package io.flutter.plugin.editing;

import android.graphics.Insets;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import android.view.WindowInsets.Builder;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

class ImeSyncDeferringInsetsCallback
{
  private boolean animating;
  private AnimationCallback animationCallback;
  private int deferredInsetTypes;
  private InsetsListener insetsListener;
  private WindowInsets lastWindowInsets;
  private boolean needsSave;
  private int overlayInsetTypes;
  private View view;
  
  ImeSyncDeferringInsetsCallback(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189757);
    this.animating = false;
    this.needsSave = false;
    this.overlayInsetTypes = paramInt1;
    this.deferredInsetTypes = paramInt2;
    this.view = paramView;
    this.animationCallback = new AnimationCallback();
    this.insetsListener = new InsetsListener(null);
    AppMethodBeat.o(189757);
  }
  
  WindowInsetsAnimation.Callback getAnimationCallback()
  {
    return this.animationCallback;
  }
  
  View.OnApplyWindowInsetsListener getInsetsListener()
  {
    return this.insetsListener;
  }
  
  void install()
  {
    AppMethodBeat.i(189831);
    this.view.setWindowInsetsAnimationCallback(this.animationCallback);
    this.view.setOnApplyWindowInsetsListener(this.insetsListener);
    AppMethodBeat.o(189831);
  }
  
  void remove()
  {
    AppMethodBeat.i(189839);
    this.view.setWindowInsetsAnimationCallback(null);
    this.view.setOnApplyWindowInsetsListener(null);
    AppMethodBeat.o(189839);
  }
  
  class AnimationCallback
    extends WindowInsetsAnimation.Callback
  {
    AnimationCallback()
    {
      super();
    }
    
    public void onEnd(WindowInsetsAnimation paramWindowInsetsAnimation)
    {
      AppMethodBeat.i(189782);
      if ((ImeSyncDeferringInsetsCallback.this.animating) && ((paramWindowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0))
      {
        ImeSyncDeferringInsetsCallback.access$202(ImeSyncDeferringInsetsCallback.this, false);
        if ((ImeSyncDeferringInsetsCallback.this.lastWindowInsets != null) && (ImeSyncDeferringInsetsCallback.this.view != null)) {
          ImeSyncDeferringInsetsCallback.this.view.dispatchApplyWindowInsets(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
        }
      }
      AppMethodBeat.o(189782);
    }
    
    public void onPrepare(WindowInsetsAnimation paramWindowInsetsAnimation)
    {
      AppMethodBeat.i(189762);
      if ((paramWindowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0)
      {
        ImeSyncDeferringInsetsCallback.access$202(ImeSyncDeferringInsetsCallback.this, true);
        ImeSyncDeferringInsetsCallback.access$302(ImeSyncDeferringInsetsCallback.this, true);
      }
      AppMethodBeat.o(189762);
    }
    
    public WindowInsets onProgress(WindowInsets paramWindowInsets, List<WindowInsetsAnimation> paramList)
    {
      AppMethodBeat.i(189772);
      if ((!ImeSyncDeferringInsetsCallback.this.animating) || (ImeSyncDeferringInsetsCallback.this.needsSave))
      {
        AppMethodBeat.o(189772);
        return paramWindowInsets;
      }
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext()) {
        if ((((WindowInsetsAnimation)paramList.next()).getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
          i = 1;
        }
      }
      if (i == 0)
      {
        AppMethodBeat.o(189772);
        return paramWindowInsets;
      }
      paramList = new WindowInsets.Builder(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
      Insets localInsets = Insets.of(0, 0, 0, Math.max(paramWindowInsets.getInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes).bottom - paramWindowInsets.getInsets(ImeSyncDeferringInsetsCallback.this.overlayInsetTypes).bottom, 0));
      paramList.setInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes, localInsets);
      ImeSyncDeferringInsetsCallback.this.view.onApplyWindowInsets(paramList.build());
      AppMethodBeat.o(189772);
      return paramWindowInsets;
    }
  }
  
  class InsetsListener
    implements View.OnApplyWindowInsetsListener
  {
    private InsetsListener() {}
    
    public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
    {
      AppMethodBeat.i(189775);
      ImeSyncDeferringInsetsCallback.access$602(ImeSyncDeferringInsetsCallback.this, paramView);
      if (ImeSyncDeferringInsetsCallback.this.needsSave)
      {
        ImeSyncDeferringInsetsCallback.access$402(ImeSyncDeferringInsetsCallback.this, paramWindowInsets);
        ImeSyncDeferringInsetsCallback.access$302(ImeSyncDeferringInsetsCallback.this, false);
      }
      if (ImeSyncDeferringInsetsCallback.this.animating)
      {
        paramView = WindowInsets.CONSUMED;
        AppMethodBeat.o(189775);
        return paramView;
      }
      paramView = paramView.onApplyWindowInsets(paramWindowInsets);
      AppMethodBeat.o(189775);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.editing.ImeSyncDeferringInsetsCallback
 * JD-Core Version:    0.7.0.1
 */
package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Insets;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import android.view.WindowInsets.Builder;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation.Callback;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi", "Override"})
@TargetApi(30)
@Keep
class ImeSyncDeferringInsetsCallback
{
  private boolean animating;
  private AnimationCallback animationCallback;
  private int deferredInsetTypes;
  private a insetsListener;
  private WindowInsets lastWindowInsets;
  private boolean needsSave;
  private int overlayInsetTypes;
  private View view;
  
  ImeSyncDeferringInsetsCallback(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255267);
    this.animating = false;
    this.needsSave = false;
    this.overlayInsetTypes = paramInt1;
    this.deferredInsetTypes = paramInt2;
    this.view = paramView;
    this.animationCallback = new AnimationCallback();
    this.insetsListener = new a((byte)0);
    AppMethodBeat.o(255267);
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
    AppMethodBeat.i(255269);
    this.view.setWindowInsetsAnimationCallback(this.animationCallback);
    this.view.setOnApplyWindowInsetsListener(this.insetsListener);
    AppMethodBeat.o(255269);
  }
  
  void remove()
  {
    AppMethodBeat.i(255271);
    this.view.setWindowInsetsAnimationCallback(null);
    this.view.setOnApplyWindowInsetsListener(null);
    AppMethodBeat.o(255271);
  }
  
  @Keep
  class AnimationCallback
    extends WindowInsetsAnimation.Callback
  {
    AnimationCallback()
    {
      super();
    }
    
    public void onEnd(WindowInsetsAnimation paramWindowInsetsAnimation)
    {
      AppMethodBeat.i(254220);
      if ((ImeSyncDeferringInsetsCallback.this.animating) && ((paramWindowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0))
      {
        ImeSyncDeferringInsetsCallback.access$202(ImeSyncDeferringInsetsCallback.this, false);
        if ((ImeSyncDeferringInsetsCallback.this.lastWindowInsets != null) && (ImeSyncDeferringInsetsCallback.this.view != null)) {
          ImeSyncDeferringInsetsCallback.this.view.dispatchApplyWindowInsets(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
        }
      }
      AppMethodBeat.o(254220);
    }
    
    public void onPrepare(WindowInsetsAnimation paramWindowInsetsAnimation)
    {
      AppMethodBeat.i(254210);
      if ((paramWindowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0)
      {
        ImeSyncDeferringInsetsCallback.access$202(ImeSyncDeferringInsetsCallback.this, true);
        ImeSyncDeferringInsetsCallback.access$302(ImeSyncDeferringInsetsCallback.this, true);
      }
      AppMethodBeat.o(254210);
    }
    
    public WindowInsets onProgress(WindowInsets paramWindowInsets, List<WindowInsetsAnimation> paramList)
    {
      AppMethodBeat.i(254217);
      if ((!ImeSyncDeferringInsetsCallback.this.animating) || (ImeSyncDeferringInsetsCallback.this.needsSave))
      {
        AppMethodBeat.o(254217);
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
        AppMethodBeat.o(254217);
        return paramWindowInsets;
      }
      paramList = new WindowInsets.Builder(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
      Insets localInsets = Insets.of(0, 0, 0, Math.max(paramWindowInsets.getInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes).bottom - paramWindowInsets.getInsets(ImeSyncDeferringInsetsCallback.this.overlayInsetTypes).bottom, 0));
      paramList.setInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes, localInsets);
      ImeSyncDeferringInsetsCallback.this.view.onApplyWindowInsets(paramList.build());
      AppMethodBeat.o(254217);
      return paramWindowInsets;
    }
  }
  
  class a
    implements View.OnApplyWindowInsetsListener
  {
    private a() {}
    
    public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
    {
      AppMethodBeat.i(255659);
      ImeSyncDeferringInsetsCallback.access$602(ImeSyncDeferringInsetsCallback.this, paramView);
      if (ImeSyncDeferringInsetsCallback.this.needsSave)
      {
        ImeSyncDeferringInsetsCallback.access$402(ImeSyncDeferringInsetsCallback.this, paramWindowInsets);
        ImeSyncDeferringInsetsCallback.access$302(ImeSyncDeferringInsetsCallback.this, false);
      }
      if (ImeSyncDeferringInsetsCallback.this.animating)
      {
        paramView = WindowInsets.CONSUMED;
        AppMethodBeat.o(255659);
        return paramView;
      }
      paramView = paramView.onApplyWindowInsets(paramWindowInsets);
      AppMethodBeat.o(255659);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.editing.ImeSyncDeferringInsetsCallback
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.gallery.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/view/FullScreenStatusMaskView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentView", "Landroid/view/View;", "fakeCloseBtn", "msg", "Landroid/widget/TextView;", "progress", "Landroid/widget/ProgressBar;", "statusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "hideProgress", "", "hideStatusIcon", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setMessage", "message", "", "showProgress", "showStatusIcon", "updateBtnLocation", "location", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FullScreenStatusMaskView
  extends FrameLayout
{
  public final WeImageView Xxy;
  private final TextView aeHv;
  public final View aeHw;
  private final View contentView;
  public final ProgressBar vfR;
  
  public FullScreenStatusMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254703);
    paramContext = af.mU(getContext()).inflate(R.i.gkm, (ViewGroup)this);
    s.s(paramContext, "getInflater(getContext()…reen_status_dialog, this)");
    this.contentView = paramContext;
    paramContext = this.contentView.findViewById(R.h.fIV);
    s.s(paramContext, "contentView.findViewById….full_screen_status_text)");
    this.aeHv = ((TextView)paramContext);
    paramContext = this.contentView.findViewById(R.h.video_close_btn);
    s.s(paramContext, "contentView.findViewById(R.id.video_close_btn)");
    this.aeHw = paramContext;
    this.aeHv.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(254698);
        if (FullScreenStatusMaskView.a(this.aeHx).getLineCount() > 1) {
          FullScreenStatusMaskView.a(this.aeHx).setTextSize(0, a.br(this.aeHx.getContext(), R.f.DescTextSize));
        }
        FullScreenStatusMaskView.a(this.aeHx).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        AppMethodBeat.o(254698);
      }
    });
    paramContext = this.contentView.findViewById(R.h.fIU);
    s.s(paramContext, "contentView.findViewById…l_screen_status_progress)");
    this.vfR = ((ProgressBar)paramContext);
    paramContext = this.contentView.findViewById(R.h.fIT);
    s.s(paramContext, "contentView.findViewById….full_screen_status_icon)");
    this.Xxy = ((WeImageView)paramContext);
    AppMethodBeat.o(254703);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(254722);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(254722);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(254711);
    this.aeHv.setText(paramCharSequence);
    AppMethodBeat.o(254711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.view.FullScreenStatusMaskView
 * JD-Core Version:    0.7.0.1
 */
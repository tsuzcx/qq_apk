package com.tencent.mm.view.a;

import a.f.b.j;
import a.l;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter;Landroid/view/View;)V", "captureStatusFailureView", "getCaptureStatusFailureView", "()Landroid/view/View;", "captureStatusLayout", "getCaptureStatusLayout", "captureStatusLoadingView", "getCaptureStatusLoadingView", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "plugin-emojisdk_release"})
public final class b$b
{
  final View ART;
  final View ARU;
  final View ARV;
  final ImageView ivs;
  
  public b$b(View paramView)
  {
    AppMethodBeat.i(63327);
    paramView = localObject.findViewById(2131821541);
    j.p(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.ivs = ((ImageView)paramView);
    paramView = localObject.findViewById(2131823612);
    j.p(paramView, "itemView.findViewById(R.…ji_capture_status_layout)");
    this.ART = paramView;
    paramView = localObject.findViewById(2131823613);
    j.p(paramView, "itemView.findViewById(R.…oji_capture_loading_view)");
    this.ARU = paramView;
    paramView = localObject.findViewById(2131823614);
    j.p(paramView, "itemView.findViewById(R.…oji_capture_failure_view)");
    this.ARV = paramView;
    AppMethodBeat.o(63327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.a.b.b
 * JD-Core Version:    0.7.0.1
 */
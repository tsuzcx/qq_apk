package com.tencent.mm.pluginsdk.ui.tools.b.a.a;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$AlbumViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Lcom/tencent/mm/ui/widget/MMNumberCheckbox;", "getCheckBox", "()Lcom/tencent/mm/ui/widget/MMNumberCheckbox;", "setCheckBox", "(Lcom/tencent/mm/ui/widget/MMNumberCheckbox;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "sizeTv", "getSizeTv", "setSizeTv", "thumbIV", "Landroid/widget/ImageView;", "getThumbIV", "()Landroid/widget/ImageView;", "setThumbIV", "(Landroid/widget/ImageView;)V", "thumbMaskIV", "getThumbMaskIV", "setThumbMaskIV", "typeMaskIV", "getTypeMaskIV", "setTypeMaskIV", "typeMaskTV", "getTypeMaskTV", "setTypeMaskTV", "collapseTouch", "", "delegate", "expandTouch", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
  extends RecyclerView.v
{
  ImageView HLM;
  ImageView HLN;
  ImageView HLO;
  TextView HLP;
  MMNumberCheckbox HLT;
  TextView descTv;
  TextView xsX;
  
  public a$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(245833);
    View localView = paramView.findViewById(R.h.media_thumb);
    s.s(localView, "itemView.findViewById(R.id.media_thumb)");
    this.HLM = ((ImageView)localView);
    localView = paramView.findViewById(R.h.media_mask);
    s.s(localView, "itemView.findViewById(R.id.media_mask)");
    this.HLN = ((ImageView)localView);
    localView = paramView.findViewById(R.h.type_mask_iv);
    s.s(localView, "itemView.findViewById(R.id.type_mask_iv)");
    this.HLO = ((ImageView)localView);
    localView = paramView.findViewById(R.h.type_mask_tv);
    s.s(localView, "itemView.findViewById(R.id.type_mask_tv)");
    this.HLP = ((TextView)localView);
    localView = paramView.findViewById(R.h.media_cbx);
    s.s(localView, "itemView.findViewById(R.id.media_cbx)");
    this.HLT = ((MMNumberCheckbox)localView);
    localView = paramView.findViewById(R.h.fOb);
    s.s(localView, "itemView.findViewById(R.id.media_desc_tv)");
    this.descTv = ((TextView)localView);
    paramView = paramView.findViewById(R.h.fOd);
    s.s(paramView, "itemView.findViewById(R.id.media_size_tv)");
    this.xsX = ((TextView)paramView);
    AppMethodBeat.o(245833);
  }
  
  public static void iq(View paramView)
  {
    AppMethodBeat.i(245838);
    s.u(paramView, "delegate");
    Object localObject = paramView.getParent();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(245838);
      throw paramView;
    }
    localObject = (View)localObject;
    ((View)localObject).post(new a.a..ExternalSyntheticLambda0(paramView, (View)localObject));
    AppMethodBeat.o(245838);
  }
  
  public static void ir(View paramView)
  {
    AppMethodBeat.i(245841);
    s.u(paramView, "delegate");
    paramView = paramView.getParent();
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(245841);
      throw paramView;
    }
    ((View)paramView).setTouchDelegate(null);
    AppMethodBeat.o(245841);
  }
  
  private static final void q(View paramView1, View paramView2)
  {
    AppMethodBeat.i(245846);
    s.u(paramView1, "$delegate");
    s.u(paramView2, "$parent");
    Rect localRect = new Rect();
    paramView1.getHitRect(localRect);
    localRect.left -= a.fromDPToPix(paramView1.getContext(), 20);
    localRect.top -= a.fromDPToPix(paramView1.getContext(), 20);
    localRect.right += a.fromDPToPix(paramView1.getContext(), 20);
    localRect.bottom += a.fromDPToPix(paramView1.getContext(), 20);
    paramView2.setTouchDelegate(new TouchDelegate(localRect, paramView1));
    AppMethodBeat.o(245846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */
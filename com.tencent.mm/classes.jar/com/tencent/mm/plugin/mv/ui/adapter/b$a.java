package com.tencent.mm.plugin.mv.ui.adapter;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.mv.b.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$AlbumViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "flexCB", "Landroid/widget/CheckBox;", "getFlexCB", "()Landroid/widget/CheckBox;", "setFlexCB", "(Landroid/widget/CheckBox;)V", "thumbIV", "Landroid/widget/ImageView;", "getThumbIV", "()Landroid/widget/ImageView;", "setThumbIV", "(Landroid/widget/ImageView;)V", "typeMaskTV", "Landroid/widget/TextView;", "getTypeMaskTV", "()Landroid/widget/TextView;", "setTypeMaskTV", "(Landroid/widget/TextView;)V", "collapseTouch", "", "delegate", "expandTouch", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
  extends RecyclerView.v
{
  ImageView HLM;
  TextView HLP;
  CheckBox MaN;
  
  public b$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(287296);
    View localView = paramView.findViewById(b.e.media_thumb);
    s.s(localView, "itemView.findViewById(R.id.media_thumb)");
    this.HLM = ((ImageView)localView);
    localView = paramView.findViewById(b.e.type_mask_tv);
    s.s(localView, "itemView.findViewById(R.id.type_mask_tv)");
    this.HLP = ((TextView)localView);
    paramView = paramView.findViewById(b.e.media_cbx);
    s.s(paramView, "itemView.findViewById(R.id.media_cbx)");
    this.MaN = ((CheckBox)paramView);
    AppMethodBeat.o(287296);
  }
  
  public static void iq(View paramView)
  {
    AppMethodBeat.i(287300);
    s.u(paramView, "delegate");
    Object localObject = paramView.getParent();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(287300);
      throw paramView;
    }
    localObject = (View)localObject;
    ((View)localObject).post(new b.a..ExternalSyntheticLambda0(paramView, (View)localObject));
    AppMethodBeat.o(287300);
  }
  
  public static void ir(View paramView)
  {
    AppMethodBeat.i(287305);
    s.u(paramView, "delegate");
    paramView = paramView.getParent();
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(287305);
      throw paramView;
    }
    ((View)paramView).setTouchDelegate(null);
    AppMethodBeat.o(287305);
  }
  
  private static final void q(View paramView1, View paramView2)
  {
    AppMethodBeat.i(287316);
    s.u(paramView1, "$delegate");
    s.u(paramView2, "$parent");
    Rect localRect = new Rect();
    paramView1.getHitRect(localRect);
    localRect.left -= a.fromDPToPix(paramView1.getContext(), 20);
    localRect.top -= a.fromDPToPix(paramView1.getContext(), 20);
    localRect.right += a.fromDPToPix(paramView1.getContext(), 20);
    localRect.bottom += a.fromDPToPix(paramView1.getContext(), 20);
    paramView2.setTouchDelegate(new TouchDelegate(localRect, paramView1));
    AppMethodBeat.o(287316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.adapter.b.a
 * JD-Core Version:    0.7.0.1
 */
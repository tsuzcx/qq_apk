package com.tencent.mm.plugin.textstatus.b.b;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/like/LikeItem;", "reportScene", "", "longClickCallback", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "(JLkotlin/jvm/functions/Function3;)V", "getLongClickCallback", "()Lkotlin/jvm/functions/Function3;", "setLongClickCallback", "(Lkotlin/jvm/functions/Function3;)V", "getReportScene", "()J", "setReportScene", "(J)V", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.textstatus.h.d.b>
{
  public static final b.a Tki;
  private long Tkj;
  private q<? super View, ? super Integer, ? super Long, Boolean> Tkk;
  
  static
  {
    AppMethodBeat.i(290350);
    Tki = new b.a((byte)0);
    AppMethodBeat.o(290350);
  }
  
  public b(long paramLong, q<? super View, ? super Integer, ? super Long, Boolean> paramq)
  {
    this.Tkj = paramLong;
    this.Tkk = paramq;
  }
  
  private static final void a(ImageView paramImageView, com.tencent.mm.plugin.textstatus.h.d.b paramb, String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(290340);
    s.u(paramb, "$item");
    if (s.p(paramImageView.getTag(), paramb)) {
      paramImageView.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(290340);
  }
  
  private static final void a(au paramau, j paramj, b paramb, View paramView)
  {
    AppMethodBeat.i(290314);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramau);
    localb.cH(paramj);
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramb, "this$0");
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramau.field_username);
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 54);
    c.b(paramj.context, "profile", ".ui.ContactInfoUI", paramView, 213);
    ((com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210(paramau.field_username, paramb.Tkj);
    paramj = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    paramau = paramau.field_username;
    s.s(paramau, "contact.username");
    f.a.bdG(paramau);
    a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290314);
  }
  
  private static final boolean a(b paramb, j paramj, int paramInt, View paramView)
  {
    AppMethodBeat.i(290326);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramj);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramb, "this$0");
    s.u(paramj, "$holder");
    paramb = paramb.Tkk;
    if (paramb != null)
    {
      paramj = paramj.caK;
      s.s(paramj, "holder.itemView");
      paramb.invoke(paramj, Integer.valueOf(paramInt), Long.valueOf(0L));
    }
    a.a(true, new Object(), "com/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(290326);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290393);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(290393);
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.b
 * JD-Core Version:    0.7.0.1
 */
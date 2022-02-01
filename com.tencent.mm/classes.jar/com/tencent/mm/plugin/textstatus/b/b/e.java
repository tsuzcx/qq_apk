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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.plugin.textstatus.h.d.d;
import com.tencent.mm.storage.au;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/like/ReferenceItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/like/ReferenceItem;", "reportScene", "", "longClickCallback", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "(JLkotlin/jvm/functions/Function3;)V", "getLongClickCallback", "()Lkotlin/jvm/functions/Function3;", "setLongClickCallback", "(Lkotlin/jvm/functions/Function3;)V", "getReportScene", "()J", "setReportScene", "(J)V", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.view.recyclerview.f<d>
{
  public static final e.a Tkm;
  private long Tkj;
  private q<? super View, ? super Integer, ? super Long, Boolean> Tkk;
  
  static
  {
    AppMethodBeat.i(290318);
    Tkm = new e.a((byte)0);
    AppMethodBeat.o(290318);
  }
  
  public e(long paramLong, q<? super View, ? super Integer, ? super Long, Boolean> paramq)
  {
    this.Tkj = paramLong;
    this.Tkk = paramq;
  }
  
  private static final void a(ImageView paramImageView, d paramd, String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(290310);
    s.u(paramd, "$item");
    if (s.p(paramImageView.getTag(), paramd)) {
      paramImageView.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(290310);
  }
  
  private static final void a(au paramau, j paramj, e parame, View paramView)
  {
    AppMethodBeat.i(290295);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramau);
    localb.cH(paramj);
    localb.cH(parame);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/like/ReferenceItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(parame, "this$0");
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramau.field_username);
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 54);
    c.b(paramj.context, "profile", ".ui.ContactInfoUI", paramView, 213);
    ((com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210(paramau.field_username, parame.Tkj);
    paramj = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    paramau = paramau.field_username;
    s.s(paramau, "contact.username");
    f.a.bdG(paramau);
    a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/like/ReferenceItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290295);
  }
  
  private static final boolean a(e parame, j paramj, int paramInt, View paramView)
  {
    AppMethodBeat.i(290302);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parame);
    localb.cH(paramj);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/like/ReferenceItemConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(parame, "this$0");
    s.u(paramj, "$holder");
    parame = parame.Tkk;
    if (parame != null)
    {
      paramj = paramj.caK;
      s.s(paramj, "holder.itemView");
      parame.invoke(paramj, Integer.valueOf(paramInt), Long.valueOf(0L));
    }
    a.a(true, new Object(), "com/tencent/mm/plugin/textstatus/convert/like/ReferenceItemConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(290302);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290346);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(290346);
  }
  
  public final int getLayoutId()
  {
    return a.f.TfF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.e
 * JD-Core Version:    0.7.0.1
 */
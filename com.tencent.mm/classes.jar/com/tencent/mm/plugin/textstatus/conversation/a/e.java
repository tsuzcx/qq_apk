package com.tencent.mm.plugin.textstatus.conversation.a;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.conversation.d.d;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.plugin.textstatus.conversation.g.c;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusGreetingClickListener;", "Lkotlin/Function3;", "Landroid/view/View;", "", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "", "callBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "getMiniAppClientData", "", "item", "handleGetContactEnd", "rspList", "", "Lcom/tencent/mm/plugin/textstatus/proto/GetV6StrangerRespInfo;", "context", "Landroid/content/Context;", "invoke", "view", "position", "showProfileDialog", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements q<View, Integer, d, ah>
{
  public static final e.a Tix;
  private kotlin.g.a.a<ah> AFP = null;
  private w psR;
  
  static
  {
    AppMethodBeat.i(290930);
    Tix = new e.a((byte)0);
    AppMethodBeat.o(290930);
  }
  
  private static final void a(com.tencent.mm.am.p paramp, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(290919);
    kotlin.g.b.s.u(paramp, "$scene");
    com.tencent.mm.kernel.h.aZW().a(paramp);
    AppMethodBeat.o(290919);
  }
  
  private static final void a(e parame, Context paramContext, d paramd, boolean paramBoolean, List paramList)
  {
    AppMethodBeat.i(290911);
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(paramd, "$item");
    int i;
    Object localObject;
    if (paramBoolean)
    {
      kotlin.g.b.s.s(paramContext, "context");
      if (paramList != null)
      {
        if (((Collection)paramList).isEmpty()) {
          break label134;
        }
        i = 1;
        if (i != 0)
        {
          paramList = (com.tencent.mm.plugin.textstatus.proto.h)kotlin.a.p.oK(paramList);
          localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
          if (com.tencent.mm.plugin.textstatus.b.f.bdN(paramd.field_session_id) != null) {
            break label140;
          }
          new com.tencent.mm.plugin.textstatus.conversation.ui.a(paramContext, null, paramd, false, 10).dDn();
          paramContext = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
          paramContext = paramd.field_session_id;
          kotlin.g.b.s.s(paramContext, "item.field_session_id");
          f.a.hp(paramContext, 104);
        }
      }
    }
    for (;;)
    {
      parame = parame.psR;
      if (parame != null) {
        parame.dismiss();
      }
      AppMethodBeat.o(290911);
      return;
      label134:
      i = 0;
      break;
      label140:
      localObject = c.Tjw;
      c.a(paramContext, paramList.ToG, "greeting", paramd);
      paramContext = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
      paramContext = paramd.field_session_id;
      kotlin.g.b.s.s(paramContext, "item.field_session_id");
      f.a.hp(paramContext, 103);
      continue;
      k.c(paramContext, paramContext.getString(a.h.msg_net_error), "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.a.e
 * JD-Core Version:    0.7.0.1
 */
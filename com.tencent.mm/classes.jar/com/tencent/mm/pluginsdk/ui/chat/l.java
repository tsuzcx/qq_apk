package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.e;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bp;

public final class l
  implements View.OnClickListener
{
  private Context context;
  
  public l(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31760);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SourceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    localObject = paramView.getTag();
    int i;
    if ((localObject instanceof b))
    {
      localObject = (b)localObject;
      if ((localObject == null) || (paramView == null))
      {
        ad.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
        i = 0;
        label69:
        if (i == 0)
        {
          paramView = q.e(this.context, ((b)localObject).appId, ((b)localObject).dET);
          localObject = new vt();
          ((vt)localObject).dKj.dKk = paramView;
          ((vt)localObject).dKj.context = this.context;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SourceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(31760);
      return;
      if ("wx7fa037cc7dfabad5".equals(((b)localObject).appId))
      {
        com.tencent.mm.plugin.sport.a.c.ma(33);
        ba.aBQ();
        if (com.tencent.mm.o.b.lM(com.tencent.mm.model.c.azp().Bf("gh_43f2581f6fd6").field_type))
        {
          paramView = new Intent();
          paramView.putExtra("Chat_User", "gh_43f2581f6fd6");
          paramView.putExtra("finish_direct", true);
          d.f(this.context, ".ui.chatting.ChattingUI", paramView);
        }
        for (;;)
        {
          i = 1;
          break;
          paramView = new Intent();
          paramView.putExtra("Contact_User", "gh_43f2581f6fd6");
          d.b(this.context, "profile", ".ui.ContactInfoUI", paramView);
        }
      }
      if ("wx485a97c844086dc9".equals(((b)localObject).appId))
      {
        paramView = new Intent();
        paramView.putExtra("shake_music", true);
        d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
        i = 1;
        break label69;
      }
      if ("wxfbc915ff7c30e335".equals(((b)localObject).appId))
      {
        if (com.tencent.mm.ax.b.aJn())
        {
          i = 1;
          break label69;
        }
        paramView = new Intent();
        paramView.putExtra("BaseScanUI_select_scan_mode", 1);
        if ((!com.tencent.mm.s.a.n(this.context, true)) && (!e.aMh()) && (!com.tencent.mm.s.a.p(this.context, true))) {
          d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
        }
        i = 1;
        break label69;
      }
      if (!"wxaf060266bfa9a35c".equals(((b)localObject).appId)) {
        break;
      }
      paramView = new Intent();
      paramView.putExtra("shake_tv", true);
      d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
      i = 1;
      break label69;
      if ((localObject instanceof a))
      {
        paramView = (a)localObject;
        localObject = new ic();
        ((ic)localObject).duF.actionCode = 2;
        ((ic)localObject).duF.scene = paramView.scene;
        ((ic)localObject).duF.extMsg = ("chatting_src=" + paramView.scene);
        ((ic)localObject).duF.appId = paramView.appId;
        ((ic)localObject).duF.context = this.context;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        localObject = new rd();
        ((rd)localObject).dFI.context = this.context;
        ((rd)localObject).dFI.scene = paramView.scene;
        ((rd)localObject).dFI.duW = paramView.appId;
        ((rd)localObject).dFI.packageName = paramView.dFD;
        ((rd)localObject).dFI.msgType = paramView.FdV;
        ((rd)localObject).dFI.dyU = paramView.dFE;
        ((rd)localObject).dFI.dFJ = 5;
        ((rd)localObject).dFI.mediaTagName = paramView.FdW;
        ((rd)localObject).dFI.dAY = paramView.dAY;
        ((rd)localObject).dFI.dFK = "";
        ((rd)localObject).dFI.dkh = paramView.FdX;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
    }
  }
  
  public static final class a
  {
    public int FdV;
    public String FdW;
    public String FdX;
    public String appId;
    public long dAY;
    public String dET;
    public String dFD;
    public String dFE;
    public int scene;
  }
  
  public static final class b
  {
    public String appId;
    public String dET;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.l
 * JD-Core Version:    0.7.0.1
 */
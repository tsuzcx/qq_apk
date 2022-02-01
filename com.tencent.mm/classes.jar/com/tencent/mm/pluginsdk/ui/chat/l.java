package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.va;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;

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
    int j = 1;
    AppMethodBeat.i(31760);
    Object localObject = paramView.getTag();
    if ((localObject instanceof b))
    {
      localObject = (b)localObject;
      int i;
      if ((localObject == null) || (paramView == null))
      {
        ac.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
        i = 0;
      }
      for (;;)
      {
        if (i == 0)
        {
          paramView = q.e(this.context, ((b)localObject).appId, ((b)localObject).dsT);
          localObject = new va();
          ((va)localObject).dxW.dxX = paramView;
          ((va)localObject).dxW.context = this.context;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        }
        AppMethodBeat.o(31760);
        return;
        if ("wx7fa037cc7dfabad5".equals(((b)localObject).appId))
        {
          com.tencent.mm.plugin.sport.a.c.lA(33);
          az.ayM();
          if (com.tencent.mm.n.b.ln(com.tencent.mm.model.c.awB().aNt("gh_43f2581f6fd6").field_type))
          {
            paramView = new Intent();
            paramView.putExtra("Chat_User", "gh_43f2581f6fd6");
            paramView.putExtra("finish_direct", true);
            d.e(this.context, ".ui.chatting.ChattingUI", paramView);
            i = j;
          }
          else
          {
            paramView = new Intent();
            paramView.putExtra("Contact_User", "gh_43f2581f6fd6");
            d.b(this.context, "profile", ".ui.ContactInfoUI", paramView);
            i = j;
          }
        }
        else if ("wx485a97c844086dc9".equals(((b)localObject).appId))
        {
          paramView = new Intent();
          paramView.putExtra("shake_music", true);
          d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
          i = j;
        }
        else if ("wxfbc915ff7c30e335".equals(((b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.aw.b.aGe())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 1);
            i = j;
            if (!com.tencent.mm.r.a.cg(this.context))
            {
              i = j;
              if (!e.aIX())
              {
                i = j;
                if (!com.tencent.mm.r.a.cj(this.context))
                {
                  d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                  i = j;
                }
              }
            }
          }
        }
        else
        {
          if (!"wxaf060266bfa9a35c".equals(((b)localObject).appId)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("shake_tv", true);
          d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
          i = j;
        }
      }
    }
    if ((localObject instanceof a))
    {
      paramView = (a)localObject;
      localObject = new hv();
      ((hv)localObject).diT.actionCode = 2;
      ((hv)localObject).diT.scene = paramView.scene;
      ((hv)localObject).diT.extMsg = ("chatting_src=" + paramView.scene);
      ((hv)localObject).diT.appId = paramView.appId;
      ((hv)localObject).diT.context = this.context;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = new qs();
      ((qs)localObject).dtI.context = this.context;
      ((qs)localObject).dtI.scene = paramView.scene;
      ((qs)localObject).dtI.djj = paramView.appId;
      ((qs)localObject).dtI.packageName = paramView.dtC;
      ((qs)localObject).dtI.msgType = paramView.DyM;
      ((qs)localObject).dtI.dng = paramView.dtD;
      ((qs)localObject).dtI.dtJ = 5;
      ((qs)localObject).dtI.mediaTagName = paramView.DyN;
      ((qs)localObject).dtI.dpl = paramView.dpl;
      ((qs)localObject).dtI.dtK = "";
      ((qs)localObject).dtI.cYP = paramView.DyO;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    AppMethodBeat.o(31760);
  }
  
  public static final class a
  {
    public int DyM;
    public String DyN;
    public String DyO;
    public String appId;
    public long dpl;
    public String dsT;
    public String dtC;
    public String dtD;
    public int scene;
  }
  
  public static final class b
  {
    public String appId;
    public String dsT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.l
 * JD-Core Version:    0.7.0.1
 */
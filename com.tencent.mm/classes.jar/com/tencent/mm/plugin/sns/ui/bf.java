package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.av.e;
import com.tencent.mm.h.a.jx;
import com.tencent.mm.h.a.jx.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;

public final class bf
{
  Context context;
  long kAE = 0L;
  ae oOe;
  public View.OnClickListener pbU = new bf.1(this);
  bf.a pjR;
  public View.OnClickListener pjS = new bf.8(this);
  public View.OnClickListener pjT = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView.getTag() instanceof bc))
      {
        paramAnonymousView = (bc)paramAnonymousView.getTag();
        if (bk.bl(paramAnonymousView.pjD))
        {
          y.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
          Toast.makeText(bf.this.context, bf.this.context.getString(i.j.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
        }
      }
      else
      {
        return;
      }
      g.DQ();
      Object localObject = ((j)g.r(j.class)).Fw().abl(paramAnonymousView.pjD);
      if ((localObject != null) && (((ao)localObject).field_username.equals(paramAnonymousView.pjD)))
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.pjD);
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, paramAnonymousView.pjD + ",37");
        ((Intent)localObject).putExtra("Contact_Scene", 37);
        com.tencent.mm.plugin.sns.c.a.eUR.d((Intent)localObject, bf.this.context);
        return;
      }
      am.a.dVy.a(paramAnonymousView.pjD, "", new bf.9.1(this));
      localObject = bf.this;
      Context localContext = bf.this.context;
      bf.this.context.getString(i.j.app_tip);
      ((bf)localObject).tipDialog = com.tencent.mm.ui.base.h.b(localContext, bf.this.context.getString(i.j.app_waiting), true, new bf.9.2(this, paramAnonymousView));
    }
  };
  public View.OnClickListener pjU = new bf.10(this);
  public View.OnClickListener pjV = new bf.11(this);
  public View.OnClickListener pjW = new bf.12(this);
  public View.OnClickListener pjX = new bf.13(this);
  public View.OnClickListener pjY = new bf.14(this);
  public View.OnClickListener pjZ = new bf.15(this);
  public View.OnClickListener pka = new bf.2(this);
  public View.OnClickListener pkb = new bf.3(this);
  public View.OnClickListener pkc = new bf.4(this);
  public View.OnClickListener pkd = new bf.5(this);
  public View.OnClickListener pke = new bf.6(this);
  public View.OnClickListener pkf = new bf.7(this);
  int source = 0;
  p tipDialog;
  
  public bf(Context paramContext, bf.a parama, int paramInt, ae paramae)
  {
    this.context = paramContext;
    this.pjR = parama;
    this.source = paramInt;
    this.oOe = paramae;
  }
  
  protected static boolean Ma(String paramString)
  {
    Object localObject = new jx();
    ((jx)localObject).bSs.action = -2;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    localObject = ((jx)localObject).bSt.bSu;
    return (localObject != null) && (com.tencent.mm.av.a.d((e)localObject)) && (paramString.equals(((e)localObject).eux)) && (com.tencent.mm.av.a.Pu());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf
 * JD-Core Version:    0.7.0.1
 */
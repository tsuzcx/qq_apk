package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.oz;
import com.tencent.mm.h.a.oz.a;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.c.wo;
import com.tencent.mm.protocal.c.wp;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;

final class g$3$1
  implements f
{
  g$3$1(g.3 param3, d paramd, oz paramoz) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(971, this);
    wr localwr = (wr)this.rDM.esv.ecF.ecN;
    y.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    Intent localIntent;
    StringBuilder localStringBuilder;
    Object localObject;
    Cursor localCursor2;
    Cursor localCursor1;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (localwr.sTs == null) {
        break label941;
      }
      localIntent = new Intent();
      localIntent.putExtra("intent.key.login.url", this.rDN.bYC.bYD);
      localIntent.putExtra("intent.key.type", 0);
      localIntent.putExtra("intent.key.icon.type", localwr.sTs.sTo);
      localIntent.putExtra("intent.key.ok.string", localwr.sTs.sTC);
      localIntent.putExtra("intent.key.cancel.string", localwr.sTs.sTD);
      localIntent.putExtra("intent.key.title.string", localwr.sTs.sTp);
      localIntent.putExtra("intent.key.content.string", localwr.sTs.sTH);
      localIntent.putExtra("intent.key.login.client.version", localwr.sTw);
      localIntent.putExtra("intent.key.function.control", localwr.sTx);
      paramm = localwr.sTs.sTp;
      localStringBuilder = new StringBuilder();
      localObject = null;
      localCursor2 = null;
      localCursor1 = localCursor2;
      paramString = localObject;
    }
    for (;;)
    {
      try
      {
        au.Hx();
        localCursor1 = localCursor2;
        paramString = localObject;
        localCursor2 = c.FB().a(s.dUT, null, com.tencent.mm.o.a.dBg, true);
        if (localCursor2 != null)
        {
          localCursor1 = localCursor2;
          paramString = localCursor2;
          if (localCursor2.getCount() < localwr.sTs.sTE)
          {
            localCursor1 = localCursor2;
            paramString = localCursor2;
            paramInt1 = localCursor2.getCount();
            localCursor1 = localCursor2;
            paramString = localCursor2;
            int i = localCursor2.getColumnIndex("username");
            paramInt2 = 0;
            if (paramInt2 < paramInt1)
            {
              localCursor1 = localCursor2;
              paramString = localCursor2;
              if (!localCursor2.moveToPosition(paramInt2)) {
                break label949;
              }
              localCursor1 = localCursor2;
              paramString = localCursor2;
              localStringBuilder.append(localCursor2.getString(i));
              if (paramInt2 >= paramInt1 - 1) {
                break label949;
              }
              localCursor1 = localCursor2;
              paramString = localCursor2;
              localStringBuilder.append(",");
              break label949;
            }
          }
          else
          {
            localCursor1 = localCursor2;
            paramString = localCursor2;
            paramInt1 = localwr.sTs.sTE;
            continue;
          }
        }
        localCursor1 = localCursor2;
        paramString = localCursor2;
        localIntent.putExtra("intent.key.ok.session.list", localStringBuilder.toString());
        if (localCursor2 == null) {
          break label679;
        }
        localCursor2.close();
        paramString = paramm;
        paramm = localIntent;
      }
      catch (Exception localException)
      {
        paramString = localCursor1;
        y.printErrStackTrace("MicroMsg.SubCoreWebWX", localException, "[oneliang]get session list error.", new Object[0]);
        if (localCursor1 == null) {
          break label679;
        }
        localCursor1.close();
        paramString = paramm;
        paramm = localIntent;
        continue;
      }
      finally
      {
        if (paramString == null) {
          continue;
        }
        paramString.close();
      }
      if (paramm != null)
      {
        paramm.setFlags(268435456);
        paramm.setClass(ae.getContext(), ExtDeviceWXLoginUI.class);
        ae.getContext().startActivity(paramm);
        paramm = new Intent(paramm);
        paramm.setFlags(67108864);
        if (this.rDN.bYC.type == 1)
        {
          paramm = PendingIntent.getActivity(ae.getContext(), 0, paramm, 134217728);
          paramString = new Notification.Builder(ae.getContext()).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(ae.getContext().getString(R.l.app_name)).setContentText(paramString).setContentIntent(paramm).getNotification();
          paramString.icon = com.tencent.mm.bq.a.bSL();
          paramString.flags |= 0x10;
          paramString.sound = RingtoneManager.getDefaultUri(2);
          au.getNotification().notify(38, paramString);
        }
      }
      return;
      label679:
      paramString = paramm;
      paramm = localIntent;
      continue;
      if (paramInt2 == -1)
      {
        if (localwr.sTt != null)
        {
          paramm = new Intent();
          paramm.putExtra("intent.key.login.url", this.rDN.bYC.bYD);
          paramm.putExtra("intent.key.type", -1);
          paramm.putExtra("intent.key.title.string", localwr.sTt.sTq);
          paramm.putExtra("intent.key.icon.type", localwr.sTt.sTo);
          paramm.putExtra("intent.key.ok.string", localwr.sTt.sTr);
          paramm.putExtra("intent.key.content.string", localwr.sTt.sTp);
          paramString = localwr.sTt.sTp;
        }
      }
      else if ((paramInt2 == -2) && (localwr.sTu != null))
      {
        paramm = new Intent();
        paramm.putExtra("intent.key.login.url", this.rDN.bYC.bYD);
        paramm.putExtra("intent.key.type", -2);
        paramm.putExtra("intent.key.title.string", localwr.sTu.sTq);
        paramm.putExtra("intent.key.icon.type", localwr.sTu.sTo);
        paramm.putExtra("intent.key.ok.string", localwr.sTu.sTr);
        paramm.putExtra("intent.key.content.string", localwr.sTu.sTp);
        paramString = localwr.sTu.sTp;
        continue;
      }
      label941:
      paramString = null;
      paramm = null;
      continue;
      label949:
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g.3.1
 * JD-Core Version:    0.7.0.1
 */
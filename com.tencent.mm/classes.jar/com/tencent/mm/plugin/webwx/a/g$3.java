package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.a.qb.a;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.be;

final class g$3
  extends com.tencent.mm.sdk.b.c<qb>
{
  g$3(g paramg)
  {
    AppMethodBeat.i(26511);
    this.__eventId = qb.class.getName().hashCode();
    AppMethodBeat.o(26511);
  }
  
  private boolean a(final qb paramqb)
  {
    AppMethodBeat.i(26512);
    if ((paramqb != null) && ((paramqb instanceof qb)))
    {
      final d locald = new d(paramqb.cGD.cGE);
      paramqb = new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(26510);
          aw.Rc().b(971, this);
          aaw localaaw = (aaw)locald.fBd.fsW.fta;
          ab.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          Intent localIntent;
          StringBuilder localStringBuilder;
          Object localObject;
          Cursor localCursor2;
          Cursor localCursor1;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (localaaw.wRp == null) {
              break label961;
            }
            localIntent = new Intent();
            localIntent.putExtra("intent.key.login.url", paramqb.cGD.cGE);
            localIntent.putExtra("intent.key.type", 0);
            localIntent.putExtra("intent.key.icon.type", localaaw.wRp.wRl);
            localIntent.putExtra("intent.key.ok.string", localaaw.wRp.wRz);
            localIntent.putExtra("intent.key.cancel.string", localaaw.wRp.wRA);
            localIntent.putExtra("intent.key.title.string", localaaw.wRp.wRm);
            localIntent.putExtra("intent.key.content.string", localaaw.wRp.wRE);
            localIntent.putExtra("intent.key.login.client.version", localaaw.wRt);
            localIntent.putExtra("intent.key.function.control", localaaw.wRu);
            paramAnonymousm = localaaw.wRp.wRm;
            localStringBuilder = new StringBuilder();
            localObject = null;
            localCursor2 = null;
            localCursor1 = localCursor2;
            paramAnonymousString = localObject;
          }
          for (;;)
          {
            try
            {
              aw.aaz();
              localCursor1 = localCursor2;
              paramAnonymousString = localObject;
              localCursor2 = com.tencent.mm.model.c.YF().a(t.flc, null, com.tencent.mm.o.a.euH, true);
              if (localCursor2 != null)
              {
                localCursor1 = localCursor2;
                paramAnonymousString = localCursor2;
                if (localCursor2.getCount() < localaaw.wRp.wRB)
                {
                  localCursor1 = localCursor2;
                  paramAnonymousString = localCursor2;
                  paramAnonymousInt1 = localCursor2.getCount();
                  localCursor1 = localCursor2;
                  paramAnonymousString = localCursor2;
                  int i = localCursor2.getColumnIndex("username");
                  paramAnonymousInt2 = 0;
                  if (paramAnonymousInt2 < paramAnonymousInt1)
                  {
                    localCursor1 = localCursor2;
                    paramAnonymousString = localCursor2;
                    if (!localCursor2.moveToPosition(paramAnonymousInt2)) {
                      break label969;
                    }
                    localCursor1 = localCursor2;
                    paramAnonymousString = localCursor2;
                    localStringBuilder.append(localCursor2.getString(i));
                    if (paramAnonymousInt2 >= paramAnonymousInt1 - 1) {
                      break label969;
                    }
                    localCursor1 = localCursor2;
                    paramAnonymousString = localCursor2;
                    localStringBuilder.append(",");
                    break label969;
                  }
                }
                else
                {
                  localCursor1 = localCursor2;
                  paramAnonymousString = localCursor2;
                  paramAnonymousInt1 = localaaw.wRp.wRB;
                  continue;
                }
              }
              localCursor1 = localCursor2;
              paramAnonymousString = localCursor2;
              localIntent.putExtra("intent.key.ok.session.list", localStringBuilder.toString());
              if (localCursor2 == null) {
                break label699;
              }
              localCursor2.close();
              paramAnonymousString = paramAnonymousm;
              paramAnonymousm = localIntent;
            }
            catch (Exception localException)
            {
              paramAnonymousString = localCursor1;
              ab.printErrStackTrace("MicroMsg.SubCoreWebWX", localException, "[oneliang]get session list error.", new Object[0]);
              if (localCursor1 == null) {
                break label699;
              }
              localCursor1.close();
              paramAnonymousString = paramAnonymousm;
              paramAnonymousm = localIntent;
              continue;
            }
            finally
            {
              if (paramAnonymousString == null) {
                continue;
              }
              paramAnonymousString.close();
              AppMethodBeat.o(26510);
            }
            if (paramAnonymousm != null)
            {
              paramAnonymousm.setFlags(268435456);
              paramAnonymousm.setClass(ah.getContext(), ExtDeviceWXLoginUI.class);
              ah.getContext().startActivity(paramAnonymousm);
              paramAnonymousm = new Intent(paramAnonymousm);
              paramAnonymousm.setFlags(67108864);
              if (paramqb.cGD.type == 1)
              {
                paramAnonymousm = PendingIntent.getActivity(ah.getContext(), 0, paramAnonymousm, 134217728);
                paramAnonymousString = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h(null).g(System.currentTimeMillis()).e(ah.getContext().getString(2131297005)).f(paramAnonymousString);
                paramAnonymousString.ya = paramAnonymousm;
                paramAnonymousString = paramAnonymousString.build();
                paramAnonymousString.icon = com.tencent.mm.bp.a.bYt();
                paramAnonymousString.flags |= 0x10;
                paramAnonymousString.sound = RingtoneManager.getDefaultUri(2);
                aw.getNotification().notify(38, paramAnonymousString);
              }
            }
            AppMethodBeat.o(26510);
            return;
            label699:
            paramAnonymousString = paramAnonymousm;
            paramAnonymousm = localIntent;
            continue;
            if (paramAnonymousInt2 == -1)
            {
              if (localaaw.wRq != null)
              {
                paramAnonymousm = new Intent();
                paramAnonymousm.putExtra("intent.key.login.url", paramqb.cGD.cGE);
                paramAnonymousm.putExtra("intent.key.type", -1);
                paramAnonymousm.putExtra("intent.key.title.string", localaaw.wRq.wRn);
                paramAnonymousm.putExtra("intent.key.icon.type", localaaw.wRq.wRl);
                paramAnonymousm.putExtra("intent.key.ok.string", localaaw.wRq.wRo);
                paramAnonymousm.putExtra("intent.key.content.string", localaaw.wRq.wRm);
                paramAnonymousString = localaaw.wRq.wRm;
              }
            }
            else if ((paramAnonymousInt2 == -2) && (localaaw.wRr != null))
            {
              paramAnonymousm = new Intent();
              paramAnonymousm.putExtra("intent.key.login.url", paramqb.cGD.cGE);
              paramAnonymousm.putExtra("intent.key.type", -2);
              paramAnonymousm.putExtra("intent.key.title.string", localaaw.wRr.wRn);
              paramAnonymousm.putExtra("intent.key.icon.type", localaaw.wRr.wRl);
              paramAnonymousm.putExtra("intent.key.ok.string", localaaw.wRr.wRo);
              paramAnonymousm.putExtra("intent.key.content.string", localaaw.wRr.wRm);
              paramAnonymousString = localaaw.wRr.wRm;
              continue;
            }
            label961:
            paramAnonymousString = null;
            paramAnonymousm = null;
            continue;
            label969:
            paramAnonymousInt2 += 1;
          }
        }
      };
      aw.Rc().a(971, paramqb);
      aw.Rc().a(locald, 0);
    }
    AppMethodBeat.o(26512);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g.3
 * JD-Core Version:    0.7.0.1
 */
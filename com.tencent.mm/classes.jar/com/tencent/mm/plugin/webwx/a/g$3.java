package com.tencent.mm.plugin.webwx.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.un;
import com.tencent.mm.f.a.un.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.protobuf.alu;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bw;
import com.tencent.mm.util.b.a;

final class g$3
  extends IListener<un>
{
  g$3(g paramg)
  {
    AppMethodBeat.i(161474);
    this.__eventId = un.class.getName().hashCode();
    AppMethodBeat.o(161474);
  }
  
  private boolean a(final un paramun)
  {
    AppMethodBeat.i(30186);
    if ((paramun != null) && ((paramun instanceof un)))
    {
      final d locald = new d(paramun.fTP.fTQ);
      paramun = new com.tencent.mm.an.i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(30185);
          bh.aGY().b(971, this);
          alx localalx = (alx)d.c.b(locald.lKU.lBS);
          Log.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          Object localObject1;
          StringBuilder localStringBuilder;
          Object localObject3;
          Cursor localCursor;
          Object localObject2;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (localalx.Swc == null) {
              break label1011;
            }
            paramAnonymousString = new Intent();
            paramAnonymousString.putExtra("intent.key.login.url", paramun.fTP.fTQ);
            paramAnonymousString.putExtra("intent.key.type", 0);
            paramAnonymousString.putExtra("intent.key.icon.type", localalx.Swc.SvY);
            paramAnonymousString.putExtra("intent.key.ok.string", localalx.Swc.Swm);
            paramAnonymousString.putExtra("intent.key.cancel.string", localalx.Swc.Swn);
            paramAnonymousString.putExtra("intent.key.title.string", localalx.Swc.SvZ);
            paramAnonymousString.putExtra("intent.key.content.string", localalx.Swc.Swr);
            paramAnonymousString.putExtra("intent.key.login.client.version", localalx.Swg);
            paramAnonymousString.putExtra("intent.key.function.control", localalx.Swh);
            paramAnonymousString.putExtra("intent.key.usage.link", localalx.Swc.Sws);
            if (Util.isNullOrNil(localalx.Swc.Swt))
            {
              paramAnonymousq = com.tencent.mm.util.i.YyX;
              paramAnonymousq = com.tencent.mm.util.i.a(b.a.Yys, "");
              localalx.Swc.Swt = paramAnonymousq;
            }
            paramAnonymousString.putExtra("intent.key.spam.url", localalx.Swc.Swt);
            localObject1 = localalx.Swc.SvZ;
            localStringBuilder = new StringBuilder();
            localObject3 = null;
            localCursor = null;
            localObject2 = localCursor;
            paramAnonymousq = localObject3;
          }
          for (;;)
          {
            try
            {
              bh.beI();
              localObject2 = localCursor;
              paramAnonymousq = localObject3;
              localCursor = c.bbR().d(null, com.tencent.mm.o.a.jxD, true);
              if (localCursor != null)
              {
                localObject2 = localCursor;
                paramAnonymousq = localCursor;
                if (localCursor.getCount() < localalx.Swc.Swo)
                {
                  localObject2 = localCursor;
                  paramAnonymousq = localCursor;
                  paramAnonymousInt1 = localCursor.getCount();
                  localObject2 = localCursor;
                  paramAnonymousq = localCursor;
                  int i = localCursor.getColumnIndex("username");
                  paramAnonymousInt2 = 0;
                  if (paramAnonymousInt2 < paramAnonymousInt1)
                  {
                    localObject2 = localCursor;
                    paramAnonymousq = localCursor;
                    if (!localCursor.moveToPosition(paramAnonymousInt2)) {
                      break label1019;
                    }
                    localObject2 = localCursor;
                    paramAnonymousq = localCursor;
                    localStringBuilder.append(localCursor.getString(i));
                    if (paramAnonymousInt2 >= paramAnonymousInt1 - 1) {
                      break label1019;
                    }
                    localObject2 = localCursor;
                    paramAnonymousq = localCursor;
                    localStringBuilder.append(",");
                    break label1019;
                  }
                }
                else
                {
                  localObject2 = localCursor;
                  paramAnonymousq = localCursor;
                  paramAnonymousInt1 = localalx.Swc.Swo;
                  continue;
                }
              }
              localObject2 = localCursor;
              paramAnonymousq = localCursor;
              paramAnonymousString.putExtra("intent.key.ok.session.list", localStringBuilder.toString());
              if (localCursor == null) {
                break label750;
              }
              localCursor.close();
              paramAnonymousq = paramAnonymousString;
              paramAnonymousString = (String)localObject1;
            }
            catch (Exception localException)
            {
              paramAnonymousq = (q)localObject2;
              Log.printErrStackTrace("MicroMsg.SubCoreWebWX", localException, "[oneliang]get session list error.", new Object[0]);
              if (localObject2 == null) {
                break label750;
              }
              ((Cursor)localObject2).close();
              paramAnonymousq = paramAnonymousString;
              paramAnonymousString = (String)localObject1;
              continue;
            }
            finally
            {
              if (paramAnonymousq == null) {
                continue;
              }
              paramAnonymousq.close();
              AppMethodBeat.o(30185);
            }
            if (paramAnonymousq != null)
            {
              paramAnonymousq.setFlags(268435456);
              paramAnonymousq.setClass(MMApplicationContext.getContext(), ExtDeviceWXLoginUI.class);
              localObject1 = MMApplicationContext.getContext();
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousq);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousq = new Intent(paramAnonymousq);
              paramAnonymousq.setFlags(67108864);
              if (paramun.fTP.type == 1) {
                g.h(paramAnonymousString, paramAnonymousq);
              }
            }
            AppMethodBeat.o(30185);
            return;
            label750:
            paramAnonymousq = paramAnonymousString;
            paramAnonymousString = (String)localObject1;
            continue;
            if (paramAnonymousInt2 == -1)
            {
              if (localalx.Swd != null)
              {
                paramAnonymousq = new Intent();
                paramAnonymousq.putExtra("intent.key.login.url", paramun.fTP.fTQ);
                paramAnonymousq.putExtra("intent.key.type", -1);
                paramAnonymousq.putExtra("intent.key.title.string", localalx.Swd.Swa);
                paramAnonymousq.putExtra("intent.key.icon.type", localalx.Swd.SvY);
                paramAnonymousq.putExtra("intent.key.ok.string", localalx.Swd.Swb);
                paramAnonymousq.putExtra("intent.key.content.string", localalx.Swd.SvZ);
                paramAnonymousString = localalx.Swd.SvZ;
              }
            }
            else if ((paramAnonymousInt2 == -2) && (localalx.Swe != null))
            {
              paramAnonymousq = new Intent();
              paramAnonymousq.putExtra("intent.key.login.url", paramun.fTP.fTQ);
              paramAnonymousq.putExtra("intent.key.type", -2);
              paramAnonymousq.putExtra("intent.key.title.string", localalx.Swe.Swa);
              paramAnonymousq.putExtra("intent.key.icon.type", localalx.Swe.SvY);
              paramAnonymousq.putExtra("intent.key.ok.string", localalx.Swe.Swb);
              paramAnonymousq.putExtra("intent.key.content.string", localalx.Swe.SvZ);
              paramAnonymousString = localalx.Swe.SvZ;
              continue;
            }
            label1011:
            paramAnonymousString = null;
            paramAnonymousq = null;
            continue;
            label1019:
            paramAnonymousInt2 += 1;
          }
        }
      };
      bh.aGY().a(971, paramun);
      bh.aGY().a(locald, 0);
    }
    AppMethodBeat.o(30186);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g.3
 * JD-Core Version:    0.7.0.1
 */
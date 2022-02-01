package com.tencent.mm.plugin.webwx.model;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.wd;
import com.tencent.mm.autogen.a.wd.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.by;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;

class SubCoreWebWX$3
  extends IListener<wd>
{
  SubCoreWebWX$3(g paramg, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(265386);
    this.__eventId = wd.class.getName().hashCode();
    AppMethodBeat.o(265386);
  }
  
  private boolean a(final wd paramwd)
  {
    AppMethodBeat.i(30186);
    if ((paramwd != null) && ((paramwd instanceof wd)))
    {
      final d locald = new d(paramwd.hZN.hZO);
      paramwd = new h()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(30185);
          bh.aZW().b(971, this);
          api localapi = (api)c.c.b(locald.oDw.otC);
          Log.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          Object localObject1;
          StringBuilder localStringBuilder;
          Object localObject3;
          Cursor localCursor;
          Object localObject2;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (localapi.Zwl == null) {
              break label1055;
            }
            paramAnonymousString = new Intent();
            paramAnonymousString.putExtra("intent.key.login.url", paramwd.hZN.hZO);
            paramAnonymousString.putExtra("intent.key.type", 0);
            paramAnonymousString.putExtra("intent.key.icon.type", localapi.Zwl.Zwh);
            paramAnonymousString.putExtra("intent.key.ok.string", localapi.Zwl.ZwA);
            paramAnonymousString.putExtra("intent.key.cancel.string", localapi.Zwl.ZwB);
            paramAnonymousString.putExtra("intent.key.title.string", localapi.Zwl.Zwi);
            paramAnonymousString.putExtra("intent.key.content.string", localapi.Zwl.ZwF);
            paramAnonymousString.putExtra("intent.key.login.client.version", localapi.Zwp);
            paramAnonymousString.putExtra("intent.key.function.control", localapi.Zwq);
            paramAnonymousString.putExtra("intent.key.usage.link", localapi.Zwl.ZwG);
            paramAnonymousString.putExtra("intent.key.multi.device.tips.type", localapi.Zwl.ZwI);
            paramAnonymousString.putExtra("intent.key.multi.device.tips.string", localapi.Zwl.ZwJ);
            paramAnonymousString.putExtra("intent.key.auto.login.switch.tip.string", localapi.Zwr);
            if (Util.isNullOrNil(localapi.Zwl.ZwH))
            {
              paramAnonymousp = i.agtt;
              paramAnonymousp = i.a(b.a.agrY, "");
              localapi.Zwl.ZwH = paramAnonymousp;
            }
            paramAnonymousString.putExtra("intent.key.spam.url", localapi.Zwl.ZwH);
            localObject1 = localapi.Zwl.Zwi;
            localStringBuilder = new StringBuilder();
            localObject3 = null;
            localCursor = null;
            localObject2 = localCursor;
            paramAnonymousp = localObject3;
          }
          for (;;)
          {
            try
            {
              bh.bCz();
              localObject2 = localCursor;
              paramAnonymousp = localObject3;
              localCursor = com.tencent.mm.model.c.bzG().d(null, com.tencent.mm.l.a.maX, true);
              if (localCursor != null)
              {
                localObject2 = localCursor;
                paramAnonymousp = localCursor;
                if (localCursor.getCount() < localapi.Zwl.ZwC)
                {
                  localObject2 = localCursor;
                  paramAnonymousp = localCursor;
                  paramAnonymousInt1 = localCursor.getCount();
                  localObject2 = localCursor;
                  paramAnonymousp = localCursor;
                  int i = localCursor.getColumnIndex("username");
                  paramAnonymousInt2 = 0;
                  if (paramAnonymousInt2 < paramAnonymousInt1)
                  {
                    localObject2 = localCursor;
                    paramAnonymousp = localCursor;
                    if (!localCursor.moveToPosition(paramAnonymousInt2)) {
                      break label1063;
                    }
                    localObject2 = localCursor;
                    paramAnonymousp = localCursor;
                    localStringBuilder.append(localCursor.getString(i));
                    if (paramAnonymousInt2 >= paramAnonymousInt1 - 1) {
                      break label1063;
                    }
                    localObject2 = localCursor;
                    paramAnonymousp = localCursor;
                    localStringBuilder.append(",");
                    break label1063;
                  }
                }
                else
                {
                  localObject2 = localCursor;
                  paramAnonymousp = localCursor;
                  paramAnonymousInt1 = localapi.Zwl.ZwC;
                  continue;
                }
              }
              localObject2 = localCursor;
              paramAnonymousp = localCursor;
              paramAnonymousString.putExtra("intent.key.ok.session.list", localStringBuilder.toString());
              if (localCursor == null) {
                break label794;
              }
              localCursor.close();
              paramAnonymousp = paramAnonymousString;
              paramAnonymousString = (String)localObject1;
            }
            catch (Exception localException)
            {
              paramAnonymousp = (p)localObject2;
              Log.printErrStackTrace("MicroMsg.SubCoreWebWX", localException, "[oneliang]get session list error.", new Object[0]);
              if (localObject2 == null) {
                break label794;
              }
              ((Cursor)localObject2).close();
              paramAnonymousp = paramAnonymousString;
              paramAnonymousString = (String)localObject1;
              continue;
            }
            finally
            {
              if (paramAnonymousp == null) {
                continue;
              }
              paramAnonymousp.close();
              AppMethodBeat.o(30185);
            }
            if (paramAnonymousp != null)
            {
              paramAnonymousp.setFlags(268435456);
              paramAnonymousp.setClass(MMApplicationContext.getContext(), ExtDeviceWXLoginUI.class);
              localObject1 = MMApplicationContext.getContext();
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousp);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousp = new Intent(paramAnonymousp);
              paramAnonymousp.setFlags(67108864);
              if (paramwd.hZN.type == 1) {
                g.i(paramAnonymousString, paramAnonymousp);
              }
            }
            AppMethodBeat.o(30185);
            return;
            label794:
            paramAnonymousp = paramAnonymousString;
            paramAnonymousString = (String)localObject1;
            continue;
            if (paramAnonymousInt2 == -1)
            {
              if (localapi.Zwm != null)
              {
                paramAnonymousp = new Intent();
                paramAnonymousp.putExtra("intent.key.login.url", paramwd.hZN.hZO);
                paramAnonymousp.putExtra("intent.key.type", -1);
                paramAnonymousp.putExtra("intent.key.title.string", localapi.Zwm.Zwj);
                paramAnonymousp.putExtra("intent.key.icon.type", localapi.Zwm.Zwh);
                paramAnonymousp.putExtra("intent.key.ok.string", localapi.Zwm.Zwk);
                paramAnonymousp.putExtra("intent.key.content.string", localapi.Zwm.Zwi);
                paramAnonymousString = localapi.Zwm.Zwi;
              }
            }
            else if ((paramAnonymousInt2 == -2) && (localapi.Zwn != null))
            {
              paramAnonymousp = new Intent();
              paramAnonymousp.putExtra("intent.key.login.url", paramwd.hZN.hZO);
              paramAnonymousp.putExtra("intent.key.type", -2);
              paramAnonymousp.putExtra("intent.key.title.string", localapi.Zwn.Zwj);
              paramAnonymousp.putExtra("intent.key.icon.type", localapi.Zwn.Zwh);
              paramAnonymousp.putExtra("intent.key.ok.string", localapi.Zwn.Zwk);
              paramAnonymousp.putExtra("intent.key.content.string", localapi.Zwn.Zwi);
              paramAnonymousString = localapi.Zwn.Zwi;
              continue;
            }
            label1055:
            paramAnonymousString = null;
            paramAnonymousp = null;
            continue;
            label1063:
            paramAnonymousInt2 += 1;
          }
        }
      };
      bh.aZW().a(971, paramwd);
      bh.aZW().a(locald, 0);
    }
    AppMethodBeat.o(30186);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.model.SubCoreWebWX.3
 * JD-Core Version:    0.7.0.1
 */
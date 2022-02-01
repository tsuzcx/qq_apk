package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.am.l;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.base.h;

public final class c
{
  public static void a(final String paramString, final Context paramContext, final at paramat, final Runnable paramRunnable, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(38287);
    final PBool localPBool = new PBool();
    Object localObject1;
    if (w.vF(paramString))
    {
      paramat = null;
      ba.aBQ();
      localObject1 = com.tencent.mm.model.c.azs().apW(paramString);
      ba.aBQ();
      com.tencent.mm.model.c.azo().c(new com.tencent.mm.bb.e(paramString, ((ei)localObject1).field_msgSvrId));
      localPBool.value = false;
      paramContext.getString(2131755906);
      localObject1 = h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          this.Ksf.value = true;
        }
      });
      if (!localPBool.value) {
        paramat = d.aNO(paramString);
      }
      if (!bt.isNullOrNil(paramat))
      {
        ((ProgressDialog)localObject1).dismiss();
        h.a(paramContext, false, paramContext.getString(2131765189, new Object[] { paramat }), null, paramContext.getString(2131760081), paramContext.getString(2131758021), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38279);
            this.Ksf.value = true;
            c.c(paramContext, paramBoolean2, paramString);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(4), paramString });
            }
            AppMethodBeat.o(38279);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38280);
            this.fNl.show();
            localPBool.value = false;
            c.a(paramString, localPBool, this.fNl);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(3), paramString });
            }
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(38280);
          }
        }, -1, 2131099904);
      }
    }
    while (w.zL(paramString))
    {
      ad.i("MicroMsg.ConvDelLogic", "del all qmessage");
      bj.aCe();
      ba.aBQ();
      com.tencent.mm.model.c.azv().aTy("@qqim");
      AppMethodBeat.o(38287);
      return;
      ((ProgressDialog)localObject1).dismiss();
      h.a(paramContext, paramContext.getString(2131759507), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38281);
          c.a(this.geH, localPBool, this.fNl);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(38281);
        }
      }, null, 2131099904);
      continue;
      if (w.zU(paramString))
      {
        ba.aBQ();
        com.tencent.mm.model.c.azv().aTy(paramString);
        paramContext = new pt();
        paramContext.dEe.opType = 4;
        paramContext.dEe.dEj = 20;
        a.IbL.l(paramContext);
      }
      else if (w.zK(paramString))
      {
        ba.aBQ();
        com.tencent.mm.model.c.azv().aTy(paramString);
      }
      else if (w.zN(paramString))
      {
        ba.aBQ();
        com.tencent.mm.model.c.azv().aTx(paramString);
      }
      else
      {
        Object localObject2;
        int i;
        if (com.tencent.mm.am.g.DQ(paramString))
        {
          ba.aBQ();
          localObject1 = com.tencent.mm.model.c.azs().apW(paramString);
          ba.aBQ();
          com.tencent.mm.model.c.azo().c(new com.tencent.mm.bb.e(paramString, ((ei)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(2131755906);
          localObject1 = h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.Ksf.value = true;
            }
          });
          ag.aFZ();
          localObject2 = f.DH(paramString);
          paramat = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194641);
              c.a(paramString, paramat, localPBool, this.Ksj);
              if (paramRunnable != null) {
                paramRunnable.run();
              }
              if (com.tencent.mm.am.g.DL(paramString)) {
                ag.aGk().DZ(paramString);
              }
              AppMethodBeat.o(194641);
            }
          };
          ((ProgressDialog)localObject1).dismiss();
          if (bt.isNullOrNil((String)localObject2))
          {
            if (w.Ad(paramString)) {}
            for (i = 2131759506;; i = 2131759505)
            {
              h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(194642);
                  this.Ksl.run();
                  AppMethodBeat.o(194642);
                }
              }, null, 2131099904);
              break;
            }
          }
          h.a(paramContext, paramContext.getString(2131759505), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38285);
              this.Ksl.run();
              bj.a(paramString, new bj.a()
              {
                public final boolean YK()
                {
                  AppMethodBeat.i(194643);
                  if ((c.17.this.Ksf.value) || (c.17.this.Ksj == null) || (!c.17.this.Ksj.isShowing()))
                  {
                    AppMethodBeat.o(194643);
                    return true;
                  }
                  AppMethodBeat.o(194643);
                  return false;
                }
                
                public final void YL()
                {
                  AppMethodBeat.i(194644);
                  com.tencent.mm.am.a.e.N(c.17.this.IVK, false);
                  if (c.17.this.Ksj != null) {
                    c.17.this.Ksj.dismiss();
                  }
                  AppMethodBeat.o(194644);
                }
              });
              AppMethodBeat.o(38285);
            }
          }, null, 2131099904);
        }
        else if (com.tencent.mm.am.g.vd(paramString))
        {
          localPBool.value = false;
          paramContext.getString(2131755906);
          paramat = h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.Ksf.value = true;
            }
          });
          paramat.dismiss();
          h.a(paramContext, paramContext.getString(2131759505), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38273);
              bj.a(this.geH, new bj.a()
              {
                public final boolean YK()
                {
                  AppMethodBeat.i(194631);
                  if ((c.2.this.Ksf.value) || (c.2.this.fNl == null) || (!c.2.this.fNl.isShowing()))
                  {
                    AppMethodBeat.o(194631);
                    return true;
                  }
                  AppMethodBeat.o(194631);
                  return false;
                }
                
                public final void YL()
                {
                  AppMethodBeat.i(194632);
                  com.tencent.mm.am.a.e.N(c.2.this.IVK, false);
                  if (c.2.this.fNl != null) {
                    c.2.this.fNl.dismiss();
                  }
                  AppMethodBeat.o(194632);
                }
              });
              AppMethodBeat.o(38273);
            }
          }, null, 2131099904);
        }
        else
        {
          ba.aBQ();
          localObject1 = com.tencent.mm.model.c.azs().apW(paramString);
          ba.aBQ();
          com.tencent.mm.model.c.azo().c(new com.tencent.mm.bb.e(paramString, ((ei)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(2131755906);
          localObject2 = h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.Ksf.value = true;
            }
          });
          localObject1 = null;
          if (!localPBool.value) {
            localObject1 = d.aNO(paramString);
          }
          if (!bt.isNullOrNil((String)localObject1))
          {
            ((ProgressDialog)localObject2).dismiss();
            h.a(paramContext, false, paramContext.getString(2131765189, new Object[] { localObject1 }), null, paramContext.getString(2131760081), paramContext.getString(2131758021), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(194633);
                this.Ksf.value = true;
                c.c(paramContext, paramBoolean2, paramString);
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(4), paramString });
                }
                AppMethodBeat.o(194633);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(194634);
                this.Ksj.show();
                localPBool.value = false;
                c.a(paramString, paramat, localPBool, this.Ksj);
                if (paramRunnable != null) {
                  paramRunnable.run();
                }
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(3), paramString });
                }
                AppMethodBeat.o(194634);
              }
            }, -1, 2131099904);
          }
          else
          {
            ((ProgressDialog)localObject2).dismiss();
            if (w.Ad(paramString)) {}
            for (i = 2131759506;; i = 2131759505)
            {
              h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(194635);
                  c.a(paramString, paramat, localPBool, this.Ksj);
                  if (paramRunnable != null) {
                    paramRunnable.run();
                  }
                  if (com.tencent.mm.am.g.DL(paramString)) {
                    ag.aGk().DZ(paramString);
                  }
                  if (w.Ad(paramString)) {
                    y.fpC();
                  }
                  AppMethodBeat.o(194635);
                }
              }, null, 2131099904);
              break;
            }
          }
        }
      }
    }
    if (w.zJ(paramString))
    {
      ad.i("MicroMsg.ConvDelLogic", "del all tmessage");
      bj.aCf();
      ba.aBQ();
      com.tencent.mm.model.c.azv().aTy("@t.qq.com");
    }
    AppMethodBeat.o(38287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c
 * JD-Core Version:    0.7.0.1
 */
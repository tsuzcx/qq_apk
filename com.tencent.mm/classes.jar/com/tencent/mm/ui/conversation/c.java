package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.l;
import com.tencent.mm.as.b;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.base.h;

public final class c
{
  public static void a(final String paramString, final Context paramContext, final au paramau, final Runnable paramRunnable, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(38287);
    final PBool localPBool = new PBool();
    Object localObject1;
    if (x.wb(paramString))
    {
      paramau = null;
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azI().arb(paramString);
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new com.tencent.mm.ba.e(paramString, ((ei)localObject1).field_msgSvrId));
      localPBool.value = false;
      paramContext.getString(2131755906);
      localObject1 = h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          this.KOz.value = true;
        }
      });
      if (!localPBool.value) {
        paramau = d.aPl(paramString);
      }
      if (!bu.isNullOrNil(paramau))
      {
        ((ProgressDialog)localObject1).dismiss();
        h.a(paramContext, false, paramContext.getString(2131765189, new Object[] { paramau }), null, paramContext.getString(2131760081), paramContext.getString(2131758021), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38279);
            this.KOz.value = true;
            c.c(paramContext, paramBoolean2, paramString);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(4), paramString });
            }
            AppMethodBeat.o(38279);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38280);
            this.fPt.show();
            localPBool.value = false;
            c.a(paramString, localPBool, this.fPt);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(3), paramString });
            }
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(38280);
          }
        }, -1, 2131099904);
      }
    }
    while (x.Av(paramString))
    {
      ae.i("MicroMsg.ConvDelLogic", "del all qmessage");
      bl.aCu();
      bc.aCg();
      com.tencent.mm.model.c.azL().aUZ("@qqim");
      AppMethodBeat.o(38287);
      return;
      ((ProgressDialog)localObject1).dismiss();
      h.a(paramContext, paramContext.getString(2131759507), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38281);
          c.a(this.ggQ, localPBool, this.fPt);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(38281);
        }
      }, null, 2131099904);
      continue;
      if (x.AE(paramString))
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().aUZ(paramString);
        paramContext = new pu();
        paramContext.dFj.opType = 4;
        paramContext.dFj.dFo = 20;
        a.IvT.l(paramContext);
      }
      else if (x.Au(paramString))
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().aUZ(paramString);
      }
      else if (x.Ax(paramString))
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().aUY(paramString);
      }
      else
      {
        Object localObject2;
        int i;
        if (com.tencent.mm.al.g.Es(paramString))
        {
          bc.aCg();
          localObject1 = com.tencent.mm.model.c.azI().arb(paramString);
          bc.aCg();
          com.tencent.mm.model.c.azE().d(new com.tencent.mm.ba.e(paramString, ((ei)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(2131755906);
          localObject1 = h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.KOz.value = true;
            }
          });
          ag.aGp();
          localObject2 = f.Ej(paramString);
          paramau = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(188043);
              c.a(paramString, paramau, localPBool, this.KOD);
              if (paramRunnable != null) {
                paramRunnable.run();
              }
              if (com.tencent.mm.al.g.En(paramString)) {
                ag.aGA().EB(paramString);
              }
              AppMethodBeat.o(188043);
            }
          };
          ((ProgressDialog)localObject1).dismiss();
          if (bu.isNullOrNil((String)localObject2))
          {
            if (x.AN(paramString)) {}
            for (i = 2131759506;; i = 2131759505)
            {
              h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(188044);
                  this.KOF.run();
                  AppMethodBeat.o(188044);
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
              this.KOF.run();
              bl.a(paramString, new bl.a()
              {
                public final boolean YT()
                {
                  AppMethodBeat.i(188045);
                  if ((c.17.this.KOz.value) || (c.17.this.KOD == null) || (!c.17.this.KOD.isShowing()))
                  {
                    AppMethodBeat.o(188045);
                    return true;
                  }
                  AppMethodBeat.o(188045);
                  return false;
                }
                
                public final void YU()
                {
                  AppMethodBeat.i(188046);
                  com.tencent.mm.al.a.e.N(c.17.this.Jqs, false);
                  if (c.17.this.KOD != null) {
                    c.17.this.KOD.dismiss();
                  }
                  AppMethodBeat.o(188046);
                }
              });
              AppMethodBeat.o(38285);
            }
          }, null, 2131099904);
        }
        else if (com.tencent.mm.al.g.vz(paramString))
        {
          localPBool.value = false;
          paramContext.getString(2131755906);
          paramau = h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.KOz.value = true;
            }
          });
          paramau.dismiss();
          h.a(paramContext, paramContext.getString(2131759505), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38273);
              bl.a(this.ggQ, new bl.a()
              {
                public final boolean YT()
                {
                  AppMethodBeat.i(188033);
                  if ((c.2.this.KOz.value) || (c.2.this.fPt == null) || (!c.2.this.fPt.isShowing()))
                  {
                    AppMethodBeat.o(188033);
                    return true;
                  }
                  AppMethodBeat.o(188033);
                  return false;
                }
                
                public final void YU()
                {
                  AppMethodBeat.i(188034);
                  com.tencent.mm.al.a.e.N(c.2.this.Jqs, false);
                  if (c.2.this.fPt != null) {
                    c.2.this.fPt.dismiss();
                  }
                  AppMethodBeat.o(188034);
                }
              });
              AppMethodBeat.o(38273);
            }
          }, null, 2131099904);
        }
        else
        {
          bc.aCg();
          localObject1 = com.tencent.mm.model.c.azI().arb(paramString);
          bc.aCg();
          com.tencent.mm.model.c.azE().d(new com.tencent.mm.ba.e(paramString, ((ei)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(2131755906);
          localObject2 = h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.KOz.value = true;
            }
          });
          localObject1 = null;
          if (!localPBool.value) {
            localObject1 = d.aPl(paramString);
          }
          if (!bu.isNullOrNil((String)localObject1))
          {
            ((ProgressDialog)localObject2).dismiss();
            h.a(paramContext, false, paramContext.getString(2131765189, new Object[] { localObject1 }), null, paramContext.getString(2131760081), paramContext.getString(2131758021), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(188035);
                this.KOz.value = true;
                c.c(paramContext, paramBoolean2, paramString);
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(4), paramString });
                }
                AppMethodBeat.o(188035);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(188036);
                this.KOD.show();
                localPBool.value = false;
                c.a(paramString, paramau, localPBool, this.KOD);
                if (paramRunnable != null) {
                  paramRunnable.run();
                }
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(3), paramString });
                }
                AppMethodBeat.o(188036);
              }
            }, -1, 2131099904);
          }
          else
          {
            ((ProgressDialog)localObject2).dismiss();
            if (x.AN(paramString)) {}
            for (i = 2131759506;; i = 2131759505)
            {
              h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(188037);
                  c.a(paramString, paramau, localPBool, this.KOD);
                  if (paramRunnable != null) {
                    paramRunnable.run();
                  }
                  if (com.tencent.mm.al.g.En(paramString)) {
                    ag.aGA().EB(paramString);
                  }
                  if (x.AN(paramString)) {
                    y.ftB();
                  }
                  AppMethodBeat.o(188037);
                }
              }, null, 2131099904);
              break;
            }
          }
        }
      }
    }
    if (x.At(paramString))
    {
      ae.i("MicroMsg.ConvDelLogic", "del all tmessage");
      bl.aCv();
      bc.aCg();
      com.tencent.mm.model.c.azL().aUZ("@t.qq.com");
    }
    AppMethodBeat.o(38287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c
 * JD-Core Version:    0.7.0.1
 */
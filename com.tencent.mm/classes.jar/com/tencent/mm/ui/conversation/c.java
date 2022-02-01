package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.al.l;
import com.tencent.mm.as.b;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.b.a.fd;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;

public final class c
{
  public static void a(final String paramString, final Context paramContext, final az paramaz, final Runnable paramRunnable, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(38287);
    final PBool localPBool = new PBool();
    Object localObject1;
    if (com.tencent.mm.model.ab.Eq(paramString))
    {
      paramaz = null;
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSQ().aEw(paramString);
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.e(paramString, ((eo)localObject1).field_msgSvrId));
      localPBool.value = false;
      paramContext.getString(2131755998);
      localObject1 = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          this.QbA.value = true;
        }
      });
      if (!localPBool.value) {
        paramaz = d.bfO(paramString);
      }
      if (!Util.isNullOrNil(paramaz))
      {
        ((ProgressDialog)localObject1).dismiss();
        com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(2131767632, new Object[] { paramaz }), null, paramContext.getString(2131761460), paramContext.getString(2131758273), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38279);
            this.QbA.value = true;
            c.c(paramContext, paramBoolean2, paramString);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(4), paramString });
            }
            AppMethodBeat.o(38279);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38280);
            this.guD.show();
            localPBool.value = false;
            c.a(paramString, localPBool, this.guD);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(3), paramString });
            }
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(38280);
          }
        }, -1, 2131099922);
      }
    }
    while (com.tencent.mm.model.ab.Ja(paramString))
    {
      Log.i("MicroMsg.ConvDelLogic", "del all qmessage");
      bp.aVS();
      bg.aVF();
      com.tencent.mm.model.c.aST().bjX("@qqim");
      AppMethodBeat.o(38287);
      return;
      ((ProgressDialog)localObject1).dismiss();
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131760822), "", paramContext.getString(2131755778), paramContext.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38281);
          c.a(this.gMw, localPBool, this.guD);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(38281);
        }
      }, null, 2131099922);
      continue;
      if (com.tencent.mm.model.ab.Jj(paramString))
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().bjX(paramString);
        paramContext = new qn();
        paramContext.dWV.opType = 4;
        paramContext.dWV.dXa = 20;
        EventCenter.instance.publish(paramContext);
      }
      else if (com.tencent.mm.model.ab.IZ(paramString))
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().bjX(paramString);
      }
      else if (com.tencent.mm.model.ab.Jc(paramString))
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().bjW(paramString);
      }
      else
      {
        Object localObject2;
        int i;
        if (g.Ng(paramString))
        {
          bg.aVF();
          localObject1 = com.tencent.mm.model.c.aSQ().aEw(paramString);
          bg.aVF();
          com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.e(paramString, ((eo)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(2131755998);
          localObject1 = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131756029), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.QbA.value = true;
            }
          });
          ag.bah();
          localObject2 = f.MX(paramString);
          paramaz = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(234110);
              c.a(paramString, paramaz, localPBool, this.QbE);
              if (paramRunnable != null) {
                paramRunnable.run();
              }
              if (g.Nb(paramString)) {
                ag.bat().Np(paramString);
              }
              AppMethodBeat.o(234110);
            }
          };
          ((ProgressDialog)localObject1).dismiss();
          if (Util.isNullOrNil((String)localObject2))
          {
            if (com.tencent.mm.model.ab.Js(paramString)) {}
            for (i = 2131760821;; i = 2131760820)
            {
              com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131755778), paramContext.getString(2131755761), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(234111);
                  this.QbG.run();
                  AppMethodBeat.o(234111);
                }
              }, null, 2131099922);
              break;
            }
          }
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131760820), "", paramContext.getString(2131755778), paramContext.getString(2131755761), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38285);
              this.QbG.run();
              bp.a(paramString, new bp.a()
              {
                public final boolean amG()
                {
                  AppMethodBeat.i(234112);
                  if ((c.17.this.QbA.value) || (c.17.this.QbE == null) || (!c.17.this.QbE.isShowing()))
                  {
                    AppMethodBeat.o(234112);
                    return true;
                  }
                  AppMethodBeat.o(234112);
                  return false;
                }
                
                public final void amH()
                {
                  AppMethodBeat.i(234113);
                  com.tencent.mm.al.a.e.P(c.17.this.OAy, false);
                  if (c.17.this.QbE != null) {
                    c.17.this.QbE.dismiss();
                  }
                  AppMethodBeat.o(234113);
                }
              });
              AppMethodBeat.o(38285);
            }
          }, null, 2131099922);
        }
        else if (g.DQ(paramString))
        {
          localPBool.value = false;
          paramContext.getString(2131755998);
          paramaz = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131756029), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.QbA.value = true;
            }
          });
          paramaz.dismiss();
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131760820), "", paramContext.getString(2131755778), paramContext.getString(2131755761), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38273);
              bp.a(this.gMw, new bp.a()
              {
                public final boolean amG()
                {
                  AppMethodBeat.i(234100);
                  if ((c.2.this.QbA.value) || (c.2.this.guD == null) || (!c.2.this.guD.isShowing()))
                  {
                    AppMethodBeat.o(234100);
                    return true;
                  }
                  AppMethodBeat.o(234100);
                  return false;
                }
                
                public final void amH()
                {
                  AppMethodBeat.i(234101);
                  com.tencent.mm.al.a.e.P(c.2.this.OAy, false);
                  if (c.2.this.guD != null) {
                    c.2.this.guD.dismiss();
                  }
                  AppMethodBeat.o(234101);
                }
              });
              AppMethodBeat.o(38273);
            }
          }, null, 2131099922);
        }
        else
        {
          bg.aVF();
          localObject1 = com.tencent.mm.model.c.aSQ().aEw(paramString);
          bg.aVF();
          com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.e(paramString, ((eo)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(2131755998);
          localObject2 = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131756029), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.QbA.value = true;
            }
          });
          localObject1 = null;
          if (!localPBool.value) {
            localObject1 = d.bfO(paramString);
          }
          if (!Util.isNullOrNil((String)localObject1))
          {
            ((ProgressDialog)localObject2).dismiss();
            com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(2131767632, new Object[] { localObject1 }), null, paramContext.getString(2131761460), paramContext.getString(2131758273), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(234102);
                this.QbA.value = true;
                c.c(paramContext, paramBoolean2, paramString);
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(4), paramString });
                }
                AppMethodBeat.o(234102);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(234103);
                this.QbE.show();
                localPBool.value = false;
                c.a(paramString, paramaz, localPBool, this.QbE);
                if (paramRunnable != null) {
                  paramRunnable.run();
                }
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(3), paramString });
                }
                AppMethodBeat.o(234103);
              }
            }, -1, 2131099922);
          }
          else
          {
            ((ProgressDialog)localObject2).dismiss();
            if (com.tencent.mm.model.ab.Js(paramString)) {}
            for (i = 2131760821;; i = 2131760820)
            {
              com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131755778), paramContext.getString(2131755761), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(234104);
                  c.a(paramString, paramaz, localPBool, this.QbE);
                  if (paramRunnable != null) {
                    paramRunnable.run();
                  }
                  if (g.Nb(paramString)) {
                    ag.bat().Np(paramString);
                  }
                  if (com.tencent.mm.model.ab.Js(paramString)) {
                    com.tencent.mm.storage.ab.gAZ();
                  }
                  AppMethodBeat.o(234104);
                }
              }, null, 2131099922);
              break;
            }
          }
        }
      }
    }
    if (com.tencent.mm.model.ab.IY(paramString))
    {
      Log.i("MicroMsg.ConvDelLogic", "del all tmessage");
      bp.aVT();
      bg.aVF();
      com.tencent.mm.model.c.aST().bjX("@t.qq.com");
    }
    AppMethodBeat.o(38287);
  }
  
  private static void report(String paramString)
  {
    AppMethodBeat.i(234114);
    bg.aVF();
    az localaz = com.tencent.mm.model.c.aST().bjY(paramString);
    if (localaz != null)
    {
      fd localfd = new fd();
      localfd.enl = 15L;
      localfd.sa(paramString);
      localfd.eFa = ac.JT(paramString);
      localfd.enE = localaz.field_unReadCount;
      localfd.bfK();
    }
    AppMethodBeat.o(234114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c
 * JD-Core Version:    0.7.0.1
 */
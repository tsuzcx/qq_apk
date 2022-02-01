package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.al.f;
import com.tencent.mm.al.k;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;

public final class c
{
  public static void a(final String paramString, final Context paramContext, final ap paramap, final Runnable paramRunnable, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(38287);
    final PBool localPBool = new PBool();
    Object localObject1;
    if (w.sQ(paramString))
    {
      paramap = null;
      az.ayM();
      localObject1 = com.tencent.mm.model.c.awD().alj(paramString);
      az.ayM();
      com.tencent.mm.model.c.awA().c(new com.tencent.mm.ba.e(paramString, ((dy)localObject1).field_msgSvrId));
      localPBool.value = false;
      paramContext.getString(2131755906);
      localObject1 = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          this.IAZ.value = true;
        }
      });
      if (!localPBool.value) {
        paramap = d.aIl(paramString);
      }
      if (!bs.isNullOrNil(paramap))
      {
        ((ProgressDialog)localObject1).dismiss();
        com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(2131765189, new Object[] { paramap }), null, paramContext.getString(2131760081), paramContext.getString(2131758021), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38279);
            this.IAZ.value = true;
            c.c(paramContext, paramBoolean2, paramString);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(4), paramString });
            }
            AppMethodBeat.o(38279);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38280);
            this.fuk.show();
            localPBool.value = false;
            c.a(paramString, localPBool, this.fuk);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(3), paramString });
            }
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(38280);
          }
        }, -1, 2131099904);
      }
    }
    while (w.wO(paramString))
    {
      ac.i("MicroMsg.ConvDelLogic", "del all qmessage");
      bi.aza();
      az.ayM();
      com.tencent.mm.model.c.awG().aNH("@qqim");
      AppMethodBeat.o(38287);
      return;
      ((ProgressDialog)localObject1).dismiss();
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759507), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38281);
          c.a(this.fLg, localPBool, this.fuk);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(38281);
        }
      }, null, 2131099904);
      continue;
      if (w.wX(paramString))
      {
        az.ayM();
        com.tencent.mm.model.c.awG().aNH(paramString);
        paramContext = new pj();
        paramContext.dsk.opType = 4;
        paramContext.dsk.dsp = 20;
        a.GpY.l(paramContext);
      }
      else if (w.wN(paramString))
      {
        az.ayM();
        com.tencent.mm.model.c.awG().aNH(paramString);
      }
      else if (w.wQ(paramString))
      {
        az.ayM();
        com.tencent.mm.model.c.awG().aNG(paramString);
      }
      else
      {
        Object localObject2;
        int i;
        if (f.AR(paramString))
        {
          az.ayM();
          localObject1 = com.tencent.mm.model.c.awD().alj(paramString);
          az.ayM();
          com.tencent.mm.model.c.awA().c(new com.tencent.mm.ba.e(paramString, ((dy)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(2131755906);
          localObject1 = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.IAZ.value = true;
            }
          });
          af.aCW();
          localObject2 = com.tencent.mm.al.e.AI(paramString);
          paramap = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(196797);
              c.a(paramString, paramap, localPBool, this.IBd);
              if (paramRunnable != null) {
                paramRunnable.run();
              }
              if (f.AM(paramString)) {
                af.aDh().Ba(paramString);
              }
              AppMethodBeat.o(196797);
            }
          };
          ((ProgressDialog)localObject1).dismiss();
          if (bs.isNullOrNil((String)localObject2))
          {
            if (w.xg(paramString)) {}
            for (i = 2131759506;; i = 2131759505)
            {
              com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(196798);
                  this.IBf.run();
                  AppMethodBeat.o(196798);
                }
              }, null, 2131099904);
              break;
            }
          }
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759505), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38285);
              this.IBf.run();
              bi.a(paramString, new bi.a()
              {
                public final boolean Wr()
                {
                  AppMethodBeat.i(196799);
                  if ((c.17.this.IAZ.value) || (c.17.this.IBd == null) || (!c.17.this.IBd.isShowing()))
                  {
                    AppMethodBeat.o(196799);
                    return true;
                  }
                  AppMethodBeat.o(196799);
                  return false;
                }
                
                public final void Ws()
                {
                  AppMethodBeat.i(196800);
                  com.tencent.mm.al.a.e.N(c.17.this.Hit, false);
                  if (c.17.this.IBd != null) {
                    c.17.this.IBd.dismiss();
                  }
                  AppMethodBeat.o(196800);
                }
              });
              AppMethodBeat.o(38285);
            }
          }, null, 2131099904);
        }
        else if (f.so(paramString))
        {
          localPBool.value = false;
          paramContext.getString(2131755906);
          paramap = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.IAZ.value = true;
            }
          });
          paramap.dismiss();
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759505), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38273);
              bi.a(this.fLg, new bi.a()
              {
                public final boolean Wr()
                {
                  AppMethodBeat.i(196787);
                  if ((c.2.this.IAZ.value) || (c.2.this.fuk == null) || (!c.2.this.fuk.isShowing()))
                  {
                    AppMethodBeat.o(196787);
                    return true;
                  }
                  AppMethodBeat.o(196787);
                  return false;
                }
                
                public final void Ws()
                {
                  AppMethodBeat.i(196788);
                  com.tencent.mm.al.a.e.N(c.2.this.Hit, false);
                  if (c.2.this.fuk != null) {
                    c.2.this.fuk.dismiss();
                  }
                  AppMethodBeat.o(196788);
                }
              });
              AppMethodBeat.o(38273);
            }
          }, null, 2131099904);
        }
        else
        {
          az.ayM();
          localObject1 = com.tencent.mm.model.c.awD().alj(paramString);
          az.ayM();
          com.tencent.mm.model.c.awA().c(new com.tencent.mm.ba.e(paramString, ((dy)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(2131755906);
          localObject2 = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.IAZ.value = true;
            }
          });
          localObject1 = null;
          if (!localPBool.value) {
            localObject1 = d.aIl(paramString);
          }
          if (!bs.isNullOrNil((String)localObject1))
          {
            ((ProgressDialog)localObject2).dismiss();
            com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(2131765189, new Object[] { localObject1 }), null, paramContext.getString(2131760081), paramContext.getString(2131758021), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(196789);
                this.IAZ.value = true;
                c.c(paramContext, paramBoolean2, paramString);
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(4), paramString });
                }
                AppMethodBeat.o(196789);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(196790);
                this.IBd.show();
                localPBool.value = false;
                c.a(paramString, paramap, localPBool, this.IBd);
                if (paramRunnable != null) {
                  paramRunnable.run();
                }
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(3), paramString });
                }
                AppMethodBeat.o(196790);
              }
            }, -1, 2131099904);
          }
          else
          {
            ((ProgressDialog)localObject2).dismiss();
            if (w.xg(paramString)) {}
            for (i = 2131759506;; i = 2131759505)
            {
              com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(196791);
                  c.a(paramString, paramap, localPBool, this.IBd);
                  if (paramRunnable != null) {
                    paramRunnable.run();
                  }
                  if (f.AM(paramString)) {
                    af.aDh().Ba(paramString);
                  }
                  AppMethodBeat.o(196791);
                }
              }, null, 2131099904);
              break;
            }
          }
        }
      }
    }
    if (w.wM(paramString))
    {
      ac.i("MicroMsg.ConvDelLogic", "del all tmessage");
      bi.azb();
      az.ayM();
      com.tencent.mm.model.c.awG().aNH("@t.qq.com");
    }
    AppMethodBeat.o(38287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.ui.RecordMsgImageUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements h.b
{
  private int bjX;
  private View.OnClickListener cMV;
  ScanCodeSheetItemLogic lvI;
  private ListView mListView;
  e rAK;
  View.OnLongClickListener rAj;
  Map<String, a> rwK;
  private c rwO;
  h.a xrU;
  int xsO;
  
  public a(h.a parama, ListView paramListView)
  {
    AppMethodBeat.i(28010);
    this.bjX = 0;
    this.rwK = new HashMap();
    this.cMV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28001);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        Object localObject2 = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        ad.d("justin", "ImageViewWrapper clickListener %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject2).dataType) });
        switch (((com.tencent.mm.plugin.record.ui.a.b)localObject2).dataType)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28001);
          return;
          localObject1 = new Intent(paramAnonymousView.getContext(), RecordMsgImageUI.class);
          ((Intent)localObject1).putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).msgId);
          ((Intent)localObject1).putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dsC.dsU);
          ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dEP);
          if (((paramAnonymousView.getContext() instanceof Activity)) && (((Activity)paramAnonymousView.getContext()).getIntent() != null))
          {
            localObject2 = ((Activity)paramAnonymousView.getContext()).getIntent().getBundleExtra("_stat_obj");
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("_stat_obj", (Bundle)localObject2);
            }
          }
          paramAnonymousView = paramAnonymousView.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).prW.field_localId);
          ((Intent)localObject1).putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dsC.dsU);
          com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject1, 1);
        }
      }
    };
    this.rAj = new View.OnLongClickListener()
    {
      private Context context;
      private String path;
      private g rtA;
      private com.tencent.mm.plugin.record.ui.a.b xsQ;
      private ajn xsR;
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28004);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        if (paramAnonymousView != null)
        {
          this.context = paramAnonymousView.getContext();
          this.xsQ = ((com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag());
          this.rtA = this.xsQ.prW;
          this.xsR = this.xsQ.dsC;
        }
        paramAnonymousView = new gw();
        paramAnonymousView.dsV.type = 2;
        paramAnonymousView.dsV.dsX = this.xsQ.dsC;
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
        this.path = paramAnonymousView.dsW.path;
        if (!com.tencent.mm.vfs.i.fv(this.path))
        {
          ad.w("MicroMsg.ImageViewWrapper", "file not exists");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(28004);
          return true;
        }
        if (a.this.rAK == null) {
          a.this.rAK = new e(this.context, 1, false);
        }
        a.this.rAK.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(28002);
            paramAnonymous2l.clear();
            a.this.rAK.setFooterView(null);
            if (a.3.a(a.3.this).GhZ == 0)
            {
              if (a.3.b(a.3.this).cuQ()) {
                paramAnonymous2l.c(2, a.3.c(a.3.this).getString(2131759001));
              }
              if (a.3.b(a.3.this).cuR()) {
                paramAnonymous2l.c(1, a.3.c(a.3.this).getString(2131758951));
              }
              paramAnonymous2l.c(3, a.3.c(a.3.this).getString(2131758994));
              paramAnonymous2l = (a.a)a.this.rwK.get(a.3.d(a.3.this));
              if ((paramAnonymous2l != null) && (paramAnonymous2l.rwY != null))
              {
                if (!bt.isNullOrNil(paramAnonymous2l.rwY.dEH.result))
                {
                  e locale = a.this.rAK;
                  a locala = a.this;
                  Object localObject = a.3.c(a.3.this);
                  qe localqe = paramAnonymous2l.rwY;
                  localObject = new a.4(locala, localqe, (Context)localObject);
                  if (!paramAnonymous2l.xta)
                  {
                    paramAnonymous2l.xta = true;
                    locala.lvI.bW(localqe.dEH.dnt, localqe.dEH.result);
                  }
                  locale.setFooterView(locala.lvI.a((View.OnClickListener)localObject, localqe.dEH.dnt, localqe.dEH.result, 5));
                  AppMethodBeat.o(28002);
                }
              }
              else
              {
                paramAnonymous2l = new qc();
                paramAnonymous2l.dEC.dlI = System.currentTimeMillis();
                paramAnonymous2l.dEC.filePath = a.3.d(a.3.this);
                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2l);
              }
            }
            AppMethodBeat.o(28002);
          }
        };
        a.this.rAK.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28003);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(28003);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Ksnsupload_type", 0);
              paramAnonymous2MenuItem.putExtra("sns_kemdia_path", a.3.d(a.3.this));
              String str = y.AH("fav_");
              y.aBq().F(str, true).k("prePublishId", "fav_");
              paramAnonymous2MenuItem.putExtra("reportSessionId", str);
              d.b(a.3.c(a.3.this), "sns", ".ui.SnsUploadUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.plugin.fav.a.b.a(a.3.d(a.3.this), a.3.c(a.3.this), a.3.e(a.3.this).dsC.iuq);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.platformtools.p.a(a.3.c(a.3.this), a.3.d(a.3.this), new p.a()
              {
                public final void bF(String paramAnonymous3String1, final String paramAnonymous3String2)
                {
                  AppMethodBeat.i(193346);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.aRB(paramAnonymous3String2) }), 1).show();
                  h.LTJ.aR(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(193345);
                      String str = com.tencent.mm.vfs.i.aPK(paramAnonymous3String2);
                      v localv = v.iNJ;
                      v.bH(str, a.3.e(a.3.this).dsC.iuq);
                      AppMethodBeat.o(193345);
                    }
                  });
                  AppMethodBeat.o(193346);
                }
                
                public final void bG(String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  AppMethodBeat.i(193347);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(2131758993), 1).show();
                  AppMethodBeat.o(193347);
                }
              });
            }
          }
        };
        a.this.rAK.JXC = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(193348);
            a.this.lvI.onDismiss();
            AppMethodBeat.o(193348);
          }
        };
        a.this.rAK.cMW();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28004);
        return true;
      }
    };
    this.rwO = new c() {};
    this.xrU = parama;
    this.mListView = paramListView;
    com.tencent.mm.sdk.b.a.IbL.c(this.rwO);
    this.lvI = new ScanCodeSheetItemLogic(paramListView.getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bpj()
      {
        AppMethodBeat.i(28000);
        if ((a.this.rAK != null) && (a.this.rAK.isShowing())) {
          a.this.rAj.onLongClick(null);
        }
        AppMethodBeat.o(28000);
      }
    });
    AppMethodBeat.o(28010);
  }
  
  public final void a(final View paramView, int paramInt, final com.tencent.mm.plugin.record.ui.a.b paramb, final Object paramObject)
  {
    AppMethodBeat.i(28012);
    paramObject = (ImageView)paramView.findViewById(2131303893);
    paramView = (ProgressBar)paramView.findViewById(2131301506);
    paramObject.setTag(paramb);
    paramObject.setOnClickListener(this.cMV);
    if (paramb.dataType == 1) {
      paramObject.setOnLongClickListener(this.rAj);
    }
    h.a.b localb = new h.a.b();
    if (paramb.dataType == 0) {
      localb.xrW = paramb.msgId;
    }
    for (;;)
    {
      localb.dsC = paramb.dsC;
      localb.dsF = true;
      localb.maxWidth = this.bjX;
      Bitmap localBitmap = this.xrU.a(localb);
      if (localBitmap == null) {
        break;
      }
      ad.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[] { localb.dsC.dsU, localBitmap });
      a(paramObject, paramView, localBitmap, true, paramb.dsC.dsU);
      AppMethodBeat.o(28012);
      return;
      if (paramb.dataType == 1) {
        localb.xrW = paramb.prW.field_localId;
      }
    }
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28007);
        Object localObject = (com.tencent.mm.plugin.record.ui.a.a)paramb;
        final int i;
        if (((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 0)
        {
          if (!com.tencent.mm.plugin.record.b.p.g(((com.tencent.mm.plugin.record.ui.a.a)localObject).dsC, ((com.tencent.mm.plugin.record.ui.a.a)localObject).msgId)) {
            break label248;
          }
          i = 2131691090;
          if (i != -1) {
            break label340;
          }
          i = 2131690142;
        }
        label332:
        label335:
        label340:
        for (;;)
        {
          com.tencent.mm.plugin.record.ui.a.a locala = (com.tencent.mm.plugin.record.ui.a.a)paramb;
          h.a locala1 = a.this.xrU;
          int j = a.this.xsO;
          localObject = new h.a.b();
          ((h.a.b)localObject).dsC = locala.dsC;
          ((h.a.b)localObject).dsF = false;
          ((h.a.b)localObject).maxWidth = j;
          h.a.c localc = new h.a.c();
          localc.dsC = locala.dsC;
          Bitmap localBitmap;
          if (locala.dataType == 0)
          {
            if (com.tencent.mm.plugin.record.b.p.g(locala.dsC, locala.msgId)) {
              break label335;
            }
            ((h.a.b)localObject).xrW = locala.msgId;
            localBitmap = locala1.a((h.a.b)localObject);
            locala.xsN = true;
            localObject = localBitmap;
            if (localBitmap != null) {
              break label332;
            }
            localc.xrW = locala.msgId;
            localObject = locala1.a(localc);
            locala.xsN = false;
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(28006);
                a.this.a(a.5.this.xsW, a.5.this.xsX, this.rAH, ((com.tencent.mm.plugin.record.ui.a.a)a.5.this.xsV).xsN, a.5.this.xsV.dsC.dsU);
                AppMethodBeat.o(28006);
              }
            });
            AppMethodBeat.o(28007);
            return;
            if ((((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 1) && (bt.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.a)localObject).dsC.GgR)))
            {
              i = 2131691090;
              break;
            }
            label248:
            i = -1;
            break;
            if (locala.dataType == 1)
            {
              ((h.a.b)localObject).xrW = locala.prW.field_localId;
              ((h.a.b)localObject).dsG = false;
              localBitmap = locala1.a((h.a.b)localObject);
              locala.xsN = true;
              localObject = localBitmap;
              if (localBitmap == null)
              {
                localc.xrW = locala.prW.field_localId;
                localObject = locala1.a(localc);
                locala.xsN = false;
              }
            }
            else
            {
              localObject = null;
            }
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(28008);
        String str = super.toString() + "|fillView";
        AppMethodBeat.o(28008);
        return str;
      }
    });
    AppMethodBeat.o(28012);
  }
  
  final void a(ImageView paramImageView, ProgressBar paramProgressBar, Bitmap paramBitmap, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(193349);
    if (!((com.tencent.mm.plugin.record.ui.a.b)paramImageView.getTag()).dsC.dsU.equals(paramString))
    {
      ad.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[] { paramString, paramImageView.getTag() });
      AppMethodBeat.o(193349);
      return;
    }
    if (paramBitmap == null)
    {
      paramBitmap = paramImageView.getLayoutParams();
      paramBitmap.height = this.bjX;
      paramBitmap.width = this.bjX;
      paramImageView.setBackgroundResource(2131099649);
      paramProgressBar.setVisibility(0);
      AppMethodBeat.o(193349);
      return;
    }
    paramProgressBar.setVisibility(8);
    ad.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramImageView.getWidth()), Integer.valueOf(paramImageView.getHeight()) });
    paramString = paramImageView.getLayoutParams();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f;
    if (j >= i)
    {
      f = j / i;
      if (paramBoolean)
      {
        j = this.bjX;
        i = (int)(paramBitmap.getHeight() * j / paramBitmap.getWidth());
        paramProgressBar = paramBitmap;
        paramString.width = j;
        paramString.height = i;
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        q.A(paramImageView, j, i);
        if (paramImageView.getLayerType() == 1) {
          this.mListView.setLayerType(1, null);
        }
        paramImageView.setImageBitmap(paramProgressBar);
        paramImageView.setBackgroundResource(0);
        AppMethodBeat.o(193349);
        return;
      }
      if (f <= 2.5D) {
        break label530;
      }
      paramProgressBar = Bitmap.createBitmap(paramBitmap, 0, (paramBitmap.getHeight() - (int)(paramBitmap.getWidth() * 2.5F)) / 2, paramBitmap.getWidth(), (int)(paramBitmap.getWidth() * 2.5F));
      f = 2.5F;
    }
    for (;;)
    {
      if (f <= 2.0F)
      {
        i = com.tencent.mm.cc.a.ay(paramImageView.getContext(), 2131165213);
        j = (int)(i / f);
        break;
      }
      j = com.tencent.mm.cc.a.ay(paramImageView.getContext(), 2131165215);
      i = (int)(j * f);
      break;
      f = i / j;
      paramProgressBar = paramBitmap;
      if (f > 2.33F) {
        paramProgressBar = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - (int)(paramBitmap.getHeight() * 2.33F)) / 2, 0, (int)(paramBitmap.getHeight() * 2.33F), paramBitmap.getHeight());
      }
      if (paramBoolean)
      {
        j = this.bjX;
        i = (int)(paramProgressBar.getHeight() * j / paramProgressBar.getWidth());
        break;
      }
      if (f <= 2.0F)
      {
        j = com.tencent.mm.cc.a.ay(paramImageView.getContext(), 2131165213);
        i = (int)(j / f);
        break;
      }
      i = com.tencent.mm.cc.a.ay(paramImageView.getContext(), 2131165215);
      j = (int)(i * f);
      break;
      label530:
      paramProgressBar = paramBitmap;
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28011);
    View localView = View.inflate(paramContext, 2131495215, null);
    if (aj.getResources() != null) {}
    for (DisplayMetrics localDisplayMetrics = aj.getResources().getDisplayMetrics();; localDisplayMetrics = paramContext.getResources().getDisplayMetrics())
    {
      this.bjX = (localDisplayMetrics.widthPixels - com.tencent.mm.ui.aq.fromDPToPix(paramContext, 80));
      this.bjX = Math.max(this.bjX, 0);
      if (this.bjX == 0) {
        this.bjX = com.tencent.mm.ui.aq.fromDPToPix(paramContext, 320);
      }
      this.xsO = this.bjX;
      AppMethodBeat.o(28011);
      return localView;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28014);
    com.tencent.mm.sdk.b.a.IbL.d(this.rwO);
    AppMethodBeat.o(28014);
  }
  
  public final void pause() {}
  
  static final class a
  {
    boolean rAN = false;
    qe rwY;
    boolean xta;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a
 * JD-Core Version:    0.7.0.1
 */
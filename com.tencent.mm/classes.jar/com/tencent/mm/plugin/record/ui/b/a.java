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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qf.a;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
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
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements h.b
{
  private int bjX;
  private View.OnClickListener cNE;
  ScanCodeSheetItemLogic lAg;
  private ListView mListView;
  Map<String, a> rEW;
  private c rFa;
  e rIV;
  View.OnLongClickListener rIu;
  h.a xHR;
  int xIL;
  
  public a(h.a parama, ListView paramListView)
  {
    AppMethodBeat.i(28010);
    this.bjX = 0;
    this.rEW = new HashMap();
    this.cNE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28001);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        Object localObject2 = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        ae.d("justin", "ImageViewWrapper clickListener %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject2).dataType) });
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
          ((Intent)localObject1).putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dtI.dua);
          ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dFU);
          if (((paramAnonymousView.getContext() instanceof Activity)) && (((Activity)paramAnonymousView.getContext()).getIntent() != null))
          {
            localObject2 = ((Activity)paramAnonymousView.getContext()).getIntent().getBundleExtra("_stat_obj");
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("_stat_obj", (Bundle)localObject2);
            }
          }
          paramAnonymousView = paramAnonymousView.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).pyC.field_localId);
          ((Intent)localObject1).putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dtI.dua);
          com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject1, 1);
        }
      }
    };
    this.rIu = new View.OnLongClickListener()
    {
      private Context context;
      private String path;
      private g rBM;
      private com.tencent.mm.plugin.record.ui.a.b xIN;
      private ajx xIO;
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28004);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        if (paramAnonymousView != null)
        {
          this.context = paramAnonymousView.getContext();
          this.xIN = ((com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag());
          this.rBM = this.xIN.pyC;
          this.xIO = this.xIN.dtI;
        }
        paramAnonymousView = new gx();
        paramAnonymousView.dub.type = 2;
        paramAnonymousView.dub.dud = this.xIN.dtI;
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
        this.path = paramAnonymousView.duc.path;
        if (!o.fB(this.path))
        {
          ae.w("MicroMsg.ImageViewWrapper", "file not exists");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(28004);
          return true;
        }
        if (a.this.rIV == null) {
          a.this.rIV = new e(this.context, 1, false);
        }
        a.this.rIV.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(28002);
            paramAnonymous2l.clear();
            a.this.rIV.setFooterView(null);
            if (a.3.a(a.3.this).GAI == 0)
            {
              if (a.3.b(a.3.this).cwr()) {
                paramAnonymous2l.d(2, a.3.c(a.3.this).getString(2131759001));
              }
              if (a.3.b(a.3.this).cws()) {
                paramAnonymous2l.d(1, a.3.c(a.3.this).getString(2131758951));
              }
              paramAnonymous2l.d(3, a.3.c(a.3.this).getString(2131758994));
              paramAnonymous2l = (a.a)a.this.rEW.get(a.3.d(a.3.this));
              if ((paramAnonymous2l != null) && (paramAnonymous2l.rFk != null))
              {
                if (!bu.isNullOrNil(paramAnonymous2l.rFk.dFM.result))
                {
                  e locale = a.this.rIV;
                  a locala = a.this;
                  Object localObject = a.3.c(a.3.this);
                  qf localqf = paramAnonymous2l.rFk;
                  localObject = new a.4(locala, localqf, (Context)localObject);
                  if (!paramAnonymous2l.xIX)
                  {
                    paramAnonymous2l.xIX = true;
                    locala.lAg.bW(localqf.dFM.dov, localqf.dFM.result);
                  }
                  locale.setFooterView(locala.lAg.a((View.OnClickListener)localObject, localqf.dFM.dov, localqf.dFM.result, 5));
                  AppMethodBeat.o(28002);
                }
              }
              else
              {
                paramAnonymous2l = new qd();
                paramAnonymous2l.dFH.dmK = System.currentTimeMillis();
                paramAnonymous2l.dFH.filePath = a.3.d(a.3.this);
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymous2l);
              }
            }
            AppMethodBeat.o(28002);
          }
        };
        a.this.rIV.LfT = new n.e()
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
              String str = z.Br("fav_");
              z.aBG().F(str, true).k("prePublishId", "fav_");
              paramAnonymous2MenuItem.putExtra("reportSessionId", str);
              d.b(a.3.c(a.3.this), "sns", ".ui.SnsUploadUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.plugin.fav.a.b.a(a.3.d(a.3.this), a.3.c(a.3.this), a.3.e(a.3.this).dtI.ixk);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.platformtools.p.a(a.3.c(a.3.this), a.3.d(a.3.this), new p.a()
              {
                public final void bF(String paramAnonymous3String1, final String paramAnonymous3String2)
                {
                  AppMethodBeat.i(186621);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.aSY(paramAnonymous3String2) }), 1).show();
                  h.MqF.aO(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(186620);
                      String str = o.aRh(paramAnonymous3String2);
                      v localv = v.iQD;
                      v.bH(str, a.3.e(a.3.this).dtI.ixk);
                      AppMethodBeat.o(186620);
                    }
                  });
                  AppMethodBeat.o(186621);
                }
                
                public final void bG(String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  AppMethodBeat.i(186622);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(2131758993), 1).show();
                  AppMethodBeat.o(186622);
                }
              });
            }
          }
        };
        a.this.rIV.KtV = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(186623);
            a.this.lAg.onDismiss();
            AppMethodBeat.o(186623);
          }
        };
        a.this.rIV.cPF();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28004);
        return true;
      }
    };
    this.rFa = new c() {};
    this.xHR = parama;
    this.mListView = paramListView;
    com.tencent.mm.sdk.b.a.IvT.c(this.rFa);
    this.lAg = new ScanCodeSheetItemLogic(paramListView.getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bpT()
      {
        AppMethodBeat.i(28000);
        if ((a.this.rIV != null) && (a.this.rIV.isShowing())) {
          a.this.rIu.onLongClick(null);
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
    paramObject.setOnClickListener(this.cNE);
    if (paramb.dataType == 1) {
      paramObject.setOnLongClickListener(this.rIu);
    }
    h.a.b localb = new h.a.b();
    if (paramb.dataType == 0) {
      localb.xHT = paramb.msgId;
    }
    for (;;)
    {
      localb.dtI = paramb.dtI;
      localb.dtL = true;
      localb.maxWidth = this.bjX;
      Bitmap localBitmap = this.xHR.a(localb);
      if (localBitmap == null) {
        break;
      }
      ae.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[] { localb.dtI.dua, localBitmap });
      a(paramObject, paramView, localBitmap, true, paramb.dtI.dua);
      AppMethodBeat.o(28012);
      return;
      if (paramb.dataType == 1) {
        localb.xHT = paramb.pyC.field_localId;
      }
    }
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28007);
        Object localObject = (com.tencent.mm.plugin.record.ui.a.a)paramb;
        final int i;
        if (((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 0)
        {
          if (!com.tencent.mm.plugin.record.b.p.g(((com.tencent.mm.plugin.record.ui.a.a)localObject).dtI, ((com.tencent.mm.plugin.record.ui.a.a)localObject).msgId)) {
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
          h.a locala1 = a.this.xHR;
          int j = a.this.xIL;
          localObject = new h.a.b();
          ((h.a.b)localObject).dtI = locala.dtI;
          ((h.a.b)localObject).dtL = false;
          ((h.a.b)localObject).maxWidth = j;
          h.a.c localc = new h.a.c();
          localc.dtI = locala.dtI;
          Bitmap localBitmap;
          if (locala.dataType == 0)
          {
            if (com.tencent.mm.plugin.record.b.p.g(locala.dtI, locala.msgId)) {
              break label335;
            }
            ((h.a.b)localObject).xHT = locala.msgId;
            localBitmap = locala1.a((h.a.b)localObject);
            locala.xIK = true;
            localObject = localBitmap;
            if (localBitmap != null) {
              break label332;
            }
            localc.xHT = locala.msgId;
            localObject = locala1.a(localc);
            locala.xIK = false;
          }
          for (;;)
          {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(28006);
                a.this.a(a.5.this.xIT, a.5.this.xIU, this.rIS, ((com.tencent.mm.plugin.record.ui.a.a)a.5.this.xIS).xIK, a.5.this.xIS.dtI.dua);
                AppMethodBeat.o(28006);
              }
            });
            AppMethodBeat.o(28007);
            return;
            if ((((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 1) && (bu.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.a)localObject).dtI.GzA)))
            {
              i = 2131691090;
              break;
            }
            label248:
            i = -1;
            break;
            if (locala.dataType == 1)
            {
              ((h.a.b)localObject).xHT = locala.pyC.field_localId;
              ((h.a.b)localObject).dtM = false;
              localBitmap = locala1.a((h.a.b)localObject);
              locala.xIK = true;
              localObject = localBitmap;
              if (localBitmap == null)
              {
                localc.xHT = locala.pyC.field_localId;
                localObject = locala1.a(localc);
                locala.xIK = false;
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
    AppMethodBeat.i(186624);
    if (!((com.tencent.mm.plugin.record.ui.a.b)paramImageView.getTag()).dtI.dua.equals(paramString))
    {
      ae.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[] { paramString, paramImageView.getTag() });
      AppMethodBeat.o(186624);
      return;
    }
    if (paramBitmap == null)
    {
      paramBitmap = paramImageView.getLayoutParams();
      paramBitmap.height = this.bjX;
      paramBitmap.width = this.bjX;
      paramImageView.setBackgroundResource(2131099649);
      paramProgressBar.setVisibility(0);
      AppMethodBeat.o(186624);
      return;
    }
    paramProgressBar.setVisibility(8);
    ae.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramImageView.getWidth()), Integer.valueOf(paramImageView.getHeight()) });
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
        r.z(paramImageView, j, i);
        if (paramImageView.getLayerType() == 1) {
          this.mListView.setLayerType(1, null);
        }
        paramImageView.setImageBitmap(paramProgressBar);
        paramImageView.setBackgroundResource(0);
        AppMethodBeat.o(186624);
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
        i = com.tencent.mm.cb.a.ay(paramImageView.getContext(), 2131165213);
        j = (int)(i / f);
        break;
      }
      j = com.tencent.mm.cb.a.ay(paramImageView.getContext(), 2131165215);
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
        j = com.tencent.mm.cb.a.ay(paramImageView.getContext(), 2131165213);
        i = (int)(j / f);
        break;
      }
      i = com.tencent.mm.cb.a.ay(paramImageView.getContext(), 2131165215);
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
    if (ak.getResources() != null) {}
    for (DisplayMetrics localDisplayMetrics = ak.getResources().getDisplayMetrics();; localDisplayMetrics = paramContext.getResources().getDisplayMetrics())
    {
      this.bjX = (localDisplayMetrics.widthPixels - aq.fromDPToPix(paramContext, 80));
      this.bjX = Math.max(this.bjX, 0);
      if (this.bjX == 0) {
        this.bjX = aq.fromDPToPix(paramContext, 320);
      }
      this.xIL = this.bjX;
      AppMethodBeat.o(28011);
      return localView;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28014);
    com.tencent.mm.sdk.b.a.IvT.d(this.rFa);
    AppMethodBeat.o(28014);
  }
  
  public final void pause() {}
  
  static final class a
  {
    qf rFk;
    boolean rIY = false;
    boolean xIX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a
 * JD-Core Version:    0.7.0.1
 */
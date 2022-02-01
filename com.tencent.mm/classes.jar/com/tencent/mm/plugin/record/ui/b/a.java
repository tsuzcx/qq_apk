package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pl.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.RecordMsgImageUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements h.b
{
  private View.OnClickListener cEO;
  ScanCodeSheetItemLogic kxs;
  private ListView mListView;
  Map<String, a> qef;
  private c qej;
  View.OnLongClickListener qhH;
  e qii;
  h.a vbp;
  int vca;
  
  public a(h.a parama, ListView paramListView)
  {
    AppMethodBeat.i(28010);
    this.qef = new HashMap();
    this.cEO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28001);
        Object localObject2 = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        ad.d("justin", "ImageViewWrapper clickListener %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject2).dataType) });
        switch (((com.tencent.mm.plugin.record.ui.a.b)localObject2).dataType)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(28001);
          return;
          Object localObject1 = new Intent(paramAnonymousView.getContext(), RecordMsgImageUI.class);
          ((Intent)localObject1).putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).msgId);
          ((Intent)localObject1).putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).djJ.dkb);
          ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dvd);
          if (((paramAnonymousView.getContext() instanceof Activity)) && (((Activity)paramAnonymousView.getContext()).getIntent() != null))
          {
            localObject2 = ((Activity)paramAnonymousView.getContext()).getIntent().getBundleExtra("_stat_obj");
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("_stat_obj", (Bundle)localObject2);
            }
          }
          paramAnonymousView = paramAnonymousView.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(28001);
          return;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).okO.field_localId);
          ((Intent)localObject1).putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).djJ.dkb);
          com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject1, 1);
        }
      }
    };
    this.qhH = new View.OnLongClickListener()
    {
      private Context context;
      private String path;
      private g qaS;
      private com.tencent.mm.plugin.record.ui.a.b vcc;
      private afy vcd;
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28004);
        if (paramAnonymousView != null)
        {
          this.context = paramAnonymousView.getContext();
          this.vcc = ((com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag());
          this.qaS = this.vcc.okO;
          this.vcd = this.vcc.djJ;
        }
        paramAnonymousView = new gs();
        paramAnonymousView.dkc.type = 2;
        paramAnonymousView.dkc.dke = this.vcc.djJ;
        com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
        this.path = paramAnonymousView.dkd.path;
        if (!com.tencent.mm.vfs.i.eK(this.path))
        {
          ad.w("MicroMsg.ImageViewWrapper", "file not exists");
          AppMethodBeat.o(28004);
          return true;
        }
        if (a.this.qii == null) {
          a.this.qii = new e(this.context, 1, false);
        }
        a.this.qii.HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(28002);
            paramAnonymous2l.clear();
            a.this.qii.setFooterView(null);
            if (a.3.a(a.3.this).Dhh == 0)
            {
              if (a.3.b(a.3.this).chE()) {
                paramAnonymous2l.c(2, a.3.c(a.3.this).getString(2131759001));
              }
              if (a.3.b(a.3.this).chF()) {
                paramAnonymous2l.c(1, a.3.c(a.3.this).getString(2131758951));
              }
              paramAnonymous2l.c(3, a.3.c(a.3.this).getString(2131758994));
              paramAnonymous2l = (a.a)a.this.qef.get(a.3.d(a.3.this));
              if ((paramAnonymous2l != null) && (paramAnonymous2l.qet != null))
              {
                if (!bt.isNullOrNil(paramAnonymous2l.qet.dva.result))
                {
                  e locale = a.this.qii;
                  a locala = a.this;
                  Object localObject = a.3.c(a.3.this);
                  pl localpl = paramAnonymous2l.qet;
                  localObject = new a.4(locala, localpl, (Context)localObject);
                  if (!paramAnonymous2l.vcl)
                  {
                    paramAnonymous2l.vcl = true;
                    locala.kxs.bM(localpl.dva.deB, localpl.dva.result);
                  }
                  locale.setFooterView(locala.kxs.a((View.OnClickListener)localObject, localpl.dva.deB, localpl.dva.result, 5));
                  AppMethodBeat.o(28002);
                }
              }
              else
              {
                paramAnonymous2l = new pj();
                paramAnonymous2l.duX.dcQ = System.currentTimeMillis();
                paramAnonymous2l.duX.filePath = a.3.d(a.3.this);
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2l);
              }
            }
            AppMethodBeat.o(28002);
          }
        };
        a.this.qii.HrY = new n.d()
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
              String str = y.tD("fav_");
              y.arz().E(str, true).m("prePublishId", "fav_");
              paramAnonymous2MenuItem.putExtra("reportSessionId", str);
              d.b(a.3.c(a.3.this), "sns", ".ui.SnsUploadUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.plugin.fav.a.b.a(a.3.d(a.3.this), a.3.c(a.3.this), a.3.e(a.3.this).djJ.hAt);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.platformtools.p.a(a.3.c(a.3.this), a.3.d(a.3.this), new p.a()
              {
                public final void bv(String paramAnonymous3String1, final String paramAnonymous3String2)
                {
                  AppMethodBeat.i(191249);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(2131757969, new Object[] { paramAnonymous3String2 }), 1).show();
                  h.Iye.aP(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(191248);
                      String str = com.tencent.mm.vfs.i.aEN(paramAnonymous3String2);
                      v localv = v.hUC;
                      v.bx(str, a.3.e(a.3.this).djJ.hAt);
                      AppMethodBeat.o(191248);
                    }
                  });
                  AppMethodBeat.o(191249);
                }
                
                public final void bw(String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  AppMethodBeat.i(191250);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(2131758993), 1).show();
                  AppMethodBeat.o(191250);
                }
              });
            }
          }
        };
        a.this.qii.GHn = new e.b()
        {
          public final void onDismiss()
          {
            a.this.kxs.vLD = null;
          }
        };
        a.this.qii.csG();
        AppMethodBeat.o(28004);
        return true;
      }
    };
    this.qej = new c() {};
    this.vbp = parama;
    this.mListView = paramListView;
    com.tencent.mm.sdk.b.a.ESL.c(this.qej);
    this.kxs = new ScanCodeSheetItemLogic(paramListView.getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void beE()
      {
        AppMethodBeat.i(28000);
        if ((a.this.qii != null) && (a.this.qii.isShowing())) {
          a.this.qhH.onLongClick(null);
        }
        AppMethodBeat.o(28000);
      }
    });
    AppMethodBeat.o(28010);
  }
  
  public final void a(final View paramView, int paramInt, final com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28012);
    paramView = (ImageView)paramView.findViewById(2131303893);
    paramView.setTag(paramb);
    paramView.setOnClickListener(this.cEO);
    if (paramb.dataType == 1) {
      paramView.setOnLongClickListener(this.qhH);
    }
    paramObject = new h.a.b();
    if (paramb.dataType == 0) {
      paramObject.vbr = paramb.msgId;
    }
    for (;;)
    {
      paramObject.djJ = paramb.djJ;
      paramObject.djM = true;
      paramObject.maxWidth = this.vca;
      Bitmap localBitmap = this.vbp.a(paramObject);
      if (localBitmap == null) {
        break;
      }
      ad.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[] { paramObject.djJ.dkb, localBitmap });
      a(paramView, localBitmap, 2131690142, paramb.djJ.dkb);
      AppMethodBeat.o(28012);
      return;
      if (paramb.dataType == 1) {
        paramObject.vbr = paramb.okO.field_localId;
      }
    }
    h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28007);
        Object localObject = (com.tencent.mm.plugin.record.ui.a.a)paramb;
        final int i;
        if (((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 0)
        {
          if (!n.g(((com.tencent.mm.plugin.record.ui.a.a)localObject).djJ, ((com.tencent.mm.plugin.record.ui.a.a)localObject).msgId)) {
            break label236;
          }
          i = 2131691090;
          if (i != -1) {
            break label319;
          }
          i = 2131690142;
        }
        label311:
        label314:
        label319:
        for (;;)
        {
          com.tencent.mm.plugin.record.ui.a.a locala = (com.tencent.mm.plugin.record.ui.a.a)paramb;
          h.a locala1 = a.this.vbp;
          int j = a.this.vca;
          localObject = new h.a.b();
          ((h.a.b)localObject).djJ = locala.djJ;
          ((h.a.b)localObject).djM = false;
          ((h.a.b)localObject).maxWidth = j;
          h.a.c localc = new h.a.c();
          localc.djJ = locala.djJ;
          Bitmap localBitmap;
          if (locala.dataType == 0)
          {
            if (n.g(locala.djJ, locala.msgId)) {
              break label314;
            }
            ((h.a.b)localObject).vbr = locala.msgId;
            localBitmap = locala1.a((h.a.b)localObject);
            localObject = localBitmap;
            if (localBitmap != null) {
              break label311;
            }
            localc.vbr = locala.msgId;
            localObject = locala1.a(localc);
          }
          for (;;)
          {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(28006);
                a.this.a(a.5.this.vci, this.qif, i, a.5.this.vch.djJ.dkb);
                AppMethodBeat.o(28006);
              }
            });
            AppMethodBeat.o(28007);
            return;
            if ((((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 1) && (bt.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.a)localObject).djJ.DfZ)))
            {
              i = 2131691090;
              break;
            }
            label236:
            i = -1;
            break;
            if (locala.dataType == 1)
            {
              ((h.a.b)localObject).vbr = locala.okO.field_localId;
              ((h.a.b)localObject).djN = false;
              localBitmap = locala1.a((h.a.b)localObject);
              localObject = localBitmap;
              if (localBitmap == null)
              {
                localc.vbr = locala.okO.field_localId;
                localObject = locala1.a(localc);
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
  
  final void a(ImageView paramImageView, Bitmap paramBitmap, int paramInt, String paramString)
  {
    AppMethodBeat.i(28013);
    if (!((com.tencent.mm.plugin.record.ui.a.b)paramImageView.getTag()).djJ.dkb.equals(paramString))
    {
      ad.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[] { paramString, paramImageView.getTag() });
      AppMethodBeat.o(28013);
      return;
    }
    if (paramBitmap == null)
    {
      paramBitmap = paramImageView.getLayoutParams();
      paramBitmap.height = 200;
      paramBitmap.width = 280;
      paramImageView.setImageResource(paramInt);
      paramImageView.setBackgroundResource(2131100540);
      AppMethodBeat.o(28013);
      return;
    }
    ad.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramImageView.getWidth()), Integer.valueOf(paramImageView.getHeight()) });
    paramString = paramImageView.getLayoutParams();
    paramInt = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    float f;
    if (i >= paramInt)
    {
      f = i / paramInt;
      if (f <= 2.5D) {
        break label457;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, (paramBitmap.getHeight() - (int)(paramBitmap.getWidth() * 2.5F)) / 2, paramBitmap.getWidth(), (int)(paramBitmap.getWidth() * 2.5F));
      f = 2.5F;
    }
    label457:
    for (;;)
    {
      if (f <= 2.0F)
      {
        paramInt = com.tencent.mm.cd.a.ap(paramImageView.getContext(), 2131165213);
        i = (int)(paramInt / f);
      }
      for (;;)
      {
        paramString.width = i;
        paramString.height = paramInt;
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.tencent.mm.sdk.platformtools.p.z(paramImageView, i, paramInt);
        if (paramImageView.getLayerType() == 1) {
          this.mListView.setLayerType(1, null);
        }
        paramImageView.setImageBitmap(paramBitmap);
        paramImageView.setBackgroundResource(0);
        AppMethodBeat.o(28013);
        return;
        i = com.tencent.mm.cd.a.ap(paramImageView.getContext(), 2131165215);
        paramInt = (int)(i * f);
      }
      f = paramInt / i;
      if (f > 2.5D)
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - (int)(paramBitmap.getHeight() * 2.5F)) / 2, 0, (int)(paramBitmap.getHeight() * 2.5F), paramBitmap.getHeight());
        f = 2.5F;
      }
      for (;;)
      {
        if (f <= 2.0F)
        {
          i = com.tencent.mm.cd.a.ap(paramImageView.getContext(), 2131165213);
          paramInt = (int)(i / f);
          break;
        }
        paramInt = com.tencent.mm.cd.a.ap(paramImageView.getContext(), 2131165215);
        i = (int)(paramInt * f);
        break;
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28011);
    View localView = View.inflate(paramContext, 2131495215, null);
    this.vca = com.tencent.mm.cd.a.fromDPToPix(paramContext, 200);
    AppMethodBeat.o(28011);
    return localView;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28014);
    com.tencent.mm.sdk.b.a.ESL.d(this.qej);
    AppMethodBeat.o(28014);
  }
  
  public final void pause() {}
  
  static final class a
  {
    pl qet;
    boolean qil = false;
    boolean vcl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a
 * JD-Core Version:    0.7.0.1
 */
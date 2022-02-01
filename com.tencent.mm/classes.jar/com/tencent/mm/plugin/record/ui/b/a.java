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
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pu.a;
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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private View.OnClickListener cBW;
  ScanCodeSheetItemLogic kYG;
  private ListView mListView;
  Map<String, a> qMI;
  private c qMM;
  e qQK;
  View.OnLongClickListener qQj;
  int wkT;
  h.a wkd;
  
  public a(h.a parama, ListView paramListView)
  {
    AppMethodBeat.i(28010);
    this.qMI = new HashMap();
    this.cBW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28001);
        Object localObject2 = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        ac.d("justin", "ImageViewWrapper clickListener %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject2).dataType) });
        switch (((com.tencent.mm.plugin.record.ui.a.b)localObject2).dataType)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(28001);
          return;
          Object localObject1 = new Intent(paramAnonymousView.getContext(), RecordMsgImageUI.class);
          ((Intent)localObject1).putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).msgId);
          ((Intent)localObject1).putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dhe.dhw);
          ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dsP);
          if (((paramAnonymousView.getContext() instanceof Activity)) && (((Activity)paramAnonymousView.getContext()).getIntent() != null))
          {
            localObject2 = ((Activity)paramAnonymousView.getContext()).getIntent().getBundleExtra("_stat_obj");
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("_stat_obj", (Bundle)localObject2);
            }
          }
          paramAnonymousView = paramAnonymousView.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(28001);
          return;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).oOo.field_localId);
          ((Intent)localObject1).putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dhe.dhw);
          com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject1, 1);
        }
      }
    };
    this.qQj = new View.OnLongClickListener()
    {
      private Context context;
      private String path;
      private g qJy;
      private com.tencent.mm.plugin.record.ui.a.b wkV;
      private agx wkW;
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28004);
        if (paramAnonymousView != null)
        {
          this.context = paramAnonymousView.getContext();
          this.wkV = ((com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag());
          this.qJy = this.wkV.oOo;
          this.wkW = this.wkV.dhe;
        }
        paramAnonymousView = new gt();
        paramAnonymousView.dhx.type = 2;
        paramAnonymousView.dhx.dhz = this.wkV.dhe;
        com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
        this.path = paramAnonymousView.dhy.path;
        if (!com.tencent.mm.vfs.i.eA(this.path))
        {
          ac.w("MicroMsg.ImageViewWrapper", "file not exists");
          AppMethodBeat.o(28004);
          return true;
        }
        if (a.this.qQK == null) {
          a.this.qQK = new e(this.context, 1, false);
        }
        a.this.qQK.ISu = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(28002);
            paramAnonymous2l.clear();
            a.this.qQK.setFooterView(null);
            if (a.3.a(a.3.this).EAn == 0)
            {
              if (a.3.b(a.3.this).cpl()) {
                paramAnonymous2l.c(2, a.3.c(a.3.this).getString(2131759001));
              }
              if (a.3.b(a.3.this).cpm()) {
                paramAnonymous2l.c(1, a.3.c(a.3.this).getString(2131758951));
              }
              paramAnonymous2l.c(3, a.3.c(a.3.this).getString(2131758994));
              paramAnonymous2l = (a.a)a.this.qMI.get(a.3.d(a.3.this));
              if ((paramAnonymous2l != null) && (paramAnonymous2l.qMW != null))
              {
                if (!bs.isNullOrNil(paramAnonymous2l.qMW.dsM.result))
                {
                  e locale = a.this.qQK;
                  a locala = a.this;
                  Object localObject = a.3.c(a.3.this);
                  pu localpu = paramAnonymous2l.qMW;
                  localObject = new a.4(locala, localpu, (Context)localObject);
                  if (!paramAnonymous2l.wle)
                  {
                    paramAnonymous2l.wle = true;
                    locala.kYG.bP(localpu.dsM.dbX, localpu.dsM.result);
                  }
                  locale.setFooterView(locala.kYG.a((View.OnClickListener)localObject, localpu.dsM.dbX, localpu.dsM.result, 5));
                  AppMethodBeat.o(28002);
                }
              }
              else
              {
                paramAnonymous2l = new ps();
                paramAnonymous2l.dsJ.dao = System.currentTimeMillis();
                paramAnonymous2l.dsJ.filePath = a.3.d(a.3.this);
                com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2l);
              }
            }
            AppMethodBeat.o(28002);
          }
        };
        a.this.qQK.ISv = new n.d()
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
              String str = y.xJ("fav_");
              y.ayq().F(str, true).l("prePublishId", "fav_");
              paramAnonymous2MenuItem.putExtra("reportSessionId", str);
              d.b(a.3.c(a.3.this), "sns", ".ui.SnsUploadUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.plugin.fav.a.b.a(a.3.d(a.3.this), a.3.c(a.3.this), a.3.e(a.3.this).dhe.iaU);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.platformtools.p.a(a.3.c(a.3.this), a.3.d(a.3.this), new p.a()
              {
                public final void bD(String paramAnonymous3String1, final String paramAnonymous3String2)
                {
                  AppMethodBeat.i(196074);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.aLU(paramAnonymous3String2) }), 1).show();
                  h.JZN.aS(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(196073);
                      String str = com.tencent.mm.vfs.i.aKe(paramAnonymous3String2);
                      v localv = v.iuG;
                      v.bF(str, a.3.e(a.3.this).dhe.iaU);
                      AppMethodBeat.o(196073);
                    }
                  });
                  AppMethodBeat.o(196074);
                }
                
                public final void bE(String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  AppMethodBeat.i(196075);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(2131758993), 1).show();
                  AppMethodBeat.o(196075);
                }
              });
            }
          }
        };
        a.this.qQK.Ihj = new e.b()
        {
          public final void onDismiss()
          {
            a.this.kYG.wVE = null;
          }
        };
        a.this.qQK.cED();
        AppMethodBeat.o(28004);
        return true;
      }
    };
    this.qMM = new c() {};
    this.wkd = parama;
    this.mListView = paramListView;
    com.tencent.mm.sdk.b.a.GpY.c(this.qMM);
    this.kYG = new ScanCodeSheetItemLogic(paramListView.getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bly()
      {
        AppMethodBeat.i(28000);
        if ((a.this.qQK != null) && (a.this.qQK.isShowing())) {
          a.this.qQj.onLongClick(null);
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
    paramView.setOnClickListener(this.cBW);
    if (paramb.dataType == 1) {
      paramView.setOnLongClickListener(this.qQj);
    }
    paramObject = new h.a.b();
    if (paramb.dataType == 0) {
      paramObject.wkf = paramb.msgId;
    }
    for (;;)
    {
      paramObject.dhe = paramb.dhe;
      paramObject.dhh = true;
      paramObject.maxWidth = this.wkT;
      Bitmap localBitmap = this.wkd.a(paramObject);
      if (localBitmap == null) {
        break;
      }
      ac.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[] { paramObject.dhe.dhw, localBitmap });
      a(paramView, localBitmap, 2131690142, paramb.dhe.dhw);
      AppMethodBeat.o(28012);
      return;
      if (paramb.dataType == 1) {
        paramObject.wkf = paramb.oOo.field_localId;
      }
    }
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28007);
        Object localObject = (com.tencent.mm.plugin.record.ui.a.a)paramb;
        final int i;
        if (((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 0)
        {
          if (!n.g(((com.tencent.mm.plugin.record.ui.a.a)localObject).dhe, ((com.tencent.mm.plugin.record.ui.a.a)localObject).msgId)) {
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
          h.a locala1 = a.this.wkd;
          int j = a.this.wkT;
          localObject = new h.a.b();
          ((h.a.b)localObject).dhe = locala.dhe;
          ((h.a.b)localObject).dhh = false;
          ((h.a.b)localObject).maxWidth = j;
          h.a.c localc = new h.a.c();
          localc.dhe = locala.dhe;
          Bitmap localBitmap;
          if (locala.dataType == 0)
          {
            if (n.g(locala.dhe, locala.msgId)) {
              break label314;
            }
            ((h.a.b)localObject).wkf = locala.msgId;
            localBitmap = locala1.a((h.a.b)localObject);
            localObject = localBitmap;
            if (localBitmap != null) {
              break label311;
            }
            localc.wkf = locala.msgId;
            localObject = locala1.a(localc);
          }
          for (;;)
          {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(28006);
                a.this.a(a.5.this.wlb, this.qQH, i, a.5.this.wla.dhe.dhw);
                AppMethodBeat.o(28006);
              }
            });
            AppMethodBeat.o(28007);
            return;
            if ((((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 1) && (bs.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.a)localObject).dhe.Ezf)))
            {
              i = 2131691090;
              break;
            }
            label236:
            i = -1;
            break;
            if (locala.dataType == 1)
            {
              ((h.a.b)localObject).wkf = locala.oOo.field_localId;
              ((h.a.b)localObject).dhi = false;
              localBitmap = locala1.a((h.a.b)localObject);
              localObject = localBitmap;
              if (localBitmap == null)
              {
                localc.wkf = locala.oOo.field_localId;
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
    if (!((com.tencent.mm.plugin.record.ui.a.b)paramImageView.getTag()).dhe.dhw.equals(paramString))
    {
      ac.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[] { paramString, paramImageView.getTag() });
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
    ac.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramImageView.getWidth()), Integer.valueOf(paramImageView.getHeight()) });
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
        paramInt = com.tencent.mm.cc.a.av(paramImageView.getContext(), 2131165213);
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
        i = com.tencent.mm.cc.a.av(paramImageView.getContext(), 2131165215);
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
          i = com.tencent.mm.cc.a.av(paramImageView.getContext(), 2131165213);
          paramInt = (int)(i / f);
          break;
        }
        paramInt = com.tencent.mm.cc.a.av(paramImageView.getContext(), 2131165215);
        i = (int)(paramInt * f);
        break;
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28011);
    View localView = View.inflate(paramContext, 2131495215, null);
    this.wkT = com.tencent.mm.cc.a.fromDPToPix(paramContext, 200);
    AppMethodBeat.o(28011);
    return localView;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28014);
    com.tencent.mm.sdk.b.a.GpY.d(this.qMM);
    AppMethodBeat.o(28014);
  }
  
  public final void pause() {}
  
  static final class a
  {
    pu qMW;
    boolean qQN = false;
    boolean wle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a
 * JD-Core Version:    0.7.0.1
 */
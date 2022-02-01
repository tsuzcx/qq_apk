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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
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
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements h.b
{
  h.a BHR;
  int BIO;
  private View.OnClickListener dec;
  private int displayWidth;
  ScanCodeSheetItemLogic mHu;
  private ListView mListView;
  Map<String, a> teB;
  private IListener teF;
  e tiF;
  View.OnLongClickListener tib;
  
  public a(h.a parama, ListView paramListView)
  {
    AppMethodBeat.i(28010);
    this.displayWidth = 0;
    this.teB = new HashMap();
    this.dec = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28001);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        Object localObject2 = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        Log.d("justin", "ImageViewWrapper clickListener %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject2).dataType) });
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
          ((Intent)localObject1).putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dKT.dLl);
          ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dXH);
          if (((paramAnonymousView.getContext() instanceof Activity)) && (((Activity)paramAnonymousView.getContext()).getIntent() != null))
          {
            localObject2 = ((Activity)paramAnonymousView.getContext()).getIntent().getBundleExtra("_stat_obj");
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("_stat_obj", (Bundle)localObject2);
            }
          }
          paramAnonymousView = paramAnonymousView.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).qNT.field_localId);
          ((Intent)localObject1).putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).dKT.dLl);
          com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject1, 1);
        }
      }
    };
    this.tib = new View.OnLongClickListener()
    {
      private com.tencent.mm.plugin.record.ui.a.b BIQ;
      private aml BIR;
      private Context context;
      private String path;
      private g tbr;
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28004);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        if (paramAnonymousView != null)
        {
          this.context = paramAnonymousView.getContext();
          this.BIQ = ((com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag());
          this.tbr = this.BIQ.qNT;
          this.BIR = this.BIQ.dKT;
        }
        paramAnonymousView = new hb();
        paramAnonymousView.dLm.type = 2;
        paramAnonymousView.dLm.dLo = this.BIQ.dKT;
        EventCenter.instance.publish(paramAnonymousView);
        this.path = paramAnonymousView.dLn.path;
        if (!s.YS(this.path))
        {
          Log.w("MicroMsg.ImageViewWrapper", "file not exists");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(28004);
          return true;
        }
        if (a.this.tiF == null) {
          a.this.tiF = new e(this.context, 1, false);
        }
        a.this.tiF.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(28002);
            paramAnonymous2m.clear();
            a.this.tiF.setFooterView(null);
            if (a.3.a(a.3.this).Lwv == 0)
            {
              if (a.3.b(a.3.this).cUu()) {
                paramAnonymous2m.d(2, a.3.c(a.3.this).getString(2131759326));
              }
              if (a.3.b(a.3.this).cUv()) {
                paramAnonymous2m.d(1, a.3.c(a.3.this).getString(2131759275));
              }
              paramAnonymous2m.d(3, a.3.c(a.3.this).getString(2131759319));
              paramAnonymous2m = (a.a)a.this.teB.get(a.3.d(a.3.this));
              if ((paramAnonymous2m != null) && (paramAnonymous2m.teQ != null))
              {
                if (!Util.isNullOrNil(paramAnonymous2m.teQ.dXz.result))
                {
                  e locale = a.this.tiF;
                  a locala = a.this;
                  Object localObject = a.3.c(a.3.this);
                  qz localqz = paramAnonymous2m.teQ;
                  localObject = new a.4(locala, localqz, (Context)localObject);
                  if (!paramAnonymous2m.BJa)
                  {
                    paramAnonymous2m.BJa = true;
                    locala.mHu.cm(localqz.dXz.dFL, localqz.dXz.result);
                  }
                  locale.setFooterView(locala.mHu.a((View.OnClickListener)localObject, localqz.dXz.dFL, localqz.dXz.result, 5));
                  AppMethodBeat.o(28002);
                }
              }
              else
              {
                paramAnonymous2m = new qx();
                paramAnonymous2m.dXu.dDZ = System.currentTimeMillis();
                paramAnonymous2m.dXu.filePath = a.3.d(a.3.this);
                EventCenter.instance.publish(paramAnonymous2m);
              }
            }
            AppMethodBeat.o(28002);
          }
        };
        a.this.tiF.HLY = new o.g()
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
              String str = ad.JX("fav_");
              ad.aVe().G(str, true).l("prePublishId", "fav_");
              paramAnonymous2MenuItem.putExtra("reportSessionId", str);
              c.b(a.3.c(a.3.this), "sns", ".ui.SnsUploadUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.plugin.fav.a.b.a(a.3.d(a.3.this), a.3.c(a.3.this), a.3.e(a.3.this).dKT.jsz);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.platformtools.p.a(a.3.c(a.3.this), a.3.d(a.3.this), new p.a()
              {
                public final void bP(String paramAnonymous3String1, final String paramAnonymous3String2)
                {
                  AppMethodBeat.i(232048);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(2131758218, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous3String2) }), 1).show();
                  h.RTc.aX(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(232047);
                      String str = s.bhK(paramAnonymous3String2);
                      v localv = v.jNy;
                      v.bR(str, a.3.e(a.3.this).dKT.jsz);
                      AppMethodBeat.o(232047);
                    }
                  });
                  AppMethodBeat.o(232048);
                }
                
                public final void bQ(String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  AppMethodBeat.i(232049);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(2131759318), 1).show();
                  AppMethodBeat.o(232049);
                }
              });
            }
          }
        };
        a.this.tiF.PGl = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(232050);
            a.this.mHu.onDismiss();
            AppMethodBeat.o(232050);
          }
        };
        a.this.tiF.dGm();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28004);
        return true;
      }
    };
    this.teF = new IListener() {};
    this.BHR = parama;
    this.mListView = paramListView;
    EventCenter.instance.addListener(this.teF);
    this.mHu = new ScanCodeSheetItemLogic(paramListView.getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bLz()
      {
        AppMethodBeat.i(28000);
        if ((a.this.tiF != null) && (a.this.tiF.isShowing())) {
          a.this.tib.onLongClick(null);
        }
        AppMethodBeat.o(28000);
      }
    });
    AppMethodBeat.o(28010);
  }
  
  public final void a(final View paramView, int paramInt, final com.tencent.mm.plugin.record.ui.a.b paramb, final Object paramObject)
  {
    AppMethodBeat.i(28012);
    paramObject = (ImageView)paramView.findViewById(2131306722);
    paramView = (ProgressBar)paramView.findViewById(2131303709);
    paramObject.setTag(paramb);
    paramObject.setOnClickListener(this.dec);
    if (paramb.dataType == 1) {
      paramObject.setOnLongClickListener(this.tib);
    }
    h.a.b localb = new h.a.b();
    if (paramb.dataType == 0) {
      localb.BHU = paramb.msgId;
    }
    for (;;)
    {
      localb.dKT = paramb.dKT;
      localb.dKW = true;
      localb.maxWidth = this.displayWidth;
      Bitmap localBitmap = this.BHR.a(localb);
      if (localBitmap == null) {
        break;
      }
      Log.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[] { localb.dKT.dLl, localBitmap });
      a(paramObject, paramView, localBitmap, true, paramb.dKT.dLl);
      AppMethodBeat.o(28012);
      return;
      if (paramb.dataType == 1) {
        localb.BHU = paramb.qNT.field_localId;
      }
    }
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28007);
        Object localObject = (com.tencent.mm.plugin.record.ui.a.a)paramb;
        final int i;
        if (((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 0)
        {
          if (!com.tencent.mm.plugin.record.b.p.g(((com.tencent.mm.plugin.record.ui.a.a)localObject).dKT, ((com.tencent.mm.plugin.record.ui.a.a)localObject).msgId)) {
            break label248;
          }
          i = 2131691392;
          if (i != -1) {
            break label340;
          }
          i = 2131690179;
        }
        label332:
        label335:
        label340:
        for (;;)
        {
          com.tencent.mm.plugin.record.ui.a.a locala = (com.tencent.mm.plugin.record.ui.a.a)paramb;
          h.a locala1 = a.this.BHR;
          int j = a.this.BIO;
          localObject = new h.a.b();
          ((h.a.b)localObject).dKT = locala.dKT;
          ((h.a.b)localObject).dKW = false;
          ((h.a.b)localObject).maxWidth = j;
          h.a.c localc = new h.a.c();
          localc.dKT = locala.dKT;
          Bitmap localBitmap;
          if (locala.dataType == 0)
          {
            if (com.tencent.mm.plugin.record.b.p.g(locala.dKT, locala.msgId)) {
              break label335;
            }
            ((h.a.b)localObject).BHU = locala.msgId;
            localBitmap = locala1.a((h.a.b)localObject);
            locala.BIM = true;
            localObject = localBitmap;
            if (localBitmap != null) {
              break label332;
            }
            localc.BHU = locala.msgId;
            localObject = locala1.a(localc);
            locala.BIM = false;
          }
          for (;;)
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(28006);
                a.this.a(a.5.this.BIW, a.5.this.BIX, this.tiC, ((com.tencent.mm.plugin.record.ui.a.a)a.5.this.BIV).BIM, a.5.this.BIV.dKT.dLl);
                AppMethodBeat.o(28006);
              }
            });
            AppMethodBeat.o(28007);
            return;
            if ((((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 1) && (Util.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.a)localObject).dKT.KuR)))
            {
              i = 2131691392;
              break;
            }
            label248:
            i = -1;
            break;
            if (locala.dataType == 1)
            {
              ((h.a.b)localObject).BHU = locala.qNT.field_localId;
              ((h.a.b)localObject).dKX = false;
              localBitmap = locala1.a((h.a.b)localObject);
              locala.BIM = true;
              localObject = localBitmap;
              if (localBitmap == null)
              {
                localc.BHU = locala.qNT.field_localId;
                localObject = locala1.a(localc);
                locala.BIM = false;
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
    AppMethodBeat.i(232051);
    if (!((com.tencent.mm.plugin.record.ui.a.b)paramImageView.getTag()).dKT.dLl.equals(paramString))
    {
      Log.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[] { paramString, paramImageView.getTag() });
      AppMethodBeat.o(232051);
      return;
    }
    if (paramBitmap == null)
    {
      paramBitmap = paramImageView.getLayoutParams();
      paramBitmap.height = this.displayWidth;
      paramBitmap.width = this.displayWidth;
      paramImageView.setBackgroundResource(2131099649);
      paramProgressBar.setVisibility(0);
      AppMethodBeat.o(232051);
      return;
    }
    paramProgressBar.setVisibility(8);
    Log.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramImageView.getWidth()), Integer.valueOf(paramImageView.getHeight()) });
    paramString = paramImageView.getLayoutParams();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f;
    if (j >= i)
    {
      f = j / i;
      if (paramBoolean)
      {
        j = this.displayWidth;
        i = (int)(paramBitmap.getHeight() * j / paramBitmap.getWidth());
        paramProgressBar = paramBitmap;
        paramString.width = j;
        paramString.height = i;
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ForceGpuUtil.decideLayerType(paramImageView, j, i);
        if (paramImageView.getLayerType() == 1) {
          this.mListView.setLayerType(1, null);
        }
        paramImageView.setImageBitmap(paramProgressBar);
        paramImageView.setBackgroundResource(0);
        AppMethodBeat.o(232051);
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
        i = com.tencent.mm.cb.a.aH(paramImageView.getContext(), 2131165216);
        j = (int)(i / f);
        break;
      }
      j = com.tencent.mm.cb.a.aH(paramImageView.getContext(), 2131165218);
      i = (int)(j * f);
      break;
      f = i / j;
      paramProgressBar = paramBitmap;
      if (f > 2.33F) {
        paramProgressBar = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - (int)(paramBitmap.getHeight() * 2.33F)) / 2, 0, (int)(paramBitmap.getHeight() * 2.33F), paramBitmap.getHeight());
      }
      if (paramBoolean)
      {
        j = this.displayWidth;
        i = (int)(paramProgressBar.getHeight() * j / paramProgressBar.getWidth());
        break;
      }
      if (f <= 2.0F)
      {
        j = com.tencent.mm.cb.a.aH(paramImageView.getContext(), 2131165216);
        i = (int)(j / f);
        break;
      }
      i = com.tencent.mm.cb.a.aH(paramImageView.getContext(), 2131165218);
      j = (int)(i * f);
      break;
      label530:
      paramProgressBar = paramBitmap;
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28011);
    View localView = View.inflate(paramContext, 2131496058, null);
    if ((paramContext != null) && ((paramContext instanceof MMActivity))) {}
    for (DisplayMetrics localDisplayMetrics = ((MMActivity)paramContext).getOriginalResources().getDisplayMetrics();; localDisplayMetrics = MMApplicationContext.getResources().getDisplayMetrics())
    {
      this.displayWidth = (localDisplayMetrics.widthPixels - at.fromDPToPix(paramContext, 80));
      this.displayWidth = Math.max(this.displayWidth, 0);
      if (this.displayWidth == 0) {
        this.displayWidth = at.fromDPToPix(paramContext, 320);
      }
      this.BIO = this.displayWidth;
      AppMethodBeat.o(28011);
      return localView;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28014);
    EventCenter.instance.removeListener(this.teF);
    AppMethodBeat.o(28014);
  }
  
  public final void pause() {}
  
  static final class a
  {
    boolean BJa;
    qz teQ;
    boolean tiI = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a
 * JD-Core Version:    0.7.0.1
 */
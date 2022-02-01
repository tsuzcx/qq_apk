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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.rz;
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
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements h.b
{
  h.a HDY;
  int HEW;
  private View.OnClickListener dig;
  private int displayWidth;
  private ListView mListView;
  ScanCodeSheetItemLogic oxq;
  Map<String, a> wKN;
  private IListener wKS;
  e wOW;
  View.OnLongClickListener wOt;
  
  public a(h.a parama, ListView paramListView)
  {
    AppMethodBeat.i(28010);
    this.displayWidth = 0;
    this.wKN = new HashMap();
    this.dig = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28001);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
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
          ((Intent)localObject1).putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).fDI.fEa);
          ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).fRy);
          if (((paramAnonymousView.getContext() instanceof Activity)) && (((Activity)paramAnonymousView.getContext()).getIntent() != null))
          {
            localObject2 = ((Activity)paramAnonymousView.getContext()).getIntent().getBundleExtra("_stat_obj");
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("_stat_obj", (Bundle)localObject2);
            }
          }
          paramAnonymousView = paramAnonymousView.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).upg.field_localId);
          ((Intent)localObject1).putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).fDI.fEa);
          com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject1, 1);
        }
      }
    };
    this.wOt = new View.OnLongClickListener()
    {
      private com.tencent.mm.plugin.record.ui.a.b HEY;
      private anm HEZ;
      private Context context;
      private String path;
      private g wHw;
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28004);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        if (paramAnonymousView != null)
        {
          this.context = paramAnonymousView.getContext();
          this.HEY = ((com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag());
          this.wHw = this.HEY.upg;
          this.HEZ = this.HEY.fDI;
        }
        paramAnonymousView = new hi();
        paramAnonymousView.fEb.type = 2;
        paramAnonymousView.fEb.fEd = this.HEY.fDI;
        EventCenter.instance.publish(paramAnonymousView);
        this.path = paramAnonymousView.fEc.path;
        if (!u.agG(this.path))
        {
          Log.w("MicroMsg.ImageViewWrapper", "file not exists");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(28004);
          return true;
        }
        if (a.this.wOW == null) {
          a.this.wOW = new e(this.context, 1, false);
        }
        a.this.wOW.ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(28002);
            paramAnonymous2o.clear();
            a.this.wOW.setFooterView(null);
            if (a.3.a(a.3.this).SyU == 0)
            {
              if (a.3.b(a.3.this).djA()) {
                paramAnonymous2o.d(2, a.3.c(a.3.this).getString(R.l.favorite_share_with_friend));
              }
              if (a.3.b(a.3.this).djB()) {
                paramAnonymous2o.d(1, a.3.c(a.3.this).getString(R.l.favorite_post_to_sns));
              }
              paramAnonymous2o.d(3, a.3.c(a.3.this).getString(R.l.favorite_save_image));
              paramAnonymous2o = (a.a)a.this.wKN.get(a.3.d(a.3.this));
              if ((paramAnonymous2o != null) && (paramAnonymous2o.wLe != null))
              {
                Object localObject1 = com.tencent.mm.pluginsdk.ui.tools.p.RxG;
                if (!Util.isNullOrNil(com.tencent.mm.pluginsdk.ui.tools.p.d(paramAnonymous2o.wLe)))
                {
                  localObject1 = a.this.wOW;
                  a locala = a.this;
                  Object localObject2 = a.3.c(a.3.this);
                  rz localrz = paramAnonymous2o.wLe;
                  Object localObject3 = com.tencent.mm.pluginsdk.ui.tools.p.RxG;
                  localObject3 = com.tencent.mm.pluginsdk.ui.tools.p.d(localrz);
                  com.tencent.mm.pluginsdk.ui.tools.p localp = com.tencent.mm.pluginsdk.ui.tools.p.RxG;
                  int i = com.tencent.mm.pluginsdk.ui.tools.p.e(localrz);
                  localp = com.tencent.mm.pluginsdk.ui.tools.p.RxG;
                  localObject2 = new a.4(locala, localrz, (Context)localObject2, (String)localObject3, i, com.tencent.mm.pluginsdk.ui.tools.p.f(localrz));
                  if (!paramAnonymous2o.HFi)
                  {
                    paramAnonymous2o.HFi = true;
                    locala.oxq.cl(i, (String)localObject3);
                  }
                  ((e)localObject1).setFooterView(locala.oxq.a((View.OnClickListener)localObject2, i, (String)localObject3, 5));
                }
                AppMethodBeat.o(28002);
                return;
              }
              paramAnonymous2o = new rx();
              paramAnonymous2o.fRg.fwK = System.currentTimeMillis();
              paramAnonymous2o.fRg.filePath = a.3.d(a.3.this);
              EventCenter.instance.publish(paramAnonymous2o);
            }
            AppMethodBeat.o(28002);
          }
        };
        a.this.wOW.ODU = new q.g()
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
              String str = ad.Rp("fav_");
              ad.beh().I(str, true).k("prePublishId", "fav_");
              paramAnonymous2MenuItem.putExtra("reportSessionId", str);
              c.b(a.3.c(a.3.this), "sns", ".ui.SnsUploadUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.plugin.fav.a.b.a(a.3.d(a.3.this), a.3.c(a.3.this), a.3.e(a.3.this).fDI.mic);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.platformtools.p.a(a.3.c(a.3.this), a.3.d(a.3.this), new p.a()
              {
                public final void bT(String paramAnonymous3String1, final String paramAnonymous3String2)
                {
                  AppMethodBeat.i(269509);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(R.l.cropimage_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous3String2) }), 1).show();
                  h.ZvG.be(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(288275);
                      String str = u.buc(paramAnonymous3String2);
                      v localv = v.mEG;
                      v.bV(str, a.3.e(a.3.this).fDI.mic);
                      AppMethodBeat.o(288275);
                    }
                  });
                  AppMethodBeat.o(269509);
                }
                
                public final void bU(String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  AppMethodBeat.i(269510);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(R.l.favorite_save_fail), 1).show();
                  AppMethodBeat.o(269510);
                }
              });
            }
          }
        };
        a.this.wOW.XbB = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(265946);
            a.this.oxq.onDismiss();
            AppMethodBeat.o(265946);
          }
        };
        a.this.wOW.eik();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28004);
        return true;
      }
    };
    this.wKS = new IListener() {};
    this.HDY = parama;
    this.mListView = paramListView;
    EventCenter.instance.addListener(this.wKS);
    this.oxq = new ScanCodeSheetItemLogic(paramListView.getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bPS()
      {
        AppMethodBeat.i(28000);
        if ((a.this.wOW != null) && (a.this.wOW.isShowing())) {
          a.this.wOt.onLongClick(null);
        }
        AppMethodBeat.o(28000);
      }
    });
    AppMethodBeat.o(28010);
  }
  
  public final void a(final View paramView, int paramInt, final com.tencent.mm.plugin.record.ui.a.b paramb, final Object paramObject)
  {
    AppMethodBeat.i(28012);
    paramObject = (ImageView)paramView.findViewById(R.h.dSs);
    paramView = (ProgressBar)paramView.findViewById(R.h.loading_pb);
    paramObject.setTag(paramb);
    paramObject.setOnClickListener(this.dig);
    if (paramb.dataType == 1) {
      paramObject.setOnLongClickListener(this.wOt);
    }
    h.a.b localb = new h.a.b();
    if (paramb.dataType == 0) {
      localb.HEb = paramb.msgId;
    }
    for (;;)
    {
      localb.fDI = paramb.fDI;
      localb.fDL = true;
      localb.maxWidth = this.displayWidth;
      Bitmap localBitmap = this.HDY.a(localb);
      if (localBitmap == null) {
        break;
      }
      Log.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[] { localb.fDI.fEa, localBitmap });
      a(paramObject, paramView, localBitmap, true, paramb.fDI.fEa);
      AppMethodBeat.o(28012);
      return;
      if (paramb.dataType == 1) {
        localb.HEb = paramb.upg.field_localId;
      }
    }
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28007);
        Object localObject = (com.tencent.mm.plugin.record.ui.a.a)paramb;
        final int i;
        if (((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 0)
        {
          if (!com.tencent.mm.plugin.record.b.p.h(((com.tencent.mm.plugin.record.ui.a.a)localObject).fDI, ((com.tencent.mm.plugin.record.ui.a.a)localObject).msgId)) {
            break label251;
          }
          i = R.k.record_errpicture_icon;
          if (i != -1) {
            break label343;
          }
          i = R.k.fav_list_img_default;
        }
        label335:
        label338:
        label343:
        for (;;)
        {
          com.tencent.mm.plugin.record.ui.a.a locala = (com.tencent.mm.plugin.record.ui.a.a)paramb;
          h.a locala1 = a.this.HDY;
          int j = a.this.HEW;
          localObject = new h.a.b();
          ((h.a.b)localObject).fDI = locala.fDI;
          ((h.a.b)localObject).fDL = false;
          ((h.a.b)localObject).maxWidth = j;
          h.a.c localc = new h.a.c();
          localc.fDI = locala.fDI;
          Bitmap localBitmap;
          if (locala.dataType == 0)
          {
            if (com.tencent.mm.plugin.record.b.p.h(locala.fDI, locala.msgId)) {
              break label338;
            }
            ((h.a.b)localObject).HEb = locala.msgId;
            localBitmap = locala1.a((h.a.b)localObject);
            locala.HEU = true;
            localObject = localBitmap;
            if (localBitmap != null) {
              break label335;
            }
            localc.HEb = locala.msgId;
            localObject = locala1.a(localc);
            locala.HEU = false;
          }
          for (;;)
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(28006);
                a.this.a(a.5.this.HFe, a.5.this.HFf, this.wOT, ((com.tencent.mm.plugin.record.ui.a.a)a.5.this.HFd).HEU, a.5.this.HFd.fDI.fEa);
                AppMethodBeat.o(28006);
              }
            });
            AppMethodBeat.o(28007);
            return;
            if ((((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 1) && (Util.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.a)localObject).fDI.Rwb)))
            {
              i = R.k.record_errpicture_icon;
              break;
            }
            label251:
            i = -1;
            break;
            if (locala.dataType == 1)
            {
              ((h.a.b)localObject).HEb = locala.upg.field_localId;
              ((h.a.b)localObject).fDM = false;
              localBitmap = locala1.a((h.a.b)localObject);
              locala.HEU = true;
              localObject = localBitmap;
              if (localBitmap == null)
              {
                localc.HEb = locala.upg.field_localId;
                localObject = locala1.a(localc);
                locala.HEU = false;
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
    AppMethodBeat.i(292241);
    if (!((com.tencent.mm.plugin.record.ui.a.b)paramImageView.getTag()).fDI.fEa.equals(paramString))
    {
      Log.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[] { paramString, paramImageView.getTag() });
      AppMethodBeat.o(292241);
      return;
    }
    if (paramBitmap == null)
    {
      paramBitmap = paramImageView.getLayoutParams();
      paramBitmap.height = this.displayWidth;
      paramBitmap.width = this.displayWidth;
      paramImageView.setBackgroundResource(R.e.BG_1);
      paramProgressBar.setVisibility(0);
      AppMethodBeat.o(292241);
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
        AppMethodBeat.o(292241);
        return;
      }
      if (f <= 2.5D) {
        break label532;
      }
      paramProgressBar = Bitmap.createBitmap(paramBitmap, 0, (paramBitmap.getHeight() - (int)(paramBitmap.getWidth() * 2.5F)) / 2, paramBitmap.getWidth(), (int)(paramBitmap.getWidth() * 2.5F));
      f = 2.5F;
    }
    for (;;)
    {
      if (f <= 2.0F)
      {
        i = com.tencent.mm.ci.a.aZ(paramImageView.getContext(), R.f.ChatImgLimitWidth);
        j = (int)(i / f);
        break;
      }
      j = com.tencent.mm.ci.a.aZ(paramImageView.getContext(), R.f.ChatImgMinWidth);
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
        j = com.tencent.mm.ci.a.aZ(paramImageView.getContext(), R.f.ChatImgLimitWidth);
        i = (int)(j / f);
        break;
      }
      i = com.tencent.mm.ci.a.aZ(paramImageView.getContext(), R.f.ChatImgMinWidth);
      j = (int)(i * f);
      break;
      label532:
      paramProgressBar = paramBitmap;
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28011);
    View localView = View.inflate(paramContext, R.i.ekn, null);
    if ((paramContext != null) && ((paramContext instanceof MMActivity))) {}
    for (DisplayMetrics localDisplayMetrics = ((MMActivity)paramContext).getOriginalResources().getDisplayMetrics();; localDisplayMetrics = MMApplicationContext.getResources().getDisplayMetrics())
    {
      this.displayWidth = (localDisplayMetrics.widthPixels - aw.fromDPToPix(paramContext, 80));
      this.displayWidth = Math.max(this.displayWidth, 0);
      if (this.displayWidth == 0) {
        this.displayWidth = aw.fromDPToPix(paramContext, 320);
      }
      this.HEW = this.displayWidth;
      AppMethodBeat.o(28011);
      return localView;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28014);
    EventCenter.instance.removeListener(this.wKS);
    AppMethodBeat.o(28014);
  }
  
  public final void pause() {}
  
  static final class a
  {
    boolean HFi;
    rz wLe;
    boolean wOZ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a
 * JD-Core Version:    0.7.0.1
 */
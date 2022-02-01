package com.tencent.mm.plugin.record.ui.viewWrappers;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.plugin.record.ui.RecordMsgImageUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements h.b
{
  Map<String, a> Ahk;
  private IListener Ahp;
  View.OnLongClickListener AkV;
  com.tencent.mm.ui.widget.a.f Alz;
  h.a NBA;
  public int NBs;
  int NCy;
  private int displayWidth;
  private View.OnClickListener fhU;
  public int fromScene;
  private ListView mListView;
  ScanCodeSheetItemLogic rAP;
  
  public a(h.a parama, ListView paramListView)
  {
    AppMethodBeat.i(28010);
    this.displayWidth = 0;
    this.Ahk = new HashMap();
    this.NBs = -1;
    this.fromScene = -1;
    this.fhU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28001);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
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
          ((Intent)localObject1).putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).hIy.hIQ);
          ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).hXv);
          ((Intent)localObject1).putExtra("from_scene", a.this.fromScene);
          ((Intent)localObject1).putExtra("chatTypeForAppbrand", a.this.NBs);
          if (((paramAnonymousView.getContext() instanceof Activity)) && (((Activity)paramAnonymousView.getContext()).getIntent() != null))
          {
            localObject2 = ((Activity)paramAnonymousView.getContext()).getIntent().getBundleExtra("_stat_obj");
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("_stat_obj", (Bundle)localObject2);
            }
          }
          paramAnonymousView = paramAnonymousView.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).xvD.field_localId);
          ((Intent)localObject1).putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject2).hIy.hIQ);
          com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject1, 1);
        }
      }
    };
    this.AkV = new View.OnLongClickListener()
    {
      private g AdF;
      private com.tencent.mm.plugin.record.ui.a.b NCA;
      private arf NCB;
      private Context context;
      private String path;
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28004);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (paramAnonymousView != null)
        {
          this.context = paramAnonymousView.getContext();
          this.NCA = ((com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag());
          this.AdF = this.NCA.xvD;
          this.NCB = this.NCA.hIy;
        }
        paramAnonymousView = new ht();
        paramAnonymousView.hIR.type = 2;
        paramAnonymousView.hIR.hIT = this.NCA.hIy;
        paramAnonymousView.publish();
        this.path = paramAnonymousView.hIS.path;
        if (!y.ZC(this.path))
        {
          Log.w("MicroMsg.ImageViewWrapper", "file not exists");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(28004);
          return true;
        }
        if (a.this.Alz == null) {
          a.this.Alz = new com.tencent.mm.ui.widget.a.f(this.context, 1, false);
        }
        a.this.Alz.Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
          {
            AppMethodBeat.i(28002);
            paramAnonymous2s.clear();
            a.this.Alz.setFooterView(null);
            if (a.3.a(a.3.this).ZzM == 0)
            {
              if (a.3.b(a.3.this).dQl()) {
                paramAnonymous2s.c(2, a.3.c(a.3.this).getString(R.l.favorite_share_with_friend));
              }
              if (a.3.b(a.3.this).dQm()) {
                paramAnonymous2s.c(1, a.3.c(a.3.this).getString(R.l.favorite_post_to_sns));
              }
              paramAnonymous2s.c(3, a.3.c(a.3.this).getString(R.l.favorite_save_image));
              paramAnonymous2s = (a.a)a.this.Ahk.get(a.3.d(a.3.this));
              if ((paramAnonymous2s != null) && (paramAnonymous2s.AhB != null))
              {
                Object localObject1 = o.YtW;
                if (!Util.isNullOrNil(o.d(paramAnonymous2s.AhB)))
                {
                  localObject1 = a.this.Alz;
                  a locala = a.this;
                  Object localObject2 = a.3.c(a.3.this);
                  to localto = paramAnonymous2s.AhB;
                  Object localObject3 = o.YtW;
                  localObject3 = o.d(localto);
                  o localo = o.YtW;
                  int i = o.e(localto);
                  localo = o.YtW;
                  localObject2 = new a.4(locala, localto, (Context)localObject2, (String)localObject3, i, o.f(localto));
                  if (!paramAnonymous2s.NCK)
                  {
                    paramAnonymous2s.NCK = true;
                    locala.rAP.cW(i, (String)localObject3);
                  }
                  ((com.tencent.mm.ui.widget.a.f)localObject1).setFooterView(locala.rAP.a((View.OnClickListener)localObject2, i, (String)localObject3, 5));
                }
                AppMethodBeat.o(28002);
                return;
              }
              paramAnonymous2s = new tm();
              paramAnonymous2s.hXd.hBk = System.currentTimeMillis();
              paramAnonymous2s.hXd.filePath = a.3.d(a.3.this);
              paramAnonymous2s.publish();
            }
            AppMethodBeat.o(28002);
          }
        };
        a.this.Alz.GAC = new u.i()
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
              String str = ad.Jo("fav_");
              ad.bCb().M(str, true).q("prePublishId", "fav_");
              paramAnonymous2MenuItem.putExtra("reportSessionId", str);
              c.b(a.3.c(a.3.this), "sns", ".ui.SnsUploadUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(28003);
              return;
              com.tencent.mm.plugin.fav.a.b.a(a.3.d(a.3.this), a.3.c(a.3.this), a.3.e(a.3.this).hIy.pbn);
              AppMethodBeat.o(28003);
              return;
              ExportFileUtil.a(a.3.c(a.3.this), a.3.d(a.3.this), new ExportFileUtil.a()
              {
                public final void cg(String paramAnonymous3String1, final String paramAnonymous3String2)
                {
                  AppMethodBeat.i(305306);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(R.l.cropimage_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous3String2) }), 1).show();
                  h.ahAA.bm(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(305299);
                      String str = y.bub(paramAnonymous3String2);
                      com.tencent.mm.platformtools.s locals = com.tencent.mm.platformtools.s.pBi;
                      com.tencent.mm.platformtools.s.ci(str, a.3.e(a.3.this).hIy.pbn);
                      AppMethodBeat.o(305299);
                    }
                  });
                  AppMethodBeat.o(305306);
                }
                
                public final void ch(String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  AppMethodBeat.i(305308);
                  Toast.makeText(a.3.c(a.3.this), a.3.c(a.3.this).getString(R.l.favorite_save_fail), 1).show();
                  AppMethodBeat.o(305308);
                }
              });
            }
          }
        };
        a.this.Alz.aeLi = new f.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(305305);
            a.this.rAP.onDismiss();
            AppMethodBeat.o(305305);
          }
        };
        a.this.Alz.dDn();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28004);
        return true;
      }
    };
    this.Ahp = new ImageViewWrapper.6(this, com.tencent.mm.app.f.hfK);
    this.NBA = parama;
    this.mListView = paramListView;
    this.Ahp.alive();
    this.rAP = new ScanCodeSheetItemLogic(paramListView.getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void onFetchedCodeInfo()
      {
        AppMethodBeat.i(28000);
        if ((a.this.Alz != null) && (a.this.Alz.isShowing())) {
          a.this.AkV.onLongClick(null);
        }
        AppMethodBeat.o(28000);
      }
    });
    AppMethodBeat.o(28010);
  }
  
  public final void a(final View paramView, int paramInt, final com.tencent.mm.plugin.record.ui.a.b paramb, final Object paramObject)
  {
    AppMethodBeat.i(28012);
    paramObject = (ImageView)paramView.findViewById(R.h.fUs);
    paramView = (ProgressBar)paramView.findViewById(R.h.loading_pb);
    paramObject.setTag(paramb);
    paramObject.setOnClickListener(this.fhU);
    if (paramb.dataType == 1) {
      paramObject.setOnLongClickListener(this.AkV);
    }
    h.a.b localb = new h.a.b();
    if (paramb.dataType == 0) {
      localb.NBD = paramb.msgId;
    }
    for (;;)
    {
      localb.hIy = paramb.hIy;
      localb.hIB = true;
      localb.maxWidth = this.displayWidth;
      Bitmap localBitmap = this.NBA.a(localb);
      if (localBitmap == null) {
        break;
      }
      Log.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[] { localb.hIy.hIQ, localBitmap });
      a(paramObject, paramView, localBitmap, true, paramb.hIy.hIQ);
      AppMethodBeat.o(28012);
      return;
      if (paramb.dataType == 1) {
        localb.NBD = paramb.xvD.field_localId;
      }
    }
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28007);
        Object localObject = (com.tencent.mm.plugin.record.ui.a.a)paramb;
        final int i;
        if (((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 0)
        {
          if (!q.h(((com.tencent.mm.plugin.record.ui.a.a)localObject).hIy, ((com.tencent.mm.plugin.record.ui.a.a)localObject).msgId)) {
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
          h.a locala1 = a.this.NBA;
          int j = a.this.NCy;
          localObject = new h.a.b();
          ((h.a.b)localObject).hIy = locala.hIy;
          ((h.a.b)localObject).hIB = false;
          ((h.a.b)localObject).maxWidth = j;
          h.a.c localc = new h.a.c();
          localc.hIy = locala.hIy;
          Bitmap localBitmap;
          if (locala.dataType == 0)
          {
            if (q.h(locala.hIy, locala.msgId)) {
              break label338;
            }
            ((h.a.b)localObject).NBD = locala.msgId;
            localBitmap = locala1.a((h.a.b)localObject);
            locala.NCw = true;
            localObject = localBitmap;
            if (localBitmap != null) {
              break label335;
            }
            localc.NBD = locala.msgId;
            localObject = locala1.a(localc);
            locala.NCw = false;
          }
          for (;;)
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(28006);
                a.this.a(a.5.this.NCG, a.5.this.NCH, this.Alw, ((com.tencent.mm.plugin.record.ui.a.a)a.5.this.NCF).NCw, a.5.this.NCF.hIy.hIQ);
                AppMethodBeat.o(28006);
              }
            });
            AppMethodBeat.o(28007);
            return;
            if ((((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 1) && (Util.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.a)localObject).hIy.Ysw)))
            {
              i = R.k.record_errpicture_icon;
              break;
            }
            label251:
            i = -1;
            break;
            if (locala.dataType == 1)
            {
              ((h.a.b)localObject).NBD = locala.xvD.field_localId;
              ((h.a.b)localObject).hIC = false;
              localBitmap = locala1.a((h.a.b)localObject);
              locala.NCw = true;
              localObject = localBitmap;
              if (localBitmap == null)
              {
                localc.NBD = locala.xvD.field_localId;
                localObject = locala1.a(localc);
                locala.NCw = false;
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
    AppMethodBeat.i(305321);
    if (!((com.tencent.mm.plugin.record.ui.a.b)paramImageView.getTag()).hIy.hIQ.equals(paramString))
    {
      Log.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[] { paramString, paramImageView.getTag() });
      AppMethodBeat.o(305321);
      return;
    }
    if (paramBitmap == null)
    {
      paramBitmap = paramImageView.getLayoutParams();
      paramBitmap.height = this.displayWidth;
      paramBitmap.width = this.displayWidth;
      paramImageView.setBackgroundResource(R.e.BG_1);
      paramProgressBar.setVisibility(0);
      AppMethodBeat.o(305321);
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
        AppMethodBeat.o(305321);
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
        i = com.tencent.mm.cd.a.bs(paramImageView.getContext(), R.f.ChatImgLimitWidth);
        j = (int)(i / f);
        break;
      }
      j = com.tencent.mm.cd.a.bs(paramImageView.getContext(), R.f.ChatImgMinWidth);
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
        j = com.tencent.mm.cd.a.bs(paramImageView.getContext(), R.f.ChatImgLimitWidth);
        i = (int)(j / f);
        break;
      }
      i = com.tencent.mm.cd.a.bs(paramImageView.getContext(), R.f.ChatImgMinWidth);
      j = (int)(i * f);
      break;
      label532:
      paramProgressBar = paramBitmap;
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28011);
    View localView = View.inflate(paramContext, R.i.gns, null);
    if ((paramContext != null) && ((paramContext instanceof MMActivity))) {}
    for (DisplayMetrics localDisplayMetrics = ((MMActivity)paramContext).getOriginalResources().getDisplayMetrics();; localDisplayMetrics = MMApplicationContext.getResources().getDisplayMetrics())
    {
      this.displayWidth = (localDisplayMetrics.widthPixels - bd.fromDPToPix(paramContext, 80));
      this.displayWidth = Math.max(this.displayWidth, 0);
      if (this.displayWidth == 0) {
        this.displayWidth = bd.fromDPToPix(paramContext, 320);
      }
      this.NCy = this.displayWidth;
      AppMethodBeat.o(28011);
      return localView;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28014);
    this.Ahp.dead();
    AppMethodBeat.o(28014);
  }
  
  public final void pause() {}
  
  static final class a
  {
    to AhB;
    boolean AlB = false;
    boolean NCK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.viewWrappers.a
 * JD-Core Version:    0.7.0.1
 */
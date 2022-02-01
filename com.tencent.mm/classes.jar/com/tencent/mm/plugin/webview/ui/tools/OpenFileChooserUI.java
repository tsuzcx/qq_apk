package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.a.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class OpenFileChooserUI
  extends MMActivity
{
  private boolean Bdt;
  private int Bdu;
  private int Bdv;
  private boolean Bdw = false;
  private DialogInterface.OnCancelListener Bdx = null;
  private int cBh;
  private int count;
  private ProgressDialog fpP = null;
  private String jLZ;
  private String jMa;
  private int rHY;
  private int rHZ;
  
  private static boolean Iv(String paramString)
  {
    AppMethodBeat.i(79662);
    if (!TextUtils.isEmpty(paramString))
    {
      e locale = new e(paramString);
      ad.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", new Object[] { paramString });
      if (locale.exists())
      {
        ad.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
        AppMethodBeat.o(79662);
        return true;
      }
      ad.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
      AppMethodBeat.o(79662);
      return false;
    }
    ad.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
    AppMethodBeat.o(79662);
    return false;
  }
  
  private void axJ(final String paramString)
  {
    AppMethodBeat.i(79658);
    this.Bdx = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(175754);
        OpenFileChooserUI.this.setResult(0);
        OpenFileChooserUI.this.finish();
        AppMethodBeat.o(175754);
      }
    };
    getString(2131755906);
    this.fpP = h.b(this, getString(2131766101), true, this.Bdx);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175762);
        Object localObject1 = new ArrayList();
        int i = OpenFileChooserUI.a(OpenFileChooserUI.this, paramString);
        if (i == -50002)
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175756);
              if ((OpenFileChooserUI.b(OpenFileChooserUI.this) == 7) && (OpenFileChooserUI.c(OpenFileChooserUI.this) == 2))
              {
                h.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(2131766102), OpenFileChooserUI.this.getString(2131755906), OpenFileChooserUI.this.getString(2131755793), false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(175755);
                    OpenFileChooserUI.this.setResult(1);
                    OpenFileChooserUI.this.finish();
                    AppMethodBeat.o(175755);
                  }
                });
                AppMethodBeat.o(175756);
                return;
              }
              Toast.makeText(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(2131764675), 0).show();
              OpenFileChooserUI.this.setResult(1);
              OpenFileChooserUI.this.finish();
              AppMethodBeat.o(175756);
            }
          });
          AppMethodBeat.o(175762);
          return;
        }
        Object localObject2;
        if (i == -50006)
        {
          localObject1 = OpenFileChooserUI.z(paramString, (List)localObject1);
          OpenFileChooserUI.b(OpenFileChooserUI.this, paramString);
          localObject2 = OpenFileChooserUI.d(OpenFileChooserUI.this);
        }
        while (!bt.isNullOrNil((String)localObject1))
        {
          aq.f(new OpenFileChooserUI.8.4(this, (String)localObject1, (String)localObject2));
          AppMethodBeat.o(175762);
          return;
          if (i == 1)
          {
            String str1 = OpenFileChooserUI.c(OpenFileChooserUI.this, paramString);
            OpenFileChooserUI.b(OpenFileChooserUI.this, paramString);
            String str2 = OpenFileChooserUI.d(OpenFileChooserUI.this);
            localObject2 = str2;
            localObject1 = str1;
            if (bt.isNullOrNil(str1))
            {
              localObject2 = str2;
              localObject1 = str1;
              if (OpenFileChooserUI.b(OpenFileChooserUI.this) == 7)
              {
                localObject2 = str2;
                localObject1 = str1;
                if (OpenFileChooserUI.c(OpenFileChooserUI.this) == 2)
                {
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(175758);
                      h.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(2131766103), OpenFileChooserUI.this.getString(2131755906), OpenFileChooserUI.this.getString(2131755793), false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(175757);
                          OpenFileChooserUI.this.setResult(1);
                          OpenFileChooserUI.this.finish();
                          AppMethodBeat.o(175757);
                        }
                      });
                      AppMethodBeat.o(175758);
                    }
                  });
                  AppMethodBeat.o(175762);
                }
              }
            }
          }
          else
          {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(175759);
                OpenFileChooserUI.this.setResult(1);
                OpenFileChooserUI.this.finish();
                AppMethodBeat.o(175759);
              }
            });
            AppMethodBeat.o(175762);
            return;
          }
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175761);
            OpenFileChooserUI.this.setResult(1);
            OpenFileChooserUI.this.finish();
            AppMethodBeat.o(175761);
          }
        });
        AppMethodBeat.o(175762);
      }
    });
    AppMethodBeat.o(79658);
  }
  
  private String axK(String paramString)
  {
    AppMethodBeat.i(79659);
    try
    {
      com.tencent.mm.compatible.h.d locald = new com.tencent.mm.compatible.h.d();
      locald.setDataSource(paramString);
      if (locald == null)
      {
        AppMethodBeat.o(79659);
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { localException });
        localWebViewJSSDKVideoItem = null;
      }
      int i = bt.getInt(localWebViewJSSDKVideoItem.extractMetadata(18), 0);
      int j = bt.getInt(localWebViewJSSDKVideoItem.extractMetadata(19), 0);
      int k = bt.getInt(localWebViewJSSDKVideoItem.extractMetadata(9), 0);
      localWebViewJSSDKVideoItem.release();
      localWebViewJSSDKVideoItem.release();
      WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = WebViewJSSDKFileItem.aVZ(paramString);
      localWebViewJSSDKVideoItem.duration = ((k + 500) / 1000);
      localWebViewJSSDKVideoItem.width = i;
      localWebViewJSSDKVideoItem.height = j;
      localWebViewJSSDKVideoItem.size = ((int)i.aMN(paramString));
      if (this.Bdv == 1) {
        localWebViewJSSDKVideoItem.jMa = this.jMa;
      }
      com.tencent.mm.plugin.webview.modeltools.g.emF().a(localWebViewJSSDKVideoItem);
      paramString = localWebViewJSSDKVideoItem.diQ;
      AppMethodBeat.o(79659);
    }
    return paramString;
  }
  
  private int axL(String paramString)
  {
    AppMethodBeat.i(79660);
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse("file://".concat(String.valueOf(paramString))));
    ay.is2G(this);
    for (;;)
    {
      try
      {
        paramString = com.tencent.mm.compatible.h.a.j(this, (Intent)localObject);
        if (paramString == null)
        {
          ad.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
          AppMethodBeat.o(79660);
          return -50005;
        }
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.OpenFileChooserUI", paramString, "", new Object[0]);
        paramString = null;
        continue;
        localObject = paramString.filename;
        boolean bool = c.BH((String)localObject);
        ad.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
        i = -10000;
        if (bool)
        {
          i = SightVideoJNI.shouldRemuxingVFS((String)localObject, 660, 500, 26214400, 300000.0D, 1000000);
          ad.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", new Object[] { Integer.valueOf(i) });
        }
        if ((i == -1) || (!bool))
        {
          i = (int)i.aMN((String)localObject);
          ad.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", new Object[] { Integer.valueOf(i) });
          if (i > 26214400) {
            i = -1;
          }
        }
        else
        {
          switch (i)
          {
          default: 
            ad.e("MicroMsg.OpenFileChooserUI", "unknown check type");
            AppMethodBeat.o(79660);
            return -50001;
          }
        }
      }
      i = 1;
    }
    int j = 0;
    for (int i = 1;; i = 0)
    {
      if (j != 0) {
        i = -50006;
      }
      ad.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramString.duration / 1000) });
      AppMethodBeat.o(79660);
      return i;
      j = 1;
    }
    AppMethodBeat.o(79660);
    return -50002;
  }
  
  private boolean enD()
  {
    AppMethodBeat.i(79654);
    ad.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", new Object[] { Long.valueOf(bt.iJ(this)) });
    if (bt.iJ(this) <= 200L)
    {
      AppMethodBeat.o(79654);
      return false;
    }
    AppMethodBeat.o(79654);
    return true;
  }
  
  private SightParams rQ(int paramInt)
  {
    AppMethodBeat.i(79655);
    String str1 = "microMsg_" + System.currentTimeMillis();
    this.jLZ = (b.ais() + str1 + ".mp4");
    this.jMa = (b.ais() + str1 + ".jpeg");
    int j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
    SightParams localSightParams = new SightParams(3, 1);
    if (this.Bdu == 16) {}
    for (int i = 1;; i = 2)
    {
      localSightParams.tAY = i;
      localSightParams.mode = paramInt;
      if (localSightParams.gCB == null) {
        localSightParams.gCB = new VideoTransPara();
      }
      localSightParams.gCB.duration = j;
      String str2 = b.ais() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
      localSightParams.p(str1, this.jLZ, this.jMa, str2);
      AppMethodBeat.o(79655);
      return localSightParams;
    }
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    AppMethodBeat.i(79657);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      paramIntent = new Intent();
      paramIntent.putExtra("key_pick_local_media_show_memory_warning", this.Bdw);
      setResult(paramInt2, paramIntent);
      finish();
      AppMethodBeat.o(79657);
      return;
    }
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      ad.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", new Object[] { Integer.valueOf(paramInt1) });
      setResult(1);
      finish();
      AppMethodBeat.o(79657);
      return;
    case 1: 
    case 3: 
      com.tencent.mm.plugin.webview.a.a.ae(new OpenFileChooserUI.6(this, paramIntent, paramInt2));
      AppMethodBeat.o(79657);
      return;
    case 2: 
      localObject1 = q.h(getContext().getApplicationContext(), paramIntent, b.ais());
      if (bt.isNullOrNil((String)localObject1))
      {
        ad.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
        setResult(-2, paramIntent);
        finish();
        AppMethodBeat.o(79657);
        return;
      }
      ad.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", new Object[] { localObject1 });
      paramIntent = new Intent();
      paramIntent.putExtra("key_send_raw_image", this.Bdt);
      paramIntent.putExtra("max_select_count", this.cBh);
      paramIntent.putExtra("query_source_type", this.rHY);
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(localObject1);
      paramIntent.putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      paramIntent.putExtra("preview_image", true);
      paramIntent.addFlags(67108864);
      com.tencent.mm.bs.d.b(this, "gallery", ".ui.GalleryEntryUI", paramIntent, 3);
      AppMethodBeat.o(79657);
      return;
    case 5: 
      if (new e(this.jLZ).exists())
      {
        axJ(this.jLZ);
        AppMethodBeat.o(79657);
        return;
      }
      ad.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", new Object[] { this.jLZ });
      setResult(1);
      finish();
      AppMethodBeat.o(79657);
      return;
    case 4: 
      paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        ad.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
        setResult(1);
        finish();
        AppMethodBeat.o(79657);
        return;
      }
      ad.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
      ad.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { paramIntent.get(0) });
      if ((this.Bdv == 1) && (!Iv(this.jMa))) {
        ad.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
      }
      axJ((String)paramIntent.get(0));
      AppMethodBeat.o(79657);
      return;
    case 6: 
      ad.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
      if (paramIntent != null)
      {
        ad.i("MicroMsg.OpenFileChooserUI", "data is valid!");
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          ad.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
          setResult(1);
          finish();
          AppMethodBeat.o(79657);
          return;
        }
        this.jLZ = paramIntent.tAR;
        ad.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.jLZ });
        if ((!Iv(this.jMa)) && (Iv(paramIntent.tAS))) {
          this.jMa = paramIntent.tAS;
        }
        paramIntent = (Intent)localObject1;
        if (!TextUtils.isEmpty(this.jLZ)) {
          paramIntent = new e(this.jLZ);
        }
        if ((paramIntent != null) && (paramIntent.exists()))
        {
          ad.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.jLZ });
          axJ(this.jLZ);
          AppMethodBeat.o(79657);
          return;
        }
        ad.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.jLZ });
      }
      ad.e("MicroMsg.OpenFileChooserUI", "data is null!");
      setResult(1);
      finish();
      AppMethodBeat.o(79657);
      return;
    case 7: 
      ad.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
      if (paramIntent != null)
      {
        ad.i("MicroMsg.OpenFileChooserUI", "data is valid!");
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          ad.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
          setResult(1);
          finish();
          AppMethodBeat.o(79657);
          return;
        }
        if (paramIntent.tAP)
        {
          paramIntent = paramIntent.tAX;
          if (bt.isNullOrNil(paramIntent))
          {
            ad.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", new Object[] { paramIntent });
            setResult(1);
            finish();
            AppMethodBeat.o(79657);
            return;
          }
          localObject1 = new ArrayList();
          localObject2 = WebViewJSSDKFileItem.aVX(paramIntent);
          ((WebViewJSSDKFileItem)localObject2).jay = true;
          ((WebViewJSSDKFileItem)localObject2).mediaType = 1;
          com.tencent.mm.plugin.webview.modeltools.g.emF().a((WebViewJSSDKFileItem)localObject2);
          ((ArrayList)localObject1).add(((WebViewJSSDKFileItem)localObject2).diQ);
          ad.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", new Object[] { paramIntent, ((WebViewJSSDKFileItem)localObject2).diQ });
          paramIntent = aw.aA((ArrayList)localObject1);
          ad.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { paramIntent });
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_pick_local_media_local_ids", paramIntent);
          ((Intent)localObject1).putExtra("key_pick_local_media_callback_type", 2);
          setResult(paramInt2, (Intent)localObject1);
          finish();
          AppMethodBeat.o(79657);
          return;
        }
        this.jLZ = paramIntent.tAR;
        ad.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.jLZ });
        if ((!Iv(this.jMa)) && (Iv(paramIntent.tAS))) {
          this.jMa = paramIntent.tAS;
        }
        if (TextUtils.isEmpty(this.jLZ)) {
          break label1442;
        }
      }
      break;
    }
    label1442:
    for (paramIntent = new e(this.jLZ);; paramIntent = null)
    {
      if ((paramIntent != null) && (paramIntent.exists()))
      {
        ad.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.jLZ });
        axJ(this.jLZ);
        AppMethodBeat.o(79657);
        return;
      }
      ad.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.jLZ });
      ad.e("MicroMsg.OpenFileChooserUI", "data is null!");
      setResult(1);
      finish();
      AppMethodBeat.o(79657);
      return;
      ad.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
      localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        axJ((String)((ArrayList)localObject1).get(0));
        AppMethodBeat.o(79657);
        return;
      }
      localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      boolean bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      if (localObject1 == null)
      {
        ad.e("MicroMsg.OpenFileChooserUI", "chosen is null");
        setResult(1);
        finish();
        AppMethodBeat.o(79657);
        return;
      }
      paramIntent = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        WebViewJSSDKFileItem localWebViewJSSDKFileItem = WebViewJSSDKFileItem.aVX((String)localObject2);
        String str = localWebViewJSSDKFileItem.diQ;
        localWebViewJSSDKFileItem.jay = bool;
        com.tencent.mm.plugin.webview.modeltools.g.emF().a(localWebViewJSSDKFileItem);
        ad.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[] { localObject2, str });
        paramIntent.add(str);
      }
      paramIntent = aw.aA(paramIntent);
      ad.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { paramIntent });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_pick_local_media_local_ids", paramIntent);
      ((Intent)localObject1).putExtra("key_pick_local_media_show_memory_warning", this.Bdw);
      ((Intent)localObject1).putExtra("key_pick_local_media_callback_type", 2);
      setResult(paramInt2, (Intent)localObject1);
      finish();
      AppMethodBeat.o(79657);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 3;
    AppMethodBeat.i(79653);
    super.onCreate(paramBundle);
    this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
    if ((this.count <= 0) || (this.count > 9)) {
      this.count = 9;
    }
    this.cBh = this.count;
    this.rHY = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
    this.rHZ = getIntent().getIntExtra("query_media_type", 1);
    this.Bdt = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
    this.Bdu = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
    this.Bdv = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
    int j;
    label378:
    String str;
    if (((this.rHY == 7) && (this.rHZ == 2)) || (this.rHZ == 3))
    {
      if (!enD())
      {
        t.makeText(this, getString(2131766118), 1).show();
        this.Bdw = true;
      }
      paramBundle = new Intent();
      paramBundle.putExtra("key_send_raw_image", this.Bdt);
      paramBundle.putExtra("query_media_type", this.rHZ);
      if (this.Bdv == 1) {
        if ((this.Bdu != 4096) && ((this.Bdu & 0x1000) > 0))
        {
          i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
          j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
          paramBundle.putExtra("KEY_SIGHT_PARAMS", rQ(1));
          paramBundle.putExtra("record_video_force_sys_camera", false);
          paramBundle.putExtra("show_header_view", true);
          paramBundle.putExtra("record_video_is_sight_capture", true);
          paramBundle.putExtra("record_video_quality", i);
          paramBundle.putExtra("record_video_time_limit", j);
          paramBundle.putExtra("video_full_path", this.jLZ);
          q.d(this, this.cBh, this.rHY, paramBundle);
        }
      }
      for (;;)
      {
        if ((this.Bdu != 4096) && ((this.Bdu & 0x1000) > 0))
        {
          i = 1;
          if (i == 0) {
            break label1082;
          }
          AppMethodBeat.o(79653);
          return;
          if ((this.Bdu == 16) || (this.Bdu == 256))
          {
            paramBundle.putExtra("KEY_SIGHT_PARAMS", rQ(1));
            q.a(this, 6, paramBundle, 3, 1);
          }
          else if (this.Bdu == 4096)
          {
            paramBundle.putExtra("show_header_view", false);
            q.d(this, this.cBh, this.rHY, paramBundle);
            continue;
            if (this.Bdv == 2)
            {
              str = bt.nullAsNil(getIntent().getStringExtra("key_pick_local_media_sight_type"));
              if ((this.Bdu != 4096) && ((this.Bdu & 0x1000) > 0))
              {
                ad.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
                setResult(1);
                finish();
                continue;
              }
              if ((this.Bdu == 16) || (this.Bdu == 256)) {
                if ((str.contains("video")) && (str.contains("image"))) {
                  i = 0;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramBundle.putExtra("KEY_SIGHT_PARAMS", rQ(i));
      q.a(this, 7, paramBundle, 3, i);
      break;
      if (str.contains("video"))
      {
        i = 1;
      }
      else
      {
        if (str.contains("image"))
        {
          i = 2;
          continue;
          if (this.Bdu != 4096) {
            break;
          }
          if ((str.contains("image")) && (str.contains("video"))) {}
          for (;;)
          {
            paramBundle = new Intent();
            paramBundle.putExtra("key_can_select_video_and_pic", true);
            paramBundle.putExtra("key_send_raw_image", this.Bdt);
            q.a(this, 8, this.cBh, this.rHY, i, paramBundle);
            break;
            if (str.contains("image")) {
              i = 1;
            } else if (str.contains("video")) {
              i = 2;
            }
          }
          if ((this.Bdu != 4096) && ((this.Bdu & 0x1000) > 0))
          {
            this.jLZ = (b.ais() + "microMsg." + System.currentTimeMillis() + ".mp4");
            i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
            j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
            paramBundle.putExtra("record_video_force_sys_camera", true);
            paramBundle.putExtra("record_video_quality", i);
            paramBundle.putExtra("record_video_time_limit", j);
            paramBundle.putExtra("video_full_path", this.jLZ);
            q.d(this, this.cBh, this.rHY, paramBundle);
            break;
          }
          if ((this.Bdu == 16) || (this.Bdu == 256))
          {
            this.jLZ = (b.ais() + "microMsg." + System.currentTimeMillis() + ".mp4");
            i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
            j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
            paramBundle = this.jLZ;
            if (this.Bdu == 16) {}
            for (boolean bool = true;; bool = false)
            {
              q.a(this, paramBundle, 5, j, i, bool);
              break;
            }
          }
          if (this.Bdu != 4096) {
            break;
          }
          paramBundle.putExtra("show_header_view", false);
          q.d(this, this.cBh, this.rHY, paramBundle);
          break;
          if ((this.Bdu == 16) || (this.Bdu == 256))
          {
            i = 1;
            break label378;
          }
          if (this.Bdu == 4096)
          {
            i = 1;
            break label378;
          }
          i = 0;
          break label378;
          label1082:
          if (!enD())
          {
            t.makeText(this, getString(2131766118), 1).show();
            this.Bdw = true;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("key_send_raw_image", this.Bdt);
          paramBundle.putExtra("query_media_type", this.rHZ);
          switch (this.Bdu)
          {
          default: 
            ad.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
            setResult(0);
            finish();
            AppMethodBeat.o(79653);
            return;
          case 1: 
            paramBundle.putExtra("show_header_view", false);
            q.a(this, 1, this.cBh, this.rHY, paramBundle);
            AppMethodBeat.o(79653);
            return;
          case 2: 
            paramBundle = new com.tencent.mm.ui.tools.l(this);
            paramBundle.HrX = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
              {
                AppMethodBeat.i(175749);
                paramAnonymousl.c(1, OpenFileChooserUI.this.getString(2131766108));
                AppMethodBeat.o(175749);
              }
            };
            paramBundle.HrY = new OpenFileChooserUI.2(this);
            paramBundle.a(new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(175751);
                ad.v("MicroMsg.OpenFileChooserUI", "alvinluo onDismiss");
                OpenFileChooserUI.this.setResult(0);
                OpenFileChooserUI.this.finish();
                AppMethodBeat.o(175751);
              }
            });
            paramBundle.a(new e.a()
            {
              public final void onClick()
              {
                AppMethodBeat.i(175752);
                ad.v("MicroMsg.OpenFileChooserUI", "alvinluo cancel onClick");
                OpenFileChooserUI.this.setResult(0);
                OpenFileChooserUI.this.finish();
                AppMethodBeat.o(175752);
              }
            });
            paramBundle.fdQ();
            AppMethodBeat.o(79653);
            return;
          }
          q.a(this, 1, this.count, this.rHY, paramBundle);
          AppMethodBeat.o(79653);
          return;
        }
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79661);
    super.onDestroy();
    if ((this.fpP != null) && (this.fpP.isShowing())) {
      this.fpP.dismiss();
    }
    AppMethodBeat.o(79661);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(79656);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(79656);
      return;
    }
    ad.i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79656);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        q.d(getContext(), b.ais(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        AppMethodBeat.o(79656);
        return;
      }
      h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new OpenFileChooserUI.5(this), null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI
 * JD-Core Version:    0.7.0.1
 */
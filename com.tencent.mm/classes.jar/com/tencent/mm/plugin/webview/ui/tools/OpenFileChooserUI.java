package com.tencent.mm.plugin.webview.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.a.a;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class OpenFileChooserUI
  extends MMActivity
{
  private int HMO;
  private boolean HPO;
  private int RFZ;
  private boolean RfR;
  private int WSH;
  private int WSI;
  private String WSJ;
  private boolean WSK = false;
  private DialogInterface.OnCancelListener WSL = null;
  private int count;
  private ProgressDialog lzP = null;
  private int mpb;
  private String rPL;
  private String rPM;
  
  private static boolean aaS(String paramString)
  {
    AppMethodBeat.i(79662);
    if (!TextUtils.isEmpty(paramString))
    {
      u localu = new u(paramString);
      Log.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", new Object[] { paramString });
      if (localu.jKS())
      {
        Log.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
        AppMethodBeat.o(79662);
        return true;
      }
      Log.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
      AppMethodBeat.o(79662);
      return false;
    }
    Log.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
    AppMethodBeat.o(79662);
    return false;
  }
  
  private SightParams auj(int paramInt)
  {
    AppMethodBeat.i(79655);
    String str1 = "microMsg_" + System.currentTimeMillis();
    this.rPL = (ivz() + str1 + ".mp4");
    this.rPM = (ivz() + str1 + ".jpeg");
    int j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
    SightParams localSightParams = new SightParams(3, 1);
    if (this.WSH == 16) {}
    for (int i = 1;; i = 2)
    {
      localSightParams.KTU = i;
      localSightParams.mode = paramInt;
      if (localSightParams.nLH == null) {
        localSightParams.nLH = new VideoTransPara();
      }
      localSightParams.nLH.duration = j;
      String str2 = ivz() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
      localSightParams.D(str1, this.rPL, this.rPM, str2);
      AppMethodBeat.o(79655);
      return localSightParams;
    }
  }
  
  private int blA(String paramString)
  {
    AppMethodBeat.i(79660);
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse("file://".concat(String.valueOf(paramString))));
    for (;;)
    {
      try
      {
        paramString = com.tencent.mm.compatible.i.a.j(this, (Intent)localObject);
        if (paramString == null)
        {
          Log.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
          AppMethodBeat.o(79660);
          return -50005;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.OpenFileChooserUI", paramString, "", new Object[0]);
        paramString = null;
        continue;
        localObject = paramString.filename;
        boolean bool = com.tencent.mm.plugin.a.c.Sm((String)localObject);
        Log.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
        i = -10000;
        if (bool)
        {
          i = SightVideoJNI.shouldRemuxingVFS((String)localObject, 660, 500, 26214400, 300000.0D, 1000000);
          Log.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", new Object[] { Integer.valueOf(i) });
        }
        if ((i == -1) || (!bool))
        {
          i = (int)y.bEl((String)localObject);
          Log.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", new Object[] { Integer.valueOf(i) });
          if (i > 26214400) {
            i = -1;
          }
        }
        else
        {
          switch (i)
          {
          default: 
            Log.e("MicroMsg.OpenFileChooserUI", "unknown check type");
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
      Log.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramString.duration / 1000) });
      AppMethodBeat.o(79660);
      return i;
      j = 1;
    }
    AppMethodBeat.o(79660);
    return -50002;
  }
  
  private void bly(final String paramString)
  {
    AppMethodBeat.i(79658);
    this.WSL = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(296259);
        OpenFileChooserUI.this.setResult(0);
        OpenFileChooserUI.this.finish();
        AppMethodBeat.o(296259);
      }
    };
    getString(c.i.app_tip);
    this.lzP = k.a(this, getString(c.i.webview_jssdk_choose_video_compressing), true, this.WSL);
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(296085);
        Object localObject1 = new ArrayList();
        int i = OpenFileChooserUI.a(OpenFileChooserUI.this, paramString);
        if (i == -50002)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(296401);
              if ((OpenFileChooserUI.e(OpenFileChooserUI.this) == 7) && (OpenFileChooserUI.f(OpenFileChooserUI.this) == 2))
              {
                k.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(c.i.webview_jssdk_choose_video_exceed_20M), OpenFileChooserUI.this.getString(c.i.app_tip), OpenFileChooserUI.this.getString(c.i.app_i_known), false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(296472);
                    OpenFileChooserUI.this.setResult(1);
                    OpenFileChooserUI.this.finish();
                    AppMethodBeat.o(296472);
                  }
                });
                AppMethodBeat.o(296401);
                return;
              }
              Toast.makeText(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(c.i.video_export_file_too_big), 0).show();
              OpenFileChooserUI.this.setResult(1);
              OpenFileChooserUI.this.finish();
              AppMethodBeat.o(296401);
            }
          });
          AppMethodBeat.o(296085);
          return;
        }
        Object localObject2;
        if (i == -50006)
        {
          localObject1 = OpenFileChooserUI.a(OpenFileChooserUI.this, paramString, (List)localObject1);
          OpenFileChooserUI.b(OpenFileChooserUI.this, paramString);
          localObject2 = OpenFileChooserUI.g(OpenFileChooserUI.this);
        }
        while (!Util.isNullOrNil((String)localObject1))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(296406);
              Intent localIntent = new Intent();
              localIntent.putExtra("key_pick_local_media_callback_type", 1);
              localIntent.putExtra("key_pick_local_media_local_id", this.sNp);
              localIntent.putExtra("key_pick_local_media_thumb_local_id", this.WSQ);
              Log.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", new Object[] { this.WSQ });
              OpenFileChooserUI.this.setResult(-1, localIntent);
              OpenFileChooserUI.this.finish();
              AppMethodBeat.o(296406);
            }
          });
          AppMethodBeat.o(296085);
          return;
          if (i == 1)
          {
            String str1 = OpenFileChooserUI.c(OpenFileChooserUI.this, paramString);
            OpenFileChooserUI.b(OpenFileChooserUI.this, paramString);
            String str2 = OpenFileChooserUI.g(OpenFileChooserUI.this);
            localObject2 = str2;
            localObject1 = str1;
            if (Util.isNullOrNil(str1))
            {
              localObject2 = str2;
              localObject1 = str1;
              if (OpenFileChooserUI.e(OpenFileChooserUI.this) == 7)
              {
                localObject2 = str2;
                localObject1 = str1;
                if (OpenFileChooserUI.f(OpenFileChooserUI.this) == 2)
                {
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(296400);
                      k.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(c.i.webview_jssdk_choose_video_type_not_support), OpenFileChooserUI.this.getString(c.i.app_tip), OpenFileChooserUI.this.getString(c.i.app_i_known), false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(296187);
                          OpenFileChooserUI.this.setResult(1);
                          OpenFileChooserUI.this.finish();
                          AppMethodBeat.o(296187);
                        }
                      });
                      AppMethodBeat.o(296400);
                    }
                  });
                  AppMethodBeat.o(296085);
                }
              }
            }
          }
          else
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(296403);
                OpenFileChooserUI.this.setResult(1);
                OpenFileChooserUI.this.finish();
                AppMethodBeat.o(296403);
              }
            });
            AppMethodBeat.o(296085);
            return;
          }
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(296396);
            OpenFileChooserUI.this.setResult(1);
            OpenFileChooserUI.this.finish();
            AppMethodBeat.o(296396);
          }
        });
        AppMethodBeat.o(296085);
      }
    });
    AppMethodBeat.o(79658);
  }
  
  private String blz(String paramString)
  {
    AppMethodBeat.i(79659);
    try
    {
      d locald = new d();
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
        Log.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { localException });
        localWebViewJSSDKVideoItem = null;
      }
      int i = Util.getInt(localWebViewJSSDKVideoItem.extractMetadata(18), 0);
      int j = Util.getInt(localWebViewJSSDKVideoItem.extractMetadata(19), 0);
      int k = Util.getInt(localWebViewJSSDKVideoItem.extractMetadata(9), 0);
      localWebViewJSSDKVideoItem.release();
      localWebViewJSSDKVideoItem.release();
      WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = WebViewJSSDKFileItem.bLD(paramString);
      localWebViewJSSDKVideoItem.duration = ((k + 500) / 1000);
      localWebViewJSSDKVideoItem.width = i;
      localWebViewJSSDKVideoItem.height = j;
      localWebViewJSSDKVideoItem.size = ((int)y.bEl(paramString));
      if (this.WSI == 1) {
        localWebViewJSSDKVideoItem.rPM = this.rPM;
      }
      g.ivZ().a(localWebViewJSSDKVideoItem);
      paramString = localWebViewJSSDKVideoItem.hHB;
      AppMethodBeat.o(79659);
    }
    return paramString;
  }
  
  private String ivz()
  {
    AppMethodBeat.i(296114);
    if (com.tencent.mm.pluginsdk.permission.b.g(getContext(), new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }))
    {
      str = com.tencent.mm.loader.i.b.bmL();
      AppMethodBeat.o(296114);
      return str;
    }
    String str = com.tencent.mm.loader.i.b.bmx();
    AppMethodBeat.o(296114);
    return str;
  }
  
  private boolean ixn()
  {
    AppMethodBeat.i(79654);
    Log.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", new Object[] { Long.valueOf(Util.getAvailableMemoryMB(this)) });
    if (Util.getAvailableMemoryMB(this) <= 200L)
    {
      AppMethodBeat.o(79654);
      return false;
    }
    AppMethodBeat.o(79654);
    return true;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(79657);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      paramIntent = new Intent();
      paramIntent.putExtra("key_pick_local_media_show_memory_warning", this.WSK);
      setResult(paramInt2, paramIntent);
      finish();
      AppMethodBeat.o(79657);
      return;
    }
    switch (paramInt1)
    {
    default: 
      Log.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", new Object[] { Integer.valueOf(paramInt1) });
      setResult(1);
      finish();
      AppMethodBeat.o(79657);
      return;
    case 1: 
    case 3: 
      com.tencent.mm.plugin.webview.a.a.au(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79652);
          Object localObject2 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          boolean bool1 = paramIntent.getBooleanExtra("isTakePhoto", false);
          boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
          Object localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str1 = (String)((Iterator)localObject2).next();
            WebViewJSSDKFileItem localWebViewJSSDKFileItem = WebViewJSSDKFileItem.bLB(str1);
            String str2 = localWebViewJSSDKFileItem.hHB;
            localWebViewJSSDKFileItem.qUO = bool2;
            g.ivZ().a(localWebViewJSSDKFileItem);
            Log.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[] { str1, str2 });
            ((ArrayList)localObject1).add(str2);
          }
          localObject1 = az.bR((ArrayList)localObject1);
          Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { localObject1 });
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_pick_local_pic_callback_local_ids", (String)localObject1);
          if (bool1) {}
          for (localObject1 = "camera";; localObject1 = "album")
          {
            ((Intent)localObject2).putExtra("key_pick_local_pic_source_type", (String)localObject1);
            ((Intent)localObject2).putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.b(OpenFileChooserUI.this));
            OpenFileChooserUI.this.setResult(paramInt2, (Intent)localObject2);
            OpenFileChooserUI.this.finish();
            AppMethodBeat.o(79652);
            return;
          }
        }
      });
      AppMethodBeat.o(79657);
      return;
    case 2: 
      localObject = t.g(getContext().getApplicationContext(), paramIntent, ivz());
      if (Util.isNullOrNil((String)localObject))
      {
        Log.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
        setResult(-2, paramIntent);
        finish();
        AppMethodBeat.o(79657);
        return;
      }
      Log.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", new Object[] { localObject });
      paramIntent = new Intent();
      paramIntent.putExtra("key_send_raw_image", this.HPO);
      paramIntent.putExtra("max_select_count", this.RFZ);
      paramIntent.putExtra("query_source_type", this.mpb);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      paramIntent.putStringArrayListExtra("preview_image_list", localArrayList);
      paramIntent.putExtra("preview_image", true);
      paramIntent.addFlags(67108864);
      com.tencent.mm.br.c.b(this, "gallery", ".ui.GalleryEntryUI", paramIntent, 3);
      AppMethodBeat.o(79657);
      return;
    case 5: 
      if (new u(this.rPL).jKS())
      {
        bly(this.rPL);
        AppMethodBeat.o(79657);
        return;
      }
      Log.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", new Object[] { this.rPL });
      setResult(1);
      finish();
      AppMethodBeat.o(79657);
      return;
    case 4: 
      paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        Log.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
        setResult(1);
        finish();
        AppMethodBeat.o(79657);
        return;
      }
      Log.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
      Log.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { paramIntent.get(0) });
      if ((this.WSI == 1) && (!aaS(this.rPM))) {
        Log.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
      }
      bly((String)paramIntent.get(0));
      AppMethodBeat.o(79657);
      return;
    case 6: 
      Log.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
      if (paramIntent != null)
      {
        Log.i("MicroMsg.OpenFileChooserUI", "data is valid!");
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          Log.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
          setResult(1);
          finish();
          AppMethodBeat.o(79657);
          return;
        }
        this.rPL = paramIntent.KTN;
        Log.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.rPL });
        if ((!aaS(this.rPM)) && (aaS(paramIntent.KTO))) {
          this.rPM = paramIntent.KTO;
        }
        paramIntent = (Intent)localObject;
        if (!TextUtils.isEmpty(this.rPL)) {
          paramIntent = new u(this.rPL);
        }
        if ((paramIntent != null) && (paramIntent.jKS()))
        {
          Log.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.rPL });
          bly(this.rPL);
          AppMethodBeat.o(79657);
          return;
        }
        Log.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.rPL });
      }
      Log.e("MicroMsg.OpenFileChooserUI", "data is null!");
      setResult(1);
      finish();
      AppMethodBeat.o(79657);
      return;
    case 7: 
      Log.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
      if (paramIntent != null)
      {
        Log.i("MicroMsg.OpenFileChooserUI", "data is valid!");
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          Log.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
          setResult(1);
          finish();
          AppMethodBeat.o(79657);
          return;
        }
        if (paramIntent.KTL)
        {
          paramIntent = paramIntent.KTT;
          localObject = new Intent();
          if (Util.isNullOrNil(paramIntent))
          {
            Log.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", new Object[] { paramIntent });
            ((Intent)localObject).putExtra("key_pick_local_pic_fail_reason", "can't get the image's filePath!");
            setResult(1, (Intent)localObject);
            finish();
            AppMethodBeat.o(79657);
            return;
          }
          if (!new u(paramIntent).jKS())
          {
            Log.e("MicroMsg.OpenFileChooserUI", "picture filePath is not nil, but couldn't access the picture! The reason might be no permissions! path:%s", new Object[] { paramIntent });
            ((Intent)localObject).putExtra("key_pick_local_pic_fail_reason", "can't have access to the image!");
            setResult(1, (Intent)localObject);
            finish();
            AppMethodBeat.o(79657);
            return;
          }
          com.tencent.mm.plugin.webview.a.a.au(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(296164);
              Object localObject1 = new ArrayList();
              Object localObject2 = WebViewJSSDKFileItem.bLB(paramIntent);
              ((WebViewJSSDKFileItem)localObject2).qUO = true;
              ((WebViewJSSDKFileItem)localObject2).mediaType = 1;
              g.ivZ().a((WebViewJSSDKFileItem)localObject2);
              ((ArrayList)localObject1).add(((WebViewJSSDKFileItem)localObject2).hHB);
              Log.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", new Object[] { paramIntent, ((WebViewJSSDKFileItem)localObject2).hHB });
              if (Util.isEqual(OpenFileChooserUI.c(OpenFileChooserUI.this), "chooseImage"))
              {
                localObject1 = az.bR((ArrayList)localObject1);
                Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { localObject1 });
                this.val$intent.putExtra("key_pick_local_media_local_ids", (String)localObject1);
                this.val$intent.putExtra("key_pick_local_media_callback_type", 2);
                this.val$intent.putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.b(OpenFileChooserUI.this));
                localObject2 = this.val$intent;
                if (!OpenFileChooserUI.d(OpenFileChooserUI.this)) {
                  break label208;
                }
              }
              label208:
              for (localObject1 = "camera";; localObject1 = "album")
              {
                ((Intent)localObject2).putExtra("key_pick_local_pic_source_type", (String)localObject1);
                OpenFileChooserUI.this.setResult(paramInt2, this.val$intent);
                OpenFileChooserUI.this.finish();
                AppMethodBeat.o(296164);
                return;
                localObject1 = az.bS((ArrayList)localObject1);
                break;
              }
            }
          });
          AppMethodBeat.o(79657);
          return;
        }
        this.rPL = paramIntent.KTN;
        Log.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.rPL });
        if ((!aaS(this.rPM)) && (aaS(paramIntent.KTO))) {
          this.rPM = paramIntent.KTO;
        }
        if (TextUtils.isEmpty(this.rPL)) {
          break label1251;
        }
      }
      break;
    }
    label1251:
    for (paramIntent = new u(this.rPL);; paramIntent = null)
    {
      if ((paramIntent != null) && (paramIntent.jKS()))
      {
        Log.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.rPL });
        bly(this.rPL);
        AppMethodBeat.o(79657);
        return;
      }
      Log.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.rPL });
      Log.e("MicroMsg.OpenFileChooserUI", "data is null!");
      setResult(1);
      finish();
      AppMethodBeat.o(79657);
      return;
      Log.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
      localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        bly((String)((ArrayList)localObject).get(0));
        AppMethodBeat.o(79657);
        return;
      }
      localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      final boolean bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      if (localObject == null)
      {
        Log.e("MicroMsg.OpenFileChooserUI", "chosen is null");
        setResult(1);
        finish();
        AppMethodBeat.o(79657);
        return;
      }
      com.tencent.mm.plugin.webview.a.a.au(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175762);
          Object localObject1 = new ArrayList();
          Object localObject2 = this.sfF.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str1 = (String)((Iterator)localObject2).next();
            WebViewJSSDKFileItem localWebViewJSSDKFileItem = WebViewJSSDKFileItem.bLB(str1);
            String str2 = localWebViewJSSDKFileItem.hHB;
            localWebViewJSSDKFileItem.qUO = bool;
            g.ivZ().a(localWebViewJSSDKFileItem);
            Log.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[] { str1, str2 });
            ((ArrayList)localObject1).add(str2);
          }
          if (Util.isEqual(OpenFileChooserUI.c(OpenFileChooserUI.this), "chooseImage"))
          {
            localObject1 = az.bR((ArrayList)localObject1);
            Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { localObject1 });
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("key_pick_local_media_local_ids", (String)localObject1);
            ((Intent)localObject2).putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.b(OpenFileChooserUI.this));
            ((Intent)localObject2).putExtra("key_pick_local_media_callback_type", 2);
            if (!OpenFileChooserUI.d(OpenFileChooserUI.this)) {
              break label229;
            }
          }
          label229:
          for (localObject1 = "camera";; localObject1 = "album")
          {
            ((Intent)localObject2).putExtra("key_pick_local_pic_source_type", (String)localObject1);
            OpenFileChooserUI.this.setResult(paramInt2, (Intent)localObject2);
            OpenFileChooserUI.this.finish();
            AppMethodBeat.o(175762);
            return;
            localObject1 = az.bS((ArrayList)localObject1);
            break;
          }
        }
      });
      AppMethodBeat.o(79657);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79653);
    super.onCreate(paramBundle);
    this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
    if ((this.count <= 0) || (this.count > 9)) {
      this.count = 9;
    }
    this.RFZ = this.count;
    this.mpb = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
    this.HMO = getIntent().getIntExtra("query_media_type", 1);
    this.HPO = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
    this.WSH = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
    this.WSI = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
    this.WSJ = getIntent().getStringExtra("key_pick_local_media_choose_type");
    boolean bool;
    int i;
    int j;
    if ((this.WSH & 0x1000) == 0)
    {
      bool = true;
      this.RfR = bool;
      if (((this.mpb != 7) || (this.HMO != 2)) && (this.HMO != 3)) {
        break label1120;
      }
      if (!ixn())
      {
        aa.makeText(this, getString(c.i.webview_memory_check_message), 1).show();
        this.WSK = true;
      }
      paramBundle = new Intent();
      paramBundle.putExtra("key_send_raw_image", this.HPO);
      paramBundle.putExtra("query_media_type", this.HMO);
      if (this.WSI != 1) {
        break label507;
      }
      if ((this.WSH == 4096) || ((this.WSH & 0x1000) <= 0)) {
        break label427;
      }
      i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
      j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
      paramBundle.putExtra("KEY_SIGHT_PARAMS", auj(1));
      paramBundle.putExtra("record_video_force_sys_camera", false);
      paramBundle.putExtra("show_header_view", true);
      paramBundle.putExtra("record_video_is_sight_capture", true);
      paramBundle.putExtra("record_video_quality", i);
      paramBundle.putExtra("record_video_time_limit", j);
      paramBundle.putExtra("video_full_path", this.rPL);
      t.e(this, this.RFZ, this.mpb, paramBundle);
      label387:
      if ((this.WSH == 4096) || ((this.WSH & 0x1000) <= 0)) {
        break label1081;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label1125;
      }
      AppMethodBeat.o(79653);
      return;
      bool = false;
      break;
      label427:
      if ((this.WSH == 16) || (this.WSH == 256))
      {
        paramBundle.putExtra("KEY_SIGHT_PARAMS", auj(1));
        t.a(this, 6, paramBundle, 3, 1);
        break label387;
      }
      if (this.WSH != 4096) {
        break label387;
      }
      paramBundle.putExtra("show_header_view", false);
      t.e(this, this.RFZ, this.mpb, paramBundle);
      break label387;
      label507:
      if (this.WSI == 2)
      {
        String str = Util.nullAsNil(getIntent().getStringExtra("key_pick_local_media_sight_type"));
        if ((this.WSH != 4096) && ((this.WSH & 0x1000) > 0))
        {
          Log.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
          setResult(1);
          finish();
          break label387;
        }
        if ((this.WSH == 16) || (this.WSH == 256))
        {
          i = 0;
          if ((str.contains("video")) && (str.contains("image"))) {
            i = 0;
          }
          for (;;)
          {
            paramBundle.putExtra("KEY_SIGHT_PARAMS", auj(i));
            t.a(this, 7, paramBundle, 3, i);
            break;
            if (str.contains("video")) {
              i = 1;
            } else if (str.contains("image")) {
              i = 2;
            }
          }
        }
        if (this.WSH != 4096) {
          break label387;
        }
        i = 3;
        if ((str.contains("image")) && (str.contains("video"))) {
          i = 3;
        }
        for (;;)
        {
          paramBundle = new Intent();
          paramBundle.putExtra("key_can_select_video_and_pic", true);
          paramBundle.putExtra("key_send_raw_image", this.HPO);
          t.a(this, 8, this.RFZ, this.mpb, i, false, paramBundle);
          break;
          if (str.contains("image")) {
            i = 1;
          } else if (str.contains("video")) {
            i = 2;
          }
        }
      }
      if ((this.WSH != 4096) && ((this.WSH & 0x1000) > 0))
      {
        this.rPL = (ivz() + "microMsg." + System.currentTimeMillis() + ".mp4");
        i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
        j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        paramBundle.putExtra("record_video_force_sys_camera", true);
        paramBundle.putExtra("record_video_quality", i);
        paramBundle.putExtra("record_video_time_limit", j);
        paramBundle.putExtra("video_full_path", this.rPL);
        t.e(this, this.RFZ, this.mpb, paramBundle);
        break label387;
      }
      if ((this.WSH == 16) || (this.WSH == 256))
      {
        this.rPL = (ivz() + "microMsg." + System.currentTimeMillis() + ".mp4");
        i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
        j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        paramBundle = this.rPL;
        if (this.WSH == 16) {}
        for (bool = true;; bool = false)
        {
          t.a(this, paramBundle, 5, j, i, bool);
          break;
        }
      }
      if (this.WSH != 4096) {
        break label387;
      }
      paramBundle.putExtra("show_header_view", false);
      t.e(this, this.RFZ, this.mpb, paramBundle);
      break label387;
      label1081:
      if ((this.WSH == 16) || (this.WSH == 256)) {
        i = 1;
      } else if (this.WSH == 4096) {
        i = 1;
      } else {
        label1120:
        i = 0;
      }
    }
    label1125:
    if (!ixn())
    {
      aa.makeText(this, getString(c.i.webview_memory_check_message), 1).show();
      this.WSK = true;
    }
    paramBundle = new Intent();
    paramBundle.putExtra("key_send_raw_image", this.HPO);
    paramBundle.putExtra("query_media_type", this.HMO);
    switch (this.WSH)
    {
    default: 
      Log.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
      setResult(0);
      finish();
      AppMethodBeat.o(79653);
      return;
    case 1: 
      paramBundle.putExtra("show_header_view", false);
      t.a(this, 1, this.RFZ, this.mpb, paramBundle);
      AppMethodBeat.o(79653);
      return;
    case 2: 
      paramBundle = new l(this);
      paramBundle.Vtg = new OpenFileChooserUI.1(this);
      paramBundle.GAC = new OpenFileChooserUI.3(this);
      paramBundle.a(new f.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(175751);
          Log.v("MicroMsg.OpenFileChooserUI", "alvinluo onDismiss");
          OpenFileChooserUI.this.setResult(0);
          OpenFileChooserUI.this.finish();
          AppMethodBeat.o(175751);
        }
      });
      paramBundle.a(new f.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(175752);
          Log.v("MicroMsg.OpenFileChooserUI", "alvinluo cancel onClick");
          OpenFileChooserUI.this.setResult(0);
          OpenFileChooserUI.this.finish();
          AppMethodBeat.o(175752);
        }
      });
      paramBundle.jDd();
      AppMethodBeat.o(79653);
      return;
    }
    t.a(this, 1, this.count, this.mpb, paramBundle);
    AppMethodBeat.o(79653);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79661);
    super.onDestroy();
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    AppMethodBeat.o(79661);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(79656);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(79656);
      return;
    }
    Log.i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79656);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        t.d(getContext(), ivz(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        AppMethodBeat.o(79656);
        return;
      }
      k.a(this, getString(c.i.permission_camera_request_again_msg), getString(c.i.permission_tips_title), getString(c.i.jump_to_settings), getString(c.i.app_cancel), false, new OpenFileChooserUI.6(this), null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI
 * JD-Core Version:    0.7.0.1
 */
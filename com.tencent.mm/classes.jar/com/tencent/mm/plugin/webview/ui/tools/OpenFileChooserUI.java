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
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.a.a;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class OpenFileChooserUI
  extends MMActivity
{
  private int CaM;
  private boolean KGr;
  private int LfO;
  private boolean QbA = false;
  private DialogInterface.OnCancelListener QbB = null;
  private boolean Qbw;
  private int Qbx;
  private int Qby;
  private String Qbz;
  private int count;
  private ProgressDialog iXX = null;
  private int jQj;
  private String oLQ;
  private String oLR;
  
  private SightParams AE(int paramInt)
  {
    AppMethodBeat.i(79655);
    String str1 = "microMsg_" + System.currentTimeMillis();
    this.oLQ = (com.tencent.mm.loader.j.b.aSX() + str1 + ".mp4");
    this.oLR = (com.tencent.mm.loader.j.b.aSX() + str1 + ".jpeg");
    int j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
    SightParams localSightParams = new SightParams(3, 1);
    if (this.Qbx == 16) {}
    for (int i = 1;; i = 2)
    {
      localSightParams.EYi = i;
      localSightParams.mode = paramInt;
      if (localSightParams.lgX == null) {
        localSightParams.lgX = new VideoTransPara();
      }
      localSightParams.lgX.duration = j;
      String str2 = AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
      localSightParams.A(str1, this.oLQ, this.oLR, str2);
      AppMethodBeat.o(79655);
      return localSightParams;
    }
  }
  
  private static boolean ahU(String paramString)
  {
    AppMethodBeat.i(79662);
    if (!TextUtils.isEmpty(paramString))
    {
      q localq = new q(paramString);
      Log.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", new Object[] { paramString });
      if (localq.ifE())
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
  
  private void blX(final String paramString)
  {
    AppMethodBeat.i(79658);
    this.QbB = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(261858);
        OpenFileChooserUI.this.setResult(0);
        OpenFileChooserUI.this.finish();
        AppMethodBeat.o(261858);
      }
    };
    getString(c.i.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(this, getString(c.i.webview_jssdk_choose_video_compressing), true, this.QbB);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268144);
        Object localObject1 = new ArrayList();
        int i = OpenFileChooserUI.a(OpenFileChooserUI.this, paramString);
        if (i == -50002)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(265142);
              if ((OpenFileChooserUI.d(OpenFileChooserUI.this) == 7) && (OpenFileChooserUI.e(OpenFileChooserUI.this) == 2))
              {
                com.tencent.mm.ui.base.h.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(c.i.webview_jssdk_choose_video_exceed_20M), OpenFileChooserUI.this.getString(c.i.app_tip), OpenFileChooserUI.this.getString(c.i.app_i_known), false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(252441);
                    OpenFileChooserUI.this.setResult(1);
                    OpenFileChooserUI.this.finish();
                    AppMethodBeat.o(252441);
                  }
                });
                AppMethodBeat.o(265142);
                return;
              }
              Toast.makeText(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(c.i.video_export_file_too_big), 0).show();
              OpenFileChooserUI.this.setResult(1);
              OpenFileChooserUI.this.finish();
              AppMethodBeat.o(265142);
            }
          });
          AppMethodBeat.o(268144);
          return;
        }
        Object localObject2;
        if (i == -50006)
        {
          localObject1 = OpenFileChooserUI.G(paramString, (List)localObject1);
          OpenFileChooserUI.b(OpenFileChooserUI.this, paramString);
          localObject2 = OpenFileChooserUI.f(OpenFileChooserUI.this);
        }
        while (!Util.isNullOrNil((String)localObject1))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219036);
              Intent localIntent = new Intent();
              localIntent.putExtra("key_pick_local_media_callback_type", 1);
              localIntent.putExtra("key_pick_local_media_local_id", this.pIy);
              localIntent.putExtra("key_pick_local_media_thumb_local_id", this.QbG);
              Log.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", new Object[] { this.QbG });
              OpenFileChooserUI.this.setResult(-1, localIntent);
              OpenFileChooserUI.this.finish();
              AppMethodBeat.o(219036);
            }
          });
          AppMethodBeat.o(268144);
          return;
          if (i == 1)
          {
            String str1 = OpenFileChooserUI.c(OpenFileChooserUI.this, paramString);
            OpenFileChooserUI.b(OpenFileChooserUI.this, paramString);
            String str2 = OpenFileChooserUI.f(OpenFileChooserUI.this);
            localObject2 = str2;
            localObject1 = str1;
            if (Util.isNullOrNil(str1))
            {
              localObject2 = str2;
              localObject1 = str1;
              if (OpenFileChooserUI.d(OpenFileChooserUI.this) == 7)
              {
                localObject2 = str2;
                localObject1 = str1;
                if (OpenFileChooserUI.e(OpenFileChooserUI.this) == 2)
                {
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(218141);
                      com.tencent.mm.ui.base.h.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(c.i.webview_jssdk_choose_video_type_not_support), OpenFileChooserUI.this.getString(c.i.app_tip), OpenFileChooserUI.this.getString(c.i.app_i_known), false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(216255);
                          OpenFileChooserUI.this.setResult(1);
                          OpenFileChooserUI.this.finish();
                          AppMethodBeat.o(216255);
                        }
                      });
                      AppMethodBeat.o(218141);
                    }
                  });
                  AppMethodBeat.o(268144);
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
                AppMethodBeat.i(244149);
                OpenFileChooserUI.this.setResult(1);
                OpenFileChooserUI.this.finish();
                AppMethodBeat.o(244149);
              }
            });
            AppMethodBeat.o(268144);
            return;
          }
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(258956);
            OpenFileChooserUI.this.setResult(1);
            OpenFileChooserUI.this.finish();
            AppMethodBeat.o(258956);
          }
        });
        AppMethodBeat.o(268144);
      }
    });
    AppMethodBeat.o(79658);
  }
  
  private String blY(String paramString)
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
      WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = WebViewJSSDKFileItem.bIJ(paramString);
      localWebViewJSSDKVideoItem.duration = ((k + 500) / 1000);
      localWebViewJSSDKVideoItem.width = i;
      localWebViewJSSDKVideoItem.height = j;
      localWebViewJSSDKVideoItem.size = ((int)com.tencent.mm.vfs.u.bBQ(paramString));
      if (this.Qby == 1) {
        localWebViewJSSDKVideoItem.oLR = this.oLR;
      }
      f.gWt().a(localWebViewJSSDKVideoItem);
      paramString = localWebViewJSSDKVideoItem.fCM;
      AppMethodBeat.o(79659);
    }
    return paramString;
  }
  
  private int blZ(String paramString)
  {
    AppMethodBeat.i(79660);
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse("file://".concat(String.valueOf(paramString))));
    NetStatusUtil.is2G(this);
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
        boolean bool = com.tencent.mm.plugin.a.c.ZZ((String)localObject);
        Log.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
        i = -10000;
        if (bool)
        {
          i = SightVideoJNI.shouldRemuxingVFS((String)localObject, 660, 500, 26214400, 300000.0D, 1000000);
          Log.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", new Object[] { Integer.valueOf(i) });
        }
        if ((i == -1) || (!bool))
        {
          i = (int)com.tencent.mm.vfs.u.bBQ((String)localObject);
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
  
  private boolean gXt()
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
      paramIntent.putExtra("key_pick_local_media_show_memory_warning", this.QbA);
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
      com.tencent.mm.plugin.webview.a.a.am(new Runnable()
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
            WebViewJSSDKFileItem localWebViewJSSDKFileItem = WebViewJSSDKFileItem.bIH(str1);
            String str2 = localWebViewJSSDKFileItem.fCM;
            localWebViewJSSDKFileItem.nVe = bool2;
            f.gWt().a(localWebViewJSSDKFileItem);
            Log.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[] { str1, str2 });
            ((ArrayList)localObject1).add(str2);
          }
          localObject1 = az.bq((ArrayList)localObject1);
          Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { localObject1 });
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_pick_local_pic_callback_local_ids", (String)localObject1);
          if (bool1) {}
          for (localObject1 = "camera";; localObject1 = "album")
          {
            ((Intent)localObject2).putExtra("key_pick_local_pic_source_type", (String)localObject1);
            ((Intent)localObject2).putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.a(OpenFileChooserUI.this));
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
      localObject = com.tencent.mm.pluginsdk.ui.tools.u.g(getContext().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.aSX());
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
      paramIntent.putExtra("key_send_raw_image", this.Qbw);
      paramIntent.putExtra("max_select_count", this.LfO);
      paramIntent.putExtra("query_source_type", this.jQj);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      paramIntent.putStringArrayListExtra("preview_image_list", localArrayList);
      paramIntent.putExtra("preview_image", true);
      paramIntent.addFlags(67108864);
      com.tencent.mm.by.c.b(this, "gallery", ".ui.GalleryEntryUI", paramIntent, 3);
      AppMethodBeat.o(79657);
      return;
    case 5: 
      if (new q(this.oLQ).ifE())
      {
        blX(this.oLQ);
        AppMethodBeat.o(79657);
        return;
      }
      Log.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", new Object[] { this.oLQ });
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
      if ((this.Qby == 1) && (!ahU(this.oLR))) {
        Log.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
      }
      blX((String)paramIntent.get(0));
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
        this.oLQ = paramIntent.EYb;
        Log.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.oLQ });
        if ((!ahU(this.oLR)) && (ahU(paramIntent.EYc))) {
          this.oLR = paramIntent.EYc;
        }
        paramIntent = (Intent)localObject;
        if (!TextUtils.isEmpty(this.oLQ)) {
          paramIntent = new q(this.oLQ);
        }
        if ((paramIntent != null) && (paramIntent.ifE()))
        {
          Log.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.oLQ });
          blX(this.oLQ);
          AppMethodBeat.o(79657);
          return;
        }
        Log.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.oLQ });
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
        if (paramIntent.EXZ)
        {
          paramIntent = paramIntent.EYh;
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
          if (!new q(paramIntent).ifE())
          {
            Log.e("MicroMsg.OpenFileChooserUI", "picture filePath is not nil, but couldn't access the picture! The reason might be no permissions! path:%s", new Object[] { paramIntent });
            ((Intent)localObject).putExtra("key_pick_local_pic_fail_reason", "can't have access to the image!");
            setResult(1, (Intent)localObject);
            finish();
            AppMethodBeat.o(79657);
            return;
          }
          com.tencent.mm.plugin.webview.a.a.am(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(254600);
              Object localObject1 = new ArrayList();
              Object localObject2 = WebViewJSSDKFileItem.bIH(paramIntent);
              ((WebViewJSSDKFileItem)localObject2).nVe = true;
              ((WebViewJSSDKFileItem)localObject2).mediaType = 1;
              f.gWt().a((WebViewJSSDKFileItem)localObject2);
              ((ArrayList)localObject1).add(((WebViewJSSDKFileItem)localObject2).fCM);
              Log.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", new Object[] { paramIntent, ((WebViewJSSDKFileItem)localObject2).fCM });
              if (Util.isEqual(OpenFileChooserUI.b(OpenFileChooserUI.this), "chooseImage"))
              {
                localObject1 = az.bq((ArrayList)localObject1);
                Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { localObject1 });
                this.val$intent.putExtra("key_pick_local_media_local_ids", (String)localObject1);
                this.val$intent.putExtra("key_pick_local_media_callback_type", 2);
                this.val$intent.putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.a(OpenFileChooserUI.this));
                localObject2 = this.val$intent;
                if (!OpenFileChooserUI.c(OpenFileChooserUI.this)) {
                  break label208;
                }
              }
              label208:
              for (localObject1 = "camera";; localObject1 = "album")
              {
                ((Intent)localObject2).putExtra("key_pick_local_pic_source_type", (String)localObject1);
                OpenFileChooserUI.this.setResult(paramInt2, this.val$intent);
                OpenFileChooserUI.this.finish();
                AppMethodBeat.o(254600);
                return;
                localObject1 = az.br((ArrayList)localObject1);
                break;
              }
            }
          });
          AppMethodBeat.o(79657);
          return;
        }
        this.oLQ = paramIntent.EYb;
        Log.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.oLQ });
        if ((!ahU(this.oLR)) && (ahU(paramIntent.EYc))) {
          this.oLR = paramIntent.EYc;
        }
        if (TextUtils.isEmpty(this.oLQ)) {
          break label1251;
        }
      }
      break;
    }
    label1251:
    for (paramIntent = new q(this.oLQ);; paramIntent = null)
    {
      if ((paramIntent != null) && (paramIntent.ifE()))
      {
        Log.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.oLQ });
        blX(this.oLQ);
        AppMethodBeat.o(79657);
        return;
      }
      Log.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.oLQ });
      Log.e("MicroMsg.OpenFileChooserUI", "data is null!");
      setResult(1);
      finish();
      AppMethodBeat.o(79657);
      return;
      Log.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
      localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        blX((String)((ArrayList)localObject).get(0));
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
      com.tencent.mm.plugin.webview.a.a.am(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175762);
          Object localObject1 = new ArrayList();
          Object localObject2 = this.pam.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str1 = (String)((Iterator)localObject2).next();
            WebViewJSSDKFileItem localWebViewJSSDKFileItem = WebViewJSSDKFileItem.bIH(str1);
            String str2 = localWebViewJSSDKFileItem.fCM;
            localWebViewJSSDKFileItem.nVe = bool;
            f.gWt().a(localWebViewJSSDKFileItem);
            Log.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[] { str1, str2 });
            ((ArrayList)localObject1).add(str2);
          }
          if (Util.isEqual(OpenFileChooserUI.b(OpenFileChooserUI.this), "chooseImage"))
          {
            localObject1 = az.bq((ArrayList)localObject1);
            Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { localObject1 });
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("key_pick_local_media_local_ids", (String)localObject1);
            ((Intent)localObject2).putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.a(OpenFileChooserUI.this));
            ((Intent)localObject2).putExtra("key_pick_local_media_callback_type", 2);
            if (!OpenFileChooserUI.c(OpenFileChooserUI.this)) {
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
            localObject1 = az.br((ArrayList)localObject1);
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
    int i = 3;
    AppMethodBeat.i(79653);
    super.onCreate(paramBundle);
    this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
    if ((this.count <= 0) || (this.count > 9)) {
      this.count = 9;
    }
    this.LfO = this.count;
    this.jQj = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
    this.CaM = getIntent().getIntExtra("query_media_type", 1);
    this.Qbw = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
    this.Qbx = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
    this.Qby = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
    this.Qbz = getIntent().getStringExtra("key_pick_local_media_choose_type");
    boolean bool;
    int j;
    if ((this.Qbx & 0x1000) == 0)
    {
      bool = true;
      this.KGr = bool;
      if (((this.jQj != 7) || (this.CaM != 2)) && (this.CaM != 3)) {
        break label1110;
      }
      if (!gXt())
      {
        w.makeText(this, getString(c.i.webview_memory_check_message), 1).show();
        this.QbA = true;
      }
      paramBundle = new Intent();
      paramBundle.putExtra("key_send_raw_image", this.Qbw);
      paramBundle.putExtra("query_media_type", this.CaM);
      if (this.Qby != 1) {
        break label508;
      }
      if ((this.Qbx == 4096) || ((this.Qbx & 0x1000) <= 0)) {
        break label428;
      }
      i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
      j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
      paramBundle.putExtra("KEY_SIGHT_PARAMS", AE(1));
      paramBundle.putExtra("record_video_force_sys_camera", false);
      paramBundle.putExtra("show_header_view", true);
      paramBundle.putExtra("record_video_is_sight_capture", true);
      paramBundle.putExtra("record_video_quality", i);
      paramBundle.putExtra("record_video_time_limit", j);
      paramBundle.putExtra("video_full_path", this.oLQ);
      com.tencent.mm.pluginsdk.ui.tools.u.d(this, this.LfO, this.jQj, paramBundle);
    }
    label411:
    label428:
    label508:
    String str;
    for (;;)
    {
      if ((this.Qbx != 4096) && ((this.Qbx & 0x1000) > 0))
      {
        i = 1;
        if (i == 0) {
          break label1115;
        }
        AppMethodBeat.o(79653);
        return;
        bool = false;
        break;
        if ((this.Qbx == 16) || (this.Qbx == 256))
        {
          paramBundle.putExtra("KEY_SIGHT_PARAMS", AE(1));
          com.tencent.mm.pluginsdk.ui.tools.u.a(this, 6, paramBundle, 3, 1);
        }
        else if (this.Qbx == 4096)
        {
          paramBundle.putExtra("show_header_view", false);
          com.tencent.mm.pluginsdk.ui.tools.u.d(this, this.LfO, this.jQj, paramBundle);
          continue;
          if (this.Qby == 2)
          {
            str = Util.nullAsNil(getIntent().getStringExtra("key_pick_local_media_sight_type"));
            if ((this.Qbx != 4096) && ((this.Qbx & 0x1000) > 0))
            {
              Log.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
              setResult(1);
              finish();
              continue;
            }
            if ((this.Qbx == 16) || (this.Qbx == 256)) {
              if ((str.contains("video")) && (str.contains("image"))) {
                i = 0;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramBundle.putExtra("KEY_SIGHT_PARAMS", AE(i));
      com.tencent.mm.pluginsdk.ui.tools.u.a(this, 7, paramBundle, 3, i);
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
          if (this.Qbx != 4096) {
            break;
          }
          if ((str.contains("image")) && (str.contains("video"))) {}
          for (;;)
          {
            paramBundle = new Intent();
            paramBundle.putExtra("key_can_select_video_and_pic", true);
            paramBundle.putExtra("key_send_raw_image", this.Qbw);
            com.tencent.mm.pluginsdk.ui.tools.u.a(this, 8, this.LfO, this.jQj, i, paramBundle);
            break;
            if (str.contains("image")) {
              i = 1;
            } else if (str.contains("video")) {
              i = 2;
            }
          }
          if ((this.Qbx != 4096) && ((this.Qbx & 0x1000) > 0))
          {
            this.oLQ = (com.tencent.mm.loader.j.b.aSX() + "microMsg." + System.currentTimeMillis() + ".mp4");
            i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
            j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
            paramBundle.putExtra("record_video_force_sys_camera", true);
            paramBundle.putExtra("record_video_quality", i);
            paramBundle.putExtra("record_video_time_limit", j);
            paramBundle.putExtra("video_full_path", this.oLQ);
            com.tencent.mm.pluginsdk.ui.tools.u.d(this, this.LfO, this.jQj, paramBundle);
            break;
          }
          if ((this.Qbx == 16) || (this.Qbx == 256))
          {
            this.oLQ = (com.tencent.mm.loader.j.b.aSX() + "microMsg." + System.currentTimeMillis() + ".mp4");
            i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
            j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
            paramBundle = this.oLQ;
            if (this.Qbx == 16) {}
            for (bool = true;; bool = false)
            {
              com.tencent.mm.pluginsdk.ui.tools.u.a(this, paramBundle, 5, j, i, bool);
              break;
            }
          }
          if (this.Qbx != 4096) {
            break;
          }
          paramBundle.putExtra("show_header_view", false);
          com.tencent.mm.pluginsdk.ui.tools.u.d(this, this.LfO, this.jQj, paramBundle);
          break;
          if ((this.Qbx == 16) || (this.Qbx == 256))
          {
            i = 1;
            break label411;
          }
          if (this.Qbx == 4096)
          {
            i = 1;
            break label411;
          }
          label1110:
          i = 0;
          break label411;
          label1115:
          if (!gXt())
          {
            w.makeText(this, getString(c.i.webview_memory_check_message), 1).show();
            this.QbA = true;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("key_send_raw_image", this.Qbw);
          paramBundle.putExtra("query_media_type", this.CaM);
          switch (this.Qbx)
          {
          default: 
            Log.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
            setResult(0);
            finish();
            AppMethodBeat.o(79653);
            return;
          case 1: 
            paramBundle.putExtra("show_header_view", false);
            com.tencent.mm.pluginsdk.ui.tools.u.a(this, 1, this.LfO, this.jQj, paramBundle);
            AppMethodBeat.o(79653);
            return;
          case 2: 
            paramBundle = new m(this);
            paramBundle.ODT = new q.f()
            {
              public final void onCreateMMMenu(o paramAnonymouso)
              {
                AppMethodBeat.i(175749);
                paramAnonymouso.d(1, OpenFileChooserUI.this.getString(c.i.webview_jssdk_take_photo));
                AppMethodBeat.o(175749);
              }
            };
            paramBundle.ODU = new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(175750);
                boolean bool = com.tencent.mm.pluginsdk.permission.b.a(OpenFileChooserUI.this.getContext(), "android.permission.CAMERA", 16, "", "");
                Log.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), OpenFileChooserUI.this.getContext() });
                if (!bool)
                {
                  AppMethodBeat.o(175750);
                  return;
                }
                com.tencent.mm.pluginsdk.ui.tools.u.d(OpenFileChooserUI.this.getContext(), com.tencent.mm.loader.j.b.aSX(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                AppMethodBeat.o(175750);
              }
            };
            paramBundle.a(new e.b()
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
            paramBundle.a(new e.a()
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
            paramBundle.hYu();
            AppMethodBeat.o(79653);
            return;
          }
          com.tencent.mm.pluginsdk.ui.tools.u.a(this, 1, this.count, this.jQj, paramBundle);
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
    if ((this.iXX != null) && (this.iXX.isShowing())) {
      this.iXX.dismiss();
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
        com.tencent.mm.pluginsdk.ui.tools.u.d(getContext(), com.tencent.mm.loader.j.b.aSX(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        AppMethodBeat.o(79656);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(c.i.permission_camera_request_again_msg), getString(c.i.permission_tips_title), getString(c.i.jump_to_settings), getString(c.i.app_cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(175753);
          paramAnonymousDialogInterface = OpenFileChooserUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/webview/ui/tools/OpenFileChooserUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/webview/ui/tools/OpenFileChooserUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(175753);
        }
      }, null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI
 * JD-Core Version:    0.7.0.1
 */
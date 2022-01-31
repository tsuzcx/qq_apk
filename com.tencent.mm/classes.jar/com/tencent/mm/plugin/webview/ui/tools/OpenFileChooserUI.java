package com.tencent.mm.plugin.webview.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.j.a.a;
import com.tencent.mm.model.au;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class OpenFileChooserUI
  extends MMActivity
{
  private int count;
  private ProgressDialog dnm = null;
  private String goK;
  private String goL;
  private int kIU;
  private int kIu;
  private int pkq;
  private int rlA;
  private int rlB;
  private boolean rlC = false;
  private DialogInterface.OnCancelListener rlD = null;
  private boolean rlz;
  
  private SightParams Cw(int paramInt)
  {
    String str1 = "microMsg_" + System.currentTimeMillis();
    this.goK = (com.tencent.mm.compatible.util.e.dzD + str1 + ".mp4");
    this.goL = (com.tencent.mm.compatible.util.e.dzD + str1 + ".jpeg");
    int j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
    SightParams localSightParams = new SightParams(3, 1);
    if (this.rlA == 16) {}
    for (int i = 1;; i = 2)
    {
      localSightParams.mfq = i;
      localSightParams.mode = paramInt;
      if (localSightParams.mfr == null) {
        localSightParams.mfr = new VideoTransPara();
      }
      localSightParams.mfr.duration = j;
      String str2 = com.tencent.mm.compatible.util.e.dzD + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
      localSightParams.o(str1, this.goK, this.goL, str2);
      return localSightParams;
    }
  }
  
  private void Ta(String paramString)
  {
    this.rlD = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        OpenFileChooserUI.this.setResult(0);
        OpenFileChooserUI.this.finish();
      }
    };
    getString(R.l.app_tip);
    this.dnm = h.b(this, getString(R.l.webview_jssdk_choose_video_compressing), true, this.rlD);
    au.DS().O(new OpenFileChooserUI.6(this, paramString));
  }
  
  private String Tb(String paramString)
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      if (localMediaMetadataRetriever == null) {
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { localException });
        localWebViewJSSDKVideoItem = null;
      }
      int i = bk.getInt(localWebViewJSSDKVideoItem.extractMetadata(18), 0);
      int j = bk.getInt(localWebViewJSSDKVideoItem.extractMetadata(19), 0);
      int k = bk.getInt(localWebViewJSSDKVideoItem.extractMetadata(9), 0);
      localWebViewJSSDKVideoItem.release();
      localWebViewJSSDKVideoItem.release();
      WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = WebViewJSSDKFileItem.Sk(paramString);
      localWebViewJSSDKVideoItem.duration = ((k + 500) / 1000);
      localWebViewJSSDKVideoItem.width = i;
      localWebViewJSSDKVideoItem.height = j;
      localWebViewJSSDKVideoItem.size = com.tencent.mm.a.e.bJ(paramString);
      if (this.rlB == 1) {
        localWebViewJSSDKVideoItem.goL = this.goL;
      }
      g.ccL().b(localWebViewJSSDKVideoItem);
      return localWebViewJSSDKVideoItem.bMB;
    }
  }
  
  private int Tc(String paramString)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse("file://" + paramString));
    aq.is2G(this);
    for (;;)
    {
      try
      {
        paramString = com.tencent.mm.compatible.j.a.h(this, (Intent)localObject);
        if (paramString == null)
        {
          y.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
          return -50005;
        }
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.OpenFileChooserUI", paramString, "", new Object[0]);
        paramString = null;
        continue;
        localObject = paramString.filename;
        boolean bool = c.pp((String)localObject);
        y.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
        i = -10000;
        if (bool)
        {
          i = SightVideoJNI.shouldRemuxing((String)localObject, 660, 500, 26214400, 300000.0D, 1000000);
          y.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", new Object[] { Integer.valueOf(i) });
        }
        if ((i == -1) || (!bool))
        {
          i = com.tencent.mm.a.e.bJ((String)localObject);
          y.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", new Object[] { Integer.valueOf(i) });
          if (i > 26214400) {
            i = -1;
          }
        }
        else
        {
          switch (i)
          {
          default: 
            y.e("MicroMsg.OpenFileChooserUI", "unknown check type");
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
      y.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramString.duration / 1000) });
      return i;
      j = 1;
    }
    return -50002;
  }
  
  private boolean cdB()
  {
    y.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", new Object[] { Long.valueOf(bk.fQ(this)) });
    return bk.fQ(this) > 200L;
  }
  
  private static boolean uq(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      y.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", new Object[] { paramString });
      if (localFile.exists())
      {
        y.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
        return true;
      }
      y.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
      return false;
    }
    y.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      paramIntent = new Intent();
      paramIntent.putExtra("key_pick_local_media_show_memory_warning", this.rlC);
      setResult(paramInt2, paramIntent);
      finish();
      return;
    }
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      y.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", new Object[] { Integer.valueOf(paramInt1) });
      setResult(1);
      finish();
      return;
    case 1: 
    case 3: 
      au.DS().O(new OpenFileChooserUI.4(this, paramIntent, paramInt2));
      return;
    case 2: 
      localObject1 = l.f(this.mController.uMN.getApplicationContext(), paramIntent, com.tencent.mm.compatible.util.e.dzD);
      if (bk.bl((String)localObject1))
      {
        y.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
        setResult(-2, paramIntent);
        finish();
        return;
      }
      y.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", new Object[] { localObject1 });
      paramIntent = new Intent();
      paramIntent.putExtra("key_send_raw_image", this.rlz);
      paramIntent.putExtra("max_select_count", this.pkq);
      paramIntent.putExtra("query_source_type", this.kIu);
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(localObject1);
      paramIntent.putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      paramIntent.putExtra("preview_image", true);
      paramIntent.addFlags(67108864);
      d.b(this, "gallery", ".ui.GalleryEntryUI", paramIntent, 3);
      return;
    case 5: 
      if (new File(this.goK).exists())
      {
        Ta(this.goK);
        return;
      }
      y.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", new Object[] { this.goK });
      setResult(1);
      finish();
      return;
    case 4: 
      paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        y.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
        setResult(1);
        finish();
        return;
      }
      y.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
      y.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { paramIntent.get(0) });
      if ((this.rlB == 1) && (!uq(this.goL))) {
        y.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
      }
      Ta((String)paramIntent.get(0));
      return;
    case 6: 
      y.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
      if (paramIntent != null)
      {
        y.i("MicroMsg.OpenFileChooserUI", "data is valid!");
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          y.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
          setResult(1);
          finish();
          return;
        }
        this.goK = paramIntent.mfj;
        y.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.goK });
        if ((!uq(this.goL)) && (uq(paramIntent.mfk))) {
          this.goL = paramIntent.mfk;
        }
        paramIntent = (Intent)localObject1;
        if (!TextUtils.isEmpty(this.goK)) {
          paramIntent = new File(this.goK);
        }
        if ((paramIntent != null) && (paramIntent.exists()))
        {
          y.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.goK });
          Ta(this.goK);
          return;
        }
        y.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.goK });
      }
      y.e("MicroMsg.OpenFileChooserUI", "data is null!");
      setResult(1);
      finish();
      return;
    case 7: 
      y.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
      if (paramIntent != null)
      {
        y.i("MicroMsg.OpenFileChooserUI", "data is valid!");
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          y.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
          setResult(1);
          finish();
          return;
        }
        if (paramIntent.mfh)
        {
          paramIntent = paramIntent.mfp;
          if (bk.bl(paramIntent))
          {
            y.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", new Object[] { paramIntent });
            setResult(1);
            finish();
            return;
          }
          localObject1 = new ArrayList();
          localObject2 = WebViewJSSDKFileItem.Si(paramIntent);
          ((WebViewJSSDKFileItem)localObject2).fNd = true;
          ((WebViewJSSDKFileItem)localObject2).bLN = 1;
          g.ccL().b((WebViewJSSDKFileItem)localObject2);
          ((ArrayList)localObject1).add(((WebViewJSSDKFileItem)localObject2).bMB);
          y.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", new Object[] { paramIntent, ((WebViewJSSDKFileItem)localObject2).bMB });
          paramIntent = am.X((ArrayList)localObject1);
          y.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { paramIntent });
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_pick_local_media_local_ids", paramIntent);
          ((Intent)localObject1).putExtra("key_pick_local_media_callback_type", 2);
          setResult(paramInt2, (Intent)localObject1);
          finish();
          return;
        }
        this.goK = paramIntent.mfj;
        y.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.goK });
        if ((!uq(this.goL)) && (uq(paramIntent.mfk))) {
          this.goL = paramIntent.mfk;
        }
        if (TextUtils.isEmpty(this.goK)) {
          break label1324;
        }
      }
      break;
    }
    label1324:
    for (paramIntent = new File(this.goK);; paramIntent = null)
    {
      if ((paramIntent != null) && (paramIntent.exists()))
      {
        y.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.goK });
        Ta(this.goK);
        return;
      }
      y.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.goK });
      y.e("MicroMsg.OpenFileChooserUI", "data is null!");
      setResult(1);
      finish();
      return;
      y.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
      localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        Ta((String)((ArrayList)localObject1).get(0));
        return;
      }
      localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      boolean bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      if (localObject1 == null)
      {
        y.e("MicroMsg.OpenFileChooserUI", "chosen is null");
        setResult(1);
        finish();
        return;
      }
      paramIntent = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        WebViewJSSDKFileItem localWebViewJSSDKFileItem = WebViewJSSDKFileItem.Si((String)localObject2);
        String str = localWebViewJSSDKFileItem.bMB;
        localWebViewJSSDKFileItem.fNd = bool;
        g.ccL().b(localWebViewJSSDKFileItem);
        y.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[] { localObject2, str });
        paramIntent.add(str);
      }
      paramIntent = am.X(paramIntent);
      y.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { paramIntent });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_pick_local_media_local_ids", paramIntent);
      ((Intent)localObject1).putExtra("key_pick_local_media_show_memory_warning", this.rlC);
      ((Intent)localObject1).putExtra("key_pick_local_media_callback_type", 2);
      setResult(paramInt2, (Intent)localObject1);
      finish();
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
    if ((this.count <= 0) || (this.count > 9)) {
      this.count = 9;
    }
    this.pkq = this.count;
    this.kIu = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
    this.kIU = getIntent().getIntExtra("query_media_type", 1);
    this.rlz = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
    this.rlA = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
    this.rlB = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
    int i;
    int j;
    if (((this.kIu == 7) && (this.kIU == 2)) || (this.kIU == 3))
    {
      if (!cdB())
      {
        com.tencent.mm.ui.base.s.makeText(this, getString(R.l.webview_memory_check_message), 1).show();
        this.rlC = true;
      }
      paramBundle = new Intent();
      paramBundle.putExtra("key_send_raw_image", this.rlz);
      paramBundle.putExtra("query_media_type", this.kIU);
      if (this.rlB == 1) {
        if ((this.rlA != 4096) && ((this.rlA & 0x1000) > 0))
        {
          i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
          j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
          paramBundle.putExtra("KEY_SIGHT_PARAMS", Cw(1));
          paramBundle.putExtra("record_video_force_sys_camera", false);
          paramBundle.putExtra("show_header_view", true);
          paramBundle.putExtra("record_video_is_sight_capture", true);
          paramBundle.putExtra("record_video_quality", i);
          paramBundle.putExtra("record_video_time_limit", j);
          paramBundle.putExtra("video_full_path", this.goK);
          l.d(this, this.pkq, this.kIu, paramBundle);
          if ((this.rlA == 4096) || ((this.rlA & 0x1000) <= 0)) {
            break label1026;
          }
          i = 1;
        }
      }
    }
    Object localObject;
    for (;;)
    {
      if (i == 0) {
        break label1070;
      }
      return;
      if ((this.rlA == 16) || (this.rlA == 256))
      {
        paramBundle.putExtra("KEY_SIGHT_PARAMS", Cw(1));
        l.a(this, 6, paramBundle, 3, 1);
        break;
      }
      if (this.rlA != 4096) {
        break;
      }
      paramBundle.putExtra("show_header_view", false);
      l.d(this, this.pkq, this.kIu, paramBundle);
      break;
      if (this.rlB == 2)
      {
        localObject = bk.pm(getIntent().getStringExtra("key_pick_local_media_sight_type"));
        if ((this.rlA != 4096) && ((this.rlA & 0x1000) > 0))
        {
          y.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
          setResult(1);
          finish();
          break;
        }
        if ((this.rlA == 16) || (this.rlA == 256))
        {
          i = 0;
          if ((((String)localObject).contains("video")) && (((String)localObject).contains("image"))) {
            i = 0;
          }
          for (;;)
          {
            paramBundle.putExtra("KEY_SIGHT_PARAMS", Cw(i));
            l.a(this, 7, paramBundle, 3, i);
            break;
            if (((String)localObject).contains("video")) {
              i = 1;
            } else if (((String)localObject).contains("image")) {
              i = 2;
            }
          }
        }
        if (this.rlA != 4096) {
          break;
        }
        i = 3;
        if ((((String)localObject).contains("image")) && (((String)localObject).contains("video"))) {
          i = 3;
        }
        for (;;)
        {
          paramBundle = new Intent();
          paramBundle.putExtra("key_can_select_video_and_pic", true);
          paramBundle.putExtra("key_send_raw_image", this.rlz);
          l.a(this, 8, this.pkq, this.kIu, i, false, paramBundle);
          break;
          if (((String)localObject).contains("image")) {
            i = 1;
          } else if (((String)localObject).contains("video")) {
            i = 2;
          }
        }
      }
      if ((this.rlA != 4096) && ((this.rlA & 0x1000) > 0))
      {
        this.goK = (com.tencent.mm.compatible.util.e.dzD + "microMsg." + System.currentTimeMillis() + ".mp4");
        i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
        j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        paramBundle.putExtra("record_video_force_sys_camera", true);
        paramBundle.putExtra("record_video_quality", i);
        paramBundle.putExtra("record_video_time_limit", j);
        paramBundle.putExtra("video_full_path", this.goK);
        l.d(this, this.pkq, this.kIu, paramBundle);
        break;
      }
      if ((this.rlA == 16) || (this.rlA == 256))
      {
        this.goK = (com.tencent.mm.compatible.util.e.dzD + "microMsg." + System.currentTimeMillis() + ".mp4");
        i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
        j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        paramBundle = this.goK;
        if (this.rlA == 16) {}
        for (boolean bool = true;; bool = false)
        {
          l.a(this, paramBundle, 5, j, i, bool);
          break;
        }
      }
      if (this.rlA != 4096) {
        break;
      }
      paramBundle.putExtra("show_header_view", false);
      l.d(this, this.pkq, this.kIu, paramBundle);
      break;
      label1026:
      if ((this.rlA == 16) || (this.rlA == 256)) {
        i = 1;
      } else if (this.rlA == 4096) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label1070:
    if (!cdB())
    {
      com.tencent.mm.ui.base.s.makeText(this, getString(R.l.webview_memory_check_message), 1).show();
      this.rlC = true;
    }
    paramBundle = new Intent();
    paramBundle.putExtra("key_send_raw_image", this.rlz);
    paramBundle.putExtra("query_media_type", this.kIU);
    switch (this.rlA)
    {
    default: 
      y.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
      setResult(0);
      finish();
      return;
    case 1: 
      paramBundle.putExtra("show_header_view", false);
      l.a(this, 1, this.pkq, this.kIu, paramBundle);
      return;
    case 2: 
      paramBundle = getString(R.l.webview_jssdk_take_photo);
      localObject = new OpenFileChooserUI.1(this);
      OpenFileChooserUI.2 local2 = new OpenFileChooserUI.2(this);
      h.a(this, "", new String[] { paramBundle }, "", true, (h.c)localObject, local2);
      return;
    }
    l.a(this, 1, this.count, this.kIu, paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.dnm != null) && (this.dnm.isShowing())) {
      this.dnm.dismiss();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.OpenFileChooserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      l.c(this.mController.uMN, com.tencent.mm.compatible.util.e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
      return;
    }
    h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new OpenFileChooserUI.3(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI
 * JD-Core Version:    0.7.0.1
 */
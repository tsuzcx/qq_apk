package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.compatible.j.a.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class OpenFileChooserUI
  extends MMActivity
{
  private int bQA;
  private int count;
  private ProgressDialog eeN = null;
  private String hIH;
  private String hII;
  private int neG;
  private int nfr;
  private boolean vbb;
  private int vbc;
  private int vbd;
  private boolean vbe = false;
  private DialogInterface.OnCancelListener vbf = null;
  
  private static boolean Cs(String paramString)
  {
    AppMethodBeat.i(7464);
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      ab.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", new Object[] { paramString });
      if (localFile.exists())
      {
        ab.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
        AppMethodBeat.o(7464);
        return true;
      }
      ab.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
      AppMethodBeat.o(7464);
      return false;
    }
    ab.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
    AppMethodBeat.o(7464);
    return false;
  }
  
  private void aib(String paramString)
  {
    AppMethodBeat.i(7460);
    this.vbf = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(7446);
        OpenFileChooserUI.this.setResult(0);
        OpenFileChooserUI.this.finish();
        AppMethodBeat.o(7446);
      }
    };
    getString(2131297087);
    this.eeN = h.b(this, getString(2131305867), true, this.vbf);
    com.tencent.mm.kernel.g.RO().ac(new OpenFileChooserUI.6(this, paramString));
    AppMethodBeat.o(7460);
  }
  
  private String aic(String paramString)
  {
    AppMethodBeat.i(7461);
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      if (localMediaMetadataRetriever == null)
      {
        AppMethodBeat.o(7461);
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { localException });
        localWebViewJSSDKVideoItem = null;
      }
      int i = bo.getInt(localWebViewJSSDKVideoItem.extractMetadata(18), 0);
      int j = bo.getInt(localWebViewJSSDKVideoItem.extractMetadata(19), 0);
      int k = bo.getInt(localWebViewJSSDKVideoItem.extractMetadata(9), 0);
      localWebViewJSSDKVideoItem.release();
      localWebViewJSSDKVideoItem.release();
      WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = WebViewJSSDKFileItem.ahu(paramString);
      localWebViewJSSDKVideoItem.duration = ((k + 500) / 1000);
      localWebViewJSSDKVideoItem.width = i;
      localWebViewJSSDKVideoItem.height = j;
      localWebViewJSSDKVideoItem.size = com.tencent.mm.a.e.cM(paramString);
      if (this.vbd == 1) {
        localWebViewJSSDKVideoItem.hII = this.hII;
      }
      com.tencent.mm.plugin.webview.modeltools.g.dcE().a(localWebViewJSSDKVideoItem);
      paramString = localWebViewJSSDKVideoItem.ctV;
      AppMethodBeat.o(7461);
    }
    return paramString;
  }
  
  private int aid(String paramString)
  {
    AppMethodBeat.i(7462);
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse("file://".concat(String.valueOf(paramString))));
    at.is2G(this);
    for (;;)
    {
      try
      {
        paramString = com.tencent.mm.compatible.j.a.j(this, (Intent)localObject);
        if (paramString == null)
        {
          ab.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
          AppMethodBeat.o(7462);
          return -50005;
        }
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.OpenFileChooserUI", paramString, "", new Object[0]);
        paramString = null;
        continue;
        localObject = paramString.filename;
        boolean bool = c.wE((String)localObject);
        ab.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
        i = -10000;
        if (bool)
        {
          i = SightVideoJNI.shouldRemuxing((String)localObject, 660, 500, 26214400, 300000.0D, 1000000);
          ab.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", new Object[] { Integer.valueOf(i) });
        }
        if ((i == -1) || (!bool))
        {
          i = com.tencent.mm.a.e.cM((String)localObject);
          ab.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", new Object[] { Integer.valueOf(i) });
          if (i > 26214400) {
            i = -1;
          }
        }
        else
        {
          switch (i)
          {
          default: 
            ab.e("MicroMsg.OpenFileChooserUI", "unknown check type");
            AppMethodBeat.o(7462);
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
      ab.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramString.duration / 1000) });
      AppMethodBeat.o(7462);
      return i;
      j = 1;
    }
    AppMethodBeat.o(7462);
    return -50002;
  }
  
  private boolean ddB()
  {
    AppMethodBeat.i(7456);
    ab.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", new Object[] { Long.valueOf(bo.hg(this)) });
    if (bo.hg(this) <= 200L)
    {
      AppMethodBeat.o(7456);
      return false;
    }
    AppMethodBeat.o(7456);
    return true;
  }
  
  private SightParams og(int paramInt)
  {
    AppMethodBeat.i(7457);
    String str1 = "microMsg_" + System.currentTimeMillis();
    this.hIH = (com.tencent.mm.compatible.util.e.esr + str1 + ".mp4");
    this.hII = (com.tencent.mm.compatible.util.e.esr + str1 + ".jpeg");
    int j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
    SightParams localSightParams = new SightParams(3, 1);
    if (this.vbc == 16) {}
    for (int i = 1;; i = 2)
    {
      localSightParams.oFP = i;
      localSightParams.mode = paramInt;
      if (localSightParams.fcu == null) {
        localSightParams.fcu = new VideoTransPara();
      }
      localSightParams.fcu.duration = j;
      String str2 = com.tencent.mm.compatible.util.e.esr + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
      localSightParams.q(str1, this.hIH, this.hII, str2);
      AppMethodBeat.o(7457);
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
    AppMethodBeat.i(7459);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      paramIntent = new Intent();
      paramIntent.putExtra("key_pick_local_media_show_memory_warning", this.vbe);
      setResult(paramInt2, paramIntent);
      finish();
      AppMethodBeat.o(7459);
      return;
    }
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      ab.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", new Object[] { Integer.valueOf(paramInt1) });
      setResult(1);
      finish();
      AppMethodBeat.o(7459);
      return;
    case 1: 
    case 3: 
      com.tencent.mm.plugin.webview.a.a.O(new OpenFileChooserUI.4(this, paramIntent, paramInt2));
      AppMethodBeat.o(7459);
      return;
    case 2: 
      localObject1 = n.h(getContext().getApplicationContext(), paramIntent, com.tencent.mm.compatible.util.e.esr);
      if (bo.isNullOrNil((String)localObject1))
      {
        ab.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
        setResult(-2, paramIntent);
        finish();
        AppMethodBeat.o(7459);
        return;
      }
      ab.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", new Object[] { localObject1 });
      paramIntent = new Intent();
      paramIntent.putExtra("key_send_raw_image", this.vbb);
      paramIntent.putExtra("max_select_count", this.bQA);
      paramIntent.putExtra("query_source_type", this.neG);
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(localObject1);
      paramIntent.putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      paramIntent.putExtra("preview_image", true);
      paramIntent.addFlags(67108864);
      d.b(this, "gallery", ".ui.GalleryEntryUI", paramIntent, 3);
      AppMethodBeat.o(7459);
      return;
    case 5: 
      if (new File(this.hIH).exists())
      {
        aib(this.hIH);
        AppMethodBeat.o(7459);
        return;
      }
      ab.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", new Object[] { this.hIH });
      setResult(1);
      finish();
      AppMethodBeat.o(7459);
      return;
    case 4: 
      paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        ab.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
        setResult(1);
        finish();
        AppMethodBeat.o(7459);
        return;
      }
      ab.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
      ab.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { paramIntent.get(0) });
      if ((this.vbd == 1) && (!Cs(this.hII))) {
        ab.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
      }
      aib((String)paramIntent.get(0));
      AppMethodBeat.o(7459);
      return;
    case 6: 
      ab.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
      if (paramIntent != null)
      {
        ab.i("MicroMsg.OpenFileChooserUI", "data is valid!");
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          ab.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
          setResult(1);
          finish();
          AppMethodBeat.o(7459);
          return;
        }
        this.hIH = paramIntent.oFI;
        ab.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.hIH });
        if ((!Cs(this.hII)) && (Cs(paramIntent.oFJ))) {
          this.hII = paramIntent.oFJ;
        }
        paramIntent = (Intent)localObject1;
        if (!TextUtils.isEmpty(this.hIH)) {
          paramIntent = new File(this.hIH);
        }
        if ((paramIntent != null) && (paramIntent.exists()))
        {
          ab.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.hIH });
          aib(this.hIH);
          AppMethodBeat.o(7459);
          return;
        }
        ab.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.hIH });
      }
      ab.e("MicroMsg.OpenFileChooserUI", "data is null!");
      setResult(1);
      finish();
      AppMethodBeat.o(7459);
      return;
    case 7: 
      ab.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
      if (paramIntent != null)
      {
        ab.i("MicroMsg.OpenFileChooserUI", "data is valid!");
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          ab.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
          setResult(1);
          finish();
          AppMethodBeat.o(7459);
          return;
        }
        if (paramIntent.oFG)
        {
          paramIntent = paramIntent.oFO;
          if (bo.isNullOrNil(paramIntent))
          {
            ab.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", new Object[] { paramIntent });
            setResult(1);
            finish();
            AppMethodBeat.o(7459);
            return;
          }
          localObject1 = new ArrayList();
          localObject2 = WebViewJSSDKFileItem.ahf(paramIntent);
          ((WebViewJSSDKFileItem)localObject2).hgn = true;
          ((WebViewJSSDKFileItem)localObject2).cth = 1;
          com.tencent.mm.plugin.webview.modeltools.g.dcE().a((WebViewJSSDKFileItem)localObject2);
          ((ArrayList)localObject1).add(((WebViewJSSDKFileItem)localObject2).ctV);
          ab.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", new Object[] { paramIntent, ((WebViewJSSDKFileItem)localObject2).ctV });
          paramIntent = ar.ac((ArrayList)localObject1);
          ab.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { paramIntent });
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_pick_local_media_local_ids", paramIntent);
          ((Intent)localObject1).putExtra("key_pick_local_media_callback_type", 2);
          setResult(paramInt2, (Intent)localObject1);
          finish();
          AppMethodBeat.o(7459);
          return;
        }
        this.hIH = paramIntent.oFI;
        ab.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.hIH });
        if ((!Cs(this.hII)) && (Cs(paramIntent.oFJ))) {
          this.hII = paramIntent.oFJ;
        }
        if (TextUtils.isEmpty(this.hIH)) {
          break label1442;
        }
      }
      break;
    }
    label1442:
    for (paramIntent = new File(this.hIH);; paramIntent = null)
    {
      if ((paramIntent != null) && (paramIntent.exists()))
      {
        ab.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.hIH });
        aib(this.hIH);
        AppMethodBeat.o(7459);
        return;
      }
      ab.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.hIH });
      ab.e("MicroMsg.OpenFileChooserUI", "data is null!");
      setResult(1);
      finish();
      AppMethodBeat.o(7459);
      return;
      ab.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
      localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        aib((String)((ArrayList)localObject1).get(0));
        AppMethodBeat.o(7459);
        return;
      }
      localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      boolean bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      if (localObject1 == null)
      {
        ab.e("MicroMsg.OpenFileChooserUI", "chosen is null");
        setResult(1);
        finish();
        AppMethodBeat.o(7459);
        return;
      }
      paramIntent = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        WebViewJSSDKFileItem localWebViewJSSDKFileItem = WebViewJSSDKFileItem.ahf((String)localObject2);
        String str = localWebViewJSSDKFileItem.ctV;
        localWebViewJSSDKFileItem.hgn = bool;
        com.tencent.mm.plugin.webview.modeltools.g.dcE().a(localWebViewJSSDKFileItem);
        ab.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[] { localObject2, str });
        paramIntent.add(str);
      }
      paramIntent = ar.ac(paramIntent);
      ab.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { paramIntent });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_pick_local_media_local_ids", paramIntent);
      ((Intent)localObject1).putExtra("key_pick_local_media_show_memory_warning", this.vbe);
      ((Intent)localObject1).putExtra("key_pick_local_media_callback_type", 2);
      setResult(paramInt2, (Intent)localObject1);
      finish();
      AppMethodBeat.o(7459);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 3;
    AppMethodBeat.i(7455);
    super.onCreate(paramBundle);
    this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
    if ((this.count <= 0) || (this.count > 9)) {
      this.count = 9;
    }
    this.bQA = this.count;
    this.neG = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
    this.nfr = getIntent().getIntExtra("query_media_type", 1);
    this.vbb = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
    this.vbc = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
    this.vbd = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
    int j;
    label378:
    Object localObject;
    if (((this.neG == 7) && (this.nfr == 2)) || (this.nfr == 3))
    {
      if (!ddB())
      {
        t.makeText(this, getString(2131305884), 1).show();
        this.vbe = true;
      }
      paramBundle = new Intent();
      paramBundle.putExtra("key_send_raw_image", this.vbb);
      paramBundle.putExtra("query_media_type", this.nfr);
      if (this.vbd == 1) {
        if ((this.vbc != 4096) && ((this.vbc & 0x1000) > 0))
        {
          i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
          j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
          paramBundle.putExtra("KEY_SIGHT_PARAMS", og(1));
          paramBundle.putExtra("record_video_force_sys_camera", false);
          paramBundle.putExtra("show_header_view", true);
          paramBundle.putExtra("record_video_is_sight_capture", true);
          paramBundle.putExtra("record_video_quality", i);
          paramBundle.putExtra("record_video_time_limit", j);
          paramBundle.putExtra("video_full_path", this.hIH);
          n.e(this, this.bQA, this.neG, paramBundle);
        }
      }
      for (;;)
      {
        if ((this.vbc != 4096) && ((this.vbc & 0x1000) > 0))
        {
          i = 1;
          if (i == 0) {
            break label1082;
          }
          AppMethodBeat.o(7455);
          return;
          if ((this.vbc == 16) || (this.vbc == 256))
          {
            paramBundle.putExtra("KEY_SIGHT_PARAMS", og(1));
            n.a(this, 6, paramBundle, 3, 1);
          }
          else if (this.vbc == 4096)
          {
            paramBundle.putExtra("show_header_view", false);
            n.e(this, this.bQA, this.neG, paramBundle);
            continue;
            if (this.vbd == 2)
            {
              localObject = bo.nullAsNil(getIntent().getStringExtra("key_pick_local_media_sight_type"));
              if ((this.vbc != 4096) && ((this.vbc & 0x1000) > 0))
              {
                ab.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
                setResult(1);
                finish();
                continue;
              }
              if ((this.vbc == 16) || (this.vbc == 256)) {
                if ((((String)localObject).contains("video")) && (((String)localObject).contains("image"))) {
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
      paramBundle.putExtra("KEY_SIGHT_PARAMS", og(i));
      n.a(this, 7, paramBundle, 3, i);
      break;
      if (((String)localObject).contains("video"))
      {
        i = 1;
      }
      else
      {
        if (((String)localObject).contains("image"))
        {
          i = 2;
          continue;
          if (this.vbc != 4096) {
            break;
          }
          if ((((String)localObject).contains("image")) && (((String)localObject).contains("video"))) {}
          for (;;)
          {
            paramBundle = new Intent();
            paramBundle.putExtra("key_can_select_video_and_pic", true);
            paramBundle.putExtra("key_send_raw_image", this.vbb);
            n.a(this, 8, this.bQA, this.neG, i, paramBundle);
            break;
            if (((String)localObject).contains("image")) {
              i = 1;
            } else if (((String)localObject).contains("video")) {
              i = 2;
            }
          }
          if ((this.vbc != 4096) && ((this.vbc & 0x1000) > 0))
          {
            this.hIH = (com.tencent.mm.compatible.util.e.esr + "microMsg." + System.currentTimeMillis() + ".mp4");
            i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
            j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
            paramBundle.putExtra("record_video_force_sys_camera", true);
            paramBundle.putExtra("record_video_quality", i);
            paramBundle.putExtra("record_video_time_limit", j);
            paramBundle.putExtra("video_full_path", this.hIH);
            n.e(this, this.bQA, this.neG, paramBundle);
            break;
          }
          if ((this.vbc == 16) || (this.vbc == 256))
          {
            this.hIH = (com.tencent.mm.compatible.util.e.esr + "microMsg." + System.currentTimeMillis() + ".mp4");
            i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
            j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
            paramBundle = this.hIH;
            if (this.vbc == 16) {}
            for (boolean bool = true;; bool = false)
            {
              n.a(this, paramBundle, 5, j, i, bool);
              break;
            }
          }
          if (this.vbc != 4096) {
            break;
          }
          paramBundle.putExtra("show_header_view", false);
          n.e(this, this.bQA, this.neG, paramBundle);
          break;
          if ((this.vbc == 16) || (this.vbc == 256))
          {
            i = 1;
            break label378;
          }
          if (this.vbc == 4096)
          {
            i = 1;
            break label378;
          }
          i = 0;
          break label378;
          label1082:
          if (!ddB())
          {
            t.makeText(this, getString(2131305884), 1).show();
            this.vbe = true;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("key_send_raw_image", this.vbb);
          paramBundle.putExtra("query_media_type", this.nfr);
          switch (this.vbc)
          {
          default: 
            ab.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
            setResult(0);
            finish();
            AppMethodBeat.o(7455);
            return;
          case 1: 
            paramBundle.putExtra("show_header_view", false);
            n.a(this, 1, this.bQA, this.neG, paramBundle);
            AppMethodBeat.o(7455);
            return;
          case 2: 
            paramBundle = getString(2131305874);
            localObject = new OpenFileChooserUI.1(this);
            OpenFileChooserUI.2 local2 = new OpenFileChooserUI.2(this);
            h.a(this, "", new String[] { paramBundle }, "", true, (h.c)localObject, local2);
            AppMethodBeat.o(7455);
            return;
          }
          n.a(this, 1, this.count, this.neG, paramBundle);
          AppMethodBeat.o(7455);
          return;
        }
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7463);
    super.onDestroy();
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
    AppMethodBeat.o(7463);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(7458);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(7458);
      return;
    }
    ab.i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(7458);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        n.c(getContext(), com.tencent.mm.compatible.util.e.esr, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        AppMethodBeat.o(7458);
        return;
      }
      h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131296888), false, new OpenFileChooserUI.3(this), null);
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
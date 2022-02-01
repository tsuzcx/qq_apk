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
import com.tencent.mm.compatible.i.a.a;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class OpenFileChooserUI
  extends MMActivity
{
  private boolean EsU;
  private boolean Jeu;
  private int Jev;
  private int Jew;
  private String Jex;
  private boolean Jey = false;
  private DialogInterface.OnCancelListener Jez = null;
  private int count;
  private int das;
  private ProgressDialog gtM = null;
  private int het;
  private String lPw;
  private String lPx;
  private int xos;
  
  private static boolean aad(String paramString)
  {
    AppMethodBeat.i(79662);
    if (!TextUtils.isEmpty(paramString))
    {
      o localo = new o(paramString);
      Log.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", new Object[] { paramString });
      if (localo.exists())
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
  
  private void bac(final String paramString)
  {
    AppMethodBeat.i(79658);
    this.Jez = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(175754);
        OpenFileChooserUI.this.setResult(0);
        OpenFileChooserUI.this.finish();
        AppMethodBeat.o(175754);
      }
    };
    getString(2131755998);
    this.gtM = h.a(this, getString(2131768572), true, this.Jez);
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175762);
        Object localObject1 = new ArrayList();
        int i = OpenFileChooserUI.a(OpenFileChooserUI.this, paramString);
        if (i == -50002)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175756);
              if ((OpenFileChooserUI.b(OpenFileChooserUI.this) == 7) && (OpenFileChooserUI.c(OpenFileChooserUI.this) == 2))
              {
                h.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(2131768573), OpenFileChooserUI.this.getString(2131755998), OpenFileChooserUI.this.getString(2131755874), false, new DialogInterface.OnClickListener()
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
              Toast.makeText(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(2131767068), 0).show();
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
          localObject1 = OpenFileChooserUI.G(paramString, (List)localObject1);
          OpenFileChooserUI.b(OpenFileChooserUI.this, paramString);
          localObject2 = OpenFileChooserUI.d(OpenFileChooserUI.this);
        }
        while (!Util.isNullOrNil((String)localObject1))
        {
          MMHandlerThread.postToMainThread(new OpenFileChooserUI.8.4(this, (String)localObject1, (String)localObject2));
          AppMethodBeat.o(175762);
          return;
          if (i == 1)
          {
            String str1 = OpenFileChooserUI.c(OpenFileChooserUI.this, paramString);
            OpenFileChooserUI.b(OpenFileChooserUI.this, paramString);
            String str2 = OpenFileChooserUI.d(OpenFileChooserUI.this);
            localObject2 = str2;
            localObject1 = str1;
            if (Util.isNullOrNil(str1))
            {
              localObject2 = str2;
              localObject1 = str1;
              if (OpenFileChooserUI.b(OpenFileChooserUI.this) == 7)
              {
                localObject2 = str2;
                localObject1 = str1;
                if (OpenFileChooserUI.c(OpenFileChooserUI.this) == 2)
                {
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(175758);
                      h.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(2131768574), OpenFileChooserUI.this.getString(2131755998), OpenFileChooserUI.this.getString(2131755874), false, new DialogInterface.OnClickListener()
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
            MMHandlerThread.postToMainThread(new Runnable()
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
        MMHandlerThread.postToMainThread(new Runnable()
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
  
  private String bad(String paramString)
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
      WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = WebViewJSSDKFileItem.bxg(paramString);
      localWebViewJSSDKVideoItem.duration = ((k + 500) / 1000);
      localWebViewJSSDKVideoItem.width = i;
      localWebViewJSSDKVideoItem.height = j;
      localWebViewJSSDKVideoItem.size = ((int)com.tencent.mm.vfs.s.boW(paramString));
      if (this.Jew == 1) {
        localWebViewJSSDKVideoItem.lPx = this.lPx;
      }
      com.tencent.mm.plugin.webview.modeltools.g.gdv().a(localWebViewJSSDKVideoItem);
      paramString = localWebViewJSSDKVideoItem.dJX;
      AppMethodBeat.o(79659);
    }
    return paramString;
  }
  
  private int bae(String paramString)
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
        boolean bool = com.tencent.mm.plugin.a.c.Sx((String)localObject);
        Log.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
        i = -10000;
        if (bool)
        {
          i = SightVideoJNI.shouldRemuxingVFS((String)localObject, 660, 500, 26214400, 300000.0D, 1000000);
          Log.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", new Object[] { Integer.valueOf(i) });
        }
        if ((i == -1) || (!bool))
        {
          i = (int)com.tencent.mm.vfs.s.boW((String)localObject);
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
  
  private boolean ger()
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
  
  private SightParams xi(int paramInt)
  {
    AppMethodBeat.i(79655);
    String str1 = "microMsg_" + System.currentTimeMillis();
    this.lPw = (b.aKV() + str1 + ".mp4");
    this.lPx = (b.aKV() + str1 + ".jpeg");
    int j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
    SightParams localSightParams = new SightParams(3, 1);
    if (this.Jev == 16) {}
    for (int i = 1;; i = 2)
    {
      localSightParams.zsH = i;
      localSightParams.mode = paramInt;
      if (localSightParams.irT == null) {
        localSightParams.irT = new VideoTransPara();
      }
      localSightParams.irT.duration = j;
      String str2 = AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
      localSightParams.v(str1, this.lPw, this.lPx, str2);
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
      paramIntent.putExtra("key_pick_local_media_show_memory_warning", this.Jey);
      setResult(paramInt2, paramIntent);
      finish();
      AppMethodBeat.o(79657);
      return;
    }
    Object localObject2;
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
      com.tencent.mm.plugin.webview.a.a.aj(new OpenFileChooserUI.6(this, paramIntent, paramInt2));
      AppMethodBeat.o(79657);
      return;
    case 2: 
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.s.h(getContext().getApplicationContext(), paramIntent, b.aKV());
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
        setResult(-2, paramIntent);
        finish();
        AppMethodBeat.o(79657);
        return;
      }
      Log.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", new Object[] { localObject1 });
      paramIntent = new Intent();
      paramIntent.putExtra("key_send_raw_image", this.Jeu);
      paramIntent.putExtra("max_select_count", this.das);
      paramIntent.putExtra("query_source_type", this.het);
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(localObject1);
      paramIntent.putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      paramIntent.putExtra("preview_image", true);
      paramIntent.addFlags(67108864);
      com.tencent.mm.br.c.b(this, "gallery", ".ui.GalleryEntryUI", paramIntent, 3);
      AppMethodBeat.o(79657);
      return;
    case 5: 
      if (new o(this.lPw).exists())
      {
        bac(this.lPw);
        AppMethodBeat.o(79657);
        return;
      }
      Log.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", new Object[] { this.lPw });
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
      if ((this.Jew == 1) && (!aad(this.lPx))) {
        Log.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
      }
      bac((String)paramIntent.get(0));
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
        this.lPw = paramIntent.zsA;
        Log.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.lPw });
        if ((!aad(this.lPx)) && (aad(paramIntent.zsB))) {
          this.lPx = paramIntent.zsB;
        }
        paramIntent = (Intent)localObject1;
        if (!TextUtils.isEmpty(this.lPw)) {
          paramIntent = new o(this.lPw);
        }
        if ((paramIntent != null) && (paramIntent.exists()))
        {
          Log.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.lPw });
          bac(this.lPw);
          AppMethodBeat.o(79657);
          return;
        }
        Log.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.lPw });
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
        if (paramIntent.zsy)
        {
          paramIntent = paramIntent.zsG;
          if (Util.isNullOrNil(paramIntent))
          {
            Log.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", new Object[] { paramIntent });
            setResult(1);
            finish();
            AppMethodBeat.o(79657);
            return;
          }
          localObject1 = new ArrayList();
          localObject2 = WebViewJSSDKFileItem.bxe(paramIntent);
          ((WebViewJSSDKFileItem)localObject2).laV = true;
          ((WebViewJSSDKFileItem)localObject2).mediaType = 1;
          com.tencent.mm.plugin.webview.modeltools.g.gdv().a((WebViewJSSDKFileItem)localObject2);
          ((ArrayList)localObject1).add(((WebViewJSSDKFileItem)localObject2).dJX);
          Log.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", new Object[] { paramIntent, ((WebViewJSSDKFileItem)localObject2).dJX });
          if (Util.isEqual(this.Jex, "chooseImage"))
          {
            paramIntent = ay.bb((ArrayList)localObject1);
            Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { paramIntent });
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_pick_local_media_local_ids", paramIntent);
            ((Intent)localObject1).putExtra("key_pick_local_media_callback_type", 2);
            ((Intent)localObject1).putExtra("key_pick_local_media_show_memory_warning", this.Jey);
            if (!this.EsU) {
              break label1054;
            }
          }
          label1054:
          for (paramIntent = "camera";; paramIntent = "album")
          {
            ((Intent)localObject1).putExtra("key_pick_local_pic_source_type", paramIntent);
            setResult(paramInt2, (Intent)localObject1);
            finish();
            AppMethodBeat.o(79657);
            return;
            paramIntent = ay.bc((ArrayList)localObject1);
            break;
          }
        }
        this.lPw = paramIntent.zsA;
        Log.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[] { this.lPw });
        if ((!aad(this.lPx)) && (aad(paramIntent.zsB))) {
          this.lPx = paramIntent.zsB;
        }
        if (TextUtils.isEmpty(this.lPw)) {
          break label1554;
        }
      }
      break;
    }
    label1547:
    label1554:
    for (paramIntent = new o(this.lPw);; paramIntent = null)
    {
      if ((paramIntent != null) && (paramIntent.exists()))
      {
        Log.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[] { this.lPw });
        bac(this.lPw);
        AppMethodBeat.o(79657);
        return;
      }
      Log.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[] { this.lPw });
      Log.e("MicroMsg.OpenFileChooserUI", "data is null!");
      setResult(1);
      finish();
      AppMethodBeat.o(79657);
      return;
      Log.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
      localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        bac((String)((ArrayList)localObject1).get(0));
        AppMethodBeat.o(79657);
        return;
      }
      localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      boolean bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.OpenFileChooserUI", "chosen is null");
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
        WebViewJSSDKFileItem localWebViewJSSDKFileItem = WebViewJSSDKFileItem.bxe((String)localObject2);
        String str = localWebViewJSSDKFileItem.dJX;
        localWebViewJSSDKFileItem.laV = bool;
        com.tencent.mm.plugin.webview.modeltools.g.gdv().a(localWebViewJSSDKFileItem);
        Log.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[] { localObject2, str });
        paramIntent.add(str);
      }
      if (Util.isEqual(this.Jex, "chooseImage"))
      {
        paramIntent = ay.bb(paramIntent);
        Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { paramIntent });
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_pick_local_media_local_ids", paramIntent);
        ((Intent)localObject1).putExtra("key_pick_local_media_show_memory_warning", this.Jey);
        ((Intent)localObject1).putExtra("key_pick_local_media_callback_type", 2);
        if (!this.EsU) {
          break label1547;
        }
      }
      for (paramIntent = "camera";; paramIntent = "album")
      {
        ((Intent)localObject1).putExtra("key_pick_local_pic_source_type", paramIntent);
        setResult(paramInt2, (Intent)localObject1);
        finish();
        AppMethodBeat.o(79657);
        return;
        paramIntent = ay.bc(paramIntent);
        break;
      }
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
    this.das = this.count;
    this.het = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
    this.xos = getIntent().getIntExtra("query_media_type", 1);
    this.Jeu = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
    this.Jev = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
    this.Jew = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
    this.Jex = getIntent().getStringExtra("key_pick_local_media_choose_type");
    boolean bool;
    int j;
    if ((this.Jev & 0x1000) == 0)
    {
      bool = true;
      this.EsU = bool;
      if (((this.het != 7) || (this.xos != 2)) && (this.xos != 3)) {
        break label1113;
      }
      if (!ger())
      {
        u.makeText(this, getString(2131768589), 1).show();
        this.Jey = true;
      }
      paramBundle = new Intent();
      paramBundle.putExtra("key_send_raw_image", this.Jeu);
      paramBundle.putExtra("query_media_type", this.xos);
      if (this.Jew != 1) {
        break label509;
      }
      if ((this.Jev == 4096) || ((this.Jev & 0x1000) <= 0)) {
        break label429;
      }
      i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
      j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
      paramBundle.putExtra("KEY_SIGHT_PARAMS", xi(1));
      paramBundle.putExtra("record_video_force_sys_camera", false);
      paramBundle.putExtra("show_header_view", true);
      paramBundle.putExtra("record_video_is_sight_capture", true);
      paramBundle.putExtra("record_video_quality", i);
      paramBundle.putExtra("record_video_time_limit", j);
      paramBundle.putExtra("video_full_path", this.lPw);
      com.tencent.mm.pluginsdk.ui.tools.s.e(this, this.das, this.het, paramBundle);
    }
    label412:
    label429:
    label509:
    String str;
    for (;;)
    {
      if ((this.Jev != 4096) && ((this.Jev & 0x1000) > 0))
      {
        i = 1;
        if (i == 0) {
          break label1118;
        }
        AppMethodBeat.o(79653);
        return;
        bool = false;
        break;
        if ((this.Jev == 16) || (this.Jev == 256))
        {
          paramBundle.putExtra("KEY_SIGHT_PARAMS", xi(1));
          com.tencent.mm.pluginsdk.ui.tools.s.a(this, 6, paramBundle, 3, 1);
        }
        else if (this.Jev == 4096)
        {
          paramBundle.putExtra("show_header_view", false);
          com.tencent.mm.pluginsdk.ui.tools.s.e(this, this.das, this.het, paramBundle);
          continue;
          if (this.Jew == 2)
          {
            str = Util.nullAsNil(getIntent().getStringExtra("key_pick_local_media_sight_type"));
            if ((this.Jev != 4096) && ((this.Jev & 0x1000) > 0))
            {
              Log.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
              setResult(1);
              finish();
              continue;
            }
            if ((this.Jev == 16) || (this.Jev == 256)) {
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
      paramBundle.putExtra("KEY_SIGHT_PARAMS", xi(i));
      com.tencent.mm.pluginsdk.ui.tools.s.a(this, 7, paramBundle, 3, i);
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
          if (this.Jev != 4096) {
            break;
          }
          if ((str.contains("image")) && (str.contains("video"))) {}
          for (;;)
          {
            paramBundle = new Intent();
            paramBundle.putExtra("key_can_select_video_and_pic", true);
            paramBundle.putExtra("key_send_raw_image", this.Jeu);
            com.tencent.mm.pluginsdk.ui.tools.s.a(this, 8, this.das, this.het, i, paramBundle);
            break;
            if (str.contains("image")) {
              i = 1;
            } else if (str.contains("video")) {
              i = 2;
            }
          }
          if ((this.Jev != 4096) && ((this.Jev & 0x1000) > 0))
          {
            this.lPw = (b.aKV() + "microMsg." + System.currentTimeMillis() + ".mp4");
            i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
            j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
            paramBundle.putExtra("record_video_force_sys_camera", true);
            paramBundle.putExtra("record_video_quality", i);
            paramBundle.putExtra("record_video_time_limit", j);
            paramBundle.putExtra("video_full_path", this.lPw);
            com.tencent.mm.pluginsdk.ui.tools.s.e(this, this.das, this.het, paramBundle);
            break;
          }
          if ((this.Jev == 16) || (this.Jev == 256))
          {
            this.lPw = (b.aKV() + "microMsg." + System.currentTimeMillis() + ".mp4");
            i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
            j = getIntent().getIntExtra("key_pick_local_media_duration", 60);
            paramBundle = this.lPw;
            if (this.Jev == 16) {}
            for (bool = true;; bool = false)
            {
              com.tencent.mm.pluginsdk.ui.tools.s.a(this, paramBundle, 5, j, i, bool);
              break;
            }
          }
          if (this.Jev != 4096) {
            break;
          }
          paramBundle.putExtra("show_header_view", false);
          com.tencent.mm.pluginsdk.ui.tools.s.e(this, this.das, this.het, paramBundle);
          break;
          if ((this.Jev == 16) || (this.Jev == 256))
          {
            i = 1;
            break label412;
          }
          if (this.Jev == 4096)
          {
            i = 1;
            break label412;
          }
          label1113:
          i = 0;
          break label412;
          label1118:
          if (!ger())
          {
            u.makeText(this, getString(2131768589), 1).show();
            this.Jey = true;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("key_send_raw_image", this.Jeu);
          paramBundle.putExtra("query_media_type", this.xos);
          switch (this.Jev)
          {
          default: 
            Log.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
            setResult(0);
            finish();
            AppMethodBeat.o(79653);
            return;
          case 1: 
            paramBundle.putExtra("show_header_view", false);
            com.tencent.mm.pluginsdk.ui.tools.s.a(this, 1, this.das, this.het, paramBundle);
            AppMethodBeat.o(79653);
            return;
          case 2: 
            paramBundle = new l(this);
            paramBundle.HLX = new OpenFileChooserUI.1(this);
            paramBundle.HLY = new OpenFileChooserUI.2(this);
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
            paramBundle.gXI();
            AppMethodBeat.o(79653);
            return;
          }
          com.tencent.mm.pluginsdk.ui.tools.s.a(this, 1, this.count, this.het, paramBundle);
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
    if ((this.gtM != null) && (this.gtM.isShowing())) {
      this.gtM.dismiss();
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
        com.tencent.mm.pluginsdk.ui.tools.s.d(getContext(), b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        AppMethodBeat.o(79656);
        return;
      }
      h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131755761), false, new OpenFileChooserUI.5(this), null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI
 * JD-Core Version:    0.7.0.1
 */
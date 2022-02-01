package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.mediabasic.data.MediaResultInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaSingleInfo;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.util.e;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.cover.edit.SnsCoverFinderPreviewUI;
import com.tencent.mm.plugin.sns.cover.edit.SnsCoverImageEditPluginLayout;
import com.tencent.mm.plugin.sns.cover.edit.SnsCoverVideoEditPluginLayout;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.r.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.s;

public class SettingSnsBackgroundUI
  extends MMPreference
{
  protected String filePath;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  
  private void baB(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(308368);
    Object localObject = com.tencent.mm.plugin.sns.cover.b.a.QkS;
    if (com.tencent.mm.plugin.sns.cover.b.a.hes())
    {
      localObject = MimeTypeUtil.getMimeTypeByFilePath(paramString);
      Log.i("MicroMsg.SettingSnsBackgroundUI", "mediaEdit mimeType:%s", new Object[] { localObject });
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        AppMethodBeat.o(308368);
        return;
      }
      if (((String)localObject).contains("image"))
      {
        localObject = e.Obp;
        paramString = RecordConfigProvider.lj(paramString, e.getTmpFilePath("sns_cover"));
        paramString.cD(1, SnsCoverImageEditPluginLayout.class.getName());
        localObject = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
        com.tencent.mm.plugin.sns.cover.c.b.akl(1);
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.sns.cover.b.a.QkS;
        paramString.oXZ = com.tencent.mm.plugin.sns.cover.b.a.hev();
        paramString.NHZ = (paramString.oXZ.duration * 1000);
        paramString.NIc = false;
        localObject = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 8, b.a.sight_slide_bottom_in, -1, paramString, i, 0);
        AppMethodBeat.o(308368);
        return;
        localObject = e.Obp;
        localObject = e.l("sns_cover", new String[] { "video", "thumb" });
        paramString = RecordConfigProvider.aM(paramString, localObject[0], localObject[1]);
        paramString.cD(2, SnsCoverVideoEditPluginLayout.class.getName());
        localObject = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
        com.tencent.mm.plugin.sns.cover.c.b.akl(2);
        i = 2;
      }
    }
    localObject = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
    com.tencent.mm.plugin.sns.cover.c.b.akl(1);
    localObject = new Intent();
    ((Intent)localObject).putExtra("CropImageMode", 1);
    ((Intent)localObject).putExtra("CropImage_ImgPath", paramString);
    paramString = g.getMessageDigest((paramString + System.currentTimeMillis()).getBytes());
    ((Intent)localObject).putExtra("CropImage_OutputPath", al.getAccSnsTmpPath() + paramString);
    com.tencent.mm.plugin.sns.d.a.pFn.a(this, (Intent)localObject, 6);
    AppMethodBeat.o(308368);
  }
  
  private void fBt()
  {
    AppMethodBeat.i(98255);
    Object localObject1 = com.tencent.mm.plugin.sns.cover.b.a.QkS;
    if (com.tencent.mm.plugin.sns.cover.b.a.hes())
    {
      localObject1 = e.Obp;
      localObject1 = e.l("sns_cover", new String[] { "video", "thumb" });
      localObject1 = RecordConfigProvider.lk(localObject1[0], localObject1[1]);
      ((RecordConfigProvider)localObject1).cD(1, SnsCoverImageEditPluginLayout.class.getName());
      ((RecordConfigProvider)localObject1).cD(2, SnsCoverVideoEditPluginLayout.class.getName());
      Object localObject2 = com.tencent.mm.plugin.sns.cover.b.a.QkS;
      ((RecordConfigProvider)localObject1).oXZ = com.tencent.mm.plugin.sns.cover.b.a.hev();
      ((RecordConfigProvider)localObject1).NHZ = (((RecordConfigProvider)localObject1).oXZ.duration * 1000);
      ((RecordConfigProvider)localObject1).NIc = true;
      ((RecordConfigProvider)localObject1).NHY = Boolean.FALSE;
      localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      com.tencent.mm.plugin.recordvideo.jumper.a.b(getContext(), 8, b.a.sight_slide_bottom_in, -1, (RecordConfigProvider)localObject1);
    }
    for (;;)
    {
      j.QFS.QGL.jfu = 2;
      AppMethodBeat.o(98255);
      return;
      if (!t.d(this, com.tencent.mm.loader.i.b.bmL(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
        Toast.makeText(this, getString(b.j.selectcameraapp_none), 1).show();
      }
    }
  }
  
  private void o(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(98251);
    Object localObject1;
    Object localObject2;
    label283:
    label289:
    Object localObject3;
    Object localObject4;
    label322:
    Object localObject5;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 7: 
    default: 
      Log.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
      AppMethodBeat.o(98251);
      return;
    case 2: 
      Log.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
      this.filePath = t.g(getApplicationContext(), paramIntent, al.getAccSnsTmpPath());
      if (this.filePath == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      baB(this.filePath);
      AppMethodBeat.o(98251);
      return;
    case 5: 
      Log.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
      if (paramIntent == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      this.filePath = com.tencent.mm.ui.tools.b.i(getApplicationContext(), paramIntent, al.getAccSnsTmpPath());
      if (this.filePath == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      baB(this.filePath);
      AppMethodBeat.o(98251);
      return;
    case 8: 
      com.tencent.mm.plugin.sns.d.a.pFo.aDz();
      localObject1 = (MediaResultInfo)paramIntent.getParcelableExtra("media_basic_out_model");
      if ((localObject1 == null) || (((MediaResultInfo)localObject1).result != true))
      {
        Log.e("MicroMsg.SettingSnsBackgroundUI", "CaptureVideoNormalModel is null");
        AppMethodBeat.o(98251);
        return;
      }
      localObject2 = ((Iterable)((MediaResultInfo)localObject1).ofu).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          paramIntent = ((Iterator)localObject2).next();
          if (((MediaSingleInfo)paramIntent).KON == com.tencent.mm.plugin.mediabasic.data.a.KOz)
          {
            paramInt = 1;
            if (paramInt == 0) {
              continue;
            }
            if (paramIntent == null) {
              break label461;
            }
            paramInt = 1;
            if (paramInt == 0) {
              break label959;
            }
            localObject3 = al.hgx();
            localObject1 = ((MediaResultInfo)localObject1).ofu;
            localObject2 = "";
            paramIntent = "";
            localObject4 = ((ArrayList)localObject1).iterator();
            localObject1 = "";
            if (!((Iterator)localObject4).hasNext()) {
              break label466;
            }
            localObject5 = (MediaSingleInfo)((Iterator)localObject4).next();
            if (((MediaSingleInfo)localObject5).KON == com.tencent.mm.plugin.mediabasic.data.a.KOz)
            {
              localObject2 = ((MediaSingleInfo)localObject5).path;
              Log.i("MicroMsg.UploadManager", "videoPath:%s", new Object[] { localObject2 });
            }
            if (((MediaSingleInfo)localObject5).KON == com.tencent.mm.plugin.mediabasic.data.a.KOC)
            {
              localObject1 = ((MediaSingleInfo)localObject5).path;
              Log.i("MicroMsg.UploadManager", "thumbPath:%s", new Object[] { localObject1 });
            }
            if (((MediaSingleInfo)localObject5).KON != com.tencent.mm.plugin.mediabasic.data.a.KOB) {
              break label1391;
            }
            paramIntent = ((MediaSingleInfo)localObject5).path;
            Log.i("MicroMsg.UploadManager", "coverPath:%s", new Object[] { paramIntent });
          }
        }
      }
    }
    label461:
    label466:
    label1391:
    for (;;)
    {
      break label322;
      paramInt = 0;
      break;
      paramIntent = null;
      break label283;
      paramInt = 0;
      break label289;
      Log.i("MicroMsg.UploadManager", "videoPath:%s thumbPath:%s", new Object[] { localObject2, localObject1 });
      if ((((bf)localObject3).hgg() != null) && (!((bf)localObject3).hgg().equals("")))
      {
        Object localObject6 = as.mg(al.getAccSnsPath(), ((bf)localObject3).hgg());
        y.bDX((String)localObject6);
        localObject4 = (String)localObject6 + ((bf)localObject3).hgg() + "thumb_bg_";
        localObject5 = (String)localObject6 + ((bf)localObject3).hgg() + "vdieo_bg_";
        String str1 = (String)localObject6 + ((bf)localObject3).hgg() + "image_bg_";
        y.deleteFile((String)localObject6 + ((bf)localObject3).hgg() + "bg_");
        bf.ml((String)localObject2, (String)localObject5);
        bf.ml((String)localObject1, (String)localObject4);
        bf.ml(paramIntent, str1);
        localObject6 = al.hgG();
        String str2 = ((bf)localObject3).hgg();
        s.u(str2, "userName");
        s.u(localObject5, "videoPath");
        s.u(localObject4, "thumbPath");
        s.u(str1, "imagePath");
        Log.i(r.TAG, s.X("updateCoverVideoInfoLocal :", str2));
        q localq = ((r)localObject6).aZM(str2);
        s.checkNotNull(localq);
        localq.field_userName = str2;
        r.c(localq);
        localq.field_type = 2;
        if (!s.p(localObject5, localq.field_localVideo))
        {
          com.tencent.threadpool.h.ahAA.bo((Runnable)new r.b(new String[] { localq.field_localVideo }));
          localq.field_localVideo = ((String)localObject5);
        }
        if (!s.p(localObject4, localq.field_localThumb))
        {
          com.tencent.threadpool.h.ahAA.bo((Runnable)new r.b(new String[] { localq.field_localThumb }));
          localq.field_localThumb = ((String)localObject4);
        }
        if (!s.p(str1, localq.field_localImage))
        {
          com.tencent.threadpool.h.ahAA.bo((Runnable)new r.b(new String[] { localq.field_localImage }));
          localq.field_localImage = str1;
        }
        ((r)localObject6).a(localq, false);
      }
      ((bf)localObject3).hhF();
      localObject3 = com.tencent.mm.plugin.sns.model.c.a.QAM;
      com.tencent.mm.plugin.sns.model.c.a.ba((String)localObject2, (String)localObject1, paramIntent);
      for (;;)
      {
        setResult(-1);
        finish();
        AppMethodBeat.o(98251);
        return;
        al.hgx().bB(((MediaResultInfo)localObject1).ofu);
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("SELECT_OBJECT", paramIntent.getByteArrayExtra("SELECT_OBJECT"));
      ((Intent)localObject1).putExtra("SELECT_TAB_TYPE", paramIntent.getIntExtra("SELECT_TAB_TYPE", 0));
      ((Intent)localObject1).setClass(this, SnsCoverFinderPreviewUI.class);
      startActivityForResult((Intent)localObject1, 10);
      AppMethodBeat.o(98251);
      return;
      localObject1 = new FinderObject();
      try
      {
        ((FinderObject)localObject1).parseFrom(paramIntent.getByteArrayExtra("SELECT_OBJECT"));
        if (((FinderObject)localObject1).objectDesc != null)
        {
          if (((FinderObject)localObject1).objectDesc.mediaType == 2)
          {
            paramIntent = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
            com.tencent.mm.plugin.sns.cover.c.b.akl(4);
          }
        }
        else
        {
          paramIntent = al.hgx();
          if ((paramIntent.hgg() != null) && (!paramIntent.hgg().equals("")))
          {
            localObject2 = as.mg(al.getAccSnsPath(), paramIntent.hgg());
            y.bDX((String)localObject2);
            y.deleteFile((String)localObject2 + paramIntent.hgg() + "bg_");
            al.hgG().c(paramIntent.hgg(), (FinderObject)localObject1);
          }
          paramIntent.hhF();
          localObject2 = com.tencent.mm.plugin.sns.model.c.a.QAM;
          com.tencent.mm.plugin.sns.model.c.a.b(paramIntent.hgg(), (FinderObject)localObject1);
          setResult(-1);
          finish();
          AppMethodBeat.o(98251);
          return;
        }
      }
      catch (IOException paramIntent)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SettingSnsBackgroundUI", paramIntent, "FinderObject error", new Object[0]);
          continue;
          if (((FinderObject)localObject1).objectDesc.mediaType == 4)
          {
            paramIntent = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
            com.tencent.mm.plugin.sns.cover.c.b.akl(3);
          }
        }
      }
      Log.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(308308);
          com.tencent.mm.plugin.sns.d.a.pFo.aDz();
          AppMethodBeat.o(308308);
        }
      });
      if (paramIntent == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      this.filePath = paramIntent.getStringExtra("CropImage_OutputPath");
      if (this.filePath == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      Log.i("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
      paramIntent = new ArrayList();
      localObject1 = MediaSingleInfo.KOM;
      localObject1 = this.filePath;
      s.u(localObject1, "path");
      paramIntent.add(new MediaSingleInfo(com.tencent.mm.plugin.mediabasic.data.a.KOB, (String)localObject1));
      al.hgx().bB(paramIntent);
      setResult(-1);
      finish();
      AppMethodBeat.o(98251);
      return;
    }
  }
  
  public int getResourceId()
  {
    return b.m.settings_sns_background;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98253);
    setMMTitle(b.j.settings_sns_bg_title);
    SnsArtistPreference localSnsArtistPreference = (SnsArtistPreference)this.screen.bAi("settings_sns_bg_select_bg");
    if (localSnsArtistPreference != null)
    {
      String str = this.sp.getString("artist_name", "");
      Log.d("MicroMsg.SettingSnsBackgroundUI", "artistName".concat(String.valueOf(str)));
      localSnsArtistPreference.RnA = str;
      localSnsArtistPreference.hnY();
      this.screen.notifyDataSetChanged();
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(308321);
        SettingSnsBackgroundUI.this.finish();
        paramAnonymousMenuItem = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
        com.tencent.mm.plugin.sns.cover.c.b.heH();
        AppMethodBeat.o(308321);
        return true;
      }
    });
    AppMethodBeat.o(98253);
  }
  
  public void onActivityResult(final int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(98252);
    Log.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + paramInt1 + " " + paramInt2);
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 2) || (paramInt1 == 5) || (paramInt1 == 6)) {
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98242);
            com.tencent.mm.plugin.sns.d.a.pFo.aDz();
            AppMethodBeat.o(98242);
          }
        });
      }
      AppMethodBeat.o(98252);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("result ok ");
    com.tencent.mm.kernel.h.baF();
    Log.d("MicroMsg.SettingSnsBackgroundUI", com.tencent.mm.kernel.h.baC().aZN());
    if (al.isInValid())
    {
      new MMHandler(Looper.myLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98243);
          SettingSnsBackgroundUI.a(SettingSnsBackgroundUI.this, paramInt1, paramIntent);
          AppMethodBeat.o(98243);
        }
      }, 2000L);
      AppMethodBeat.o(98252);
      return;
    }
    Log.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
    o(paramInt1, paramIntent);
    AppMethodBeat.o(98252);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(308380);
    super.onBackPressed();
    com.tencent.mm.plugin.sns.cover.c.b localb = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
    com.tencent.mm.plugin.sns.cover.c.b.heH();
    AppMethodBeat.o(308380);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98247);
    Log.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.sp = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    paramBundle = com.tencent.mm.plugin.sns.cover.b.a.QkS;
    if (!com.tencent.mm.plugin.sns.cover.b.a.hes()) {
      this.screen.bAk("settings_sns_bg_select_from_finder");
    }
    initView();
    paramBundle = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
    com.tencent.mm.plugin.sns.cover.c.b.heG();
    AppMethodBeat.o(98247);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98249);
    super.onDestroy();
    Log.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
    AppMethodBeat.o(98249);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(98248);
    Log.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    setResult(-1);
    finish();
    AppMethodBeat.o(98248);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98254);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.SettingSnsBackgroundUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_sns_bg_select_from_album"))
    {
      paramf = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
      com.tencent.mm.plugin.sns.cover.c.b.akl(10);
      com.tencent.mm.kernel.h.baF();
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        aa.j(this, null);
        AppMethodBeat.o(98254);
        return false;
      }
      paramf = com.tencent.mm.plugin.sns.cover.b.a.QkS;
      if (com.tencent.mm.plugin.sns.cover.b.a.hes()) {
        t.bJ(this);
      }
      for (;;)
      {
        j.QFS.QGL.jfu = 1;
        AppMethodBeat.o(98254);
        return true;
        t.d(this, 5, null);
      }
    }
    if (paramf.equals("settings_sns_bg_select_from_finder"))
    {
      paramf = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
      com.tencent.mm.plugin.sns.cover.c.b.akl(11);
      com.tencent.mm.kernel.h.baF();
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        aa.j(this, null);
        AppMethodBeat.o(98254);
        return false;
      }
      paramf = new Intent();
      paramf.putExtra("BIZ_SCENE", 3);
      paramPreference = new ArrayList();
      paramPreference.add(Integer.valueOf(2));
      paramPreference.add(Integer.valueOf(4));
      paramPreference.add(Integer.valueOf(5));
      paramPreference.add(Integer.valueOf(3));
      paramPreference.add(Integer.valueOf(1));
      paramf.putIntegerArrayListExtra("TAB_LIST", paramPreference);
      overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderGallery(this, paramf, 9);
      AppMethodBeat.o(98254);
      return true;
    }
    if (paramf.equals("settings_sns_bg_take_photo"))
    {
      paramf = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
      com.tencent.mm.plugin.sns.cover.c.b.akl(12);
      com.tencent.mm.kernel.h.baF();
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        aa.j(this, null);
        AppMethodBeat.o(98254);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(getContext(), "android.permission.CAMERA", 16, "");
      Log.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), getContext() });
      if (!bool)
      {
        AppMethodBeat.o(98254);
        return false;
      }
      fBt();
      AppMethodBeat.o(98254);
      return true;
    }
    if (paramf.equals("settings_sns_bg_select_bg"))
    {
      paramf = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
      com.tencent.mm.plugin.sns.cover.c.b.akl(13);
      paramf = new Intent(this, ArtistUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/sns/ui/SettingSnsBackgroundUI", "setSelectBg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/sns/ui/SettingSnsBackgroundUI", "setSelectBg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      j.QFS.QGL.jfu = 8;
      j.QFS.QGL.jfr = 1;
      AppMethodBeat.o(98254);
      return true;
    }
    AppMethodBeat.o(98254);
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(98256);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(98256);
      return;
    }
    Log.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98256);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        fBt();
        AppMethodBeat.o(98256);
        return;
      }
      k.a(this, getString(b.j.permission_camera_request_again_msg), getString(b.j.permission_tips_title), getString(b.j.jump_to_settings), getString(b.j.app_cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(308322);
          com.tencent.mm.pluginsdk.permission.b.lx(SettingSnsBackgroundUI.this.getContext());
          AppMethodBeat.o(308322);
        }
      }, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98250);
    super.onResume();
    if (this.screen != null) {
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(98250);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI
 * JD-Core Version:    0.7.0.1
 */
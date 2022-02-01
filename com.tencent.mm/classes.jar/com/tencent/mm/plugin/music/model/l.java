package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.ho.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLDecoder;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/model/MusicUIUtil;", "", "()V", "TAG", "", "doJumpToApp", "", "context", "Landroid/content/Context;", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "formatFinderNumber", "number", "", "getBgAndLyricColor", "", "bitmap", "Landroid/graphics/Bitmap;", "getCurrentMusic", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "activity", "Landroid/app/Activity;", "isChinesePeople", "", "isoCode", "setWindowStyle", "isShowStatusBar", "isShowNavigationBar", "updatePlayIcon", "isChecked", "playBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "playBtnColor", "plugin-music_release"})
public final class l
{
  public static final l AkI;
  
  static
  {
    AppMethodBeat.i(219994);
    AkI = new l();
    AppMethodBeat.o(219994);
  }
  
  public static void a(Context paramContext, f paramf, axy paramaxy)
  {
    AppMethodBeat.i(219991);
    p.h(paramContext, "context");
    if (paramf == null)
    {
      Log.e("MusicUIUtil", "doJumpToApp wrapper is null");
      AppMethodBeat.o(219991);
      return;
    }
    Log.i("MusicUIUtil", "doJumpToApp MusicType:%d, SongWebUrl:%s, AppId:%s, srcUsername:%s", new Object[] { Integer.valueOf(paramf.jeT), paramf.jfd, paramf.jfi, paramf.eag });
    Object localObject1 = h.aJw(paramf.jfi);
    if (localObject1 != null) {
      Log.i("MusicUIUtil", "packageName:%s", new Object[] { ((g)localObject1).field_packageName });
    }
    while (paramf.jeT == 11)
    {
      paramContext = new ho();
      EventCenter.instance.publish((IEvent)paramContext);
      paramaxy = paramContext.dMd.appId;
      paramf = paramContext.dMd.brandName;
      localObject1 = paramContext.dMd.appUserName;
      int i = paramContext.dMd.dMe;
      paramContext = paramf;
      if (TextUtils.isEmpty((CharSequence)paramf)) {
        paramContext = "";
      }
      Log.i("MusicUIUtil", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { paramaxy, paramContext, Integer.valueOf(i), localObject1 });
      Log.i("MusicUIUtil", "launch app brand Application");
      m.ag(paramaxy, (String)localObject1, i);
      AppMethodBeat.o(219991);
      return;
      Log.e("MusicUIUtil", "appInfo is null");
    }
    if ((!TextUtils.isEmpty((CharSequence)paramf.jfi)) && (p.j(paramf.jfi, "wx485a97c844086dc9")))
    {
      Log.i("MusicUIUtil", "launch qq music Application");
      m.b(paramf, (Activity)paramContext);
      AppMethodBeat.o(219991);
      return;
    }
    if ((!TextUtils.isEmpty((CharSequence)paramf.jfi)) && (localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((g)localObject1).field_packageName)) && (h.s(paramContext, paramf.jfi)))
    {
      Log.i("MusicUIUtil", "launch third party app, package name:%s", new Object[] { ((g)localObject1).field_packageName });
      WXMusicVideoObject localWXMusicVideoObject = new WXMusicVideoObject();
      localWXMusicVideoObject.musicUrl = paramf.jfd;
      localWXMusicVideoObject.musicDataUrl = paramf.jfb;
      if (paramaxy != null)
      {
        localObject2 = paramaxy.identification;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localWXMusicVideoObject.identification = URLDecoder.decode((String)localObject1);
      Object localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localWXMusicVideoObject);
      ((WXMediaMessage)localObject2).sdkVer = 637928960;
      if (paramaxy != null)
      {
        localObject1 = paramaxy.extraInfo;
        paramaxy = (axy)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramaxy = "";
      }
      ((WXMediaMessage)localObject2).messageExt = URLDecoder.decode(paramaxy);
      h.a(paramContext, paramf.jfi, (WXMediaMessage)localObject2, 0, (al)l.a.AkJ, null);
      AppMethodBeat.o(219991);
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)paramf.eag))
    {
      if (paramf.jfd == null) {}
      for (paramf = paramf.jfb;; paramf = paramf.jfd)
      {
        Log.i("MusicUIUtil", "launch biz H5 url:%s", new Object[] { paramf });
        paramaxy = new Intent();
        paramaxy.putExtra("rawUrl", paramf);
        c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramaxy);
        AppMethodBeat.o(219991);
        return;
      }
    }
    if (paramf.jfd == null) {}
    for (paramf = paramf.jfb;; paramf = paramf.jfd)
    {
      Log.i("MusicUIUtil", "launch H5 url:%s", new Object[] { paramf });
      paramaxy = new Intent();
      paramaxy.putExtra("rawUrl", paramf);
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramaxy);
      AppMethodBeat.o(219991);
      return;
    }
  }
  
  public static void aq(Activity paramActivity)
  {
    AppMethodBeat.i(219992);
    p.h(paramActivity, "activity");
    Object localObject = paramActivity.getWindow();
    p.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "activity.window.decorView");
    ((View)localObject).setSystemUiVisibility(5894);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.getWindow().addFlags(-2147483648);
      localObject = paramActivity.getWindow();
      p.g(localObject, "activity.window");
      ((Window)localObject).setStatusBarColor(0);
      localObject = paramActivity.getWindow();
      p.g(localObject, "activity.window");
      ((Window)localObject).setNavigationBarColor(0);
    }
    paramActivity.getWindow().setFormat(-3);
    AppMethodBeat.o(219992);
  }
  
  public static a au(Activity paramActivity)
  {
    AppMethodBeat.i(219993);
    p.h(paramActivity, "activity");
    Object localObject = b.aS(e.class);
    p.g(localObject, "MusicCoreService.service…PrivateLogic::class.java)");
    a locala = ((e)localObject).etY();
    if (locala == null)
    {
      localObject = "";
      if (paramActivity.getIntent().hasExtra("db_music_id"))
      {
        localObject = paramActivity.getIntent().getStringExtra("db_music_id");
        p.g(localObject, "activity.intent.getStrin…MusicPlayerUI.KDBMusicId)");
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (paramActivity = ((e)b.aS(e.class)).aHL((String)localObject);; paramActivity = locala)
    {
      AppMethodBeat.o(219993);
      return paramActivity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.l
 * JD-Core Version:    0.7.0.1
 */
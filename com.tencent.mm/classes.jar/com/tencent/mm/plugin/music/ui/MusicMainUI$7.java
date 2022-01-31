package com.tencent.mm.plugin.music.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.c;

final class MusicMainUI$7
  implements h.c
{
  MusicMainUI$7(MusicMainUI paramMusicMainUI, com.tencent.mm.aw.e parame) {}
  
  public final void iA(int paramInt)
  {
    Object localObject2 = null;
    int i = -1;
    AppMethodBeat.i(105102);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(105102);
      return;
    case 0: 
      d.Y(this.pcd);
      com.tencent.mm.plugin.music.model.d.e.Ar(MusicMainUI.h(this.pcd));
      com.tencent.mm.plugin.music.model.d.e.At(2);
      AppMethodBeat.o(105102);
      return;
    case 1: 
      d.b(this.fKa, this.pcd);
      com.tencent.mm.plugin.music.model.d.e.As(MusicMainUI.h(this.pcd));
      com.tencent.mm.plugin.music.model.d.e.At(1);
      AppMethodBeat.o(105102);
      return;
    case 2: 
      d.a(this.fKa, this.pcd);
      com.tencent.mm.plugin.music.model.d.e.At(3);
      AppMethodBeat.o(105102);
      return;
    }
    Object localObject1 = this.fKa;
    MusicMainUI localMusicMainUI = this.pcd;
    h.qsU.kvStat(10910, "4");
    String str2;
    if (localObject1 != null)
    {
      str2 = ((com.tencent.mm.aw.e)localObject1).fKr;
      if (str2 != null) {
        break label263;
      }
      paramInt = -1;
      label164:
      if (paramInt >= 0) {
        break label274;
      }
      localObject1 = null;
      label170:
      if (str2 != null) {
        break label323;
      }
      paramInt = i;
      label177:
      if (paramInt >= 0) {
        break label334;
      }
      label181:
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty((CharSequence)localObject1))) {
        break label386;
      }
      ab.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[] { str2 });
      localObject1 = "qqmusic://qq.com/ui/pageVisibility";
    }
    for (;;)
    {
      label215:
      ab.i("MicroMsg.Music.MusicUtil", "qqMusicActionUrl:%s", new Object[] { localObject1 });
      localObject2 = Uri.parse((String)localObject1);
      if (localObject2 == null) {
        ab.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[] { localObject1 });
      }
      for (;;)
      {
        com.tencent.mm.plugin.music.model.d.e.At(4);
        break;
        label263:
        paramInt = str2.indexOf("songid=");
        break label164;
        label274:
        String str1 = str2.substring(paramInt + 7);
        localObject1 = str1;
        if (str1 == null) {
          break label170;
        }
        localObject1 = str1;
        if (!str1.contains("&")) {
          break label170;
        }
        localObject1 = str1.substring(0, str1.indexOf("&"));
        break label170;
        label323:
        paramInt = str2.indexOf("songmid=");
        break label177;
        label334:
        str1 = str2.substring(paramInt + 8);
        localObject2 = str1;
        if (str1 == null) {
          break label181;
        }
        localObject2 = str1;
        if (!str1.contains("&")) {
          break label181;
        }
        localObject2 = str1.substring(0, str1.indexOf("&"));
        break label181;
        label386:
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ab.i("MicroMsg.Music.MusicUtil", "get qq music songmid %s", new Object[] { localObject2 });
          localObject1 = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songmid%22%3A%22" + (String)localObject2 + "%22%7D%5D%7D";
          break label215;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label539;
        }
        localObject1 = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songid%22%3A%22" + (String)localObject1 + "%22%7D%5D%7D";
        break label215;
        a.aiu();
        localObject1 = new Intent("android.intent.action.VIEW", (Uri)localObject2);
        ((Intent)localObject1).addFlags(268435456);
        if (bo.k(localMusicMainUI, (Intent)localObject1))
        {
          localMusicMainUI.startActivity((Intent)localObject1);
        }
        else
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", str2);
          b.gmO.i((Intent)localObject1, localMusicMainUI);
        }
      }
      label539:
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.7
 * JD-Core Version:    0.7.0.1
 */
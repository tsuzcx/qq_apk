package com.tencent.mm.plugin.textstatus.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.textstatus.g.r;>;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/jump/MusicPlayerJumper;", "Lcom/tencent/mm/plugin/textstatus/jump/ITextStatusJumpSingleton;", "()V", "doJump", "", "textStatusID", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "Companion", "plugin-textstatus_release"})
public final class d
  implements b
{
  public static final a FXZ;
  
  static
  {
    AppMethodBeat.i(216127);
    FXZ = new a((byte)0);
    AppMethodBeat.o(216127);
  }
  
  public final boolean F(String paramString, List<? extends r> paramList)
  {
    AppMethodBeat.i(258411);
    p.h(paramString, "textStatusID");
    p.h(paramList, "jumpInfos");
    Iterator localIterator = ((Iterable)paramList).iterator();
    boolean bool = false;
    Object localObject2;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject2 = (r)localIterator.next();
      if (!p.j(((r)localObject2).GaO, "1")) {
        break label1466;
      }
      localObject3 = XmlParser.parseXml(((r)localObject2).GaQ, "MusicVideoStatusOpenParams", null);
      if (localObject3 == null) {
        break label1474;
      }
    }
    for (;;)
    {
      axy localaxy;
      try
      {
        localaxy = new axy();
        paramList = ".".concat(String.valueOf("MusicVideoStatusOpenParams"));
        p.h(localaxy, "$this$parseFromXml");
        p.h(paramList, "prefix");
        p.h(localObject3, "values");
        try
        {
          str = paramList + ".FinderMVSongInfo";
          localObject1 = (String)((Map)localObject3).get(str + ".songName");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.BPc = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".singer");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.lDR = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".musicDataUrl");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.musicDataUrl = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".musicAppId");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.LIf = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".musicWebUrl");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.LIg = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".songId");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.AqO = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".lyric");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.LIh = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".albumName");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.albumName = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".albumUrl");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.Djf = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".genre");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.LIi = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".publicTime");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.LIj = paramList;
          paramList = (String)((Map)localObject3).get(str + ".publicTimeS");
          if (paramList == null) {
            break label1480;
          }
          paramList = n.buB(paramList);
          if (paramList == null) {
            break label1480;
          }
          l = paramList.longValue();
          localaxy.LIk = l;
          localObject1 = (String)((Map)localObject3).get(str + ".extraInfo");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.extraInfo = paramList;
          localObject1 = (String)((Map)localObject3).get(str + ".identification");
          paramList = (List<? extends r>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          localaxy.identification = paramList;
          paramList = (String)((Map)localObject3).get(str + ".duration");
          if (paramList == null) {
            break label1486;
          }
          paramList = n.buA(paramList);
          if (paramList == null) {
            break label1486;
          }
          i = paramList.intValue();
          localaxy.duration = i;
        }
        catch (Exception paramList)
        {
          String str;
          Object localObject1;
          Intent localIntent;
          Log.e("FinderMVSongInfo", "parse FinderMVSongInfo from xml fail:" + paramList.getLocalizedMessage());
          continue;
        }
        localObject3 = ak.C(".".concat(String.valueOf("MusicVideoStatusOpenParams")), (Map)localObject3);
        Log.i("MusicPlayerJumper", "alvinluo jumpToMv ext: %s, %s, identification: %s, %s, xml: %s", new Object[] { localaxy.extraInfo, ((css)localObject3).extraInfo, localaxy.identification, ((css)localObject3).identification, ((r)localObject2).GaQ });
        paramList = (CharSequence)((css)localObject3).Ktp;
        if (paramList == null) {
          break label1469;
        }
        if (paramList.length() != 0) {
          break label1428;
        }
      }
      catch (Exception paramList)
      {
        Log.e("MusicPlayerJumper", "process TextStatusJumpInfo fail:" + paramList.getLocalizedMessage());
        break label1474;
      }
      if (i == 0)
      {
        paramList = ((css)localObject3).Ktp;
        p.g(paramList, "musicShareObject.mvCoverUrl");
        localObject1 = ac.vER;
        localObject2 = localaxy.AqO;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = String.valueOf(System.currentTimeMillis());
        }
        ac.a(localaxy, (String)localObject1, 0, paramList);
        localIntent = new Intent();
        localObject1 = ((css)localObject3).Ktn;
        if (localObject1 != null) {
          break label1460;
        }
        localObject1 = "";
        localObject2 = ((css)localObject3).Kto;
        if (localObject2 == null)
        {
          localObject2 = "";
          str = ((css)localObject3).Ktq;
          localObject3 = str;
          if (str == null) {
            localObject3 = "";
          }
          localIntent.putExtra("key_mv_feed_id", (String)localObject1);
          localIntent.putExtra("key_mv_nonce_id", (String)localObject2);
          localIntent.putExtra("key_mv_cover_url", paramList);
          localIntent.putExtra("key_mv_poster", (String)localObject3);
          localIntent.putExtra("key_mv_song_name", localaxy.BPc);
          localIntent.putExtra("key_mv_song_lyric", localaxy.LIh);
          localIntent.putExtra("key_mv_singer_name", localaxy.lDR);
          localIntent.putExtra("key_mv_album_name", localaxy.albumName);
          localIntent.putExtra("key_mv_music_genre", localaxy.LIi);
          localIntent.putExtra("key_mv_issue_date", String.valueOf(localaxy.LIk));
          localIntent.putExtra("key_mv_album_cover_url", localaxy.Djf);
          localIntent.putExtra("key_mv_identification", localaxy.identification);
          localIntent.putExtra("key_mv_extra_info", localaxy.extraInfo);
          localIntent.putExtra("key_mv_music_duration", localaxy.duration);
          localIntent.putExtra("key_need_update_music_ball_url", true);
          paramList = new cst();
          localObject1 = a.qCo;
          paramList.sGQ = a.cAK();
          paramList.MxJ = paramString;
          paramList.scene = 6;
          localIntent.putExtra("key_mv_report_data", paramList.toByteArray());
          localIntent.setFlags(268435456);
          c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", localIntent);
          break label1474;
          label1428:
          i = 0;
        }
      }
      else
      {
        paramList = localaxy.Djf;
        if (paramList != null) {
          break label1463;
        }
        paramList = "";
        continue;
        AppMethodBeat.o(258411);
        return bool;
      }
      continue;
      label1460:
      continue;
      label1463:
      continue;
      label1466:
      break label1477;
      label1469:
      int i = 1;
      continue;
      label1474:
      bool = true;
      label1477:
      break;
      label1480:
      long l = 0L;
      continue;
      label1486:
      i = 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/jump/MusicPlayerJumper$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.d
 * JD-Core Version:    0.7.0.1
 */
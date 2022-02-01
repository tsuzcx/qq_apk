package com.tencent.mm.search.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.lz;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/report/SimilarEmojiReport;", "", "()V", "chatId", "", "source", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "reportClickEmoji", "", "select", "index", "reportClickSimilarMenu", "emojiInfo", "reportClickSosEntrance", "reportListIdle", "emojiList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportShowSimilarMenu", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b acsj;
  private static EmojiInfo acsk;
  private static String mfW;
  private static long timestamp;
  
  static
  {
    AppMethodBeat.i(105858);
    acsj = new b();
    mfW = "";
    AppMethodBeat.o(105858);
  }
  
  public static void F(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105855);
    s.u(paramEmojiInfo, "emojiInfo");
    lz locallz = new lz();
    locallz.iEj = timestamp;
    locallz.ikE = 2L;
    locallz.uA(paramEmojiInfo.field_groupId);
    locallz.uB(paramEmojiInfo.getMd5());
    locallz.uH(mfW);
    locallz.bMH();
    paramEmojiInfo = a.acsi;
    a.iTx();
    AppMethodBeat.o(105855);
  }
  
  private static final void a(long paramLong, EmojiInfo paramEmojiInfo)
  {
    Object localObject2 = null;
    AppMethodBeat.i(236866);
    s.u(paramEmojiInfo, "$select");
    lz locallz = new lz();
    locallz.iEj = timestamp;
    locallz.ikE = 4L;
    Object localObject1 = acsk;
    if (localObject1 == null)
    {
      localObject1 = null;
      locallz.uA((String)localObject1);
      localObject1 = acsk;
      if (localObject1 != null) {
        break label183;
      }
      localObject1 = localObject2;
      label67:
      locallz.uB((String)localObject1);
      locallz.iAO = paramLong;
      locallz.aIP();
      locallz.uC(paramEmojiInfo.field_groupId);
      locallz.uD(paramEmojiInfo.getMd5());
      locallz.uE(String.valueOf(paramEmojiInfo.akmd));
      if (!l.aUF().k(paramEmojiInfo)) {
        break label191;
      }
      localObject1 = "2";
      label132:
      locallz.uG((String)localObject1);
      if (!d.x(paramEmojiInfo)) {
        break label197;
      }
      locallz.uF("1");
    }
    for (;;)
    {
      locallz.uH(mfW);
      locallz.bMH();
      AppMethodBeat.o(236866);
      return;
      localObject1 = ((EmojiInfo)localObject1).field_groupId;
      break;
      label183:
      localObject1 = ((EmojiInfo)localObject1).getMd5();
      break label67;
      label191:
      localObject1 = "1";
      break label132;
      label197:
      locallz.uF("2");
    }
  }
  
  private static final void b(long paramLong, ArrayList paramArrayList)
  {
    EmojiInfo localEmojiInfo = null;
    AppMethodBeat.i(236859);
    s.u(paramArrayList, "$emojiList");
    lz locallz = new lz();
    locallz.iEj = timestamp;
    locallz.ikE = 3L;
    Object localObject = acsk;
    if (localObject == null)
    {
      localObject = null;
      locallz.uA((String)localObject);
      localObject = acsk;
      if (localObject != null) {
        break label361;
      }
      localObject = localEmojiInfo;
      label67:
      locallz.uB((String)localObject);
      locallz.iAO = paramLong;
      locallz.aIP();
      locallz.uC("");
      locallz.uD("");
      locallz.uE("");
      locallz.uF("");
      locallz.uG("");
      localObject = ((Iterable)paramArrayList).iterator();
    }
    for (;;)
    {
      label136:
      if (!((Iterator)localObject).hasNext()) {
        break label402;
      }
      localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      locallz.uC(locallz.iqB + localEmojiInfo.field_groupId + '#');
      locallz.uD(locallz.iuD + localEmojiInfo.getMd5() + '#');
      locallz.uE(locallz.jaE + localEmojiInfo.akmd + '#');
      StringBuilder localStringBuilder = new StringBuilder().append(locallz.jaG);
      if (l.aUF().k(localEmojiInfo)) {}
      for (paramArrayList = "2";; paramArrayList = "1")
      {
        locallz.uG(paramArrayList + '#');
        if (!d.x(localEmojiInfo)) {
          break label375;
        }
        locallz.uF(s.X(locallz.jaF, "1".concat(String.valueOf("#"))));
        break label136;
        localObject = ((EmojiInfo)localObject).field_groupId;
        break;
        label361:
        localObject = ((EmojiInfo)localObject).getMd5();
        break label67;
      }
      label375:
      locallz.uF(s.X(locallz.jaF, "2".concat(String.valueOf("#"))));
    }
    label402:
    locallz.uH(mfW);
    locallz.bMH();
    AppMethodBeat.o(236859);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(105857);
    s.u(paramEmojiInfo, "select");
    h.ahAA.bm(new b..ExternalSyntheticLambda0(paramLong, paramEmojiInfo));
    AppMethodBeat.o(105857);
  }
  
  public static void b(ArrayList<EmojiInfo> paramArrayList, long paramLong)
  {
    AppMethodBeat.i(105856);
    s.u(paramArrayList, "emojiList");
    h.ahAA.bm(new b..ExternalSyntheticLambda1(paramLong, paramArrayList));
    AppMethodBeat.o(105856);
  }
  
  public static void c(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(236850);
    s.u(paramEmojiInfo, "emojiInfo");
    s.u(paramString, "chatId");
    timestamp = System.currentTimeMillis();
    acsk = paramEmojiInfo;
    mfW = paramString;
    lz locallz = new lz();
    locallz.iEj = timestamp;
    locallz.ikE = 1L;
    locallz.uA(paramEmojiInfo.field_groupId);
    locallz.uB(paramEmojiInfo.getMd5());
    locallz.uH(paramString);
    locallz.bMH();
    paramEmojiInfo = a.acsi;
    a.iTw();
    AppMethodBeat.o(236850);
  }
  
  public static long getTimestamp()
  {
    return timestamp;
  }
  
  public static void iTD()
  {
    Object localObject2 = null;
    AppMethodBeat.i(169247);
    lz locallz = new lz();
    locallz.iEj = timestamp;
    locallz.ikE = 5L;
    Object localObject1 = acsk;
    if (localObject1 == null)
    {
      localObject1 = null;
      locallz.uA((String)localObject1);
      localObject1 = acsk;
      if (localObject1 != null) {
        break label95;
      }
    }
    label95:
    for (localObject1 = localObject2;; localObject1 = ((EmojiInfo)localObject1).getMd5())
    {
      locallz.uB((String)localObject1);
      locallz.aIP();
      locallz.uH(mfW);
      locallz.bMH();
      AppMethodBeat.o(169247);
      return;
      localObject1 = ((EmojiInfo)localObject1).field_groupId;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.c.b
 * JD-Core Version:    0.7.0.1
 */
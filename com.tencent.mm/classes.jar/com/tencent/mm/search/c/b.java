package com.tencent.mm.search.c;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.f.b.a.jn;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/report/SimilarEmojiReport;", "", "()V", "chatId", "", "source", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "reportClickEmoji", "", "select", "index", "reportClickSimilarMenu", "emojiInfo", "reportClickSosEntrance", "reportListIdle", "emojiList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportShowSimilarMenu", "plugin-emojisdk_release"})
public final class b
{
  private static EmojiInfo UWX;
  public static final b UWY;
  private static String jGo;
  private static long timestamp;
  
  static
  {
    AppMethodBeat.i(105858);
    UWY = new b();
    jGo = "";
    AppMethodBeat.o(105858);
  }
  
  public static void F(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105855);
    p.k(paramEmojiInfo, "emojiInfo");
    jn localjn = new jn();
    localjn.uu(timestamp);
    localjn.uv(2L);
    localjn.Au(paramEmojiInfo.field_groupId);
    localjn.Av(paramEmojiInfo.getMd5());
    localjn.AB(jGo);
    localjn.bpa();
    paramEmojiInfo = a.UWW;
    a.htq();
    AppMethodBeat.o(105855);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(105857);
    p.k(paramEmojiInfo, "select");
    h.ZvG.be((Runnable)new a(paramLong, paramEmojiInfo));
    AppMethodBeat.o(105857);
  }
  
  public static void b(ArrayList<EmojiInfo> paramArrayList, long paramLong)
  {
    AppMethodBeat.i(105856);
    p.k(paramArrayList, "emojiList");
    h.ZvG.be((Runnable)new b(paramLong, paramArrayList));
    AppMethodBeat.o(105856);
  }
  
  public static void c(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(226149);
    p.k(paramEmojiInfo, "emojiInfo");
    p.k(paramString, "chatId");
    timestamp = System.currentTimeMillis();
    UWX = paramEmojiInfo;
    jGo = paramString;
    jn localjn = new jn();
    localjn.uu(timestamp);
    localjn.uv(1L);
    localjn.Au(paramEmojiInfo.field_groupId);
    localjn.Av(paramEmojiInfo.getMd5());
    localjn.AB(paramString);
    localjn.bpa();
    paramEmojiInfo = a.UWW;
    a.htp();
    AppMethodBeat.o(226149);
  }
  
  public static long getTimestamp()
  {
    return timestamp;
  }
  
  public static void htw()
  {
    Object localObject2 = null;
    AppMethodBeat.i(169247);
    jn localjn = new jn();
    localjn.uu(timestamp);
    localjn.uv(5L);
    Object localObject1 = UWX;
    if (localObject1 != null) {}
    for (localObject1 = ((EmojiInfo)localObject1).field_groupId;; localObject1 = null)
    {
      localjn.Au((String)localObject1);
      EmojiInfo localEmojiInfo = UWX;
      localObject1 = localObject2;
      if (localEmojiInfo != null) {
        localObject1 = localEmojiInfo.getMd5();
      }
      localjn.Av((String)localObject1);
      localjn.amb();
      localjn.AB(jGo);
      localjn.bpa();
      AppMethodBeat.o(169247);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(long paramLong, EmojiInfo paramEmojiInfo) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(105852);
      jn localjn = new jn();
      Object localObject1 = b.UWY;
      localjn.uu(b.getTimestamp());
      localjn.uv(4L);
      localObject1 = b.UWY;
      localObject1 = b.htx();
      if (localObject1 != null)
      {
        localObject1 = ((EmojiInfo)localObject1).field_groupId;
        localjn.Au((String)localObject1);
        localObject1 = b.UWY;
        EmojiInfo localEmojiInfo = b.htx();
        localObject1 = localObject2;
        if (localEmojiInfo != null) {
          localObject1 = localEmojiInfo.getMd5();
        }
        localjn.Av((String)localObject1);
        localjn.uw(this.UWZ);
        localjn.amb();
        localjn.Aw(this.UXa.field_groupId);
        localjn.Ax(this.UXa.getMd5());
        localjn.Ay(String.valueOf(this.UXa.ZuP));
        if (!k.aBH().l(this.UXa)) {
          break label206;
        }
        localObject1 = "2";
        label155:
        localjn.AA((String)localObject1);
        if (!com.tencent.mm.plugin.emoji.i.b.x(this.UXa)) {
          break label212;
        }
        localjn.Az("1");
      }
      for (;;)
      {
        localObject1 = b.UWY;
        localjn.AB(b.hty());
        localjn.bpa();
        AppMethodBeat.o(105852);
        return;
        localObject1 = null;
        break;
        label206:
        localObject1 = "1";
        break label155;
        label212:
        localjn.Az("2");
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(long paramLong, ArrayList paramArrayList) {}
    
    public final void run()
    {
      Iterator localIterator = null;
      AppMethodBeat.i(105853);
      jn localjn = new jn();
      Object localObject = b.UWY;
      localjn.uu(b.getTimestamp());
      localjn.uv(3L);
      localObject = b.UWY;
      localObject = b.htx();
      EmojiInfo localEmojiInfo;
      if (localObject != null)
      {
        localObject = ((EmojiInfo)localObject).field_groupId;
        localjn.Au((String)localObject);
        localObject = b.UWY;
        localEmojiInfo = b.htx();
        localObject = localIterator;
        if (localEmojiInfo != null) {
          localObject = localEmojiInfo.getMd5();
        }
        localjn.Av((String)localObject);
        localjn.uw(this.UWZ);
        localjn.amb();
        localjn.Aw("");
        localjn.Ax("");
        localjn.Ay("");
        localjn.Az("");
        localjn.AA("");
        localIterator = ((Iterable)this.UXb).iterator();
      }
      for (;;)
      {
        label148:
        if (!localIterator.hasNext()) {
          break label432;
        }
        localEmojiInfo = (EmojiInfo)localIterator.next();
        localObject = localjn.getPid();
        localjn.Aw((String)localObject + localEmojiInfo.field_groupId + "#");
        localObject = localjn.getMd5();
        localjn.Ax((String)localObject + localEmojiInfo.getMd5() + "#");
        localObject = localjn.amc();
        localjn.Ay((String)localObject + String.valueOf(localEmojiInfo.ZuP) + "#");
        localObject = localjn.ame();
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
        if (k.aBH().l(localEmojiInfo)) {}
        for (localObject = "2";; localObject = "1")
        {
          localjn.AA((String)localObject + "#");
          if (!com.tencent.mm.plugin.emoji.i.b.x(localEmojiInfo)) {
            break label392;
          }
          localObject = localjn.amd();
          localjn.Az((String)localObject + "1".concat(String.valueOf("#")));
          break label148;
          localObject = null;
          break;
        }
        label392:
        localObject = localjn.amd();
        localjn.Az((String)localObject + "2".concat(String.valueOf("#")));
      }
      label432:
      localObject = b.UWY;
      localjn.AB(b.hty());
      localjn.bpa();
      AppMethodBeat.o(105853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.search.c.b
 * JD-Core Version:    0.7.0.1
 */
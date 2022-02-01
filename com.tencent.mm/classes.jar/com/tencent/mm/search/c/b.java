package com.tencent.mm.search.c;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/report/SimilarEmojiReport;", "", "()V", "chatId", "", "source", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "reportClickEmoji", "", "select", "index", "reportClickSimilarMenu", "emojiInfo", "reportClickSosEntrance", "reportListIdle", "emojiList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportShowSimilarMenu", "plugin-emojisdk_release"})
public final class b
{
  private static EmojiInfo NJw;
  public static final b NJx;
  private static String gVs;
  private static long timestamp;
  
  static
  {
    AppMethodBeat.i(105858);
    NJx = new b();
    gVs = "";
    AppMethodBeat.o(105858);
  }
  
  public static void E(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105855);
    p.h(paramEmojiInfo, "emojiInfo");
    hi localhi = new hi();
    localhi.qN(timestamp);
    localhi.qO(2L);
    localhi.uW(paramEmojiInfo.field_groupId);
    localhi.uX(paramEmojiInfo.getMd5());
    localhi.vd(gVs);
    localhi.bfK();
    paramEmojiInfo = a.NJv;
    a.gxs();
    AppMethodBeat.o(105855);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(105857);
    p.h(paramEmojiInfo, "select");
    h.RTc.aX((Runnable)new a(paramLong, paramEmojiInfo));
    AppMethodBeat.o(105857);
  }
  
  public static void b(ArrayList<EmojiInfo> paramArrayList, long paramLong)
  {
    AppMethodBeat.i(105856);
    p.h(paramArrayList, "emojiList");
    h.RTc.aX((Runnable)new b(paramLong, paramArrayList));
    AppMethodBeat.o(105856);
  }
  
  public static void c(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(200088);
    p.h(paramEmojiInfo, "emojiInfo");
    p.h(paramString, "chatId");
    timestamp = System.currentTimeMillis();
    NJw = paramEmojiInfo;
    gVs = paramString;
    hi localhi = new hi();
    localhi.qN(timestamp);
    localhi.qO(1L);
    localhi.uW(paramEmojiInfo.field_groupId);
    localhi.uX(paramEmojiInfo.getMd5());
    localhi.vd(paramString);
    localhi.bfK();
    paramEmojiInfo = a.NJv;
    a.gxr();
    AppMethodBeat.o(200088);
  }
  
  public static long getTimestamp()
  {
    return timestamp;
  }
  
  public static void gxy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(169247);
    hi localhi = new hi();
    localhi.qN(timestamp);
    localhi.qO(5L);
    Object localObject1 = NJw;
    if (localObject1 != null) {}
    for (localObject1 = ((EmojiInfo)localObject1).field_groupId;; localObject1 = null)
    {
      localhi.uW((String)localObject1);
      EmojiInfo localEmojiInfo = NJw;
      localObject1 = localObject2;
      if (localEmojiInfo != null) {
        localObject1 = localEmojiInfo.getMd5();
      }
      localhi.uX((String)localObject1);
      localhi.agV();
      localhi.vd(gVs);
      localhi.bfK();
      AppMethodBeat.o(169247);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(long paramLong, EmojiInfo paramEmojiInfo) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(105852);
      hi localhi = new hi();
      Object localObject1 = b.NJx;
      localhi.qN(b.getTimestamp());
      localhi.qO(4L);
      localObject1 = b.NJx;
      localObject1 = b.gxz();
      if (localObject1 != null)
      {
        localObject1 = ((EmojiInfo)localObject1).field_groupId;
        localhi.uW((String)localObject1);
        localObject1 = b.NJx;
        EmojiInfo localEmojiInfo = b.gxz();
        localObject1 = localObject2;
        if (localEmojiInfo != null) {
          localObject1 = localEmojiInfo.getMd5();
        }
        localhi.uX((String)localObject1);
        localhi.qP(this.NJy);
        localhi.agV();
        localhi.uY(this.NJz.field_groupId);
        localhi.uZ(this.NJz.getMd5());
        localhi.va(String.valueOf(this.NJz.UuN));
        if (!j.auL().l(this.NJz)) {
          break label206;
        }
        localObject1 = "2";
        label155:
        localhi.vc((String)localObject1);
        if (!com.tencent.mm.plugin.emoji.h.b.w(this.NJz)) {
          break label212;
        }
        localhi.vb("1");
      }
      for (;;)
      {
        localObject1 = b.NJx;
        localhi.vd(b.gxA());
        localhi.bfK();
        AppMethodBeat.o(105852);
        return;
        localObject1 = null;
        break;
        label206:
        localObject1 = "1";
        break label155;
        label212:
        localhi.vb("2");
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(long paramLong, ArrayList paramArrayList) {}
    
    public final void run()
    {
      Iterator localIterator = null;
      AppMethodBeat.i(105853);
      hi localhi = new hi();
      Object localObject = b.NJx;
      localhi.qN(b.getTimestamp());
      localhi.qO(3L);
      localObject = b.NJx;
      localObject = b.gxz();
      EmojiInfo localEmojiInfo;
      if (localObject != null)
      {
        localObject = ((EmojiInfo)localObject).field_groupId;
        localhi.uW((String)localObject);
        localObject = b.NJx;
        localEmojiInfo = b.gxz();
        localObject = localIterator;
        if (localEmojiInfo != null) {
          localObject = localEmojiInfo.getMd5();
        }
        localhi.uX((String)localObject);
        localhi.qP(this.NJy);
        localhi.agV();
        localhi.uY("");
        localhi.uZ("");
        localhi.va("");
        localhi.vb("");
        localhi.vc("");
        localIterator = ((Iterable)this.NJA).iterator();
      }
      for (;;)
      {
        label148:
        if (!localIterator.hasNext()) {
          break label432;
        }
        localEmojiInfo = (EmojiInfo)localIterator.next();
        localObject = localhi.agU();
        localhi.uY((String)localObject + localEmojiInfo.field_groupId + "#");
        localObject = localhi.getMd5();
        localhi.uZ((String)localObject + localEmojiInfo.getMd5() + "#");
        localObject = localhi.agW();
        localhi.va((String)localObject + String.valueOf(localEmojiInfo.UuN) + "#");
        localObject = localhi.agY();
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
        if (j.auL().l(localEmojiInfo)) {}
        for (localObject = "2";; localObject = "1")
        {
          localhi.vc((String)localObject + "#");
          if (!com.tencent.mm.plugin.emoji.h.b.w(localEmojiInfo)) {
            break label392;
          }
          localObject = localhi.agX();
          localhi.vb((String)localObject + "1".concat(String.valueOf("#")));
          break label148;
          localObject = null;
          break;
        }
        label392:
        localObject = localhi.agX();
        localhi.vb((String)localObject + "2".concat(String.valueOf("#")));
      }
      label432:
      localObject = b.NJx;
      localhi.vd(b.gxA());
      localhi.bfK();
      AppMethodBeat.o(105853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.search.c.b
 * JD-Core Version:    0.7.0.1
 */
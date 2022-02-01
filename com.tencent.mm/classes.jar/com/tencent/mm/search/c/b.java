package com.tencent.mm.search.c;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.di;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/search/report/SimilarEmojiReport;", "", "()V", "chatId", "", "source", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "reportClickEmoji", "", "select", "index", "reportClickSimilarMenu", "emojiInfo", "reportClickSosEntrance", "reportListIdle", "emojiList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportShowSimilarMenu", "plugin-emojisdk_release"})
public final class b
{
  public static final b GwA;
  private static EmojiInfo Gwy;
  private static String Gwz;
  private static long timestamp;
  
  static
  {
    AppMethodBeat.i(105858);
    GwA = new b();
    Gwz = "";
    AppMethodBeat.o(105858);
  }
  
  public static void F(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105855);
    k.h(paramEmojiInfo, "emojiInfo");
    di localdi = new di();
    localdi.ii(timestamp);
    localdi.ij(2L);
    localdi.lf(paramEmojiInfo.field_groupId);
    localdi.lg(paramEmojiInfo.JC());
    localdi.lm(Gwz);
    localdi.aHZ();
    paramEmojiInfo = a.Gwx;
    a.eWS();
    AppMethodBeat.o(105855);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(105857);
    k.h(paramEmojiInfo, "select");
    h.JZN.aS((Runnable)new a(paramLong, paramEmojiInfo));
    AppMethodBeat.o(105857);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(209871);
    k.h(paramEmojiInfo, "emojiInfo");
    k.h(paramString, "chatId");
    timestamp = System.currentTimeMillis();
    Gwy = paramEmojiInfo;
    Gwz = paramString;
    di localdi = new di();
    localdi.ii(timestamp);
    localdi.ij(1L);
    localdi.lf(paramEmojiInfo.field_groupId);
    localdi.lg(paramEmojiInfo.JC());
    localdi.lm(paramString);
    localdi.aHZ();
    paramEmojiInfo = a.Gwx;
    a.eWR();
    AppMethodBeat.o(209871);
  }
  
  public static void b(ArrayList<EmojiInfo> paramArrayList, long paramLong)
  {
    AppMethodBeat.i(105856);
    k.h(paramArrayList, "emojiList");
    h.JZN.aS((Runnable)new b(paramLong, paramArrayList));
    AppMethodBeat.o(105856);
  }
  
  public static void eWY()
  {
    Object localObject2 = null;
    AppMethodBeat.i(169247);
    di localdi = new di();
    localdi.ii(timestamp);
    localdi.ij(5L);
    Object localObject1 = Gwy;
    if (localObject1 != null) {}
    for (localObject1 = ((EmojiInfo)localObject1).field_groupId;; localObject1 = null)
    {
      localdi.lf((String)localObject1);
      EmojiInfo localEmojiInfo = Gwy;
      localObject1 = localObject2;
      if (localEmojiInfo != null) {
        localObject1 = localEmojiInfo.JC();
      }
      localdi.lg((String)localObject1);
      localdi.QX();
      localdi.lm(Gwz);
      localdi.aHZ();
      AppMethodBeat.o(169247);
      return;
    }
  }
  
  public static long getTimestamp()
  {
    return timestamp;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(long paramLong, EmojiInfo paramEmojiInfo) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(105852);
      di localdi = new di();
      Object localObject1 = b.GwA;
      localdi.ii(b.getTimestamp());
      localdi.ij(4L);
      localObject1 = b.GwA;
      localObject1 = b.eWZ();
      if (localObject1 != null)
      {
        localObject1 = ((EmojiInfo)localObject1).field_groupId;
        localdi.lf((String)localObject1);
        localObject1 = b.GwA;
        EmojiInfo localEmojiInfo = b.eWZ();
        localObject1 = localObject2;
        if (localEmojiInfo != null) {
          localObject1 = localEmojiInfo.JC();
        }
        localdi.lg((String)localObject1);
        localdi.ik(this.GwB);
        localdi.QX();
        localdi.lh(this.GwC.field_groupId);
        localdi.li(this.GwC.JC());
        localdi.lj(String.valueOf(this.GwC.Kgp));
        if (!com.tencent.mm.emoji.a.i.ach().l(this.GwC)) {
          break label206;
        }
        localObject1 = "2";
        label155:
        localdi.ll((String)localObject1);
        if (!com.tencent.mm.plugin.emoji.h.b.w(this.GwC)) {
          break label212;
        }
        localdi.lk("1");
      }
      for (;;)
      {
        localObject1 = b.GwA;
        localdi.lm(b.eXa());
        localdi.aHZ();
        AppMethodBeat.o(105852);
        return;
        localObject1 = null;
        break;
        label206:
        localObject1 = "1";
        break label155;
        label212:
        localdi.lk("2");
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(long paramLong, ArrayList paramArrayList) {}
    
    public final void run()
    {
      Iterator localIterator = null;
      AppMethodBeat.i(105853);
      di localdi = new di();
      Object localObject = b.GwA;
      localdi.ii(b.getTimestamp());
      localdi.ij(3L);
      localObject = b.GwA;
      localObject = b.eWZ();
      EmojiInfo localEmojiInfo;
      if (localObject != null)
      {
        localObject = ((EmojiInfo)localObject).field_groupId;
        localdi.lf((String)localObject);
        localObject = b.GwA;
        localEmojiInfo = b.eWZ();
        localObject = localIterator;
        if (localEmojiInfo != null) {
          localObject = localEmojiInfo.JC();
        }
        localdi.lg((String)localObject);
        localdi.ik(this.GwB);
        localdi.QX();
        localdi.lh("");
        localdi.li("");
        localdi.lj("");
        localdi.lk("");
        localdi.ll("");
        localIterator = ((Iterable)this.GwD).iterator();
      }
      for (;;)
      {
        label148:
        if (!localIterator.hasNext()) {
          break label432;
        }
        localEmojiInfo = (EmojiInfo)localIterator.next();
        localObject = localdi.QW();
        localdi.lh((String)localObject + localEmojiInfo.field_groupId + "#");
        localObject = localdi.JC();
        localdi.li((String)localObject + localEmojiInfo.JC() + "#");
        localObject = localdi.QY();
        localdi.lj((String)localObject + String.valueOf(localEmojiInfo.Kgp) + "#");
        localObject = localdi.Ra();
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
        if (com.tencent.mm.emoji.a.i.ach().l(localEmojiInfo)) {}
        for (localObject = "2";; localObject = "1")
        {
          localdi.ll((String)localObject + "#");
          if (!com.tencent.mm.plugin.emoji.h.b.w(localEmojiInfo)) {
            break label392;
          }
          localObject = localdi.QZ();
          localdi.lk((String)localObject + "1".concat(String.valueOf("#")));
          break label148;
          localObject = null;
          break;
        }
        label392:
        localObject = localdi.QZ();
        localdi.lk((String)localObject + "2".concat(String.valueOf("#")));
      }
      label432:
      localObject = b.GwA;
      localdi.lm(b.eXa());
      localdi.aHZ();
      AppMethodBeat.o(105853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.search.c.b
 * JD-Core Version:    0.7.0.1
 */
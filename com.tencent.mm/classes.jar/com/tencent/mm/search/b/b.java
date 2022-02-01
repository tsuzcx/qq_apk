package com.tencent.mm.search.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/report/SimilarEmojiReport;", "", "()V", "source", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "reportClickEmoji", "", "select", "index", "reportClickSimilarMenu", "emojiInfo", "reportClickSosEntrance", "reportListIdle", "emojiList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportShowSimilarMenu", "plugin-emojisdk_release"})
public final class b
{
  private static EmojiInfo EZk;
  public static final b EZl;
  private static long timestamp;
  
  static
  {
    AppMethodBeat.i(105858);
    EZl = new b();
    AppMethodBeat.o(105858);
  }
  
  public static void E(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105854);
    k.h(paramEmojiInfo, "emojiInfo");
    timestamp = System.currentTimeMillis();
    EZk = paramEmojiInfo;
    bu localbu = new bu();
    localbu.eV(timestamp);
    localbu.eW(1L);
    localbu.iq(paramEmojiInfo.field_groupId);
    localbu.ir(paramEmojiInfo.JS());
    localbu.aBj();
    paramEmojiInfo = a.EZj;
    a.eHw();
    AppMethodBeat.o(105854);
  }
  
  public static void F(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105855);
    k.h(paramEmojiInfo, "emojiInfo");
    bu localbu = new bu();
    localbu.eV(timestamp);
    localbu.eW(2L);
    localbu.iq(paramEmojiInfo.field_groupId);
    localbu.ir(paramEmojiInfo.JS());
    localbu.aBj();
    paramEmojiInfo = a.EZj;
    a.eHx();
    AppMethodBeat.o(105855);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(105857);
    k.h(paramEmojiInfo, "select");
    com.tencent.e.h.Iye.aP((Runnable)new a(paramLong, paramEmojiInfo));
    AppMethodBeat.o(105857);
  }
  
  public static void b(ArrayList<EmojiInfo> paramArrayList, long paramLong)
  {
    AppMethodBeat.i(105856);
    k.h(paramArrayList, "emojiList");
    com.tencent.e.h.Iye.aP((Runnable)new b(paramLong, paramArrayList));
    AppMethodBeat.o(105856);
  }
  
  public static void eHD()
  {
    Object localObject2 = null;
    AppMethodBeat.i(169247);
    bu localbu = new bu();
    localbu.eV(timestamp);
    localbu.eW(5L);
    Object localObject1 = EZk;
    if (localObject1 != null) {}
    for (localObject1 = ((EmojiInfo)localObject1).field_groupId;; localObject1 = null)
    {
      localbu.iq((String)localObject1);
      EmojiInfo localEmojiInfo = EZk;
      localObject1 = localObject2;
      if (localEmojiInfo != null) {
        localObject1 = localEmojiInfo.JS();
      }
      localbu.ir((String)localObject1);
      localbu.Qv();
      localbu.aBj();
      AppMethodBeat.o(169247);
      return;
    }
  }
  
  public static long getTimestamp()
  {
    return timestamp;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(long paramLong, EmojiInfo paramEmojiInfo) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(105852);
      bu localbu = new bu();
      Object localObject1 = b.EZl;
      localbu.eV(b.getTimestamp());
      localbu.eW(4L);
      localObject1 = b.EZl;
      localObject1 = b.eHE();
      if (localObject1 != null)
      {
        localObject1 = ((EmojiInfo)localObject1).field_groupId;
        localbu.iq((String)localObject1);
        localObject1 = b.EZl;
        EmojiInfo localEmojiInfo = b.eHE();
        localObject1 = localObject2;
        if (localEmojiInfo != null) {
          localObject1 = localEmojiInfo.JS();
        }
        localbu.ir((String)localObject1);
        localbu.eX(this.EZm);
        localbu.Qv();
        localbu.is(this.EZn.field_groupId);
        localbu.it(this.EZn.JS());
        localbu.iu(String.valueOf(this.EZn.LCo));
        if (!com.tencent.mm.emoji.a.h.abj().l(this.EZn)) {
          break label194;
        }
        localObject1 = "2";
        label155:
        localbu.iw((String)localObject1);
        if (!com.tencent.mm.plugin.emoji.h.b.w(this.EZn)) {
          break label200;
        }
        localbu.iv("1");
      }
      for (;;)
      {
        localbu.aBj();
        AppMethodBeat.o(105852);
        return;
        localObject1 = null;
        break;
        label194:
        localObject1 = "1";
        break label155;
        label200:
        localbu.iv("2");
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(long paramLong, ArrayList paramArrayList) {}
    
    public final void run()
    {
      Iterator localIterator = null;
      AppMethodBeat.i(105853);
      bu localbu = new bu();
      Object localObject = b.EZl;
      localbu.eV(b.getTimestamp());
      localbu.eW(3L);
      localObject = b.EZl;
      localObject = b.eHE();
      EmojiInfo localEmojiInfo;
      if (localObject != null)
      {
        localObject = ((EmojiInfo)localObject).field_groupId;
        localbu.iq((String)localObject);
        localObject = b.EZl;
        localEmojiInfo = b.eHE();
        localObject = localIterator;
        if (localEmojiInfo != null) {
          localObject = localEmojiInfo.JS();
        }
        localbu.ir((String)localObject);
        localbu.eX(this.EZm);
        localbu.Qv();
        localbu.is("");
        localbu.it("");
        localbu.iu("");
        localbu.iv("");
        localbu.iw("");
        localIterator = ((Iterable)this.EZo).iterator();
      }
      for (;;)
      {
        label148:
        if (!localIterator.hasNext()) {
          break label432;
        }
        localEmojiInfo = (EmojiInfo)localIterator.next();
        localObject = localbu.Qu();
        localbu.is((String)localObject + localEmojiInfo.field_groupId + "#");
        localObject = localbu.JS();
        localbu.it((String)localObject + localEmojiInfo.JS() + "#");
        localObject = localbu.Qw();
        localbu.iu((String)localObject + String.valueOf(localEmojiInfo.LCo) + "#");
        localObject = localbu.Qy();
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
        if (com.tencent.mm.emoji.a.h.abj().l(localEmojiInfo)) {}
        for (localObject = "2";; localObject = "1")
        {
          localbu.iw((String)localObject + "#");
          if (!com.tencent.mm.plugin.emoji.h.b.w(localEmojiInfo)) {
            break label392;
          }
          localObject = localbu.Qx();
          localbu.iv((String)localObject + "1".concat(String.valueOf("#")));
          break label148;
          localObject = null;
          break;
        }
        label392:
        localObject = localbu.Qx();
        localbu.iv((String)localObject + "2".concat(String.valueOf("#")));
      }
      label432:
      localbu.aBj();
      AppMethodBeat.o(105853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.search.b.b
 * JD-Core Version:    0.7.0.1
 */
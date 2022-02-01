package com.tencent.mm.search.c;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eb;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/search/report/SimilarEmojiReport;", "", "()V", "chatId", "", "source", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "reportClickEmoji", "", "select", "index", "reportClickSimilarMenu", "emojiInfo", "reportClickSosEntrance", "reportListIdle", "emojiList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportShowSimilarMenu", "plugin-emojisdk_release"})
public final class b
{
  private static EmojiInfo Iis;
  private static String Iit;
  public static final b Iiu;
  private static long timestamp;
  
  static
  {
    AppMethodBeat.i(105858);
    Iiu = new b();
    Iit = "";
    AppMethodBeat.o(105858);
  }
  
  public static void E(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105855);
    p.h(paramEmojiInfo, "emojiInfo");
    eb localeb = new eb();
    localeb.jT(timestamp);
    localeb.jU(2L);
    localeb.ni(paramEmojiInfo.field_groupId);
    localeb.nj(paramEmojiInfo.Lb());
    localeb.np(Iit);
    localeb.aLk();
    paramEmojiInfo = a.Iir;
    a.fmC();
    AppMethodBeat.o(105855);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(105857);
    p.h(paramEmojiInfo, "select");
    h.LTJ.aR((Runnable)new a(paramLong, paramEmojiInfo));
    AppMethodBeat.o(105857);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(218997);
    p.h(paramEmojiInfo, "emojiInfo");
    p.h(paramString, "chatId");
    timestamp = System.currentTimeMillis();
    Iis = paramEmojiInfo;
    Iit = paramString;
    eb localeb = new eb();
    localeb.jT(timestamp);
    localeb.jU(1L);
    localeb.ni(paramEmojiInfo.field_groupId);
    localeb.nj(paramEmojiInfo.Lb());
    localeb.np(paramString);
    localeb.aLk();
    paramEmojiInfo = a.Iir;
    a.fmB();
    AppMethodBeat.o(218997);
  }
  
  public static void b(ArrayList<EmojiInfo> paramArrayList, long paramLong)
  {
    AppMethodBeat.i(105856);
    p.h(paramArrayList, "emojiList");
    h.LTJ.aR((Runnable)new b(paramLong, paramArrayList));
    AppMethodBeat.o(105856);
  }
  
  public static void fmI()
  {
    Object localObject2 = null;
    AppMethodBeat.i(169247);
    eb localeb = new eb();
    localeb.jT(timestamp);
    localeb.jU(5L);
    Object localObject1 = Iis;
    if (localObject1 != null) {}
    for (localObject1 = ((EmojiInfo)localObject1).field_groupId;; localObject1 = null)
    {
      localeb.ni((String)localObject1);
      EmojiInfo localEmojiInfo = Iis;
      localObject1 = localObject2;
      if (localEmojiInfo != null) {
        localObject1 = localEmojiInfo.Lb();
      }
      localeb.nj((String)localObject1);
      localeb.Te();
      localeb.np(Iit);
      localeb.aLk();
      AppMethodBeat.o(169247);
      return;
    }
  }
  
  public static long getTimestamp()
  {
    return timestamp;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(long paramLong, EmojiInfo paramEmojiInfo) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(105852);
      eb localeb = new eb();
      Object localObject1 = b.Iiu;
      localeb.jT(b.getTimestamp());
      localeb.jU(4L);
      localObject1 = b.Iiu;
      localObject1 = b.fmJ();
      if (localObject1 != null)
      {
        localObject1 = ((EmojiInfo)localObject1).field_groupId;
        localeb.ni((String)localObject1);
        localObject1 = b.Iiu;
        EmojiInfo localEmojiInfo = b.fmJ();
        localObject1 = localObject2;
        if (localEmojiInfo != null) {
          localObject1 = localEmojiInfo.Lb();
        }
        localeb.nj((String)localObject1);
        localeb.jV(this.Iiv);
        localeb.Te();
        localeb.nk(this.Iiw.field_groupId);
        localeb.nl(this.Iiw.Lb());
        localeb.nm(String.valueOf(this.Iiw.Ofl));
        if (!com.tencent.mm.emoji.a.i.aeL().l(this.Iiw)) {
          break label206;
        }
        localObject1 = "2";
        label155:
        localeb.no((String)localObject1);
        if (!com.tencent.mm.plugin.emoji.h.b.w(this.Iiw)) {
          break label212;
        }
        localeb.nn("1");
      }
      for (;;)
      {
        localObject1 = b.Iiu;
        localeb.np(b.fmK());
        localeb.aLk();
        AppMethodBeat.o(105852);
        return;
        localObject1 = null;
        break;
        label206:
        localObject1 = "1";
        break label155;
        label212:
        localeb.nn("2");
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(long paramLong, ArrayList paramArrayList) {}
    
    public final void run()
    {
      Iterator localIterator = null;
      AppMethodBeat.i(105853);
      eb localeb = new eb();
      Object localObject = b.Iiu;
      localeb.jT(b.getTimestamp());
      localeb.jU(3L);
      localObject = b.Iiu;
      localObject = b.fmJ();
      EmojiInfo localEmojiInfo;
      if (localObject != null)
      {
        localObject = ((EmojiInfo)localObject).field_groupId;
        localeb.ni((String)localObject);
        localObject = b.Iiu;
        localEmojiInfo = b.fmJ();
        localObject = localIterator;
        if (localEmojiInfo != null) {
          localObject = localEmojiInfo.Lb();
        }
        localeb.nj((String)localObject);
        localeb.jV(this.Iiv);
        localeb.Te();
        localeb.nk("");
        localeb.nl("");
        localeb.nm("");
        localeb.nn("");
        localeb.no("");
        localIterator = ((Iterable)this.Iix).iterator();
      }
      for (;;)
      {
        label148:
        if (!localIterator.hasNext()) {
          break label432;
        }
        localEmojiInfo = (EmojiInfo)localIterator.next();
        localObject = localeb.Td();
        localeb.nk((String)localObject + localEmojiInfo.field_groupId + "#");
        localObject = localeb.Lb();
        localeb.nl((String)localObject + localEmojiInfo.Lb() + "#");
        localObject = localeb.Tf();
        localeb.nm((String)localObject + String.valueOf(localEmojiInfo.Ofl) + "#");
        localObject = localeb.Th();
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
        if (com.tencent.mm.emoji.a.i.aeL().l(localEmojiInfo)) {}
        for (localObject = "2";; localObject = "1")
        {
          localeb.no((String)localObject + "#");
          if (!com.tencent.mm.plugin.emoji.h.b.w(localEmojiInfo)) {
            break label392;
          }
          localObject = localeb.Tg();
          localeb.nn((String)localObject + "1".concat(String.valueOf("#")));
          break label148;
          localObject = null;
          break;
        }
        label392:
        localObject = localeb.Tg();
        localeb.nn((String)localObject + "2".concat(String.valueOf("#")));
      }
      label432:
      localObject = b.Iiu;
      localeb.np(b.fmK());
      localeb.aLk();
      AppMethodBeat.o(105853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.search.c.b
 * JD-Core Version:    0.7.0.1
 */
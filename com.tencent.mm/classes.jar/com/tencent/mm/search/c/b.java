package com.tencent.mm.search.c;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ed;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/search/report/SimilarEmojiReport;", "", "()V", "chatId", "", "source", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "reportClickEmoji", "", "select", "index", "reportClickSimilarMenu", "emojiInfo", "reportClickSosEntrance", "reportListIdle", "emojiList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportShowSimilarMenu", "plugin-emojisdk_release"})
public final class b
{
  private static EmojiInfo ICD;
  private static String ICE;
  public static final b ICF;
  private static long timestamp;
  
  static
  {
    AppMethodBeat.i(105858);
    ICF = new b();
    ICE = "";
    AppMethodBeat.o(105858);
  }
  
  public static void E(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105855);
    p.h(paramEmojiInfo, "emojiInfo");
    ed localed = new ed();
    localed.ke(timestamp);
    localed.kf(2L);
    localed.nD(paramEmojiInfo.field_groupId);
    localed.nE(paramEmojiInfo.Lj());
    localed.nK(ICE);
    localed.aLH();
    paramEmojiInfo = a.ICC;
    a.fqx();
    AppMethodBeat.o(105855);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(105857);
    p.h(paramEmojiInfo, "select");
    h.MqF.aO((Runnable)new a(paramLong, paramEmojiInfo));
    AppMethodBeat.o(105857);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(188619);
    p.h(paramEmojiInfo, "emojiInfo");
    p.h(paramString, "chatId");
    timestamp = System.currentTimeMillis();
    ICD = paramEmojiInfo;
    ICE = paramString;
    ed localed = new ed();
    localed.ke(timestamp);
    localed.kf(1L);
    localed.nD(paramEmojiInfo.field_groupId);
    localed.nE(paramEmojiInfo.Lj());
    localed.nK(paramString);
    localed.aLH();
    paramEmojiInfo = a.ICC;
    a.fqw();
    AppMethodBeat.o(188619);
  }
  
  public static void b(ArrayList<EmojiInfo> paramArrayList, long paramLong)
  {
    AppMethodBeat.i(105856);
    p.h(paramArrayList, "emojiList");
    h.MqF.aO((Runnable)new b(paramLong, paramArrayList));
    AppMethodBeat.o(105856);
  }
  
  public static void fqD()
  {
    Object localObject2 = null;
    AppMethodBeat.i(169247);
    ed localed = new ed();
    localed.ke(timestamp);
    localed.kf(5L);
    Object localObject1 = ICD;
    if (localObject1 != null) {}
    for (localObject1 = ((EmojiInfo)localObject1).field_groupId;; localObject1 = null)
    {
      localed.nD((String)localObject1);
      EmojiInfo localEmojiInfo = ICD;
      localObject1 = localObject2;
      if (localEmojiInfo != null) {
        localObject1 = localEmojiInfo.Lj();
      }
      localed.nE((String)localObject1);
      localed.Tk();
      localed.nK(ICE);
      localed.aLH();
      AppMethodBeat.o(169247);
      return;
    }
  }
  
  public static long getTimestamp()
  {
    return timestamp;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(long paramLong, EmojiInfo paramEmojiInfo) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(105852);
      ed localed = new ed();
      Object localObject1 = b.ICF;
      localed.ke(b.getTimestamp());
      localed.kf(4L);
      localObject1 = b.ICF;
      localObject1 = b.fqE();
      if (localObject1 != null)
      {
        localObject1 = ((EmojiInfo)localObject1).field_groupId;
        localed.nD((String)localObject1);
        localObject1 = b.ICF;
        EmojiInfo localEmojiInfo = b.fqE();
        localObject1 = localObject2;
        if (localEmojiInfo != null) {
          localObject1 = localEmojiInfo.Lj();
        }
        localed.nE((String)localObject1);
        localed.kg(this.ICG);
        localed.Tk();
        localed.nF(this.ICH.field_groupId);
        localed.nG(this.ICH.Lj());
        localed.nH(String.valueOf(this.ICH.OAs));
        if (!com.tencent.mm.emoji.a.i.aeX().l(this.ICH)) {
          break label206;
        }
        localObject1 = "2";
        label155:
        localed.nJ((String)localObject1);
        if (!com.tencent.mm.plugin.emoji.h.b.w(this.ICH)) {
          break label212;
        }
        localed.nI("1");
      }
      for (;;)
      {
        localObject1 = b.ICF;
        localed.nK(b.fqF());
        localed.aLH();
        AppMethodBeat.o(105852);
        return;
        localObject1 = null;
        break;
        label206:
        localObject1 = "1";
        break label155;
        label212:
        localed.nI("2");
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(long paramLong, ArrayList paramArrayList) {}
    
    public final void run()
    {
      Iterator localIterator = null;
      AppMethodBeat.i(105853);
      ed localed = new ed();
      Object localObject = b.ICF;
      localed.ke(b.getTimestamp());
      localed.kf(3L);
      localObject = b.ICF;
      localObject = b.fqE();
      EmojiInfo localEmojiInfo;
      if (localObject != null)
      {
        localObject = ((EmojiInfo)localObject).field_groupId;
        localed.nD((String)localObject);
        localObject = b.ICF;
        localEmojiInfo = b.fqE();
        localObject = localIterator;
        if (localEmojiInfo != null) {
          localObject = localEmojiInfo.Lj();
        }
        localed.nE((String)localObject);
        localed.kg(this.ICG);
        localed.Tk();
        localed.nF("");
        localed.nG("");
        localed.nH("");
        localed.nI("");
        localed.nJ("");
        localIterator = ((Iterable)this.ICI).iterator();
      }
      for (;;)
      {
        label148:
        if (!localIterator.hasNext()) {
          break label432;
        }
        localEmojiInfo = (EmojiInfo)localIterator.next();
        localObject = localed.Tj();
        localed.nF((String)localObject + localEmojiInfo.field_groupId + "#");
        localObject = localed.Lj();
        localed.nG((String)localObject + localEmojiInfo.Lj() + "#");
        localObject = localed.Tl();
        localed.nH((String)localObject + String.valueOf(localEmojiInfo.OAs) + "#");
        localObject = localed.Tn();
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
        if (com.tencent.mm.emoji.a.i.aeX().l(localEmojiInfo)) {}
        for (localObject = "2";; localObject = "1")
        {
          localed.nJ((String)localObject + "#");
          if (!com.tencent.mm.plugin.emoji.h.b.w(localEmojiInfo)) {
            break label392;
          }
          localObject = localed.Tm();
          localed.nI((String)localObject + "1".concat(String.valueOf("#")));
          break label148;
          localObject = null;
          break;
        }
        label392:
        localObject = localed.Tm();
        localed.nI((String)localObject + "2".concat(String.valueOf("#")));
      }
      label432:
      localObject = b.ICF;
      localed.nK(b.fqF());
      localed.aLH();
      AppMethodBeat.o(105853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.c.b
 * JD-Core Version:    0.7.0.1
 */
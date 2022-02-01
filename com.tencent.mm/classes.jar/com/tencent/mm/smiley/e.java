package com.tencent.mm.smiley;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiItemRepo;", "Lcom/tencent/mm/smiley/IEmojiRepo;", "()V", "mDescIndex", "Landroid/util/SparseArray;", "", "mEmojiDataSoftBankIndex", "Lcom/tencent/mm/smiley/SoftbankEmojiItem;", "mNameIndex", "Lcom/tencent/mm/smiley/NameIdxEmojiItem;", "mPicItemIndex", "Landroid/util/SparseIntArray;", "mSoftBankIndex", "rootNode", "Lcom/tencent/mm/smiley/EmojiItemRepo$EmojiItemNode;", "getRootNode", "()Lcom/tencent/mm/smiley/EmojiItemRepo$EmojiItemNode;", "append", "", "item", "Lcom/tencent/mm/smiley/SystemEmojiItem;", "emojiItemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/smiley/EmojiDataItem;", "constructIndex", "softbankEmojiItemList", "createEmojiDataItem", "Lcom/tencent/mm/smiley/IEmojiItem;", "findSystemEmojiItem", "dataItem", "getDescIndexs", "getEmojiDataSoftBankIndex", "getNameIndexs", "getPicItemIndex", "getRootEmojiItemNode", "getSoftbankIndexs", "process", "content", "", "start", "", "end", "matchCallback", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "processOne", "Companion", "EmojiItemNode", "EmojiItemRepoHolder", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a acxj;
  final SparseArray<v> acxk;
  final SparseArray<v> acxl;
  final SparseArray<p> acxm;
  SparseArray<String> acxn;
  private SparseIntArray acxo;
  final b acxp;
  
  static
  {
    AppMethodBeat.i(242850);
    acxj = new e.a((byte)0);
    AppMethodBeat.o(242850);
  }
  
  private e()
  {
    AppMethodBeat.i(242845);
    this.acxk = new SparseArray();
    this.acxl = new SparseArray();
    this.acxm = new SparseArray();
    this.acxn = new SparseArray();
    this.acxo = new SparseIntArray();
    this.acxp = new b(1024);
    AppMethodBeat.o(242845);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(242854);
    s.u(paramm, "matchCallback");
    new f((n)this.acxp).b(paramCharSequence, paramInt1, paramInt2, paramm);
    AppMethodBeat.o(242854);
  }
  
  public final l k(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(242856);
    f localf = new f((n)this.acxp);
    ah.f localf1 = new ah.f();
    localf.b(paramCharSequence, 0, paramInt, (m)new d(localf1));
    paramCharSequence = (l)localf1.aqH;
    AppMethodBeat.o(242856);
    return paramCharSequence;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiItemRepo$EmojiItemNode;", "Lcom/tencent/mm/smiley/AbsEmojiNode;", "()V", "defaultChildrenSize", "", "(I)V", "data", "Lcom/tencent/mm/smiley/IEmojiItem;", "getData", "()Lcom/tencent/mm/smiley/IEmojiItem;", "setData", "(Lcom/tencent/mm/smiley/IEmojiItem;)V", "createNode", "putSoftbank", "", "codePoint", "dataItem", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends a
  {
    l acwK;
    
    b()
    {
      this(1);
    }
    
    public b(int paramInt)
    {
      super();
    }
    
    public final void a(l paraml)
    {
      this.acwK = paraml;
    }
    
    public final l iUH()
    {
      return this.acwK;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiItemRepo$EmojiItemRepoHolder;", "", "()V", "instance", "Lcom/tencent/mm/smiley/EmojiItemRepo;", "getInstance", "()Lcom/tencent/mm/smiley/EmojiItemRepo;", "setInstance", "(Lcom/tencent/mm/smiley/EmojiItemRepo;)V", "updateEmojiItemRepoInstance", "", "newInstance", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
  {
    public static final c acxq;
    private static e acxr;
    
    static
    {
      AppMethodBeat.i(242807);
      acxq = new c();
      acxr = new e((byte)0);
      AppMethodBeat.o(242807);
    }
    
    public static e iUR()
    {
      return acxr;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/smiley/EmojiItemRepo$processOne$1", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "onMatch", "", "item", "Lcom/tencent/mm/smiley/IEmojiItem;", "startIndex", "", "endIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements m
  {
    d(ah.f<l> paramf) {}
    
    public final boolean a(l paraml, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242806);
      s.u(paraml, "item");
      this.Exw.aqH = paraml;
      AppMethodBeat.o(242806);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.e
 * JD-Core Version:    0.7.0.1
 */
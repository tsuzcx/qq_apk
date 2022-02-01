package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import d.g.b.k;
import d.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "getContext", "()Landroid/content/Context;", "setContext", "footerCount", "", "headerCount", "isFooterShow", "", "mCurrentVideoSize", "Ljava/util/HashSet;", "", "mIs2GOr3G", "addMember", "", "members", "Ljava/util/ArrayList;", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "Lkotlin/collections/ArrayList;", "clickListener", "Landroid/view/View$OnClickListener;", "checkIsAvatarContent", "position", "findChildIndexByUsername", "userName", "getAvatarCount", "getAvatarWidth", "getItemCount", "getItemViewType", "getMarginWidth", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "index", "setCurrentVideoSet", "currentVideoSet", "setIs2GOr3G", "is2GOr3G", "Companion", "plugin-multitalk_release"})
public final class a
  extends RecyclerView.a<b>
{
  private static final int qxJ = 2;
  private static final int qxK = 3;
  private static final int tQQ = 1;
  public static final a.a tQR;
  private Context context;
  final int qYg;
  public CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> tQL;
  public boolean tQM;
  public HashSet<String> tQN;
  private boolean tQO;
  int tQP;
  
  static
  {
    AppMethodBeat.i(178965);
    tQR = new a.a((byte)0);
    tQQ = 1;
    qxJ = 2;
    qxK = 3;
    AppMethodBeat.o(178965);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(178964);
    this.context = paramContext;
    this.tQL = new CopyOnWriteArrayList();
    this.qYg = 1;
    this.tQP = 1;
    AppMethodBeat.o(178964);
  }
  
  private final int aid(int paramInt)
  {
    AppMethodBeat.i(201307);
    switch (cSU())
    {
    default: 
      AppMethodBeat.o(201307);
      return 0;
    }
    if (paramInt == 2)
    {
      paramInt = cSV() / 2;
      AppMethodBeat.o(201307);
      return paramInt;
    }
    AppMethodBeat.o(201307);
    return 0;
  }
  
  private int cSU()
  {
    AppMethodBeat.i(178961);
    int i = getItemCount();
    int j = this.qYg;
    int k = this.tQP;
    AppMethodBeat.o(178961);
    return i - j - k;
  }
  
  private final int cSV()
  {
    AppMethodBeat.i(178962);
    int i = com.tencent.mm.cd.a.hW(this.context) - com.tencent.mm.cd.a.fromDPToPix(this.context, 285);
    int j = com.tencent.mm.cd.a.hV(this.context);
    if (i > j)
    {
      if (cSU() < 5)
      {
        i = j / 2;
        AppMethodBeat.o(178962);
        return i;
      }
      i = j / 3;
      AppMethodBeat.o(178962);
      return i;
    }
    if (cSU() < 5)
    {
      i /= 2;
      AppMethodBeat.o(178962);
      return i;
    }
    i /= 3;
    AppMethodBeat.o(178962);
    return i;
  }
  
  public final boolean Hm(int paramInt)
  {
    AppMethodBeat.i(178960);
    if ((paramInt < this.qYg) || (paramInt > getItemCount() - this.tQP - 1))
    {
      AppMethodBeat.o(178960);
      return true;
    }
    AppMethodBeat.o(178960);
    return false;
  }
  
  /* Error */
  public final void a(java.util.ArrayList<MultiTalkGroupMember> arg1, android.view.View.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 317
    //   5: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 318
    //   12: invokestatic 110	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_2
    //   16: ldc_w 319
    //   19: invokestatic 110	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   22: new 117	java/util/concurrent/CopyOnWriteArrayList
    //   25: dup
    //   26: invokespecial 118	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   29: astore 4
    //   31: aload_1
    //   32: checkcast 285	java/lang/Iterable
    //   35: invokeinterface 323 1 0
    //   40: astore 5
    //   42: iconst_0
    //   43: istore_3
    //   44: aload 5
    //   46: invokeinterface 329 1 0
    //   51: ifeq +95 -> 146
    //   54: aload 5
    //   56: invokeinterface 333 1 0
    //   61: astore_1
    //   62: iload_3
    //   63: ifge +6 -> 69
    //   66: invokestatic 336	d/a/j:fvx	()V
    //   69: aload_1
    //   70: checkcast 228	com/tencent/pb/talkroom/sdk/MultiTalkGroupMember
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 283	com/tencent/mm/plugin/multitalk/ui/widget/a:tQN	Ljava/util/HashSet;
    //   78: astore 6
    //   80: aload 6
    //   82: ifnull +49 -> 131
    //   85: aload 6
    //   87: aload_1
    //   88: getfield 232	com/tencent/pb/talkroom/sdk/MultiTalkGroupMember:Iol	Ljava/lang/String;
    //   91: invokevirtual 342	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   94: iconst_1
    //   95: if_icmpne +36 -> 131
    //   98: aload_0
    //   99: getfield 292	com/tencent/mm/plugin/multitalk/ui/widget/a:tQM	Z
    //   102: ifne +29 -> 131
    //   105: new 223	com/tencent/mm/plugin/multitalk/data/a
    //   108: dup
    //   109: aload_1
    //   110: aload_2
    //   111: iload_3
    //   112: iconst_1
    //   113: invokespecial 345	com/tencent/mm/plugin/multitalk/data/a:<init>	(Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;Landroid/view/View$OnClickListener;IZ)V
    //   116: astore_1
    //   117: aload 4
    //   119: aload_1
    //   120: invokevirtual 348	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: iload_3
    //   125: iconst_1
    //   126: iadd
    //   127: istore_3
    //   128: goto -84 -> 44
    //   131: new 223	com/tencent/mm/plugin/multitalk/data/a
    //   134: dup
    //   135: aload_1
    //   136: aload_2
    //   137: iload_3
    //   138: iconst_0
    //   139: invokespecial 345	com/tencent/mm/plugin/multitalk/data/a:<init>	(Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;Landroid/view/View$OnClickListener;IZ)V
    //   142: astore_1
    //   143: goto -26 -> 117
    //   146: aload_0
    //   147: getfield 120	com/tencent/mm/plugin/multitalk/ui/widget/a:tQL	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   150: astore_1
    //   151: aload_1
    //   152: monitorenter
    //   153: aload_0
    //   154: getfield 120	com/tencent/mm/plugin/multitalk/ui/widget/a:tQL	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   157: invokevirtual 351	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   160: aload_0
    //   161: getfield 120	com/tencent/mm/plugin/multitalk/ui/widget/a:tQL	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   164: aload 4
    //   166: checkcast 353	java/util/Collection
    //   169: invokevirtual 357	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   172: pop
    //   173: aload_0
    //   174: invokevirtual 360	com/tencent/mm/plugin/multitalk/ui/widget/a:notifyDataSetChanged	()V
    //   177: getstatic 366	d/y:JfV	Ld/y;
    //   180: astore_2
    //   181: aload_1
    //   182: monitorexit
    //   183: ldc_w 317
    //   186: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_0
    //   190: monitorexit
    //   191: return
    //   192: astore_2
    //   193: aload_1
    //   194: monitorexit
    //   195: ldc_w 317
    //   198: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_2
    //   202: athrow
    //   203: astore_1
    //   204: aload_0
    //   205: monitorexit
    //   206: aload_1
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	a
    //   0	208	2	paramOnClickListener	android.view.View.OnClickListener
    //   43	95	3	i	int
    //   29	136	4	localCopyOnWriteArrayList	CopyOnWriteArrayList
    //   40	15	5	localIterator	Iterator
    //   78	8	6	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   153	181	192	finally
    //   2	42	203	finally
    //   44	62	203	finally
    //   66	69	203	finally
    //   69	80	203	finally
    //   85	117	203	finally
    //   117	124	203	finally
    //   131	143	203	finally
    //   146	153	203	finally
    //   181	189	203	finally
    //   193	203	203	finally
  }
  
  public final int ahJ(String paramString)
  {
    AppMethodBeat.i(178955);
    k.h(paramString, "userName");
    Iterator localIterator = ((Iterable)this.tQL).iterator();
    Object localObject1;
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      localObject1 = (com.tencent.mm.plugin.multitalk.data.a)localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localObject1).tOo;
        if (localObject1 != null)
        {
          localObject1 = ((MultiTalkGroupMember)localObject1).Iol;
          label77:
          if (!k.g(localObject1, paramString)) {
            break label122;
          }
          paramString = localObject2;
          label89:
          paramString = (com.tencent.mm.plugin.multitalk.data.a)paramString;
          if (paramString == null) {
            break label129;
          }
        }
      }
    }
    label129:
    for (int i = paramString.index;; i = -1)
    {
      int j = this.qYg;
      AppMethodBeat.o(178955);
      return i + j;
      localObject1 = null;
      break label77;
      label122:
      break;
      paramString = null;
      break label89;
    }
  }
  
  public final void d(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(178956);
    k.h(paramHashSet, "currentVideoSet");
    this.tQN = paramHashSet;
    AppMethodBeat.o(178956);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178959);
    if (this.tQL.size() > 12)
    {
      this.tQO = true;
      this.tQP = 1;
      i = this.tQL.size();
      j = this.qYg;
      int k = this.tQP;
      AppMethodBeat.o(178959);
      return i + j + k;
    }
    this.tQO = false;
    this.tQP = 0;
    int i = this.tQL.size();
    int j = this.qYg;
    AppMethodBeat.o(178959);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(178958);
    if (paramInt == 0)
    {
      paramInt = qxJ;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    if (paramInt == getItemCount() - 1)
    {
      if (this.tQO)
      {
        paramInt = qxK;
        AppMethodBeat.o(178958);
        return paramInt;
      }
      paramInt = tQQ;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    paramInt = tQQ;
    AppMethodBeat.o(178958);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */
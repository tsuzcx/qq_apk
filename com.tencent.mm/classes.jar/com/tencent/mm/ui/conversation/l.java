package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.am.af;
import com.tencent.mm.am.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;
import java.util.LinkedList;

public final class l
  extends q<a>
{
  private boolean Hfd;
  private m Hfe;
  final j Hff;
  public final com.tencent.mm.ui.bizchat.b Hfg;
  private final DataSetObserver Hfh;
  
  public l(Context paramContext, String paramString, q.a parama)
  {
    super(paramContext, new a());
    AppMethodBeat.i(191745);
    this.Hfd = false;
    this.Hfh = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(191739);
        if (l.a(l.this) != null) {
          l.a(l.this).fcH();
        }
        l.this.notifyDataSetChanged();
        AppMethodBeat.o(191739);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(191740);
        if (l.a(l.this) != null) {
          l.a(l.this).fcH();
        }
        l.this.notifyDataSetInvalidated();
        AppMethodBeat.o(191740);
      }
    };
    super.vw(false);
    this.Hff = new j(paramContext, paramString, parama);
    this.Hff.registerDataSetObserver(this.Hfh);
    af.awe();
    String str = e.wC(paramString);
    if (bt.isNullOrNil(str)) {}
    for (;;)
    {
      this.Hfg = new com.tencent.mm.ui.bizchat.b(paramContext, parama, paramString);
      this.Hfg.registerDataSetObserver(this.Hfh);
      paramContext = this.Hfg;
      af.awh().add(paramContext);
      af.awh().a(paramContext, paramContext.GgP.getMainLooper());
      AppMethodBeat.o(191745);
      return;
      paramString = str;
    }
  }
  
  /* Error */
  private a a(a parama, Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc 117
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: astore_3
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: new 13	com/tencent/mm/ui/conversation/l$a
    //   14: dup
    //   15: invokespecial 29	com/tencent/mm/ui/conversation/l$a:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_0
    //   21: getfield 119	com/tencent/mm/ui/conversation/l:Hfe	Lcom/tencent/mm/ui/conversation/m;
    //   24: invokevirtual 125	com/tencent/mm/ui/conversation/m:fcI	()Landroid/database/Cursor;
    //   27: invokeinterface 131 1 0
    //   32: putfield 135	com/tencent/mm/ui/conversation/l$a:Hfj	I
    //   35: aload_3
    //   36: aconst_null
    //   37: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/am;
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 85	com/tencent/mm/ui/conversation/l:Hfg	Lcom/tencent/mm/ui/bizchat/b;
    //   45: aload_3
    //   46: getfield 143	com/tencent/mm/ui/conversation/l$a:Hfk	Lcom/tencent/mm/am/a/a;
    //   49: aload_2
    //   50: invokevirtual 146	com/tencent/mm/ui/bizchat/b:a	(Lcom/tencent/mm/am/a/a;Landroid/database/Cursor;)Lcom/tencent/mm/am/a/a;
    //   53: putfield 143	com/tencent/mm/ui/conversation/l$a:Hfk	Lcom/tencent/mm/am/a/a;
    //   56: aload_3
    //   57: getfield 143	com/tencent/mm/ui/conversation/l$a:Hfk	Lcom/tencent/mm/am/a/a;
    //   60: getfield 152	com/tencent/mm/am/a/a:field_bizChatId	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifle +15 -> 80
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 155	com/tencent/mm/ui/conversation/l$a:nBH	I
    //   73: ldc 117
    //   75: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_3
    //   79: areturn
    //   80: aload_3
    //   81: aconst_null
    //   82: putfield 143	com/tencent/mm/ui/conversation/l$a:Hfk	Lcom/tencent/mm/am/a/a;
    //   85: aload_3
    //   86: aload_3
    //   87: getfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/am;
    //   90: aload_2
    //   91: invokestatic 158	com/tencent/mm/ui/conversation/j:a	(Lcom/tencent/mm/storage/am;Landroid/database/Cursor;)Lcom/tencent/mm/storage/am;
    //   94: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/am;
    //   97: aload_3
    //   98: iconst_1
    //   99: putfield 155	com/tencent/mm/ui/conversation/l$a:nBH	I
    //   102: ldc 117
    //   104: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_3
    //   108: areturn
    //   109: astore_1
    //   110: aload_3
    //   111: aconst_null
    //   112: putfield 143	com/tencent/mm/ui/conversation/l$a:Hfk	Lcom/tencent/mm/am/a/a;
    //   115: goto -30 -> 85
    //   118: astore_1
    //   119: aload_3
    //   120: aconst_null
    //   121: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/am;
    //   124: goto -22 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	l
    //   0	127	1	parama	a
    //   0	127	2	paramCursor	Cursor
    //   6	114	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   35	73	109	java/lang/Throwable
    //   80	85	109	java/lang/Throwable
    //   85	102	118	java/lang/Throwable
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(191747);
    this.Hff.Wd();
    this.Hfg.Wd();
    this.Hfe = new m(m.e.HfF, new m.a[] { new m.a()new m.a
    {
      protected final m.d d(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(191742);
        m.d locald = new m.d();
        String str = paramAnonymousCursor.getString(b(paramAnonymousCursor, "username"));
        locald.HfC = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "conversationTime"));
        if (((k)g.ab(k.class)).apR().aIv(str)) {}
        for (locald.HfD = 1;; locald.HfD = 0)
        {
          AppMethodBeat.o(191742);
          return locald;
        }
      }
      
      public final Cursor fcF()
      {
        AppMethodBeat.i(191741);
        Cursor localCursor = l.b(l.this).getCursor();
        AppMethodBeat.o(191741);
        return localCursor;
      }
    }, new m.a()
    {
      protected final m.d d(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(191744);
        m.d locald = new m.d();
        locald.HfC = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "lastMsgTime"));
        if ((paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0x0) != 0L) {}
        for (locald.HfD = 1;; locald.HfD = 0)
        {
          AppMethodBeat.o(191744);
          return locald;
        }
      }
      
      public final Cursor fcF()
      {
        AppMethodBeat.i(191743);
        Cursor localCursor = l.this.Hfg.getCursor();
        AppMethodBeat.o(191743);
        return localCursor;
      }
    } });
    setCursor(this.Hfe);
    AppMethodBeat.o(191747);
  }
  
  public final void We()
  {
    AppMethodBeat.i(191748);
    if (this.Hfd)
    {
      this.Hfe = m.fcG();
      setCursor(this.Hfe);
      AppMethodBeat.o(191748);
      return;
    }
    this.Hfd = true;
    Wd();
    this.Hfd = false;
    AppMethodBeat.o(191748);
  }
  
  public final a ZP(int paramInt)
  {
    AppMethodBeat.i(191750);
    a locala2 = (a)super.getItem(paramInt);
    Object localObject1 = locala2;
    if (locala2 == null) {
      localObject1 = locala2;
    }
    try
    {
      j = this.Hff.getCount();
      localObject1 = locala2;
      i = this.Hfg.getCount();
      localObject1 = locala2;
      ad.w("MergeBizChatConversationAdapter", "getItem NULL, position=%d, size=%d, cursor.size=[%d, %d], window=[%d, %d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.Hfe.Hfo), Integer.valueOf(this.Hfe.Hfo + this.Hfe.Hfp.size()) });
      locala1 = locala2;
      if (j > 0)
      {
        locala1 = locala2;
        if (paramInt < j)
        {
          localObject1 = locala2;
          locala1 = new a();
        }
      }
    }
    catch (Throwable localThrowable3)
    {
      int j;
      int i;
      a locala1;
      label281:
      break label281;
    }
    try
    {
      locala1.nBH = 1;
      locala1.Hfj = Math.max(0, paramInt);
      locala1.conversation = ((am)this.Hff.getItem(locala1.Hfj));
      paramInt -= j;
      localObject1 = locala1;
      if (locala1 == null)
      {
        localObject1 = locala1;
        if (i > 0)
        {
          localObject1 = locala1;
          if (paramInt < i)
          {
            localObject1 = locala1;
            locala1 = new a();
          }
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject2 = localThrowable3;
      break label281;
    }
    try
    {
      locala1.nBH = 0;
      locala1.Hfj = Math.max(0, paramInt);
      locala1.Hfk = ((a)this.Hfg.getItem(locala1.Hfj));
      localObject1 = locala1;
    }
    catch (Throwable localThrowable2)
    {
      Object localObject3 = localThrowable3;
      break label281;
    }
    AppMethodBeat.o(191750);
    return localObject1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(191753);
    if (this.Hfe != null)
    {
      i = this.Hfe.getCount();
      AppMethodBeat.o(191753);
      return i;
    }
    int i = super.getCount();
    AppMethodBeat.o(191753);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(191752);
    a locala = ZP(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(191752);
      return 0;
    }
    paramInt = locala.nBH;
    AppMethodBeat.o(191752);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(191751);
    a locala = ZP(paramInt);
    int i = locala.nBH;
    paramInt = 1;
    for (;;)
    {
      if (i == 1) {}
      try
      {
        localView = this.Hff.getView(locala.Hfj, paramView, paramViewGroup);
        AppMethodBeat.o(191751);
        return localView;
      }
      catch (ClassCastException localClassCastException)
      {
        View localView;
        if (paramView == null) {
          break label99;
        }
        localObject = null;
        if (paramInt > 0) {
          break label107;
        }
        AppMethodBeat.o(191751);
        return null;
      }
      localView = paramView;
      if (i == 0)
      {
        localView = this.Hfg.getView(locala.Hfj, paramView, paramViewGroup);
        AppMethodBeat.o(191751);
        return localView;
      }
      Object localObject;
      label99:
      label107:
      paramInt -= 1;
      paramView = localObject;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final void vw(boolean paramBoolean)
  {
    AppMethodBeat.i(191746);
    super.vw(false);
    AppMethodBeat.o(191746);
  }
  
  public static final class a
  {
    int Hfj = 0;
    public a Hfk;
    public am conversation;
    int nBH = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

public final class l
  extends r<a>
{
  private boolean KwC;
  private m KwD;
  final j KwE;
  public final com.tencent.mm.ui.bizchat.b KwF;
  private final DataSetObserver KwG;
  
  public l(Context paramContext, String paramString, r.a parama)
  {
    super(paramContext, new a());
    AppMethodBeat.i(194710);
    this.KwC = false;
    this.KwG = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(194704);
        if (l.a(l.this) != null) {
          l.a(l.this).fJq();
        }
        l.this.notifyDataSetChanged();
        AppMethodBeat.o(194704);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(194705);
        if (l.a(l.this) != null) {
          l.a(l.this).fJq();
        }
        l.this.notifyDataSetInvalidated();
        AppMethodBeat.o(194705);
      }
    };
    super.xk(false);
    this.KwE = new j(paramContext, paramString, parama);
    this.KwE.registerDataSetObserver(this.KwG);
    ag.aFZ();
    String str = f.DH(paramString);
    if (bt.isNullOrNil(str)) {}
    for (;;)
    {
      this.KwF = new com.tencent.mm.ui.bizchat.b(paramContext, parama, paramString);
      this.KwF.registerDataSetObserver(this.KwG);
      paramContext = this.KwF;
      ag.aGc().add(paramContext);
      ag.aGc().a(paramContext, paramContext.Juv.getMainLooper());
      AppMethodBeat.o(194710);
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
    //   21: getfield 119	com/tencent/mm/ui/conversation/l:KwD	Lcom/tencent/mm/ui/conversation/m;
    //   24: invokevirtual 125	com/tencent/mm/ui/conversation/m:fJr	()Landroid/database/Cursor;
    //   27: invokeinterface 131 1 0
    //   32: putfield 135	com/tencent/mm/ui/conversation/l$a:KwI	I
    //   35: aload_3
    //   36: aconst_null
    //   37: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/at;
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 85	com/tencent/mm/ui/conversation/l:KwF	Lcom/tencent/mm/ui/bizchat/b;
    //   45: aload_3
    //   46: getfield 143	com/tencent/mm/ui/conversation/l$a:KwJ	Lcom/tencent/mm/am/a/a;
    //   49: aload_2
    //   50: invokevirtual 146	com/tencent/mm/ui/bizchat/b:a	(Lcom/tencent/mm/am/a/a;Landroid/database/Cursor;)Lcom/tencent/mm/am/a/a;
    //   53: putfield 143	com/tencent/mm/ui/conversation/l$a:KwJ	Lcom/tencent/mm/am/a/a;
    //   56: aload_3
    //   57: getfield 143	com/tencent/mm/ui/conversation/l$a:KwJ	Lcom/tencent/mm/am/a/a;
    //   60: getfield 152	com/tencent/mm/am/a/a:field_bizChatId	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifle +15 -> 80
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 155	com/tencent/mm/ui/conversation/l$a:oIb	I
    //   73: ldc 117
    //   75: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_3
    //   79: areturn
    //   80: aload_3
    //   81: aconst_null
    //   82: putfield 143	com/tencent/mm/ui/conversation/l$a:KwJ	Lcom/tencent/mm/am/a/a;
    //   85: aload_3
    //   86: aload_3
    //   87: getfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/at;
    //   90: aload_2
    //   91: invokestatic 158	com/tencent/mm/ui/conversation/j:a	(Lcom/tencent/mm/storage/at;Landroid/database/Cursor;)Lcom/tencent/mm/storage/at;
    //   94: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/at;
    //   97: aload_3
    //   98: iconst_1
    //   99: putfield 155	com/tencent/mm/ui/conversation/l$a:oIb	I
    //   102: ldc 117
    //   104: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_3
    //   108: areturn
    //   109: astore_1
    //   110: aload_3
    //   111: aconst_null
    //   112: putfield 143	com/tencent/mm/ui/conversation/l$a:KwJ	Lcom/tencent/mm/am/a/a;
    //   115: goto -30 -> 85
    //   118: astore_1
    //   119: aload_3
    //   120: aconst_null
    //   121: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/at;
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
  
  public final void Zu()
  {
    AppMethodBeat.i(194712);
    this.KwE.Zu();
    this.KwF.Zu();
    this.KwD = new m(m.e.Kxe, new m.a[] { new m.a()new m.a
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(194707);
        m.d locald = new m.d();
        String str = paramAnonymousCursor.getString(b(paramAnonymousCursor, "username"));
        locald.Kxb = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "conversationTime"));
        if (locald.Kxb == 0L) {
          locald.Kxb = (paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0xFFFFFFFF);
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTH(str)) {}
        for (locald.Kxc = 1;; locald.Kxc = 0)
        {
          AppMethodBeat.o(194707);
          return locald;
        }
      }
      
      public final Cursor fJo()
      {
        AppMethodBeat.i(194706);
        Cursor localCursor = l.b(l.this).getCursor();
        AppMethodBeat.o(194706);
        return localCursor;
      }
    }, new m.a()
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(194709);
        m.d locald = new m.d();
        locald.Kxb = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "lastMsgTime"));
        if ((paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0x0) != 0L) {}
        for (locald.Kxc = 1;; locald.Kxc = 0)
        {
          AppMethodBeat.o(194709);
          return locald;
        }
      }
      
      public final Cursor fJo()
      {
        AppMethodBeat.i(194708);
        Cursor localCursor = l.this.KwF.getCursor();
        AppMethodBeat.o(194708);
        return localCursor;
      }
    } });
    setCursor(this.KwD);
    AppMethodBeat.o(194712);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(194713);
    if (this.KwC)
    {
      this.KwD = m.fJp();
      setCursor(this.KwD);
      AppMethodBeat.o(194713);
      return;
    }
    this.KwC = true;
    Zu();
    this.KwC = false;
    AppMethodBeat.o(194713);
  }
  
  public final a aeA(int paramInt)
  {
    AppMethodBeat.i(194715);
    a locala2 = (a)super.getItem(paramInt);
    Object localObject1 = locala2;
    if (locala2 == null) {
      localObject1 = locala2;
    }
    try
    {
      j = this.KwE.getCount();
      localObject1 = locala2;
      i = this.KwF.getCount();
      localObject1 = locala2;
      ad.w("MergeBizChatConversationAdapter", "getItem NULL, position=%d, size=%d, cursor.size=[%d, %d], window=[%d, %d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.KwD.KwN), Integer.valueOf(this.KwD.KwN + this.KwD.KwO.size()) });
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
      locala1.oIb = 1;
      locala1.KwI = Math.max(0, paramInt);
      locala1.conversation = ((at)this.KwE.getItem(locala1.KwI));
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
      locala1.oIb = 0;
      locala1.KwI = Math.max(0, paramInt);
      locala1.KwJ = ((a)this.KwF.getItem(locala1.KwI));
      localObject1 = locala1;
    }
    catch (Throwable localThrowable2)
    {
      Object localObject3 = localThrowable3;
      break label281;
    }
    AppMethodBeat.o(194715);
    return localObject1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(194718);
    if (this.KwD != null)
    {
      i = this.KwD.getCount();
      AppMethodBeat.o(194718);
      return i;
    }
    int i = super.getCount();
    AppMethodBeat.o(194718);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(194717);
    a locala = aeA(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(194717);
      return 0;
    }
    paramInt = locala.oIb;
    AppMethodBeat.o(194717);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(194716);
    a locala = aeA(paramInt);
    int i = locala.oIb;
    paramInt = 1;
    for (;;)
    {
      if (i == 1) {}
      try
      {
        localView = this.KwE.getView(locala.KwI, paramView, paramViewGroup);
        AppMethodBeat.o(194716);
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
        AppMethodBeat.o(194716);
        return null;
      }
      localView = paramView;
      if (i == 0)
      {
        localView = this.KwF.getView(locala.KwI, paramView, paramViewGroup);
        AppMethodBeat.o(194716);
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
  
  public final void xk(boolean paramBoolean)
  {
    AppMethodBeat.i(194711);
    super.xk(false);
    AppMethodBeat.o(194711);
  }
  
  public static final class a
  {
    int KwI = 0;
    public a KwJ;
    public at conversation;
    int oIb = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l
 * JD-Core Version:    0.7.0.1
 */
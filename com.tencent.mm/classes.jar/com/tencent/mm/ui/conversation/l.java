package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;
import java.util.LinkedList;

public final class l
  extends s<a>
{
  private boolean Qgd;
  private m Qge;
  final j Qgf;
  public final com.tencent.mm.ui.bizchat.b Qgg;
  private final DataSetObserver Qgh;
  
  public l(Context paramContext, String paramString, s.a parama)
  {
    super(paramContext, new a());
    AppMethodBeat.i(234205);
    this.Qgd = false;
    this.Qgh = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(234199);
        if (l.a(l.this) != null) {
          l.a(l.this).gWb();
        }
        l.this.notifyDataSetChanged();
        AppMethodBeat.o(234199);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(234200);
        if (l.a(l.this) != null) {
          l.a(l.this).gWb();
        }
        l.this.notifyDataSetInvalidated();
        AppMethodBeat.o(234200);
      }
    };
    super.Bh(false);
    this.Qgf = new j(paramContext, paramString, parama);
    this.Qgf.registerDataSetObserver(this.Qgh);
    ag.bah();
    String str = f.MX(paramString);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      this.Qgg = new com.tencent.mm.ui.bizchat.b(paramContext, parama, paramString);
      this.Qgg.registerDataSetObserver(this.Qgh);
      paramContext = this.Qgg;
      ag.bak().add(paramContext);
      ag.bak().a(paramContext, paramContext.wkt.getMainLooper());
      AppMethodBeat.o(234205);
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
    //   21: getfield 119	com/tencent/mm/ui/conversation/l:Qge	Lcom/tencent/mm/ui/conversation/m;
    //   24: invokevirtual 125	com/tencent/mm/ui/conversation/m:gWc	()Landroid/database/Cursor;
    //   27: invokeinterface 131 1 0
    //   32: putfield 135	com/tencent/mm/ui/conversation/l$a:Qgj	I
    //   35: aload_3
    //   36: aconst_null
    //   37: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/az;
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 85	com/tencent/mm/ui/conversation/l:Qgg	Lcom/tencent/mm/ui/bizchat/b;
    //   45: aload_3
    //   46: getfield 143	com/tencent/mm/ui/conversation/l$a:Qgk	Lcom/tencent/mm/al/a/a;
    //   49: aload_2
    //   50: invokevirtual 146	com/tencent/mm/ui/bizchat/b:a	(Lcom/tencent/mm/al/a/a;Landroid/database/Cursor;)Lcom/tencent/mm/al/a/a;
    //   53: putfield 143	com/tencent/mm/ui/conversation/l$a:Qgk	Lcom/tencent/mm/al/a/a;
    //   56: aload_3
    //   57: getfield 143	com/tencent/mm/ui/conversation/l$a:Qgk	Lcom/tencent/mm/al/a/a;
    //   60: getfield 152	com/tencent/mm/al/a/a:field_bizChatId	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifle +15 -> 80
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 155	com/tencent/mm/ui/conversation/l$a:qcr	I
    //   73: ldc 117
    //   75: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_3
    //   79: areturn
    //   80: aload_3
    //   81: aconst_null
    //   82: putfield 143	com/tencent/mm/ui/conversation/l$a:Qgk	Lcom/tencent/mm/al/a/a;
    //   85: aload_3
    //   86: aload_3
    //   87: getfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/az;
    //   90: aload_2
    //   91: invokestatic 158	com/tencent/mm/ui/conversation/j:a	(Lcom/tencent/mm/storage/az;Landroid/database/Cursor;)Lcom/tencent/mm/storage/az;
    //   94: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/az;
    //   97: aload_3
    //   98: iconst_1
    //   99: putfield 155	com/tencent/mm/ui/conversation/l$a:qcr	I
    //   102: ldc 117
    //   104: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_3
    //   108: areturn
    //   109: astore_1
    //   110: aload_3
    //   111: aconst_null
    //   112: putfield 143	com/tencent/mm/ui/conversation/l$a:Qgk	Lcom/tencent/mm/al/a/a;
    //   115: goto -30 -> 85
    //   118: astore_1
    //   119: aload_3
    //   120: aconst_null
    //   121: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/az;
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
  
  public final void Bh(boolean paramBoolean)
  {
    AppMethodBeat.i(234206);
    super.Bh(false);
    AppMethodBeat.o(234206);
  }
  
  public final a anT(int paramInt)
  {
    AppMethodBeat.i(234210);
    a locala2 = (a)super.getItem(paramInt);
    Object localObject1 = locala2;
    if (locala2 == null) {
      localObject1 = locala2;
    }
    try
    {
      j = this.Qgf.getCount();
      localObject1 = locala2;
      i = this.Qgg.getCount();
      localObject1 = locala2;
      Log.w("MergeBizChatConversationAdapter", "getItem NULL, position=%d, size=%d, cursor.size=[%d, %d], window=[%d, %d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.Qge.Qgo), Integer.valueOf(this.Qge.Qgo + this.Qge.Qgp.size()) });
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
      locala1.qcr = 1;
      locala1.Qgj = Math.max(0, paramInt);
      locala1.conversation = ((az)this.Qgf.getItem(locala1.Qgj));
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
      locala1.qcr = 0;
      locala1.Qgj = Math.max(0, paramInt);
      locala1.Qgk = ((a)this.Qgg.getItem(locala1.Qgj));
      localObject1 = locala1;
    }
    catch (Throwable localThrowable2)
    {
      Object localObject3 = localThrowable3;
      break label281;
    }
    AppMethodBeat.o(234210);
    return localObject1;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(234207);
    this.Qgf.anp();
    this.Qgg.anp();
    this.Qge = new m(m.e.QgF, new m.a[] { new m.a()new m.a
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(234202);
        m.d locald = new m.d();
        String str = paramAnonymousCursor.getString(b(paramAnonymousCursor, "username"));
        locald.QgC = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "conversationTime"));
        if (locald.QgC == 0L) {
          locald.QgC = (paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0xFFFFFFFF);
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkg(str)) {}
        for (locald.QgD = 1;; locald.QgD = 0)
        {
          AppMethodBeat.o(234202);
          return locald;
        }
      }
      
      public final Cursor gVZ()
      {
        AppMethodBeat.i(234201);
        Cursor localCursor = l.b(l.this).getCursor();
        AppMethodBeat.o(234201);
        return localCursor;
      }
    }, new m.a()
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(234204);
        m.d locald = new m.d();
        locald.QgC = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "lastMsgTime"));
        if ((paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0x0) != 0L) {}
        for (locald.QgD = 1;; locald.QgD = 0)
        {
          AppMethodBeat.o(234204);
          return locald;
        }
      }
      
      public final Cursor gVZ()
      {
        AppMethodBeat.i(234203);
        Cursor localCursor = l.this.Qgg.getCursor();
        AppMethodBeat.o(234203);
        return localCursor;
      }
    } });
    setCursor(this.Qge);
    AppMethodBeat.o(234207);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(234208);
    if (this.Qgd)
    {
      this.Qge = m.gWa();
      setCursor(this.Qge);
      AppMethodBeat.o(234208);
      return;
    }
    this.Qgd = true;
    anp();
    this.Qgd = false;
    AppMethodBeat.o(234208);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(234213);
    if (this.Qge != null)
    {
      i = this.Qge.getCount();
      AppMethodBeat.o(234213);
      return i;
    }
    int i = super.getCount();
    AppMethodBeat.o(234213);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(234212);
    a locala = anT(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(234212);
      return 0;
    }
    paramInt = locala.qcr;
    AppMethodBeat.o(234212);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(234211);
    a locala = anT(paramInt);
    int i = locala.qcr;
    paramInt = 1;
    for (;;)
    {
      if (i == 1) {}
      try
      {
        localView = this.Qgf.getView(locala.Qgj, paramView, paramViewGroup);
        AppMethodBeat.o(234211);
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
        AppMethodBeat.o(234211);
        return null;
      }
      localView = paramView;
      if (i == 0)
      {
        localView = this.Qgg.getView(locala.Qgj, paramView, paramViewGroup);
        AppMethodBeat.o(234211);
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
  
  public static final class a
  {
    int Qgj = 0;
    public a Qgk;
    public az conversation;
    int qcr = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l
 * JD-Core Version:    0.7.0.1
 */
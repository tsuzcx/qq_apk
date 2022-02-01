package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a.a;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;
import java.util.LinkedList;

public final class m
  extends v<a>
{
  private boolean XDi;
  private n XDj;
  final k XDk;
  public final com.tencent.mm.ui.bizchat.b XDl;
  private final DataSetObserver XDm;
  
  public m(Context paramContext, String paramString, v.a parama)
  {
    super(paramContext, new a());
    AppMethodBeat.i(288433);
    this.XDi = false;
    this.XDm = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(279768);
        if (m.a(m.this) != null) {
          m.a(m.this).hWB();
        }
        m.this.notifyDataSetChanged();
        AppMethodBeat.o(279768);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(279770);
        if (m.a(m.this) != null) {
          m.a(m.this).hWB();
        }
        m.this.notifyDataSetInvalidated();
        AppMethodBeat.o(279770);
      }
    };
    super.Fx(false);
    this.XDk = new k(paramContext, paramString, parama);
    this.XDk.registerDataSetObserver(this.XDm);
    af.bjv();
    String str = f.Ut(paramString);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      this.XDl = new com.tencent.mm.ui.bizchat.b(paramContext, parama, paramString);
      this.XDl.registerDataSetObserver(this.XDm);
      paramContext = this.XDl;
      af.bjy().add(paramContext);
      af.bjy().a(paramContext, paramContext.AVp.getMainLooper());
      AppMethodBeat.o(288433);
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
    //   11: new 13	com/tencent/mm/ui/conversation/m$a
    //   14: dup
    //   15: invokespecial 29	com/tencent/mm/ui/conversation/m$a:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_0
    //   21: getfield 119	com/tencent/mm/ui/conversation/m:XDj	Lcom/tencent/mm/ui/conversation/n;
    //   24: invokevirtual 125	com/tencent/mm/ui/conversation/n:hWC	()Landroid/database/Cursor;
    //   27: invokeinterface 131 1 0
    //   32: putfield 135	com/tencent/mm/ui/conversation/m$a:XDo	I
    //   35: aload_3
    //   36: aconst_null
    //   37: putfield 139	com/tencent/mm/ui/conversation/m$a:conversation	Lcom/tencent/mm/storage/az;
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 85	com/tencent/mm/ui/conversation/m:XDl	Lcom/tencent/mm/ui/bizchat/b;
    //   45: aload_3
    //   46: getfield 143	com/tencent/mm/ui/conversation/m$a:XDp	Lcom/tencent/mm/ao/a/a;
    //   49: aload_2
    //   50: invokevirtual 146	com/tencent/mm/ui/bizchat/b:a	(Lcom/tencent/mm/ao/a/a;Landroid/database/Cursor;)Lcom/tencent/mm/ao/a/a;
    //   53: putfield 143	com/tencent/mm/ui/conversation/m$a:XDp	Lcom/tencent/mm/ao/a/a;
    //   56: aload_3
    //   57: getfield 143	com/tencent/mm/ui/conversation/m$a:XDp	Lcom/tencent/mm/ao/a/a;
    //   60: getfield 152	com/tencent/mm/ao/a/a:field_bizChatId	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifle +15 -> 80
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 155	com/tencent/mm/ui/conversation/m$a:viewType	I
    //   73: ldc 117
    //   75: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_3
    //   79: areturn
    //   80: aload_3
    //   81: aconst_null
    //   82: putfield 143	com/tencent/mm/ui/conversation/m$a:XDp	Lcom/tencent/mm/ao/a/a;
    //   85: aload_3
    //   86: aload_3
    //   87: getfield 139	com/tencent/mm/ui/conversation/m$a:conversation	Lcom/tencent/mm/storage/az;
    //   90: aload_2
    //   91: invokestatic 158	com/tencent/mm/ui/conversation/k:a	(Lcom/tencent/mm/storage/az;Landroid/database/Cursor;)Lcom/tencent/mm/storage/az;
    //   94: putfield 139	com/tencent/mm/ui/conversation/m$a:conversation	Lcom/tencent/mm/storage/az;
    //   97: aload_3
    //   98: iconst_1
    //   99: putfield 155	com/tencent/mm/ui/conversation/m$a:viewType	I
    //   102: ldc 117
    //   104: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_3
    //   108: areturn
    //   109: astore_1
    //   110: aload_3
    //   111: aconst_null
    //   112: putfield 143	com/tencent/mm/ui/conversation/m$a:XDp	Lcom/tencent/mm/ao/a/a;
    //   115: goto -30 -> 85
    //   118: astore_1
    //   119: aload_3
    //   120: aconst_null
    //   121: putfield 139	com/tencent/mm/ui/conversation/m$a:conversation	Lcom/tencent/mm/storage/az;
    //   124: goto -22 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	m
    //   0	127	1	parama	a
    //   0	127	2	paramCursor	Cursor
    //   6	114	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   35	73	109	java/lang/Throwable
    //   80	85	109	java/lang/Throwable
    //   85	102	118	java/lang/Throwable
  }
  
  public final void Fx(boolean paramBoolean)
  {
    AppMethodBeat.i(288435);
    super.Fx(false);
    AppMethodBeat.o(288435);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(288436);
    this.XDk.atr();
    this.XDl.atr();
    this.XDj = new n(n.e.XDK, new n.a[] { new n.a()new n.a
    {
      protected final n.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(290147);
        n.d locald = new n.d();
        String str = paramAnonymousCursor.getString(b(paramAnonymousCursor, "username"));
        locald.XDH = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "conversationTime"));
        if (locald.XDH == 0L) {
          locald.XDH = (paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0xFFFFFFFF);
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwF(str)) {}
        for (locald.XDI = 1;; locald.XDI = 0)
        {
          AppMethodBeat.o(290147);
          return locald;
        }
      }
      
      public final Cursor hWz()
      {
        AppMethodBeat.i(290146);
        Cursor localCursor = m.b(m.this).hK();
        AppMethodBeat.o(290146);
        return localCursor;
      }
    }, new n.a()
    {
      protected final n.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(270794);
        n.d locald = new n.d();
        locald.XDH = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "lastMsgTime"));
        if ((paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0x0) != 0L) {}
        for (locald.XDI = 1;; locald.XDI = 0)
        {
          AppMethodBeat.o(270794);
          return locald;
        }
      }
      
      public final Cursor hWz()
      {
        AppMethodBeat.i(270793);
        Cursor localCursor = m.this.XDl.hK();
        AppMethodBeat.o(270793);
        return localCursor;
      }
    } });
    v(this.XDj);
    AppMethodBeat.o(288436);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(288437);
    if (this.XDi)
    {
      this.XDj = n.hWA();
      v(this.XDj);
      AppMethodBeat.o(288437);
      return;
    }
    this.XDi = true;
    atr();
    this.XDi = false;
    AppMethodBeat.o(288437);
  }
  
  public final a awY(int paramInt)
  {
    AppMethodBeat.i(288439);
    a locala2 = (a)super.getItem(paramInt);
    Object localObject1 = locala2;
    if (locala2 == null) {
      localObject1 = locala2;
    }
    try
    {
      j = this.XDk.getCount();
      localObject1 = locala2;
      i = this.XDl.getCount();
      localObject1 = locala2;
      Log.w("MergeBizChatConversationAdapter", "getItem NULL, position=%d, size=%d, cursor.size=[%d, %d], window=[%d, %d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.XDj.XDt), Integer.valueOf(this.XDj.XDt + this.XDj.XDu.size()) });
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
      locala1.viewType = 1;
      locala1.XDo = Math.max(0, paramInt);
      locala1.conversation = ((az)this.XDk.getItem(locala1.XDo));
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
      locala1.viewType = 0;
      locala1.XDo = Math.max(0, paramInt);
      locala1.XDp = ((a)this.XDl.getItem(locala1.XDo));
      localObject1 = locala1;
    }
    catch (Throwable localThrowable2)
    {
      Object localObject3 = localThrowable3;
      break label281;
    }
    AppMethodBeat.o(288439);
    return localObject1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(288442);
    if (this.XDj != null)
    {
      i = this.XDj.getCount();
      AppMethodBeat.o(288442);
      return i;
    }
    int i = super.getCount();
    AppMethodBeat.o(288442);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(288441);
    a locala = awY(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(288441);
      return 0;
    }
    paramInt = locala.viewType;
    AppMethodBeat.o(288441);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(288440);
    a locala = awY(paramInt);
    int i = locala.viewType;
    paramInt = 1;
    for (;;)
    {
      if (i == 1) {}
      try
      {
        localView = this.XDk.getView(locala.XDo, paramView, paramViewGroup);
        AppMethodBeat.o(288440);
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
        AppMethodBeat.o(288440);
        return null;
      }
      localView = paramView;
      if (i == 0)
      {
        localView = this.XDl.getView(locala.XDo, paramView, paramViewGroup);
        AppMethodBeat.o(288440);
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
    int XDo = 0;
    public a XDp;
    public az conversation;
    int viewType = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m
 * JD-Core Version:    0.7.0.1
 */
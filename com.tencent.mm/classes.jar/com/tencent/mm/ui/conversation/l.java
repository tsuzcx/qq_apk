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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

public final class l
  extends r<a>
{
  private boolean KSW;
  private m KSX;
  final j KSY;
  public final com.tencent.mm.ui.bizchat.b KSZ;
  private final DataSetObserver KTa;
  
  public l(Context paramContext, String paramString, r.a parama)
  {
    super(paramContext, new a());
    AppMethodBeat.i(188112);
    this.KSW = false;
    this.KTa = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(188106);
        if (l.a(l.this) != null) {
          l.a(l.this).fNH();
        }
        l.this.notifyDataSetChanged();
        AppMethodBeat.o(188106);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(188107);
        if (l.a(l.this) != null) {
          l.a(l.this).fNH();
        }
        l.this.notifyDataSetInvalidated();
        AppMethodBeat.o(188107);
      }
    };
    super.xs(false);
    this.KSY = new j(paramContext, paramString, parama);
    this.KSY.registerDataSetObserver(this.KTa);
    ag.aGp();
    String str = f.Ej(paramString);
    if (bu.isNullOrNil(str)) {}
    for (;;)
    {
      this.KSZ = new com.tencent.mm.ui.bizchat.b(paramContext, parama, paramString);
      this.KSZ.registerDataSetObserver(this.KTa);
      paramContext = this.KSZ;
      ag.aGs().add(paramContext);
      ag.aGs().a(paramContext, paramContext.JPk.getMainLooper());
      AppMethodBeat.o(188112);
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
    //   21: getfield 119	com/tencent/mm/ui/conversation/l:KSX	Lcom/tencent/mm/ui/conversation/m;
    //   24: invokevirtual 125	com/tencent/mm/ui/conversation/m:fNI	()Landroid/database/Cursor;
    //   27: invokeinterface 131 1 0
    //   32: putfield 135	com/tencent/mm/ui/conversation/l$a:KTc	I
    //   35: aload_3
    //   36: aconst_null
    //   37: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/au;
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 85	com/tencent/mm/ui/conversation/l:KSZ	Lcom/tencent/mm/ui/bizchat/b;
    //   45: aload_3
    //   46: getfield 143	com/tencent/mm/ui/conversation/l$a:KTd	Lcom/tencent/mm/al/a/a;
    //   49: aload_2
    //   50: invokevirtual 146	com/tencent/mm/ui/bizchat/b:a	(Lcom/tencent/mm/al/a/a;Landroid/database/Cursor;)Lcom/tencent/mm/al/a/a;
    //   53: putfield 143	com/tencent/mm/ui/conversation/l$a:KTd	Lcom/tencent/mm/al/a/a;
    //   56: aload_3
    //   57: getfield 143	com/tencent/mm/ui/conversation/l$a:KTd	Lcom/tencent/mm/al/a/a;
    //   60: getfield 152	com/tencent/mm/al/a/a:field_bizChatId	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifle +15 -> 80
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 155	com/tencent/mm/ui/conversation/l$a:oOD	I
    //   73: ldc 117
    //   75: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_3
    //   79: areturn
    //   80: aload_3
    //   81: aconst_null
    //   82: putfield 143	com/tencent/mm/ui/conversation/l$a:KTd	Lcom/tencent/mm/al/a/a;
    //   85: aload_3
    //   86: aload_3
    //   87: getfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/au;
    //   90: aload_2
    //   91: invokestatic 158	com/tencent/mm/ui/conversation/j:a	(Lcom/tencent/mm/storage/au;Landroid/database/Cursor;)Lcom/tencent/mm/storage/au;
    //   94: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/au;
    //   97: aload_3
    //   98: iconst_1
    //   99: putfield 155	com/tencent/mm/ui/conversation/l$a:oOD	I
    //   102: ldc 117
    //   104: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_3
    //   108: areturn
    //   109: astore_1
    //   110: aload_3
    //   111: aconst_null
    //   112: putfield 143	com/tencent/mm/ui/conversation/l$a:KTd	Lcom/tencent/mm/al/a/a;
    //   115: goto -30 -> 85
    //   118: astore_1
    //   119: aload_3
    //   120: aconst_null
    //   121: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/au;
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
  
  public final void ZD()
  {
    AppMethodBeat.i(188114);
    this.KSY.ZD();
    this.KSZ.ZD();
    this.KSX = new m(m.e.KTy, new m.a[] { new m.a()new m.a
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(188109);
        m.d locald = new m.d();
        String str = paramAnonymousCursor.getString(b(paramAnonymousCursor, "username"));
        locald.KTv = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "conversationTime"));
        if (locald.KTv == 0L) {
          locald.KTv = (paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0xFFFFFFFF);
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVi(str)) {}
        for (locald.KTw = 1;; locald.KTw = 0)
        {
          AppMethodBeat.o(188109);
          return locald;
        }
      }
      
      public final Cursor fNF()
      {
        AppMethodBeat.i(188108);
        Cursor localCursor = l.b(l.this).getCursor();
        AppMethodBeat.o(188108);
        return localCursor;
      }
    }, new m.a()
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(188111);
        m.d locald = new m.d();
        locald.KTv = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "lastMsgTime"));
        if ((paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0x0) != 0L) {}
        for (locald.KTw = 1;; locald.KTw = 0)
        {
          AppMethodBeat.o(188111);
          return locald;
        }
      }
      
      public final Cursor fNF()
      {
        AppMethodBeat.i(188110);
        Cursor localCursor = l.this.KSZ.getCursor();
        AppMethodBeat.o(188110);
        return localCursor;
      }
    } });
    setCursor(this.KSX);
    AppMethodBeat.o(188114);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(188115);
    if (this.KSW)
    {
      this.KSX = m.fNG();
      setCursor(this.KSX);
      AppMethodBeat.o(188115);
      return;
    }
    this.KSW = true;
    ZD();
    this.KSW = false;
    AppMethodBeat.o(188115);
  }
  
  public final a afj(int paramInt)
  {
    AppMethodBeat.i(188117);
    a locala2 = (a)super.getItem(paramInt);
    Object localObject1 = locala2;
    if (locala2 == null) {
      localObject1 = locala2;
    }
    try
    {
      j = this.KSY.getCount();
      localObject1 = locala2;
      i = this.KSZ.getCount();
      localObject1 = locala2;
      ae.w("MergeBizChatConversationAdapter", "getItem NULL, position=%d, size=%d, cursor.size=[%d, %d], window=[%d, %d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.KSX.KTh), Integer.valueOf(this.KSX.KTh + this.KSX.KTi.size()) });
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
      locala1.oOD = 1;
      locala1.KTc = Math.max(0, paramInt);
      locala1.conversation = ((au)this.KSY.getItem(locala1.KTc));
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
      locala1.oOD = 0;
      locala1.KTc = Math.max(0, paramInt);
      locala1.KTd = ((a)this.KSZ.getItem(locala1.KTc));
      localObject1 = locala1;
    }
    catch (Throwable localThrowable2)
    {
      Object localObject3 = localThrowable3;
      break label281;
    }
    AppMethodBeat.o(188117);
    return localObject1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(188120);
    if (this.KSX != null)
    {
      i = this.KSX.getCount();
      AppMethodBeat.o(188120);
      return i;
    }
    int i = super.getCount();
    AppMethodBeat.o(188120);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(188119);
    a locala = afj(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(188119);
      return 0;
    }
    paramInt = locala.oOD;
    AppMethodBeat.o(188119);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(188118);
    a locala = afj(paramInt);
    int i = locala.oOD;
    paramInt = 1;
    for (;;)
    {
      if (i == 1) {}
      try
      {
        localView = this.KSY.getView(locala.KTc, paramView, paramViewGroup);
        AppMethodBeat.o(188118);
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
        AppMethodBeat.o(188118);
        return null;
      }
      localView = paramView;
      if (i == 0)
      {
        localView = this.KSZ.getView(locala.KTc, paramView, paramViewGroup);
        AppMethodBeat.o(188118);
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
  
  public final void xs(boolean paramBoolean)
  {
    AppMethodBeat.i(188113);
    super.xs(false);
    AppMethodBeat.o(188113);
  }
  
  public static final class a
  {
    int KTc = 0;
    public a KTd;
    public au conversation;
    int oOD = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l
 * JD-Core Version:    0.7.0.1
 */
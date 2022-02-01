package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

public final class l
  extends r<a>
{
  private final DataSetObserver IFA;
  private boolean IFw;
  private m IFx;
  final j IFy;
  public final com.tencent.mm.ui.bizchat.b IFz;
  
  public l(Context paramContext, String paramString, r.a parama)
  {
    super(paramContext, new a());
    AppMethodBeat.i(196861);
    this.IFw = false;
    this.IFA = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(196855);
        if (l.a(l.this) != null) {
          l.a(l.this).fsC();
        }
        l.this.notifyDataSetChanged();
        AppMethodBeat.o(196855);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(196856);
        if (l.a(l.this) != null) {
          l.a(l.this).fsC();
        }
        l.this.notifyDataSetInvalidated();
        AppMethodBeat.o(196856);
      }
    };
    super.wy(false);
    this.IFy = new j(paramContext, paramString, parama);
    this.IFy.registerDataSetObserver(this.IFA);
    af.aCW();
    String str = e.AI(paramString);
    if (bs.isNullOrNil(str)) {}
    for (;;)
    {
      this.IFz = new com.tencent.mm.ui.bizchat.b(paramContext, parama, paramString);
      this.IFz.registerDataSetObserver(this.IFA);
      paramContext = this.IFz;
      af.aCZ().add(paramContext);
      af.aCZ().a(paramContext, paramContext.HGE.getMainLooper());
      AppMethodBeat.o(196861);
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
    //   21: getfield 119	com/tencent/mm/ui/conversation/l:IFx	Lcom/tencent/mm/ui/conversation/m;
    //   24: invokevirtual 125	com/tencent/mm/ui/conversation/m:fsD	()Landroid/database/Cursor;
    //   27: invokeinterface 131 1 0
    //   32: putfield 135	com/tencent/mm/ui/conversation/l$a:IFC	I
    //   35: aload_3
    //   36: aconst_null
    //   37: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/ap;
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 85	com/tencent/mm/ui/conversation/l:IFz	Lcom/tencent/mm/ui/bizchat/b;
    //   45: aload_3
    //   46: getfield 143	com/tencent/mm/ui/conversation/l$a:IFD	Lcom/tencent/mm/al/a/a;
    //   49: aload_2
    //   50: invokevirtual 146	com/tencent/mm/ui/bizchat/b:a	(Lcom/tencent/mm/al/a/a;Landroid/database/Cursor;)Lcom/tencent/mm/al/a/a;
    //   53: putfield 143	com/tencent/mm/ui/conversation/l$a:IFD	Lcom/tencent/mm/al/a/a;
    //   56: aload_3
    //   57: getfield 143	com/tencent/mm/ui/conversation/l$a:IFD	Lcom/tencent/mm/al/a/a;
    //   60: getfield 152	com/tencent/mm/al/a/a:field_bizChatId	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifle +15 -> 80
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 155	com/tencent/mm/ui/conversation/l$a:oeH	I
    //   73: ldc 117
    //   75: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_3
    //   79: areturn
    //   80: aload_3
    //   81: aconst_null
    //   82: putfield 143	com/tencent/mm/ui/conversation/l$a:IFD	Lcom/tencent/mm/al/a/a;
    //   85: aload_3
    //   86: aload_3
    //   87: getfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/ap;
    //   90: aload_2
    //   91: invokestatic 158	com/tencent/mm/ui/conversation/j:a	(Lcom/tencent/mm/storage/ap;Landroid/database/Cursor;)Lcom/tencent/mm/storage/ap;
    //   94: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/ap;
    //   97: aload_3
    //   98: iconst_1
    //   99: putfield 155	com/tencent/mm/ui/conversation/l$a:oeH	I
    //   102: ldc 117
    //   104: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_3
    //   108: areturn
    //   109: astore_1
    //   110: aload_3
    //   111: aconst_null
    //   112: putfield 143	com/tencent/mm/ui/conversation/l$a:IFD	Lcom/tencent/mm/al/a/a;
    //   115: goto -30 -> 85
    //   118: astore_1
    //   119: aload_3
    //   120: aconst_null
    //   121: putfield 139	com/tencent/mm/ui/conversation/l$a:conversation	Lcom/tencent/mm/storage/ap;
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
  
  public final void Xb()
  {
    AppMethodBeat.i(196863);
    this.IFy.Xb();
    this.IFz.Xb();
    this.IFx = new m(m.e.IFY, new m.a[] { new m.a()new m.a
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(196858);
        m.d locald = new m.d();
        String str = paramAnonymousCursor.getString(b(paramAnonymousCursor, "username"));
        locald.IFV = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "conversationTime"));
        if (locald.IFV == 0L) {
          locald.IFV = (paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0xFFFFFFFF);
        }
        if (((k)g.ab(k.class)).awG().aNQ(str)) {}
        for (locald.IFW = 1;; locald.IFW = 0)
        {
          AppMethodBeat.o(196858);
          return locald;
        }
      }
      
      public final Cursor fsA()
      {
        AppMethodBeat.i(196857);
        Cursor localCursor = l.b(l.this).getCursor();
        AppMethodBeat.o(196857);
        return localCursor;
      }
    }, new m.a()
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(196860);
        m.d locald = new m.d();
        locald.IFV = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "lastMsgTime"));
        if ((paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0x0) != 0L) {}
        for (locald.IFW = 1;; locald.IFW = 0)
        {
          AppMethodBeat.o(196860);
          return locald;
        }
      }
      
      public final Cursor fsA()
      {
        AppMethodBeat.i(196859);
        Cursor localCursor = l.this.IFz.getCursor();
        AppMethodBeat.o(196859);
        return localCursor;
      }
    } });
    setCursor(this.IFx);
    AppMethodBeat.o(196863);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(196864);
    if (this.IFw)
    {
      this.IFx = m.fsB();
      setCursor(this.IFx);
      AppMethodBeat.o(196864);
      return;
    }
    this.IFw = true;
    Xb();
    this.IFw = false;
    AppMethodBeat.o(196864);
  }
  
  public final a acc(int paramInt)
  {
    AppMethodBeat.i(196866);
    a locala2 = (a)super.getItem(paramInt);
    Object localObject1 = locala2;
    if (locala2 == null) {
      localObject1 = locala2;
    }
    try
    {
      j = this.IFy.getCount();
      localObject1 = locala2;
      i = this.IFz.getCount();
      localObject1 = locala2;
      ac.w("MergeBizChatConversationAdapter", "getItem NULL, position=%d, size=%d, cursor.size=[%d, %d], window=[%d, %d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.IFx.IFH), Integer.valueOf(this.IFx.IFH + this.IFx.IFI.size()) });
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
      locala1.oeH = 1;
      locala1.IFC = Math.max(0, paramInt);
      locala1.conversation = ((ap)this.IFy.getItem(locala1.IFC));
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
      locala1.oeH = 0;
      locala1.IFC = Math.max(0, paramInt);
      locala1.IFD = ((a)this.IFz.getItem(locala1.IFC));
      localObject1 = locala1;
    }
    catch (Throwable localThrowable2)
    {
      Object localObject3 = localThrowable3;
      break label281;
    }
    AppMethodBeat.o(196866);
    return localObject1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(196869);
    if (this.IFx != null)
    {
      i = this.IFx.getCount();
      AppMethodBeat.o(196869);
      return i;
    }
    int i = super.getCount();
    AppMethodBeat.o(196869);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(196868);
    a locala = acc(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(196868);
      return 0;
    }
    paramInt = locala.oeH;
    AppMethodBeat.o(196868);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(196867);
    a locala = acc(paramInt);
    int i = locala.oeH;
    paramInt = 1;
    for (;;)
    {
      if (i == 1) {}
      try
      {
        localView = this.IFy.getView(locala.IFC, paramView, paramViewGroup);
        AppMethodBeat.o(196867);
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
        AppMethodBeat.o(196867);
        return null;
      }
      localView = paramView;
      if (i == 0)
      {
        localView = this.IFz.getView(locala.IFC, paramView, paramViewGroup);
        AppMethodBeat.o(196867);
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
  
  public final void wy(boolean paramBoolean)
  {
    AppMethodBeat.i(196862);
    super.wy(false);
    AppMethodBeat.o(196862);
  }
  
  public static final class a
  {
    int IFC = 0;
    public a IFD;
    public ap conversation;
    int oeH = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l
 * JD-Core Version:    0.7.0.1
 */
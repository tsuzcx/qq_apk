package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.a;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;

public final class o
  extends x<a>
{
  private boolean afqL;
  private p afqM;
  final l afqN;
  public final com.tencent.mm.ui.bizchat.b afqO;
  private final DataSetObserver afqP;
  
  public o(Context paramContext, String paramString, x.a parama)
  {
    super(paramContext, new a());
    AppMethodBeat.i(256871);
    this.afqL = false;
    this.afqP = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(256650);
        if (o.a(o.this) != null) {
          o.a(o.this).jAP();
        }
        o.this.notifyDataSetChanged();
        AppMethodBeat.o(256650);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(256652);
        if (o.a(o.this) != null) {
          o.a(o.this).jAP();
        }
        o.this.notifyDataSetInvalidated();
        AppMethodBeat.o(256652);
      }
    };
    super.Lh(false);
    this.afqN = new l(paramContext, paramString, parama);
    this.afqN.registerDataSetObserver(this.afqP);
    af.bHf();
    String str = f.Ms(paramString);
    if (Util.isNullOrNil(str)) {}
    for (;;)
    {
      this.afqO = new com.tencent.mm.ui.bizchat.b(paramContext, parama, paramString);
      this.afqO.registerDataSetObserver(this.afqP);
      paramContext = this.afqO;
      af.bHi().add(paramContext);
      af.bHi().a(paramContext, paramContext.FYB.getMainLooper());
      AppMethodBeat.o(256871);
      return;
      paramString = str;
    }
  }
  
  /* Error */
  private a a(a parama, Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc 115
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: astore_3
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: new 13	com/tencent/mm/ui/conversation/o$a
    //   14: dup
    //   15: invokespecial 29	com/tencent/mm/ui/conversation/o$a:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_0
    //   21: getfield 117	com/tencent/mm/ui/conversation/o:afqM	Lcom/tencent/mm/ui/conversation/p;
    //   24: invokevirtual 123	com/tencent/mm/ui/conversation/p:jAQ	()Landroid/database/Cursor;
    //   27: invokeinterface 129 1 0
    //   32: putfield 133	com/tencent/mm/ui/conversation/o$a:afqR	I
    //   35: aload_3
    //   36: aconst_null
    //   37: putfield 137	com/tencent/mm/ui/conversation/o$a:conversation	Lcom/tencent/mm/storage/bb;
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 85	com/tencent/mm/ui/conversation/o:afqO	Lcom/tencent/mm/ui/bizchat/b;
    //   45: aload_3
    //   46: getfield 141	com/tencent/mm/ui/conversation/o$a:afqS	Lcom/tencent/mm/an/a/a;
    //   49: aload_2
    //   50: invokevirtual 144	com/tencent/mm/ui/bizchat/b:a	(Lcom/tencent/mm/an/a/a;Landroid/database/Cursor;)Lcom/tencent/mm/an/a/a;
    //   53: putfield 141	com/tencent/mm/ui/conversation/o$a:afqS	Lcom/tencent/mm/an/a/a;
    //   56: aload_3
    //   57: getfield 141	com/tencent/mm/ui/conversation/o$a:afqS	Lcom/tencent/mm/an/a/a;
    //   60: getfield 150	com/tencent/mm/an/a/a:field_bizChatId	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifle +15 -> 80
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 153	com/tencent/mm/ui/conversation/o$a:viewType	I
    //   73: ldc 115
    //   75: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_3
    //   79: areturn
    //   80: aload_3
    //   81: aconst_null
    //   82: putfield 141	com/tencent/mm/ui/conversation/o$a:afqS	Lcom/tencent/mm/an/a/a;
    //   85: aload_3
    //   86: aload_3
    //   87: getfield 137	com/tencent/mm/ui/conversation/o$a:conversation	Lcom/tencent/mm/storage/bb;
    //   90: aload_2
    //   91: invokestatic 156	com/tencent/mm/ui/conversation/l:a	(Lcom/tencent/mm/storage/bb;Landroid/database/Cursor;)Lcom/tencent/mm/storage/bb;
    //   94: putfield 137	com/tencent/mm/ui/conversation/o$a:conversation	Lcom/tencent/mm/storage/bb;
    //   97: aload_3
    //   98: iconst_1
    //   99: putfield 153	com/tencent/mm/ui/conversation/o$a:viewType	I
    //   102: ldc 115
    //   104: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_3
    //   108: areturn
    //   109: astore_1
    //   110: aload_3
    //   111: aconst_null
    //   112: putfield 141	com/tencent/mm/ui/conversation/o$a:afqS	Lcom/tencent/mm/an/a/a;
    //   115: goto -30 -> 85
    //   118: astore_1
    //   119: aload_3
    //   120: aconst_null
    //   121: putfield 137	com/tencent/mm/ui/conversation/o$a:conversation	Lcom/tencent/mm/storage/bb;
    //   124: goto -22 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	o
    //   0	127	1	parama	a
    //   0	127	2	paramCursor	Cursor
    //   6	114	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   35	73	109	finally
    //   80	85	109	finally
    //   85	102	118	finally
  }
  
  public final void Lh(boolean paramBoolean)
  {
    AppMethodBeat.i(256894);
    super.Lh(false);
    AppMethodBeat.o(256894);
  }
  
  /* Error */
  public final a aDG(int paramInt)
  {
    // Byte code:
    //   0: ldc 167
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iload_1
    //   7: invokespecial 171	com/tencent/mm/ui/x:getItem	(I)Ljava/lang/Object;
    //   10: checkcast 13	com/tencent/mm/ui/conversation/o$a
    //   13: astore 6
    //   15: aload 6
    //   17: astore 4
    //   19: aload 6
    //   21: ifnonnull +260 -> 281
    //   24: aload 6
    //   26: astore 4
    //   28: aload_0
    //   29: getfield 56	com/tencent/mm/ui/conversation/o:afqN	Lcom/tencent/mm/ui/conversation/l;
    //   32: invokevirtual 174	com/tencent/mm/ui/conversation/l:getCount	()I
    //   35: istore_3
    //   36: aload 6
    //   38: astore 4
    //   40: aload_0
    //   41: getfield 85	com/tencent/mm/ui/conversation/o:afqO	Lcom/tencent/mm/ui/bizchat/b;
    //   44: invokevirtual 175	com/tencent/mm/ui/bizchat/b:getCount	()I
    //   47: istore_2
    //   48: aload 6
    //   50: astore 4
    //   52: ldc 177
    //   54: ldc 179
    //   56: bipush 6
    //   58: anewarray 181	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: iload_1
    //   64: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_0
    //   71: invokevirtual 188	com/tencent/mm/ui/conversation/o:getCount	()I
    //   74: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_2
    //   80: iload_3
    //   81: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: dup
    //   86: iconst_3
    //   87: iload_2
    //   88: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: aastore
    //   92: dup
    //   93: iconst_4
    //   94: aload_0
    //   95: getfield 117	com/tencent/mm/ui/conversation/o:afqM	Lcom/tencent/mm/ui/conversation/p;
    //   98: getfield 191	com/tencent/mm/ui/conversation/p:afqW	I
    //   101: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: dup
    //   106: iconst_5
    //   107: aload_0
    //   108: getfield 117	com/tencent/mm/ui/conversation/o:afqM	Lcom/tencent/mm/ui/conversation/p;
    //   111: getfield 191	com/tencent/mm/ui/conversation/p:afqW	I
    //   114: aload_0
    //   115: getfield 117	com/tencent/mm/ui/conversation/o:afqM	Lcom/tencent/mm/ui/conversation/p;
    //   118: getfield 195	com/tencent/mm/ui/conversation/p:afqX	Ljava/util/LinkedList;
    //   121: invokevirtual 200	java/util/LinkedList:size	()I
    //   124: iadd
    //   125: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload 6
    //   134: astore 5
    //   136: iload_3
    //   137: ifle +61 -> 198
    //   140: aload 6
    //   142: astore 5
    //   144: iload_1
    //   145: iload_3
    //   146: if_icmpge +52 -> 198
    //   149: aload 6
    //   151: astore 4
    //   153: new 13	com/tencent/mm/ui/conversation/o$a
    //   156: dup
    //   157: invokespecial 29	com/tencent/mm/ui/conversation/o$a:<init>	()V
    //   160: astore 5
    //   162: aload 5
    //   164: iconst_1
    //   165: putfield 153	com/tencent/mm/ui/conversation/o$a:viewType	I
    //   168: aload 5
    //   170: iconst_0
    //   171: iload_1
    //   172: invokestatic 212	java/lang/Math:max	(II)I
    //   175: putfield 133	com/tencent/mm/ui/conversation/o$a:afqR	I
    //   178: aload 5
    //   180: aload_0
    //   181: getfield 56	com/tencent/mm/ui/conversation/o:afqN	Lcom/tencent/mm/ui/conversation/l;
    //   184: aload 5
    //   186: getfield 133	com/tencent/mm/ui/conversation/o$a:afqR	I
    //   189: invokevirtual 213	com/tencent/mm/ui/conversation/l:getItem	(I)Ljava/lang/Object;
    //   192: checkcast 215	com/tencent/mm/storage/bb
    //   195: putfield 137	com/tencent/mm/ui/conversation/o$a:conversation	Lcom/tencent/mm/storage/bb;
    //   198: iload_1
    //   199: iload_3
    //   200: isub
    //   201: istore_1
    //   202: aload 5
    //   204: astore 4
    //   206: aload 5
    //   208: ifnonnull +73 -> 281
    //   211: aload 5
    //   213: astore 4
    //   215: iload_2
    //   216: ifle +65 -> 281
    //   219: aload 5
    //   221: astore 4
    //   223: iload_1
    //   224: iload_2
    //   225: if_icmpge +56 -> 281
    //   228: aload 5
    //   230: astore 4
    //   232: new 13	com/tencent/mm/ui/conversation/o$a
    //   235: dup
    //   236: invokespecial 29	com/tencent/mm/ui/conversation/o$a:<init>	()V
    //   239: astore 5
    //   241: aload 5
    //   243: iconst_0
    //   244: putfield 153	com/tencent/mm/ui/conversation/o$a:viewType	I
    //   247: aload 5
    //   249: iconst_0
    //   250: iload_1
    //   251: invokestatic 212	java/lang/Math:max	(II)I
    //   254: putfield 133	com/tencent/mm/ui/conversation/o$a:afqR	I
    //   257: aload 5
    //   259: aload_0
    //   260: getfield 85	com/tencent/mm/ui/conversation/o:afqO	Lcom/tencent/mm/ui/bizchat/b;
    //   263: aload 5
    //   265: getfield 133	com/tencent/mm/ui/conversation/o$a:afqR	I
    //   268: invokevirtual 216	com/tencent/mm/ui/bizchat/b:getItem	(I)Ljava/lang/Object;
    //   271: checkcast 146	com/tencent/mm/an/a/a
    //   274: putfield 141	com/tencent/mm/ui/conversation/o$a:afqS	Lcom/tencent/mm/an/a/a;
    //   277: aload 5
    //   279: astore 4
    //   281: ldc 167
    //   283: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: aload 4
    //   288: areturn
    //   289: astore 5
    //   291: goto -10 -> 281
    //   294: astore 4
    //   296: aload 5
    //   298: astore 4
    //   300: goto -19 -> 281
    //   303: astore 4
    //   305: aload 5
    //   307: astore 4
    //   309: goto -28 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	o
    //   0	312	1	paramInt	int
    //   47	179	2	i	int
    //   35	166	3	j	int
    //   17	270	4	localObject1	Object
    //   294	1	4	localObject2	Object
    //   298	1	4	localObject3	Object
    //   303	1	4	localObject4	Object
    //   307	1	4	localObject5	Object
    //   134	144	5	locala1	a
    //   289	17	5	localObject6	Object
    //   13	137	6	locala2	a
    // Exception table:
    //   from	to	target	type
    //   28	36	289	finally
    //   40	48	289	finally
    //   52	132	289	finally
    //   153	162	289	finally
    //   232	241	289	finally
    //   162	198	294	finally
    //   241	277	303	finally
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(256902);
    this.afqN.aNy();
    this.afqO.aNy();
    this.afqM = new p(p.e.afrn, new p.a[] { new p.a()new p.a
    {
      protected final p.d d(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(256656);
        p.d locald = new p.d();
        String str = paramAnonymousCursor.getString(b(paramAnonymousCursor, "username"));
        locald.afrk = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "conversationTime"));
        if (locald.afrk == 0L) {
          locald.afrk = (paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0xFFFFFFFF);
        }
        if (((n)h.ax(n.class)).bzG().bxV(str)) {}
        for (locald.afrl = 1;; locald.afrl = 0)
        {
          AppMethodBeat.o(256656);
          return locald;
        }
      }
      
      public final Cursor jAN()
      {
        AppMethodBeat.i(256653);
        Cursor localCursor = o.b(o.this).Fv();
        AppMethodBeat.o(256653);
        return localCursor;
      }
    }, new p.a()
    {
      protected final p.d d(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(256662);
        p.d locald = new p.d();
        locald.afrk = paramAnonymousCursor.getLong(b(paramAnonymousCursor, "lastMsgTime"));
        if ((paramAnonymousCursor.getLong(b(paramAnonymousCursor, "flag")) & 0x0) != 0L) {}
        for (locald.afrl = 1;; locald.afrl = 0)
        {
          AppMethodBeat.o(256662);
          return locald;
        }
      }
      
      public final Cursor jAN()
      {
        AppMethodBeat.i(256658);
        Cursor localCursor = o.this.afqO.Fv();
        AppMethodBeat.o(256658);
        return localCursor;
      }
    } });
    w(this.afqM);
    AppMethodBeat.o(256902);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(256905);
    if (this.afqL)
    {
      this.afqM = p.jAO();
      w(this.afqM);
      AppMethodBeat.o(256905);
      return;
    }
    this.afqL = true;
    aNy();
    this.afqL = false;
    AppMethodBeat.o(256905);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(256935);
    if (this.afqM != null)
    {
      i = this.afqM.getCount();
      AppMethodBeat.o(256935);
      return i;
    }
    int i = super.getCount();
    AppMethodBeat.o(256935);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(256924);
    a locala = aDG(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(256924);
      return 0;
    }
    paramInt = locala.viewType;
    AppMethodBeat.o(256924);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(256921);
    a locala = aDG(paramInt);
    int i = locala.viewType;
    paramInt = 1;
    for (;;)
    {
      if (i == 1) {}
      try
      {
        localView = this.afqN.getView(locala.afqR, paramView, paramViewGroup);
        AppMethodBeat.o(256921);
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
        AppMethodBeat.o(256921);
        return null;
      }
      localView = paramView;
      if (i == 0)
      {
        localView = this.afqO.getView(locala.afqR, paramView, paramViewGroup);
        AppMethodBeat.o(256921);
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
    int afqR = 0;
    public a afqS;
    public bb conversation;
    int viewType = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.o
 * JD-Core Version:    0.7.0.1
 */
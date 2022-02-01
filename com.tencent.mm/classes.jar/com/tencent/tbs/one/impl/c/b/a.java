package com.tencent.tbs.one.impl.c.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.LayoutInflater.Filter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.f;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public final class a
  extends LayoutInflater
{
  private static final StackTraceElement[] b = new StackTraceElement[0];
  private static final Class<?>[] d = { Context.class, AttributeSet.class };
  public ClassLoader a;
  private final Object[] c;
  private final HashMap<String, Constructor<? extends View>> e;
  private HashMap<String, Boolean> f;
  
  protected a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(173848);
    this.c = new Object[2];
    this.e = new HashMap();
    a();
    AppMethodBeat.o(173848);
  }
  
  private a(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    super(paramLayoutInflater, paramContext);
    AppMethodBeat.i(173849);
    this.c = new Object[2];
    this.e = new HashMap();
    a();
    AppMethodBeat.o(173849);
  }
  
  private Class<? extends View> a(String paramString)
  {
    AppMethodBeat.i(173853);
    if (this.a != null) {
      try
      {
        Class localClass = this.a.loadClass(paramString).asSubclass(View.class);
        AppMethodBeat.o(173853);
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
    }
    paramString = getClass().getClassLoader().loadClass(paramString).asSubclass(View.class);
    AppMethodBeat.o(173853);
    return paramString;
  }
  
  private void a()
  {
    AppMethodBeat.i(173850);
    if (Build.VERSION.SDK_INT >= 11) {
      try
      {
        setFactory2(new LayoutInflater.Factory2()
        {
          public final View onCreateView(View paramAnonymousView, String paramAnonymousString, Context paramAnonymousContext, AttributeSet paramAnonymousAttributeSet)
          {
            AppMethodBeat.i(173869);
            paramAnonymousView = a.this.a(paramAnonymousString, paramAnonymousAttributeSet);
            AppMethodBeat.o(173869);
            return paramAnonymousView;
          }
          
          public final View onCreateView(String paramAnonymousString, Context paramAnonymousContext, AttributeSet paramAnonymousAttributeSet)
          {
            return null;
          }
        });
        AppMethodBeat.o(173850);
        return;
      }
      catch (Exception localException) {}
    }
    setFactory(new LayoutInflater.Factory()
    {
      public final View onCreateView(String paramAnonymousString, Context paramAnonymousContext, AttributeSet paramAnonymousAttributeSet)
      {
        AppMethodBeat.i(173870);
        paramAnonymousString = a.this.a(paramAnonymousString, paramAnonymousAttributeSet);
        AppMethodBeat.o(173870);
        return paramAnonymousString;
      }
    });
    AppMethodBeat.o(173850);
  }
  
  /* Error */
  private View b(String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: ldc 121
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 52	com/tencent/tbs/one/impl/c/b/a:c	[Ljava/lang/Object;
    //   9: astore 7
    //   11: aload 7
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 52	com/tencent/tbs/one/impl/c/b/a:c	[Ljava/lang/Object;
    //   18: iconst_0
    //   19: aload_0
    //   20: invokevirtual 125	com/tencent/tbs/one/impl/c/b/a:getContext	()Landroid/content/Context;
    //   23: aastore
    //   24: aload_0
    //   25: getfield 58	com/tencent/tbs/one/impl/c/b/a:e	Ljava/util/HashMap;
    //   28: aload_1
    //   29: invokevirtual 129	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 131	java/lang/reflect/Constructor
    //   35: astore 4
    //   37: aconst_null
    //   38: astore 6
    //   40: aload_0
    //   41: invokevirtual 135	com/tencent/tbs/one/impl/c/b/a:getFilter	()Landroid/view/LayoutInflater$Filter;
    //   44: astore 8
    //   46: aload 4
    //   48: ifnonnull +123 -> 171
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 137	com/tencent/tbs/one/impl/c/b/a:a	(Ljava/lang/String;)Ljava/lang/Class;
    //   56: astore 4
    //   58: aload 8
    //   60: ifnull +25 -> 85
    //   63: aload 4
    //   65: ifnull +20 -> 85
    //   68: aload 8
    //   70: aload 4
    //   72: invokeinterface 143 2 0
    //   77: ifne +8 -> 85
    //   80: aload_1
    //   81: aload_2
    //   82: invokestatic 146	com/tencent/tbs/one/impl/c/b/a:c	(Ljava/lang/String;Landroid/util/AttributeSet;)V
    //   85: aload 4
    //   87: getstatic 36	com/tencent/tbs/one/impl/c/b/a:d	[Ljava/lang/Class;
    //   90: invokevirtual 150	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   93: astore 5
    //   95: aload 5
    //   97: iconst_1
    //   98: invokevirtual 154	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   101: aload_0
    //   102: getfield 58	com/tencent/tbs/one/impl/c/b/a:e	Ljava/util/HashMap;
    //   105: aload_1
    //   106: aload 5
    //   108: invokevirtual 158	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: aload_0
    //   113: getfield 52	com/tencent/tbs/one/impl/c/b/a:c	[Ljava/lang/Object;
    //   116: astore 6
    //   118: aload 6
    //   120: iconst_1
    //   121: aload_2
    //   122: aastore
    //   123: aload 5
    //   125: aload 6
    //   127: invokevirtual 162	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 80	android/view/View
    //   133: astore 5
    //   135: getstatic 103	android/os/Build$VERSION:SDK_INT	I
    //   138: bipush 16
    //   140: if_icmplt +20 -> 160
    //   143: aload 5
    //   145: instanceof 164
    //   148: ifeq +12 -> 160
    //   151: aload 5
    //   153: checkcast 164	android/view/ViewStub
    //   156: aload_0
    //   157: invokevirtual 168	android/view/ViewStub:setLayoutInflater	(Landroid/view/LayoutInflater;)V
    //   160: aload 7
    //   162: monitorexit
    //   163: ldc 121
    //   165: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload 5
    //   170: areturn
    //   171: aload 8
    //   173: ifnull +105 -> 278
    //   176: aload_0
    //   177: getfield 170	com/tencent/tbs/one/impl/c/b/a:f	Ljava/util/HashMap;
    //   180: aload_1
    //   181: invokevirtual 129	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: checkcast 172	java/lang/Boolean
    //   187: astore 5
    //   189: aload 5
    //   191: ifnonnull +71 -> 262
    //   194: aload_0
    //   195: aload_1
    //   196: invokespecial 137	com/tencent/tbs/one/impl/c/b/a:a	(Ljava/lang/String;)Ljava/lang/Class;
    //   199: astore 5
    //   201: aload 5
    //   203: ifnull +54 -> 257
    //   206: aload 8
    //   208: aload 5
    //   210: invokeinterface 143 2 0
    //   215: ifeq +42 -> 257
    //   218: iconst_1
    //   219: istore_3
    //   220: aload_0
    //   221: getfield 170	com/tencent/tbs/one/impl/c/b/a:f	Ljava/util/HashMap;
    //   224: aload_1
    //   225: iload_3
    //   226: invokestatic 176	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   229: invokevirtual 158	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   232: pop
    //   233: iload_3
    //   234: ifne +8 -> 242
    //   237: aload_1
    //   238: aload_2
    //   239: invokestatic 146	com/tencent/tbs/one/impl/c/b/a:c	(Ljava/lang/String;Landroid/util/AttributeSet;)V
    //   242: aload 4
    //   244: astore 6
    //   246: aload 5
    //   248: astore 4
    //   250: aload 6
    //   252: astore 5
    //   254: goto -142 -> 112
    //   257: iconst_0
    //   258: istore_3
    //   259: goto -39 -> 220
    //   262: aload 5
    //   264: getstatic 180	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   267: invokevirtual 184	java/lang/Boolean:equals	(Ljava/lang/Object;)Z
    //   270: ifeq +8 -> 278
    //   273: aload_1
    //   274: aload_2
    //   275: invokestatic 146	com/tencent/tbs/one/impl/c/b/a:c	(Ljava/lang/String;Landroid/util/AttributeSet;)V
    //   278: aload 4
    //   280: astore 5
    //   282: aload 6
    //   284: astore 4
    //   286: goto -174 -> 112
    //   289: astore 4
    //   291: new 186	android/view/InflateException
    //   294: dup
    //   295: new 188	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   302: aload_2
    //   303: invokeinterface 193 1 0
    //   308: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc 199
    //   313: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_1
    //   317: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: aload 4
    //   325: invokespecial 205	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: astore_1
    //   329: aload_1
    //   330: getstatic 28	com/tencent/tbs/one/impl/c/b/a:b	[Ljava/lang/StackTraceElement;
    //   333: invokevirtual 209	android/view/InflateException:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   336: ldc 121
    //   338: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aload_1
    //   342: athrow
    //   343: astore_1
    //   344: aload 7
    //   346: monitorexit
    //   347: ldc 121
    //   349: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload_1
    //   353: athrow
    //   354: astore 4
    //   356: new 186	android/view/InflateException
    //   359: dup
    //   360: new 188	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   367: aload_2
    //   368: invokeinterface 193 1 0
    //   373: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 211
    //   378: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_1
    //   382: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokespecial 214	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   391: astore_1
    //   392: aload_1
    //   393: getstatic 28	com/tencent/tbs/one/impl/c/b/a:b	[Ljava/lang/StackTraceElement;
    //   396: invokevirtual 209	android/view/InflateException:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   399: ldc 121
    //   401: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: aload_1
    //   405: athrow
    //   406: astore_1
    //   407: ldc 121
    //   409: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aload_1
    //   413: athrow
    //   414: new 188	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   421: aload_2
    //   422: invokeinterface 193 1 0
    //   427: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc 199
    //   432: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: astore_2
    //   436: aload_1
    //   437: ifnonnull +36 -> 473
    //   440: ldc 216
    //   442: astore_1
    //   443: new 186	android/view/InflateException
    //   446: dup
    //   447: aload_2
    //   448: aload_1
    //   449: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokespecial 214	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   458: astore_1
    //   459: aload_1
    //   460: getstatic 28	com/tencent/tbs/one/impl/c/b/a:b	[Ljava/lang/StackTraceElement;
    //   463: invokevirtual 209	android/view/InflateException:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   466: ldc 121
    //   468: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   471: aload_1
    //   472: athrow
    //   473: aload_1
    //   474: invokevirtual 219	java/lang/Class:getName	()Ljava/lang/String;
    //   477: astore_1
    //   478: goto -35 -> 443
    //   481: astore_1
    //   482: aload 4
    //   484: astore_1
    //   485: goto -71 -> 414
    //   488: astore_1
    //   489: aload 5
    //   491: astore_1
    //   492: goto -78 -> 414
    //   495: astore_1
    //   496: aload 4
    //   498: astore_1
    //   499: goto -85 -> 414
    //   502: astore_1
    //   503: aconst_null
    //   504: astore_1
    //   505: goto -91 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	508	0	this	a
    //   0	508	1	paramString	String
    //   0	508	2	paramAttributeSet	AttributeSet
    //   219	40	3	bool	boolean
    //   35	250	4	localObject1	Object
    //   289	35	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   354	143	4	localClassCastException	java.lang.ClassCastException
    //   93	397	5	localObject2	Object
    //   38	245	6	localObject3	Object
    //   9	336	7	arrayOfObject	Object[]
    //   44	163	8	localFilter	LayoutInflater.Filter
    // Exception table:
    //   from	to	target	type
    //   40	46	289	java/lang/NoSuchMethodException
    //   51	58	289	java/lang/NoSuchMethodException
    //   68	85	289	java/lang/NoSuchMethodException
    //   85	112	289	java/lang/NoSuchMethodException
    //   112	118	289	java/lang/NoSuchMethodException
    //   123	160	289	java/lang/NoSuchMethodException
    //   176	189	289	java/lang/NoSuchMethodException
    //   194	201	289	java/lang/NoSuchMethodException
    //   206	218	289	java/lang/NoSuchMethodException
    //   220	233	289	java/lang/NoSuchMethodException
    //   237	242	289	java/lang/NoSuchMethodException
    //   262	278	289	java/lang/NoSuchMethodException
    //   14	37	343	finally
    //   40	46	343	finally
    //   51	58	343	finally
    //   68	85	343	finally
    //   85	112	343	finally
    //   112	118	343	finally
    //   123	160	343	finally
    //   160	163	343	finally
    //   176	189	343	finally
    //   194	201	343	finally
    //   206	218	343	finally
    //   220	233	343	finally
    //   237	242	343	finally
    //   262	278	343	finally
    //   291	343	343	finally
    //   344	347	343	finally
    //   356	406	343	finally
    //   407	414	343	finally
    //   414	436	343	finally
    //   443	473	343	finally
    //   473	478	343	finally
    //   40	46	354	java/lang/ClassCastException
    //   51	58	354	java/lang/ClassCastException
    //   68	85	354	java/lang/ClassCastException
    //   85	112	354	java/lang/ClassCastException
    //   112	118	354	java/lang/ClassCastException
    //   123	160	354	java/lang/ClassCastException
    //   176	189	354	java/lang/ClassCastException
    //   194	201	354	java/lang/ClassCastException
    //   206	218	354	java/lang/ClassCastException
    //   220	233	354	java/lang/ClassCastException
    //   237	242	354	java/lang/ClassCastException
    //   262	278	354	java/lang/ClassCastException
    //   40	46	406	java/lang/ClassNotFoundException
    //   51	58	406	java/lang/ClassNotFoundException
    //   68	85	406	java/lang/ClassNotFoundException
    //   85	112	406	java/lang/ClassNotFoundException
    //   112	118	406	java/lang/ClassNotFoundException
    //   123	160	406	java/lang/ClassNotFoundException
    //   176	189	406	java/lang/ClassNotFoundException
    //   194	201	406	java/lang/ClassNotFoundException
    //   206	218	406	java/lang/ClassNotFoundException
    //   220	233	406	java/lang/ClassNotFoundException
    //   237	242	406	java/lang/ClassNotFoundException
    //   262	278	406	java/lang/ClassNotFoundException
    //   68	85	481	java/lang/Exception
    //   85	112	481	java/lang/Exception
    //   206	218	488	java/lang/Exception
    //   220	233	488	java/lang/Exception
    //   237	242	488	java/lang/Exception
    //   112	118	495	java/lang/Exception
    //   123	160	495	java/lang/Exception
    //   40	46	502	java/lang/Exception
    //   51	58	502	java/lang/Exception
    //   176	189	502	java/lang/Exception
    //   194	201	502	java/lang/Exception
    //   262	278	502	java/lang/Exception
  }
  
  private static void c(String paramString, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(173856);
    paramString = new InflateException(paramAttributeSet.getPositionDescription() + ": Class not allowed to be inflated " + paramString);
    AppMethodBeat.o(173856);
    throw paramString;
  }
  
  public final View a(String paramString, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(173854);
    Object localObject4 = null;
    Object localObject1 = localObject4;
    if (-1 != paramString.indexOf('.')) {}
    try
    {
      localObject1 = b(paramString, paramAttributeSet);
      localObject4 = localObject1;
      if (localObject1 != null) {}
    }
    finally
    {
      try
      {
        if (-1 == paramString.indexOf('.')) {}
        for (localObject4 = onCreateView(paramString, paramAttributeSet);; localObject4 = createView(paramString, null, paramAttributeSet))
        {
          AppMethodBeat.o(173854);
          return localObject4;
          localObject2 = finally;
          f.b("Failed to create view %s", new Object[] { paramString, localObject2 });
          localObject3 = localObject4;
          break;
        }
      }
      finally
      {
        for (;;)
        {
          Object localObject3;
          f.b("Failed to create view %s", new Object[] { paramString, paramAttributeSet });
          localObject4 = localObject3;
        }
      }
    }
  }
  
  public final LayoutInflater cloneInContext(Context paramContext)
  {
    AppMethodBeat.i(173851);
    paramContext = new a(this, paramContext);
    AppMethodBeat.o(173851);
    return paramContext;
  }
  
  public final void setFilter(LayoutInflater.Filter paramFilter)
  {
    AppMethodBeat.i(173852);
    super.setFilter(paramFilter);
    if (paramFilter != null) {
      this.f = new HashMap();
    }
    AppMethodBeat.o(173852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b.a
 * JD-Core Version:    0.7.0.1
 */
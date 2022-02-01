package com.tencent.tbs.one.impl.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.c.a.c.1;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.e.a;
import com.tencent.tbs.one.impl.common.e.b;
import com.tencent.tbs.one.impl.e.h.1;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class b
  implements com.tencent.tbs.one.impl.a.a.d.a
{
  public String a;
  public com.tencent.tbs.one.impl.e.h b;
  ArrayList<TBSOneCallback<File>> c;
  public ArrayList<TBSOneCallback<TBSOneComponent>> d;
  public boolean e;
  com.tencent.tbs.one.impl.common.d.a f;
  public int g;
  int h;
  int i;
  String j;
  public File k;
  public a l;
  private com.tencent.tbs.one.impl.common.e m;
  private Map<String, ClassLoader> n;
  
  public b(com.tencent.tbs.one.impl.e.h paramh, String paramString)
  {
    AppMethodBeat.i(173830);
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.a = paramString;
    this.b = paramh;
    AppMethodBeat.o(173830);
  }
  
  private File a(String paramString)
  {
    AppMethodBeat.i(173837);
    if (this.b.b())
    {
      Object localObject = this.b.f;
      if (localObject != null)
      {
        localObject = ((TBSOneDelegate)localObject).shouldOverrideFilePath(this.b.b, this.a, this.f.c, paramString);
        if (localObject != null)
        {
          paramString = new File((String)localObject);
          AppMethodBeat.o(173837);
          return paramString;
        }
      }
      paramString = com.tencent.tbs.one.impl.common.f.a(com.tencent.tbs.one.impl.common.f.a(this.b.a), this.a, paramString);
      AppMethodBeat.o(173837);
      return paramString;
    }
    paramString = new File(this.k, paramString);
    if (!paramString.exists()) {
      com.tencent.tbs.one.impl.a.f.b("Failed to find component file %s in installation directory", new Object[] { paramString.getAbsolutePath() });
    }
    AppMethodBeat.o(173837);
    return paramString;
  }
  
  private ClassLoader a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(173840);
    String str1 = this.b.b;
    String str2 = this.a;
    Object localObject1;
    if (this.n != null)
    {
      localObject1 = (ClassLoader)this.n.get(paramString);
      if (localObject1 != null)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Reusing class loader %s %s", new Object[] { str1, str2, paramString, localObject1 });
        AppMethodBeat.o(173840);
        return localObject1;
      }
    }
    File localFile = a(paramString);
    if (!localFile.exists())
    {
      paramContext = new TBSOneException(105, "Failed to find dex file " + localFile.getAbsolutePath());
      AppMethodBeat.o(173840);
      throw paramContext;
    }
    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Creating class loader %s from %s", new Object[] { str1, str2, paramString, localFile.getAbsolutePath() });
    Object localObject2;
    label184:
    Object localObject3;
    label216:
    Object localObject4;
    long l1;
    String str3;
    label249:
    boolean bool;
    label283:
    int i1;
    if (this.m == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label639;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label710;
      }
      localObject3 = ((e.b)localObject1).a;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break label649;
      }
      localObject1 = a(paramContext, ((e.b)localObject1).b);
      localObject4 = b(localFile.getAbsolutePath());
      l1 = System.currentTimeMillis();
      str3 = this.k.getAbsolutePath();
      if (localObject2 != null) {
        break label739;
      }
      localObject2 = null;
      localObject3 = this.b.g.get("async_dex_optimization");
      if (!(localObject3 instanceof Boolean)) {
        break label749;
      }
      bool = ((Boolean)localObject3).booleanValue();
      com.tencent.tbs.one.impl.a.f.a("Creating class loader from %s, optimizedDirectory: %s, librarySearchPath: %s, parent: %s, sealedPackage: %s, isAsyncDexOptimizationEnabled: %b", new Object[] { localFile.getAbsolutePath(), str3, localObject4, localObject1, localObject2, Boolean.valueOf(bool) });
      if (!bool) {
        break label865;
      }
      if (com.tencent.tbs.one.impl.c.a.c.a == null)
      {
        i1 = Build.VERSION.SDK_INT;
        if ((i1 >= 21) && (i1 <= 25)) {
          break label755;
        }
        com.tencent.tbs.one.impl.a.f.a("API level %d does not support dex optimization", new Object[] { Integer.valueOf(i1) });
        bool = false;
        label375:
        com.tencent.tbs.one.impl.c.a.c.a = Boolean.valueOf(bool);
      }
      if (!com.tencent.tbs.one.impl.c.a.c.a.booleanValue()) {
        break label865;
      }
      String str4 = localFile.getName();
      bool = com.tencent.tbs.one.impl.c.a.c.b(str3, str4).exists();
      if (!bool) {
        break label828;
      }
      localObject3 = "has";
      label420:
      com.tencent.tbs.one.impl.a.f.a("The dex %s %s optimized", new Object[] { str4, localObject3 });
      if ((!bool) || (!com.tencent.tbs.one.impl.c.a.c.a(str3, str4))) {
        break label836;
      }
      i1 = 0;
      label456:
      if (i1 == 0) {
        break label865;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label841;
      }
      localObject1 = new PathClassLoader(localFile.getAbsolutePath(), (String)localObject4, (ClassLoader)localObject1);
      label486:
      m.c(new c.1(localFile, paramContext, str3, (String)localObject4));
      paramContext = (Context)localObject1;
    }
    for (;;)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Created dex class loader %s %s cost %dms", new Object[] { str1, str2, paramString, paramContext, Long.valueOf(System.currentTimeMillis() - l1) });
      if (this.n == null) {
        this.n = new HashMap();
      }
      this.n.put(paramString, paramContext);
      if (this.b.b())
      {
        paramString = this.b.f;
        if (paramString != null) {
          paramString.onDexLoaded(str1, str2, this.f.c, localFile.getAbsolutePath(), paramContext);
        }
      }
      AppMethodBeat.o(173840);
      return paramContext;
      localObject2 = this.m.a(paramString);
      break;
      label639:
      localObject1 = ((e.a)localObject2).d;
      break label184;
      label649:
      localObject4 = this.b.d((String)localObject3);
      if (localObject4 == null)
      {
        paramContext = new TBSOneException(404, "Failed to get loaded dependency ".concat(String.valueOf(localObject3)));
        AppMethodBeat.o(173840);
        throw paramContext;
      }
      localObject1 = ((b)localObject4).a(paramContext, ((e.b)localObject1).b);
      break label216;
      label710:
      localObject3 = c();
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label216;
      }
      localObject1 = this.b.a.getClassLoader();
      break label216;
      label739:
      localObject2 = ((e.a)localObject2).c;
      break label249;
      label749:
      bool = false;
      break label283;
      label755:
      localObject3 = System.getProperty("java.vm.version");
      if ((localObject3 == null) || (!((String)localObject3).startsWith("2")))
      {
        com.tencent.tbs.one.impl.a.f.a("VM version %s does not support dex optimization", new Object[] { localObject3 });
        bool = false;
        break label375;
      }
      com.tencent.tbs.one.impl.a.f.a("API level %d and VM version %s supports dex optimization", new Object[] { Integer.valueOf(i1), localObject3 });
      bool = true;
      break label375;
      label828:
      localObject3 = "has not";
      break label420;
      label836:
      i1 = 1;
      break label456;
      label841:
      localObject1 = new com.tencent.tbs.one.impl.c.a.e(localFile.getAbsolutePath(), null, (String)localObject4, (ClassLoader)localObject1, (String)localObject2);
      break label486;
      label865:
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        paramContext = new DexClassLoader(localFile.getAbsolutePath(), str3, (String)localObject4, (ClassLoader)localObject1);
      } else {
        paramContext = new com.tencent.tbs.one.impl.c.a.e(localFile.getAbsolutePath(), str3, (String)localObject4, (ClassLoader)localObject1, (String)localObject2);
      }
    }
  }
  
  private void a(a parama)
  {
    int i1 = 0;
    AppMethodBeat.i(173843);
    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished loading component %s", new Object[] { this.b.b, this.a, parama });
    this.l = parama;
    int i2 = this.g;
    this.g = 100;
    TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
    this.d.clear();
    int i3 = arrayOfTBSOneCallback.length;
    while (i1 < i3)
    {
      TBSOneCallback localTBSOneCallback = arrayOfTBSOneCallback[i1];
      localTBSOneCallback.onProgressChanged(i2, 100);
      localTBSOneCallback.onCompleted(parama);
      i1 += 1;
    }
    AppMethodBeat.o(173843);
  }
  
  private String b(String paramString)
  {
    AppMethodBeat.i(173839);
    String str = TextUtils.join(File.pathSeparator, d());
    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Collected librarySearchPath %s", new Object[] { this.b.b, this.a, str });
    if (this.b.b())
    {
      TBSOneDelegate localTBSOneDelegate = this.b.f;
      if (localTBSOneDelegate != null)
      {
        paramString = localTBSOneDelegate.shouldOverrideLibrarySearchPath(this.b.b, this.a, this.f.c, paramString, str);
        if (paramString != null)
        {
          AppMethodBeat.o(173839);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(173839);
    return str;
  }
  
  private static ClassLoader c()
  {
    AppMethodBeat.i(190120);
    try
    {
      Object localObject = Class.forName("dalvik.system.VMStack").getMethod("getCallingClassLoader", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      if ((localObject instanceof ClassLoader))
      {
        localObject = (ClassLoader)localObject;
        AppMethodBeat.o(190120);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(190120);
    }
    return null;
  }
  
  private Set<String> d()
  {
    AppMethodBeat.i(190129);
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.k.getAbsolutePath());
    String[] arrayOfString = this.f.f;
    if (arrayOfString != null)
    {
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        localHashSet.addAll(this.b.d(str).d());
        i1 += 1;
      }
    }
    AppMethodBeat.o(190129);
    return localHashSet;
  }
  
  public final void a()
  {
    AppMethodBeat.i(173834);
    final String str = this.a;
    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished installing component and dependencies", new Object[] { this.b.b, str });
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(173879);
        if (b.this.f == null)
        {
          localObject1 = str;
          com.tencent.tbs.one.impl.a.f.c("[%s] {%s} Unknown error, finished installing component and dependencies but config is null, last error: [%d] %s", new Object[] { b.this.b.b, localObject1, Integer.valueOf(b.this.i), b.this.j });
          localObject2 = b.this.b.h;
          if (localObject2 != null) {}
          for (i = ((d)localObject2).a;; i = -1)
          {
            com.tencent.tbs.one.impl.common.h.a(i, (String)localObject1, -1, 101, String.format(Locale.US, "ComponentConfig is null, last error: [%d] %s", new Object[] { Integer.valueOf(b.this.i), b.this.j }), null);
            AppMethodBeat.o(173879);
            return;
          }
        }
        b.this.a(90);
        Object localObject1 = b.this.b.a(str, b.this.f.c);
        Object localObject2 = b.this;
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished installing component at %s", new Object[] { ((b)localObject2).b.b, str, ((File)localObject1).getAbsolutePath() });
        ((b)localObject2).k = ((File)localObject1);
        TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])((b)localObject2).c.toArray(new TBSOneCallback[0]);
        ((b)localObject2).c.clear();
        int j = arrayOfTBSOneCallback.length;
        int i = 0;
        while (i < j)
        {
          TBSOneCallback localTBSOneCallback = arrayOfTBSOneCallback[i];
          localTBSOneCallback.onProgressChanged(((b)localObject2).g, 100);
          localTBSOneCallback.onCompleted(localObject1);
          i += 1;
        }
        if (b.this.d.size() > 0) {
          b.this.b();
        }
        AppMethodBeat.o(173879);
      }
    });
    AppMethodBeat.o(173834);
  }
  
  final void a(int paramInt)
  {
    AppMethodBeat.i(173842);
    Object localObject = this.b.b;
    localObject = this.a;
    int i1 = this.g;
    if (paramInt - this.g > 2)
    {
      int i2 = this.g;
      this.g = paramInt;
      localObject = (TBSOneCallback[])this.c.toArray(new TBSOneCallback[0]);
      TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
      int i3 = localObject.length;
      i1 = 0;
      while (i1 < i3)
      {
        localObject[i1].onProgressChanged(i2, paramInt);
        i1 += 1;
      }
      i3 = arrayOfTBSOneCallback.length;
      i1 = 0;
      while (i1 < i3)
      {
        arrayOfTBSOneCallback[i1].onProgressChanged(i2, paramInt);
        i1 += 1;
      }
    }
    AppMethodBeat.o(173842);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(173841);
    paramInt1 = Math.min(Math.max(0, paramInt1), 100);
    float f1 = paramInt2;
    a((int)(paramInt1 / 100.0F * (paramInt3 - paramInt2) + f1));
    AppMethodBeat.o(173841);
  }
  
  public final void a(final int paramInt, final String paramString, final Throwable paramThrowable)
  {
    AppMethodBeat.i(173833);
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(173847);
        b.this.b(paramInt, paramString, paramThrowable);
        AppMethodBeat.o(173847);
      }
    });
    AppMethodBeat.o(173833);
  }
  
  public final void a(final Bundle paramBundle)
  {
    AppMethodBeat.i(190073);
    Object localObject1 = this.b.b;
    Object localObject2 = this.a;
    if (this.e)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Have started loading component", new Object[] { localObject1, localObject2 });
      AppMethodBeat.o(190073);
      return;
    }
    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Loading DEPS", new Object[] { localObject1, localObject2 });
    this.e = true;
    localObject1 = this.b;
    localObject2 = new com.tencent.tbs.one.impl.common.c()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(173880);
        b.this.a(paramAnonymousInt2, 0, 20);
        AppMethodBeat.o(173880);
      }
      
      public final void a(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(173881);
        b.this.b(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
        AppMethodBeat.o(173881);
      }
    };
    String str = ((com.tencent.tbs.one.impl.e.h)localObject1).b;
    com.tencent.tbs.one.impl.a.f.a("[%s] Loading DEPS", new Object[] { str });
    if (((com.tencent.tbs.one.impl.e.h)localObject1).h != null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] Loaded DEPS#%d", new Object[] { str, Integer.valueOf(((com.tencent.tbs.one.impl.e.h)localObject1).h.a) });
      ((l)localObject2).a(((com.tencent.tbs.one.impl.e.h)localObject1).h);
      AppMethodBeat.o(190073);
      return;
    }
    if (((com.tencent.tbs.one.impl.e.h)localObject1).i == null) {
      ((com.tencent.tbs.one.impl.e.h)localObject1).i = new h.1((com.tencent.tbs.one.impl.e.h)localObject1, paramBundle);
    }
    ((com.tencent.tbs.one.impl.e.h)localObject1).i.a((l)localObject2);
    AppMethodBeat.o(190073);
  }
  
  public final void a(Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    AppMethodBeat.i(190069);
    if (this.k != null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Installed component at %s", new Object[] { this.b.b, this.a, this.k });
      if (paramTBSOneCallback != null)
      {
        paramTBSOneCallback.onProgressChanged(0, 100);
        paramTBSOneCallback.onCompleted(this.k);
      }
      AppMethodBeat.o(190069);
      return;
    }
    if (paramTBSOneCallback != null)
    {
      paramTBSOneCallback.onProgressChanged(0, this.g);
      this.c.add(paramTBSOneCallback);
    }
    a(paramBundle);
    AppMethodBeat.o(190069);
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: ldc_w 519
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 75	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   10: getfield 91	com/tencent/tbs/one/impl/e/h:b	Ljava/lang/String;
    //   13: astore 7
    //   15: aload_0
    //   16: getfield 73	com/tencent/tbs/one/impl/c/b:a	Ljava/lang/String;
    //   19: astore 8
    //   21: aload_0
    //   22: getfield 93	com/tencent/tbs/one/impl/c/b:f	Lcom/tencent/tbs/one/impl/common/d$a;
    //   25: getfield 97	com/tencent/tbs/one/impl/common/d$a:c	I
    //   28: istore_2
    //   29: ldc_w 521
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload 7
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload 8
    //   45: aastore
    //   46: invokestatic 154	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: new 523	com/tencent/tbs/one/impl/c/a
    //   52: dup
    //   53: aload 8
    //   55: aload_0
    //   56: getfield 93	com/tencent/tbs/one/impl/c/b:f	Lcom/tencent/tbs/one/impl/common/d$a;
    //   59: getfield 524	com/tencent/tbs/one/impl/common/d$a:b	Ljava/lang/String;
    //   62: iload_2
    //   63: aload_0
    //   64: getfield 121	com/tencent/tbs/one/impl/c/b:k	Ljava/io/File;
    //   67: invokespecial 527	com/tencent/tbs/one/impl/c/a:<init>	(Ljava/lang/String;Ljava/lang/String;ILjava/io/File;)V
    //   70: astore 6
    //   72: aload_0
    //   73: ldc_w 529
    //   76: invokespecial 156	com/tencent/tbs/one/impl/c/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   79: astore 4
    //   81: aload 4
    //   83: invokevirtual 127	java/io/File:exists	()Z
    //   86: ifeq +950 -> 1036
    //   89: ldc_w 531
    //   92: iconst_3
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload 7
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: aload 8
    //   105: aastore
    //   106: dup
    //   107: iconst_2
    //   108: aload 4
    //   110: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   113: aastore
    //   114: invokestatic 154	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_0
    //   118: aload 4
    //   120: invokestatic 534	com/tencent/tbs/one/impl/common/e:a	(Ljava/io/File;)Lcom/tencent/tbs/one/impl/common/e;
    //   123: putfield 177	com/tencent/tbs/one/impl/c/b:m	Lcom/tencent/tbs/one/impl/common/e;
    //   126: aload_0
    //   127: getfield 177	com/tencent/tbs/one/impl/c/b:m	Lcom/tencent/tbs/one/impl/common/e;
    //   130: getfield 537	com/tencent/tbs/one/impl/common/e:f	[Landroid/util/Pair;
    //   133: astore 9
    //   135: aload 9
    //   137: ifnull +180 -> 317
    //   140: ldc_w 539
    //   143: iconst_3
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload 7
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: aload 8
    //   156: aastore
    //   157: dup
    //   158: iconst_2
    //   159: aload 9
    //   161: aastore
    //   162: invokestatic 154	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload 9
    //   167: arraylength
    //   168: istore_3
    //   169: iconst_0
    //   170: istore_1
    //   171: iload_1
    //   172: iload_3
    //   173: if_icmpge +164 -> 337
    //   176: aload 9
    //   178: iload_1
    //   179: aaload
    //   180: astore 4
    //   182: aload_0
    //   183: getfield 75	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   186: astore 10
    //   188: new 541	com/tencent/tbs/one/impl/common/g
    //   191: dup
    //   192: aload 8
    //   194: aload 4
    //   196: getfield 547	android/util/Pair:second	Ljava/lang/Object;
    //   199: checkcast 293	java/lang/String
    //   202: aload 4
    //   204: getfield 550	android/util/Pair:first	Ljava/lang/Object;
    //   207: checkcast 293	java/lang/String
    //   210: invokespecial 553	com/tencent/tbs/one/impl/common/g:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   213: astore 11
    //   215: aload 11
    //   217: getfield 554	com/tencent/tbs/one/impl/common/g:c	Ljava/lang/String;
    //   220: astore 12
    //   222: aload 10
    //   224: getfield 556	com/tencent/tbs/one/impl/e/h:k	Ljava/util/Map;
    //   227: aload 12
    //   229: invokeinterface 148 2 0
    //   234: checkcast 558	java/util/List
    //   237: astore 5
    //   239: aload 5
    //   241: astore 4
    //   243: aload 5
    //   245: ifnonnull +27 -> 272
    //   248: new 66	java/util/ArrayList
    //   251: dup
    //   252: invokespecial 67	java/util/ArrayList:<init>	()V
    //   255: astore 4
    //   257: aload 10
    //   259: getfield 556	com/tencent/tbs/one/impl/e/h:k	Ljava/util/Map;
    //   262: aload 12
    //   264: aload 4
    //   266: invokeinterface 272 3 0
    //   271: pop
    //   272: aload 4
    //   274: aload 11
    //   276: invokeinterface 559 2 0
    //   281: pop
    //   282: iload_1
    //   283: iconst_1
    //   284: iadd
    //   285: istore_1
    //   286: goto -115 -> 171
    //   289: astore 4
    //   291: aload_0
    //   292: aload 4
    //   294: invokevirtual 563	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   297: aload 4
    //   299: invokevirtual 566	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   302: aload 4
    //   304: invokevirtual 570	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   307: invokevirtual 572	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   310: ldc_w 519
    //   313: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: return
    //   317: ldc_w 574
    //   320: iconst_2
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: aload 7
    //   328: aastore
    //   329: dup
    //   330: iconst_1
    //   331: aload 8
    //   333: aastore
    //   334: invokestatic 154	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: aload_0
    //   338: getfield 75	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   341: getfield 111	com/tencent/tbs/one/impl/e/h:a	Landroid/content/Context;
    //   344: astore 5
    //   346: aload_0
    //   347: getfield 177	com/tencent/tbs/one/impl/c/b:m	Lcom/tencent/tbs/one/impl/common/e;
    //   350: getfield 575	com/tencent/tbs/one/impl/common/e:b	Ljava/lang/String;
    //   353: astore 9
    //   355: aconst_null
    //   356: astore 4
    //   358: aload 9
    //   360: invokestatic 186	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   363: ifne +396 -> 759
    //   366: aload_0
    //   367: aload 9
    //   369: invokespecial 156	com/tencent/tbs/one/impl/c/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   372: astore 4
    //   374: ldc_w 577
    //   377: iconst_4
    //   378: anewarray 4	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: aload 7
    //   385: aastore
    //   386: dup
    //   387: iconst_1
    //   388: aload 8
    //   390: aastore
    //   391: dup
    //   392: iconst_2
    //   393: aload 9
    //   395: aastore
    //   396: dup
    //   397: iconst_3
    //   398: aload 4
    //   400: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   403: aastore
    //   404: invokestatic 154	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: aload 4
    //   409: invokevirtual 127	java/io/File:exists	()Z
    //   412: ifne +38 -> 450
    //   415: aload_0
    //   416: bipush 105
    //   418: new 160	java/lang/StringBuilder
    //   421: dup
    //   422: ldc_w 579
    //   425: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   428: aload 4
    //   430: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   433: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: aconst_null
    //   440: invokevirtual 572	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   443: ldc_w 519
    //   446: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: return
    //   450: new 581	com/tencent/tbs/one/impl/c/b/b
    //   453: dup
    //   454: aload 5
    //   456: aload 4
    //   458: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   461: invokespecial 584	com/tencent/tbs/one/impl/c/b/b:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   464: astore 4
    //   466: aload 6
    //   468: aload 4
    //   470: putfield 585	com/tencent/tbs/one/impl/c/a:a	Landroid/content/Context;
    //   473: aload_0
    //   474: getfield 177	com/tencent/tbs/one/impl/c/b:m	Lcom/tencent/tbs/one/impl/common/e;
    //   477: getfield 586	com/tencent/tbs/one/impl/common/e:c	Ljava/lang/String;
    //   480: astore 9
    //   482: aload 9
    //   484: invokestatic 186	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   487: ifne +526 -> 1013
    //   490: aload_0
    //   491: aload 5
    //   493: aload 9
    //   495: invokespecial 189	com/tencent/tbs/one/impl/c/b:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   498: astore 11
    //   500: aload 6
    //   502: aload 11
    //   504: putfield 589	com/tencent/tbs/one/impl/c/a:b	Ljava/lang/ClassLoader;
    //   507: aload_0
    //   508: getfield 177	com/tencent/tbs/one/impl/c/b:m	Lcom/tencent/tbs/one/impl/common/e;
    //   511: getfield 591	com/tencent/tbs/one/impl/common/e:d	Ljava/lang/String;
    //   514: astore 10
    //   516: aload 10
    //   518: invokestatic 186	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   521: ifne +469 -> 990
    //   524: ldc_w 593
    //   527: iconst_3
    //   528: anewarray 4	java/lang/Object
    //   531: dup
    //   532: iconst_0
    //   533: aload 7
    //   535: aastore
    //   536: dup
    //   537: iconst_1
    //   538: aload 8
    //   540: aastore
    //   541: dup
    //   542: iconst_2
    //   543: aload 10
    //   545: aastore
    //   546: invokestatic 154	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   549: new 267	java/util/HashMap
    //   552: dup
    //   553: invokespecial 268	java/util/HashMap:<init>	()V
    //   556: astore 7
    //   558: aload 7
    //   560: ldc_w 595
    //   563: aload 5
    //   565: invokeinterface 272 3 0
    //   570: pop
    //   571: aload 4
    //   573: ifnull +26 -> 599
    //   576: aload 4
    //   578: getfield 598	com/tencent/tbs/one/impl/c/b/b:a	Lcom/tencent/tbs/one/impl/c/b/a;
    //   581: aload 11
    //   583: putfield 602	com/tencent/tbs/one/impl/c/b/a:a	Ljava/lang/ClassLoader;
    //   586: aload 7
    //   588: ldc_w 604
    //   591: aload 4
    //   593: invokeinterface 272 3 0
    //   598: pop
    //   599: aload 7
    //   601: ldc_w 606
    //   604: aload 11
    //   606: invokeinterface 272 3 0
    //   611: pop
    //   612: aload 7
    //   614: ldc_w 608
    //   617: aload_0
    //   618: getfield 121	com/tencent/tbs/one/impl/c/b:k	Ljava/io/File;
    //   621: invokeinterface 272 3 0
    //   626: pop
    //   627: aload 7
    //   629: ldc_w 610
    //   632: aload_0
    //   633: getfield 121	com/tencent/tbs/one/impl/c/b:k	Ljava/io/File;
    //   636: invokeinterface 272 3 0
    //   641: pop
    //   642: aload 7
    //   644: ldc_w 612
    //   647: aload_0
    //   648: aload 9
    //   650: invokespecial 192	com/tencent/tbs/one/impl/c/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   653: invokeinterface 272 3 0
    //   658: pop
    //   659: aload 7
    //   661: ldc_w 614
    //   664: aload_0
    //   665: getfield 93	com/tencent/tbs/one/impl/c/b:f	Lcom/tencent/tbs/one/impl/common/d$a;
    //   668: getfield 524	com/tencent/tbs/one/impl/common/d$a:b	Ljava/lang/String;
    //   671: invokeinterface 272 3 0
    //   676: pop
    //   677: aload 7
    //   679: ldc_w 616
    //   682: iload_2
    //   683: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   686: invokeinterface 272 3 0
    //   691: pop
    //   692: aload 7
    //   694: ldc_w 618
    //   697: aload_0
    //   698: getfield 75	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   701: getfield 621	com/tencent/tbs/one/impl/e/h:l	Lcom/tencent/tbs/one/impl/e/b;
    //   704: invokeinterface 272 3 0
    //   709: pop
    //   710: aload 6
    //   712: aload 11
    //   714: aload 10
    //   716: invokevirtual 624	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   719: iconst_1
    //   720: anewarray 408	java/lang/Class
    //   723: dup
    //   724: iconst_0
    //   725: ldc 144
    //   727: aastore
    //   728: invokevirtual 628	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   731: iconst_1
    //   732: anewarray 4	java/lang/Object
    //   735: dup
    //   736: iconst_0
    //   737: aload 7
    //   739: aastore
    //   740: invokevirtual 634	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   743: putfield 636	com/tencent/tbs/one/impl/c/a:c	Ljava/lang/Object;
    //   746: aload_0
    //   747: aload 6
    //   749: invokespecial 638	com/tencent/tbs/one/impl/c/b:a	(Lcom/tencent/tbs/one/impl/c/a;)V
    //   752: ldc_w 519
    //   755: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   758: return
    //   759: ldc_w 640
    //   762: iconst_2
    //   763: anewarray 4	java/lang/Object
    //   766: dup
    //   767: iconst_0
    //   768: aload 7
    //   770: aastore
    //   771: dup
    //   772: iconst_1
    //   773: aload 8
    //   775: aastore
    //   776: invokestatic 154	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   779: goto -306 -> 473
    //   782: astore 4
    //   784: aload_0
    //   785: aload 4
    //   787: invokevirtual 563	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   790: aload 4
    //   792: invokevirtual 566	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   795: aload 4
    //   797: invokevirtual 570	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   800: invokevirtual 572	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   803: ldc_w 519
    //   806: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   809: return
    //   810: astore 4
    //   812: aload_0
    //   813: sipush 405
    //   816: new 160	java/lang/StringBuilder
    //   819: dup
    //   820: ldc_w 642
    //   823: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   826: aload 10
    //   828: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: ldc_w 644
    //   834: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: aload 9
    //   839: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: ldc_w 646
    //   845: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload 4
    //   850: invokestatic 652	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   853: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   859: aconst_null
    //   860: invokevirtual 572	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   863: ldc_w 519
    //   866: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   869: return
    //   870: astore 4
    //   872: aload_0
    //   873: sipush 406
    //   876: new 160	java/lang/StringBuilder
    //   879: dup
    //   880: ldc_w 654
    //   883: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   886: aload 10
    //   888: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: ldc_w 656
    //   894: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: aload 9
    //   899: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: ldc_w 646
    //   905: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: aload 4
    //   910: invokestatic 652	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   913: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   919: aconst_null
    //   920: invokevirtual 572	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   923: ldc_w 519
    //   926: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   929: return
    //   930: astore 4
    //   932: aload_0
    //   933: sipush 407
    //   936: new 160	java/lang/StringBuilder
    //   939: dup
    //   940: ldc_w 658
    //   943: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   946: aload 10
    //   948: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: ldc_w 644
    //   954: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: aload 9
    //   959: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: ldc_w 646
    //   965: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: aload 4
    //   970: invokestatic 652	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   973: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: aconst_null
    //   980: invokevirtual 572	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   983: ldc_w 519
    //   986: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   989: return
    //   990: ldc_w 660
    //   993: iconst_2
    //   994: anewarray 4	java/lang/Object
    //   997: dup
    //   998: iconst_0
    //   999: aload 7
    //   1001: aastore
    //   1002: dup
    //   1003: iconst_1
    //   1004: aload 8
    //   1006: aastore
    //   1007: invokestatic 154	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1010: goto -264 -> 746
    //   1013: ldc_w 662
    //   1016: iconst_2
    //   1017: anewarray 4	java/lang/Object
    //   1020: dup
    //   1021: iconst_0
    //   1022: aload 7
    //   1024: aastore
    //   1025: dup
    //   1026: iconst_1
    //   1027: aload 8
    //   1029: aastore
    //   1030: invokestatic 154	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1033: goto -287 -> 746
    //   1036: ldc_w 664
    //   1039: iconst_2
    //   1040: anewarray 4	java/lang/Object
    //   1043: dup
    //   1044: iconst_0
    //   1045: aload 7
    //   1047: aastore
    //   1048: dup
    //   1049: iconst_1
    //   1050: aload 8
    //   1052: aastore
    //   1053: invokestatic 154	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1056: goto -310 -> 746
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1059	0	this	b
    //   170	116	1	i1	int
    //   28	655	2	i2	int
    //   168	6	3	i3	int
    //   79	194	4	localObject1	Object
    //   289	14	4	localTBSOneException1	TBSOneException
    //   356	236	4	localObject2	Object
    //   782	14	4	localTBSOneException2	TBSOneException
    //   810	39	4	localClassNotFoundException	java.lang.ClassNotFoundException
    //   870	39	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   930	39	4	localException	java.lang.Exception
    //   237	327	5	localObject3	Object
    //   70	678	6	locala	a
    //   13	1033	7	localObject4	Object
    //   19	1032	8	str1	String
    //   133	825	9	localObject5	Object
    //   186	761	10	localObject6	Object
    //   213	500	11	localObject7	Object
    //   220	43	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   117	126	289	com/tencent/tbs/one/TBSOneException
    //   490	500	782	com/tencent/tbs/one/TBSOneException
    //   710	746	810	java/lang/ClassNotFoundException
    //   710	746	870	java/lang/NoSuchMethodException
    //   710	746	930	java/lang/Exception
  }
  
  final void b(int paramInt, String paramString, Throwable paramThrowable)
  {
    int i2 = -1;
    AppMethodBeat.i(173844);
    Object localObject = this.a;
    com.tencent.tbs.one.impl.a.f.b("Failed to install or load component %s, error: [%d] %s", new Object[] { localObject, Integer.valueOf(paramInt), paramString });
    com.tencent.tbs.one.impl.a.f.c("[%s] {%s} Failed to install or load component, error: [%d] %s", new Object[] { this.b.b, localObject, Integer.valueOf(paramInt), paramString, paramThrowable });
    d locald = this.b.h;
    if (locald != null) {}
    for (int i1 = locald.a;; i1 = -1)
    {
      if (this.f != null) {
        i2 = this.f.c;
      }
      com.tencent.tbs.one.impl.common.h.a(i1, (String)localObject, i2, paramInt, paramString, paramThrowable);
      this.i = paramInt;
      this.j = paramString;
      this.f = null;
      this.m = null;
      this.k = null;
      this.l = null;
      this.g = 0;
      this.e = false;
      paramThrowable = (TBSOneCallback[])this.c.toArray(new TBSOneCallback[0]);
      this.c.clear();
      localObject = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
      this.d.clear();
      i2 = paramThrowable.length;
      i1 = 0;
      while (i1 < i2)
      {
        paramThrowable[i1].onError(paramInt, paramString);
        i1 += 1;
      }
    }
    i2 = localObject.length;
    i1 = 0;
    while (i1 < i2)
    {
      localObject[i1].onError(paramInt, paramString);
      i1 += 1;
    }
    AppMethodBeat.o(173844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b
 * JD-Core Version:    0.7.0.1
 */
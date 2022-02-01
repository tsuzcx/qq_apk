package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface f
{
  public abstract f btK(String paramString);
  
  public abstract f cm(String paramString, long paramLong);
  
  public abstract f dZ(String paramString, boolean paramBoolean);
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract f iC(String paramString, int paramInt);
  
  public abstract f iQF();
  
  public abstract f iQG();
  
  public abstract f iQH();
  
  public abstract f px(String paramString1, String paramString2);
  
  public static final class a
    implements f
  {
    final File acjY;
    final File acjZ;
    private final AtomicBoolean acka;
    private final Bundle mExtras;
    
    public a(Context paramContext, String paramString)
    {
      this(new File(k.a.lX(paramContext), paramString));
      AppMethodBeat.i(237919);
      AppMethodBeat.o(237919);
    }
    
    private a(File paramFile)
    {
      AppMethodBeat.i(237927);
      this.mExtras = new Bundle();
      this.acka = new AtomicBoolean();
      this.acjY = paramFile;
      this.acjZ = new File(this.acjY, "fast_persist_data");
      AppMethodBeat.o(237927);
    }
    
    private Pair<String, File> btL(String paramString)
    {
      AppMethodBeat.i(237966);
      Object localObject1 = new ArrayList();
      File[] arrayOfFile = k.a.b.L(this.acjZ);
      int j = arrayOfFile.length;
      int i = 0;
      Object localObject2;
      if (i < j)
      {
        localObject2 = arrayOfFile[i];
        try
        {
          Object localObject3 = ((File)localObject2).getName();
          if ((((String)localObject3).startsWith(".FP")) && (((String)localObject3).contains("__KEY__")))
          {
            localObject3 = ((String)localObject3).substring(((String)localObject3).indexOf("__KEY__") + 7);
            if (((String)localObject3).contains("__VALUE__"))
            {
              if (((String)localObject3).substring(0, ((String)localObject3).indexOf("__VALUE__")).equals(paramString))
              {
                localObject3 = new Pair(((String)localObject3).substring(((String)localObject3).indexOf("__VALUE__") + 9), localObject2);
                paramString = ((List)localObject1).iterator();
                while (paramString.hasNext()) {
                  k.a.b.I((File)paramString.next());
                }
                AppMethodBeat.o(237966);
                return localObject3;
              }
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext()) {
                k.a.b.I((File)((Iterator)localObject2).next());
              }
            }
            ((List)localObject1).add(localObject2);
          }
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            k.a.b.I((File)((Iterator)localObject2).next());
          }
          try
          {
            k.b.w("MicroMsg.recovery.fastPersist", "find persist file fail", localThrowable);
            ((List)localObject1).add(localObject2);
            localObject2 = ((List)localObject1).iterator();
            if (((Iterator)localObject2).hasNext()) {
              k.a.b.I((File)((Iterator)localObject2).next());
            }
          }
          finally
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              k.a.b.I((File)((Iterator)localObject1).next());
            }
            AppMethodBeat.o(237966);
          }
        }
        finally {}
      }
      return null;
    }
    
    private void checkInit()
    {
      AppMethodBeat.i(237954);
      if (!this.acka.get())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(237954);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(237954);
    }
    
    private a cn(String paramString, long paramLong)
    {
      AppMethodBeat.i(237971);
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(237971);
      return this;
    }
    
    private a iQI()
    {
      AppMethodBeat.i(237935);
      try
      {
        Object localObject = this.acjZ;
        if (localObject == null)
        {
          localObject = new IOException("Dir is null.");
          AppMethodBeat.o(237935);
          throw ((Throwable)localObject);
        }
      }
      finally
      {
        k.b.w("MicroMsg.recovery.fastPersist", "create persist dir fail", localThrowable);
      }
      for (;;)
      {
        this.acka.set(true);
        AppMethodBeat.o(237935);
        return this;
        IOException localIOException;
        if (localThrowable.exists())
        {
          if (!localThrowable.isDirectory())
          {
            if (!k.a.b.I(localThrowable))
            {
              localIOException = new IOException("Fail to delete existing file, file = " + localThrowable.getAbsolutePath());
              AppMethodBeat.o(237935);
              throw localIOException;
            }
            localIOException.mkdir();
          }
        }
        else {
          while ((!localIOException.exists()) || (!localIOException.isDirectory()))
          {
            localIOException = new IOException("Fail to create dir, dir = " + localIOException.getAbsolutePath());
            AppMethodBeat.o(237935);
            throw localIOException;
            localIOException.mkdirs();
          }
        }
      }
    }
    
    /* Error */
    private a iQJ()
    {
      // Byte code:
      //   0: ldc 212
      //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokespecial 214	com/tencent/mm/recoveryv2/f$a:checkInit	()V
      //   9: aload_0
      //   10: getfield 50	com/tencent/mm/recoveryv2/f$a:mExtras	Landroid/os/Bundle;
      //   13: invokevirtual 218	android/os/Bundle:keySet	()Ljava/util/Set;
      //   16: invokeinterface 221 1 0
      //   21: astore_1
      //   22: aload_1
      //   23: invokeinterface 125 1 0
      //   28: ifeq +104 -> 132
      //   31: aload_1
      //   32: invokeinterface 129 1 0
      //   37: checkcast 81	java/lang/String
      //   40: astore_2
      //   41: aload_0
      //   42: getfield 50	com/tencent/mm/recoveryv2/f$a:mExtras	Landroid/os/Bundle;
      //   45: aload_2
      //   46: invokevirtual 224	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   49: astore_3
      //   50: aload_3
      //   51: ifnull -29 -> 22
      //   54: aload_0
      //   55: aload_2
      //   56: invokespecial 226	com/tencent/mm/recoveryv2/f$a:btL	(Ljava/lang/String;)Landroid/util/Pair;
      //   59: astore 4
      //   61: aload 4
      //   63: ifnull +15 -> 78
      //   66: aload 4
      //   68: getfield 230	android/util/Pair:second	Ljava/lang/Object;
      //   71: checkcast 18	java/io/File
      //   74: invokestatic 133	com/tencent/mm/recoveryv2/k$a$b:I	(Ljava/io/File;)Z
      //   77: pop
      //   78: new 18	java/io/File
      //   81: dup
      //   82: aload_0
      //   83: getfield 61	com/tencent/mm/recoveryv2/f$a:acjZ	Ljava/io/File;
      //   86: new 189	java/lang/StringBuilder
      //   89: dup
      //   90: ldc 232
      //   92: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   95: aload_2
      //   96: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: ldc 101
      //   101: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: aload_3
      //   105: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   108: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   111: invokespecial 27	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   114: invokestatic 238	com/tencent/mm/recoveryv2/k$a$b:K	(Ljava/io/File;)V
      //   117: goto -95 -> 22
      //   120: astore_2
      //   121: ldc 138
      //   123: ldc 240
      //   125: aload_2
      //   126: invokestatic 146	com/tencent/mm/recoveryv2/k$b:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   129: goto -107 -> 22
      //   132: ldc 212
      //   134: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   137: aload_0
      //   138: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	139	0	this	a
      //   21	11	1	localIterator	Iterator
      //   40	56	2	str	String
      //   120	6	2	localThrowable	Throwable
      //   49	56	3	localObject	Object
      //   59	8	4	localPair	Pair
      // Exception table:
      //   from	to	target	type
      //   78	117	120	finally
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(237978);
      checkInit();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(237978);
        return paramBoolean;
      }
      paramString = btL(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if ((paramString.equalsIgnoreCase("true")) || (paramString.equalsIgnoreCase("false")))
        {
          paramBoolean = Boolean.parseBoolean(paramString);
          AppMethodBeat.o(237978);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(237978);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(237982);
      paramInt = k.a.aL(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(237982);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(237989);
      checkInit();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(237989);
        return paramLong;
      }
      paramString = btL(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if (k.a.isNumeric(paramString)) {
          try
          {
            long l = Long.parseLong(paramString);
            AppMethodBeat.o(237989);
            return l;
          }
          finally {}
        }
      }
      AppMethodBeat.o(237989);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(237995);
      checkInit();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(237995);
        return paramString1;
      }
      paramString1 = btL(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (String)paramString1.first;
        AppMethodBeat.o(237995);
        return paramString1;
      }
      AppMethodBeat.o(237995);
      return paramString2;
    }
  }
  
  public static final class b
    implements f
  {
    private final String ackb;
    private SharedPreferences ackc;
    private final Context mContext;
    private final Bundle mExtras;
    
    public b(Context paramContext, String paramString)
    {
      AppMethodBeat.i(237921);
      this.mExtras = new Bundle();
      this.mContext = paramContext;
      this.ackb = paramString;
      AppMethodBeat.o(237921);
    }
    
    private static long a(SharedPreferences paramSharedPreferences, String paramString, long paramLong)
    {
      AppMethodBeat.i(237950);
      if (!paramSharedPreferences.contains(paramString))
      {
        AppMethodBeat.o(237950);
        return paramLong;
      }
      try
      {
        long l = paramSharedPreferences.getLong(paramString, paramLong);
        AppMethodBeat.o(237950);
        return l;
      }
      finally
      {
        try
        {
          int i = paramSharedPreferences.getInt(paramString, 0);
          paramLong = i;
          return paramLong;
        }
        finally
        {
          AppMethodBeat.o(237950);
        }
      }
      return paramLong;
    }
    
    private b co(String paramString, long paramLong)
    {
      AppMethodBeat.i(237942);
      iQL();
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(237942);
      return this;
    }
    
    private void iQL()
    {
      AppMethodBeat.i(237926);
      if (this.ackc == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(237926);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(237926);
    }
    
    /* Error */
    private android.content.SharedPreferences.Editor iQM()
    {
      // Byte code:
      //   0: ldc 80
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 70	com/tencent/mm/recoveryv2/f$b:ackc	Landroid/content/SharedPreferences;
      //   9: invokeinterface 83 1 0
      //   14: astore_1
      //   15: aload_0
      //   16: getfield 32	com/tencent/mm/recoveryv2/f$b:mExtras	Landroid/os/Bundle;
      //   19: invokevirtual 87	android/os/Bundle:keySet	()Ljava/util/Set;
      //   22: invokeinterface 93 1 0
      //   27: astore_2
      //   28: aload_2
      //   29: invokeinterface 99 1 0
      //   34: ifeq +112 -> 146
      //   37: aload_2
      //   38: invokeinterface 103 1 0
      //   43: checkcast 105	java/lang/String
      //   46: astore_3
      //   47: aload_0
      //   48: getfield 32	com/tencent/mm/recoveryv2/f$b:mExtras	Landroid/os/Bundle;
      //   51: aload_3
      //   52: invokevirtual 109	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   55: astore 4
      //   57: aload 4
      //   59: ifnull -31 -> 28
      //   62: aload 4
      //   64: invokevirtual 113	java/lang/Object:toString	()Ljava/lang/String;
      //   67: astore 4
      //   69: aload 4
      //   71: invokestatic 118	com/tencent/mm/recoveryv2/k$a:isNumeric	(Ljava/lang/String;)Z
      //   74: ifeq +23 -> 97
      //   77: aload_1
      //   78: aload_3
      //   79: aload 4
      //   81: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   84: invokeinterface 129 4 0
      //   89: pop
      //   90: goto -62 -> 28
      //   93: astore_3
      //   94: goto -66 -> 28
      //   97: aload 4
      //   99: ldc 131
      //   101: invokevirtual 134	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   104: ifne +13 -> 117
      //   107: aload 4
      //   109: ldc 136
      //   111: invokevirtual 134	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   114: ifeq +19 -> 133
      //   117: aload_1
      //   118: aload_3
      //   119: aload 4
      //   121: invokestatic 141	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
      //   124: invokeinterface 145 3 0
      //   129: pop
      //   130: goto -102 -> 28
      //   133: aload_1
      //   134: aload_3
      //   135: aload 4
      //   137: invokeinterface 149 3 0
      //   142: pop
      //   143: goto -115 -> 28
      //   146: ldc 80
      //   148: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   151: aload_1
      //   152: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	153	0	this	b
      //   14	138	1	localEditor	android.content.SharedPreferences.Editor
      //   27	11	2	localIterator	Iterator
      //   46	33	3	str1	String
      //   93	42	3	str2	String
      //   55	81	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   77	90	93	finally
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(237964);
      iQL();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(237964);
        return paramBoolean;
      }
      paramBoolean = this.ackc.getBoolean(paramString, paramBoolean);
      AppMethodBeat.o(237964);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(237970);
      paramInt = k.a.aL(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(237970);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(237975);
      iQL();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(237975);
        return paramLong;
      }
      paramLong = a(this.ackc, paramString, paramLong);
      AppMethodBeat.o(237975);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(237980);
      iQL();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(237980);
        return paramString1;
      }
      paramString1 = this.ackc.getString(paramString1, paramString2);
      AppMethodBeat.o(237980);
      return paramString1;
    }
    
    public final b iQK()
    {
      AppMethodBeat.i(237958);
      this.ackc = this.mContext.getSharedPreferences(this.ackb, 4);
      AppMethodBeat.o(237958);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.f
 * JD-Core Version:    0.7.0.1
 */
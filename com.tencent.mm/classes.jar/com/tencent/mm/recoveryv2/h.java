package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface h
{
  public abstract h btT(String paramString);
  
  public abstract h ca(String paramString, long paramLong);
  
  public abstract h dp(String paramString, boolean paramBoolean);
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract h hqf();
  
  public abstract h hqg();
  
  public abstract h hqh();
  
  public abstract h hu(String paramString, int paramInt);
  
  public abstract h nB(String paramString1, String paramString2);
  
  public static final class a
    implements h
  {
    final File UPh;
    final File UPi;
    private final AtomicBoolean UPj;
    private final Bundle mExtras;
    
    public a(Context paramContext, String paramString)
    {
      this(new File(m.jY(paramContext), paramString));
      AppMethodBeat.i(190021);
      AppMethodBeat.o(190021);
    }
    
    private a(File paramFile)
    {
      AppMethodBeat.i(190025);
      this.mExtras = new Bundle();
      this.UPj = new AtomicBoolean();
      this.UPh = paramFile;
      this.UPi = new File(this.UPh, "fast_persist_data");
      AppMethodBeat.o(190025);
    }
    
    private void bcM()
    {
      AppMethodBeat.i(190036);
      if (!this.UPj.get())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(190036);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(190036);
    }
    
    private Pair<String, File> btU(String paramString)
    {
      AppMethodBeat.i(190043);
      Object localObject1 = new ArrayList();
      File[] arrayOfFile = m.b.H(this.UPi);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = arrayOfFile[i];
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
                  m.b.E((File)paramString.next());
                }
                AppMethodBeat.o(190043);
                return localObject3;
              }
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext()) {
                m.b.E((File)((Iterator)localObject2).next());
              }
            }
            ((List)localObject1).add(localObject2);
          }
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            m.b.E((File)((Iterator)localObject2).next());
          }
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          a.w("MicroMsg.recovery.fastPersist", "find persist file fail", localThrowable);
          ((List)localObject1).add(localObject2);
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            m.b.E((File)((Iterator)localObject2).next());
          }
        }
        finally
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            m.b.E((File)((Iterator)localObject1).next());
          }
          AppMethodBeat.o(190043);
        }
      }
      AppMethodBeat.o(190043);
      return null;
    }
    
    private a cb(String paramString, long paramLong)
    {
      AppMethodBeat.i(190053);
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(190053);
      return this;
    }
    
    private a hqi()
    {
      AppMethodBeat.i(190030);
      try
      {
        Object localObject = this.UPi;
        if (localObject == null)
        {
          localObject = new IOException("Dir is null.");
          AppMethodBeat.o(190030);
          throw ((Throwable)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        a.w("MicroMsg.recovery.fastPersist", "create persist dir fail", localThrowable);
      }
      for (;;)
      {
        this.UPj.set(true);
        AppMethodBeat.o(190030);
        return this;
        IOException localIOException;
        if (localThrowable.exists())
        {
          if (!localThrowable.isDirectory())
          {
            if (!m.b.E(localThrowable))
            {
              localIOException = new IOException("Fail to delete existing file, file = " + localThrowable.getAbsolutePath());
              AppMethodBeat.o(190030);
              throw localIOException;
            }
            localIOException.mkdir();
          }
        }
        else {
          while ((!localIOException.exists()) || (!localIOException.isDirectory()))
          {
            localIOException = new IOException("Fail to create dir, dir = " + localIOException.getAbsolutePath());
            AppMethodBeat.o(190030);
            throw localIOException;
            localIOException.mkdirs();
          }
        }
      }
    }
    
    private a hqj()
    {
      AppMethodBeat.i(190031);
      bcM();
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mExtras.get(str);
        if (localObject != null)
        {
          Pair localPair = btU(str);
          if (localPair != null) {
            m.b.E((File)localPair.second);
          }
          try
          {
            m.b.G(new File(this.UPi, ".FP__KEY__" + str + "__VALUE__" + localObject));
          }
          catch (Throwable localThrowable)
          {
            a.w("MicroMsg.recovery.fastPersist", "create file pair store fail", localThrowable);
          }
        }
      }
      AppMethodBeat.o(190031);
      return this;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(190047);
      bcM();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(190047);
        return paramBoolean;
      }
      paramString = btU(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if ((paramString.equalsIgnoreCase("true")) || (paramString.equalsIgnoreCase("false")))
        {
          paramBoolean = Boolean.parseBoolean(paramString);
          AppMethodBeat.o(190047);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(190047);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(190049);
      paramInt = m.av(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(190049);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(190052);
      bcM();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(190052);
        return paramLong;
      }
      paramString = btU(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if (m.isNumeric(paramString)) {
          try
          {
            long l = Long.parseLong(paramString);
            AppMethodBeat.o(190052);
            return l;
          }
          catch (Throwable paramString) {}
        }
      }
      AppMethodBeat.o(190052);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190056);
      bcM();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(190056);
        return paramString1;
      }
      paramString1 = btU(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (String)paramString1.first;
        AppMethodBeat.o(190056);
        return paramString1;
      }
      AppMethodBeat.o(190056);
      return paramString2;
    }
  }
  
  public static final class b
    implements h
  {
    private final String UPk;
    private SharedPreferences UPl;
    private final Context mContext;
    private final Bundle mExtras;
    
    public b(Context paramContext, String paramString)
    {
      AppMethodBeat.i(190084);
      this.mExtras = new Bundle();
      this.mContext = paramContext;
      this.UPk = paramString;
      AppMethodBeat.o(190084);
    }
    
    private static long a(SharedPreferences paramSharedPreferences, String paramString, long paramLong)
    {
      AppMethodBeat.i(190110);
      if (!paramSharedPreferences.contains(paramString))
      {
        AppMethodBeat.o(190110);
        return paramLong;
      }
      try
      {
        long l = paramSharedPreferences.getLong(paramString, paramLong);
        AppMethodBeat.o(190110);
        return l;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          int i = paramSharedPreferences.getInt(paramString, 0);
          paramLong = i;
          AppMethodBeat.o(190110);
          return paramLong;
        }
        catch (Throwable paramSharedPreferences)
        {
          AppMethodBeat.o(190110);
        }
      }
      return paramLong;
    }
    
    private b cc(String paramString, long paramLong)
    {
      AppMethodBeat.i(190103);
      hql();
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(190103);
      return this;
    }
    
    private void hql()
    {
      AppMethodBeat.i(190087);
      if (this.UPl == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(190087);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(190087);
    }
    
    private SharedPreferences.Editor hqm()
    {
      AppMethodBeat.i(190092);
      SharedPreferences.Editor localEditor = this.UPl.edit();
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mExtras.get(str);
        if (localObject != null)
        {
          localObject = localObject.toString();
          if (m.isNumeric((String)localObject)) {
            try
            {
              localEditor.putLong(str, Long.parseLong((String)localObject));
            }
            catch (Throwable localThrowable) {}
          } else if ((((String)localObject).equalsIgnoreCase("true")) || (((String)localObject).equalsIgnoreCase("false"))) {
            localEditor.putBoolean(localThrowable, Boolean.parseBoolean((String)localObject));
          } else {
            localEditor.putString(localThrowable, (String)localObject);
          }
        }
      }
      AppMethodBeat.o(190092);
      return localEditor;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(190096);
      hql();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(190096);
        return paramBoolean;
      }
      paramBoolean = this.UPl.getBoolean(paramString, paramBoolean);
      AppMethodBeat.o(190096);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(190099);
      paramInt = m.av(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(190099);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(190102);
      hql();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(190102);
        return paramLong;
      }
      paramLong = a(this.UPl, paramString, paramLong);
      AppMethodBeat.o(190102);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190106);
      hql();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(190106);
        return paramString1;
      }
      paramString1 = this.UPl.getString(paramString1, paramString2);
      AppMethodBeat.o(190106);
      return paramString1;
    }
    
    public final b hqk()
    {
      AppMethodBeat.i(190086);
      this.UPl = this.mContext.getSharedPreferences(this.UPk, 4);
      AppMethodBeat.o(190086);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.h
 * JD-Core Version:    0.7.0.1
 */
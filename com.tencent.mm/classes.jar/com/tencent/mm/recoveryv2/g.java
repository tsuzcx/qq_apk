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

public abstract interface g
{
  public abstract g aPB(String paramString);
  
  public abstract g bR(String paramString, long paramLong);
  
  public abstract g cF(String paramString, boolean paramBoolean);
  
  public abstract g fhb();
  
  public abstract g fhc();
  
  public abstract g fhd();
  
  public abstract g ge(String paramString, int paramInt);
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract g lF(String paramString1, String paramString2);
  
  public static final class a
    implements g
  {
    final File HTZ;
    final File HUa;
    private final AtomicBoolean HUb;
    private final Bundle mExtras;
    
    public a(Context paramContext, String paramString)
    {
      this(new File(l.hV(paramContext), paramString));
      AppMethodBeat.i(206988);
      AppMethodBeat.o(206988);
    }
    
    private a(File paramFile)
    {
      AppMethodBeat.i(206989);
      this.mExtras = new Bundle();
      this.HUb = new AtomicBoolean();
      this.HTZ = paramFile;
      this.HUa = new File(this.HTZ, "fast_persist_data");
      AppMethodBeat.o(206989);
    }
    
    private Pair<String, File> aPC(String paramString)
    {
      AppMethodBeat.i(206993);
      Object localObject1 = new ArrayList();
      File[] arrayOfFile = l.b.O(this.HUa);
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
                  l.b.L((File)paramString.next());
                }
                AppMethodBeat.o(206993);
                return localObject3;
              }
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext()) {
                l.b.L((File)((Iterator)localObject2).next());
              }
            }
            ((List)localObject1).add(localObject2);
          }
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            l.b.L((File)((Iterator)localObject2).next());
          }
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          a.w("MicroMsg.recovery.fastPersist", "find persist file fail", localThrowable);
          ((List)localObject1).add(localObject2);
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            l.b.L((File)((Iterator)localObject2).next());
          }
        }
        finally
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            l.b.L((File)((Iterator)localObject1).next());
          }
          AppMethodBeat.o(206993);
        }
      }
      AppMethodBeat.o(206993);
      return null;
    }
    
    private a bS(String paramString, long paramLong)
    {
      AppMethodBeat.i(206997);
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(206997);
      return this;
    }
    
    private void ete()
    {
      AppMethodBeat.i(206992);
      if (!this.HUb.get())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(206992);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(206992);
    }
    
    private a fhe()
    {
      AppMethodBeat.i(206990);
      try
      {
        Object localObject = this.HUa;
        if (localObject == null)
        {
          localObject = new IOException("Dir is null.");
          AppMethodBeat.o(206990);
          throw ((Throwable)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        a.w("MicroMsg.recovery.fastPersist", "create persist dir fail", localThrowable);
      }
      for (;;)
      {
        this.HUb.set(true);
        AppMethodBeat.o(206990);
        return this;
        IOException localIOException;
        if (localThrowable.exists())
        {
          if (!localThrowable.isDirectory())
          {
            if (!l.b.L(localThrowable))
            {
              localIOException = new IOException("Fail to delete existing file, file = " + localThrowable.getAbsolutePath());
              AppMethodBeat.o(206990);
              throw localIOException;
            }
            localIOException.mkdir();
          }
        }
        else {
          while ((!localIOException.exists()) || (!localIOException.isDirectory()))
          {
            localIOException = new IOException("Fail to create dir, dir = " + localIOException.getAbsolutePath());
            AppMethodBeat.o(206990);
            throw localIOException;
            localIOException.mkdirs();
          }
        }
      }
    }
    
    private a fhf()
    {
      AppMethodBeat.i(206991);
      ete();
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mExtras.get(str);
        if (localObject != null)
        {
          Pair localPair = aPC(str);
          if (localPair != null) {
            l.b.L((File)localPair.second);
          }
          try
          {
            l.b.N(new File(this.HUa, ".FP__KEY__" + str + "__VALUE__" + localObject));
          }
          catch (Throwable localThrowable)
          {
            a.w("MicroMsg.recovery.fastPersist", "create file pair store fail", localThrowable);
          }
        }
      }
      AppMethodBeat.o(206991);
      return this;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(206994);
      ete();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(206994);
        return paramBoolean;
      }
      paramString = aPC(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if ((paramString.equalsIgnoreCase("true")) || (paramString.equalsIgnoreCase("false")))
        {
          paramBoolean = Boolean.parseBoolean(paramString);
          AppMethodBeat.o(206994);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(206994);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(206995);
      paramInt = l.aj(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(206995);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(206996);
      ete();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(206996);
        return paramLong;
      }
      paramString = aPC(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if (l.isNumeric(paramString)) {
          try
          {
            long l = Long.parseLong(paramString);
            AppMethodBeat.o(206996);
            return l;
          }
          catch (Throwable paramString) {}
        }
      }
      AppMethodBeat.o(206996);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(206998);
      ete();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(206998);
        return paramString1;
      }
      paramString1 = aPC(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (String)paramString1.first;
        AppMethodBeat.o(206998);
        return paramString1;
      }
      AppMethodBeat.o(206998);
      return paramString2;
    }
  }
  
  public static final class b
    implements g
  {
    private final String HUc;
    private SharedPreferences HUd;
    private final Context mContext;
    private final Bundle mExtras;
    
    public b(Context paramContext, String paramString)
    {
      AppMethodBeat.i(207007);
      this.mExtras = new Bundle();
      this.mContext = paramContext;
      this.HUc = paramString;
      AppMethodBeat.o(207007);
    }
    
    private static long a(SharedPreferences paramSharedPreferences, String paramString, long paramLong)
    {
      AppMethodBeat.i(207016);
      if (!paramSharedPreferences.contains(paramString))
      {
        AppMethodBeat.o(207016);
        return paramLong;
      }
      try
      {
        long l = paramSharedPreferences.getLong(paramString, paramLong);
        AppMethodBeat.o(207016);
        return l;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          int i = paramSharedPreferences.getInt(paramString, 0);
          paramLong = i;
          AppMethodBeat.o(207016);
          return paramLong;
        }
        catch (Throwable paramSharedPreferences)
        {
          AppMethodBeat.o(207016);
        }
      }
      return paramLong;
    }
    
    private b bT(String paramString, long paramLong)
    {
      AppMethodBeat.i(207014);
      fhh();
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(207014);
      return this;
    }
    
    private void fhh()
    {
      AppMethodBeat.i(207009);
      if (this.HUd == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(207009);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(207009);
    }
    
    private SharedPreferences.Editor fhi()
    {
      AppMethodBeat.i(207010);
      SharedPreferences.Editor localEditor = this.HUd.edit();
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mExtras.get(str);
        if (localObject != null)
        {
          localObject = localObject.toString();
          if (l.isNumeric((String)localObject)) {
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
      AppMethodBeat.o(207010);
      return localEditor;
    }
    
    public final b fhg()
    {
      AppMethodBeat.i(207008);
      this.HUd = this.mContext.getSharedPreferences(this.HUc, 4);
      AppMethodBeat.o(207008);
      return this;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(207011);
      fhh();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(207011);
        return paramBoolean;
      }
      paramBoolean = this.HUd.getBoolean(paramString, paramBoolean);
      AppMethodBeat.o(207011);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(207012);
      paramInt = l.aj(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(207012);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(207013);
      fhh();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(207013);
        return paramLong;
      }
      paramLong = a(this.HUd, paramString, paramLong);
      AppMethodBeat.o(207013);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(207015);
      fhh();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(207015);
        return paramString1;
      }
      paramString1 = this.HUd.getString(paramString1, paramString2);
      AppMethodBeat.o(207015);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.g
 * JD-Core Version:    0.7.0.1
 */
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
  public abstract g bT(String paramString, long paramLong);
  
  public abstract g bhB(String paramString);
  
  public abstract g de(String paramString, boolean paramBoolean);
  
  public abstract g gL(String paramString, int paramInt);
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract g guE();
  
  public abstract g guF();
  
  public abstract g guG();
  
  public abstract g mK(String paramString1, String paramString2);
  
  public static final class a
    implements g
  {
    final File NBF;
    final File NBG;
    private final AtomicBoolean NBH;
    private final Bundle mExtras;
    
    public a(Context paramContext, String paramString)
    {
      this(new File(l.iU(paramContext), paramString));
      AppMethodBeat.i(193784);
      AppMethodBeat.o(193784);
    }
    
    private a(File paramFile)
    {
      AppMethodBeat.i(193785);
      this.mExtras = new Bundle();
      this.NBH = new AtomicBoolean();
      this.NBF = paramFile;
      this.NBG = new File(this.NBF, "fast_persist_data");
      AppMethodBeat.o(193785);
    }
    
    private void aTL()
    {
      AppMethodBeat.i(193788);
      if (!this.NBH.get())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(193788);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(193788);
    }
    
    private a bU(String paramString, long paramLong)
    {
      AppMethodBeat.i(193793);
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(193793);
      return this;
    }
    
    private Pair<String, File> bhC(String paramString)
    {
      AppMethodBeat.i(193789);
      Object localObject1 = new ArrayList();
      File[] arrayOfFile = l.b.P(this.NBG);
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
                  l.b.M((File)paramString.next());
                }
                AppMethodBeat.o(193789);
                return localObject3;
              }
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext()) {
                l.b.M((File)((Iterator)localObject2).next());
              }
            }
            ((List)localObject1).add(localObject2);
          }
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            l.b.M((File)((Iterator)localObject2).next());
          }
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          a.w("MicroMsg.recovery.fastPersist", "find persist file fail", localThrowable);
          ((List)localObject1).add(localObject2);
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            l.b.M((File)((Iterator)localObject2).next());
          }
        }
        finally
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            l.b.M((File)((Iterator)localObject1).next());
          }
          AppMethodBeat.o(193789);
        }
      }
      AppMethodBeat.o(193789);
      return null;
    }
    
    private a guH()
    {
      AppMethodBeat.i(193786);
      try
      {
        Object localObject = this.NBG;
        if (localObject == null)
        {
          localObject = new IOException("Dir is null.");
          AppMethodBeat.o(193786);
          throw ((Throwable)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        a.w("MicroMsg.recovery.fastPersist", "create persist dir fail", localThrowable);
      }
      for (;;)
      {
        this.NBH.set(true);
        AppMethodBeat.o(193786);
        return this;
        IOException localIOException;
        if (localThrowable.exists())
        {
          if (!localThrowable.isDirectory())
          {
            if (!l.b.M(localThrowable))
            {
              localIOException = new IOException("Fail to delete existing file, file = " + localThrowable.getAbsolutePath());
              AppMethodBeat.o(193786);
              throw localIOException;
            }
            localIOException.mkdir();
          }
        }
        else {
          while ((!localIOException.exists()) || (!localIOException.isDirectory()))
          {
            localIOException = new IOException("Fail to create dir, dir = " + localIOException.getAbsolutePath());
            AppMethodBeat.o(193786);
            throw localIOException;
            localIOException.mkdirs();
          }
        }
      }
    }
    
    private a guI()
    {
      AppMethodBeat.i(193787);
      aTL();
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mExtras.get(str);
        if (localObject != null)
        {
          Pair localPair = bhC(str);
          if (localPair != null) {
            l.b.M((File)localPair.second);
          }
          try
          {
            l.b.O(new File(this.NBG, ".FP__KEY__" + str + "__VALUE__" + localObject));
          }
          catch (Throwable localThrowable)
          {
            a.w("MicroMsg.recovery.fastPersist", "create file pair store fail", localThrowable);
          }
        }
      }
      AppMethodBeat.o(193787);
      return this;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193790);
      aTL();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(193790);
        return paramBoolean;
      }
      paramString = bhC(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if ((paramString.equalsIgnoreCase("true")) || (paramString.equalsIgnoreCase("false")))
        {
          paramBoolean = Boolean.parseBoolean(paramString);
          AppMethodBeat.o(193790);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(193790);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(193791);
      paramInt = l.am(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(193791);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(193792);
      aTL();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(193792);
        return paramLong;
      }
      paramString = bhC(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if (l.isNumeric(paramString)) {
          try
          {
            long l = Long.parseLong(paramString);
            AppMethodBeat.o(193792);
            return l;
          }
          catch (Throwable paramString) {}
        }
      }
      AppMethodBeat.o(193792);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(193794);
      aTL();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(193794);
        return paramString1;
      }
      paramString1 = bhC(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (String)paramString1.first;
        AppMethodBeat.o(193794);
        return paramString1;
      }
      AppMethodBeat.o(193794);
      return paramString2;
    }
  }
  
  public static final class b
    implements g
  {
    private final String NBI;
    private SharedPreferences NBJ;
    private final Context mContext;
    private final Bundle mExtras;
    
    public b(Context paramContext, String paramString)
    {
      AppMethodBeat.i(193803);
      this.mExtras = new Bundle();
      this.mContext = paramContext;
      this.NBI = paramString;
      AppMethodBeat.o(193803);
    }
    
    private static long a(SharedPreferences paramSharedPreferences, String paramString, long paramLong)
    {
      AppMethodBeat.i(193812);
      if (!paramSharedPreferences.contains(paramString))
      {
        AppMethodBeat.o(193812);
        return paramLong;
      }
      try
      {
        long l = paramSharedPreferences.getLong(paramString, paramLong);
        AppMethodBeat.o(193812);
        return l;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          int i = paramSharedPreferences.getInt(paramString, 0);
          paramLong = i;
          AppMethodBeat.o(193812);
          return paramLong;
        }
        catch (Throwable paramSharedPreferences)
        {
          AppMethodBeat.o(193812);
        }
      }
      return paramLong;
    }
    
    private b bV(String paramString, long paramLong)
    {
      AppMethodBeat.i(193810);
      guK();
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(193810);
      return this;
    }
    
    private void guK()
    {
      AppMethodBeat.i(193805);
      if (this.NBJ == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(193805);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(193805);
    }
    
    private SharedPreferences.Editor guL()
    {
      AppMethodBeat.i(193806);
      SharedPreferences.Editor localEditor = this.NBJ.edit();
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
      AppMethodBeat.o(193806);
      return localEditor;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193807);
      guK();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(193807);
        return paramBoolean;
      }
      paramBoolean = this.NBJ.getBoolean(paramString, paramBoolean);
      AppMethodBeat.o(193807);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(193808);
      paramInt = l.am(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(193808);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(193809);
      guK();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(193809);
        return paramLong;
      }
      paramLong = a(this.NBJ, paramString, paramLong);
      AppMethodBeat.o(193809);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(193811);
      guK();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(193811);
        return paramString1;
      }
      paramString1 = this.NBJ.getString(paramString1, paramString2);
      AppMethodBeat.o(193811);
      return paramString1;
    }
    
    public final b guJ()
    {
      AppMethodBeat.i(193804);
      this.NBJ = this.mContext.getSharedPreferences(this.NBI, 4);
      AppMethodBeat.o(193804);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.g
 * JD-Core Version:    0.7.0.1
 */
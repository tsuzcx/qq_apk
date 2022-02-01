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
  public abstract g aQY(String paramString);
  
  public abstract g bS(String paramString, long paramLong);
  
  public abstract g cJ(String paramString, boolean paramBoolean);
  
  public abstract g fkT();
  
  public abstract g fkU();
  
  public abstract g fkV();
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract g gn(String paramString, int paramInt);
  
  public abstract g lM(String paramString1, String paramString2);
  
  public static final class a
    implements g
  {
    final File Ioh;
    final File Ioi;
    private final AtomicBoolean Ioj;
    private final Bundle mExtras;
    
    public a(Context paramContext, String paramString)
    {
      this(new File(l.ib(paramContext), paramString));
      AppMethodBeat.i(195296);
      AppMethodBeat.o(195296);
    }
    
    private a(File paramFile)
    {
      AppMethodBeat.i(195297);
      this.mExtras = new Bundle();
      this.Ioj = new AtomicBoolean();
      this.Ioh = paramFile;
      this.Ioi = new File(this.Ioh, "fast_persist_data");
      AppMethodBeat.o(195297);
    }
    
    private Pair<String, File> aQZ(String paramString)
    {
      AppMethodBeat.i(195301);
      Object localObject1 = new ArrayList();
      File[] arrayOfFile = l.b.O(this.Ioi);
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
                AppMethodBeat.o(195301);
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
          AppMethodBeat.o(195301);
        }
      }
      AppMethodBeat.o(195301);
      return null;
    }
    
    private a bT(String paramString, long paramLong)
    {
      AppMethodBeat.i(195305);
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(195305);
      return this;
    }
    
    private void ewL()
    {
      AppMethodBeat.i(195300);
      if (!this.Ioj.get())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(195300);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(195300);
    }
    
    private a fkW()
    {
      AppMethodBeat.i(195298);
      try
      {
        Object localObject = this.Ioi;
        if (localObject == null)
        {
          localObject = new IOException("Dir is null.");
          AppMethodBeat.o(195298);
          throw ((Throwable)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        a.w("MicroMsg.recovery.fastPersist", "create persist dir fail", localThrowable);
      }
      for (;;)
      {
        this.Ioj.set(true);
        AppMethodBeat.o(195298);
        return this;
        IOException localIOException;
        if (localThrowable.exists())
        {
          if (!localThrowable.isDirectory())
          {
            if (!l.b.L(localThrowable))
            {
              localIOException = new IOException("Fail to delete existing file, file = " + localThrowable.getAbsolutePath());
              AppMethodBeat.o(195298);
              throw localIOException;
            }
            localIOException.mkdir();
          }
        }
        else {
          while ((!localIOException.exists()) || (!localIOException.isDirectory()))
          {
            localIOException = new IOException("Fail to create dir, dir = " + localIOException.getAbsolutePath());
            AppMethodBeat.o(195298);
            throw localIOException;
            localIOException.mkdirs();
          }
        }
      }
    }
    
    private a fkX()
    {
      AppMethodBeat.i(195299);
      ewL();
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mExtras.get(str);
        if (localObject != null)
        {
          Pair localPair = aQZ(str);
          if (localPair != null) {
            l.b.L((File)localPair.second);
          }
          try
          {
            l.b.N(new File(this.Ioi, ".FP__KEY__" + str + "__VALUE__" + localObject));
          }
          catch (Throwable localThrowable)
          {
            a.w("MicroMsg.recovery.fastPersist", "create file pair store fail", localThrowable);
          }
        }
      }
      AppMethodBeat.o(195299);
      return this;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(195302);
      ewL();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(195302);
        return paramBoolean;
      }
      paramString = aQZ(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if ((paramString.equalsIgnoreCase("true")) || (paramString.equalsIgnoreCase("false")))
        {
          paramBoolean = Boolean.parseBoolean(paramString);
          AppMethodBeat.o(195302);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(195302);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(195303);
      paramInt = l.aj(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(195303);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(195304);
      ewL();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(195304);
        return paramLong;
      }
      paramString = aQZ(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if (l.isNumeric(paramString)) {
          try
          {
            long l = Long.parseLong(paramString);
            AppMethodBeat.o(195304);
            return l;
          }
          catch (Throwable paramString) {}
        }
      }
      AppMethodBeat.o(195304);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195306);
      ewL();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(195306);
        return paramString1;
      }
      paramString1 = aQZ(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (String)paramString1.first;
        AppMethodBeat.o(195306);
        return paramString1;
      }
      AppMethodBeat.o(195306);
      return paramString2;
    }
  }
  
  public static final class b
    implements g
  {
    private final String Iok;
    private SharedPreferences Iol;
    private final Context mContext;
    private final Bundle mExtras;
    
    public b(Context paramContext, String paramString)
    {
      AppMethodBeat.i(195315);
      this.mExtras = new Bundle();
      this.mContext = paramContext;
      this.Iok = paramString;
      AppMethodBeat.o(195315);
    }
    
    private static long a(SharedPreferences paramSharedPreferences, String paramString, long paramLong)
    {
      AppMethodBeat.i(195324);
      if (!paramSharedPreferences.contains(paramString))
      {
        AppMethodBeat.o(195324);
        return paramLong;
      }
      try
      {
        long l = paramSharedPreferences.getLong(paramString, paramLong);
        AppMethodBeat.o(195324);
        return l;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          int i = paramSharedPreferences.getInt(paramString, 0);
          paramLong = i;
          AppMethodBeat.o(195324);
          return paramLong;
        }
        catch (Throwable paramSharedPreferences)
        {
          AppMethodBeat.o(195324);
        }
      }
      return paramLong;
    }
    
    private b bU(String paramString, long paramLong)
    {
      AppMethodBeat.i(195322);
      fkZ();
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(195322);
      return this;
    }
    
    private void fkZ()
    {
      AppMethodBeat.i(195317);
      if (this.Iol == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(195317);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(195317);
    }
    
    private SharedPreferences.Editor fla()
    {
      AppMethodBeat.i(195318);
      SharedPreferences.Editor localEditor = this.Iol.edit();
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
      AppMethodBeat.o(195318);
      return localEditor;
    }
    
    public final b fkY()
    {
      AppMethodBeat.i(195316);
      this.Iol = this.mContext.getSharedPreferences(this.Iok, 4);
      AppMethodBeat.o(195316);
      return this;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(195319);
      fkZ();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(195319);
        return paramBoolean;
      }
      paramBoolean = this.Iol.getBoolean(paramString, paramBoolean);
      AppMethodBeat.o(195319);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(195320);
      paramInt = l.aj(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(195320);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(195321);
      fkZ();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(195321);
        return paramLong;
      }
      paramLong = a(this.Iol, paramString, paramLong);
      AppMethodBeat.o(195321);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195323);
      fkZ();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(195323);
        return paramString1;
      }
      paramString1 = this.Iol.getString(paramString1, paramString2);
      AppMethodBeat.o(195323);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.g
 * JD-Core Version:    0.7.0.1
 */
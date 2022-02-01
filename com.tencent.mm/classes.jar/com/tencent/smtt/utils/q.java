package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class q
{
  private b a = null;
  private b b = null;
  
  private boolean a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(219364);
    TbsLog.d("TbsCopyVerify", "equal");
    if ((paramb1 != null) && (paramb1.a() != null) && (paramb2 != null) && (paramb2.a() != null))
    {
      Object localObject1 = paramb1.a();
      paramb1 = paramb2.a();
      paramb2 = ((Map)localObject1).entrySet().iterator();
      while (paramb2.hasNext())
      {
        Object localObject2 = (Map.Entry)paramb2.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (a)((Map.Entry)localObject2).getValue();
        if (paramb1.containsKey(localObject1))
        {
          localObject1 = (a)paramb1.get(localObject1);
          if ((((a)localObject2).a() != ((a)localObject1).a()) || (((a)localObject2).b() != ((a)localObject1).b()))
          {
            AppMethodBeat.o(219364);
            return false;
          }
        }
        else
        {
          AppMethodBeat.o(219364);
          return false;
        }
      }
      AppMethodBeat.o(219364);
      return true;
    }
    AppMethodBeat.o(219364);
    return false;
  }
  
  public void a(File paramFile)
  {
    AppMethodBeat.i(219367);
    this.a = new b(paramFile);
    AppMethodBeat.o(219367);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(219374);
    TbsLog.d("TbsCopyVerify", "verify");
    if ((this.b == null) || (this.a == null))
    {
      AppMethodBeat.o(219374);
      return false;
    }
    if ((this.b.a().size() == this.a.a().size()) && (a(this.a, this.b)))
    {
      TbsLog.d("TbsCopyVerify", "verify Yes!");
      AppMethodBeat.o(219374);
      return true;
    }
    TbsLog.d("TbsCopyVerify", "verify No!");
    AppMethodBeat.o(219374);
    return false;
  }
  
  public void b(File paramFile)
  {
    AppMethodBeat.i(219369);
    this.b = new b(paramFile);
    AppMethodBeat.o(219369);
  }
  
  class a
  {
    private String b;
    private long c;
    private long d;
    
    a(String paramString, long paramLong1, long paramLong2)
    {
      this.b = paramString;
      this.c = paramLong1;
      this.d = paramLong2;
    }
    
    long a()
    {
      return this.c;
    }
    
    long b()
    {
      return this.d;
    }
  }
  
  class b
  {
    private Map<String, q.a> b;
    
    b(File paramFile)
    {
      AppMethodBeat.i(219355);
      this.b = new HashMap();
      this.b.clear();
      a(paramFile);
      AppMethodBeat.o(219355);
    }
    
    private void a(File paramFile)
    {
      AppMethodBeat.i(219359);
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        if ((paramFile == null) && (Build.VERSION.SDK_INT >= 26))
        {
          AppMethodBeat.o(219359);
          return;
        }
        TbsLog.d("TbsCopyVerify", "generateFileInfo len=" + paramFile.length);
        int i = 0;
        while (i < paramFile.length)
        {
          a(paramFile[i]);
          i += 1;
        }
        AppMethodBeat.o(219359);
        return;
      }
      if (paramFile.isFile()) {
        a(paramFile.getName(), paramFile.length(), paramFile.lastModified());
      }
      AppMethodBeat.o(219359);
    }
    
    private void a(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(219362);
      TbsLog.d("TbsCopyVerify", "generateFileInfo name=" + paramString + ",fileSize=" + paramLong1 + ",lastModify=" + paramLong2);
      if ((paramString != null) && (paramString.length() > 0) && (paramLong1 > 0L) && (paramLong2 > 0L))
      {
        q.a locala = new q.a(q.this, paramString, paramLong1, paramLong2);
        if (!this.b.containsKey(paramString)) {
          this.b.put(paramString, locala);
        }
      }
      AppMethodBeat.o(219362);
    }
    
    Map<String, q.a> a()
    {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.q
 * JD-Core Version:    0.7.0.1
 */
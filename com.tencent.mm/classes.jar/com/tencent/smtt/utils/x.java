package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class x
{
  private b a = null;
  private b b = null;
  
  private boolean a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(65320);
    if ((paramb1 != null) && (paramb1.a() != null) && (paramb2 != null) && (paramb2.a() != null))
    {
      Object localObject1 = paramb1.a();
      paramb1 = paramb2.a();
      paramb2 = ((Map)localObject1).entrySet().iterator();
      while (paramb2.hasNext())
      {
        Object localObject2 = (Map.Entry)paramb2.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (x.a)((Map.Entry)localObject2).getValue();
        if (paramb1.containsKey(localObject1))
        {
          localObject1 = (x.a)paramb1.get(localObject1);
          if ((((x.a)localObject2).a() != ((x.a)localObject1).a()) || (((x.a)localObject2).b() != ((x.a)localObject1).b()))
          {
            AppMethodBeat.o(65320);
            return false;
          }
        }
        else
        {
          AppMethodBeat.o(65320);
          return false;
        }
      }
      AppMethodBeat.o(65320);
      return true;
    }
    AppMethodBeat.o(65320);
    return false;
  }
  
  public void a(File paramFile)
  {
    AppMethodBeat.i(65317);
    this.a = new b(paramFile);
    AppMethodBeat.o(65317);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(65319);
    if ((this.b == null) || (this.a == null))
    {
      AppMethodBeat.o(65319);
      return false;
    }
    if ((this.b.a().size() == this.a.a().size()) && (a(this.a, this.b)))
    {
      AppMethodBeat.o(65319);
      return true;
    }
    AppMethodBeat.o(65319);
    return false;
  }
  
  public void b(File paramFile)
  {
    AppMethodBeat.i(65318);
    this.b = new b(paramFile);
    AppMethodBeat.o(65318);
  }
  
  class b
  {
    private Map<String, x.a> b;
    
    b(File paramFile)
    {
      AppMethodBeat.i(65314);
      this.b = new HashMap();
      this.b.clear();
      a(paramFile);
      AppMethodBeat.o(65314);
    }
    
    private void a(File paramFile)
    {
      AppMethodBeat.i(65315);
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        if ((paramFile == null) && (Build.VERSION.SDK_INT >= 26))
        {
          AppMethodBeat.o(65315);
          return;
        }
        int i = 0;
        while (i < paramFile.length)
        {
          a(paramFile[i]);
          i += 1;
        }
        AppMethodBeat.o(65315);
        return;
      }
      if (paramFile.isFile()) {
        a(paramFile.getName(), paramFile.length(), paramFile.lastModified());
      }
      AppMethodBeat.o(65315);
    }
    
    private void a(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(65316);
      if ((paramString != null) && (paramString.length() > 0) && (paramLong1 > 0L) && (paramLong2 > 0L))
      {
        x.a locala = new x.a(x.this, paramString, paramLong1, paramLong2);
        if (!this.b.containsKey(paramString)) {
          this.b.put(paramString, locala);
        }
      }
      AppMethodBeat.o(65316);
    }
    
    Map<String, x.a> a()
    {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.x
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class bd
{
  private List<String> a;
  private List<String> b;
  private final int c;
  
  public bd()
  {
    AppMethodBeat.i(149816);
    this.a = new ArrayList();
    this.b = new ArrayList();
    this.c = 300;
    AppMethodBeat.o(149816);
  }
  
  private void a(List<String> paramList)
  {
    AppMethodBeat.i(149818);
    if (paramList == null)
    {
      AppMethodBeat.o(149818);
      return;
    }
    if (paramList.size() <= 300)
    {
      AppMethodBeat.o(149818);
      return;
    }
    paramList.remove(0);
    AppMethodBeat.o(149818);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(149817);
        if ((paramString == null) || (paramString.trim().length() == 0))
        {
          AppMethodBeat.o(149817);
          return bool;
        }
        if (this.b.contains(paramString))
        {
          AppMethodBeat.o(149817);
          continue;
        }
        bool = true;
      }
      finally {}
      AppMethodBeat.o(149817);
    }
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(149819);
        if ((paramString == null) || (paramString.trim().length() == 0))
        {
          AppMethodBeat.o(149819);
          return;
        }
        if (this.b.contains(paramString))
        {
          this.b.remove(paramString);
          this.b.add(paramString);
          AppMethodBeat.o(149819);
          continue;
        }
        if (!this.a.contains(paramString)) {
          break label128;
        }
      }
      finally {}
      a(this.b);
      this.b.add(paramString);
      this.a.remove(paramString);
      AppMethodBeat.o(149819);
      continue;
      label128:
      a(this.a);
      this.a.add(paramString);
      AppMethodBeat.o(149819);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bd
 * JD-Core Version:    0.7.0.1
 */
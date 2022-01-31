package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class au$a
{
  public String a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  private String[] h;
  
  public au$a(au paramau, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(147247);
    this.b = true;
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.a = paramString1;
    paramau = paramString1.split("-");
    if (paramau.length < 5)
    {
      this.h = new String[] { "all", "all", "all", "all", "all" };
      int i = 0;
      while (i < paramau.length)
      {
        this.h[i] = paramau[i];
        i += 1;
      }
    }
    this.h = paramau;
    this.c = a(0, String.valueOf(paramInt));
    this.d = a(1, paramString2);
    this.e = a(2, paramString3);
    this.f = a(3, paramString4);
    this.g = a(4, paramString5);
    this.h = null;
    AppMethodBeat.o(147247);
  }
  
  private boolean a(int paramInt, String paramString)
  {
    AppMethodBeat.i(147248);
    boolean bool2;
    if (this.h.length >= paramInt + 1)
    {
      bool2 = this.h[paramInt].equals(paramString);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.h[paramInt].equals("all")) {
          this.b = false;
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      AppMethodBeat.o(147248);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.au.a
 * JD-Core Version:    0.7.0.1
 */
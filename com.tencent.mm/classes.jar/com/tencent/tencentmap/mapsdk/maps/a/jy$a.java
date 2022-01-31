package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

class jy$a
{
  private Bitmap a;
  private TextPaint b;
  private int c;
  private int d;
  private int e;
  private HashMap<String, Integer> f;
  
  private jy$a()
  {
    AppMethodBeat.i(148853);
    this.a = null;
    this.b = null;
    this.c = 900;
    this.d = 180;
    this.e = -1;
    this.f = new HashMap();
    AppMethodBeat.o(148853);
  }
  
  void a()
  {
    AppMethodBeat.i(148854);
    if ((this.a != null) && (!this.a.isRecycled()))
    {
      this.a.recycle();
      this.a = null;
    }
    AppMethodBeat.o(148854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jy.a
 * JD-Core Version:    0.7.0.1
 */
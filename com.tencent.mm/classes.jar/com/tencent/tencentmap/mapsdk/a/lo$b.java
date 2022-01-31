package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.text.TextPaint;
import java.util.HashMap;

class lo$b
{
  private Bitmap a = null;
  private TextPaint b = null;
  private int c = 900;
  private int d = 180;
  private int e = -1;
  private HashMap<String, Integer> f = new HashMap();
  
  void a()
  {
    if ((this.a != null) && (!this.a.isRecycled()))
    {
      this.a.recycle();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lo.b
 * JD-Core Version:    0.7.0.1
 */
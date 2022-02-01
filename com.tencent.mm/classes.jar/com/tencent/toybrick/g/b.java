package com.tencent.toybrick.g;

import android.graphics.drawable.Drawable;
import com.tencent.toybrick.c.f;

public abstract interface b<R, T extends f>
{
  public abstract R hpL();
  
  public static abstract class a<T extends f>
    implements b<Boolean, T>
  {}
  
  public static abstract class b<T extends f>
    implements b<Drawable, T>
  {}
  
  public static abstract class c<T extends f>
    implements b<Integer, T>
  {}
  
  public static abstract class d<T extends f>
    implements b<CharSequence, T>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.g.b
 * JD-Core Version:    0.7.0.1
 */
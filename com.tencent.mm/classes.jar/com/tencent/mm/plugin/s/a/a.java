package com.tencent.mm.plugin.s.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import java.util.LinkedList;

public abstract interface a
{
  public abstract Cursor C(int[] paramArrayOfInt);
  
  public abstract Bitmap a(String paramString, int paramInt, float paramFloat);
  
  public abstract void aA(LinkedList<String> paramLinkedList);
  
  public abstract g ajX(String paramString);
  
  public abstract g ajY(String paramString);
  
  public abstract void ajZ(String paramString);
  
  public abstract Cursor cZU();
  
  public abstract j cZV();
  
  public abstract Cursor cZW();
  
  public abstract void e(g paramg);
  
  public abstract void ec(String paramString, int paramInt);
  
  public abstract void f(g paramg);
  
  public abstract void g(g paramg);
  
  public abstract Cursor gv(int paramInt1, int paramInt2);
  
  public static final class a
  {
    private static a unE = null;
    
    public static void a(a parama)
    {
      unE = parama;
    }
    
    public static a cZX()
    {
      return unE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a.a
 * JD-Core Version:    0.7.0.1
 */
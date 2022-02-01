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
  
  public abstract void aI(LinkedList<String> paramLinkedList);
  
  public abstract g atV(String paramString);
  
  public abstract g atW(String paramString);
  
  public abstract void atX(String paramString);
  
  public abstract Cursor dxU();
  
  public abstract j dxV();
  
  public abstract Cursor dxW();
  
  public abstract void e(g paramg);
  
  public abstract void eB(String paramString, int paramInt);
  
  public abstract void f(g paramg);
  
  public abstract void g(g paramg);
  
  public abstract Cursor gU(int paramInt1, int paramInt2);
  
  public static final class a
  {
    private static a wBU = null;
    
    public static void a(a parama)
    {
      wBU = parama;
    }
    
    public static a dxX()
    {
      return wBU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a.a
 * JD-Core Version:    0.7.0.1
 */
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
  
  public abstract void aH(LinkedList<String> paramLinkedList);
  
  public abstract g aoV(String paramString);
  
  public abstract g aoW(String paramString);
  
  public abstract void aoX(String paramString);
  
  public abstract Cursor dnC();
  
  public abstract j dnD();
  
  public abstract Cursor dnE();
  
  public abstract void e(g paramg);
  
  public abstract void ej(String paramString, int paramInt);
  
  public abstract void f(g paramg);
  
  public abstract void g(g paramg);
  
  public abstract Cursor gC(int paramInt1, int paramInt2);
  
  public static final class a
  {
    private static a vwA = null;
    
    public static void a(a parama)
    {
      vwA = parama;
    }
    
    public static a dnF()
    {
      return vwA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a.a
 * JD-Core Version:    0.7.0.1
 */
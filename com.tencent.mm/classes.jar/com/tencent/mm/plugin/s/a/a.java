package com.tencent.mm.plugin.s.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import java.util.LinkedList;

public abstract interface a
{
  public abstract Cursor D(int[] paramArrayOfInt);
  
  public abstract Bitmap a(String paramString, int paramInt, float paramFloat);
  
  public abstract void aJ(LinkedList<String> paramLinkedList);
  
  public abstract g avk(String paramString);
  
  public abstract g avl(String paramString);
  
  public abstract void avm(String paramString);
  
  public abstract Cursor dBk();
  
  public abstract j dBl();
  
  public abstract Cursor dBm();
  
  public abstract void e(g paramg);
  
  public abstract void eJ(String paramString, int paramInt);
  
  public abstract void f(g paramg);
  
  public abstract void g(g paramg);
  
  public abstract Cursor gV(int paramInt1, int paramInt2);
  
  public static final class a
  {
    private static a wRF = null;
    
    public static void a(a parama)
    {
      wRF = parama;
    }
    
    public static a dBn()
    {
      return wRF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a.a
 * JD-Core Version:    0.7.0.1
 */
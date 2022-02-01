package com.tencent.mm.plugin.r.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import java.util.LinkedList;

public abstract interface a
{
  public abstract Cursor H(int[] paramArrayOfInt);
  
  public abstract Bitmap a(String paramString, int paramInt, float paramFloat);
  
  public abstract g aJw(String paramString);
  
  public abstract g aJx(String paramString);
  
  public abstract String aJy(String paramString);
  
  public abstract void aJz(String paramString);
  
  public abstract void bg(LinkedList<String> paramLinkedList);
  
  public abstract void e(g paramg);
  
  public abstract Cursor eAW();
  
  public abstract j eAX();
  
  public abstract Cursor eAY();
  
  public abstract void eZ(String paramString, int paramInt);
  
  public abstract void f(g paramg);
  
  public abstract void g(g paramg);
  
  public abstract Cursor hG(int paramInt1, int paramInt2);
  
  public static final class a
  {
    private static a ANA = null;
    
    public static void a(a parama)
    {
      ANA = parama;
    }
    
    public static a eAZ()
    {
      return ANA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.r.a.a
 * JD-Core Version:    0.7.0.1
 */
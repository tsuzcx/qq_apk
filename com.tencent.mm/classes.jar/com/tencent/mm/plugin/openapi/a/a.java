package com.tencent.mm.plugin.openapi.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import java.util.LinkedList;

public abstract interface a
{
  public abstract Cursor K(int[] paramArrayOfInt);
  
  public abstract Bitmap a(String paramString, int paramInt, float paramFloat);
  
  public abstract g aQY(String paramString);
  
  public abstract g aQZ(String paramString);
  
  public abstract String aRa(String paramString);
  
  public abstract void aRb(String paramString);
  
  public abstract void bJ(LinkedList<String> paramLinkedList);
  
  public abstract void e(g paramg);
  
  public abstract void f(g paramg);
  
  public abstract void g(g paramg);
  
  public abstract void gt(String paramString, int paramInt);
  
  public abstract Cursor gxr();
  
  public abstract j gxs();
  
  public abstract Cursor gxt();
  
  public abstract Cursor kr(int paramInt1, int paramInt2);
  
  public static final class a
  {
    private static a MDF = null;
    
    public static void a(a parama)
    {
      MDF = parama;
    }
    
    public static a gxu()
    {
      return MDF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.openapi.a.a
 * JD-Core Version:    0.7.0.1
 */
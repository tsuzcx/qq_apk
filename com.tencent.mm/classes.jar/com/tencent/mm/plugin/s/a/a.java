package com.tencent.mm.plugin.s.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import java.util.LinkedList;

public abstract interface a
{
  public abstract f WD(String paramString);
  
  public abstract f WE(String paramString);
  
  public abstract void WF(String paramString);
  
  public abstract Bitmap a(String paramString, int paramInt, float paramFloat);
  
  public abstract void al(LinkedList<String> paramLinkedList);
  
  public abstract void cX(String paramString, int paramInt);
  
  public abstract Cursor cag();
  
  public abstract i cah();
  
  public abstract Cursor cai();
  
  public abstract void e(f paramf);
  
  public abstract Cursor eZ(int paramInt1, int paramInt2);
  
  public abstract void f(f paramf);
  
  public abstract void g(f paramf);
  
  public abstract Cursor z(int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a.a
 * JD-Core Version:    0.7.0.1
 */
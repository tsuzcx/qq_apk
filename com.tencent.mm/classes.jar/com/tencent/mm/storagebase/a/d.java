package com.tencent.mm.storagebase.a;

import android.database.Cursor;
import android.util.SparseArray;
import java.util.HashMap;

public abstract interface d<T>
  extends Cursor
{
  public abstract void EV(boolean paramBoolean);
  
  public abstract void a(f.a parama);
  
  public abstract boolean a(Object paramObject, a parama);
  
  public abstract boolean asV(int paramInt);
  
  public abstract a asW(int paramInt);
  
  public abstract void asX(int paramInt);
  
  public abstract boolean eh(Object paramObject);
  
  public abstract a ei(Object paramObject);
  
  public abstract SparseArray<T>[] hBN();
  
  public abstract HashMap<Object, T> hBO();
  
  public abstract boolean hBP();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.d
 * JD-Core Version:    0.7.0.1
 */
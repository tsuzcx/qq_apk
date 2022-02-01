package com.tencent.mm.storagebase.a;

import android.database.Cursor;
import android.util.SparseArray;
import java.util.HashMap;

public abstract interface d<T>
  extends Cursor
{
  public abstract void a(f.a parama);
  
  public abstract boolean a(Object paramObject, a parama);
  
  public abstract boolean abQ(int paramInt);
  
  public abstract a abR(int paramInt);
  
  public abstract void abS(int paramInt);
  
  public abstract boolean dY(Object paramObject);
  
  public abstract a dZ(Object paramObject);
  
  public abstract SparseArray<T>[] fxI();
  
  public abstract HashMap<Object, T> fxJ();
  
  public abstract boolean fxK();
  
  public abstract void xa(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.d
 * JD-Core Version:    0.7.0.1
 */
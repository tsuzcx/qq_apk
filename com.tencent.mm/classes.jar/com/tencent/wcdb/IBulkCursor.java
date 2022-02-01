package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface IBulkCursor
  extends IInterface
{
  public static final int CLOSE_TRANSACTION = 7;
  public static final int DEACTIVATE_TRANSACTION = 2;
  public static final int GET_CURSOR_WINDOW_TRANSACTION = 1;
  public static final int GET_EXTRAS_TRANSACTION = 5;
  public static final int ON_MOVE_TRANSACTION = 4;
  public static final int REQUERY_TRANSACTION = 3;
  public static final int RESPOND_TRANSACTION = 6;
  public static final String descriptor = "android.content.IBulkCursor";
  
  public abstract void close();
  
  public abstract void deactivate();
  
  public abstract Bundle getExtras();
  
  public abstract CursorWindow getWindow(int paramInt);
  
  public abstract void onMove(int paramInt);
  
  public abstract int requery(IContentObserver paramIContentObserver);
  
  public abstract Bundle respond(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wcdb.IBulkCursor
 * JD-Core Version:    0.7.0.1
 */
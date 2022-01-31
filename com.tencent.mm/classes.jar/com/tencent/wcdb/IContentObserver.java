package com.tencent.wcdb;

import android.net.Uri;
import android.os.IInterface;

public abstract interface IContentObserver
  extends IInterface
{
  public abstract void onChange(boolean paramBoolean, Uri paramUri);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.IContentObserver
 * JD-Core Version:    0.7.0.1
 */
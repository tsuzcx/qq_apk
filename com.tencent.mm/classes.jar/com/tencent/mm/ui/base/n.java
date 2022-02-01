package com.tencent.mm.ui.base;

import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public final class n
{
  public static abstract interface a
  {
    public abstract void a(ImageView paramImageView, MenuItem paramMenuItem);
  }
  
  public static abstract interface b
  {
    public abstract void a(TextView paramTextView, MenuItem paramMenuItem);
  }
  
  public static abstract interface c
  {
    public abstract void onCreateMMMenu(l paraml);
  }
  
  public static abstract interface d
  {
    public abstract void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.n
 * JD-Core Version:    0.7.0.1
 */
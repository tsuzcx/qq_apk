package com.tencent.mm.ui.widget.cedit.b;

import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public abstract interface d
{
  public abstract void a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt);
  
  public abstract boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, KeyEvent paramKeyEvent);
  
  public abstract boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, MotionEvent paramMotionEvent);
  
  public abstract boolean a(CustomTextView paramCustomTextView, MotionEvent paramMotionEvent);
  
  public abstract void j(Spannable paramSpannable);
  
  public abstract boolean jHi();
  
  public abstract boolean jHk();
  
  public abstract boolean jHl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.b.d
 * JD-Core Version:    0.7.0.1
 */
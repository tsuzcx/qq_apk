package io.flutter.plugin.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.view.FlutterNativeView;

public abstract interface m
{
  public abstract boolean bbH(String paramString);
  
  public abstract c em(String paramString);
  
  public static abstract interface a
  {
    public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  public static abstract interface b
  {
    public abstract boolean onNewIntent(Intent paramIntent);
  }
  
  public static abstract interface c
  {
    public abstract Activity JQ();
    
    public abstract Context JR();
    
    public abstract c JS();
    
    public abstract io.flutter.view.c JT();
    
    public abstract String L(String paramString1, String paramString2);
    
    public abstract c a(m.f paramf);
    
    public abstract String en(String paramString);
  }
  
  public static abstract interface d
  {
    public abstract boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }
  
  public static abstract interface e
  {
    public abstract void onUserLeaveHint();
  }
  
  public static abstract interface f
  {
    public abstract boolean a(FlutterNativeView paramFlutterNativeView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.a.m
 * JD-Core Version:    0.7.0.1
 */
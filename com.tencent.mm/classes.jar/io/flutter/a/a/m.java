package io.flutter.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.f;

public abstract interface m
{
  public abstract boolean aPH(String paramString);
  
  public abstract c dB(String paramString);
  
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
    public abstract Activity IH();
    
    public abstract Context II();
    
    public abstract c IJ();
    
    public abstract f IK();
    
    public abstract String J(String paramString1, String paramString2);
    
    public abstract c a(m.f paramf);
    
    public abstract String dC(String paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.a.m
 * JD-Core Version:    0.7.0.1
 */
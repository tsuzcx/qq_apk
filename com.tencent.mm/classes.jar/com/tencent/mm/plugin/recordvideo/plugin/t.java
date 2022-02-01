package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "", "name", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBackPress", "", "onDetach", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "release", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"})
public abstract interface t
{
  public abstract boolean aoB();
  
  public abstract void ayX();
  
  public abstract String name();
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onDetach();
  
  public abstract void onPause();
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onResume();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void setVisibility(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.t
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "", "initLogic", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "name", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBackPress", "", "onDetach", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "release", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface v
{
  public abstract void a(RecordConfigProvider paramRecordConfigProvider);
  
  public abstract void bwk();
  
  public abstract String name();
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean onBackPress();
  
  public abstract void onDetach();
  
  public abstract void onPause();
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onResume();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void setVisibility(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.v
 * JD-Core Version:    0.7.0.1
 */
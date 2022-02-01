package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "", "name", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBackPress", "", "onDetach", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "release", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"})
public abstract interface u
{
  public abstract void bbp();
  
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
  
  @l(iBK={1, 1, 16})
  public static final class a
  {
    public static void a(String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(219005);
      p.k(paramArrayOfString, "permissions");
      p.k(paramArrayOfInt, "grantResults");
      AppMethodBeat.o(219005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.u
 * JD-Core Version:    0.7.0.1
 */
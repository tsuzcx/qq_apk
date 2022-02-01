package com.tencent.mm.plugin.ringtone.uic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.ui.widget.pulldown.c;
import kotlin.Metadata;

@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/BaseRingtoneUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "TAG", "", "getForceOrientation", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseRingtoneUI
  extends MMSecDataActivity
{
  private final String TAG = "MicroMsg.BaseRingtoneUI";
  
  public void _$_clearFindViewByIdCache() {}
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.BaseRingtoneUI
 * JD-Core Version:    0.7.0.1
 */
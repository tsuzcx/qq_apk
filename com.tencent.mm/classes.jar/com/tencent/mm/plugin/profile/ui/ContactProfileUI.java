package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.DrawStatusBarPreference;

public class ContactProfileUI
  extends DrawStatusBarPreference
{
  public int getResourceId()
  {
    AppMethodBeat.i(27043);
    int i = super.getResourceId();
    AppMethodBeat.o(27043);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27042);
    super.onCreate(paramBundle);
    AppMethodBeat.o(27042);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactProfileUI
 * JD-Core Version:    0.7.0.1
 */
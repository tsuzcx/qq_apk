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
    AppMethodBeat.i(23427);
    int i = super.getResourceId();
    AppMethodBeat.o(23427);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23426);
    super.onCreate(paramBundle);
    AppMethodBeat.o(23426);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactProfileUI
 * JD-Core Version:    0.7.0.1
 */
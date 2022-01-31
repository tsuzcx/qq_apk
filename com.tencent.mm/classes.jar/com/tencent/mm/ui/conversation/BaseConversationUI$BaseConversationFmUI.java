package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragment;

public class BaseConversationUI$BaseConversationFmUI
  extends MMFragment
{
  private BaseConversationUI.a fmStatus = BaseConversationUI.a.AgX;
  public BaseConversationUI ui;
  
  public void finish()
  {
    AppMethodBeat.i(34068);
    thisActivity().finish();
    AppMethodBeat.o(34068);
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public String getUserName()
  {
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(34066);
    this.fmStatus = BaseConversationUI.a.AgX;
    this.ui = ((BaseConversationUI)thisActivity());
    paramLayoutInflater = paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
    setHasOptionsMenu(true);
    AppMethodBeat.o(34066);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34071);
    if (this.fmStatus != BaseConversationUI.a.AgZ)
    {
      ab.w("MicroMsg.BaseConversationUI", "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
      onPause();
    }
    super.onDestroy();
    AppMethodBeat.o(34071);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34070);
    super.onPause();
    this.fmStatus = BaseConversationUI.a.AgZ;
    AppMethodBeat.o(34070);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34069);
    super.onResume();
    this.fmStatus = BaseConversationUI.a.AgY;
    AppMethodBeat.o(34069);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(34067);
    if (this.ui != null) {
      this.ui.setTitle(paramString);
    }
    AppMethodBeat.o(34067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;

public class BaseConversationUI$BaseConversationFmUI
  extends MMFragment
{
  private BaseConversationUI.a fmStatus = BaseConversationUI.a.XzB;
  public BaseConversationUI ui;
  
  public void finish()
  {
    AppMethodBeat.i(38187);
    thisActivity().finish();
    AppMethodBeat.o(38187);
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
    AppMethodBeat.i(38185);
    this.fmStatus = BaseConversationUI.a.XzB;
    this.ui = ((BaseConversationUI)thisActivity());
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(38185);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38190);
    if (this.fmStatus != BaseConversationUI.a.XzD)
    {
      Log.w("MicroMsg.BaseConversationUI", "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
      onPause();
    }
    super.onDestroy();
    AppMethodBeat.o(38190);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38189);
    super.onPause();
    this.fmStatus = BaseConversationUI.a.XzD;
    AppMethodBeat.o(38189);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38188);
    super.onResume();
    this.fmStatus = BaseConversationUI.a.XzC;
    AppMethodBeat.o(38188);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(38186);
    if (this.ui != null) {
      this.ui.setTitle(paramString);
    }
    AppMethodBeat.o(38186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI
 * JD-Core Version:    0.7.0.1
 */
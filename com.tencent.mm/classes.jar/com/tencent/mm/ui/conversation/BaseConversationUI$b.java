package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.x;

public class BaseConversationUI$b
  extends x
{
  private BaseConversationUI.a fmStatus = BaseConversationUI.a.vPm;
  public BaseConversationUI ui;
  
  public void finish()
  {
    thisActivity().finish();
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
    this.fmStatus = BaseConversationUI.a.vPm;
    this.ui = ((BaseConversationUI)thisActivity());
    paramLayoutInflater = paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
    setHasOptionsMenu(true);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.fmStatus != BaseConversationUI.a.vPo)
    {
      y.w("MicroMsg.BaseConversationUI", "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
      onPause();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.fmStatus = BaseConversationUI.a.vPo;
  }
  
  public void onResume()
  {
    super.onResume();
    this.fmStatus = BaseConversationUI.a.vPn;
  }
  
  public void setMMTitle(String paramString)
  {
    if (this.ui != null) {
      this.ui.setTitle(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.b
 * JD-Core Version:    0.7.0.1
 */
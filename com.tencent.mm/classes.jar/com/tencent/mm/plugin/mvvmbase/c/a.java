package com.tencent.mm.plugin.mvvmbase.c;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.mm.sdk.statecenter.BaseState;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmbase/uic/MvvmStateCenterUIC;", "State", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "uiStateCenter", "Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "getUiStateCenter", "()Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "setUiStateCenter", "(Lcom/tencent/mm/sdk/statecenter/UIStateCenter;)V", "getInitState", "()Lcom/tencent/mm/sdk/statecenter/BaseState;", "onCreateBefore", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-mvvmbase_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<State extends BaseState>
  extends com.tencent.mm.plugin.mvvmbase.a
{
  public UIStateCenter<State> MmB;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public abstract State getInitState();
  
  public void onCreateBefore(Bundle paramBundle)
  {
    this.MmB = new UIStateCenter(getInitState(), (q)getActivity(), null, null, 12, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmbase.c.a
 * JD-Core Version:    0.7.0.1
 */
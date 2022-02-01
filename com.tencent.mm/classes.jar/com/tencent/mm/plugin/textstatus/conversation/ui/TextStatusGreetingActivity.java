package com.tencent.mm.plugin.textstatus.conversation.ui;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/ui/TextStatusGreetingActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "convFragment", "Landroidx/fragment/app/Fragment;", "getConvFragment", "()Landroidx/fragment/app/Fragment;", "setConvFragment", "(Landroidx/fragment/app/Fragment;)V", "getFragment", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public class TextStatusGreetingActivity
  extends MMActivity
{
  public static final TextStatusGreetingActivity.a TjJ;
  private Fragment TjK;
  
  static
  {
    AppMethodBeat.i(290980);
    TjJ = new TextStatusGreetingActivity.a((byte)0);
    AppMethodBeat.o(290980);
  }
  
  private static final boolean a(TextStatusGreetingActivity paramTextStatusGreetingActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(290978);
    s.u(paramTextStatusGreetingActivity, "this$0");
    paramTextStatusGreetingActivity.onBackPressed();
    AppMethodBeat.o(290978);
    return true;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public int getLayoutId()
  {
    return a.f.Tfj;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291001);
    super.onCreate(paramBundle);
    setMMTitle(a.h.TgF);
    setBackBtn(new TextStatusGreetingActivity..ExternalSyntheticLambda0(this));
    if (this.TjK == null) {
      this.TjK = ((Fragment)new TextStatusGreetingFragment());
    }
    paramBundle = this.TjK;
    if (paramBundle != null)
    {
      r localr = getSupportFragmentManager().beginTransaction();
      s.s(localr, "supportFragmentManager.beginTransaction()");
      localr.b(a.e.fragment_container, paramBundle);
      localr.FY();
    }
    AppMethodBeat.o(291001);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.ui.TextStatusGreetingActivity
 * JD-Core Version:    0.7.0.1
 */
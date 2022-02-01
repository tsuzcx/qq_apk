package com.tencent.mm.plugin.profile.ui.newbizinfo.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthMainUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "username", "getUsername", "setUsername", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initActionBar", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NewBizInfoAuthMainUI
  extends MMSecDataActivity
{
  public String appId;
  public String username;
  
  private static final boolean a(NewBizInfoAuthMainUI paramNewBizInfoAuthMainUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(305768);
    s.u(paramNewBizInfoAuthMainUI, "this$0");
    paramNewBizInfoAuthMainUI.finish();
    AppMethodBeat.o(305768);
    return true;
  }
  
  public final int getLayoutId()
  {
    return R.i.gid;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(305788);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(305788);
      return null;
    }
    localSet = ar.b(localSet, (Iterable)ar.setOf(new Class[] { a.class, b.class, c.class }));
    AppMethodBeat.o(305788);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305805);
    super.onCreate(paramBundle);
    String str = getIntent().getStringExtra("Contact_User");
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    s.u(paramBundle, "<set-?>");
    this.username = paramBundle;
    str = getIntent().getStringExtra("key_add_contact_openim_appid");
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    s.u(paramBundle, "<set-?>");
    this.appId = paramBundle;
    setTitleDividerVis(false);
    setMMTitle("");
    hideActionbarLine();
    setBackBtn(new NewBizInfoAuthMainUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(305805);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.auth.NewBizInfoAuthMainUI
 * JD-Core Version:    0.7.0.1
 */
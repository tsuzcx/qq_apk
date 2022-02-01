package com.tencent.mm.sensitive.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.i;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/ui/PermissionDialogUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PermissionDialogUI
  extends MMActivity
{
  private static b<? super Boolean, ah> Qpe;
  public static final PermissionDialogUI.a acvK;
  private static final String acvL;
  private static final String acvM;
  
  static
  {
    AppMethodBeat.i(241019);
    acvK = new PermissionDialogUI.a((byte)0);
    acvL = "KEY_PERMISSION";
    acvM = "KEY_BUSINESS";
    AppMethodBeat.o(241019);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(241024);
    super.onCreate(paramBundle);
    if (d.rb(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = getIntent().getStringExtra(acvL);
    Object localObject1;
    label60:
    Object localObject2;
    if (paramBundle == null)
    {
      paramBundle = null;
      localObject1 = getIntent().getStringExtra(acvM);
      if (localObject1 != null) {
        break label131;
      }
      localObject1 = null;
      if ((paramBundle == null) || (localObject1 == null)) {
        break label143;
      }
      localObject2 = a.acvO;
      a.a((Activity)this, paramBundle, (d.a)localObject1, (b)new b(this));
    }
    label131:
    label143:
    for (paramBundle = ah.aiuX;; paramBundle = null)
    {
      if (paramBundle == null)
      {
        paramBundle = (PermissionDialogUI)this;
        Qpe = null;
        paramBundle.finish();
      }
      AppMethodBeat.o(241024);
      return;
      localObject1 = i.actT;
      paramBundle = i.buq(paramBundle);
      break;
      localObject2 = i.actT;
      localObject1 = i.bup((String)localObject1);
      break label60;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Boolean, ah>
  {
    b(PermissionDialogUI paramPermissionDialogUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.ui.PermissionDialogUI
 * JD-Core Version:    0.7.0.1
 */
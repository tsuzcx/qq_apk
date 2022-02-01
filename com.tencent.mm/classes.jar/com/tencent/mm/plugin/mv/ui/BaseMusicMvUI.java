package com.tencent.mm.plugin.mv.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.uic.s;
import com.tencent.mm.plugin.secdata.c;
import com.tencent.mm.plugin.secdata.h;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "TAG", "", "getForceOrientation", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseMusicMvUI
  extends MMSecDataActivity
{
  private final String TAG = "MicroMsg.Mv.BaseMusicMvUI";
  
  public void _$_clearFindViewByIdCache() {}
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    Set localSet = super.importUIComponents();
    if (localSet == null) {
      return null;
    }
    return ar.b(localSet, (Iterable)ar.setOf(s.class));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = k.aeZF;
    ((a)k.d((AppCompatActivity)this).q(a.class)).a((h)new c(dtk.class, 7, (byte)0));
    paramBundle = a.PlI;
    paramBundle = (dtk)a.a.a((Context)this, 7, dtk.class);
    if (paramBundle != null)
    {
      localObject = a.PlI;
      localObject = (dtk)a.a.b((Context)this, 7, dtk.class);
      if (localObject != null)
      {
        paramBundle.scene = ((dtk)localObject).scene;
        paramBundle.zIO = ((dtk)localObject).zIO;
        paramBundle.aaYP = ((dtk)localObject).aaYP;
        paramBundle.aaYQ = ((dtk)localObject).aaYQ;
        paramBundle.FST = ((dtk)localObject).FST;
        Log.i(this.TAG, "init mv page scene:" + ((dtk)localObject).scene + " contextId:" + ((dtk)localObject).zIO + " finderCommentScene:" + ((dtk)localObject).aaYP + " finderContextId:" + ((dtk)localObject).FST);
      }
    }
    Object localObject = getIntent().getByteArrayExtra("key_mv_report_data");
    if (localObject != null) {}
    try
    {
      paramBundle = new dtk();
      paramBundle.parseFrom((byte[])localObject);
      localObject = a.PlI;
      localObject = (dtk)a.a.a((Context)this, 7, dtk.class);
      if (localObject != null)
      {
        ((dtk)localObject).scene = paramBundle.scene;
        ((dtk)localObject).zIO = paramBundle.zIO;
        ((dtk)localObject).aaYP = paramBundle.aaYP;
        ((dtk)localObject).aaYQ = ((dtk)localObject).aaYQ;
        Log.i(this.TAG, "init mv page report data from intent, " + paramBundle.scene + ' ' + paramBundle.zIO + ' ' + paramBundle.aaYP);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramBundle, paramBundle.getMessage(), new Object[0]);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.BaseMusicMvUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.textstatus.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.j;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.glocom.b;
import com.tencent.mm.ui.component.glocom.b.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog$gloUIC$1", "Lcom/tencent/mm/ui/component/glocom/IGloUIComponent;", "getTag", "", "onPause", "", "onResume", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$b
  implements b
{
  i$b(i parami) {}
  
  public final void c(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(291727);
    b.a.a(this, paramMMFragmentActivity);
    AppMethodBeat.o(291727);
  }
  
  public final void d(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(291856);
    b.a.b(this, paramMMFragmentActivity);
    AppMethodBeat.o(291856);
  }
  
  public final String getTag()
  {
    return "TextStatusCardDialog";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(291735);
    b.a.c((b)this);
    AppMethodBeat.o(291735);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(291741);
    boolean bool = b.a.d((b)this);
    AppMethodBeat.o(291741);
    return bool;
  }
  
  public final void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(291751);
    b.a.e((b)this);
    AppMethodBeat.o(291751);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(291758);
    b.a.a((b)this, paramConfiguration);
    AppMethodBeat.o(291758);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(291766);
    b.a.f((b)this);
    AppMethodBeat.o(291766);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(291778);
    b.a.g((b)this);
    AppMethodBeat.o(291778);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291785);
    b.a.h((b)this);
    AppMethodBeat.o(291785);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(291797);
    boolean bool = b.a.a((b)this, paramKeyEvent);
    AppMethodBeat.o(291797);
    return bool;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(291806);
    boolean bool = b.a.b((b)this, paramKeyEvent);
    AppMethodBeat.o(291806);
    return bool;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(291817);
    b.a.i((b)this);
    AppMethodBeat.o(291817);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(291709);
    b.a.j((b)this);
    j localj = this.Txb.TwZ;
    if (localj != null) {
      localj.hFx();
    }
    AppMethodBeat.o(291709);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(291825);
    b.a.a((b)this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(291825);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(291833);
    b.a.k((b)this);
    AppMethodBeat.o(291833);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291702);
    b.a.l((b)this);
    j localj = this.Txb.TwZ;
    if (localj != null) {
      localj.hFw();
    }
    AppMethodBeat.o(291702);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(291836);
    b.a.m((b)this);
    AppMethodBeat.o(291836);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(291843);
    b.a.n((b)this);
    AppMethodBeat.o(291843);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(291847);
    b.a.o((b)this);
    AppMethodBeat.o(291847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.i.b
 * JD-Core Version:    0.7.0.1
 */
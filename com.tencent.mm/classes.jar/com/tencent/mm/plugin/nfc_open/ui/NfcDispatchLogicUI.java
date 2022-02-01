package com.tencent.mm.plugin.nfc_open.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.g;
import com.tencent.mm.plugin.nfc_open.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/nfc_open/ui/NfcDispatchLogicUI;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NfcDispatchLogicUI
  extends AppCompatActivity
{
  public static final NfcDispatchLogicUI.a Mtx;
  
  static
  {
    AppMethodBeat.i(261780);
    Mtx = new NfcDispatchLogicUI.a((byte)0);
    AppMethodBeat.o(261780);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(261783);
    setTheme(a.g.MMTheme_NoTitleTranslucent);
    super.onCreate(paramBundle);
    aw.g(getWindow());
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    overridePendingTransition(0, 0);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      Log.i("MicroMsg.Nfc.NfcDispatchLogicUI", "onCreate, intent is null");
      finish();
      AppMethodBeat.o(261783);
      return;
    }
    d locald = d.Mtt;
    d.aE((Context)this, paramBundle);
    finish();
    AppMethodBeat.o(261783);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.ui.NfcDispatchLogicUI
 * JD-Core Version:    0.7.0.1
 */
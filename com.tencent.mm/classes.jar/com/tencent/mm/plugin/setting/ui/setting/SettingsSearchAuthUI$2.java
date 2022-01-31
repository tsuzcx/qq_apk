package com.tencent.mm.plugin.setting.ui.setting;

import android.content.res.Resources;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class SettingsSearchAuthUI$2
  implements FTSEditTextView.a
{
  SettingsSearchAuthUI$2(SettingsSearchAuthUI paramSettingsSearchAuthUI) {}
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(127439);
    ab.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", new Object[] { paramString1 });
    if (!bo.isNullOrNil(paramString1))
    {
      SettingsSearchAuthUI.a(this.qJW);
      paramString2 = this.qJW.getString(2131297065);
      paramString1 = new k(paramString2 + " " + paramString1.trim());
      paramString1.setSpan(new ForegroundColorSpan(this.qJW.getResources().getColor(2131689778)), paramString2.length(), paramString1.length(), 33);
      SettingsSearchAuthUI.b(this.qJW).setText(paramString1);
      AppMethodBeat.o(127439);
      return;
    }
    SettingsSearchAuthUI.c(this.qJW);
    AppMethodBeat.o(127439);
  }
  
  public final boolean aMm()
  {
    AppMethodBeat.i(127442);
    ab.i("MicroMsg.SettingsSearchAuthUI", "search key down");
    Editable localEditable = SettingsSearchAuthUI.d(this.qJW).getFtsEditText().getEditText().getText();
    SettingsSearchAuthUI.b(this.qJW).setVisibility(8);
    SettingsSearchAuthUI.d(this.qJW).getFtsEditText().getEditText().clearFocus();
    this.qJW.hideVKB();
    SettingsSearchAuthUI.e(this.qJW);
    if (!bo.aa(localEditable)) {
      SettingsSearchAuthUI.a(this.qJW, localEditable.toString().trim());
    }
    AppMethodBeat.o(127442);
    return true;
  }
  
  public final void bCE() {}
  
  public final void hQ(boolean paramBoolean)
  {
    AppMethodBeat.i(127440);
    ab.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.qJW.showVKB();
      AppMethodBeat.o(127440);
      return;
    }
    this.qJW.hideVKB();
    AppMethodBeat.o(127440);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(127441);
    ab.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
    SettingsSearchAuthUI.c(this.qJW);
    AppMethodBeat.o(127441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.2
 * JD-Core Version:    0.7.0.1
 */
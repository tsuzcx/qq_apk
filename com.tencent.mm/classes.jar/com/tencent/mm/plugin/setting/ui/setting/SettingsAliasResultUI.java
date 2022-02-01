package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;

public class SettingsAliasResultUI
  extends MMActivity
{
  private String ffB;
  private TextView iCV;
  private TextView yGn;
  private Button yGo;
  private ImageView yGp;
  private boolean yGq;
  
  public int getLayoutId()
  {
    return 2131495386;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74112);
    setMMTitle(2131761319);
    this.iCV = ((TextView)findViewById(2131299008));
    this.yGn = ((TextView)findViewById(2131296639));
    this.yGo = ((Button)findViewById(2131304612));
    this.yGp = ((ImageView)findViewById(2131303000));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74107);
        SettingsAliasResultUI.this.finish();
        AppMethodBeat.o(74107);
        return true;
      }
    });
    this.yGn.setText(this.ffB);
    if (!this.yGq)
    {
      this.yGo.setVisibility(0);
      this.iCV.setText(getString(2131761324));
    }
    for (;;)
    {
      this.yGo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74108);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent(SettingsAliasResultUI.this.getContext(), RegByMobileSetPwdUI.class);
          paramAnonymousView.putExtra("kintent_hint", SettingsAliasResultUI.this.getString(2131762358));
          SettingsAliasResultUI.this.startActivityForResult(paramAnonymousView, 0);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74108);
        }
      });
      AppMethodBeat.o(74112);
      return;
      this.yGo.setVisibility(8);
      this.iCV.setText(getString(2131761325));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74113);
    if (paramInt2 == -1) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(74113);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74109);
    super.onCreate(paramBundle);
    this.ffB = ((String)g.ajC().ajl().get(42, null));
    this.yGq = getIntent().getBooleanExtra("has_pwd", true);
    initView();
    AppMethodBeat.o(74109);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74111);
    super.onDestroy();
    AppMethodBeat.o(74111);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74110);
    super.onPause();
    AppMethodBeat.o(74110);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI
 * JD-Core Version:    0.7.0.1
 */
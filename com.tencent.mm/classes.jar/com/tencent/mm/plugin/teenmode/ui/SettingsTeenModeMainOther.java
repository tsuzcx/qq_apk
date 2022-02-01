package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class SettingsTeenModeMainOther
  extends MMActivity
{
  private WeImageView FWR;
  private MMImageView FWS;
  private TextView jBR;
  private TextView jVO;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496275;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187450);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.FWR = ((WeImageView)findViewById(2131302514));
    this.FWS = ((MMImageView)findViewById(2131302037));
    this.jVO = ((TextView)findViewById(2131309249));
    this.jBR = ((TextView)findViewById(2131299510));
    int i = getIntent().getIntExtra("biz_type", 0);
    Log.i("MicroMsg.SettingsTeenModeMainOther", "type:%s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187449);
          SettingsTeenModeMainOther.this.onBackPressed();
          AppMethodBeat.o(187449);
          return true;
        }
      });
      AppMethodBeat.o(187450);
      return;
      this.FWR.setImageDrawable(a.l(getContext(), 2131690853));
      this.FWR.setIconColor(a.n(getContext(), 2131099792));
      this.jVO.setText(2131766675);
      this.jBR.setText(2131758300);
      continue;
      this.FWR.setImageDrawable(a.l(getContext(), 2131690903));
      this.FWR.setIconColor(a.n(getContext(), 2131099818));
      this.jVO.setText(2131766667);
      this.jBR.setText(2131758294);
      continue;
      this.FWR.setVisibility(8);
      this.FWS.setVisibility(0);
      this.jVO.setText(2131766669);
      this.jBR.setText(2131758295);
      continue;
      this.FWR.setImageDrawable(a.l(getContext(), 2131690852));
      this.FWR.setIconColor(a.n(getContext(), 2131099700));
      this.jVO.setText(2131766671);
      this.jBR.setText(2131758296);
      continue;
      this.FWR.setImageDrawable(a.l(getContext(), 2131690825));
      this.FWR.setIconColor(a.n(getContext(), 2131099700));
      this.jVO.setText(2131766672);
      this.jBR.setText(2131758297);
      continue;
      this.FWR.setImageDrawable(a.l(getContext(), 2131690906));
      this.FWR.setIconColor(a.n(getContext(), 2131099700));
      this.jVO.setText(2131766673);
      this.jBR.setText(2131758298);
      continue;
      this.FWR.setImageDrawable(a.l(getContext(), 2131690908));
      this.FWR.setIconColor(a.n(getContext(), 2131099818));
      this.jVO.setText(2131766674);
      this.jBR.setText(2131758299);
      continue;
      this.FWR.setImageDrawable(a.l(getContext(), 2131690953));
      this.FWR.setIconColor(a.n(getContext(), 2131099710));
      this.jVO.setText(2131766676);
      this.jBR.setText(2131758301);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(187452);
    super.onDestroy();
    AppMethodBeat.o(187452);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(187451);
    super.onPause();
    AppMethodBeat.o(187451);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainOther
 * JD-Core Version:    0.7.0.1
 */
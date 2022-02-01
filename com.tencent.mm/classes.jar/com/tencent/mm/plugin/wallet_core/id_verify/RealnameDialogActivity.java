package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class RealnameDialogActivity
  extends WalletBaseUI
{
  private RealnameGuideHelper tpz;
  private int type = 1;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70017);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if ((paramBundle != null) && (paramBundle.hasExtra("key_realname_guide_helper")))
    {
      this.tpz = ((RealnameGuideHelper)paramBundle.getParcelableExtra("key_realname_guide_helper"));
      paramBundle = new Bundle();
      paramBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
      paramBundle.putString("realname_verify_process_jump_activity", ".id_verify.RealnameDialogActivity");
      paramBundle.putBoolean("process_finish_stay_orgpage", false);
      boolean bool1 = this.tpz.a(this, paramBundle, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70015);
          paramAnonymousDialogInterface.dismiss();
          RealnameDialogActivity.this.finish();
          AppMethodBeat.o(70015);
        }
      }, null, true);
      boolean bool2 = this.tpz.a(this, paramBundle, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70016);
          paramAnonymousDialogInterface.dismiss();
          RealnameDialogActivity.this.finish();
          AppMethodBeat.o(70016);
        }
      });
      if ((!bool1) && (!bool2)) {
        finish();
      }
      AppMethodBeat.o(70017);
      return;
    }
    finish();
    AppMethodBeat.o(70017);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.RealnameDialogActivity
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public class SnsLongMsgUI
  extends MMActivity
{
  private Button xau;
  
  public int getLayoutId()
  {
    return 2131494608;
  }
  
  @TargetApi(17)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98851);
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    this.xau = ((Button)findViewById(2131301272));
    this.xau.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98849);
        Object localObject = new Intent();
        ((Intent)localObject).setClass(SnsLongMsgUI.this, SnsUploadUI.class);
        ((Intent)localObject).putExtra("KSnsPostManu", true);
        ((Intent)localObject).putExtra("KTouchCameraTime", bt.aGK());
        ((Intent)localObject).putExtra("sns_comment_type", 1);
        ((Intent)localObject).putExtra("Ksnsupload_type", 9);
        paramAnonymousView = SnsLongMsgUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/sns/ui/SnsLongMsgUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsLongMsgUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        SnsLongMsgUI.this.finish();
        AppMethodBeat.o(98849);
      }
    });
    AppMethodBeat.o(98851);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98850);
    super.onDestroy();
    AppMethodBeat.o(98850);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98852);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      paramKeyEvent = new Intent();
      paramKeyEvent.setClass(this, SnsUploadUI.class);
      paramKeyEvent.putExtra("KSnsPostManu", true);
      paramKeyEvent.putExtra("KTouchCameraTime", bt.aGK());
      paramKeyEvent.putExtra("sns_comment_type", 1);
      paramKeyEvent.putExtra("Ksnsupload_type", 9);
      paramKeyEvent = new com.tencent.mm.hellhoundlib.b.a().bd(paramKeyEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramKeyEvent.adn(), "com/tencent/mm/plugin/sns/ui/SnsLongMsgUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramKeyEvent.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLongMsgUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(98852);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(98852);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLongMsgUI
 * JD-Core Version:    0.7.0.1
 */
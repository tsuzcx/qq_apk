package com.tencent.mm.wear.app.ui.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.mm.e.a.n;
import com.tencent.mm.sdk.a.e;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.d.g;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.io.IOException;

public class ReplyLuckyUI
  extends MMActivity
{
  private int agB;
  private n agC;
  private com.tencent.mm.wear.app.ui.widget.a ajK;
  private ListView ajL;
  private b ajM;
  private e ajN = new e() {};
  
  public final void od()
  {
    com.tencent.mm.sdk.a.a.YM.a(this.ajN);
    com.tencent.mm.wear.app.f.b localb = new com.tencent.mm.wear.app.f.b(11029, String.valueOf(this.agC.XJ).getBytes());
    h.mP().a(localb);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903100);
    this.ajL = ((ListView)findViewById(2131558516));
    this.ajK = new com.tencent.mm.wear.app.ui.widget.a(this);
    this.ajL.addHeaderView(this.ajK.om());
    this.ajM = new b(this);
    this.ajL.setAdapter(this.ajM);
    paramBundle = getIntent().getByteArrayExtra("key_data");
    this.agB = getIntent().getIntExtra("key_notification_id", 0);
    boolean bool = getIntent().getBooleanExtra("key_open", false);
    this.agC = new n();
    try
    {
      this.agC.h(paramBundle);
      label128:
      this.ajK.a(this.agC);
      if (bool)
      {
        od();
        this.ajK.on();
        com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyLuckyUI", "start to request lucky %d", new Object[] { Long.valueOf(this.agC.XJ) });
      }
      for (;;)
      {
        if (this.agB > 0)
        {
          g.i(MMApplication.getContext(), this.agB);
          com.tencent.mm.wear.app.d.a.cj(8);
        }
        return;
        this.ajK.a(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            com.tencent.mm.wear.app.d.a.cj(9);
            ReplyLuckyUI.this.od();
            ReplyLuckyUI.a(ReplyLuckyUI.this).on();
            com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyLuckyUI", "start to request lucky %d", new Object[] { Long.valueOf(ReplyLuckyUI.b(ReplyLuckyUI.this).XJ) });
          }
        });
      }
    }
    catch (IOException paramBundle)
    {
      break label128;
    }
  }
  
  protected void onStop()
  {
    com.tencent.mm.sdk.a.a.YM.b(this.ajN);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.ReplyLuckyUI
 * JD-Core Version:    0.7.0.1
 */
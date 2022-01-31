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
import com.tencent.mm.wear.app.d.f;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.io.IOException;

public class ReplyLuckyUI
  extends MMActivity
{
  private int ada;
  private n adb;
  private com.tencent.mm.wear.app.ui.widget.a agi;
  private ListView agj;
  private b agk;
  private e agl = new e() {};
  
  public final void nq()
  {
    com.tencent.mm.sdk.a.a.WJ.a(this.agl);
    com.tencent.mm.wear.app.f.b localb = new com.tencent.mm.wear.app.f.b(11029, String.valueOf(this.adb.VO).getBytes());
    h.mc().a(localb);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903100);
    this.agj = ((ListView)findViewById(2131558515));
    this.agi = new com.tencent.mm.wear.app.ui.widget.a(this);
    this.agj.addHeaderView(this.agi.ny());
    this.agk = new b(this);
    this.agj.setAdapter(this.agk);
    paramBundle = getIntent().getByteArrayExtra("key_data");
    this.ada = getIntent().getIntExtra("key_notification_id", 0);
    boolean bool = getIntent().getBooleanExtra("key_open", false);
    this.adb = new n();
    try
    {
      this.adb.h(paramBundle);
      label128:
      this.agi.a(this.adb);
      if (bool)
      {
        nq();
        this.agi.nz();
        com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyLuckyUI", "start to request lucky %d", new Object[] { Long.valueOf(this.adb.VO) });
      }
      for (;;)
      {
        if (this.ada > 0)
        {
          f.i(MMApplication.getContext(), this.ada);
          com.tencent.mm.wear.app.d.a.bN(8);
        }
        return;
        this.agi.a(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            com.tencent.mm.wear.app.d.a.bN(9);
            ReplyLuckyUI.this.nq();
            ReplyLuckyUI.a(ReplyLuckyUI.this).nz();
            com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyLuckyUI", "start to request lucky %d", new Object[] { Long.valueOf(ReplyLuckyUI.b(ReplyLuckyUI.this).VO) });
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
    com.tencent.mm.sdk.a.a.WJ.b(this.agl);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.ReplyLuckyUI
 * JD-Core Version:    0.7.0.1
 */
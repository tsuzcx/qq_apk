package com.tencent.mm.wear.app.ui.message;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.wear.a.f.c;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.d.a.b.g;
import com.tencent.mm.wear.app.ui.MMAvatarActivity;
import com.tencent.mm.wear.app.ui.widget.RecordView;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ReplyVoiceUI
  extends MMAvatarActivity
  implements com.tencent.mm.wear.app.d.a.b.e, com.tencent.mm.wear.app.ui.widget.b
{
  private String aas;
  private BlockingQueue<g> adP;
  private com.tencent.mm.wear.app.d.a.b.d ago;
  private RecordView agq;
  private TextView agr;
  private int agu;
  private com.tencent.mm.wear.app.d.a.b.a agx;
  private long agy;
  private com.tencent.mm.wear.a.b.a agz = new com.tencent.mm.wear.a.b.a()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage.what == 4097) && ((ReplyVoiceUI.a(ReplyVoiceUI.this).getStatus() == 2) || (ReplyVoiceUI.a(ReplyVoiceUI.this).getStatus() == 3)))
      {
        if (ReplyVoiceUI.b(ReplyVoiceUI.this) <= 0) {
          ReplyVoiceUI.a(ReplyVoiceUI.this).setStatus(4);
        }
      }
      else {
        return;
      }
      if (ReplyVoiceUI.b(ReplyVoiceUI.this) <= 10)
      {
        if (ReplyVoiceUI.a(ReplyVoiceUI.this).getStatus() != 2) {
          break label145;
        }
        ReplyVoiceUI.a(ReplyVoiceUI.this, ReplyVoiceUI.this.getString(2131165234, new Object[] { Integer.valueOf(ReplyVoiceUI.b(ReplyVoiceUI.this)) }));
      }
      for (;;)
      {
        ReplyVoiceUI.c(ReplyVoiceUI.this);
        ReplyVoiceUI.d(ReplyVoiceUI.this).sendEmptyMessageDelayed(4097, 1000L);
        return;
        label145:
        ReplyVoiceUI.a(ReplyVoiceUI.this, ReplyVoiceUI.this.getString(2131165237, new Object[] { Integer.valueOf(ReplyVoiceUI.b(ReplyVoiceUI.this)) }));
      }
    }
  };
  
  private void ns()
  {
    this.agu = 0;
    this.agz.removeMessages(4097);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyVoiceUI", "stop time ticker", new Object[0]);
  }
  
  public final void aj(int paramInt1, int paramInt2)
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyVoiceUI", "currentStatus %d, preStatus %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str;
    switch (paramInt1)
    {
    case -2: 
    case 0: 
    case 1: 
    case 5: 
    case 7: 
    default: 
      return;
    case 2: 
      com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyVoiceUI", "start to record", new Object[0]);
      str = new File(h.mi(), System.currentTimeMillis()).getAbsolutePath();
      this.adP = new LinkedBlockingQueue();
      this.ago = new com.tencent.mm.wear.app.d.a.b.d(this.adP, 8000);
      this.ago.a(this);
      this.ago.start();
      this.agx = new com.tencent.mm.wear.app.d.a.b.a(str, this.adP);
      this.agx.start();
      this.agr.setText(2131165233);
      this.agu = 30;
      this.agz.removeMessages(4097);
      this.agz.sendEmptyMessage(4097);
      com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyVoiceUI", "start time ticker", new Object[0]);
      return;
    case 3: 
      this.agr.setText(2131165228);
      return;
    case 4: 
      com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyVoiceUI", "stop to record", new Object[0]);
      if ((this.ago != null) && (this.agx != null))
      {
        this.ago.mP();
        this.agy = this.ago.mQ();
        this.agx.mL();
        this.aas = this.agx.mM();
        this.ago = null;
        this.agx = null;
        if (this.agy >= 1500L) {
          break label377;
        }
        com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyVoiceUI", "two short voice: length=%d", new Object[] { Long.valueOf(this.agy) });
        c.S(this.aas);
        this.agq.setStatus(-1);
      }
      for (;;)
      {
        ns();
        return;
        this.agr.setText(2131165238);
        this.agq.cc(6);
        this.agq.setStatus(5);
      }
    case -1: 
      this.agr.setText(2131165239);
      return;
    case 6: 
      label377:
      str = this.aas;
      long l = this.agy;
      h.mc().a(new e(this, str, l, getUsername(), nd()));
      return;
    }
    finish();
  }
  
  public final void bP(int paramInt)
  {
    if ((paramInt > 1000) && (this.agq.getStatus() == 2)) {
      this.agq.setStatus(3);
    }
    this.agq.cb(paramInt);
  }
  
  public final int getLayoutId()
  {
    return 2130903105;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    this.agq = ((RecordView)findViewById(2131558516));
    this.agr = ((TextView)findViewById(2131558517));
    this.agr.setText(2131165233);
    this.agq.a(this);
    this.agq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        switch (ReplyVoiceUI.a(ReplyVoiceUI.this).getStatus())
        {
        case 0: 
        case 1: 
        case 4: 
        default: 
          return;
        case 2: 
        case 3: 
          ReplyVoiceUI.a(ReplyVoiceUI.this).setStatus(4);
          return;
        case -1: 
          ReplyVoiceUI.a(ReplyVoiceUI.this).setStatus(2);
          return;
        }
        ReplyVoiceUI.a(ReplyVoiceUI.this).setStatus(-3);
      }
    });
    this.agq.setStatus(2);
    N(getUsername());
  }
  
  protected void onDestroy()
  {
    if (this.ago != null)
    {
      this.ago.mP();
      this.ago = null;
    }
    if (this.agx != null)
    {
      this.agx.mL();
      String str = this.agx.mM();
      this.agx = null;
      c.S(str);
    }
    ns();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.ReplyVoiceUI
 * JD-Core Version:    0.7.0.1
 */
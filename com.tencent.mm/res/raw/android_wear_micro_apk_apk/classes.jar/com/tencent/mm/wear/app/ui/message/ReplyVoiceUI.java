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
  private String adT;
  private BlockingQueue<g> ahr;
  private com.tencent.mm.wear.app.d.a.b.d ajQ;
  private RecordView ajS;
  private TextView ajT;
  private int ajW;
  private com.tencent.mm.wear.app.d.a.b.a ajZ;
  private long aka;
  private com.tencent.mm.wear.a.b.a akb = new com.tencent.mm.wear.a.b.a()
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
        ReplyVoiceUI.a(ReplyVoiceUI.this, ReplyVoiceUI.this.getString(2131165235, new Object[] { Integer.valueOf(ReplyVoiceUI.b(ReplyVoiceUI.this)) }));
      }
      for (;;)
      {
        ReplyVoiceUI.c(ReplyVoiceUI.this);
        ReplyVoiceUI.d(ReplyVoiceUI.this).sendEmptyMessageDelayed(4097, 1000L);
        return;
        label145:
        ReplyVoiceUI.a(ReplyVoiceUI.this, ReplyVoiceUI.this.getString(2131165238, new Object[] { Integer.valueOf(ReplyVoiceUI.b(ReplyVoiceUI.this)) }));
      }
    }
  };
  
  private void of()
  {
    this.ajW = 0;
    this.akb.removeMessages(4097);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyVoiceUI", "stop time ticker", new Object[0]);
  }
  
  public final void am(int paramInt1, int paramInt2)
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
      str = new File(h.mU(), System.currentTimeMillis()).getAbsolutePath();
      this.ahr = new LinkedBlockingQueue();
      this.ajQ = new com.tencent.mm.wear.app.d.a.b.d(this.ahr, 8000);
      this.ajQ.a(this);
      this.ajQ.start();
      this.ajZ = new com.tencent.mm.wear.app.d.a.b.a(str, this.ahr);
      this.ajZ.start();
      this.ajT.setText(2131165234);
      this.ajW = 30;
      this.akb.removeMessages(4097);
      this.akb.sendEmptyMessage(4097);
      com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyVoiceUI", "start time ticker", new Object[0]);
      return;
    case 3: 
      this.ajT.setText(2131165229);
      return;
    case 4: 
      com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyVoiceUI", "stop to record", new Object[0]);
      if ((this.ajQ != null) && (this.ajZ != null))
      {
        this.ajQ.nB();
        this.aka = this.ajQ.nC();
        this.ajZ.nx();
        this.adT = this.ajZ.ny();
        this.ajQ = null;
        this.ajZ = null;
        if (this.aka >= 1500L) {
          break label377;
        }
        com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyVoiceUI", "two short voice: length=%d", new Object[] { Long.valueOf(this.aka) });
        c.Z(this.adT);
        this.ajS.setStatus(-1);
      }
      for (;;)
      {
        of();
        return;
        this.ajT.setText(2131165239);
        this.ajS.cy(6);
        this.ajS.setStatus(5);
      }
    case -1: 
      this.ajT.setText(2131165240);
      return;
    case 6: 
      label377:
      str = this.adT;
      long l = this.aka;
      h.mP().a(new e(this, str, l, getUsername(), nQ()));
      return;
    }
    finish();
  }
  
  public final void cl(int paramInt)
  {
    if ((paramInt > 1000) && (this.ajS.getStatus() == 2)) {
      this.ajS.setStatus(3);
    }
    this.ajS.cx(paramInt);
  }
  
  public final int getLayoutId()
  {
    return 2130903105;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    this.ajS = ((RecordView)findViewById(2131558517));
    this.ajT = ((TextView)findViewById(2131558518));
    this.ajT.setText(2131165234);
    this.ajS.a(this);
    this.ajS.setOnClickListener(new View.OnClickListener()
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
    this.ajS.setStatus(2);
    U(getUsername());
  }
  
  protected void onDestroy()
  {
    if (this.ajQ != null)
    {
      this.ajQ.nB();
      this.ajQ = null;
    }
    if (this.ajZ != null)
    {
      this.ajZ.nx();
      String str = this.ajZ.ny();
      this.ajZ = null;
      c.Z(str);
    }
    of();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.ReplyVoiceUI
 * JD-Core Version:    0.7.0.1
 */
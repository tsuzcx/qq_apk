package com.tencent.mm.wear.app.ui.message;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.am;
import com.tencent.mm.wear.app.a.i;
import com.tencent.mm.wear.app.a.k;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.MMAvatarActivity;
import com.tencent.mm.wear.app.ui.widget.RecordView;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ReplyTextUI
  extends MMAvatarActivity
  implements k, com.tencent.mm.wear.app.d.a.b.e, com.tencent.mm.wear.app.ui.widget.b
{
  private BlockingQueue<com.tencent.mm.wear.app.d.a.b.g> adP;
  private i adT;
  private com.tencent.mm.wear.app.d.a.b.b agn;
  private com.tencent.mm.wear.app.d.a.b.d ago;
  private Vibrator agp;
  private RecordView agq;
  private TextView agr;
  private TextView ags;
  private d agt = new d(this, (byte)0);
  private int agu;
  
  private void P(String paramString)
  {
    this.agr.setText(paramString);
    this.ags.setText("");
  }
  
  private void nr()
  {
    if (this.ago != null)
    {
      this.ago.mP();
      this.ago = null;
    }
    if (this.agn != null)
    {
      this.agn.mO();
      this.agn = null;
    }
  }
  
  private void ns()
  {
    this.agu = 0;
    this.agt.removeMessages(4098);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyTextUI", "stop time ticker", new Object[0]);
  }
  
  public final void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramInt1 != 0) {
      com.tencent.mm.wear.a.c.d.a("MicroMsg.ReplyTextUI", "long request on action error code=%d funId=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    label237:
    do
    {
      return;
      paramArrayOfByte = h.mb().l(paramArrayOfByte);
      am localam = new am();
      for (;;)
      {
        try
        {
          localam.h(paramArrayOfByte);
          com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyTextUI", "response %b %s %d %s", new Object[] { Boolean.valueOf(localam.WD), localam.VN, Integer.valueOf(localam.WE), localam.Wt });
          if ((!localam.WD) || (localam.WE != 0)) {
            break label237;
          }
          paramArrayOfByte = localam.Wt;
          if (paramArrayOfByte.length() <= 10)
          {
            this.agq.cc(6);
            this.agq.setStatus(5);
            this.agr.setText("");
            this.ags.setText(paramArrayOfByte);
            this.agp.vibrate(150L);
            if (this.adT == null) {
              break;
            }
            this.adT.stop();
            this.adT = null;
            return;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          com.tencent.mm.wear.a.c.d.a("MicroMsg.ReplyTextUI", paramArrayOfByte);
          return;
        }
        if (paramArrayOfByte.length() <= 20) {
          this.agq.cc(3);
        } else {
          this.agq.cc(2);
        }
      }
      if (localam.WE == 1)
      {
        this.agq.setStatus(4);
        return;
      }
      this.agq.setStatus(-2);
    } while (this.adT == null);
    this.adT.stop();
    this.adT = null;
  }
  
  public final void aj(int paramInt1, int paramInt2)
  {
    paramInt2 = 2;
    switch (paramInt1)
    {
    case 0: 
    case 1: 
    case 5: 
    case 7: 
    default: 
      return;
    case 2: 
      com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyTextUI", "start to record", new Object[0]);
      this.adP = new LinkedBlockingQueue();
      this.adT = new i(h.mb().lS());
      this.adT.a(this);
      this.ago = new com.tencent.mm.wear.app.d.a.b.d(this.adP, 16000);
      this.ago.setPriority(1);
      this.ago.a(this);
      this.ago.start();
      this.agn = new com.tencent.mm.wear.app.d.a.b.b(this.adP, getUsername(), this.adT);
      this.agn.setPriority(1);
      this.agn.start();
      this.agu = 30;
      this.agt.removeMessages(4098);
      this.agt.sendEmptyMessage(4098);
      com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyTextUI", "start time ticker", new Object[0]);
      P(getString(2131165233));
      return;
    case 3: 
      P(getString(2131165228));
      return;
    case 4: 
      com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyTextUI", "stop to record", new Object[0]);
      long l = 0L;
      if (this.ago != null)
      {
        this.ago.mP();
        l = this.ago.mQ();
        this.ago = null;
      }
      if (this.agn != null)
      {
        if (l >= 1500L) {
          break label331;
        }
        this.agn.mO();
        this.agq.setStatus(-1);
      }
      for (;;)
      {
        this.agn = null;
        ns();
        return;
        this.agn.mN();
        P(getString(2131165236));
      }
    case -1: 
      P(getString(2131165239));
      nr();
      return;
    case -2: 
      P(getString(2131165235));
      nr();
      return;
    case 6: 
      label331:
      Object localObject = this.ags.getText().toString();
      P("");
      this.agq.setStatus(7);
      if (nd() > 0) {}
      for (paramInt1 = paramInt2;; paramInt1 = 1) {
        try
        {
          ah localah = new ah();
          localah.VN = getUsername();
          localah.Ws = paramInt1;
          localah.Wt = ((String)localObject);
          localObject = new com.tencent.mm.wear.app.f.e(nd(), 11023, localah.toByteArray());
          ((com.tencent.mm.wear.app.f.e)localObject).mU();
          ((com.tencent.mm.wear.app.f.e)localObject).a(new com.tencent.mm.wear.app.f.g()
          {
            public final void mV()
            {
              com.tencent.mm.wear.a.b.a.aiT.postDelayed(new Runnable()
              {
                public final void run()
                {
                  ReplyTextUI.this.finish();
                }
              }, 1000L);
            }
          });
          h.mc().a((com.tencent.mm.wear.app.g.a)localObject);
          com.tencent.mm.wear.app.d.a.bM(2);
          return;
        }
        catch (IOException localIOException)
        {
          return;
        }
      }
    }
    nr();
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
    if (MMActivity.isRound()) {
      return 2130903102;
    }
    return 2130903101;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    this.agq = ((RecordView)findViewById(2131558516));
    this.agr = ((TextView)findViewById(2131558517));
    this.ags = ((TextView)findViewById(2131558518));
    P("");
    this.agq.a(this);
    this.agq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        switch (ReplyTextUI.a(ReplyTextUI.this).getStatus())
        {
        case 0: 
        case 1: 
        default: 
          return;
        case 2: 
        case 3: 
          ReplyTextUI.a(ReplyTextUI.this).setStatus(4);
          return;
        case -3: 
        case -2: 
        case -1: 
          ReplyTextUI.a(ReplyTextUI.this).setStatus(2);
          return;
        }
        ReplyTextUI.a(ReplyTextUI.this).setStatus(-3);
      }
    });
    this.agq.setStatus(2);
    this.agp = ((Vibrator)getSystemService("vibrator"));
    N(getUsername());
  }
  
  protected void onDestroy()
  {
    nr();
    ns();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.ReplyTextUI
 * JD-Core Version:    0.7.0.1
 */
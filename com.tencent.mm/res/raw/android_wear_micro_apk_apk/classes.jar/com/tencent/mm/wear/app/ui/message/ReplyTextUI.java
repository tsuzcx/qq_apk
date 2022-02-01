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
  private BlockingQueue<com.tencent.mm.wear.app.d.a.b.g> ahr;
  private i ahv;
  private com.tencent.mm.wear.app.d.a.b.b ajP;
  private com.tencent.mm.wear.app.d.a.b.d ajQ;
  private Vibrator ajR;
  private RecordView ajS;
  private TextView ajT;
  private TextView ajU;
  private d ajV = new d(this, (byte)0);
  private int ajW;
  
  private void W(String paramString)
  {
    this.ajT.setText(paramString);
    this.ajU.setText("");
  }
  
  private void oe()
  {
    if (this.ajQ != null)
    {
      this.ajQ.nB();
      this.ajQ = null;
    }
    if (this.ajP != null)
    {
      this.ajP.nA();
      this.ajP = null;
    }
  }
  
  private void of()
  {
    this.ajW = 0;
    this.ajV.removeMessages(4098);
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
      paramArrayOfByte = h.mO().l(paramArrayOfByte);
      am localam = new am();
      for (;;)
      {
        try
        {
          localam.h(paramArrayOfByte);
          com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyTextUI", "response %b %s %d %s", new Object[] { Boolean.valueOf(localam.Yy), localam.XI, Integer.valueOf(localam.Yz), localam.Yo });
          if ((!localam.Yy) || (localam.Yz != 0)) {
            break label237;
          }
          paramArrayOfByte = localam.Yo;
          if (paramArrayOfByte.length() <= 10)
          {
            this.ajS.cy(6);
            this.ajS.setStatus(5);
            this.ajT.setText("");
            this.ajU.setText(paramArrayOfByte);
            this.ajR.vibrate(150L);
            if (this.ahv == null) {
              break;
            }
            this.ahv.stop();
            this.ahv = null;
            return;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          com.tencent.mm.wear.a.c.d.a("MicroMsg.ReplyTextUI", paramArrayOfByte);
          return;
        }
        if (paramArrayOfByte.length() <= 20) {
          this.ajS.cy(3);
        } else {
          this.ajS.cy(2);
        }
      }
      if (localam.Yz == 1)
      {
        this.ajS.setStatus(4);
        return;
      }
      this.ajS.setStatus(-2);
    } while (this.ahv == null);
    this.ahv.stop();
    this.ahv = null;
  }
  
  public final void am(int paramInt1, int paramInt2)
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
      this.ahr = new LinkedBlockingQueue();
      this.ahv = new i(h.mO().mF());
      this.ahv.a(this);
      this.ajQ = new com.tencent.mm.wear.app.d.a.b.d(this.ahr, 16000);
      this.ajQ.setPriority(1);
      this.ajQ.a(this);
      this.ajQ.start();
      this.ajP = new com.tencent.mm.wear.app.d.a.b.b(this.ahr, getUsername(), this.ahv);
      this.ajP.setPriority(1);
      this.ajP.start();
      this.ajW = 30;
      this.ajV.removeMessages(4098);
      this.ajV.sendEmptyMessage(4098);
      com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyTextUI", "start time ticker", new Object[0]);
      W(getString(2131165234));
      return;
    case 3: 
      W(getString(2131165229));
      return;
    case 4: 
      com.tencent.mm.wear.a.c.d.c("MicroMsg.ReplyTextUI", "stop to record", new Object[0]);
      long l = 0L;
      if (this.ajQ != null)
      {
        this.ajQ.nB();
        l = this.ajQ.nC();
        this.ajQ = null;
      }
      if (this.ajP != null)
      {
        if (l >= 1500L) {
          break label331;
        }
        this.ajP.nA();
        this.ajS.setStatus(-1);
      }
      for (;;)
      {
        this.ajP = null;
        of();
        return;
        this.ajP.nz();
        W(getString(2131165237));
      }
    case -1: 
      W(getString(2131165240));
      oe();
      return;
    case -2: 
      W(getString(2131165236));
      oe();
      return;
    case 6: 
      label331:
      Object localObject = this.ajU.getText().toString();
      W("");
      this.ajS.setStatus(7);
      if (nQ() > 0) {}
      for (paramInt1 = paramInt2;; paramInt1 = 1) {
        try
        {
          ah localah = new ah();
          localah.XI = getUsername();
          localah.Yn = paramInt1;
          localah.Yo = ((String)localObject);
          localObject = new com.tencent.mm.wear.app.f.e(nQ(), 11023, localah.toByteArray());
          ((com.tencent.mm.wear.app.f.e)localObject).nG();
          ((com.tencent.mm.wear.app.f.e)localObject).a(new com.tencent.mm.wear.app.f.g()
          {
            public final void nH()
            {
              com.tencent.mm.wear.a.b.a.amv.postDelayed(new Runnable()
              {
                public final void run()
                {
                  ReplyTextUI.this.finish();
                }
              }, 1000L);
            }
          });
          h.mP().a((com.tencent.mm.wear.app.g.a)localObject);
          com.tencent.mm.wear.app.d.a.ci(2);
          return;
        }
        catch (IOException localIOException)
        {
          return;
        }
      }
    }
    oe();
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
    if (MMActivity.isRound()) {
      return 2130903102;
    }
    return 2130903101;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    this.ajS = ((RecordView)findViewById(2131558517));
    this.ajT = ((TextView)findViewById(2131558518));
    this.ajU = ((TextView)findViewById(2131558519));
    W("");
    this.ajS.a(this);
    this.ajS.setOnClickListener(new View.OnClickListener()
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
    this.ajS.setStatus(2);
    this.ajR = ((Vibrator)getSystemService("vibrator"));
    U(getUsername());
  }
  
  protected void onDestroy()
  {
    oe();
    of();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.ReplyTextUI
 * JD-Core Version:    0.7.0.1
 */
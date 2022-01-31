package com.tencent.mm.wear.app.ui.emoji;

import android.content.res.AssetManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.e.a.ag;
import com.tencent.mm.e.a.f;
import com.tencent.mm.e.a.g;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.emoji.gif.MMGIFImageView;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.widget.e;
import java.io.IOException;
import java.util.LinkedList;

public class HeartBeatEmojiUI
  extends MMActivity
  implements SensorEventListener
{
  private com.tencent.mm.wear.app.ui.widget.d aeC;
  private SensorManager aeh;
  private Sensor afO;
  private MMGIFImageView afP;
  private LinkedList<String> afQ;
  private TextView afy;
  
  public final void nl()
  {
    Object localObject = new f();
    ((f)localObject).Vt = "com.tencent.xin.emoticon.heartbeatg";
    try
    {
      localObject = new com.tencent.mm.wear.app.f.b(11004, ((f)localObject).toByteArray());
      ((com.tencent.mm.wear.app.f.b)localObject).a(new com.tencent.mm.wear.app.f.d()
      {
        public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
        {
          g localg;
          if (paramAnonymousInt2 == 0) {
            localg = new g();
          }
          try
          {
            localg.h(paramAnonymousArrayOfByte);
            label20:
            HeartBeatEmojiUI.a(HeartBeatEmojiUI.this).addAll(localg.Vu);
            HeartBeatEmojiUI.b(HeartBeatEmojiUI.this);
            return;
          }
          catch (IOException paramAnonymousArrayOfByte)
          {
            break label20;
          }
        }
      });
      h.mc().a((com.tencent.mm.wear.app.g.a)localObject);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public final void no()
  {
    this.aeh = ((SensorManager)getSystemService("sensor"));
    this.afO = this.aeh.getDefaultSensor(21);
    if (this.afO != null) {
      this.aeh.registerListener(this, this.afO, 3);
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.HeartRateEmojiUI", "name %s, accuracy: %d", new Object[] { paramSensor.getName(), Integer.valueOf(paramInt) });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    setContentView(2130903054);
    this.afQ = new LinkedList();
    this.aeC = new com.tencent.mm.wear.app.ui.widget.d(this);
    this.afy = ((TextView)findViewById(2131558447));
    this.aeC.a(new e()
    {
      public final void onStart()
      {
        HeartBeatEmojiUI.this.nl();
      }
    });
    this.aeC.startLoading();
    this.afP = ((MMGIFImageView)findViewById(2131558456));
    try
    {
      this.afP.a(getAssets().open("heartbeat_bg.gif"), "");
      nl();
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.HeartRateEmojiUI", paramBundle);
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this.afO != null) {
      this.aeh.unregisterListener(this, this.afO);
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    h.mf().stop();
  }
  
  protected void onResume()
  {
    super.onResume();
    h.mf().start();
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = 2;
    int j = (int)paramSensorEvent.values[0];
    if (paramSensorEvent.accuracy > 0)
    {
      this.aeh.unregisterListener(this, this.afO);
      if (j > 70) {
        break label155;
      }
      paramSensorEvent = (String)this.afQ.get(2);
      if (nd() <= 0) {
        break label191;
      }
    }
    for (;;)
    {
      ag localag = new ag();
      localag.VN = getUsername();
      localag.Vr = paramSensorEvent;
      localag.Wt = getString(2131165210, new Object[] { Integer.valueOf(j) });
      localag.Ws = i;
      localag.Vt = "com.tencent.xin.emoticon.heartbeatg";
      label155:
      try
      {
        paramSensorEvent = new com.tencent.mm.wear.app.f.b(11025, localag.toByteArray());
        paramSensorEvent.F(true);
        paramSensorEvent.a(new com.tencent.mm.wear.app.f.d()
        {
          public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
          {
            com.tencent.mm.wear.app.g.a.nG();
            com.tencent.mm.wear.a.b.a.aiT.postDelayed(new Runnable()
            {
              public final void run()
              {
                HeartBeatEmojiUI.this.setResult(-1);
                HeartBeatEmojiUI.this.finish();
              }
            }, 1000L);
          }
        });
        h.mc().a(paramSensorEvent);
        return;
      }
      catch (IOException paramSensorEvent) {}
      if (j <= 90)
      {
        paramSensorEvent = (String)this.afQ.get(1);
        break;
      }
      paramSensorEvent = (String)this.afQ.get(0);
      break;
      label191:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.emoji.HeartBeatEmojiUI
 * JD-Core Version:    0.7.0.1
 */
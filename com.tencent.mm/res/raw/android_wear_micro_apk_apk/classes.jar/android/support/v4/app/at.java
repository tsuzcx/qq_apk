package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public final class at
{
  boolean gA = true;
  boolean gB;
  av gC;
  CharSequence gD;
  CharSequence[] gE;
  int gF;
  int gG;
  boolean gH;
  String gI;
  boolean gJ;
  String gK;
  boolean gL = false;
  boolean gM;
  boolean gN;
  String gO;
  int gP = 0;
  int gQ = 0;
  Notification gR;
  RemoteViews gS;
  RemoteViews gT;
  RemoteViews gU;
  String gV;
  int gW = 0;
  String gX;
  long gY;
  int gZ = 0;
  Bundle gl;
  public ArrayList<ar> gq = new ArrayList();
  CharSequence gr;
  CharSequence gs;
  PendingIntent gt;
  PendingIntent gu;
  RemoteViews gv;
  Bitmap gw;
  CharSequence gx;
  int gy;
  int gz;
  Notification ha = new Notification();
  @Deprecated
  public ArrayList<String> hb;
  public Context mContext;
  
  @Deprecated
  public at(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public at(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.gV = paramString;
    this.ha.when = System.currentTimeMillis();
    this.ha.audioStreamType = -1;
    this.gz = 0;
    this.hb = new ArrayList();
  }
  
  protected static CharSequence e(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    while (paramCharSequence.length() <= 5120) {
      return paramCharSequence;
    }
    return paramCharSequence.subSequence(0, 5120);
  }
  
  public final at a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this.gq.add(new ar(paramInt, paramCharSequence, paramPendingIntent));
    return this;
  }
  
  public final at a(long paramLong)
  {
    this.ha.when = paramLong;
    return this;
  }
  
  public final at a(PendingIntent paramPendingIntent)
  {
    this.gt = paramPendingIntent;
    return this;
  }
  
  public final at a(Bitmap paramBitmap)
  {
    this.gw = paramBitmap;
    return this;
  }
  
  public final at a(ar paramar)
  {
    this.gq.add(paramar);
    return this;
  }
  
  public final at a(av paramav)
  {
    if (this.gC != paramav)
    {
      this.gC = paramav;
      if (this.gC != null) {
        this.gC.b(this);
      }
    }
    return this;
  }
  
  public final at a(long[] paramArrayOfLong)
  {
    this.ha.vibrate = paramArrayOfLong;
    return this;
  }
  
  public final at aM()
  {
    Notification localNotification = this.ha;
    localNotification.flags |= 0x10;
    return this;
  }
  
  public final at aN()
  {
    this.gL = true;
    return this;
  }
  
  public final at aO()
  {
    this.gz = 2;
    return this;
  }
  
  public final at b(PendingIntent paramPendingIntent)
  {
    this.ha.deleteIntent = paramPendingIntent;
    return this;
  }
  
  public final at b(CharSequence paramCharSequence)
  {
    this.gr = e(paramCharSequence);
    return this;
  }
  
  public final Notification build()
  {
    return new ax(this).build();
  }
  
  public final at c(CharSequence paramCharSequence)
  {
    this.gs = e(paramCharSequence);
    return this;
  }
  
  public final at d(CharSequence paramCharSequence)
  {
    this.ha.tickerText = e(paramCharSequence);
    return this;
  }
  
  public final at t(int paramInt)
  {
    this.ha.icon = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.at
 * JD-Core Version:    0.7.0.1
 */
package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public final class ar
{
  public CharSequence eC;
  public CharSequence eD;
  PendingIntent eE;
  PendingIntent eF;
  RemoteViews eG;
  public Bitmap eH;
  public CharSequence eI;
  public int eJ;
  int eK;
  boolean eL = true;
  public boolean eM;
  public bc eN;
  public CharSequence eO;
  public CharSequence[] eP;
  int eQ;
  int eR;
  boolean eS;
  String eT;
  boolean eU;
  String eV;
  public ArrayList<ap> eW = new ArrayList();
  boolean eX = false;
  boolean eY;
  boolean eZ;
  Bundle ew;
  String fa;
  int fb = 0;
  int fc = 0;
  Notification fd;
  RemoteViews fe;
  RemoteViews ff;
  RemoteViews fg;
  String fh;
  int fi = 0;
  String fj;
  long fk;
  private int fl = 0;
  public Notification fm = new Notification();
  public ArrayList<String> fn;
  public Context mContext;
  
  private ar(Context paramContext)
  {
    this.mContext = paramContext;
    this.fh = null;
    this.fm.when = System.currentTimeMillis();
    this.fm.audioStreamType = -1;
    this.eK = 0;
    this.fn = new ArrayList();
  }
  
  @Deprecated
  public ar(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  protected static CharSequence e(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    while (paramCharSequence.length() <= 5120) {
      return paramCharSequence;
    }
    return paramCharSequence.subSequence(0, 5120);
  }
  
  public final ar a(PendingIntent paramPendingIntent)
  {
    this.eE = paramPendingIntent;
    return this;
  }
  
  public final ar a(bc parambc)
  {
    if (this.eN != parambc)
    {
      this.eN = parambc;
      if (this.eN != null) {
        this.eN.c(this);
      }
    }
    return this;
  }
  
  public final ar aB()
  {
    this.eX = true;
    return this;
  }
  
  public final ar b(CharSequence paramCharSequence)
  {
    this.eC = e(paramCharSequence);
    return this;
  }
  
  public final Notification build()
  {
    bb localbb = ao.ev;
    new as();
    return localbb.b(this);
  }
  
  public final ar c(CharSequence paramCharSequence)
  {
    this.eD = e(paramCharSequence);
    return this;
  }
  
  public final ar d(CharSequence paramCharSequence)
  {
    this.fm.tickerText = e(paramCharSequence);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ar
 * JD-Core Version:    0.7.0.1
 */
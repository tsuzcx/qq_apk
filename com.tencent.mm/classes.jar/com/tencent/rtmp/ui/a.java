package com.tencent.rtmp.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.rtmp.TXLiveBase;
import java.text.SimpleDateFormat;

public class a
  extends LinearLayout
{
  StringBuffer a = new StringBuffer("");
  private TextView b;
  private TextView c;
  private ScrollView d;
  private ScrollView e;
  private final int f = 3000;
  private boolean g = false;
  
  public a(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.b = new TextView(paramContext);
    this.c = new TextView(paramContext);
    this.d = new ScrollView(paramContext);
    this.e = new ScrollView(paramContext);
    paramAttributeSet = new LinearLayout.LayoutParams(-1, 0);
    paramAttributeSet.weight = 0.2F;
    this.d.setLayoutParams(paramAttributeSet);
    this.d.setBackgroundColor(1627389951);
    this.d.setVerticalScrollBarEnabled(true);
    this.d.setScrollbarFadingEnabled(true);
    paramAttributeSet = new LinearLayout.LayoutParams(-1, -1);
    this.b.setLayoutParams(paramAttributeSet);
    this.b.setTextSize(2, 11.0F);
    this.b.setTextColor(-16777216);
    this.b.setTypeface(Typeface.MONOSPACE, 1);
    this.b.setLineSpacing(4.0F, 1.0F);
    this.b.setPadding(a(paramContext, 2.0F), a(paramContext, 2.0F), a(paramContext, 2.0F), a(paramContext, 2.0F));
    this.d.addView(this.b);
    paramAttributeSet = new LinearLayout.LayoutParams(-1, 0);
    paramAttributeSet.weight = 0.8F;
    paramAttributeSet.topMargin = a(paramContext, 2.0F);
    this.e.setLayoutParams(paramAttributeSet);
    this.e.setBackgroundColor(1627389951);
    this.e.setVerticalScrollBarEnabled(true);
    this.e.setScrollbarFadingEnabled(true);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    this.c.setLayoutParams(paramAttributeSet);
    this.c.setTextSize(2, 13.0F);
    this.c.setTextColor(-16777216);
    this.c.setPadding(a(paramContext, 2.0F), a(paramContext, 2.0F), a(paramContext, 2.0F), a(paramContext, 2.0F));
    this.e.addView(this.c);
    addView(this.d);
    addView(this.e);
    setVisibility(8);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a(ScrollView paramScrollView, View paramView)
  {
    if ((paramScrollView == null) || (paramView == null)) {
      return;
    }
    int j = paramView.getMeasuredHeight() - paramScrollView.getMeasuredHeight();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    paramScrollView.scrollTo(0, i);
  }
  
  protected String a(Bundle paramBundle)
  {
    return String.format("%-16s %-16s %-16s\n%-12s %-12s %-12s %-12s\n%-14s %-14s %-14s\n%-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("CODEC_CACHE") + " | " + paramBundle.getInt("CACHE_SIZE") + "," + paramBundle.getInt("VIDEO_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_PLAY_SPEED")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("CODEC_DROP_CNT") + "|" + paramBundle.getInt("DROP_SIZE"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") });
  }
  
  public void a()
  {
    this.a.setLength(0);
    this.b.setText("");
    this.c.setText("");
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (paramInt == 1020) {
      return;
    }
    String str = new SimpleDateFormat("HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis()));
    while (this.a.length() > 3000)
    {
      int i = this.a.indexOf("\n");
      paramInt = i;
      if (i == 0) {
        paramInt = 1;
      }
      this.a = this.a.delete(0, paramInt);
    }
    this.a = this.a.append("\n[" + str + "]" + paramString);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2, int paramInt)
  {
    if (this.g) {}
    label7:
    do
    {
      do
      {
        do
        {
          break label7;
          do
          {
            return;
          } while ((paramInt == 2011) || (paramInt == 2012));
          if ((paramBundle1 != null) && (getVisibility() == 0)) {
            this.b.setText(a(paramBundle1));
          }
          if (this.a.length() <= 0) {
            this.a.append("liteav sdk version:" + TXLiveBase.getSDKVersionStr());
          }
        } while (paramBundle2 == null);
        paramBundle1 = paramBundle2.getString("EVT_MSG");
      } while ((paramBundle1 == null) || (paramBundle1.isEmpty()));
      a(paramInt, paramBundle1);
    } while (getVisibility() != 0);
    this.c.setText(this.a.toString());
    a(this.e, this.c);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.c.setText(this.a.toString());
      a(this.e, this.c);
      return;
    }
    this.c.setText("");
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.rtmp.ui.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;

public class TXDashBoard
  extends LinearLayout
{
  protected TextView a;
  protected TextView b;
  protected ScrollView c;
  protected StringBuffer d;
  protected int e;
  private final SimpleDateFormat f;
  private boolean g;
  
  public TXDashBoard(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TXDashBoard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(146872);
    this.d = new StringBuffer("");
    this.e = 3000;
    this.f = new SimpleDateFormat("HH:mm:ss.SSS");
    this.g = false;
    setOrientation(1);
    this.a = new TextView(paramContext);
    this.b = new TextView(paramContext);
    this.c = new ScrollView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.a.setLayoutParams(paramContext);
    this.a.setTextColor(-49023);
    this.a.setTypeface(Typeface.MONOSPACE);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.c.setPadding(0, 10, 0, 0);
    this.c.setLayoutParams(paramContext);
    this.c.setVerticalScrollBarEnabled(true);
    this.c.setScrollbarFadingEnabled(true);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.b.setLayoutParams(paramContext);
    this.b.setTextColor(-49023);
    this.c.addView(this.b);
    addView(this.a);
    addView(this.c);
    setVisibility(4);
    AppMethodBeat.o(146872);
  }
  
  private void a(ScrollView paramScrollView, View paramView)
  {
    AppMethodBeat.i(146883);
    if ((paramScrollView == null) || (paramView == null))
    {
      AppMethodBeat.o(146883);
      return;
    }
    int j = paramView.getMeasuredHeight() - paramScrollView.getMeasuredHeight();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    paramScrollView.scrollTo(0, i);
    AppMethodBeat.o(146883);
  }
  
  protected String a(Bundle paramBundle)
  {
    AppMethodBeat.i(146882);
    paramBundle = String.format("%-16s %-16s %-16s\n%-12s %-12s %-12s %-12s\n%-14s %-14s %-14s\n%-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") });
    AppMethodBeat.o(146882);
    return paramBundle;
  }
  
  public void a()
  {
    AppMethodBeat.i(146879);
    this.d.setLength(0);
    this.a.setText("");
    this.b.setText("");
    AppMethodBeat.o(146879);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(146874);
    this.a.setPadding(paramInt1, paramInt2, paramInt3, 0);
    this.c.setPadding(paramInt1, 0, paramInt3, paramInt4);
    AppMethodBeat.o(146874);
  }
  
  protected void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(146881);
    if (paramInt == 1020)
    {
      AppMethodBeat.o(146881);
      return;
    }
    String str = new SimpleDateFormat("HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis()));
    while (this.d.length() > this.e)
    {
      int i = this.d.indexOf("\n");
      paramInt = i;
      if (i == 0) {
        paramInt = 1;
      }
      this.d = this.d.delete(0, paramInt);
    }
    this.d = this.d.append("\n[" + str + "]" + paramString);
    AppMethodBeat.o(146881);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2, int paramInt)
  {
    AppMethodBeat.i(146880);
    if (this.g)
    {
      AppMethodBeat.o(146880);
      return;
    }
    if ((paramInt == 2011) || (paramInt == 2012))
    {
      AppMethodBeat.o(146880);
      return;
    }
    if (paramBundle1 != null) {
      this.a.setText(a(paramBundle1));
    }
    if (this.d.length() <= 0) {
      this.d.append("liteav sdk version:" + TXCCommonUtil.getSDKVersionStr());
    }
    if (paramBundle2 != null)
    {
      paramBundle1 = paramBundle2.getString("EVT_MSG");
      if ((paramBundle1 != null) && (!paramBundle1.isEmpty()))
      {
        a(paramInt, paramBundle1);
        this.b.setText(this.d.toString());
        if (getVisibility() == 0) {
          a(this.c, this.b);
        }
      }
    }
    AppMethodBeat.o(146880);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(146876);
    this.a.setText(paramCharSequence);
    AppMethodBeat.o(146876);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(146878);
    String str = this.f.format(Long.valueOf(System.currentTimeMillis()));
    paramString = "[" + str + "]" + paramString + "\n";
    while (this.d.length() > this.e)
    {
      int j = this.d.indexOf("\n");
      int i = j;
      if (j == 0) {
        i = 1;
      }
      this.d = this.d.delete(0, i);
    }
    this.d = this.d.append(paramString);
    this.b.setText("liteav sdk version:" + TXCCommonUtil.getSDKVersionStr() + "\n" + this.d.toString());
    AppMethodBeat.o(146878);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setEventTextSize(float paramFloat)
  {
    AppMethodBeat.i(146875);
    this.b.setTextSize(paramFloat);
    AppMethodBeat.o(146875);
  }
  
  public void setLogMsgLenLimit(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setShowLevel(int paramInt)
  {
    AppMethodBeat.i(146877);
    switch (paramInt)
    {
    default: 
      this.a.setVisibility(0);
      this.c.setVisibility(0);
      setVisibility(0);
      AppMethodBeat.o(146877);
      return;
    case 0: 
      this.a.setVisibility(4);
      this.c.setVisibility(4);
      setVisibility(4);
      AppMethodBeat.o(146877);
      return;
    }
    this.a.setVisibility(0);
    this.c.setVisibility(4);
    setVisibility(0);
    AppMethodBeat.o(146877);
  }
  
  public void setStatusTextSize(float paramFloat)
  {
    AppMethodBeat.i(146873);
    this.a.setTextSize(paramFloat);
    AppMethodBeat.o(146873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXDashBoard
 * JD-Core Version:    0.7.0.1
 */
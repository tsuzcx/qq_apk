package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
    AppMethodBeat.i(14271);
    this.d = new StringBuffer("");
    this.e = 3000;
    this.f = new SimpleDateFormat("HH:mm:ss.SSS");
    this.g = false;
    setOrientation(1);
    setVisibility(4);
    AppMethodBeat.o(14271);
  }
  
  private void a(ScrollView paramScrollView, View paramView)
  {
    AppMethodBeat.i(14283);
    if ((paramScrollView == null) || (paramView == null))
    {
      AppMethodBeat.o(14283);
      return;
    }
    int j = paramView.getMeasuredHeight() - paramScrollView.getMeasuredHeight();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    paramScrollView.scrollTo(0, i);
    AppMethodBeat.o(14283);
  }
  
  private void b()
  {
    AppMethodBeat.i(14277);
    if (this.a != null)
    {
      AppMethodBeat.o(14277);
      return;
    }
    this.a = new TextView(getContext());
    this.b = new TextView(getContext());
    this.c = new ScrollView(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a.setTextColor(-49023);
    this.a.setTypeface(Typeface.MONOSPACE);
    localObject = new LinearLayout.LayoutParams(-1, -1);
    this.c.setPadding(0, 10, 0, 0);
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setVerticalScrollBarEnabled(true);
    this.c.setScrollbarFadingEnabled(true);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setTextColor(-49023);
    this.c.addView(this.b);
    addView(this.a);
    addView(this.c);
    if (this.d.length() <= 0) {
      this.d.append("liteav sdk version:" + TXCCommonUtil.getSDKVersionStr() + "\n");
    }
    this.b.setText(this.d.toString());
    AppMethodBeat.o(14277);
  }
  
  protected String a(Bundle paramBundle)
  {
    AppMethodBeat.i(14282);
    paramBundle = String.format("%-16s %-16s %-16s\n%-12s %-12s %-12s %-12s\n%-14s %-14s %-14s\n%-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") });
    AppMethodBeat.o(14282);
    return paramBundle;
  }
  
  public void a()
  {
    AppMethodBeat.i(14279);
    this.d.setLength(0);
    if (this.a != null) {
      this.a.setText("");
    }
    if (this.b != null) {
      this.b.setText("");
    }
    AppMethodBeat.o(14279);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(14273);
    if (this.a != null) {
      this.a.setPadding(paramInt1, paramInt2, paramInt3, 0);
    }
    if (this.c != null) {
      this.c.setPadding(paramInt1, 0, paramInt3, paramInt4);
    }
    AppMethodBeat.o(14273);
  }
  
  protected void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(14281);
    if (paramInt == 1020)
    {
      AppMethodBeat.o(14281);
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
    AppMethodBeat.o(14281);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2, int paramInt)
  {
    AppMethodBeat.i(14280);
    if (this.g)
    {
      AppMethodBeat.o(14280);
      return;
    }
    if ((paramInt == 2011) || (paramInt == 2012))
    {
      AppMethodBeat.o(14280);
      return;
    }
    if ((paramBundle1 != null) && (this.a != null)) {
      this.a.setText(a(paramBundle1));
    }
    if (this.d.length() <= 0) {
      this.d.append("liteav sdk version:" + TXCCommonUtil.getSDKVersionStr() + "\n");
    }
    if (paramBundle2 != null)
    {
      paramBundle1 = paramBundle2.getString("EVT_MSG");
      if ((paramBundle1 != null) && (!paramBundle1.isEmpty()))
      {
        a(paramInt, paramBundle1);
        if (this.b != null) {
          this.b.setText(this.d.toString());
        }
        if ((getVisibility() == 0) && (this.c != null) && (this.b != null)) {
          a(this.c, this.b);
        }
      }
    }
    AppMethodBeat.o(14280);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(14275);
    if (this.a != null) {
      this.a.setText(paramCharSequence);
    }
    AppMethodBeat.o(14275);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(14278);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(14278);
      return;
    }
    String str = this.f.format(Long.valueOf(System.currentTimeMillis()));
    paramString = "[" + str + "]" + paramString + "\n";
    if (this.d.length() <= 0) {
      this.d.append("liteav sdk version:" + TXCCommonUtil.getSDKVersionStr() + "\n");
    }
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
    if (this.b != null) {
      this.b.setText(this.d.toString());
    }
    AppMethodBeat.o(14278);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setEventTextSize(float paramFloat)
  {
    AppMethodBeat.i(14274);
    if (this.b != null) {
      this.b.setTextSize(paramFloat);
    }
    AppMethodBeat.o(14274);
  }
  
  public void setLogMsgLenLimit(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setShowLevel(int paramInt)
  {
    AppMethodBeat.i(14276);
    switch (paramInt)
    {
    default: 
      b();
      this.a.setVisibility(0);
      this.c.setVisibility(0);
      setVisibility(0);
      AppMethodBeat.o(14276);
      return;
    case 0: 
      if (this.a != null) {
        this.a.setVisibility(4);
      }
      if (this.c != null) {
        this.c.setVisibility(4);
      }
      setVisibility(4);
      AppMethodBeat.o(14276);
      return;
    }
    b();
    this.a.setVisibility(0);
    this.c.setVisibility(4);
    setVisibility(0);
    AppMethodBeat.o(14276);
  }
  
  public void setStatusTextSize(float paramFloat)
  {
    AppMethodBeat.i(14272);
    if (this.a != null) {
      this.a.setTextSize(paramFloat);
    }
    AppMethodBeat.o(14272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXDashBoard
 * JD-Core Version:    0.7.0.1
 */
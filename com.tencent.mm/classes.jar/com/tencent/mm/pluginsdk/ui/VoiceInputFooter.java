package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.pluginsdk.ui.chat.n.a;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter
  extends BasePanelKeybordLayout
{
  private MMActivity bER;
  ChatFooterPanel jpC;
  LinearLayout mqY;
  MMEditText pdp = null;
  n saW;
  ImageButton saX;
  private ImageButton saY;
  private boolean saZ = false;
  private boolean sba = false;
  private final int sbb = 1;
  private final int sbc = 2;
  private a sbd;
  
  public VoiceInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    paramContext = (ViewGroup)com.tencent.mm.ui.y.gt(this.bER).inflate(R.i.voice_input_ui_footer, this);
    this.saY = ((ImageButton)paramContext.findViewById(R.h.album_voiceinput_mode_iv));
    this.saY.setOnClickListener(new VoiceInputFooter.3(this));
    this.saX = ((ImageButton)paramContext.findViewById(R.h.album_comment_mode_iv));
    this.saX.setOnClickListener(new VoiceInputFooter.4(this));
    if (e.sgr == null)
    {
      this.jpC = new d(this.bER);
      return;
    }
    this.jpC = e.sgr.cX(getContext());
    this.jpC.setEntranceScene(ChatFooterPanel.rZu);
    this.jpC.setVisibility(8);
    this.mqY = ((LinearLayout)findViewById(R.h.root));
    this.mqY.setOnClickListener(null);
    this.mqY.addView(this.jpC, -1, 0);
    this.jpC.sk();
    this.jpC.aN(false);
    this.jpC.setOnTextOperationListener(new VoiceInputFooter.5(this));
  }
  
  private static void jdMethod_if(int paramInt)
  {
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramInt == 1) {
      localVoiceInputBehavior.smileIconClick = 1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      log_13905 locallog_13905 = new log_13905();
      locallog_13905.viOp_ = localVoiceInputBehavior;
      h.nFQ.c(13905, locallog_13905);
      do
      {
        return;
      } while (paramInt != 2);
      localVoiceInputBehavior.voiceIconClick = 1;
    }
  }
  
  public final boolean bJX()
  {
    return this.jpC.getVisibility() == 0;
  }
  
  public final boolean cmA()
  {
    return this.saW.getVisibility() == 0;
  }
  
  final void cmB()
  {
    this.saZ = false;
    if (this.saW != null)
    {
      this.saW.pause();
      this.saW.setVisibility(8);
      this.saY.setImageResource(R.g.voiceinputui_setmode_voice_btn);
      int i = a.ab(this.bER, R.f.voice_input_album_voiceinput_padding);
      this.saY.setPadding(0, 0, i, 0);
      this.saX.setVisibility(0);
      if (this.sbd != null) {
        this.sbd.lR(false);
      }
    }
  }
  
  protected List<View> getPanelView()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jpC);
    localArrayList.add(this.saW);
    return localArrayList;
  }
  
  final void hideSmileyPanel()
  {
    this.sba = false;
    this.jpC.onPause();
    this.jpC.setVisibility(8);
  }
  
  public void setVoiceInputFooterListener(a parama)
  {
    this.sbd = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cmC();
    
    public abstract void lR(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter
 * JD-Core Version:    0.7.0.1
 */
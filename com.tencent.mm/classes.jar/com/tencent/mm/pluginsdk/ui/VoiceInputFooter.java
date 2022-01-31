package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.pluginsdk.ui.chat.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter
  extends BasePanelKeybordLayout
{
  private MMActivity cmc;
  private ChatFooterPanel eys;
  MMEditText kju;
  LinearLayout oQN;
  n vSd;
  ImageButton vSe;
  private ImageButton vSf;
  private boolean vSg;
  private boolean vSh;
  private final int vSi;
  private final int vSj;
  private VoiceInputFooter.a vSk;
  
  public VoiceInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27560);
    this.kju = null;
    this.vSg = false;
    this.vSh = false;
    this.vSi = 1;
    this.vSj = 2;
    this.cmc = ((MMActivity)paramContext);
    paramContext = (ViewGroup)w.hM(this.cmc).inflate(2130971091, this);
    this.vSf = ((ImageButton)paramContext.findViewById(2131828761));
    this.vSf.setOnClickListener(new VoiceInputFooter.3(this));
    this.vSe = ((ImageButton)paramContext.findViewById(2131825850));
    this.vSe.setOnClickListener(new VoiceInputFooter.4(this));
    if (e.vYI == null)
    {
      this.eys = new d(this.cmc);
      AppMethodBeat.o(27560);
      return;
    }
    this.eys = e.vYI.dK(getContext());
    this.eys.setEntranceScene(ChatFooterPanel.vQl);
    this.eys.setVisibility(8);
    this.oQN = ((LinearLayout)findViewById(2131821003));
    this.oQN.setOnClickListener(null);
    this.oQN.addView(this.eys, -1, 0);
    this.eys.Az();
    this.eys.bo(false);
    this.eys.onResume();
    this.eys.setOnTextOperationListener(new VoiceInputFooter.5(this));
    AppMethodBeat.o(27560);
  }
  
  private static void kS(int paramInt)
  {
    AppMethodBeat.i(27567);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramInt == 1) {
      localVoiceInputBehavior.smileIconClick = 1;
    }
    for (;;)
    {
      ab.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      log_13905 locallog_13905 = new log_13905();
      locallog_13905.viOp_ = localVoiceInputBehavior;
      h.qsU.c(13905, locallog_13905);
      AppMethodBeat.o(27567);
      return;
      if (paramInt != 2) {
        break;
      }
      localVoiceInputBehavior.voiceIconClick = 1;
    }
    AppMethodBeat.o(27567);
  }
  
  final void aRm()
  {
    AppMethodBeat.i(27564);
    this.vSh = false;
    this.eys.onPause();
    this.eys.setVisibility(8);
    AppMethodBeat.o(27564);
  }
  
  public final boolean bad()
  {
    AppMethodBeat.i(27561);
    if (this.eys.getVisibility() == 0)
    {
      AppMethodBeat.o(27561);
      return true;
    }
    AppMethodBeat.o(27561);
    return false;
  }
  
  public final boolean dnq()
  {
    AppMethodBeat.i(27562);
    if (this.vSd.getVisibility() == 0)
    {
      AppMethodBeat.o(27562);
      return true;
    }
    AppMethodBeat.o(27562);
    return false;
  }
  
  final void dnr()
  {
    AppMethodBeat.i(27563);
    this.vSg = false;
    if (this.vSd != null)
    {
      this.vSd.pause();
      this.vSd.setVisibility(8);
      this.vSf.setImageResource(2130840704);
      this.vSe.setVisibility(0);
      if (this.vSk != null) {
        this.vSk.pe(false);
      }
    }
    AppMethodBeat.o(27563);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(27565);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.eys);
    localArrayList.add(this.vSd);
    AppMethodBeat.o(27565);
    return localArrayList;
  }
  
  public final void release()
  {
    AppMethodBeat.i(27566);
    if (this.eys != null)
    {
      this.eys.Ay();
      this.eys.destroy();
    }
    if (this.vSd != null) {
      this.vSd.destroy();
    }
    AppMethodBeat.o(27566);
  }
  
  public void setVoiceInputFooterListener(VoiceInputFooter.a parama)
  {
    this.vSk = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter
 * JD-Core Version:    0.7.0.1
 */
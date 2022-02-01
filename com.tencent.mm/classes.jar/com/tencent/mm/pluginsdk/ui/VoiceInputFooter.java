package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.pluginsdk.ui.chat.n.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter
  extends BasePanelKeybordLayout
{
  MMEditText Rxv;
  n Yab;
  ImageButton Yac;
  private ImageButton Yad;
  private boolean Yae;
  private boolean Yaf;
  private final int Yag;
  private final int Yah;
  private a Yai;
  private MMActivity lzt;
  private ChatFooterPanel moD;
  LinearLayout ybr;
  
  public VoiceInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31262);
    this.Rxv = null;
    this.Yae = false;
    this.Yaf = false;
    this.Yag = 1;
    this.Yah = 2;
    this.lzt = ((MMActivity)paramContext);
    paramContext = (ViewGroup)af.mU(this.lzt).inflate(R.i.goT, this);
    this.Yad = ((ImageButton)paramContext.findViewById(R.h.frb));
    this.Yad.setOnClickListener(new VoiceInputFooter.3(this));
    this.Yac = ((ImageButton)paramContext.findViewById(R.h.album_comment_mode_iv));
    this.Yac.setOnClickListener(new VoiceInputFooter.4(this));
    if (e.Ykf == null)
    {
      this.moD = new d(this.lzt);
      AppMethodBeat.o(31262);
      return;
    }
    this.moD = e.Ykf.fZ(getContext());
    this.moD.setEntranceScene(ChatFooterPanel.XYl);
    this.moD.setVisibility(8);
    this.ybr = ((LinearLayout)findViewById(R.h.root));
    this.ybr.setOnClickListener(null);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    this.ybr.addView(this.moD, -1, i);
    this.moD.iKh();
    this.moD.onResume();
    this.moD.setOnTextOperationListener(new VoiceInputFooter.5(this));
    AppMethodBeat.o(31262);
  }
  
  private static void rG(int paramInt)
  {
    AppMethodBeat.i(31269);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramInt == 1) {
      localVoiceInputBehavior.smileIconClick = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      log_13905 locallog_13905 = new log_13905();
      locallog_13905.viOp_ = localVoiceInputBehavior;
      h.OAn.c(13905, locallog_13905);
      AppMethodBeat.o(31269);
      return;
      if (paramInt != 2) {
        break;
      }
      localVoiceInputBehavior.voiceIconClick = 1;
    }
    AppMethodBeat.o(31269);
  }
  
  final void aWJ()
  {
    AppMethodBeat.i(31266);
    this.Yaf = false;
    this.moD.onPause();
    this.moD.setVisibility(8);
    AppMethodBeat.o(31266);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(31267);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.moD);
    localArrayList.add(this.Yab);
    AppMethodBeat.o(31267);
    return localArrayList;
  }
  
  public final boolean hqp()
  {
    AppMethodBeat.i(31263);
    if (this.moD.getVisibility() == 0)
    {
      AppMethodBeat.o(31263);
      return true;
    }
    AppMethodBeat.o(31263);
    return false;
  }
  
  public final boolean iKL()
  {
    AppMethodBeat.i(31264);
    if (this.Yab.getVisibility() == 0)
    {
      AppMethodBeat.o(31264);
      return true;
    }
    AppMethodBeat.o(31264);
    return false;
  }
  
  final void iKM()
  {
    AppMethodBeat.i(31265);
    this.Yae = false;
    if (this.Yab != null)
    {
      this.Yab.pause();
      this.Yab.setVisibility(8);
      this.Yad.setImageResource(R.g.fpL);
      this.Yac.setVisibility(0);
      if (this.Yai != null) {
        this.Yai.JF(false);
      }
    }
    AppMethodBeat.o(31265);
  }
  
  public final void release()
  {
    AppMethodBeat.i(31268);
    if (this.moD != null)
    {
      this.moD.iKg();
      this.moD.destroy();
    }
    if (this.Yab != null) {
      this.Yab.destroy();
    }
    AppMethodBeat.o(31268);
  }
  
  public void setVoiceInputFooterListener(a parama)
  {
    this.Yai = parama;
  }
  
  public static abstract interface a
  {
    public abstract void JF(boolean paramBoolean);
    
    public abstract void iKO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter
 * JD-Core Version:    0.7.0.1
 */
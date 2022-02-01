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
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter
  extends BasePanelKeybordLayout
{
  LinearLayout FiY;
  MMEditText KXu;
  n RdV;
  ImageButton RdW;
  private ImageButton RdX;
  private boolean RdY;
  private boolean RdZ;
  private final int Rea;
  private final int Reb;
  private a Rec;
  private MMActivity iXq;
  private ChatFooterPanel jPN;
  
  public VoiceInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31262);
    this.KXu = null;
    this.RdY = false;
    this.RdZ = false;
    this.Rea = 1;
    this.Reb = 2;
    this.iXq = ((MMActivity)paramContext);
    paramContext = (ViewGroup)ad.kS(this.iXq).inflate(R.i.elP, this);
    this.RdX = ((ImageButton)paramContext.findViewById(R.h.dqN));
    this.RdX.setOnClickListener(new VoiceInputFooter.3(this));
    this.RdW = ((ImageButton)paramContext.findViewById(R.h.album_comment_mode_iv));
    this.RdW.setOnClickListener(new VoiceInputFooter.4(this));
    if (e.RnO == null)
    {
      this.jPN = new d(this.iXq);
      AppMethodBeat.o(31262);
      return;
    }
    this.jPN = e.RnO.fd(getContext());
    this.jPN.setEntranceScene(ChatFooterPanel.Rcg);
    this.jPN.setVisibility(8);
    this.FiY = ((LinearLayout)findViewById(R.h.root));
    this.FiY.setOnClickListener(null);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    this.FiY.addView(this.jPN, -1, i);
    this.jPN.hjp();
    this.jPN.onResume();
    this.jPN.setOnTextOperationListener(new VoiceInputFooter.5(this));
    AppMethodBeat.o(31262);
  }
  
  private static void rE(int paramInt)
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
      h.IzE.c(13905, locallog_13905);
      AppMethodBeat.o(31269);
      return;
      if (paramInt != 2) {
        break;
      }
      localVoiceInputBehavior.voiceIconClick = 1;
    }
    AppMethodBeat.o(31269);
  }
  
  final void aDL()
  {
    AppMethodBeat.i(31266);
    this.RdZ = false;
    this.jPN.onPause();
    this.jPN.setVisibility(8);
    AppMethodBeat.o(31266);
  }
  
  public final boolean fXU()
  {
    AppMethodBeat.i(31263);
    if (this.jPN.getVisibility() == 0)
    {
      AppMethodBeat.o(31263);
      return true;
    }
    AppMethodBeat.o(31263);
    return false;
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(31267);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jPN);
    localArrayList.add(this.RdV);
    AppMethodBeat.o(31267);
    return localArrayList;
  }
  
  public final boolean hjT()
  {
    AppMethodBeat.i(31264);
    if (this.RdV.getVisibility() == 0)
    {
      AppMethodBeat.o(31264);
      return true;
    }
    AppMethodBeat.o(31264);
    return false;
  }
  
  final void hjU()
  {
    AppMethodBeat.i(31265);
    this.RdY = false;
    if (this.RdV != null)
    {
      this.RdV.pause();
      this.RdV.setVisibility(8);
      this.RdX.setImageResource(R.g.dpw);
      this.RdW.setVisibility(0);
      if (this.Rec != null) {
        this.Rec.DW(false);
      }
    }
    AppMethodBeat.o(31265);
  }
  
  public final void release()
  {
    AppMethodBeat.i(31268);
    if (this.jPN != null)
    {
      this.jPN.hjm();
      this.jPN.destroy();
    }
    if (this.RdV != null) {
      this.RdV.destroy();
    }
    AppMethodBeat.o(31268);
  }
  
  public void setVoiceInputFooterListener(a parama)
  {
    this.Rec = parama;
  }
  
  public static abstract interface a
  {
    public abstract void DW(boolean paramBoolean);
    
    public abstract void hjW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter
 * JD-Core Version:    0.7.0.1
 */
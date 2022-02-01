package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.pluginsdk.ui.chat.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter
  extends BasePanelKeybordLayout
{
  n DoY;
  ImageButton DoZ;
  private ImageButton Dpa;
  private boolean Dpb;
  private boolean Dpc;
  private final int Dpd;
  private final int Dpe;
  private a Dpf;
  private ChatFooterPanel fWT;
  private MMActivity iMV;
  LinearLayout uUm;
  MMEditText yRm;
  
  public VoiceInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31262);
    this.yRm = null;
    this.Dpb = false;
    this.Dpc = false;
    this.Dpd = 1;
    this.Dpe = 2;
    this.iMV = ((MMActivity)paramContext);
    paramContext = (ViewGroup)z.jD(this.iMV).inflate(2131495861, this);
    this.Dpa = ((ImageButton)paramContext.findViewById(2131296629));
    this.Dpa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31257);
        VoiceInputFooter.c(VoiceInputFooter.this);
        AppMethodBeat.o(31257);
      }
    });
    this.DoZ = ((ImageButton)paramContext.findViewById(2131296558));
    this.DoZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31258);
        VoiceInputFooter.d(VoiceInputFooter.this);
        AppMethodBeat.o(31258);
      }
    });
    if (e.DyA == null)
    {
      this.fWT = new d(this.iMV);
      AppMethodBeat.o(31262);
      return;
    }
    this.fWT = e.DyA.eA(getContext());
    this.fWT.setEntranceScene(ChatFooterPanel.Dnj);
    this.fWT.setVisibility(8);
    this.uUm = ((LinearLayout)findViewById(2131304239));
    this.uUm.setOnClickListener(null);
    int i = y.iy(getContext());
    this.uUm.addView(this.fWT, -1, i);
    this.fWT.eMH();
    this.fWT.onResume();
    this.fWT.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void amb()
      {
        AppMethodBeat.i(31259);
        VoiceInputFooter.e(VoiceInputFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        VoiceInputFooter.e(VoiceInputFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(31259);
      }
      
      public final void amc() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(31260);
        try
        {
          VoiceInputFooter.e(VoiceInputFooter.this).aRF(paramAnonymousString);
          AppMethodBeat.o(31260);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ac.printErrStackTrace("MicroMsg.VoiceInputFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(31260);
        }
      }
      
      public final void dS(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(31262);
  }
  
  private static void lA(int paramInt)
  {
    AppMethodBeat.i(31269);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramInt == 1) {
      localVoiceInputBehavior.smileIconClick = 1;
    }
    for (;;)
    {
      ac.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      log_13905 locallog_13905 = new log_13905();
      locallog_13905.viOp_ = localVoiceInputBehavior;
      h.wUl.c(13905, locallog_13905);
      AppMethodBeat.o(31269);
      return;
      if (paramInt != 2) {
        break;
      }
      localVoiceInputBehavior.voiceIconClick = 1;
    }
    AppMethodBeat.o(31269);
  }
  
  final void bAD()
  {
    AppMethodBeat.i(31266);
    this.Dpc = false;
    this.fWT.onPause();
    this.fWT.setVisibility(8);
    AppMethodBeat.o(31266);
  }
  
  public final boolean dRh()
  {
    AppMethodBeat.i(31263);
    if (this.fWT.getVisibility() == 0)
    {
      AppMethodBeat.o(31263);
      return true;
    }
    AppMethodBeat.o(31263);
    return false;
  }
  
  public final boolean eNe()
  {
    AppMethodBeat.i(31264);
    if (this.DoY.getVisibility() == 0)
    {
      AppMethodBeat.o(31264);
      return true;
    }
    AppMethodBeat.o(31264);
    return false;
  }
  
  final void eNf()
  {
    AppMethodBeat.i(31265);
    this.Dpb = false;
    if (this.DoY != null)
    {
      this.DoY.pause();
      this.DoY.setVisibility(8);
      this.Dpa.setImageResource(2131234518);
      this.DoZ.setVisibility(0);
      if (this.Dpf != null) {
        this.Dpf.va(false);
      }
    }
    AppMethodBeat.o(31265);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(31267);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.fWT);
    localArrayList.add(this.DoY);
    AppMethodBeat.o(31267);
    return localArrayList;
  }
  
  public final void release()
  {
    AppMethodBeat.i(31268);
    if (this.fWT != null)
    {
      this.fWT.eMG();
      this.fWT.destroy();
    }
    if (this.DoY != null) {
      this.DoY.destroy();
    }
    AppMethodBeat.o(31268);
  }
  
  public void setVoiceInputFooterListener(a parama)
  {
    this.Dpf = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eNh();
    
    public abstract void va(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter
 * JD-Core Version:    0.7.0.1
 */
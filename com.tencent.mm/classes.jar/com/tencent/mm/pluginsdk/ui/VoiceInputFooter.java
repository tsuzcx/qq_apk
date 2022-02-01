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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter
  extends BasePanelKeybordLayout
{
  n BWH;
  ImageButton BWI;
  private ImageButton BWJ;
  private boolean BWK;
  private boolean BWL;
  private final int BWM;
  private final int BWN;
  private a BWO;
  private ChatFooterPanel fSY;
  private MMActivity imP;
  LinearLayout tLI;
  MMEditText xEy;
  
  public VoiceInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31262);
    this.xEy = null;
    this.BWK = false;
    this.BWL = false;
    this.BWM = 1;
    this.BWN = 2;
    this.imP = ((MMActivity)paramContext);
    paramContext = (ViewGroup)y.js(this.imP).inflate(2131495861, this);
    this.BWJ = ((ImageButton)paramContext.findViewById(2131296629));
    this.BWJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31257);
        VoiceInputFooter.c(VoiceInputFooter.this);
        AppMethodBeat.o(31257);
      }
    });
    this.BWI = ((ImageButton)paramContext.findViewById(2131296558));
    this.BWI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31258);
        VoiceInputFooter.d(VoiceInputFooter.this);
        AppMethodBeat.o(31258);
      }
    });
    if (e.Cgj == null)
    {
      this.fSY = new d(this.imP);
      AppMethodBeat.o(31262);
      return;
    }
    this.fSY = e.Cgj.es(getContext());
    this.fSY.setEntranceScene(ChatFooterPanel.BUT);
    this.fSY.setVisibility(8);
    this.tLI = ((LinearLayout)findViewById(2131304239));
    this.tLI.setOnClickListener(null);
    int i = z.in(getContext());
    this.tLI.addView(this.fSY, -1, i);
    this.fSY.exn();
    this.fSY.onResume();
    this.fSY.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(31260);
        try
        {
          VoiceInputFooter.e(VoiceInputFooter.this).aMd(paramAnonymousString);
          AppMethodBeat.o(31260);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.printErrStackTrace("MicroMsg.VoiceInputFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(31260);
        }
      }
      
      public final void btF()
      {
        AppMethodBeat.i(31259);
        VoiceInputFooter.e(VoiceInputFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        VoiceInputFooter.e(VoiceInputFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(31259);
      }
      
      public final void cqY() {}
      
      public final void lf(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(31262);
  }
  
  private static void lI(int paramInt)
  {
    AppMethodBeat.i(31269);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramInt == 1) {
      localVoiceInputBehavior.smileIconClick = 1;
    }
    for (;;)
    {
      ad.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      log_13905 locallog_13905 = new log_13905();
      locallog_13905.viOp_ = localVoiceInputBehavior;
      h.vKh.c(13905, locallog_13905);
      AppMethodBeat.o(31269);
      return;
      if (paramInt != 2) {
        break;
      }
      localVoiceInputBehavior.voiceIconClick = 1;
    }
    AppMethodBeat.o(31269);
  }
  
  final void btD()
  {
    AppMethodBeat.i(31266);
    this.BWL = false;
    this.fSY.onPause();
    this.fSY.setVisibility(8);
    AppMethodBeat.o(31266);
  }
  
  public final boolean dCK()
  {
    AppMethodBeat.i(31263);
    if (this.fSY.getVisibility() == 0)
    {
      AppMethodBeat.o(31263);
      return true;
    }
    AppMethodBeat.o(31263);
    return false;
  }
  
  public final boolean exK()
  {
    AppMethodBeat.i(31264);
    if (this.BWH.getVisibility() == 0)
    {
      AppMethodBeat.o(31264);
      return true;
    }
    AppMethodBeat.o(31264);
    return false;
  }
  
  final void exL()
  {
    AppMethodBeat.i(31265);
    this.BWK = false;
    if (this.BWH != null)
    {
      this.BWH.pause();
      this.BWH.setVisibility(8);
      this.BWJ.setImageResource(2131234518);
      this.BWI.setVisibility(0);
      if (this.BWO != null) {
        this.BWO.tZ(false);
      }
    }
    AppMethodBeat.o(31265);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(31267);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.fSY);
    localArrayList.add(this.BWH);
    AppMethodBeat.o(31267);
    return localArrayList;
  }
  
  public final void release()
  {
    AppMethodBeat.i(31268);
    if (this.fSY != null)
    {
      this.fSY.exm();
      this.fSY.destroy();
    }
    if (this.BWH != null) {
      this.BWH.destroy();
    }
    AppMethodBeat.o(31268);
  }
  
  public void setVoiceInputFooterListener(a parama)
  {
    this.BWO = parama;
  }
  
  public static abstract interface a
  {
    public abstract void exN();
    
    public abstract void tZ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter
 * JD-Core Version:    0.7.0.1
 */
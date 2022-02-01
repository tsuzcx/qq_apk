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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.pluginsdk.ui.chat.n.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter
  extends BasePanelKeybordLayout
{
  MMEditText AzX;
  private boolean FmA;
  private boolean FmB;
  private final int FmC;
  private final int FmD;
  private a FmE;
  n Fmx;
  ImageButton Fmy;
  private ImageButton Fmz;
  private MMActivity fNT;
  private ChatFooterPanel qdo;
  LinearLayout wjA;
  
  public VoiceInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31262);
    this.AzX = null;
    this.FmA = false;
    this.FmB = false;
    this.FmC = 1;
    this.FmD = 2;
    this.fNT = ((MMActivity)paramContext);
    paramContext = (ViewGroup)z.jV(this.fNT).inflate(2131495861, this);
    this.Fmz = ((ImageButton)paramContext.findViewById(2131296629));
    this.Fmz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31257);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        VoiceInputFooter.c(VoiceInputFooter.this);
        a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31257);
      }
    });
    this.Fmy = ((ImageButton)paramContext.findViewById(2131296558));
    this.Fmy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31258);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        VoiceInputFooter.d(VoiceInputFooter.this);
        a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31258);
      }
    });
    if (e.Fwh == null)
    {
      this.qdo = new d(this.fNT);
      AppMethodBeat.o(31262);
      return;
    }
    this.qdo = e.Fwh.eE(getContext());
    this.qdo.setEntranceScene(ChatFooterPanel.FkJ);
    this.qdo.setVisibility(8);
    this.wjA = ((LinearLayout)findViewById(2131304239));
    this.wjA.setOnClickListener(null);
    int i = aa.iN(getContext());
    this.wjA.addView(this.qdo, -1, i);
    this.qdo.fft();
    this.qdo.onResume();
    this.qdo.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void apc()
      {
        AppMethodBeat.i(31259);
        VoiceInputFooter.e(VoiceInputFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        VoiceInputFooter.e(VoiceInputFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(31259);
      }
      
      public final void apd() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(31260);
        try
        {
          VoiceInputFooter.e(VoiceInputFooter.this).aZf(paramAnonymousString);
          AppMethodBeat.o(31260);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.printErrStackTrace("MicroMsg.VoiceInputFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(31260);
        }
      }
      
      public final void dW(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(31262);
  }
  
  private static void md(int paramInt)
  {
    AppMethodBeat.i(31269);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramInt == 1) {
      localVoiceInputBehavior.smileIconClick = 1;
    }
    for (;;)
    {
      ae.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      log_13905 locallog_13905 = new log_13905();
      locallog_13905.viOp_ = localVoiceInputBehavior;
      g.yxI.c(13905, locallog_13905);
      AppMethodBeat.o(31269);
      return;
      if (paramInt != 2) {
        break;
      }
      localVoiceInputBehavior.voiceIconClick = 1;
    }
    AppMethodBeat.o(31269);
  }
  
  final void bFx()
  {
    AppMethodBeat.i(31266);
    this.FmB = false;
    this.qdo.onPause();
    this.qdo.setVisibility(8);
    AppMethodBeat.o(31266);
  }
  
  public final boolean ehg()
  {
    AppMethodBeat.i(31263);
    if (this.qdo.getVisibility() == 0)
    {
      AppMethodBeat.o(31263);
      return true;
    }
    AppMethodBeat.o(31263);
    return false;
  }
  
  public final boolean ffR()
  {
    AppMethodBeat.i(31264);
    if (this.Fmx.getVisibility() == 0)
    {
      AppMethodBeat.o(31264);
      return true;
    }
    AppMethodBeat.o(31264);
    return false;
  }
  
  final void ffS()
  {
    AppMethodBeat.i(31265);
    this.FmA = false;
    if (this.Fmx != null)
    {
      this.Fmx.pause();
      this.Fmx.setVisibility(8);
      this.Fmz.setImageResource(2131234518);
      this.Fmy.setVisibility(0);
      if (this.FmE != null) {
        this.FmE.vT(false);
      }
    }
    AppMethodBeat.o(31265);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(31267);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.qdo);
    localArrayList.add(this.Fmx);
    AppMethodBeat.o(31267);
    return localArrayList;
  }
  
  public final void release()
  {
    AppMethodBeat.i(31268);
    if (this.qdo != null)
    {
      this.qdo.ffs();
      this.qdo.destroy();
    }
    if (this.Fmx != null) {
      this.Fmx.destroy();
    }
    AppMethodBeat.o(31268);
  }
  
  public void setVoiceInputFooterListener(a parama)
  {
    this.FmE = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ffU();
    
    public abstract void vT(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter
 * JD-Core Version:    0.7.0.1
 */
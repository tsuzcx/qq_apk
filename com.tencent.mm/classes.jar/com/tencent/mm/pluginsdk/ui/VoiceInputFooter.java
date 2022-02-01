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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter
  extends BasePanelKeybordLayout
{
  MMEditText AiM;
  n EUc;
  ImageButton EUd;
  private ImageButton EUe;
  private boolean EUf;
  private boolean EUg;
  private final int EUh;
  private final int EUi;
  private a EUj;
  private MMActivity fLP;
  private ChatFooterPanel pWJ;
  LinearLayout vXw;
  
  public VoiceInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31262);
    this.AiM = null;
    this.EUf = false;
    this.EUg = false;
    this.EUh = 1;
    this.EUi = 2;
    this.fLP = ((MMActivity)paramContext);
    paramContext = (ViewGroup)com.tencent.mm.ui.z.jO(this.fLP).inflate(2131495861, this);
    this.EUe = ((ImageButton)paramContext.findViewById(2131296629));
    this.EUe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31257);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        VoiceInputFooter.c(VoiceInputFooter.this);
        a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31257);
      }
    });
    this.EUd = ((ImageButton)paramContext.findViewById(2131296558));
    this.EUd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31258);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        VoiceInputFooter.d(VoiceInputFooter.this);
        a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31258);
      }
    });
    if (e.FdJ == null)
    {
      this.pWJ = new d(this.fLP);
      AppMethodBeat.o(31262);
      return;
    }
    this.pWJ = e.FdJ.eA(getContext());
    this.pWJ.setEntranceScene(ChatFooterPanel.ESo);
    this.pWJ.setVisibility(8);
    this.vXw = ((LinearLayout)findViewById(2131304239));
    this.vXw.setOnClickListener(null);
    int i = com.tencent.mm.sdk.platformtools.z.iI(getContext());
    this.vXw.addView(this.pWJ, -1, i);
    this.pWJ.fbF();
    this.pWJ.onResume();
    this.pWJ.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aoO()
      {
        AppMethodBeat.i(31259);
        VoiceInputFooter.e(VoiceInputFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        VoiceInputFooter.e(VoiceInputFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(31259);
      }
      
      public final void aoP() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(31260);
        try
        {
          VoiceInputFooter.e(VoiceInputFooter.this).aXD(paramAnonymousString);
          AppMethodBeat.o(31260);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.printErrStackTrace("MicroMsg.VoiceInputFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(31260);
        }
      }
      
      public final void dU(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(31262);
  }
  
  private static void ma(int paramInt)
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
      g.yhR.c(13905, locallog_13905);
      AppMethodBeat.o(31269);
      return;
      if (paramInt != 2) {
        break;
      }
      localVoiceInputBehavior.voiceIconClick = 1;
    }
    AppMethodBeat.o(31269);
  }
  
  final void bEF()
  {
    AppMethodBeat.i(31266);
    this.EUg = false;
    this.pWJ.onPause();
    this.pWJ.setVisibility(8);
    AppMethodBeat.o(31266);
  }
  
  public final boolean edz()
  {
    AppMethodBeat.i(31263);
    if (this.pWJ.getVisibility() == 0)
    {
      AppMethodBeat.o(31263);
      return true;
    }
    AppMethodBeat.o(31263);
    return false;
  }
  
  public final boolean fcd()
  {
    AppMethodBeat.i(31264);
    if (this.EUc.getVisibility() == 0)
    {
      AppMethodBeat.o(31264);
      return true;
    }
    AppMethodBeat.o(31264);
    return false;
  }
  
  final void fce()
  {
    AppMethodBeat.i(31265);
    this.EUf = false;
    if (this.EUc != null)
    {
      this.EUc.pause();
      this.EUc.setVisibility(8);
      this.EUe.setImageResource(2131234518);
      this.EUd.setVisibility(0);
      if (this.EUj != null) {
        this.EUj.vL(false);
      }
    }
    AppMethodBeat.o(31265);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(31267);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.pWJ);
    localArrayList.add(this.EUc);
    AppMethodBeat.o(31267);
    return localArrayList;
  }
  
  public final void release()
  {
    AppMethodBeat.i(31268);
    if (this.pWJ != null)
    {
      this.pWJ.fbE();
      this.pWJ.destroy();
    }
    if (this.EUc != null) {
      this.EUc.destroy();
    }
    AppMethodBeat.o(31268);
  }
  
  public void setVoiceInputFooterListener(a parama)
  {
    this.EUj = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fcg();
    
    public abstract void vL(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter
 * JD-Core Version:    0.7.0.1
 */
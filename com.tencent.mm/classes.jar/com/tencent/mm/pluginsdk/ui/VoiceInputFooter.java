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
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter
  extends BasePanelKeybordLayout
{
  MMEditText EJt;
  n Kdp;
  ImageButton Kdq;
  private ImageButton Kdr;
  private boolean Kds;
  private boolean Kdt;
  private final int Kdu;
  private final int Kdv;
  private a Kdw;
  private MMActivity gte;
  private ChatFooterPanel rum;
  LinearLayout zDZ;
  
  public VoiceInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31262);
    this.EJt = null;
    this.Kds = false;
    this.Kdt = false;
    this.Kdu = 1;
    this.Kdv = 2;
    this.gte = ((MMActivity)paramContext);
    paramContext = (ViewGroup)aa.jQ(this.gte).inflate(2131496841, this);
    this.Kdr = ((ImageButton)paramContext.findViewById(2131296706));
    this.Kdr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31257);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        VoiceInputFooter.c(VoiceInputFooter.this);
        a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31257);
      }
    });
    this.Kdq = ((ImageButton)paramContext.findViewById(2131296635));
    this.Kdq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31258);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        VoiceInputFooter.d(VoiceInputFooter.this);
        a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31258);
      }
    });
    if (e.Knc == null)
    {
      this.rum = new d(this.gte);
      AppMethodBeat.o(31262);
      return;
    }
    this.rum = e.Knc.eZ(getContext());
    this.rum.setEntranceScene(ChatFooterPanel.KbB);
    this.rum.setVisibility(8);
    this.zDZ = ((LinearLayout)findViewById(2131307157));
    this.zDZ.setOnClickListener(null);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    this.zDZ.addView(this.rum, -1, i);
    this.rum.goD();
    this.rum.onResume();
    this.rum.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aHC()
      {
        AppMethodBeat.i(31259);
        VoiceInputFooter.e(VoiceInputFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        VoiceInputFooter.e(VoiceInputFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(31259);
      }
      
      public final void aHD() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(31260);
        try
        {
          VoiceInputFooter.e(VoiceInputFooter.this).bol(paramAnonymousString);
          AppMethodBeat.o(31260);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.VoiceInputFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(31260);
        }
      }
      
      public final void eP(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(31262);
  }
  
  private static void pl(int paramInt)
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
      h.CyF.c(13905, locallog_13905);
      AppMethodBeat.o(31269);
      return;
      if (paramInt != 2) {
        break;
      }
      localVoiceInputBehavior.voiceIconClick = 1;
    }
    AppMethodBeat.o(31269);
  }
  
  final void cbM()
  {
    AppMethodBeat.i(31266);
    this.Kdt = false;
    this.rum.onPause();
    this.rum.setVisibility(8);
    AppMethodBeat.o(31266);
  }
  
  public final boolean fjI()
  {
    AppMethodBeat.i(31263);
    if (this.rum.getVisibility() == 0)
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
    localArrayList.add(this.rum);
    localArrayList.add(this.Kdp);
    AppMethodBeat.o(31267);
    return localArrayList;
  }
  
  public final boolean gpa()
  {
    AppMethodBeat.i(31264);
    if (this.Kdp.getVisibility() == 0)
    {
      AppMethodBeat.o(31264);
      return true;
    }
    AppMethodBeat.o(31264);
    return false;
  }
  
  final void gpb()
  {
    AppMethodBeat.i(31265);
    this.Kds = false;
    if (this.Kdp != null)
    {
      this.Kdp.pause();
      this.Kdp.setVisibility(8);
      this.Kdr.setImageResource(2131235480);
      this.Kdq.setVisibility(0);
      if (this.Kdw != null) {
        this.Kdw.zR(false);
      }
    }
    AppMethodBeat.o(31265);
  }
  
  public final void release()
  {
    AppMethodBeat.i(31268);
    if (this.rum != null)
    {
      this.rum.goC();
      this.rum.destroy();
    }
    if (this.Kdp != null) {
      this.Kdp.destroy();
    }
    AppMethodBeat.o(31268);
  }
  
  public void setVoiceInputFooterListener(a parama)
  {
    this.Kdw = parama;
  }
  
  public static abstract interface a
  {
    public abstract void gpd();
    
    public abstract void zR(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter
 * JD-Core Version:    0.7.0.1
 */
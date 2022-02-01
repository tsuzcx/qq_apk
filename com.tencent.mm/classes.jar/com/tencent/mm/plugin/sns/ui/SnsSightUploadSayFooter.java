package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
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
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter
  extends BasePanelKeybordLayout
{
  private MMEditText AzX;
  SightRangeWidget AzY;
  SightLocationWidget AzZ;
  MMActivity fNT;
  ChatFooterPanel qdo;
  private ImageButton vNs;
  private boolean vNw;
  
  public SnsSightUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99122);
    this.AzX = null;
    this.vNw = true;
    this.fNT = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.fNT, 2131495588, this);
    this.vNs = ((ImageButton)paramContext.findViewById(2131296558));
    this.vNs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99119);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsSightUploadSayFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        SnsSightUploadSayFooter.d(SnsSightUploadSayFooter.this);
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightUploadSayFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99119);
      }
    });
    if (e.Fwh == null) {
      this.qdo = new d(this.fNT);
    }
    for (;;)
    {
      this.AzY = ((SightRangeWidget)paramContext.findViewById(2131303717));
      this.AzY.Agc = null;
      this.AzY.style = 1;
      this.AzZ = ((SightLocationWidget)paramContext.findViewById(2131301546));
      AppMethodBeat.o(99122);
      return;
      this.qdo = e.Fwh.eE(getContext());
      this.qdo.setEntranceScene(ChatFooterPanel.xKI);
      this.qdo.setVisibility(8);
      ((LinearLayout)findViewById(2131304239)).addView(this.qdo, -1, 0);
      this.qdo.fft();
      this.qdo.onResume();
      this.qdo.setOnTextOperationListener(new ChatFooterPanel.a()
      {
        public final void apc()
        {
          AppMethodBeat.i(99120);
          SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
          SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(99120);
        }
        
        public final void apd() {}
        
        public final void append(String paramAnonymousString)
        {
          AppMethodBeat.i(99121);
          try
          {
            SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).aZf(paramAnonymousString);
            AppMethodBeat.o(99121);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ae.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", paramAnonymousString, "", new Object[0]);
            AppMethodBeat.o(99121);
          }
        }
        
        public final void dW(boolean paramAnonymousBoolean) {}
      });
    }
  }
  
  private void bFx()
  {
    AppMethodBeat.i(99124);
    this.qdo.onPause();
    this.qdo.setVisibility(8);
    AppMethodBeat.o(99124);
  }
  
  public bwk getLocation()
  {
    AppMethodBeat.i(99126);
    bwk localbwk = this.AzZ.getLocation();
    AppMethodBeat.o(99126);
    return localbwk;
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(99125);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.qdo);
    AppMethodBeat.o(99125);
    return localArrayList;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(99123);
    this.AzX = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99117);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsSightUploadSayFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (SnsSightUploadSayFooter.this.getVisibility() == 8) {
          SnsSightUploadSayFooter.this.setVisibility(0);
        }
        if (SnsSightUploadSayFooter.this.qdo.getVisibility() == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            SnsSightUploadSayFooter.a(SnsSightUploadSayFooter.this);
          }
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightUploadSayFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99117);
          return;
        }
      }
    });
    paramMMEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return false;
      }
    });
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99118);
        SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).performClick();
        SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).requestFocus();
        SnsSightUploadSayFooter.c(SnsSightUploadSayFooter.this).showVKB();
        AppMethodBeat.o(99118);
      }
    }, 200L);
    AppMethodBeat.o(99123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */
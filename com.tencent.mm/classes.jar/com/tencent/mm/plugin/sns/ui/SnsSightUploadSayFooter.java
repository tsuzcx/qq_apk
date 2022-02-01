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
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter
  extends BasePanelKeybordLayout
{
  ChatFooterPanel fWT;
  MMActivity iMV;
  private ImageButton uyL;
  private boolean uyP;
  private MMEditText yRm;
  SightRangeWidget yRn;
  SightLocationWidget yRo;
  
  public SnsSightUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99122);
    this.yRm = null;
    this.uyP = true;
    this.iMV = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.iMV, 2131495588, this);
    this.uyL = ((ImageButton)paramContext.findViewById(2131296558));
    this.uyL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99119);
        SnsSightUploadSayFooter.d(SnsSightUploadSayFooter.this);
        AppMethodBeat.o(99119);
      }
    });
    if (e.DyA == null) {
      this.fWT = new d(this.iMV);
    }
    for (;;)
    {
      this.yRn = ((SightRangeWidget)paramContext.findViewById(2131303717));
      this.yRn.yxJ = null;
      this.yRn.style = 1;
      this.yRo = ((SightLocationWidget)paramContext.findViewById(2131301546));
      AppMethodBeat.o(99122);
      return;
      this.fWT = e.DyA.eA(getContext());
      this.fWT.setEntranceScene(ChatFooterPanel.wmX);
      this.fWT.setVisibility(8);
      ((LinearLayout)findViewById(2131304239)).addView(this.fWT, -1, 0);
      this.fWT.eMH();
      this.fWT.onResume();
      this.fWT.setOnTextOperationListener(new ChatFooterPanel.a()
      {
        public final void amb()
        {
          AppMethodBeat.i(99120);
          SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
          SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(99120);
        }
        
        public final void amc() {}
        
        public final void append(String paramAnonymousString)
        {
          AppMethodBeat.i(99121);
          try
          {
            SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).aRF(paramAnonymousString);
            AppMethodBeat.o(99121);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ac.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", paramAnonymousString, "", new Object[0]);
            AppMethodBeat.o(99121);
          }
        }
        
        public final void dS(boolean paramAnonymousBoolean) {}
      });
    }
  }
  
  private void bAD()
  {
    AppMethodBeat.i(99124);
    this.fWT.onPause();
    this.fWT.setVisibility(8);
    AppMethodBeat.o(99124);
  }
  
  public brd getLocation()
  {
    AppMethodBeat.i(99126);
    brd localbrd = this.yRo.getLocation();
    AppMethodBeat.o(99126);
    return localbrd;
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(99125);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.fWT);
    AppMethodBeat.o(99125);
    return localArrayList;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(99123);
    this.yRm = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int i = 0;
        AppMethodBeat.i(99117);
        if (SnsSightUploadSayFooter.this.getVisibility() == 8) {
          SnsSightUploadSayFooter.this.setVisibility(0);
        }
        if (SnsSightUploadSayFooter.this.fWT.getVisibility() == 0) {
          i = 1;
        }
        if (i != 0) {
          SnsSightUploadSayFooter.a(SnsSightUploadSayFooter.this);
        }
        AppMethodBeat.o(99117);
      }
    });
    paramMMEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return false;
      }
    });
    ap.n(new Runnable()
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
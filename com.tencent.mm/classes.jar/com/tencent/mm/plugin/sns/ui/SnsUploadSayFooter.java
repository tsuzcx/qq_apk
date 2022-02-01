package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputConnection;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.b;
import com.tencent.mm.ui.z;

public class SnsUploadSayFooter
  extends InputPanelLinearLayout
{
  ChatFooterPanel fWT;
  private MMActivity iMV;
  private ImageButton uyL;
  private int yKX;
  private int yKY;
  private int yKZ;
  private MMEditText yRm;
  private boolean yWX;
  private boolean yWY;
  
  public SnsUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99554);
    this.yRm = null;
    this.yKX = -1;
    this.yKY = -1;
    this.yKZ = 0;
    this.yWX = true;
    this.yWY = false;
    this.iMV = ((MMActivity)paramContext);
    this.uyL = ((ImageButton)((ViewGroup)z.jD(this.iMV).inflate(2131495619, this)).findViewById(2131296558));
    this.uyL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99549);
        SnsUploadSayFooter.b(SnsUploadSayFooter.this);
        AppMethodBeat.o(99549);
      }
    });
    if (e.DyA == null)
    {
      this.fWT = new d(this.iMV);
      AppMethodBeat.o(99554);
      return;
    }
    this.fWT = e.DyA.eA(getContext());
    this.fWT.setEntranceScene(ChatFooterPanel.wmX);
    this.fWT.setVisibility(8);
    paramContext = (LinearLayout)findViewById(2131304239);
    paramContext.setOnClickListener(null);
    this.yKZ = y.iy(getContext());
    paramContext.addView(this.fWT, -1, this.yKZ);
    this.fWT.eMH();
    dPC();
    this.fWT.onResume();
    this.fWT.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void amb()
      {
        AppMethodBeat.i(99550);
        SnsUploadSayFooter.c(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        SnsUploadSayFooter.c(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(99550);
      }
      
      public final void amc() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(99551);
        try
        {
          SnsUploadSayFooter.c(SnsUploadSayFooter.this).aRF(paramAnonymousString);
          AppMethodBeat.o(99551);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ac.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(99551);
        }
      }
      
      public final void dS(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(99554);
  }
  
  private void bAD()
  {
    AppMethodBeat.i(99560);
    this.yWY = false;
    this.fWT.onPause();
    if (y.iA(getContext()))
    {
      getInputPanelHelper().aL(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99552);
          SnsUploadSayFooter.d(SnsUploadSayFooter.this).setVisibility(8);
          AppMethodBeat.o(99552);
        }
      });
      AppMethodBeat.o(99560);
      return;
    }
    this.fWT.setVisibility(8);
    AppMethodBeat.o(99560);
  }
  
  private void dPC()
  {
    AppMethodBeat.i(99562);
    int i = y.iy(getContext());
    this.fWT.setPortHeightPx(i);
    ViewGroup.LayoutParams localLayoutParams = this.fWT.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(99562);
  }
  
  public final void dRg()
  {
    AppMethodBeat.i(99555);
    setVisibility(0);
    if (this.uyL != null) {
      this.uyL.setImageResource(2131234155);
    }
    AppMethodBeat.o(99555);
  }
  
  public final boolean dRh()
  {
    AppMethodBeat.i(99557);
    if (this.fWT.getVisibility() == 0)
    {
      AppMethodBeat.o(99557);
      return true;
    }
    AppMethodBeat.o(99557);
    return false;
  }
  
  public final void dRi()
  {
    AppMethodBeat.i(99558);
    bAD();
    setVisibility(4);
    AppMethodBeat.o(99558);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(99561);
    ac.i("MicroMsg.SnsUploadSayFooter", "onInputPanelChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    super.g(paramBoolean, paramInt);
    if ((this.yKZ != paramInt) && (paramInt != 0))
    {
      this.yKZ = paramInt;
      i.A(getContext(), paramInt);
      dPC();
    }
    if (paramBoolean)
    {
      dRg();
      AppMethodBeat.o(99561);
      return;
    }
    if (!this.yWY) {
      setVisibility(4);
    }
    AppMethodBeat.o(99561);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99559);
    super.onConfigurationChanged(paramConfiguration);
    if (this.fWT != null) {
      dPC();
    }
    AppMethodBeat.o(99559);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(99563);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.yKX < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.yKX)
    {
      this.yKX = paramInt1;
      this.yKY = paramInt4;
      AppMethodBeat.o(99563);
      return;
    }
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(99556);
    this.yRm = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99548);
        if (SnsUploadSayFooter.this.getVisibility() == 8) {
          SnsUploadSayFooter.this.setVisibility(0);
        }
        if (SnsUploadSayFooter.this.dRh()) {
          SnsUploadSayFooter.a(SnsUploadSayFooter.this);
        }
        AppMethodBeat.o(99548);
      }
    });
    paramMMEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return false;
      }
    });
    AppMethodBeat.o(99556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.b;

public class SnsUploadSayFooter
  extends InputPanelLinearLayout
{
  private MMActivity cmc;
  ChatFooterPanel eys;
  private int kjA;
  private boolean kjB;
  private MMEditText kju;
  private ImageButton kjv;
  private int kjy;
  private int kjz;
  
  public SnsUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39723);
    this.kju = null;
    this.kjy = -1;
    this.kjz = -1;
    this.kjA = 0;
    this.kjB = true;
    this.cmc = ((MMActivity)paramContext);
    this.kjv = ((ImageButton)((ViewGroup)w.hM(this.cmc).inflate(2130970892, this)).findViewById(2131825850));
    this.kjv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39718);
        SnsUploadSayFooter.b(SnsUploadSayFooter.this);
        AppMethodBeat.o(39718);
      }
    });
    if (e.vYI == null)
    {
      this.eys = new d(this.cmc);
      AppMethodBeat.o(39723);
      return;
    }
    this.eys = e.vYI.dK(getContext());
    this.eys.setEntranceScene(ChatFooterPanel.vQn);
    this.eys.setVisibility(8);
    paramContext = (LinearLayout)findViewById(2131821003);
    paramContext.setOnClickListener(null);
    this.kjA = x.gL(getContext());
    paramContext.addView(this.eys, -1, this.kjA);
    this.eys.Az();
    this.eys.bo(false);
    baf();
    this.eys.onResume();
    this.eys.setOnTextOperationListener(new SnsUploadSayFooter.4(this));
    AppMethodBeat.o(39723);
  }
  
  private void aRm()
  {
    AppMethodBeat.i(39729);
    this.eys.onPause();
    if (x.gN(getContext()))
    {
      getInputPanelHelper().ay(new SnsUploadSayFooter.5(this));
      AppMethodBeat.o(39729);
      return;
    }
    this.eys.setVisibility(8);
    AppMethodBeat.o(39729);
  }
  
  private void baf()
  {
    AppMethodBeat.i(39731);
    int i = x.gL(getContext());
    this.eys.setPortHeightPx(i);
    this.eys.AD();
    ViewGroup.LayoutParams localLayoutParams = this.eys.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(39731);
  }
  
  public final void baa()
  {
    AppMethodBeat.i(39724);
    setVisibility(0);
    if (this.kjv != null) {
      this.kjv.setImageResource(2130840431);
    }
    AppMethodBeat.o(39724);
  }
  
  public final boolean bad()
  {
    AppMethodBeat.i(39726);
    if (this.eys.getVisibility() == 0)
    {
      AppMethodBeat.o(39726);
      return true;
    }
    AppMethodBeat.o(39726);
    return false;
  }
  
  public final void bae()
  {
    AppMethodBeat.i(39727);
    aRm();
    setVisibility(8);
    AppMethodBeat.o(39727);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(39728);
    super.onConfigurationChanged(paramConfiguration);
    if (this.eys != null)
    {
      baf();
      this.eys.refresh();
    }
    AppMethodBeat.o(39728);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39732);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.kjy < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.kjy)
    {
      this.kjy = paramInt1;
      this.kjz = paramInt4;
      AppMethodBeat.o(39732);
      return;
    }
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(39730);
    super.p(paramBoolean, paramInt);
    if ((this.kjA != paramInt) && (paramInt != 0))
    {
      this.kjA = paramInt;
      j.z(getContext(), paramInt);
      baf();
    }
    AppMethodBeat.o(39730);
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(39725);
    this.kju = paramMMEditText;
    paramMMEditText.setOnClickListener(new SnsUploadSayFooter.1(this));
    paramMMEditText.setOnEditorActionListener(new SnsUploadSayFooter.2(this));
    AppMethodBeat.o(39725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter
  extends BasePanelKeybordLayout
{
  MMActivity cmc;
  ChatFooterPanel eys;
  private MMEditText kju;
  private ImageButton kjv;
  private boolean oxq;
  SightRangeWidget rVY;
  SightLocationWidget rVZ;
  
  public SnsSightUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39291);
    this.kju = null;
    this.oxq = true;
    this.cmc = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.cmc, 2130970863, this);
    this.kjv = ((ImageButton)paramContext.findViewById(2131825850));
    this.kjv.setOnClickListener(new SnsSightUploadSayFooter.4(this));
    if (e.vYI == null) {
      this.eys = new d(this.cmc);
    }
    for (;;)
    {
      this.rVY = ((SightRangeWidget)paramContext.findViewById(2131825851));
      this.rVY.rFe = null;
      this.rVY.style = 1;
      this.rVZ = ((SightLocationWidget)paramContext.findViewById(2131828082));
      AppMethodBeat.o(39291);
      return;
      this.eys = e.vYI.dK(getContext());
      this.eys.setEntranceScene(ChatFooterPanel.vQn);
      this.eys.setVisibility(8);
      ((LinearLayout)findViewById(2131821003)).addView(this.eys, -1, 0);
      this.eys.Az();
      this.eys.bo(false);
      this.eys.onResume();
      this.eys.setOnTextOperationListener(new SnsSightUploadSayFooter.5(this));
    }
  }
  
  private void aRm()
  {
    AppMethodBeat.i(39293);
    this.eys.onPause();
    this.eys.setVisibility(8);
    AppMethodBeat.o(39293);
  }
  
  public bap getLocation()
  {
    AppMethodBeat.i(39295);
    bap localbap = this.rVZ.getLocation();
    AppMethodBeat.o(39295);
    return localbap;
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(39294);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.eys);
    AppMethodBeat.o(39294);
    return localArrayList;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(39292);
    this.kju = paramMMEditText;
    paramMMEditText.setOnClickListener(new SnsSightUploadSayFooter.1(this));
    paramMMEditText.setOnEditorActionListener(new SnsSightUploadSayFooter.2(this));
    al.p(new SnsSightUploadSayFooter.3(this), 200L);
    AppMethodBeat.o(39292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */
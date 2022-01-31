package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter
  extends BasePanelKeybordLayout
{
  MMActivity bER;
  ChatFooterPanel jpC;
  private ImageButton kEW;
  private boolean lXR = true;
  private MMEditText pdp = null;
  SightRangeWidget pdq;
  SightLocationWidget pdr;
  
  public SnsSightUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.bER, i.g.sns_sight_upload_say_footer, this);
    this.kEW = ((ImageButton)paramContext.findViewById(i.f.album_comment_mode_iv));
    this.kEW.setOnClickListener(new SnsSightUploadSayFooter.4(this));
    if (e.sgr == null) {
      this.jpC = new d(this.bER);
    }
    for (;;)
    {
      this.pdq = ((SightRangeWidget)paramContext.findViewById(i.f.range_widget));
      this.pdq.oNv = null;
      this.pdq.style = 1;
      this.pdr = ((SightLocationWidget)paramContext.findViewById(i.f.location_widget));
      return;
      this.jpC = e.sgr.cX(getContext());
      this.jpC.setEntranceScene(ChatFooterPanel.SCENE_SNS);
      this.jpC.setVisibility(8);
      ((LinearLayout)findViewById(i.f.root)).addView(this.jpC, -1, 0);
      this.jpC.sk();
      this.jpC.aN(false);
      this.jpC.setOnTextOperationListener(new SnsSightUploadSayFooter.5(this));
    }
  }
  
  private void hideSmileyPanel()
  {
    this.jpC.onPause();
    this.jpC.setVisibility(8);
  }
  
  public aui getLocation()
  {
    return this.pdr.getLocation();
  }
  
  protected List<View> getPanelView()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jpC);
    return localArrayList;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    this.pdp = paramMMEditText;
    paramMMEditText.setOnClickListener(new SnsSightUploadSayFooter.1(this));
    paramMMEditText.setOnEditorActionListener(new SnsSightUploadSayFooter.2(this));
    ai.l(new SnsSightUploadSayFooter.3(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */
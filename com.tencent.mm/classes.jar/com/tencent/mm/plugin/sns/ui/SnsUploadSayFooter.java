package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsUploadSayFooter
  extends BasePanelKeybordLayout
{
  private MMActivity bER;
  ChatFooterPanel jpC;
  private ImageButton kEW;
  private boolean lXR = true;
  private boolean oXD = false;
  private boolean oXE = false;
  private int oXF = -1;
  private int oXG = -1;
  private boolean oXI = u.fA(getContext());
  private MMEditText pdp = null;
  
  public SnsUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    this.kEW = ((ImageButton)((ViewGroup)com.tencent.mm.ui.y.gt(this.bER).inflate(i.g.sns_upload_say_footer, this)).findViewById(i.f.album_comment_mode_iv));
    this.kEW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        SnsUploadSayFooter.b(SnsUploadSayFooter.this);
      }
    });
    if (e.sgr == null)
    {
      this.jpC = new d(this.bER);
      return;
    }
    this.jpC = e.sgr.cX(getContext());
    this.jpC.setEntranceScene(ChatFooterPanel.SCENE_SNS);
    this.jpC.setVisibility(8);
    paramContext = (LinearLayout)findViewById(i.f.root);
    paramContext.setOnClickListener(null);
    paramContext.addView(this.jpC, -1, 0);
    this.jpC.sk();
    this.jpC.aN(false);
    this.jpC.setOnTextOperationListener(new SnsUploadSayFooter.4(this));
  }
  
  private void hideSmileyPanel()
  {
    this.jpC.onPause();
    this.jpC.setVisibility(8);
  }
  
  public final void bJW()
  {
    setVisibility(0);
    if (this.kEW != null) {
      this.kEW.setImageResource(i.e.sns_upload_biaoqing_btn);
    }
  }
  
  public final boolean bJX()
  {
    return this.jpC.getVisibility() == 0;
  }
  
  public final void bJY()
  {
    hideSmileyPanel();
    setVisibility(8);
  }
  
  protected List<View> getPanelView()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jpC);
    return localArrayList;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.oXE) || (this.oXD)) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsUploadSayFooter", "onLayout maxBottom %d currBottom %d layoutBottom %d", new Object[] { Integer.valueOf(this.oXF), Integer.valueOf(this.oXG), Integer.valueOf(paramInt4) });
    }
    if ((this.oXE) && (this.jpC != null) && (this.oXG != paramInt4))
    {
      this.jpC.setVisibility(0);
      this.oXE = false;
    }
    if (this.oXF < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.oXF)
    {
      this.oXF = paramInt1;
      this.oXG = paramInt4;
      if ((u.fA(getContext()) != this.oXI) || (this.lXR))
      {
        this.jpC.setPortHeightPx(u.fy(getContext()));
        this.jpC.refresh();
        this.oXI = u.fA(getContext());
        ViewGroup.LayoutParams localLayoutParams = this.jpC.getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.height = j.fy(getContext());
          this.jpC.setLayoutParams(localLayoutParams);
        }
        this.lXR = false;
      }
      return;
    }
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    this.pdp = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (SnsUploadSayFooter.this.getVisibility() == 8) {
          SnsUploadSayFooter.this.setVisibility(0);
        }
        if (SnsUploadSayFooter.this.bJX()) {
          SnsUploadSayFooter.a(SnsUploadSayFooter.this);
        }
      }
    });
    paramMMEditText.setOnEditorActionListener(new SnsUploadSayFooter.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference
  extends Preference
{
  private MMActivity bER;
  private TextView eXr;
  private TextView fug;
  private ImageView heN;
  private int jRP = 255;
  private Button jRQ;
  private View jRR;
  private View.OnClickListener jRS = null;
  private String jRT = "";
  private String jRU = "";
  private String mTitle = "";
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.bER = ((MMActivity)paramContext);
  }
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    setLayoutResource(R.i.voice_print_pref_header);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    this.jRS = paramOnClickListener;
    if ((this.jRQ == null) || (this.jRR == null)) {
      return;
    }
    if ((this.jRQ != null) && (this.jRS != null))
    {
      this.jRQ.setOnClickListener(paramOnClickListener);
      this.jRQ.setVisibility(0);
      this.jRR.setVisibility(0);
      return;
    }
    this.jRQ.setVisibility(8);
    this.jRR.setVisibility(8);
  }
  
  public final void cY(String paramString1, String paramString2)
  {
    this.jRT = paramString1;
    this.jRU = paramString2;
    if (this.eXr != null)
    {
      if (bk.bl(this.jRT)) {
        break label83;
      }
      this.eXr.setText(this.jRT);
      this.eXr.setVisibility(0);
    }
    for (;;)
    {
      if (this.fug != null)
      {
        if (bk.bl(this.jRU)) {
          break;
        }
        this.fug.setText(this.jRU);
        this.fug.setVisibility(0);
      }
      return;
      label83:
      this.eXr.setVisibility(8);
    }
    this.fug.setVisibility(8);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.heN = ((ImageView)paramView.findViewById(R.h.voice_print_sucesss_icon));
    this.eXr = ((TextView)paramView.findViewById(R.h.voice_print_title));
    this.fug = ((TextView)paramView.findViewById(R.h.voice_print_title_tip));
    this.jRQ = ((Button)paramView.findViewById(R.h.right_btn));
    this.jRR = paramView.findViewById(R.h.button_ll);
    if (!bk.bl(this.jRT))
    {
      this.eXr.setText(this.jRT);
      this.eXr.setVisibility(0);
      if (bk.bl(this.jRU)) {
        break label184;
      }
      this.fug.setText(this.jRU);
      this.fug.setVisibility(0);
    }
    for (;;)
    {
      if ((this.jRQ == null) || (this.jRS == null)) {
        break label196;
      }
      this.jRQ.setOnClickListener(this.jRS);
      this.jRQ.setVisibility(0);
      this.jRR.setVisibility(0);
      return;
      this.eXr.setVisibility(8);
      break;
      label184:
      this.fug.setVisibility(8);
    }
    label196:
    this.jRQ.setVisibility(8);
    this.jRR.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */
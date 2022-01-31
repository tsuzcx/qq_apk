package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference
  extends Preference
{
  String aVr;
  private final Context context;
  String nHN;
  private ImageView nOd;
  private TextView nOe;
  private TextView nOf;
  private TextView nOg;
  private TextView nOh;
  String nOi;
  String title;
  
  public VcardContactUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public VcardContactUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    y.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
    this.nOd = ((ImageView)paramView.findViewById(R.h.vcontact_info_avatar_iv));
    this.nOe = ((TextView)paramView.findViewById(R.h.vcontact_info_name_tv));
    if (this.nOi != null) {
      this.nOe.setText(this.nOi);
    }
    this.nOf = ((TextView)paramView.findViewById(R.h.vcontact_info_nickname_tv));
    if (this.aVr != null)
    {
      this.nOf.setText(this.context.getString(R.l.v_contact_nick_name, new Object[] { this.aVr }));
      this.nOf.setVisibility(0);
    }
    this.nOg = ((TextView)paramView.findViewById(R.h.vcontact_info_role_tv));
    if (this.nHN != null)
    {
      this.nOg.setText(this.context.getString(R.l.v_contact_role, new Object[] { this.nHN }));
      this.nOg.setVisibility(0);
    }
    this.nOh = ((TextView)paramView.findViewById(R.h.vcontact_info_title_tv));
    if (this.title != null)
    {
      this.nOh.setText(this.context.getString(R.l.v_contact_tile, new Object[] { this.title }));
      this.nOh.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */
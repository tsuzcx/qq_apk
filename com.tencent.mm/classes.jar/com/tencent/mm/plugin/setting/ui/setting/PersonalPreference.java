package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference
  extends Preference
{
  private String cDs;
  private String dCJ;
  private TextView ejj;
  Bitmap frG;
  ImageView mDc;
  private TextView qFY;
  int qFZ;
  String qGa;
  private View.OnClickListener qGb;
  private String username;
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ejj = null;
    this.qFY = null;
    this.mDc = null;
    this.frG = null;
    this.qFZ = -1;
    this.qGa = null;
  }
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126972);
    this.ejj = null;
    this.qFY = null;
    this.mDc = null;
    this.frG = null;
    this.qFZ = -1;
    this.qGa = null;
    setLayoutResource(2130970179);
    setWidgetLayoutResource(2130970254);
    AppMethodBeat.o(126972);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(126974);
    if (this.mDc == null) {
      this.mDc = ((ImageView)paramView.findViewById(2131822243));
    }
    if (this.frG != null)
    {
      this.mDc.setImageBitmap(this.frG);
      this.mDc.setOnClickListener(this.qGb);
      if ((this.ejj != null) && (this.cDs != null)) {
        this.ejj.setText(j.b(this.mContext, this.cDs, this.ejj.getTextSize()));
      }
      if (this.qFY != null) {
        if (!bo.isNullOrNil(this.dCJ)) {
          break label230;
        }
      }
    }
    label230:
    for (String str = this.username;; str = this.dCJ)
    {
      if ((bo.isNullOrNil(this.dCJ)) && (ad.ari(this.username))) {
        this.qFY.setVisibility(8);
      }
      this.qFY.setText(this.mContext.getString(2131296950) + str);
      super.onBindView(paramView);
      AppMethodBeat.o(126974);
      return;
      if (this.qFZ > 0)
      {
        this.mDc.setImageResource(this.qFZ);
        break;
      }
      if (this.qGa == null) {
        break;
      }
      a.b.c(this.mDc, this.qGa);
      break;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(126973);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970211, localViewGroup);
    AppMethodBeat.o(126973);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PersonalPreference
 * JD-Core Version:    0.7.0.1
 */
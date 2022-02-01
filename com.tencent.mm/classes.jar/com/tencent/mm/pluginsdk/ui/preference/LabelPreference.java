package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class LabelPreference
  extends Preference
{
  private View KKQ;
  private TextView MWH;
  public cr NsP;
  private TextView XZE;
  public au xVS;
  
  public LabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31857);
    super.onBindView(paramView);
    if (this.xVS == null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(31857);
      return;
    }
    paramView.setVisibility(0);
    if (this.MWH == null) {
      this.MWH = ((TextView)paramView.findViewById(R.h.fCq));
    }
    if (this.XZE == null) {
      this.XZE = ((TextView)paramView.findViewById(R.h.fCr));
    }
    if (this.XZE != null)
    {
      paramView = this.XZE.getLayoutParams();
      paramView.width = com.tencent.mm.cd.a.br(this.mContext, R.f.FixedTitleWidth);
      this.XZE.setLayoutParams(paramView);
    }
    this.MWH.setVisibility(0);
    ArrayList localArrayList;
    if (d.rs(this.xVS.field_type))
    {
      paramView = this.xVS.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.fTb().aJJ(paramView);
      if ((!Util.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.MWH.setText(p.b(this.mContext, Util.listToString(localArrayList, this.mContext.getResources().getString(R.l.gAt))));
      }
      AppMethodBeat.o(31857);
      return;
    }
    if (this.NsP != null)
    {
      paramView = this.NsP.field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.fTb().aJI(paramView);
      if ((!Util.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.MWH.setText(p.b(this.mContext, Util.listToString(localArrayList, this.mContext.getResources().getString(R.l.gAt))));
      }
    }
    AppMethodBeat.o(31857);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31856);
    if (this.KKQ == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
      localViewGroup.removeAllViews();
      LayoutInflater.from(this.mContext).inflate(R.i.gnf, localViewGroup);
      this.KKQ = paramViewGroup;
    }
    paramViewGroup = this.KKQ;
    AppMethodBeat.o(31856);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.LabelPreference
 * JD-Core Version:    0.7.0.1
 */
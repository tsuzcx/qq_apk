package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bz;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.fvk;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class FinderPreference
  extends Preference
{
  public static String NAME = "contact_profile_finder";
  private List<ImageView> GzL;
  private View KKQ;
  public fvk Ymy;
  private MMActivity lzt;
  public String mTitle;
  public boolean maT;
  
  public FinderPreference(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(245111);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(245111);
  }
  
  public FinderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(245112);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(245112);
  }
  
  public FinderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(245114);
    this.mTitle = "";
    this.GzL = new LinkedList();
    this.Ymy = null;
    this.maT = false;
    this.lzt = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(R.l.find_friends_by_finder);
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(245114);
  }
  
  private void fkH()
  {
    AppMethodBeat.i(245118);
    Object localObject = this.GzL.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ImageView)((Iterator)localObject).next()).setVisibility(8);
    }
    localObject = this.Ymy;
    if ((localObject != null) && (((fvk)localObject).aahh == 0))
    {
      int j = ((fvk)localObject).ZIQ.size();
      int i = 0;
      while ((i < j) && (i < this.GzL.size()))
      {
        ImageView localImageView = (ImageView)this.GzL.get(i);
        localImageView.setVisibility(0);
        ((cn)h.az(cn.class)).getFinderUIApi().a(((fvk)localObject).ZIQ.get(i), localImageView);
        i += 1;
      }
    }
    AppMethodBeat.o(245118);
  }
  
  public final void a(fvk paramfvk)
  {
    AppMethodBeat.i(245127);
    this.Ymy = paramfvk;
    fkH();
    AppMethodBeat.o(245127);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(245124);
    super.onBindView(paramView);
    this.GzL.clear();
    this.GzL.add((ImageView)paramView.findViewById(R.h.image_iv1));
    this.GzL.add((ImageView)paramView.findViewById(R.h.image_iv2));
    this.GzL.add((ImageView)paramView.findViewById(R.h.image_iv3));
    this.GzL.add((ImageView)paramView.findViewById(R.h.image_iv4));
    paramView = (TextView)paramView.findViewById(R.h.album_title);
    if (!Util.isNullOrNil(this.mTitle))
    {
      paramView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.width = a.br(this.mContext, R.f.FixedTitleWidth);
      paramView.setLayoutParams(localLayoutParams);
    }
    fkH();
    AppMethodBeat.o(245124);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(245120);
    if (this.KKQ == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(R.i.glP, localViewGroup);
      this.KKQ = paramViewGroup;
    }
    paramViewGroup = this.KKQ;
    AppMethodBeat.o(245120);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FinderPreference
 * JD-Core Version:    0.7.0.1
 */
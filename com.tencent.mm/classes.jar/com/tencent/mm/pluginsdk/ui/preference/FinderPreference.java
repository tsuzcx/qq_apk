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
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.af;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.ezi;
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
  private List<ImageView> AYn;
  private View EQs;
  public ezi Rqh;
  private MMActivity iXq;
  public String mTitle;
  
  public FinderPreference(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(219756);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(219756);
  }
  
  public FinderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(219759);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(219759);
  }
  
  public FinderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(219760);
    this.mTitle = "";
    this.AYn = new LinkedList();
    this.Rqh = null;
    this.iXq = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(R.l.find_friends_by_finder);
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(219760);
  }
  
  private void eiM()
  {
    AppMethodBeat.i(219764);
    Object localObject = this.AYn.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ImageView)((Iterator)localObject).next()).setVisibility(8);
    }
    localObject = this.Rqh;
    if ((localObject != null) && (((ezi)localObject).SVR == 0))
    {
      int j = ((ezi)localObject).SGi.size();
      int i = 0;
      while ((i < j) && (i < this.AYn.size()))
      {
        ImageView localImageView = (ImageView)this.AYn.get(i);
        localImageView.setVisibility(0);
        ((ak)h.ag(ak.class)).getFinderUIApi().a(((ezi)localObject).SGi.get(i), localImageView);
        i += 1;
      }
    }
    AppMethodBeat.o(219764);
  }
  
  public final void a(ezi paramezi)
  {
    AppMethodBeat.i(219774);
    this.Rqh = paramezi;
    eiM();
    AppMethodBeat.o(219774);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(219772);
    super.onBindView(paramView);
    this.AYn.clear();
    this.AYn.add((ImageView)paramView.findViewById(R.h.image_iv1));
    this.AYn.add((ImageView)paramView.findViewById(R.h.image_iv2));
    this.AYn.add((ImageView)paramView.findViewById(R.h.image_iv3));
    this.AYn.add((ImageView)paramView.findViewById(R.h.image_iv4));
    paramView = (TextView)paramView.findViewById(R.h.album_title);
    if (!Util.isNullOrNil(this.mTitle))
    {
      paramView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.width = a.aY(this.mContext, R.f.FixedTitleWidth);
      paramView.setLayoutParams(localLayoutParams);
    }
    eiM();
    AppMethodBeat.o(219772);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(219767);
    if (this.EQs == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(R.i.eiQ, localViewGroup);
      this.EQs = paramViewGroup;
    }
    paramViewGroup = this.EQs;
    AppMethodBeat.o(219767);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FinderPreference
 * JD-Core Version:    0.7.0.1
 */
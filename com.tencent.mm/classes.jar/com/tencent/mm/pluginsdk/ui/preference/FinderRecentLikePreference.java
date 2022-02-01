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
import com.tencent.mm.protocal.protobuf.fvm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class FinderRecentLikePreference
  extends Preference
{
  private List<ImageView> GzL;
  private fvm GzM;
  private View KKQ;
  private MMActivity lzt;
  private String mTitle;
  
  public FinderRecentLikePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(245116);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(245116);
  }
  
  public FinderRecentLikePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(245117);
    this.mTitle = "";
    this.GzL = new LinkedList();
    this.GzM = null;
    this.lzt = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(R.l.find_friends_recent_like);
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(245117);
  }
  
  private void fkH()
  {
    AppMethodBeat.i(245119);
    Object localObject = this.GzL.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ImageView)((Iterator)localObject).next()).setVisibility(8);
    }
    localObject = this.GzM;
    if (localObject != null)
    {
      int j = ((fvm)localObject).ZIQ.size();
      int i = 0;
      while ((i < j) && (i < this.GzL.size()))
      {
        ImageView localImageView = (ImageView)this.GzL.get(i);
        localImageView.setVisibility(0);
        ((cn)h.az(cn.class)).getFinderUIApi().a(((fvm)localObject).ZIQ.get(i), localImageView);
        i += 1;
      }
    }
    AppMethodBeat.o(245119);
  }
  
  public final void a(fvm paramfvm)
  {
    AppMethodBeat.i(245128);
    this.GzM = paramfvm;
    fkH();
    AppMethodBeat.o(245128);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(245125);
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
    AppMethodBeat.o(245125);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(245122);
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
    AppMethodBeat.o(245122);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FinderRecentLikePreference
 * JD-Core Version:    0.7.0.1
 */
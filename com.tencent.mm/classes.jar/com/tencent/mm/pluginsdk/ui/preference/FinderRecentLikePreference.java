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
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.ae;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.eoz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class FinderRecentLikePreference
  extends Preference
{
  private List<ImageView> Kpq;
  private eoz Kps;
  private MMActivity gte;
  private String mTitle;
  private View zlc;
  
  public FinderRecentLikePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(232339);
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(232339);
  }
  
  public FinderRecentLikePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(232340);
    this.mTitle = "";
    this.Kpq = new LinkedList();
    this.Kps = null;
    this.gte = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(2131759439);
    setLayoutResource(2131495538);
    AppMethodBeat.o(232340);
  }
  
  private void grH()
  {
    AppMethodBeat.i(232341);
    Object localObject = this.Kpq.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ImageView)((Iterator)localObject).next()).setVisibility(8);
    }
    localObject = this.Kps;
    if (localObject != null)
    {
      int j = ((eoz)localObject).LCW.size();
      int i = 0;
      while ((i < j) && (i < this.Kpq.size()))
      {
        ImageView localImageView = (ImageView)this.Kpq.get(i);
        localImageView.setVisibility(0);
        ((aj)g.ah(aj.class)).getFinderUIApi().a(((eoz)localObject).LCW.get(i), localImageView);
        i += 1;
      }
    }
    AppMethodBeat.o(232341);
  }
  
  public final void a(eoz parameoz)
  {
    AppMethodBeat.i(232344);
    this.Kps = parameoz;
    grH();
    AppMethodBeat.o(232344);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(232343);
    super.onBindView(paramView);
    this.Kpq.clear();
    this.Kpq.add((ImageView)paramView.findViewById(2131302574));
    this.Kpq.add((ImageView)paramView.findViewById(2131302575));
    this.Kpq.add((ImageView)paramView.findViewById(2131302576));
    this.Kpq.add((ImageView)paramView.findViewById(2131302577));
    paramView = (TextView)paramView.findViewById(2131296703);
    if (!Util.isNullOrNil(this.mTitle))
    {
      paramView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.width = a.aG(this.mContext, 2131165381);
      paramView.setLayoutParams(localLayoutParams);
    }
    grH();
    AppMethodBeat.o(232343);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(232342);
    if (this.zlc == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(2131495561, localViewGroup);
      this.zlc = paramViewGroup;
    }
    paramViewGroup = this.zlc;
    AppMethodBeat.o(232342);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FinderRecentLikePreference
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.a.qb.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference
  extends Preference
  implements com.tencent.mm.ui.base.preference.g
{
  private QDisFadeImageView FgJ;
  private QDisFadeImageView FgK;
  private QDisFadeImageView FgL;
  private QDisFadeImageView FgM;
  private ImageView FgN;
  private ImageView FgO;
  private ImageView FgP;
  private ImageView FgQ;
  private a FgR;
  private MMActivity fLP;
  private List<byn> list;
  private String mTitle;
  private int rlt;
  private View vET;
  private bj zdv;
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(31906);
    this.fLP = ((MMActivity)paramContext);
    AppMethodBeat.o(31906);
  }
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31907);
    this.mTitle = "";
    this.FgJ = null;
    this.FgK = null;
    this.FgL = null;
    this.FgM = null;
    this.FgN = null;
    this.FgO = null;
    this.FgP = null;
    this.FgQ = null;
    this.rlt = 255;
    this.list = new LinkedList();
    this.FgR = new a();
    this.fLP = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(2131757823);
    setLayoutResource(2131494804);
    AppMethodBeat.o(31907);
  }
  
  private void feP()
  {
    int j = 0;
    AppMethodBeat.i(31908);
    if (this.FgJ != null)
    {
      this.FgJ.setImageResource(2131101179);
      this.FgJ.setVisibility(4);
    }
    if (this.FgK != null)
    {
      this.FgK.setImageResource(2131101179);
      this.FgK.setVisibility(4);
    }
    if (this.FgL != null)
    {
      this.FgL.setImageResource(2131101179);
      this.FgL.setVisibility(4);
    }
    if (this.FgM != null)
    {
      this.FgM.setImageResource(2131101179);
      this.FgM.setVisibility(4);
    }
    ImageView localImageView;
    if ((this.FgJ != null) && (this.list.size() > 0))
    {
      this.FgJ.setVisibility(0);
      if (e.abf()) {
        break label295;
      }
      this.FgJ.setImageResource(2131233475);
      localImageView = this.FgN;
    }
    label295:
    label440:
    label587:
    label600:
    for (;;)
    {
      for (int i = 8;; i = 0)
      {
        localImageView.setVisibility(i);
        if ((this.FgK != null) && (this.list.size() >= 2))
        {
          this.FgK.setVisibility(0);
          if (e.abf()) {
            break;
          }
          this.FgK.setImageResource(2131233475);
        }
        if ((this.FgL != null) && (this.list.size() >= 3))
        {
          this.FgL.setVisibility(0);
          if (e.abf()) {
            break label440;
          }
          this.FgL.setImageResource(2131233475);
        }
        if ((this.FgM == null) || (this.list.size() < 4)) {
          break label587;
        }
        this.FgM.setVisibility(0);
        if (e.abf()) {
          break label518;
        }
        this.FgM.setImageResource(2131233475);
        AppMethodBeat.o(31908);
        return;
        o.zbS.b((byn)this.list.get(0), this.FgJ, this.fLP.hashCode(), this.zdv);
        localImageView = this.FgN;
        if (((byn)this.list.get(0)).nEf != 6) {
          break label600;
        }
      }
      o.zbS.b((byn)this.list.get(1), this.FgK, this.fLP.hashCode(), this.zdv);
      localImageView = this.FgO;
      if (((byn)this.list.get(1)).nEf == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      o.zbS.b((byn)this.list.get(2), this.FgL, this.fLP.hashCode(), this.zdv);
      localImageView = this.FgP;
      if (((byn)this.list.get(2)).nEf == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      o.zbS.b((byn)this.list.get(3), this.FgM, this.fLP.hashCode(), this.zdv);
      localImageView = this.FgQ;
      if (((byn)this.list.get(3)).nEf == 6) {}
      for (i = j;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(31908);
        return;
      }
    }
  }
  
  public final void aNf(String paramString)
  {
    AppMethodBeat.i(31911);
    if (paramString == null)
    {
      AppMethodBeat.o(31911);
      return;
    }
    this.list.clear();
    ba.aBQ();
    Object localObject = c.azp().Bf(paramString);
    if ((localObject != null) && ((int)((com.tencent.mm.o.b)localObject).gfj > 0) && (com.tencent.mm.o.b.lM(((aw)localObject).field_type))) {
      this.zdv = bj.ILR;
    }
    for (;;)
    {
      localObject = new qb();
      ((qb)localObject).dEw.username = paramString;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if (((qb)localObject).dEx.dEy != null) {
        this.list.add(((qb)localObject).dEx.dEy);
      }
      if (((qb)localObject).dEx.dEz != null) {
        this.list.add(((qb)localObject).dEx.dEz);
      }
      if (((qb)localObject).dEx.dEA != null) {
        this.list.add(((qb)localObject).dEx.dEA);
      }
      if (((qb)localObject).dEx.dEB != null) {
        this.list.add(((qb)localObject).dEx.dEB);
      }
      feP();
      AppMethodBeat.o(31911);
      return;
      if (paramString.equals(u.aAm())) {
        this.zdv = bj.ILR;
      } else {
        this.zdv = bj.ILS;
      }
    }
  }
  
  public final int feQ()
  {
    AppMethodBeat.i(31912);
    int i = 0;
    if (this.list != null) {
      i = this.list.size();
    }
    AppMethodBeat.o(31912);
    return i;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31910);
    super.onBindView(paramView);
    this.FgJ = ((QDisFadeImageView)paramView.findViewById(2131300944));
    this.FgJ.setAlpha(this.rlt);
    this.FgJ.setImageDrawable(this.FgR);
    this.FgK = ((QDisFadeImageView)paramView.findViewById(2131300945));
    this.FgK.setAlpha(this.rlt);
    this.FgK.setImageDrawable(this.FgR);
    this.FgL = ((QDisFadeImageView)paramView.findViewById(2131300946));
    this.FgL.setAlpha(this.rlt);
    this.FgL.setImageDrawable(this.FgR);
    this.FgM = ((QDisFadeImageView)paramView.findViewById(2131300947));
    this.FgM.setAlpha(this.rlt);
    this.FgM.setImageDrawable(this.FgR);
    TextView localTextView = (TextView)paramView.findViewById(2131296626);
    if (!bt.isNullOrNil(this.mTitle))
    {
      localTextView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
      localLayoutParams.width = com.tencent.mm.cc.a.ax(this.mContext, 2131165370);
      localTextView.setLayoutParams(localLayoutParams);
    }
    this.FgN = ((ImageView)paramView.findViewById(2131305050));
    this.FgO = ((ImageView)paramView.findViewById(2131305051));
    this.FgP = ((ImageView)paramView.findViewById(2131305052));
    this.FgQ = ((ImageView)paramView.findViewById(2131305053));
    this.FgN.setVisibility(8);
    this.FgO.setVisibility(8);
    this.FgP.setVisibility(8);
    this.FgQ.setVisibility(8);
    feP();
    if ((paramView == null) || (this.list == null))
    {
      AppMethodBeat.o(31910);
      return;
    }
    paramView.setContentDescription(this.mContext.getString(2131762049, new Object[] { Integer.valueOf(this.list.size()) }));
    AppMethodBeat.o(31910);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31909);
    if (this.vET == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(2131494821, localViewGroup);
      this.vET = paramViewGroup;
    }
    paramViewGroup = this.vET;
    AppMethodBeat.o(31909);
    return paramViewGroup;
  }
  
  static final class a
    extends ColorDrawable
  {
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SnsPreference
 * JD-Core Version:    0.7.0.1
 */
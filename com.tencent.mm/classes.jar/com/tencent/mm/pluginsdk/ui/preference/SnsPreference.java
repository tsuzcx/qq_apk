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
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qc.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference
  extends Preference
  implements com.tencent.mm.ui.base.preference.g
{
  private QDisFadeImageView Fzh;
  private QDisFadeImageView Fzi;
  private QDisFadeImageView Fzj;
  private QDisFadeImageView Fzk;
  private ImageView Fzl;
  private ImageView Fzm;
  private ImageView Fzn;
  private ImageView Fzo;
  private a Fzp;
  private MMActivity fNT;
  private List<bzh> list;
  private String mTitle;
  private int rty;
  private View vQX;
  private bk zul;
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(31906);
    this.fNT = ((MMActivity)paramContext);
    AppMethodBeat.o(31906);
  }
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31907);
    this.mTitle = "";
    this.Fzh = null;
    this.Fzi = null;
    this.Fzj = null;
    this.Fzk = null;
    this.Fzl = null;
    this.Fzm = null;
    this.Fzn = null;
    this.Fzo = null;
    this.rty = 255;
    this.list = new LinkedList();
    this.Fzp = new a();
    this.fNT = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(2131757823);
    setLayoutResource(2131494804);
    AppMethodBeat.o(31907);
  }
  
  private void fiF()
  {
    int j = 0;
    AppMethodBeat.i(31908);
    if (this.Fzh != null)
    {
      this.Fzh.setImageResource(2131101179);
      this.Fzh.setVisibility(4);
    }
    if (this.Fzi != null)
    {
      this.Fzi.setImageResource(2131101179);
      this.Fzi.setVisibility(4);
    }
    if (this.Fzj != null)
    {
      this.Fzj.setImageResource(2131101179);
      this.Fzj.setVisibility(4);
    }
    if (this.Fzk != null)
    {
      this.Fzk.setImageResource(2131101179);
      this.Fzk.setVisibility(4);
    }
    ImageView localImageView;
    if ((this.Fzh != null) && (this.list.size() > 0))
    {
      this.Fzh.setVisibility(0);
      if (e.abo()) {
        break label295;
      }
      this.Fzh.setImageResource(2131233475);
      localImageView = this.Fzl;
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
        if ((this.Fzi != null) && (this.list.size() >= 2))
        {
          this.Fzi.setVisibility(0);
          if (e.abo()) {
            break;
          }
          this.Fzi.setImageResource(2131233475);
        }
        if ((this.Fzj != null) && (this.list.size() >= 3))
        {
          this.Fzj.setVisibility(0);
          if (e.abo()) {
            break label440;
          }
          this.Fzj.setImageResource(2131233475);
        }
        if ((this.Fzk == null) || (this.list.size() < 4)) {
          break label587;
        }
        this.Fzk.setVisibility(0);
        if (e.abo()) {
          break label518;
        }
        this.Fzk.setImageResource(2131233475);
        AppMethodBeat.o(31908);
        return;
        o.zsv.b((bzh)this.list.get(0), this.Fzh, this.fNT.hashCode(), this.zul);
        localImageView = this.Fzl;
        if (((bzh)this.list.get(0)).nJA != 6) {
          break label600;
        }
      }
      o.zsv.b((bzh)this.list.get(1), this.Fzi, this.fNT.hashCode(), this.zul);
      localImageView = this.Fzm;
      if (((bzh)this.list.get(1)).nJA == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      o.zsv.b((bzh)this.list.get(2), this.Fzj, this.fNT.hashCode(), this.zul);
      localImageView = this.Fzn;
      if (((bzh)this.list.get(2)).nJA == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      o.zsv.b((bzh)this.list.get(3), this.Fzk, this.fNT.hashCode(), this.zul);
      localImageView = this.Fzo;
      if (((bzh)this.list.get(3)).nJA == 6) {}
      for (i = j;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(31908);
        return;
      }
    }
  }
  
  public final void aOC(String paramString)
  {
    AppMethodBeat.i(31911);
    if (paramString == null)
    {
      AppMethodBeat.o(31911);
      return;
    }
    this.list.clear();
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azF().BH(paramString);
    if ((localObject != null) && ((int)((com.tencent.mm.contact.c)localObject).ght > 0) && (com.tencent.mm.contact.c.lO(((aw)localObject).field_type))) {
      this.zul = bk.Jgy;
    }
    for (;;)
    {
      localObject = new qc();
      ((qc)localObject).dFB.username = paramString;
      com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
      if (((qc)localObject).dFC.dFD != null) {
        this.list.add(((qc)localObject).dFC.dFD);
      }
      if (((qc)localObject).dFC.dFE != null) {
        this.list.add(((qc)localObject).dFC.dFE);
      }
      if (((qc)localObject).dFC.dFF != null) {
        this.list.add(((qc)localObject).dFC.dFF);
      }
      if (((qc)localObject).dFC.dFG != null) {
        this.list.add(((qc)localObject).dFC.dFG);
      }
      fiF();
      AppMethodBeat.o(31911);
      return;
      if (paramString.equals(v.aAC())) {
        this.zul = bk.Jgy;
      } else {
        this.zul = bk.Jgz;
      }
    }
  }
  
  public final int fiG()
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
    this.Fzh = ((QDisFadeImageView)paramView.findViewById(2131300944));
    this.Fzh.setAlpha(this.rty);
    this.Fzh.setImageDrawable(this.Fzp);
    this.Fzi = ((QDisFadeImageView)paramView.findViewById(2131300945));
    this.Fzi.setAlpha(this.rty);
    this.Fzi.setImageDrawable(this.Fzp);
    this.Fzj = ((QDisFadeImageView)paramView.findViewById(2131300946));
    this.Fzj.setAlpha(this.rty);
    this.Fzj.setImageDrawable(this.Fzp);
    this.Fzk = ((QDisFadeImageView)paramView.findViewById(2131300947));
    this.Fzk.setAlpha(this.rty);
    this.Fzk.setImageDrawable(this.Fzp);
    TextView localTextView = (TextView)paramView.findViewById(2131296626);
    if (!bu.isNullOrNil(this.mTitle))
    {
      localTextView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
      localLayoutParams.width = com.tencent.mm.cb.a.ax(this.mContext, 2131165370);
      localTextView.setLayoutParams(localLayoutParams);
    }
    this.Fzl = ((ImageView)paramView.findViewById(2131305050));
    this.Fzm = ((ImageView)paramView.findViewById(2131305051));
    this.Fzn = ((ImageView)paramView.findViewById(2131305052));
    this.Fzo = ((ImageView)paramView.findViewById(2131305053));
    this.Fzl.setVisibility(8);
    this.Fzm.setVisibility(8);
    this.Fzn.setVisibility(8);
    this.Fzo.setVisibility(8);
    fiF();
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
    if (this.vQX == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(2131494821, localViewGroup);
      this.vQX = paramViewGroup;
    }
    paramViewGroup = this.vQX;
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
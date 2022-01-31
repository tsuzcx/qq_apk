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
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.nv.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.g;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference
  extends Preference
  implements g
{
  private MMActivity cmc;
  private List<bcs> list;
  private String mTitle;
  private int mml;
  private View ozm;
  private az rbm;
  private QDisFadeImageView wbF;
  private QDisFadeImageView wbG;
  private QDisFadeImageView wbH;
  private QDisFadeImageView wbI;
  private ImageView wbJ;
  private ImageView wbK;
  private ImageView wbL;
  private ImageView wbM;
  private SnsPreference.a wbN;
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(28117);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(28117);
  }
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28118);
    this.mTitle = "";
    this.wbF = null;
    this.wbG = null;
    this.wbH = null;
    this.wbI = null;
    this.wbJ = null;
    this.wbK = null;
    this.wbL = null;
    this.wbM = null;
    this.mml = 255;
    this.list = new LinkedList();
    this.wbN = new SnsPreference.a();
    this.cmc = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(2131298760);
    setLayoutResource(2130970179);
    AppMethodBeat.o(28118);
  }
  
  private void dpm()
  {
    int j = 0;
    AppMethodBeat.i(28119);
    if (this.wbF != null)
    {
      this.wbF.setImageResource(2131690709);
      this.wbF.setVisibility(4);
    }
    if (this.wbG != null)
    {
      this.wbG.setImageResource(2131690709);
      this.wbG.setVisibility(4);
    }
    if (this.wbH != null)
    {
      this.wbH.setImageResource(2131690709);
      this.wbH.setVisibility(4);
    }
    if (this.wbI != null)
    {
      this.wbI.setImageResource(2131690709);
      this.wbI.setVisibility(4);
    }
    ImageView localImageView;
    if ((this.wbF != null) && (this.list.size() > 0))
    {
      this.wbF.setVisibility(0);
      if (com.tencent.mm.compatible.util.f.Mi()) {
        break label295;
      }
      this.wbF.setImageResource(2130839820);
      localImageView = this.wbJ;
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
        if ((this.wbG != null) && (this.list.size() >= 2))
        {
          this.wbG.setVisibility(0);
          if (com.tencent.mm.compatible.util.f.Mi()) {
            break;
          }
          this.wbG.setImageResource(2130839820);
        }
        if ((this.wbH != null) && (this.list.size() >= 3))
        {
          this.wbH.setVisibility(0);
          if (com.tencent.mm.compatible.util.f.Mi()) {
            break label440;
          }
          this.wbH.setImageResource(2130839820);
        }
        if ((this.wbI == null) || (this.list.size() < 4)) {
          break label587;
        }
        this.wbI.setVisibility(0);
        if (com.tencent.mm.compatible.util.f.Mi()) {
          break label518;
        }
        this.wbI.setImageResource(2130839820);
        AppMethodBeat.o(28119);
        return;
        n.raQ.b((bcs)this.list.get(0), this.wbF, this.cmc.hashCode(), this.rbm);
        localImageView = this.wbJ;
        if (((bcs)this.list.get(0)).jKs != 6) {
          break label600;
        }
      }
      n.raQ.b((bcs)this.list.get(1), this.wbG, this.cmc.hashCode(), this.rbm);
      localImageView = this.wbK;
      if (((bcs)this.list.get(1)).jKs == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      n.raQ.b((bcs)this.list.get(2), this.wbH, this.cmc.hashCode(), this.rbm);
      localImageView = this.wbL;
      if (((bcs)this.list.get(2)).jKs == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      n.raQ.b((bcs)this.list.get(3), this.wbI, this.cmc.hashCode(), this.rbm);
      localImageView = this.wbM;
      if (((bcs)this.list.get(3)).jKs == 6) {}
      for (i = j;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(28119);
        return;
      }
    }
  }
  
  public final void amx(String paramString)
  {
    AppMethodBeat.i(28122);
    if (paramString == null)
    {
      AppMethodBeat.o(28122);
      return;
    }
    this.list.clear();
    aw.aaz();
    Object localObject = c.YA().arw(paramString);
    if ((localObject != null) && ((int)((com.tencent.mm.n.a)localObject).euF > 0) && (com.tencent.mm.n.a.je(((aq)localObject).field_type))) {
      this.rbm = az.yNQ;
    }
    for (;;)
    {
      localObject = new nv();
      ((nv)localObject).cEp.username = paramString;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      if (((nv)localObject).cEq.cEr != null) {
        this.list.add(((nv)localObject).cEq.cEr);
      }
      if (((nv)localObject).cEq.cEs != null) {
        this.list.add(((nv)localObject).cEq.cEs);
      }
      if (((nv)localObject).cEq.cEt != null) {
        this.list.add(((nv)localObject).cEq.cEt);
      }
      if (((nv)localObject).cEq.cEu != null) {
        this.list.add(((nv)localObject).cEq.cEu);
      }
      dpm();
      AppMethodBeat.o(28122);
      return;
      if (paramString.equals(r.Zn())) {
        this.rbm = az.yNQ;
      } else {
        this.rbm = az.yNR;
      }
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(28121);
    super.onBindView(paramView);
    this.wbF = ((QDisFadeImageView)paramView.findViewById(2131826202));
    this.wbF.setAlpha(this.mml);
    this.wbF.setImageDrawable(this.wbN);
    this.wbG = ((QDisFadeImageView)paramView.findViewById(2131826204));
    this.wbG.setAlpha(this.mml);
    this.wbG.setImageDrawable(this.wbN);
    this.wbH = ((QDisFadeImageView)paramView.findViewById(2131826206));
    this.wbH.setAlpha(this.mml);
    this.wbH.setImageDrawable(this.wbN);
    this.wbI = ((QDisFadeImageView)paramView.findViewById(2131826208));
    this.wbI.setAlpha(this.mml);
    this.wbI.setImageDrawable(this.wbN);
    TextView localTextView = (TextView)paramView.findViewById(2131826192);
    if (!bo.isNullOrNil(this.mTitle))
    {
      localTextView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
      localLayoutParams.width = com.tencent.mm.cb.a.ao(this.mContext, 2131427664);
      localTextView.setLayoutParams(localLayoutParams);
    }
    this.wbJ = ((ImageView)paramView.findViewById(2131826203));
    this.wbK = ((ImageView)paramView.findViewById(2131826205));
    this.wbL = ((ImageView)paramView.findViewById(2131826207));
    this.wbM = ((ImageView)paramView.findViewById(2131826209));
    this.wbJ.setVisibility(8);
    this.wbK.setVisibility(8);
    this.wbL.setVisibility(8);
    this.wbM.setVisibility(8);
    dpm();
    if ((paramView == null) || (this.list == null))
    {
      AppMethodBeat.o(28121);
      return;
    }
    paramView.setContentDescription(this.mContext.getString(2131302181, new Object[] { Integer.valueOf(this.list.size()) }));
    AppMethodBeat.o(28121);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28120);
    if (this.ozm == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(2130970196, localViewGroup);
      this.ozm = paramViewGroup;
    }
    paramViewGroup = this.ozm;
    AppMethodBeat.o(28120);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SnsPreference
 * JD-Core Version:    0.7.0.1
 */
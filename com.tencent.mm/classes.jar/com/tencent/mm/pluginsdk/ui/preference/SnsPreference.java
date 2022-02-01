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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.a.qw.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference
  extends Preference
  implements com.tencent.mm.ui.base.preference.g
{
  private bp DEv;
  private QDisFadeImageView Kqg;
  private QDisFadeImageView Kqh;
  private QDisFadeImageView Kqi;
  private QDisFadeImageView Kqj;
  private ImageView Kqk;
  private ImageView Kql;
  private ImageView Kqm;
  private ImageView Kqn;
  private a Kqo;
  private MMActivity gte;
  private List<cnb> list;
  private String mTitle;
  private int sUb;
  private View zlc;
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(31906);
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(31906);
  }
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31907);
    this.mTitle = "";
    this.Kqg = null;
    this.Kqh = null;
    this.Kqi = null;
    this.Kqj = null;
    this.Kqk = null;
    this.Kql = null;
    this.Kqm = null;
    this.Kqn = null;
    this.sUb = 255;
    this.list = new LinkedList();
    this.Kqo = new a();
    this.gte = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(2131758063);
    setLayoutResource(2131495538);
    AppMethodBeat.o(31907);
  }
  
  public final void bfe(final String paramString)
  {
    AppMethodBeat.i(31911);
    if (paramString == null)
    {
      AppMethodBeat.o(31911);
      return;
    }
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(paramString);
    if ((localas != null) && ((int)localas.gMZ > 0) && (com.tencent.mm.contact.c.oR(localas.field_type))) {
      this.DEv = bp.Oqp;
    }
    for (;;)
    {
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232348);
          qw localqw = new qw();
          localqw.dXo.username = paramString;
          EventCenter.instance.publish(localqw);
          final LinkedList localLinkedList = new LinkedList();
          if (localqw.dXp.dXq != null) {
            localLinkedList.add(localqw.dXp.dXq);
          }
          if (localqw.dXp.dXr != null) {
            localLinkedList.add(localqw.dXp.dXr);
          }
          if (localqw.dXp.dXs != null) {
            localLinkedList.add(localqw.dXp.dXs);
          }
          if (localqw.dXp.dXt != null) {
            localLinkedList.add(localqw.dXp.dXt);
          }
          SnsPreference.b(SnsPreference.this).runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(232347);
              SnsPreference.a(SnsPreference.this).clear();
              SnsPreference.a(SnsPreference.this).addAll(localLinkedList);
              SnsPreference.this.iv(SnsPreference.a(SnsPreference.this));
              AppMethodBeat.o(232347);
            }
          });
          AppMethodBeat.o(232348);
        }
      });
      AppMethodBeat.o(31911);
      return;
      if (paramString.equals(z.aTY())) {
        this.DEv = bp.Oqp;
      } else {
        this.DEv = bp.Oqq;
      }
    }
  }
  
  public final int grS()
  {
    AppMethodBeat.i(31912);
    int i = 0;
    if (this.list != null) {
      i = this.list.size();
    }
    AppMethodBeat.o(31912);
    return i;
  }
  
  public final void iv(List<cnb> paramList)
  {
    int j = 0;
    AppMethodBeat.i(232349);
    if (this.Kqg != null)
    {
      this.Kqg.setImageResource(2131101424);
      this.Kqg.setVisibility(4);
    }
    if (this.Kqh != null)
    {
      this.Kqh.setImageResource(2131101424);
      this.Kqh.setVisibility(4);
    }
    if (this.Kqi != null)
    {
      this.Kqi.setImageResource(2131101424);
      this.Kqi.setVisibility(4);
    }
    if (this.Kqj != null)
    {
      this.Kqj.setImageResource(2131101424);
      this.Kqj.setVisibility(4);
    }
    ImageView localImageView;
    if ((this.Kqg != null) && (paramList.size() > 0))
    {
      this.Kqg.setVisibility(0);
      if (e.apn()) {
        break label283;
      }
      this.Kqg.setImageResource(2131234278);
      localImageView = this.Kqk;
    }
    label283:
    label419:
    label558:
    label570:
    for (;;)
    {
      for (int i = 8;; i = 0)
      {
        localImageView.setVisibility(i);
        if ((this.Kqh != null) && (paramList.size() >= 2))
        {
          this.Kqh.setVisibility(0);
          if (e.apn()) {
            break;
          }
          this.Kqh.setImageResource(2131234278);
        }
        if ((this.Kqi != null) && (paramList.size() >= 3))
        {
          this.Kqi.setVisibility(0);
          if (e.apn()) {
            break label419;
          }
          this.Kqi.setImageResource(2131234278);
        }
        if ((this.Kqj == null) || (paramList.size() < 4)) {
          break label558;
        }
        this.Kqj.setVisibility(0);
        if (e.apn()) {
          break label493;
        }
        this.Kqj.setImageResource(2131234278);
        AppMethodBeat.o(232349);
        return;
        o.DCM.b((cnb)paramList.get(0), this.Kqg, this.gte.hashCode(), this.DEv);
        localImageView = this.Kqk;
        if (((cnb)paramList.get(0)).oUv != 6) {
          break label570;
        }
      }
      o.DCM.b((cnb)paramList.get(1), this.Kqh, this.gte.hashCode(), this.DEv);
      localImageView = this.Kql;
      if (((cnb)paramList.get(1)).oUv == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      o.DCM.b((cnb)paramList.get(2), this.Kqi, this.gte.hashCode(), this.DEv);
      localImageView = this.Kqm;
      if (((cnb)paramList.get(2)).oUv == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      label493:
      o.DCM.b((cnb)paramList.get(3), this.Kqj, this.gte.hashCode(), this.DEv);
      localImageView = this.Kqn;
      if (((cnb)paramList.get(3)).oUv == 6) {}
      for (i = j;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(232349);
        return;
      }
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31910);
    super.onBindView(paramView);
    this.Kqg = ((QDisFadeImageView)paramView.findViewById(2131302574));
    this.Kqg.setAlpha(this.sUb);
    this.Kqg.setImageDrawable(this.Kqo);
    this.Kqh = ((QDisFadeImageView)paramView.findViewById(2131302575));
    this.Kqh.setAlpha(this.sUb);
    this.Kqh.setImageDrawable(this.Kqo);
    this.Kqi = ((QDisFadeImageView)paramView.findViewById(2131302576));
    this.Kqi.setAlpha(this.sUb);
    this.Kqi.setImageDrawable(this.Kqo);
    this.Kqj = ((QDisFadeImageView)paramView.findViewById(2131302577));
    this.Kqj.setAlpha(this.sUb);
    this.Kqj.setImageDrawable(this.Kqo);
    TextView localTextView = (TextView)paramView.findViewById(2131296703);
    if (!Util.isNullOrNil(this.mTitle))
    {
      localTextView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
      localLayoutParams.width = a.aG(this.mContext, 2131165381);
      localTextView.setLayoutParams(localLayoutParams);
    }
    this.Kqk = ((ImageView)paramView.findViewById(2131308205));
    this.Kql = ((ImageView)paramView.findViewById(2131308206));
    this.Kqm = ((ImageView)paramView.findViewById(2131308207));
    this.Kqn = ((ImageView)paramView.findViewById(2131308208));
    this.Kqk.setVisibility(8);
    this.Kql.setVisibility(8);
    this.Kqm.setVisibility(8);
    this.Kqn.setVisibility(8);
    iv(this.list);
    if ((paramView == null) || (this.list == null))
    {
      AppMethodBeat.o(31910);
      return;
    }
    paramView.setContentDescription(this.mContext.getString(2131764066, new Object[] { Integer.valueOf(this.list.size()) }));
    AppMethodBeat.o(31910);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31909);
    if (this.zlc == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(2131495555, localViewGroup);
      this.zlc = paramViewGroup;
    }
    paramViewGroup = this.zlc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SnsPreference
 * JD-Core Version:    0.7.0.1
 */
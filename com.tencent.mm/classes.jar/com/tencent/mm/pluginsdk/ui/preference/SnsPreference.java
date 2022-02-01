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
import com.tencent.mm.g.a.pi;
import com.tencent.mm.g.a.pi.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference
  extends Preference
  implements com.tencent.mm.ui.base.preference.g
{
  private QDisFadeImageView Cjl;
  private QDisFadeImageView Cjm;
  private QDisFadeImageView Cjn;
  private QDisFadeImageView Cjo;
  private ImageView Cjp;
  private ImageView Cjq;
  private ImageView Cjr;
  private ImageView Cjs;
  private a Cjt;
  private MMActivity imP;
  private List<bpi> list;
  private String mTitle;
  private int pSW;
  private View ttN;
  private bc wBg;
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(31906);
    this.imP = ((MMActivity)paramContext);
    AppMethodBeat.o(31906);
  }
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31907);
    this.mTitle = "";
    this.Cjl = null;
    this.Cjm = null;
    this.Cjn = null;
    this.Cjo = null;
    this.Cjp = null;
    this.Cjq = null;
    this.Cjr = null;
    this.Cjs = null;
    this.pSW = 255;
    this.list = new LinkedList();
    this.Cjt = new a();
    this.imP = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(2131757823);
    setLayoutResource(2131494804);
    AppMethodBeat.o(31907);
  }
  
  private void eAt()
  {
    int j = 0;
    AppMethodBeat.i(31908);
    if (this.Cjl != null)
    {
      this.Cjl.setImageResource(2131101179);
      this.Cjl.setVisibility(4);
    }
    if (this.Cjm != null)
    {
      this.Cjm.setImageResource(2131101179);
      this.Cjm.setVisibility(4);
    }
    if (this.Cjn != null)
    {
      this.Cjn.setImageResource(2131101179);
      this.Cjn.setVisibility(4);
    }
    if (this.Cjo != null)
    {
      this.Cjo.setImageResource(2131101179);
      this.Cjo.setVisibility(4);
    }
    ImageView localImageView;
    if ((this.Cjl != null) && (this.list.size() > 0))
    {
      this.Cjl.setVisibility(0);
      if (e.XG()) {
        break label295;
      }
      this.Cjl.setImageResource(2131233475);
      localImageView = this.Cjp;
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
        if ((this.Cjm != null) && (this.list.size() >= 2))
        {
          this.Cjm.setVisibility(0);
          if (e.XG()) {
            break;
          }
          this.Cjm.setImageResource(2131233475);
        }
        if ((this.Cjn != null) && (this.list.size() >= 3))
        {
          this.Cjn.setVisibility(0);
          if (e.XG()) {
            break label440;
          }
          this.Cjn.setImageResource(2131233475);
        }
        if ((this.Cjo == null) || (this.list.size() < 4)) {
          break label587;
        }
        this.Cjo.setVisibility(0);
        if (e.XG()) {
          break label518;
        }
        this.Cjo.setImageResource(2131233475);
        AppMethodBeat.o(31908);
        return;
        o.wzG.b((bpi)this.list.get(0), this.Cjl, this.imP.hashCode(), this.wBg);
        localImageView = this.Cjp;
        if (((bpi)this.list.get(0)).mBH != 6) {
          break label600;
        }
      }
      o.wzG.b((bpi)this.list.get(1), this.Cjm, this.imP.hashCode(), this.wBg);
      localImageView = this.Cjq;
      if (((bpi)this.list.get(1)).mBH == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      o.wzG.b((bpi)this.list.get(2), this.Cjn, this.imP.hashCode(), this.wBg);
      localImageView = this.Cjr;
      if (((bpi)this.list.get(2)).mBH == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      o.wzG.b((bpi)this.list.get(3), this.Cjo, this.imP.hashCode(), this.wBg);
      localImageView = this.Cjs;
      if (((bpi)this.list.get(3)).mBH == 6) {}
      for (i = j;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(31908);
        return;
      }
    }
  }
  
  public final void aCk(String paramString)
  {
    AppMethodBeat.i(31911);
    if (paramString == null)
    {
      AppMethodBeat.o(31911);
      return;
    }
    this.list.clear();
    az.arV();
    Object localObject = c.apM().aHY(paramString);
    if ((localObject != null) && ((int)((com.tencent.mm.n.b)localObject).fId > 0) && (com.tencent.mm.n.b.ls(((au)localObject).field_type))) {
      this.wBg = bc.FzB;
    }
    for (;;)
    {
      localObject = new pi();
      ((pi)localObject).duR.username = paramString;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if (((pi)localObject).duS.duT != null) {
        this.list.add(((pi)localObject).duS.duT);
      }
      if (((pi)localObject).duS.duU != null) {
        this.list.add(((pi)localObject).duS.duU);
      }
      if (((pi)localObject).duS.duV != null) {
        this.list.add(((pi)localObject).duS.duV);
      }
      if (((pi)localObject).duS.duW != null) {
        this.list.add(((pi)localObject).duS.duW);
      }
      eAt();
      AppMethodBeat.o(31911);
      return;
      if (paramString.equals(u.aqG())) {
        this.wBg = bc.FzB;
      } else {
        this.wBg = bc.FzC;
      }
    }
  }
  
  public final int eAu()
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
    this.Cjl = ((QDisFadeImageView)paramView.findViewById(2131300944));
    this.Cjl.setAlpha(this.pSW);
    this.Cjl.setImageDrawable(this.Cjt);
    this.Cjm = ((QDisFadeImageView)paramView.findViewById(2131300945));
    this.Cjm.setAlpha(this.pSW);
    this.Cjm.setImageDrawable(this.Cjt);
    this.Cjn = ((QDisFadeImageView)paramView.findViewById(2131300946));
    this.Cjn.setAlpha(this.pSW);
    this.Cjn.setImageDrawable(this.Cjt);
    this.Cjo = ((QDisFadeImageView)paramView.findViewById(2131300947));
    this.Cjo.setAlpha(this.pSW);
    this.Cjo.setImageDrawable(this.Cjt);
    TextView localTextView = (TextView)paramView.findViewById(2131296626);
    if (!bt.isNullOrNil(this.mTitle))
    {
      localTextView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
      localLayoutParams.width = com.tencent.mm.cd.a.ao(this.mContext, 2131165370);
      localTextView.setLayoutParams(localLayoutParams);
    }
    this.Cjp = ((ImageView)paramView.findViewById(2131305050));
    this.Cjq = ((ImageView)paramView.findViewById(2131305051));
    this.Cjr = ((ImageView)paramView.findViewById(2131305052));
    this.Cjs = ((ImageView)paramView.findViewById(2131305053));
    this.Cjp.setVisibility(8);
    this.Cjq.setVisibility(8);
    this.Cjr.setVisibility(8);
    this.Cjs.setVisibility(8);
    eAt();
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
    if (this.ttN == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(2131494821, localViewGroup);
      this.ttN = paramViewGroup;
    }
    paramViewGroup = this.ttN;
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
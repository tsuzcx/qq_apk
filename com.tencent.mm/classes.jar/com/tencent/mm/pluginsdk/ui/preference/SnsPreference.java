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
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.pr.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference
  extends Preference
  implements com.tencent.mm.ui.base.preference.g
{
  private QDisFadeImageView DBC;
  private QDisFadeImageView DBD;
  private QDisFadeImageView DBE;
  private QDisFadeImageView DBF;
  private ImageView DBG;
  private ImageView DBH;
  private ImageView DBI;
  private ImageView DBJ;
  private a DBK;
  private MMActivity iMV;
  private List<btz> list;
  private String mTitle;
  private int qBD;
  private View uCg;
  private bf xNB;
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(31906);
    this.iMV = ((MMActivity)paramContext);
    AppMethodBeat.o(31906);
  }
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31907);
    this.mTitle = "";
    this.DBC = null;
    this.DBD = null;
    this.DBE = null;
    this.DBF = null;
    this.DBG = null;
    this.DBH = null;
    this.DBI = null;
    this.DBJ = null;
    this.qBD = 255;
    this.list = new LinkedList();
    this.DBK = new a();
    this.iMV = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(2131757823);
    setLayoutResource(2131494804);
    AppMethodBeat.o(31907);
  }
  
  private void ePN()
  {
    int j = 0;
    AppMethodBeat.i(31908);
    if (this.DBC != null)
    {
      this.DBC.setImageResource(2131101179);
      this.DBC.setVisibility(4);
    }
    if (this.DBD != null)
    {
      this.DBD.setImageResource(2131101179);
      this.DBD.setVisibility(4);
    }
    if (this.DBE != null)
    {
      this.DBE.setImageResource(2131101179);
      this.DBE.setVisibility(4);
    }
    if (this.DBF != null)
    {
      this.DBF.setImageResource(2131101179);
      this.DBF.setVisibility(4);
    }
    ImageView localImageView;
    if ((this.DBC != null) && (this.list.size() > 0))
    {
      this.DBC.setVisibility(0);
      if (e.YD()) {
        break label295;
      }
      this.DBC.setImageResource(2131233475);
      localImageView = this.DBG;
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
        if ((this.DBD != null) && (this.list.size() >= 2))
        {
          this.DBD.setVisibility(0);
          if (e.YD()) {
            break;
          }
          this.DBD.setImageResource(2131233475);
        }
        if ((this.DBE != null) && (this.list.size() >= 3))
        {
          this.DBE.setVisibility(0);
          if (e.YD()) {
            break label440;
          }
          this.DBE.setImageResource(2131233475);
        }
        if ((this.DBF == null) || (this.list.size() < 4)) {
          break label587;
        }
        this.DBF.setVisibility(0);
        if (e.YD()) {
          break label518;
        }
        this.DBF.setImageResource(2131233475);
        AppMethodBeat.o(31908);
        return;
        o.xMa.b((btz)this.list.get(0), this.DBC, this.iMV.hashCode(), this.xNB);
        localImageView = this.DBG;
        if (((btz)this.list.get(0)).ndI != 6) {
          break label600;
        }
      }
      o.xMa.b((btz)this.list.get(1), this.DBD, this.iMV.hashCode(), this.xNB);
      localImageView = this.DBH;
      if (((btz)this.list.get(1)).ndI == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      o.xMa.b((btz)this.list.get(2), this.DBE, this.iMV.hashCode(), this.xNB);
      localImageView = this.DBI;
      if (((btz)this.list.get(2)).ndI == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      o.xMa.b((btz)this.list.get(3), this.DBF, this.iMV.hashCode(), this.xNB);
      localImageView = this.DBJ;
      if (((btz)this.list.get(3)).ndI == 6) {}
      for (i = j;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(31908);
        return;
      }
    }
  }
  
  public final void aHC(String paramString)
  {
    AppMethodBeat.i(31911);
    if (paramString == null)
    {
      AppMethodBeat.o(31911);
      return;
    }
    this.list.clear();
    az.ayM();
    Object localObject = c.awB().aNt(paramString);
    if ((localObject != null) && ((int)((com.tencent.mm.n.b)localObject).fLJ > 0) && (com.tencent.mm.n.b.ln(((av)localObject).field_type))) {
      this.xNB = bf.GYD;
    }
    for (;;)
    {
      localObject = new pr();
      ((pr)localObject).dsD.username = paramString;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if (((pr)localObject).dsE.dsF != null) {
        this.list.add(((pr)localObject).dsE.dsF);
      }
      if (((pr)localObject).dsE.dsG != null) {
        this.list.add(((pr)localObject).dsE.dsG);
      }
      if (((pr)localObject).dsE.dsH != null) {
        this.list.add(((pr)localObject).dsE.dsH);
      }
      if (((pr)localObject).dsE.dsI != null) {
        this.list.add(((pr)localObject).dsE.dsI);
      }
      ePN();
      AppMethodBeat.o(31911);
      return;
      if (paramString.equals(u.axw())) {
        this.xNB = bf.GYD;
      } else {
        this.xNB = bf.GYE;
      }
    }
  }
  
  public final int ePO()
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
    this.DBC = ((QDisFadeImageView)paramView.findViewById(2131300944));
    this.DBC.setAlpha(this.qBD);
    this.DBC.setImageDrawable(this.DBK);
    this.DBD = ((QDisFadeImageView)paramView.findViewById(2131300945));
    this.DBD.setAlpha(this.qBD);
    this.DBD.setImageDrawable(this.DBK);
    this.DBE = ((QDisFadeImageView)paramView.findViewById(2131300946));
    this.DBE.setAlpha(this.qBD);
    this.DBE.setImageDrawable(this.DBK);
    this.DBF = ((QDisFadeImageView)paramView.findViewById(2131300947));
    this.DBF.setAlpha(this.qBD);
    this.DBF.setImageDrawable(this.DBK);
    TextView localTextView = (TextView)paramView.findViewById(2131296626);
    if (!bs.isNullOrNil(this.mTitle))
    {
      localTextView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
      localLayoutParams.width = com.tencent.mm.cc.a.au(this.mContext, 2131165370);
      localTextView.setLayoutParams(localLayoutParams);
    }
    this.DBG = ((ImageView)paramView.findViewById(2131305050));
    this.DBH = ((ImageView)paramView.findViewById(2131305051));
    this.DBI = ((ImageView)paramView.findViewById(2131305052));
    this.DBJ = ((ImageView)paramView.findViewById(2131305053));
    this.DBG.setVisibility(8);
    this.DBH.setVisibility(8);
    this.DBI.setVisibility(8);
    this.DBJ.setVisibility(8);
    ePN();
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
    if (this.uCg == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(2131494821, localViewGroup);
      this.uCg = paramViewGroup;
    }
    paramViewGroup = this.uCg;
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
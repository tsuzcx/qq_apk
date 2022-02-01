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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ci.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.rw;
import com.tencent.mm.f.a.rw.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
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
  private View EQs;
  private bp JRq;
  private QDisFadeImageView RqW;
  private QDisFadeImageView RqX;
  private QDisFadeImageView RqY;
  private QDisFadeImageView RqZ;
  private ImageView Rra;
  private ImageView Rrb;
  private ImageView Rrc;
  private ImageView Rrd;
  private a Rre;
  private MMActivity iXq;
  private List<cvt> list;
  private String mTitle;
  private int wzX;
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(31906);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(31906);
  }
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31907);
    this.mTitle = "";
    this.RqW = null;
    this.RqX = null;
    this.RqY = null;
    this.RqZ = null;
    this.Rra = null;
    this.Rrb = null;
    this.Rrc = null;
    this.Rrd = null;
    this.wzX = 255;
    this.list = new LinkedList();
    this.Rre = new a();
    this.iXq = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(R.l.contact_info_sns_title);
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(31907);
  }
  
  public final void brA(final String paramString)
  {
    AppMethodBeat.i(31911);
    if (paramString == null)
    {
      AppMethodBeat.o(31911);
      return;
    }
    bh.beI();
    as localas = c.bbL().RG(paramString);
    if ((localas != null) && ((int)localas.jxt > 0) && (d.rk(localas.field_type))) {
      this.JRq = bp.VGl;
    }
    for (;;)
    {
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(267830);
          rw localrw = new rw();
          localrw.fRa.username = paramString;
          EventCenter.instance.publish(localrw);
          final LinkedList localLinkedList = new LinkedList();
          if (localrw.fRb.fRc != null) {
            localLinkedList.add(localrw.fRb.fRc);
          }
          if (localrw.fRb.fRd != null) {
            localLinkedList.add(localrw.fRb.fRd);
          }
          if (localrw.fRb.fRe != null) {
            localLinkedList.add(localrw.fRb.fRe);
          }
          if (localrw.fRb.fRf != null) {
            localLinkedList.add(localrw.fRb.fRf);
          }
          SnsPreference.b(SnsPreference.this).runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(278737);
              SnsPreference.a(SnsPreference.this).clear();
              SnsPreference.a(SnsPreference.this).addAll(localLinkedList);
              SnsPreference.this.jm(SnsPreference.a(SnsPreference.this));
              AppMethodBeat.o(278737);
            }
          });
          AppMethodBeat.o(267830);
        }
      });
      AppMethodBeat.o(31911);
      return;
      if (paramString.equals(z.bcZ())) {
        this.JRq = bp.VGl;
      } else {
        this.JRq = bp.VGm;
      }
    }
  }
  
  public final int hmS()
  {
    AppMethodBeat.i(31912);
    int i = 0;
    if (this.list != null) {
      i = this.list.size();
    }
    AppMethodBeat.o(31912);
    return i;
  }
  
  public final void jm(List<cvt> paramList)
  {
    int j = 0;
    AppMethodBeat.i(287536);
    if (this.RqW != null)
    {
      this.RqW.setImageResource(R.e.white);
      this.RqW.setVisibility(4);
    }
    if (this.RqX != null)
    {
      this.RqX.setImageResource(R.e.white);
      this.RqX.setVisibility(4);
    }
    if (this.RqY != null)
    {
      this.RqY.setImageResource(R.e.white);
      this.RqY.setVisibility(4);
    }
    if (this.RqZ != null)
    {
      this.RqZ.setImageResource(R.e.white);
      this.RqZ.setVisibility(4);
    }
    ImageView localImageView;
    if ((this.RqW != null) && (paramList.size() > 0))
    {
      this.RqW.setVisibility(0);
      if (e.avA()) {
        break label291;
      }
      this.RqW.setImageResource(R.g.dok);
      localImageView = this.Rra;
    }
    label291:
    label427:
    label566:
    label578:
    for (;;)
    {
      for (int i = 8;; i = 0)
      {
        localImageView.setVisibility(i);
        if ((this.RqX != null) && (paramList.size() >= 2))
        {
          this.RqX.setVisibility(0);
          if (e.avA()) {
            break;
          }
          this.RqX.setImageResource(R.g.dok);
        }
        if ((this.RqY != null) && (paramList.size() >= 3))
        {
          this.RqY.setVisibility(0);
          if (e.avA()) {
            break label427;
          }
          this.RqY.setImageResource(R.g.dok);
        }
        if ((this.RqZ == null) || (paramList.size() < 4)) {
          break label566;
        }
        this.RqZ.setVisibility(0);
        if (e.avA()) {
          break label501;
        }
        this.RqZ.setImageResource(R.g.dok);
        AppMethodBeat.o(287536);
        return;
        p.JPc.b((cvt)paramList.get(0), this.RqW, this.iXq.hashCode(), this.JRq);
        localImageView = this.Rra;
        if (((cvt)paramList.get(0)).rWu != 6) {
          break label578;
        }
      }
      p.JPc.b((cvt)paramList.get(1), this.RqX, this.iXq.hashCode(), this.JRq);
      localImageView = this.Rrb;
      if (((cvt)paramList.get(1)).rWu == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      p.JPc.b((cvt)paramList.get(2), this.RqY, this.iXq.hashCode(), this.JRq);
      localImageView = this.Rrc;
      if (((cvt)paramList.get(2)).rWu == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      label501:
      p.JPc.b((cvt)paramList.get(3), this.RqZ, this.iXq.hashCode(), this.JRq);
      localImageView = this.Rrd;
      if (((cvt)paramList.get(3)).rWu == 6) {}
      for (i = j;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(287536);
        return;
      }
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31910);
    super.onBindView(paramView);
    this.RqW = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv1));
    this.RqW.setAlpha(this.wzX);
    this.RqW.setImageDrawable(this.Rre);
    this.RqX = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv2));
    this.RqX.setAlpha(this.wzX);
    this.RqX.setImageDrawable(this.Rre);
    this.RqY = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv3));
    this.RqY.setAlpha(this.wzX);
    this.RqY.setImageDrawable(this.Rre);
    this.RqZ = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv4));
    this.RqZ.setAlpha(this.wzX);
    this.RqZ.setImageDrawable(this.Rre);
    TextView localTextView = (TextView)paramView.findViewById(R.h.album_title);
    if (!Util.isNullOrNil(this.mTitle))
    {
      localTextView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
      localLayoutParams.width = a.aY(this.mContext, R.f.FixedTitleWidth);
      localTextView.setLayoutParams(localLayoutParams);
    }
    this.Rra = ((ImageView)paramView.findViewById(R.h.dVw));
    this.Rrb = ((ImageView)paramView.findViewById(R.h.dVx));
    this.Rrc = ((ImageView)paramView.findViewById(R.h.dVy));
    this.Rrd = ((ImageView)paramView.findViewById(R.h.dVz));
    this.Rra.setVisibility(8);
    this.Rrb.setVisibility(8);
    this.Rrc.setVisibility(8);
    this.Rrd.setVisibility(8);
    jm(this.list);
    if ((paramView == null) || (this.list == null))
    {
      AppMethodBeat.o(31910);
      return;
    }
    paramView.setContentDescription(this.mContext.getString(R.l.profile_photo_desc, new Object[] { Integer.valueOf(this.list.size()) }));
    AppMethodBeat.o(31910);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31909);
    if (this.EQs == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(R.i.eiO, localViewGroup);
      this.EQs = paramViewGroup;
    }
    paramViewGroup = this.EQs;
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
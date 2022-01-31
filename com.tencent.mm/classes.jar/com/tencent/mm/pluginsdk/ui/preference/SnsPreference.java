package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.my;
import com.tencent.mm.h.a.my.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
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
  private MMActivity bER;
  private int jRP = 255;
  private List<awd> list = new LinkedList();
  private String mTitle = "";
  private az omX;
  private QDisFadeImageView sjb = null;
  private QDisFadeImageView sjc = null;
  private QDisFadeImageView sjd = null;
  private ImageView sje = null;
  private ImageView sjf = null;
  private ImageView sjg = null;
  private SnsPreference.a sjh = new SnsPreference.a();
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.bER = ((MMActivity)paramContext);
  }
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(R.l.contact_info_sns_title);
    setLayoutResource(R.i.mm_preference);
  }
  
  private void coa()
  {
    int j = 0;
    if (this.sjb != null)
    {
      this.sjb.setImageResource(R.e.white);
      this.sjb.setVisibility(4);
    }
    if (this.sjc != null)
    {
      this.sjc.setImageResource(R.e.white);
      this.sjc.setVisibility(4);
    }
    if (this.sjd != null)
    {
      this.sjd.setImageResource(R.e.white);
      this.sjd.setVisibility(4);
    }
    ImageView localImageView;
    if ((this.sjb != null) && (this.list.size() > 0))
    {
      this.sjb.setVisibility(0);
      if (com.tencent.mm.compatible.util.f.zF()) {
        break label222;
      }
      this.sjb.setImageResource(R.g.nosdcard_app);
      localImageView = this.sje;
    }
    label443:
    for (;;)
    {
      for (int i = 8;; i = 0)
      {
        localImageView.setVisibility(i);
        if ((this.sjc != null) && (this.list.size() >= 2))
        {
          this.sjc.setVisibility(0);
          if (com.tencent.mm.compatible.util.f.zF()) {
            break;
          }
          this.sjc.setImageResource(R.g.nosdcard_app);
        }
        if ((this.sjd != null) && (this.list.size() >= 3))
        {
          this.sjd.setVisibility(0);
          if (com.tencent.mm.compatible.util.f.zF()) {
            break label367;
          }
          this.sjd.setImageResource(R.g.nosdcard_app);
        }
        return;
        label222:
        n.omC.b((awd)this.list.get(0), this.sjb, this.bER.hashCode(), this.omX);
        localImageView = this.sje;
        if (((awd)this.list.get(0)).hQR != 6) {
          break label443;
        }
      }
      n.omC.b((awd)this.list.get(1), this.sjc, this.bER.hashCode(), this.omX);
      localImageView = this.sjf;
      if (((awd)this.list.get(1)).hQR == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      label367:
      n.omC.b((awd)this.list.get(2), this.sjd, this.bER.hashCode(), this.omX);
      localImageView = this.sjg;
      if (((awd)this.list.get(2)).hQR == 6) {}
      for (i = j;; i = 8)
      {
        localImageView.setVisibility(i);
        return;
      }
    }
  }
  
  public final void WP(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.list.clear();
    au.Hx();
    Object localObject = c.Fw().abl(paramString);
    if ((localObject != null) && ((int)((com.tencent.mm.n.a)localObject).dBe > 0) && (com.tencent.mm.n.a.gR(((ao)localObject).field_type))) {
      this.omX = az.uBG;
    }
    for (;;)
    {
      localObject = new my();
      ((my)localObject).bWA.username = paramString;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject);
      if (((my)localObject).bWB.bWC != null) {
        this.list.add(((my)localObject).bWB.bWC);
      }
      if (((my)localObject).bWB.bWD != null) {
        this.list.add(((my)localObject).bWB.bWD);
      }
      if (((my)localObject).bWB.bWE != null) {
        this.list.add(((my)localObject).bWB.bWE);
      }
      coa();
      return;
      if (paramString.equals(q.Gj())) {
        this.omX = az.uBG;
      } else {
        this.omX = az.uBH;
      }
    }
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.sjb = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv1));
    this.sjb.setAlpha(this.jRP);
    this.sjb.setImageDrawable(this.sjh);
    this.sjc = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv2));
    this.sjc.setAlpha(this.jRP);
    this.sjc.setImageDrawable(this.sjh);
    this.sjd = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv3));
    this.sjd.setAlpha(this.jRP);
    this.sjd.setImageDrawable(this.sjh);
    TextView localTextView = (TextView)paramView.findViewById(R.h.album_title);
    if (!bk.bl(this.mTitle))
    {
      localTextView.setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
      localLayoutParams.width = com.tencent.mm.cb.a.aa(this.mContext, R.f.FixedTitleWidth);
      localTextView.setLayoutParams(localLayoutParams);
    }
    this.sje = ((ImageView)paramView.findViewById(R.h.sns_sight_icon1));
    this.sjf = ((ImageView)paramView.findViewById(R.h.sns_sight_icon2));
    this.sjg = ((ImageView)paramView.findViewById(R.h.sns_sight_icon3));
    this.sje.setVisibility(8);
    this.sjf.setVisibility(8);
    this.sjg.setVisibility(8);
    coa();
    if ((paramView == null) || (this.list == null)) {
      return;
    }
    paramView.setContentDescription(this.mContext.getString(R.l.profile_photo_desc, new Object[] { Integer.valueOf(this.list.size()) }));
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.mm_preference_content_album, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SnsPreference
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.tl;
import com.tencent.mm.autogen.a.tl.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.g;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.threadpool.h;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference
  extends Preference
  implements g
{
  private View KKQ;
  private br Qob;
  private QDisFadeImageView Ynn;
  private QDisFadeImageView Yno;
  private QDisFadeImageView Ynp;
  private QDisFadeImageView Ynq;
  private ImageView Ynr;
  private ImageView Yns;
  private ImageView Ynt;
  private ImageView Ynu;
  private a Ynv;
  private List<dmz> list;
  private MMActivity lzt;
  private String mTitle;
  private int zWi;
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(31906);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(31906);
  }
  
  public SnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31907);
    this.mTitle = "";
    this.Ynn = null;
    this.Yno = null;
    this.Ynp = null;
    this.Ynq = null;
    this.Ynr = null;
    this.Yns = null;
    this.Ynt = null;
    this.Ynu = null;
    this.zWi = 255;
    this.list = new LinkedList();
    this.Ynv = new a();
    this.lzt = ((MMActivity)paramContext);
    this.mTitle = paramContext.getString(R.l.contact_info_sns_title);
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(31907);
  }
  
  public final void bro(final String paramString)
  {
    AppMethodBeat.i(31911);
    if (paramString == null)
    {
      AppMethodBeat.o(31911);
      return;
    }
    bh.bCz();
    au localau = c.bzA().JE(paramString);
    if ((localau != null) && ((int)localau.maN > 0) && (d.rs(localau.field_type))) {
      this.Qob = br.adjZ;
    }
    for (;;)
    {
      h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(245126);
          tl localtl = new tl();
          localtl.hWX.username = paramString;
          localtl.publish();
          final LinkedList localLinkedList = new LinkedList();
          if (localtl.hWY.hWZ != null) {
            localLinkedList.add(localtl.hWY.hWZ);
          }
          if (localtl.hWY.hXa != null) {
            localLinkedList.add(localtl.hWY.hXa);
          }
          if (localtl.hWY.hXb != null) {
            localLinkedList.add(localtl.hWY.hXb);
          }
          if (localtl.hWY.hXc != null) {
            localLinkedList.add(localtl.hWY.hXc);
          }
          SnsPreference.b(SnsPreference.this).runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(245109);
              SnsPreference.a(SnsPreference.this).clear();
              SnsPreference.a(SnsPreference.this).addAll(localLinkedList);
              SnsPreference.this.mx(SnsPreference.a(SnsPreference.this));
              AppMethodBeat.o(245109);
            }
          });
          AppMethodBeat.o(245126);
        }
      });
      AppMethodBeat.o(31911);
      return;
      if (paramString.equals(z.bAM())) {
        this.Qob = br.adjZ;
      } else {
        this.Qob = br.adka;
      }
    }
  }
  
  public final int iNI()
  {
    AppMethodBeat.i(31912);
    int i = 0;
    if (this.list != null) {
      i = this.list.size();
    }
    AppMethodBeat.o(31912);
    return i;
  }
  
  public final void mx(List<dmz> paramList)
  {
    int j = 0;
    AppMethodBeat.i(245123);
    if (this.Ynn != null)
    {
      this.Ynn.setImageResource(R.e.white);
      this.Ynn.setVisibility(4);
    }
    if (this.Yno != null)
    {
      this.Yno.setImageResource(R.e.white);
      this.Yno.setVisibility(4);
    }
    if (this.Ynp != null)
    {
      this.Ynp.setImageResource(R.e.white);
      this.Ynp.setVisibility(4);
    }
    if (this.Ynq != null)
    {
      this.Ynq.setImageResource(R.e.white);
      this.Ynq.setVisibility(4);
    }
    ImageView localImageView;
    if ((this.Ynn != null) && (paramList.size() > 0))
    {
      this.Ynn.setVisibility(0);
      if (e.aPU()) {
        break label291;
      }
      this.Ynn.setImageResource(R.g.foI);
      localImageView = this.Ynr;
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
        if ((this.Yno != null) && (paramList.size() >= 2))
        {
          this.Yno.setVisibility(0);
          if (e.aPU()) {
            break;
          }
          this.Yno.setImageResource(R.g.foI);
        }
        if ((this.Ynp != null) && (paramList.size() >= 3))
        {
          this.Ynp.setVisibility(0);
          if (e.aPU()) {
            break label427;
          }
          this.Ynp.setImageResource(R.g.foI);
        }
        if ((this.Ynq == null) || (paramList.size() < 4)) {
          break label566;
        }
        this.Ynq.setVisibility(0);
        if (e.aPU()) {
          break label501;
        }
        this.Ynq.setImageResource(R.g.foI);
        AppMethodBeat.o(245123);
        return;
        q.Qkh.b((dmz)paramList.get(0), this.Ynn, this.lzt.hashCode(), this.Qob);
        localImageView = this.Ynr;
        if (((dmz)paramList.get(0)).vhJ != 6) {
          break label578;
        }
      }
      q.Qkh.b((dmz)paramList.get(1), this.Yno, this.lzt.hashCode(), this.Qob);
      localImageView = this.Yns;
      if (((dmz)paramList.get(1)).vhJ == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      q.Qkh.b((dmz)paramList.get(2), this.Ynp, this.lzt.hashCode(), this.Qob);
      localImageView = this.Ynt;
      if (((dmz)paramList.get(2)).vhJ == 6) {}
      for (i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        break;
      }
      label501:
      q.Qkh.b((dmz)paramList.get(3), this.Ynq, this.lzt.hashCode(), this.Qob);
      localImageView = this.Ynu;
      if (((dmz)paramList.get(3)).vhJ == 6) {}
      for (i = j;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(245123);
        return;
      }
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31910);
    super.onBindView(paramView);
    this.Ynn = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv1));
    this.Ynn.setAlpha(this.zWi);
    this.Ynn.setImageDrawable(this.Ynv);
    this.Yno = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv2));
    this.Yno.setAlpha(this.zWi);
    this.Yno.setImageDrawable(this.Ynv);
    this.Ynp = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv3));
    this.Ynp.setAlpha(this.zWi);
    this.Ynp.setImageDrawable(this.Ynv);
    this.Ynq = ((QDisFadeImageView)paramView.findViewById(R.h.image_iv4));
    this.Ynq.setAlpha(this.zWi);
    this.Ynq.setImageDrawable(this.Ynv);
    Object localObject = (TextView)paramView.findViewById(R.h.album_title);
    if (!Util.isNullOrNil(this.mTitle))
    {
      ((TextView)localObject).setText(this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = ((TextView)localObject).getLayoutParams();
      localLayoutParams.width = a.br(this.mContext, R.f.FixedTitleWidth);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
    }
    this.Ynr = ((ImageView)paramView.findViewById(R.h.fXS));
    this.Yns = ((ImageView)paramView.findViewById(R.h.fXT));
    this.Ynt = ((ImageView)paramView.findViewById(R.h.fXU));
    this.Ynu = ((ImageView)paramView.findViewById(R.h.fXV));
    this.Ynr.setVisibility(8);
    this.Yns.setVisibility(8);
    this.Ynt.setVisibility(8);
    this.Ynu.setVisibility(8);
    mx(this.list);
    if ((paramView == null) || (this.list == null))
    {
      AppMethodBeat.o(31910);
      return;
    }
    localObject = this.mContext.getString(R.l.profile_photo_desc, new Object[] { Integer.valueOf(this.list.size()) });
    if (this.mTitle != null)
    {
      paramView.setContentDescription(this.mTitle + (String)localObject);
      AppMethodBeat.o(31910);
      return;
    }
    paramView.setContentDescription((CharSequence)localObject);
    AppMethodBeat.o(31910);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31909);
    if (this.KKQ == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(R.i.glN, localViewGroup);
      this.KKQ = paramViewGroup;
    }
    paramViewGroup = this.KKQ;
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
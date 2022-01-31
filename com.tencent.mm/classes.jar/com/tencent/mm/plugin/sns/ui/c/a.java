package com.tencent.mm.plugin.sns.ui.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.aa;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.au.b;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.vending.base.Vending;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class a
{
  public boolean DEBUG = false;
  protected int ivk;
  protected Activity mActivity;
  protected boolean oVB = false;
  protected com.tencent.mm.plugin.sns.ui.au owd;
  public ArrayList<ap.b> pmy = new ArrayList();
  
  private static void a(a.c paramc, n paramn)
  {
    if (paramn.yr(32))
    {
      if (paramc.pmF != null) {
        paramc.pmF.setVisibility(0);
      }
      paramc.pmH.setLongClickable(false);
      paramc.pmH.setOnClickListener(null);
      paramn = new LinearLayout.LayoutParams(-1, -2);
      paramc.pmH.setLayoutParams(paramn);
      paramc.pmH.setBackgroundColor(Color.parseColor("#00ffffff"));
      if (paramc.pmZ != null)
      {
        paramn = (LinearLayout.LayoutParams)paramc.pmZ.getLayoutParams();
        paramn.leftMargin = 0;
        paramn.rightMargin = 0;
        paramc.pmZ.setLayoutParams(paramn);
      }
      if (paramc.pnx)
      {
        paramn = (LinearLayout.LayoutParams)paramc.plQ.oTG.getLayoutParams();
        paramn.leftMargin = 0;
        paramn.rightMargin = 0;
        paramc.plQ.oTG.setLayoutParams(paramn);
      }
      return;
    }
    if (paramc.pmF != null) {
      paramc.pmF.setVisibility(0);
    }
    paramc.pmH.setLongClickable(false);
    paramc.pmH.setOnClickListener(null);
    if (paramc.pmZ != null)
    {
      paramn = (LinearLayout.LayoutParams)paramc.pmZ.getLayoutParams();
      paramn.leftMargin = 0;
      paramn.rightMargin = 0;
      paramc.pmZ.setLayoutParams(paramn);
    }
    if (paramc.pnx)
    {
      paramn = (LinearLayout.LayoutParams)paramc.plQ.oTG.getLayoutParams();
      paramn.leftMargin = 0;
      paramn.rightMargin = 0;
      paramc.plQ.oTG.setLayoutParams(paramn);
    }
    paramn = new LinearLayout.LayoutParams(-1, -2);
    paramc.pmH.setLayoutParams(paramn);
    paramc.pmH.setBackgroundColor(Color.parseColor("#00ffffff"));
  }
  
  private boolean a(MaskTextView paramMaskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(" ");
    int k = localSpannableStringBuilder.length() - 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int[] arrayOfInt1 = new int[paramb.size()];
    int[] arrayOfInt2 = new int[paramb.size()];
    int j = 1;
    int i = 0;
    Object localObject;
    try
    {
      if (i < paramb.size())
      {
        localObject = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(1);
        if (j != 0)
        {
          localSpannableStringBuilder.append(" ");
          localStringBuffer.append(" ");
          j = 0;
        }
        for (;;)
        {
          arrayOfInt1[i] = localSpannableStringBuilder.length();
          arrayOfInt1[i] += ((String)localObject).length();
          localStringBuffer.append((String)localObject);
          localSpannableStringBuilder.append(j.a(this.mActivity, (CharSequence)localObject, paramMaskTextView.getTextSize()));
          i += 1;
          break;
          localSpannableStringBuilder.append(", ");
          localStringBuffer.append(", ");
        }
        return true;
      }
    }
    catch (Exception paramMaskTextView)
    {
      y.e("MicroMsg.BaseTimeLineItem", "setLikedList  e:%s", new Object[] { bk.j(paramMaskTextView) });
    }
    for (;;)
    {
      localObject = this.mActivity.getResources();
      if (paramInt == 10) {}
      for (i = i.e.golden_like_icon;; i = i.e.normal_like_icon)
      {
        localObject = ((Resources)localObject).getDrawable(i);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject);
        locala.wjc = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
        localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
        if (paramInt != 10) {
          break label416;
        }
        paramInt = 3;
        break label410;
        while (i < arrayOfInt1.length)
        {
          localSpannableStringBuilder.setSpan(new o((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), this.owd.oWm, paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
          i += 1;
        }
      }
      paramMaskTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
      paramMaskTextView.setOriginText(localStringBuffer.toString());
    }
    for (;;)
    {
      label410:
      i = 0;
      break;
      label416:
      paramInt = 2;
    }
  }
  
  private boolean a(List<btd> paramList, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, a.c paramc)
  {
    LinearLayout localLinearLayout = paramc.pmV;
    int n = localLinearLayout.getChildCount();
    int j = paramb.size();
    int i;
    if (n > j)
    {
      i = j;
      while (i < n)
      {
        localObject1 = localLinearLayout.getChildAt(j);
        localLinearLayout.removeViewAt(j);
        if ((localObject1 instanceof SnsCommentPreloadTextView)) {
          this.owd.a((SnsCommentPreloadTextView)localObject1);
        }
        i += 1;
      }
    }
    if (paramb.size() == 0)
    {
      localLinearLayout.setVisibility(8);
      return false;
    }
    localLinearLayout.setVisibility(0);
    Object localObject1 = this.owd.bJv();
    if ((localObject1 instanceof aw)) {}
    for (ax localax = (ax)((aw)localObject1).pgx.get(paramc.position);; localax = null)
    {
      if (this.DEBUG) {
        y.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + paramc.position + " commentCount: " + j);
      }
      int k = 0;
      j = 0;
      Object localObject3;
      ap.b localb;
      label420:
      int m;
      Object localObject2;
      TranslateCommentTextView localTranslateCommentTextView;
      label635:
      String str4;
      String str5;
      if (j < paramb.size())
      {
        localObject1 = (com.tencent.mm.vending.j.a)paramb.get(j);
        long l = ((Long)((com.tencent.mm.vending.j.a)localObject1).get(0)).longValue();
        String str1 = (String)((com.tencent.mm.vending.j.a)localObject1).get(1);
        String str2 = (String)((com.tencent.mm.vending.j.a)localObject1).get(2);
        String str3 = (String)((com.tencent.mm.vending.j.a)localObject1).get(3);
        localObject3 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(4);
        btd localbtd = (btd)paramList.get(j);
        localb = am(paramc.bRV, l);
        if ((localb != null) && (localb.ebE)) {
          ap.cq(localb.id, 2);
        }
        if (k >= n) {
          if ((localb == null) || (localb.ebE))
          {
            localObject1 = this.owd.bJr();
            ((SnsCommentPreloadTextView)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.cJ(((View)localObject1).getContext()));
            if (this.owd.peg == -1) {
              this.owd.peg = this.mActivity.getResources().getColor(i.c.sns_comment_color);
            }
            ((SnsCommentPreloadTextView)localObject1).setTextColor(this.owd.peg);
            ((SnsCommentPreloadTextView)localObject1).setGravity(16);
            m = 1;
            localObject2 = localObject1;
          }
        }
        for (;;)
        {
          if (localb != null)
          {
            localObject1 = localObject2;
            if (!(localObject2 instanceof TranslateCommentTextView))
            {
              localLinearLayout.removeView((View)localObject2);
              localObject1 = new TranslateCommentTextView(this.mActivity);
              localLinearLayout.addView((View)localObject1, k);
              ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cb.a.cJ(((View)localObject1).getContext()));
              ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cb.a.cJ(((View)localObject1).getContext()));
            }
            localTranslateCommentTextView = (TranslateCommentTextView)localObject1;
            ((View)localObject1).setOnTouchListener(null);
            b(localTranslateCommentTextView.getOriginCommentTextView(), (CharSequence)localObject3);
            if (!localb.dYj)
            {
              localTranslateCommentTextView.pkz.setTextSize(1, 15.0F * com.tencent.mm.cb.a.cJ(localTranslateCommentTextView.getContext()));
              localTranslateCommentTextView.oXv.yV(2);
              localTranslateCommentTextView.oXv.setVisibility(0);
              i = 1;
              ((View)localObject1).setBackgroundResource(i.e.sns_timeline_comment_bg);
              if (k <= 0) {
                break label1230;
              }
              if (i == 0) {
                break label1204;
              }
              ((View)localObject1).setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2), 0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 7));
              if (i != 0)
              {
                localObject2 = (TranslateCommentTextView)localObject1;
                i = (int)this.mActivity.getResources().getDimension(i.d.SmallPadding);
                ((TranslateCommentTextView)localObject2).oXv.getSplitlineView().setPadding(0, 0, i, 0);
              }
              ((View)localObject1).setOnLongClickListener(new a.3(this, (View)localObject1));
              ((View)localObject1).setOnClickListener(new com.tencent.mm.plugin.sns.ui.i.a(this.owd.pec, localbtd, str2, str3, paramc));
              if (localax != null) {
                ((View)localObject1).setTag(new l(localax.pgO, localbtd, str1, str3, (View)localObject1, 1));
              }
              if (m != 0) {
                localLinearLayout.addView((View)localObject1);
              }
              k += 1;
              j += 1;
              break;
              localObject1 = new TranslateCommentTextView(this.mActivity);
              ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cb.a.cJ(((View)localObject1).getContext()));
              ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cb.a.cJ(((View)localObject1).getContext()));
              break label420;
              localObject2 = localLinearLayout.getChildAt(k);
              m = 0;
              continue;
            }
            if (!localb.ebE)
            {
              str4 = localb.result;
              str5 = localb.egI;
              String str6 = localTranslateCommentTextView.pkz.getText().toString();
              if (!bk.bl(str6))
              {
                localObject2 = str6.split(":");
                if (localObject2.length <= 2) {
                  break label1283;
                }
                localObject3 = new String[2];
                localObject3[0] = localObject2[0];
                localObject3[1] = str6.substring(localObject3[0].length() + 1);
                localObject2 = localObject3;
              }
            }
          }
        }
      }
      label1283:
      for (;;)
      {
        if (localObject2.length == 2)
        {
          if (bk.bl(str4)) {
            break label1051;
          }
          localTranslateCommentTextView.oXv.a(localb, 2, localObject2[0] + ": " + str4, str5, localb.otH);
        }
        for (;;)
        {
          localTranslateCommentTextView.oXv.setVisibility(0);
          localTranslateCommentTextView.pkz.setTextSize(1, 15.0F * com.tencent.mm.cb.a.cJ(localTranslateCommentTextView.getContext()));
          i = 1;
          break;
          label1051:
          localTranslateCommentTextView.oXv.a(localb, 2, null, str5, localb.otH);
        }
        localTranslateCommentTextView.getTranslateResultView().setVisibility(8);
        i = 1;
        break;
        if ((m == 0) && ((localObject2 instanceof TranslateCommentTextView)))
        {
          localLinearLayout.removeView((View)localObject2);
          localObject1 = this.owd.bJr();
          localLinearLayout.addView((View)localObject1, k);
          ((SnsCommentPreloadTextView)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.cJ(((View)localObject1).getContext()));
        }
        for (;;)
        {
          if ((localObject1 instanceof SnsCommentPreloadTextView)) {
            ((SnsCommentPreloadTextView)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.cJ(((View)localObject1).getContext()));
          }
          ((View)localObject1).setOnTouchListener(new m(this.mActivity));
          b((View)localObject1, (CharSequence)localObject3);
          i = 0;
          break;
          label1204:
          ((View)localObject1).setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2), 0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 3));
          break label635;
          label1230:
          if (i != 0)
          {
            ((View)localObject1).setPadding(0, 1, 0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 7));
            break label635;
          }
          ((View)localObject1).setPadding(0, 1, 0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 3));
          break label635;
          return true;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  private ap.b am(String paramString, long paramLong)
  {
    if (this.pmy.size() <= 0) {
      return null;
    }
    Iterator localIterator = this.pmy.iterator();
    while (localIterator.hasNext())
    {
      ap.b localb = (ap.b)localIterator.next();
      if ((localb.id != null) && (localb.id.equals(ap.eK(paramString, String.valueOf(paramLong))))) {
        return localb;
      }
    }
    return null;
  }
  
  private static void b(View paramView, CharSequence paramCharSequence)
  {
    if ((paramView instanceof SnsCommentPreloadTextView)) {
      ((SnsCommentPreloadTextView)paramView).setText(paramCharSequence);
    }
    while (!(paramView instanceof TextView)) {
      return;
    }
    ((TextView)paramView).setText(paramCharSequence);
  }
  
  private void b(MaskTextView paramMaskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, int paramInt)
  {
    if (paramb.size() == 0)
    {
      paramMaskTextView.setVisibility(8);
      return;
    }
    paramMaskTextView.setVisibility(0);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(" ");
    int k = localSpannableStringBuilder.length() - 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int[] arrayOfInt1 = new int[paramb.size()];
    int[] arrayOfInt2 = new int[paramb.size()];
    int j = 1;
    int i = 0;
    Object localObject;
    try
    {
      if (i < paramb.size())
      {
        localObject = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(1);
        if (j != 0)
        {
          localSpannableStringBuilder.append(" ");
          localStringBuffer.append(" ");
          j = 0;
        }
        for (;;)
        {
          arrayOfInt1[i] = localSpannableStringBuilder.length();
          arrayOfInt1[i] += ((String)localObject).length();
          localStringBuffer.append((String)localObject);
          localSpannableStringBuilder.append(j.a(this.mActivity, (CharSequence)localObject, paramMaskTextView.getTextSize()));
          i += 1;
          break;
          localSpannableStringBuilder.append(", ");
          localStringBuffer.append(", ");
        }
      }
      localObject = this.mActivity.getResources().getDrawable(i.i.friendactivity_luckymoney_icon);
    }
    catch (Exception paramMaskTextView)
    {
      y.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[] { bk.j(paramMaskTextView) });
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject);
    locala.wjc = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
    localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
    if (paramInt == 10)
    {
      paramInt = 3;
      break label405;
      while (i < arrayOfInt1.length)
      {
        localSpannableStringBuilder.setSpan(new o((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), this.owd.oWm, paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
        i += 1;
      }
      paramMaskTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
      paramMaskTextView.setOriginText(localStringBuffer.toString());
      return;
    }
    for (;;)
    {
      label405:
      i = 0;
      break;
      paramInt = 2;
    }
  }
  
  public static void e(a.c paramc)
  {
    if ((paramc != null) && (paramc.pmG != null)) {
      paramc.pmG.setVisibility(8);
    }
  }
  
  public final View a(Activity paramActivity, a.c paramc, int paramInt, com.tencent.mm.plugin.sns.ui.au paramau, n paramn)
  {
    this.mActivity = paramActivity;
    this.ivk = paramInt;
    this.owd = paramau;
    paramc.bRV = paramn.bGk();
    Object localObject;
    View localView;
    switch (paramInt)
    {
    default: 
      localObject = "R.layout.sns_media_sub_item2";
      localView = com.tencent.mm.kiss.a.b.ED().a(this.mActivity, (String)localObject, i.g.sns_timeline_item_photo_one3);
      paramc.pnG = ((String)localObject);
      localObject = localView.findViewById(i.f.images_keeper_li);
      if (!(localObject instanceof ViewStub)) {
        break;
      }
    }
    for (paramc.pmI = ((ViewStub)localObject);; paramc.pmI = null)
    {
      y.i("MicroMsg.BaseTimeLineItem", "create new item  " + paramInt + "  " + localView.hashCode());
      paramc.pnz = localView.findViewById(i.f.sns_timeline_content);
      paramc.ivk = paramInt;
      paramc.doU = ((MaskImageButton)localView.findViewById(i.f.album_avatar_iv));
      paramc.doU.setOnClickListener(paramau.ovx.poA);
      paramc.doU.setOnLongClickListener(paramau.ovx.poB);
      paramc.doU.setOnTouchListener(new a.1(this));
      paramc.pmC = ((AsyncTextView)localView.findViewById(i.f.nickname_tv));
      paramc.pmD = ((ImageView)localView.findViewById(i.f.type_desc_tv));
      paramc.pmC.setOnTouchListener(new aa());
      paramc.pmE = ((ViewGroup)localView.findViewById(i.f.nick_type_ll));
      paramc.pmF = ((AsyncNormalTextView)localView.findViewById(i.f.desc_collapse_tv));
      paramc.pmF.setOpClickListener(paramau.pem);
      paramc.pmH = ((LinearLayout)localView.findViewById(i.f.images_keeper_lieaner_layout));
      paramc.pmH.setTag(paramc);
      paramc.pmH.setOnClickListener(paramau.ovx.ppf);
      localObject = localView.findViewById(i.f.desc_tv);
      paramau.iep.c((View)localObject, paramau.ovx.poC, paramau.ovx.poz);
      localObject = (TextView)localView.findViewById(i.f.desc_tv_single);
      paramau.iep.c((View)localObject, paramau.ovx.poC, paramau.ovx.poz);
      paramc.pmG = ((SnsTranslateResultView)localView.findViewById(i.f.sns_translate_result_view));
      paramc.pmG.setVisibility(8);
      paramc.pmG.getSplitlineView().setPadding(0, 0, (int)this.mActivity.getResources().getDimension(i.d.SmallPadding), 0);
      paramc.pmG.getResultTextView().setBackgroundResource(i.e.sns_clickable_bg);
      paramau.iep.c(paramc.pmG.getResultTextView(), paramau.ovx.poC, paramau.ovx.poz);
      paramc.pmY = ((LinearLayout)localView.findViewById(i.f.comment_ll));
      paramc.pmO = ((TextView)localView.findViewById(i.f.with_info_tv));
      paramc.igx = ((TextView)localView.findViewById(i.f.album_publish_time));
      paramc.pmP = ((AsyncTextView)localView.findViewById(i.f.album_ad_tail_desc));
      paramc.pmQ = ((AsyncTextView)localView.findViewById(i.f.album_ad_at_tail));
      paramc.pcd = ((TextView)localView.findViewById(i.f.album_address));
      paramc.omM = new be(localView);
      paramc.omM.a(paramau.ovx.poK, paramau.ovx.poY);
      paramc.oPv = ((TextView)localView.findViewById(i.f.album_del));
      paramc.oPv.setText(paramActivity.getString(i.j.app_delete));
      paramc.oPv.setOnClickListener(paramau.ovx.poE);
      paramc.pmP.setOnClickListener(paramau.ovx.poZ);
      paramc.pmQ.setOnClickListener(paramau.ovx.ppa);
      paramc.pcd.setOnClickListener(paramau.ovx.poV);
      paramc.pmR = localView.findViewById(i.f.album_groupid);
      paramc.pmR.setOnClickListener(paramau.ovx.poJ);
      paramc.iSH = ((TextView)localView.findViewById(i.f.album_from));
      paramc.pmS = ((ImageView)localView.findViewById(i.f.album_show_comment_tv));
      paramc.pnb = ((ViewStub)localView.findViewById(i.f.album_comment_stub));
      paramc.oMK = ((LinearLayout)localView.findViewById(i.f.album_list_fatherview));
      paramc.pnB = ((ViewStub)localView.findViewById(i.f.album_hb_reward));
      paramc.pnd = ((ViewStub)localView.findViewById(i.f.sns_post_error_stub));
      paramc.pmK = ((TextView)localView.findViewById(i.f.game_more_tv));
      paramc.pmK.setOnClickListener(paramau.ovx.poF);
      paramc.pnF = ((TextView)localView.findViewById(i.f.hb_tip));
      paramc.kKz = localView;
      if (this.oVB)
      {
        com.tencent.mm.plugin.sns.abtest.c.b(localView, paramc);
        com.tencent.mm.plugin.sns.abtest.a.a(localView, paramc);
        af.bDw();
        com.tencent.mm.plugin.sns.f.c.c(localView, paramc);
      }
      d(paramc);
      localView.setTag(paramc);
      a(paramc, paramn);
      return localView;
      localObject = "R.layout.sns_timeline_item_photo_one3";
      break;
      localObject = "R.layout.sns_timeline_imagesline_one";
      break;
      localObject = "R.layout.sns_timeline_imagesline1";
      break;
      localObject = "R.layout.sns_timeline_imagesline2";
      break;
      localObject = "R.layout.sns_timeline_imagesline3";
      break;
      localObject = "R.layout.sns_media_sub_item2";
      break;
      localObject = "R.layout.sns_media_sub_item2";
      break;
      localObject = "R.layout.sns_media_sub_item2";
      break;
      localObject = "R.layout.sns_media_sub_item2";
      break;
      localObject = "R.layout.sns_media_sight_item";
      break;
      localObject = "R.layout.sns_ad_card_layout_item";
      break;
      localObject = "R.layout.sns_hb_reward_item";
      break;
      localObject = "R.layout.sns_timeline_turn_media";
      break;
      localObject = "R.layout.sns_media_collapse_item";
      break;
      localObject = "R.layout.sns_timeline_ad_full_card";
      break;
    }
  }
  
  public final void a(a.c paramc, int paramInt, n paramn)
  {
    paramn = paramn.bGe();
    a(paramc, paramInt, (ax)this.owd.bJv().bHy().get(Integer.valueOf(paramInt)), paramn, paramc.ivk, this.owd);
  }
  
  public final void a(a.c paramc, int paramInt1, n paramn, bxk parambxk, int paramInt2, com.tencent.mm.plugin.sns.ui.au paramau)
  {
    Object localObject3 = (ax)paramau.bJv().bHy().get(Integer.valueOf(paramInt1));
    a(paramc, paramn);
    this.ivk = paramInt2;
    this.owd = paramau;
    if (this.oVB) {
      aw.F(paramn);
    }
    if (paramn.yr(32)) {
      y.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + com.tencent.mm.plugin.sns.data.i.fO(paramn.field_snsId) + " for susan");
    }
    paramc.pmA = ((ax)localObject3).pgP;
    paramc.kOp = false;
    paramc.position = paramInt1;
    paramc.bRV = ((ax)localObject3).pgO;
    paramc.bJQ = ((ax)localObject3).oOM;
    paramc.pmB = ((ax)localObject3).pgT;
    paramc.pmS.setOnClickListener(paramau.pel);
    paramc.plP = parambxk;
    bto localbto = ((ax)localObject3).ojd;
    paramc.okd = localbto;
    Object localObject1 = paramau.pec.oNC.ota;
    Object localObject2;
    if (paramn != null)
    {
      localObject2 = paramn.bGE();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).ozm.add(localObject2);
      if (paramn.yr(32)) {
        ((com.tencent.mm.plugin.sns.h.b)localObject1).ozr.add(localObject2);
      }
      ((com.tencent.mm.plugin.sns.h.b)localObject1).ozs.add(paramn.field_userName);
    }
    switch (paramn.field_type)
    {
    default: 
      ((com.tencent.mm.plugin.sns.h.b)localObject1).ozx.add(localObject2);
      if (paramInt1 < ((com.tencent.mm.plugin.sns.h.b)localObject1).ozk)
      {
        ((com.tencent.mm.plugin.sns.h.b)localObject1).ozk = paramInt1;
        ((com.tencent.mm.plugin.sns.h.b)localObject1).oxQ = com.tencent.mm.plugin.sns.data.i.j(paramn);
      }
      if (paramInt1 > ((com.tencent.mm.plugin.sns.h.b)localObject1).ozl)
      {
        ((com.tencent.mm.plugin.sns.h.b)localObject1).ozl = paramInt1;
        ((com.tencent.mm.plugin.sns.h.b)localObject1).oxR = com.tencent.mm.plugin.sns.data.i.j(paramn);
      }
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oxW = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozn.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oxX = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozo.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oxY = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozp.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oya = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozq.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oxZ = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozr.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oyb = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozv.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oyj = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozw.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).idv = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozs.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oxU = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozt.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oxV = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozu.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oyi = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozx.size();
      ((com.tencent.mm.plugin.sns.h.b)localObject1).oxE = ((com.tencent.mm.plugin.sns.h.b)localObject1).ozm.size();
      localObject1 = paramn.bFZ();
      localObject2 = ((ax)localObject3).hcm;
      if (!bk.bl((String)localObject2))
      {
        paramc.pny = ((ax)localObject3).pgN;
        paramc.doU.setTag(localObject2);
        if ((localObject1 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject1).oBA)) {
          break label2525;
        }
        if (!bk.bl(((com.tencent.mm.plugin.sns.storage.b)localObject1).oBC))
        {
          paramc.doU.setTag(i.f.sns_prefer_avatar_url, ((com.tencent.mm.plugin.sns.storage.b)localObject1).oBC);
          h.a(((com.tencent.mm.plugin.sns.storage.b)localObject1).oBC, new a.2(this, paramc));
          label618:
          paramc.pmC.a((String)localObject2, ((ax)localObject3).phd, paramau.oWm, ((ax)localObject3).oNn, ((ax)localObject3).oOM, paramInt2, ((ax)localObject3).oNn);
          ((MaskImageButton)paramc.doU).wdF = ((ax)localObject3).oOM;
        }
      }
      else
      {
        paramc.pmD.setVisibility(8);
        if (!((ax)localObject3).oNn) {
          break label2677;
        }
        paramc.omL = true;
        paramc.kOp = ((ax)localObject3).pgU;
        label700:
        localObject1 = paramc.pmF;
        localObject2 = ((ax)localObject3).pgQ;
        ((AsyncNormalTextView)localObject1).oNk = ((ax)localObject3).pgR;
        ((AsyncNormalTextView)localObject1).content = ((String)localObject2);
        ((AsyncNormalTextView)localObject1).owd = paramau;
        ((AsyncNormalTextView)localObject1).oNl = ((ax)localObject3);
        if (bk.bl((String)localObject2)) {
          ((AsyncNormalTextView)localObject1).setVisibility(8);
        }
        paramc.pmF.setShow(paramc);
        paramc.iSH.setOnTouchListener(new aa());
        a(paramc, paramInt1, (ax)localObject3, parambxk, paramInt2, paramau);
        paramau.pee.put(Integer.valueOf(paramInt1), new WeakReference(paramc.kKz));
        if (paramc.kKz.getBackground() == null)
        {
          paramc.kKz.setBackgroundResource(i.e.comm_list_item_selector);
          paramInt1 = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
          int i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8);
          paramc.kKz.setPadding(paramInt1, paramInt1, paramInt1, i);
        }
        paramc.igx.setText(((ax)localObject3).pgW);
        paramc.pmP.setVisibility(8);
        paramc.pmQ.setVisibility(8);
        if (((ax)localObject3).oNn)
        {
          localObject2 = ((ax)localObject3).pgX;
          paramc.pmP.setTag(((ax)localObject3).oOM);
          if (((ax)localObject3).pgX.oAf != com.tencent.mm.plugin.sns.storage.a.ozR) {
            break label2697;
          }
          if (bk.bl(((ax)localObject3).pha)) {
            break label2685;
          }
          paramc.pmP.setText(((ax)localObject3).pha);
          paramc.pmP.setVisibility(0);
          label974:
          if ((paramc.pmP.getVisibility() != 8) && (bk.bl(((com.tencent.mm.plugin.sns.storage.a)localObject2).oAh)))
          {
            paramc.pmP.setTextColor(this.mActivity.getResources().getColor(i.c.sns_word_color));
            paramc.pmP.setOnClickListener(null);
          }
          if ((paramn.bGe().tNr.sPK & 0x4) == 0) {
            break label3008;
          }
          paramc.pmQ.setTag(paramc);
          paramc.pmQ.setVisibility(0);
          paramc.pmQ.setText(String.format("%s%s%s", new Object[] { this.mActivity.getResources().getString(i.j.sns_ad_at_tips1), ((ax)localObject3).phd, this.mActivity.getResources().getString(i.j.sns_ad_at_tips2) }));
        }
        label1113:
        if (!((ax)localObject3).phg) {
          break label3020;
        }
        localObject1 = paramau.bER.getString(i.j.lucky_sns_reward_numbers, new Object[] { Integer.valueOf(((ax)localObject3).phh) });
        paramc.pnF.setText((CharSequence)localObject1);
        paramc.pnF.setVisibility(0);
        label1166:
        paramc.pcd.setTag(((ax)localObject3).oOM);
        if (bk.bl(((ax)localObject3).phj)) {
          break label3039;
        }
        paramc.pcd.setVisibility(0);
        paramc.pcd.setText(((ax)localObject3).phj);
        paramc.pcd.setClickable(((ax)localObject3).phk);
        localObject1 = paramc.pcd;
        if (!((ax)localObject3).phk) {
          break label3032;
        }
        paramInt1 = -11048043;
        label1239:
        ((TextView)localObject1).setTextColor(paramInt1);
        label1245:
        paramc.iSH.setTextColor(this.mActivity.getResources().getColor(i.c.sns_link_color));
        if (!((ax)localObject3).phl) {
          break label3051;
        }
        paramc.iSH.setVisibility(0);
        localObject2 = this.mActivity.getString(i.j.sns_comefrome) + ((ax)localObject3).mAppName;
        localObject1 = localObject2;
        if (((String)localObject2).length() > 10) {
          localObject1 = ((String)localObject2).substring(0, 10) + "...";
        }
        localObject1 = new SpannableString((CharSequence)localObject1);
        ((SpannableString)localObject1).setSpan(new a.b(this), 0, ((SpannableString)localObject1).length(), 33);
        paramc.iSH.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((!((ax)localObject3).phn) && (!"wx7fa037cc7dfabad5".equals(parambxk.tNq.lsK)))
        {
          paramc.iSH.setTextColor(this.mActivity.getResources().getColor(i.c.sns_word_color));
          paramc.iSH.setOnTouchListener(null);
        }
        paramc.iSH.setTag(parambxk);
        label1463:
        if (!((ax)localObject3).phf) {
          break label3352;
        }
        paramc.oPv.setVisibility(0);
        paramc.oPv.setTag(((ax)localObject3).oOM);
        label1491:
        paramc.pmS.setTag(paramc);
        if (!((ax)localObject3).phr) {
          break label3451;
        }
        if (!paramc.pnh)
        {
          paramc.pmW = ((LinearLayout)paramc.pnd.inflate());
          paramc.pmX = paramc.kKz.findViewById(i.f.post_again_click_id);
          paramc.pnh = true;
          paramc.pmX.setTag(((ax)localObject3).oOM);
          paramc.oGU = ((TextView)paramc.pmW.findViewById(i.f.post_again_click_id));
        }
        paramc.pnd.setVisibility(0);
        paramc.pmX.setOnClickListener(paramau.ovx.poI);
        switch (((ax)localObject3).phs)
        {
        default: 
          paramc.oGU.setText(i.j.sns_post_error_touch_again);
          paramc.pmX.setClickable(true);
          paramc.pmX.setEnabled(true);
          label1666:
          parambxk = paramn.bGw();
          if ((parambxk != null) && (!bk.bl(parambxk.tsC))) {
            paramc.oGU.setText(parambxk.tsC);
          }
          label1700:
          if (((ax)localObject3).pht)
          {
            paramc.pmR.setVisibility(0);
            paramc.pmR.setTag(((ax)localObject3).oOM);
            label1728:
            if (!((ax)localObject3).phu) {
              break label3573;
            }
            if (bk.bl(((ax)localObject3).phv)) {
              break label3512;
            }
            paramc.pmO.setVisibility(0);
            if (paramInt2 != 7) {
              break label3482;
            }
            parambxk = String.format(this.mActivity.getString(i.j.sns_timeline_ui_tv_with_to), new Object[] { ((ax)localObject3).phv });
            label1789:
            parambxk = j.a(this.mActivity, parambxk, paramc.pmO.getTextSize());
            paramc.pmO.setText(parambxk);
            if (!((ax)localObject3).phx) {
              break label3585;
            }
            if (paramc.pnC == null)
            {
              paramc.pnC = paramc.pnB.inflate();
              paramc.ook = ((TextView)paramc.pnC.findViewById(i.f.album_hb_reward_tip));
              paramc.pnD = ((MaskTextView)paramc.pnC.findViewById(i.f.album_hb_reward_users));
              paramc.pnD.setOnTouchListener(new aa());
            }
            paramc.pnC.setVisibility(0);
            b(paramc.pnD, ((ax)localObject3).phA, paramInt2);
            parambxk = this.mActivity.getString(i.j.sns_lucky_reward_tip_info, new Object[] { Integer.valueOf(((ax)localObject3).phy), bk.A(((ax)localObject3).phz / 100.0D) });
            paramc.ook.setText(parambxk);
            paramc.pnC.setTag(paramn);
            paramc.pnC.setOnClickListener(paramau.ovx.poL);
            label1987:
            if (((((ax)localObject3).phB != null) && (((ax)localObject3).phB.size() != 0)) || ((((ax)localObject3).phC != null) && (((ax)localObject3).phC.size() != 0))) {
              break label3623;
            }
            if (paramc.oMK == null) {
              break label3604;
            }
            paramc.oMK.setVisibility(8);
            label2041:
            if (!((ax)localObject3).phD) {
              break label3916;
            }
            paramc.pmK.setTag(((ax)localObject3).oOM);
            paramc.pmK.setText(((ax)localObject3).phE);
            paramc.pmK.setVisibility(0);
            if (!((ax)localObject3).oNn) {
              break label3933;
            }
            y.i("MicroMsg.BaseTimeLineItem", "adatag " + ((ax)localObject3).pgZ);
            paramc.omM.m(Long.valueOf(((ax)localObject3).pgP), new com.tencent.mm.plugin.sns.data.b(paramc.omM, paramc.position, ((ax)localObject3).oOM, ((ax)localObject3).pgP, ((ax)localObject3).pgV));
            paramc.omM.a(((ax)localObject3).pgY, ((ax)localObject3).pgX);
            paramc.omM.setVisibility(0);
            if ((paramc.pcd != null) && (paramc.pcd.getVisibility() == 0))
            {
              if (paramc.omM.pjJ.getVisibility() != 0) {
                break label3928;
              }
              paramInt1 = 1;
              label2217:
              if (paramInt1 != 0)
              {
                paramn = (LinearLayout.LayoutParams)paramc.pcd.getLayoutParams();
                paramn.setMargins(paramn.leftMargin, BackwardSupportUtil.b.b(this.mActivity, 0.0F), paramn.rightMargin, paramn.bottomMargin);
                paramc.pcd.setLayoutParams(paramn);
              }
            }
          }
          label1816:
          label2081:
          break;
        }
      }
      break;
    }
    boolean bool;
    for (;;)
    {
      if (this.oVB) {
        af.bDw().a(this.mActivity, localbto, paramc);
      }
      paramn = new ar(((ax)localObject3).pgO, ((ax)localObject3).oOM, false, true, 1);
      paramc.pmG.getResultTextView().setTag(paramn);
      paramn = com.tencent.mm.ui.a.a.a.cAj();
      parambxk = paramc.kKz;
      paramau = paramc.pmC;
      localObject3 = paramc.igx;
      localObject1 = paramc.pmF.getContent();
      localObject2 = paramc.pmM;
      bool = paramc.pnx;
      if ((paramn.cAi()) && (paramn.ze != null) && (parambxk != null) && (paramau != null) && (localObject3 != null)) {
        break label3945;
      }
      return;
      ((com.tencent.mm.plugin.sns.h.b)localObject1).ozo.add(localObject2);
      break;
      ((com.tencent.mm.plugin.sns.h.b)localObject1).ozn.add(localObject2);
      break;
      ((com.tencent.mm.plugin.sns.h.b)localObject1).ozq.add(localObject2);
      break;
      ((com.tencent.mm.plugin.sns.h.b)localObject1).ozp.add(localObject2);
      break;
      ((com.tencent.mm.plugin.sns.h.b)localObject1).ozv.add(localObject2);
      break;
      ((com.tencent.mm.plugin.sns.h.b)localObject1).ozw.add(localObject2);
      break;
      if (!bk.bl(parambxk.tNs))
      {
        ((com.tencent.mm.plugin.sns.h.b)localObject1).ozt.add(localObject2);
        break;
      }
      ((com.tencent.mm.plugin.sns.h.b)localObject1).ozu.add(localObject2);
      break;
      paramc.doU.setImageResource(i.e.default_avatar);
      break label618;
      label2525:
      if (!((String)localObject2).endsWith("@ad")) {
        if (((ax)localObject3).phe)
        {
          y.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[] { localObject2 });
          if (com.tencent.mm.pluginsdk.ui.a.b.cmd().sG() != null) {
            paramc.doU.setImageBitmap(com.tencent.mm.pluginsdk.ui.a.b.cmd().sG());
          }
          am.a.dVy.a((String)localObject2, "", new au.b(paramau.bJv(), paramInt1));
        }
      }
      for (;;)
      {
        paramc.pmC.a((String)localObject2, ((ax)localObject3).phd, paramau.oWm, ((ax)localObject3).oNn, ((ax)localObject3).oOM, paramInt2, ((ax)localObject3).oNn);
        break;
        com.tencent.mm.pluginsdk.ui.a.b.a(paramc.doU, (String)localObject2);
        continue;
        paramc.doU.setImageResource(i.e.default_avatar);
      }
      label2677:
      paramc.omL = false;
      break label700;
      label2685:
      paramc.pmP.setVisibility(8);
      break label974;
      label2697:
      if (((com.tencent.mm.plugin.sns.storage.a)localObject2).oAf != com.tencent.mm.plugin.sns.storage.a.ozS) {
        break label974;
      }
      Object localObject4;
      if (!bk.bl(((ax)localObject3).phb))
      {
        localObject1 = ((ax)localObject3).phc;
        localObject4 = ((ax)localObject3).phb;
        Object localObject5 = this.mActivity;
        paramc.pmP.getTextSize();
        localObject5 = new k(j.c((Context)localObject5, (CharSequence)localObject4, 1));
        ((k)localObject5).a(null, (CharSequence)localObject4, 0);
        localObject4 = paramc.pmP.getPaint();
        float f = Layout.getDesiredWidth((CharSequence)localObject5, 0, ((k)localObject5).length(), (TextPaint)localObject4);
        if (com.tencent.mm.cb.a.ad(this.mActivity, (int)f) > paramc.oWu)
        {
          do
          {
            if (((String)localObject1).length() <= 1) {
              break;
            }
            localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
            localObject5 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject2).oAg, new Object[] { (String)localObject1 + "..." });
            Object localObject6 = this.mActivity;
            paramc.pmP.getTextSize();
            localObject6 = new k(j.c((Context)localObject6, (CharSequence)localObject5, 1));
            ((k)localObject6).a(null, (CharSequence)localObject5, 0);
            f = Layout.getDesiredWidth((CharSequence)localObject6, 0, ((k)localObject6).length(), (TextPaint)localObject4);
            paramInt1 = com.tencent.mm.cb.a.ad(this.mActivity, (int)f);
            paramc.pmP.setText((CharSequence)localObject6, TextView.BufferType.SPANNABLE);
            paramc.pmP.setVisibility(0);
          } while (paramInt1 > paramc.oWu);
          break label974;
        }
        paramc.pmP.setText((CharSequence)localObject5, TextView.BufferType.SPANNABLE);
        paramc.pmP.setVisibility(0);
        break label974;
      }
      paramc.pmP.setVisibility(8);
      break label974;
      label3008:
      paramc.pmQ.setVisibility(8);
      break label1113;
      label3020:
      paramc.pnF.setVisibility(8);
      break label1166;
      label3032:
      paramInt1 = -9211021;
      break label1239;
      label3039:
      paramc.pcd.setVisibility(8);
      break label1245;
      label3051:
      if (((ax)localObject3).phm)
      {
        paramc.iSH.setVisibility(0);
        parambxk = new SpannableString(((ax)localObject3).php);
        parambxk.setSpan(new a.d(this), 0, parambxk.length(), 33);
        paramc.iSH.setText(parambxk, TextView.BufferType.SPANNABLE);
        paramc.iSH.setTag(new bc(((ax)localObject3).pho, ((ax)localObject3).php));
        break label1463;
      }
      if (((ax)localObject3).phq)
      {
        paramc.iSH.setVisibility(0);
        localObject1 = this.mActivity.getString(i.j.app_brand_appbrand_with_dot);
        localObject2 = (String)localObject1 + ((ax)localObject3).mAppName;
        localObject4 = new SpannableString((CharSequence)localObject2);
        ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(i.c.sns_word_color)), 0, ((String)localObject1).length(), 33);
        ((SpannableString)localObject4).setSpan(new a.a(this), ((String)localObject1).length(), ((String)localObject2).length(), 33);
        paramc.iSH.setText((CharSequence)localObject4, TextView.BufferType.SPANNABLE);
        if ((!((ax)localObject3).phn) && (!"wx7fa037cc7dfabad5".equals(parambxk.tNq.lsK)))
        {
          paramc.iSH.setTextColor(this.mActivity.getResources().getColor(i.c.sns_word_color));
          paramc.iSH.setOnTouchListener(null);
        }
        paramc.iSH.setTag(parambxk);
        break label1463;
      }
      paramc.iSH.setVisibility(8);
      break label1463;
      label3352:
      paramc.oPv.setVisibility(8);
      break label1491;
      paramc.oGU.setText(i.j.sns_post_error_ban_again);
      paramc.pmX.setClickable(false);
      paramc.pmX.setEnabled(false);
      break label1666;
      paramc.oGU.setText(i.j.sns_post_error_to_long_again);
      paramc.pmX.setClickable(false);
      paramc.pmX.setEnabled(false);
      break label1666;
      paramc.oGU.setText(i.j.sns_post_error_ten_min_again);
      paramc.pmX.setClickable(true);
      paramc.pmX.setEnabled(true);
      break label1666;
      label3451:
      if (!paramc.pnh) {
        break label1700;
      }
      paramc.pnd.setVisibility(8);
      break label1700;
      paramc.pmR.setVisibility(8);
      break label1728;
      label3482:
      parambxk = String.format(this.mActivity.getString(i.j.sns_timeline_ui_with_to), new Object[] { ((ax)localObject3).phv });
      break label1789;
      label3512:
      if (((ax)localObject3).phw)
      {
        paramc.pmO.setVisibility(0);
        parambxk = this.mActivity.getString(i.j.sns_timeline_ui_with_you);
        parambxk = j.a(this.mActivity, parambxk.toString(), paramc.pmO.getTextSize());
        paramc.pmO.setText(parambxk);
        break label1816;
      }
      label3573:
      paramc.pmO.setVisibility(8);
      break label1816;
      label3585:
      if (paramc.pnC == null) {
        break label1987;
      }
      paramc.pnC.setVisibility(8);
      break label1987;
      label3604:
      if (!paramc.pnc) {
        break label2041;
      }
      paramc.pnb.setVisibility(8);
      break label2041;
      label3623:
      if (!paramc.pnc)
      {
        if (paramc.oMK == null) {
          paramc.oMK = ((LinearLayout)paramc.pnb.inflate());
        }
        paramc.pmU = ((MaskTextView)paramc.oMK.findViewById(i.f.album_liked_list_tv));
        paramc.pmU.setOnTouchListener(new aa());
        paramc.pmV = ((LinearLayout)paramc.kKz.findViewById(i.f.album_comment_list_li));
        paramc.oMK.setTag(((ax)localObject3).pgO);
        paramc.pmU.setTag(((ax)localObject3).pgO);
        paramc.pna = paramc.oMK.findViewById(i.f.album_list_line);
        paramc.pnE = paramc.oMK.findViewById(i.f.album_list_fatherview);
        paramc.pnc = true;
      }
      paramc.oMK.setVisibility(0);
      if ((((ax)localObject3).phB != null) && (((ax)localObject3).phB.size() > 0))
      {
        paramc.pmU.setVisibility(0);
        a(paramc.pmU, ((ax)localObject3).phB, paramInt2);
        label3807:
        if (((ax)localObject3).phC == null) {
          break label3892;
        }
        a(localbto.tKb, ((ax)localObject3).phC, paramc);
      }
      for (;;)
      {
        if ((((ax)localObject3).phB == null) || (((ax)localObject3).phB.size() == 0) || (((ax)localObject3).phC == null) || (((ax)localObject3).phC.size() == 0)) {
          break label3904;
        }
        paramc.pna.setVisibility(0);
        break;
        paramc.pmU.setVisibility(8);
        break label3807;
        label3892:
        paramc.pmV.setVisibility(8);
      }
      label3904:
      paramc.pna.setVisibility(8);
      break label2041;
      label3916:
      paramc.pmK.setVisibility(8);
      break label2081;
      label3928:
      paramInt1 = 0;
      break label2217;
      label3933:
      paramc.omM.setVisibility(8);
    }
    label3945:
    paramc = new com.tencent.mm.ui.a.b();
    paramc.acY(paramau.getText().toString());
    paramc.acY((String)localObject1);
    if (localObject2 != null) {
      paramc.acY(((TextView)localObject2).getText().toString());
    }
    if (bool) {
      paramc.acY(paramn.ze.getString(a.k.contains_sight_desc));
    }
    paramc.dB(parambxk);
  }
  
  public abstract void a(a.c paramc, int paramInt1, ax paramax, bxk parambxk, int paramInt2, com.tencent.mm.plugin.sns.ui.au paramau);
  
  public abstract void d(a.c paramc);
  
  public final void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.oVB = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a
 * JD-Core Version:    0.7.0.1
 */
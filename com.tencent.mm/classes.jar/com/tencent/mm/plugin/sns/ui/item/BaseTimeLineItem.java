package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.autogen.a.ts;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.MomentsTogetherTailActionStruct.a;
import com.tencent.mm.autogen.mmdata.rpt.nn;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.av.b;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ax.a;
import com.tencent.mm.plugin.sns.model.g.5;
import com.tencent.mm.plugin.sns.model.g.d;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.ah;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.bj;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bn.c;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.bs;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.plugin.sns.ui.i.a;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.widget.Tiger2022Helper;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.span.u;
import com.tencent.mm.pluginsdk.ui.span.u.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.feb;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public abstract class BaseTimeLineItem
{
  public boolean DEBUG = false;
  public bn QBJ;
  private ax.a Qyi = new ax.a()
  {
    public final void bT(LinkedList<String> paramAnonymousLinkedList)
    {
      AppMethodBeat.i(308994);
      ax.Qyi = null;
      BaseTimeLineItem.b(BaseTimeLineItem.this).setVisibility(0);
      BaseTimeLineItem.a(BaseTimeLineItem.this, BaseTimeLineItem.b(BaseTimeLineItem.this), paramAnonymousLinkedList);
      AppMethodBeat.o(308994);
    }
  };
  private ViewGroup RKt;
  private StoryAvatarDotsView RKu;
  public ArrayList<av.b> RKv = new ArrayList();
  protected boolean Roa = false;
  protected Activity mActivity;
  private final com.tencent.mm.pluginsdk.ui.span.a mAdTagClickCallback = new com.tencent.mm.pluginsdk.ui.span.a()
  {
    public final void lG(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(308979);
      if (paramAnonymousInt1 < 0) {}
      try
      {
        Log.e("AdTagClickableHelper", "BaseTimeLineItem, position < 0");
        AppMethodBeat.o(308979);
        return;
      }
      finally
      {
        SnsInfo localSnsInfo;
        Log.e("AdTagClickableHelper", localObject.toString());
        AppMethodBeat.o(308979);
        return;
      }
      localSnsInfo = BaseTimeLineItem.this.QBJ.alF(paramAnonymousInt1);
      if (localSnsInfo != null)
      {
        Log.i("AdTagClickableHelper", "BaseTimeLineItem position = " + paramAnonymousInt1 + ", snsId = " + localSnsInfo.field_snsId + ", source = SOURCE_TIMELINE , clickPos = " + paramAnonymousInt2);
        com.tencent.mm.plugin.sns.ad.timeline.helper.c.a(BaseTimeLineItem.this.mActivity, 0, localSnsInfo, paramAnonymousInt2);
        AppMethodBeat.o(308979);
        return;
      }
      Log.e("AdTagClickableHelper", "BaseTimeLineItem, snsInfo is null");
      AppMethodBeat.o(308979);
    }
  };
  protected int viewType;
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, fdv paramfdv)
  {
    if ((paramView instanceof SnsCommentCollapseLayout)) {
      ((SnsCommentCollapseLayout)paramView).a(paramCharSequence1, paramCharSequence2, paramInt1, paramInt2);
    }
    for (;;)
    {
      paramCharSequence1 = com.tencent.mm.plugin.sns.j.a.QCu;
      com.tencent.mm.plugin.sns.j.a.a.a(paramView, paramfdv);
      return;
      if ((paramView instanceof TextView)) {
        ((TextView)paramView).setText(paramCharSequence1);
      }
    }
  }
  
  private void a(TextView paramTextView, int paramInt, CharSequence paramCharSequence)
  {
    paramTextView.setVisibility(0);
    Object localObject = paramCharSequence;
    if (paramInt != 0) {
      localObject = this.mActivity.getString(paramInt, new Object[] { paramCharSequence });
    }
    paramTextView.setText(p.b(this.mActivity, (CharSequence)localObject, paramTextView.getTextSize()));
  }
  
  public static void a(av.b paramb, BaseViewHolder paramBaseViewHolder, String paramString1, String paramString2)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.RKE != null))
    {
      paramBaseViewHolder.RKE.a(paramb, 1, paramString1, paramString2, paramb.Qxs);
      paramBaseViewHolder.RKE.setVisibility(0);
    }
  }
  
  private void a(ADInfo paramADInfo, BaseViewHolder paramBaseViewHolder)
  {
    if ((paramADInfo == null) || (paramBaseViewHolder == null)) {
      Log.i("MicroMsg.BaseTimeLineItem", "adInfo or holder is null");
    }
    for (;;)
    {
      return;
      try
      {
        if ((paramADInfo.adChainType == 1) && (!Util.isNullOrNil(paramADInfo.adActionExtTailFormattedWording)))
        {
          String str = paramADInfo.adActionExtTailUserDisplayName;
          Object localObject1 = paramADInfo.adActionExtTailFormattedWording;
          Object localObject2 = this.mActivity;
          paramBaseViewHolder.RKP.getTextSize();
          localObject2 = new q(p.e((Context)localObject2, (CharSequence)localObject1, 1));
          ((q)localObject2).a(null, (CharSequence)localObject1, 0);
          localObject1 = paramBaseViewHolder.RKP.getPaint();
          float f = Layout.getDesiredWidth((CharSequence)localObject2, 0, ((q)localObject2).length(), (TextPaint)localObject1);
          if (com.tencent.mm.cd.a.K(this.mActivity, (int)f) > paramBaseViewHolder.RoX)
          {
            int i;
            do
            {
              if (str.length() <= 1) {
                break;
              }
              str = str.substring(0, str.length() - 2);
              localObject2 = String.format(paramADInfo.adActionExtTailWording, new Object[] { str + "..." });
              Object localObject3 = this.mActivity;
              paramBaseViewHolder.RKP.getTextSize();
              localObject3 = new q(p.e((Context)localObject3, (CharSequence)localObject2, 1));
              ((q)localObject3).a(null, (CharSequence)localObject2, 0);
              f = Layout.getDesiredWidth((CharSequence)localObject3, 0, ((q)localObject3).length(), (TextPaint)localObject1);
              i = com.tencent.mm.cd.a.K(this.mActivity, (int)f);
              paramBaseViewHolder.RKP.setText((CharSequence)localObject3, TextView.BufferType.SPANNABLE);
              paramBaseViewHolder.RKP.setVisibility(0);
            } while (i > paramBaseViewHolder.RoX);
            return;
          }
          paramBaseViewHolder.RKP.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
          paramBaseViewHolder.RKP.setVisibility(0);
          return;
        }
      }
      finally
      {
        Log.e("MicroMsg.BaseTimeLineItem", paramADInfo.toString());
      }
    }
  }
  
  private void a(MaskTextView paramMaskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, int paramInt)
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
          localSpannableStringBuilder.append(p.b(this.mActivity, (CharSequence)localObject, paramMaskTextView.getTextSize()));
          i += 1;
          break;
          localSpannableStringBuilder.append(", ");
          localStringBuffer.append(", ");
        }
      }
      localObject = this.mActivity.getResources().getDrawable(b.i.friendactivity_luckymoney_icon);
    }
    catch (Exception paramMaskTextView)
    {
      Log.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[] { Util.stackTraceToString(paramMaskTextView) });
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
    locala.afSg = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
    localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
    if (paramInt == 10)
    {
      paramInt = 3;
      break label411;
      while (i < arrayOfInt1.length)
      {
        localSpannableStringBuilder.setSpan(new u((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), this.QBJ.RoO, paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
        i += 1;
      }
      paramMaskTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
      paramMaskTextView.setOriginText(localStringBuffer.toString());
      return;
    }
    for (;;)
    {
      label411:
      i = 0;
      break;
      paramInt = 2;
    }
  }
  
  public static void a(bo parambo, int paramInt)
  {
    if ((paramInt != 3) && (paramInt != 2)) {
      return;
    }
    ts localts = new ts();
    localts.hXH.hHB = parambo.Rdg;
    localts.hXH.hQX = parambo.PNx;
    localts.hXH.action = 1;
    localts.hXH.hVQ = parambo.sWX;
    localts.hXH.type = paramInt;
    localts.publish();
  }
  
  private static void a(BaseViewHolder paramBaseViewHolder, SnsInfo paramSnsInfo)
  {
    if (paramSnsInfo.isAd())
    {
      if (paramBaseViewHolder.RKD != null) {
        paramBaseViewHolder.RKD.setVisibility(0);
      }
      paramBaseViewHolder.RKF.setLongClickable(false);
      paramBaseViewHolder.RKF.setOnClickListener(null);
      paramSnsInfo = new LinearLayout.LayoutParams(-1, -2);
      paramBaseViewHolder.RKF.setLayoutParams(paramSnsInfo);
      paramBaseViewHolder.RKF.setBackgroundColor(Color.parseColor("#00ffffff"));
      if (paramBaseViewHolder.RKZ != null)
      {
        paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.RKZ.getLayoutParams();
        paramSnsInfo.leftMargin = 0;
        paramSnsInfo.rightMargin = 0;
        paramBaseViewHolder.RKZ.setLayoutParams(paramSnsInfo);
      }
      if (paramBaseViewHolder.RLx)
      {
        paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.Qcj.RjL.getLayoutParams();
        paramSnsInfo.leftMargin = 0;
        paramSnsInfo.rightMargin = 0;
        paramBaseViewHolder.Qcj.RjL.setLayoutParams(paramSnsInfo);
      }
      return;
    }
    if (paramBaseViewHolder.RKD != null) {
      paramBaseViewHolder.RKD.setVisibility(0);
    }
    paramBaseViewHolder.RKF.setLongClickable(false);
    paramBaseViewHolder.RKF.setOnClickListener(null);
    if (paramBaseViewHolder.RKZ != null)
    {
      paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.RKZ.getLayoutParams();
      paramSnsInfo.leftMargin = 0;
      paramSnsInfo.rightMargin = 0;
      paramBaseViewHolder.RKZ.setLayoutParams(paramSnsInfo);
    }
    if (paramBaseViewHolder.RLx)
    {
      paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.Qcj.RjL.getLayoutParams();
      paramSnsInfo.leftMargin = 0;
      paramSnsInfo.rightMargin = 0;
      paramBaseViewHolder.Qcj.RjL.setLayoutParams(paramSnsInfo);
    }
    paramSnsInfo = new LinearLayout.LayoutParams(-1, -2);
    paramBaseViewHolder.RKF.setLayoutParams(paramSnsInfo);
    paramBaseViewHolder.RKF.setBackgroundColor(Color.parseColor("#00ffffff"));
  }
  
  private void a(StoryAvatarDotsView paramStoryAvatarDotsView, List<String> paramList)
  {
    paramStoryAvatarDotsView.setIconSize(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 20));
    paramStoryAvatarDotsView.setIconGap(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 24));
    if (paramList.size() > 0)
    {
      paramStoryAvatarDotsView.setVisibility(0);
      paramStoryAvatarDotsView.setIconLayerCount(Math.min(paramList.size(), 3));
      int i = 0;
      while (i < paramStoryAvatarDotsView.getChildCount())
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(paramStoryAvatarDotsView.DS(i), (String)paramList.get(i), 0.1F, false);
        paramStoryAvatarDotsView.DS(i).setPadding(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 1), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 1), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 1), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 1));
        i += 1;
      }
    }
    paramStoryAvatarDotsView.setVisibility(8);
  }
  
  private boolean a(List<fdv> paramList, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, BaseViewHolder paramBaseViewHolder, bo parambo, int paramInt, SnsInfo paramSnsInfo)
  {
    LinearLayout localLinearLayout = paramBaseViewHolder.RKV;
    int i1 = localLinearLayout.getChildCount();
    int j = paramb.size();
    Object localObject1;
    if (i1 > j)
    {
      i = j;
      while (i < i1)
      {
        localObject1 = localLinearLayout.getChildAt(j);
        localLinearLayout.removeViewAt(j);
        if ((localObject1 instanceof SnsCommentCollapseLayout)) {
          this.QBJ.a((SnsCommentCollapseLayout)localObject1);
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
    if (this.DEBUG) {
      Log.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + paramBaseViewHolder.position + " commentCount: " + j);
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int m = 0;
    int i = 0;
    int k = 0;
    long l;
    String str1;
    String str3;
    String str2;
    Object localObject4;
    Object localObject6;
    Object localObject5;
    if (m < paramb.size())
    {
      localObject1 = (com.tencent.mm.vending.j.a)paramb.get(m);
      l = ((Long)((com.tencent.mm.vending.j.a)localObject1).get(0)).longValue();
      str1 = (String)((com.tencent.mm.vending.j.a)localObject1).get(1);
      str3 = (String)((com.tencent.mm.vending.j.a)localObject1).get(2);
      str2 = (String)((com.tencent.mm.vending.j.a)localObject1).get(3);
      localObject4 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(4);
      localObject6 = (String)((com.tencent.mm.vending.j.a)localObject1).get(5);
      localObject5 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(6);
      if (Util.isNullOrNil((String)localObject6)) {
        break label2277;
      }
      j = 1;
      localStringBuilder2.append(l).append("|");
    }
    for (;;)
    {
      localStringBuilder1.append(l).append("|");
      fdv localfdv = (fdv)paramList.get(m);
      i = localfdv.abDl;
      int i2 = localfdv.DeleteFlag;
      Object localObject7 = bG(paramBaseViewHolder.hQX, l);
      if ((localObject7 != null) && (((av.b)localObject7).oss)) {
        av.gX(((av.b)localObject7).id, 2);
      }
      label480:
      int n;
      Object localObject2;
      if (k >= i1) {
        if ((localObject7 == null) || (((av.b)localObject7).oss))
        {
          localObject1 = this.QBJ.hpv();
          ((SnsCommentCollapseLayout)localObject1).bm(15.0F * com.tencent.mm.cd.a.getScaleSize(((View)localObject1).getContext()));
          if (this.QBJ.Ryu == -1) {
            this.QBJ.Ryu = this.mActivity.getResources().getColor(b.c.FG_0_5);
          }
          ((SnsCommentCollapseLayout)localObject1).setTextColor(this.QBJ.Ryu);
          ((SnsCommentCollapseLayout)localObject1).setGravity(16);
          n = 1;
          localObject2 = localObject1;
        }
      }
      label723:
      Object localObject3;
      label787:
      label831:
      Object localObject8;
      for (;;)
      {
        if (localObject7 != null)
        {
          localObject1 = localObject2;
          if (!(localObject2 instanceof TranslateCommentTextView))
          {
            localLinearLayout.removeView((View)localObject2);
            localObject1 = new TranslateCommentTextView(this.mActivity);
            localLinearLayout.addView((View)localObject1, k);
            ((TranslateCommentTextView)localObject1).getTranslateResultView().dr(15.0F * com.tencent.mm.cd.a.getScaleSize(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cd.a.getScaleSize(((View)localObject1).getContext()));
          }
          localObject6 = (TranslateCommentTextView)localObject1;
          ((View)localObject1).setOnTouchListener(null);
          a(((TranslateCommentTextView)localObject6).getOriginCommentTextView(), (CharSequence)localObject5, (CharSequence)localObject4, i, i2, localfdv);
          if (!((av.b)localObject7).ooe)
          {
            ((TranslateCommentTextView)localObject6).RGj.setTextSize(1, 15.0F * com.tencent.mm.cd.a.getScaleSize(((TranslateCommentTextView)localObject6).getContext()));
            ((TranslateCommentTextView)localObject6).Rqk.amo(2);
            ((TranslateCommentTextView)localObject6).Rqk.setVisibility(0);
            i = 1;
            if (k <= 0) {
              break label1964;
            }
            ((View)localObject1).setPadding(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 4), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 3));
            if (k != paramb.size() - 1) {
              break label1953;
            }
            ((View)localObject1).setBackgroundResource(b.e.sns_timeline_comment_bg_bottom);
            if (i != 0)
            {
              localObject2 = (TranslateCommentTextView)localObject1;
              i = (int)this.mActivity.getResources().getDimension(b.d.SmallPadding);
              ((TranslateCommentTextView)localObject2).Rqk.getSplitlineView().setPadding(0, 0, i, 0);
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.g.c(localfdv)) {
              break label2070;
            }
            ((View)localObject1).setOnLongClickListener(null);
            ((View)localObject1).setOnClickListener(null);
            if (parambo != null)
            {
              localObject3 = parambo.Rdg;
              str3 = parambo.PNx;
              localObject4 = parambo.sWX;
              if (parambo.PJU == null) {
                break label2114;
              }
              localObject2 = parambo.PJU.Id;
              ((View)localObject1).setTag(new m((String)localObject3, str3, localfdv, str1, str2, (View)localObject1, 1, (String)localObject4, (String)localObject2));
            }
            if (n != 0)
            {
              localLinearLayout.removeView((View)localObject1);
              localLinearLayout.addView((View)localObject1);
            }
            m += 1;
            i = j;
            k += 1;
            break;
            localObject1 = new TranslateCommentTextView(this.mActivity);
            ((TranslateCommentTextView)localObject1).getTranslateResultView().dr(15.0F * com.tencent.mm.cd.a.getScaleSize(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cd.a.getScaleSize(((View)localObject1).getContext()));
            break label480;
            localObject2 = localLinearLayout.getChildAt(k);
            n = 0;
            continue;
          }
          if (!((av.b)localObject7).oss)
          {
            localObject4 = ((av.b)localObject7).result;
            localObject5 = ((av.b)localObject7).brand;
            localObject8 = ((TranslateCommentTextView)localObject6).RGj.getText().toString();
            if (!Util.isNullOrNil((String)localObject8))
            {
              localObject2 = ((String)localObject8).split(":");
              if (localObject2.length <= 2) {
                break label2274;
              }
              localObject3 = new String[2];
              localObject3[0] = localObject2[0];
              localObject3[1] = ((String)localObject8).substring(localObject3[0].length() + 1);
              localObject2 = localObject3;
            }
          }
        }
      }
      label1171:
      label1953:
      label1964:
      label2114:
      label2274:
      for (;;)
      {
        if (localObject2.length == 2)
        {
          if (Util.isNullOrNil((String)localObject4)) {
            break label1171;
          }
          ((TranslateCommentTextView)localObject6).Rqk.a((av.b)localObject7, 2, localObject2[0] + ": " + (String)localObject4, (String)localObject5, ((av.b)localObject7).Qxs);
        }
        for (;;)
        {
          ((TranslateCommentTextView)localObject6).Rqk.setVisibility(0);
          ((TranslateCommentTextView)localObject6).RGj.setTextSize(1, 15.0F * com.tencent.mm.cd.a.getScaleSize(((TranslateCommentTextView)localObject6).getContext()));
          i = 1;
          break;
          ((TranslateCommentTextView)localObject6).Rqk.a((av.b)localObject7, 2, null, (String)localObject5, ((av.b)localObject7).Qxs);
        }
        ((TranslateCommentTextView)localObject6).getTranslateResultView().setVisibility(8);
        i = 1;
        break;
        if ((n == 0) && ((localObject2 instanceof TranslateCommentTextView)))
        {
          localLinearLayout.removeView((View)localObject2);
          localObject1 = this.QBJ.hpv();
          localLinearLayout.addView((View)localObject1, k);
          ((SnsCommentCollapseLayout)localObject1).bm(15.0F * com.tencent.mm.cd.a.getScaleSize(((View)localObject1).getContext()));
        }
        for (;;)
        {
          if ((localObject1 instanceof SnsCommentCollapseLayout))
          {
            ((SnsCommentCollapseLayout)localObject1).bm(15.0F * com.tencent.mm.cd.a.getScaleSize(((View)localObject1).getContext()));
            ((SnsCommentCollapseLayout)localObject1).setOpClickListener(this.QBJ.RyJ);
            localObject2 = new com.tencent.mm.pluginsdk.ui.span.s(this.mActivity);
            ((com.tencent.mm.pluginsdk.ui.span.s)localObject2).setAdTagClickCallback(null, -1);
            if (com.tencent.mm.plugin.sns.ui.widget.g.b(paramSnsInfo, localfdv.Username))
            {
              ((com.tencent.mm.pluginsdk.ui.span.s)localObject2).setAdTagClickCallback(this.mAdTagClickCallback, paramInt);
              ((com.tencent.mm.pluginsdk.ui.span.s)localObject2).mAdTagClickScene = 31;
            }
            ((SnsCommentCollapseLayout)localObject1).setPressTouchListener((View.OnTouchListener)localObject2);
          }
          localObject3 = new CharSequence[2];
          localObject3[0] = localObject5;
          localObject3[1] = localObject4;
          localObject1.hashCode();
          if ((Util.isNullOrNil((String)localObject6)) || (!(localObject1 instanceof SnsCommentCollapseLayout)))
          {
            ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).tryAttachStatusIconSpan((View)localObject1, (CharSequence)localObject4);
            a((View)localObject1, localObject3[0], localObject3[1], i, i2, localfdv);
            i = 0;
            break;
          }
          localObject2 = al.hgy();
          localObject7 = new f((String)localObject6, (CharSequence)localObject5, (CharSequence)localObject4, (View)localObject1, i, i2, this.QBJ.Ryx);
          localObject8 = com.tencent.mm.emoji.b.a.b.mgs;
          localObject8 = com.tencent.mm.emoji.b.a.b.Eo((String)localObject6);
          if (localObject8 == null) {
            al.hgo().execute(new g.5((com.tencent.mm.plugin.sns.model.g)localObject2, (String)localObject6, (g.d)localObject7));
          }
          int i3 = com.tencent.mm.ui.bd.fromDPToPix(this.mActivity, 28);
          localObject6 = new StringBuilder((String)localObject6);
          if (localObject8 == null)
          {
            ((StringBuilder)localObject6).append("miss");
            Log.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s miss cache", new Object[] { ((StringBuilder)localObject6).toString() });
          }
          for (localObject2 = this.mActivity.getResources().getDrawable(b.e.sns_emoji_download_icon);; localObject2 = new BitmapDrawable((Bitmap)localObject8))
          {
            localObject5 = new SpannableStringBuilder((CharSequence)localObject5);
            ((SpannableStringBuilder)localObject5).append("  ").append(((StringBuilder)localObject6).toString()).append("  ").append(" ");
            int i4 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 2 - 1;
            int i5 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 4 - 1;
            ((Drawable)localObject2).setBounds(0, 0, i3, i3);
            localObject7 = new com.tencent.mm.ui.widget.a((Drawable)localObject2, 1);
            localObject8 = new u(((StringBuilder)localObject6).toString(), this.QBJ.Ryx, 2);
            ((SpannableStringBuilder)localObject5).setSpan(localObject7, i4, ((StringBuilder)localObject6).toString().length() + i4, 33);
            ((SpannableStringBuilder)localObject5).setSpan(localObject8, i5, i5 + 4 + ((StringBuilder)localObject6).toString().length(), 33);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject4);
            localSpannableStringBuilder.append("  ").append(((StringBuilder)localObject6).toString()).append("  ").append(" ");
            i4 = localSpannableStringBuilder.length() - ((StringBuilder)localObject6).toString().length() - 2 - 1;
            i5 = localSpannableStringBuilder.length() - ((StringBuilder)localObject6).toString().length() - 4 - 1;
            ((Drawable)localObject2).setBounds(0, 0, i3, i3);
            localSpannableStringBuilder.setSpan(localObject7, i4, ((StringBuilder)localObject6).toString().length() + i4, 33);
            localSpannableStringBuilder.setSpan(localObject8, i5, i5 + 4 + ((StringBuilder)localObject6).toString().length(), 33);
            localObject3[0] = localObject5;
            localObject3[1] = localSpannableStringBuilder;
            break;
            Log.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s hit cache", new Object[] { ((StringBuilder)localObject6).toString() });
          }
          ((View)localObject1).setBackgroundResource(b.e.sns_clickable_bg);
          break label723;
          ((View)localObject1).setPadding(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 6), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 3));
          if (paramBaseViewHolder.Mei)
          {
            if (paramb.size() == 1)
            {
              ((View)localObject1).setBackgroundResource(b.e.sns_timeline_comment_bg_bottom);
              break label723;
            }
            ((View)localObject1).setBackgroundResource(b.e.sns_clickable_bg);
            break label723;
          }
          if (paramb.size() == 1)
          {
            ((View)localObject1).setBackgroundResource(b.e.sns_timeline_comment_bg);
            break label723;
          }
          ((View)localObject1).setBackgroundResource(b.e.sns_timeline_comment_bg_top);
          break label723;
          ((View)localObject1).setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(308987);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              localObject = new int[2];
              if ((paramAnonymousView.getTag(b.f.touch_loc) instanceof int[])) {}
              for (paramAnonymousView = (int[])paramAnonymousView.getTag(b.f.touch_loc);; paramAnonymousView = (View)localObject)
              {
                BaseTimeLineItem.this.QBJ.hpB().a(this.RFU, BaseTimeLineItem.this.QBJ.QBf.RQh, BaseTimeLineItem.this.QBJ.QBf.RPU, paramAnonymousView[0], paramAnonymousView[1]);
                com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(308987);
                return true;
              }
            }
          });
          ((View)localObject1).setOnClickListener(new i.a(this.QBJ.Ryp, localfdv, str3, str2, paramBaseViewHolder));
          break label787;
          localObject2 = null;
          break label831;
          if (i != 0)
          {
            paramList = com.tencent.mm.plugin.sns.statistics.j.QFS;
            paramInt = paramBaseViewHolder.position;
            l = parambo.PJQ.field_snsId;
            paramb = localStringBuilder2.toString();
            paramSnsInfo = localStringBuilder1.toString();
            paramBaseViewHolder = t.uA(l);
            if (paramList.QGg.get(paramBaseViewHolder) == null)
            {
              parambo = new nn();
              parambo.iVg = parambo.F("PublishId", paramBaseViewHolder, true);
              parambo.jfn = parambo.F("CommentIdList", paramSnsInfo, true);
              parambo.jfo = parambo.F("EmojiIdList", paramb, true);
              paramb = new com.tencent.mm.plugin.sns.statistics.j.a(paramList);
              paramb.position = paramInt;
              paramb.QGU = parambo;
              paramList.QGg.put(paramBaseViewHolder, paramb);
            }
          }
          return true;
          localObject1 = localObject2;
        }
      }
      label2070:
      label2277:
      j = i;
    }
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, SnsInfo paramSnsInfo)
  {
    paramBaseViewHolder.RLP.setVisibility(8);
    Object localObject1;
    Object localObject2;
    if ((this.QBJ != null) && (this.QBJ.RyB))
    {
      localObject1 = al.hgK();
      long l = paramSnsInfo.field_snsId;
      localObject2 = "select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.bottom<=" + l + " AND SnsWsFoldGroup.top>=" + l;
      localObject2 = ((ah)localObject1).omV.rawQuery((String)localObject2, null, 2);
      if (localObject2 == null) {
        break label518;
      }
      if (!((Cursor)localObject2).moveToFirst()) {
        break label512;
      }
      localObject1 = new com.tencent.mm.plugin.sns.storage.ag();
      ((com.tencent.mm.plugin.sns.storage.ag)localObject1).convertFrom((Cursor)localObject2);
      ((Cursor)localObject2).close();
    }
    for (;;)
    {
      String str1;
      String str2;
      int i;
      if (localObject1 != null)
      {
        str1 = t.uB(((com.tencent.mm.plugin.sns.storage.ag)localObject1).field_top);
        str2 = t.uB(((com.tencent.mm.plugin.sns.storage.ag)localObject1).field_bottom);
        Object localObject3 = al.hgB();
        localObject2 = w.hkY();
        if (str1 != null)
        {
          localObject1 = localObject2;
          if (str1.equals("")) {}
        }
        else
        {
          localObject1 = (String)localObject2 + " AND " + ((w)localObject3).bai(str1);
        }
        localObject2 = localObject1;
        if (w.bad(str2)) {
          localObject2 = (String)localObject1 + " AND " + ((w)localObject3).bae(str2);
        }
        localObject1 = (String)localObject2 + w.QYW;
        Log.d("MicroMsg.SnsInfoStorage", "getCursorByTimeLineSeqIncluded ".concat(String.valueOf(localObject1)));
        localObject1 = ((w)localObject3).QYR.rawQuery((String)localObject1, null);
        localObject2 = new ArrayList();
        if (localObject1 != null)
        {
          while (((Cursor)localObject1).moveToNext())
          {
            localObject3 = new SnsInfo();
            ((SnsInfo)localObject3).convertFrom((Cursor)localObject1);
            ((List)localObject2).add(localObject3);
          }
          ((Cursor)localObject1).close();
        }
        i = 0;
        if (i >= ((List)localObject2).size()) {
          break label507;
        }
        if (((SnsInfo)((List)localObject2).get(i)).field_snsId != paramSnsInfo.field_snsId) {
          break label500;
        }
      }
      for (;;)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("top:").append(str1).append("bottom:").append(str2).append("\n");
        ((StringBuilder)localObject1).append("snsid:").append(t.uB(paramSnsInfo.field_snsId)).append("\n");
        ((StringBuilder)localObject1).append("indexInGroup:").append(i);
        paramBaseViewHolder.RLP.setText(((StringBuilder)localObject1).toString());
        paramBaseViewHolder.RLP.setVisibility(0);
        return;
        label500:
        i += 1;
        break;
        label507:
        i = 0;
      }
      label512:
      localObject1 = null;
      break;
      label518:
      localObject1 = null;
    }
  }
  
  private av.b bG(String paramString, long paramLong)
  {
    if (this.RKv.size() <= 0) {
      return null;
    }
    Iterator localIterator = this.RKv.iterator();
    while (localIterator.hasNext())
    {
      av.b localb = (av.b)localIterator.next();
      if ((localb.id != null) && (localb.id.equals(av.mj(paramString, String.valueOf(paramLong))))) {
        return localb;
      }
    }
    return null;
  }
  
  public static void i(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.RKE != null))
    {
      paramBaseViewHolder.RKE.amo(1);
      paramBaseViewHolder.RKE.setVisibility(0);
    }
  }
  
  public static void j(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.RKE != null)) {
      paramBaseViewHolder.RKE.setVisibility(8);
    }
  }
  
  public final View a(Activity paramActivity, final BaseViewHolder paramBaseViewHolder, int paramInt, final bn parambn, SnsInfo paramSnsInfo)
  {
    this.mActivity = paramActivity;
    this.viewType = paramInt;
    this.QBJ = parambn;
    paramBaseViewHolder.hQX = paramSnsInfo.getSnsId();
    Object localObject;
    View localView;
    switch (paramInt)
    {
    case 14: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 22: 
    case 25: 
    default: 
      localObject = "R.layout.sns_media_sub_item2";
      int j = b.g.sns_timeline_item_photo_one3;
      int i = j;
      if (com.tencent.mm.ui.aw.jlc()) {
        if (!com.tencent.mm.ui.aw.mO(this.mActivity))
        {
          i = j;
          if (com.tencent.mm.ui.aw.b(this.mActivity.getContentResolver()))
          {
            i = j;
            if (Build.VERSION.SDK_INT >= 24)
            {
              i = j;
              if (this.mActivity.isInMultiWindowMode()) {}
            }
          }
        }
        else
        {
          i = j;
          if (!com.tencent.mm.ui.ag.aAk(this.mActivity.getTaskId())) {
            i = b.g.sns_timeline_item_photo_one3_large;
          }
        }
      }
      com.tencent.mm.kiss.layout.b.bbG();
      localView = com.tencent.mm.kiss.layout.b.d(this.mActivity, i);
      paramBaseViewHolder.Qcs = localView;
      paramBaseViewHolder.RLF = ((String)localObject);
      localObject = localView.findViewById(b.f.images_keeper_li);
      if (!(localObject instanceof ViewStub)) {
        break;
      }
    }
    for (paramBaseViewHolder.RKG = ((ViewStub)localObject);; paramBaseViewHolder.RKG = null)
    {
      Log.i("MicroMsg.BaseTimeLineItem", "create new item  " + paramInt + "  " + localView.hashCode());
      paramBaseViewHolder.RLy = localView.findViewById(b.f.sns_timeline_content);
      paramBaseViewHolder.viewType = paramInt;
      paramBaseViewHolder.RKz = ((SnsAvatarImageView)localView.findViewById(b.f.album_avatar_iv));
      paramBaseViewHolder.RKz.setWeakContext(paramActivity);
      paramBaseViewHolder.RKz.setOnClickListener(parambn.QBf.RPV);
      paramBaseViewHolder.RKz.setOnLongClickListener(parambn.QBf.RPW);
      paramBaseViewHolder.RKz.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(100046);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            int i = (int)paramAnonymousMotionEvent.getRawX();
            int j = (int)paramAnonymousMotionEvent.getRawY();
            paramAnonymousView.setTag(b.f.touch_loc, new int[] { i, j });
          }
          AppMethodBeat.o(100046);
          return false;
        }
      });
      paramBaseViewHolder.RKA = ((AsyncTextView)localView.findViewById(b.f.nickname_tv));
      paramBaseViewHolder.RKB = ((ImageView)localView.findViewById(b.f.type_desc_tv));
      paramBaseViewHolder.RKA.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ai());
      paramBaseViewHolder.RKC = ((ViewGroup)localView.findViewById(b.f.nick_type_ll));
      paramBaseViewHolder.RKD = ((AsyncNormalTextView)localView.findViewById(b.f.desc_collapse_tv));
      paramBaseViewHolder.RKD.setOpClickListener(parambn.RyG);
      paramBaseViewHolder.RKD.setShrinkOrSpreadListener(parambn.RyH);
      paramBaseViewHolder.RKF = ((LinearLayout)localView.findViewById(b.f.images_keeper_linear_layout));
      paramBaseViewHolder.RKF.setTag(paramBaseViewHolder);
      paramBaseViewHolder.RKF.setOnClickListener(parambn.QBf.RQG);
      localObject = localView.findViewById(b.f.desc_tv);
      parambn.hpB().c((View)localObject, parambn.QBf.RPX, parambn.QBf.RPU);
      localObject = (TextView)localView.findViewById(b.f.desc_tv_single);
      parambn.hpB().c((View)localObject, parambn.QBf.RPX, parambn.QBf.RPU);
      paramBaseViewHolder.RKE = ((SnsTranslateResultView)localView.findViewById(b.f.sns_translate_result_view));
      paramBaseViewHolder.RKE.setVisibility(8);
      paramBaseViewHolder.RKE.getSplitlineView().setPadding(0, 0, 0, 0);
      paramBaseViewHolder.RKE.getResultTextView().setBackgroundResource(b.e.sns_clickable_bg);
      parambn.hpB().c(paramBaseViewHolder.RKE.getResultTextView(), parambn.QBf.RPX, parambn.QBf.RPU);
      paramBaseViewHolder.RKY = ((LinearLayout)localView.findViewById(b.f.comment_ll));
      paramBaseViewHolder.RKN = ((TextView)localView.findViewById(b.f.with_info_tv));
      paramBaseViewHolder.timeTv = ((TextView)localView.findViewById(b.f.album_publish_time));
      paramBaseViewHolder.RKP = ((TextView)localView.findViewById(b.f.album_ad_tail_desc));
      paramBaseViewHolder.RKQ = ((TextView)localView.findViewById(b.f.album_ad_at_tail));
      paramBaseViewHolder.Rwl = ((TextView)localView.findViewById(b.f.album_address));
      paramBaseViewHolder.QmD = new bu(localView, parambn.Ryp.Rbv, 0, new c.b()
      {
        public final void hbt()
        {
          AppMethodBeat.i(308972);
          if (parambn.QBf != null) {
            parambn.QBf.m(paramBaseViewHolder);
          }
          AppMethodBeat.o(308972);
        }
        
        public final ViewGroup hbu()
        {
          if ((paramBaseViewHolder instanceof a.a)) {
            return ((a.a)paramBaseViewHolder).xFi;
          }
          if ((paramBaseViewHolder instanceof f.a)) {
            return (ViewGroup)((f.a)paramBaseViewHolder).RMK.Cxb;
          }
          return null;
        }
      });
      paramBaseViewHolder.QmD.b(parambn.QBf.RQf, parambn.QBf.RQv);
      paramBaseViewHolder.RKM = ((RelativeLayout)localView.findViewById(b.f.openim_tag_ll));
      paramBaseViewHolder.RKM.setOnClickListener(parambn.QBf.RQy);
      paramBaseViewHolder.RdP = ((TextView)localView.findViewById(b.f.album_del));
      paramBaseViewHolder.RdP.setText(paramActivity.getString(b.j.app_delete));
      paramBaseViewHolder.RdP.setContentDescription(paramActivity.getString(b.j.app_delete));
      paramBaseViewHolder.RdP.setOnClickListener(parambn.QBf.RPZ);
      paramBaseViewHolder.RKP.setOnClickListener(parambn.QBf.RQw);
      paramBaseViewHolder.RKQ.setOnClickListener(parambn.QBf.RQx);
      paramBaseViewHolder.Rwl.setOnClickListener(parambn.QBf.RQs);
      paramBaseViewHolder.RKR = localView.findViewById(b.f.album_groupid);
      paramBaseViewHolder.RKR.setOnClickListener(parambn.QBf.RQe);
      paramBaseViewHolder.RKO = ((WeImageView)localView.findViewById(b.f.album_type_icon));
      paramBaseViewHolder.plq = ((TextView)localView.findViewById(b.f.album_from));
      paramBaseViewHolder.RKS = ((ImageView)localView.findViewById(b.f.album_show_comment_tv));
      paramBaseViewHolder.RLb = ((ViewStub)localView.findViewById(b.f.album_comment_stub));
      paramBaseViewHolder.RaE = ((LinearLayout)localView.findViewById(b.f.album_list_fatherview));
      paramBaseViewHolder.RLA = ((ViewStub)localView.findViewById(b.f.album_hb_reward));
      paramBaseViewHolder.RLH = ((ViewStub)localView.findViewById(b.f.sns_unread_tip_stub));
      paramBaseViewHolder.RLM = ((ViewStub)localView.findViewById(b.f.sns_retry_edit_tip_stub));
      paramBaseViewHolder.pzj = ((ViewGroup)localView.findViewById(b.f.sns_item_content_root));
      paramBaseViewHolder.RLd = ((ViewStub)localView.findViewById(b.f.sns_post_error_stub));
      paramBaseViewHolder.RKI = ((TextView)localView.findViewById(b.f.game_more_tv));
      paramBaseViewHolder.RKI.setOnClickListener(parambn.QBf.RQa);
      BaseViewHolder.a(paramBaseViewHolder, (TextView)localView.findViewById(b.f.hb_tip));
      paramBaseViewHolder.RLP = ((TextView)localView.findViewById(b.f.sns_ws_fold_debug_tv));
      paramBaseViewHolder.convertView = localView;
      paramBaseViewHolder.RLQ = localView.findViewById(b.f.sns_timeline_loading_end);
      paramBaseViewHolder.akiX = ((ViewStub)localView.findViewById(b.f.tiger2022_stub));
      if (this.Roa)
      {
        com.tencent.mm.plugin.sns.abtest.c.b(localView, paramBaseViewHolder);
        com.tencent.mm.plugin.sns.abtest.a.a(localView, paramBaseViewHolder);
        al.hgs();
        com.tencent.mm.plugin.sns.i.c.c(localView, paramBaseViewHolder);
      }
      d(paramBaseViewHolder);
      localView.setTag(paramBaseViewHolder);
      a(paramBaseViewHolder, paramSnsInfo);
      return localView;
      localObject = "R.layout.sns_timeline_item_photo_one3";
      if (!com.tencent.mm.ui.aw.jkS()) {
        break;
      }
      localObject = "R.layout.sns_timeline_item_photo_one3_large";
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
      localObject = "R.layout.sns_timeline_ad_full_card_new";
      break;
      localObject = "R.layout.sns_timeline_ad_sphere_card";
      break;
      localObject = "R.layout.sns_media_sight_item";
      break;
      localObject = "R.layout.sns_ad_finder_topic_item_content";
      break;
      localObject = "R.layout.sns_ad_slide_full_card";
      break;
    }
  }
  
  public final void a(bo parambo, TimeLineObject paramTimeLineObject)
  {
    if ((parambo == null) || (paramTimeLineObject == null)) {}
    for (;;)
    {
      return;
      if (paramTimeLineObject.AppInfo == null) {}
      for (String str = null; !Util.isNullOrNil(str); str = paramTimeLineObject.AppInfo.Id)
      {
        com.tencent.mm.plugin.sns.d.a.pFo.a(str, paramTimeLineObject.UserName, paramTimeLineObject.ContentObj.Zpq, paramTimeLineObject.statisticsData, parambo.RBq);
        return;
      }
    }
  }
  
  public final void a(final BaseViewHolder paramBaseViewHolder, int paramInt1, final SnsInfo paramSnsInfo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn, bo parambo)
  {
    a(paramBaseViewHolder, paramSnsInfo);
    this.viewType = paramInt2;
    this.QBJ = parambn;
    if (this.Roa) {
      com.tencent.mm.plugin.sns.ui.a.c.ac(paramSnsInfo);
    }
    com.tencent.mm.plugin.sns.ui.a.c.g(paramTimeLineObject);
    com.tencent.mm.plugin.sns.ui.a.c.f(paramTimeLineObject);
    if (paramSnsInfo.isAd()) {
      Log.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + t.uB(paramSnsInfo.field_snsId) + " for susan");
    }
    paramBaseViewHolder.RKx = parambo.RBq;
    paramBaseViewHolder.ICx = false;
    paramBaseViewHolder.position = paramInt1;
    paramBaseViewHolder.hQX = parambo.PNx;
    paramBaseViewHolder.hES = parambo.Rdg;
    paramBaseViewHolder.RKy = parambo.RBu;
    paramBaseViewHolder.RKS.setOnClickListener(parambn.RyF);
    paramBaseViewHolder.timeLineObject = paramTimeLineObject;
    Object localObject2 = parambo.PJP;
    paramBaseViewHolder.snsobj = ((SnsObject)localObject2);
    Object localObject1 = parambn.Ryp.Rbw.Qwn;
    Object localObject3;
    if (paramSnsInfo != null)
    {
      localObject3 = paramSnsInfo.getLocalid();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFn.add(localObject3);
      if (paramSnsInfo.isAd()) {
        ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFs.add(localObject3);
      }
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFt.add(paramSnsInfo.field_userName);
    }
    int i;
    label658:
    Object localObject4;
    switch (paramSnsInfo.field_type)
    {
    default: 
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFy.add(localObject3);
      if (paramInt1 < ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFl)
      {
        ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFl = paramInt1;
        ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDL = t.x(paramSnsInfo);
      }
      if (paramInt1 > ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFm)
      {
        ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFm = paramInt1;
        ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDM = t.x(paramSnsInfo);
      }
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDR = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFo.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDS = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFp.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDT = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFq.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDV = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFr.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDU = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFs.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDW = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFw.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QEe = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFx.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).vDI = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFt.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDP = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFu.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDQ = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFv.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QEd = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFy.size();
      ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QDz = ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFn.size();
      localObject3 = parambo.PVf;
      localObject1 = parambo.sWX;
      paramBaseViewHolder.RKD.setAdTagClickCallback(null, -1);
      if (com.tencent.mm.plugin.sns.ad.timeline.helper.c.ai(parambo.Rbg, paramInt2)) {
        paramBaseViewHolder.RKD.setAdTagClickCallback(this.mAdTagClickCallback, paramInt1);
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramBaseViewHolder.Rbk = parambo.RBp;
        paramBaseViewHolder.RKz.setTag(localObject1);
        paramBaseViewHolder.RKz.setContentDescription(String.format(paramBaseViewHolder.RKz.getResources().getString(b.j.shake_avatar), new Object[] { parambo.RBD }));
        if (paramBaseViewHolder.Rbk != null) {
          if ((com.tencent.mm.storage.au.bwO((String)localObject1)) && ("3552365301".equals(paramBaseViewHolder.Rbk.field_openImAppid)))
          {
            i = 1;
            if ((localObject3 == null) || (!((ADXml)localObject3).usePreferedInfo)) {
              break label3902;
            }
            paramBaseViewHolder.RKz.setImageResource(b.e.default_avatar);
            paramBaseViewHolder.RKz.hj((String)localObject1, 4);
            paramBaseViewHolder.RKz.setShowStoryHint(false);
            if (!Util.isNullOrNil(((ADXml)localObject3).preferAvatar))
            {
              localObject4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId", ((ADXml)localObject3).preferAvatar);
              paramBaseViewHolder.RKz.setTag(b.f.sns_prefer_avatar_url, ((ADXml)localObject3).preferAvatar);
              if (!y.ZC((String)localObject4)) {
                break label3851;
              }
              if (!com.tencent.mm.plugin.sns.ad.timeline.helper.k.hbW()) {
                break label3824;
              }
              com.tencent.mm.plugin.sns.ad.timeline.helper.k.i(paramBaseViewHolder.RKz, (String)localObject4, 1);
            }
            label762:
            paramBaseViewHolder.RKA.setContactInfo(paramBaseViewHolder.Rbk);
            paramBaseViewHolder.RKA.a((String)localObject1, parambo.RBD, new d(parambn, (String)localObject1), parambo.Rbg, parambo.Rdg, paramInt2, parambo.Rbg);
            paramBaseViewHolder.RKz.nsy = parambo.Rdg;
          }
        }
      }
      break;
    }
    label858:
    label5725:
    for (;;)
    {
      paramBaseViewHolder.RKB.setVisibility(8);
      label1127:
      int j;
      if (parambo.Rbg)
      {
        paramBaseViewHolder.isAd = true;
        paramBaseViewHolder.ICx = parambo.RBv;
        paramBaseViewHolder.RKD.a(parambo.RBr, parambn, parambo.RBs, parambo);
        paramBaseViewHolder.RKD.setShow(paramBaseViewHolder);
        if ((TextUtils.isEmpty(parambo.RBn)) || (!Tiger2022Helper.h(paramTimeLineObject)) || (paramBaseViewHolder.akiX == null)) {
          break label4179;
        }
        paramBaseViewHolder.RKD.setVisibility(8);
        if (paramBaseViewHolder.akiZ == null)
        {
          localObject1 = (ViewGroup)paramBaseViewHolder.akiX.inflate();
          paramBaseViewHolder.akiZ = ((TextView)((ViewGroup)localObject1).findViewById(b.f.tiger2022_text));
          paramBaseViewHolder.akiY = ((ViewGroup)((ViewGroup)localObject1).findViewById(b.f.tiger2022_container));
        }
        paramBaseViewHolder.akiY.setVisibility(0);
        parambn.hpB().c(paramBaseViewHolder.akiZ, parambn.QBf.RPX, parambn.QBf.RPU);
        localObject1 = new bj(parambo.PNx, parambo.Rdg, false, false, 1);
        ((bj)localObject1).userName = parambo.sWX;
        paramBaseViewHolder.akiZ.setTag(localObject1);
        paramBaseViewHolder.akiZ.setText(parambo.RBn);
        paramBaseViewHolder.akiZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(paramBaseViewHolder.akiZ.getContext()));
        localObject1 = (ViewGroup)paramBaseViewHolder.akiY.getParent();
        ((ViewGroup)localObject1).setClipChildren(false);
        ((ViewGroup)localObject1).setClipToPadding(false);
        localObject1 = (ViewGroup)((ViewGroup)localObject1).getParent();
        ((ViewGroup)localObject1).setClipChildren(false);
        ((ViewGroup)localObject1).setClipToPadding(false);
        localObject1 = com.tencent.mm.plugin.sns.j.a.QCu;
        localObject3 = paramBaseViewHolder.RKD;
        j = b.f.desc_tv;
        kotlin.g.b.s.u(localObject3, "view");
        kotlin.g.b.s.u(parambo, "struct");
        localObject1 = ((View)localObject3).findViewById(j);
        localObject4 = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject3 = ((View)localObject3).getContext();
        kotlin.g.b.s.s(localObject3, "view.context");
        localObject3 = com.tencent.mm.plugin.secdata.ui.a.a.jC((Context)localObject3);
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.secdata.ui.a)localObject3).gUA();
          if (localObject3 != null) {
            ((com.tencent.mm.plugin.secdata.f)localObject3).lJ(kotlin.g.b.s.X("Item_", Integer.valueOf(parambo.PJQ.localid)), String.valueOf(((View)localObject1).hashCode()));
          }
        }
        paramBaseViewHolder.plq.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ai());
        a(paramBaseViewHolder, paramInt1, parambo, paramTimeLineObject, paramInt2, parambn);
        a(parambo, paramTimeLineObject);
        parambn.Ryr.put(Integer.valueOf(paramInt1), new WeakReference(paramBaseViewHolder.convertView));
        if (paramBaseViewHolder.convertView.getBackground() == null)
        {
          paramBaseViewHolder.convertView.setBackgroundResource(b.e.comm_list_item_selector);
          j = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12);
          int k = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8);
          paramBaseViewHolder.convertView.setPadding(j, j, j, k);
        }
        paramBaseViewHolder.timeTv.setText(parambo.RBw);
        paramBaseViewHolder.RKP.setVisibility(8);
        paramBaseViewHolder.RKQ.setVisibility(8);
        if (parambo.Rbg)
        {
          localObject3 = parambo.RBx;
          paramBaseViewHolder.RKP.setTag(parambo.Rdg);
          if (!com.tencent.mm.plugin.sns.ad.timeline.helper.e.a((ADInfo)localObject3)) {
            break label4198;
          }
          com.tencent.mm.plugin.sns.ad.timeline.helper.e.a(paramBaseViewHolder.RKP, (SnsObject)localObject2, (ADInfo)localObject3);
          if ((paramBaseViewHolder.RKP.getVisibility() != 8) && (Util.isNullOrNil(((ADInfo)localObject3).adActionExtTailLink)))
          {
            paramBaseViewHolder.RKP.setTextColor(this.mActivity.getResources().getColor(b.c.sns_word_color));
            paramBaseViewHolder.RKP.setOnClickListener(null);
          }
          if ((paramSnsInfo.getTimeLine().ContentObj.Zps & 0x4) == 0) {
            break label4617;
          }
          paramBaseViewHolder.RKQ.setTag(paramBaseViewHolder);
          paramBaseViewHolder.RKQ.setVisibility(0);
          paramBaseViewHolder.RKQ.setText(String.format("%s%s%s", new Object[] { this.mActivity.getResources().getString(b.j.sns_ad_at_tips1), parambo.RBD, this.mActivity.getResources().getString(b.j.sns_ad_at_tips2) }));
        }
        if (!parambo.RBG) {
          break label4629;
        }
        localObject1 = parambn.lzt.getString(b.j.lucky_sns_reward_numbers, new Object[] { Integer.valueOf(parambo.RBH) });
        BaseViewHolder.k(paramBaseViewHolder).setText((CharSequence)localObject1);
        BaseViewHolder.k(paramBaseViewHolder).setVisibility(0);
        label1629:
        paramBaseViewHolder.Rwl.setTag(parambo.Rdg);
        if (Util.isNullOrNil(parambo.RBJ)) {
          break label4682;
        }
        paramBaseViewHolder.Rwl.setVisibility(0);
        paramBaseViewHolder.Rwl.setText(parambo.RBJ);
        paramBaseViewHolder.Rwl.setContentDescription(parambo.RBJ);
        paramBaseViewHolder.Rwl.setClickable(parambo.RBK);
        localObject1 = paramBaseViewHolder.Rwl;
        if (!parambo.RBK) {
          break label4641;
        }
        j = this.mActivity.getResources().getColor(b.c.sns_link_color);
        ((TextView)localObject1).setTextColor(j);
        if (!parambo.RBK) {
          break label4659;
        }
        paramBaseViewHolder.Rwl.setBackground(this.mActivity.getResources().getDrawable(b.e.sns_clickable_bg));
        label1760:
        if (!parambo.RBR) {
          break label4702;
        }
        paramBaseViewHolder.RKO.setVisibility(0);
        paramBaseViewHolder.RKO.setImageResource(b.i.icons_outlined_mini_program);
        paramBaseViewHolder.RKO.setIconColor(this.mActivity.getResources().getColor(b.c.BW_0_Alpha_0_3));
        paramBaseViewHolder.plq.setTextColor(this.mActivity.getResources().getColor(b.c.sns_link_color));
        if (!parambo.RBL) {
          break label4720;
        }
        paramBaseViewHolder.plq.setVisibility(0);
        localObject1 = this.mActivity.getString(b.j.sns_comefrome) + parambo.akiQ;
        if ((paramTimeLineObject == null) || (paramTimeLineObject.ContentObj == null) || ((paramTimeLineObject.ContentObj.Zpq != 28) && (paramTimeLineObject.ContentObj.Zpq != 34) && (paramTimeLineObject.ContentObj.Zpq != 45) && (paramTimeLineObject.ContentObj.Zpq != 43) && (paramTimeLineObject.ContentObj.Zpq != 36) && ((paramTimeLineObject.ContentObj.Zpq != 1) || (paramTimeLineObject.ContentObj.DHa == null)))) {
          break label4714;
        }
        j = 1;
        if ((((String)localObject1).length() <= 10) || (j != 0)) {
          break label6518;
        }
        localObject1 = ((String)localObject1).substring(0, 10) + "...";
      }
      label2142:
      label2420:
      label6518:
      for (;;)
      {
        localObject1 = new SpannableString((CharSequence)localObject1);
        ((SpannableString)localObject1).setSpan(new b(), 0, ((SpannableString)localObject1).length(), 33);
        if (Tiger2022Helper.i(paramTimeLineObject)) {
          Tiger2022Helper.bE((CharSequence)localObject1);
        }
        paramBaseViewHolder.plq.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((!parambo.RBN) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.AppInfo.Id)))
        {
          paramBaseViewHolder.plq.setTextColor(this.mActivity.getResources().getColor(b.c.sns_word_color));
          paramBaseViewHolder.plq.setOnTouchListener(null);
        }
        paramBaseViewHolder.plq.setTag(paramTimeLineObject);
        if (parambo.RBF)
        {
          paramBaseViewHolder.RdP.setVisibility(0);
          paramBaseViewHolder.RdP.setTag(parambo.Rdg);
          label2170:
          paramBaseViewHolder.RKS.setTag(paramBaseViewHolder);
          if ((!parambo.RBS) || (paramTimeLineObject.ContentObj.Zpq == 28)) {
            break label5120;
          }
          if (!paramBaseViewHolder.RLh)
          {
            paramBaseViewHolder.RKW = ((LinearLayout)paramBaseViewHolder.RLd.inflate());
            paramBaseViewHolder.RKX = paramBaseViewHolder.convertView.findViewById(b.f.post_again_click_id);
            paramBaseViewHolder.RLh = true;
            paramBaseViewHolder.RKX.setTag(parambo.Rdg);
            paramBaseViewHolder.QRC = ((TextView)paramBaseViewHolder.RKW.findViewById(b.f.post_again_click_id));
          }
          paramBaseViewHolder.RLd.setVisibility(0);
          paramBaseViewHolder.RKX.setOnClickListener(parambn.QBf.RQd);
          switch (parambo.RBT)
          {
          default: 
            paramBaseViewHolder.QRC.setText(b.j.sns_post_error_touch_again);
            paramBaseViewHolder.RKX.setClickable(true);
            paramBaseViewHolder.RKX.setEnabled(true);
            paramTimeLineObject = paramSnsInfo.getPostInfo();
            if ((paramTimeLineObject != null) && (!Util.isNullOrNil(paramTimeLineObject.aaTW))) {
              paramBaseViewHolder.QRC.setText(paramTimeLineObject.aaTW);
            }
            if (parambo.RBU)
            {
              paramBaseViewHolder.RKR.setVisibility(0);
              paramBaseViewHolder.RKR.setTag(parambo.Rdg);
              if (!parambo.RBV) {
                break label5229;
              }
              if (Util.isNullOrNil(parambo.RBX)) {
                break label5151;
              }
              paramBaseViewHolder.RKN.setVisibility(0);
              paramBaseViewHolder.RKN.setText(parambo.RBX, TextView.BufferType.SPANNABLE);
              paramBaseViewHolder.RKN.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ai());
              com.tencent.mm.plugin.comm.b.e.xfd.b(com.tencent.mm.plugin.comm.b.b.xeQ.name(), parambo.PNx, "scene", MomentsTogetherTailActionStruct.a.iVi);
              com.tencent.mm.plugin.comm.b.e.xfd.a(com.tencent.mm.plugin.comm.b.b.xeQ.name(), parambo.PNx, "expoCount", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
              com.tencent.mm.plugin.comm.b.e.xfd.b(com.tencent.mm.plugin.comm.b.b.xeQ.name(), parambo.PNx, "PublishId", Long.valueOf(com.tencent.mm.plugin.sns.storage.ai.aXe(parambo.PNx)));
              label2557:
              if (!parambo.RBZ) {
                break label5241;
              }
              if (paramBaseViewHolder.RLB == null)
              {
                paramBaseViewHolder.RLB = paramBaseViewHolder.RLA.inflate();
                paramBaseViewHolder.Qqg = ((TextView)paramBaseViewHolder.RLB.findViewById(b.f.album_hb_reward_tip));
                paramBaseViewHolder.RLC = ((MaskTextView)paramBaseViewHolder.RLB.findViewById(b.f.album_hb_reward_users));
                paramBaseViewHolder.RLC.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ai());
              }
              paramBaseViewHolder.RLB.setVisibility(0);
              a(paramBaseViewHolder.RLC, parambo.RCc, paramInt2);
              paramTimeLineObject = this.mActivity.getString(b.j.sns_lucky_reward_tip_info, new Object[] { Integer.valueOf(parambo.RCa), Util.formatMoney2f(parambo.RCb / 100.0D) });
              paramBaseViewHolder.Qqg.setText(paramTimeLineObject);
              paramBaseViewHolder.RLB.setTag(paramSnsInfo);
              paramBaseViewHolder.RLB.setOnClickListener(parambn.QBf.RQg);
              if (((parambo.RCd != null) && (parambo.RCd.size() != 0)) || ((parambo.RCe != null) && (parambo.RCe.size() != 0))) {
                break label5279;
              }
              if (paramBaseViewHolder.RaE == null) {
                break label5260;
              }
              paramBaseViewHolder.RaE.setVisibility(8);
              if (!parambo.RCf) {
                break label5707;
              }
              paramBaseViewHolder.RKI.setTag(parambo.Rdg);
              paramBaseViewHolder.RKI.setText(parambo.RCg);
              paramBaseViewHolder.RKI.setVisibility(0);
              if (!parambo.Rbg) {
                break label5725;
              }
              Log.i("MicroMsg.BaseTimeLineItem", "adatag " + parambo.RBz);
              paramBaseViewHolder.QmD.R(Long.valueOf(parambo.RBq), new com.tencent.mm.plugin.sns.data.e(paramBaseViewHolder.QmD, paramBaseViewHolder.position, parambo.Rdg, parambo.RBq, parambo.mViewId));
              paramBaseViewHolder.QmD.a(parambo.PJQ, parambo.RBy, parambo.RBx);
              paramBaseViewHolder.QmD.setVisibility(0);
              if ((paramBaseViewHolder.Rwl != null) && (paramBaseViewHolder.Rwl.getVisibility() == 0))
              {
                if (paramBaseViewHolder.QmD.RFb.getVisibility() != 0) {
                  break label5719;
                }
                i = 1;
                if (i != 0)
                {
                  paramTimeLineObject = (LinearLayout.LayoutParams)paramBaseViewHolder.Rwl.getLayoutParams();
                  paramTimeLineObject.setMargins(paramTimeLineObject.leftMargin, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mActivity, 0.0F), paramTimeLineObject.rightMargin, paramTimeLineObject.bottomMargin);
                  paramBaseViewHolder.Rwl.setLayoutParams(paramTimeLineObject);
                }
              }
              paramBaseViewHolder.RKM.setVisibility(8);
              if (!this.Roa) {
                break label5896;
              }
              al.hgs().a(this.mActivity, (SnsObject)localObject2, paramBaseViewHolder);
              b(paramBaseViewHolder, paramSnsInfo);
              paramTimeLineObject = al.hgN();
              long l = paramSnsInfo.field_snsId;
              if ((!paramTimeLineObject.Qxy) || (l == 0L) || (paramTimeLineObject.QxR) || (paramTimeLineObject.QxI <= paramTimeLineObject.QxC) || (paramTimeLineObject.QxV == null) || (paramTimeLineObject.QxV.state != 1) || (paramTimeLineObject.QxV.QCP < paramTimeLineObject.QxD) || (!paramTimeLineObject.QxN)) {
                break label5798;
              }
              if ((paramTimeLineObject.QxG != 0L) && (cn.getSyncServerTimeSecond() - paramTimeLineObject.QxU.QxZ <= paramTimeLineObject.QxG)) {
                break label5793;
              }
              paramInt1 = 1;
              if ((paramInt1 == 0) || (l != paramTimeLineObject.QxX)) {
                break label5798;
              }
              paramInt1 = 1;
              label3195:
              if (paramInt1 == 0) {
                break label5824;
              }
              if (!paramBaseViewHolder.RLG)
              {
                paramBaseViewHolder.RLJ = ((LinearLayout)paramBaseViewHolder.RLH.inflate());
                paramBaseViewHolder.RLG = true;
                paramBaseViewHolder.RLK = ((ViewGroup)paramBaseViewHolder.RLJ.findViewById(b.f.sns_unread_tip_group));
                BaseViewHolder.a(paramBaseViewHolder, (StoryAvatarDotsView)paramBaseViewHolder.RLK.findViewById(b.f.sns_unread_tip_avatars));
                this.RKt = paramBaseViewHolder.RLK;
              }
              paramBaseViewHolder.RLH.setVisibility(0);
              paramTimeLineObject = al.hgN();
              if (paramTimeLineObject.QxV == null)
              {
                Log.e("MicroMsg.SnsUnreadTipManager", "getTargetUserNames targetItem is null");
                paramTimeLineObject.Qyg = new LinkedList();
              }
              paramTimeLineObject = paramTimeLineObject.Qyg;
              Log.i("MicroMsg.BaseTimeLineItem", "checkUnreadTip expose, targetUserNames:%s", new Object[] { Integer.valueOf(paramTimeLineObject.size()) });
              if (!Util.isNullOrNil(paramTimeLineObject)) {
                break label5803;
              }
              BaseViewHolder.l(paramBaseViewHolder).setVisibility(8);
              this.RKu = BaseViewHolder.l(paramBaseViewHolder);
              ax.Qyi = this.Qyi;
              this.RKt.invalidate();
              this.RKt.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(309007);
                  t.a(BaseTimeLineItem.a(BaseTimeLineItem.this), Float.valueOf(BaseTimeLineItem.a(BaseTimeLineItem.this).getMeasuredHeight() / 2.0F));
                  BaseTimeLineItem.a(BaseTimeLineItem.this).invalidate();
                  AppMethodBeat.o(309007);
                }
              });
              paramBaseViewHolder.pzj.setBackgroundColor(0);
              paramBaseViewHolder.RLK.setTag(Long.valueOf(paramSnsInfo.field_snsId));
              al.hgN().ju(paramBaseViewHolder.RLK);
              paramBaseViewHolder.RLK.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(308991);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  BaseTimeLineItem.this.QBJ.Ryp.hlI();
                  com.tencent.mm.plugin.sns.statistics.j.QFS.QGC.jpE = 1L;
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(308991);
                }
              });
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1295, 1);
              label3452:
              al.hgO();
              if (!com.tencent.mm.plugin.sns.model.au.x(paramSnsInfo.field_snsId, paramSnsInfo.getCreateTime(), paramSnsInfo.localid)) {
                break label5867;
              }
              if (!paramBaseViewHolder.RLL)
              {
                paramBaseViewHolder.RLN = ((LinearLayout)paramBaseViewHolder.RLM.inflate());
                paramBaseViewHolder.RLL = true;
                paramBaseViewHolder.RLO = ((TextView)paramBaseViewHolder.RLN.findViewById(b.f.sns_retry_edit_tip));
              }
              paramBaseViewHolder.RLM.setVisibility(0);
              paramBaseViewHolder.pzj.setBackgroundColor(0);
              paramBaseViewHolder.RLO.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(309003);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  al.hgO().d(paramBaseViewHolder.RLO.getContext(), paramSnsInfo);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(309003);
                }
              });
            }
            break;
          }
        }
        Object localObject5;
        label5241:
        label5627:
        boolean bool;
        for (;;)
        {
          paramSnsInfo = new bj(parambo.PNx, parambo.Rdg, false, true, 1);
          paramBaseViewHolder.RKE.getResultTextView().setTag(paramSnsInfo);
          parambn = new StringBuilder("");
          if ((parambo.RCd == null) || (parambo.RCd.size() <= 0)) {
            break label5957;
          }
          parambn.append(MMApplicationContext.getContext().getResources().getString(b.j.sns_accessibility_like_list)).append(":");
          paramInt1 = 0;
          while (paramInt1 < parambo.RCd.size())
          {
            paramSnsInfo = (com.tencent.mm.vending.j.a)parambo.RCd.get(paramInt1);
            if (paramSnsInfo != null) {
              parambn.append((String)paramSnsInfo.get(1)).append(",");
            }
            paramInt1 += 1;
          }
          ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFp.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFo.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFr.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFq.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFw.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFx.add(localObject3);
          break;
          if (!Util.isNullOrNil(paramTimeLineObject.publicUserName))
          {
            ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFu.add(localObject3);
            break;
          }
          ((com.tencent.mm.plugin.sns.statistics.e)localObject1).QFv.add(localObject3);
          break;
          i = 0;
          break label658;
          localObject3 = o.PWQ.Cr((String)localObject4);
          if (localObject3 == null) {
            break label762;
          }
          paramBaseViewHolder.RKz.setImageBitmap((Bitmap)localObject3);
          break label762;
          if (com.tencent.mm.plugin.sns.ad.timeline.helper.k.hbW())
          {
            Log.i("MicroMsg.BaseTimeLineItem", "download use avatar with cdn, but the statement should not reach!");
            com.tencent.mm.plugin.sns.ad.timeline.helper.k.j(paramBaseViewHolder.RKz, ((ADXml)localObject3).preferAvatar, 1);
            break label762;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.a(((ADXml)localObject3).preferAvatar, false, new g.a()
          {
            public final void aWn(String paramAnonymousString)
            {
              AppMethodBeat.i(309002);
              Log.i("MicroMsg.BaseTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
              String str = (String)paramBaseViewHolder.RKz.getTag(b.f.sns_prefer_avatar_url);
              if ((!Util.isNullOrNil(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId", str))))
              {
                paramAnonymousString = o.PWQ.Cr(paramAnonymousString);
                if (paramAnonymousString != null) {
                  paramBaseViewHolder.RKz.setImageBitmap(paramAnonymousString);
                }
              }
              AppMethodBeat.o(309002);
            }
            
            public final void gZM() {}
            
            public final void gZN() {}
          });
          break label762;
          if (!((String)localObject1).endsWith("@ad")) {
            if (parambo.RBE)
            {
              Log.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[] { localObject1 });
              if (com.tencent.mm.pluginsdk.ui.a.b.iKa().aCj() != null) {
                paramBaseViewHolder.RKz.setImageBitmap(com.tencent.mm.pluginsdk.ui.a.b.iKa().aCj());
              }
              az.a.okP.a((String)localObject1, "", new bn.c(parambn.hpz(), paramInt1));
              if (parambo.RBF) {
                break label4119;
              }
              com.tencent.mm.plugin.sns.ui.e.a.b(4, (String)paramBaseViewHolder.RKz.getTag(), paramBaseViewHolder.RKz);
              paramBaseViewHolder.RKz.hj((String)localObject1, 4);
              paramBaseViewHolder.RKz.setTag(localObject1);
              com.tencent.mm.plugin.sns.ui.e.a.a(4, (String)localObject1, paramBaseViewHolder.RKz);
              paramBaseViewHolder.RKz.setShowStoryHint(false);
            }
          }
          for (;;)
          {
            paramBaseViewHolder.RKA.setContactInfo(paramBaseViewHolder.Rbk);
            paramBaseViewHolder.RKA.a((String)localObject1, parambo.RBD, new c(parambn), parambo.Rbg, parambo.Rdg, paramInt2, parambo.Rbg);
            break;
            com.tencent.mm.pluginsdk.ui.a.b.g(paramBaseViewHolder.RKz, (String)localObject1);
            break label3990;
            paramBaseViewHolder.RKz.hj((String)localObject1, 4);
            paramBaseViewHolder.RKz.setShowStoryHint(false);
            continue;
            paramBaseViewHolder.RKz.setImageResource(b.e.default_avatar);
            paramBaseViewHolder.RKz.hj((String)localObject1, 4);
            paramBaseViewHolder.RKz.setShowStoryHint(false);
          }
          paramBaseViewHolder.isAd = false;
          break label858;
          if (paramBaseViewHolder.akiZ == null) {
            break label1127;
          }
          paramBaseViewHolder.akiY.setVisibility(8);
          break label1127;
          if (parambo.RBx.adActionExtTailType == ADInfo.ADChainStrengthenDefaultWording)
          {
            if (!Util.isNullOrNil(parambo.RBA))
            {
              paramBaseViewHolder.RKP.setText(parambo.RBA);
              paramBaseViewHolder.RKP.setVisibility(0);
            }
            while ((((ADInfo)localObject3).adChainType == 1) && (!Util.isNullOrNil(((ADInfo)localObject3).adActionExtTailWording)))
            {
              paramBaseViewHolder.RKP.setText(((ADInfo)localObject3).adActionExtTailWording);
              paramBaseViewHolder.RKP.setVisibility(0);
              break;
              paramBaseViewHolder.RKP.setVisibility(8);
            }
          }
          if (((ADInfo)localObject3).adActionExtTailType != ADInfo.ADChainStrengthenUserInfoFormatWording) {
            break label1437;
          }
          if (!Util.isNullOrNil(parambo.RBB))
          {
            localObject1 = parambo.RBC;
            localObject4 = parambo.RBB;
            localObject5 = this.mActivity;
            paramBaseViewHolder.RKP.getTextSize();
            localObject5 = new q(p.e((Context)localObject5, (CharSequence)localObject4, 1));
            ((q)localObject5).a(null, (CharSequence)localObject4, 0);
            localObject4 = paramBaseViewHolder.RKP.getPaint();
            float f = Layout.getDesiredWidth((CharSequence)localObject5, 0, ((q)localObject5).length(), (TextPaint)localObject4);
            if (com.tencent.mm.cd.a.K(this.mActivity, (int)f) > paramBaseViewHolder.RoX) {
              do
              {
                if (((String)localObject1).length() <= 1) {
                  break;
                }
                localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                localObject5 = String.format(((ADInfo)localObject3).adActionExtTailWording, new Object[] { (String)localObject1 + "..." });
                localObject6 = this.mActivity;
                paramBaseViewHolder.RKP.getTextSize();
                localObject6 = new q(p.e((Context)localObject6, (CharSequence)localObject5, 1));
                ((q)localObject6).a(null, (CharSequence)localObject5, 0);
                f = Layout.getDesiredWidth((CharSequence)localObject6, 0, ((q)localObject6).length(), (TextPaint)localObject4);
                j = com.tencent.mm.cd.a.K(this.mActivity, (int)f);
                paramBaseViewHolder.RKP.setText((CharSequence)localObject6, TextView.BufferType.SPANNABLE);
                paramBaseViewHolder.RKP.setVisibility(0);
              } while (j > paramBaseViewHolder.RoX);
            }
          }
          for (;;)
          {
            a((ADInfo)localObject3, paramBaseViewHolder);
            break;
            paramBaseViewHolder.RKP.setText((CharSequence)localObject5, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.RKP.setVisibility(0);
            continue;
            paramBaseViewHolder.RKP.setVisibility(8);
          }
          paramBaseViewHolder.RKQ.setVisibility(8);
          break label1576;
          BaseViewHolder.k(paramBaseViewHolder).setVisibility(8);
          break label1629;
          j = this.mActivity.getResources().getColor(b.c.desc_text_color);
          break label1725;
          paramBaseViewHolder.Rwl.setBackground(this.mActivity.getResources().getDrawable(b.e.mm_trans));
          break label1760;
          paramBaseViewHolder.Rwl.setVisibility(8);
          paramBaseViewHolder.Rwl.setContentDescription(null);
          break label1760;
          paramBaseViewHolder.RKO.setVisibility(8);
          break label1806;
          j = 0;
          break label1979;
          if (parambo.RBM)
          {
            paramBaseViewHolder.plq.setVisibility(0);
            localObject1 = new SpannableString(parambo.RBP);
            ((SpannableString)localObject1).setSpan(new e(), 0, ((SpannableString)localObject1).length(), 33);
            paramBaseViewHolder.plq.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.plq.setTag(new bs(parambo.RBO, parambo.RBP));
            break label2142;
          }
          if (parambo.RBQ)
          {
            paramBaseViewHolder.plq.setVisibility(0);
            localObject1 = this.mActivity.getString(b.j.app_brand_appbrand_with_dot);
            localObject3 = (String)localObject1 + parambo.akiQ;
            localObject4 = new SpannableString((CharSequence)localObject3);
            ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(b.c.sns_word_color)), 0, ((String)localObject1).length(), 33);
            ((SpannableString)localObject4).setSpan(new a(), ((String)localObject1).length(), ((String)localObject3).length(), 33);
            paramBaseViewHolder.plq.setText((CharSequence)localObject4, TextView.BufferType.SPANNABLE);
            if ((!parambo.RBN) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.AppInfo.Id)))
            {
              paramBaseViewHolder.plq.setTextColor(this.mActivity.getResources().getColor(b.c.sns_word_color));
              paramBaseViewHolder.plq.setOnTouchListener(null);
            }
            paramBaseViewHolder.plq.setTag(paramTimeLineObject);
            break label2142;
          }
          paramBaseViewHolder.plq.setVisibility(8);
          break label2142;
          paramBaseViewHolder.RdP.setVisibility(8);
          break label2170;
          paramBaseViewHolder.QRC.setText(b.j.sns_post_error_ban_again);
          paramBaseViewHolder.RKX.setClickable(false);
          paramBaseViewHolder.RKX.setEnabled(false);
          break label2358;
          paramBaseViewHolder.QRC.setText(b.j.sns_post_error_to_long_again);
          paramBaseViewHolder.RKX.setClickable(false);
          paramBaseViewHolder.RKX.setEnabled(false);
          break label2358;
          paramBaseViewHolder.QRC.setText(b.j.sns_post_error_ten_min_again);
          paramBaseViewHolder.RKX.setClickable(true);
          paramBaseViewHolder.RKX.setEnabled(true);
          break label2358;
          if (!paramBaseViewHolder.RLh) {
            break label2392;
          }
          paramBaseViewHolder.RLd.setVisibility(8);
          break label2392;
          paramBaseViewHolder.RKR.setVisibility(8);
          break label2420;
          if (parambo.RBY)
          {
            a(paramBaseViewHolder.RKN, b.j.sns_timeline_ui_with_you, "");
            break label2557;
          }
          if (!Util.isNullOrNil(parambo.RBW))
          {
            paramTimeLineObject = paramBaseViewHolder.RKN;
            if (paramInt2 == 7) {}
            for (j = b.j.sns_timeline_ui_tv_with_to;; j = b.j.sns_timeline_ui_with_to)
            {
              a(paramTimeLineObject, j, parambo.RBW);
              break;
            }
          }
          paramBaseViewHolder.RKN.setVisibility(8);
          break label2557;
          if (paramBaseViewHolder.RLB == null) {
            break label2728;
          }
          paramBaseViewHolder.RLB.setVisibility(8);
          break label2728;
          if (!paramBaseViewHolder.RLc) {
            break label2782;
          }
          paramBaseViewHolder.RLb.setVisibility(8);
          break label2782;
          if (!paramBaseViewHolder.RLc)
          {
            if ((paramBaseViewHolder.RaE != null) || (paramBaseViewHolder.RLb.getParent() == null)) {
              break label5627;
            }
            paramBaseViewHolder.RaE = ((LinearLayout)paramBaseViewHolder.RLb.inflate());
            if (paramBaseViewHolder.RaE != null)
            {
              paramBaseViewHolder.RKU = ((SnsLikesTextView)paramBaseViewHolder.RaE.findViewById(b.f.album_liked_list_tv));
              paramBaseViewHolder.RKU.setLikedTextTouchListener(new com.tencent.mm.plugin.sns.ui.ai());
              paramBaseViewHolder.RKU.setOpClickListener(parambn.RyI);
              paramBaseViewHolder.RKV = ((LinearLayout)paramBaseViewHolder.convertView.findViewById(b.f.album_comment_list_li));
              paramBaseViewHolder.RaE.setTag(parambo.PNx);
              paramBaseViewHolder.RKU.setLikeTvTag(parambo.PNx);
              paramBaseViewHolder.RKU.setOpTvTag(paramBaseViewHolder);
              paramBaseViewHolder.RLa = paramBaseViewHolder.RaE.findViewById(b.f.album_list_line);
              paramBaseViewHolder.RLD = paramBaseViewHolder.RaE.findViewById(b.f.album_list_fatherview);
              paramBaseViewHolder.RLc = true;
            }
          }
          if (paramBaseViewHolder.RaE != null) {
            paramBaseViewHolder.RaE.setVisibility(0);
          }
          if ((parambo.RCd != null) && (parambo.RCd.size() > 0))
          {
            paramBaseViewHolder.RKU.setVisibility(0);
            parambn.a(parambo.Rdg, paramBaseViewHolder.RKU);
            paramBaseViewHolder.RKU.a(parambo.RCd, paramInt2, parambn, parambo.Rdg, parambn.RtB, parambn.RtC, parambn.Ryt, parambo, paramBaseViewHolder);
            paramBaseViewHolder.Mei = true;
            if (parambo.RCe == null) {
              break label5683;
            }
            a(((SnsObject)localObject2).CommentUserList, parambo.RCe, paramBaseViewHolder, parambo, paramInt1, paramSnsInfo);
          }
          for (;;)
          {
            if ((parambo.RCd == null) || (parambo.RCd.size() == 0) || (parambo.RCe == null) || (parambo.RCe.size() == 0)) {
              break label5695;
            }
            paramBaseViewHolder.RLa.setVisibility(0);
            break;
            if (paramBaseViewHolder.RaE == null) {}
            for (bool = true;; bool = false)
            {
              Log.e("MicroMsg.BaseTimeLineItem", "holder.listKeeper = null %s,and holder.commentStub.inflated", new Object[] { Boolean.valueOf(bool) });
              break;
            }
            paramBaseViewHolder.RKU.setVisibility(8);
            paramBaseViewHolder.Mei = false;
            break label5550;
            paramBaseViewHolder.RKV.setVisibility(8);
          }
          paramBaseViewHolder.RLa.setVisibility(8);
          break label2782;
          paramBaseViewHolder.RKI.setVisibility(8);
          break label2822;
          i = 0;
          break label2964;
          if (i != 0)
          {
            paramBaseViewHolder.QmD.setVisibility(8);
            paramBaseViewHolder.RKM.setTag(new com.tencent.mm.plugin.sns.data.i(paramBaseViewHolder.RKM, paramSnsInfo.getLocalid()));
            paramBaseViewHolder.RKM.setVisibility(0);
            break label3027;
          }
          paramBaseViewHolder.QmD.setVisibility(8);
          paramBaseViewHolder.RKM.setVisibility(8);
          break label3027;
          paramInt1 = 0;
          break label3178;
          paramInt1 = 0;
          break label3195;
          BaseViewHolder.l(paramBaseViewHolder).setVisibility(0);
          a(BaseViewHolder.l(paramBaseViewHolder), paramTimeLineObject);
          break label3372;
          if (paramBaseViewHolder.RLG)
          {
            paramBaseViewHolder.RLH.setVisibility(8);
            paramBaseViewHolder.RLK.setTag(Long.valueOf(paramSnsInfo.field_snsId));
          }
          paramBaseViewHolder.pzj.setBackgroundResource(b.e.list_item_normal);
          break label3452;
          if (paramBaseViewHolder.RLL) {
            paramBaseViewHolder.RLM.setVisibility(8);
          }
          paramBaseViewHolder.pzj.setBackgroundResource(b.e.list_item_normal);
          continue;
          if ((this.QBJ != null) && (this.QBJ.getCount() - 1 == paramInt1))
          {
            paramBaseViewHolder.pzj.setBackgroundColor(0);
            paramBaseViewHolder.RLQ.setVisibility(0);
          }
          else
          {
            paramBaseViewHolder.pzj.setBackgroundResource(b.e.list_item_normal);
            paramBaseViewHolder.RLQ.setVisibility(8);
          }
        }
        localObject1 = new StringBuilder("");
        if ((parambo.RCe != null) && (parambo.RCe.size() > 0))
        {
          ((StringBuilder)localObject1).append(MMApplicationContext.getContext().getResources().getString(b.j.sns_accessibility_comment_list)).append(":");
          paramInt1 = 0;
          while (paramInt1 < parambo.RCe.size())
          {
            paramSnsInfo = (com.tencent.mm.vending.j.a)parambo.RCe.get(paramInt1);
            if (paramSnsInfo != null) {
              ((StringBuilder)localObject1).append((CharSequence)paramSnsInfo.get(6)).append(",");
            }
            paramInt1 += 1;
          }
        }
        paramInt1 = 0;
        if (paramInt2 == 2) {}
        for (paramInt1 = 1;; paramInt1 = 2) {
          do
          {
            parambo = com.tencent.mm.ui.a.a.a.jlv();
            localObject2 = paramBaseViewHolder.convertView;
            localObject3 = paramBaseViewHolder.RKA;
            localObject4 = paramBaseViewHolder.timeTv;
            localObject5 = paramBaseViewHolder.Rwl;
            paramTimeLineObject = paramBaseViewHolder.RKD.getContent();
            paramSnsInfo = paramTimeLineObject;
            if (TextUtils.isEmpty(paramTimeLineObject)) {
              paramSnsInfo = "";
            }
            localObject6 = paramBaseViewHolder.hqU();
            paramTimeLineObject = paramSnsInfo;
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {
              paramTimeLineObject = paramSnsInfo + "，" + (String)localObject6;
            }
            paramSnsInfo = paramBaseViewHolder.RKK;
            bool = paramBaseViewHolder.RLx;
            paramBaseViewHolder = paramBaseViewHolder.plq;
            parambn = parambn.toString();
            localObject1 = ((StringBuilder)localObject1).toString();
            if ((parambo.jls()) && (parambo.mAppContext != null) && (localObject2 != null) && (localObject3 != null) && (localObject4 != null) && (localObject5 != null) && (paramBaseViewHolder != null)) {
              break;
            }
            return;
          } while ((paramInt2 != 3) && (paramInt2 != 4) && (paramInt2 != 5));
        }
        Object localObject6 = new com.tencent.mm.ui.a.b();
        ((com.tencent.mm.ui.a.b)localObject6).bzT(((TextView)localObject3).getText().toString());
        ((com.tencent.mm.ui.a.b)localObject6).bzT(paramTimeLineObject);
        if ((paramSnsInfo != null) && (paramSnsInfo.getText() != null)) {
          ((com.tencent.mm.ui.a.b)localObject6).bzT(paramSnsInfo.getText().toString());
        }
        if (bool) {
          ((com.tencent.mm.ui.a.b)localObject6).bzT(parambo.mAppContext.getString(a.k.contains_sight_desc));
        }
        if (paramInt1 == 1) {
          ((com.tencent.mm.ui.a.b)localObject6).bzT(parambo.mAppContext.getString(a.k.contains_one_photo_desc));
        }
        for (;;)
        {
          if ((localObject5 != null) && (((TextView)localObject5).getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject6).bzT(((TextView)localObject5).getText().toString());
          }
          if ((localObject4 != null) && (((TextView)localObject4).getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject6).bzT(((TextView)localObject4).getText().toString());
          }
          if ((paramBaseViewHolder != null) && (paramBaseViewHolder.getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject6).bzT(paramBaseViewHolder.getText().toString());
          }
          if (parambn != null) {
            ((com.tencent.mm.ui.a.b)localObject6).bzT(parambn);
          }
          if (localObject1 != null) {
            ((com.tencent.mm.ui.a.b)localObject6).bzT((String)localObject1);
          }
          ((com.tencent.mm.ui.a.b)localObject6).kX((View)localObject2);
          return;
          if (paramInt1 > 1) {
            ((com.tencent.mm.ui.a.b)localObject6).bzT(parambo.mAppContext.getString(a.k.contains_photos_desc));
          }
        }
      }
      label2782:
      label3178:
      label3824:
      label4720:
      i = 0;
      label4198:
      label4714:
      label5229:
      break label658;
      label4702:
      label5867:
      i = 0;
    }
  }
  
  public abstract void a(BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn);
  
  public abstract void d(BaseViewHolder paramBaseViewHolder);
  
  public final void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.Roa = paramBoolean;
  }
  
  public static abstract class BaseViewHolder
  {
    public ImageView DOt;
    public boolean ICx;
    public boolean Mei = false;
    public TextView QRC;
    public com.tencent.mm.plugin.sns.ui.aw Qcj = new com.tencent.mm.plugin.sns.ui.aw();
    public View Qcs;
    public bu QmD;
    public TextView Qqg;
    public AsyncTextView RKA;
    public ImageView RKB;
    public ViewGroup RKC;
    public AsyncNormalTextView RKD;
    public SnsTranslateResultView RKE;
    public LinearLayout RKF;
    public ViewStub RKG;
    public boolean RKH = false;
    public TextView RKI;
    public TagImageView RKJ;
    public TextView RKK;
    public int RKL = 0;
    public RelativeLayout RKM;
    public TextView RKN;
    public WeImageView RKO;
    public TextView RKP;
    public TextView RKQ;
    public View RKR;
    public ImageView RKS;
    public View RKT;
    public SnsLikesTextView RKU;
    public LinearLayout RKV;
    public LinearLayout RKW;
    public View RKX;
    public LinearLayout RKY;
    public PhotosContent RKZ;
    public long RKx;
    public int RKy;
    public SnsAvatarImageView RKz;
    public ViewStub RLA;
    public View RLB;
    public MaskTextView RLC;
    public View RLD;
    private TextView RLE;
    public String RLF;
    public boolean RLG = false;
    public ViewStub RLH;
    private StoryAvatarDotsView RLI;
    public LinearLayout RLJ;
    public ViewGroup RLK;
    public boolean RLL = false;
    public ViewStub RLM;
    public LinearLayout RLN;
    public TextView RLO;
    public TextView RLP;
    public View RLQ;
    public View RLa;
    public ViewStub RLb;
    public boolean RLc = false;
    public ViewStub RLd;
    public ViewStub RLe;
    public View RLf = null;
    public boolean RLg = false;
    public boolean RLh = false;
    public ViewStub RLi;
    public boolean RLj = false;
    public View RLk;
    public LinearLayout RLl;
    public TextView RLm;
    public ViewStub RLn;
    public boolean RLo = false;
    public View RLp;
    public LinearLayout RLq;
    public ViewStub RLr;
    public boolean RLs = false;
    public View RLt;
    public ImageView RLu;
    public boolean RLv = false;
    ViewStub RLw;
    boolean RLx = false;
    public View RLy;
    public BaseTimeLineItem RLz;
    public LinearLayout RaE;
    public com.tencent.mm.contact.d Rbk;
    public TextView RdP;
    public int RoX = 210;
    public TextView Rwl;
    public View Rwr;
    public ViewStub akiX;
    public ViewGroup akiY;
    public TextView akiZ;
    public View convertView;
    public String desc = "";
    public String hES;
    public String hQX;
    public boolean isAd;
    public volatile boolean mtE;
    public TextView plq;
    public int position;
    public dna postInfo;
    public ViewGroup pzj;
    public SnsObject snsobj;
    public TimeLineObject timeLineObject;
    public TextView timeTv;
    public TextView titleTv;
    public int viewType;
    
    public String hqU()
    {
      return this.desc;
    }
  }
  
  final class a
    extends u
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100051);
      BaseTimeLineItem.this.QBJ.RoS.RFI.onClick(paramView);
      AppMethodBeat.o(100051);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100052);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(b.c.sns_link_bg_color);
      if (getPress())
      {
        paramTextPaint.bgColor = i;
        AppMethodBeat.o(100052);
        return;
      }
      paramTextPaint.bgColor = 0;
      AppMethodBeat.o(100052);
    }
  }
  
  final class b
    extends u
  {
    b() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100053);
      BaseTimeLineItem.this.QBJ.RoS.RFw.onClick(paramView);
      AppMethodBeat.o(100053);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100054);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(b.c.sns_link_bg_color);
      if (getPress())
      {
        paramTextPaint.bgColor = i;
        AppMethodBeat.o(100054);
        return;
      }
      paramTextPaint.bgColor = 0;
      AppMethodBeat.o(100054);
    }
  }
  
  static final class c
    implements u.a
  {
    private WeakReference<bn> RLR;
    
    public c(bn parambn)
    {
      AppMethodBeat.i(308931);
      this.RLR = new WeakReference(parambn);
      AppMethodBeat.o(308931);
    }
    
    public final void onClick(View paramView, Object paramObject)
    {
      AppMethodBeat.i(308935);
      bn localbn = (bn)this.RLR.get();
      if ((localbn != null) && (localbn.RoO != null)) {
        if (!(paramObject instanceof com.tencent.mm.plugin.sns.data.d)) {
          break label87;
        }
      }
      label87:
      for (boolean bool = ((com.tencent.mm.plugin.sns.data.d)paramObject).isAd;; bool = false)
      {
        if (bool) {}
        for (localbn.RoO.source = 0;; localbn.RoO.source = 6)
        {
          localbn.RoO.onClick(paramView, paramObject);
          AppMethodBeat.o(308935);
          return;
        }
      }
    }
  }
  
  static final class d
    implements u.a
  {
    private WeakReference<bn> RLR;
    private String userName;
    
    public d(bn parambn, String paramString)
    {
      AppMethodBeat.i(308953);
      this.RLR = new WeakReference(parambn);
      this.userName = paramString;
      AppMethodBeat.o(308953);
    }
    
    public final void onClick(View paramView, Object paramObject)
    {
      AppMethodBeat.i(308956);
      bn localbn = (bn)this.RLR.get();
      if ((localbn != null) && (localbn.RoO != null))
      {
        localbn.RoO.source = 0;
        localbn.RoO.onClick(paramView, paramObject);
        ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210(this.userName, 6L);
      }
      AppMethodBeat.o(308956);
    }
  }
  
  final class e
    extends u
  {
    e() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100056);
      BaseTimeLineItem.this.QBJ.RoS.RFx.onClick(paramView);
      AppMethodBeat.o(100056);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100057);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(b.c.sns_link_bg_color);
      if (getPress())
      {
        paramTextPaint.bgColor = i;
        AppMethodBeat.o(100057);
        return;
      }
      paramTextPaint.bgColor = 0;
      AppMethodBeat.o(100057);
    }
  }
  
  static final class f
    implements g.d
  {
    private WeakReference<View> RLS;
    public CharSequence RLT;
    public int RLU;
    public int Rqx;
    public com.tencent.mm.plugin.sns.ui.l Ryx;
    public int deleteFlag;
    public CharSequence mGL;
    public String md5;
    
    public f(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, View paramView, int paramInt1, int paramInt2, com.tencent.mm.plugin.sns.ui.l paraml)
    {
      AppMethodBeat.i(308950);
      this.RLS = null;
      this.md5 = null;
      this.RLT = null;
      this.mGL = null;
      this.Rqx = 0;
      this.deleteFlag = 0;
      this.RLU = com.tencent.mm.ui.bd.fromDPToPix(MMApplicationContext.getContext(), 28);
      this.Ryx = null;
      this.RLS = new WeakReference(paramView);
      this.md5 = paramString;
      this.RLT = paramCharSequence1;
      this.mGL = paramCharSequence2;
      this.Rqx = paramInt1;
      this.deleteFlag = paramInt2;
      this.Ryx = paraml;
      AppMethodBeat.o(308950);
    }
    
    public final void j(Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(100059);
      Log.i("MicroMsg.BaseTimeLineItem", "onEmojiDecodeFin bitmapAvailable:%s, md5:%s", new Object[] { Boolean.valueOf(t.S(paramBitmap)), paramString });
      if ((this.RLS != null) && (this.RLS.get() != null) && ((this.RLS.get() instanceof SnsCommentCollapseLayout)))
      {
        SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.RLS.get();
        if ((localSnsCommentCollapseLayout != null) && (localSnsCommentCollapseLayout.getTag() != null) && ((localSnsCommentCollapseLayout.getTag() instanceof m)))
        {
          Object localObject = (m)localSnsCommentCollapseLayout.getTag();
          if ((((m)localObject).Qsv != null) && (!Util.isNullOrNil(((m)localObject).Qsv.abDm)) && (((m)localObject).Qsv.abDm.get(0) != null) && (Util.isEqual(paramString, ((feb)((m)localObject).Qsv.abDm.get(0)).Md5)) && (t.S(paramBitmap)))
          {
            paramBitmap = new BitmapDrawable(paramBitmap);
            paramBitmap.setBounds(0, 0, this.RLU, this.RLU);
            paramBitmap = new com.tencent.mm.ui.widget.a(paramBitmap, 1);
            MMApplicationContext.getContext();
            paramString = new u(this.md5, this.Ryx, 2);
            localObject = new SpannableStringBuilder(this.RLT);
            ((SpannableStringBuilder)localObject).append("  ").append(this.md5).append("  ").append(" ");
            int i = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 2 - 1;
            int j = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 4 - 1;
            ((SpannableStringBuilder)localObject).setSpan(paramBitmap, i, this.md5.length() + i, 33);
            ((SpannableStringBuilder)localObject).setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.mGL);
            localSpannableStringBuilder.append("  ").append(this.md5).append("  ").append(" ");
            i = localSpannableStringBuilder.length() - this.md5.length() - 2 - 1;
            j = localSpannableStringBuilder.length() - this.md5.length() - 4 - 1;
            localSpannableStringBuilder.setSpan(paramBitmap, i, this.md5.length() + i, 33);
            localSpannableStringBuilder.setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            localSnsCommentCollapseLayout.a((CharSequence)localObject, localSpannableStringBuilder, this.Rqx, this.deleteFlag);
          }
        }
      }
      AppMethodBeat.o(100059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
 * JD-Core Version:    0.7.0.1
 */
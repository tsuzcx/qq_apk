package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
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
import com.tencent.mm.f.b.a.kt;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.at.b;
import com.tencent.mm.plugin.sns.model.av.a;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.g.5;
import com.tencent.mm.plugin.sns.model.g.d;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.ah;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bm.c;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.plugin.sns.ui.bt;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.i.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.g.b.p;

public abstract class BaseTimeLineItem
{
  public boolean DEBUG = false;
  protected boolean KOn = false;
  private av.a KaZ = new av.a()
  {
    public final void bK(LinkedList<String> paramAnonymousLinkedList)
    {
      AppMethodBeat.i(198458);
      com.tencent.mm.plugin.sns.model.av.KaZ = null;
      BaseTimeLineItem.b(BaseTimeLineItem.this).setVisibility(0);
      BaseTimeLineItem.a(BaseTimeLineItem.this, BaseTimeLineItem.b(BaseTimeLineItem.this), paramAnonymousLinkedList);
      AppMethodBeat.o(198458);
    }
  };
  public bm Kee;
  private ViewGroup LkE;
  private StoryAvatarDotsView LkF;
  public ArrayList<at.b> LkG = new ArrayList();
  public Activity mActivity;
  private final com.tencent.mm.pluginsdk.ui.span.a mAdTagClickCallback = new com.tencent.mm.pluginsdk.ui.span.a()
  {
    public final void jU(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(215429);
      if (paramAnonymousInt1 < 0) {}
      try
      {
        Log.e("AdTagClickableHelper", "BaseTimeLineItem, position < 0");
        AppMethodBeat.o(215429);
        return;
      }
      catch (Throwable localThrowable)
      {
        SnsInfo localSnsInfo;
        Log.e("AdTagClickableHelper", localThrowable.toString());
        AppMethodBeat.o(215429);
        return;
      }
      localSnsInfo = BaseTimeLineItem.this.Kee.agM(paramAnonymousInt1);
      if (localSnsInfo != null)
      {
        Log.i("AdTagClickableHelper", "BaseTimeLineItem position = " + paramAnonymousInt1 + ", snsId = " + localSnsInfo.field_snsId + ", source = SOURCE_TIMELINE , clickPos = " + paramAnonymousInt2);
        com.tencent.mm.plugin.sns.ad.timeline.b.c.a(BaseTimeLineItem.this.mActivity, 0, localSnsInfo, paramAnonymousInt2);
        AppMethodBeat.o(215429);
        return;
      }
      Log.e("AdTagClickableHelper", "BaseTimeLineItem, snsInfo is null");
      AppMethodBeat.o(215429);
    }
  };
  protected int viewType;
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, ejo paramejo)
  {
    if ((paramView instanceof SnsCommentCollapseLayout)) {
      ((SnsCommentCollapseLayout)paramView).a(paramCharSequence1, paramCharSequence2, paramInt1, paramInt2);
    }
    for (;;)
    {
      paramCharSequence1 = com.tencent.mm.plugin.sns.i.a.KeP;
      com.tencent.mm.plugin.sns.i.a.a.a(paramView, paramejo);
      return;
      if ((paramView instanceof TextView)) {
        ((TextView)paramView).setText(paramCharSequence1);
      }
    }
  }
  
  public static void a(at.b paramb, BaseViewHolder paramBaseViewHolder, String paramString1, String paramString2)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.LkP != null))
    {
      paramBaseViewHolder.LkP.a(paramb, 1, paramString1, paramString2, paramb.Kaj);
      paramBaseViewHolder.LkP.setVisibility(0);
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
          paramBaseViewHolder.Lla.getTextSize();
          localObject2 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.e((Context)localObject2, (CharSequence)localObject1, 1));
          ((com.tencent.mm.pluginsdk.ui.span.m)localObject2).a(null, (CharSequence)localObject1, 0);
          localObject1 = paramBaseViewHolder.Lla.getPaint();
          float f = Layout.getDesiredWidth((CharSequence)localObject2, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject2).length(), (TextPaint)localObject1);
          if (com.tencent.mm.ci.a.H(this.mActivity, (int)f) > paramBaseViewHolder.KPl)
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
              paramBaseViewHolder.Lla.getTextSize();
              localObject3 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.e((Context)localObject3, (CharSequence)localObject2, 1));
              ((com.tencent.mm.pluginsdk.ui.span.m)localObject3).a(null, (CharSequence)localObject2, 0);
              f = Layout.getDesiredWidth((CharSequence)localObject3, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject3).length(), (TextPaint)localObject1);
              i = com.tencent.mm.ci.a.H(this.mActivity, (int)f);
              paramBaseViewHolder.Lla.setText((CharSequence)localObject3, TextView.BufferType.SPANNABLE);
              paramBaseViewHolder.Lla.setVisibility(0);
            } while (i > paramBaseViewHolder.KPl);
            return;
          }
          paramBaseViewHolder.Lla.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
          paramBaseViewHolder.Lla.setVisibility(0);
          return;
        }
      }
      catch (Throwable paramADInfo)
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
          localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.b(this.mActivity, (CharSequence)localObject, paramMaskTextView.getTextSize()));
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
      Log.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[] { Util.stackTraceToString(paramMaskTextView) });
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
    locala.Yal = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
    localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
    if (paramInt == 10)
    {
      paramInt = 3;
      break label411;
      while (i < arrayOfInt1.length)
      {
        localSpannableStringBuilder.setSpan(new q((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), this.Kee.KPc, paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
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
  
  private static void a(BaseViewHolder paramBaseViewHolder, SnsInfo paramSnsInfo)
  {
    if (paramSnsInfo.isAd())
    {
      if (paramBaseViewHolder.LkO != null) {
        paramBaseViewHolder.LkO.setVisibility(0);
      }
      paramBaseViewHolder.LkQ.setLongClickable(false);
      paramBaseViewHolder.LkQ.setOnClickListener(null);
      paramSnsInfo = new LinearLayout.LayoutParams(-1, -2);
      paramBaseViewHolder.LkQ.setLayoutParams(paramSnsInfo);
      paramBaseViewHolder.LkQ.setBackgroundColor(Color.parseColor("#00ffffff"));
      if (paramBaseViewHolder.Lll != null)
      {
        paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.Lll.getLayoutParams();
        paramSnsInfo.leftMargin = 0;
        paramSnsInfo.rightMargin = 0;
        paramBaseViewHolder.Lll.setLayoutParams(paramSnsInfo);
      }
      if (paramBaseViewHolder.LlJ)
      {
        paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.JKG.KKj.getLayoutParams();
        paramSnsInfo.leftMargin = 0;
        paramSnsInfo.rightMargin = 0;
        paramBaseViewHolder.JKG.KKj.setLayoutParams(paramSnsInfo);
      }
      return;
    }
    if (paramBaseViewHolder.LkO != null) {
      paramBaseViewHolder.LkO.setVisibility(0);
    }
    paramBaseViewHolder.LkQ.setLongClickable(false);
    paramBaseViewHolder.LkQ.setOnClickListener(null);
    if (paramBaseViewHolder.Lll != null)
    {
      paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.Lll.getLayoutParams();
      paramSnsInfo.leftMargin = 0;
      paramSnsInfo.rightMargin = 0;
      paramBaseViewHolder.Lll.setLayoutParams(paramSnsInfo);
    }
    if (paramBaseViewHolder.LlJ)
    {
      paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.JKG.KKj.getLayoutParams();
      paramSnsInfo.leftMargin = 0;
      paramSnsInfo.rightMargin = 0;
      paramBaseViewHolder.JKG.KKj.setLayoutParams(paramSnsInfo);
    }
    paramSnsInfo = new LinearLayout.LayoutParams(-1, -2);
    paramBaseViewHolder.LkQ.setLayoutParams(paramSnsInfo);
    paramBaseViewHolder.LkQ.setBackgroundColor(Color.parseColor("#00ffffff"));
  }
  
  private void a(StoryAvatarDotsView paramStoryAvatarDotsView, List<String> paramList)
  {
    paramStoryAvatarDotsView.setIconSize(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 20));
    paramStoryAvatarDotsView.setIconGap(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 24));
    if (paramList.size() > 0)
    {
      paramStoryAvatarDotsView.setVisibility(0);
      paramStoryAvatarDotsView.setIconLayerCount(Math.min(paramList.size(), 3));
      int i = 0;
      while (i < paramStoryAvatarDotsView.getChildCount())
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(paramStoryAvatarDotsView.Dt(i), (String)paramList.get(i), 0.1F, false);
        paramStoryAvatarDotsView.Dt(i).setPadding(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 1), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 1), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 1), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 1));
        i += 1;
      }
    }
    paramStoryAvatarDotsView.setVisibility(8);
  }
  
  private boolean a(List<ejo> paramList, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, BaseViewHolder paramBaseViewHolder, bn parambn, int paramInt, SnsInfo paramSnsInfo)
  {
    LinearLayout localLinearLayout = paramBaseViewHolder.Llh;
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
          this.Kee.a((SnsCommentCollapseLayout)localObject1);
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
    String str2;
    String str3;
    Object localObject4;
    Object localObject6;
    Object localObject5;
    if (m < paramb.size())
    {
      localObject1 = (com.tencent.mm.vending.j.a)paramb.get(m);
      l = ((Long)((com.tencent.mm.vending.j.a)localObject1).get(0)).longValue();
      str1 = (String)((com.tencent.mm.vending.j.a)localObject1).get(1);
      str2 = (String)((com.tencent.mm.vending.j.a)localObject1).get(2);
      str3 = (String)((com.tencent.mm.vending.j.a)localObject1).get(3);
      localObject4 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(4);
      localObject6 = (String)((com.tencent.mm.vending.j.a)localObject1).get(5);
      localObject5 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(6);
      if (Util.isNullOrNil((String)localObject6)) {
        break label2239;
      }
      j = 1;
      localStringBuilder2.append(l).append("|");
    }
    for (;;)
    {
      localStringBuilder1.append(l).append("|");
      ejo localejo = (ejo)paramList.get(m);
      i = localejo.Ulr;
      int i2 = localejo.DeleteFlag;
      Object localObject7 = bu(paramBaseViewHolder.fLp, l);
      if ((localObject7 != null) && (((at.b)localObject7).lAQ)) {
        at.ge(((at.b)localObject7).id, 2);
      }
      label480:
      int n;
      Object localObject2;
      if (k >= i1) {
        if ((localObject7 == null) || (((at.b)localObject7).lAQ))
        {
          localObject1 = this.Kee.fXc();
          ((SnsCommentCollapseLayout)localObject1).ar(15.0F * com.tencent.mm.ci.a.ez(((View)localObject1).getContext()));
          if (this.Kee.KYt == -1) {
            this.Kee.KYt = this.mActivity.getResources().getColor(i.c.sns_comment_color);
          }
          ((SnsCommentCollapseLayout)localObject1).setTextColor(this.Kee.KYt);
          ((SnsCommentCollapseLayout)localObject1).setGravity(16);
          n = 1;
          localObject2 = localObject1;
        }
      }
      label723:
      Object localObject8;
      label787:
      Object localObject3;
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
            ((TranslateCommentTextView)localObject1).getTranslateResultView().ci(15.0F * com.tencent.mm.ci.a.ez(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.ci.a.ez(((View)localObject1).getContext()));
          }
          localObject6 = (TranslateCommentTextView)localObject1;
          ((View)localObject1).setOnTouchListener(null);
          a(((TranslateCommentTextView)localObject6).getOriginCommentTextView(), (CharSequence)localObject5, (CharSequence)localObject4, i, i2, localejo);
          if (!((at.b)localObject7).lwF)
          {
            ((TranslateCommentTextView)localObject6).LfZ.setTextSize(1, 15.0F * com.tencent.mm.ci.a.ez(((TranslateCommentTextView)localObject6).getContext()));
            ((TranslateCommentTextView)localObject6).KQw.aht(2);
            ((TranslateCommentTextView)localObject6).KQw.setVisibility(0);
            i = 1;
            if (k <= 0) {
              break label1932;
            }
            ((View)localObject1).setPadding(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 4), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 3));
            if (k != paramb.size() - 1) {
              break label1921;
            }
            ((View)localObject1).setBackgroundResource(i.e.sns_timeline_comment_bg_bottom);
            if (i != 0)
            {
              localObject2 = (TranslateCommentTextView)localObject1;
              i = (int)this.mActivity.getResources().getDimension(i.d.SmallPadding);
              ((TranslateCommentTextView)localObject2).KQw.getSplitlineView().setPadding(0, 0, i, 0);
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.e.c(localejo)) {
              break label2038;
            }
            ((View)localObject1).setOnLongClickListener(null);
            ((View)localObject1).setOnClickListener(null);
            if (parambn != null) {
              ((View)localObject1).setTag(new com.tencent.mm.plugin.sns.ui.m(parambn.KDB, parambn.JyZ, localejo, str1, str3, (View)localObject1, 1, parambn.pRV));
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
            ((TranslateCommentTextView)localObject1).getTranslateResultView().ci(15.0F * com.tencent.mm.ci.a.ez(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.ci.a.ez(((View)localObject1).getContext()));
            break label480;
            localObject2 = localLinearLayout.getChildAt(k);
            n = 0;
            continue;
          }
          if (!((at.b)localObject7).lAQ)
          {
            localObject4 = ((at.b)localObject7).result;
            localObject5 = ((at.b)localObject7).brand;
            localObject8 = ((TranslateCommentTextView)localObject6).LfZ.getText().toString();
            if (!Util.isNullOrNil((String)localObject8))
            {
              localObject2 = ((String)localObject8).split(":");
              if (localObject2.length <= 2) {
                break label2236;
              }
              localObject3 = new String[2];
              localObject3[0] = localObject2[0];
              localObject3[1] = ((String)localObject8).substring(localObject3[0].length() + 1);
              localObject2 = localObject3;
            }
          }
        }
      }
      label1921:
      label1932:
      label2236:
      for (;;)
      {
        if (localObject2.length == 2)
        {
          if (Util.isNullOrNil((String)localObject4)) {
            break label1139;
          }
          ((TranslateCommentTextView)localObject6).KQw.a((at.b)localObject7, 2, localObject2[0] + ": " + (String)localObject4, (String)localObject5, ((at.b)localObject7).Kaj);
        }
        for (;;)
        {
          ((TranslateCommentTextView)localObject6).KQw.setVisibility(0);
          ((TranslateCommentTextView)localObject6).LfZ.setTextSize(1, 15.0F * com.tencent.mm.ci.a.ez(((TranslateCommentTextView)localObject6).getContext()));
          i = 1;
          break;
          label1139:
          ((TranslateCommentTextView)localObject6).KQw.a((at.b)localObject7, 2, null, (String)localObject5, ((at.b)localObject7).Kaj);
        }
        ((TranslateCommentTextView)localObject6).getTranslateResultView().setVisibility(8);
        i = 1;
        break;
        if ((n == 0) && ((localObject2 instanceof TranslateCommentTextView)))
        {
          localLinearLayout.removeView((View)localObject2);
          localObject1 = this.Kee.fXc();
          localLinearLayout.addView((View)localObject1, k);
          ((SnsCommentCollapseLayout)localObject1).ar(15.0F * com.tencent.mm.ci.a.ez(((View)localObject1).getContext()));
        }
        for (;;)
        {
          if ((localObject1 instanceof SnsCommentCollapseLayout))
          {
            ((SnsCommentCollapseLayout)localObject1).ar(15.0F * com.tencent.mm.ci.a.ez(((View)localObject1).getContext()));
            ((SnsCommentCollapseLayout)localObject1).setOpClickListener(this.Kee.KYJ);
            localObject2 = new com.tencent.mm.pluginsdk.ui.span.o(this.mActivity);
            ((com.tencent.mm.pluginsdk.ui.span.o)localObject2).setAdTagClickCallback(null, -1);
            if (com.tencent.mm.plugin.sns.ui.widget.e.b(paramSnsInfo, localejo.Username))
            {
              ((com.tencent.mm.pluginsdk.ui.span.o)localObject2).setAdTagClickCallback(this.mAdTagClickCallback, paramInt);
              ((com.tencent.mm.pluginsdk.ui.span.o)localObject2).mAdTagClickScene = 31;
            }
            ((SnsCommentCollapseLayout)localObject1).setPressTouchListener((View.OnTouchListener)localObject2);
          }
          localObject3 = new CharSequence[2];
          localObject3[0] = localObject5;
          localObject3[1] = localObject4;
          localObject1.hashCode();
          if ((Util.isNullOrNil((String)localObject6)) || (!(localObject1 instanceof SnsCommentCollapseLayout)))
          {
            ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).tryAttachStatusIconSpan((View)localObject1, (CharSequence)localObject4);
            a((View)localObject1, localObject3[0], localObject3[1], i, i2, localejo);
            i = 0;
            break;
          }
          localObject2 = aj.fOF();
          localObject7 = new d((String)localObject6, (CharSequence)localObject5, (CharSequence)localObject4, (View)localObject1, i, i2, this.Kee.KYx);
          localObject8 = com.tencent.mm.emoji.loader.a.b.jGQ;
          localObject8 = com.tencent.mm.emoji.loader.a.b.LI((String)localObject6);
          if (localObject8 == null) {
            aj.fOv().execute(new g.5((com.tencent.mm.plugin.sns.model.g)localObject2, (String)localObject6, (g.d)localObject7));
          }
          int i3 = aw.fromDPToPix(this.mActivity, 28);
          localObject6 = new StringBuilder((String)localObject6);
          if (localObject8 == null)
          {
            ((StringBuilder)localObject6).append("miss");
            Log.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s miss cache", new Object[] { ((StringBuilder)localObject6).toString() });
          }
          for (localObject2 = this.mActivity.getResources().getDrawable(i.e.sns_emoji_download_icon);; localObject2 = new BitmapDrawable((Bitmap)localObject8))
          {
            localObject5 = new SpannableStringBuilder((CharSequence)localObject5);
            ((SpannableStringBuilder)localObject5).append("  ").append(((StringBuilder)localObject6).toString()).append("  ").append(" ");
            int i4 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 2 - 1;
            int i5 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 4 - 1;
            ((Drawable)localObject2).setBounds(0, 0, i3, i3);
            localObject7 = new com.tencent.mm.ui.widget.a((Drawable)localObject2, 1);
            localObject8 = new q(((StringBuilder)localObject6).toString(), this.Kee.KYx, 2);
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
          ((View)localObject1).setBackgroundResource(i.e.sns_clickable_bg);
          break label723;
          ((View)localObject1).setPadding(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 6), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 3));
          if (paramBaseViewHolder.Llg)
          {
            if (paramb.size() == 1)
            {
              ((View)localObject1).setBackgroundResource(i.e.sns_timeline_comment_bg_bottom);
              break label723;
            }
            ((View)localObject1).setBackgroundResource(i.e.sns_clickable_bg);
            break label723;
          }
          if (paramb.size() == 1)
          {
            ((View)localObject1).setBackgroundResource(i.e.sns_timeline_comment_bg);
            break label723;
          }
          ((View)localObject1).setBackgroundResource(i.e.sns_timeline_comment_bg_top);
          break label723;
          label2038:
          ((View)localObject1).setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(197140);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$12", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              localObject = new int[2];
              if ((paramAnonymousView.getTag(i.f.touch_loc) instanceof int[])) {}
              for (paramAnonymousView = (int[])paramAnonymousView.getTag(i.f.touch_loc);; paramAnonymousView = (View)localObject)
              {
                BaseTimeLineItem.this.Kee.fXi().a(this.LfI, BaseTimeLineItem.this.Kee.Kdz.Lpc, BaseTimeLineItem.this.Kee.Kdz.LoP, paramAnonymousView[0], paramAnonymousView[1]);
                com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$12", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(197140);
                return true;
              }
            }
          });
          ((View)localObject1).setOnClickListener(new i.a(this.Kee.KYo, localejo, str2, str3, paramBaseViewHolder));
          break label787;
          if (i != 0)
          {
            paramList = com.tencent.mm.plugin.sns.k.g.Kia;
            paramInt = paramBaseViewHolder.position;
            l = parambn.Jws.field_snsId;
            paramb = localStringBuilder2.toString();
            paramSnsInfo = localStringBuilder1.toString();
            paramBaseViewHolder = t.Qu(l);
            if (paramList.Kin.get(paramBaseViewHolder) == null)
            {
              parambn = new kt();
              parambn.gOX = parambn.z("PublishId", paramBaseViewHolder, true);
              parambn.gOY = parambn.z("CommentIdList", paramSnsInfo, true);
              parambn.gOZ = parambn.z("EmojiIdList", paramb, true);
              paramb = new com.tencent.mm.plugin.sns.k.g.a(paramList);
              paramb.position = paramInt;
              paramb.KiX = parambn;
              paramList.Kin.put(paramBaseViewHolder, paramb);
            }
          }
          return true;
          localObject1 = localObject2;
        }
      }
      label2239:
      j = i;
    }
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, SnsInfo paramSnsInfo)
  {
    paramBaseViewHolder.Lmc.setVisibility(8);
    Object localObject1;
    Object localObject2;
    if ((this.Kee != null) && (this.Kee.KYB))
    {
      localObject1 = aj.fOQ();
      long l = paramSnsInfo.field_snsId;
      localObject2 = "select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.bottom<=" + l + " AND SnsWsFoldGroup.top>=" + l;
      localObject2 = ((x)localObject1).lvy.rawQuery((String)localObject2, null, 2);
      if (localObject2 == null) {
        break label518;
      }
      if (!((Cursor)localObject2).moveToFirst()) {
        break label512;
      }
      localObject1 = new w();
      ((w)localObject1).convertFrom((Cursor)localObject2);
      ((Cursor)localObject2).close();
    }
    for (;;)
    {
      String str1;
      String str2;
      int i;
      if (localObject1 != null)
      {
        str1 = t.Qv(((w)localObject1).field_top);
        str2 = t.Qv(((w)localObject1).field_bottom);
        Object localObject3 = aj.fOI();
        localObject2 = n.fSM();
        if (str1 != null)
        {
          localObject1 = localObject2;
          if (str1.equals("")) {}
        }
        else
        {
          localObject1 = (String)localObject2 + " AND " + ((n)localObject3).bbB(str1);
        }
        localObject2 = localObject1;
        if (n.bbw(str2)) {
          localObject2 = (String)localObject1 + " AND " + ((n)localObject3).bbx(str2);
        }
        localObject1 = (String)localObject2 + n.KzD;
        Log.d("MicroMsg.SnsInfoStorage", "getCursorByTimeLineSeqIncluded ".concat(String.valueOf(localObject1)));
        localObject1 = ((n)localObject3).lvy.rawQuery((String)localObject1, null);
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
        ((StringBuilder)localObject1).append("snsid:").append(t.Qv(paramSnsInfo.field_snsId)).append("\n");
        ((StringBuilder)localObject1).append("indexInGroup:").append(i);
        paramBaseViewHolder.Lmc.setText(((StringBuilder)localObject1).toString());
        paramBaseViewHolder.Lmc.setVisibility(0);
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
  
  private at.b bu(String paramString, long paramLong)
  {
    if (this.LkG.size() <= 0) {
      return null;
    }
    Iterator localIterator = this.LkG.iterator();
    while (localIterator.hasNext())
    {
      at.b localb = (at.b)localIterator.next();
      if ((localb.id != null) && (localb.id.equals(at.kE(paramString, String.valueOf(paramLong))))) {
        return localb;
      }
    }
    return null;
  }
  
  public static ViewStub h(BaseViewHolder paramBaseViewHolder)
  {
    return paramBaseViewHolder.LkR;
  }
  
  public static void i(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.LkP != null))
    {
      paramBaseViewHolder.LkP.aht(1);
      paramBaseViewHolder.LkP.setVisibility(0);
    }
  }
  
  public static void j(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.LkP != null)) {
      paramBaseViewHolder.LkP.setVisibility(8);
    }
  }
  
  public final View a(Activity paramActivity, final BaseViewHolder paramBaseViewHolder, int paramInt, final bm parambm, SnsInfo paramSnsInfo)
  {
    this.mActivity = paramActivity;
    this.viewType = paramInt;
    this.Kee = parambm;
    paramBaseViewHolder.fLp = paramSnsInfo.getSnsId();
    Object localObject;
    View localView;
    switch (paramInt)
    {
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 22: 
    case 25: 
    default: 
      localObject = "R.layout.sns_media_sub_item2";
      com.tencent.mm.kiss.a.b.aIK();
      localView = com.tencent.mm.kiss.a.b.d(this.mActivity, i.g.sns_timeline_item_photo_one3);
      paramBaseViewHolder.LlS = localView;
      paramBaseViewHolder.LlR = ((String)localObject);
      localObject = localView.findViewById(i.f.images_keeper_li);
      if (!(localObject instanceof ViewStub)) {
        break;
      }
    }
    for (paramBaseViewHolder.LkR = ((ViewStub)localObject);; paramBaseViewHolder.LkR = null)
    {
      Log.i("MicroMsg.BaseTimeLineItem", "create new item  " + paramInt + "  " + localView.hashCode());
      paramBaseViewHolder.LlK = localView.findViewById(i.f.sns_timeline_content);
      paramBaseViewHolder.viewType = paramInt;
      paramBaseViewHolder.LkK = ((SnsAvatarImageView)localView.findViewById(i.f.album_avatar_iv));
      paramBaseViewHolder.LkK.setWeakContext(paramActivity);
      paramBaseViewHolder.LkK.setOnClickListener(parambm.Kdz.LoQ);
      paramBaseViewHolder.LkK.setOnLongClickListener(parambm.Kdz.LoR);
      paramBaseViewHolder.LkK.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(100046);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            int i = (int)paramAnonymousMotionEvent.getRawX();
            int j = (int)paramAnonymousMotionEvent.getRawY();
            paramAnonymousView.setTag(i.f.touch_loc, new int[] { i, j });
          }
          AppMethodBeat.o(100046);
          return false;
        }
      });
      paramBaseViewHolder.LkL = ((AsyncTextView)localView.findViewById(i.f.nickname_tv));
      paramBaseViewHolder.LkM = ((ImageView)localView.findViewById(i.f.type_desc_tv));
      paramBaseViewHolder.LkL.setOnTouchListener(new ah());
      paramBaseViewHolder.LkN = ((ViewGroup)localView.findViewById(i.f.nick_type_ll));
      paramBaseViewHolder.LkO = ((AsyncNormalTextView)localView.findViewById(i.f.desc_collapse_tv));
      paramBaseViewHolder.LkO.setOpClickListener(parambm.KYG);
      paramBaseViewHolder.LkO.setShrinkOrSpreadListener(parambm.KYH);
      paramBaseViewHolder.LkQ = ((LinearLayout)localView.findViewById(i.f.images_keeper_linear_layout));
      paramBaseViewHolder.LkQ.setTag(paramBaseViewHolder);
      paramBaseViewHolder.LkQ.setOnClickListener(parambm.Kdz.LpB);
      localObject = localView.findViewById(i.f.desc_tv);
      parambm.fXi().c((View)localObject, parambm.Kdz.LoS, parambm.Kdz.LoP);
      localObject = (TextView)localView.findViewById(i.f.desc_tv_single);
      parambm.fXi().c((View)localObject, parambm.Kdz.LoS, parambm.Kdz.LoP);
      paramBaseViewHolder.LkP = ((SnsTranslateResultView)localView.findViewById(i.f.sns_translate_result_view));
      paramBaseViewHolder.LkP.setVisibility(8);
      paramBaseViewHolder.LkP.getSplitlineView().setPadding(0, 0, 0, 0);
      paramBaseViewHolder.LkP.getResultTextView().setBackgroundResource(i.e.sns_clickable_bg);
      parambm.fXi().c(paramBaseViewHolder.LkP.getResultTextView(), parambm.Kdz.LoS, parambm.Kdz.LoP);
      paramBaseViewHolder.Llk = ((LinearLayout)localView.findViewById(i.f.comment_ll));
      paramBaseViewHolder.LkY = ((TextView)localView.findViewById(i.f.with_info_tv));
      paramBaseViewHolder.timeTv = ((TextView)localView.findViewById(i.f.album_publish_time));
      paramBaseViewHolder.Lla = ((AsyncTextView)localView.findViewById(i.f.album_ad_tail_desc));
      paramBaseViewHolder.Llb = ((AsyncTextView)localView.findViewById(i.f.album_ad_at_tail));
      paramBaseViewHolder.KWo = ((TextView)localView.findViewById(i.f.album_address));
      paramBaseViewHolder.JPW = new bt(localView, parambm.KYo.KBN, 0, new c.b()
      {
        public final void fLc()
        {
          AppMethodBeat.i(244205);
          if (parambm.Kdz != null) {
            parambm.Kdz.a(paramBaseViewHolder, null);
          }
          AppMethodBeat.o(244205);
        }
        
        public final ViewGroup fLd()
        {
          if ((paramBaseViewHolder instanceof a.a)) {
            return ((a.a)paramBaseViewHolder).uyC;
          }
          if ((paramBaseViewHolder instanceof h.a)) {
            return (ViewGroup)((h.a)paramBaseViewHolder).Lnh.xYJ;
          }
          if ((paramBaseViewHolder instanceof g.a)) {
            return (ViewGroup)((g.a)paramBaseViewHolder).xYJ;
          }
          return null;
        }
      });
      paramBaseViewHolder.JPW.b(parambm.Kdz.Lpa, parambm.Kdz.Lpq);
      paramBaseViewHolder.LkX = ((RelativeLayout)localView.findViewById(i.f.openim_tag_ll));
      paramBaseViewHolder.LkX.setOnClickListener(parambm.Kdz.Lpt);
      paramBaseViewHolder.KEn = ((TextView)localView.findViewById(i.f.album_del));
      paramBaseViewHolder.KEn.setText(paramActivity.getString(i.j.app_delete));
      paramBaseViewHolder.KEn.setContentDescription(paramActivity.getString(i.j.app_delete));
      paramBaseViewHolder.KEn.setOnClickListener(parambm.Kdz.LoU);
      paramBaseViewHolder.Lla.setOnClickListener(parambm.Kdz.Lpr);
      paramBaseViewHolder.Llb.setOnClickListener(parambm.Kdz.Lps);
      paramBaseViewHolder.KWo.setOnClickListener(parambm.Kdz.Lpn);
      paramBaseViewHolder.Llc = localView.findViewById(i.f.album_groupid);
      paramBaseViewHolder.Llc.setOnClickListener(parambm.Kdz.LoZ);
      paramBaseViewHolder.LkZ = ((WeImageView)localView.findViewById(i.f.album_type_icon));
      paramBaseViewHolder.mrL = ((TextView)localView.findViewById(i.f.album_from));
      paramBaseViewHolder.Lld = ((ImageView)localView.findViewById(i.f.album_show_comment_tv));
      paramBaseViewHolder.Lln = ((ViewStub)localView.findViewById(i.f.album_comment_stub));
      paramBaseViewHolder.KAX = ((LinearLayout)localView.findViewById(i.f.album_list_fatherview));
      paramBaseViewHolder.LlM = ((ViewStub)localView.findViewById(i.f.album_hb_reward));
      paramBaseViewHolder.LlU = ((ViewStub)localView.findViewById(i.f.sns_unread_tip_stub));
      paramBaseViewHolder.LlZ = ((ViewStub)localView.findViewById(i.f.sns_retry_edit_tip_stub));
      paramBaseViewHolder.mCC = ((ViewGroup)localView.findViewById(i.f.sns_item_content_root));
      paramBaseViewHolder.Llp = ((ViewStub)localView.findViewById(i.f.sns_post_error_stub));
      paramBaseViewHolder.LkT = ((TextView)localView.findViewById(i.f.game_more_tv));
      paramBaseViewHolder.LkT.setOnClickListener(parambm.Kdz.LoV);
      BaseViewHolder.a(paramBaseViewHolder, (TextView)localView.findViewById(i.f.hb_tip));
      paramBaseViewHolder.Lmc = ((TextView)localView.findViewById(i.f.sns_ws_fold_debug_tv));
      paramBaseViewHolder.convertView = localView;
      paramBaseViewHolder.Lmd = localView.findViewById(i.f.sns_timeline_loading_end);
      if (this.KOn)
      {
        com.tencent.mm.plugin.sns.abtest.c.b(localView, paramBaseViewHolder);
        com.tencent.mm.plugin.sns.abtest.a.a(localView, paramBaseViewHolder);
        aj.fOz();
        com.tencent.mm.plugin.sns.h.c.c(localView, paramBaseViewHolder);
      }
      a(paramBaseViewHolder.LkR, paramBaseViewHolder);
      localView.setTag(paramBaseViewHolder);
      a(paramBaseViewHolder, paramSnsInfo);
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
  
  public abstract void a(ViewStub paramViewStub, BaseViewHolder paramBaseViewHolder);
  
  public final void a(bn parambn, TimeLineObject paramTimeLineObject)
  {
    if ((parambn == null) || (paramTimeLineObject == null)) {}
    for (;;)
    {
      return;
      if (paramTimeLineObject.AppInfo == null) {}
      for (String str = null; !Util.isNullOrNil(str); str = paramTimeLineObject.AppInfo.Id)
      {
        com.tencent.mm.plugin.sns.c.a.mIH.a(str, paramTimeLineObject.UserName, paramTimeLineObject.ContentObj.Sqq, paramTimeLineObject.statisticsData, parambn.Lbm);
        return;
      }
    }
  }
  
  public final void a(final BaseViewHolder paramBaseViewHolder, int paramInt1, SnsInfo paramSnsInfo, TimeLineObject paramTimeLineObject, int paramInt2, final bm parambm, bn parambn)
  {
    a(paramBaseViewHolder, paramSnsInfo);
    this.viewType = paramInt2;
    this.Kee = parambm;
    if (this.KOn) {
      com.tencent.mm.plugin.sns.ui.a.c.aa(paramSnsInfo);
    }
    com.tencent.mm.plugin.sns.ui.a.c.g(paramTimeLineObject);
    com.tencent.mm.plugin.sns.ui.a.c.f(paramTimeLineObject);
    if (paramSnsInfo.isAd()) {
      Log.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + t.Qv(paramSnsInfo.field_snsId) + " for susan");
    }
    paramBaseViewHolder.LkI = parambn.Lbm;
    paramBaseViewHolder.CIn = false;
    paramBaseViewHolder.position = paramInt1;
    paramBaseViewHolder.fLp = parambn.JyZ;
    paramBaseViewHolder.fAg = parambn.KDB;
    paramBaseViewHolder.LkJ = parambn.Lbq;
    paramBaseViewHolder.Lld.setOnClickListener(parambm.KYF);
    paramBaseViewHolder.timeLineObject = paramTimeLineObject;
    Object localObject2 = parambn.Jwr;
    paramBaseViewHolder.snsobj = ((SnsObject)localObject2);
    Object localObject1 = parambm.KYo.KBO.JZd;
    Object localObject3;
    if (paramSnsInfo != null)
    {
      localObject3 = paramSnsInfo.getLocalid();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Khy.add(localObject3);
      if (paramSnsInfo.isAd()) {
        ((com.tencent.mm.plugin.sns.k.d)localObject1).KhD.add(localObject3);
      }
      ((com.tencent.mm.plugin.sns.k.d)localObject1).KhE.add(paramSnsInfo.field_userName);
    }
    int i;
    label623:
    Object localObject4;
    switch (paramSnsInfo.field_type)
    {
    default: 
      ((com.tencent.mm.plugin.sns.k.d)localObject1).KhJ.add(localObject3);
      if (paramInt1 < ((com.tencent.mm.plugin.sns.k.d)localObject1).Khw)
      {
        ((com.tencent.mm.plugin.sns.k.d)localObject1).Khw = paramInt1;
        ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgb = t.w(paramSnsInfo);
      }
      if (paramInt1 > ((com.tencent.mm.plugin.sns.k.d)localObject1).Khx)
      {
        ((com.tencent.mm.plugin.sns.k.d)localObject1).Khx = paramInt1;
        ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgc = t.w(paramSnsInfo);
      }
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgh = ((com.tencent.mm.plugin.sns.k.d)localObject1).Khz.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgi = ((com.tencent.mm.plugin.sns.k.d)localObject1).KhA.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgj = ((com.tencent.mm.plugin.sns.k.d)localObject1).KhB.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgl = ((com.tencent.mm.plugin.sns.k.d)localObject1).KhC.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgk = ((com.tencent.mm.plugin.sns.k.d)localObject1).KhD.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgm = ((com.tencent.mm.plugin.sns.k.d)localObject1).KhH.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgu = ((com.tencent.mm.plugin.sns.k.d)localObject1).KhI.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).sxZ = ((com.tencent.mm.plugin.sns.k.d)localObject1).KhE.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgf = ((com.tencent.mm.plugin.sns.k.d)localObject1).KhF.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgg = ((com.tencent.mm.plugin.sns.k.d)localObject1).KhG.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).Kgt = ((com.tencent.mm.plugin.sns.k.d)localObject1).KhJ.size();
      ((com.tencent.mm.plugin.sns.k.d)localObject1).KfP = ((com.tencent.mm.plugin.sns.k.d)localObject1).Khy.size();
      localObject3 = parambn.JEd;
      localObject1 = parambn.pRV;
      paramBaseViewHolder.LkO.setAdTagClickCallback(null, -1);
      if (com.tencent.mm.plugin.sns.ad.timeline.b.c.ag(parambn.KBz, paramInt2)) {
        paramBaseViewHolder.LkO.setAdTagClickCallback(this.mAdTagClickCallback, paramInt1);
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramBaseViewHolder.KBD = parambn.Lbl;
        paramBaseViewHolder.LkK.setTag(localObject1);
        if (paramBaseViewHolder.KBD != null) {
          if ((com.tencent.mm.storage.as.bvK((String)localObject1)) && ("3552365301".equals(paramBaseViewHolder.KBD.field_openImAppid)))
          {
            i = 1;
            if ((localObject3 == null) || (!((ADXml)localObject3).usePreferedInfo)) {
              break label3556;
            }
            paramBaseViewHolder.LkK.setImageResource(i.e.default_avatar);
            paramBaseViewHolder.LkK.gp((String)localObject1, 4);
            paramBaseViewHolder.LkK.setShowStoryHint(false);
            if (!Util.isNullOrNil(((ADXml)localObject3).preferAvatar))
            {
              localObject4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", ((ADXml)localObject3).preferAvatar);
              paramBaseViewHolder.LkK.setTag(i.f.sns_prefer_avatar_url, ((ADXml)localObject3).preferAvatar);
              if (!u.agG((String)localObject4)) {
                break label3505;
              }
              if (!com.tencent.mm.plugin.sns.ad.timeline.b.h.fLz()) {
                break label3478;
              }
              com.tencent.mm.plugin.sns.ad.timeline.b.h.i(paramBaseViewHolder.LkK, (String)localObject4, 1);
            }
            label727:
            paramBaseViewHolder.LkL.setContactInfo(paramBaseViewHolder.KBD);
            paramBaseViewHolder.LkL.a((String)localObject1, parambn.LbA, new q.a()
            {
              public final void b(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(200463);
                if (parambm.KPc != null)
                {
                  parambm.KPc.source = 0;
                  parambm.KPc.b(paramAnonymousView, paramAnonymousObject);
                  ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).report22210(this.iXG, 6L);
                }
                AppMethodBeat.o(200463);
              }
            }, parambn.KBz, parambn.KDB, paramInt2, parambn.KBz);
            paramBaseViewHolder.LkK.kQV = parambn.KDB;
          }
        }
      }
      break;
    }
    label824:
    label1848:
    label4794:
    for (;;)
    {
      paramBaseViewHolder.LkM.setVisibility(8);
      int j;
      if (parambn.KBz)
      {
        paramBaseViewHolder.isAd = true;
        paramBaseViewHolder.CIn = parambn.Lbr;
        paramBaseViewHolder.LkO.a(parambn.Lbn, parambm, parambn.Lbo, parambn);
        paramBaseViewHolder.LkO.setShow(paramBaseViewHolder);
        localObject1 = com.tencent.mm.plugin.sns.i.a.KeP;
        localObject3 = paramBaseViewHolder.LkO;
        j = i.f.desc_tv;
        p.k(localObject3, "view");
        p.k(parambn, "struct");
        localObject1 = ((View)localObject3).findViewById(j);
        localObject4 = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject3 = ((View)localObject3).getContext();
        p.j(localObject3, "view.context");
        localObject3 = com.tencent.mm.plugin.secdata.ui.a.a.hU((Context)localObject3);
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.secdata.ui.a)localObject3).fFs();
          if (localObject3 != null) {
            ((f)localObject3).kk("Item_" + parambn.Jws.localid, String.valueOf(((View)localObject1).hashCode()));
          }
        }
        paramBaseViewHolder.mrL.setOnTouchListener(new ah());
        a(paramBaseViewHolder, paramInt1, parambn, paramTimeLineObject, paramInt2, parambm);
        a(parambn, paramTimeLineObject);
        parambm.KYq.put(Integer.valueOf(paramInt1), new WeakReference(paramBaseViewHolder.convertView));
        if (paramBaseViewHolder.convertView.getBackground() == null)
        {
          paramBaseViewHolder.convertView.setBackgroundResource(i.e.comm_list_item_selector);
          j = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12);
          int k = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 8);
          paramBaseViewHolder.convertView.setPadding(j, j, j, k);
        }
        paramBaseViewHolder.timeTv.setText(parambn.Lbt);
        paramBaseViewHolder.Lla.setVisibility(8);
        paramBaseViewHolder.Llb.setVisibility(8);
        if (parambn.KBz)
        {
          localObject3 = parambn.Lbu;
          paramBaseViewHolder.Lla.setTag(parambn.KDB);
          if (!com.tencent.mm.plugin.sns.ad.timeline.b.e.a((ADInfo)localObject3)) {
            break label3849;
          }
          com.tencent.mm.plugin.sns.ad.timeline.b.e.a(paramBaseViewHolder.Lla, (SnsObject)localObject2, (ADInfo)localObject3);
          if ((paramBaseViewHolder.Lla.getVisibility() != 8) && (Util.isNullOrNil(((ADInfo)localObject3).adActionExtTailLink)))
          {
            paramBaseViewHolder.Lla.setTextColor(this.mActivity.getResources().getColor(i.c.sns_word_color));
            paramBaseViewHolder.Lla.setOnClickListener(null);
          }
          if ((paramSnsInfo.getTimeLine().ContentObj.Sqs & 0x4) == 0) {
            break label4268;
          }
          paramBaseViewHolder.Llb.setTag(paramBaseViewHolder);
          paramBaseViewHolder.Llb.setVisibility(0);
          paramBaseViewHolder.Llb.setText(String.format("%s%s%s", new Object[] { this.mActivity.getResources().getString(i.j.sns_ad_at_tips1), parambn.LbA, this.mActivity.getResources().getString(i.j.sns_ad_at_tips2) }));
        }
        if (!parambn.LbD) {
          break label4280;
        }
        localObject1 = parambm.iXq.getString(i.j.lucky_sns_reward_numbers, new Object[] { Integer.valueOf(parambn.LbE) });
        BaseViewHolder.k(paramBaseViewHolder).setText((CharSequence)localObject1);
        BaseViewHolder.k(paramBaseViewHolder).setVisibility(0);
        label1362:
        paramBaseViewHolder.KWo.setTag(parambn.KDB);
        if (Util.isNullOrNil(parambn.LbG)) {
          break label4333;
        }
        paramBaseViewHolder.KWo.setVisibility(0);
        paramBaseViewHolder.KWo.setText(parambn.LbG);
        paramBaseViewHolder.KWo.setContentDescription(parambn.LbG);
        paramBaseViewHolder.KWo.setClickable(parambn.LbH);
        localObject1 = paramBaseViewHolder.KWo;
        if (!parambn.LbH) {
          break label4292;
        }
        j = this.mActivity.getResources().getColor(i.c.sns_link_color);
        ((TextView)localObject1).setTextColor(j);
        if (!parambn.LbH) {
          break label4310;
        }
        paramBaseViewHolder.KWo.setBackground(this.mActivity.getResources().getDrawable(i.e.sns_clickable_bg));
        label1493:
        if (!parambn.LbO) {
          break label4345;
        }
        paramBaseViewHolder.LkZ.setVisibility(0);
        paramBaseViewHolder.LkZ.setImageResource(i.i.icons_outlined_mini_program);
        paramBaseViewHolder.LkZ.setIconColor(this.mActivity.getResources().getColor(i.c.BW_0_Alpha_0_3));
        paramBaseViewHolder.mrL.setTextColor(this.mActivity.getResources().getColor(i.c.sns_link_color));
        if (!parambn.LbI) {
          break label4363;
        }
        paramBaseViewHolder.mrL.setVisibility(0);
        localObject1 = this.mActivity.getString(i.j.sns_comefrome) + parambn.mAppName;
        if ((paramTimeLineObject == null) || (paramTimeLineObject.ContentObj == null) || ((paramTimeLineObject.ContentObj.Sqq != 28) && (paramTimeLineObject.ContentObj.Sqq != 34) && (paramTimeLineObject.ContentObj.Sqq != 43) && (paramTimeLineObject.ContentObj.Sqq != 36) && ((paramTimeLineObject.ContentObj.Sqq != 1) || (paramTimeLineObject.ContentObj.yNL == null)))) {
          break label4357;
        }
        j = 1;
        if ((((String)localObject1).length() <= 10) || (j != 0)) {
          break label6118;
        }
        localObject1 = ((String)localObject1).substring(0, 10) + "...";
      }
      label1876:
      label3556:
      label6118:
      for (;;)
      {
        localObject1 = new SpannableString((CharSequence)localObject1);
        ((SpannableString)localObject1).setSpan(new b(), 0, ((SpannableString)localObject1).length(), 33);
        paramBaseViewHolder.mrL.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((!parambn.LbK) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.AppInfo.Id)))
        {
          paramBaseViewHolder.mrL.setTextColor(this.mActivity.getResources().getColor(i.c.sns_word_color));
          paramBaseViewHolder.mrL.setOnTouchListener(null);
        }
        paramBaseViewHolder.mrL.setTag(paramTimeLineObject);
        if (parambn.LbC)
        {
          paramBaseViewHolder.KEn.setVisibility(0);
          paramBaseViewHolder.KEn.setTag(parambn.KDB);
          paramBaseViewHolder.Lld.setTag(paramBaseViewHolder);
          if ((!parambn.LbP) || (paramTimeLineObject.ContentObj.Sqq == 28)) {
            break label4763;
          }
          if (!paramBaseViewHolder.Llt)
          {
            paramBaseViewHolder.Lli = ((LinearLayout)paramBaseViewHolder.Llp.inflate());
            paramBaseViewHolder.Llj = paramBaseViewHolder.convertView.findViewById(i.f.post_again_click_id);
            paramBaseViewHolder.Llt = true;
            paramBaseViewHolder.Llj.setTag(parambn.KDB);
            paramBaseViewHolder.Ktc = ((TextView)paramBaseViewHolder.Lli.findViewById(i.f.post_again_click_id));
          }
          paramBaseViewHolder.Llp.setVisibility(0);
          paramBaseViewHolder.Llj.setOnClickListener(parambm.Kdz.LoY);
          switch (parambn.LbQ)
          {
          default: 
            paramBaseViewHolder.Ktc.setText(i.j.sns_post_error_touch_again);
            paramBaseViewHolder.Llj.setClickable(true);
            paramBaseViewHolder.Llj.setEnabled(true);
            paramTimeLineObject = paramSnsInfo.getPostInfo();
            if ((paramTimeLineObject != null) && (!Util.isNullOrNil(paramTimeLineObject.TEq))) {
              paramBaseViewHolder.Ktc.setText(paramTimeLineObject.TEq);
            }
            if (parambn.LbR)
            {
              paramBaseViewHolder.Llc.setVisibility(0);
              paramBaseViewHolder.Llc.setTag(parambn.KDB);
              if (!parambn.LbS) {
                break label4885;
              }
              if (Util.isNullOrNil(parambn.LbT)) {
                break label4824;
              }
              paramBaseViewHolder.LkY.setVisibility(0);
              if (paramInt2 != 7) {
                break label4794;
              }
              paramTimeLineObject = String.format(this.mActivity.getString(i.j.sns_timeline_ui_tv_with_to), new Object[] { parambn.LbT });
              paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.l.b(this.mActivity, paramTimeLineObject, paramBaseViewHolder.LkY.getTextSize());
              paramBaseViewHolder.LkY.setText(paramTimeLineObject);
              if (!parambn.LbV) {
                break label4897;
              }
              if (paramBaseViewHolder.LlN == null)
              {
                paramBaseViewHolder.LlN = paramBaseViewHolder.LlM.inflate();
                paramBaseViewHolder.JTe = ((TextView)paramBaseViewHolder.LlN.findViewById(i.f.album_hb_reward_tip));
                paramBaseViewHolder.LlO = ((MaskTextView)paramBaseViewHolder.LlN.findViewById(i.f.album_hb_reward_users));
                paramBaseViewHolder.LlO.setOnTouchListener(new ah());
              }
              paramBaseViewHolder.LlN.setVisibility(0);
              a(paramBaseViewHolder.LlO, parambn.LbY, paramInt2);
              paramTimeLineObject = this.mActivity.getString(i.j.sns_lucky_reward_tip_info, new Object[] { Integer.valueOf(parambn.LbW), Util.formatMoney2f(parambn.LbX / 100.0D) });
              paramBaseViewHolder.JTe.setText(paramTimeLineObject);
              paramBaseViewHolder.LlN.setTag(paramSnsInfo);
              paramBaseViewHolder.LlN.setOnClickListener(parambm.Kdz.Lpb);
              if (((parambn.LbZ != null) && (parambn.LbZ.size() != 0)) || ((parambn.Lca != null) && (parambn.Lca.size() != 0))) {
                break label4935;
              }
              if (paramBaseViewHolder.KAX == null) {
                break label4916;
              }
              paramBaseViewHolder.KAX.setVisibility(8);
              if (!parambn.Lcb) {
                break label5363;
              }
              paramBaseViewHolder.LkT.setTag(parambn.KDB);
              paramBaseViewHolder.LkT.setText(parambn.Lcc);
              paramBaseViewHolder.LkT.setVisibility(0);
              if (!parambn.KBz) {
                break label5381;
              }
              Log.i("MicroMsg.BaseTimeLineItem", "adatag " + parambn.Lbw);
              paramBaseViewHolder.JPW.G(Long.valueOf(parambn.Lbm), new com.tencent.mm.plugin.sns.data.e(paramBaseViewHolder.JPW, paramBaseViewHolder.position, parambn.KDB, parambn.Lbm, parambn.Lbs));
              paramBaseViewHolder.JPW.a(parambn.Jws, parambn.Lbv, parambn.Lbu);
              paramBaseViewHolder.JPW.setVisibility(0);
              if ((paramBaseViewHolder.KWo != null) && (paramBaseViewHolder.KWo.getVisibility() == 0))
              {
                if (paramBaseViewHolder.JPW.LeR.getVisibility() != 0) {
                  break label5375;
                }
                i = 1;
                if (i != 0)
                {
                  paramTimeLineObject = (LinearLayout.LayoutParams)paramBaseViewHolder.KWo.getLayoutParams();
                  paramTimeLineObject.setMargins(paramTimeLineObject.leftMargin, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mActivity, 0.0F), paramTimeLineObject.rightMargin, paramTimeLineObject.bottomMargin);
                  paramBaseViewHolder.KWo.setLayoutParams(paramTimeLineObject);
                }
              }
              paramBaseViewHolder.LkX.setVisibility(8);
              label2682:
              if (!this.KOn) {
                break label5552;
              }
              aj.fOz().a(this.mActivity, (SnsObject)localObject2, paramBaseViewHolder);
              b(paramBaseViewHolder, paramSnsInfo);
              paramTimeLineObject = aj.fOT();
              long l = paramSnsInfo.field_snsId;
              if ((!paramTimeLineObject.Kap) || (l == 0L) || (paramTimeLineObject.KaI) || (paramTimeLineObject.Kaz <= paramTimeLineObject.Kat) || (paramTimeLineObject.KaM == null) || (paramTimeLineObject.KaM.state != 1) || (paramTimeLineObject.KaM.Kfi < paramTimeLineObject.Kau) || (!paramTimeLineObject.KaE)) {
                break label5454;
              }
              if ((paramTimeLineObject.Kax != 0L) && (cm.bfF() - paramTimeLineObject.KaL.KaQ <= paramTimeLineObject.Kax)) {
                break label5449;
              }
              paramInt1 = 1;
              if ((paramInt1 == 0) || (l != paramTimeLineObject.KaO)) {
                break label5454;
              }
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label5480;
              }
              if (!paramBaseViewHolder.LlT)
              {
                paramBaseViewHolder.LlW = ((LinearLayout)paramBaseViewHolder.LlU.inflate());
                paramBaseViewHolder.LlT = true;
                paramBaseViewHolder.LlX = ((ViewGroup)paramBaseViewHolder.LlW.findViewById(i.f.sns_unread_tip_group));
                BaseViewHolder.a(paramBaseViewHolder, (StoryAvatarDotsView)paramBaseViewHolder.LlX.findViewById(i.f.sns_unread_tip_avatars));
                this.LkE = paramBaseViewHolder.LlX;
              }
              paramBaseViewHolder.LlU.setVisibility(0);
              paramTimeLineObject = aj.fOT();
              if (paramTimeLineObject.KaM == null)
              {
                Log.e("MicroMsg.SnsUnreadTipManager", "getTargetUserNames targetItem is null");
                paramTimeLineObject.KaX = new LinkedList();
              }
              paramTimeLineObject = paramTimeLineObject.KaX;
              Log.i("MicroMsg.BaseTimeLineItem", "checkUnreadTip expose, targetUserNames:%s", new Object[] { Integer.valueOf(paramTimeLineObject.size()) });
              if (!Util.isNullOrNil(paramTimeLineObject)) {
                break label5459;
              }
              BaseViewHolder.l(paramBaseViewHolder).setVisibility(8);
              this.LkF = BaseViewHolder.l(paramBaseViewHolder);
              com.tencent.mm.plugin.sns.model.av.KaZ = this.KaZ;
              this.LkE.invalidate();
              this.LkE.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(243551);
                  t.a(BaseTimeLineItem.a(BaseTimeLineItem.this), Float.valueOf(BaseTimeLineItem.a(BaseTimeLineItem.this).getMeasuredHeight() / 2.0F));
                  BaseTimeLineItem.a(BaseTimeLineItem.this).invalidate();
                  AppMethodBeat.o(243551);
                }
              });
              paramBaseViewHolder.mCC.setBackgroundColor(0);
              paramBaseViewHolder.LlX.setTag(Long.valueOf(paramSnsInfo.field_snsId));
              aj.fOT().gq(paramBaseViewHolder.LlX);
              paramBaseViewHolder.LlX.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(264917);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  BaseTimeLineItem.this.Kee.KYo.fTr();
                  com.tencent.mm.plugin.sns.k.g.Kia.KiI.gWi = 1L;
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(264917);
                }
              });
              com.tencent.mm.plugin.report.service.h.IzE.el(1295, 1);
              aj.fOU();
              if (!com.tencent.mm.plugin.sns.model.as.p(paramSnsInfo.field_snsId, paramSnsInfo.getCreateTime(), paramSnsInfo.localid)) {
                break label5523;
              }
              if (!paramBaseViewHolder.LlY)
              {
                paramBaseViewHolder.Lma = ((LinearLayout)paramBaseViewHolder.LlZ.inflate());
                paramBaseViewHolder.LlY = true;
                paramBaseViewHolder.Lmb = ((TextView)paramBaseViewHolder.Lma.findViewById(i.f.sns_retry_edit_tip));
              }
              paramBaseViewHolder.LlZ.setVisibility(0);
              paramBaseViewHolder.mCC.setBackgroundColor(0);
              paramBaseViewHolder.Lmb.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(249002);
                  Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
                  paramAnonymousView = aj.fOU();
                  localObject1 = paramBaseViewHolder.Lmb.getContext();
                  Object localObject2;
                  Parcel localParcel;
                  if (com.tencent.mm.plugin.sns.model.as.JZV)
                  {
                    paramAnonymousView.JZZ = null;
                    paramAnonymousView.Kaa = "";
                    Log.i(com.tencent.mm.plugin.sns.model.as.TAG, "goRetryEdit draftKey:%s", new Object[] { paramAnonymousView.JZY });
                    localObject2 = aj.fOP().bbm(paramAnonymousView.JZY);
                    if (localObject2 != null)
                    {
                      localObject2 = ((com.tencent.mm.plugin.sns.storage.j)localObject2).field_draft;
                      if (!Util.isNullOrNil((byte[])localObject2))
                      {
                        localParcel = Parcel.obtain();
                        localParcel.unmarshall((byte[])localObject2, 0, localObject2.length);
                        localParcel.setDataPosition(0);
                      }
                    }
                  }
                  try
                  {
                    localObject2 = (Intent)Intent.CREATOR.createFromParcel(localParcel);
                    ((Intent)localObject2).putExtra("Kis_retry_edit", true);
                    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
                    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
                    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousView.reset();
                    MMHandlerThread.removeRunnable(paramAnonymousView.Kab);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(249002);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      aj.fOP().b(paramAnonymousView.JZY, null, 0);
                    }
                  }
                }
              });
            }
            break;
          }
        }
        Object localObject5;
        label4333:
        label4345:
        boolean bool;
        for (;;)
        {
          paramSnsInfo = new bi(parambn.JyZ, parambn.KDB, false, true, 1);
          paramBaseViewHolder.LkP.getResultTextView().setTag(paramSnsInfo);
          paramSnsInfo = new StringBuilder("");
          if ((parambn.LbZ == null) || (parambn.LbZ.size() <= 0)) {
            break label5613;
          }
          paramSnsInfo.append(MMApplicationContext.getContext().getResources().getString(i.j.sns_accessibility_like_list)).append(":");
          paramInt1 = 0;
          while (paramInt1 < parambn.LbZ.size())
          {
            paramTimeLineObject = (com.tencent.mm.vending.j.a)parambn.LbZ.get(paramInt1);
            if (paramTimeLineObject != null) {
              paramSnsInfo.append((String)paramTimeLineObject.get(1)).append(",");
            }
            paramInt1 += 1;
          }
          ((com.tencent.mm.plugin.sns.k.d)localObject1).KhA.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.k.d)localObject1).Khz.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.k.d)localObject1).KhC.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.k.d)localObject1).KhB.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.k.d)localObject1).KhH.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.k.d)localObject1).KhI.add(localObject3);
          break;
          if (!Util.isNullOrNil(paramTimeLineObject.publicUserName))
          {
            ((com.tencent.mm.plugin.sns.k.d)localObject1).KhF.add(localObject3);
            break;
          }
          ((com.tencent.mm.plugin.sns.k.d)localObject1).KhG.add(localObject3);
          break;
          i = 0;
          break label623;
          localObject3 = com.tencent.mm.plugin.sns.ad.f.o.JFQ.JL((String)localObject4);
          if (localObject3 == null) {
            break label727;
          }
          paramBaseViewHolder.LkK.setImageBitmap((Bitmap)localObject3);
          break label727;
          if (com.tencent.mm.plugin.sns.ad.timeline.b.h.fLz())
          {
            Log.i("MicroMsg.BaseTimeLineItem", "download use avatar with cdn, but the statement should not reach!");
            com.tencent.mm.plugin.sns.ad.timeline.b.h.j(paramBaseViewHolder.LkK, ((ADXml)localObject3).preferAvatar, 1);
            break label727;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(((ADXml)localObject3).preferAvatar, false, new f.a()
          {
            public final void aYs(String paramAnonymousString)
            {
              AppMethodBeat.i(198814);
              Log.i("MicroMsg.BaseTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
              String str = (String)paramBaseViewHolder.LkK.getTag(i.f.sns_prefer_avatar_url);
              if ((!Util.isNullOrNil(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", str))))
              {
                paramAnonymousString = com.tencent.mm.plugin.sns.ad.f.o.JFQ.JL(paramAnonymousString);
                if (paramAnonymousString != null) {
                  paramBaseViewHolder.LkK.setImageBitmap(paramAnonymousString);
                }
              }
              AppMethodBeat.o(198814);
            }
            
            public final void fJU() {}
            
            public final void fJV() {}
          });
          break label727;
          if (!((String)localObject1).endsWith("@ad")) {
            if (parambn.LbB)
            {
              Log.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[] { localObject1 });
              if (com.tencent.mm.pluginsdk.ui.a.b.hjf().aaC() != null) {
                paramBaseViewHolder.LkK.setImageBitmap(com.tencent.mm.pluginsdk.ui.a.b.hjf().aaC());
              }
              az.a.ltq.a((String)localObject1, "", new bm.c(parambm.fXg(), paramInt1));
              if (parambn.LbC) {
                break label3789;
              }
              com.tencent.mm.plugin.sns.ui.e.a.b(4, (String)paramBaseViewHolder.LkK.getTag(), paramBaseViewHolder.LkK);
              paramBaseViewHolder.LkK.gp((String)localObject1, 4);
              paramBaseViewHolder.LkK.setTag(localObject1);
              com.tencent.mm.plugin.sns.ui.e.a.a(4, (String)localObject1, paramBaseViewHolder.LkK);
              paramBaseViewHolder.LkK.setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).hasNewStory((String)localObject1));
            }
          }
          for (;;)
          {
            paramBaseViewHolder.LkL.setContactInfo(paramBaseViewHolder.KBD);
            paramBaseViewHolder.LkL.a((String)localObject1, parambn.LbA, new q.a()
            {
              public final void b(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(267743);
                if (parambm.KPc != null) {
                  if (!(paramAnonymousObject instanceof com.tencent.mm.plugin.sns.data.d)) {
                    break label78;
                  }
                }
                label78:
                for (boolean bool = ((com.tencent.mm.plugin.sns.data.d)paramAnonymousObject).isAd;; bool = false)
                {
                  if (bool) {}
                  for (parambm.KPc.source = 0;; parambm.KPc.source = 6)
                  {
                    parambm.KPc.b(paramAnonymousView, paramAnonymousObject);
                    AppMethodBeat.o(267743);
                    return;
                  }
                }
              }
            }, parambn.KBz, parambn.KDB, paramInt2, parambn.KBz);
            break;
            com.tencent.mm.pluginsdk.ui.a.b.c(paramBaseViewHolder.LkK, (String)localObject1);
            break label3644;
            paramBaseViewHolder.LkK.gp((String)localObject1, 4);
            paramBaseViewHolder.LkK.setShowStoryHint(false);
            continue;
            paramBaseViewHolder.LkK.setImageResource(i.e.default_avatar);
            paramBaseViewHolder.LkK.gp((String)localObject1, 4);
            paramBaseViewHolder.LkK.setShowStoryHint(false);
          }
          paramBaseViewHolder.isAd = false;
          break label824;
          if (parambn.Lbu.adActionExtTailType == ADInfo.ADChainStrengthenDefaultWording)
          {
            if (!Util.isNullOrNil(parambn.Lbx))
            {
              paramBaseViewHolder.Lla.setText(parambn.Lbx);
              paramBaseViewHolder.Lla.setVisibility(0);
            }
            while ((((ADInfo)localObject3).adChainType == 1) && (!Util.isNullOrNil(((ADInfo)localObject3).adActionExtTailWording)))
            {
              paramBaseViewHolder.Lla.setText(((ADInfo)localObject3).adActionExtTailWording);
              paramBaseViewHolder.Lla.setVisibility(0);
              break;
              paramBaseViewHolder.Lla.setVisibility(8);
            }
          }
          if (((ADInfo)localObject3).adActionExtTailType != ADInfo.ADChainStrengthenUserInfoFormatWording) {
            break label1170;
          }
          if (!Util.isNullOrNil(parambn.Lby))
          {
            localObject1 = parambn.Lbz;
            localObject4 = parambn.Lby;
            localObject5 = this.mActivity;
            paramBaseViewHolder.Lla.getTextSize();
            localObject5 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.e((Context)localObject5, (CharSequence)localObject4, 1));
            ((com.tencent.mm.pluginsdk.ui.span.m)localObject5).a(null, (CharSequence)localObject4, 0);
            localObject4 = paramBaseViewHolder.Lla.getPaint();
            float f = Layout.getDesiredWidth((CharSequence)localObject5, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject5).length(), (TextPaint)localObject4);
            if (com.tencent.mm.ci.a.H(this.mActivity, (int)f) > paramBaseViewHolder.KPl) {
              do
              {
                if (((String)localObject1).length() <= 1) {
                  break;
                }
                localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                localObject5 = String.format(((ADInfo)localObject3).adActionExtTailWording, new Object[] { (String)localObject1 + "..." });
                localObject6 = this.mActivity;
                paramBaseViewHolder.Lla.getTextSize();
                localObject6 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.e((Context)localObject6, (CharSequence)localObject5, 1));
                ((com.tencent.mm.pluginsdk.ui.span.m)localObject6).a(null, (CharSequence)localObject5, 0);
                f = Layout.getDesiredWidth((CharSequence)localObject6, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject6).length(), (TextPaint)localObject4);
                j = com.tencent.mm.ci.a.H(this.mActivity, (int)f);
                paramBaseViewHolder.Lla.setText((CharSequence)localObject6, TextView.BufferType.SPANNABLE);
                paramBaseViewHolder.Lla.setVisibility(0);
              } while (j > paramBaseViewHolder.KPl);
            }
          }
          for (;;)
          {
            a((ADInfo)localObject3, paramBaseViewHolder);
            break;
            paramBaseViewHolder.Lla.setText((CharSequence)localObject5, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.Lla.setVisibility(0);
            continue;
            paramBaseViewHolder.Lla.setVisibility(8);
          }
          paramBaseViewHolder.Llb.setVisibility(8);
          break label1309;
          BaseViewHolder.k(paramBaseViewHolder).setVisibility(8);
          break label1362;
          j = this.mActivity.getResources().getColor(i.c.desc_text_color);
          break label1458;
          paramBaseViewHolder.KWo.setBackground(this.mActivity.getResources().getDrawable(i.e.mm_trans));
          break label1493;
          paramBaseViewHolder.KWo.setVisibility(8);
          break label1493;
          paramBaseViewHolder.LkZ.setVisibility(8);
          break label1539;
          j = 0;
          break label1699;
          if (parambn.LbJ)
          {
            paramBaseViewHolder.mrL.setVisibility(0);
            localObject1 = new SpannableString(parambn.LbM);
            ((SpannableString)localObject1).setSpan(new c(), 0, ((SpannableString)localObject1).length(), 33);
            paramBaseViewHolder.mrL.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.mrL.setTag(new br(parambn.LbL, parambn.LbM));
            break label1848;
          }
          if (parambn.LbN)
          {
            paramBaseViewHolder.mrL.setVisibility(0);
            localObject1 = this.mActivity.getString(i.j.app_brand_appbrand_with_dot);
            localObject3 = (String)localObject1 + parambn.mAppName;
            localObject4 = new SpannableString((CharSequence)localObject3);
            ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(i.c.sns_word_color)), 0, ((String)localObject1).length(), 33);
            ((SpannableString)localObject4).setSpan(new a(), ((String)localObject1).length(), ((String)localObject3).length(), 33);
            paramBaseViewHolder.mrL.setText((CharSequence)localObject4, TextView.BufferType.SPANNABLE);
            if ((!parambn.LbK) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.AppInfo.Id)))
            {
              paramBaseViewHolder.mrL.setTextColor(this.mActivity.getResources().getColor(i.c.sns_word_color));
              paramBaseViewHolder.mrL.setOnTouchListener(null);
            }
            paramBaseViewHolder.mrL.setTag(paramTimeLineObject);
            break label1848;
          }
          paramBaseViewHolder.mrL.setVisibility(8);
          break label1848;
          paramBaseViewHolder.KEn.setVisibility(8);
          break label1876;
          paramBaseViewHolder.Ktc.setText(i.j.sns_post_error_ban_again);
          paramBaseViewHolder.Llj.setClickable(false);
          paramBaseViewHolder.Llj.setEnabled(false);
          break label2062;
          paramBaseViewHolder.Ktc.setText(i.j.sns_post_error_to_long_again);
          paramBaseViewHolder.Llj.setClickable(false);
          paramBaseViewHolder.Llj.setEnabled(false);
          break label2062;
          paramBaseViewHolder.Ktc.setText(i.j.sns_post_error_ten_min_again);
          paramBaseViewHolder.Llj.setClickable(true);
          paramBaseViewHolder.Llj.setEnabled(true);
          break label2062;
          if (!paramBaseViewHolder.Llt) {
            break label2096;
          }
          paramBaseViewHolder.Llp.setVisibility(8);
          break label2096;
          paramBaseViewHolder.Llc.setVisibility(8);
          break label2124;
          paramTimeLineObject = String.format(this.mActivity.getString(i.j.sns_timeline_ui_with_to), new Object[] { parambn.LbT });
          break label2185;
          if (parambn.LbU)
          {
            paramBaseViewHolder.LkY.setVisibility(0);
            paramTimeLineObject = this.mActivity.getString(i.j.sns_timeline_ui_with_you);
            paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.l.b(this.mActivity, paramTimeLineObject.toString(), paramBaseViewHolder.LkY.getTextSize());
            paramBaseViewHolder.LkY.setText(paramTimeLineObject);
            break label2212;
          }
          paramBaseViewHolder.LkY.setVisibility(8);
          break label2212;
          if (paramBaseViewHolder.LlN == null) {
            break label2383;
          }
          paramBaseViewHolder.LlN.setVisibility(8);
          break label2383;
          if (!paramBaseViewHolder.Llo) {
            break label2437;
          }
          paramBaseViewHolder.Lln.setVisibility(8);
          break label2437;
          if (!paramBaseViewHolder.Llo)
          {
            if ((paramBaseViewHolder.KAX != null) || (paramBaseViewHolder.Lln.getParent() == null)) {
              break label5283;
            }
            paramBaseViewHolder.KAX = ((LinearLayout)paramBaseViewHolder.Lln.inflate());
            if (paramBaseViewHolder.KAX != null)
            {
              paramBaseViewHolder.Llf = ((SnsLikesTextView)paramBaseViewHolder.KAX.findViewById(i.f.album_liked_list_tv));
              paramBaseViewHolder.Llf.setLikedTextTouchListener(new ah());
              paramBaseViewHolder.Llf.setOpClickListener(parambm.KYI);
              paramBaseViewHolder.Llh = ((LinearLayout)paramBaseViewHolder.convertView.findViewById(i.f.album_comment_list_li));
              paramBaseViewHolder.KAX.setTag(parambn.JyZ);
              paramBaseViewHolder.Llf.setLikeTvTag(parambn.JyZ);
              paramBaseViewHolder.Llf.setOpTvTag(paramBaseViewHolder);
              paramBaseViewHolder.Llm = paramBaseViewHolder.KAX.findViewById(i.f.album_list_line);
              paramBaseViewHolder.LlP = paramBaseViewHolder.KAX.findViewById(i.f.album_list_fatherview);
              paramBaseViewHolder.Llo = true;
            }
          }
          if (paramBaseViewHolder.KAX != null) {
            paramBaseViewHolder.KAX.setVisibility(0);
          }
          if ((parambn.LbZ != null) && (parambn.LbZ.size() > 0))
          {
            paramBaseViewHolder.Llf.setVisibility(0);
            parambm.a(parambn.KDB, paramBaseViewHolder.Llf);
            paramBaseViewHolder.Llf.a(parambn.LbZ, paramInt2, parambm, parambn.KDB, parambm.KTE, parambm.KTF, parambm.KYs, parambn, paramBaseViewHolder);
            paramBaseViewHolder.Llg = true;
            if (parambn.Lca == null) {
              break label5339;
            }
            a(((SnsObject)localObject2).CommentUserList, parambn.Lca, paramBaseViewHolder, parambn, paramInt1, paramSnsInfo);
          }
          for (;;)
          {
            if ((parambn.LbZ == null) || (parambn.LbZ.size() == 0) || (parambn.Lca == null) || (parambn.Lca.size() == 0)) {
              break label5351;
            }
            paramBaseViewHolder.Llm.setVisibility(0);
            break;
            if (paramBaseViewHolder.KAX == null) {}
            for (bool = true;; bool = false)
            {
              Log.e("MicroMsg.BaseTimeLineItem", "holder.listKeeper = null %s,and holder.commentStub.inflated", new Object[] { Boolean.valueOf(bool) });
              break;
            }
            paramBaseViewHolder.Llf.setVisibility(8);
            paramBaseViewHolder.Llg = false;
            break label5206;
            paramBaseViewHolder.Llh.setVisibility(8);
          }
          label5351:
          paramBaseViewHolder.Llm.setVisibility(8);
          break label2437;
          label5363:
          paramBaseViewHolder.LkT.setVisibility(8);
          break label2477;
          label5375:
          i = 0;
          break label2619;
          if (i != 0)
          {
            paramBaseViewHolder.JPW.setVisibility(8);
            paramBaseViewHolder.LkX.setTag(new com.tencent.mm.plugin.sns.data.i(paramBaseViewHolder.LkX, paramSnsInfo.getLocalid()));
            paramBaseViewHolder.LkX.setVisibility(0);
            break label2682;
          }
          paramBaseViewHolder.JPW.setVisibility(8);
          paramBaseViewHolder.LkX.setVisibility(8);
          break label2682;
          paramInt1 = 0;
          break label2833;
          paramInt1 = 0;
          break label2850;
          BaseViewHolder.l(paramBaseViewHolder).setVisibility(0);
          a(BaseViewHolder.l(paramBaseViewHolder), paramTimeLineObject);
          break label3027;
          label5480:
          if (paramBaseViewHolder.LlT)
          {
            paramBaseViewHolder.LlU.setVisibility(8);
            paramBaseViewHolder.LlX.setTag(Long.valueOf(paramSnsInfo.field_snsId));
          }
          paramBaseViewHolder.mCC.setBackgroundResource(i.e.list_item_normal);
          break label3107;
          if (paramBaseViewHolder.LlY) {
            paramBaseViewHolder.LlZ.setVisibility(8);
          }
          paramBaseViewHolder.mCC.setBackgroundResource(i.e.list_item_normal);
          continue;
          if ((this.Kee != null) && (this.Kee.getCount() - 1 == paramInt1))
          {
            paramBaseViewHolder.mCC.setBackgroundColor(0);
            paramBaseViewHolder.Lmd.setVisibility(0);
          }
          else
          {
            paramBaseViewHolder.mCC.setBackgroundResource(i.e.list_item_normal);
            paramBaseViewHolder.Lmd.setVisibility(8);
          }
        }
        label5613:
        paramTimeLineObject = new StringBuilder("");
        if ((parambn.Lca != null) && (parambn.Lca.size() > 0))
        {
          paramTimeLineObject.append(MMApplicationContext.getContext().getResources().getString(i.j.sns_accessibility_comment_list)).append(":");
          paramInt1 = 0;
          while (paramInt1 < parambn.Lca.size())
          {
            parambm = (com.tencent.mm.vending.j.a)parambn.Lca.get(paramInt1);
            if (parambm != null) {
              paramTimeLineObject.append((CharSequence)parambm.get(6)).append(",");
            }
            paramInt1 += 1;
          }
        }
        paramInt1 = 0;
        if (paramInt2 == 2) {}
        for (paramInt1 = 1;; paramInt1 = 2) {
          do
          {
            parambm = com.tencent.mm.ui.a.a.a.hJg();
            parambn = paramBaseViewHolder.convertView;
            localObject1 = paramBaseViewHolder.LkL;
            localObject2 = paramBaseViewHolder.timeTv;
            localObject3 = paramBaseViewHolder.KWo;
            localObject4 = paramBaseViewHolder.LkO.getContent();
            localObject5 = paramBaseViewHolder.LkV;
            bool = paramBaseViewHolder.LlJ;
            paramBaseViewHolder = paramBaseViewHolder.mrL;
            paramSnsInfo = paramSnsInfo.toString();
            paramTimeLineObject = paramTimeLineObject.toString();
            if ((parambm.hJd()) && (parambm.mAppContext != null) && (parambn != null) && (localObject1 != null) && (localObject2 != null) && (localObject3 != null) && (paramBaseViewHolder != null)) {
              break;
            }
            return;
          } while ((paramInt2 != 3) && (paramInt2 != 4) && (paramInt2 != 5));
        }
        Object localObject6 = new com.tencent.mm.ui.a.b();
        ((com.tencent.mm.ui.a.b)localObject6).byv(((TextView)localObject1).getText().toString());
        ((com.tencent.mm.ui.a.b)localObject6).byv((String)localObject4);
        if ((localObject5 != null) && (((TextView)localObject5).getText() != null)) {
          ((com.tencent.mm.ui.a.b)localObject6).byv(((TextView)localObject5).getText().toString());
        }
        if (bool) {
          ((com.tencent.mm.ui.a.b)localObject6).byv(parambm.mAppContext.getString(a.k.contains_sight_desc));
        }
        if (paramInt1 == 1) {
          ((com.tencent.mm.ui.a.b)localObject6).byv(parambm.mAppContext.getString(a.k.contains_one_photo_desc));
        }
        for (;;)
        {
          if ((localObject3 != null) && (((TextView)localObject3).getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject6).byv(((TextView)localObject3).getText().toString());
          }
          if ((localObject2 != null) && (((TextView)localObject2).getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject6).byv(((TextView)localObject2).getText().toString());
          }
          if ((paramBaseViewHolder != null) && (paramBaseViewHolder.getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject6).byv(paramBaseViewHolder.getText().toString());
          }
          if (paramSnsInfo != null) {
            ((com.tencent.mm.ui.a.b)localObject6).byv(paramSnsInfo);
          }
          if (paramTimeLineObject != null) {
            ((com.tencent.mm.ui.a.b)localObject6).byv(paramTimeLineObject);
          }
          ((com.tencent.mm.ui.a.b)localObject6).hE(parambn);
          return;
          if (paramInt1 > 1) {
            ((com.tencent.mm.ui.a.b)localObject6).byv(parambm.mAppContext.getString(a.k.contains_photos_desc));
          }
        }
      }
      label2124:
      label2383:
      label3027:
      label4310:
      label4824:
      label5339:
      i = 0;
      label2619:
      label3644:
      label3789:
      label5206:
      break label623;
      label4292:
      label4935:
      label5449:
      label5454:
      label5459:
      i = 0;
    }
  }
  
  public abstract void a(BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm);
  
  public final void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.KOn = paramBoolean;
  }
  
  public static class BaseViewHolder
  {
    public boolean CIn;
    public com.tencent.mm.plugin.sns.ui.av JKG;
    public bt JPW;
    public TextView JTe;
    public LinearLayout KAX;
    public com.tencent.mm.contact.d KBD;
    public TextView KEn;
    public int KPl;
    public TextView KWo;
    public View KWu;
    public TextView Ktc;
    public long LkI;
    public int LkJ;
    public SnsAvatarImageView LkK;
    public AsyncTextView LkL;
    public ImageView LkM;
    public ViewGroup LkN;
    public AsyncNormalTextView LkO;
    public SnsTranslateResultView LkP;
    public LinearLayout LkQ;
    public ViewStub LkR;
    public boolean LkS;
    public TextView LkT;
    public TagImageView LkU;
    public TextView LkV;
    public int LkW;
    public RelativeLayout LkX;
    public TextView LkY;
    public WeImageView LkZ;
    public boolean LlA;
    public View LlB;
    public LinearLayout LlC;
    public ViewStub LlD;
    public boolean LlE;
    public View LlF;
    public ImageView LlG;
    public boolean LlH;
    ViewStub LlI;
    boolean LlJ;
    public View LlK;
    public BaseTimeLineItem LlL;
    public ViewStub LlM;
    public View LlN;
    public MaskTextView LlO;
    public View LlP;
    private TextView LlQ;
    public String LlR;
    public View LlS;
    public boolean LlT;
    public ViewStub LlU;
    private StoryAvatarDotsView LlV;
    public LinearLayout LlW;
    public ViewGroup LlX;
    public boolean LlY;
    public ViewStub LlZ;
    public AsyncTextView Lla;
    public AsyncTextView Llb;
    public View Llc;
    public ImageView Lld;
    public View Lle;
    public SnsLikesTextView Llf;
    public boolean Llg;
    public LinearLayout Llh;
    public LinearLayout Lli;
    public View Llj;
    public LinearLayout Llk;
    public PhotosContent Lll;
    public View Llm;
    public ViewStub Lln;
    public boolean Llo;
    public ViewStub Llp;
    public ViewStub Llq;
    public View Llr;
    public boolean Lls;
    public boolean Llt;
    public ViewStub Llu;
    public boolean Llv;
    public View Llw;
    public LinearLayout Llx;
    public TextView Lly;
    public ViewStub Llz;
    public LinearLayout Lma;
    public TextView Lmb;
    public TextView Lmc;
    public View Lmd;
    public View convertView;
    public String fAg;
    public String fLp;
    public boolean isAd;
    public volatile boolean jTm;
    public ViewGroup mCC;
    public TextView mrL;
    public int position;
    public cvu postInfo;
    public SnsObject snsobj;
    public TimeLineObject timeLineObject;
    public TextView timeTv;
    public TextView titleTv;
    public int viewType;
    public ImageView yVe;
    
    public BaseViewHolder()
    {
      AppMethodBeat.i(100055);
      this.LkS = false;
      this.LkW = 0;
      this.KPl = 210;
      this.Llg = false;
      this.Llo = false;
      this.Llr = null;
      this.Lls = false;
      this.Llt = false;
      this.Llv = false;
      this.LlA = false;
      this.LlE = false;
      this.LlH = false;
      this.LlJ = false;
      this.JKG = new com.tencent.mm.plugin.sns.ui.av();
      this.LlT = false;
      this.LlY = false;
      AppMethodBeat.o(100055);
    }
  }
  
  final class a
    extends q
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100051);
      BaseTimeLineItem.this.Kee.KPg.Lfw.onClick(paramView);
      AppMethodBeat.o(100051);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100052);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(i.c.sns_link_bg_color);
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
    extends q
  {
    b() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100053);
      BaseTimeLineItem.this.Kee.KPg.Lfk.onClick(paramView);
      AppMethodBeat.o(100053);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100054);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(i.c.sns_link_bg_color);
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
  
  final class c
    extends q
  {
    c() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100056);
      BaseTimeLineItem.this.Kee.KPg.Lfl.onClick(paramView);
      AppMethodBeat.o(100056);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100057);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(i.c.sns_link_bg_color);
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
  
  static final class d
    implements g.d
  {
    public int KQF;
    public com.tencent.mm.plugin.sns.ui.l KYx;
    public CharSequence Lme;
    public int Lmf;
    public int deleteFlag;
    public CharSequence kgn;
    public String md5;
    private WeakReference<View> view;
    
    public d(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, View paramView, int paramInt1, int paramInt2, com.tencent.mm.plugin.sns.ui.l paraml)
    {
      AppMethodBeat.i(198988);
      this.view = null;
      this.md5 = null;
      this.Lme = null;
      this.kgn = null;
      this.KQF = 0;
      this.deleteFlag = 0;
      this.Lmf = aw.fromDPToPix(MMApplicationContext.getContext(), 28);
      this.KYx = null;
      this.view = new WeakReference(paramView);
      this.md5 = paramString;
      this.Lme = paramCharSequence1;
      this.kgn = paramCharSequence2;
      this.KQF = paramInt1;
      this.deleteFlag = paramInt2;
      this.KYx = paraml;
      AppMethodBeat.o(198988);
    }
    
    public final void f(Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(100059);
      Log.i("MicroMsg.BaseTimeLineItem", "onEmojiDecodeFin bitmapAvailable:%s, md5:%s", new Object[] { Boolean.valueOf(t.K(paramBitmap)), paramString });
      if ((this.view != null) && (this.view.get() != null) && ((this.view.get() instanceof SnsCommentCollapseLayout)))
      {
        SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.view.get();
        if ((localSnsCommentCollapseLayout != null) && (localSnsCommentCollapseLayout.getTag() != null) && ((localSnsCommentCollapseLayout.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)localSnsCommentCollapseLayout.getTag();
          if ((((com.tencent.mm.plugin.sns.ui.m)localObject).JVu != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.sns.ui.m)localObject).JVu.Uls)) && (((com.tencent.mm.plugin.sns.ui.m)localObject).JVu.Uls.get(0) != null) && (Util.isEqual(paramString, ((eju)((com.tencent.mm.plugin.sns.ui.m)localObject).JVu.Uls.get(0)).Md5)) && (t.K(paramBitmap)))
          {
            paramBitmap = new BitmapDrawable(paramBitmap);
            paramBitmap.setBounds(0, 0, this.Lmf, this.Lmf);
            paramBitmap = new com.tencent.mm.ui.widget.a(paramBitmap, 1);
            MMApplicationContext.getContext();
            paramString = new q(this.md5, this.KYx, 2);
            localObject = new SpannableStringBuilder(this.Lme);
            ((SpannableStringBuilder)localObject).append("  ").append(this.md5).append("  ").append(" ");
            int i = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 2 - 1;
            int j = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 4 - 1;
            ((SpannableStringBuilder)localObject).setSpan(paramBitmap, i, this.md5.length() + i, 33);
            ((SpannableStringBuilder)localObject).setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.kgn);
            localSpannableStringBuilder.append("  ").append(this.md5).append("  ").append(" ");
            i = localSpannableStringBuilder.length() - this.md5.length() - 2 - 1;
            j = localSpannableStringBuilder.length() - this.md5.length() - 4 - 1;
            localSpannableStringBuilder.setSpan(paramBitmap, i, this.md5.length() + i, 33);
            localSpannableStringBuilder.setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            localSnsCommentCollapseLayout.a((CharSequence)localObject, localSpannableStringBuilder, this.KQF, this.deleteFlag);
          }
        }
      }
      AppMethodBeat.o(100059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
 * JD-Core Version:    0.7.0.1
 */
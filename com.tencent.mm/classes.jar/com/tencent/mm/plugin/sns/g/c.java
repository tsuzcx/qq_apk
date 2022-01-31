package com.tencent.mm.plugin.sns.g;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.pluginsdk.ui.d.o.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements com.tencent.mm.ai.f, com.tencent.mm.plugin.sns.model.e
{
  public static final Pattern rlc;
  public static final Pattern rld;
  public com.tencent.mm.plugin.sns.h.c rfe;
  public final int rkU;
  public List<d> rkV;
  public ListView rkW;
  public av rkX;
  public Map<Long, Integer> rkY;
  public HashSet<Long> rkZ;
  public final int rkr;
  public HashSet<Long> rla;
  public HashMap<Long, c.a> rlb;
  private o.a rle;
  
  static
  {
    AppMethodBeat.i(36800);
    rlc = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    rld = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    AppMethodBeat.o(36800);
  }
  
  public c()
  {
    AppMethodBeat.i(36783);
    this.rkr = 14;
    this.rkU = 500;
    this.rkY = new HashMap();
    this.rkZ = new HashSet();
    this.rla = new HashSet();
    this.rlb = new HashMap();
    this.rle = new c.6(this);
    AppMethodBeat.o(36783);
  }
  
  private SpannableString a(Context paramContext, TextView paramTextView, String paramString, SnsObject paramSnsObject, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, d.a parama, d.b paramb, d paramd)
  {
    AppMethodBeat.i(36795);
    Object localObject = rlc.matcher(paramString);
    if ((((Matcher)localObject).find()) && (((Matcher)localObject).groupCount() == 1))
    {
      String str = ((Matcher)localObject).group();
      localObject = ((Matcher)localObject).group(1);
      int i = paramString.indexOf(str);
      paramString = paramString.replace(str, (CharSequence)localObject);
      paramTextView.setOnClickListener(null);
      paramTextView.setClickable(true);
      paramString = new SpannableString(paramString);
      paramTextView.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.aa());
      paramString.setSpan(new o(paramSnsObject.Username, new c.5(this, paramContext, paramSnsObject, parama, paramb, paramBaseViewHolder, paramd)), i, ((String)localObject).length() + i, 33);
      AppMethodBeat.o(36795);
      return paramString;
    }
    paramContext = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramString);
    AppMethodBeat.o(36795);
    return paramContext;
  }
  
  private static String a(String paramString, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(36794);
    Object localObject = paramString;
    try
    {
      if (bo.isNullOrNil(paramString))
      {
        AppMethodBeat.o(36794);
        return "";
      }
      localObject = paramString;
      paramSnsObject = paramSnsObject.Username;
      localObject = paramString;
      g.RM();
      localObject = paramString;
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramSnsObject);
      paramSnsObject = paramString;
      localObject = paramString;
      if (paramString.contains("{username}"))
      {
        localObject = paramString;
        paramSnsObject = paramString.replace("{username}", localad.Of());
      }
      localObject = paramSnsObject;
      int i = localad.dqC;
      if (i == 1)
      {
        i = 0;
        paramString = paramSnsObject;
      }
      ab.printErrStackTrace("MicroMsg.SnSABTestMgr", paramSnsObject, "settext error ", new Object[0]);
    }
    catch (Exception paramSnsObject)
    {
      try
      {
        paramSnsObject = rld.matcher(paramString);
        if ((paramSnsObject.find()) && (paramSnsObject.groupCount() == 3))
        {
          localObject = paramSnsObject.group();
          if (i == 0) {
            paramSnsObject = paramSnsObject.group(1);
          }
          for (;;)
          {
            paramSnsObject = paramString.replace((CharSequence)localObject, paramSnsObject);
            paramString = paramSnsObject;
            break;
            localObject = paramSnsObject;
            i = localad.dqC;
            if (i == 2)
            {
              i = 1;
              paramString = paramSnsObject;
              break;
            }
            i = 2;
            paramString = paramSnsObject;
            break;
            if (i == 1) {
              paramSnsObject = paramSnsObject.group(2);
            } else {
              paramSnsObject = paramSnsObject.group(3);
            }
          }
        }
        AppMethodBeat.o(36794);
        return paramString;
      }
      catch (Exception paramSnsObject)
      {
        break label212;
      }
      paramSnsObject = paramSnsObject;
      paramString = (String)localObject;
    }
    label212:
    AppMethodBeat.o(36794);
    return paramString;
  }
  
  private void a(Context paramContext, SnsObject paramSnsObject, d.a parama, d.b paramb, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, d paramd)
  {
    AppMethodBeat.i(36792);
    ab.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + paramSnsObject.Username + " " + paramSnsObject.Id);
    int i = parama.rly - 1;
    c.a locala = (c.a)this.rlb.get(Long.valueOf(paramSnsObject.Id));
    if (locala != null)
    {
      locala.D(paramb.showType, paramb.hjU.size(), parama.index, parama.actionType);
      locala.rlp = -1;
      locala.rlq = -1;
    }
    if (parama.actionType == 3)
    {
      this.rkZ.add(Long.valueOf(paramSnsObject.Id));
      this.rkY.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
    }
    for (;;)
    {
      if ((i == 4) || (i == 1)) {
        a(paramContext, paramSnsObject, paramBaseViewHolder);
      }
      AppMethodBeat.o(36792);
      return;
      if (parama.actionType == 1)
      {
        this.rkY.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
        lM(paramSnsObject.Id);
        b(paramBaseViewHolder);
      }
      else
      {
        if (parama.actionType == 5)
        {
          if (this.rkZ.contains(Long.valueOf(paramSnsObject.Id)))
          {
            this.rkZ.remove(Long.valueOf(paramSnsObject.Id));
            lM(paramSnsObject.Id);
            b(paramBaseViewHolder);
            if (this.rlb.containsKey(Long.valueOf(paramSnsObject.Id))) {
              a((c.a)this.rlb.remove(Long.valueOf(paramSnsObject.Id)));
            }
          }
          this.rkY.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(-1));
          a(paramBaseViewHolder);
          AppMethodBeat.o(36792);
          return;
        }
        if (parama.actionType == 7)
        {
          if (i < paramd.rlv.size())
          {
            parama = (d.b)paramd.rlv.get(i);
            if (parama.showType == 2)
            {
              b(paramContext, paramSnsObject, paramBaseViewHolder, parama, paramd);
              AppMethodBeat.o(36792);
              return;
            }
            if (parama.showType == 5)
            {
              t.makeText(paramContext, bo.bf(parama.title, ""), 0).show();
              lM(paramSnsObject.Id);
              b(paramBaseViewHolder);
              AppMethodBeat.o(36792);
            }
          }
        }
        else
        {
          if (parama.actionType == 6)
          {
            t.makeText(paramContext, bo.bf(paramContext.getString(2131303735), ""), 0).show();
            this.rla.add(Long.valueOf(paramSnsObject.Id));
            b(paramBaseViewHolder);
            paramContext = new lh();
            com.tencent.mm.sdk.b.a.ymk.l(paramContext);
            a(paramBaseViewHolder);
            AppMethodBeat.o(36792);
            return;
          }
          if (parama.actionType == 2)
          {
            parama = parama.jumpUrl;
            ab.i("MicroMsg.SnSABTestMgr", "jump url ".concat(String.valueOf(parama)));
            paramb = new Intent();
            paramb.putExtra("rawUrl", parama);
            paramb.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.gmO.i(paramb, paramContext);
            lM(paramSnsObject.Id);
            b(paramBaseViewHolder);
            a(paramBaseViewHolder);
            AppMethodBeat.o(36792);
            return;
          }
          if (parama.actionType == 8)
          {
            AppMethodBeat.o(36792);
            return;
          }
          if (parama.actionType == 4)
          {
            parama = paramSnsObject.Username;
            paramb = new LinkedList();
            paramb.add(parama);
            parama = new w(1, 5L, "", paramb.size(), paramb, 0);
            g.RM();
            g.RK().eHt.a(parama, 0);
          }
        }
      }
    }
  }
  
  private static void a(c.a parama)
  {
    AppMethodBeat.i(36797);
    Object localObject = parama.rlo;
    if (localObject == null)
    {
      AppMethodBeat.o(36797);
      return;
    }
    String str2 = ((d)localObject).rkT;
    String str3 = ((d)localObject).rkS;
    String str4 = parama.rlt;
    parama.D(parama.rlp, parama.rlq, 0, 0);
    String str1 = parama.rls;
    localObject = str1;
    if (bo.isNullOrNil(str1)) {
      localObject = parama.rlp + ":" + parama.rlq + ":0:0";
    }
    long l1 = parama.mStartTime / 1000L;
    if (parama.mEndTime == -1L) {
      parama.mEndTime = System.currentTimeMillis();
    }
    long l2 = parama.mEndTime / 1000L;
    if (parama != null)
    {
      ab.i("MicroMsg.SnSABTestMgr", "report layerId: " + str2 + " expid " + str3 + " acton " + (String)localObject + " starttime " + l1 + " timelineId: " + str4);
      com.tencent.mm.plugin.report.service.h.qsU.e(11917, new Object[] { str2, str3, "", "", Integer.valueOf(1), str4, localObject, Long.valueOf(l1), Long.valueOf(l2) });
    }
    AppMethodBeat.o(36797);
  }
  
  private void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(36791);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(36791);
      return;
    }
    Context localContext = paramBaseViewHolder.ngZ.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(36791);
      return;
    }
    if (paramBaseViewHolder.ngZ.getBackground() == null)
    {
      paramBaseViewHolder.ngZ.setBackgroundResource(2130838445);
      paramBaseViewHolder.ngZ.setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 8));
    }
    int i = paramBaseViewHolder.position;
    if (this.rkX != null)
    {
      paramBaseViewHolder = (WeakReference)this.rkX.rWR.get(Integer.valueOf(i - 1));
      if ((paramBaseViewHolder == null) || (paramBaseViewHolder.get() == null))
      {
        AppMethodBeat.o(36791);
        return;
      }
      ((View)paramBaseViewHolder.get()).setBackgroundResource(2130838445);
      ((View)paramBaseViewHolder.get()).setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 8));
    }
    AppMethodBeat.o(36791);
  }
  
  private boolean a(Context paramContext, SnsObject paramSnsObject, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, d.b paramb, d paramd)
  {
    AppMethodBeat.i(36789);
    paramBaseViewHolder.ngZ.setBackgroundDrawable(null);
    int i = paramBaseViewHolder.position;
    Object localObject1;
    if (this.rkX != null)
    {
      localObject1 = (WeakReference)this.rkX.rWR.get(Integer.valueOf(i - 1));
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        break label260;
      }
    }
    Object localObject2;
    for (;;)
    {
      if (!paramBaseViewHolder.shz)
      {
        paramBaseViewHolder.shA = paramBaseViewHolder.shy.inflate();
        paramBaseViewHolder.shz = true;
        paramBaseViewHolder.shB = ((LinearLayout)paramBaseViewHolder.shA.findViewById(2131827826));
      }
      paramBaseViewHolder.shA.setVisibility(0);
      paramBaseViewHolder.shK.setVisibility(8);
      paramBaseViewHolder.sgM.setVisibility(8);
      localObject1 = paramb.hjU;
      if (((List)localObject1).size() == paramBaseViewHolder.shB.getChildCount()) {
        break;
      }
      paramBaseViewHolder.shB.removeAllViews();
      int j = com.tencent.mm.cb.a.fromDPToPix(paramContext, 10);
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setBackgroundResource(2130837668);
        ((TextView)localObject2).setPadding(j, j, j, j);
        ((TextView)localObject2).setTextSize(1, 14.0F * com.tencent.mm.cb.a.dr(paramContext));
        ((TextView)localObject2).setTextColor(paramContext.getResources().getColor(2131689763));
        paramBaseViewHolder.shB.addView((View)localObject2);
        i += 1;
      }
      label260:
      ((View)((WeakReference)localObject1).get()).setBackgroundDrawable(null);
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (d.a)((List)localObject1).get(i);
      TextView localTextView = (TextView)paramBaseViewHolder.shB.getChildAt(i);
      localTextView.setText(((d.a)localObject2).rlw);
      localTextView.setTag(paramSnsObject);
      String str = a(f.a((d.a)localObject2), paramSnsObject);
      localTextView.setOnClickListener(new c.2(this, paramContext, (d.a)localObject2, paramb, paramBaseViewHolder, paramd));
      localTextView.setText(a(paramContext, localTextView, str, paramSnsObject, paramBaseViewHolder, (d.a)localObject2, paramb, paramd), TextView.BufferType.SPANNABLE);
      if (((d.a)localObject2).actionType != 5)
      {
        localTextView.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(paramContext, 5));
        localTextView.setCompoundDrawablesWithIntrinsicBounds(paramContext.getResources().getDrawable(2131230769), null, null, null);
      }
      i += 1;
    }
    AppMethodBeat.o(36789);
    return true;
  }
  
  private static void b(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(36793);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(36793);
      return;
    }
    if (paramBaseViewHolder.sht != null) {
      paramBaseViewHolder.sht.setVisibility(8);
    }
    if (paramBaseViewHolder.shv != null) {
      paramBaseViewHolder.shv.setVisibility(8);
    }
    if (paramBaseViewHolder.shy != null) {
      paramBaseViewHolder.shy.setVisibility(8);
    }
    if (paramBaseViewHolder.shA != null) {
      paramBaseViewHolder.shA.setVisibility(8);
    }
    if (paramBaseViewHolder.shK.getVisibility() == 8) {
      paramBaseViewHolder.shK.setVisibility(0);
    }
    if (paramBaseViewHolder.sgM.getVisibility() == 8) {
      paramBaseViewHolder.sgM.setVisibility(0);
    }
    if (paramBaseViewHolder.ngZ.getVisibility() == 8) {
      paramBaseViewHolder.ngZ.setVisibility(0);
    }
    AppMethodBeat.o(36793);
  }
  
  private boolean b(Context paramContext, SnsObject paramSnsObject, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, d.b paramb, d paramd)
  {
    AppMethodBeat.i(36790);
    if (paramb.hjU.size() == 2)
    {
      d.a locala1 = (d.a)paramb.hjU.get(0);
      d.a locala2 = (d.a)paramb.hjU.get(1);
      String str1 = a(f.a(locala1), paramSnsObject);
      String str2 = a(f.a(locala2), paramSnsObject);
      com.tencent.mm.ui.base.h.d(paramContext, a(paramb.title, paramSnsObject), paramContext.getString(2131297087), str1, str2, new c.3(this, paramContext, paramSnsObject, locala1, paramb, paramBaseViewHolder, paramd), new c.4(this, paramContext, paramSnsObject, locala2, paramb, paramBaseViewHolder, paramd));
      AppMethodBeat.o(36790);
      return true;
    }
    AppMethodBeat.o(36790);
    return false;
  }
  
  public static void c(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(36787);
    paramBaseViewHolder.shu = false;
    paramBaseViewHolder.sht = ((ViewStub)paramView.findViewById(2131828145));
    paramBaseViewHolder.sht.setVisibility(8);
    paramBaseViewHolder.shy = ((ViewStub)paramView.findViewById(2131828152));
    paramBaseViewHolder.shy.setVisibility(8);
    AppMethodBeat.o(36787);
  }
  
  private void lM(long paramLong)
  {
    AppMethodBeat.i(36785);
    if (this.rfe == null) {
      this.rfe = new com.tencent.mm.plugin.sns.h.c();
    }
    if (this.rfe.rlL.size() > 500) {
      this.rfe.rlL.remove(0);
    }
    this.rfe.rlL.add(Long.valueOf(paramLong));
    AppMethodBeat.o(36785);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(36796);
    if (this.rlb.containsKey(Long.valueOf(paramLong)))
    {
      paramString = (c.a)this.rlb.get(Long.valueOf(paramLong));
      if (paramString.mEndTime == -1L) {
        paramString.mEndTime = System.currentTimeMillis();
      }
      paramString.D(paramString.rlp, paramString.rlq, 0, 0);
    }
    AppMethodBeat.o(36796);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bc parambc) {}
  
  public final void a(Context paramContext, SnsObject paramSnsObject, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(36788);
    if (!com.tencent.mm.sdk.platformtools.aa.dsD())
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(36788);
      return;
    }
    if ((this.rkV == null) || (this.rkV.size() == 0))
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(36788);
      return;
    }
    if (this.rla.contains(Long.valueOf(paramSnsObject.Id)))
    {
      b(paramBaseViewHolder);
      paramBaseViewHolder.shK.setVisibility(8);
      paramBaseViewHolder.sgM.setVisibility(8);
      paramBaseViewHolder.ngZ.setVisibility(8);
      AppMethodBeat.o(36788);
      return;
    }
    if ((paramSnsObject.Username == null) || (paramSnsObject.Username.equals(ag.coK())))
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(36788);
      return;
    }
    if ((this.rfe != null) && (this.rfe.rlL.contains(Long.valueOf(paramSnsObject.Id))))
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(36788);
      return;
    }
    if (paramSnsObject != null) {}
    for (;;)
    {
      try
      {
        arrayOfByte = com.tencent.mm.platformtools.aa.a(paramSnsObject.ObjectOperations);
        boolean bool = bo.ce(arrayOfByte);
        if (!bool) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte;
        int k;
        i = 0;
        continue;
        d.b localb = null;
        Object localObject2 = this.rkV.iterator();
        Object localObject1 = localb;
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject1 = (d)((Iterator)localObject2).next();
        if (localObject1 != null) {
          continue;
        }
        b(paramBaseViewHolder);
        AppMethodBeat.o(36788);
        return;
        if (((d)localObject1).rlu != i) {
          continue;
        }
        if (localObject1 != null) {
          continue;
        }
        b(paramBaseViewHolder);
        AppMethodBeat.o(36788);
        return;
        if (j < ((d)localObject1).rlv.size()) {
          continue;
        }
        b(paramBaseViewHolder);
        AppMethodBeat.o(36788);
        return;
        localb = (d.b)((d)localObject1).rlv.get(j);
        int j = localb.showType;
        b(paramBaseViewHolder);
        if (i <= 0) {
          continue;
        }
        if (this.rlb.containsKey(Long.valueOf(paramSnsObject.Id))) {
          continue;
        }
        localObject2 = new c.a(System.currentTimeMillis(), paramSnsObject.Id, i.lq(paramSnsObject.Id), (d)localObject1);
        ((c.a)localObject2).fw(j, localb.hjU.size());
        this.rlb.put(Long.valueOf(paramSnsObject.Id), localObject2);
        if (j != 1) {
          continue;
        }
        localObject2 = localb.title;
        if (paramBaseViewHolder.shu) {
          continue;
        }
        paramBaseViewHolder.shv = paramBaseViewHolder.sht.inflate();
        paramBaseViewHolder.shu = true;
        paramBaseViewHolder.shx = ((TextView)paramBaseViewHolder.shv.findViewById(2131827824));
        paramBaseViewHolder.shw = ((LinearLayout)paramBaseViewHolder.shv.findViewById(2131827825));
        paramBaseViewHolder.shv.setVisibility(0);
        paramBaseViewHolder.shx.setText((CharSequence)localObject2);
        localObject2 = localb.hjU;
        if (((List)localObject2).size() == paramBaseViewHolder.shw.getChildCount()) {
          continue;
        }
        paramBaseViewHolder.shw.removeAllViews();
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        d.a locala = (d.a)((List)localObject2).get(i);
        TextView localTextView = new TextView(paramBaseViewHolder.shw.getContext());
        localTextView.setText(locala.rlw);
        localTextView.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(paramContext, 10), 0);
        localTextView.setVisibility(0);
        localTextView.setTextSize(1, 14.0F * com.tencent.mm.cb.a.dr(paramContext));
        localTextView.setTextColor(paramContext.getResources().getColor(2131690489));
        paramBaseViewHolder.shw.addView(localTextView);
        i += 1;
        continue;
        ((c.a)this.rlb.get(Long.valueOf(paramSnsObject.Id))).fw(j, localb.hjU.size());
        continue;
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        locala = (d.a)((List)localObject2).get(i);
        localTextView = (TextView)paramBaseViewHolder.shw.getChildAt(i);
        localTextView.setText(a(paramContext, localTextView, a(f.a(locala), paramSnsObject), paramSnsObject, paramBaseViewHolder, locala, localb, (d)localObject1));
        localTextView.setTag(paramSnsObject);
        localTextView.setOnClickListener(new c.1(this, paramContext, locala, localb, paramBaseViewHolder, (d)localObject1));
        i += 1;
        continue;
        AppMethodBeat.o(36788);
        return;
        if (j != 4) {
          continue;
        }
        a(paramContext, paramSnsObject, paramBaseViewHolder, localb, (d)localObject1);
        AppMethodBeat.o(36788);
        return;
        if (j != 2) {
          continue;
        }
        if (!b(paramContext, paramSnsObject, paramBaseViewHolder, localb, (d)localObject1)) {
          continue;
        }
        AppMethodBeat.o(36788);
        return;
        AppMethodBeat.o(36788);
        return;
        b(paramBaseViewHolder);
        AppMethodBeat.o(36788);
        return;
      }
      j = 0;
      if (this.rkY.containsKey(Long.valueOf(paramSnsObject.Id)))
      {
        k = ((Integer)this.rkY.get(Long.valueOf(paramSnsObject.Id))).intValue();
        j = k;
        if (k == -1)
        {
          b(paramBaseViewHolder);
          AppMethodBeat.o(36788);
          return;
          i = ((cel)new cel().parseFrom(arrayOfByte)).xOL;
          continue;
        }
      }
      int i = 0;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(36786);
    this.rkW = null;
    this.rkX = null;
    Object localObject2;
    if (this.rkZ != null)
    {
      localObject1 = this.rkZ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        r localr = new r(((Long)localObject2).longValue(), 0, 0, null);
        g.RM();
        g.RK().eHt.a(localr, 0);
        ab.i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(localObject2)));
      }
    }
    if (this.rlb != null)
    {
      localObject1 = this.rlb.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((c.a)((Iterator)localObject1).next());
      }
      this.rlb.clear();
    }
    if ((this.rkV.size() == 0) || (this.rfe == null))
    {
      AppMethodBeat.o(36786);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    g.RM();
    localObject1 = g.RL().cachePath + "ws_1100004";
    ab.i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(localObject1)));
    try
    {
      localObject2 = this.rfe.toByteArray();
      com.tencent.mm.vfs.e.b((String)localObject1, (byte[])localObject2, localObject2.length);
      ab.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + this.rfe.rlL.size());
      AppMethodBeat.o(36786);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SnSABTestMgr", localException, "listToFile failed: ".concat(String.valueOf(localObject1)), new Object[0]);
      AppMethodBeat.o(36786);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(36784);
    ab.i("MicroMsg.SnSABTestMgr", "onSceneend " + paramInt1 + " errCode " + paramInt2);
    paramString = new lg();
    com.tencent.mm.sdk.b.a.ymk.l(paramString);
    AppMethodBeat.o(36784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.c
 * JD-Core Version:    0.7.0.1
 */
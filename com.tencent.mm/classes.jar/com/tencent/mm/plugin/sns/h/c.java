package com.tencent.mm.plugin.sns.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.ui.ae;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
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
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.sns.model.d
{
  public static final Pattern zpN;
  public static final Pattern zpO;
  private com.tencent.mm.plugin.sns.i.c zhQ;
  public final int zpF;
  private List<d> zpG;
  public ListView zpH;
  public bh zpI;
  public Map<Long, Integer> zpJ;
  public HashSet<Long> zpK;
  public HashSet<Long> zpL;
  private HashMap<Long, a> zpM;
  private p.a zpP;
  public final int zpc;
  
  static
  {
    AppMethodBeat.i(96128);
    zpN = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    zpO = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    AppMethodBeat.o(96128);
  }
  
  public c()
  {
    AppMethodBeat.i(96111);
    this.zpc = 14;
    this.zpF = 500;
    this.zpJ = new HashMap();
    this.zpK = new HashSet();
    this.zpL = new HashSet();
    this.zpM = new HashMap();
    this.zpP = new p.a()
    {
      public final void b(View paramAnonymousView, Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(96111);
  }
  
  private SpannableString a(final Context paramContext, TextView paramTextView, String paramString, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.a parama, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96123);
    Object localObject = zpN.matcher(paramString);
    if ((((Matcher)localObject).find()) && (((Matcher)localObject).groupCount() == 1))
    {
      String str = ((Matcher)localObject).group();
      localObject = ((Matcher)localObject).group(1);
      int i = paramString.indexOf(str);
      paramString = paramString.replace(str, (CharSequence)localObject);
      paramTextView.setOnClickListener(null);
      paramTextView.setClickable(true);
      paramString = new SpannableString(paramString);
      paramTextView.setOnTouchListener(new ae());
      paramString.setSpan(new p(paramSnsObject.Username, new p.a()
      {
        public final void b(View paramAnonymousView, Object paramAnonymousObject)
        {
          AppMethodBeat.i(96108);
          c.a(c.this, paramContext, paramSnsObject, parama, paramb, paramBaseViewHolder, paramd);
          AppMethodBeat.o(96108);
        }
      }), i, ((String)localObject).length() + i, 33);
      AppMethodBeat.o(96123);
      return paramString;
    }
    paramContext = k.c(paramContext, paramString);
    AppMethodBeat.o(96123);
    return paramContext;
  }
  
  private static String a(String paramString, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(96122);
    Object localObject = paramString;
    try
    {
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(96122);
        return "";
      }
      localObject = paramString;
      paramSnsObject = paramSnsObject.Username;
      localObject = paramString;
      com.tencent.mm.kernel.g.ajD();
      localObject = paramString;
      am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramSnsObject);
      paramSnsObject = paramString;
      localObject = paramString;
      if (paramString.contains("{username}"))
      {
        localObject = paramString;
        paramSnsObject = paramString.replace("{username}", localam.adv());
      }
      localObject = paramSnsObject;
      int i = localam.ePk;
      if (i == 1)
      {
        i = 0;
        paramString = paramSnsObject;
      }
      ad.printErrStackTrace("MicroMsg.SnSABTestMgr", paramSnsObject, "settext error ", new Object[0]);
    }
    catch (Exception paramSnsObject)
    {
      try
      {
        paramSnsObject = zpO.matcher(paramString);
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
            i = localam.ePk;
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
        AppMethodBeat.o(96122);
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
    AppMethodBeat.o(96122);
    return paramString;
  }
  
  private void a(Context paramContext, SnsObject paramSnsObject, d.a parama, d.b paramb, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, d paramd)
  {
    AppMethodBeat.i(96120);
    ad.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + paramSnsObject.Username + " " + paramSnsObject.Id);
    int i = parama.zqi - 1;
    a locala = (a)this.zpM.get(Long.valueOf(paramSnsObject.Id));
    if (locala != null)
    {
      locala.J(paramb.dlp, paramb.jZF.size(), parama.index, parama.actionType);
      locala.zqa = -1;
      locala.zqb = -1;
    }
    if (parama.actionType == 3)
    {
      this.zpK.add(Long.valueOf(paramSnsObject.Id));
      this.zpJ.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
    }
    for (;;)
    {
      if ((i == 4) || (i == 1)) {
        a(paramContext, paramSnsObject, paramBaseViewHolder);
      }
      AppMethodBeat.o(96120);
      return;
      if (parama.actionType == 1)
      {
        this.zpJ.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
        zT(paramSnsObject.Id);
        e(paramBaseViewHolder);
      }
      else
      {
        if (parama.actionType == 5)
        {
          if (this.zpK.contains(Long.valueOf(paramSnsObject.Id)))
          {
            this.zpK.remove(Long.valueOf(paramSnsObject.Id));
            zT(paramSnsObject.Id);
            e(paramBaseViewHolder);
            if (this.zpM.containsKey(Long.valueOf(paramSnsObject.Id))) {
              a((a)this.zpM.remove(Long.valueOf(paramSnsObject.Id)));
            }
          }
          this.zpJ.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(-1));
          d(paramBaseViewHolder);
          AppMethodBeat.o(96120);
          return;
        }
        if (parama.actionType == 7)
        {
          if (i < paramd.zqf.size())
          {
            parama = (d.b)paramd.zqf.get(i);
            if (parama.dlp == 2)
            {
              b(paramContext, paramSnsObject, paramBaseViewHolder, parama, paramd);
              AppMethodBeat.o(96120);
              return;
            }
            if (parama.dlp == 5)
            {
              t.makeText(paramContext, bt.bI(parama.title, ""), 0).show();
              zT(paramSnsObject.Id);
              e(paramBaseViewHolder);
              AppMethodBeat.o(96120);
            }
          }
        }
        else
        {
          if (parama.actionType == 6)
          {
            t.makeText(paramContext, bt.bI(paramContext.getString(2131763729), ""), 0).show();
            this.zpL.add(Long.valueOf(paramSnsObject.Id));
            e(paramBaseViewHolder);
            paramContext = new ni();
            com.tencent.mm.sdk.b.a.IbL.l(paramContext);
            d(paramBaseViewHolder);
            AppMethodBeat.o(96120);
            return;
          }
          if (parama.actionType == 2)
          {
            parama = parama.jumpUrl;
            ad.i("MicroMsg.SnSABTestMgr", "jump url ".concat(String.valueOf(parama)));
            paramb = new Intent();
            paramb.putExtra("rawUrl", parama);
            paramb.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.iRG.i(paramb, paramContext);
            zT(paramSnsObject.Id);
            e(paramBaseViewHolder);
            d(paramBaseViewHolder);
            AppMethodBeat.o(96120);
            return;
          }
          if (parama.actionType == 8)
          {
            AppMethodBeat.o(96120);
            return;
          }
          if (parama.actionType == 4)
          {
            parama = paramSnsObject.Username;
            paramb = new LinkedList();
            paramb.add(parama);
            parama = new v(1, 5L, "", paramb.size(), paramb, 0);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(parama, 0);
          }
        }
      }
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(96125);
    Object localObject = parama.zpZ;
    if (localObject == null)
    {
      AppMethodBeat.o(96125);
      return;
    }
    String str2 = ((d)localObject).zpE;
    String str3 = ((d)localObject).zpD;
    String str4 = parama.zbo;
    parama.J(parama.zqa, parama.zqb, 0, 0);
    String str1 = parama.zqd;
    localObject = str1;
    if (bt.isNullOrNil(str1)) {
      localObject = parama.zqa + ":" + parama.zqb + ":0:0";
    }
    long l1 = parama.mStartTime / 1000L;
    if (parama.mEndTime == -1L) {
      parama.mEndTime = System.currentTimeMillis();
    }
    long l2 = parama.mEndTime / 1000L;
    if (parama != null)
    {
      ad.i("MicroMsg.SnSABTestMgr", "report layerId: " + str2 + " expid " + str3 + " acton " + (String)localObject + " starttime " + l1 + " timelineId: " + str4);
      com.tencent.mm.plugin.report.service.g.yhR.f(11917, new Object[] { str2, str3, "", "", Integer.valueOf(1), str4, localObject, Long.valueOf(l1), Long.valueOf(l2) });
    }
    AppMethodBeat.o(96125);
  }
  
  private boolean a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96117);
    paramBaseViewHolder.tPw.setBackgroundDrawable(null);
    int i = paramBaseViewHolder.position;
    Object localObject1;
    if (this.zpI != null)
    {
      localObject1 = (WeakReference)this.zpI.AjG.get(Integer.valueOf(i - 1));
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        break label260;
      }
    }
    Object localObject2;
    for (;;)
    {
      if (!paramBaseViewHolder.AvL)
      {
        paramBaseViewHolder.AvM = paramBaseViewHolder.AvK.inflate();
        paramBaseViewHolder.AvL = true;
        paramBaseViewHolder.AvN = ((LinearLayout)paramBaseViewHolder.AvM.findViewById(2131304888));
      }
      paramBaseViewHolder.AvM.setVisibility(0);
      paramBaseViewHolder.AvV.setVisibility(8);
      paramBaseViewHolder.AuV.setVisibility(8);
      localObject1 = paramb.jZF;
      if (((List)localObject1).size() == paramBaseViewHolder.AvN.getChildCount()) {
        break;
      }
      paramBaseViewHolder.AvN.removeAllViews();
      int j = com.tencent.mm.cc.a.fromDPToPix(paramContext, 10);
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setBackgroundResource(2131230902);
        ((TextView)localObject2).setPadding(j, j, j, j);
        ((TextView)localObject2).setTextSize(1, 14.0F * com.tencent.mm.cc.a.eb(paramContext));
        ((TextView)localObject2).setTextColor(paramContext.getResources().getColor(2131100711));
        paramBaseViewHolder.AvN.addView((View)localObject2);
        i += 1;
      }
      label260:
      ((View)((WeakReference)localObject1).get()).setBackgroundDrawable(null);
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (d.a)((List)localObject1).get(i);
      TextView localTextView = (TextView)paramBaseViewHolder.AvN.getChildAt(i);
      localTextView.setText(((d.a)localObject2).zqg);
      localTextView.setTag(paramSnsObject);
      String str = a(f.a((d.a)localObject2), paramSnsObject);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96105);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          c.a(c.this, paramContext, paramAnonymousView, this.zpQ, paramb, paramBaseViewHolder, paramd);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96105);
        }
      });
      localTextView.setText(a(paramContext, localTextView, str, paramSnsObject, paramBaseViewHolder, (d.a)localObject2, paramb, paramd), TextView.BufferType.SPANNABLE);
      if (((d.a)localObject2).actionType != 5)
      {
        localTextView.setCompoundDrawablePadding(com.tencent.mm.cc.a.fromDPToPix(paramContext, 5));
        localTextView.setCompoundDrawablesWithIntrinsicBounds(paramContext.getResources().getDrawable(2131689522), null, null, null);
      }
      i += 1;
    }
    AppMethodBeat.o(96117);
    return true;
  }
  
  private boolean b(final Context paramContext, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96118);
    if (paramb.jZF.size() == 2)
    {
      final d.a locala1 = (d.a)paramb.jZF.get(0);
      final d.a locala2 = (d.a)paramb.jZF.get(1);
      String str1 = a(f.a(locala1), paramSnsObject);
      String str2 = a(f.a(locala2), paramSnsObject);
      h.e(paramContext, a(paramb.title, paramSnsObject), paramContext.getString(2131755906), str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(96106);
          ad.i("MicroMsg.SnSABTestMgr", "onClick alert1");
          c.a(c.this, paramContext, paramSnsObject, locala1, paramb, paramBaseViewHolder, paramd);
          AppMethodBeat.o(96106);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(96107);
          ad.i("MicroMsg.SnSABTestMgr", "onClick alert2");
          c.a(c.this, paramContext, paramSnsObject, locala2, paramb, paramBaseViewHolder, paramd);
          AppMethodBeat.o(96107);
        }
      });
      AppMethodBeat.o(96118);
      return true;
    }
    AppMethodBeat.o(96118);
    return false;
  }
  
  public static void c(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96115);
    paramBaseViewHolder.AvG = false;
    paramBaseViewHolder.AvF = ((ViewStub)paramView.findViewById(2131305043));
    paramBaseViewHolder.AvF.setVisibility(8);
    paramBaseViewHolder.AvK = ((ViewStub)paramView.findViewById(2131304986));
    paramBaseViewHolder.AvK.setVisibility(8);
    AppMethodBeat.o(96115);
  }
  
  private void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(197869);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(197869);
      return;
    }
    Context localContext = paramBaseViewHolder.tPw.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(197869);
      return;
    }
    if (paramBaseViewHolder.tPw.getBackground() == null)
    {
      paramBaseViewHolder.tPw.setBackgroundResource(2131231818);
      paramBaseViewHolder.tPw.setPadding(com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 8));
    }
    int i = paramBaseViewHolder.position;
    if (this.zpI != null)
    {
      paramBaseViewHolder = (WeakReference)this.zpI.AjG.get(Integer.valueOf(i - 1));
      if ((paramBaseViewHolder == null) || (paramBaseViewHolder.get() == null))
      {
        AppMethodBeat.o(197869);
        return;
      }
      ((View)paramBaseViewHolder.get()).setBackgroundResource(2131231818);
      ((View)paramBaseViewHolder.get()).setPadding(com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 8));
    }
    AppMethodBeat.o(197869);
  }
  
  private static void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96121);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(96121);
      return;
    }
    if (paramBaseViewHolder.AvF != null) {
      paramBaseViewHolder.AvF.setVisibility(8);
    }
    if (paramBaseViewHolder.AvH != null) {
      paramBaseViewHolder.AvH.setVisibility(8);
    }
    if (paramBaseViewHolder.AvK != null) {
      paramBaseViewHolder.AvK.setVisibility(8);
    }
    if (paramBaseViewHolder.AvM != null) {
      paramBaseViewHolder.AvM.setVisibility(8);
    }
    if (paramBaseViewHolder.AvV.getVisibility() == 8) {
      paramBaseViewHolder.AvV.setVisibility(0);
    }
    if (paramBaseViewHolder.AuV.getVisibility() == 8) {
      paramBaseViewHolder.AuV.setVisibility(0);
    }
    if (paramBaseViewHolder.tPw.getVisibility() == 8) {
      paramBaseViewHolder.tPw.setVisibility(0);
    }
    AppMethodBeat.o(96121);
  }
  
  private void zT(long paramLong)
  {
    AppMethodBeat.i(96113);
    if (this.zhQ == null) {
      this.zhQ = new com.tencent.mm.plugin.sns.i.c();
    }
    if (this.zhQ.zqu.size() > 500) {
      this.zhQ.zqu.remove(0);
    }
    this.zhQ.zqu.add(Long.valueOf(paramLong));
    AppMethodBeat.o(96113);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(96124);
    if (this.zpM.containsKey(Long.valueOf(paramLong)))
    {
      paramString = (a)this.zpM.get(Long.valueOf(paramLong));
      if (paramString.mEndTime == -1L) {
        paramString.mEndTime = System.currentTimeMillis();
      }
      paramString.J(paramString.zqa, paramString.zqb, 0, 0);
    }
    AppMethodBeat.o(96124);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bn parambn) {}
  
  public final void a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96116);
    if (!ac.fkp())
    {
      e(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.zpG == null) || (this.zpG.size() == 0))
    {
      e(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if (this.zpL.contains(Long.valueOf(paramSnsObject.Id)))
    {
      e(paramBaseViewHolder);
      paramBaseViewHolder.AvV.setVisibility(8);
      paramBaseViewHolder.AuV.setVisibility(8);
      paramBaseViewHolder.tPw.setVisibility(8);
      AppMethodBeat.o(96116);
      return;
    }
    if ((paramSnsObject.Username == null) || (paramSnsObject.Username.equals(ag.dTJ())))
    {
      e(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.zhQ != null) && (this.zhQ.zqu.contains(Long.valueOf(paramSnsObject.Id))))
    {
      e(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if (paramSnsObject != null) {}
    for (;;)
    {
      try
      {
        arrayOfByte = z.a(paramSnsObject.ObjectOperations);
        boolean bool = bt.cC(arrayOfByte);
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
        final d.b localb = null;
        Object localObject2 = this.zpG.iterator();
        Object localObject1 = localb;
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject1 = (d)((Iterator)localObject2).next();
        if (localObject1 != null) {
          continue;
        }
        e(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        if (((d)localObject1).zqe != i) {
          continue;
        }
        if (localObject1 != null) {
          continue;
        }
        e(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        if (j < ((d)localObject1).zqf.size()) {
          continue;
        }
        e(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        localb = (d.b)((d)localObject1).zqf.get(j);
        int j = localb.dlp;
        e(paramBaseViewHolder);
        if (i <= 0) {
          continue;
        }
        if (this.zpM.containsKey(Long.valueOf(paramSnsObject.Id))) {
          continue;
        }
        localObject2 = new a(System.currentTimeMillis(), paramSnsObject.Id, com.tencent.mm.plugin.sns.data.q.zw(paramSnsObject.Id), (d)localObject1);
        ((a)localObject2).hA(j, localb.jZF.size());
        this.zpM.put(Long.valueOf(paramSnsObject.Id), localObject2);
        if (j != 1) {
          continue;
        }
        localObject2 = localb.title;
        if (paramBaseViewHolder.AvG) {
          continue;
        }
        paramBaseViewHolder.AvH = paramBaseViewHolder.AvF.inflate();
        paramBaseViewHolder.AvG = true;
        paramBaseViewHolder.AvJ = ((TextView)paramBaseViewHolder.AvH.findViewById(2131303356));
        paramBaseViewHolder.AvI = ((LinearLayout)paramBaseViewHolder.AvH.findViewById(2131296311));
        paramBaseViewHolder.AvH.setVisibility(0);
        paramBaseViewHolder.AvJ.setText((CharSequence)localObject2);
        localObject2 = localb.jZF;
        if (((List)localObject2).size() == paramBaseViewHolder.AvI.getChildCount()) {
          continue;
        }
        paramBaseViewHolder.AvI.removeAllViews();
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        final d.a locala = (d.a)((List)localObject2).get(i);
        TextView localTextView = new TextView(paramBaseViewHolder.AvI.getContext());
        localTextView.setText(locala.zqg);
        localTextView.setPadding(0, 0, com.tencent.mm.cc.a.fromDPToPix(paramContext, 10), 0);
        localTextView.setVisibility(0);
        localTextView.setTextSize(1, 14.0F * com.tencent.mm.cc.a.eb(paramContext));
        localTextView.setTextColor(paramContext.getResources().getColor(2131100914));
        paramBaseViewHolder.AvI.addView(localTextView);
        i += 1;
        continue;
        ((a)this.zpM.get(Long.valueOf(paramSnsObject.Id))).hA(j, localb.jZF.size());
        continue;
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        locala = (d.a)((List)localObject2).get(i);
        localTextView = (TextView)paramBaseViewHolder.AvI.getChildAt(i);
        localTextView.setText(a(paramContext, localTextView, a(f.a(locala), paramSnsObject), paramSnsObject, paramBaseViewHolder, locala, localb, (d)localObject1));
        localTextView.setTag(paramSnsObject);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96104);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            c.a(c.this, paramContext, paramAnonymousView, locala, localb, paramBaseViewHolder, this.zpT);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96104);
          }
        });
        i += 1;
        continue;
        AppMethodBeat.o(96116);
        return;
        if (j != 4) {
          continue;
        }
        a(paramContext, paramSnsObject, paramBaseViewHolder, localb, (d)localObject1);
        AppMethodBeat.o(96116);
        return;
        if (j != 2) {
          continue;
        }
        if (!b(paramContext, paramSnsObject, paramBaseViewHolder, localb, (d)localObject1)) {
          continue;
        }
        AppMethodBeat.o(96116);
        return;
        AppMethodBeat.o(96116);
        return;
        e(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
      }
      j = 0;
      if (this.zpJ.containsKey(Long.valueOf(paramSnsObject.Id)))
      {
        k = ((Integer)this.zpJ.get(Long.valueOf(paramSnsObject.Id))).intValue();
        j = k;
        if (k == -1)
        {
          e(paramBaseViewHolder);
          AppMethodBeat.o(96116);
          return;
          i = ((dgh)new dgh().parseFrom(arrayOfByte)).Hux;
          continue;
        }
      }
      int i = 0;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(96114);
    this.zpH = null;
    this.zpI = null;
    Object localObject2;
    if (this.zpK != null)
    {
      localObject1 = this.zpK.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        com.tencent.mm.plugin.sns.model.q localq = new com.tencent.mm.plugin.sns.model.q(((Long)localObject2).longValue(), 0, 0, null);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(localq, 0);
        ad.i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(localObject2)));
      }
    }
    if (this.zpM != null)
    {
      localObject1 = this.zpM.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((a)((Iterator)localObject1).next());
      }
      this.zpM.clear();
    }
    if ((this.zpG.size() == 0) || (this.zhQ == null))
    {
      AppMethodBeat.o(96114);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject1 = com.tencent.mm.kernel.g.ajC().cachePath + "ws_1100004";
    ad.i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(localObject1)));
    try
    {
      localObject2 = this.zhQ.toByteArray();
      i.f((String)localObject1, (byte[])localObject2, localObject2.length);
      ad.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + this.zhQ.zqu.size());
      AppMethodBeat.o(96114);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SnSABTestMgr", localException, "listToFile failed: ".concat(String.valueOf(localObject1)), new Object[0]);
      AppMethodBeat.o(96114);
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(179118);
    Object localObject1 = new ArrayList();
    Object localObject2 = com.tencent.mm.model.c.d.aDs().aSk("10001").values().iterator();
    label254:
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.storage.c localc = (com.tencent.mm.storage.c)((Iterator)localObject2).next();
      d locald = new d();
      if (localc == null)
      {
        ad.i("MicroMsg.SnsABTestStrategy", "abtest is null");
      }
      else if (!localc.isValid())
      {
        ad.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      }
      else
      {
        Map localMap = localc.foF();
        if (localMap != null)
        {
          ad.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
          locald.h(localc.field_layerId, localc.field_expId, localMap);
          if ((locald.doF) && (locald.zqf != null) && (locald.zqf.size() > 0)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label254;
            }
            ((List)localObject1).add(locald);
            break;
          }
        }
      }
    }
    this.zpG = ((List)localObject1);
    this.zpJ.clear();
    this.zpK.clear();
    this.zpM.clear();
    this.zhQ = null;
    if ((this.zpG == null) || (this.zpG.size() == 0))
    {
      AppMethodBeat.o(179118);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject1 = com.tencent.mm.kernel.g.ajC().cachePath + "ws_1100004";
    ad.i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(localObject1)));
    localObject2 = i.aY((String)localObject1, 0, -1);
    if (localObject2 != null)
    {
      try
      {
        this.zhQ = ((com.tencent.mm.plugin.sns.i.c)new com.tencent.mm.plugin.sns.i.c().parseFrom((byte[])localObject2));
        ad.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - l));
        if (this.zhQ == null)
        {
          ad.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
          AppMethodBeat.o(179118);
          return;
        }
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.SnSABTestMgr", localIOException, "", new Object[0]);
        i.deleteFile((String)localObject1);
        AppMethodBeat.o(179118);
        return;
      }
      ad.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.zhQ.zqu.size());
    }
    AppMethodBeat.o(179118);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(96112);
    ad.i("MicroMsg.SnSABTestMgr", "onSceneend " + paramInt1 + " errCode " + paramInt2);
    paramString = new nh();
    com.tencent.mm.sdk.b.a.IbL.l(paramString);
    AppMethodBeat.o(96112);
  }
  
  static final class a
  {
    long mEndTime = -1L;
    long mStartTime = -1L;
    long zaX;
    String zbo;
    d zpZ;
    int zqa = 0;
    int zqb = 0;
    String zqc = "";
    String zqd = "";
    
    public a(long paramLong1, long paramLong2, String paramString, d paramd)
    {
      this.zpZ = paramd;
      this.mStartTime = paramLong1;
      this.zaX = paramLong2;
      this.zbo = paramString;
    }
    
    private void addAction(String paramString)
    {
      AppMethodBeat.i(96110);
      if (!bt.isNullOrNil(this.zqd)) {
        this.zqd += "|";
      }
      this.zqd += paramString;
      AppMethodBeat.o(96110);
    }
    
    public final void J(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(96109);
      if ((paramInt1 == -1) || (paramInt2 == -1))
      {
        AppMethodBeat.o(96109);
        return;
      }
      String str1 = paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4;
      String str2 = paramInt1 + ":" + paramInt2;
      if ((str1.equals(this.zqc)) || ((this.zqc.startsWith(str2)) && (paramInt3 == 0) && (paramInt4 == 0)))
      {
        AppMethodBeat.o(96109);
        return;
      }
      this.zqc = str1;
      addAction(paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4);
      AppMethodBeat.o(96109);
    }
    
    public final void hA(int paramInt1, int paramInt2)
    {
      this.zqa = paramInt1;
      this.zqb = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.c
 * JD-Core Version:    0.7.0.1
 */
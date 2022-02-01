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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.ui.af;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bq;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.u;
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
  implements i, com.tencent.mm.plugin.sns.model.e
{
  public static final Pattern DRc;
  public static final Pattern DRd;
  private com.tencent.mm.plugin.sns.j.c DIP;
  public final int DQU;
  private List<d> DQV;
  public ListView DQW;
  public bk DQX;
  public Map<Long, Integer> DQY;
  public HashSet<Long> DQZ;
  public final int DQr;
  public HashSet<Long> DRa;
  private HashMap<Long, a> DRb;
  private q.a DRe;
  
  static
  {
    AppMethodBeat.i(96128);
    DRc = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    DRd = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    AppMethodBeat.o(96128);
  }
  
  public c()
  {
    AppMethodBeat.i(96111);
    this.DQr = 14;
    this.DQU = 500;
    this.DQY = new HashMap();
    this.DQZ = new HashSet();
    this.DRa = new HashSet();
    this.DRb = new HashMap();
    this.DRe = new q.a()
    {
      public final void b(View paramAnonymousView, Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(96111);
  }
  
  private void Jy(long paramLong)
  {
    AppMethodBeat.i(96113);
    if (this.DIP == null) {
      this.DIP = new com.tencent.mm.plugin.sns.j.c();
    }
    if (this.DIP.DRK.size() > 500) {
      this.DIP.DRK.remove(0);
    }
    this.DIP.DRK.add(Long.valueOf(paramLong));
    AppMethodBeat.o(96113);
  }
  
  private SpannableString a(final Context paramContext, TextView paramTextView, String paramString, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.a parama, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96123);
    Object localObject = DRc.matcher(paramString);
    if ((((Matcher)localObject).find()) && (((Matcher)localObject).groupCount() == 1))
    {
      String str = ((Matcher)localObject).group();
      localObject = ((Matcher)localObject).group(1);
      int i = paramString.indexOf(str);
      paramString = paramString.replace(str, (CharSequence)localObject);
      paramTextView.setOnClickListener(null);
      paramTextView.setClickable(true);
      paramString = new SpannableString(paramString);
      paramTextView.setOnTouchListener(new af());
      paramString.setSpan(new com.tencent.mm.pluginsdk.ui.span.q(paramSnsObject.Username, new q.a()
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
    paramContext = com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, paramString);
    AppMethodBeat.o(96123);
    return paramContext;
  }
  
  private static String a(String paramString, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(96122);
    Object localObject = paramString;
    try
    {
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(96122);
        return "";
      }
      localObject = paramString;
      paramSnsObject = paramSnsObject.Username;
      localObject = paramString;
      g.aAi();
      localObject = paramString;
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramSnsObject);
      paramSnsObject = paramString;
      localObject = paramString;
      if (paramString.contains("{username}"))
      {
        localObject = paramString;
        paramSnsObject = paramString.replace("{username}", localas.arJ());
      }
      localObject = paramSnsObject;
      int i = localas.fuA;
      if (i == 1)
      {
        i = 0;
        paramString = paramSnsObject;
      }
      Log.printErrStackTrace("MicroMsg.SnSABTestMgr", paramSnsObject, "settext error ", new Object[0]);
    }
    catch (Exception paramSnsObject)
    {
      try
      {
        paramSnsObject = DRd.matcher(paramString);
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
            i = localas.fuA;
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
    Log.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + paramSnsObject.Username + " " + paramSnsObject.Id);
    int i = parama.DRx - 1;
    a locala = (a)this.DRb.get(Long.valueOf(paramSnsObject.Id));
    if (locala != null)
    {
      locala.K(paramb.dDG, paramb.lgB.size(), parama.index, parama.actionType);
      locala.DRp = -1;
      locala.DRq = -1;
    }
    if (parama.actionType == 3)
    {
      this.DQZ.add(Long.valueOf(paramSnsObject.Id));
      this.DQY.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
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
        this.DQY.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
        Jy(paramSnsObject.Id);
        f(paramBaseViewHolder);
      }
      else
      {
        if (parama.actionType == 5)
        {
          if (this.DQZ.contains(Long.valueOf(paramSnsObject.Id)))
          {
            this.DQZ.remove(Long.valueOf(paramSnsObject.Id));
            Jy(paramSnsObject.Id);
            f(paramBaseViewHolder);
            if (this.DRb.containsKey(Long.valueOf(paramSnsObject.Id))) {
              a((a)this.DRb.remove(Long.valueOf(paramSnsObject.Id)));
            }
          }
          this.DQY.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(-1));
          e(paramBaseViewHolder);
          AppMethodBeat.o(96120);
          return;
        }
        if (parama.actionType == 7)
        {
          if (i < paramd.DRu.size())
          {
            parama = (d.b)paramd.DRu.get(i);
            if (parama.dDG == 2)
            {
              b(paramContext, paramSnsObject, paramBaseViewHolder, parama, paramd);
              AppMethodBeat.o(96120);
              return;
            }
            if (parama.dDG == 5)
            {
              u.makeText(paramContext, Util.nullAs(parama.title, ""), 0).show();
              Jy(paramSnsObject.Id);
              f(paramBaseViewHolder);
              AppMethodBeat.o(96120);
            }
          }
        }
        else
        {
          if (parama.actionType == 6)
          {
            u.makeText(paramContext, Util.nullAs(paramContext.getString(2131765920), ""), 0).show();
            this.DRa.add(Long.valueOf(paramSnsObject.Id));
            f(paramBaseViewHolder);
            paramContext = new ob();
            EventCenter.instance.publish(paramContext);
            e(paramBaseViewHolder);
            AppMethodBeat.o(96120);
            return;
          }
          if (parama.actionType == 2)
          {
            parama = parama.jumpUrl;
            Log.i("MicroMsg.SnSABTestMgr", "jump url ".concat(String.valueOf(parama)));
            paramb = new Intent();
            paramb.putExtra("rawUrl", parama);
            paramb.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.jRt.i(paramb, paramContext);
            Jy(paramSnsObject.Id);
            f(paramBaseViewHolder);
            e(paramBaseViewHolder);
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
            parama = new x(1, 5L, "", paramb.size(), paramb, 0);
            g.aAi();
            g.aAg().hqi.a(parama, 0);
          }
        }
      }
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(96125);
    Object localObject = parama.DRo;
    if (localObject == null)
    {
      AppMethodBeat.o(96125);
      return;
    }
    String str2 = ((d)localObject).DQT;
    String str3 = ((d)localObject).DQS;
    String str4 = parama.Dzk;
    parama.K(parama.DRp, parama.DRq, 0, 0);
    String str1 = parama.DRs;
    localObject = str1;
    if (Util.isNullOrNil(str1)) {
      localObject = parama.DRp + ":" + parama.DRq + ":0:0";
    }
    long l1 = parama.mStartTime / 1000L;
    if (parama.mEndTime == -1L) {
      parama.mEndTime = System.currentTimeMillis();
    }
    long l2 = parama.mEndTime / 1000L;
    if (parama != null)
    {
      Log.i("MicroMsg.SnSABTestMgr", "report layerId: " + str2 + " expid " + str3 + " acton " + (String)localObject + " starttime " + l1 + " timelineId: " + str4);
      com.tencent.mm.plugin.report.service.h.CyF.a(11917, new Object[] { str2, str3, "", "", Integer.valueOf(1), str4, localObject, Long.valueOf(l1), Long.valueOf(l2) });
    }
    AppMethodBeat.o(96125);
  }
  
  private boolean a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96117);
    paramBaseViewHolder.convertView.setBackgroundDrawable(null);
    int i = paramBaseViewHolder.position;
    Object localObject1;
    if (this.DQX != null)
    {
      localObject1 = (WeakReference)this.DQX.EKn.get(Integer.valueOf(i - 1));
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        break label260;
      }
    }
    Object localObject2;
    for (;;)
    {
      if (!paramBaseViewHolder.EXm)
      {
        paramBaseViewHolder.EXn = paramBaseViewHolder.EXl.inflate();
        paramBaseViewHolder.EXm = true;
        paramBaseViewHolder.EXo = ((LinearLayout)paramBaseViewHolder.EXn.findViewById(2131307974));
      }
      paramBaseViewHolder.EXn.setVisibility(0);
      paramBaseViewHolder.EXw.setVisibility(8);
      paramBaseViewHolder.EWw.setVisibility(8);
      localObject1 = paramb.lgB;
      if (((List)localObject1).size() == paramBaseViewHolder.EXo.getChildCount()) {
        break;
      }
      paramBaseViewHolder.EXo.removeAllViews();
      int j = com.tencent.mm.cb.a.fromDPToPix(paramContext, 10);
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setBackgroundResource(2131230922);
        ((TextView)localObject2).setPadding(j, j, j, j);
        ((TextView)localObject2).setTextSize(1, 14.0F * com.tencent.mm.cb.a.ez(paramContext));
        ((TextView)localObject2).setTextColor(paramContext.getResources().getColor(2131100904));
        paramBaseViewHolder.EXo.addView((View)localObject2);
        i += 1;
      }
      label260:
      ((View)((WeakReference)localObject1).get()).setBackgroundDrawable(null);
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (d.a)((List)localObject1).get(i);
      TextView localTextView = (TextView)paramBaseViewHolder.EXo.getChildAt(i);
      localTextView.setText(((d.a)localObject2).DRv);
      localTextView.setTag(paramSnsObject);
      String str = a(f.a((d.a)localObject2), paramSnsObject);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96105);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          c.a(c.this, paramContext, paramAnonymousView, this.DRf, paramb, paramBaseViewHolder, paramd);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96105);
        }
      });
      localTextView.setText(a(paramContext, localTextView, str, paramSnsObject, paramBaseViewHolder, (d.a)localObject2, paramb, paramd), TextView.BufferType.SPANNABLE);
      if (((d.a)localObject2).actionType != 5)
      {
        localTextView.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(paramContext, 5));
        localTextView.setCompoundDrawablesWithIntrinsicBounds(paramContext.getResources().getDrawable(2131689525), null, null, null);
      }
      i += 1;
    }
    AppMethodBeat.o(96117);
    return true;
  }
  
  private boolean b(final Context paramContext, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96118);
    if (paramb.lgB.size() == 2)
    {
      final d.a locala1 = (d.a)paramb.lgB.get(0);
      final d.a locala2 = (d.a)paramb.lgB.get(1);
      String str1 = a(f.a(locala1), paramSnsObject);
      String str2 = a(f.a(locala2), paramSnsObject);
      com.tencent.mm.ui.base.h.c(paramContext, a(paramb.title, paramSnsObject), paramContext.getString(2131755998), str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(96106);
          Log.i("MicroMsg.SnSABTestMgr", "onClick alert1");
          c.a(c.this, paramContext, paramSnsObject, locala1, paramb, paramBaseViewHolder, paramd);
          AppMethodBeat.o(96106);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(96107);
          Log.i("MicroMsg.SnSABTestMgr", "onClick alert2");
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
    paramBaseViewHolder.EXh = false;
    paramBaseViewHolder.EXg = ((ViewStub)paramView.findViewById(2131308194));
    paramBaseViewHolder.EXg.setVisibility(8);
    paramBaseViewHolder.EXl = ((ViewStub)paramView.findViewById(2131308136));
    paramBaseViewHolder.EXl.setVisibility(8);
    AppMethodBeat.o(96115);
  }
  
  private void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(202799);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(202799);
      return;
    }
    Context localContext = paramBaseViewHolder.convertView.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(202799);
      return;
    }
    if (paramBaseViewHolder.convertView.getBackground() == null)
    {
      paramBaseViewHolder.convertView.setBackgroundResource(2131231898);
      paramBaseViewHolder.convertView.setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 8));
    }
    int i = paramBaseViewHolder.position;
    if (this.DQX != null)
    {
      paramBaseViewHolder = (WeakReference)this.DQX.EKn.get(Integer.valueOf(i - 1));
      if ((paramBaseViewHolder == null) || (paramBaseViewHolder.get() == null))
      {
        AppMethodBeat.o(202799);
        return;
      }
      ((View)paramBaseViewHolder.get()).setBackgroundResource(2131231898);
      ((View)paramBaseViewHolder.get()).setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 8));
    }
    AppMethodBeat.o(202799);
  }
  
  private static void f(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96121);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(96121);
      return;
    }
    if (paramBaseViewHolder.EXg != null) {
      paramBaseViewHolder.EXg.setVisibility(8);
    }
    if (paramBaseViewHolder.EXi != null) {
      paramBaseViewHolder.EXi.setVisibility(8);
    }
    if (paramBaseViewHolder.EXl != null) {
      paramBaseViewHolder.EXl.setVisibility(8);
    }
    if (paramBaseViewHolder.EXn != null) {
      paramBaseViewHolder.EXn.setVisibility(8);
    }
    if (paramBaseViewHolder.EXw.getVisibility() == 8) {
      paramBaseViewHolder.EXw.setVisibility(0);
    }
    if (paramBaseViewHolder.EWw.getVisibility() == 8) {
      paramBaseViewHolder.EWw.setVisibility(0);
    }
    if (paramBaseViewHolder.convertView.getVisibility() == 8) {
      paramBaseViewHolder.convertView.setVisibility(0);
    }
    AppMethodBeat.o(96121);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(96124);
    if (this.DRb.containsKey(Long.valueOf(paramLong)))
    {
      paramString = (a)this.DRb.get(Long.valueOf(paramLong));
      if (paramString.mEndTime == -1L) {
        paramString.mEndTime = System.currentTimeMillis();
      }
      paramString.K(paramString.DRp, paramString.DRq, 0, 0);
    }
    AppMethodBeat.o(96124);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bq parambq) {}
  
  public final void a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96116);
    if (!LocaleUtil.isSimplifiedChineseAppLang())
    {
      f(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.DQV == null) || (this.DQV.size() == 0))
    {
      f(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if (this.DRa.contains(Long.valueOf(paramSnsObject.Id)))
    {
      f(paramBaseViewHolder);
      paramBaseViewHolder.EXw.setVisibility(8);
      paramBaseViewHolder.EWw.setVisibility(8);
      paramBaseViewHolder.convertView.setVisibility(8);
      AppMethodBeat.o(96116);
      return;
    }
    if ((paramSnsObject.Username == null) || (paramSnsObject.Username.equals(aj.fau())))
    {
      f(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.DIP != null) && (this.DIP.DRK.contains(Long.valueOf(paramSnsObject.Id))))
    {
      f(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if (paramSnsObject != null) {}
    for (;;)
    {
      try
      {
        arrayOfByte = z.a(paramSnsObject.ObjectOperations);
        boolean bool = Util.isNullOrNil(arrayOfByte);
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
        Object localObject2 = this.DQV.iterator();
        Object localObject1 = localb;
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject1 = (d)((Iterator)localObject2).next();
        if (localObject1 != null) {
          continue;
        }
        f(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        if (((d)localObject1).DRt != i) {
          continue;
        }
        if (localObject1 != null) {
          continue;
        }
        f(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        if (j < ((d)localObject1).DRu.size()) {
          continue;
        }
        f(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        localb = (d.b)((d)localObject1).DRu.get(j);
        int j = localb.dDG;
        f(paramBaseViewHolder);
        if (i <= 0) {
          continue;
        }
        if (this.DRb.containsKey(Long.valueOf(paramSnsObject.Id))) {
          continue;
        }
        localObject2 = new a(System.currentTimeMillis(), paramSnsObject.Id, r.Jb(paramSnsObject.Id), (d)localObject1);
        ((a)localObject2).iw(j, localb.lgB.size());
        this.DRb.put(Long.valueOf(paramSnsObject.Id), localObject2);
        if (j != 1) {
          continue;
        }
        localObject2 = localb.title;
        if (paramBaseViewHolder.EXh) {
          continue;
        }
        paramBaseViewHolder.EXi = paramBaseViewHolder.EXg.inflate();
        paramBaseViewHolder.EXh = true;
        paramBaseViewHolder.EXk = ((TextView)paramBaseViewHolder.EXi.findViewById(2131306049));
        paramBaseViewHolder.EXj = ((LinearLayout)paramBaseViewHolder.EXi.findViewById(2131296324));
        paramBaseViewHolder.EXi.setVisibility(0);
        paramBaseViewHolder.EXk.setText((CharSequence)localObject2);
        localObject2 = localb.lgB;
        if (((List)localObject2).size() == paramBaseViewHolder.EXj.getChildCount()) {
          continue;
        }
        paramBaseViewHolder.EXj.removeAllViews();
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        final d.a locala = (d.a)((List)localObject2).get(i);
        TextView localTextView = new TextView(paramBaseViewHolder.EXj.getContext());
        localTextView.setText(locala.DRv);
        localTextView.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(paramContext, 10), 0);
        localTextView.setVisibility(0);
        localTextView.setTextSize(1, 14.0F * com.tencent.mm.cb.a.ez(paramContext));
        localTextView.setTextColor(paramContext.getResources().getColor(2131101131));
        paramBaseViewHolder.EXj.addView(localTextView);
        i += 1;
        continue;
        ((a)this.DRb.get(Long.valueOf(paramSnsObject.Id))).iw(j, localb.lgB.size());
        continue;
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        locala = (d.a)((List)localObject2).get(i);
        localTextView = (TextView)paramBaseViewHolder.EXj.getChildAt(i);
        localTextView.setText(a(paramContext, localTextView, a(f.a(locala), paramSnsObject), paramSnsObject, paramBaseViewHolder, locala, localb, (d)localObject1));
        localTextView.setTag(paramSnsObject);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96104);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            c.a(c.this, paramContext, paramAnonymousView, locala, localb, paramBaseViewHolder, this.DRi);
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
        f(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
      }
      j = 0;
      if (this.DQY.containsKey(Long.valueOf(paramSnsObject.Id)))
      {
        k = ((Integer)this.DQY.get(Long.valueOf(paramSnsObject.Id))).intValue();
        j = k;
        if (k == -1)
        {
          f(paramBaseViewHolder);
          AppMethodBeat.o(96116);
          return;
          i = ((eaj)new eaj().parseFrom(arrayOfByte)).MZH;
          continue;
        }
      }
      int i = 0;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(96114);
    this.DQW = null;
    this.DQX = null;
    Object localObject2;
    if (this.DQZ != null)
    {
      localObject1 = this.DQZ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        com.tencent.mm.plugin.sns.model.s locals = new com.tencent.mm.plugin.sns.model.s(((Long)localObject2).longValue(), 0, 0, null);
        g.aAi();
        g.aAg().hqi.a(locals, 0);
        Log.i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(localObject2)));
      }
    }
    if (this.DRb != null)
    {
      localObject1 = this.DRb.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((a)((Iterator)localObject1).next());
      }
      this.DRb.clear();
    }
    if ((this.DQV.size() == 0) || (this.DIP == null))
    {
      AppMethodBeat.o(96114);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    g.aAi();
    localObject1 = g.aAh().cachePath + "ws_1100004";
    Log.i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(localObject1)));
    try
    {
      localObject2 = this.DIP.toByteArray();
      com.tencent.mm.vfs.s.f((String)localObject1, (byte[])localObject2, localObject2.length);
      Log.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + this.DIP.DRK.size());
      AppMethodBeat.o(96114);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SnSABTestMgr", localException, "listToFile failed: ".concat(String.valueOf(localObject1)), new Object[0]);
      AppMethodBeat.o(96114);
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(179118);
    Object localObject1 = new ArrayList();
    Object localObject2 = com.tencent.mm.model.c.d.aXu().biC("10001").values().iterator();
    label254:
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.storage.c localc = (com.tencent.mm.storage.c)((Iterator)localObject2).next();
      d locald = new d();
      if (localc == null)
      {
        Log.i("MicroMsg.SnsABTestStrategy", "abtest is null");
      }
      else if (!localc.isValid())
      {
        Log.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      }
      else
      {
        Map localMap = localc.gzz();
        if (localMap != null)
        {
          Log.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
          locald.f(localc.field_layerId, localc.field_expId, localMap);
          if ((locald.dGX) && (locald.DRu != null) && (locald.DRu.size() > 0)) {}
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
    this.DQV = ((List)localObject1);
    this.DQY.clear();
    this.DQZ.clear();
    this.DRb.clear();
    this.DIP = null;
    if ((this.DQV == null) || (this.DQV.size() == 0))
    {
      AppMethodBeat.o(179118);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    g.aAi();
    localObject1 = g.aAh().cachePath + "ws_1100004";
    Log.i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(localObject1)));
    localObject2 = com.tencent.mm.vfs.s.aW((String)localObject1, 0, -1);
    if (localObject2 != null)
    {
      try
      {
        this.DIP = ((com.tencent.mm.plugin.sns.j.c)new com.tencent.mm.plugin.sns.j.c().parseFrom((byte[])localObject2));
        Log.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - l));
        if (this.DIP == null)
        {
          Log.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
          AppMethodBeat.o(179118);
          return;
        }
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.SnSABTestMgr", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.s.deleteFile((String)localObject1);
        AppMethodBeat.o(179118);
        return;
      }
      Log.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.DIP.DRK.size());
    }
    AppMethodBeat.o(179118);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(96112);
    Log.i("MicroMsg.SnSABTestMgr", "onSceneend " + paramInt1 + " errCode " + paramInt2);
    paramString = new oa();
    EventCenter.instance.publish(paramString);
    AppMethodBeat.o(96112);
  }
  
  static final class a
  {
    d DRo;
    int DRp = 0;
    int DRq = 0;
    String DRr = "";
    String DRs = "";
    long Dyz;
    String Dzk;
    long mEndTime = -1L;
    long mStartTime = -1L;
    
    public a(long paramLong1, long paramLong2, String paramString, d paramd)
    {
      this.DRo = paramd;
      this.mStartTime = paramLong1;
      this.Dyz = paramLong2;
      this.Dzk = paramString;
    }
    
    private void addAction(String paramString)
    {
      AppMethodBeat.i(96110);
      if (!Util.isNullOrNil(this.DRs)) {
        this.DRs += "|";
      }
      this.DRs += paramString;
      AppMethodBeat.o(96110);
    }
    
    public final void K(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(96109);
      if ((paramInt1 == -1) || (paramInt2 == -1))
      {
        AppMethodBeat.o(96109);
        return;
      }
      String str1 = paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4;
      String str2 = paramInt1 + ":" + paramInt2;
      if ((str1.equals(this.DRr)) || ((this.DRr.startsWith(str2)) && (paramInt3 == 0) && (paramInt4 == 0)))
      {
        AppMethodBeat.o(96109);
        return;
      }
      this.DRr = str1;
      addAction(paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4);
      AppMethodBeat.o(96109);
    }
    
    public final void iw(int paramInt1, int paramInt2)
    {
      this.DRp = paramInt1;
      this.DRq = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.c
 * JD-Core Version:    0.7.0.1
 */
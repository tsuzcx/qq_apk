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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.w;
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
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.o;
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
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.sns.model.e
{
  public static final Pattern zHc;
  public static final Pattern zHd;
  public final int zGU;
  private List<d> zGV;
  public ListView zGW;
  public bh zGX;
  public Map<Long, Integer> zGY;
  public HashSet<Long> zGZ;
  public final int zGr;
  public HashSet<Long> zHa;
  private HashMap<Long, a> zHb;
  private p.a zHe;
  private com.tencent.mm.plugin.sns.i.c zyF;
  
  static
  {
    AppMethodBeat.i(96128);
    zHc = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    zHd = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    AppMethodBeat.o(96128);
  }
  
  public c()
  {
    AppMethodBeat.i(96111);
    this.zGr = 14;
    this.zGU = 500;
    this.zGY = new HashMap();
    this.zGZ = new HashSet();
    this.zHa = new HashSet();
    this.zHb = new HashMap();
    this.zHe = new p.a()
    {
      public final void b(View paramAnonymousView, Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(96111);
  }
  
  private void Ar(long paramLong)
  {
    AppMethodBeat.i(96113);
    if (this.zyF == null) {
      this.zyF = new com.tencent.mm.plugin.sns.i.c();
    }
    if (this.zyF.zHJ.size() > 500) {
      this.zyF.zHJ.remove(0);
    }
    this.zyF.zHJ.add(Long.valueOf(paramLong));
    AppMethodBeat.o(96113);
  }
  
  private SpannableString a(final Context paramContext, TextView paramTextView, String paramString, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.a parama, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96123);
    Object localObject = zHc.matcher(paramString);
    if ((((Matcher)localObject).find()) && (((Matcher)localObject).groupCount() == 1))
    {
      String str = ((Matcher)localObject).group();
      localObject = ((Matcher)localObject).group(1);
      int i = paramString.indexOf(str);
      paramString = paramString.replace(str, (CharSequence)localObject);
      paramTextView.setOnClickListener(null);
      paramTextView.setClickable(true);
      paramString = new SpannableString(paramString);
      paramTextView.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ae());
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
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(96122);
        return "";
      }
      localObject = paramString;
      paramSnsObject = paramSnsObject.Username;
      localObject = paramString;
      com.tencent.mm.kernel.g.ajS();
      localObject = paramString;
      an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramSnsObject);
      paramSnsObject = paramString;
      localObject = paramString;
      if (paramString.contains("{username}"))
      {
        localObject = paramString;
        paramSnsObject = paramString.replace("{username}", localan.adG());
      }
      localObject = paramSnsObject;
      int i = localan.eQV;
      if (i == 1)
      {
        i = 0;
        paramString = paramSnsObject;
      }
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.SnSABTestMgr", paramSnsObject, "settext error ", new Object[0]);
    }
    catch (Exception paramSnsObject)
    {
      try
      {
        paramSnsObject = zHd.matcher(paramString);
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
            i = localan.eQV;
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + paramSnsObject.Username + " " + paramSnsObject.Id);
    int i = parama.zHx - 1;
    a locala = (a)this.zHb.get(Long.valueOf(paramSnsObject.Id));
    if (locala != null)
    {
      locala.J(paramb.dmr, paramb.kcW.size(), parama.index, parama.actionType);
      locala.zHp = -1;
      locala.zHq = -1;
    }
    if (parama.actionType == 3)
    {
      this.zGZ.add(Long.valueOf(paramSnsObject.Id));
      this.zGY.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
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
        this.zGY.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
        Ar(paramSnsObject.Id);
        e(paramBaseViewHolder);
      }
      else
      {
        if (parama.actionType == 5)
        {
          if (this.zGZ.contains(Long.valueOf(paramSnsObject.Id)))
          {
            this.zGZ.remove(Long.valueOf(paramSnsObject.Id));
            Ar(paramSnsObject.Id);
            e(paramBaseViewHolder);
            if (this.zHb.containsKey(Long.valueOf(paramSnsObject.Id))) {
              a((a)this.zHb.remove(Long.valueOf(paramSnsObject.Id)));
            }
          }
          this.zGY.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(-1));
          d(paramBaseViewHolder);
          AppMethodBeat.o(96120);
          return;
        }
        if (parama.actionType == 7)
        {
          if (i < paramd.zHu.size())
          {
            parama = (d.b)paramd.zHu.get(i);
            if (parama.dmr == 2)
            {
              b(paramContext, paramSnsObject, paramBaseViewHolder, parama, paramd);
              AppMethodBeat.o(96120);
              return;
            }
            if (parama.dmr == 5)
            {
              t.makeText(paramContext, bu.bI(parama.title, ""), 0).show();
              Ar(paramSnsObject.Id);
              e(paramBaseViewHolder);
              AppMethodBeat.o(96120);
            }
          }
        }
        else
        {
          if (parama.actionType == 6)
          {
            t.makeText(paramContext, bu.bI(paramContext.getString(2131763729), ""), 0).show();
            this.zHa.add(Long.valueOf(paramSnsObject.Id));
            e(paramBaseViewHolder);
            paramContext = new nj();
            com.tencent.mm.sdk.b.a.IvT.l(paramContext);
            d(paramBaseViewHolder);
            AppMethodBeat.o(96120);
            return;
          }
          if (parama.actionType == 2)
          {
            parama = parama.jumpUrl;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "jump url ".concat(String.valueOf(parama)));
            paramb = new Intent();
            paramb.putExtra("rawUrl", parama);
            paramb.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.iUz.i(paramb, paramContext);
            Ar(paramSnsObject.Id);
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
            parama = new w(1, 5L, "", paramb.size(), paramb, 0);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(parama, 0);
          }
        }
      }
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(96125);
    Object localObject = parama.zHo;
    if (localObject == null)
    {
      AppMethodBeat.o(96125);
      return;
    }
    String str2 = ((d)localObject).zGT;
    String str3 = ((d)localObject).zGS;
    String str4 = parama.zrS;
    parama.J(parama.zHp, parama.zHq, 0, 0);
    String str1 = parama.zHs;
    localObject = str1;
    if (bu.isNullOrNil(str1)) {
      localObject = parama.zHp + ":" + parama.zHq + ":0:0";
    }
    long l1 = parama.mStartTime / 1000L;
    if (parama.mEndTime == -1L) {
      parama.mEndTime = System.currentTimeMillis();
    }
    long l2 = parama.mEndTime / 1000L;
    if (parama != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "report layerId: " + str2 + " expid " + str3 + " acton " + (String)localObject + " starttime " + l1 + " timelineId: " + str4);
      com.tencent.mm.plugin.report.service.g.yxI.f(11917, new Object[] { str2, str3, "", "", Integer.valueOf(1), str4, localObject, Long.valueOf(l1), Long.valueOf(l2) });
    }
    AppMethodBeat.o(96125);
  }
  
  private boolean a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96117);
    paramBaseViewHolder.uan.setBackgroundDrawable(null);
    int i = paramBaseViewHolder.position;
    Object localObject1;
    if (this.zGX != null)
    {
      localObject1 = (WeakReference)this.zGX.AAS.get(Integer.valueOf(i - 1));
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        break label260;
      }
    }
    Object localObject2;
    for (;;)
    {
      if (!paramBaseViewHolder.ANc)
      {
        paramBaseViewHolder.ANd = paramBaseViewHolder.ANb.inflate();
        paramBaseViewHolder.ANc = true;
        paramBaseViewHolder.ANe = ((LinearLayout)paramBaseViewHolder.ANd.findViewById(2131304888));
      }
      paramBaseViewHolder.ANd.setVisibility(0);
      paramBaseViewHolder.ANm.setVisibility(8);
      paramBaseViewHolder.AMl.setVisibility(8);
      localObject1 = paramb.kcW;
      if (((List)localObject1).size() == paramBaseViewHolder.ANe.getChildCount()) {
        break;
      }
      paramBaseViewHolder.ANe.removeAllViews();
      int j = com.tencent.mm.cb.a.fromDPToPix(paramContext, 10);
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setBackgroundResource(2131230902);
        ((TextView)localObject2).setPadding(j, j, j, j);
        ((TextView)localObject2).setTextSize(1, 14.0F * com.tencent.mm.cb.a.ef(paramContext));
        ((TextView)localObject2).setTextColor(paramContext.getResources().getColor(2131100711));
        paramBaseViewHolder.ANe.addView((View)localObject2);
        i += 1;
      }
      label260:
      ((View)((WeakReference)localObject1).get()).setBackgroundDrawable(null);
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (d.a)((List)localObject1).get(i);
      TextView localTextView = (TextView)paramBaseViewHolder.ANe.getChildAt(i);
      localTextView.setText(((d.a)localObject2).zHv);
      localTextView.setTag(paramSnsObject);
      String str = a(f.a((d.a)localObject2), paramSnsObject);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96105);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          c.a(c.this, paramContext, paramAnonymousView, this.zHf, paramb, paramBaseViewHolder, paramd);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96105);
        }
      });
      localTextView.setText(a(paramContext, localTextView, str, paramSnsObject, paramBaseViewHolder, (d.a)localObject2, paramb, paramd), TextView.BufferType.SPANNABLE);
      if (((d.a)localObject2).actionType != 5)
      {
        localTextView.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(paramContext, 5));
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
    if (paramb.kcW.size() == 2)
    {
      final d.a locala1 = (d.a)paramb.kcW.get(0);
      final d.a locala2 = (d.a)paramb.kcW.get(1);
      String str1 = a(f.a(locala1), paramSnsObject);
      String str2 = a(f.a(locala2), paramSnsObject);
      h.e(paramContext, a(paramb.title, paramSnsObject), paramContext.getString(2131755906), str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(96106);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "onClick alert1");
          c.a(c.this, paramContext, paramSnsObject, locala1, paramb, paramBaseViewHolder, paramd);
          AppMethodBeat.o(96106);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(96107);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "onClick alert2");
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
    paramBaseViewHolder.AMX = false;
    paramBaseViewHolder.AMW = ((ViewStub)paramView.findViewById(2131305043));
    paramBaseViewHolder.AMW.setVisibility(8);
    paramBaseViewHolder.ANb = ((ViewStub)paramView.findViewById(2131304986));
    paramBaseViewHolder.ANb.setVisibility(8);
    AppMethodBeat.o(96115);
  }
  
  private void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(219363);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(219363);
      return;
    }
    Context localContext = paramBaseViewHolder.uan.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(219363);
      return;
    }
    if (paramBaseViewHolder.uan.getBackground() == null)
    {
      paramBaseViewHolder.uan.setBackgroundResource(2131231818);
      paramBaseViewHolder.uan.setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 8));
    }
    int i = paramBaseViewHolder.position;
    if (this.zGX != null)
    {
      paramBaseViewHolder = (WeakReference)this.zGX.AAS.get(Integer.valueOf(i - 1));
      if ((paramBaseViewHolder == null) || (paramBaseViewHolder.get() == null))
      {
        AppMethodBeat.o(219363);
        return;
      }
      ((View)paramBaseViewHolder.get()).setBackgroundResource(2131231818);
      ((View)paramBaseViewHolder.get()).setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 8));
    }
    AppMethodBeat.o(219363);
  }
  
  private static void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96121);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(96121);
      return;
    }
    if (paramBaseViewHolder.AMW != null) {
      paramBaseViewHolder.AMW.setVisibility(8);
    }
    if (paramBaseViewHolder.AMY != null) {
      paramBaseViewHolder.AMY.setVisibility(8);
    }
    if (paramBaseViewHolder.ANb != null) {
      paramBaseViewHolder.ANb.setVisibility(8);
    }
    if (paramBaseViewHolder.ANd != null) {
      paramBaseViewHolder.ANd.setVisibility(8);
    }
    if (paramBaseViewHolder.ANm.getVisibility() == 8) {
      paramBaseViewHolder.ANm.setVisibility(0);
    }
    if (paramBaseViewHolder.AMl.getVisibility() == 8) {
      paramBaseViewHolder.AMl.setVisibility(0);
    }
    if (paramBaseViewHolder.uan.getVisibility() == 8) {
      paramBaseViewHolder.uan.setVisibility(0);
    }
    AppMethodBeat.o(96121);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(96124);
    if (this.zHb.containsKey(Long.valueOf(paramLong)))
    {
      paramString = (a)this.zHb.get(Long.valueOf(paramLong));
      if (paramString.mEndTime == -1L) {
        paramString.mEndTime = System.currentTimeMillis();
      }
      paramString.J(paramString.zHp, paramString.zHq, 0, 0);
    }
    AppMethodBeat.o(96124);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bn parambn) {}
  
  public final void a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96116);
    if (!ad.foj())
    {
      e(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.zGV == null) || (this.zGV.size() == 0))
    {
      e(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if (this.zHa.contains(Long.valueOf(paramSnsObject.Id)))
    {
      e(paramBaseViewHolder);
      paramBaseViewHolder.ANm.setVisibility(8);
      paramBaseViewHolder.AMl.setVisibility(8);
      paramBaseViewHolder.uan.setVisibility(8);
      AppMethodBeat.o(96116);
      return;
    }
    if ((paramSnsObject.Username == null) || (paramSnsObject.Username.equals(ah.dXj())))
    {
      e(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.zyF != null) && (this.zyF.zHJ.contains(Long.valueOf(paramSnsObject.Id))))
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
        boolean bool = bu.cF(arrayOfByte);
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
        Object localObject2 = this.zGV.iterator();
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
        if (((d)localObject1).zHt != i) {
          continue;
        }
        if (localObject1 != null) {
          continue;
        }
        e(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        if (j < ((d)localObject1).zHu.size()) {
          continue;
        }
        e(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        localb = (d.b)((d)localObject1).zHu.get(j);
        int j = localb.dmr;
        e(paramBaseViewHolder);
        if (i <= 0) {
          continue;
        }
        if (this.zHb.containsKey(Long.valueOf(paramSnsObject.Id))) {
          continue;
        }
        localObject2 = new a(System.currentTimeMillis(), paramSnsObject.Id, com.tencent.mm.plugin.sns.data.r.zV(paramSnsObject.Id), (d)localObject1);
        ((a)localObject2).hD(j, localb.kcW.size());
        this.zHb.put(Long.valueOf(paramSnsObject.Id), localObject2);
        if (j != 1) {
          continue;
        }
        localObject2 = localb.title;
        if (paramBaseViewHolder.AMX) {
          continue;
        }
        paramBaseViewHolder.AMY = paramBaseViewHolder.AMW.inflate();
        paramBaseViewHolder.AMX = true;
        paramBaseViewHolder.ANa = ((TextView)paramBaseViewHolder.AMY.findViewById(2131303356));
        paramBaseViewHolder.AMZ = ((LinearLayout)paramBaseViewHolder.AMY.findViewById(2131296311));
        paramBaseViewHolder.AMY.setVisibility(0);
        paramBaseViewHolder.ANa.setText((CharSequence)localObject2);
        localObject2 = localb.kcW;
        if (((List)localObject2).size() == paramBaseViewHolder.AMZ.getChildCount()) {
          continue;
        }
        paramBaseViewHolder.AMZ.removeAllViews();
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        final d.a locala = (d.a)((List)localObject2).get(i);
        TextView localTextView = new TextView(paramBaseViewHolder.AMZ.getContext());
        localTextView.setText(locala.zHv);
        localTextView.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(paramContext, 10), 0);
        localTextView.setVisibility(0);
        localTextView.setTextSize(1, 14.0F * com.tencent.mm.cb.a.ef(paramContext));
        localTextView.setTextColor(paramContext.getResources().getColor(2131100914));
        paramBaseViewHolder.AMZ.addView(localTextView);
        i += 1;
        continue;
        ((a)this.zHb.get(Long.valueOf(paramSnsObject.Id))).hD(j, localb.kcW.size());
        continue;
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        locala = (d.a)((List)localObject2).get(i);
        localTextView = (TextView)paramBaseViewHolder.AMZ.getChildAt(i);
        localTextView.setText(a(paramContext, localTextView, a(f.a(locala), paramSnsObject), paramSnsObject, paramBaseViewHolder, locala, localb, (d)localObject1));
        localTextView.setTag(paramSnsObject);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96104);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            c.a(c.this, paramContext, paramAnonymousView, locala, localb, paramBaseViewHolder, this.zHi);
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
      if (this.zGY.containsKey(Long.valueOf(paramSnsObject.Id)))
      {
        k = ((Integer)this.zGY.get(Long.valueOf(paramSnsObject.Id))).intValue();
        j = k;
        if (k == -1)
        {
          e(paramBaseViewHolder);
          AppMethodBeat.o(96116);
          return;
          i = ((dhb)new dhb().parseFrom(arrayOfByte)).HOa;
          continue;
        }
      }
      int i = 0;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(96114);
    this.zGW = null;
    this.zGX = null;
    Object localObject2;
    if (this.zGZ != null)
    {
      localObject1 = this.zGZ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        com.tencent.mm.plugin.sns.model.r localr = new com.tencent.mm.plugin.sns.model.r(((Long)localObject2).longValue(), 0, 0, null);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(localr, 0);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(localObject2)));
      }
    }
    if (this.zHb != null)
    {
      localObject1 = this.zHb.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((a)((Iterator)localObject1).next());
      }
      this.zHb.clear();
    }
    if ((this.zGV.size() == 0) || (this.zyF == null))
    {
      AppMethodBeat.o(96114);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject1 = com.tencent.mm.kernel.g.ajR().cachePath + "ws_1100004";
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(localObject1)));
    try
    {
      localObject2 = this.zyF.toByteArray();
      o.f((String)localObject1, (byte[])localObject2, localObject2.length);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + this.zyF.zHJ.size());
      AppMethodBeat.o(96114);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.SnSABTestMgr", localException, "listToFile failed: ".concat(String.valueOf(localObject1)), new Object[0]);
      AppMethodBeat.o(96114);
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(179118);
    Object localObject1 = new ArrayList();
    Object localObject2 = com.tencent.mm.model.c.d.aDI().aTH("10001").values().iterator();
    label254:
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.storage.c localc = (com.tencent.mm.storage.c)((Iterator)localObject2).next();
      d locald = new d();
      if (localc == null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsABTestStrategy", "abtest is null");
      }
      else if (!localc.isValid())
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      }
      else
      {
        Map localMap = localc.fsy();
        if (localMap != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
          locald.h(localc.field_layerId, localc.field_expId, localMap);
          if ((locald.dpK) && (locald.zHu != null) && (locald.zHu.size() > 0)) {}
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
    this.zGV = ((List)localObject1);
    this.zGY.clear();
    this.zGZ.clear();
    this.zHb.clear();
    this.zyF = null;
    if ((this.zGV == null) || (this.zGV.size() == 0))
    {
      AppMethodBeat.o(179118);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject1 = com.tencent.mm.kernel.g.ajR().cachePath + "ws_1100004";
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(localObject1)));
    localObject2 = o.bb((String)localObject1, 0, -1);
    if (localObject2 != null)
    {
      try
      {
        this.zyF = ((com.tencent.mm.plugin.sns.i.c)new com.tencent.mm.plugin.sns.i.c().parseFrom((byte[])localObject2));
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - l));
        if (this.zyF == null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
          AppMethodBeat.o(179118);
          return;
        }
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.SnSABTestMgr", localIOException, "", new Object[0]);
        o.deleteFile((String)localObject1);
        AppMethodBeat.o(179118);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.zyF.zHJ.size());
    }
    AppMethodBeat.o(179118);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(96112);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnSABTestMgr", "onSceneend " + paramInt1 + " errCode " + paramInt2);
    paramString = new ni();
    com.tencent.mm.sdk.b.a.IvT.l(paramString);
    AppMethodBeat.o(96112);
  }
  
  static final class a
  {
    long mEndTime = -1L;
    long mStartTime = -1L;
    d zHo;
    int zHp = 0;
    int zHq = 0;
    String zHr = "";
    String zHs = "";
    String zrS;
    long zry;
    
    public a(long paramLong1, long paramLong2, String paramString, d paramd)
    {
      this.zHo = paramd;
      this.mStartTime = paramLong1;
      this.zry = paramLong2;
      this.zrS = paramString;
    }
    
    private void addAction(String paramString)
    {
      AppMethodBeat.i(96110);
      if (!bu.isNullOrNil(this.zHs)) {
        this.zHs += "|";
      }
      this.zHs += paramString;
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
      if ((str1.equals(this.zHr)) || ((this.zHr.startsWith(str2)) && (paramInt3 == 0) && (paramInt4 == 0)))
      {
        AppMethodBeat.o(96109);
        return;
      }
      this.zHr = str1;
      addAction(paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4);
      AppMethodBeat.o(96109);
    }
    
    public final void hD(int paramInt1, int paramInt2)
    {
      this.zHp = paramInt1;
      this.zHq = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.c
 * JD-Core Version:    0.7.0.1
 */
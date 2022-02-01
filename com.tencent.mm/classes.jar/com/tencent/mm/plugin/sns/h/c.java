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
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.na;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.ui.ad;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.sns.model.d
{
  public static final Pattern xZO;
  public static final Pattern xZP;
  private com.tencent.mm.plugin.sns.i.c xRW;
  public final int xZG;
  private List<d> xZH;
  public ListView xZI;
  public be xZJ;
  public Map<Long, Integer> xZK;
  public HashSet<Long> xZL;
  public HashSet<Long> xZM;
  private HashMap<Long, a> xZN;
  private p.a xZQ;
  public final int xZd;
  
  static
  {
    AppMethodBeat.i(96128);
    xZO = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    xZP = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    AppMethodBeat.o(96128);
  }
  
  public c()
  {
    AppMethodBeat.i(96111);
    this.xZd = 14;
    this.xZG = 500;
    this.xZK = new HashMap();
    this.xZL = new HashSet();
    this.xZM = new HashSet();
    this.xZN = new HashMap();
    this.xZQ = new p.a()
    {
      public final void b(View paramAnonymousView, Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(96111);
  }
  
  private SpannableString a(final Context paramContext, TextView paramTextView, String paramString, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.a parama, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96123);
    Object localObject = xZO.matcher(paramString);
    if ((((Matcher)localObject).find()) && (((Matcher)localObject).groupCount() == 1))
    {
      String str = ((Matcher)localObject).group();
      localObject = ((Matcher)localObject).group(1);
      int i = paramString.indexOf(str);
      paramString = paramString.replace(str, (CharSequence)localObject);
      paramTextView.setOnClickListener(null);
      paramTextView.setClickable(true);
      paramString = new SpannableString(paramString);
      paramTextView.setOnTouchListener(new ad());
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
    paramContext = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, paramString);
    AppMethodBeat.o(96123);
    return paramContext;
  }
  
  private static String a(String paramString, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(96122);
    Object localObject = paramString;
    try
    {
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(96122);
        return "";
      }
      localObject = paramString;
      paramSnsObject = paramSnsObject.Username;
      localObject = paramString;
      com.tencent.mm.kernel.g.agS();
      localObject = paramString;
      ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramSnsObject);
      paramSnsObject = paramString;
      localObject = paramString;
      if (paramString.contains("{username}"))
      {
        localObject = paramString;
        paramSnsObject = paramString.replace("{username}", localai.aaS());
      }
      localObject = paramSnsObject;
      int i = localai.exL;
      if (i == 1)
      {
        i = 0;
        paramString = paramSnsObject;
      }
      ac.printErrStackTrace("MicroMsg.SnSABTestMgr", paramSnsObject, "settext error ", new Object[0]);
    }
    catch (Exception paramSnsObject)
    {
      try
      {
        paramSnsObject = xZP.matcher(paramString);
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
            i = localai.exL;
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
    ac.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + paramSnsObject.Username + " " + paramSnsObject.Id);
    int i = parama.yak - 1;
    a locala = (a)this.xZN.get(Long.valueOf(paramSnsObject.Id));
    if (locala != null)
    {
      locala.J(paramb.cZX, paramb.jFA.size(), parama.index, parama.actionType);
      locala.yab = -1;
      locala.yac = -1;
    }
    if (parama.actionType == 3)
    {
      this.xZL.add(Long.valueOf(paramSnsObject.Id));
      this.xZK.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
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
        this.xZK.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
        xv(paramSnsObject.Id);
        b(paramBaseViewHolder);
      }
      else
      {
        if (parama.actionType == 5)
        {
          if (this.xZL.contains(Long.valueOf(paramSnsObject.Id)))
          {
            this.xZL.remove(Long.valueOf(paramSnsObject.Id));
            xv(paramSnsObject.Id);
            b(paramBaseViewHolder);
            if (this.xZN.containsKey(Long.valueOf(paramSnsObject.Id))) {
              a((a)this.xZN.remove(Long.valueOf(paramSnsObject.Id)));
            }
          }
          this.xZK.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(-1));
          a(paramBaseViewHolder);
          AppMethodBeat.o(96120);
          return;
        }
        if (parama.actionType == 7)
        {
          if (i < paramd.yah.size())
          {
            parama = (d.b)paramd.yah.get(i);
            if (parama.cZX == 2)
            {
              b(paramContext, paramSnsObject, paramBaseViewHolder, parama, paramd);
              AppMethodBeat.o(96120);
              return;
            }
            if (parama.cZX == 5)
            {
              t.makeText(paramContext, bs.bG(parama.title, ""), 0).show();
              xv(paramSnsObject.Id);
              b(paramBaseViewHolder);
              AppMethodBeat.o(96120);
            }
          }
        }
        else
        {
          if (parama.actionType == 6)
          {
            t.makeText(paramContext, bs.bG(paramContext.getString(2131763729), ""), 0).show();
            this.xZM.add(Long.valueOf(paramSnsObject.Id));
            b(paramBaseViewHolder);
            paramContext = new na();
            com.tencent.mm.sdk.b.a.GpY.l(paramContext);
            a(paramBaseViewHolder);
            AppMethodBeat.o(96120);
            return;
          }
          if (parama.actionType == 2)
          {
            parama = parama.jumpUrl;
            ac.i("MicroMsg.SnSABTestMgr", "jump url ".concat(String.valueOf(parama)));
            paramb = new Intent();
            paramb.putExtra("rawUrl", parama);
            paramb.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.iyx.i(paramb, paramContext);
            xv(paramSnsObject.Id);
            b(paramBaseViewHolder);
            a(paramBaseViewHolder);
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
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(parama, 0);
          }
        }
      }
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(96125);
    Object localObject = parama.yaa;
    if (localObject == null)
    {
      AppMethodBeat.o(96125);
      return;
    }
    String str2 = ((d)localObject).xZF;
    String str3 = ((d)localObject).xZE;
    String str4 = parama.yaf;
    parama.J(parama.yab, parama.yac, 0, 0);
    String str1 = parama.yae;
    localObject = str1;
    if (bs.isNullOrNil(str1)) {
      localObject = parama.yab + ":" + parama.yac + ":0:0";
    }
    long l1 = parama.mStartTime / 1000L;
    if (parama.mEndTime == -1L) {
      parama.mEndTime = System.currentTimeMillis();
    }
    long l2 = parama.mEndTime / 1000L;
    if (parama != null)
    {
      ac.i("MicroMsg.SnSABTestMgr", "report layerId: " + str2 + " expid " + str3 + " acton " + (String)localObject + " starttime " + l1 + " timelineId: " + str4);
      com.tencent.mm.plugin.report.service.h.wUl.f(11917, new Object[] { str2, str3, "", "", Integer.valueOf(1), str4, localObject, Long.valueOf(l1), Long.valueOf(l2) });
    }
    AppMethodBeat.o(96125);
  }
  
  private void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96119);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(96119);
      return;
    }
    Context localContext = paramBaseViewHolder.sSS.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(96119);
      return;
    }
    if (paramBaseViewHolder.sSS.getBackground() == null)
    {
      paramBaseViewHolder.sSS.setBackgroundResource(2131231818);
      paramBaseViewHolder.sSS.setPadding(com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 8));
    }
    int i = paramBaseViewHolder.position;
    if (this.xZJ != null)
    {
      paramBaseViewHolder = (WeakReference)this.xZJ.ySf.get(Integer.valueOf(i - 1));
      if ((paramBaseViewHolder == null) || (paramBaseViewHolder.get() == null))
      {
        AppMethodBeat.o(96119);
        return;
      }
      ((View)paramBaseViewHolder.get()).setBackgroundResource(2131231818);
      ((View)paramBaseViewHolder.get()).setPadding(com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 12), com.tencent.mm.cc.a.fromDPToPix(localContext, 8));
    }
    AppMethodBeat.o(96119);
  }
  
  private boolean a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96117);
    paramBaseViewHolder.sSS.setBackgroundDrawable(null);
    int i = paramBaseViewHolder.position;
    Object localObject1;
    if (this.xZJ != null)
    {
      localObject1 = (WeakReference)this.xZJ.ySf.get(Integer.valueOf(i - 1));
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        break label260;
      }
    }
    Object localObject2;
    for (;;)
    {
      if (!paramBaseViewHolder.zdV)
      {
        paramBaseViewHolder.zdW = paramBaseViewHolder.zdU.inflate();
        paramBaseViewHolder.zdV = true;
        paramBaseViewHolder.zdX = ((LinearLayout)paramBaseViewHolder.zdW.findViewById(2131304888));
      }
      paramBaseViewHolder.zdW.setVisibility(0);
      paramBaseViewHolder.zef.setVisibility(8);
      paramBaseViewHolder.zdf.setVisibility(8);
      localObject1 = paramb.jFA;
      if (((List)localObject1).size() == paramBaseViewHolder.zdX.getChildCount()) {
        break;
      }
      paramBaseViewHolder.zdX.removeAllViews();
      int j = com.tencent.mm.cc.a.fromDPToPix(paramContext, 10);
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setBackgroundResource(2131230902);
        ((TextView)localObject2).setPadding(j, j, j, j);
        ((TextView)localObject2).setTextSize(1, 14.0F * com.tencent.mm.cc.a.eb(paramContext));
        ((TextView)localObject2).setTextColor(paramContext.getResources().getColor(2131100711));
        paramBaseViewHolder.zdX.addView((View)localObject2);
        i += 1;
      }
      label260:
      ((View)((WeakReference)localObject1).get()).setBackgroundDrawable(null);
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (d.a)((List)localObject1).get(i);
      TextView localTextView = (TextView)paramBaseViewHolder.zdX.getChildAt(i);
      localTextView.setText(((d.a)localObject2).yai);
      localTextView.setTag(paramSnsObject);
      String str = a(f.a((d.a)localObject2), paramSnsObject);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96105);
          c.a(c.this, paramContext, paramAnonymousView, this.xZR, paramb, paramBaseViewHolder, paramd);
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
  
  private static void b(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96121);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(96121);
      return;
    }
    if (paramBaseViewHolder.zdP != null) {
      paramBaseViewHolder.zdP.setVisibility(8);
    }
    if (paramBaseViewHolder.zdR != null) {
      paramBaseViewHolder.zdR.setVisibility(8);
    }
    if (paramBaseViewHolder.zdU != null) {
      paramBaseViewHolder.zdU.setVisibility(8);
    }
    if (paramBaseViewHolder.zdW != null) {
      paramBaseViewHolder.zdW.setVisibility(8);
    }
    if (paramBaseViewHolder.zef.getVisibility() == 8) {
      paramBaseViewHolder.zef.setVisibility(0);
    }
    if (paramBaseViewHolder.zdf.getVisibility() == 8) {
      paramBaseViewHolder.zdf.setVisibility(0);
    }
    if (paramBaseViewHolder.sSS.getVisibility() == 8) {
      paramBaseViewHolder.sSS.setVisibility(0);
    }
    AppMethodBeat.o(96121);
  }
  
  private boolean b(final Context paramContext, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96118);
    if (paramb.jFA.size() == 2)
    {
      final d.a locala1 = (d.a)paramb.jFA.get(0);
      final d.a locala2 = (d.a)paramb.jFA.get(1);
      String str1 = a(f.a(locala1), paramSnsObject);
      String str2 = a(f.a(locala2), paramSnsObject);
      com.tencent.mm.ui.base.h.d(paramContext, a(paramb.title, paramSnsObject), paramContext.getString(2131755906), str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(96106);
          ac.i("MicroMsg.SnSABTestMgr", "onClick alert1");
          c.a(c.this, paramContext, paramSnsObject, locala1, paramb, paramBaseViewHolder, paramd);
          AppMethodBeat.o(96106);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(96107);
          ac.i("MicroMsg.SnSABTestMgr", "onClick alert2");
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
    paramBaseViewHolder.zdQ = false;
    paramBaseViewHolder.zdP = ((ViewStub)paramView.findViewById(2131305043));
    paramBaseViewHolder.zdP.setVisibility(8);
    paramBaseViewHolder.zdU = ((ViewStub)paramView.findViewById(2131304986));
    paramBaseViewHolder.zdU.setVisibility(8);
    AppMethodBeat.o(96115);
  }
  
  private void xv(long paramLong)
  {
    AppMethodBeat.i(96113);
    if (this.xRW == null) {
      this.xRW = new com.tencent.mm.plugin.sns.i.c();
    }
    if (this.xRW.yay.size() > 500) {
      this.xRW.yay.remove(0);
    }
    this.xRW.yay.add(Long.valueOf(paramLong));
    AppMethodBeat.o(96113);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(96124);
    if (this.xZN.containsKey(Long.valueOf(paramLong)))
    {
      paramString = (a)this.xZN.get(Long.valueOf(paramLong));
      if (paramString.mEndTime == -1L) {
        paramString.mEndTime = System.currentTimeMillis();
      }
      paramString.J(paramString.yab, paramString.yac, 0, 0);
    }
    AppMethodBeat.o(96124);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bk parambk) {}
  
  public final void a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96116);
    if (!ab.eUL())
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.xZH == null) || (this.xZH.size() == 0))
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if (this.xZM.contains(Long.valueOf(paramSnsObject.Id)))
    {
      b(paramBaseViewHolder);
      paramBaseViewHolder.zef.setVisibility(8);
      paramBaseViewHolder.zdf.setVisibility(8);
      paramBaseViewHolder.sSS.setVisibility(8);
      AppMethodBeat.o(96116);
      return;
    }
    if ((paramSnsObject.Username == null) || (paramSnsObject.Username.equals(af.dHx())))
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.xRW != null) && (this.xRW.yay.contains(Long.valueOf(paramSnsObject.Id))))
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if (paramSnsObject != null) {}
    for (;;)
    {
      try
      {
        arrayOfByte = z.a(paramSnsObject.ObjectOperations);
        boolean bool = bs.cv(arrayOfByte);
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
        Object localObject2 = this.xZH.iterator();
        Object localObject1 = localb;
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject1 = (d)((Iterator)localObject2).next();
        if (localObject1 != null) {
          continue;
        }
        b(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        if (((d)localObject1).yag != i) {
          continue;
        }
        if (localObject1 != null) {
          continue;
        }
        b(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        if (j < ((d)localObject1).yah.size()) {
          continue;
        }
        b(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        localb = (d.b)((d)localObject1).yah.get(j);
        int j = localb.cZX;
        b(paramBaseViewHolder);
        if (i <= 0) {
          continue;
        }
        if (this.xZN.containsKey(Long.valueOf(paramSnsObject.Id))) {
          continue;
        }
        localObject2 = new a(System.currentTimeMillis(), paramSnsObject.Id, com.tencent.mm.plugin.sns.data.q.wW(paramSnsObject.Id), (d)localObject1);
        ((a)localObject2).hj(j, localb.jFA.size());
        this.xZN.put(Long.valueOf(paramSnsObject.Id), localObject2);
        if (j != 1) {
          continue;
        }
        localObject2 = localb.title;
        if (paramBaseViewHolder.zdQ) {
          continue;
        }
        paramBaseViewHolder.zdR = paramBaseViewHolder.zdP.inflate();
        paramBaseViewHolder.zdQ = true;
        paramBaseViewHolder.zdT = ((TextView)paramBaseViewHolder.zdR.findViewById(2131303356));
        paramBaseViewHolder.zdS = ((LinearLayout)paramBaseViewHolder.zdR.findViewById(2131296311));
        paramBaseViewHolder.zdR.setVisibility(0);
        paramBaseViewHolder.zdT.setText((CharSequence)localObject2);
        localObject2 = localb.jFA;
        if (((List)localObject2).size() == paramBaseViewHolder.zdS.getChildCount()) {
          continue;
        }
        paramBaseViewHolder.zdS.removeAllViews();
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        final d.a locala = (d.a)((List)localObject2).get(i);
        TextView localTextView = new TextView(paramBaseViewHolder.zdS.getContext());
        localTextView.setText(locala.yai);
        localTextView.setPadding(0, 0, com.tencent.mm.cc.a.fromDPToPix(paramContext, 10), 0);
        localTextView.setVisibility(0);
        localTextView.setTextSize(1, 14.0F * com.tencent.mm.cc.a.eb(paramContext));
        localTextView.setTextColor(paramContext.getResources().getColor(2131100914));
        paramBaseViewHolder.zdS.addView(localTextView);
        i += 1;
        continue;
        ((a)this.xZN.get(Long.valueOf(paramSnsObject.Id))).hj(j, localb.jFA.size());
        continue;
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        locala = (d.a)((List)localObject2).get(i);
        localTextView = (TextView)paramBaseViewHolder.zdS.getChildAt(i);
        localTextView.setText(a(paramContext, localTextView, a(f.a(locala), paramSnsObject), paramSnsObject, paramBaseViewHolder, locala, localb, (d)localObject1));
        localTextView.setTag(paramSnsObject);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96104);
            c.a(c.this, paramContext, paramAnonymousView, locala, localb, paramBaseViewHolder, this.xZU);
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
        b(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
      }
      j = 0;
      if (this.xZK.containsKey(Long.valueOf(paramSnsObject.Id)))
      {
        k = ((Integer)this.xZK.get(Long.valueOf(paramSnsObject.Id))).intValue();
        j = k;
        if (k == -1)
        {
          b(paramBaseViewHolder);
          AppMethodBeat.o(96116);
          return;
          i = ((dau)new dau().parseFrom(arrayOfByte)).FJP;
          continue;
        }
      }
      int i = 0;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(96114);
    this.xZI = null;
    this.xZJ = null;
    Object localObject2;
    if (this.xZL != null)
    {
      localObject1 = this.xZL.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        com.tencent.mm.plugin.sns.model.q localq = new com.tencent.mm.plugin.sns.model.q(((Long)localObject2).longValue(), 0, 0, null);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(localq, 0);
        ac.i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(localObject2)));
      }
    }
    if (this.xZN != null)
    {
      localObject1 = this.xZN.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((a)((Iterator)localObject1).next());
      }
      this.xZN.clear();
    }
    if ((this.xZH.size() == 0) || (this.xRW == null))
    {
      AppMethodBeat.o(96114);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject1 = com.tencent.mm.kernel.g.agR().cachePath + "ws_1100004";
    ac.i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(localObject1)));
    try
    {
      localObject2 = this.xRW.toByteArray();
      i.f((String)localObject1, (byte[])localObject2, localObject2.length);
      ac.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + this.xRW.yay.size());
      AppMethodBeat.o(96114);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SnSABTestMgr", localException, "listToFile failed: ".concat(String.valueOf(localObject1)), new Object[0]);
      AppMethodBeat.o(96114);
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(179118);
    Object localObject1 = new ArrayList();
    Object localObject2 = com.tencent.mm.model.c.d.aAp().aMD("10001").values().iterator();
    label254:
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.storage.c localc = (com.tencent.mm.storage.c)((Iterator)localObject2).next();
      d locald = new d();
      if (localc == null)
      {
        ac.i("MicroMsg.SnsABTestStrategy", "abtest is null");
      }
      else if (!localc.isValid())
      {
        ac.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      }
      else
      {
        Map localMap = localc.eYV();
        if (localMap != null)
        {
          ac.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
          locald.h(localc.field_layerId, localc.field_expId, localMap);
          if ((locald.ddj) && (locald.yah != null) && (locald.yah.size() > 0)) {}
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
    this.xZH = ((List)localObject1);
    this.xZK.clear();
    this.xZL.clear();
    this.xZN.clear();
    this.xRW = null;
    if ((this.xZH == null) || (this.xZH.size() == 0))
    {
      AppMethodBeat.o(179118);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject1 = com.tencent.mm.kernel.g.agR().cachePath + "ws_1100004";
    ac.i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(localObject1)));
    localObject2 = i.aU((String)localObject1, 0, -1);
    if (localObject2 != null)
    {
      try
      {
        this.xRW = ((com.tencent.mm.plugin.sns.i.c)new com.tencent.mm.plugin.sns.i.c().parseFrom((byte[])localObject2));
        ac.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - l));
        if (this.xRW == null)
        {
          ac.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
          AppMethodBeat.o(179118);
          return;
        }
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.SnSABTestMgr", localIOException, "", new Object[0]);
        i.deleteFile((String)localObject1);
        AppMethodBeat.o(179118);
        return;
      }
      ac.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.xRW.yay.size());
    }
    AppMethodBeat.o(179118);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(96112);
    ac.i("MicroMsg.SnSABTestMgr", "onSceneend " + paramInt1 + " errCode " + paramInt2);
    paramString = new mz();
    com.tencent.mm.sdk.b.a.GpY.l(paramString);
    AppMethodBeat.o(96112);
  }
  
  static final class a
  {
    long mEndTime = -1L;
    long mStartTime = -1L;
    long xLI;
    d yaa;
    int yab = 0;
    int yac = 0;
    String yad = "";
    String yae = "";
    String yaf;
    
    public a(long paramLong1, long paramLong2, String paramString, d paramd)
    {
      this.yaa = paramd;
      this.mStartTime = paramLong1;
      this.xLI = paramLong2;
      this.yaf = paramString;
    }
    
    private void addAction(String paramString)
    {
      AppMethodBeat.i(96110);
      if (!bs.isNullOrNil(this.yae)) {
        this.yae += "|";
      }
      this.yae += paramString;
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
      if ((str1.equals(this.yad)) || ((this.yad.startsWith(str2)) && (paramInt3 == 0) && (paramInt4 == 0)))
      {
        AppMethodBeat.o(96109);
        return;
      }
      this.yad = str1;
      addAction(paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4);
      AppMethodBeat.o(96109);
    }
    
    public final void hj(int paramInt1, int paramInt2)
    {
      this.yab = paramInt1;
      this.yac = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.c
 * JD-Core Version:    0.7.0.1
 */
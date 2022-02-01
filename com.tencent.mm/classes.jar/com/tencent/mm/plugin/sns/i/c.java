package com.tencent.mm.plugin.sns.i;

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
import com.tencent.mm.g.a.mq;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
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
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.sns.model.d
{
  public static final Pattern wNi;
  public static final Pattern wNj;
  private com.tencent.mm.plugin.sns.j.c wFC;
  public final int wMx;
  public final int wNa;
  private List<d> wNb;
  public ListView wNc;
  public be wNd;
  public Map<Long, Integer> wNe;
  public HashSet<Long> wNf;
  public HashSet<Long> wNg;
  private HashMap<Long, a> wNh;
  private p.a wNk;
  
  static
  {
    AppMethodBeat.i(96128);
    wNi = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    wNj = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    AppMethodBeat.o(96128);
  }
  
  public c()
  {
    AppMethodBeat.i(96111);
    this.wMx = 14;
    this.wNa = 500;
    this.wNe = new HashMap();
    this.wNf = new HashSet();
    this.wNg = new HashSet();
    this.wNh = new HashMap();
    this.wNk = new p.a()
    {
      public final void b(View paramAnonymousView, Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(96111);
  }
  
  private SpannableString a(final Context paramContext, TextView paramTextView, String paramString, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.a parama, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96123);
    Object localObject = wNi.matcher(paramString);
    if ((((Matcher)localObject).find()) && (((Matcher)localObject).groupCount() == 1))
    {
      String str = ((Matcher)localObject).group();
      localObject = ((Matcher)localObject).group(1);
      int i = paramString.indexOf(str);
      paramString = paramString.replace(str, (CharSequence)localObject);
      paramTextView.setOnClickListener(null);
      paramTextView.setClickable(true);
      paramString = new SpannableString(paramString);
      paramTextView.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ad());
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
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(96122);
        return "";
      }
      localObject = paramString;
      paramSnsObject = paramSnsObject.Username;
      localObject = paramString;
      com.tencent.mm.kernel.g.afC();
      localObject = paramString;
      com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramSnsObject);
      paramSnsObject = paramString;
      localObject = paramString;
      if (paramString.contains("{username}"))
      {
        localObject = paramString;
        paramSnsObject = paramString.replace("{username}", localaf.ZX());
      }
      localObject = paramSnsObject;
      int i = localaf.evp;
      if (i == 1)
      {
        i = 0;
        paramString = paramSnsObject;
      }
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnSABTestMgr", paramSnsObject, "settext error ", new Object[0]);
    }
    catch (Exception paramSnsObject)
    {
      try
      {
        paramSnsObject = wNj.matcher(paramString);
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
            i = localaf.evp;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + paramSnsObject.Username + " " + paramSnsObject.Id);
    int i = parama.wNE - 1;
    a locala = (a)this.wNh.get(Long.valueOf(paramSnsObject.Id));
    if (locala != null)
    {
      locala.H(paramb.dcz, paramb.jfl.size(), parama.index, parama.actionType);
      locala.wNv = -1;
      locala.wNw = -1;
    }
    if (parama.actionType == 3)
    {
      this.wNf.add(Long.valueOf(paramSnsObject.Id));
      this.wNe.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
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
        this.wNe.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
        sS(paramSnsObject.Id);
        b(paramBaseViewHolder);
      }
      else
      {
        if (parama.actionType == 5)
        {
          if (this.wNf.contains(Long.valueOf(paramSnsObject.Id)))
          {
            this.wNf.remove(Long.valueOf(paramSnsObject.Id));
            sS(paramSnsObject.Id);
            b(paramBaseViewHolder);
            if (this.wNh.containsKey(Long.valueOf(paramSnsObject.Id))) {
              a((a)this.wNh.remove(Long.valueOf(paramSnsObject.Id)));
            }
          }
          this.wNe.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(-1));
          a(paramBaseViewHolder);
          AppMethodBeat.o(96120);
          return;
        }
        if (parama.actionType == 7)
        {
          if (i < paramd.wNB.size())
          {
            parama = (d.b)paramd.wNB.get(i);
            if (parama.dcz == 2)
            {
              b(paramContext, paramSnsObject, paramBaseViewHolder, parama, paramd);
              AppMethodBeat.o(96120);
              return;
            }
            if (parama.dcz == 5)
            {
              t.makeText(paramContext, bt.by(parama.title, ""), 0).show();
              sS(paramSnsObject.Id);
              b(paramBaseViewHolder);
              AppMethodBeat.o(96120);
            }
          }
        }
        else
        {
          if (parama.actionType == 6)
          {
            t.makeText(paramContext, bt.by(paramContext.getString(2131763729), ""), 0).show();
            this.wNg.add(Long.valueOf(paramSnsObject.Id));
            b(paramBaseViewHolder);
            paramContext = new mr();
            com.tencent.mm.sdk.b.a.ESL.l(paramContext);
            a(paramBaseViewHolder);
            AppMethodBeat.o(96120);
            return;
          }
          if (parama.actionType == 2)
          {
            parama = parama.jumpUrl;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "jump url ".concat(String.valueOf(parama)));
            paramb = new Intent();
            paramb.putExtra("rawUrl", parama);
            paramb.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.d.a.hYt.i(paramb, paramContext);
            sS(paramSnsObject.Id);
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
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(parama, 0);
          }
        }
      }
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(96125);
    Object localObject = parama.wNu;
    if (localObject == null)
    {
      AppMethodBeat.o(96125);
      return;
    }
    String str2 = ((d)localObject).wMZ;
    String str3 = ((d)localObject).wMY;
    String str4 = parama.wNz;
    parama.H(parama.wNv, parama.wNw, 0, 0);
    String str1 = parama.wNy;
    localObject = str1;
    if (bt.isNullOrNil(str1)) {
      localObject = parama.wNv + ":" + parama.wNw + ":0:0";
    }
    long l1 = parama.mStartTime / 1000L;
    if (parama.mEndTime == -1L) {
      parama.mEndTime = System.currentTimeMillis();
    }
    long l2 = parama.mEndTime / 1000L;
    if (parama != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "report layerId: " + str2 + " expid " + str3 + " acton " + (String)localObject + " starttime " + l1 + " timelineId: " + str4);
      com.tencent.mm.plugin.report.service.h.vKh.f(11917, new Object[] { str2, str3, "", "", Integer.valueOf(1), str4, localObject, Long.valueOf(l1), Long.valueOf(l2) });
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
    Context localContext = paramBaseViewHolder.rLd.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(96119);
      return;
    }
    if (paramBaseViewHolder.rLd.getBackground() == null)
    {
      paramBaseViewHolder.rLd.setBackgroundResource(2131231818);
      paramBaseViewHolder.rLd.setPadding(com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 8));
    }
    int i = paramBaseViewHolder.position;
    if (this.wNd != null)
    {
      paramBaseViewHolder = (WeakReference)this.wNd.xFs.get(Integer.valueOf(i - 1));
      if ((paramBaseViewHolder == null) || (paramBaseViewHolder.get() == null))
      {
        AppMethodBeat.o(96119);
        return;
      }
      ((View)paramBaseViewHolder.get()).setBackgroundResource(2131231818);
      ((View)paramBaseViewHolder.get()).setPadding(com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 8));
    }
    AppMethodBeat.o(96119);
  }
  
  private boolean a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96117);
    paramBaseViewHolder.rLd.setBackgroundDrawable(null);
    int i = paramBaseViewHolder.position;
    Object localObject1;
    if (this.wNd != null)
    {
      localObject1 = (WeakReference)this.wNd.xFs.get(Integer.valueOf(i - 1));
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        break label260;
      }
    }
    Object localObject2;
    for (;;)
    {
      if (!paramBaseViewHolder.xRf)
      {
        paramBaseViewHolder.xRg = paramBaseViewHolder.xRe.inflate();
        paramBaseViewHolder.xRf = true;
        paramBaseViewHolder.xRh = ((LinearLayout)paramBaseViewHolder.xRg.findViewById(2131304888));
      }
      paramBaseViewHolder.xRg.setVisibility(0);
      paramBaseViewHolder.xRp.setVisibility(8);
      paramBaseViewHolder.xQp.setVisibility(8);
      localObject1 = paramb.jfl;
      if (((List)localObject1).size() == paramBaseViewHolder.xRh.getChildCount()) {
        break;
      }
      paramBaseViewHolder.xRh.removeAllViews();
      int j = com.tencent.mm.cd.a.fromDPToPix(paramContext, 10);
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setBackgroundResource(2131230902);
        ((TextView)localObject2).setPadding(j, j, j, j);
        ((TextView)localObject2).setTextSize(1, 14.0F * com.tencent.mm.cd.a.dT(paramContext));
        ((TextView)localObject2).setTextColor(paramContext.getResources().getColor(2131100711));
        paramBaseViewHolder.xRh.addView((View)localObject2);
        i += 1;
      }
      label260:
      ((View)((WeakReference)localObject1).get()).setBackgroundDrawable(null);
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (d.a)((List)localObject1).get(i);
      TextView localTextView = (TextView)paramBaseViewHolder.xRh.getChildAt(i);
      localTextView.setText(((d.a)localObject2).wNC);
      localTextView.setTag(paramSnsObject);
      String str = a(f.a((d.a)localObject2), paramSnsObject);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96105);
          c.a(c.this, paramContext, paramAnonymousView, this.wNl, paramb, paramBaseViewHolder, paramd);
          AppMethodBeat.o(96105);
        }
      });
      localTextView.setText(a(paramContext, localTextView, str, paramSnsObject, paramBaseViewHolder, (d.a)localObject2, paramb, paramd), TextView.BufferType.SPANNABLE);
      if (((d.a)localObject2).actionType != 5)
      {
        localTextView.setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(paramContext, 5));
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
    if (paramBaseViewHolder.xQZ != null) {
      paramBaseViewHolder.xQZ.setVisibility(8);
    }
    if (paramBaseViewHolder.xRb != null) {
      paramBaseViewHolder.xRb.setVisibility(8);
    }
    if (paramBaseViewHolder.xRe != null) {
      paramBaseViewHolder.xRe.setVisibility(8);
    }
    if (paramBaseViewHolder.xRg != null) {
      paramBaseViewHolder.xRg.setVisibility(8);
    }
    if (paramBaseViewHolder.xRp.getVisibility() == 8) {
      paramBaseViewHolder.xRp.setVisibility(0);
    }
    if (paramBaseViewHolder.xQp.getVisibility() == 8) {
      paramBaseViewHolder.xQp.setVisibility(0);
    }
    if (paramBaseViewHolder.rLd.getVisibility() == 8) {
      paramBaseViewHolder.rLd.setVisibility(0);
    }
    AppMethodBeat.o(96121);
  }
  
  private boolean b(final Context paramContext, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96118);
    if (paramb.jfl.size() == 2)
    {
      final d.a locala1 = (d.a)paramb.jfl.get(0);
      final d.a locala2 = (d.a)paramb.jfl.get(1);
      String str1 = a(f.a(locala1), paramSnsObject);
      String str2 = a(f.a(locala2), paramSnsObject);
      com.tencent.mm.ui.base.h.d(paramContext, a(paramb.title, paramSnsObject), paramContext.getString(2131755906), str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(96106);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "onClick alert1");
          c.a(c.this, paramContext, paramSnsObject, locala1, paramb, paramBaseViewHolder, paramd);
          AppMethodBeat.o(96106);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(96107);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "onClick alert2");
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
    paramBaseViewHolder.xRa = false;
    paramBaseViewHolder.xQZ = ((ViewStub)paramView.findViewById(2131305043));
    paramBaseViewHolder.xQZ.setVisibility(8);
    paramBaseViewHolder.xRe = ((ViewStub)paramView.findViewById(2131304986));
    paramBaseViewHolder.xRe.setVisibility(8);
    AppMethodBeat.o(96115);
  }
  
  private void sS(long paramLong)
  {
    AppMethodBeat.i(96113);
    if (this.wFC == null) {
      this.wFC = new com.tencent.mm.plugin.sns.j.c();
    }
    if (this.wFC.wNR.size() > 500) {
      this.wFC.wNR.remove(0);
    }
    this.wFC.wNR.add(Long.valueOf(paramLong));
    AppMethodBeat.o(96113);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(96124);
    if (this.wNh.containsKey(Long.valueOf(paramLong)))
    {
      paramString = (a)this.wNh.get(Long.valueOf(paramLong));
      if (paramString.mEndTime == -1L) {
        paramString.mEndTime = System.currentTimeMillis();
      }
      paramString.H(paramString.wNv, paramString.wNw, 0, 0);
    }
    AppMethodBeat.o(96124);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bk parambk) {}
  
  public final void a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96116);
    if (!ac.eFr())
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.wNb == null) || (this.wNb.size() == 0))
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if (this.wNg.contains(Long.valueOf(paramSnsObject.Id)))
    {
      b(paramBaseViewHolder);
      paramBaseViewHolder.xRp.setVisibility(8);
      paramBaseViewHolder.xQp.setVisibility(8);
      paramBaseViewHolder.rLd.setVisibility(8);
      AppMethodBeat.o(96116);
      return;
    }
    if ((paramSnsObject.Username == null) || (paramSnsObject.Username.equals(com.tencent.mm.plugin.sns.model.af.dta())))
    {
      b(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.wFC != null) && (this.wFC.wNR.contains(Long.valueOf(paramSnsObject.Id))))
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
        boolean bool = bt.cw(arrayOfByte);
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
        Object localObject2 = this.wNb.iterator();
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
        if (((d)localObject1).wNA != i) {
          continue;
        }
        if (localObject1 != null) {
          continue;
        }
        b(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        if (j < ((d)localObject1).wNB.size()) {
          continue;
        }
        b(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        localb = (d.b)((d)localObject1).wNB.get(j);
        int j = localb.dcz;
        b(paramBaseViewHolder);
        if (i <= 0) {
          continue;
        }
        if (this.wNh.containsKey(Long.valueOf(paramSnsObject.Id))) {
          continue;
        }
        localObject2 = new a(System.currentTimeMillis(), paramSnsObject.Id, com.tencent.mm.plugin.sns.data.q.st(paramSnsObject.Id), (d)localObject1);
        ((a)localObject2).ha(j, localb.jfl.size());
        this.wNh.put(Long.valueOf(paramSnsObject.Id), localObject2);
        if (j != 1) {
          continue;
        }
        localObject2 = localb.title;
        if (paramBaseViewHolder.xRa) {
          continue;
        }
        paramBaseViewHolder.xRb = paramBaseViewHolder.xQZ.inflate();
        paramBaseViewHolder.xRa = true;
        paramBaseViewHolder.xRd = ((TextView)paramBaseViewHolder.xRb.findViewById(2131303356));
        paramBaseViewHolder.xRc = ((LinearLayout)paramBaseViewHolder.xRb.findViewById(2131296311));
        paramBaseViewHolder.xRb.setVisibility(0);
        paramBaseViewHolder.xRd.setText((CharSequence)localObject2);
        localObject2 = localb.jfl;
        if (((List)localObject2).size() == paramBaseViewHolder.xRc.getChildCount()) {
          continue;
        }
        paramBaseViewHolder.xRc.removeAllViews();
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        final d.a locala = (d.a)((List)localObject2).get(i);
        TextView localTextView = new TextView(paramBaseViewHolder.xRc.getContext());
        localTextView.setText(locala.wNC);
        localTextView.setPadding(0, 0, com.tencent.mm.cd.a.fromDPToPix(paramContext, 10), 0);
        localTextView.setVisibility(0);
        localTextView.setTextSize(1, 14.0F * com.tencent.mm.cd.a.dT(paramContext));
        localTextView.setTextColor(paramContext.getResources().getColor(2131100914));
        paramBaseViewHolder.xRc.addView(localTextView);
        i += 1;
        continue;
        ((a)this.wNh.get(Long.valueOf(paramSnsObject.Id))).ha(j, localb.jfl.size());
        continue;
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        locala = (d.a)((List)localObject2).get(i);
        localTextView = (TextView)paramBaseViewHolder.xRc.getChildAt(i);
        localTextView.setText(a(paramContext, localTextView, a(f.a(locala), paramSnsObject), paramSnsObject, paramBaseViewHolder, locala, localb, (d)localObject1));
        localTextView.setTag(paramSnsObject);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96104);
            c.a(c.this, paramContext, paramAnonymousView, locala, localb, paramBaseViewHolder, this.wNo);
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
      if (this.wNe.containsKey(Long.valueOf(paramSnsObject.Id)))
      {
        k = ((Integer)this.wNe.get(Long.valueOf(paramSnsObject.Id))).intValue();
        j = k;
        if (k == -1)
        {
          b(paramBaseViewHolder);
          AppMethodBeat.o(96116);
          return;
          i = ((cvi)new cvi().parseFrom(arrayOfByte)).EmQ;
          continue;
        }
      }
      int i = 0;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(96114);
    this.wNc = null;
    this.wNd = null;
    Object localObject2;
    if (this.wNf != null)
    {
      localObject1 = this.wNf.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        com.tencent.mm.plugin.sns.model.q localq = new com.tencent.mm.plugin.sns.model.q(((Long)localObject2).longValue(), 0, 0, null);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(localq, 0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(localObject2)));
      }
    }
    if (this.wNh != null)
    {
      localObject1 = this.wNh.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((a)((Iterator)localObject1).next());
      }
      this.wNh.clear();
    }
    if ((this.wNb.size() == 0) || (this.wFC == null))
    {
      AppMethodBeat.o(96114);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject1 = com.tencent.mm.kernel.g.afB().cachePath + "ws_1100004";
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(localObject1)));
    try
    {
      localObject2 = this.wFC.toByteArray();
      i.f((String)localObject1, (byte[])localObject2, localObject2.length);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + this.wFC.wNR.size());
      AppMethodBeat.o(96114);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnSABTestMgr", localException, "listToFile failed: ".concat(String.valueOf(localObject1)), new Object[0]);
      AppMethodBeat.o(96114);
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(179118);
    Object localObject1 = new ArrayList();
    Object localObject2 = com.tencent.mm.model.c.d.aty().aHj("10001").values().iterator();
    label254:
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.storage.c localc = (com.tencent.mm.storage.c)((Iterator)localObject2).next();
      d locald = new d();
      if (localc == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsABTestStrategy", "abtest is null");
      }
      else if (!localc.isValid())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      }
      else
      {
        Map localMap = localc.eJy();
        if (localMap != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
          locald.f(localc.field_layerId, localc.field_expId, localMap);
          if ((locald.dfO) && (locald.wNB != null) && (locald.wNB.size() > 0)) {}
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
    this.wNb = ((List)localObject1);
    this.wNe.clear();
    this.wNf.clear();
    this.wNh.clear();
    this.wFC = null;
    if ((this.wNb == null) || (this.wNb.size() == 0))
    {
      AppMethodBeat.o(179118);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject1 = com.tencent.mm.kernel.g.afB().cachePath + "ws_1100004";
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(localObject1)));
    localObject2 = i.aR((String)localObject1, 0, -1);
    if (localObject2 != null)
    {
      try
      {
        this.wFC = ((com.tencent.mm.plugin.sns.j.c)new com.tencent.mm.plugin.sns.j.c().parseFrom((byte[])localObject2));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - l));
        if (this.wFC == null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
          AppMethodBeat.o(179118);
          return;
        }
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnSABTestMgr", localIOException, "", new Object[0]);
        i.deleteFile((String)localObject1);
        AppMethodBeat.o(179118);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.wFC.wNR.size());
    }
    AppMethodBeat.o(179118);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(96112);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnSABTestMgr", "onSceneend " + paramInt1 + " errCode " + paramInt2);
    paramString = new mq();
    com.tencent.mm.sdk.b.a.ESL.l(paramString);
    AppMethodBeat.o(96112);
  }
  
  static final class a
  {
    long mEndTime = -1L;
    long mStartTime = -1L;
    long wFm;
    d wNu;
    int wNv = 0;
    int wNw = 0;
    String wNx = "";
    String wNy = "";
    String wNz;
    
    public a(long paramLong1, long paramLong2, String paramString, d paramd)
    {
      this.wNu = paramd;
      this.mStartTime = paramLong1;
      this.wFm = paramLong2;
      this.wNz = paramString;
    }
    
    private void addAction(String paramString)
    {
      AppMethodBeat.i(96110);
      if (!bt.isNullOrNil(this.wNy)) {
        this.wNy += "|";
      }
      this.wNy += paramString;
      AppMethodBeat.o(96110);
    }
    
    public final void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(96109);
      if ((paramInt1 == -1) || (paramInt2 == -1))
      {
        AppMethodBeat.o(96109);
        return;
      }
      String str1 = paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4;
      String str2 = paramInt1 + ":" + paramInt2;
      if ((str1.equals(this.wNx)) || ((this.wNx.startsWith(str2)) && (paramInt3 == 0) && (paramInt4 == 0)))
      {
        AppMethodBeat.o(96109);
        return;
      }
      this.wNx = str1;
      addAction(paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4);
      AppMethodBeat.o(96109);
    }
    
    public final void ha(int paramInt1, int paramInt2)
    {
      this.wNv = paramInt1;
      this.wNw = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.c
 * JD-Core Version:    0.7.0.1
 */
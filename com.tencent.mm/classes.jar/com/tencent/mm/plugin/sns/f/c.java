package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ks;
import com.tencent.mm.h.a.kt;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.pluginsdk.ui.d.o.a;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.btw;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.s;
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
  implements com.tencent.mm.ah.f, com.tencent.mm.plugin.sns.model.e
{
  public static final Pattern owi = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
  public static final Pattern owj = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
  private com.tencent.mm.plugin.sns.g.c oqu;
  public final int ovw = 14;
  public final int owa = 500;
  private List<d> owb;
  public ListView owc;
  public au owd;
  public Map<Long, Integer> owe = new HashMap();
  public HashSet<Long> owf = new HashSet();
  public HashSet<Long> owg = new HashSet();
  private HashMap<Long, c.a> owh = new HashMap();
  private o.a owk = new c.6(this);
  
  private SpannableString a(Context paramContext, TextView paramTextView, String paramString, bto parambto, a.c paramc, d.a parama, d.b paramb, d paramd)
  {
    Object localObject = owi.matcher(paramString);
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
      paramString.setSpan(new o(parambto.sxM, new c.5(this, paramContext, parambto, parama, paramb, paramc, paramd)), i, ((String)localObject).length() + i, 33);
      return paramString;
    }
    return com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramString);
  }
  
  private static String a(String paramString, bto parambto)
  {
    Object localObject = paramString;
    try
    {
      if (bk.bl(paramString)) {
        return "";
      }
      localObject = paramString;
      parambto = parambto.sxM;
      localObject = paramString;
      g.DQ();
      localObject = paramString;
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambto);
      parambto = paramString;
      localObject = paramString;
      if (paramString.contains("{username}"))
      {
        localObject = paramString;
        parambto = paramString.replace("{username}", localad.Bq());
      }
      localObject = parambto;
      int i = localad.sex;
      if (i == 1)
      {
        i = 0;
        paramString = parambto;
      }
      label195:
      return paramString;
    }
    catch (Exception parambto)
    {
      try
      {
        parambto = owj.matcher(paramString);
        if ((!parambto.find()) || (parambto.groupCount() != 3)) {
          return paramString;
        }
        localObject = parambto.group();
        if (i == 0) {
          parambto = parambto.group(1);
        }
        for (;;)
        {
          parambto = paramString.replace((CharSequence)localObject, parambto);
          paramString = parambto;
          break;
          localObject = parambto;
          i = localad.sex;
          if (i == 2)
          {
            i = 1;
            paramString = parambto;
            break;
          }
          i = 2;
          paramString = parambto;
          break;
          if (i == 1) {
            parambto = parambto.group(2);
          } else {
            parambto = parambto.group(3);
          }
        }
        parambto = parambto;
        paramString = (String)localObject;
      }
      catch (Exception parambto)
      {
        break label195;
      }
      y.printErrStackTrace("MicroMsg.SnSABTestMgr", parambto, "settext error ", new Object[0]);
      return paramString;
    }
  }
  
  private void a(Context paramContext, bto parambto, d.a parama, d.b paramb, a.c paramc, d paramd)
  {
    y.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + parambto.sxM + " " + parambto.sGd);
    int i = parama.owE - 1;
    c.a locala = (c.a)this.owh.get(Long.valueOf(parambto.sGd));
    if (locala != null)
    {
      locala.x(paramb.showType, paramb.fRi.size(), parama.index, parama.actionType);
      locala.owv = -1;
      locala.oww = -1;
    }
    if (parama.actionType == 3)
    {
      this.owf.add(Long.valueOf(parambto.sGd));
      this.owe.put(Long.valueOf(parambto.sGd), Integer.valueOf(i));
    }
    for (;;)
    {
      if ((i == 4) || (i == 1)) {
        a(paramContext, parambto, paramc);
      }
      do
      {
        return;
        if (parama.actionType == 1)
        {
          this.owe.put(Long.valueOf(parambto.sGd), Integer.valueOf(i));
          gi(parambto.sGd);
          b(paramc);
          break;
        }
        if (parama.actionType == 5)
        {
          if (this.owf.contains(Long.valueOf(parambto.sGd)))
          {
            this.owf.remove(Long.valueOf(parambto.sGd));
            gi(parambto.sGd);
            b(paramc);
            if (this.owh.containsKey(Long.valueOf(parambto.sGd))) {
              a((c.a)this.owh.remove(Long.valueOf(parambto.sGd)));
            }
          }
          this.owe.put(Long.valueOf(parambto.sGd), Integer.valueOf(-1));
          a(paramc);
          return;
        }
        if (parama.actionType == 7)
        {
          if (i >= paramd.owB.size()) {
            break;
          }
          parama = (d.b)paramd.owB.get(i);
          if (parama.showType == 2)
          {
            b(paramContext, parambto, paramc, parama, paramd);
            return;
          }
          if (parama.showType != 5) {
            break;
          }
          s.makeText(paramContext, bk.aM(parama.title, ""), 0).show();
          gi(parambto.sGd);
          b(paramc);
          return;
        }
        if (parama.actionType == 6)
        {
          s.makeText(paramContext, bk.aM(paramContext.getString(i.j.sns_abtest_toast), ""), 0).show();
          this.owg.add(Long.valueOf(parambto.sGd));
          b(paramc);
          paramContext = new kt();
          com.tencent.mm.sdk.b.a.udP.m(paramContext);
          a(paramc);
          return;
        }
        if (parama.actionType == 2)
        {
          parama = parama.jumpUrl;
          y.i("MicroMsg.SnSABTestMgr", "jump url " + parama);
          paramb = new Intent();
          paramb.putExtra("rawUrl", parama);
          paramb.putExtra("useJs", true);
          com.tencent.mm.plugin.sns.c.a.eUR.j(paramb, paramContext);
          gi(parambto.sGd);
          b(paramc);
          a(paramc);
          return;
        }
      } while (parama.actionType == 8);
      if (parama.actionType == 4)
      {
        parama = parambto.sxM;
        paramb = new LinkedList();
        paramb.add(parama);
        parama = new w(1, 5L, "", paramb.size(), paramb, 0);
        g.DQ();
        g.DO().dJT.a(parama, 0);
      }
    }
  }
  
  private static void a(c.a parama)
  {
    Object localObject = parama.owu;
    if (localObject == null) {}
    String str2;
    String str3;
    String str4;
    long l1;
    long l2;
    do
    {
      return;
      str2 = ((d)localObject).ovZ;
      str3 = ((d)localObject).ovY;
      str4 = parama.owz;
      parama.x(parama.owv, parama.oww, 0, 0);
      String str1 = parama.owy;
      localObject = str1;
      if (bk.bl(str1)) {
        localObject = parama.owv + ":" + parama.oww + ":0:0";
      }
      l1 = parama.mStartTime / 1000L;
      if (parama.mEndTime == -1L) {
        parama.mEndTime = System.currentTimeMillis();
      }
      l2 = parama.mEndTime / 1000L;
    } while (parama == null);
    y.i("MicroMsg.SnSABTestMgr", "report layerId: " + str2 + " expid " + str3 + " acton " + (String)localObject + " starttime " + l1 + " timelineId: " + str4);
    com.tencent.mm.plugin.report.service.h.nFQ.f(11917, new Object[] { str2, str3, "", "", Integer.valueOf(1), str4, localObject, Long.valueOf(l1), Long.valueOf(l2) });
  }
  
  private void a(a.c paramc)
  {
    if (paramc == null) {}
    Context localContext;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          localContext = paramc.kKz.getContext();
        } while (localContext == null);
        if (paramc.kKz.getBackground() == null)
        {
          paramc.kKz.setBackgroundResource(i.e.comm_list_item_selector);
          paramc.kKz.setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 8));
        }
        i = paramc.position;
      } while (this.owd == null);
      paramc = (WeakReference)this.owd.pee.get(Integer.valueOf(i - 1));
    } while ((paramc == null) || (paramc.get() == null));
    ((View)paramc.get()).setBackgroundResource(i.e.comm_list_item_selector);
    ((View)paramc.get()).setPadding(com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 12), com.tencent.mm.cb.a.fromDPToPix(localContext, 8));
  }
  
  private boolean a(Context paramContext, bto parambto, a.c paramc, d.b paramb, d paramd)
  {
    paramc.kKz.setBackgroundDrawable(null);
    int i = paramc.position;
    Object localObject1;
    if (this.owd != null)
    {
      localObject1 = (WeakReference)this.owd.pee.get(Integer.valueOf(i - 1));
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        break label254;
      }
    }
    Object localObject2;
    for (;;)
    {
      if (!paramc.pno)
      {
        paramc.pnp = paramc.pnn.inflate();
        paramc.pno = true;
        paramc.pnq = ((LinearLayout)paramc.pnp.findViewById(i.f.sns_abtest_one_item_ll));
      }
      paramc.pnp.setVisibility(0);
      paramc.pnz.setVisibility(8);
      paramc.doU.setVisibility(8);
      localObject1 = paramb.fRi;
      if (((List)localObject1).size() == paramc.pnq.getChildCount()) {
        break;
      }
      paramc.pnq.removeAllViews();
      int j = com.tencent.mm.cb.a.fromDPToPix(paramContext, 10);
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setBackgroundResource(i.e.album_abtesti_cellbg);
        ((TextView)localObject2).setPadding(j, j, j, j);
        ((TextView)localObject2).setTextSize(1, 14.0F * com.tencent.mm.cb.a.cJ(paramContext));
        ((TextView)localObject2).setTextColor(paramContext.getResources().getColor(i.c.black));
        paramc.pnq.addView((View)localObject2);
        i += 1;
      }
      label254:
      ((View)((WeakReference)localObject1).get()).setBackgroundDrawable(null);
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (d.a)((List)localObject1).get(i);
      TextView localTextView = (TextView)paramc.pnq.getChildAt(i);
      localTextView.setText(((d.a)localObject2).owC);
      localTextView.setTag(parambto);
      String str = a(f.a((d.a)localObject2), parambto);
      localTextView.setOnClickListener(new c.2(this, paramContext, (d.a)localObject2, paramb, paramc, paramd));
      localTextView.setText(a(paramContext, localTextView, str, parambto, paramc, (d.a)localObject2, paramb, paramd), TextView.BufferType.SPANNABLE);
      if (((d.a)localObject2).actionType != 5)
      {
        localTextView.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(paramContext, 5));
        localTextView.setCompoundDrawablesWithIntrinsicBounds(paramContext.getResources().getDrawable(i.i.album_abtesti_icon2), null, null, null);
      }
      i += 1;
    }
    return true;
  }
  
  private static void b(a.c paramc)
  {
    if (paramc == null) {}
    do
    {
      return;
      if (paramc.pni != null) {
        paramc.pni.setVisibility(8);
      }
      if (paramc.pnk != null) {
        paramc.pnk.setVisibility(8);
      }
      if (paramc.pnn != null) {
        paramc.pnn.setVisibility(8);
      }
      if (paramc.pnp != null) {
        paramc.pnp.setVisibility(8);
      }
      if (paramc.pnz.getVisibility() == 8) {
        paramc.pnz.setVisibility(0);
      }
      if (paramc.doU.getVisibility() == 8) {
        paramc.doU.setVisibility(0);
      }
    } while (paramc.kKz.getVisibility() != 8);
    paramc.kKz.setVisibility(0);
  }
  
  private boolean b(Context paramContext, bto parambto, a.c paramc, d.b paramb, d paramd)
  {
    if (paramb.fRi.size() == 2)
    {
      d.a locala1 = (d.a)paramb.fRi.get(0);
      d.a locala2 = (d.a)paramb.fRi.get(1);
      String str1 = a(f.a(locala1), parambto);
      String str2 = a(f.a(locala2), parambto);
      com.tencent.mm.ui.base.h.a(paramContext, a(paramb.title, parambto), paramContext.getString(i.j.app_tip), str1, str2, new c.3(this, paramContext, parambto, locala1, paramb, paramc, paramd), new c.4(this, paramContext, parambto, locala2, paramb, paramc, paramd));
      return true;
    }
    return false;
  }
  
  public static void c(View paramView, a.c paramc)
  {
    paramc.pnj = false;
    paramc.pni = ((ViewStub)paramView.findViewById(i.f.sns_post_item_abtest));
    paramc.pni.setVisibility(8);
    paramc.pnn = ((ViewStub)paramView.findViewById(i.f.sns_item_abtest_layout));
    paramc.pnn.setVisibility(8);
  }
  
  private void gi(long paramLong)
  {
    if (this.oqu == null) {
      this.oqu = new com.tencent.mm.plugin.sns.g.c();
    }
    if (this.oqu.owR.size() > 500) {
      this.oqu.owR.remove(0);
    }
    this.oqu.owR.add(Long.valueOf(paramLong));
  }
  
  public final void a(int paramInt, String paramString, long paramLong, bxk parambxk, boolean paramBoolean)
  {
    if (this.owh.containsKey(Long.valueOf(paramLong)))
    {
      paramString = (c.a)this.owh.get(Long.valueOf(paramLong));
      if (paramString.mEndTime == -1L) {
        paramString.mEndTime = System.currentTimeMillis();
      }
      paramString.x(paramString.owv, paramString.oww, 0, 0);
    }
  }
  
  public final void a(int paramInt, String paramString, long paramLong, bxk parambxk, boolean paramBoolean, be parambe) {}
  
  public final void a(Context paramContext, bto parambto, a.c paramc)
  {
    if (!x.cqG())
    {
      b(paramc);
      return;
    }
    if ((this.owb == null) || (this.owb.size() == 0))
    {
      b(paramc);
      return;
    }
    if (this.owg.contains(Long.valueOf(parambto.sGd)))
    {
      b(paramc);
      paramc.pnz.setVisibility(8);
      paramc.doU.setVisibility(8);
      paramc.kKz.setVisibility(8);
      return;
    }
    if ((parambto.sxM == null) || (parambto.sxM.equals(af.bDl())))
    {
      b(paramc);
      return;
    }
    if ((this.oqu != null) && (this.oqu.owR.contains(Long.valueOf(parambto.sGd))))
    {
      b(paramc);
      return;
    }
    if (parambto != null) {}
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = com.tencent.mm.platformtools.aa.a(parambto.tKl);
        boolean bool = bk.bE(arrayOfByte);
        if (bool)
        {
          i = 0;
          j = 0;
          if (this.owe.containsKey(Long.valueOf(parambto.sGd)))
          {
            int k = ((Integer)this.owe.get(Long.valueOf(parambto.sGd))).intValue();
            j = k;
            if (k == -1) {
              b(paramc);
            }
          }
        }
        else
        {
          i = ((btw)new btw().aH(arrayOfByte)).tKw;
          continue;
        }
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
        d.b localb = null;
        Object localObject2 = this.owb.iterator();
        Object localObject1 = localb;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (d)((Iterator)localObject2).next();
          if (localObject1 == null)
          {
            b(paramc);
            return;
          }
          if (((d)localObject1).owA != i) {
            continue;
          }
        }
        if (localObject1 == null)
        {
          b(paramc);
          return;
        }
        if (j >= ((d)localObject1).owB.size())
        {
          b(paramc);
          return;
        }
        localb = (d.b)((d)localObject1).owB.get(j);
        int j = localb.showType;
        b(paramc);
        if (i > 0)
        {
          if (!this.owh.containsKey(Long.valueOf(parambto.sGd)))
          {
            localObject2 = new c.a(System.currentTimeMillis(), parambto.sGd, i.fN(parambto.sGd), (d)localObject1);
            ((c.a)localObject2).dN(j, localb.fRi.size());
            this.owh.put(Long.valueOf(parambto.sGd), localObject2);
            if (j != 1) {
              continue;
            }
            localObject2 = localb.title;
            if (!paramc.pnj)
            {
              paramc.pnk = paramc.pni.inflate();
              paramc.pnj = true;
              paramc.pnm = ((TextView)paramc.pnk.findViewById(i.f.post_abtest_click_text));
              paramc.pnl = ((LinearLayout)paramc.pnk.findViewById(i.f.abtest_button_list));
            }
            paramc.pnk.setVisibility(0);
            paramc.pnm.setText((CharSequence)localObject2);
            localObject2 = localb.fRi;
            if (((List)localObject2).size() != paramc.pnl.getChildCount())
            {
              paramc.pnl.removeAllViews();
              i = 0;
              if (i < ((List)localObject2).size())
              {
                locala = (d.a)((List)localObject2).get(i);
                localTextView = new TextView(paramc.pnl.getContext());
                localTextView.setText(locala.owC);
                localTextView.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(paramContext, 10), 0);
                localTextView.setVisibility(0);
                localTextView.setTextSize(1, 14.0F * com.tencent.mm.cb.a.cJ(paramContext));
                localTextView.setTextColor(paramContext.getResources().getColor(i.c.sns_link_color));
                paramc.pnl.addView(localTextView);
                i += 1;
                continue;
              }
            }
          }
          else
          {
            ((c.a)this.owh.get(Long.valueOf(parambto.sGd))).dN(j, localb.fRi.size());
            continue;
          }
          i = 0;
          if (i >= ((List)localObject2).size()) {
            break;
          }
          d.a locala = (d.a)((List)localObject2).get(i);
          TextView localTextView = (TextView)paramc.pnl.getChildAt(i);
          localTextView.setText(a(paramContext, localTextView, a(f.a(locala), parambto), parambto, paramc, locala, localb, (d)localObject1));
          localTextView.setTag(parambto);
          localTextView.setOnClickListener(new c.1(this, paramContext, locala, localb, paramc, (d)localObject1));
          i += 1;
          continue;
          if (j == 4)
          {
            a(paramContext, parambto, paramc, localb, (d)localObject1);
            return;
          }
          if (j == 2)
          {
            if (!b(paramContext, parambto, paramc, localb, (d)localObject1)) {
              break;
            }
            return;
          }
        }
        b(paramc);
        return;
      }
      int i = 0;
    }
  }
  
  public final void clean()
  {
    this.owc = null;
    this.owd = null;
    Object localObject2;
    if (this.owf != null)
    {
      localObject1 = this.owf.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        r localr = new r(((Long)localObject2).longValue(), 0, 0, null);
        g.DQ();
        g.DO().dJT.a(localr, 0);
        y.i("MicroMsg.SnSABTestMgr", "report id " + localObject2);
      }
    }
    if (this.owh != null)
    {
      localObject1 = this.owh.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((c.a)((Iterator)localObject1).next());
      }
      this.owh.clear();
    }
    if ((this.owb.size() == 0) || (this.oqu == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    g.DQ();
    localObject1 = g.DP().cachePath + "ws_1100004";
    y.i("MicroMsg.SnSABTestMgr", "listToFile to list  " + (String)localObject1);
    try
    {
      localObject2 = this.oqu.toByteArray();
      com.tencent.mm.vfs.e.b((String)localObject1, (byte[])localObject2, localObject2.length);
      y.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + this.oqu.owR.size());
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SnSABTestMgr", localException, "listToFile failed: " + (String)localObject1, new Object[0]);
    }
  }
  
  public final void init()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = com.tencent.mm.model.c.c.IX().aaC("10001").values().iterator();
    label245:
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.storage.c localc = (com.tencent.mm.storage.c)((Iterator)localObject2).next();
      d locald = new d();
      if (localc == null)
      {
        y.i("MicroMsg.SnsABTestStrategy", "abtest is null");
      }
      else if (!localc.isValid())
      {
        y.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      }
      else
      {
        Map localMap = localc.ctr();
        if (localMap != null)
        {
          y.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
          locald.e(localc.field_layerId, localc.field_expId, localMap);
          if ((locald.bJy) && (locald.owB != null) && (locald.owB.size() > 0)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label245;
            }
            ((List)localObject1).add(locald);
            break;
          }
        }
      }
    }
    this.owb = ((List)localObject1);
    this.owe.clear();
    this.owf.clear();
    this.owh.clear();
    this.oqu = null;
    if ((this.owb == null) || (this.owb.size() == 0)) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      localObject1 = new StringBuilder();
      g.DQ();
      localObject1 = g.DP().cachePath + "ws_1100004";
      y.i("MicroMsg.SnSABTestMgr", "filepath to list  " + (String)localObject1);
      localObject2 = com.tencent.mm.vfs.e.c((String)localObject1, 0, -1);
    } while (localObject2 == null);
    try
    {
      this.oqu = ((com.tencent.mm.plugin.sns.g.c)new com.tencent.mm.plugin.sns.g.c().aH((byte[])localObject2));
      y.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - l));
      if (this.oqu == null)
      {
        y.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
        return;
      }
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.SnSABTestMgr", localIOException, "", new Object[0]);
      com.tencent.mm.vfs.e.deleteFile((String)localObject1);
      return;
    }
    y.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.oqu.owR.size());
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.SnSABTestMgr", "onSceneend " + paramInt1 + " errCode " + paramInt2);
    paramString = new ks();
    com.tencent.mm.sdk.b.a.udP.m(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.c
 * JD-Core Version:    0.7.0.1
 */
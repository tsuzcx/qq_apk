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
import com.tencent.mm.an.i;
import com.tencent.mm.f.a.ox;
import com.tencent.mm.f.a.oy;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.ui.ah;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bt;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ekj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
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
  implements i, e
{
  public static final Pattern Kej;
  public static final Pattern Kek;
  private com.tencent.mm.plugin.sns.j.c JVP;
  public final int Kdy;
  public final int Keb;
  private List<d> Kec;
  public ListView Ked;
  public bm Kee;
  public Map<Long, Integer> Kef;
  public HashSet<Long> Keg;
  public HashSet<Long> Keh;
  private HashMap<Long, a> Kei;
  private q.a Kel;
  
  static
  {
    AppMethodBeat.i(96128);
    Kej = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    Kek = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    AppMethodBeat.o(96128);
  }
  
  public c()
  {
    AppMethodBeat.i(96111);
    this.Kdy = 14;
    this.Keb = 500;
    this.Kef = new HashMap();
    this.Keg = new HashSet();
    this.Keh = new HashSet();
    this.Kei = new HashMap();
    this.Kel = new q.a()
    {
      public final void b(View paramAnonymousView, Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(96111);
  }
  
  private void QR(long paramLong)
  {
    AppMethodBeat.i(96113);
    if (this.JVP == null) {
      this.JVP = new com.tencent.mm.plugin.sns.j.c();
    }
    if (this.JVP.KeR.size() > 500) {
      this.JVP.KeR.remove(0);
    }
    this.JVP.KeR.add(Long.valueOf(paramLong));
    AppMethodBeat.o(96113);
  }
  
  private SpannableString a(final Context paramContext, TextView paramTextView, String paramString, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.a parama, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96123);
    Object localObject = Kej.matcher(paramString);
    if ((((Matcher)localObject).find()) && (((Matcher)localObject).groupCount() == 1))
    {
      String str = ((Matcher)localObject).group();
      localObject = ((Matcher)localObject).group(1);
      int i = paramString.indexOf(str);
      paramString = paramString.replace(str, (CharSequence)localObject);
      paramTextView.setOnClickListener(null);
      paramTextView.setClickable(true);
      paramString = new SpannableString(paramString);
      paramTextView.setOnTouchListener(new ah());
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
    paramContext = l.c(paramContext, paramString);
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
      com.tencent.mm.kernel.h.aHH();
      localObject = paramString;
      as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramSnsObject);
      paramSnsObject = paramString;
      localObject = paramString;
      if (paramString.contains("{username}"))
      {
        localObject = paramString;
        paramSnsObject = paramString.replace("{username}", localas.ays());
      }
      localObject = paramSnsObject;
      int i = localas.sex;
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
        paramSnsObject = Kek.matcher(paramString);
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
            i = localas.sex;
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
    int i = parama.KeE - 1;
    a locala = (a)this.Kei.get(Long.valueOf(paramSnsObject.Id));
    if (locala != null)
    {
      locala.P(paramb.fwp, paramb.obd.size(), parama.index, parama.actionType);
      locala.Kew = -1;
      locala.Kex = -1;
    }
    if (parama.actionType == 3)
    {
      this.Keg.add(Long.valueOf(paramSnsObject.Id));
      this.Kef.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
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
        this.Kef.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
        QR(paramSnsObject.Id);
        e(paramBaseViewHolder);
      }
      else
      {
        if (parama.actionType == 5)
        {
          if (this.Keg.contains(Long.valueOf(paramSnsObject.Id)))
          {
            this.Keg.remove(Long.valueOf(paramSnsObject.Id));
            QR(paramSnsObject.Id);
            e(paramBaseViewHolder);
            if (this.Kei.containsKey(Long.valueOf(paramSnsObject.Id))) {
              a((a)this.Kei.remove(Long.valueOf(paramSnsObject.Id)));
            }
          }
          this.Kef.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(-1));
          d(paramBaseViewHolder);
          AppMethodBeat.o(96120);
          return;
        }
        if (parama.actionType == 7)
        {
          if (i < paramd.KeB.size())
          {
            parama = (d.b)paramd.KeB.get(i);
            if (parama.fwp == 2)
            {
              b(paramContext, paramSnsObject, paramBaseViewHolder, parama, paramd);
              AppMethodBeat.o(96120);
              return;
            }
            if (parama.fwp == 5)
            {
              w.makeText(paramContext, Util.nullAs(parama.title, ""), 0).show();
              QR(paramSnsObject.Id);
              e(paramBaseViewHolder);
              AppMethodBeat.o(96120);
            }
          }
        }
        else
        {
          if (parama.actionType == 6)
          {
            w.makeText(paramContext, Util.nullAs(paramContext.getString(i.j.sns_abtest_toast), ""), 0).show();
            this.Keh.add(Long.valueOf(paramSnsObject.Id));
            e(paramBaseViewHolder);
            paramContext = new oy();
            EventCenter.instance.publish(paramContext);
            d(paramBaseViewHolder);
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
            com.tencent.mm.plugin.sns.c.a.mIG.h(paramb, paramContext);
            QR(paramSnsObject.Id);
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
            parama = new x(1, 5L, "", paramb.size(), paramb, 0);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(parama, 0);
          }
        }
      }
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(96125);
    Object localObject = parama.Kev;
    if (localObject == null)
    {
      AppMethodBeat.o(96125);
      return;
    }
    String str2 = ((d)localObject).Kea;
    String str3 = ((d)localObject).KdZ;
    String str4 = parama.JJA;
    parama.P(parama.Kew, parama.Kex, 0, 0);
    String str1 = parama.Kez;
    localObject = str1;
    if (Util.isNullOrNil(str1)) {
      localObject = parama.Kew + ":" + parama.Kex + ":0:0";
    }
    long l1 = parama.mStartTime / 1000L;
    if (parama.mEndTime == -1L) {
      parama.mEndTime = System.currentTimeMillis();
    }
    long l2 = parama.mEndTime / 1000L;
    if (parama != null)
    {
      Log.i("MicroMsg.SnSABTestMgr", "report layerId: " + str2 + " expid " + str3 + " acton " + (String)localObject + " starttime " + l1 + " timelineId: " + str4);
      com.tencent.mm.plugin.report.service.h.IzE.a(11917, new Object[] { str2, str3, "", "", Integer.valueOf(1), str4, localObject, Long.valueOf(l1), Long.valueOf(l2) });
    }
    AppMethodBeat.o(96125);
  }
  
  private boolean a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96117);
    paramBaseViewHolder.convertView.setBackgroundDrawable(null);
    int i = paramBaseViewHolder.position;
    Object localObject1;
    if (this.Kee != null)
    {
      localObject1 = (WeakReference)this.Kee.KYq.get(Integer.valueOf(i - 1));
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        break label260;
      }
    }
    Object localObject2;
    for (;;)
    {
      if (!paramBaseViewHolder.LlA)
      {
        paramBaseViewHolder.LlB = paramBaseViewHolder.Llz.inflate();
        paramBaseViewHolder.LlA = true;
        paramBaseViewHolder.LlC = ((LinearLayout)paramBaseViewHolder.LlB.findViewById(i.f.sns_abtest_one_item_ll));
      }
      paramBaseViewHolder.LlB.setVisibility(0);
      paramBaseViewHolder.LlK.setVisibility(8);
      paramBaseViewHolder.LkK.setVisibility(8);
      localObject1 = paramb.obd;
      if (((List)localObject1).size() == paramBaseViewHolder.LlC.getChildCount()) {
        break;
      }
      paramBaseViewHolder.LlC.removeAllViews();
      int j = com.tencent.mm.ci.a.fromDPToPix(paramContext, 10);
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setBackgroundResource(i.e.album_abtesti_cellbg);
        ((TextView)localObject2).setPadding(j, j, j, j);
        ((TextView)localObject2).setTextSize(1, 14.0F * com.tencent.mm.ci.a.ez(paramContext));
        ((TextView)localObject2).setTextColor(paramContext.getResources().getColor(i.c.normal_text_color));
        paramBaseViewHolder.LlC.addView((View)localObject2);
        i += 1;
      }
      label260:
      ((View)((WeakReference)localObject1).get()).setBackgroundDrawable(null);
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (d.a)((List)localObject1).get(i);
      TextView localTextView = (TextView)paramBaseViewHolder.LlC.getChildAt(i);
      localTextView.setText(((d.a)localObject2).KeC);
      localTextView.setTag(paramSnsObject);
      String str = a(f.a((d.a)localObject2), paramSnsObject);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96105);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          c.a(c.this, paramContext, paramAnonymousView, this.Kem, paramb, paramBaseViewHolder, paramd);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96105);
        }
      });
      localTextView.setText(a(paramContext, localTextView, str, paramSnsObject, paramBaseViewHolder, (d.a)localObject2, paramb, paramd), TextView.BufferType.SPANNABLE);
      if (((d.a)localObject2).actionType != 5)
      {
        localTextView.setCompoundDrawablePadding(com.tencent.mm.ci.a.fromDPToPix(paramContext, 5));
        localTextView.setCompoundDrawablesWithIntrinsicBounds(paramContext.getResources().getDrawable(i.i.album_abtesti_icon2), null, null, null);
      }
      i += 1;
    }
    AppMethodBeat.o(96117);
    return true;
  }
  
  private boolean b(final Context paramContext, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96118);
    if (paramb.obd.size() == 2)
    {
      final d.a locala1 = (d.a)paramb.obd.get(0);
      final d.a locala2 = (d.a)paramb.obd.get(1);
      String str1 = a(f.a(locala1), paramSnsObject);
      String str2 = a(f.a(locala2), paramSnsObject);
      com.tencent.mm.ui.base.h.c(paramContext, a(paramb.title, paramSnsObject), paramContext.getString(i.j.app_tip), str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    paramBaseViewHolder.Llv = false;
    paramBaseViewHolder.Llu = ((ViewStub)paramView.findViewById(i.f.sns_post_item_abtest));
    paramBaseViewHolder.Llu.setVisibility(8);
    paramBaseViewHolder.Llz = ((ViewStub)paramView.findViewById(i.f.sns_item_abtest_layout));
    paramBaseViewHolder.Llz.setVisibility(8);
    AppMethodBeat.o(96115);
  }
  
  private void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(200670);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(200670);
      return;
    }
    Context localContext = paramBaseViewHolder.convertView.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(200670);
      return;
    }
    if (paramBaseViewHolder.convertView.getBackground() == null)
    {
      paramBaseViewHolder.convertView.setBackgroundResource(i.e.comm_list_item_selector);
      paramBaseViewHolder.convertView.setPadding(com.tencent.mm.ci.a.fromDPToPix(localContext, 12), com.tencent.mm.ci.a.fromDPToPix(localContext, 12), com.tencent.mm.ci.a.fromDPToPix(localContext, 12), com.tencent.mm.ci.a.fromDPToPix(localContext, 8));
    }
    int i = paramBaseViewHolder.position;
    if (this.Kee != null)
    {
      paramBaseViewHolder = (WeakReference)this.Kee.KYq.get(Integer.valueOf(i - 1));
      if ((paramBaseViewHolder == null) || (paramBaseViewHolder.get() == null))
      {
        AppMethodBeat.o(200670);
        return;
      }
      ((View)paramBaseViewHolder.get()).setBackgroundResource(i.e.comm_list_item_selector);
      ((View)paramBaseViewHolder.get()).setPadding(com.tencent.mm.ci.a.fromDPToPix(localContext, 12), com.tencent.mm.ci.a.fromDPToPix(localContext, 12), com.tencent.mm.ci.a.fromDPToPix(localContext, 12), com.tencent.mm.ci.a.fromDPToPix(localContext, 8));
    }
    AppMethodBeat.o(200670);
  }
  
  private static void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96121);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(96121);
      return;
    }
    if (paramBaseViewHolder.Llu != null) {
      paramBaseViewHolder.Llu.setVisibility(8);
    }
    if (paramBaseViewHolder.Llw != null) {
      paramBaseViewHolder.Llw.setVisibility(8);
    }
    if (paramBaseViewHolder.Llz != null) {
      paramBaseViewHolder.Llz.setVisibility(8);
    }
    if (paramBaseViewHolder.LlB != null) {
      paramBaseViewHolder.LlB.setVisibility(8);
    }
    if (paramBaseViewHolder.LlK.getVisibility() == 8) {
      paramBaseViewHolder.LlK.setVisibility(0);
    }
    if (paramBaseViewHolder.LkK.getVisibility() == 8) {
      paramBaseViewHolder.LkK.setVisibility(0);
    }
    if (paramBaseViewHolder.convertView.getVisibility() == 8) {
      paramBaseViewHolder.convertView.setVisibility(0);
    }
    AppMethodBeat.o(96121);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(96124);
    if (this.Kei.containsKey(Long.valueOf(paramLong)))
    {
      paramString = (a)this.Kei.get(Long.valueOf(paramLong));
      if (paramString.mEndTime == -1L) {
        paramString.mEndTime = System.currentTimeMillis();
      }
      paramString.P(paramString.Kew, paramString.Kex, 0, 0);
    }
    AppMethodBeat.o(96124);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bt parambt) {}
  
  public final void a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96116);
    if (!LocaleUtil.isSimplifiedChineseAppLang())
    {
      e(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.Kec == null) || (this.Kec.size() == 0))
    {
      e(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if (this.Keh.contains(Long.valueOf(paramSnsObject.Id)))
    {
      e(paramBaseViewHolder);
      paramBaseViewHolder.LlK.setVisibility(8);
      paramBaseViewHolder.LkK.setVisibility(8);
      paramBaseViewHolder.convertView.setVisibility(8);
      AppMethodBeat.o(96116);
      return;
    }
    if ((paramSnsObject.Username == null) || (paramSnsObject.Username.equals(aj.fOo())))
    {
      e(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.JVP != null) && (this.JVP.KeR.contains(Long.valueOf(paramSnsObject.Id))))
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
        Object localObject2 = this.Kec.iterator();
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
        if (((d)localObject1).KeA != i) {
          continue;
        }
        if (localObject1 != null) {
          continue;
        }
        e(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        if (j < ((d)localObject1).KeB.size()) {
          continue;
        }
        e(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        localb = (d.b)((d)localObject1).KeB.get(j);
        int j = localb.fwp;
        e(paramBaseViewHolder);
        if (i <= 0) {
          continue;
        }
        if (this.Kei.containsKey(Long.valueOf(paramSnsObject.Id))) {
          continue;
        }
        localObject2 = new a(System.currentTimeMillis(), paramSnsObject.Id, com.tencent.mm.plugin.sns.data.t.Qu(paramSnsObject.Id), (d)localObject1);
        ((a)localObject2).jF(j, localb.obd.size());
        this.Kei.put(Long.valueOf(paramSnsObject.Id), localObject2);
        if (j != 1) {
          continue;
        }
        localObject2 = localb.title;
        if (paramBaseViewHolder.Llv) {
          continue;
        }
        paramBaseViewHolder.Llw = paramBaseViewHolder.Llu.inflate();
        paramBaseViewHolder.Llv = true;
        paramBaseViewHolder.Lly = ((TextView)paramBaseViewHolder.Llw.findViewById(i.f.post_abtest_click_text));
        paramBaseViewHolder.Llx = ((LinearLayout)paramBaseViewHolder.Llw.findViewById(i.f.abtest_button_list));
        paramBaseViewHolder.Llw.setVisibility(0);
        paramBaseViewHolder.Lly.setText((CharSequence)localObject2);
        localObject2 = localb.obd;
        if (((List)localObject2).size() == paramBaseViewHolder.Llx.getChildCount()) {
          continue;
        }
        paramBaseViewHolder.Llx.removeAllViews();
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        final d.a locala = (d.a)((List)localObject2).get(i);
        TextView localTextView = new TextView(paramBaseViewHolder.Llx.getContext());
        localTextView.setText(locala.KeC);
        localTextView.setPadding(0, 0, com.tencent.mm.ci.a.fromDPToPix(paramContext, 10), 0);
        localTextView.setVisibility(0);
        localTextView.setTextSize(1, 14.0F * com.tencent.mm.ci.a.ez(paramContext));
        localTextView.setTextColor(paramContext.getResources().getColor(i.c.sns_link_color));
        paramBaseViewHolder.Llx.addView(localTextView);
        i += 1;
        continue;
        ((a)this.Kei.get(Long.valueOf(paramSnsObject.Id))).jF(j, localb.obd.size());
        continue;
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        locala = (d.a)((List)localObject2).get(i);
        localTextView = (TextView)paramBaseViewHolder.Llx.getChildAt(i);
        localTextView.setText(a(paramContext, localTextView, a(f.a(locala), paramSnsObject), paramSnsObject, paramBaseViewHolder, locala, localb, (d)localObject1));
        localTextView.setTag(paramSnsObject);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96104);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            c.a(c.this, paramContext, paramAnonymousView, locala, localb, paramBaseViewHolder, this.Kep);
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
      if (this.Kef.containsKey(Long.valueOf(paramSnsObject.Id)))
      {
        k = ((Integer)this.Kef.get(Long.valueOf(paramSnsObject.Id))).intValue();
        j = k;
        if (k == -1)
        {
          e(paramBaseViewHolder);
          AppMethodBeat.o(96116);
          return;
          i = ((ekj)new ekj().parseFrom(arrayOfByte)).Umb;
          continue;
        }
      }
      int i = 0;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(96114);
    this.Ked = null;
    this.Kee = null;
    Object localObject2;
    if (this.Keg != null)
    {
      localObject1 = this.Keg.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        s locals = new s(((Long)localObject2).longValue(), 0, 0, null);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(locals, 0);
        Log.i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(localObject2)));
      }
    }
    if (this.Kei != null)
    {
      localObject1 = this.Kei.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((a)((Iterator)localObject1).next());
      }
      this.Kei.clear();
    }
    if ((this.Kec.size() == 0) || (this.JVP == null))
    {
      AppMethodBeat.o(96114);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject1 = com.tencent.mm.kernel.h.aHG().cachePath + "ws_1100004";
    Log.i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(localObject1)));
    try
    {
      localObject2 = this.JVP.toByteArray();
      u.f((String)localObject1, (byte[])localObject2, localObject2.length);
      Log.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + this.JVP.KeR.size());
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
    Object localObject2 = com.tencent.mm.model.c.d.bgB().buV("10001").values().iterator();
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
        Map localMap = localc.hvz();
        if (localMap != null)
        {
          Log.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
          locald.f(localc.field_layerId, localc.field_expId, localMap);
          if ((locald.fzO) && (locald.KeB != null) && (locald.KeB.size() > 0)) {}
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
    this.Kec = ((List)localObject1);
    this.Kef.clear();
    this.Keg.clear();
    this.Kei.clear();
    this.JVP = null;
    if ((this.Kec == null) || (this.Kec.size() == 0))
    {
      AppMethodBeat.o(179118);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject1 = com.tencent.mm.kernel.h.aHG().cachePath + "ws_1100004";
    Log.i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(localObject1)));
    localObject2 = u.aY((String)localObject1, 0, -1);
    if (localObject2 != null)
    {
      try
      {
        this.JVP = ((com.tencent.mm.plugin.sns.j.c)new com.tencent.mm.plugin.sns.j.c().parseFrom((byte[])localObject2));
        Log.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - l));
        if (this.JVP == null)
        {
          Log.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
          AppMethodBeat.o(179118);
          return;
        }
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.SnSABTestMgr", localIOException, "", new Object[0]);
        u.deleteFile((String)localObject1);
        AppMethodBeat.o(179118);
        return;
      }
      Log.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.JVP.KeR.size());
    }
    AppMethodBeat.o(179118);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(96112);
    Log.i("MicroMsg.SnSABTestMgr", "onSceneend " + paramInt1 + " errCode " + paramInt2);
    paramString = new ox();
    EventCenter.instance.publish(paramString);
    AppMethodBeat.o(96112);
  }
  
  static final class a
  {
    long JIs;
    String JJA;
    d Kev;
    int Kew = 0;
    int Kex = 0;
    String Key = "";
    String Kez = "";
    long mEndTime = -1L;
    long mStartTime = -1L;
    
    public a(long paramLong1, long paramLong2, String paramString, d paramd)
    {
      this.Kev = paramd;
      this.mStartTime = paramLong1;
      this.JIs = paramLong2;
      this.JJA = paramString;
    }
    
    private void baI(String paramString)
    {
      AppMethodBeat.i(96110);
      if (!Util.isNullOrNil(this.Kez)) {
        this.Kez += "|";
      }
      this.Kez += paramString;
      AppMethodBeat.o(96110);
    }
    
    public final void P(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(96109);
      if ((paramInt1 == -1) || (paramInt2 == -1))
      {
        AppMethodBeat.o(96109);
        return;
      }
      String str1 = paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4;
      String str2 = paramInt1 + ":" + paramInt2;
      if ((str1.equals(this.Key)) || ((this.Key.startsWith(str2)) && (paramInt3 == 0) && (paramInt4 == 0)))
      {
        AppMethodBeat.o(96109);
        return;
      }
      this.Key = str1;
      baI(paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4);
      AppMethodBeat.o(96109);
    }
    
    public final void jF(int paramInt1, int paramInt2)
    {
      this.Kew = paramInt1;
      this.Kex = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.c
 * JD-Core Version:    0.7.0.1
 */
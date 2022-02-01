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
import com.tencent.mm.autogen.a.qj;
import com.tencent.mm.autogen.a.qk;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.ui.ai;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.u;
import com.tencent.mm.pluginsdk.ui.span.u.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.fer;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;
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
  implements com.tencent.mm.am.h, e
{
  public static final Pattern QBO;
  public static final Pattern QBP;
  public final int QBG;
  private List<d> QBH;
  public ListView QBI;
  public bn QBJ;
  public Map<Long, Integer> QBK;
  public HashSet<Long> QBL;
  public HashSet<Long> QBM;
  private HashMap<Long, a> QBN;
  private u.a QBQ;
  public final int QBe;
  private com.tencent.mm.plugin.sns.k.b QsQ;
  
  static
  {
    AppMethodBeat.i(96128);
    QBO = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    QBP = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    AppMethodBeat.o(96128);
  }
  
  public c()
  {
    AppMethodBeat.i(96111);
    this.QBe = 14;
    this.QBG = 500;
    this.QBK = new HashMap();
    this.QBL = new HashSet();
    this.QBM = new HashSet();
    this.QBN = new HashMap();
    this.QBQ = new u.a()
    {
      public final void onClick(View paramAnonymousView, Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(96111);
  }
  
  private SpannableString a(final Context paramContext, TextView paramTextView, String paramString, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.a parama, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96123);
    Object localObject = QBO.matcher(paramString);
    if ((((Matcher)localObject).find()) && (((Matcher)localObject).groupCount() == 1))
    {
      String str = ((Matcher)localObject).group();
      localObject = ((Matcher)localObject).group(1);
      int i = paramString.indexOf(str);
      paramString = paramString.replace(str, (CharSequence)localObject);
      paramTextView.setOnClickListener(null);
      paramTextView.setClickable(true);
      paramString = new SpannableString(paramString);
      paramTextView.setOnTouchListener(new ai());
      paramString.setSpan(new u(paramSnsObject.Username, new u.a()
      {
        public final void onClick(View paramAnonymousView, Object paramAnonymousObject)
        {
          AppMethodBeat.i(96108);
          c.a(c.this, paramContext, paramSnsObject, parama, paramb, paramBaseViewHolder, paramd);
          AppMethodBeat.o(96108);
        }
      }), i, ((String)localObject).length() + i, 33);
      AppMethodBeat.o(96123);
      return paramString;
    }
    paramContext = com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, paramString);
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
      com.tencent.mm.kernel.h.baF();
      localObject = paramString;
      au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramSnsObject);
      paramSnsObject = paramString;
      localObject = paramString;
      if (paramString.contains("{username}"))
      {
        localObject = paramString;
        paramSnsObject = paramString.replace("{username}", localau.aSV());
      }
      localObject = paramSnsObject;
      int i = localau.sex;
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
        paramSnsObject = QBP.matcher(paramString);
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
            i = localau.sex;
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
    int i = parama.QCj - 1;
    a locala = (a)this.QBN.get(Long.valueOf(paramSnsObject.Id));
    if (locala != null)
    {
      locala.Y(paramb.hAN, paramb.rbP.size(), parama.index, parama.actionType);
      locala.QCb = -1;
      locala.QCc = -1;
    }
    if (parama.actionType == 3)
    {
      this.QBL.add(Long.valueOf(paramSnsObject.Id));
      this.QBK.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
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
        this.QBK.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(i));
        uX(paramSnsObject.Id);
        f(paramBaseViewHolder);
      }
      else
      {
        if (parama.actionType == 5)
        {
          if (this.QBL.contains(Long.valueOf(paramSnsObject.Id)))
          {
            this.QBL.remove(Long.valueOf(paramSnsObject.Id));
            uX(paramSnsObject.Id);
            f(paramBaseViewHolder);
            if (this.QBN.containsKey(Long.valueOf(paramSnsObject.Id))) {
              a((a)this.QBN.remove(Long.valueOf(paramSnsObject.Id)));
            }
          }
          this.QBK.put(Long.valueOf(paramSnsObject.Id), Integer.valueOf(-1));
          e(paramBaseViewHolder);
          AppMethodBeat.o(96120);
          return;
        }
        if (parama.actionType == 7)
        {
          if (i < paramd.QCg.size())
          {
            parama = (d.b)paramd.QCg.get(i);
            if (parama.hAN == 2)
            {
              b(paramContext, paramSnsObject, paramBaseViewHolder, parama, paramd);
              AppMethodBeat.o(96120);
              return;
            }
            if (parama.hAN == 5)
            {
              aa.makeText(paramContext, Util.nullAs(parama.title, ""), 0).show();
              uX(paramSnsObject.Id);
              f(paramBaseViewHolder);
              AppMethodBeat.o(96120);
            }
          }
        }
        else
        {
          if (parama.actionType == 6)
          {
            aa.makeText(paramContext, Util.nullAs(paramContext.getString(b.j.sns_abtest_toast), ""), 0).show();
            this.QBM.add(Long.valueOf(paramSnsObject.Id));
            f(paramBaseViewHolder);
            new qk().publish();
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
            com.tencent.mm.plugin.sns.d.a.pFn.h(paramb, paramContext);
            uX(paramSnsObject.Id);
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
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(parama, 0);
          }
        }
      }
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(96125);
    Object localObject = parama.QCa;
    if (localObject == null)
    {
      AppMethodBeat.o(96125);
      return;
    }
    String str2 = ((d)localObject).sdF;
    String str3 = ((d)localObject).QBF;
    String str4 = parama.Qbe;
    parama.Y(parama.QCb, parama.QCc, 0, 0);
    String str1 = parama.QCe;
    localObject = str1;
    if (Util.isNullOrNil(str1)) {
      localObject = parama.QCb + ":" + parama.QCc + ":0:0";
    }
    long l1 = parama.mStartTime / 1000L;
    if (parama.mEndTime == -1L) {
      parama.mEndTime = System.currentTimeMillis();
    }
    long l2 = parama.mEndTime / 1000L;
    if (parama != null)
    {
      Log.i("MicroMsg.SnSABTestMgr", "report layerId: " + str2 + " expid " + str3 + " acton " + (String)localObject + " starttime " + l1 + " timelineId: " + str4);
      com.tencent.mm.plugin.report.service.h.OAn.b(11917, new Object[] { str2, str3, "", "", Integer.valueOf(1), str4, localObject, Long.valueOf(l1), Long.valueOf(l2) });
    }
    AppMethodBeat.o(96125);
  }
  
  private boolean a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96117);
    paramBaseViewHolder.convertView.setBackgroundDrawable(null);
    int i = paramBaseViewHolder.position;
    Object localObject1;
    if (this.QBJ != null)
    {
      localObject1 = (WeakReference)this.QBJ.Ryr.get(Integer.valueOf(i - 1));
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        break label260;
      }
    }
    Object localObject2;
    for (;;)
    {
      if (!paramBaseViewHolder.RLo)
      {
        paramBaseViewHolder.RLp = paramBaseViewHolder.RLn.inflate();
        paramBaseViewHolder.RLo = true;
        paramBaseViewHolder.RLq = ((LinearLayout)paramBaseViewHolder.RLp.findViewById(b.f.sns_abtest_one_item_ll));
      }
      paramBaseViewHolder.RLp.setVisibility(0);
      paramBaseViewHolder.RLy.setVisibility(8);
      paramBaseViewHolder.RKz.setVisibility(8);
      localObject1 = paramb.rbP;
      if (((List)localObject1).size() == paramBaseViewHolder.RLq.getChildCount()) {
        break;
      }
      paramBaseViewHolder.RLq.removeAllViews();
      int j = com.tencent.mm.cd.a.fromDPToPix(paramContext, 10);
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setBackgroundResource(b.e.album_abtesti_cellbg);
        ((TextView)localObject2).setPadding(j, j, j, j);
        ((TextView)localObject2).setTextSize(1, 14.0F * com.tencent.mm.cd.a.getScaleSize(paramContext));
        ((TextView)localObject2).setTextColor(paramContext.getResources().getColor(b.c.normal_text_color));
        paramBaseViewHolder.RLq.addView((View)localObject2);
        i += 1;
      }
      label260:
      ((View)((WeakReference)localObject1).get()).setBackgroundDrawable(null);
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (d.a)((List)localObject1).get(i);
      TextView localTextView = (TextView)paramBaseViewHolder.RLq.getChildAt(i);
      localTextView.setText(((d.a)localObject2).QCh);
      localTextView.setTag(paramSnsObject);
      String str = a(f.a((d.a)localObject2), paramSnsObject);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96105);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          c.a(c.this, paramContext, paramAnonymousView, this.QBR, paramb, paramBaseViewHolder, paramd);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96105);
        }
      });
      localTextView.setText(a(paramContext, localTextView, str, paramSnsObject, paramBaseViewHolder, (d.a)localObject2, paramb, paramd), TextView.BufferType.SPANNABLE);
      if (((d.a)localObject2).actionType != 5)
      {
        localTextView.setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(paramContext, 5));
        localTextView.setCompoundDrawablesWithIntrinsicBounds(paramContext.getResources().getDrawable(b.i.album_abtesti_icon2), null, null, null);
      }
      i += 1;
    }
    AppMethodBeat.o(96117);
    return true;
  }
  
  private boolean b(final Context paramContext, final SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, final d.b paramb, final d paramd)
  {
    AppMethodBeat.i(96118);
    if (paramb.rbP.size() == 2)
    {
      final d.a locala1 = (d.a)paramb.rbP.get(0);
      final d.a locala2 = (d.a)paramb.rbP.get(1);
      String str1 = a(f.a(locala1), paramSnsObject);
      String str2 = a(f.a(locala2), paramSnsObject);
      k.b(paramContext, a(paramb.title, paramSnsObject), paramContext.getString(b.j.app_tip), str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    paramBaseViewHolder.RLj = false;
    paramBaseViewHolder.RLi = ((ViewStub)paramView.findViewById(b.f.sns_post_item_abtest));
    paramBaseViewHolder.RLi.setVisibility(8);
    paramBaseViewHolder.RLn = ((ViewStub)paramView.findViewById(b.f.sns_item_abtest_layout));
    paramBaseViewHolder.RLn.setVisibility(8);
    AppMethodBeat.o(96115);
  }
  
  private void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(306485);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(306485);
      return;
    }
    Context localContext = paramBaseViewHolder.convertView.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(306485);
      return;
    }
    if (paramBaseViewHolder.convertView.getBackground() == null)
    {
      paramBaseViewHolder.convertView.setBackgroundResource(b.e.comm_list_item_selector);
      paramBaseViewHolder.convertView.setPadding(com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 8));
    }
    int i = paramBaseViewHolder.position;
    if (this.QBJ != null)
    {
      paramBaseViewHolder = (WeakReference)this.QBJ.Ryr.get(Integer.valueOf(i - 1));
      if ((paramBaseViewHolder == null) || (paramBaseViewHolder.get() == null))
      {
        AppMethodBeat.o(306485);
        return;
      }
      ((View)paramBaseViewHolder.get()).setBackgroundResource(b.e.comm_list_item_selector);
      ((View)paramBaseViewHolder.get()).setPadding(com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 12), com.tencent.mm.cd.a.fromDPToPix(localContext, 8));
    }
    AppMethodBeat.o(306485);
  }
  
  private static void f(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96121);
    if (paramBaseViewHolder == null)
    {
      AppMethodBeat.o(96121);
      return;
    }
    if (paramBaseViewHolder.RLi != null) {
      paramBaseViewHolder.RLi.setVisibility(8);
    }
    if (paramBaseViewHolder.RLk != null) {
      paramBaseViewHolder.RLk.setVisibility(8);
    }
    if (paramBaseViewHolder.RLn != null) {
      paramBaseViewHolder.RLn.setVisibility(8);
    }
    if (paramBaseViewHolder.RLp != null) {
      paramBaseViewHolder.RLp.setVisibility(8);
    }
    if (paramBaseViewHolder.RLy.getVisibility() == 8) {
      paramBaseViewHolder.RLy.setVisibility(0);
    }
    if (paramBaseViewHolder.RKz.getVisibility() == 8) {
      paramBaseViewHolder.RKz.setVisibility(0);
    }
    if (paramBaseViewHolder.convertView.getVisibility() == 8) {
      paramBaseViewHolder.convertView.setVisibility(0);
    }
    AppMethodBeat.o(96121);
  }
  
  private void uX(long paramLong)
  {
    AppMethodBeat.i(96113);
    if (this.QsQ == null) {
      this.QsQ = new com.tencent.mm.plugin.sns.k.b();
    }
    if (this.QsQ.QCv.size() > 500) {
      this.QsQ.QCv.remove(0);
    }
    this.QsQ.QCv.add(Long.valueOf(paramLong));
    AppMethodBeat.o(96113);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(96124);
    if (this.QBN.containsKey(Long.valueOf(paramLong)))
    {
      paramString = (a)this.QBN.get(Long.valueOf(paramLong));
      if (paramString.mEndTime == -1L) {
        paramString.mEndTime = System.currentTimeMillis();
      }
      paramString.Y(paramString.QCb, paramString.QCc, 0, 0);
    }
    AppMethodBeat.o(96124);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bu parambu) {}
  
  public final void a(final Context paramContext, SnsObject paramSnsObject, final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(96116);
    if (!LocaleUtil.isSimplifiedChineseAppLang())
    {
      f(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.QBH == null) || (this.QBH.size() == 0))
    {
      f(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if (this.QBM.contains(Long.valueOf(paramSnsObject.Id)))
    {
      f(paramBaseViewHolder);
      paramBaseViewHolder.RLy.setVisibility(8);
      paramBaseViewHolder.RKz.setVisibility(8);
      paramBaseViewHolder.convertView.setVisibility(8);
      AppMethodBeat.o(96116);
      return;
    }
    if ((paramSnsObject.Username == null) || (paramSnsObject.Username.equals(al.hgg())))
    {
      f(paramBaseViewHolder);
      AppMethodBeat.o(96116);
      return;
    }
    if ((this.QsQ != null) && (this.QsQ.QCv.contains(Long.valueOf(paramSnsObject.Id))))
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
        arrayOfByte = w.a(paramSnsObject.ObjectOperations);
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
        Object localObject2 = this.QBH.iterator();
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
        if (((d)localObject1).QCf != i) {
          continue;
        }
        if (localObject1 != null) {
          continue;
        }
        f(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        if (j < ((d)localObject1).QCg.size()) {
          continue;
        }
        f(paramBaseViewHolder);
        AppMethodBeat.o(96116);
        return;
        localb = (d.b)((d)localObject1).QCg.get(j);
        int j = localb.hAN;
        f(paramBaseViewHolder);
        if (i <= 0) {
          continue;
        }
        if (this.QBN.containsKey(Long.valueOf(paramSnsObject.Id))) {
          continue;
        }
        localObject2 = new a(System.currentTimeMillis(), paramSnsObject.Id, t.uA(paramSnsObject.Id), (d)localObject1);
        ((a)localObject2).lr(j, localb.rbP.size());
        this.QBN.put(Long.valueOf(paramSnsObject.Id), localObject2);
        if (j != 1) {
          continue;
        }
        localObject2 = localb.title;
        if (paramBaseViewHolder.RLj) {
          continue;
        }
        paramBaseViewHolder.RLk = paramBaseViewHolder.RLi.inflate();
        paramBaseViewHolder.RLj = true;
        paramBaseViewHolder.RLm = ((TextView)paramBaseViewHolder.RLk.findViewById(b.f.post_abtest_click_text));
        paramBaseViewHolder.RLl = ((LinearLayout)paramBaseViewHolder.RLk.findViewById(b.f.abtest_button_list));
        paramBaseViewHolder.RLk.setVisibility(0);
        paramBaseViewHolder.RLm.setText((CharSequence)localObject2);
        localObject2 = localb.rbP;
        if (((List)localObject2).size() == paramBaseViewHolder.RLl.getChildCount()) {
          continue;
        }
        paramBaseViewHolder.RLl.removeAllViews();
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        final d.a locala = (d.a)((List)localObject2).get(i);
        TextView localTextView = new TextView(paramBaseViewHolder.RLl.getContext());
        localTextView.setText(locala.QCh);
        localTextView.setPadding(0, 0, com.tencent.mm.cd.a.fromDPToPix(paramContext, 10), 0);
        localTextView.setVisibility(0);
        localTextView.setTextSize(1, 14.0F * com.tencent.mm.cd.a.getScaleSize(paramContext));
        localTextView.setTextColor(paramContext.getResources().getColor(b.c.sns_link_color));
        paramBaseViewHolder.RLl.addView(localTextView);
        i += 1;
        continue;
        ((a)this.QBN.get(Long.valueOf(paramSnsObject.Id))).lr(j, localb.rbP.size());
        continue;
        i = 0;
        if (i >= ((List)localObject2).size()) {
          continue;
        }
        locala = (d.a)((List)localObject2).get(i);
        localTextView = (TextView)paramBaseViewHolder.RLl.getChildAt(i);
        localTextView.setText(a(paramContext, localTextView, a(f.a(locala), paramSnsObject), paramSnsObject, paramBaseViewHolder, locala, localb, (d)localObject1));
        localTextView.setTag(paramSnsObject);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96104);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            c.a(c.this, paramContext, paramAnonymousView, locala, localb, paramBaseViewHolder, this.QBU);
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
        if (!a(paramContext, paramSnsObject, paramBaseViewHolder, localb, (d)localObject1)) {
          continue;
        }
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
      if (this.QBK.containsKey(Long.valueOf(paramSnsObject.Id)))
      {
        k = ((Integer)this.QBK.get(Long.valueOf(paramSnsObject.Id))).intValue();
        j = k;
        if (k == -1)
        {
          f(paramBaseViewHolder);
          AppMethodBeat.o(96116);
          return;
          i = ((fer)new fer().parseFrom(arrayOfByte)).abEc;
          continue;
        }
      }
      int i = 0;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(96114);
    this.QBI = null;
    this.QBJ = null;
    Object localObject2;
    if (this.QBL != null)
    {
      localObject1 = this.QBL.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        com.tencent.mm.plugin.sns.model.s locals = new com.tencent.mm.plugin.sns.model.s(((Long)localObject2).longValue(), 0, 0, null);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(locals, 0);
        Log.i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(localObject2)));
      }
    }
    if (this.QBN != null)
    {
      localObject1 = this.QBN.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((a)((Iterator)localObject1).next());
      }
      this.QBN.clear();
    }
    if ((this.QBH.size() == 0) || (this.QsQ == null))
    {
      AppMethodBeat.o(96114);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject1 = com.tencent.mm.kernel.h.baE().cachePath + "ws_1100004";
    Log.i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(localObject1)));
    try
    {
      localObject2 = this.QsQ.toByteArray();
      y.f((String)localObject1, (byte[])localObject2, localObject2.length);
      Log.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + this.QsQ.QCv.size());
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
    Object localObject2 = com.tencent.mm.model.newabtest.d.bEt().bvc("10001");
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).values().iterator();
      label263:
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
          Map localMap = localc.iWZ();
          if (localMap != null)
          {
            Log.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
            locald.f(localc.field_layerId, localc.field_expId, localMap);
            if ((locald.hEn) && (locald.QCg != null) && (locald.QCg.size() > 0)) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label263;
              }
              ((List)localObject1).add(locald);
              break;
            }
          }
        }
      }
    }
    this.QBH = ((List)localObject1);
    this.QBK.clear();
    this.QBL.clear();
    this.QBN.clear();
    this.QsQ = null;
    if ((this.QBH == null) || (this.QBH.size() == 0))
    {
      AppMethodBeat.o(179118);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject1 = com.tencent.mm.kernel.h.baE().cachePath + "ws_1100004";
    Log.i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(localObject1)));
    localObject2 = y.bi((String)localObject1, 0, -1);
    if (localObject2 != null)
    {
      try
      {
        this.QsQ = ((com.tencent.mm.plugin.sns.k.b)new com.tencent.mm.plugin.sns.k.b().parseFrom((byte[])localObject2));
        Log.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - l));
        if (this.QsQ == null)
        {
          Log.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
          AppMethodBeat.o(179118);
          return;
        }
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.SnSABTestMgr", localIOException, "", new Object[0]);
        y.deleteFile((String)localObject1);
        AppMethodBeat.o(179118);
        return;
      }
      Log.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.QsQ.QCv.size());
    }
    AppMethodBeat.o(179118);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(96112);
    Log.i("MicroMsg.SnSABTestMgr", "onSceneend " + paramInt1 + " errCode " + paramInt2);
    new qj().publish();
    AppMethodBeat.o(96112);
  }
  
  static final class a
  {
    long PZu;
    d QCa;
    int QCb = 0;
    int QCc = 0;
    String QCd = "";
    String QCe = "";
    String Qbe;
    long mEndTime = -1L;
    long mStartTime = -1L;
    
    public a(long paramLong1, long paramLong2, String paramString, d paramd)
    {
      this.QCa = paramd;
      this.mStartTime = paramLong1;
      this.PZu = paramLong2;
      this.Qbe = paramString;
    }
    
    private void aZf(String paramString)
    {
      AppMethodBeat.i(96110);
      if (!Util.isNullOrNil(this.QCe)) {
        this.QCe += "|";
      }
      this.QCe += paramString;
      AppMethodBeat.o(96110);
    }
    
    public final void Y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(96109);
      if ((paramInt1 == -1) || (paramInt2 == -1))
      {
        AppMethodBeat.o(96109);
        return;
      }
      String str1 = paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4;
      String str2 = paramInt1 + ":" + paramInt2;
      if ((str1.equals(this.QCd)) || ((this.QCd.startsWith(str2)) && (paramInt3 == 0) && (paramInt4 == 0)))
      {
        AppMethodBeat.o(96109);
        return;
      }
      this.QCd = str1;
      aZf(paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4);
      AppMethodBeat.o(96109);
    }
    
    public final void lr(int paramInt1, int paramInt2)
    {
      this.QCb = paramInt1;
      this.QCc = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.c
 * JD-Core Version:    0.7.0.1
 */
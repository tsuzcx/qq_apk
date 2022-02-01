package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.t;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class g
  extends x<bb>
  implements MStorageEx.IOnStorageChange
{
  private static long afmV = 2000L;
  boolean Rdz;
  private float aeaW;
  protected float aeaZ;
  private float aeba;
  private ColorStateList[] aebb;
  private HashMap<String, d> aebd;
  private boolean aebe;
  private NoMeasuredTextView.c afaM;
  private boolean afmI;
  private f afmJ;
  private com.tencent.mm.pluginsdk.ui.e afmK;
  private boolean afmL;
  private boolean afmM;
  private g.c afmN;
  private IListener afmO;
  private b afmP;
  public String afmQ;
  final e afmR;
  private final int afmS;
  private final int afmT;
  private a afmU;
  private boolean afmW;
  private MTimerHandler afmX;
  protected List<String> lMF;
  private String pRp;
  private boolean pVy;
  protected MMSlideDelView.g vzf;
  protected MMSlideDelView.c vzg;
  protected MMSlideDelView.f vzh;
  protected MMSlideDelView.d vzi;
  private boolean xhA;
  
  public g(Context paramContext, x.a parama)
  {
    super(paramContext, new bb());
    AppMethodBeat.i(38304);
    this.lMF = null;
    this.aebb = new ColorStateList[5];
    this.afmI = true;
    this.pVy = false;
    this.vzi = MMSlideDelView.getItemStatusCallBack();
    this.aeaW = -1.0F;
    this.aeaZ = -1.0F;
    this.aeba = -1.0F;
    this.xhA = false;
    this.aebe = false;
    this.afmL = false;
    this.afmM = false;
    this.afmO = null;
    this.afmP = null;
    this.afaM = new NoMeasuredTextView.c()
    {
      public final CharSequence a(NoMeasuredTextView paramAnonymousNoMeasuredTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(256741);
        float f1 = paramAnonymousNoMeasuredTextView.getPaint().getTextSize();
        paramAnonymousInt2 = com.tencent.mm.cd.a.fromDPToPix(g.a(g.this), paramAnonymousInt2);
        paramAnonymousNoMeasuredTextView.getPaint().setTextSize(paramAnonymousInt2);
        float f2 = paramAnonymousNoMeasuredTextView.getPaint().measureText(" ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousNoMeasuredTextView.getPaint().setTextSize(f1);
        int i = paramAnonymousNoMeasuredTextView.getMeasuredWidth() - paramAnonymousNoMeasuredTextView.getCompoundPaddingRight() - paramAnonymousNoMeasuredTextView.getCompoundPaddingLeft();
        if (f2 >= i * 0.6D)
        {
          paramAnonymousCharSequence = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousNoMeasuredTextView.getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
          f2 = paramAnonymousNoMeasuredTextView.getPaint().measureText(paramAnonymousCharSequence.toString());
          paramAnonymousNoMeasuredTextView.getPaint().setTextSize(paramAnonymousInt2);
          paramAnonymousString = TextUtils.ellipsize(paramAnonymousString, paramAnonymousNoMeasuredTextView.getPaint(), i - f2 - 20.0F, TextUtils.TruncateAt.END);
          paramAnonymousNoMeasuredTextView.getPaint().setTextSize(f1);
        }
        for (paramAnonymousNoMeasuredTextView = paramAnonymousCharSequence;; paramAnonymousNoMeasuredTextView = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousNoMeasuredTextView.getPaint(), i - f2, TextUtils.TruncateAt.END))
        {
          paramAnonymousCharSequence = com.tencent.mm.pluginsdk.ui.span.p.b(g.b(g.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
          ColorStateList localColorStateList = com.tencent.mm.cd.a.l(g.c(g.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(256741);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.afmQ = "";
    this.afmR = new e();
    this.Rdz = false;
    this.afmW = false;
    this.afmX = new MTimerHandler(bh.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(256746);
        if (g.f(g.this)) {
          g.g(g.this);
        }
        AppMethodBeat.o(256746);
        return false;
      }
    }, false);
    super.a(parama);
    this.aebb[0] = com.tencent.mm.cd.a.l(paramContext, R.e.hint_text_color);
    this.aebb[1] = com.tencent.mm.cd.a.l(paramContext, R.e.red_text_color);
    this.aebb[3] = com.tencent.mm.cd.a.l(paramContext, R.e.normal_text_color);
    this.aebb[2] = com.tencent.mm.cd.a.l(paramContext, R.e.mm_list_textcolor_three);
    this.aebb[2] = com.tencent.mm.cd.a.l(paramContext, R.e.mm_list_textcolor_three);
    this.aebb[4] = com.tencent.mm.cd.a.l(paramContext, R.e.light_text_color);
    this.aebd = new HashMap();
    if (com.tencent.mm.cd.a.mq(paramContext))
    {
      this.afmT = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeLargerWidth);
      this.afmS = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
    }
    for (;;)
    {
      this.aeaW = com.tencent.mm.cd.a.br(paramContext, R.f.NormalTextSize);
      this.aeaZ = com.tencent.mm.cd.a.br(paramContext, R.f.HintTextSize);
      this.aeba = com.tencent.mm.cd.a.br(paramContext, R.f.SmallestTextSize);
      AppMethodBeat.o(38304);
      return;
      if (com.tencent.mm.cd.a.mp(paramContext))
      {
        this.afmT = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
        this.afmS = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
      }
      else
      {
        this.afmT = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
        this.afmS = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth);
      }
    }
  }
  
  private CharSequence a(bb parambb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38315);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (parambb.field_remitMarkRed == 1)
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.gSR));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject1);
      Log.i("MicroMsg.ConversationAdapter", "mark remittance flag conversation: %s, flag: %s", new Object[] { parambb.field_username, Integer.valueOf(parambb.field_attrflag) });
    }
    while (((!Util.isNullOrNil(parambb.field_editingMsg)) || (parambb.field_editingQuoteMsgId != 0L)) && ((parambb.field_atCount <= 0) || ((parambb.field_unReadCount <= 0) && (parambb.field_unReadMuteCount <= 0))) && (parambb.field_hasSpecialFollow == 0))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.gNc));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      if (!Util.isNullOrNil(parambb.field_editingMsg)) {
        ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.d(this.context, parambb.field_editingMsg, paramInt));
      }
      parambb = localSpannableStringBuilder.append((CharSequence)localObject1);
      AppMethodBeat.o(38315);
      return parambb;
      if (parambb.field_hbMarkRed == 1)
      {
        localObject1 = new SpannableStringBuilder(this.context.getString(R.l.grU));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        localSpannableStringBuilder.append((CharSequence)localObject1);
        Log.i("MicroMsg.ConversationAdapter", "mark hb flag conversation: %s", new Object[] { parambb.field_username });
      }
    }
    if ((aip(parambb.field_msgType) == 10000) && (!ab.c(parambb)) && (parambb.field_hasTodo != 1) && (parambb.field_hasSpecialFollow == 0))
    {
      if (parambb.field_content.contains("weixin://wxpay/transfer/remindrcvmsg"))
      {
        Log.i("MicroMsg.ConversationAdapter", "is transfer remind msg ");
        parambb = localSpannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.h(this.context, parambb.field_content, paramInt));
        AppMethodBeat.o(38315);
        return parambb;
      }
      if (parambb.field_hbMarkRed == 1)
      {
        parambb = localSpannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.h(this.context, parambb.field_content, paramInt));
        AppMethodBeat.o(38315);
        return parambb;
      }
      if (parambb.field_remitMarkRed == 1)
      {
        parambb = localSpannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.h(this.context, parambb.field_content, paramInt));
        AppMethodBeat.o(38315);
        return parambb;
      }
      parambb = new SpannableString(com.tencent.mm.pluginsdk.ui.span.p.h(this.context, parambb.field_content, paramInt));
      AppMethodBeat.o(38315);
      return parambb;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject5;
    Object localObject4;
    if (aip(parambb.field_msgType) == 49)
    {
      localObject5 = aa.getDisplayName(parambb.field_digestUser);
      localObject4 = k.b.Hf(parambb.field_content);
      localObject1 = localObject2;
      if (localObject4 == null) {}
    }
    switch (((k.b)localObject4).type)
    {
    default: 
      localObject1 = localObject2;
      localObject2 = parambb.field_digest;
      if ((localObject2 == null) || (!((String)localObject2).startsWith("<img src=\"original_label.png\"/>  "))) {
        break;
      }
    }
    label729:
    Object localObject3;
    label798:
    label937:
    label969:
    label979:
    label1751:
    String str1;
    for (localObject2 = new SpannableString(com.tencent.mm.pluginsdk.ui.span.p.e(this.context, (CharSequence)localObject2, paramInt));; localObject3 = str1)
    {
      localObject5 = parambb.field_username;
      localObject1 = localObject2;
      int i;
      if (((String)localObject5).equals("qqmail"))
      {
        bh.bCz();
        if (Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(17, null)) != 1) {
          break label1476;
        }
        i = 1;
        localObject1 = localObject2;
        if (i == 0) {
          localObject1 = this.context.getString(R.l.settings_plugins_disable);
        }
      }
      localObject4 = localObject1;
      if (((String)localObject5).equals("tmessage"))
      {
        bh.bCz();
        localObject2 = com.tencent.mm.model.c.bzJ().aMh("@t.qq.com");
        if ((localObject2 == null) || (!((cm)localObject2).isEnable())) {
          break label1482;
        }
        i = 1;
        localObject4 = localObject1;
        if (i == 0) {
          localObject4 = this.context.getString(R.l.settings_plugins_disable);
        }
      }
      localObject2 = localObject4;
      if (parambb.field_msgType != null)
      {
        localObject2 = localObject4;
        if (parambb.field_msgType.equals("64")) {
          localObject2 = parambb.field_content;
        }
      }
      if ((parambb.field_msgType != null) && ((parambb.field_msgType.equals("47")) || (parambb.field_msgType.equals("1048625"))))
      {
        localObject1 = bAr(parambb.field_digest);
        localObject5 = "";
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject1 = "[" + (String)localObject1 + "]";
          localObject4 = localObject5;
          localObject2 = localObject1;
          if (Util.isNullOrNil((CharSequence)localObject1))
          {
            localObject2 = this.context.getString(R.l.app_emoji);
            if (!Util.isNullOrNil((String)localObject4)) {
              break label1694;
            }
            parambb.BF((String)localObject2);
            localObject2 = localObject1;
          }
          localObject1 = localObject2;
          if (Util.isNullOrNil((CharSequence)localObject2))
          {
            if (Util.isNullOrNil(parambb.field_digest)) {
              break label1751;
            }
            if (Util.isNullOrNil(parambb.field_digestUser)) {
              break label1740;
            }
            localObject1 = r(parambb);
          }
        }
      }
      for (;;)
      {
        label1476:
        label1482:
        label1740:
        try
        {
          localObject1 = String.format(parambb.field_digest, new Object[] { localObject1 });
          localObject1 = ((CharSequence)localObject1).toString().replace('\n', ' ');
          localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject1, paramInt);
          if ((!parambb.rx(33554432)) || ((parambb.field_unReadCount <= 0) && (parambb.field_unReadMuteCount <= 0))) {
            break label1782;
          }
          parambb = new SpannableStringBuilder(this.context.getString(R.l.gWA));
          parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
          parambb.append(" ").append((CharSequence)localObject1);
          parambb = localSpannableStringBuilder.append(parambb);
          AppMethodBeat.o(38315);
          return parambb;
        }
        catch (Exception localException1) {}
        localObject4 = t.Hk(parambb.field_content);
        localObject1 = localObject2;
        if (localObject4 == null) {
          break;
        }
        localObject1 = localObject2;
        if (((t)localObject4).nUJ != 19) {
          break;
        }
        if (Util.isNullOrNil((String)localObject5))
        {
          localObject1 = this.context.getString(R.l.app_record);
          parambb.BF((String)localObject1);
          localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject1, paramInt);
          break;
        }
        localObject1 = (String)localObject5 + ": " + this.context.getString(R.l.app_record);
        continue;
        localObject1 = null;
        try
        {
          localObject2 = String.format(parambb.field_digest, new Object[] { r(parambb) });
          localObject1 = localObject2;
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.ConversationAdapter", localException2, "", new Object[0]);
          continue;
        }
        localObject5 = new StringBuilder();
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject2 = this.context.getString(R.l.app_url);
        }
        localObject1 = (String)localObject2 + " " + ((k.b)localObject4).title;
        localObject1 = com.tencent.mm.pluginsdk.ui.span.p.h(this.context, (CharSequence)localObject1, paramInt);
        break;
        if (Util.isNullOrNil((String)localObject5))
        {
          localObject1 = this.context.getString(R.l.app_record);
          parambb.BF((String)localObject1);
          localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject1, paramInt);
          break;
        }
        localObject1 = (String)localObject5 + ": " + this.context.getString(R.l.app_record);
        continue;
        i = 0;
        break label729;
        i = 0;
        break label798;
        localObject4 = localObject5;
        localObject1 = localException2;
        if (parambb.field_digest == null) {
          break label937;
        }
        localObject4 = localObject5;
        localObject1 = localException2;
        if (!parambb.field_digest.contains(":")) {
          break label937;
        }
        localObject5 = parambb.field_digest.substring(0, parambb.field_digest.indexOf(":"));
        String str2 = bAr(parambb.field_digest.substring(parambb.field_digest.indexOf(":") + 1).replace(" ", ""));
        localObject4 = localObject5;
        localObject1 = localException2;
        if (Util.isNullOrNil(str2)) {
          break label937;
        }
        localObject3 = "[" + str2 + "]";
        if (Util.isNullOrNil((String)localObject5))
        {
          localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject5, paramInt);
          localObject4 = localObject5;
          break label937;
        }
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append(com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject5, paramInt));
        ((SpannableStringBuilder)localObject1).append(": ");
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject3);
        localObject4 = localObject5;
        break label937;
        label1694:
        localObject3 = (String)localObject4 + ": " + (String)localObject3;
        break label969;
        localObject3 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject3, paramInt);
        break label979;
        localObject1 = parambb.field_digest;
        continue;
        str1 = com.tencent.mm.booter.notification.a.h.a(parambb.field_isSend, parambb.field_username, parambb.field_content, aip(parambb.field_msgType), this.context);
      }
      label1782:
      if (parambb.field_UnReadInvite > 0)
      {
        if (parambb.field_UnReadInvite < 4096) {}
        for (parambb = this.context.getString(R.l.gMZ, new Object[] { Integer.valueOf(parambb.field_UnReadInvite) });; parambb = this.context.getString(R.l.gMW))
        {
          parambb = new SpannableStringBuilder(parambb);
          parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
          parambb.append(" ").append(str1);
          AppMethodBeat.o(38315);
          return parambb;
        }
      }
      if ((parambb.field_atCount > 0) && ((parambb.field_unReadCount > 0) || (parambb.field_unReadMuteCount > 0)))
      {
        localObject3 = this.context;
        if (parambb.field_atCount < 4096) {
          paramInt = R.l.gMY;
        }
        for (;;)
        {
          parambb = new SpannableStringBuilder(((Context)localObject3).getString(paramInt));
          parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
          parambb.append(" ").append(str1);
          AppMethodBeat.o(38315);
          return parambb;
          if (com.tencent.mm.an.g.Dn(parambb.field_username)) {
            paramInt = R.l.gMX;
          } else {
            paramInt = R.l.gNa;
          }
        }
      }
      if ((parambb.field_hasSpecialFollow > 0) && ((parambb.field_unReadCount > 0) || (parambb.field_unReadMuteCount > 0)))
      {
        parambb = new SpannableStringBuilder(this.context.getString(R.l.gWu));
        parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
        parambb.append(" ").append(str1);
        AppMethodBeat.o(38315);
        return parambb;
      }
      if (parambb.field_hasTodo == 1)
      {
        parambb = new SpannableStringBuilder(this.context.getString(R.l.gXq));
        parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
        parambb.append(" ").append(str1);
        AppMethodBeat.o(38315);
        return parambb;
      }
      if ((parambb.rx(16777216)) && ((parambb.field_unReadCount > 0) || (parambb.field_unReadMuteCount > 0)))
      {
        parambb = this.context.getString(R.l.gpu);
        str1 = str1.toString().replace(parambb, "");
        parambb = new SpannableStringBuilder(parambb);
        parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
        parambb.append(com.tencent.mm.pluginsdk.ui.span.p.d(this.context, str1, paramInt));
        parambb = localSpannableStringBuilder.append(parambb);
        AppMethodBeat.o(38315);
        return parambb;
      }
      if (parambb.field_remitMarkRed == 1)
      {
        parambb = this.context.getString(R.l.gSR);
        localSpannableStringBuilder.append(str1.toString().replace(parambb, ""));
        AppMethodBeat.o(38315);
        return localSpannableStringBuilder;
      }
      if (parambb.field_hbMarkRed == 1)
      {
        localObject3 = str1;
        if (aip(parambb.field_msgType) == 436207665)
        {
          parambb = k.b.Hf(parambb.field_content);
          localObject3 = str1;
          if (parambb != null)
          {
            parambb = str1.toString().replace("[" + parambb.nSI + "]", "");
            localObject3 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, parambb, paramInt);
          }
        }
      }
      label2868:
      do
      {
        do
        {
          do
          {
            parambb = localSpannableStringBuilder.append((CharSequence)localObject3);
            AppMethodBeat.o(38315);
            return parambb;
            if ((paramBoolean) && ((parambb.field_unReadCount > 1) || (parambb.field_unReadMuteCount > 0)))
            {
              localSpannableStringBuilder.append(this.context.getString(R.l.gNb, new Object[] { Integer.valueOf(parambb.field_unReadCount), "" }));
              localSpannableStringBuilder.append(str1);
              AppMethodBeat.o(38315);
              return localSpannableStringBuilder;
            }
            if (!au.bwp(parambb.field_username)) {
              break label2868;
            }
            localObject3 = com.tencent.mm.plugin.biz.b.a.vtj;
            localObject3 = com.tencent.mm.plugin.biz.b.a.a(paramInt, this.context, parambb);
            if ((localObject3 != null) && (((CharSequence)localObject3).length() > 0))
            {
              AppMethodBeat.o(38315);
              return localObject3;
            }
            paramBoolean = parambb.rx(16);
            if ((parambb.field_unReadCount <= 1) && ((paramBoolean) || (parambb.field_unReadCount <= 0))) {
              break;
            }
            if (paramBoolean)
            {
              if (parambb.rx(32))
              {
                parambb = this.context.getString(R.l.main_conversation_biz_time_line_unread_count, new Object[] { Integer.valueOf(parambb.field_unReadCount) });
                localObject3 = com.tencent.mm.plugin.biz.b.a.vtj;
                parambb = TextUtils.concat(new CharSequence[] { parambb, " ", com.tencent.mm.plugin.biz.b.a.e(paramInt, this.context), str1 });
                AppMethodBeat.o(38315);
                return parambb;
              }
              localSpannableStringBuilder.append(this.context.getString(R.l.gNb, new Object[] { Integer.valueOf(parambb.field_unReadCount), "" }));
              localSpannableStringBuilder.append(str1);
              AppMethodBeat.o(38315);
              return localSpannableStringBuilder;
            }
            localObject3 = str1;
          } while (!ai.iZf());
          localSpannableStringBuilder.append(this.context.getString(R.l.gMV, new Object[] { Integer.valueOf(parambb.field_unReadCount), "" }));
          localSpannableStringBuilder.append(str1);
          AppMethodBeat.o(38315);
          return localSpannableStringBuilder;
          localObject3 = str1;
        } while (!parambb.rx(32));
        parambb = com.tencent.mm.plugin.biz.b.a.vtj;
        parambb = TextUtils.concat(new CharSequence[] { com.tencent.mm.plugin.biz.b.a.e(paramInt, this.context), str1 });
        AppMethodBeat.o(38315);
        return parambb;
        if ((au.bwA(parambb.field_username)) && ((parambb.field_unReadCount > 1) || (parambb.field_unReadMuteCount > 0)))
        {
          localSpannableStringBuilder.append(this.context.getString(R.l.gNb, new Object[] { Integer.valueOf(parambb.field_unReadCount), "" }));
          localSpannableStringBuilder.append(str1);
          AppMethodBeat.o(38315);
          return localSpannableStringBuilder;
        }
        if (aip(parambb.field_msgType) == 889192497) {
          break;
        }
        localObject3 = str1;
      } while (aip(parambb.field_msgType) != 922746929);
      parambb = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).b(this.context, aip(parambb.field_msgType), parambb.field_content, parambb.field_username, paramInt);
      AppMethodBeat.o(38315);
      return parambb;
    }
  }
  
  private static int aip(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(38313);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(38313);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private static String bAr(String paramString)
  {
    AppMethodBeat.i(38316);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(paramString);
      AppMethodBeat.o(38316);
      return paramString;
    }
    AppMethodBeat.o(38316);
    return null;
  }
  
  private void fHY()
  {
    AppMethodBeat.i(38308);
    if (this.aebd == null)
    {
      AppMethodBeat.o(38308);
      return;
    }
    Iterator localIterator = this.aebd.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).afna = null;
    }
    AppMethodBeat.o(38308);
  }
  
  private void jzT()
  {
    AppMethodBeat.i(38320);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38302);
        if (!bh.baz())
        {
          g.h(g.this).stopTimer();
          Log.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38302);
          return;
        }
        long l = Util.nowMilliSecond();
        g.i(g.this);
        l = Util.milliSecondsToNow(l) * 3L;
        Log.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(g.jzU()), Boolean.valueOf(g.f(g.this)) });
        g.At((l + g.jzU()) / 2L);
        g.j(g.this);
        g.h(g.this).startTimer(g.jzU());
        AppMethodBeat.o(38302);
      }
    });
    AppMethodBeat.o(38320);
  }
  
  private CharSequence q(bb parambb)
  {
    AppMethodBeat.i(38305);
    if (parambb.field_status == 1)
    {
      parambb = this.context.getString(R.l.gNp);
      AppMethodBeat.o(38305);
      return parambb;
    }
    if (parambb.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38305);
      return "";
    }
    parambb = f.d(this.context, parambb.field_conversationTime, true);
    AppMethodBeat.o(38305);
    return parambb;
  }
  
  private static String r(bb parambb)
  {
    AppMethodBeat.i(256892);
    if ((parambb.field_isSend == 0) && (au.bwE(parambb.field_username)))
    {
      parambb = aa.aV(parambb.field_digestUser, parambb.field_username);
      AppMethodBeat.o(256892);
      return parambb;
    }
    parambb = aa.getDisplayName(parambb.field_digestUser);
    AppMethodBeat.o(256892);
    return parambb;
  }
  
  public bb a(bb parambb, Cursor paramCursor)
  {
    AppMethodBeat.i(257032);
    if (this.pVy)
    {
      if ((paramCursor.getString(0) != null) && (paramCursor.getString(0).equals("1")))
      {
        localObject = parambb;
        if (parambb == null) {
          localObject = new bb();
        }
        ((bb)localObject).BF("");
        ((bb)localObject).BG("");
        ((bb)localObject).convertFrom(paramCursor);
        AppMethodBeat.o(257032);
        return localObject;
      }
      if (paramCursor.getString(0).equals("2"))
      {
        bh.bCz();
        au localau = com.tencent.mm.model.c.bzA().bxq(au.t(paramCursor));
        localObject = localau;
        if (localau == null)
        {
          localObject = new au();
          ((au)localObject).convertFrom(paramCursor);
          bh.bCz();
          com.tencent.mm.model.c.bzA().ay((au)localObject);
        }
        paramCursor = parambb;
        if (parambb == null) {
          paramCursor = new bb();
        }
        paramCursor.setStatus(2);
        paramCursor.gR(-1L);
        paramCursor.pI(1);
        paramCursor.setContent(this.context.getString(R.l.gIQ));
        paramCursor.setUsername(((az)localObject).field_username);
        paramCursor.pG(0);
        paramCursor.BE(Integer.toString(1));
        paramCursor.BF("");
        paramCursor.BG("");
        AppMethodBeat.o(257032);
        return paramCursor;
      }
    }
    Object localObject = parambb;
    if (parambb == null) {
      localObject = new bb();
    }
    ((bb)localObject).BF("");
    ((bb)localObject).BG("");
    ((bb)localObject).convertFrom(paramCursor);
    AppMethodBeat.o(257032);
    return localObject;
  }
  
  protected void a(bb parambb, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.vzh = paramf;
  }
  
  protected void a(String paramString, g paramg) {}
  
  public void aNy()
  {
    AppMethodBeat.i(38311);
    Log.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(this.pVy) });
    if (this.pVy)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = bh.bCz().oit.a(ab.ojZ, this.lMF, this.pRp);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.lMF != null) && (this.lMF.size() > 0)) {
        localArrayList1.addAll(this.lMF);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!au.bwE(str)) {
            localArrayList2.add(str);
          }
          Log.d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(str)));
        }
        if (this.afmJ == null) {}
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ConversationAdapter", localException, "", new Object[0]);
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = bh.bCz().oiu.b(this.pRp, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        w(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (this.pRp != null) {
        Fv().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38311);
      return;
      bh.bCz();
      w(com.tencent.mm.model.c.bzG().d(this.lMF, com.tencent.mm.l.a.maX, false));
    }
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(38306);
    aNy();
    AppMethodBeat.o(38306);
  }
  
  protected final String bCe(String paramString)
  {
    AppMethodBeat.i(257028);
    paramString = (d)this.aebd.get(paramString);
    if ((paramString != null) && (paramString.nickName != null))
    {
      paramString = paramString.nickName.toString();
      AppMethodBeat.o(257028);
      return paramString;
    }
    AppMethodBeat.o(257028);
    return "";
  }
  
  public void detach() {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38312);
    bb localbb = (bb)getItem(paramInt);
    String str = localbb.field_username;
    this.afmR.BS(str);
    this.afmU = new a((byte)0);
    g localg;
    label155:
    label502:
    d locald;
    au localau;
    label567:
    boolean bool;
    label575:
    label598:
    label621:
    int i;
    label665:
    Object localObject;
    if (paramView == null)
    {
      localg = new g();
      if (com.tencent.mm.cd.a.mp(this.context))
      {
        paramView = View.inflate(this.context, R.i.giF, null);
        localg.TJN = ((LinearLayout)paramView.findViewById(R.h.fDC));
        localg.LwU = ((RelativeLayout)paramView.findViewById(R.h.avatar_layout));
        localg.lBC = ((ImageView)paramView.findViewById(R.h.avatar_iv));
        if ((!(this.context instanceof NewBizConversationUI)) && (!(this.context instanceof ServiceNotifyConversationUI))) {
          break label2106;
        }
        a.b.h(localg.lBC, str);
        paramViewGroup = (com.tencent.mm.pluginsdk.ui.a)localg.lBC.getDrawable();
        if (this.afmK != null) {
          this.afmK.a(paramViewGroup);
        }
        localg.aebj = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
        localg.aebj.setLayoutCallback(this.afaM);
        localg.afno = ((NoMeasuredTextView)paramView.findViewById(R.h.source_tv));
        localg.aebk = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
        localg.aebl = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
        localg.vzm = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
        localg.vzm.setBackgroundResource(v.nH(this.context));
        localg.aebm = ((ImageView)paramView.findViewById(R.h.fKm));
        localg.aebo = paramView.findViewById(R.h.fsw);
        localg.aebn = ((ImageView)paramView.findViewById(R.h.fYY));
        localg.afnp = ((ImageView)paramView.findViewById(R.h.fNi));
        paramView.setTag(localg);
        localg.aebl.setTextSize(0, this.aeaZ);
        localg.aebk.setTextSize(0, this.aeba);
        localg.aebj.setTextSize(0, this.aeaW);
        localg.afno.setTextSize(0, this.aeaZ);
        localg.aebl.setTextColor(this.aebb[0]);
        localg.aebk.setTextColor(this.aebb[4]);
        localg.aebj.setTextColor(this.aebb[3]);
        localg.afno.setTextColor(this.aebb[0]);
        localg.aebl.setShouldEllipsize(true);
        localg.aebk.setShouldEllipsize(false);
        localg.aebj.setShouldEllipsize(true);
        localg.afno.setShouldEllipsize(true);
        localg.aebk.setGravity(5);
        paramViewGroup = paramView;
        locald = (d)this.aebd.get(str);
        if (locald != null) {
          break label3155;
        }
        locald = new d((byte)0);
        localau = this.afmR.jzV();
        if (localau == null) {
          break label2133;
        }
        locald.afne = localau.hyY;
        locald.afnd = ((int)localau.maN);
        if (localau == null) {
          break label2148;
        }
        bool = true;
        locald.afnj = bool;
        if ((localau == null) || (!localau.aMW())) {
          break label2154;
        }
        bool = true;
        locald.afnl = bool;
        if ((localau == null) || (localau.kaf != 0)) {
          break label2160;
        }
        bool = true;
        locald.afnk = bool;
        locald.Aeu = au.bwE(str);
        if ((!locald.Aeu) || (!locald.afnk) || (localbb.field_unReadCount <= 0)) {
          break label2166;
        }
        bool = true;
        locald.afni = bool;
        locald.viewType = 0;
        i = aip(localbb.field_msgType);
        if ((i == 34) && (localbb.field_isSend == 0) && (!Util.isNullOrNil(localbb.field_content)))
        {
          localObject = localbb.field_content;
          if (!str.equals("qmessage"))
          {
            paramView = (View)localObject;
            if (!str.equals("floatbottle")) {}
          }
          else
          {
            String[] arrayOfString = ((String)localObject).split(":");
            paramView = (View)localObject;
            if (arrayOfString != null)
            {
              paramView = (View)localObject;
              if (arrayOfString.length > 3) {
                paramView = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
              }
            }
          }
          if (!new com.tencent.mm.modelvoice.p(paramView).paW) {
            locald.viewType = 1;
          }
        }
        if (i == 285212721)
        {
          paramView = localbb.field_content;
          long l = localbb.field_lastSeq;
          com.tencent.threadpool.h.ahAA.g(new g.4(this, paramView), "tmplPreload");
        }
        paramView = aa.a(localau, str, locald.Aeu);
        if ((!locald.Aeu) || (paramView != null)) {
          break label2172;
        }
        locald.nickName = this.context.getString(R.l.gzv);
        label920:
        locald.afna = q(localbb);
        locald.afnb = a(localbb, (int)localg.aebl.getTextSize(), locald.afni);
        locald.afnm = localbb.field_attrflag;
        switch (localbb.field_status)
        {
        case 3: 
        case 4: 
        default: 
          i = -1;
          label1011:
          locald.afnc = i;
          locald.afnf = ab.a(localbb);
          bh.bCz();
          locald.aebg = com.tencent.mm.model.c.bzG().k(localbb);
          if ((localau != null) && (localau.aGe()))
          {
            bool = true;
            label1063:
            locald.afng = bool;
            locald.afnh = LocaleUtil.isChineseAppLang();
            this.aebd.put(str, locald);
          }
          break;
        }
      }
    }
    label1214:
    label2502:
    label3155:
    for (;;)
    {
      if (au.bwQ(localbb.field_username))
      {
        this.afmR.BS(localbb.field_username);
        localau = this.afmR.jzV();
        paramView = "";
        if (localau != null) {
          paramView = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).cc(localau.field_openImAppid, localau.field_descWordingId);
        }
        if (!Util.isNullOrNil(paramView))
        {
          localObject = paramView;
          if (localau != null)
          {
            localObject = paramView;
            if ("3552365301".equals(localau.field_openImAppid)) {
              localObject = "@".concat(String.valueOf(paramView));
            }
          }
          localg.aebj.bc((String)localObject, R.e.fkJ, 14);
          if (locald.afna == null) {
            locald.afna = q(localbb);
          }
          if ((!locald.afni) && (!au.bwp(localbb.field_parentRef))) {
            break label2269;
          }
          localg.aebl.setTextColor(this.aebb[0]);
          com.tencent.mm.booter.notification.a.h.qr(localg.aebl.getWidth());
          com.tencent.mm.booter.notification.a.h.qs((int)localg.aebl.getTextSize());
          com.tencent.mm.booter.notification.a.h.c(localg.aebl.getPaint());
          if (!str.toLowerCase().endsWith("@t.qq.com")) {
            break label2408;
          }
          localg.aebj.setCompoundRightDrawablesWithIntrinsicBounds(R.g.icon_tencent_weibo);
          localg.aebj.setDrawRightDrawable(true);
          i = locald.afnc;
          if (i == -1) {
            break label2459;
          }
          localg.aebl.setCompoundLeftDrawablesWithIntrinsicBounds(i);
          localg.aebl.setDrawLeftDrawable(true);
          label1366:
          localg.afno.setVisibility(8);
          paramView = localg.aebk.getLayoutParams();
          if (locald.afna.length() < 9) {
            break label2471;
          }
          if (paramView.width != this.afmT)
          {
            paramView.width = this.afmT;
            localg.aebk.setLayoutParams(paramView);
          }
          Log.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(paramView.width) });
          localg.aebk.setText(locald.afna);
          localg.aebl.setText(locald.afnb);
          if ((!locald.Aeu) || (!locald.afnk)) {
            break label2502;
          }
          localg.aebm.setVisibility(0);
          label1502:
          if ((!(this.context instanceof NewBizConversationUI)) && (!(this.context instanceof ServiceNotifyConversationUI))) {
            break label2535;
          }
          a.b.h(localg.lBC, str);
          label1532:
          if (this.afmI)
          {
            if ((localbb != null) && (localg != null) && (locald != null)) {
              break label2548;
            }
            Log.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
          }
          if ((!locald.afnf) && (locald.aebg) && (bh.baz()))
          {
            bh.bCz();
            com.tencent.mm.model.c.bzG().j(localbb);
          }
          if ((!(this.context instanceof NewBizConversationUI)) || (!locald.aebg) || (localbb.field_conversationTime == -1L)) {
            break label2973;
          }
          paramView = this.context.getResources().getDrawable(R.g.biz_timeline_star_icon);
          i = (int)localg.aebj.getTextSize();
          paramView.setBounds(0, 0, i, i);
          paramView = new com.tencent.mm.ui.widget.a(paramView, 1);
          localObject = new SpannableString("@");
          ((SpannableString)localObject).setSpan(paramView, 0, 1, 33);
          localg.aebj.setText(TextUtils.concat(new CharSequence[] { locald.nickName, " ", localObject }));
          paramViewGroup.findViewById(R.h.fDC).setBackgroundResource(R.g.comm_list_item_selector);
          localg.aebj.setContentDescription(locald.nickName.toString() + this.context.getString(R.l.biz_timeline_star));
          paramViewGroup.setTag(R.h.fuE, Boolean.TRUE);
          if (com.tencent.mm.br.c.iPe()) {
            break label3111;
          }
          paramView = new aaq();
          paramView.ieg.iei = true;
          paramView.publish();
          if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localbb, 7, 0L)) && (!localbb.field_username.equals(paramView.ieh.iek)))
          {
            localbb.gS(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localbb, 6, localbb.field_conversationTime));
            bh.bCz();
            com.tencent.mm.model.c.bzG().c(localbb, localbb.field_username);
          }
          if ((com.tencent.mm.bc.g.oXL != null) && (com.tencent.mm.bc.g.oXL.Pv(localbb.field_username))) {
            break label3056;
          }
          localg.aebn.setVisibility(8);
          if ((com.tencent.mm.bd.d.oXN == null) || (!com.tencent.mm.bd.d.oXN.Py(localbb.field_username))) {
            break label3124;
          }
          localg.afnp.setVisibility(0);
          if ((localg.aebj.getContentDescription() == null) || (localg.aebj.getContentDescription().toString().length() <= 0)) {
            break label3137;
          }
        }
      }
      for (this.afmU.nickName = String.valueOf(localg.aebj.getContentDescription());; this.afmU.nickName = String.valueOf(locald.nickName))
      {
        for (;;)
        {
          this.afmU.content = String.valueOf(locald.afnb);
          this.afmU.time = String.valueOf(locald.afna);
          paramView = this.afmU;
          a.a.jlv().a(paramViewGroup, paramView.nickName, paramView.afmZ, paramView.time, paramView.content);
          a(str, localg);
          a(localbb, locald.aebg, paramInt, false);
          AppMethodBeat.o(38312);
          return paramViewGroup;
          paramView = View.inflate(this.context, R.i.giE, null);
          break;
          a.b.g(localg.lBC, str);
          break label155;
          localg = (g)paramView.getTag();
          paramViewGroup = paramView;
          break label502;
          label2133:
          locald.afne = -1;
          locald.afnd = -1;
          break label567;
          label2148:
          bool = false;
          break label575;
          label2154:
          bool = false;
          break label598;
          label2160:
          bool = false;
          break label621;
          label2166:
          bool = false;
          break label665;
          label2172:
          locald.nickName = com.tencent.mm.pluginsdk.ui.span.p.b(this.context, aa.a(localau, str, locald.Aeu), localg.aebj.getTextSize());
          break label920;
          i = -1;
          break label1011;
          i = R.k.msg_state_sending;
          break label1011;
          i = -1;
          break label1011;
          i = R.k.msg_state_failed;
          break label1011;
          bool = false;
          break label1063;
          localg.aebj.bc(null, 0, 0);
          break label1214;
          localg.aebj.bc(null, 0, 0);
          break label1214;
          label2269:
          if ((locald.viewType == 1) && (localbb.field_isSend == 0))
          {
            paramView = this.context.getString(R.l.app_voice);
            i = locald.afnb.toString().lastIndexOf(paramView);
            if (i < 0) {}
          }
          try
          {
            localObject = new SpannableStringBuilder(locald.afnb);
            ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), i, paramView.length() + i, 33);
            locald.afnb = ((CharSequence)localObject);
            localg.aebl.setTextColor(this.aebb[0]);
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.ConversationAdapter", paramView, null, new Object[0]);
            }
          }
        }
        label2408:
        if ((au.bwF(str)) || (ab.II(str)))
        {
          localg.aebj.setCompoundRightDrawablesWithIntrinsicBounds(R.k.open_im_main_logo);
          localg.aebj.setDrawRightDrawable(true);
          break label1334;
        }
        localg.aebj.setDrawRightDrawable(false);
        break label1334;
        localg.aebl.setDrawLeftDrawable(false);
        break label1366;
        if (paramView.width == this.afmS) {
          break label1428;
        }
        paramView.width = this.afmS;
        localg.aebk.setLayoutParams(paramView);
        break label1428;
        if (locald.afng)
        {
          localg.aebm.setVisibility(0);
          break label1502;
        }
        localg.aebm.setVisibility(8);
        break label1502;
        label2535:
        a.b.g(localg.lBC, str);
        break label1532;
        label2548:
        localg.vzm.setVisibility(4);
        localg.aebo.setVisibility(4);
        if (au.bwp(localbb.field_username))
        {
          paramView = localg.aebo;
          if (localbb.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            paramView.setVisibility(i);
            localg.aebj.setTextColor(this.aebb[3]);
            break;
          }
        }
        localObject = localg.aebj;
        if ((locald.afnj) && (locald.afne == 1)) {}
        for (paramView = this.aebb[2];; paramView = this.aebb[3])
        {
          ((NoMeasuredTextView)localObject).setTextColor(paramView);
          if ((locald.afnj) && (locald.afnd != 0)) {
            break label2698;
          }
          Log.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
          break;
        }
        if (au.bwp(localbb.field_parentRef))
        {
          if (((this.context instanceof NewBizConversationUI)) || ((this.context instanceof ServiceNotifyConversationUI))) {
            break label1563;
          }
          paramView = localg.aebo;
          if (localbb.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            paramView.setVisibility(i);
            break;
          }
        }
        if ((locald.afng) && (locald.afnl))
        {
          paramView = localg.aebo;
          if (localbb.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            paramView.setVisibility(i);
            break;
          }
        }
        if ((locald.Aeu) && (locald.afnk))
        {
          paramView = localg.aebo;
          if (localbb.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            paramView.setVisibility(i);
            break;
          }
        }
        i = localbb.field_unReadCount;
        if (i > 99)
        {
          localg.vzm.setText("");
          localg.vzm.setBackgroundResource(R.k.badge_count_more);
          localg.vzm.setVisibility(0);
        }
        for (;;)
        {
          this.afmU.afmZ = i;
          break;
          if (i > 0)
          {
            localg.vzm.setText(localbb.field_unReadCount);
            localg.vzm.setBackgroundResource(v.bC(this.context, i));
            localg.vzm.setVisibility(0);
          }
        }
        localg.aebj.setText(locald.nickName);
        if ((locald.aebg) && (localbb.field_conversationTime != -1L)) {
          paramViewGroup.findViewById(R.h.fDC).setBackgroundResource(R.g.comm_item_highlight_selector);
        }
        for (;;)
        {
          localg.aebj.setContentDescription(locald.nickName.toString());
          break;
          paramViewGroup.findViewById(R.h.fDC).setBackgroundResource(R.g.comm_list_item_selector);
        }
        label3056:
        localg.aebn.setVisibility(0);
        if (localbb.field_username.equals(paramView.ieh.iek))
        {
          localg.aebn.setImageResource(R.k.talk_room_mic_speaking);
          break label1925;
        }
        localg.aebn.setImageResource(R.k.talk_room_mic_idle);
        break label1925;
        localg.aebn.setVisibility(8);
        break label1925;
        localg.afnp.setVisibility(8);
        break label1956;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38314);
    this.afmX.stopTimer();
    this.afmP = null;
    this.afmN = null;
    if (this.aebd != null)
    {
      this.aebd.clear();
      this.aebd = null;
    }
    fSd();
    jhO();
    detach();
    AppMethodBeat.o(38314);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(38317);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(38317);
      return;
    }
    onNotifyChange((String)paramObject, null);
    AppMethodBeat.o(38317);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(38318);
    Log.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.xhA), Boolean.valueOf(this.aebe), paramString });
    if ((!Util.isNullOrNil(paramString)) && (this.aebd != null)) {
      this.aebd.remove(paramString);
    }
    if (this.xhA)
    {
      Log.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.afmW), Boolean.valueOf(this.afmX.stopped()) });
      this.afmW = true;
      if (this.afmX.stopped()) {
        jzT();
      }
      AppMethodBeat.o(38318);
      return;
    }
    this.aebe = true;
    AppMethodBeat.o(38318);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38307);
    if (this.vzi != null) {
      this.vzi.fSm();
    }
    this.xhA = false;
    AppMethodBeat.o(38307);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38309);
    Log.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[] { Boolean.valueOf(this.xhA), Boolean.valueOf(this.afmL), Boolean.valueOf(this.aebe), Boolean.valueOf(this.afmM) });
    this.xhA = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.platformtools.e.a("MM/dd", (Time)localObject).toString();
    if (!this.afmQ.equals(localObject)) {}
    for (;;)
    {
      this.afmQ = ((String)localObject);
      if (i != 0) {
        fHY();
      }
      if ((this.afmL) && (this.afmP != null)) {
        this.afmL = false;
      }
      if ((this.aebe) || (this.afmM))
      {
        super.onNotifyChange(null, null);
        this.aebe = false;
        this.afmM = false;
      }
      AppMethodBeat.o(38309);
      return;
      i = 0;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.vzg = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.vzf = paramg;
  }
  
  final class a
  {
    public int afmZ;
    public String content;
    public String nickName;
    public String time;
    
    private a() {}
  }
  
  public static abstract interface b {}
  
  final class d
  {
    public boolean Aeu;
    public boolean aebg;
    public CharSequence afna;
    public CharSequence afnb;
    public int afnc;
    public int afnd;
    public int afne;
    public boolean afnf;
    public boolean afng;
    public boolean afnh;
    public boolean afni;
    public boolean afnj;
    public boolean afnk;
    public boolean afnl;
    public int afnm;
    public CharSequence nickName;
    public int viewType;
    
    private d() {}
  }
  
  final class e
  {
    private Integer afnn = null;
    private au contact = null;
    private boolean initialized = false;
    private String talker = null;
    
    public e() {}
    
    public final void BS(String paramString)
    {
      AppMethodBeat.i(256657);
      this.talker = paramString;
      this.contact = null;
      this.afnn = null;
      this.initialized = false;
      if (!Util.isNullOrNil(paramString)) {
        this.initialized = true;
      }
      AppMethodBeat.o(256657);
    }
    
    public final au jzV()
    {
      AppMethodBeat.i(256661);
      if ((this.initialized) && (this.contact == null))
      {
        bh.bCz();
        this.contact = com.tencent.mm.model.c.bzA().JE(this.talker);
      }
      au localau = this.contact;
      AppMethodBeat.o(256661);
      return localau;
    }
  }
  
  public static abstract interface f {}
  
  public static final class g
  {
    public RelativeLayout LwU;
    public LinearLayout TJN;
    public NoMeasuredTextView aebj;
    public NoMeasuredTextView aebk;
    public NoMeasuredTextView aebl;
    public ImageView aebm;
    public ImageView aebn;
    public View aebo;
    public NoMeasuredTextView afno;
    public ImageView afnp;
    public ImageView lBC;
    public TextView vzm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.f.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class h
  extends f<String, ak>
  implements m.b
{
  protected List<String> dru = null;
  private boolean fiq = false;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  boolean lGE = false;
  boolean oPd = false;
  private boolean vPP = true;
  com.tencent.mm.pluginsdk.ui.d vPR;
  private boolean vPU = false;
  com.tencent.mm.sdk.b.c vPX = null;
  public String vPZ = "";
  private final int vQb;
  private final int vQc;
  private boolean vSe = false;
  private ru vSf = null;
  h.b vSg = null;
  private HashSet<String> vSh;
  private boolean vSi = false;
  HashMap<String, Integer> vSj = new HashMap();
  private HashMap<String, Integer> vSk = new HashMap();
  boolean vSl = false;
  HashSet<String> vSm;
  boolean vSn = false;
  private boolean vSo = false;
  private NoMeasuredTextView.c vSp = new NoMeasuredTextView.c()
  {
    public final CharSequence a(NoMeasuredTextView paramAnonymousNoMeasuredTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      float f = paramAnonymousNoMeasuredTextView.getPaint().measureText(" " + paramAnonymousString);
      paramAnonymousNoMeasuredTextView = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousNoMeasuredTextView.getPaint(), paramAnonymousNoMeasuredTextView.getMeasuredWidth() - paramAnonymousNoMeasuredTextView.getCompoundPaddingRight() - paramAnonymousNoMeasuredTextView.getCompoundPaddingLeft() - f, TextUtils.TruncateAt.END);
      paramAnonymousInt2 = com.tencent.mm.cb.a.fromDPToPix(h.a(h.this), paramAnonymousInt2);
      paramAnonymousCharSequence = com.tencent.mm.pluginsdk.ui.d.j.b(h.b(h.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
      ColorStateList localColorStateList = com.tencent.mm.cb.a.h(h.c(h.this), paramAnonymousInt1);
      paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
      return paramAnonymousCharSequence;
    }
  };
  public String vSq = "";
  final h.e vSr = new h.e(this);
  private float vSs = -1.0F;
  private h.a vSt;
  private long vSu = 0L;
  boolean vSv = false;
  private float veB = -1.0F;
  private float veC = -1.0F;
  private float veD = -1.0F;
  private ColorStateList[] veE = new ColorStateList[5];
  HashMap<String, h.d> veF;
  public boolean voH = false;
  
  public h(Context paramContext, f.a parama)
  {
    super(paramContext, (short)0);
    this.TAG = "MicroMsg.ConversationWithCacheAdapter";
    super.a(parama);
    this.veE[0] = com.tencent.mm.cb.a.h(paramContext, R.e.hint_text_color);
    this.veE[1] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_unread);
    this.veE[3] = com.tencent.mm.cb.a.h(paramContext, R.e.normal_text_color);
    this.veE[2] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_three);
    this.veE[2] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_three);
    this.veE[4] = com.tencent.mm.cb.a.h(paramContext, R.e.light_text_color);
    if (com.tencent.mm.cb.a.fh(paramContext)) {
      this.vQc = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
    }
    for (this.vQb = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);; this.vQb = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth))
    {
      this.veF = new HashMap();
      this.vSh = new HashSet();
      this.vSm = new HashSet();
      this.veB = paramContext.getResources().getDimension(R.f.NormalTextSize);
      this.veC = paramContext.getResources().getDimension(R.f.HintTextSize);
      this.veD = paramContext.getResources().getDimension(R.f.SmallestTextSize);
      this.dru = new ArrayList();
      this.dru.add("qmessage");
      return;
      this.vQc = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
    }
  }
  
  static int a(ak paramak, h.d paramd)
  {
    int j = 0;
    int i;
    if ((paramak == null) || (paramak.field_unReadCount <= 0))
    {
      i = j;
      if (paramak != null) {
        if (!paramak.gV(8388608))
        {
          i = j;
          if (!paramak.gV(2097152)) {}
        }
        else
        {
          i = j;
          if (paramak != null)
          {
            i = j;
            if (paramak.field_unReadMuteCount > 0) {
              i = 1;
            }
          }
        }
      }
    }
    do
    {
      return i;
      if (!com.tencent.mm.model.s.hK(paramak.field_username)) {
        break label98;
      }
      if ((!com.tencent.mm.storage.s.ctL()) || (paramak.gV(16))) {
        break;
      }
      i = j;
    } while (!paramak.gV(64));
    return 1;
    label98:
    if (com.tencent.mm.model.s.hP(paramak.field_username))
    {
      au.Hx();
      if (!com.tencent.mm.model.c.Dz().getBoolean(ac.a.uty, true)) {
        return 1;
      }
    }
    if (com.tencent.mm.model.s.hT(paramak.field_username))
    {
      au.Hx();
      if (!com.tencent.mm.model.c.Dz().getBoolean(ac.a.utz, true)) {
        return 1;
      }
    }
    if ((paramd.vQq) && (paramd.vQv)) {
      return 1;
    }
    if ((paramd.kay) && (paramd.vQu)) {
      return 1;
    }
    return 2;
  }
  
  private SparseArray<String> a(f.b<String, ak> paramb, SparseArray<String> paramSparseArray, HashMap<String, ak> paramHashMap)
  {
    String str = (String)paramb.object;
    int j = paramSparseArray.size();
    ak localak = (ak)paramb.uIu;
    int k = paramSparseArray.size();
    int i = 0;
    if (i < k) {
      if (((String)paramSparseArray.get(i)).equals(str))
      {
        label57:
        y.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", new Object[] { str, Integer.valueOf(j), Integer.valueOf(i) });
        switch (paramb.uIt)
        {
        case 3: 
        case 4: 
        default: 
          label124:
          if (i < 0) {
            y.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
          }
          break;
        }
      }
    }
    label278:
    long l1;
    long l2;
    do
    {
      do
      {
        do
        {
          return paramSparseArray;
          i += 1;
          break;
          i = -1;
          break label57;
        } while (i < 0);
        while (i < j - 1)
        {
          paramSparseArray.put(i, paramSparseArray.get(i + 1));
          i += 1;
        }
        paramSparseArray.remove(j - 1);
        return paramSparseArray;
        if (localak != null) {
          break label278;
        }
        y.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
      } while (i < 0);
      y.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", new Object[] { str });
      while (i < j - 1)
      {
        paramSparseArray.put(i, paramSparseArray.get(i + 1));
        i += 1;
      }
      paramSparseArray.remove(j - 1);
      return paramSparseArray;
      if (i >= 0) {
        break label124;
      }
      i = 0;
      while ((i < j) && (c((String)paramSparseArray.get(i), paramHashMap).field_flag > localak.field_flag)) {
        i += 1;
      }
      while (j > i)
      {
        paramSparseArray.put(j, paramSparseArray.get(j - 1));
        j -= 1;
      }
      paramSparseArray.put(i, str);
      return paramSparseArray;
      paramb = c(str, paramHashMap);
      if (localak == null)
      {
        y.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", new Object[] { str });
        while (i < j - 1)
        {
          paramSparseArray.put(i, paramSparseArray.get(i + 1));
          i += 1;
        }
        paramSparseArray.remove(j - 1);
        return paramSparseArray;
      }
      l1 = paramb.field_flag;
      l2 = localak.field_flag;
    } while (l1 == l2);
    int n;
    int m;
    if (l1 < l2)
    {
      j = 0;
      n = i - 1;
      m = 1;
      label481:
      k = j;
      label485:
      if (k > n) {
        break label703;
      }
      if (c((String)paramSparseArray.get(k), paramHashMap).field_flag > localak.field_flag) {
        break label640;
      }
    }
    label640:
    label703:
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(-1), Boolean.valueOf(bool), Integer.valueOf(i), str });
      if (!bool) {
        break;
      }
      if (m != 0)
      {
        while (i > k)
        {
          paramSparseArray.put(i, paramSparseArray.get(i - 1));
          i -= 1;
        }
        k = i + 1;
        n = j - 1;
        m = 0;
        j = k;
        break label481;
        k += 1;
        break label485;
      }
      k -= 1;
      for (;;)
      {
        j = k;
        if (i >= k) {
          break;
        }
        paramSparseArray.put(i, paramSparseArray.get(i + 1));
        i += 1;
      }
      j = k;
      paramSparseArray.put(j, str);
      return paramSparseArray;
    }
  }
  
  private void a(h.d paramd, ad paramad)
  {
    if ((paramd.kay) && (paramd.dtK == null))
    {
      paramd.nickName = this.context.getString(R.l.chatting_roominfo_noname);
      return;
    }
    if (ad.aaU(paramad.field_username))
    {
      com.tencent.mm.openim.a.b localb = (com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class);
      Context localContext = ae.getContext();
      String str = paramd.dtK;
      paramad = paramad.field_openImAppid;
      paramd.nickName = localb.d(localContext, str, com.tencent.mm.cb.a.aa(this.context, R.f.NormalTextSize));
      return;
    }
    paramd.nickName = com.tencent.mm.pluginsdk.ui.d.j.b(this.context, paramd.dtK, com.tencent.mm.cb.a.aa(this.context, R.f.NormalTextSize));
  }
  
  private static String adj(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 32)) {
      return ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(paramString);
    }
    return null;
  }
  
  private CharSequence b(ak paramak, int paramInt, boolean paramBoolean)
  {
    if ((!ah.bl(paramak.field_editingMsg)) && ((paramak.field_atCount <= 0) || ((paramak.field_unReadCount <= 0) && (paramak.field_unReadMuteCount <= 0))))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_last_editing_msg_prefix));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, paramak.field_editingMsg, paramInt));
      return localObject1;
    }
    if (xP(paramak.field_msgType) == 10000)
    {
      boolean bool2 = com.tencent.mm.model.s.hK(paramak.field_username);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = paramak.gV(2097152);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = paramak.gV(8388608);
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramak.gV(16777216);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = com.tencent.mm.model.s.hT(paramak.field_username);
      }
      if (!bool2) {
        return new SpannableString(com.tencent.mm.pluginsdk.ui.d.j.e(this.context, paramak.field_content, paramInt));
      }
    }
    Object localObject2;
    if (xP(paramak.field_msgType) == 49)
    {
      localObject1 = r.gV(paramak.field_digestUser);
      localObject2 = g.a.gp(paramak.field_content);
      if ((localObject2 != null) && (((g.a)localObject2).type == 40) && (k.gv(paramak.field_content).dTA == 19))
      {
        if (ah.bl((String)localObject1)) {}
        for (localObject1 = this.context.getString(R.l.app_record);; localObject1 = (String)localObject1 + ": " + this.context.getString(R.l.app_record))
        {
          paramak.dQ((String)localObject1);
          return localObject1;
        }
      }
    }
    Object localObject1 = paramak.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  "))) {
      return new SpannableString(com.tencent.mm.pluginsdk.ui.d.j.c(this.context, (CharSequence)localObject1, paramInt));
    }
    localObject1 = paramak.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      au.Hx();
      if (ah.g((Integer)com.tencent.mm.model.c.Dz().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0) {
        return this.context.getString(R.l.settings_plugins_disable);
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      au.Hx();
      localObject1 = com.tencent.mm.model.c.FE().Ic("@t.qq.com");
      if ((localObject1 != null) && (((bq)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0) {
        return this.context.getString(R.l.settings_plugins_disable);
      }
    }
    if ((paramak.field_msgType != null) && (paramak.field_msgType.equals("64"))) {
      return paramak.field_content;
    }
    Object localObject3;
    if ((paramak.field_msgType != null) && ((paramak.field_msgType.equals("47")) || (paramak.field_msgType.equals("1048625"))))
    {
      localObject1 = adj(paramak.field_digest);
      localObject2 = "";
      if (!ah.bl((String)localObject1)) {
        return "[" + (String)localObject1 + "]";
      }
      localObject1 = localObject2;
      if (paramak.field_digest != null)
      {
        localObject1 = localObject2;
        if (paramak.field_digest.contains(":"))
        {
          localObject2 = paramak.field_digest.substring(0, paramak.field_digest.indexOf(":"));
          localObject3 = adj(paramak.field_digest.substring(paramak.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = localObject2;
          if (!ah.bl((String)localObject3))
          {
            paramak = "[" + (String)localObject3 + "]";
            if (ah.bl((String)localObject2)) {
              return com.tencent.mm.pluginsdk.ui.d.j.b(this.context, (CharSequence)localObject2, paramInt);
            }
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, (CharSequence)localObject2, paramInt));
            ((SpannableStringBuilder)localObject1).append(": ");
            ((SpannableStringBuilder)localObject1).append(paramak);
            return localObject1;
          }
        }
      }
      localObject2 = this.context.getString(R.l.app_emoji);
      if (ah.bl((String)localObject1))
      {
        localObject1 = localObject2;
        paramak.dQ((String)localObject1);
      }
    }
    else
    {
      if (ah.bl(paramak.field_digest)) {
        break label1052;
      }
      if (ah.bl(paramak.field_digestUser)) {
        break label1041;
      }
      if ((paramak.field_isSend != 0) || (!com.tencent.mm.model.s.fn(paramak.field_username))) {
        break label1029;
      }
      localObject1 = r.getDisplayName(paramak.field_digestUser, paramak.field_username);
    }
    label1029:
    label1041:
    label1052:
    String str;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramak.field_digest, new Object[] { localObject1 });
        localObject1 = ((String)localObject1).replace('\n', ' ');
        if ((!paramak.gV(33554432)) || ((paramak.field_unReadCount <= 0) && (paramak.field_unReadMuteCount <= 0))) {
          break label1083;
        }
        paramak = new SpannableStringBuilder(this.context.getString(R.l.subscribe_notify_digest_prefix));
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, (CharSequence)localObject1, paramInt));
        return paramak;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + (String)localObject2;
      break;
      localObject1 = r.gV(paramak.field_digestUser);
      continue;
      localObject1 = paramak.field_digest;
      continue;
      str = com.tencent.mm.booter.notification.a.h.a(paramak.field_isSend, paramak.field_username, paramak.field_content, xP(paramak.field_msgType), this.context);
    }
    label1083:
    if (paramak.field_UnReadInvite > 0)
    {
      if (paramak.field_UnReadInvite < 4096) {}
      for (paramak = this.context.getString(R.l.main_conversation_chatroom_invite_hint, new Object[] { Integer.valueOf(paramak.field_UnReadInvite) });; paramak = this.context.getString(R.l.main_conversation_chatroom_accept_invite_hint))
      {
        paramak = new SpannableStringBuilder(paramak);
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, str, paramInt));
        return paramak;
      }
    }
    if ((paramak.field_atCount > 0) && ((paramak.field_unReadCount > 0) || (paramak.field_unReadMuteCount > 0)))
    {
      localObject2 = this.context;
      if (paramak.field_atCount < 4096) {}
      for (i = R.l.main_conversation_chatroom_at_hint;; i = R.l.main_conversation_chatroom_notice_at_hint)
      {
        paramak = new SpannableStringBuilder(((Context)localObject2).getString(i));
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, str, paramInt));
        return paramak;
      }
    }
    if ((paramak.gV(16777216)) && ((paramak.field_unReadCount > 0) || (paramak.field_unReadMuteCount > 0)))
    {
      paramak = this.context.getString(R.l.aa_digest_prefix);
      str = str.replace(paramak, "");
      paramak = new SpannableStringBuilder(paramak);
      paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
      paramak.append(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, str, paramInt));
      return paramak;
    }
    if ((paramBoolean) && ((paramak.field_unReadCount > 1) || (paramak.field_unReadMuteCount > 0))) {
      paramak = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[] { Integer.valueOf(paramak.field_unReadCount), str });
    }
    for (;;)
    {
      return com.tencent.mm.pluginsdk.ui.d.j.b(this.context, paramak, paramInt);
      if ((com.tencent.mm.storage.s.ctL()) && (com.tencent.mm.model.s.hK(paramak.field_username)))
      {
        paramBoolean = paramak.gV(16);
        if ((paramak.field_unReadCount > 1) || ((!paramBoolean) && (paramak.field_unReadCount > 0)))
        {
          if (paramBoolean)
          {
            if (paramak.gV(32))
            {
              paramak = this.context.getString(R.l.main_conversation_biz_time_line_unread_count, new Object[] { Integer.valueOf(paramak.field_unReadCount) });
              localObject2 = this.context.getResources().getDrawable(R.g.biz_timeline_star_icon);
              ((Drawable)localObject2).setBounds(0, 0, paramInt, paramInt);
              localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
              localObject3 = new SpannableString("@");
              ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
              return TextUtils.concat(new CharSequence[] { paramak, " ", localObject3, com.tencent.mm.pluginsdk.ui.d.j.b(this.context, str, paramInt) });
            }
            paramak = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[] { Integer.valueOf(paramak.field_unReadCount), str });
            continue;
          }
          paramak = this.context.getString(R.l.main_conversation_biz_time_line_unread_digest_hint, new Object[] { Integer.valueOf(paramak.field_unReadCount), str });
          continue;
        }
        if (paramak.gV(32))
        {
          paramak = this.context.getResources().getDrawable(R.g.biz_timeline_star_icon);
          paramak.setBounds(0, 0, paramInt, paramInt);
          paramak = new com.tencent.mm.ui.widget.a(paramak);
          localObject2 = new SpannableString("@");
          ((SpannableString)localObject2).setSpan(paramak, 0, 1, 33);
          return TextUtils.concat(new CharSequence[] { localObject2, com.tencent.mm.pluginsdk.ui.d.j.b(this.context, str, paramInt) });
        }
      }
      paramak = str;
    }
  }
  
  private ak c(String paramString, HashMap<String, ak> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString))) {
      return (ak)paramHashMap.get(paramString);
    }
    return (ak)bZ(paramString);
  }
  
  private void cHW()
  {
    if (this.veF == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.veF.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((h.d)((Map.Entry)localIterator.next()).getValue()).vQk = null;
      }
    }
  }
  
  private void cIg()
  {
    if ((this.veF == null) || (this.vSh == null) || (this.vSh.isEmpty())) {
      return;
    }
    y.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[] { Integer.valueOf(this.vSh.size()) });
    Iterator localIterator = this.vSh.iterator();
    int i = 0;
    int j;
    boolean bool1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        j = i;
        if (str1 == null) {
          break label342;
        }
        j = i;
        if (str1.equals("")) {
          break label342;
        }
        j = i;
        if (!this.veF.containsKey(str1)) {
          break label342;
        }
        h.d locald = (h.d)this.veF.get(str1);
        j = i;
        if (locald == null) {
          break label342;
        }
        this.vSr.ec(str1);
        bool1 = com.tencent.mm.model.s.fn(str1);
        ad localad = this.vSr.cIi();
        if (localad != null)
        {
          String str2 = r.a(localad, str1, bool1);
          y.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[] { str2, locald.dtK });
          j = i;
          if (str2 != null)
          {
            j = i;
            if (!str2.equals(locald.dtK))
            {
              locald.dtK = str2;
              a(locald, localad);
              j = 1;
            }
          }
          boolean bool2 = localad.Bj();
          if (localad.cCy == 0)
          {
            bool1 = true;
            label257:
            if ((locald.vQq == bool2) && (bool1 == locald.vQu)) {
              break label342;
            }
            locald.vQq = bool2;
            locald.vQu = bool1;
            locald.vQv = localad.xG();
            y.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", new Object[] { str1 });
          }
        }
      }
    }
    label342:
    for (i = 1;; i = j)
    {
      break;
      bool1 = false;
      break label257;
      if (i != 0) {
        notifyDataSetChanged();
      }
      this.vSh.clear();
      return;
    }
  }
  
  private CharSequence h(ak paramak)
  {
    if (paramak.field_status == 1) {
      return this.context.getString(R.l.main_sending);
    }
    if (paramak.field_conversationTime == 9223372036854775807L) {
      return "";
    }
    return com.tencent.mm.pluginsdk.f.h.c(this.context, paramak.field_conversationTime, true);
  }
  
  private static int xP(String paramString)
  {
    int j = 1;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 1;
  }
  
  public final void HR(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {}
    ak localak;
    do
    {
      return;
      localak = (ak)FC(paramInt);
    } while (localak == null);
    a.b.cmd().ch(localak.field_username);
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    int j = 0;
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    String str;
    label189:
    label195:
    label205:
    label225:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            str = (String)paramObject;
            if (!(paramm instanceof be)) {
              break label225;
            }
            y.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), str });
            i = j;
            if (str.contains("@"))
            {
              i = j;
              if (!str.endsWith("@chatroom"))
              {
                i = j;
                if (!str.endsWith("@im.chatroom"))
                {
                  i = j;
                  if (!str.endsWith("@micromsg.qq.com")) {
                    if (!ad.aaU(str)) {
                      break label189;
                    }
                  }
                }
              }
            }
            for (i = j; i == 0; i = 1)
            {
              if (this.veF == null) {
                break label205;
              }
              if (!paramObject.equals("")) {
                break label195;
              }
              if (paramInt != 5) {
                break label205;
              }
              this.vSn = true;
              super.f(null, 1);
              return;
            }
          }
          this.vSm.add(str);
          int i = paramInt;
          if (paramInt == 3) {
            i = 2;
          }
          super.f(str, i);
          return;
        } while (!(paramm instanceof bd));
        y.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", new Object[] { Integer.valueOf(paramInt), paramObject, Boolean.valueOf(this.lGE) });
      } while (this.lGE);
      this.vSl = true;
    } while ((paramInt == 5) || (paramInt == 2) || (this.veF == null) || (!this.veF.containsKey(str)) || (this.vSh == null));
    this.vSh.add(str);
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, ak>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    if ((paramArrayOfSparseArray == null) || (paramArrayOfSparseArray.length <= 0) || (!com.tencent.mm.kernel.g.DK())) {}
    for (;;)
    {
      return paramArrayOfSparseArray;
      y.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", new Object[] { Integer.valueOf(paramHashSet.size()), Integer.valueOf(paramArrayOfSparseArray[0].size()) });
      Object localObject1 = new ArrayList();
      Object localObject2 = paramHashSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (f.b)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((f.b)localObject3).uIt != 5) && (!((ArrayList)localObject1).contains(((f.b)localObject3).object)))
        {
          y.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + (String)((f.b)localObject3).object);
          ((ArrayList)localObject1).add(((f.b)localObject3).object);
        }
      }
      localObject2 = new HashMap();
      au.Hx();
      Object localObject3 = com.tencent.mm.model.c.FB().a((ArrayList)localObject1, com.tencent.mm.model.s.dUT, this.dru, com.tencent.mm.o.a.dBg);
      Object localObject4;
      while (((Cursor)localObject3).moveToNext())
      {
        localObject4 = new ak();
        ((ak)localObject4).d((Cursor)localObject3);
        ((HashMap)localObject2).put(((as)localObject4).field_username, localObject4);
      }
      ((Cursor)localObject3).close();
      localObject3 = paramHashSet.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (f.b)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          if (((f.b)localObject4).uIt != 5)
          {
            StringBuilder localStringBuilder = new StringBuilder("evnet name,").append((String)((f.b)localObject4).object).append("  event.newObj   ==");
            if (((HashMap)localObject2).get(((f.b)localObject4).object) == null) {}
            for (boolean bool = true;; bool = false)
            {
              y.d("MicroMsg.ConversationWithCacheAdapter", bool);
              ((f.b)localObject4).uIu = ((HashMap)localObject2).get(((f.b)localObject4).object);
              break;
            }
          }
          ((f.b)localObject4).uIu = null;
        }
      }
      ((ArrayList)localObject1).clear();
      ((HashMap)localObject2).clear();
      localObject1 = new HashMap();
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        localObject2 = (f.b)paramHashSet.next();
        if (localObject2 != null)
        {
          a((f.b)localObject2, paramArrayOfSparseArray[0], (HashMap)localObject1);
          if (((f.b)localObject2).uIt != 5) {
            ((HashMap)localObject1).put(((f.b)localObject2).object, ((f.b)localObject2).uIu);
          }
        }
      }
    }
  }
  
  public final boolean adY(String paramString)
  {
    return (this.veF == null) || (!this.veF.containsKey(paramString));
  }
  
  public final ArrayList<ak> ag(ArrayList<String> paramArrayList)
  {
    y.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    au.Hx();
    paramArrayList = com.tencent.mm.model.c.FB().a(paramArrayList, com.tencent.mm.model.s.dUT, this.dru, com.tencent.mm.o.a.dBg);
    while (paramArrayList.moveToNext())
    {
      ak localak = new ak();
      localak.d(paramArrayList);
      localArrayList.add(localak);
    }
    paramArrayList.close();
    return localArrayList;
  }
  
  public final void cHo()
  {
    boolean bool1 = true;
    if (this.dru == null) {
      this.dru = new ArrayList();
    }
    this.dru.clear();
    int i;
    if ((com.tencent.mm.model.q.Gn() & 0x8000) == 0)
    {
      i = 1;
      boolean bool2 = com.tencent.mm.model.q.GA();
      if ((i == 0) || (!bool2)) {
        break label126;
      }
      label53:
      if (bool1 != this.vSo)
      {
        if (!bool1) {
          break label131;
        }
        au.Hx();
        a(5, (m)com.tencent.mm.model.c.FB(), "floatbottle");
      }
    }
    for (;;)
    {
      this.vSo = bool1;
      if (this.vSo) {
        this.dru.add("floatbottle");
      }
      this.dru.add("qmessage");
      return;
      i = 0;
      break;
      label126:
      bool1 = false;
      break label53;
      label131:
      au.Hx();
      a(2, (m)com.tencent.mm.model.c.FB(), "floatbottle");
    }
  }
  
  public final void cIf()
  {
    super.f(null, 1);
  }
  
  public final void clearCache()
  {
    if (this.veF != null)
    {
      this.veF.clear();
      this.vSn = true;
    }
  }
  
  public final boolean cxa()
  {
    return super.cxa();
  }
  
  public final com.tencent.mm.cf.a.d cyc()
  {
    y.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
    au.Hx();
    return (com.tencent.mm.cf.a.d)com.tencent.mm.model.c.FB().a(com.tencent.mm.model.s.dUT, this.dru, com.tencent.mm.o.a.dBg, true);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.vSt = new h.a(this, (byte)0);
    ak localak = (ak)FC(paramInt);
    String str = localak.field_username;
    this.vSr.ec(str);
    Object localObject1;
    int i;
    Object localObject3;
    if (this.vSj.containsKey(str))
    {
      if (paramInt != ((Integer)this.vSj.get(str)).intValue())
      {
        localObject1 = cyd();
        int k;
        if (this.uIg == null)
        {
          paramViewGroup = null;
          localObject2 = new StringBuffer();
          k = localObject1.length;
          i = 0;
        }
        for (;;)
        {
          if (i >= k) {
            break label243;
          }
          localObject3 = localObject1[i];
          int j = 0;
          for (;;)
          {
            if ((j < ((SparseArray)localObject3).size()) && (j < 50))
            {
              ((StringBuffer)localObject2).append("[");
              ((StringBuffer)localObject2).append(j);
              ((StringBuffer)localObject2).append(",");
              ((StringBuffer)localObject2).append(((SparseArray)localObject3).keyAt(j));
              ((StringBuffer)localObject2).append(",");
              ((StringBuffer)localObject2).append((String)((SparseArray)localObject3).valueAt(j));
              ((StringBuffer)localObject2).append("]");
              j += 1;
              continue;
              paramViewGroup = this.uIg.uEU.cwZ();
              break;
            }
          }
          i += 1;
        }
        label243:
        ((StringBuffer)localObject2).append("\n");
        if (paramViewGroup != null)
        {
          localObject1 = paramViewGroup.entrySet().iterator();
          i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject1).next();
            if (i >= 50) {
              break;
            }
            i += 1;
            ((StringBuffer)localObject2).append("[");
            ((StringBuffer)localObject2).append(((Map.Entry)localObject3).getKey());
            ((StringBuffer)localObject2).append(",");
            if (((Map.Entry)localObject3).getValue() != null) {
              ((StringBuffer)localObject2).append(((ak)((Map.Entry)localObject3).getValue()).field_username);
            }
            ((StringBuffer)localObject2).append("]");
          }
          ((StringBuffer)localObject2).append("\n");
        }
        localObject1 = ((StringBuffer)localObject2).toString();
        localObject2 = this.vSj.toString();
        if (paramViewGroup == null) {
          break label1855;
        }
        i = paramViewGroup.size();
        y.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", new Object[] { localObject1, str, Integer.valueOf(paramInt), localObject2, Integer.valueOf(i) });
        if (!this.vSi)
        {
          e.rv(20);
          this.vSi = true;
        }
        if (System.currentTimeMillis() - this.vSu > 3600000L)
        {
          super.f(null, 1);
          this.vSu = System.currentTimeMillis();
        }
      }
      label499:
      if (paramView != null) {
        break label1934;
      }
      localObject1 = new h.f();
      if (!com.tencent.mm.cb.a.fh(this.context)) {
        break label1878;
      }
      paramView = com.tencent.mm.kiss.a.b.ED().a((Activity)this.context, "R.layout.conversation_item_with_cache_large", R.i.conversation_item_with_cache_large);
      label542:
      ((h.f)localObject1).doU = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      a.b.a(((h.f)localObject1).doU, str);
      paramViewGroup = (com.tencent.mm.pluginsdk.ui.a)((h.f)localObject1).doU.getDrawable();
      if (this.vPR != null) {
        this.vPR.a(paramViewGroup);
      }
      ((h.f)localObject1).veJ = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
      ((h.f)localObject1).veJ.setLayoutCallback(this.vSp);
      ((h.f)localObject1).veK = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
      ((h.f)localObject1).vSF = ((ImageView)paramView.findViewById(R.h.last_msg_type_iv));
      ((h.f)localObject1).veL = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
      ((h.f)localObject1).hZk = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
      ((h.f)localObject1).veM = ((ImageView)paramView.findViewById(R.h.image_mute));
      ((h.f)localObject1).veO = paramView.findViewById(R.h.avatar_prospect_iv);
      ((h.f)localObject1).veN = ((ImageView)paramView.findViewById(R.h.talkroom_iv));
      ((h.f)localObject1).vQz = ((ImageView)paramView.findViewById(R.h.location_share_iv));
      ((h.f)localObject1).vSG = ((ImageView)paramView.findViewById(R.h.multitalk_iv));
      ((h.f)localObject1).hZk.setBackgroundResource(com.tencent.mm.ui.tools.q.hh(this.context));
      ((h.f)localObject1).vSH = new h.c(this);
      paramView.setTag(localObject1);
      ((h.f)localObject1).veL.setTextSize(0, com.tencent.mm.cb.a.aa(this.context, R.f.SmallerTextSize));
      ((h.f)localObject1).veK.setTextSize(0, com.tencent.mm.cb.a.aa(this.context, R.f.SmallestTextSize));
      ((h.f)localObject1).veJ.setTextSize(0, com.tencent.mm.cb.a.aa(this.context, R.f.NormalTextSize));
      this.vSs = ((h.f)localObject1).veJ.getTextSize();
      ((h.f)localObject1).veL.setTextColor(this.veE[0]);
      ((h.f)localObject1).veK.setTextColor(this.veE[4]);
      ((h.f)localObject1).veJ.setTextColor(this.veE[3]);
      ((h.f)localObject1).veL.setShouldEllipsize(true);
      ((h.f)localObject1).veK.setShouldEllipsize(false);
      ((h.f)localObject1).veJ.setShouldEllipsize(true);
      ((h.f)localObject1).veK.setGravity(5);
      paramViewGroup = paramView;
      label939:
      localObject3 = i(localak);
      if (((h.d)localObject3).vQl == null) {
        ((h.d)localObject3).vQl = b(localak, (int)((h.f)localObject1).veL.getTextSize(), ((h.d)localObject3).vQs);
      }
      if (((h.d)localObject3).vQk == null) {
        ((h.d)localObject3).vQk = h(localak);
      }
      if (!((h.d)localObject3).vQs) {
        break label1948;
      }
      ((h.f)localObject1).veL.setTextColor(this.veE[0]);
      label1021:
      com.tencent.mm.booter.notification.a.h.gc(((h.f)localObject1).veL.getWidth());
      com.tencent.mm.booter.notification.a.h.gd((int)((h.f)localObject1).veL.getTextSize());
      com.tencent.mm.booter.notification.a.h.a(((h.f)localObject1).veL.getPaint());
      if (!str.toLowerCase().endsWith("@t.qq.com")) {
        break label1969;
      }
      ((h.f)localObject1).veJ.setCompoundRightDrawablesWithIntrinsicBounds(R.g.icon_tencent_weibo);
      ((h.f)localObject1).veJ.setDrawRightDrawable(true);
      label1089:
      paramInt = ((h.d)localObject3).vQm;
      if (paramInt == -1) {
        break label2012;
      }
      ((h.f)localObject1).veL.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
      ((h.f)localObject1).veL.setDrawLeftDrawable(true);
      y.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[] { str, Integer.valueOf(((h.d)localObject3).vQm) });
      label1146:
      if (!ad.aaU(localak.field_username)) {
        break label2046;
      }
      this.vSr.ec(localak.field_username);
      ad localad = this.vSr.cIi();
      paramView = "";
      if (localad != null) {
        paramView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).aK(localad.field_openImAppid, localad.field_descWordingId);
      }
      if (ah.bl(paramView)) {
        break label2032;
      }
      Object localObject2 = paramView;
      if ("3552365301".equals(localad.field_openImAppid)) {
        localObject2 = "@" + paramView;
      }
      ((h.f)localObject1).veJ.ao((String)localObject2, R.e.lable_text_color, 14);
      label1269:
      ((h.f)localObject1).veJ.setText(((h.d)localObject3).nickName);
      paramView = ((h.f)localObject1).veK.getLayoutParams();
      if (((h.d)localObject3).vQk.length() < 9) {
        break label2069;
      }
      if (paramView.width != this.vQc)
      {
        paramView.width = this.vQc;
        ((h.f)localObject1).veK.setLayoutParams(paramView);
      }
      label1334:
      ((h.f)localObject1).veK.setText(((h.d)localObject3).vQk);
      ((h.f)localObject1).veL.setText(((h.d)localObject3).vQl);
      ((h.f)localObject1).vSF.setVisibility(8);
      ((h.f)localObject1).veM.setVisibility(8);
      if (!((h.d)localObject3).kay) {
        break label2100;
      }
      if (((h.d)localObject3).vQu) {
        ((h.f)localObject1).veM.setVisibility(0);
      }
      label1405:
      a.b.a(((h.f)localObject1).doU, str);
      if (this.vPP)
      {
        if ((localak != null) && (localObject1 != null) && (localObject3 != null)) {
          break label2120;
        }
        y.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
      }
      label1445:
      if ((!((h.d)localObject3).vQp) && (((h.d)localObject3).veG) && (au.DK()))
      {
        au.Hx();
        com.tencent.mm.model.c.FB().f(localak);
      }
      if ((!((h.d)localObject3).veG) || (localak.field_conversationTime == -1L)) {
        break label2352;
      }
      paramViewGroup.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
      label1515:
      if (Build.VERSION.SDK_INT >= 21) {
        paramViewGroup.findViewById(R.h.conversation_item_ll).setOnTouchListener(new h.3(this));
      }
      com.tencent.mm.br.d.coz();
      if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 7, 0L)) && (!localak.field_username.equals(this.vSf.cbr.cbu)))
      {
        localak.bb(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 6, localak.field_conversationTime));
        au.Hx();
        com.tencent.mm.model.c.FB().a(localak, localak.field_username);
      }
      if ((com.tencent.mm.bf.g.eEV != null) && (com.tencent.mm.bf.g.eEV.nx(localak.field_username))) {
        break label2368;
      }
      ((h.f)localObject1).veN.setVisibility(8);
      label1648:
      if ((com.tencent.mm.bg.d.eEX == null) || (!com.tencent.mm.bg.d.eEX.nA(localak.field_username))) {
        break label2426;
      }
      ((h.f)localObject1).vQz.setVisibility(0);
      label1679:
      if ((!com.tencent.mm.model.s.fn(localak.field_username)) || (com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class) == null) || (!((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).Iv(localak.field_username))) {
        break label2453;
      }
      if ((!((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).bkC()) || (!((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).dU(localak.field_username, com.tencent.mm.model.q.Gj()))) {
        break label2439;
      }
      ((h.f)localObject1).vSG.setImageResource(R.k.chatlist_multitalk_highlight_icon);
      label1774:
      ((h.f)localObject1).vSG.setVisibility(0);
    }
    for (;;)
    {
      this.vSt.content = String.valueOf(((h.d)localObject3).vQl);
      this.vSt.aVr = ((h.d)localObject3).dtK;
      this.vSt.vQj = String.valueOf(((h.d)localObject3).vQk);
      paramView = this.vSt;
      a.a.cAj().a(paramViewGroup, paramView.aVr, paramView.vQi, paramView.vQj, paramView.content);
      return paramViewGroup;
      label1855:
      i = 0;
      break;
      this.vSj.put(str, Integer.valueOf(paramInt));
      break label499;
      label1878:
      if (com.tencent.mm.cb.a.fi(this.context))
      {
        paramView = com.tencent.mm.kiss.a.b.ED().a((Activity)this.context, "R.layout.conversation_item_with_cache_small", R.i.conversation_item_with_cache_small);
        break label542;
      }
      paramView = com.tencent.mm.kiss.a.b.ED().a((Activity)this.context, "R.layout.conversation_item_with_cache", R.i.conversation_item_with_cache);
      break label542;
      label1934:
      localObject1 = (h.f)paramView.getTag();
      paramViewGroup = paramView;
      break label939;
      label1948:
      ((h.f)localObject1).veL.setTextColor(this.veE[localObject3.ivk]);
      break label1021;
      label1969:
      if (com.tencent.mm.model.s.hb(str))
      {
        ((h.f)localObject1).veJ.setCompoundRightDrawablesWithIntrinsicBounds(R.k.open_im_main_logo);
        ((h.f)localObject1).veJ.setDrawRightDrawable(true);
        break label1089;
      }
      ((h.f)localObject1).veJ.setDrawRightDrawable(false);
      break label1089;
      label2012:
      ((h.f)localObject1).veL.setDrawLeftDrawable(false);
      ((h.f)localObject1).veL.invalidate();
      break label1146;
      label2032:
      ((h.f)localObject1).veJ.ao(null, 0, 0);
      break label1269;
      label2046:
      com.tencent.mm.model.s.hb(localak.field_username);
      ((h.f)localObject1).veJ.ao(null, 0, 0);
      break label1269;
      label2069:
      if (paramView.width == this.vQb) {
        break label1334;
      }
      paramView.width = this.vQb;
      ((h.f)localObject1).veK.setLayoutParams(paramView);
      break label1334;
      label2100:
      if (!((h.d)localObject3).vQq) {
        break label1405;
      }
      ((h.f)localObject1).veM.setVisibility(0);
      break label1405;
      label2120:
      ((h.f)localObject1).hZk.setVisibility(4);
      ((h.f)localObject1).veO.setVisibility(4);
      if ((!com.tencent.mm.model.s.hg(localak.field_username)) && (((h.d)localObject3).vQt) && ((((h.d)localObject3).vQo == 1) || (((h.d)localObject3).vQo == 2) || (((h.d)localObject3).vQo == 3))) {}
      for (paramView = this.veE[2];; paramView = this.veE[3])
      {
        ((h.f)localObject1).veJ.setTextColor(paramView);
        if ((((h.d)localObject3).vQt) && (((h.d)localObject3).vQn != 0)) {
          break label2237;
        }
        y.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
        break;
      }
      label2237:
      paramInt = a(localak, (h.d)localObject3);
      if (paramInt == 1)
      {
        ((h.f)localObject1).veO.setVisibility(0);
        break label1445;
      }
      if (paramInt != 2) {
        break label1445;
      }
      paramInt = localak.field_unReadCount;
      if (paramInt > 99)
      {
        ((h.f)localObject1).hZk.setText(R.l.unread_count_overt_100);
        ((h.f)localObject1).hZk.setVisibility(0);
      }
      for (;;)
      {
        this.vSt.vQi = paramInt;
        break;
        if (paramInt > 0)
        {
          ((h.f)localObject1).hZk.setText(localak.field_unReadCount);
          ((h.f)localObject1).hZk.setVisibility(0);
        }
      }
      label2352:
      paramViewGroup.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
      break label1515;
      label2368:
      ((h.f)localObject1).veN.setVisibility(0);
      if (localak.field_username.equals(this.vSf.cbr.cbu))
      {
        ((h.f)localObject1).veN.setImageResource(R.k.talk_room_mic_speaking);
        break label1648;
      }
      ((h.f)localObject1).veN.setImageResource(R.k.talk_room_mic_idle);
      break label1648;
      label2426:
      ((h.f)localObject1).vQz.setVisibility(8);
      break label1679;
      label2439:
      ((h.f)localObject1).vSG.setImageResource(R.k.chatlist_multitalk_icon);
      break label1774;
      label2453:
      ((h.f)localObject1).vSG.setVisibility(8);
    }
  }
  
  final h.d i(ak paramak)
  {
    boolean bool2 = true;
    String str2 = paramak.field_username;
    Object localObject;
    if (this.veF != null)
    {
      localObject = (h.d)this.veF.get(str2);
      if (localObject != null) {
        return localObject;
      }
    }
    h.d locald = new h.d(this, (byte)0);
    this.vSr.ec(str2);
    ad localad = this.vSr.cIi();
    label100:
    label121:
    int i;
    if (localad != null)
    {
      locald.vQo = localad.cCI;
      locald.vQn = ((int)localad.dBe);
      if (localad == null) {
        break label582;
      }
      bool1 = true;
      locald.vQt = bool1;
      if ((localad == null) || (!localad.xG())) {
        break label587;
      }
      bool1 = true;
      locald.vQv = bool1;
      if ((localad == null) || (localad.cCy != 0)) {
        break label592;
      }
      bool1 = true;
      label142:
      locald.vQu = bool1;
      locald.kay = com.tencent.mm.model.s.gZ(str2);
      if ((!locald.kay) || (!locald.vQu) || (paramak.field_unReadCount <= 0)) {
        break label597;
      }
      bool1 = true;
      label183:
      locald.vQs = bool1;
      locald.ivk = 0;
      if ((xP(paramak.field_msgType) == 34) && (paramak.field_isSend == 0) && (!ah.bl(paramak.field_content)))
      {
        String str1 = paramak.field_content;
        if ((!str2.equals("qmessage")) && (!str2.equals("floatbottle")) && (!str2.equals("officialaccounts")) && (!paramak.gV(2097152)))
        {
          localObject = str1;
          if (!paramak.gV(8388608)) {}
        }
        else
        {
          String[] arrayOfString = str1.split(":");
          localObject = str1;
          if (arrayOfString != null)
          {
            localObject = str1;
            if (arrayOfString.length > 3) {
              localObject = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
            }
          }
        }
        if (!new n((String)localObject).eHB) {
          locald.ivk = 1;
        }
      }
      if ((!com.tencent.mm.storage.s.ctL()) || (!com.tencent.mm.model.s.hK(str2))) {
        break label602;
      }
      locald.dtK = this.context.getResources().getString(R.l.biz_time_line_title);
      label414:
      a(locald, localad);
      locald.vQk = h(paramak);
      switch (paramak.field_status)
      {
      case 3: 
      case 4: 
      case 6: 
      case 7: 
      default: 
        i = -1;
        label490:
        locald.vQm = i;
        locald.vQp = com.tencent.mm.model.s.a(paramak);
        au.Hx();
        locald.veG = com.tencent.mm.model.c.FB().g(paramak);
        if ((localad == null) || (!localad.Bj())) {
          break;
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locald.vQq = bool1;
      if (this.veF != null) {
        this.veF.put(str2, locald);
      }
      return locald;
      locald.vQo = -1;
      locald.vQn = -1;
      break;
      label582:
      bool1 = false;
      break label100;
      label587:
      bool1 = false;
      break label121;
      label592:
      bool1 = false;
      break label142;
      label597:
      bool1 = false;
      break label183;
      label602:
      locald.dtK = r.a(localad, str2, locald.kay);
      break label414;
      i = -1;
      break label490;
      i = R.k.msg_state_sending;
      break label490;
      i = -1;
      break label490;
      i = R.k.msg_state_failed;
      break label490;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    if (!this.vSv)
    {
      super.notifyDataSetChanged();
      this.vSj.clear();
    }
    y.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
  }
  
  public final void onPause()
  {
    y.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.voH);
    if (!this.voH) {}
    do
    {
      return;
      this.voH = false;
      super.pause();
    } while (this.hZg == null);
    this.hZg.bdb();
  }
  
  public final void onResume()
  {
    y.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.voH);
    if (this.voH) {
      return;
    }
    this.voH = true;
    cHo();
    cIg();
    y.i(this.TAG, "newcursor resume syncNow ");
    this.uIf = true;
    mJ(true);
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.f.g.a("MM/dd", (Time)localObject).toString();
    String str = x.cqJ();
    if ((!this.vPZ.equals(localObject)) || (!this.vSq.equals(str))) {}
    for (int i = 1;; i = 0)
    {
      this.vPZ = ((String)localObject);
      this.vSq = str;
      if (i != 0) {
        cHW();
      }
      if ((this.vPU) && (this.vSg != null))
      {
        this.vSg.cIh();
        this.vPU = false;
        super.f(null, 1);
      }
      this.vSf = new ru();
      this.vSf.cbq.cbs = true;
      com.tencent.mm.sdk.b.a.udP.m(this.vSf);
      return;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.hZe = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.hZd = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h
 * JD-Core Version:    0.7.0.1
 */
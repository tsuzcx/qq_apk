package com.tencent.mm.ui.conversation;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.o;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aj;
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
  implements n.b
{
  private boolean AhA;
  com.tencent.mm.pluginsdk.ui.d AhC;
  private boolean AhE;
  com.tencent.mm.sdk.b.c AhH;
  public String AhJ;
  private final int AhL;
  private final int AhM;
  private boolean AjQ;
  private tl AjR;
  h.b AjS;
  private HashSet<String> AjT;
  private boolean AjU;
  HashMap<String, Integer> AjV;
  private HashMap<String, Integer> AjW;
  boolean AjX;
  HashSet<String> AjY;
  boolean AjZ;
  private boolean Aka;
  private NoMeasuredTextView.c Akb;
  public String Akc;
  private String Akd;
  private Drawable Ake;
  ValueAnimator Akf;
  final e Akg;
  private float Akh;
  private a Aki;
  private long Akj;
  private boolean Akk;
  boolean Akl;
  protected List<String> ejc;
  private boolean gzX;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.d jSe;
  private ListView mListView;
  boolean odR;
  boolean rGP;
  public boolean zEj;
  k.a zfd;
  private float zta;
  private float ztb;
  private float ztc;
  private ColorStateList[] ztd;
  HashMap<String, d> zte;
  
  public h(Context paramContext, ListView paramListView, f.a parama)
  {
    super(paramContext, (short)0);
    AppMethodBeat.i(34365);
    this.ejc = null;
    this.ztd = new ColorStateList[5];
    this.AhA = true;
    this.AjQ = false;
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    this.AjR = null;
    this.gzX = false;
    this.zta = -1.0F;
    this.ztb = -1.0F;
    this.ztc = -1.0F;
    this.AhE = false;
    this.AhH = null;
    this.AjS = null;
    this.zEj = false;
    this.AjU = false;
    this.AjV = new HashMap();
    this.AjW = new HashMap();
    this.AjX = false;
    this.AjZ = false;
    this.Aka = false;
    this.Akb = new h.1(this);
    this.AhJ = "";
    this.Akc = "";
    this.zfd = new h.7(this);
    this.Akg = new e();
    this.rGP = false;
    this.Akh = -1.0F;
    this.Akj = 0L;
    this.Akk = false;
    this.odR = false;
    this.Akl = false;
    this.mListView = paramListView;
    this.TAG = "MicroMsg.ConversationWithCacheAdapter";
    super.a(parama);
    this.ztd[0] = com.tencent.mm.cb.a.l(paramContext, 2131690168);
    this.ztd[1] = com.tencent.mm.cb.a.l(paramContext, 2131690773);
    this.ztd[3] = com.tencent.mm.cb.a.l(paramContext, 2131690322);
    this.ztd[2] = com.tencent.mm.cb.a.l(paramContext, 2131690770);
    this.ztd[2] = com.tencent.mm.cb.a.l(paramContext, 2131690770);
    this.ztd[4] = com.tencent.mm.cb.a.l(paramContext, 2131690210);
    if (com.tencent.mm.cb.a.gu(paramContext))
    {
      this.AhM = paramContext.getResources().getDimensionPixelSize(2131427553);
      this.AhL = paramContext.getResources().getDimensionPixelSize(2131427554);
    }
    for (;;)
    {
      this.zte = new HashMap();
      this.AjT = new HashSet();
      this.AjY = new HashSet();
      this.zta = paramContext.getResources().getDimension(2131427809);
      this.ztb = paramContext.getResources().getDimension(2131427758);
      this.ztc = paramContext.getResources().getDimension(2131427862);
      this.ejc = new ArrayList();
      this.ejc.add("qmessage");
      AppMethodBeat.o(34365);
      return;
      if (com.tencent.mm.cb.a.gt(paramContext))
      {
        this.AhM = paramContext.getResources().getDimensionPixelSize(2131427552);
        this.AhL = paramContext.getResources().getDimensionPixelSize(2131427554);
      }
      else
      {
        this.AhM = paramContext.getResources().getDimensionPixelSize(2131427551);
        this.AhL = paramContext.getResources().getDimensionPixelSize(2131427555);
      }
    }
  }
  
  private static int GH(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(34378);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(34378);
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
  
  private static int QA(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    default: 
      return -1;
    case 1: 
    case 8: 
      return 2131231716;
    }
    return 2131231715;
  }
  
  static int a(ak paramak, d paramd)
  {
    AppMethodBeat.i(34377);
    if ((paramak == null) || (paramak.field_unReadCount <= 0))
    {
      if ((paramak != null) && ((paramak.ji(8388608)) || (paramak.ji(2097152))) && (paramak != null) && (paramak.field_unReadMuteCount > 0))
      {
        AppMethodBeat.o(34377);
        return 1;
      }
      AppMethodBeat.o(34377);
      return 0;
    }
    if (com.tencent.mm.model.t.ot(paramak.field_username))
    {
      if ((com.tencent.mm.storage.s.aWl()) && (!paramak.ji(16)) && (!paramak.ji(64)))
      {
        AppMethodBeat.o(34377);
        return 0;
      }
      AppMethodBeat.o(34377);
      return 1;
    }
    if (com.tencent.mm.model.t.oy(paramak.field_username))
    {
      aw.aaz();
      if (!com.tencent.mm.model.c.Ru().getBoolean(ac.a.yDB, true))
      {
        AppMethodBeat.o(34377);
        return 1;
      }
    }
    if (com.tencent.mm.model.t.oC(paramak.field_username))
    {
      aw.aaz();
      if (!com.tencent.mm.model.c.Ru().getBoolean(ac.a.yDC, true))
      {
        AppMethodBeat.o(34377);
        return 1;
      }
    }
    if ((paramd.Aia) && (paramd.Aif))
    {
      AppMethodBeat.o(34377);
      return 1;
    }
    if ((paramd.muU) && (paramd.Aie))
    {
      AppMethodBeat.o(34377);
      return 1;
    }
    AppMethodBeat.o(34377);
    return 2;
  }
  
  private SparseArray<String> a(f.b<String, ak> paramb, SparseArray<String> paramSparseArray, HashMap<String, ak> paramHashMap)
  {
    AppMethodBeat.i(34387);
    String str = (String)paramb.object;
    int k = paramSparseArray.size();
    ak localak = (ak)paramb.yVN;
    int j = paramSparseArray.size();
    int i = 0;
    label39:
    if (i < j) {
      if (!((String)paramSparseArray.get(i)).equals(str)) {}
    }
    for (;;)
    {
      ab.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i) });
      switch (paramb.yVM)
      {
      case 3: 
      case 4: 
      default: 
        if (i >= 0) {
          break label411;
        }
        ab.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
        AppMethodBeat.o(34387);
        return paramSparseArray;
        i += 1;
        break label39;
        i = -1;
      }
    }
    j = i;
    if (i < 0)
    {
      AppMethodBeat.o(34387);
      return paramSparseArray;
    }
    while (j < k - 1)
    {
      paramSparseArray.put(j, paramSparseArray.get(j + 1));
      j += 1;
    }
    paramSparseArray.remove(k - 1);
    for (;;)
    {
      AppMethodBeat.o(34387);
      return paramSparseArray;
      if (localak == null)
      {
        ab.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
        if (i >= 0)
        {
          ab.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", new Object[] { str });
          while (i < k - 1)
          {
            paramSparseArray.put(i, paramSparseArray.get(i + 1));
            i += 1;
          }
          paramSparseArray.remove(k - 1);
        }
        AppMethodBeat.o(34387);
        return paramSparseArray;
      }
      if (i >= 0) {
        break;
      }
      i = 0;
      while ((i < k) && (d((String)paramSparseArray.get(i), paramHashMap).field_flag > localak.field_flag)) {
        i += 1;
      }
      j = k;
      while (j > i)
      {
        paramSparseArray.put(j, paramSparseArray.get(j - 1));
        j -= 1;
      }
      paramSparseArray.put(i, str);
    }
    label411:
    paramb = d(str, paramHashMap);
    if (localak == null)
    {
      ab.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", new Object[] { str });
      while (i < k - 1)
      {
        paramSparseArray.put(i, paramSparseArray.get(i + 1));
        i += 1;
      }
      paramSparseArray.remove(k - 1);
      AppMethodBeat.o(34387);
      return paramSparseArray;
    }
    long l1 = paramb.field_flag;
    long l2 = localak.field_flag;
    if (l1 == l2)
    {
      AppMethodBeat.o(34387);
      return paramSparseArray;
    }
    int n;
    int m;
    if (l1 < l2)
    {
      j = 0;
      n = i - 1;
      m = 1;
      label538:
      k = j;
      label542:
      if (k > n) {
        break label765;
      }
      if (d((String)paramSparseArray.get(k), paramHashMap).field_flag > localak.field_flag) {
        break label666;
      }
    }
    label666:
    label765:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(-1), Boolean.valueOf(bool), Integer.valueOf(i), str });
      if (!bool)
      {
        AppMethodBeat.o(34387);
        return paramSparseArray;
        j = i + 1;
        n = k - 1;
        m = 0;
        break label538;
        k += 1;
        break label542;
      }
      if (m != 0) {
        while (i > k)
        {
          paramSparseArray.put(i, paramSparseArray.get(i - 1));
          i -= 1;
        }
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
      break;
    }
  }
  
  private void a(d paramd, ad paramad)
  {
    AppMethodBeat.i(34376);
    if ((paramd.muU) && (paramd.elx == null))
    {
      paramd.nickName = this.context.getString(2131298302);
      AppMethodBeat.o(34376);
      return;
    }
    if (ad.arf(paramad.field_username))
    {
      paramd.nickName = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).e(com.tencent.mm.sdk.platformtools.ah.getContext(), paramd.elx, com.tencent.mm.cb.a.ao(this.context, 2131427809));
      AppMethodBeat.o(34376);
      return;
    }
    paramd.nickName = j.b(this.context, paramd.elx, com.tencent.mm.cb.a.ao(this.context, 2131427809));
    AppMethodBeat.o(34376);
  }
  
  private static String atE(String paramString)
  {
    AppMethodBeat.i(34382);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(paramString);
      AppMethodBeat.o(34382);
      return paramString;
    }
    AppMethodBeat.o(34382);
    return null;
  }
  
  private CharSequence b(ak paramak, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34380);
    if ((!com.tencent.mm.platformtools.ah.isNullOrNil(paramak.field_editingMsg)) && ((paramak.field_atCount <= 0) || ((paramak.field_unReadCount <= 0) && (paramak.field_unReadMuteCount <= 0))))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131301401));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(j.b(this.context, paramak.field_editingMsg, paramInt));
      AppMethodBeat.o(34380);
      return localObject1;
    }
    if (GH(paramak.field_msgType) == 10000)
    {
      boolean bool2 = com.tencent.mm.model.t.ot(paramak.field_username);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = paramak.ji(2097152);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = paramak.ji(8388608);
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramak.ji(16777216);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = com.tencent.mm.model.t.oC(paramak.field_username);
      }
      if (!bool2)
      {
        paramak = new SpannableString(j.f(this.context, paramak.field_content, paramInt));
        AppMethodBeat.o(34380);
        return paramak;
      }
    }
    Object localObject2;
    Object localObject3;
    if (GH(paramak.field_msgType) == 49)
    {
      localObject1 = com.tencent.mm.model.s.nE(paramak.field_digestUser);
      localObject2 = j.b.mY(paramak.field_content);
      if ((localObject2 != null) && (((j.b)localObject2).type == 40))
      {
        if (o.nd(paramak.field_content).fjG == 19)
        {
          if (com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject1)) {}
          for (localObject1 = this.context.getString(2131297055);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131297055))
          {
            paramak.jW((String)localObject1);
            paramak = j.b(this.context, (CharSequence)localObject1, paramInt);
            AppMethodBeat.o(34380);
            return paramak;
          }
        }
      }
      else
      {
        if ((localObject2 != null) && (((j.b)localObject2).type == 5))
        {
          localObject1 = null;
          try
          {
            paramak = String.format(paramak.field_digest, new Object[] { j(paramak) });
            localObject3 = new StringBuilder();
            localObject1 = paramak;
            if (com.tencent.mm.platformtools.ah.isNullOrNil(paramak)) {
              localObject1 = this.context.getString(2131297097);
            }
            paramak = (String)localObject1 + " " + ((j.b)localObject2).title;
            paramak = new SpannableString(j.f(this.context, paramak, paramInt));
            AppMethodBeat.o(34380);
            return paramak;
          }
          catch (Exception paramak)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramak, "", new Object[0]);
              paramak = (ak)localObject1;
            }
          }
        }
        if ((localObject2 != null) && (((j.b)localObject2).type == 19))
        {
          if (com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject1)) {}
          for (localObject1 = this.context.getString(2131297055);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131297055))
          {
            paramak.jW((String)localObject1);
            paramak = j.b(this.context, (CharSequence)localObject1, paramInt);
            AppMethodBeat.o(34380);
            return paramak;
          }
        }
      }
    }
    Object localObject1 = paramak.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramak = new SpannableString(j.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(34380);
      return paramak;
    }
    localObject1 = paramak.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      aw.aaz();
      if (com.tencent.mm.platformtools.ah.g((Integer)com.tencent.mm.model.c.Ru().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramak = this.context.getString(2131303374);
        AppMethodBeat.o(34380);
        return paramak;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      aw.aaz();
      localObject1 = com.tencent.mm.model.c.YI().TL("@t.qq.com");
      if ((localObject1 != null) && (((bq)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramak = this.context.getString(2131303374);
        AppMethodBeat.o(34380);
        return paramak;
      }
    }
    if ((paramak.field_msgType != null) && (paramak.field_msgType.equals("64")))
    {
      paramak = paramak.field_content;
      AppMethodBeat.o(34380);
      return paramak;
    }
    if ((paramak.field_msgType != null) && ((paramak.field_msgType.equals("47")) || (paramak.field_msgType.equals("1048625"))))
    {
      localObject1 = atE(paramak.field_digest);
      localObject2 = "";
      if (!com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject1))
      {
        paramak = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(34380);
        return paramak;
      }
      localObject1 = localObject2;
      if (paramak.field_digest != null)
      {
        localObject1 = localObject2;
        if (paramak.field_digest.contains(":"))
        {
          localObject2 = paramak.field_digest.substring(0, paramak.field_digest.indexOf(":"));
          localObject3 = atE(paramak.field_digest.substring(paramak.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = localObject2;
          if (!com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject3))
          {
            paramak = "[" + (String)localObject3 + "]";
            if (com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject2))
            {
              paramak = j.b(this.context, (CharSequence)localObject2, paramInt);
              AppMethodBeat.o(34380);
              return paramak;
            }
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(j.b(this.context, (CharSequence)localObject2, paramInt));
            ((SpannableStringBuilder)localObject1).append(": ");
            ((SpannableStringBuilder)localObject1).append(paramak);
            AppMethodBeat.o(34380);
            return localObject1;
          }
        }
      }
      localObject2 = this.context.getString(2131296915);
      if (com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject1))
      {
        localObject1 = localObject2;
        paramak.jW((String)localObject1);
      }
    }
    else
    {
      if (com.tencent.mm.platformtools.ah.isNullOrNil(paramak.field_digest)) {
        break label1347;
      }
      if (com.tencent.mm.platformtools.ah.isNullOrNil(paramak.field_digestUser)) {
        break label1336;
      }
      localObject1 = j(paramak);
    }
    label1336:
    label1347:
    String str;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramak.field_digest, new Object[] { localObject1 });
        localObject1 = ((String)localObject1).replace('\n', ' ');
        if ((!paramak.ji(33554432)) || ((paramak.field_unReadCount <= 0) && (paramak.field_unReadMuteCount <= 0))) {
          break label1378;
        }
        paramak = new SpannableStringBuilder(this.context.getString(2131304203));
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(j.b(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(34380);
        return paramak;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + (String)localObject2;
      break;
      localObject1 = paramak.field_digest;
      continue;
      str = com.tencent.mm.booter.notification.a.h.a(paramak.field_isSend, paramak.field_username, paramak.field_content, GH(paramak.field_msgType), this.context);
    }
    label1378:
    if (paramak.field_UnReadInvite > 0)
    {
      if (paramak.field_UnReadInvite < 4096) {}
      for (paramak = this.context.getString(2131301398, new Object[] { Integer.valueOf(paramak.field_UnReadInvite) });; paramak = this.context.getString(2131301396))
      {
        paramak = new SpannableStringBuilder(paramak);
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(j.b(this.context, str, paramInt));
        AppMethodBeat.o(34380);
        return paramak;
      }
    }
    if ((paramak.field_atCount > 0) && ((paramak.field_unReadCount > 0) || (paramak.field_unReadMuteCount > 0)))
    {
      localObject2 = this.context;
      if (paramak.field_atCount < 4096) {}
      for (i = 2131301397;; i = 2131301399)
      {
        paramak = new SpannableStringBuilder(((Context)localObject2).getString(i));
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(j.b(this.context, str, paramInt));
        AppMethodBeat.o(34380);
        return paramak;
      }
    }
    if ((paramak.ji(16777216)) && ((paramak.field_unReadCount > 0) || (paramak.field_unReadMuteCount > 0)))
    {
      paramak = this.context.getString(2131296353);
      str = str.replace(paramak, "");
      paramak = new SpannableStringBuilder(paramak);
      paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
      paramak.append(j.b(this.context, str, paramInt));
      AppMethodBeat.o(34380);
      return paramak;
    }
    if ((paramBoolean) && ((paramak.field_unReadCount > 1) || (paramak.field_unReadMuteCount > 0))) {
      paramak = this.context.getString(2131301400, new Object[] { Integer.valueOf(paramak.field_unReadCount), str });
    }
    for (;;)
    {
      paramak = j.b(this.context, paramak, paramInt);
      AppMethodBeat.o(34380);
      return paramak;
      if ((com.tencent.mm.storage.s.aWl()) && (com.tencent.mm.model.t.ot(paramak.field_username)))
      {
        paramBoolean = paramak.ji(16);
        if ((paramak.field_unReadCount > 1) || ((!paramBoolean) && (paramak.field_unReadCount > 0)))
        {
          if (paramBoolean)
          {
            if (paramak.ji(32))
            {
              paramak = this.context.getString(2131301393, new Object[] { Integer.valueOf(paramak.field_unReadCount) });
              localObject2 = this.context.getResources().getDrawable(2130837986);
              ((Drawable)localObject2).setBounds(0, 0, paramInt, paramInt);
              localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
              localObject3 = new SpannableString("@");
              ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
              paramak = TextUtils.concat(new CharSequence[] { paramak, " ", localObject3, j.b(this.context, str, paramInt) });
              AppMethodBeat.o(34380);
              return paramak;
            }
            paramak = this.context.getString(2131301400, new Object[] { Integer.valueOf(paramak.field_unReadCount), str });
            continue;
          }
          paramak = this.context.getString(2131301394, new Object[] { Integer.valueOf(paramak.field_unReadCount), str });
          continue;
        }
        if (paramak.ji(32))
        {
          paramak = this.context.getResources().getDrawable(2130837986);
          paramak.setBounds(0, 0, paramInt, paramInt);
          paramak = new com.tencent.mm.ui.widget.a(paramak);
          localObject2 = new SpannableString("@");
          ((SpannableString)localObject2).setSpan(paramak, 0, 1, 33);
          paramak = TextUtils.concat(new CharSequence[] { localObject2, j.b(this.context, str, paramInt) });
          AppMethodBeat.o(34380);
          return paramak;
        }
      }
      paramak = str;
    }
  }
  
  private ak d(String paramString, HashMap<String, ak> paramHashMap)
  {
    AppMethodBeat.i(34386);
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramString = (ak)paramHashMap.get(paramString);
      AppMethodBeat.o(34386);
      return paramString;
    }
    paramString = (ak)cE(paramString);
    AppMethodBeat.o(34386);
    return paramString;
  }
  
  private boolean dMK()
  {
    return this.Akd != null;
  }
  
  private void dMM()
  {
    AppMethodBeat.i(34389);
    if ((this.zte == null) || (this.AjT == null) || (this.AjT.isEmpty()))
    {
      AppMethodBeat.o(34389);
      return;
    }
    ab.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[] { Integer.valueOf(this.AjT.size()) });
    Iterator localIterator = this.AjT.iterator();
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
          break label360;
        }
        j = i;
        if (str1.equals("")) {
          break label360;
        }
        j = i;
        if (!this.zte.containsKey(str1)) {
          break label360;
        }
        d locald = (d)this.zte.get(str1);
        j = i;
        if (locald == null) {
          break label360;
        }
        this.Akg.kj(str1);
        bool1 = com.tencent.mm.model.t.lA(str1);
        ad localad = this.Akg.ccM();
        if (localad != null)
        {
          String str2 = com.tencent.mm.model.s.a(localad, str1, bool1);
          ab.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[] { str2, locald.elx });
          j = i;
          if (str2 != null)
          {
            j = i;
            if (!str2.equals(locald.elx))
            {
              locald.elx = str2;
              a(locald, localad);
              j = 1;
            }
          }
          boolean bool2 = localad.DP();
          if (localad.dqK == 0)
          {
            bool1 = true;
            label269:
            if ((locald.Aia == bool2) && (bool1 == locald.Aie)) {
              break label360;
            }
            locald.Aia = bool2;
            locald.Aie = bool1;
            locald.Aif = localad.JY();
            ab.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", new Object[] { str1 });
          }
        }
      }
    }
    label360:
    for (i = 1;; i = j)
    {
      break;
      bool1 = false;
      break label269;
      if (i != 0) {
        notifyDataSetChanged();
      }
      this.AjT.clear();
      AppMethodBeat.o(34389);
      return;
    }
  }
  
  private void dMq()
  {
    AppMethodBeat.i(34369);
    if (this.zte == null)
    {
      AppMethodBeat.o(34369);
      return;
    }
    Iterator localIterator = this.zte.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).AhU = null;
    }
    AppMethodBeat.o(34369);
  }
  
  private CharSequence h(ak paramak)
  {
    AppMethodBeat.i(34366);
    if (paramak.field_status == 1)
    {
      paramak = this.context.getString(2131301428);
      AppMethodBeat.o(34366);
      return paramak;
    }
    if (paramak.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(34366);
      return "";
    }
    paramak = com.tencent.mm.pluginsdk.f.h.c(this.context, paramak.field_conversationTime, true);
    AppMethodBeat.o(34366);
    return paramak;
  }
  
  private static String j(ak paramak)
  {
    AppMethodBeat.i(34381);
    if ((paramak.field_isSend == 0) && (com.tencent.mm.model.t.lA(paramak.field_username)))
    {
      paramak = com.tencent.mm.model.s.getDisplayName(paramak.field_digestUser, paramak.field_username);
      AppMethodBeat.o(34381);
      return paramak;
    }
    paramak = com.tencent.mm.model.s.nE(paramak.field_digestUser);
    AppMethodBeat.o(34381);
    return paramak;
  }
  
  public final void QB(int paramInt)
  {
    AppMethodBeat.i(34372);
    if (!dMK())
    {
      ab.i("MicroMsg.ConversationWithCacheAdapter", "[requestDismissClickStatus] pass!");
      AppMethodBeat.o(34372);
      return;
    }
    al.p(new h.4(this), paramInt);
    AppMethodBeat.o(34372);
  }
  
  public final void QC(int paramInt)
  {
    AppMethodBeat.i(34392);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(34392);
      return;
    }
    try
    {
      ak localak = (ak)NM(paramInt);
      if (localak == null)
      {
        AppMethodBeat.o(34392);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject;
      for (;;)
      {
        ab.w("MicroMsg.ConversationWithCacheAdapter", "preLoad position:%s is null!", new Object[] { Integer.valueOf(paramInt) });
        localObject = null;
      }
      a.b.dmT().dt(localObject.field_username);
      AppMethodBeat.o(34392);
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    int j = 0;
    AppMethodBeat.i(34388);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(34388);
      return;
    }
    String str = (String)paramObject;
    if ((paramn instanceof be))
    {
      ab.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), str });
      int i = j;
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
              if (!ad.arf(str)) {
                break label175;
              }
            }
          }
        }
      }
      label175:
      for (i = j; i != 0; i = 1)
      {
        AppMethodBeat.o(34388);
        return;
      }
      if (this.zte != null) {
        if (paramObject.equals(""))
        {
          if (paramInt == 5)
          {
            this.AjZ = true;
            super.i(null, 1);
            AppMethodBeat.o(34388);
          }
        }
        else {
          this.AjY.add(str);
        }
      }
      i = paramInt;
      if (paramInt == 3) {
        i = 2;
      }
      super.i(str, i);
      AppMethodBeat.o(34388);
      return;
    }
    if ((paramn instanceof bd))
    {
      ab.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", new Object[] { Integer.valueOf(paramInt), paramObject, Boolean.valueOf(this.odR) });
      if (this.odR)
      {
        AppMethodBeat.o(34388);
        return;
      }
      this.AjX = true;
      if ((paramInt == 5) || (paramInt == 2))
      {
        AppMethodBeat.o(34388);
        return;
      }
      if ((this.zte == null) || (!this.zte.containsKey(str)))
      {
        AppMethodBeat.o(34388);
        return;
      }
      if (this.AjT != null) {
        this.AjT.add(str);
      }
    }
    AppMethodBeat.o(34388);
  }
  
  public final void a(View paramView, int paramInt, String paramString)
  {
    AppMethodBeat.i(34371);
    if (paramView == null)
    {
      AppMethodBeat.o(34371);
      return;
    }
    if (this.Akd != null)
    {
      ab.w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(34371);
      return;
    }
    ab.i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.Akd = paramString;
    paramString = (h.f)paramView.getTag();
    Resources localResources = paramView.getContext().getResources();
    if ((paramString != null) && (paramString.ztf)) {}
    for (paramInt = 2131689889;; paramInt = 2131689913)
    {
      this.Ake = new ColorDrawable(localResources.getColor(paramInt));
      paramView.setBackground(this.Ake);
      AppMethodBeat.o(34371);
      return;
    }
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, ak>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(34385);
    if ((paramArrayOfSparseArray == null) || (paramArrayOfSparseArray.length <= 0) || (!com.tencent.mm.kernel.g.RG()))
    {
      AppMethodBeat.o(34385);
      return paramArrayOfSparseArray;
    }
    ab.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", new Object[] { Integer.valueOf(paramHashSet.size()), Integer.valueOf(paramArrayOfSparseArray[0].size()) });
    Object localObject1 = new ArrayList();
    Object localObject2 = paramHashSet.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (f.b)((Iterator)localObject2).next();
      if ((localObject3 != null) && (((f.b)localObject3).yVM != 5) && (!((ArrayList)localObject1).contains(((f.b)localObject3).object)))
      {
        ab.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + (String)((f.b)localObject3).object);
        ((ArrayList)localObject1).add(((f.b)localObject3).object);
      }
    }
    localObject2 = new HashMap();
    aw.aaz();
    Object localObject3 = com.tencent.mm.model.c.YF().a((ArrayList)localObject1, com.tencent.mm.model.t.flc, this.ejc, com.tencent.mm.o.a.euH);
    Object localObject4;
    while (((Cursor)localObject3).moveToNext())
    {
      localObject4 = new ak();
      ((ak)localObject4).convertFrom((Cursor)localObject3);
      ((HashMap)localObject2).put(((au)localObject4).field_username, localObject4);
    }
    ((Cursor)localObject3).close();
    localObject3 = paramHashSet.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (f.b)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        if (((f.b)localObject4).yVM != 5)
        {
          StringBuilder localStringBuilder = new StringBuilder("evnet name,").append((String)((f.b)localObject4).object).append("  event.newObj   ==");
          if (((HashMap)localObject2).get(((f.b)localObject4).object) == null) {}
          for (boolean bool = true;; bool = false)
          {
            ab.d("MicroMsg.ConversationWithCacheAdapter", bool);
            ((f.b)localObject4).yVN = ((HashMap)localObject2).get(((f.b)localObject4).object);
            break;
          }
        }
        ((f.b)localObject4).yVN = null;
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
        if (((f.b)localObject2).yVM != 5) {
          ((HashMap)localObject1).put(((f.b)localObject2).object, ((f.b)localObject2).yVN);
        }
      }
    }
    AppMethodBeat.o(34385);
    return paramArrayOfSparseArray;
  }
  
  public final ArrayList<ak> ap(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(34384);
    ab.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    aw.aaz();
    paramArrayList = com.tencent.mm.model.c.YF().a(paramArrayList, com.tencent.mm.model.t.flc, this.ejc, com.tencent.mm.o.a.euH);
    while (paramArrayList.moveToNext())
    {
      ak localak = new ak();
      localak.convertFrom(paramArrayList);
      localArrayList.add(localak);
    }
    paramArrayList.close();
    AppMethodBeat.o(34384);
    return localArrayList;
  }
  
  public final boolean auG(String paramString)
  {
    AppMethodBeat.i(34391);
    if ((this.zte == null) || (!this.zte.containsKey(paramString)))
    {
      AppMethodBeat.o(34391);
      return true;
    }
    AppMethodBeat.o(34391);
    return false;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(34379);
    if (this.zte != null)
    {
      this.zte.clear();
      this.AjZ = true;
    }
    AppMethodBeat.o(34379);
  }
  
  public final com.tencent.mm.cg.a.d dAZ()
  {
    AppMethodBeat.i(34383);
    ab.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
    aw.aaz();
    com.tencent.mm.cg.a.d locald = (com.tencent.mm.cg.a.d)com.tencent.mm.model.c.YF().a(com.tencent.mm.model.t.flc, this.ejc, com.tencent.mm.o.a.euH, true);
    AppMethodBeat.o(34383);
    return locald;
  }
  
  public final void dLE()
  {
    boolean bool1 = true;
    AppMethodBeat.i(34367);
    if (this.ejc == null) {
      this.ejc = new ArrayList();
    }
    this.ejc.clear();
    int i;
    if ((r.Zr() & 0x8000) == 0)
    {
      i = 1;
      boolean bool2 = r.ZF();
      if ((i == 0) || (!bool2)) {
        break label139;
      }
      label59:
      if (bool1 != this.Aka)
      {
        if (!bool1) {
          break label144;
        }
        aw.aaz();
        a(5, (n)com.tencent.mm.model.c.YF(), "floatbottle");
      }
    }
    for (;;)
    {
      this.Aka = bool1;
      if (this.Aka) {
        this.ejc.add("floatbottle");
      }
      this.ejc.add("qmessage");
      AppMethodBeat.o(34367);
      return;
      i = 0;
      break;
      label139:
      bool1 = false;
      break label59;
      label144:
      aw.aaz();
      a(2, (n)com.tencent.mm.model.c.YF(), "floatbottle");
    }
  }
  
  public final void dML()
  {
    AppMethodBeat.i(34373);
    super.i(null, 1);
    AppMethodBeat.o(34373);
  }
  
  public final boolean dzM()
  {
    AppMethodBeat.i(34390);
    boolean bool = super.dzM();
    AppMethodBeat.o(34390);
    return bool;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34374);
    this.Aki = new a((byte)0);
    ak localak = (ak)NM(paramInt);
    String str = localak.field_username;
    this.Akg.kj(str);
    Object localObject1;
    int i;
    Object localObject3;
    label249:
    label505:
    boolean bool;
    if (this.AjV.containsKey(str))
    {
      if (paramInt != ((Integer)this.AjV.get(str)).intValue())
      {
        localObject1 = dBa();
        int k;
        if (this.yVA == null)
        {
          paramViewGroup = null;
          localObject2 = new StringBuffer();
          k = localObject1.length;
          i = 0;
        }
        for (;;)
        {
          if (i >= k) {
            break label249;
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
              paramViewGroup = this.yVA.yRC.dzL();
              break;
            }
          }
          i += 1;
        }
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
        localObject2 = this.AjV.toString();
        if (paramViewGroup == null) {
          break label2049;
        }
        i = paramViewGroup.size();
        ab.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", new Object[] { localObject1, str, Integer.valueOf(paramInt), localObject2, Integer.valueOf(i) });
        if (!this.AjU)
        {
          e.wq(20);
          this.AjU = true;
        }
        if (System.currentTimeMillis() - this.Akj > 3600000L)
        {
          super.i(null, 1);
          this.Akj = System.currentTimeMillis();
        }
      }
      if (paramView != null) {
        break label2093;
      }
      localObject1 = new h.f();
      if (!com.tencent.mm.cb.a.gv(this.context)) {
        break label2072;
      }
      com.tencent.mm.kiss.a.b.SH();
      paramView = com.tencent.mm.kiss.a.b.b((Activity)this.context, 2130969278);
      label546:
      paramView.setTag(2131820681, new int[2]);
      paramView.setOnClickListener(new h.8(this));
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(34361);
          if ((h.f(h.this) == null) || (h.f(h.this).getOnItemLongClickListener() == null))
          {
            ab.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            AppMethodBeat.o(34361);
            return false;
          }
          if (paramAnonymousView.getTag() == null)
          {
            ab.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            AppMethodBeat.o(34361);
            return false;
          }
          if (!h.this.zEj)
          {
            ab.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
            AppMethodBeat.o(34361);
            return false;
          }
          h.f localf = (h.f)paramAnonymousView.getTag();
          int i = localf.position;
          int j = h.f(h.this).getHeaderViewsCount();
          boolean bool = h.f(h.this).getOnItemLongClickListener().onItemLongClick(h.f(h.this), paramAnonymousView, i + j, h.this.getItemId(localf.position));
          AppMethodBeat.o(34361);
          return bool;
        }
      });
      ((h.f)localObject1).egq = ((ImageView)paramView.findViewById(2131821210));
      a.b.c(((h.f)localObject1).egq, str);
      paramViewGroup = (com.tencent.mm.pluginsdk.ui.a)((h.f)localObject1).egq.getDrawable();
      if (this.AhC != null) {
        this.AhC.a(paramViewGroup);
      }
      ((h.f)localObject1).egq.getViewTreeObserver().addOnPreDrawListener(new h.10(this, (h.f)localObject1));
      ((h.f)localObject1).zti = ((NoMeasuredTextView)paramView.findViewById(2131823254));
      ((h.f)localObject1).zti.setLayoutCallback(this.Akb);
      ((h.f)localObject1).ztj = ((NoMeasuredTextView)paramView.findViewById(2131823255));
      ((h.f)localObject1).Aky = ((ImageView)paramView.findViewById(2131823262));
      ((h.f)localObject1).ztk = ((NoMeasuredTextView)paramView.findViewById(2131823256));
      ((h.f)localObject1).jSi = ((TextView)paramView.findViewById(2131821087));
      ((h.f)localObject1).ztl = ((ImageView)paramView.findViewById(2131823258));
      ((h.f)localObject1).ztn = paramView.findViewById(2131823253);
      ((h.f)localObject1).ztm = ((ImageView)paramView.findViewById(2131823259));
      ((h.f)localObject1).Aij = ((ImageView)paramView.findViewById(2131823260));
      ((h.f)localObject1).Akz = ((ImageView)paramView.findViewById(2131823257));
      ((h.f)localObject1).jSi.setBackgroundResource(com.tencent.mm.ui.tools.t.iF(this.context));
      ((h.f)localObject1).jSi.setTextSize(0, com.tencent.mm.cb.a.ap(this.context, 2131428775) * com.tencent.mm.cb.a.gr(this.context));
      ((h.f)localObject1).AkA = new c();
      paramView.setTag(localObject1);
      ((h.f)localObject1).ztk.setTextSize(0, com.tencent.mm.cb.a.ao(this.context, 2131427860));
      ((h.f)localObject1).ztj.setTextSize(0, com.tencent.mm.cb.a.ao(this.context, 2131427862));
      ((h.f)localObject1).zti.setTextSize(0, com.tencent.mm.cb.a.ao(this.context, 2131427809));
      this.Akh = ((h.f)localObject1).zti.getTextSize();
      ((h.f)localObject1).ztk.setTextColor(this.ztd[0]);
      ((h.f)localObject1).ztj.setTextColor(this.ztd[4]);
      ((h.f)localObject1).zti.setTextColor(this.ztd[3]);
      ((h.f)localObject1).ztk.setShouldEllipsize(true);
      ((h.f)localObject1).ztj.setShouldEllipsize(false);
      ((h.f)localObject1).zti.setShouldEllipsize(true);
      if (((h.f)localObject1).zti.getPaint() != null) {
        af.a(((h.f)localObject1).zti.getPaint(), 0.1F);
      }
      ((h.f)localObject1).ztj.setGravity(5);
      paramViewGroup = paramView;
      label1049:
      localObject3 = i(localak);
      ((h.f)localObject1).position = paramInt;
      ((h.f)localObject1).username = str;
      if ((!((d)localObject3).ztf) || (localak.field_conversationTime == -1L)) {
        break label2107;
      }
      bool = true;
      label1093:
      ((h.f)localObject1).ztf = bool;
      if (((d)localObject3).AhV == null) {
        ((d)localObject3).AhV = b(localak, (int)((h.f)localObject1).ztk.getTextSize(), ((d)localObject3).Aic);
      }
      if (((d)localObject3).AhU == null) {
        ((d)localObject3).AhU = h(localak);
      }
      if (!((d)localObject3).Aic) {
        break label2113;
      }
      ((h.f)localObject1).ztk.setTextColor(this.ztd[0]);
      label1174:
      com.tencent.mm.booter.notification.a.h.is(((h.f)localObject1).ztk.getWidth());
      com.tencent.mm.booter.notification.a.h.it((int)((h.f)localObject1).ztk.getTextSize());
      com.tencent.mm.booter.notification.a.h.a(((h.f)localObject1).ztk.getPaint());
      if (!com.tencent.mm.model.t.nK(str)) {
        break label2134;
      }
      ((h.f)localObject1).zti.setCompoundRightDrawablesWithIntrinsicBounds(2131231831);
      ((h.f)localObject1).zti.setDrawRightDrawable(true);
      label1236:
      paramInt = ((d)localObject3).AhW;
      if (paramInt == -1) {
        break label2157;
      }
      ((h.f)localObject1).ztk.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
      ((h.f)localObject1).ztk.setDrawLeftDrawable(true);
      ab.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[] { str, Integer.valueOf(((d)localObject3).AhW) });
      label1293:
      if (!ad.arf(localak.field_username)) {
        break label2191;
      }
      this.Akg.kj(localak.field_username);
      ad localad = this.Akg.ccM();
      paramView = "";
      if (localad != null) {
        paramView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).bd(localad.field_openImAppid, localad.field_descWordingId);
      }
      if (com.tencent.mm.platformtools.ah.isNullOrNil(paramView)) {
        break label2177;
      }
      Object localObject2 = paramView;
      if ("3552365301".equals(localad.field_openImAppid)) {
        localObject2 = "@".concat(String.valueOf(paramView));
      }
      ((h.f)localObject1).zti.aF((String)localObject2, 2131690198, 14);
      label1409:
      ((h.f)localObject1).zti.setText(((d)localObject3).nickName);
      paramView = ((h.f)localObject1).ztj.getLayoutParams();
      if (((d)localObject3).AhU.length() < 9) {
        break label2214;
      }
      if (paramView.width != this.AhM)
      {
        paramView.width = this.AhM;
        ((h.f)localObject1).ztj.setLayoutParams(paramView);
      }
      label1474:
      ((h.f)localObject1).ztj.setText(((d)localObject3).AhU);
      ((h.f)localObject1).ztk.setText(((d)localObject3).AhV);
      ((h.f)localObject1).Aky.setVisibility(8);
      ((h.f)localObject1).ztl.setVisibility(8);
      if (!((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).On(str)) {
        break label2245;
      }
      ((h.f)localObject1).ztl.setVisibility(0);
      ((h.f)localObject1).ztl.setImageResource(2131231086);
      label1559:
      a.b.c(((h.f)localObject1).egq, str);
      if (this.AhA)
      {
        if ((localak != null) && (localObject1 != null) && (localObject3 != null)) {
          break label2324;
        }
        ab.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
      }
      label1599:
      if ((!((d)localObject3).AhZ) && (((d)localObject3).ztf) && (aw.RG()))
      {
        aw.aaz();
        com.tencent.mm.model.c.YF().f(localak);
      }
      if ((this.Akd == null) || (!this.Akd.equals(str))) {
        break label2581;
      }
      ab.i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), this.Akd });
      paramViewGroup.findViewById(2131823252).setBackground(this.Ake);
      label1698:
      if (Build.VERSION.SDK_INT >= 21) {
        paramViewGroup.findViewById(2131823252).setOnTouchListener(new h.2(this));
      }
      com.tencent.mm.bq.d.dpU();
      if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 7, 0L)) && (!localak.field_username.equals(this.AjR.cJU.cJX)))
      {
        localak.fL(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 6, localak.field_conversationTime));
        aw.aaz();
        com.tencent.mm.model.c.YF().a(localak, localak.field_username);
      }
      if ((com.tencent.mm.bg.g.fUM != null) && (com.tencent.mm.bg.g.fUM.uL(localak.field_username))) {
        break label2633;
      }
      ((h.f)localObject1).ztm.setVisibility(8);
      label1831:
      if ((com.tencent.mm.bh.d.fUO == null) || (!com.tencent.mm.bh.d.fUO.uO(localak.field_username))) {
        break label2691;
      }
      ((h.f)localObject1).Aij.setVisibility(0);
      label1862:
      if ((!com.tencent.mm.model.t.lA(localak.field_username)) || (com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class) == null) || (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Uk(localak.field_username))) {
        break label2718;
      }
      if ((!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class)).bSC()) || (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class)).fn(localak.field_username, r.Zn()))) {
        break label2704;
      }
      ((h.f)localObject1).Akz.setImageResource(2131231101);
      label1957:
      ((h.f)localObject1).Akz.setVisibility(0);
    }
    for (;;)
    {
      this.Aki.content = String.valueOf(((d)localObject3).AhV);
      this.Aki.blZ = ((d)localObject3).elx;
      this.Aki.AhT = String.valueOf(((d)localObject3).AhU);
      paramView = this.Aki;
      a.a.dDt().a(paramViewGroup, paramView.blZ, paramView.AhS, paramView.AhT, paramView.content);
      paramViewGroup.setAlpha(1.0F);
      AppMethodBeat.o(34374);
      return paramViewGroup;
      label2049:
      i = 0;
      break;
      this.AjV.put(str, Integer.valueOf(paramInt));
      break label505;
      label2072:
      com.tencent.mm.kiss.a.b.SH();
      paramView = com.tencent.mm.kiss.a.b.b((Activity)this.context, 2130969276);
      break label546;
      label2093:
      localObject1 = (h.f)paramView.getTag();
      paramViewGroup = paramView;
      break label1049;
      label2107:
      bool = false;
      break label1093;
      label2113:
      ((h.f)localObject1).ztk.setTextColor(this.ztd[localObject3.kwo]);
      break label1174;
      label2134:
      if (!((h.f)localObject1).zti.zoX) {
        break label1236;
      }
      ((h.f)localObject1).zti.setDrawRightDrawable(false);
      break label1236;
      label2157:
      ((h.f)localObject1).ztk.setDrawLeftDrawable(false);
      ((h.f)localObject1).ztk.invalidate();
      break label1293;
      label2177:
      ((h.f)localObject1).zti.aF(null, 0, 0);
      break label1409;
      label2191:
      com.tencent.mm.model.t.nK(localak.field_username);
      ((h.f)localObject1).zti.aF(null, 0, 0);
      break label1409;
      label2214:
      if (paramView.width == this.AhL) {
        break label1474;
      }
      paramView.width = this.AhL;
      ((h.f)localObject1).ztj.setLayoutParams(paramView);
      break label1474;
      label2245:
      ((h.f)localObject1).ztl.setImageDrawable(aj.g(this.context, 2131231488, this.context.getResources().getColor(2131689494)));
      if (((d)localObject3).muU)
      {
        if (!((d)localObject3).Aie) {
          break label1559;
        }
        ((h.f)localObject1).ztl.setVisibility(0);
        break label1559;
      }
      if (!((d)localObject3).Aia) {
        break label1559;
      }
      ((h.f)localObject1).ztl.setVisibility(0);
      break label1559;
      label2324:
      ((h.f)localObject1).jSi.setVisibility(4);
      ((h.f)localObject1).ztn.setVisibility(4);
      if ((!com.tencent.mm.model.t.nP(localak.field_username)) && (((d)localObject3).Aid) && ((((d)localObject3).AhY == 1) || (((d)localObject3).AhY == 2) || (((d)localObject3).AhY == 3))) {}
      for (paramView = this.ztd[2];; paramView = this.ztd[3])
      {
        ((h.f)localObject1).zti.setTextColor(paramView);
        if ((((d)localObject3).Aid) && (((d)localObject3).AhX != 0)) {
          break label2441;
        }
        ab.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
        break;
      }
      label2441:
      paramInt = a(localak, (d)localObject3);
      if (paramInt == 1)
      {
        ((h.f)localObject1).ztn.setVisibility(0);
        break label1599;
      }
      if (paramInt != 2) {
        break label1599;
      }
      paramInt = localak.field_unReadCount;
      if (paramInt > 99)
      {
        ((h.f)localObject1).jSi.setText("");
        ((h.f)localObject1).jSi.setBackgroundResource(2131230963);
        ((h.f)localObject1).jSi.setVisibility(0);
      }
      for (;;)
      {
        this.Aki.AhS = paramInt;
        break;
        if (paramInt > 0)
        {
          ((h.f)localObject1).jSi.setText(localak.field_unReadCount);
          ((h.f)localObject1).jSi.setVisibility(0);
          ((h.f)localObject1).jSi.setBackgroundResource(com.tencent.mm.ui.tools.t.iF(this.context));
        }
      }
      label2581:
      if ((((d)localObject3).ztf) && (localak.field_conversationTime != -1L))
      {
        paramViewGroup.findViewById(2131823252).setBackgroundResource(2130839279);
        break label1698;
      }
      paramViewGroup.findViewById(2131823252).setBackgroundResource(2130838476);
      break label1698;
      label2633:
      ((h.f)localObject1).ztm.setVisibility(0);
      if (localak.field_username.equals(this.AjR.cJU.cJX))
      {
        ((h.f)localObject1).ztm.setImageResource(2131232073);
        break label1831;
      }
      ((h.f)localObject1).ztm.setImageResource(2131232072);
      break label1831;
      label2691:
      ((h.f)localObject1).Aij.setVisibility(8);
      break label1862;
      label2704:
      ((h.f)localObject1).Akz.setImageResource(2131231102);
      break label1957;
      label2718:
      ((h.f)localObject1).Akz.setVisibility(8);
    }
  }
  
  final d i(ak paramak)
  {
    boolean bool2 = true;
    AppMethodBeat.i(34375);
    String str2 = paramak.field_username;
    Object localObject;
    if (this.zte != null)
    {
      localObject = (d)this.zte.get(str2);
      if (localObject != null)
      {
        AppMethodBeat.o(34375);
        return localObject;
      }
    }
    d locald = new d((byte)0);
    this.Akg.kj(str2);
    ad localad = this.Akg.ccM();
    if (localad != null)
    {
      locald.AhY = localad.dqS;
      locald.AhX = ((int)localad.euF);
      if (localad == null) {
        break label547;
      }
      bool1 = true;
      label111:
      locald.Aid = bool1;
      if ((localad == null) || (!localad.JY())) {
        break label552;
      }
      bool1 = true;
      label132:
      locald.Aif = bool1;
      if ((localad == null) || (localad.dqK != 0)) {
        break label557;
      }
      bool1 = true;
      label153:
      locald.Aie = bool1;
      locald.muU = com.tencent.mm.model.t.nI(str2);
      if ((!locald.muU) || (!locald.Aie) || (paramak.field_unReadCount <= 0)) {
        break label562;
      }
      bool1 = true;
      label194:
      locald.Aic = bool1;
      locald.kwo = 0;
      if ((GH(paramak.field_msgType) == 34) && (paramak.field_isSend == 0) && (!com.tencent.mm.platformtools.ah.isNullOrNil(paramak.field_content)))
      {
        String str1 = paramak.field_content;
        if ((!str2.equals("qmessage")) && (!str2.equals("floatbottle")) && (!str2.equals("officialaccounts")) && (!paramak.ji(2097152)))
        {
          localObject = str1;
          if (!paramak.ji(8388608)) {}
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
        if (!new p((String)localObject).fXr) {
          locald.kwo = 1;
        }
      }
      if ((!com.tencent.mm.storage.s.aWl()) || (!com.tencent.mm.model.t.ot(str2))) {
        break label567;
      }
      locald.elx = this.context.getResources().getString(2131297724);
      label426:
      a(locald, localad);
      locald.AhU = h(paramak);
      locald.AhW = QA(paramak.field_status);
      locald.AhZ = com.tencent.mm.model.t.a(paramak);
      aw.aaz();
      locald.ztf = com.tencent.mm.model.c.YF().g(paramak);
      if ((localad == null) || (!localad.DP())) {
        break label587;
      }
    }
    label547:
    label552:
    label557:
    label562:
    label567:
    label587:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locald.Aia = bool1;
      if (this.zte != null) {
        this.zte.put(str2, locald);
      }
      AppMethodBeat.o(34375);
      return locald;
      locald.AhY = -1;
      locald.AhX = -1;
      break;
      bool1 = false;
      break label111;
      bool1 = false;
      break label132;
      bool1 = false;
      break label153;
      bool1 = false;
      break label194;
      locald.elx = com.tencent.mm.model.s.a(localad, str2, locald.muU);
      break label426;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(34393);
    if (!this.Akl)
    {
      super.notifyDataSetChanged();
      this.AjV.clear();
    }
    ab.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    AppMethodBeat.o(34393);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(34368);
    ab.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.zEj);
    if (!this.zEj)
    {
      AppMethodBeat.o(34368);
      return;
    }
    this.zEj = false;
    super.pause();
    if (this.jSe != null) {
      this.jSe.bKk();
    }
    AppMethodBeat.o(34368);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(34370);
    ab.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.zEj);
    if (this.zEj)
    {
      AppMethodBeat.o(34370);
      return;
    }
    this.zEj = true;
    dLE();
    dMM();
    ab.i(this.TAG, "newcursor resume syncNow ");
    this.yVz = true;
    qc(true);
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.f.g.a("MM/dd", (Time)localObject).toString();
    String str = aa.dsG();
    if ((!this.AhJ.equals(localObject)) || (!this.Akc.equals(str))) {}
    for (int i = 1;; i = 0)
    {
      this.AhJ = ((String)localObject);
      this.Akc = str;
      if (i != 0) {
        dMq();
      }
      if ((this.AhE) && (this.AjS != null))
      {
        this.AjS.dMN();
        this.AhE = false;
        super.i(null, 1);
      }
      this.AjR = new tl();
      this.AjR.cJT.cJV = true;
      com.tencent.mm.sdk.b.a.ymk.l(this.AjR);
      AppMethodBeat.o(34370);
      return;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
  
  final class a
  {
    public int AhS;
    public String AhT;
    public String blZ;
    public String content;
    
    private a() {}
  }
  
  final class c
  {
    boolean Akq = false;
    boolean Akr = false;
    boolean Aks = false;
    boolean Akt = false;
    boolean Aku = false;
    public ImageView Akv = null;
    public TextView Akw = null;
    public View Akx = null;
    public View jSj = null;
    public TextView jSk = null;
    String username = "";
    public View zlw = null;
    
    c() {}
  }
  
  final class d
  {
    public CharSequence AhU;
    public CharSequence AhV;
    public int AhW;
    public int AhX;
    public int AhY;
    public boolean AhZ;
    public boolean Aia;
    public boolean Aic;
    public boolean Aid;
    public boolean Aie;
    public boolean Aif;
    public String elx;
    public int kwo;
    public boolean muU;
    public CharSequence nickName;
    public boolean ztf;
    
    private d() {}
  }
  
  final class e
  {
    private Integer Aih = null;
    private ad contact = null;
    private boolean initialized = false;
    private String talker = null;
    
    public e() {}
    
    public final ad ccM()
    {
      AppMethodBeat.i(34364);
      if ((this.initialized) && (this.contact == null) && (aw.RG()))
      {
        aw.aaz();
        this.contact = com.tencent.mm.model.c.YA().arw(this.talker);
      }
      ad localad = this.contact;
      AppMethodBeat.o(34364);
      return localad;
    }
    
    public final void kj(String paramString)
    {
      AppMethodBeat.i(34363);
      this.talker = paramString;
      this.contact = null;
      this.Aih = null;
      this.initialized = false;
      if (!com.tencent.mm.platformtools.ah.isNullOrNil(paramString)) {
        this.initialized = true;
      }
      AppMethodBeat.o(34363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h
 * JD-Core Version:    0.7.0.1
 */
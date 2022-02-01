package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.d;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.g.b;
import com.tencent.mm.ui.g.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class a
  extends g<String, f>
  implements MStorageEx.IOnStorageChange
{
  public static final ColorStateList Eeh;
  public static final ColorStateList Eei;
  protected MMSlideDelView.f GtD;
  private String[] Wtw;
  public HashMap<String, f> XoR;
  protected String XoS;
  protected String XoT;
  private List<Object> XoU;
  private List<String> XoV;
  private int XoW;
  protected int[] XoX;
  String[] XoY;
  protected AddressUI.AddressUIFragment XoZ;
  private Set<Integer> Xpa;
  private int Xpb;
  private boolean Xpc;
  a Xpd;
  private boolean Xpe;
  boolean Xpf;
  private String Xpg;
  LinkedList<View> Xph;
  boolean Xpi;
  HashMap<View, ViewStub> Xpj;
  private NoMeasuredTextView.c Xpk;
  private SparseArray<String> Xpl;
  private SparseArray<Integer> Xpm;
  private HashSet<String> Xpn;
  View.OnClickListener dig;
  protected List<String> jkb;
  private String mUI;
  private com.tencent.mm.ui.applet.b mVX;
  private WeakReference<Context> nLE;
  StringBuilder sb;
  protected MMSlideDelView.g snh;
  protected MMSlideDelView.c sni;
  protected MMSlideDelView.d snk;
  private boolean sxF;
  private int type;
  
  static
  {
    AppMethodBeat.i(37596);
    Eeh = com.tencent.mm.ci.a.l(MMApplicationContext.getContext(), R.e.mm_list_textcolor_one);
    Eei = com.tencent.mm.ci.a.l(MMApplicationContext.getContext(), R.e.hint_text_color);
    AppMethodBeat.o(37596);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(37572);
    this.XoS = null;
    this.XoT = null;
    this.jkb = null;
    this.XoW = 0;
    this.mUI = "";
    this.Wtw = null;
    this.snk = MMSlideDelView.getItemStatusCallBack();
    this.Xpa = new HashSet();
    this.Xpb = 0;
    this.Xpc = true;
    this.mVX = null;
    this.sxF = false;
    this.Xpe = false;
    this.Xpf = false;
    this.Xph = new LinkedList();
    this.Xpj = new HashMap();
    this.Xpk = new NoMeasuredTextView.c()
    {
      public final CharSequence a(NoMeasuredTextView paramAnonymousNoMeasuredTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(217472);
        float f1 = paramAnonymousNoMeasuredTextView.getPaint().getTextSize();
        paramAnonymousInt2 = com.tencent.mm.ci.a.fromDPToPix(a.a(a.this), paramAnonymousInt2);
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
          paramAnonymousCharSequence = com.tencent.mm.pluginsdk.ui.span.l.c(a.b(a.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
          ColorStateList localColorStateList = com.tencent.mm.ci.a.l(a.c(a.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(217472);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.dig = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37568);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.v("MicroMsg.AddressAdapter", "on delView clicked");
        a.this.snk.eKn();
        if (a.this.GtD != null) {
          a.this.GtD.cW(((ViewStub)a.d(a.this).get(paramAnonymousView)).getTag());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37568);
      }
    };
    this.sb = new StringBuilder(32);
    this.Xpl = new SparseArray();
    this.Xpm = new SparseArray();
    this.Xpn = new HashSet();
    this.XoR = new HashMap();
    this.nLE = new WeakReference(paramContext);
    this.context = MMApplicationContext.getContext();
    this.XoS = paramString1;
    this.XoT = paramString2;
    this.type = paramInt;
    this.Xpe = true;
    this.XoU = new LinkedList();
    this.XoV = new LinkedList();
    this.Xpg = z.bcZ();
    this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    AppMethodBeat.o(37572);
  }
  
  public static String aL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37582);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      AppMethodBeat.o(37582);
      return paramString1;
    }
    AppMethodBeat.o(37582);
    return paramString2;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(37587);
    String str2 = (String)this.Xpl.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = this.context.getString(paramInt);
      this.Xpl.put(paramInt, str1);
    }
    AppMethodBeat.o(37587);
    return str1;
  }
  
  private boolean hUe()
  {
    AppMethodBeat.i(37575);
    if ((this.XoS.equals("@micromsg.qq.com")) || (this.XoS.equals("@all.contact.without.chatroom")) || (this.XoS.equals("@all.contact.without.chatroom.without.openim")))
    {
      AppMethodBeat.o(37575);
      return true;
    }
    AppMethodBeat.o(37575);
    return false;
  }
  
  protected int a(f paramf, int paramInt)
  {
    AppMethodBeat.i(37584);
    if (paramInt < this.Xpb)
    {
      AppMethodBeat.o(37584);
      return 32;
    }
    if (paramf == null)
    {
      Log.e("MicroMsg.AddressAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(37584);
      return -1;
    }
    paramInt = paramf.field_showHead;
    AppMethodBeat.o(37584);
    return paramInt;
  }
  
  protected void a(f paramf, b paramb)
  {
    AppMethodBeat.i(37580);
    try
    {
      paramb.mNc.setText(null);
      paramb.mNc.setVisibility(8);
      AppMethodBeat.o(37580);
      return;
    }
    catch (Throwable paramf)
    {
      AppMethodBeat.o(37580);
    }
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.GtD = paramf;
  }
  
  public final SparseArray<String>[] a(HashSet<g.b<String, f>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(37590);
    paramHashSet = new SparseArray[paramArrayOfSparseArray.length];
    paramArrayOfSparseArray = new LinkedList();
    paramArrayOfSparseArray.add("weixin");
    long l = System.currentTimeMillis();
    bh.beI();
    paramArrayOfSparseArray = c.bbL().b(this.XoS, this.XoT, this.jkb, paramArrayOfSparseArray, hUe(), this.Xpe);
    int i;
    if ((paramArrayOfSparseArray instanceof com.tencent.mm.storagebase.a.e))
    {
      com.tencent.mm.storagebase.a.d[] arrayOfd = ((com.tencent.mm.storagebase.a.e)paramArrayOfSparseArray).VJT;
      int k = arrayOfd.length;
      i = 0;
      while (i < k)
      {
        arrayOfd[i].asX(5000);
        paramHashSet[i] = new SparseArray();
        int j = 0;
        while (arrayOfd[i].moveToNext())
        {
          paramHashSet[i].put(j, arrayOfd[i].getString(0));
          j += 1;
        }
        i += 1;
      }
      this.Xpb = arrayOfd[0].getCount();
    }
    for (;;)
    {
      paramArrayOfSparseArray.close();
      Log.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(37590);
      return paramHashSet;
      paramHashSet[0] = new SparseArray();
      i = 0;
      while (paramArrayOfSparseArray.moveToNext())
      {
        paramHashSet[0].put(i, paramArrayOfSparseArray.getString(0));
        i += 1;
      }
    }
  }
  
  public final int awI(int paramInt)
  {
    int i = paramInt;
    if (this.XoX != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.XoX.length) {
          i = this.XoX[paramInt];
        }
      }
    }
    return this.Xpb + i;
  }
  
  public final g<String, f>.c b(com.tencent.mm.storagebase.a.d<String> paramd)
  {
    AppMethodBeat.i(270468);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramd = new g.c(this, paramd, (byte)0);
      AppMethodBeat.o(270468);
      return paramd;
    }
    paramd = new g.c(this, paramd);
    AppMethodBeat.o(270468);
    return paramd;
  }
  
  protected String b(f paramf, int paramInt)
  {
    AppMethodBeat.i(37585);
    if (paramInt < this.Xpb)
    {
      paramf = getString(R.l.eny);
      AppMethodBeat.o(37585);
      return paramf;
    }
    if (paramf.field_showHead == 31)
    {
      AppMethodBeat.o(37585);
      return "";
    }
    if (paramf.field_showHead == 123)
    {
      AppMethodBeat.o(37585);
      return "#";
    }
    if (paramf.field_showHead == 33)
    {
      paramf = getString(R.l.emU);
      AppMethodBeat.o(37585);
      return paramf;
    }
    if (paramf.field_showHead == 43)
    {
      paramf = getString(R.l.eRh);
      AppMethodBeat.o(37585);
      return paramf;
    }
    if (paramf.field_showHead == 32)
    {
      paramf = getString(R.l.eny);
      AppMethodBeat.o(37585);
      return paramf;
    }
    String str = (String)this.Xpl.get(paramf.field_showHead);
    if (str != null)
    {
      AppMethodBeat.o(37585);
      return str;
    }
    str = String.valueOf((char)paramf.field_showHead);
    this.Xpl.put(paramf.field_showHead, str);
    AppMethodBeat.o(37585);
    return str;
  }
  
  protected void b(f paramf, b paramb)
  {
    AppMethodBeat.i(37581);
    Object localObject2;
    Object localObject1;
    if (as.bvK(paramf.field_username))
    {
      localObject2 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bR(paramf.field_openImAppid, paramf.field_descWordingId);
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject1 = localObject2;
        if ("3552365301".equals(paramf.field_openImAppid)) {
          localObject1 = "@".concat(String.valueOf(localObject2));
        }
        paramb.Xpq.aT((String)localObject1, R.e.dkA, 14);
        if ((!ab.PQ(paramf.field_username)) && (!ab.PT(paramf.field_username))) {
          break label247;
        }
        paramb.Xpq.setCompoundRightDrawablesWithIntrinsicBounds(R.k.open_im_main_logo);
        paramb.Xpq.setDrawRightDrawable(true);
        label127:
        localObject1 = paramf.Vcw;
        if (localObject1 != null) {
          break label274;
        }
      }
    }
    for (;;)
    {
      label247:
      CharSequence localCharSequence;
      try
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.d(this.context, bzP(aL(paramf.ays(), paramf.field_username)), com.tencent.mm.ci.a.aY(this.context, R.f.NormalTextSize));
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        paramb.Xpq.setText((CharSequence)localObject2);
        ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).setTextWithStatus(paramb.Xpq, paramf.field_username, com.tencent.mm.plugin.textstatus.a.a.b.MzA);
        AppMethodBeat.o(37581);
        return;
        paramb.Xpq.aT(null, 0, 0);
        break;
        paramb.Xpq.aT(null, 0, 0);
        break;
        if (!paramb.Xpq.WoY) {
          break label127;
        }
        paramb.Xpq.setDrawRightDrawable(false);
      }
      catch (Exception localException)
      {
        localCharSequence = null;
        continue;
      }
      label274:
      paramb.Xpq.setText(localCharSequence);
    }
  }
  
  public final ArrayList<f> bD(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(37589);
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ((List)localObject).add((String)paramArrayList.get(i));
      i += 1;
    }
    paramArrayList = new ArrayList(((List)localObject).size());
    bh.beI();
    localObject = c.bbL().jC((List)localObject);
    while (((Cursor)localObject).moveToNext())
    {
      f localf = new f();
      localf.convertFrom((Cursor)localObject);
      paramArrayList.add(localf);
    }
    ((Cursor)localObject).close();
    Log.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37589);
    return paramArrayList;
  }
  
  protected final String bzP(String paramString)
  {
    AppMethodBeat.i(37583);
    if (("".length() > 0) && (!"".equals(paramString)))
    {
      this.sb.append(paramString);
      this.sb.append("(");
      this.sb.append("");
      this.sb.append(")");
      paramString = this.sb.toString();
      this.sb.delete(0, this.sb.length());
      AppMethodBeat.o(37583);
      return paramString;
    }
    AppMethodBeat.o(37583);
    return paramString;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(37573);
    if (this.mVX != null)
    {
      this.mVX.detach();
      this.mVX = null;
    }
    AppMethodBeat.o(37573);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(37586);
    int i = super.getCount();
    AppMethodBeat.o(37586);
    return i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37579);
    paramViewGroup = (Context)this.nLE.get();
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(37579);
      return paramView;
    }
    int i;
    if (!this.Xpi)
    {
      i = 0;
      while (i < 8)
      {
        this.Xph.add(ad.kS(paramViewGroup).inflate(R.i.ebs, null));
        i += 1;
      }
      this.Xpi = true;
    }
    f localf = (f)asW(paramInt);
    Object localObject1;
    label388:
    Object localObject2;
    label425:
    label564:
    Activity localActivity;
    if (paramView == null) {
      if (this.Xph.size() > 0)
      {
        paramView = (View)this.Xph.getFirst();
        this.Xph.removeFirst();
        paramViewGroup = new b();
        paramViewGroup.DUW = ((TextView)paramView.findViewById(R.h.dCx));
        paramViewGroup.DUX = ((TextView)paramView.findViewById(R.h.dCE));
        paramViewGroup.Xpq = ((NoMeasuredTextView)paramView.findViewById(R.h.dNc));
        paramViewGroup.Xpq.setLayoutCallback(this.Xpk);
        paramViewGroup.Xpq.setTextSize(0, com.tencent.mm.ci.a.aY(this.context, R.f.NormalTextSize));
        paramViewGroup.Xpq.setShouldEllipsize(true);
        if (paramViewGroup.Xpq.getPaint() != null) {
          ar.a(paramViewGroup.Xpq.getPaint(), 0.1F);
        }
        paramViewGroup.Xpq.setTextColor(com.tencent.mm.ci.a.l(this.context, R.e.normal_text_color));
        paramViewGroup.Xpq.setGravity(16);
        paramViewGroup.jiu = ((ImageView)paramView.findViewById(R.h.dqv));
        paramViewGroup.Xpr = ((TextView)paramView.findViewById(R.h.dCu));
        paramViewGroup.Xps = paramView.findViewById(R.h.dCD);
        paramViewGroup.mNc = ((TextView)paramView.findViewById(R.h.openim_contact_desc));
        paramViewGroup.Xpt = ((CategoryTipView)paramView.findViewById(R.h.dCy));
        paramViewGroup.Xpu = ((ViewGroup)paramView.findViewById(R.h.dCw));
        localObject1 = paramViewGroup.Xps.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.ci.a.aZ(this.context, R.f.ContactListHeight) * com.tencent.mm.ci.a.kn(this.context)));
        paramViewGroup.Xps.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramView.setTag(paramViewGroup);
        if (localf != null)
        {
          localObject2 = (f)asW(paramInt - 1);
          localObject1 = (f)asW(paramInt + 1);
          if (localObject2 != null) {
            break label791;
          }
          i = -1;
          int j = a(localf, paramInt);
          if (localObject1 != null) {
            a((f)localObject1, paramInt + 1);
          }
          paramViewGroup.Xpt.setTag(Integer.valueOf(j));
          if ((!this.Xpc) || (paramInt < 0) || (j == i)) {
            break label805;
          }
          localObject2 = b(localf, paramInt);
          if (Util.isNullOrNil((String)localObject2)) {
            break label805;
          }
          paramViewGroup.Xpu.setVisibility(0);
          paramViewGroup.DUW.setVisibility(0);
          paramViewGroup.DUW.setText((CharSequence)localObject2);
          paramViewGroup.Xpt.awL(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().gbt());
          label547:
          localObject2 = b(localf, paramInt);
          if (localObject1 != null) {
            break label835;
          }
          localObject1 = null;
          paramInt = paramViewGroup.Xps.getPaddingLeft();
          localActivity = (Activity)this.nLE.get();
          if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
            break label849;
          }
          paramViewGroup.Xpq.setBackground(null);
          paramViewGroup.Xps.setBackground(aw.bf(localActivity, R.d.list_item_divider));
        }
      }
    }
    for (;;)
    {
      paramViewGroup.Xps.setPadding(paramInt, 0, 0, 0);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.jiu, localf.field_username);
      b(localf, paramViewGroup);
      a(localf, paramViewGroup);
      com.tencent.mm.plugin.sns.ui.e.a.b(0, (String)paramViewGroup.jiu.getTag(), (AvatarImageView)paramViewGroup.jiu);
      ((AvatarImageView)paramViewGroup.jiu).gp(localf.field_username, 0);
      ((AvatarImageView)paramViewGroup.jiu).setTag(localf.field_username);
      com.tencent.mm.plugin.sns.ui.e.a.a(0, localf.field_username, (AvatarImageView)paramViewGroup.jiu);
      ((AvatarImageView)paramViewGroup.jiu).setShowStoryHint(com.tencent.mm.plugin.sns.f.a.aZz(localf.field_username));
      paramViewGroup.jiu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37566);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.d("MicroMsg.AddressAdapter", "click avatarIv");
          if (paramAnonymousView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37566);
            return;
          }
          a.this.snh.s(paramAnonymousView, a.this.sni.dO(paramAnonymousView), R.h.dqv);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37566);
        }
      });
      AppMethodBeat.o(37579);
      return paramView;
      paramView = View.inflate(paramViewGroup, R.i.ebs, null);
      break;
      paramViewGroup = (b)paramView.getTag();
      break label388;
      label791:
      i = a((f)localObject2, paramInt - 1);
      break label425;
      label805:
      paramViewGroup.Xpu.setVisibility(8);
      paramViewGroup.DUW.setVisibility(8);
      paramViewGroup.Xpt.setVisibility(8);
      break label547;
      label835:
      localObject1 = b((f)localObject1, paramInt + 1);
      break label564;
      label849:
      paramViewGroup.Xpq.setBackground(aw.bf(localActivity, R.d.list_item_divider));
      paramViewGroup.Xps.setBackground(null);
    }
  }
  
  public final com.tencent.mm.storagebase.a.d<String> hFF()
  {
    AppMethodBeat.i(37588);
    com.tencent.mm.storagebase.a.d locald = (com.tencent.mm.storagebase.a.d)hUf();
    AppMethodBeat.o(37588);
    return locald;
  }
  
  public final void hR(String paramString, int paramInt)
  {
    AppMethodBeat.i(37569);
    if (paramInt == 5) {
      this.Xpn.add(paramString);
    }
    super.u(paramString, paramInt);
    AppMethodBeat.o(37569);
  }
  
  protected Cursor hUf()
  {
    AppMethodBeat.i(37576);
    long l = System.currentTimeMillis();
    final LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("weixin");
    bh.beI();
    Cursor localCursor = c.bbL().a(this.XoS, this.XoT, this.jkb, localLinkedList, hUe(), this.Xpe);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(286995);
        bh.beI();
        Cursor localCursor = c.bbL().a(a.this.XoS, a.this.XoT, a.this.jkb, localLinkedList, a.e(a.this), a.f(a.this));
        if (localCursor != null)
        {
          try
          {
            if (!(localCursor instanceof com.tencent.mm.storagebase.a.e)) {
              break label214;
            }
            ArrayList localArrayList = new ArrayList();
            com.tencent.mm.storagebase.a.d locald = ((com.tencent.mm.storagebase.a.e)localCursor).VJT[0];
            int i = locald.getPosition();
            if (locald != null)
            {
              while (locald.moveToNext())
              {
                f localf = new f();
                localf.convertFrom(locald);
                localArrayList.add(localf.field_username);
                Log.d("MicroMsg.AddressAdapter", "mStarUserList add %s %s", new Object[] { localf.field_username, localf.field_conRemark });
              }
              locald.moveToPosition(i);
            }
          }
          finally
          {
            if (localCursor != null) {
              localCursor.close();
            }
            AppMethodBeat.o(286995);
          }
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().hY(localList);
        }
        label214:
        if (localCursor != null)
        {
          localCursor.close();
          AppMethodBeat.o(286995);
          return;
        }
        AppMethodBeat.o(286995);
      }
    });
    Log.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37576);
    return localCursor;
  }
  
  protected final void hUg()
  {
    AppMethodBeat.i(37577);
    int k = getCount();
    if (k == 0)
    {
      AppMethodBeat.o(37577);
      return;
    }
    this.Xpb = hFE();
    if (this.Wtw != null)
    {
      this.XoX = ab.a(this.XoS, this.XoT, this.jkb, this.Wtw);
      this.XoY = ab.a(this.XoS, this.XoT, this.Wtw, this.jkb);
    }
    for (;;)
    {
      this.Xpa.clear();
      if (this.XoX == null) {
        break;
      }
      Object localObject1 = this.XoX;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        k = localObject1[i];
        this.Xpa.add(Integer.valueOf(k - 1));
        i += 1;
      }
      long l;
      if (hBP())
      {
        l = System.currentTimeMillis();
        localObject1 = new HashSet();
        this.XoX = new int[30];
        this.XoY = new String[30];
        j = this.Xpb;
        i = 0;
        if (j < k)
        {
          Object localObject2 = (f)asW(j);
          if (localObject2 != null)
          {
            localObject2 = b((f)localObject2, j);
            if (!((HashSet)localObject1).add(localObject2)) {
              break label268;
            }
            this.XoX[i] = (j - this.Xpb);
            this.XoY[i] = localObject2;
            i += 1;
          }
          label268:
          for (;;)
          {
            j += 1;
            break;
            Log.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
          }
        }
        Log.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - l) + "favourCount : " + this.Xpb);
      }
      else
      {
        l = System.currentTimeMillis();
        this.XoX = ab.a(null, this.XoS, this.XoT, this.jkb, this.mUI);
        this.XoY = ab.a(null, this.XoS, this.XoT, this.mUI, this.jkb);
        Log.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - l));
      }
    }
    AppMethodBeat.o(37577);
  }
  
  public final void hUh()
  {
    AppMethodBeat.i(37578);
    this.snk.eKn();
    AppMethodBeat.o(37578);
  }
  
  public final void hUi()
  {
    AppMethodBeat.i(37591);
    super.u(null, 1);
    AppMethodBeat.o(37591);
  }
  
  public final void kw(List<String> paramList)
  {
    AppMethodBeat.i(37574);
    if (this.type != 2) {
      paramList.add(z.bcZ());
    }
    bh.beI();
    Object localObject = c.bbU().aPi("@t.qq.com");
    if (localObject != null) {
      paramList.add(((cj)localObject).name);
    }
    if ((this.type == 3) || (this.type == 5) || (this.type == 4) || (this.type == 1) || (this.type == 0))
    {
      localObject = ab.bdW().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add((String)((Iterator)localObject).next());
      }
    }
    paramList.add("blogapp");
    this.jkb = paramList;
    AppMethodBeat.o(37574);
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(37571);
    this.Xpg = z.bcZ();
    if (this.XoX == null) {
      hUg();
    }
    if (getCount() == 0)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(37571);
      return;
    }
    this.Xpb = hFE();
    Log.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[] { Integer.valueOf(this.Xpb) });
    super.notifyDataSetChanged();
    AppMethodBeat.o(37571);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(37592);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(37592);
      return;
    }
    bh.beI();
    if (paramMStorageEx == c.bbL()) {
      if ((!ab.Qk((String)paramObject)) && (!this.Xpn.contains((String)paramObject)))
      {
        super.u((String)paramObject, 2);
        if ((this.Xpf) && (this.XoZ != null))
        {
          this.XoZ.XpO = true;
          Log.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
          AppMethodBeat.o(37592);
        }
      }
      else
      {
        Log.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
      }
    }
    AppMethodBeat.o(37592);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(37570);
    this.Xpn.clear();
    super.pause();
    AppMethodBeat.o(37570);
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.XoZ = ((AddressUI.AddressUIFragment)paramFragment);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.sni = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.snh = paramg;
  }
  
  public static abstract interface a {}
  
  protected static final class b
  {
    public TextView DUW;
    public TextView DUX;
    public NoMeasuredTextView Xpq;
    public TextView Xpr;
    public View Xps;
    public CategoryTipView Xpt;
    public ViewGroup Xpu;
    public ImageView jiu;
    public TextView mNc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a
 * JD-Core Version:    0.7.0.1
 */
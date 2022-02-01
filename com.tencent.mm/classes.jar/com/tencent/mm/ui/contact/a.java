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
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storagebase.a.d;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.g.b;
import com.tencent.mm.ui.g.c;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class a
  extends g<String, com.tencent.mm.storage.f>
  implements MStorageEx.IOnStorageChange
{
  public static final ColorStateList JVS;
  public static final ColorStateList JVT;
  protected MMSlideDelView.f MpD;
  private String[] aeaP;
  String[] afaA;
  protected AddressUI.AddressUIFragment afaB;
  private Set<Integer> afaC;
  private int afaD;
  private boolean afaE;
  a afaF;
  private boolean afaG;
  boolean afaH;
  private String afaI;
  LinkedList<View> afaJ;
  boolean afaK;
  HashMap<View, ViewStub> afaL;
  private NoMeasuredTextView.c afaM;
  private SparseArray<String> afaN;
  private SparseArray<Integer> afaO;
  private HashSet<String> afaP;
  public HashMap<String, com.tencent.mm.storage.f> afat;
  protected String afau;
  protected String afav;
  private List<Object> afaw;
  private List<String> afax;
  private int afay;
  protected int[] afaz;
  View.OnClickListener fhU;
  protected List<String> lMF;
  private String pRp;
  private com.tencent.mm.ui.applet.b pSE;
  private WeakReference<Context> qLs;
  StringBuilder sb;
  private int type;
  private boolean vDm;
  protected MMSlideDelView.g vzf;
  protected MMSlideDelView.c vzg;
  protected MMSlideDelView.d vzi;
  
  static
  {
    AppMethodBeat.i(37596);
    JVS = com.tencent.mm.cd.a.l(MMApplicationContext.getContext(), R.e.mm_list_textcolor_one);
    JVT = com.tencent.mm.cd.a.l(MMApplicationContext.getContext(), R.e.hint_text_color);
    AppMethodBeat.o(37596);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(37572);
    this.afau = null;
    this.afav = null;
    this.lMF = null;
    this.afay = 0;
    this.pRp = "";
    this.aeaP = null;
    this.vzi = MMSlideDelView.getItemStatusCallBack();
    this.afaC = new HashSet();
    this.afaD = 0;
    this.afaE = true;
    this.pSE = null;
    this.vDm = false;
    this.afaG = false;
    this.afaH = false;
    this.afaJ = new LinkedList();
    this.afaL = new HashMap();
    this.afaM = new NoMeasuredTextView.c()
    {
      public final CharSequence a(NoMeasuredTextView paramAnonymousNoMeasuredTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(252926);
        float f1 = paramAnonymousNoMeasuredTextView.getPaint().getTextSize();
        paramAnonymousInt2 = com.tencent.mm.cd.a.fromDPToPix(a.a(a.this), paramAnonymousInt2);
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
          paramAnonymousCharSequence = p.b(a.b(a.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
          ColorStateList localColorStateList = com.tencent.mm.cd.a.l(a.c(a.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(252926);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.fhU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37568);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.v("MicroMsg.AddressAdapter", "on delView clicked");
        a.this.vzi.fSn();
        if (a.this.MpD != null) {
          a.this.MpD.es(((ViewStub)a.d(a.this).get(paramAnonymousView)).getTag());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37568);
      }
    };
    this.sb = new StringBuilder(32);
    this.afaN = new SparseArray();
    this.afaO = new SparseArray();
    this.afaP = new HashSet();
    this.afat = new HashMap();
    this.qLs = new WeakReference(paramContext);
    this.context = MMApplicationContext.getContext();
    this.afau = paramString1;
    this.afav = paramString2;
    this.type = paramInt;
    this.afaG = true;
    this.afaw = new LinkedList();
    this.afax = new LinkedList();
    this.afaI = z.bAM();
    this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    AppMethodBeat.o(37572);
  }
  
  public static String aV(String paramString1, String paramString2)
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
    String str2 = (String)this.afaN.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = this.context.getString(paramInt);
      this.afaN.put(paramInt, str1);
    }
    AppMethodBeat.o(37587);
    return str1;
  }
  
  private boolean jxU()
  {
    AppMethodBeat.i(37575);
    if ((this.afau.equals("@micromsg.qq.com")) || (this.afau.equals("@all.contact.without.chatroom")) || (this.afau.equals("@all.contact.without.chatroom.without.openim")))
    {
      AppMethodBeat.o(37575);
      return true;
    }
    AppMethodBeat.o(37575);
    return false;
  }
  
  protected int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37584);
    if (paramInt < this.afaD)
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
  
  protected void a(com.tencent.mm.storage.f paramf, b paramb)
  {
    AppMethodBeat.i(37580);
    try
    {
      paramb.pJK.setText(null);
      paramb.pJK.setVisibility(8);
      return;
    }
    finally
    {
      AppMethodBeat.o(37580);
    }
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.MpD = paramf;
  }
  
  public final SparseArray<String>[] a(HashSet<g.b<String, com.tencent.mm.storage.f>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(37590);
    paramHashSet = new SparseArray[paramArrayOfSparseArray.length];
    paramArrayOfSparseArray = new LinkedList();
    paramArrayOfSparseArray.add("weixin");
    long l = System.currentTimeMillis();
    bh.bCz();
    paramArrayOfSparseArray = c.bzA().b(this.afau, this.afav, this.lMF, paramArrayOfSparseArray, jxU(), this.afaG);
    int i;
    if ((paramArrayOfSparseArray instanceof com.tencent.mm.storagebase.a.e))
    {
      d[] arrayOfd = ((com.tencent.mm.storagebase.a.e)paramArrayOfSparseArray).adnX;
      int k = arrayOfd.length;
      i = 0;
      while (i < k)
      {
        arrayOfd[i].fi(5000);
        paramHashSet[i] = new SparseArray();
        int j = 0;
        while (arrayOfd[i].moveToNext())
        {
          paramHashSet[i].put(j, arrayOfd[i].getString(0));
          j += 1;
        }
        i += 1;
      }
      this.afaD = arrayOfd[0].getCount();
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
  
  public final int aDr(int paramInt)
  {
    int i = paramInt;
    if (this.afaz != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.afaz.length) {
          i = this.afaz[paramInt];
        }
      }
    }
    return this.afaD + i;
  }
  
  public final g<String, com.tencent.mm.storage.f>.c b(d<String> paramd)
  {
    AppMethodBeat.i(252934);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramd = new g.c(this, paramd, (byte)0);
      AppMethodBeat.o(252934);
      return paramd;
    }
    paramd = new g.c(this, paramd);
    AppMethodBeat.o(252934);
    return paramd;
  }
  
  protected String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37585);
    if (paramInt < this.afaD)
    {
      paramf = getString(R.l.gqy);
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
      paramf = getString(R.l.gpV);
      AppMethodBeat.o(37585);
      return paramf;
    }
    if (paramf.field_showHead == 43)
    {
      paramf = getString(R.l.gTN);
      AppMethodBeat.o(37585);
      return paramf;
    }
    if (paramf.field_showHead == 32)
    {
      paramf = getString(R.l.gqy);
      AppMethodBeat.o(37585);
      return paramf;
    }
    String str = (String)this.afaN.get(paramf.field_showHead);
    if (str != null)
    {
      AppMethodBeat.o(37585);
      return str;
    }
    str = String.valueOf((char)paramf.field_showHead);
    this.afaN.put(paramf.field_showHead, str);
    AppMethodBeat.o(37585);
    return str;
  }
  
  protected void b(com.tencent.mm.storage.f paramf, b paramb)
  {
    AppMethodBeat.i(37581);
    Object localObject2;
    Object localObject1;
    if (au.bwO(paramf.field_username))
    {
      localObject2 = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).cc(paramf.field_openImAppid, paramf.field_descWordingId);
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject1 = localObject2;
        if ("3552365301".equals(paramf.field_openImAppid)) {
          localObject1 = "@".concat(String.valueOf(localObject2));
        }
        paramb.afaS.bc((String)localObject1, R.e.fkJ, 14);
        if ((!au.bwF(paramf.field_username)) && (!ab.II(paramf.field_username))) {
          break label247;
        }
        paramb.afaS.setCompoundRightDrawablesWithIntrinsicBounds(R.k.open_im_main_logo);
        paramb.afaS.setDrawRightDrawable(true);
        label127:
        localObject1 = paramf.acDG;
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
        localObject1 = p.d(this.context, bBG(aV(paramf.aSV(), paramf.field_username)), com.tencent.mm.cd.a.br(this.context, R.f.NormalTextSize));
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        paramb.afaS.setText((CharSequence)localObject2);
        ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).setTextWithStatus(paramb.afaS, paramf.field_username, com.tencent.mm.plugin.textstatus.a.a.b.ThE);
        AppMethodBeat.o(37581);
        return;
        paramb.afaS.bc(null, 0, 0);
        break;
        paramb.afaS.bc(null, 0, 0);
        break;
        if (!paramb.afaS.adWm) {
          break label127;
        }
        paramb.afaS.setDrawRightDrawable(false);
      }
      catch (Exception localException)
      {
        localCharSequence = null;
        continue;
      }
      label274:
      paramb.afaS.setText(localCharSequence);
    }
  }
  
  protected final String bBG(String paramString)
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
  
  public final ArrayList<com.tencent.mm.storage.f> ce(ArrayList<String> paramArrayList)
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
    bh.bCz();
    localObject = c.bzA().mP((List)localObject);
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
      localf.convertFrom((Cursor)localObject);
      paramArrayList.add(localf);
    }
    ((Cursor)localObject).close();
    Log.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37589);
    return paramArrayList;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(37573);
    if (this.pSE != null)
    {
      this.pSE.detach();
      this.pSE = null;
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
    paramViewGroup = (Context)this.qLs.get();
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(37579);
      return paramView;
    }
    int i;
    if (!this.afaK)
    {
      i = 0;
      while (i < 8)
      {
        this.afaJ.add(af.mU(paramViewGroup).inflate(R.i.gea, null));
        i += 1;
      }
      this.afaK = true;
    }
    com.tencent.mm.storage.f localf = (com.tencent.mm.storage.f)azn(paramInt);
    Object localObject1;
    label388:
    Object localObject2;
    label425:
    label564:
    Activity localActivity;
    if (paramView == null) {
      if (this.afaJ.size() > 0)
      {
        paramView = (View)this.afaJ.getFirst();
        this.afaJ.removeFirst();
        paramViewGroup = new b();
        paramViewGroup.JMf = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
        paramViewGroup.JMg = ((TextView)paramView.findViewById(R.h.fDt));
        paramViewGroup.afaS = ((NoMeasuredTextView)paramView.findViewById(R.h.fOW));
        paramViewGroup.afaS.setLayoutCallback(this.afaM);
        paramViewGroup.afaS.setTextSize(0, com.tencent.mm.cd.a.br(this.context, R.f.NormalTextSize));
        paramViewGroup.afaS.setShouldEllipsize(true);
        if (paramViewGroup.afaS.getPaint() != null) {
          aw.a(paramViewGroup.afaS.getPaint(), 0.1F);
        }
        paramViewGroup.afaS.setTextColor(com.tencent.mm.cd.a.l(this.context, R.e.normal_text_color));
        paramViewGroup.afaS.setGravity(16);
        paramViewGroup.lKK = ((ImageView)paramView.findViewById(R.h.fqJ));
        paramViewGroup.afaT = ((TextView)paramView.findViewById(R.h.fDk));
        paramViewGroup.afaU = paramView.findViewById(R.h.fDs);
        paramViewGroup.pJK = ((TextView)paramView.findViewById(R.h.openim_contact_desc));
        paramViewGroup.afaV = ((CategoryTipView)paramView.findViewById(R.h.fDn));
        paramViewGroup.afaW = ((ViewGroup)paramView.findViewById(R.h.fDm));
        localObject1 = paramViewGroup.afaU.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cd.a.bs(this.context, R.f.ContactListHeight) * com.tencent.mm.cd.a.mo(this.context)));
        paramViewGroup.afaU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramView.setTag(paramViewGroup);
        if (localf != null)
        {
          localObject2 = (com.tencent.mm.storage.f)azn(paramInt - 1);
          localObject1 = (com.tencent.mm.storage.f)azn(paramInt + 1);
          if (localObject2 != null) {
            break label791;
          }
          i = -1;
          int j = a(localf, paramInt);
          if (localObject1 != null) {
            a((com.tencent.mm.storage.f)localObject1, paramInt + 1);
          }
          paramViewGroup.afaV.setTag(Integer.valueOf(j));
          if ((!this.afaE) || (paramInt < 0) || (j == i)) {
            break label805;
          }
          localObject2 = b(localf, paramInt);
          if (Util.isNullOrNil((String)localObject2)) {
            break label805;
          }
          paramViewGroup.afaW.setVisibility(0);
          paramViewGroup.JMf.setVisibility(0);
          paramViewGroup.JMf.setText((CharSequence)localObject2);
          paramViewGroup.afaV.aDs(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().huM());
          label547:
          localObject2 = b(localf, paramInt);
          if (localObject1 != null) {
            break label835;
          }
          localObject1 = null;
          paramInt = paramViewGroup.afaU.getPaddingLeft();
          localActivity = (Activity)this.qLs.get();
          if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
            break label849;
          }
          paramViewGroup.afaS.setBackground(null);
          paramViewGroup.afaU.setBackground(bd.by(localActivity, R.d.list_item_divider));
        }
      }
    }
    for (;;)
    {
      paramViewGroup.afaU.setPadding(paramInt, 0, 0, 0);
      com.tencent.mm.pluginsdk.ui.a.b.g(paramViewGroup.lKK, localf.field_username);
      b(localf, paramViewGroup);
      a(localf, paramViewGroup);
      com.tencent.mm.plugin.sns.ui.e.a.b(0, (String)paramViewGroup.lKK.getTag(), (AvatarImageView)paramViewGroup.lKK);
      ((AvatarImageView)paramViewGroup.lKK).hj(localf.field_username, 0);
      ((AvatarImageView)paramViewGroup.lKK).setTag(localf.field_username);
      com.tencent.mm.plugin.sns.ui.e.a.a(0, localf.field_username, (AvatarImageView)paramViewGroup.lKK);
      ((AvatarImageView)paramViewGroup.lKK).setShowStoryHint(com.tencent.mm.plugin.sns.easteregg.a.aXK(localf.field_username));
      paramViewGroup.lKK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37566);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.d("MicroMsg.AddressAdapter", "click avatarIv");
          if (paramAnonymousView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37566);
            return;
          }
          a.this.vzf.performItemClick(paramAnonymousView, a.this.vzg.eB(paramAnonymousView), R.h.fqJ);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37566);
        }
      });
      AppMethodBeat.o(37579);
      return paramView;
      paramView = View.inflate(paramViewGroup, R.i.gea, null);
      break;
      paramViewGroup = (b)paramView.getTag();
      break label388;
      label791:
      i = a((com.tencent.mm.storage.f)localObject2, paramInt - 1);
      break label425;
      label805:
      paramViewGroup.afaW.setVisibility(8);
      paramViewGroup.JMf.setVisibility(8);
      paramViewGroup.afaV.setVisibility(8);
      break label547;
      label835:
      localObject1 = b((com.tencent.mm.storage.f)localObject1, paramInt + 1);
      break label564;
      label849:
      paramViewGroup.afaS.setBackground(bd.by(localActivity, R.d.list_item_divider));
      paramViewGroup.afaU.setBackground(null);
    }
  }
  
  public final void iZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(37569);
    if (paramInt == 5) {
      this.afaP.add(paramString);
    }
    super.v(paramString, paramInt);
    AppMethodBeat.o(37569);
  }
  
  public final d<String> jhR()
  {
    AppMethodBeat.i(37588);
    d locald = (d)jxV();
    AppMethodBeat.o(37588);
    return locald;
  }
  
  protected Cursor jxV()
  {
    AppMethodBeat.i(37576);
    long l = System.currentTimeMillis();
    final LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("weixin");
    bh.bCz();
    Cursor localCursor = c.bzA().a(this.afau, this.afav, this.lMF, localLinkedList, jxU(), this.afaG);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252925);
        bh.bCz();
        Cursor localCursor = c.bzA().a(a.this.afau, a.this.afav, a.this.lMF, localLinkedList, a.e(a.this), a.f(a.this));
        if (localCursor != null)
        {
          try
          {
            if (!(localCursor instanceof com.tencent.mm.storagebase.a.e)) {
              break label214;
            }
            ArrayList localArrayList = new ArrayList();
            d locald = ((com.tencent.mm.storagebase.a.e)localCursor).adnX[0];
            int i = locald.getPosition();
            if (locald != null)
            {
              while (locald.moveToNext())
              {
                com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
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
            AppMethodBeat.o(252925);
          }
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().ld(localList);
        }
        label214:
        if (localCursor != null)
        {
          localCursor.close();
          AppMethodBeat.o(252925);
          return;
        }
        AppMethodBeat.o(252925);
      }
    });
    Log.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37576);
    return localCursor;
  }
  
  protected final void jxW()
  {
    AppMethodBeat.i(37577);
    int k = getCount();
    if (k == 0)
    {
      AppMethodBeat.o(37577);
      return;
    }
    this.afaD = jhQ();
    if (this.aeaP != null)
    {
      this.afaz = ab.a(this.afau, this.afav, this.lMF, this.aeaP);
      this.afaA = ab.a(this.afau, this.afav, this.aeaP, this.lMF);
    }
    for (;;)
    {
      this.afaC.clear();
      if (this.afaz == null) {
        break;
      }
      Object localObject1 = this.afaz;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        k = localObject1[i];
        this.afaC.add(Integer.valueOf(k - 1));
        i += 1;
      }
      long l;
      if (jdV())
      {
        l = System.currentTimeMillis();
        localObject1 = new HashSet();
        this.afaz = new int[30];
        this.afaA = new String[30];
        j = this.afaD;
        i = 0;
        if (j < k)
        {
          Object localObject2 = (com.tencent.mm.storage.f)azn(j);
          if (localObject2 != null)
          {
            localObject2 = b((com.tencent.mm.storage.f)localObject2, j);
            if (!((HashSet)localObject1).add(localObject2)) {
              break label268;
            }
            this.afaz[i] = (j - this.afaD);
            this.afaA[i] = localObject2;
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
        Log.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - l) + "favourCount : " + this.afaD);
      }
      else
      {
        l = System.currentTimeMillis();
        this.afaz = ab.a(null, this.afau, this.afav, this.lMF, this.pRp);
        this.afaA = ab.a(null, this.afau, this.afav, this.pRp, this.lMF);
        Log.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - l));
      }
    }
    AppMethodBeat.o(37577);
  }
  
  public final void jxX()
  {
    AppMethodBeat.i(37578);
    this.vzi.fSn();
    AppMethodBeat.o(37578);
  }
  
  public final void jxY()
  {
    AppMethodBeat.i(37591);
    super.v(null, 1);
    AppMethodBeat.o(37591);
  }
  
  public final void nM(List<String> paramList)
  {
    AppMethodBeat.i(37574);
    if (this.type != 2) {
      paramList.add(z.bAM());
    }
    bh.bCz();
    Object localObject = c.bzJ().aMh("@t.qq.com");
    if (localObject != null) {
      paramList.add(((cm)localObject).name);
    }
    if ((this.type == 3) || (this.type == 5) || (this.type == 4) || (this.type == 1) || (this.type == 0))
    {
      localObject = ab.bBO().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add((String)((Iterator)localObject).next());
      }
    }
    paramList.add("blogapp");
    this.lMF = paramList;
    AppMethodBeat.o(37574);
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(37571);
    this.afaI = z.bAM();
    if (this.afaz == null) {
      jxW();
    }
    if (getCount() == 0)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(37571);
      return;
    }
    this.afaD = jhQ();
    Log.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[] { Integer.valueOf(this.afaD) });
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
    bh.bCz();
    if (paramMStorageEx == c.bzA()) {
      if ((!au.bxa((String)paramObject)) && (!this.afaP.contains((String)paramObject)))
      {
        super.v((String)paramObject, 2);
        if ((this.afaH) && (this.afaB != null))
        {
          this.afaB.afbq = true;
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
    this.afaP.clear();
    super.pause();
    AppMethodBeat.o(37570);
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.afaB = ((AddressUI.AddressUIFragment)paramFragment);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.vzg = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.vzf = paramg;
  }
  
  public static abstract interface a {}
  
  protected static final class b
  {
    public TextView JMf;
    public TextView JMg;
    public NoMeasuredTextView afaS;
    public TextView afaT;
    public View afaU;
    public CategoryTipView afaV;
    public ViewGroup afaW;
    public ImageView lKK;
    public TextView pJK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a
 * JD-Core Version:    0.7.0.1
 */
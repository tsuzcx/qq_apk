package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.AddressView.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class a
  extends com.tencent.mm.ui.f<String, com.tencent.mm.storage.f>
  implements n.b
{
  public static final ColorStateList tUu;
  public static final ColorStateList tUv;
  private String[] HGx;
  boolean IsA;
  HashMap<View, ViewStub> IsB;
  private SparseArray<String> IsC;
  private SparseArray<Integer> IsD;
  private HashSet<String> IsE;
  public HashMap<String, com.tencent.mm.storage.f> Isj;
  protected String Isk;
  protected String Isl;
  private List<Object> Ism;
  private List<String> Isn;
  private int Iso;
  protected int[] Isp;
  String[] Isq;
  protected AddressUI.AddressUIFragment Isr;
  private Set<Integer> Iss;
  private int Ist;
  private boolean Isu;
  a Isv;
  private boolean Isw;
  boolean Isx;
  private String Isy;
  LinkedList<View> Isz;
  View.OnClickListener cBW;
  protected List<String> fzw;
  private String iJd;
  private com.tencent.mm.ui.applet.b iKs;
  private WeakReference<Context> jrI;
  protected MMSlideDelView.g ntA;
  protected MMSlideDelView.c ntB;
  protected MMSlideDelView.d ntD;
  private boolean nwB;
  StringBuilder sb;
  private int type;
  protected MMSlideDelView.f vkp;
  
  static
  {
    AppMethodBeat.i(37596);
    tUu = com.tencent.mm.cc.a.m(com.tencent.mm.sdk.platformtools.ai.getContext(), 2131100638);
    tUv = com.tencent.mm.cc.a.m(com.tencent.mm.sdk.platformtools.ai.getContext(), 2131100490);
    AppMethodBeat.o(37596);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(37572);
    this.Isk = null;
    this.Isl = null;
    this.fzw = null;
    this.Iso = 0;
    this.iJd = "";
    this.HGx = null;
    this.ntD = MMSlideDelView.getItemStatusCallBack();
    this.Iss = new HashSet();
    this.Ist = 0;
    this.Isu = true;
    this.iKs = null;
    this.nwB = false;
    this.Isw = false;
    this.Isx = false;
    this.Isz = new LinkedList();
    this.IsB = new HashMap();
    this.cBW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37568);
        ac.v("MicroMsg.AddressAdapter", "on delView clicked");
        a.this.ntD.cVs();
        if (a.this.vkp != null) {
          a.this.vkp.cN(((ViewStub)a.f(a.this).get(paramAnonymousView)).getTag());
        }
        AppMethodBeat.o(37568);
      }
    };
    this.sb = new StringBuilder(32);
    this.IsC = new SparseArray();
    this.IsD = new SparseArray();
    this.IsE = new HashSet();
    this.Isj = new HashMap();
    this.jrI = new WeakReference(paramContext);
    this.context = com.tencent.mm.sdk.platformtools.ai.getContext();
    this.Isk = paramString1;
    this.Isl = paramString2;
    this.type = paramInt;
    this.Isw = true;
    this.Ism = new LinkedList();
    this.Isn = new LinkedList();
    this.Isy = u.axw();
    this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    AppMethodBeat.o(37572);
  }
  
  private boolean fqM()
  {
    AppMethodBeat.i(37575);
    if ((this.Isk.equals("@micromsg.qq.com")) || (this.Isk.equals("@all.contact.without.chatroom")) || (this.Isk.equals("@all.contact.without.chatroom.without.openim")))
    {
      AppMethodBeat.o(37575);
      return true;
    }
    AppMethodBeat.o(37575);
    return false;
  }
  
  public static String getDisplayName(String paramString1, String paramString2)
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
    String str2 = (String)this.IsC.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = this.context.getString(paramInt);
      this.IsC.put(paramInt, str1);
    }
    AppMethodBeat.o(37587);
    return str1;
  }
  
  protected int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37584);
    if (paramInt < this.Ist)
    {
      AppMethodBeat.o(37584);
      return 32;
    }
    if (paramf == null)
    {
      ac.e("MicroMsg.AddressAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(37584);
      return -1;
    }
    paramInt = paramf.field_showHead;
    AppMethodBeat.o(37584);
    return paramInt;
  }
  
  public void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(37592);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(37592);
      return;
    }
    az.ayM();
    if (paramn == c.awB()) {
      if ((!w.wF((String)paramObject)) && (!this.IsE.contains((String)paramObject)))
      {
        super.m((String)paramObject, 2);
        if ((this.Isx) && (this.Isr != null))
        {
          this.Isr.Ith = true;
          ac.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
          AppMethodBeat.o(37592);
        }
      }
      else
      {
        ac.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
      }
    }
    AppMethodBeat.o(37592);
  }
  
  protected void a(com.tencent.mm.storage.f paramf, b paramb)
  {
    AppMethodBeat.i(37580);
    try
    {
      paramb.iCh.setText(null);
      paramb.iCh.setVisibility(8);
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
    this.vkp = paramf;
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.f>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(37590);
    paramHashSet = new SparseArray[paramArrayOfSparseArray.length];
    paramArrayOfSparseArray = new LinkedList();
    paramArrayOfSparseArray.add("weixin");
    long l = System.currentTimeMillis();
    az.ayM();
    paramArrayOfSparseArray = c.awB().b(this.Isk, this.Isl, this.fzw, paramArrayOfSparseArray, fqM(), this.Isw);
    int i;
    if ((paramArrayOfSparseArray instanceof com.tencent.mm.storagebase.a.e))
    {
      com.tencent.mm.storagebase.a.d[] arrayOfd = ((com.tencent.mm.storagebase.a.e)paramArrayOfSparseArray).Hcf;
      int k = arrayOfd.length;
      i = 0;
      while (i < k)
      {
        arrayOfd[i].Zb(5000);
        paramHashSet[i] = new SparseArray();
        int j = 0;
        while (arrayOfd[i].moveToNext())
        {
          paramHashSet[i].put(j, arrayOfd[i].getString(0));
          j += 1;
        }
        i += 1;
      }
      this.Ist = arrayOfd[0].getCount();
    }
    for (;;)
    {
      paramArrayOfSparseArray.close();
      ac.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - l));
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
  
  protected final String aQP(String paramString)
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
  
  public final ArrayList<com.tencent.mm.storage.f> aY(ArrayList<String> paramArrayList)
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
    az.ayM();
    localObject = c.awB().hk((List)localObject);
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
      localf.convertFrom((Cursor)localObject);
      paramArrayList.add(localf);
    }
    ((Cursor)localObject).close();
    ac.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37589);
    return paramArrayList;
  }
  
  protected String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37585);
    if (paramInt < this.Ist)
    {
      paramf = getString(2131755197);
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
      paramf = getString(2131755174);
      AppMethodBeat.o(37585);
      return paramf;
    }
    if (paramf.field_showHead == 43)
    {
      paramf = getString(2131762623);
      AppMethodBeat.o(37585);
      return paramf;
    }
    if (paramf.field_showHead == 32)
    {
      paramf = getString(2131755197);
      AppMethodBeat.o(37585);
      return paramf;
    }
    String str = (String)this.IsC.get(paramf.field_showHead);
    if (str != null)
    {
      AppMethodBeat.o(37585);
      return str;
    }
    str = String.valueOf((char)paramf.field_showHead);
    this.IsC.put(paramf.field_showHead, str);
    AppMethodBeat.o(37585);
    return str;
  }
  
  protected void b(final com.tencent.mm.storage.f paramf, final b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(37581);
    paramb.tUz.updateTextColors();
    if (com.tencent.mm.storage.ai.aNc(paramf.field_username)) {
      paramb.tUz.setMergeCallback(new AddressView.a()
      {
        public final CharSequence Zh(int paramAnonymousInt)
        {
          AppMethodBeat.i(37567);
          Object localObject3 = paramf.GBP;
          if (localObject3 == null)
          {
            try
            {
              localObject1 = paramf.aaS();
              localObject3 = paramf.field_descWordingId;
              localObject3 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bB(paramf.field_openImAppid, (String)localObject3);
              if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
                break label442;
              }
              localObject3 = "@".concat(String.valueOf(localObject3));
              int i = com.tencent.mm.cc.a.au(a.a(a.this), 2131165257);
              localObject4 = new TextView(a.b(a.this));
              ((TextView)localObject4).getPaint().setTextSize(i);
              f = ((TextView)localObject4).getPaint().measureText(" ".concat(String.valueOf(localObject3)));
              ((TextView)localObject4).getPaint().setTextSize(paramb.tUz.getNickNameSize());
              if (f < paramAnonymousInt * 0.6D) {
                break label420;
              }
              localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject4).getPaint(), (float)(paramAnonymousInt * 0.4D), TextUtils.TruncateAt.END);
              f = ((TextView)localObject4).getPaint().measureText(((CharSequence)localObject1).toString());
              ((TextView)localObject4).getPaint().setTextSize(i);
              localObject3 = TextUtils.ellipsize((CharSequence)localObject3, ((TextView)localObject4).getPaint(), paramAnonymousInt - f - 20.0F, TextUtils.TruncateAt.END);
              localObject4 = com.tencent.mm.pluginsdk.ui.span.k.c(a.c(a.this), localObject1 + " " + localObject3);
              ColorStateList localColorStateList = com.tencent.mm.cc.a.m(a.d(a.this), 2131100528);
              ((SpannableString)localObject4).setSpan(new TextAppearanceSpan(null, 0, i, localColorStateList, localColorStateList), ((CharSequence)localObject1).length() + 1, ((CharSequence)localObject1).length() + 1 + ((CharSequence)localObject3).length(), 33);
              ((SpannableString)localObject4).setSpan(new com.tencent.mm.cg.a(i), ((CharSequence)localObject1).length() + 1, ((CharSequence)localObject1).length() + 1 + ((CharSequence)localObject3).length(), 33);
              localObject1 = localObject4;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Object localObject1;
                Object localObject4;
                float f;
                label387:
                localObject2 = null;
              }
            }
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = "";
            }
            paramb.tUz.setName((CharSequence)localObject3);
          }
          for (;;)
          {
            AppMethodBeat.o(37567);
            return localObject3;
            label420:
            localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject4).getPaint(), paramAnonymousInt - f, TextUtils.TruncateAt.END);
            break;
            label442:
            localObject1 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).e(com.tencent.mm.sdk.platformtools.ai.getContext(), (String)localObject1, com.tencent.mm.cc.a.au(a.e(a.this), 2131165517));
            break label387;
            Object localObject2;
            paramb.tUz.setName((CharSequence)localObject3);
          }
        }
      });
    }
    for (;;)
    {
      paramb.tUz.setDescription(bs.nullAsNil(paramf.field_remarkDesc));
      AppMethodBeat.o(37581);
      return;
      paramb.tUz.setMergeCallback(null);
      Object localObject2 = paramf.GBP;
      if (localObject2 == null) {}
      try
      {
        localObject2 = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, aQP(getDisplayName(paramf.aaS(), paramf.field_username)), com.tencent.mm.cc.a.au(this.context, 2131165517));
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        label119:
        break label119;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      paramb.tUz.setName((CharSequence)localObject2);
      continue;
      paramb.tUz.setName((CharSequence)localObject2);
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(37573);
    if (this.iKs != null)
    {
      this.iKs.detach();
      this.iKs = null;
    }
    AppMethodBeat.o(37573);
  }
  
  public final com.tencent.mm.storagebase.a.d<String> ffb()
  {
    AppMethodBeat.i(37588);
    com.tencent.mm.storagebase.a.d locald = (com.tencent.mm.storagebase.a.d)fqN();
    AppMethodBeat.o(37588);
    return locald;
  }
  
  protected Cursor fqN()
  {
    AppMethodBeat.i(37576);
    long l = System.currentTimeMillis();
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("weixin");
    az.ayM();
    Cursor localCursor = c.awB().a(this.Isk, this.Isl, this.fzw, localLinkedList, fqM(), this.Isw);
    h.JZN.aS(new a.4(this, localLinkedList));
    ac.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37576);
    return localCursor;
  }
  
  protected final void fqO()
  {
    AppMethodBeat.i(37577);
    int k = getCount();
    if (k == 0)
    {
      AppMethodBeat.o(37577);
      return;
    }
    this.Ist = ffa();
    if (this.HGx != null)
    {
      this.Isp = w.a(this.Isk, this.Isl, this.fzw, this.HGx);
      this.Isq = w.a(this.Isk, this.Isl, this.HGx, this.fzw);
    }
    for (;;)
    {
      this.Iss.clear();
      if (this.Isp == null) {
        break;
      }
      Object localObject1 = this.Isp;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        k = localObject1[i];
        this.Iss.add(Integer.valueOf(k - 1));
        i += 1;
      }
      long l;
      if (fdB())
      {
        l = System.currentTimeMillis();
        localObject1 = new HashSet();
        this.Isp = new int[30];
        this.Isq = new String[30];
        j = this.Ist;
        i = 0;
        if (j < k)
        {
          Object localObject2 = (com.tencent.mm.storage.f)Za(j);
          if (localObject2 != null)
          {
            localObject2 = b((com.tencent.mm.storage.f)localObject2, j);
            if (!((HashSet)localObject1).add(localObject2)) {
              break label268;
            }
            this.Isp[i] = (j - this.Ist);
            this.Isq[i] = localObject2;
            i += 1;
          }
          label268:
          for (;;)
          {
            j += 1;
            break;
            ac.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
          }
        }
        ac.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - l) + "favourCount : " + this.Ist);
      }
      else
      {
        l = System.currentTimeMillis();
        this.Isp = w.a(null, this.Isk, this.Isl, this.fzw, this.iJd);
        this.Isq = w.a(null, this.Isk, this.Isl, this.iJd, this.fzw);
        ac.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - l));
      }
    }
    AppMethodBeat.o(37577);
  }
  
  public final void fqP()
  {
    AppMethodBeat.i(37578);
    this.ntD.cVs();
    AppMethodBeat.o(37578);
  }
  
  public final void fqQ()
  {
    AppMethodBeat.i(37591);
    super.m(null, 1);
    AppMethodBeat.o(37591);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(37586);
    int i = super.getCount();
    AppMethodBeat.o(37586);
    return i;
  }
  
  public final int getPositionForSection(int paramInt)
  {
    int i = paramInt;
    if (this.Isp != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.Isp.length) {
          i = this.Isp[paramInt];
        }
      }
    }
    return this.Ist + i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37579);
    paramViewGroup = (Context)this.jrI.get();
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(37579);
      return paramView;
    }
    int i;
    if (!this.IsA)
    {
      i = 0;
      while (i < 8)
      {
        this.Isz.add(z.jD(paramViewGroup).inflate(2131492951, null));
        i += 1;
      }
      this.IsA = true;
    }
    Object localObject2 = (com.tencent.mm.storage.f)Za(paramInt);
    label322:
    Object localObject3;
    label359:
    label498:
    Activity localActivity;
    if (paramView == null) {
      if (this.Isz.size() > 0)
      {
        paramView = (View)this.Isz.getFirst();
        this.Isz.removeFirst();
        paramViewGroup = new b();
        paramViewGroup.tNT = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.tNU = ((TextView)paramView.findViewById(2131298734));
        paramViewGroup.tUz = ((AddressView)paramView.findViewById(2131302653));
        paramViewGroup.fxQ = ((ImageView)paramView.findViewById(2131296484));
        paramViewGroup.IsI = ((TextView)paramView.findViewById(2131298720));
        paramViewGroup.IsJ = paramView.findViewById(2131298733);
        paramViewGroup.iCh = ((TextView)paramView.findViewById(2131303032));
        paramViewGroup.IsK = ((CategoryTipView)paramView.findViewById(2131298726));
        paramViewGroup.IsL = ((ViewGroup)paramView.findViewById(2131298723));
        localObject1 = paramViewGroup.IsJ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cc.a.av(this.context, 2131165242) * com.tencent.mm.cc.a.ic(this.context)));
        paramViewGroup.IsJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (this.Isr != null) {
          this.Isr.ftW.a(paramViewGroup.tUz);
        }
        paramView.setTag(paramViewGroup);
        if (localObject2 != null)
        {
          localObject3 = (com.tencent.mm.storage.f)Za(paramInt - 1);
          localObject1 = (com.tencent.mm.storage.f)Za(paramInt + 1);
          if (localObject3 != null) {
            break label809;
          }
          i = -1;
          int j = a((com.tencent.mm.storage.f)localObject2, paramInt);
          if (localObject1 != null) {
            a((com.tencent.mm.storage.f)localObject1, paramInt + 1);
          }
          paramViewGroup.IsK.setTag(Integer.valueOf(j));
          if ((!this.Isu) || (paramInt < 0) || (j == i)) {
            break label823;
          }
          localObject3 = b((com.tencent.mm.storage.f)localObject2, paramInt);
          if (bs.isNullOrNil((String)localObject3)) {
            break label823;
          }
          paramViewGroup.IsL.setVisibility(0);
          paramViewGroup.tNT.setVisibility(0);
          paramViewGroup.tNT.setText((CharSequence)localObject3);
          paramViewGroup.IsK.abP(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().dUD());
          label481:
          localObject3 = b((com.tencent.mm.storage.f)localObject2, paramInt);
          if (localObject1 != null) {
            break label853;
          }
          localObject1 = null;
          paramInt = paramViewGroup.IsJ.getPaddingLeft();
          localActivity = (Activity)this.jrI.get();
          if ((localObject3 == null) || (((String)localObject3).equals(localObject1))) {
            break label867;
          }
          paramViewGroup.tUz.setBackground(null);
          paramViewGroup.IsJ.setBackground(ao.aI(localActivity, 2130969245));
          label556:
          paramViewGroup.IsJ.setPadding(paramInt, 0, 0, 0);
          com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.fxQ, ((com.tencent.mm.storage.f)localObject2).field_username);
          if (((com.tencent.mm.storage.f)localObject2).field_verifyFlag == 0) {
            break label915;
          }
          if (ar.a.hny == null) {
            break label904;
          }
          localObject1 = ar.a.hny.nS(((com.tencent.mm.storage.f)localObject2).field_verifyFlag);
          if (localObject1 == null) {
            break label893;
          }
          localObject1 = com.tencent.mm.al.n.Bh((String)localObject1);
          paramViewGroup.tUz.setMaskBitmap((Bitmap)localObject1);
          label629:
          b((com.tencent.mm.storage.f)localObject2, paramViewGroup);
          a((com.tencent.mm.storage.f)localObject2, paramViewGroup);
          com.tencent.mm.plugin.sns.ui.e.a.b(0, (String)paramViewGroup.fxQ.getTag(), (AvatarImageView)paramViewGroup.fxQ);
          ((AvatarImageView)paramViewGroup.fxQ).eM(((com.tencent.mm.storage.f)localObject2).field_username, 0);
          ((AvatarImageView)paramViewGroup.fxQ).setTag(((com.tencent.mm.storage.f)localObject2).field_username);
          com.tencent.mm.plugin.sns.ui.e.a.a(0, ((com.tencent.mm.storage.f)localObject2).field_username, (AvatarImageView)paramViewGroup.fxQ);
          ((AvatarImageView)paramViewGroup.fxQ).setShowStoryHint(com.tencent.mm.plugin.sns.f.a.atk(((com.tencent.mm.storage.f)localObject2).field_username));
        }
        paramViewGroup.tUz.updatePositionFlag();
        localObject2 = paramViewGroup.tUz;
        if (paramViewGroup.tUz.getNickName() != null) {
          break label926;
        }
      }
    }
    label904:
    label915:
    label926:
    for (Object localObject1 = "";; localObject1 = paramViewGroup.tUz.getNickName().toString())
    {
      ((AddressView)localObject2).setContentDescription((CharSequence)localObject1);
      paramViewGroup.fxQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37566);
          ac.d("MicroMsg.AddressAdapter", "click avatarIv");
          if (paramAnonymousView == null)
          {
            AppMethodBeat.o(37566);
            return;
          }
          a.this.ntA.s(paramAnonymousView, a.this.ntB.dy(paramAnonymousView), 2131296484);
          AppMethodBeat.o(37566);
        }
      });
      AppMethodBeat.o(37579);
      return paramView;
      paramView = View.inflate(paramViewGroup, 2131492951, null);
      break;
      paramViewGroup = (b)paramView.getTag();
      break label322;
      label809:
      i = a((com.tencent.mm.storage.f)localObject3, paramInt - 1);
      break label359;
      label823:
      paramViewGroup.IsL.setVisibility(8);
      paramViewGroup.tNT.setVisibility(8);
      paramViewGroup.IsK.setVisibility(8);
      break label481;
      label853:
      localObject1 = b((com.tencent.mm.storage.f)localObject1, paramInt + 1);
      break label498;
      label867:
      paramViewGroup.tUz.setBackground(ao.aI(localActivity, 2130969245));
      paramViewGroup.IsJ.setBackground(null);
      break label556;
      label893:
      paramViewGroup.tUz.setMaskBitmap(null);
      break label629;
      paramViewGroup.tUz.setMaskBitmap(null);
      break label629;
      paramViewGroup.tUz.setMaskBitmap(null);
      break label629;
    }
  }
  
  public final void gj(String paramString, int paramInt)
  {
    AppMethodBeat.i(37569);
    if (paramInt == 5) {
      this.IsE.add(paramString);
    }
    super.m(paramString, paramInt);
    AppMethodBeat.o(37569);
  }
  
  public final void ic(List<String> paramList)
  {
    AppMethodBeat.i(37574);
    if (this.type != 2) {
      paramList.add(u.axw());
    }
    az.ayM();
    Object localObject = c.awJ().alJ("@t.qq.com");
    if (localObject != null) {
      paramList.add(((bu)localObject).name);
    }
    if ((this.type == 3) || (this.type == 5) || (this.type == 4) || (this.type == 1) || (this.type == 0))
    {
      localObject = w.ayh().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add((String)((Iterator)localObject).next());
      }
    }
    paramList.add("blogapp");
    this.fzw = paramList;
    AppMethodBeat.o(37574);
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(37571);
    this.Isy = u.axw();
    if (this.Isp == null) {
      fqO();
    }
    if (getCount() == 0)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(37571);
      return;
    }
    this.Ist = ffa();
    ac.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[] { Integer.valueOf(this.Ist) });
    super.notifyDataSetChanged();
    AppMethodBeat.o(37571);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(37570);
    this.IsE.clear();
    super.pause();
    AppMethodBeat.o(37570);
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.Isr = ((AddressUI.AddressUIFragment)paramFragment);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.ntB = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.ntA = paramg;
  }
  
  public static abstract interface a {}
  
  protected static final class b
  {
    public TextView IsI;
    public View IsJ;
    public CategoryTipView IsK;
    public ViewGroup IsL;
    public ImageView fxQ;
    public TextView iCh;
    public TextView tNT;
    public TextView tNU;
    public AddressView tUz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a
 * JD-Core Version:    0.7.0.1
 */
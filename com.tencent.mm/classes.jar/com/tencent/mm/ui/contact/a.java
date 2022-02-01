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
import com.tencent.mm.am.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.a.d;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.AddressView.a;
import com.tencent.mm.ui.aq;
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
  public static final ColorStateList uWW;
  public static final ColorStateList uWX;
  private String[] Juo;
  public HashMap<String, com.tencent.mm.storage.f> KiO;
  protected String KiP;
  protected String KiQ;
  private List<Object> KiR;
  private List<String> KiS;
  private int KiT;
  protected int[] KiU;
  String[] KiV;
  protected AddressUI.AddressUIFragment KiW;
  private Set<Integer> KiX;
  private int KiY;
  private boolean KiZ;
  a Kja;
  private boolean Kjb;
  boolean Kjc;
  private String Kjd;
  LinkedList<View> Kje;
  boolean Kjf;
  HashMap<View, ViewStub> Kjg;
  private SparseArray<String> Kjh;
  private SparseArray<Integer> Kji;
  private HashSet<String> Kjj;
  View.OnClickListener cMV;
  protected List<String> fSL;
  private WeakReference<Context> jLC;
  private String jcm;
  private com.tencent.mm.ui.applet.b jdB;
  protected MMSlideDelView.g nUw;
  protected MMSlideDelView.c nUx;
  protected MMSlideDelView.d nUz;
  private boolean nXZ;
  StringBuilder sb;
  private int type;
  protected MMSlideDelView.f wpH;
  
  static
  {
    AppMethodBeat.i(37596);
    uWW = com.tencent.mm.cc.a.m(aj.getContext(), 2131100638);
    uWX = com.tencent.mm.cc.a.m(aj.getContext(), 2131100490);
    AppMethodBeat.o(37596);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(37572);
    this.KiP = null;
    this.KiQ = null;
    this.fSL = null;
    this.KiT = 0;
    this.jcm = "";
    this.Juo = null;
    this.nUz = MMSlideDelView.getItemStatusCallBack();
    this.KiX = new HashSet();
    this.KiY = 0;
    this.KiZ = true;
    this.jdB = null;
    this.nXZ = false;
    this.Kjb = false;
    this.Kjc = false;
    this.Kje = new LinkedList();
    this.Kjg = new HashMap();
    this.cMV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37568);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.v("MicroMsg.AddressAdapter", "on delView clicked");
        a.this.nUz.deD();
        if (a.this.wpH != null) {
          a.this.wpH.cP(((ViewStub)a.f(a.this).get(paramAnonymousView)).getTag());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37568);
      }
    };
    this.sb = new StringBuilder(32);
    this.Kjh = new SparseArray();
    this.Kji = new SparseArray();
    this.Kjj = new HashSet();
    this.KiO = new HashMap();
    this.jLC = new WeakReference(paramContext);
    this.context = aj.getContext();
    this.KiP = paramString1;
    this.KiQ = paramString2;
    this.type = paramInt;
    this.Kjb = true;
    this.KiR = new LinkedList();
    this.KiS = new LinkedList();
    this.Kjd = u.aAm();
    this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    AppMethodBeat.o(37572);
  }
  
  private boolean fHz()
  {
    AppMethodBeat.i(37575);
    if ((this.KiP.equals("@micromsg.qq.com")) || (this.KiP.equals("@all.contact.without.chatroom")) || (this.KiP.equals("@all.contact.without.chatroom.without.openim")))
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
    String str2 = (String)this.Kjh.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = this.context.getString(paramInt);
      this.Kjh.put(paramInt, str1);
    }
    AppMethodBeat.o(37587);
    return str1;
  }
  
  protected int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37584);
    if (paramInt < this.KiY)
    {
      AppMethodBeat.o(37584);
      return 32;
    }
    if (paramf == null)
    {
      ad.e("MicroMsg.AddressAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(37584);
      return -1;
    }
    paramInt = paramf.field_showHead;
    AppMethodBeat.o(37584);
    return paramInt;
  }
  
  public void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(37592);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(37592);
      return;
    }
    ba.aBQ();
    if (paramn == c.azp()) {
      if ((!w.zC((String)paramObject)) && (!this.Kjj.contains((String)paramObject)))
      {
        super.n((String)paramObject, 2);
        if ((this.Kjc) && (this.KiW != null))
        {
          this.KiW.KjN = true;
          ad.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
          AppMethodBeat.o(37592);
        }
      }
      else
      {
        ad.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
      }
    }
    AppMethodBeat.o(37592);
  }
  
  protected void a(com.tencent.mm.storage.f paramf, b paramb)
  {
    AppMethodBeat.i(37580);
    try
    {
      paramb.iVr.setText(null);
      paramb.iVr.setVisibility(8);
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
    this.wpH = paramf;
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.f>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(37590);
    paramHashSet = new SparseArray[paramArrayOfSparseArray.length];
    paramArrayOfSparseArray = new LinkedList();
    paramArrayOfSparseArray.add("weixin");
    long l = System.currentTimeMillis();
    ba.aBQ();
    paramArrayOfSparseArray = c.azp().b(this.KiP, this.KiQ, this.fSL, paramArrayOfSparseArray, fHz(), this.Kjb);
    int i;
    if ((paramArrayOfSparseArray instanceof com.tencent.mm.storagebase.a.e))
    {
      d[] arrayOfd = ((com.tencent.mm.storagebase.a.e)paramArrayOfSparseArray).IPv;
      int k = arrayOfd.length;
      i = 0;
      while (i < k)
      {
        arrayOfd[i].abk(5000);
        paramHashSet[i] = new SparseArray();
        int j = 0;
        while (arrayOfd[i].moveToNext())
        {
          paramHashSet[i].put(j, arrayOfd[i].getString(0));
          j += 1;
        }
        i += 1;
      }
      this.KiY = arrayOfd[0].getCount();
    }
    for (;;)
    {
      paramArrayOfSparseArray.close();
      ad.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - l));
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
  
  public final ArrayList<com.tencent.mm.storage.f> aV(ArrayList<String> paramArrayList)
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
    ba.aBQ();
    localObject = c.azp().hw((List)localObject);
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
      localf.convertFrom((Cursor)localObject);
      paramArrayList.add(localf);
    }
    ((Cursor)localObject).close();
    ad.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37589);
    return paramArrayList;
  }
  
  protected final String aWK(String paramString)
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
  
  protected String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37585);
    if (paramInt < this.KiY)
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
    String str = (String)this.Kjh.get(paramf.field_showHead);
    if (str != null)
    {
      AppMethodBeat.o(37585);
      return str;
    }
    str = String.valueOf((char)paramf.field_showHead);
    this.Kjh.put(paramf.field_showHead, str);
    AppMethodBeat.o(37585);
    return str;
  }
  
  protected void b(final com.tencent.mm.storage.f paramf, final b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(37581);
    paramb.uXb.updateTextColors();
    if (am.aSQ(paramf.field_username)) {
      paramb.uXb.setMergeCallback(new AddressView.a()
      {
        public final CharSequence abq(int paramAnonymousInt)
        {
          AppMethodBeat.i(37567);
          Object localObject3 = paramf.InJ;
          if (localObject3 == null)
          {
            try
            {
              localObject1 = paramf.adv();
              localObject3 = paramf.field_descWordingId;
              localObject3 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bC(paramf.field_openImAppid, (String)localObject3);
              if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
                break label442;
              }
              localObject3 = "@".concat(String.valueOf(localObject3));
              int i = com.tencent.mm.cc.a.ax(a.a(a.this), 2131165257);
              localObject4 = new TextView(a.b(a.this));
              ((TextView)localObject4).getPaint().setTextSize(i);
              f = ((TextView)localObject4).getPaint().measureText(" ".concat(String.valueOf(localObject3)));
              ((TextView)localObject4).getPaint().setTextSize(paramb.uXb.getNickNameSize());
              if (f < paramAnonymousInt * 0.6D) {
                break label420;
              }
              localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject4).getPaint(), (float)(paramAnonymousInt * 0.4D), TextUtils.TruncateAt.END);
              f = ((TextView)localObject4).getPaint().measureText(((CharSequence)localObject1).toString());
              ((TextView)localObject4).getPaint().setTextSize(i);
              localObject3 = TextUtils.ellipsize((CharSequence)localObject3, ((TextView)localObject4).getPaint(), paramAnonymousInt - f - 20.0F, TextUtils.TruncateAt.END);
              localObject4 = k.c(a.c(a.this), localObject1 + " " + localObject3);
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
            paramb.uXb.setName((CharSequence)localObject3);
          }
          for (;;)
          {
            AppMethodBeat.o(37567);
            return localObject3;
            label420:
            localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject4).getPaint(), paramAnonymousInt - f, TextUtils.TruncateAt.END);
            break;
            label442:
            localObject1 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).e(aj.getContext(), (String)localObject1, com.tencent.mm.cc.a.ax(a.e(a.this), 2131165517));
            break label387;
            Object localObject2;
            paramb.uXb.setName((CharSequence)localObject3);
          }
        }
      });
    }
    for (;;)
    {
      paramb.uXb.setDescription(bt.nullAsNil(paramf.field_remarkDesc));
      AppMethodBeat.o(37581);
      return;
      paramb.uXb.setMergeCallback(null);
      Object localObject2 = paramf.InJ;
      if (localObject2 == null) {}
      try
      {
        localObject2 = k.b(this.context, aWK(getDisplayName(paramf.adv(), paramf.field_username)), com.tencent.mm.cc.a.ax(this.context, 2131165517));
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
      paramb.uXb.setName((CharSequence)localObject2);
      continue;
      paramb.uXb.setName((CharSequence)localObject2);
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(37573);
    if (this.jdB != null)
    {
      this.jdB.detach();
      this.jdB = null;
    }
    AppMethodBeat.o(37573);
  }
  
  protected Cursor fHA()
  {
    AppMethodBeat.i(37576);
    long l = System.currentTimeMillis();
    final LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("weixin");
    ba.aBQ();
    Cursor localCursor = c.azp().a(this.KiP, this.KiQ, this.fSL, localLinkedList, fHz(), this.Kjb);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194516);
        ba.aBQ();
        Cursor localCursor = c.azp().a(a.this.KiP, a.this.KiQ, a.this.fSL, localLinkedList, a.g(a.this), a.h(a.this));
        if (localCursor != null)
        {
          try
          {
            if (!(localCursor instanceof com.tencent.mm.storagebase.a.e)) {
              break label214;
            }
            ArrayList localArrayList = new ArrayList();
            d locald = ((com.tencent.mm.storagebase.a.e)localCursor).IPv[0];
            int i = locald.getPosition();
            if (locald != null)
            {
              while (locald.moveToNext())
              {
                com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
                localf.convertFrom(locald);
                localArrayList.add(localf.field_username);
                ad.d("MicroMsg.AddressAdapter", "mStarUserList add %s %s", new Object[] { localf.field_username, localf.field_conRemark });
              }
              locald.moveToPosition(i);
            }
          }
          finally
          {
            if (localCursor != null) {
              localCursor.close();
            }
            AppMethodBeat.o(194516);
          }
          ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().gk(localList);
        }
        label214:
        if (localCursor != null)
        {
          localCursor.close();
          AppMethodBeat.o(194516);
          return;
        }
        AppMethodBeat.o(194516);
      }
    });
    ad.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37576);
    return localCursor;
  }
  
  protected final void fHB()
  {
    AppMethodBeat.i(37577);
    int k = getCount();
    if (k == 0)
    {
      AppMethodBeat.o(37577);
      return;
    }
    this.KiY = fvi();
    if (this.Juo != null)
    {
      this.KiU = w.a(this.KiP, this.KiQ, this.fSL, this.Juo);
      this.KiV = w.a(this.KiP, this.KiQ, this.Juo, this.fSL);
    }
    for (;;)
    {
      this.KiX.clear();
      if (this.KiU == null) {
        break;
      }
      Object localObject1 = this.KiU;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        k = localObject1[i];
        this.KiX.add(Integer.valueOf(k - 1));
        i += 1;
      }
      long l;
      if (ftJ())
      {
        l = System.currentTimeMillis();
        localObject1 = new HashSet();
        this.KiU = new int[30];
        this.KiV = new String[30];
        j = this.KiY;
        i = 0;
        if (j < k)
        {
          Object localObject2 = (com.tencent.mm.storage.f)abj(j);
          if (localObject2 != null)
          {
            localObject2 = b((com.tencent.mm.storage.f)localObject2, j);
            if (!((HashSet)localObject1).add(localObject2)) {
              break label268;
            }
            this.KiU[i] = (j - this.KiY);
            this.KiV[i] = localObject2;
            i += 1;
          }
          label268:
          for (;;)
          {
            j += 1;
            break;
            ad.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
          }
        }
        ad.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - l) + "favourCount : " + this.KiY);
      }
      else
      {
        l = System.currentTimeMillis();
        this.KiU = w.a(null, this.KiP, this.KiQ, this.fSL, this.jcm);
        this.KiV = w.a(null, this.KiP, this.KiQ, this.jcm, this.fSL);
        ad.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - l));
      }
    }
    AppMethodBeat.o(37577);
  }
  
  public final void fHC()
  {
    AppMethodBeat.i(37578);
    this.nUz.deD();
    AppMethodBeat.o(37578);
  }
  
  public final void fHD()
  {
    AppMethodBeat.i(37591);
    super.n(null, 1);
    AppMethodBeat.o(37591);
  }
  
  public final d<String> fvj()
  {
    AppMethodBeat.i(37588);
    d locald = (d)fHA();
    AppMethodBeat.o(37588);
    return locald;
  }
  
  public final void gG(String paramString, int paramInt)
  {
    AppMethodBeat.i(37569);
    if (paramInt == 5) {
      this.Kjj.add(paramString);
    }
    super.n(paramString, paramInt);
    AppMethodBeat.o(37569);
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
    if (this.KiU != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.KiU.length) {
          i = this.KiU[paramInt];
        }
      }
    }
    return this.KiY + i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37579);
    paramViewGroup = (Context)this.jLC.get();
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(37579);
      return paramView;
    }
    int i;
    if (!this.Kjf)
    {
      i = 0;
      while (i < 8)
      {
        this.Kje.add(z.jO(paramViewGroup).inflate(2131492951, null));
        i += 1;
      }
      this.Kjf = true;
    }
    Object localObject2 = (com.tencent.mm.storage.f)abj(paramInt);
    label322:
    Object localObject3;
    label359:
    label498:
    Activity localActivity;
    if (paramView == null) {
      if (this.Kje.size() > 0)
      {
        paramView = (View)this.Kje.getFirst();
        this.Kje.removeFirst();
        paramViewGroup = new b();
        paramViewGroup.uQG = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.uQH = ((TextView)paramView.findViewById(2131298734));
        paramViewGroup.uXb = ((AddressView)paramView.findViewById(2131302653));
        paramViewGroup.fRd = ((ImageView)paramView.findViewById(2131296484));
        paramViewGroup.Kjo = ((TextView)paramView.findViewById(2131298720));
        paramViewGroup.Kjp = paramView.findViewById(2131298733);
        paramViewGroup.iVr = ((TextView)paramView.findViewById(2131303032));
        paramViewGroup.Kjq = ((CategoryTipView)paramView.findViewById(2131298726));
        paramViewGroup.Kjr = ((ViewGroup)paramView.findViewById(2131298723));
        localObject1 = paramViewGroup.Kjp.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cc.a.ay(this.context, 2131165242) * com.tencent.mm.cc.a.il(this.context)));
        paramViewGroup.Kjp.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (this.KiW != null) {
          this.KiW.fMX.a(paramViewGroup.uXb);
        }
        paramView.setTag(paramViewGroup);
        if (localObject2 != null)
        {
          localObject3 = (com.tencent.mm.storage.f)abj(paramInt - 1);
          localObject1 = (com.tencent.mm.storage.f)abj(paramInt + 1);
          if (localObject3 != null) {
            break label809;
          }
          i = -1;
          int j = a((com.tencent.mm.storage.f)localObject2, paramInt);
          if (localObject1 != null) {
            a((com.tencent.mm.storage.f)localObject1, paramInt + 1);
          }
          paramViewGroup.Kjq.setTag(Integer.valueOf(j));
          if ((!this.KiZ) || (paramInt < 0) || (j == i)) {
            break label823;
          }
          localObject3 = b((com.tencent.mm.storage.f)localObject2, paramInt);
          if (bt.isNullOrNil((String)localObject3)) {
            break label823;
          }
          paramViewGroup.Kjr.setVisibility(0);
          paramViewGroup.uQG.setVisibility(0);
          paramViewGroup.uQG.setText((CharSequence)localObject3);
          paramViewGroup.Kjq.aem(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().egR());
          label481:
          localObject3 = b((com.tencent.mm.storage.f)localObject2, paramInt);
          if (localObject1 != null) {
            break label853;
          }
          localObject1 = null;
          paramInt = paramViewGroup.Kjp.getPaddingLeft();
          localActivity = (Activity)this.jLC.get();
          if ((localObject3 == null) || (((String)localObject3).equals(localObject1))) {
            break label867;
          }
          paramViewGroup.uXb.setBackground(null);
          paramViewGroup.Kjp.setBackground(aq.aM(localActivity, 2130969245));
          label556:
          paramViewGroup.Kjp.setPadding(paramInt, 0, 0, 0);
          com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.fRd, ((com.tencent.mm.storage.f)localObject2).field_username);
          if (((com.tencent.mm.storage.f)localObject2).field_verifyFlag == 0) {
            break label915;
          }
          if (as.a.hFQ == null) {
            break label904;
          }
          localObject1 = as.a.hFQ.os(((com.tencent.mm.storage.f)localObject2).field_verifyFlag);
          if (localObject1 == null) {
            break label893;
          }
          localObject1 = o.Eg((String)localObject1);
          paramViewGroup.uXb.setMaskBitmap((Bitmap)localObject1);
          label629:
          b((com.tencent.mm.storage.f)localObject2, paramViewGroup);
          a((com.tencent.mm.storage.f)localObject2, paramViewGroup);
          com.tencent.mm.plugin.sns.ui.e.a.b(0, (String)paramViewGroup.fRd.getTag(), (AvatarImageView)paramViewGroup.fRd);
          ((AvatarImageView)paramViewGroup.fRd).fe(((com.tencent.mm.storage.f)localObject2).field_username, 0);
          ((AvatarImageView)paramViewGroup.fRd).setTag(((com.tencent.mm.storage.f)localObject2).field_username);
          com.tencent.mm.plugin.sns.ui.e.a.a(0, ((com.tencent.mm.storage.f)localObject2).field_username, (AvatarImageView)paramViewGroup.fRd);
          ((AvatarImageView)paramViewGroup.fRd).setShowStoryHint(com.tencent.mm.plugin.sns.f.a.ayp(((com.tencent.mm.storage.f)localObject2).field_username));
        }
        paramViewGroup.uXb.updatePositionFlag();
        localObject2 = paramViewGroup.uXb;
        if (paramViewGroup.uXb.getNickName() != null) {
          break label926;
        }
      }
    }
    label904:
    label915:
    label926:
    for (Object localObject1 = "";; localObject1 = paramViewGroup.uXb.getNickName().toString())
    {
      ((AddressView)localObject2).setContentDescription((CharSequence)localObject1);
      paramViewGroup.fRd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37566);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.d("MicroMsg.AddressAdapter", "click avatarIv");
          if (paramAnonymousView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37566);
            return;
          }
          a.this.nUw.s(paramAnonymousView, a.this.nUx.dA(paramAnonymousView), 2131296484);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      paramViewGroup.Kjr.setVisibility(8);
      paramViewGroup.uQG.setVisibility(8);
      paramViewGroup.Kjq.setVisibility(8);
      break label481;
      label853:
      localObject1 = b((com.tencent.mm.storage.f)localObject1, paramInt + 1);
      break label498;
      label867:
      paramViewGroup.uXb.setBackground(aq.aM(localActivity, 2130969245));
      paramViewGroup.Kjp.setBackground(null);
      break label556;
      label893:
      paramViewGroup.uXb.setMaskBitmap(null);
      break label629;
      paramViewGroup.uXb.setMaskBitmap(null);
      break label629;
      paramViewGroup.uXb.setMaskBitmap(null);
      break label629;
    }
  }
  
  public final void io(List<String> paramList)
  {
    AppMethodBeat.i(37574);
    if (this.type != 2) {
      paramList.add(u.aAm());
    }
    ba.aBQ();
    Object localObject = c.azy().aqy("@t.qq.com");
    if (localObject != null) {
      paramList.add(((ca)localObject).name);
    }
    if ((this.type == 3) || (this.type == 5) || (this.type == 4) || (this.type == 1) || (this.type == 0))
    {
      localObject = w.aBh().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add((String)((Iterator)localObject).next());
      }
    }
    paramList.add("blogapp");
    this.fSL = paramList;
    AppMethodBeat.o(37574);
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(37571);
    this.Kjd = u.aAm();
    if (this.KiU == null) {
      fHB();
    }
    if (getCount() == 0)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(37571);
      return;
    }
    this.KiY = fvi();
    ad.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[] { Integer.valueOf(this.KiY) });
    super.notifyDataSetChanged();
    AppMethodBeat.o(37571);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(37570);
    this.Kjj.clear();
    super.pause();
    AppMethodBeat.o(37570);
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.KiW = ((AddressUI.AddressUIFragment)paramFragment);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.nUx = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.nUw = paramg;
  }
  
  public static abstract interface a {}
  
  protected static final class b
  {
    public TextView Kjo;
    public View Kjp;
    public CategoryTipView Kjq;
    public ViewGroup Kjr;
    public ImageView fRd;
    public TextView iVr;
    public TextView uQG;
    public TextView uQH;
    public AddressView uXb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a
 * JD-Core Version:    0.7.0.1
 */
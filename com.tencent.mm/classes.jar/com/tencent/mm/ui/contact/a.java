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
import com.tencent.mm.al.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cb;
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
  public static final ColorStateList viK;
  public static final ColorStateList viL;
  private String[] JPd;
  HashMap<View, ViewStub> KFA;
  private SparseArray<String> KFB;
  private SparseArray<Integer> KFC;
  private HashSet<String> KFD;
  public HashMap<String, com.tencent.mm.storage.f> KFi;
  protected String KFj;
  protected String KFk;
  private List<Object> KFl;
  private List<String> KFm;
  private int KFn;
  protected int[] KFo;
  String[] KFp;
  protected AddressUI.AddressUIFragment KFq;
  private Set<Integer> KFr;
  private int KFs;
  private boolean KFt;
  a KFu;
  private boolean KFv;
  boolean KFw;
  private String KFx;
  LinkedList<View> KFy;
  boolean KFz;
  View.OnClickListener cNE;
  protected List<String> fUR;
  private WeakReference<Context> jOO;
  private String jff;
  private com.tencent.mm.ui.applet.b jgu;
  protected MMSlideDelView.g oac;
  protected MMSlideDelView.c oad;
  protected MMSlideDelView.d oaf;
  private boolean odI;
  StringBuilder sb;
  private int type;
  protected MMSlideDelView.f wFq;
  
  static
  {
    AppMethodBeat.i(37596);
    viK = com.tencent.mm.cb.a.m(ak.getContext(), 2131100638);
    viL = com.tencent.mm.cb.a.m(ak.getContext(), 2131100490);
    AppMethodBeat.o(37596);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(37572);
    this.KFj = null;
    this.KFk = null;
    this.fUR = null;
    this.KFn = 0;
    this.jff = "";
    this.JPd = null;
    this.oaf = MMSlideDelView.getItemStatusCallBack();
    this.KFr = new HashSet();
    this.KFs = 0;
    this.KFt = true;
    this.jgu = null;
    this.odI = false;
    this.KFv = false;
    this.KFw = false;
    this.KFy = new LinkedList();
    this.KFA = new HashMap();
    this.cNE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37568);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.v("MicroMsg.AddressAdapter", "on delView clicked");
        a.this.oaf.dhv();
        if (a.this.wFq != null) {
          a.this.wFq.cQ(((ViewStub)a.f(a.this).get(paramAnonymousView)).getTag());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37568);
      }
    };
    this.sb = new StringBuilder(32);
    this.KFB = new SparseArray();
    this.KFC = new SparseArray();
    this.KFD = new HashSet();
    this.KFi = new HashMap();
    this.jOO = new WeakReference(paramContext);
    this.context = ak.getContext();
    this.KFj = paramString1;
    this.KFk = paramString2;
    this.type = paramInt;
    this.KFv = true;
    this.KFl = new LinkedList();
    this.KFm = new LinkedList();
    this.KFx = v.aAC();
    this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    AppMethodBeat.o(37572);
  }
  
  private boolean fLR()
  {
    AppMethodBeat.i(37575);
    if ((this.KFj.equals("@micromsg.qq.com")) || (this.KFj.equals("@all.contact.without.chatroom")) || (this.KFj.equals("@all.contact.without.chatroom.without.openim")))
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
    String str2 = (String)this.KFB.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = this.context.getString(paramInt);
      this.KFB.put(paramInt, str1);
    }
    AppMethodBeat.o(37587);
    return str1;
  }
  
  protected int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37584);
    if (paramInt < this.KFs)
    {
      AppMethodBeat.o(37584);
      return 32;
    }
    if (paramf == null)
    {
      ae.e("MicroMsg.AddressAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
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
      ae.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(37592);
      return;
    }
    bc.aCg();
    if (paramn == c.azF()) {
      if ((!x.Am((String)paramObject)) && (!this.KFD.contains((String)paramObject)))
      {
        super.n((String)paramObject, 2);
        if ((this.KFw) && (this.KFq != null))
        {
          this.KFq.KGh = true;
          ae.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
          AppMethodBeat.o(37592);
        }
      }
      else
      {
        ae.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
      }
    }
    AppMethodBeat.o(37592);
  }
  
  protected void a(com.tencent.mm.storage.f paramf, b paramb)
  {
    AppMethodBeat.i(37580);
    try
    {
      paramb.iYk.setText(null);
      paramb.iYk.setVisibility(8);
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
    this.wFq = paramf;
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.f>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(37590);
    paramHashSet = new SparseArray[paramArrayOfSparseArray.length];
    paramArrayOfSparseArray = new LinkedList();
    paramArrayOfSparseArray.add("weixin");
    long l = System.currentTimeMillis();
    bc.aCg();
    paramArrayOfSparseArray = c.azF().b(this.KFj, this.KFk, this.fUR, paramArrayOfSparseArray, fLR(), this.KFv);
    int i;
    if ((paramArrayOfSparseArray instanceof com.tencent.mm.storagebase.a.e))
    {
      d[] arrayOfd = ((com.tencent.mm.storagebase.a.e)paramArrayOfSparseArray).Jkd;
      int k = arrayOfd.length;
      i = 0;
      while (i < k)
      {
        arrayOfd[i].abS(5000);
        paramHashSet[i] = new SparseArray();
        int j = 0;
        while (arrayOfd[i].moveToNext())
        {
          paramHashSet[i].put(j, arrayOfd[i].getString(0));
          j += 1;
        }
        i += 1;
      }
      this.KFs = arrayOfd[0].getCount();
    }
    for (;;)
    {
      paramArrayOfSparseArray.close();
      ae.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - l));
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
  
  public final ArrayList<com.tencent.mm.storage.f> aW(ArrayList<String> paramArrayList)
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
    bc.aCg();
    localObject = c.azF().hG((List)localObject);
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
      localf.convertFrom((Cursor)localObject);
      paramArrayList.add(localf);
    }
    ((Cursor)localObject).close();
    ae.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37589);
    return paramArrayList;
  }
  
  protected final String aYl(String paramString)
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
    if (paramInt < this.KFs)
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
    String str = (String)this.KFB.get(paramf.field_showHead);
    if (str != null)
    {
      AppMethodBeat.o(37585);
      return str;
    }
    str = String.valueOf((char)paramf.field_showHead);
    this.KFB.put(paramf.field_showHead, str);
    AppMethodBeat.o(37585);
    return str;
  }
  
  protected void b(final com.tencent.mm.storage.f paramf, final b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(37581);
    paramb.viP.updateTextColors();
    if (an.aUq(paramf.field_username)) {
      paramb.viP.setMergeCallback(new AddressView.a()
      {
        public final CharSequence abY(int paramAnonymousInt)
        {
          AppMethodBeat.i(37567);
          Object localObject3 = paramf.IHU;
          if (localObject3 == null)
          {
            try
            {
              localObject1 = paramf.adG();
              localObject3 = paramf.field_descWordingId;
              localObject3 = ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).bC(paramf.field_openImAppid, (String)localObject3);
              if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
                break label442;
              }
              localObject3 = "@".concat(String.valueOf(localObject3));
              int i = com.tencent.mm.cb.a.ax(a.a(a.this), 2131165257);
              localObject4 = new TextView(a.b(a.this));
              ((TextView)localObject4).getPaint().setTextSize(i);
              f = ((TextView)localObject4).getPaint().measureText(" ".concat(String.valueOf(localObject3)));
              ((TextView)localObject4).getPaint().setTextSize(paramb.viP.getNickNameSize());
              if (f < paramAnonymousInt * 0.6D) {
                break label420;
              }
              localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject4).getPaint(), (float)(paramAnonymousInt * 0.4D), TextUtils.TruncateAt.END);
              f = ((TextView)localObject4).getPaint().measureText(((CharSequence)localObject1).toString());
              ((TextView)localObject4).getPaint().setTextSize(i);
              localObject3 = TextUtils.ellipsize((CharSequence)localObject3, ((TextView)localObject4).getPaint(), paramAnonymousInt - f - 20.0F, TextUtils.TruncateAt.END);
              localObject4 = k.c(a.c(a.this), localObject1 + " " + localObject3);
              ColorStateList localColorStateList = com.tencent.mm.cb.a.m(a.d(a.this), 2131100528);
              ((SpannableString)localObject4).setSpan(new TextAppearanceSpan(null, 0, i, localColorStateList, localColorStateList), ((CharSequence)localObject1).length() + 1, ((CharSequence)localObject1).length() + 1 + ((CharSequence)localObject3).length(), 33);
              ((SpannableString)localObject4).setSpan(new com.tencent.mm.cf.a(i), ((CharSequence)localObject1).length() + 1, ((CharSequence)localObject1).length() + 1 + ((CharSequence)localObject3).length(), 33);
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
            paramb.viP.setName((CharSequence)localObject3);
          }
          for (;;)
          {
            AppMethodBeat.o(37567);
            return localObject3;
            label420:
            localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject4).getPaint(), paramAnonymousInt - f, TextUtils.TruncateAt.END);
            break;
            label442:
            localObject1 = ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).e(ak.getContext(), (String)localObject1, com.tencent.mm.cb.a.ax(a.e(a.this), 2131165517));
            break label387;
            Object localObject2;
            paramb.viP.setName((CharSequence)localObject3);
          }
        }
      });
    }
    for (;;)
    {
      paramb.viP.setDescription(bu.nullAsNil(paramf.field_remarkDesc));
      AppMethodBeat.o(37581);
      return;
      paramb.viP.setMergeCallback(null);
      Object localObject2 = paramf.IHU;
      if (localObject2 == null) {}
      try
      {
        localObject2 = k.b(this.context, aYl(getDisplayName(paramf.adG(), paramf.field_username)), com.tencent.mm.cb.a.ax(this.context, 2131165517));
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
      paramb.viP.setName((CharSequence)localObject2);
      continue;
      paramb.viP.setName((CharSequence)localObject2);
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(37573);
    if (this.jgu != null)
    {
      this.jgu.detach();
      this.jgu = null;
    }
    AppMethodBeat.o(37573);
  }
  
  protected Cursor fLS()
  {
    AppMethodBeat.i(37576);
    long l = System.currentTimeMillis();
    final LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("weixin");
    bc.aCg();
    Cursor localCursor = c.azF().a(this.KFj, this.KFk, this.fUR, localLinkedList, fLR(), this.KFv);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187917);
        bc.aCg();
        Cursor localCursor = c.azF().a(a.this.KFj, a.this.KFk, a.this.fUR, localLinkedList, a.g(a.this), a.h(a.this));
        if (localCursor != null)
        {
          try
          {
            if (!(localCursor instanceof com.tencent.mm.storagebase.a.e)) {
              break label214;
            }
            ArrayList localArrayList = new ArrayList();
            d locald = ((com.tencent.mm.storagebase.a.e)localCursor).Jkd[0];
            int i = locald.getPosition();
            if (locald != null)
            {
              while (locald.moveToNext())
              {
                com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
                localf.convertFrom(locald);
                localArrayList.add(localf.field_username);
                ae.d("MicroMsg.AddressAdapter", "mStarUserList add %s %s", new Object[] { localf.field_username, localf.field_conRemark });
              }
              locald.moveToPosition(i);
            }
          }
          finally
          {
            if (localCursor != null) {
              localCursor.close();
            }
            AppMethodBeat.o(187917);
          }
          ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().gt(localList);
        }
        label214:
        if (localCursor != null)
        {
          localCursor.close();
          AppMethodBeat.o(187917);
          return;
        }
        AppMethodBeat.o(187917);
      }
    });
    ae.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37576);
    return localCursor;
  }
  
  protected final void fLT()
  {
    AppMethodBeat.i(37577);
    int k = getCount();
    if (k == 0)
    {
      AppMethodBeat.o(37577);
      return;
    }
    this.KFs = fzj();
    if (this.JPd != null)
    {
      this.KFo = x.a(this.KFj, this.KFk, this.fUR, this.JPd);
      this.KFp = x.a(this.KFj, this.KFk, this.JPd, this.fUR);
    }
    for (;;)
    {
      this.KFr.clear();
      if (this.KFo == null) {
        break;
      }
      Object localObject1 = this.KFo;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        k = localObject1[i];
        this.KFr.add(Integer.valueOf(k - 1));
        i += 1;
      }
      long l;
      if (fxK())
      {
        l = System.currentTimeMillis();
        localObject1 = new HashSet();
        this.KFo = new int[30];
        this.KFp = new String[30];
        j = this.KFs;
        i = 0;
        if (j < k)
        {
          Object localObject2 = (com.tencent.mm.storage.f)abR(j);
          if (localObject2 != null)
          {
            localObject2 = b((com.tencent.mm.storage.f)localObject2, j);
            if (!((HashSet)localObject1).add(localObject2)) {
              break label268;
            }
            this.KFo[i] = (j - this.KFs);
            this.KFp[i] = localObject2;
            i += 1;
          }
          label268:
          for (;;)
          {
            j += 1;
            break;
            ae.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
          }
        }
        ae.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - l) + "favourCount : " + this.KFs);
      }
      else
      {
        l = System.currentTimeMillis();
        this.KFo = x.a(null, this.KFj, this.KFk, this.fUR, this.jff);
        this.KFp = x.a(null, this.KFj, this.KFk, this.jff, this.fUR);
        ae.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - l));
      }
    }
    AppMethodBeat.o(37577);
  }
  
  public final void fLU()
  {
    AppMethodBeat.i(37578);
    this.oaf.dhv();
    AppMethodBeat.o(37578);
  }
  
  public final void fLV()
  {
    AppMethodBeat.i(37591);
    super.n(null, 1);
    AppMethodBeat.o(37591);
  }
  
  public final d<String> fzk()
  {
    AppMethodBeat.i(37588);
    d locald = (d)fLS();
    AppMethodBeat.o(37588);
    return locald;
  }
  
  public final void gP(String paramString, int paramInt)
  {
    AppMethodBeat.i(37569);
    if (paramInt == 5) {
      this.KFD.add(paramString);
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
    if (this.KFo != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.KFo.length) {
          i = this.KFo[paramInt];
        }
      }
    }
    return this.KFs + i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37579);
    paramViewGroup = (Context)this.jOO.get();
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(37579);
      return paramView;
    }
    int i;
    if (!this.KFz)
    {
      i = 0;
      while (i < 8)
      {
        this.KFy.add(z.jV(paramViewGroup).inflate(2131492951, null));
        i += 1;
      }
      this.KFz = true;
    }
    Object localObject2 = (com.tencent.mm.storage.f)abR(paramInt);
    label322:
    Object localObject3;
    label359:
    label498:
    Activity localActivity;
    if (paramView == null) {
      if (this.KFy.size() > 0)
      {
        paramView = (View)this.KFy.getFirst();
        this.KFy.removeFirst();
        paramViewGroup = new b();
        paramViewGroup.vcs = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.vct = ((TextView)paramView.findViewById(2131298734));
        paramViewGroup.viP = ((AddressView)paramView.findViewById(2131302653));
        paramViewGroup.fTj = ((ImageView)paramView.findViewById(2131296484));
        paramViewGroup.KFI = ((TextView)paramView.findViewById(2131298720));
        paramViewGroup.KFJ = paramView.findViewById(2131298733);
        paramViewGroup.iYk = ((TextView)paramView.findViewById(2131303032));
        paramViewGroup.KFK = ((CategoryTipView)paramView.findViewById(2131298726));
        paramViewGroup.KFL = ((ViewGroup)paramView.findViewById(2131298723));
        localObject1 = paramViewGroup.KFJ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cb.a.ay(this.context, 2131165242) * com.tencent.mm.cb.a.iq(this.context)));
        paramViewGroup.KFJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (this.KFq != null) {
          this.KFq.fPf.a(paramViewGroup.viP);
        }
        paramView.setTag(paramViewGroup);
        if (localObject2 != null)
        {
          localObject3 = (com.tencent.mm.storage.f)abR(paramInt - 1);
          localObject1 = (com.tencent.mm.storage.f)abR(paramInt + 1);
          if (localObject3 != null) {
            break label809;
          }
          i = -1;
          int j = a((com.tencent.mm.storage.f)localObject2, paramInt);
          if (localObject1 != null) {
            a((com.tencent.mm.storage.f)localObject1, paramInt + 1);
          }
          paramViewGroup.KFK.setTag(Integer.valueOf(j));
          if ((!this.KFt) || (paramInt < 0) || (j == i)) {
            break label823;
          }
          localObject3 = b((com.tencent.mm.storage.f)localObject2, paramInt);
          if (bu.isNullOrNil((String)localObject3)) {
            break label823;
          }
          paramViewGroup.KFL.setVisibility(0);
          paramViewGroup.vcs.setVisibility(0);
          paramViewGroup.vcs.setText((CharSequence)localObject3);
          paramViewGroup.KFK.aeV(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().ekz());
          label481:
          localObject3 = b((com.tencent.mm.storage.f)localObject2, paramInt);
          if (localObject1 != null) {
            break label853;
          }
          localObject1 = null;
          paramInt = paramViewGroup.KFJ.getPaddingLeft();
          localActivity = (Activity)this.jOO.get();
          if ((localObject3 == null) || (((String)localObject3).equals(localObject1))) {
            break label867;
          }
          paramViewGroup.viP.setBackground(null);
          paramViewGroup.KFJ.setBackground(aq.aM(localActivity, 2130969245));
          label556:
          paramViewGroup.KFJ.setPadding(paramInt, 0, 0, 0);
          com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.fTj, ((com.tencent.mm.storage.f)localObject2).field_username);
          if (((com.tencent.mm.storage.f)localObject2).field_verifyFlag == 0) {
            break label915;
          }
          if (au.a.hII == null) {
            break label904;
          }
          localObject1 = au.a.hII.ov(((com.tencent.mm.storage.f)localObject2).field_verifyFlag);
          if (localObject1 == null) {
            break label893;
          }
          localObject1 = o.EI((String)localObject1);
          paramViewGroup.viP.setMaskBitmap((Bitmap)localObject1);
          label629:
          b((com.tencent.mm.storage.f)localObject2, paramViewGroup);
          a((com.tencent.mm.storage.f)localObject2, paramViewGroup);
          com.tencent.mm.plugin.sns.ui.e.a.b(0, (String)paramViewGroup.fTj.getTag(), (AvatarImageView)paramViewGroup.fTj);
          ((AvatarImageView)paramViewGroup.fTj).fn(((com.tencent.mm.storage.f)localObject2).field_username, 0);
          ((AvatarImageView)paramViewGroup.fTj).setTag(((com.tencent.mm.storage.f)localObject2).field_username);
          com.tencent.mm.plugin.sns.ui.e.a.a(0, ((com.tencent.mm.storage.f)localObject2).field_username, (AvatarImageView)paramViewGroup.fTj);
          ((AvatarImageView)paramViewGroup.fTj).setShowStoryHint(com.tencent.mm.plugin.sns.f.a.azG(((com.tencent.mm.storage.f)localObject2).field_username));
        }
        paramViewGroup.viP.updatePositionFlag();
        localObject2 = paramViewGroup.viP;
        if (paramViewGroup.viP.getNickName() != null) {
          break label926;
        }
      }
    }
    label904:
    label915:
    label926:
    for (Object localObject1 = "";; localObject1 = paramViewGroup.viP.getNickName().toString())
    {
      ((AddressView)localObject2).setContentDescription((CharSequence)localObject1);
      paramViewGroup.fTj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37566);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.d("MicroMsg.AddressAdapter", "click avatarIv");
          if (paramAnonymousView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37566);
            return;
          }
          a.this.oac.r(paramAnonymousView, a.this.oad.dA(paramAnonymousView), 2131296484);
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
      paramViewGroup.KFL.setVisibility(8);
      paramViewGroup.vcs.setVisibility(8);
      paramViewGroup.KFK.setVisibility(8);
      break label481;
      label853:
      localObject1 = b((com.tencent.mm.storage.f)localObject1, paramInt + 1);
      break label498;
      label867:
      paramViewGroup.viP.setBackground(aq.aM(localActivity, 2130969245));
      paramViewGroup.KFJ.setBackground(null);
      break label556;
      label893:
      paramViewGroup.viP.setMaskBitmap(null);
      break label629;
      paramViewGroup.viP.setMaskBitmap(null);
      break label629;
      paramViewGroup.viP.setMaskBitmap(null);
      break label629;
    }
  }
  
  public final void iy(List<String> paramList)
  {
    AppMethodBeat.i(37574);
    if (this.type != 2) {
      paramList.add(v.aAC());
    }
    bc.aCg();
    Object localObject = c.azO().arD("@t.qq.com");
    if (localObject != null) {
      paramList.add(((cb)localObject).name);
    }
    if ((this.type == 3) || (this.type == 5) || (this.type == 4) || (this.type == 1) || (this.type == 0))
    {
      localObject = x.aBx().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add((String)((Iterator)localObject).next());
      }
    }
    paramList.add("blogapp");
    this.fUR = paramList;
    AppMethodBeat.o(37574);
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(37571);
    this.KFx = v.aAC();
    if (this.KFo == null) {
      fLT();
    }
    if (getCount() == 0)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(37571);
      return;
    }
    this.KFs = fzj();
    ae.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[] { Integer.valueOf(this.KFs) });
    super.notifyDataSetChanged();
    AppMethodBeat.o(37571);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(37570);
    this.KFD.clear();
    super.pause();
    AppMethodBeat.o(37570);
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.KFq = ((AddressUI.AddressUIFragment)paramFragment);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.oad = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.oac = paramg;
  }
  
  public static abstract interface a {}
  
  protected static final class b
  {
    public TextView KFI;
    public View KFJ;
    public CategoryTipView KFK;
    public ViewGroup KFL;
    public ImageView fTj;
    public TextView iYk;
    public TextView vcs;
    public TextView vct;
    public AddressView viP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.br;
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
import com.tencent.mm.ui.y;
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
  public static final ColorStateList sMP;
  public static final ColorStateList sMQ;
  public HashMap<String, com.tencent.mm.storage.f> GRW;
  protected String GRX;
  protected String GRY;
  private List<Object> GRZ;
  private List<String> GSa;
  private int GSb;
  protected int[] GSc;
  String[] GSd;
  protected AddressUI.AddressUIFragment GSe;
  private Set<Integer> GSf;
  private int GSg;
  private boolean GSh;
  a GSi;
  private boolean GSj;
  boolean GSk;
  private String GSl;
  LinkedList<View> GSm;
  boolean GSn;
  HashMap<View, ViewStub> GSo;
  private SparseArray<String> GSp;
  private SparseArray<Integer> GSq;
  private HashSet<String> GSr;
  private String[] GgH;
  View.OnClickListener cEO;
  protected List<String> fvP;
  private WeakReference<Context> iRx;
  private String iiW;
  private com.tencent.mm.ui.applet.b ikl;
  protected MMSlideDelView.g mRk;
  protected MMSlideDelView.c mRl;
  protected MMSlideDelView.d mRn;
  private boolean mUj;
  StringBuilder sb;
  private int type;
  protected MMSlideDelView.f ubr;
  
  static
  {
    AppMethodBeat.i(37596);
    sMP = com.tencent.mm.cd.a.m(aj.getContext(), 2131100638);
    sMQ = com.tencent.mm.cd.a.m(aj.getContext(), 2131100490);
    AppMethodBeat.o(37596);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(37572);
    this.GRX = null;
    this.GRY = null;
    this.fvP = null;
    this.GSb = 0;
    this.iiW = "";
    this.GgH = null;
    this.mRn = MMSlideDelView.getItemStatusCallBack();
    this.GSf = new HashSet();
    this.GSg = 0;
    this.GSh = true;
    this.ikl = null;
    this.mUj = false;
    this.GSj = false;
    this.GSk = false;
    this.GSm = new LinkedList();
    this.GSo = new HashMap();
    this.cEO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37568);
        ad.v("MicroMsg.AddressAdapter", "on delView clicked");
        a.this.mRn.cIh();
        if (a.this.ubr != null) {
          a.this.ubr.cO(((ViewStub)a.f(a.this).get(paramAnonymousView)).getTag());
        }
        AppMethodBeat.o(37568);
      }
    };
    this.sb = new StringBuilder(32);
    this.GSp = new SparseArray();
    this.GSq = new SparseArray();
    this.GSr = new HashSet();
    this.GRW = new HashMap();
    this.iRx = new WeakReference(paramContext);
    this.context = aj.getContext();
    this.GRX = paramString1;
    this.GRY = paramString2;
    this.type = paramInt;
    this.GSj = true;
    this.GRZ = new LinkedList();
    this.GSa = new LinkedList();
    this.GSl = u.aqG();
    this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    AppMethodBeat.o(37572);
  }
  
  private boolean faV()
  {
    AppMethodBeat.i(37575);
    if ((this.GRX.equals("@micromsg.qq.com")) || (this.GRX.equals("@all.contact.without.chatroom")) || (this.GRX.equals("@all.contact.without.chatroom.without.openim")))
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
    String str2 = (String)this.GSp.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = this.context.getString(paramInt);
      this.GSp.put(paramInt, str1);
    }
    AppMethodBeat.o(37587);
    return str1;
  }
  
  private static void t(Cursor paramCursor)
  {
    AppMethodBeat.i(37593);
    if ((paramCursor instanceof com.tencent.mm.storagebase.a.e))
    {
      ArrayList localArrayList = new ArrayList();
      paramCursor = ((com.tencent.mm.storagebase.a.e)paramCursor).FDc[0];
      int i = paramCursor.getPosition();
      if (paramCursor != null)
      {
        while (paramCursor.moveToNext())
        {
          com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
          localf.convertFrom(paramCursor);
          localArrayList.add(localf.field_username);
          ad.d("MicroMsg.AddressAdapter", "mStarUserList add %s %s", new Object[] { localf.field_username, localf.field_conRemark });
        }
        paramCursor.moveToPosition(i);
      }
      ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().fR(localArrayList);
    }
    AppMethodBeat.o(37593);
  }
  
  protected int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37584);
    if (paramInt < this.GSg)
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
  
  public void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(37592);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(37592);
      return;
    }
    az.arV();
    if (paramn == c.apM()) {
      if ((!w.sC((String)paramObject)) && (!this.GSr.contains((String)paramObject)))
      {
        super.j((String)paramObject, 2);
        if ((this.GSk) && (this.GSe != null))
        {
          this.GSe.GSV = true;
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
      paramb.GSx.setText(null);
      paramb.GSx.setVisibility(8);
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
    this.ubr = paramf;
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.f>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(37590);
    paramHashSet = new SparseArray[paramArrayOfSparseArray.length];
    paramArrayOfSparseArray = new LinkedList();
    paramArrayOfSparseArray.add("weixin");
    long l = System.currentTimeMillis();
    az.arV();
    paramArrayOfSparseArray = c.apM().b(this.GRX, this.GRY, this.fvP, paramArrayOfSparseArray, faV(), this.GSj);
    int i;
    if ((paramArrayOfSparseArray instanceof com.tencent.mm.storagebase.a.e))
    {
      com.tencent.mm.storagebase.a.d[] arrayOfd = ((com.tencent.mm.storagebase.a.e)paramArrayOfSparseArray).FDc;
      int k = arrayOfd.length;
      i = 0;
      while (i < k)
      {
        arrayOfd[i].WR(5000);
        paramHashSet[i] = new SparseArray();
        int j = 0;
        while (arrayOfd[i].moveToNext())
        {
          paramHashSet[i].put(j, arrayOfd[i].getString(0));
          j += 1;
        }
        i += 1;
      }
      this.GSg = arrayOfd[0].getCount();
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
  
  protected final String aLl(String paramString)
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
  
  public final ArrayList<com.tencent.mm.storage.f> aM(ArrayList<String> paramArrayList)
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
    az.arV();
    localObject = c.apM().gX((List)localObject);
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
  
  protected String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37585);
    if (paramInt < this.GSg)
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
    String str = (String)this.GSp.get(paramf.field_showHead);
    if (str != null)
    {
      AppMethodBeat.o(37585);
      return str;
    }
    str = String.valueOf((char)paramf.field_showHead);
    this.GSp.put(paramf.field_showHead, str);
    AppMethodBeat.o(37585);
    return str;
  }
  
  protected void b(final com.tencent.mm.storage.f paramf, final b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(37581);
    paramb.sMU.updateTextColors();
    if (af.aHH(paramf.field_username)) {
      paramb.sMU.setMergeCallback(new AddressView.a()
      {
        public final CharSequence WX(int paramAnonymousInt)
        {
          AppMethodBeat.i(37567);
          Object localObject3 = paramf.Feg;
          if (localObject3 == null)
          {
            try
            {
              localObject1 = paramf.ZX();
              localObject3 = paramf.field_descWordingId;
              localObject3 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bt(paramf.field_openImAppid, (String)localObject3);
              if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
                break label442;
              }
              localObject3 = "@".concat(String.valueOf(localObject3));
              int i = com.tencent.mm.cd.a.ao(a.a(a.this), 2131165257);
              localObject4 = new TextView(a.b(a.this));
              ((TextView)localObject4).getPaint().setTextSize(i);
              f = ((TextView)localObject4).getPaint().measureText(" ".concat(String.valueOf(localObject3)));
              ((TextView)localObject4).getPaint().setTextSize(paramb.sMU.getNickNameSize());
              if (f < paramAnonymousInt * 0.6D) {
                break label420;
              }
              localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject4).getPaint(), (float)(paramAnonymousInt * 0.4D), TextUtils.TruncateAt.END);
              f = ((TextView)localObject4).getPaint().measureText(((CharSequence)localObject1).toString());
              ((TextView)localObject4).getPaint().setTextSize(i);
              localObject3 = TextUtils.ellipsize((CharSequence)localObject3, ((TextView)localObject4).getPaint(), paramAnonymousInt - f - 20.0F, TextUtils.TruncateAt.END);
              localObject4 = com.tencent.mm.pluginsdk.ui.span.k.c(a.c(a.this), localObject1 + " " + localObject3);
              ColorStateList localColorStateList = com.tencent.mm.cd.a.m(a.d(a.this), 2131100528);
              ((SpannableString)localObject4).setSpan(new TextAppearanceSpan(null, 0, i, localColorStateList, localColorStateList), ((CharSequence)localObject1).length() + 1, ((CharSequence)localObject1).length() + 1 + ((CharSequence)localObject3).length(), 33);
              ((SpannableString)localObject4).setSpan(new com.tencent.mm.ch.a(i), ((CharSequence)localObject1).length() + 1, ((CharSequence)localObject1).length() + 1 + ((CharSequence)localObject3).length(), 33);
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
            paramb.sMU.setName((CharSequence)localObject3);
          }
          for (;;)
          {
            AppMethodBeat.o(37567);
            return localObject3;
            label420:
            localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject4).getPaint(), paramAnonymousInt - f, TextUtils.TruncateAt.END);
            break;
            label442:
            localObject1 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).e(aj.getContext(), (String)localObject1, com.tencent.mm.cd.a.ao(a.e(a.this), 2131165517));
            break label387;
            Object localObject2;
            paramb.sMU.setName((CharSequence)localObject3);
          }
        }
      });
    }
    for (;;)
    {
      paramb.sMU.setDescription(bt.nullAsNil(paramf.field_remarkDesc));
      AppMethodBeat.o(37581);
      return;
      paramb.sMU.setMergeCallback(null);
      Object localObject2 = paramf.Feg;
      if (localObject2 == null) {}
      try
      {
        localObject2 = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, aLl(getDisplayName(paramf.ZX(), paramf.field_username)), com.tencent.mm.cd.a.ao(this.context, 2131165517));
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
      paramb.sMU.setName((CharSequence)localObject2);
      continue;
      paramb.sMU.setName((CharSequence)localObject2);
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(37573);
    if (this.ikl != null)
    {
      this.ikl.detach();
      this.ikl = null;
    }
    AppMethodBeat.o(37573);
  }
  
  public final com.tencent.mm.storagebase.a.d<String> ePx()
  {
    AppMethodBeat.i(37588);
    com.tencent.mm.storagebase.a.d locald = (com.tencent.mm.storagebase.a.d)faW();
    AppMethodBeat.o(37588);
    return locald;
  }
  
  protected Cursor faW()
  {
    AppMethodBeat.i(37576);
    long l = System.currentTimeMillis();
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add("weixin");
    az.arV();
    localObject = c.apM().a(this.GRX, this.GRY, this.fvP, (List)localObject, faV(), this.GSj);
    t((Cursor)localObject);
    ad.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37576);
    return localObject;
  }
  
  protected final void faX()
  {
    AppMethodBeat.i(37577);
    int k = getCount();
    if (k == 0)
    {
      AppMethodBeat.o(37577);
      return;
    }
    this.GSg = ePw();
    if (this.GgH != null)
    {
      this.GSc = w.a(this.GRX, this.GRY, this.fvP, this.GgH);
      this.GSd = w.a(this.GRX, this.GRY, this.GgH, this.fvP);
    }
    for (;;)
    {
      this.GSf.clear();
      if (this.GSc == null) {
        break;
      }
      Object localObject1 = this.GSc;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        k = localObject1[i];
        this.GSf.add(Integer.valueOf(k - 1));
        i += 1;
      }
      long l;
      if (eNX())
      {
        l = System.currentTimeMillis();
        localObject1 = new HashSet();
        this.GSc = new int[30];
        this.GSd = new String[30];
        j = this.GSg;
        i = 0;
        if (j < k)
        {
          Object localObject2 = (com.tencent.mm.storage.f)WQ(j);
          if (localObject2 != null)
          {
            localObject2 = b((com.tencent.mm.storage.f)localObject2, j);
            if (!((HashSet)localObject1).add(localObject2)) {
              break label268;
            }
            this.GSc[i] = (j - this.GSg);
            this.GSd[i] = localObject2;
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
        ad.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - l) + "favourCount : " + this.GSg);
      }
      else
      {
        l = System.currentTimeMillis();
        this.GSc = w.a(null, this.GRX, this.GRY, this.fvP, this.iiW);
        this.GSd = w.a(null, this.GRX, this.GRY, this.iiW, this.fvP);
        ad.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - l));
      }
    }
    AppMethodBeat.o(37577);
  }
  
  public final void faY()
  {
    AppMethodBeat.i(37578);
    this.mRn.cIh();
    AppMethodBeat.o(37578);
  }
  
  public final void faZ()
  {
    AppMethodBeat.i(37591);
    super.j(null, 1);
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
    if (this.GSc != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.GSc.length) {
          i = this.GSc[paramInt];
        }
      }
    }
    return this.GSg + i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37579);
    paramViewGroup = (Context)this.iRx.get();
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(37579);
      return paramView;
    }
    int i;
    if (!this.GSn)
    {
      i = 0;
      while (i < 8)
      {
        this.GSm.add(y.js(paramViewGroup).inflate(2131492951, null));
        i += 1;
      }
      this.GSn = true;
    }
    Object localObject2 = (com.tencent.mm.storage.f)WQ(paramInt);
    label322:
    Object localObject3;
    label359:
    label498:
    Activity localActivity;
    if (paramView == null) {
      if (this.GSm.size() > 0)
      {
        paramView = (View)this.GSm.getFirst();
        this.GSm.removeFirst();
        paramViewGroup = new b();
        paramViewGroup.sGm = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.sGn = ((TextView)paramView.findViewById(2131298734));
        paramViewGroup.sMU = ((AddressView)paramView.findViewById(2131302653));
        paramViewGroup.fuj = ((ImageView)paramView.findViewById(2131296484));
        paramViewGroup.GSv = ((TextView)paramView.findViewById(2131298720));
        paramViewGroup.GSw = paramView.findViewById(2131298733);
        paramViewGroup.GSx = ((TextView)paramView.findViewById(2131303032));
        paramViewGroup.GSy = ((CategoryTipView)paramView.findViewById(2131298726));
        paramViewGroup.GSz = ((ViewGroup)paramView.findViewById(2131298723));
        localObject1 = paramViewGroup.GSw.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cd.a.ap(this.context, 2131165242) * com.tencent.mm.cd.a.hR(this.context)));
        paramViewGroup.GSw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (this.GSe != null) {
          this.GSe.fqs.a(paramViewGroup.sMU);
        }
        paramView.setTag(paramViewGroup);
        if (localObject2 != null)
        {
          localObject3 = (com.tencent.mm.storage.f)WQ(paramInt - 1);
          localObject1 = (com.tencent.mm.storage.f)WQ(paramInt + 1);
          if (localObject3 != null) {
            break label809;
          }
          i = -1;
          int j = a((com.tencent.mm.storage.f)localObject2, paramInt);
          if (localObject1 != null) {
            a((com.tencent.mm.storage.f)localObject1, paramInt + 1);
          }
          paramViewGroup.GSy.setTag(Integer.valueOf(j));
          if ((!this.GSh) || (paramInt < 0) || (j == i)) {
            break label823;
          }
          localObject3 = b((com.tencent.mm.storage.f)localObject2, paramInt);
          if (bt.isNullOrNil((String)localObject3)) {
            break label823;
          }
          paramViewGroup.GSz.setVisibility(0);
          paramViewGroup.sGm.setVisibility(0);
          paramViewGroup.sGm.setText((CharSequence)localObject3);
          paramViewGroup.GSy.ZB(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().dGc());
          label481:
          localObject3 = b((com.tencent.mm.storage.f)localObject2, paramInt);
          if (localObject1 != null) {
            break label853;
          }
          localObject1 = null;
          paramInt = paramViewGroup.GSw.getPaddingLeft();
          localActivity = (Activity)this.iRx.get();
          if ((localObject3 == null) || (((String)localObject3).equals(localObject1))) {
            break label867;
          }
          paramViewGroup.sMU.setBackground(null);
          paramViewGroup.GSw.setBackground(ao.aC(localActivity, 2130969245));
          label556:
          paramViewGroup.GSw.setPadding(paramInt, 0, 0, 0);
          com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.fuj, ((com.tencent.mm.storage.f)localObject2).field_username);
          if (((com.tencent.mm.storage.f)localObject2).field_verifyFlag == 0) {
            break label915;
          }
          if (ar.a.gMY == null) {
            break label904;
          }
          localObject1 = ar.a.gMY.ne(((com.tencent.mm.storage.f)localObject2).field_verifyFlag);
          if (localObject1 == null) {
            break label893;
          }
          localObject1 = com.tencent.mm.am.n.xb((String)localObject1);
          paramViewGroup.sMU.setMaskBitmap((Bitmap)localObject1);
          label629:
          b((com.tencent.mm.storage.f)localObject2, paramViewGroup);
          a((com.tencent.mm.storage.f)localObject2, paramViewGroup);
          com.tencent.mm.plugin.sns.ui.e.a.b(0, (String)paramViewGroup.fuj.getTag(), (AvatarImageView)paramViewGroup.fuj);
          ((AvatarImageView)paramViewGroup.fuj).eE(((com.tencent.mm.storage.f)localObject2).field_username, 0);
          ((AvatarImageView)paramViewGroup.fuj).setTag(((com.tencent.mm.storage.f)localObject2).field_username);
          com.tencent.mm.plugin.sns.ui.e.a.a(0, ((com.tencent.mm.storage.f)localObject2).field_username, (AvatarImageView)paramViewGroup.fuj);
          ((AvatarImageView)paramViewGroup.fuj).setShowStoryHint(com.tencent.mm.plugin.sns.g.a.anY(((com.tencent.mm.storage.f)localObject2).field_username));
        }
        paramViewGroup.sMU.updatePositionFlag();
        localObject2 = paramViewGroup.sMU;
        if (paramViewGroup.sMU.getNickName() != null) {
          break label926;
        }
      }
    }
    label904:
    label915:
    label926:
    for (Object localObject1 = "";; localObject1 = paramViewGroup.sMU.getNickName().toString())
    {
      ((AddressView)localObject2).setContentDescription((CharSequence)localObject1);
      paramViewGroup.fuj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37566);
          ad.d("MicroMsg.AddressAdapter", "click avatarIv");
          if (paramAnonymousView == null)
          {
            AppMethodBeat.o(37566);
            return;
          }
          a.this.mRk.s(paramAnonymousView, a.this.mRl.dw(paramAnonymousView), 2131296484);
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
      paramViewGroup.GSz.setVisibility(8);
      paramViewGroup.sGm.setVisibility(8);
      paramViewGroup.GSy.setVisibility(8);
      break label481;
      label853:
      localObject1 = b((com.tencent.mm.storage.f)localObject1, paramInt + 1);
      break label498;
      label867:
      paramViewGroup.sMU.setBackground(ao.aC(localActivity, 2130969245));
      paramViewGroup.GSw.setBackground(null);
      break label556;
      label893:
      paramViewGroup.sMU.setMaskBitmap(null);
      break label629;
      paramViewGroup.sMU.setMaskBitmap(null);
      break label629;
      paramViewGroup.sMU.setMaskBitmap(null);
      break label629;
    }
  }
  
  public final void gf(String paramString, int paramInt)
  {
    AppMethodBeat.i(37569);
    if (paramInt == 5) {
      this.GSr.add(paramString);
    }
    super.j(paramString, paramInt);
    AppMethodBeat.o(37569);
  }
  
  public final void hP(List<String> paramList)
  {
    AppMethodBeat.i(37574);
    if (this.type != 2) {
      paramList.add(u.aqG());
    }
    az.arV();
    Object localObject = c.apU().agP("@t.qq.com");
    if (localObject != null) {
      paramList.add(((br)localObject).name);
    }
    if ((this.type == 3) || (this.type == 5) || (this.type == 4) || (this.type == 1) || (this.type == 0))
    {
      localObject = w.arr().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add((String)((Iterator)localObject).next());
      }
    }
    paramList.add("blogapp");
    this.fvP = paramList;
    AppMethodBeat.o(37574);
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(37571);
    this.GSl = u.aqG();
    if (this.GSc == null) {
      faX();
    }
    if (getCount() == 0)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(37571);
      return;
    }
    this.GSg = ePw();
    ad.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[] { Integer.valueOf(this.GSg) });
    super.notifyDataSetChanged();
    AppMethodBeat.o(37571);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(37570);
    this.GSr.clear();
    super.pause();
    AppMethodBeat.o(37570);
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.GSe = ((AddressUI.AddressUIFragment)paramFragment);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.mRl = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.mRk = paramg;
  }
  
  public static abstract interface a {}
  
  protected static final class b
  {
    public TextView GSv;
    public View GSw;
    public TextView GSx;
    public CategoryTipView GSy;
    public ViewGroup GSz;
    public ImageView fuj;
    public TextView sGm;
    public TextView sGn;
    public AddressView sMU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
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
import com.tencent.mm.aj.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.w;
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
  public static final ColorStateList nYQ;
  public static final ColorStateList nYR;
  boolean Aaa;
  HashMap<View, ViewStub> Aab;
  private SparseArray<String> Aac;
  private SparseArray<Integer> Aad;
  private HashSet<String> Aae;
  View.OnClickListener bTw;
  protected List<String> ejc;
  private WeakReference<Context> gYJ;
  private String gvZ;
  private com.tencent.mm.ui.applet.b gxo;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.d jSe;
  private boolean jTS;
  protected MMSlideDelView.f pdU;
  StringBuilder sb;
  private int type;
  public HashMap<String, com.tencent.mm.storage.f> zZJ;
  protected String zZK;
  protected String zZL;
  private List<Object> zZM;
  private List<String> zZN;
  private int zZO;
  protected int[] zZP;
  String[] zZQ;
  protected AddressUI.AddressUIFragment zZR;
  private Set<Integer> zZS;
  private int zZT;
  private boolean zZU;
  a.a zZV;
  private boolean zZW;
  boolean zZX;
  private String zZY;
  LinkedList<View> zZZ;
  private String[] zsR;
  
  static
  {
    AppMethodBeat.i(33482);
    nYQ = com.tencent.mm.cb.a.l(com.tencent.mm.sdk.platformtools.ah.getContext(), 2131690768);
    nYR = com.tencent.mm.cb.a.l(com.tencent.mm.sdk.platformtools.ah.getContext(), 2131690168);
    AppMethodBeat.o(33482);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(33461);
    this.zZK = null;
    this.zZL = null;
    this.ejc = null;
    this.zZO = 0;
    this.gvZ = "";
    this.zsR = null;
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    this.zZS = new HashSet();
    this.zZT = 0;
    this.zZU = true;
    this.gxo = null;
    this.jTS = false;
    this.zZW = false;
    this.zZX = false;
    this.zZZ = new LinkedList();
    this.Aab = new HashMap();
    this.bTw = new a.3(this);
    this.sb = new StringBuilder(32);
    this.Aac = new SparseArray();
    this.Aad = new SparseArray();
    this.Aae = new HashSet();
    this.zZJ = new HashMap();
    this.gYJ = new WeakReference(paramContext);
    this.context = com.tencent.mm.sdk.platformtools.ah.getContext();
    this.zZK = paramString1;
    this.zZL = paramString2;
    this.type = paramInt;
    this.zZW = true;
    this.zZM = new LinkedList();
    this.zZN = new LinkedList();
    this.zZY = r.Zn();
    this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    AppMethodBeat.o(33461);
  }
  
  private boolean dLz()
  {
    AppMethodBeat.i(33464);
    if ((this.zZK.equals("@micromsg.qq.com")) || (this.zZK.equals("@all.contact.without.chatroom")) || (this.zZK.equals("@all.contact.without.chatroom.without.openim")))
    {
      AppMethodBeat.o(33464);
      return true;
    }
    AppMethodBeat.o(33464);
    return false;
  }
  
  public static String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156719);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      AppMethodBeat.o(156719);
      return paramString1;
    }
    AppMethodBeat.o(156719);
    return paramString2;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(33473);
    String str2 = (String)this.Aac.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = this.context.getString(paramInt);
      this.Aac.put(paramInt, str1);
    }
    AppMethodBeat.o(33473);
    return str1;
  }
  
  private static void r(Cursor paramCursor)
  {
    AppMethodBeat.i(33479);
    if ((paramCursor instanceof com.tencent.mm.cg.a.e))
    {
      ArrayList localArrayList = new ArrayList();
      paramCursor = ((com.tencent.mm.cg.a.e)paramCursor).yRt[0];
      int i = paramCursor.getPosition();
      if (paramCursor != null)
      {
        while (paramCursor.moveToNext())
        {
          com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
          localf.convertFrom(paramCursor);
          localArrayList.add(localf.field_username);
          ab.d("MicroMsg.AddressAdapter", "mStarUserList add %s %s", new Object[] { localf.field_username, localf.field_conRemark });
        }
        paramCursor.moveToPosition(i);
      }
      ((com.tencent.mm.plugin.story.api.e)g.G(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().dA(localArrayList);
    }
    AppMethodBeat.o(33479);
  }
  
  protected int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(33470);
    if (paramInt < this.zZT)
    {
      AppMethodBeat.o(33470);
      return 32;
    }
    if (paramf == null)
    {
      ab.e("MicroMsg.AddressAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(33470);
      return -1;
    }
    paramInt = paramf.field_showHead;
    AppMethodBeat.o(33470);
    return paramInt;
  }
  
  public void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(33478);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(33478);
      return;
    }
    aw.aaz();
    if (paramn == c.YA()) {
      if ((!t.nS((String)paramObject)) && (!this.Aae.contains((String)paramObject)))
      {
        super.i((String)paramObject, 2);
        if ((this.zZX) && (this.zZR != null))
        {
          this.zZR.AaH = true;
          ab.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
          AppMethodBeat.o(33478);
        }
      }
      else
      {
        ab.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
      }
    }
    AppMethodBeat.o(33478);
  }
  
  protected void a(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    AppMethodBeat.i(33469);
    try
    {
      paramb.Aak.setText(null);
      paramb.Aak.setVisibility(8);
      AppMethodBeat.o(33469);
      return;
    }
    catch (Throwable paramf)
    {
      AppMethodBeat.o(33469);
    }
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.pdU = paramf;
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.f>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(33476);
    paramHashSet = new SparseArray[paramArrayOfSparseArray.length];
    paramArrayOfSparseArray = new LinkedList();
    paramArrayOfSparseArray.add("weixin");
    long l = System.currentTimeMillis();
    aw.aaz();
    paramArrayOfSparseArray = c.YA().b(this.zZK, this.zZL, this.ejc, paramArrayOfSparseArray, dLz(), this.zZW);
    int i;
    if ((paramArrayOfSparseArray instanceof com.tencent.mm.cg.a.e))
    {
      com.tencent.mm.cg.a.d[] arrayOfd = ((com.tencent.mm.cg.a.e)paramArrayOfSparseArray).yRt;
      int k = arrayOfd.length;
      i = 0;
      while (i < k)
      {
        arrayOfd[i].NN(5000);
        paramHashSet[i] = new SparseArray();
        int j = 0;
        while (arrayOfd[i].moveToNext())
        {
          paramHashSet[i].put(j, arrayOfd[i].getString(0));
          j += 1;
        }
        i += 1;
      }
      this.zZT = arrayOfd[0].getCount();
    }
    for (;;)
    {
      paramArrayOfSparseArray.close();
      ab.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(33476);
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
  
  public final ArrayList<com.tencent.mm.storage.f> ap(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(33475);
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ((List)localObject).add((String)paramArrayList.get(i));
      i += 1;
    }
    paramArrayList = new ArrayList(((List)localObject).size());
    aw.aaz();
    localObject = c.YA().eD((List)localObject);
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
      localf.convertFrom((Cursor)localObject);
      paramArrayList.add(localf);
    }
    ((Cursor)localObject).close();
    ab.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(33475);
    return paramArrayList;
  }
  
  protected final String auw(String paramString)
  {
    AppMethodBeat.i(156720);
    if (("".length() > 0) && (!"".equals(paramString)))
    {
      this.sb.append(paramString);
      this.sb.append("(");
      this.sb.append("");
      this.sb.append(")");
      paramString = this.sb.toString();
      this.sb.delete(0, this.sb.length());
      AppMethodBeat.o(156720);
      return paramString;
    }
    AppMethodBeat.o(156720);
    return paramString;
  }
  
  protected String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(33471);
    if (paramInt < this.zZT)
    {
      paramf = getString(2131296465);
      AppMethodBeat.o(33471);
      return paramf;
    }
    if (paramf.field_showHead == 31)
    {
      AppMethodBeat.o(33471);
      return "";
    }
    if (paramf.field_showHead == 123)
    {
      AppMethodBeat.o(33471);
      return "#";
    }
    if (paramf.field_showHead == 33)
    {
      paramf = getString(2131296446);
      AppMethodBeat.o(33471);
      return paramf;
    }
    if (paramf.field_showHead == 43)
    {
      paramf = getString(2131302712);
      AppMethodBeat.o(33471);
      return paramf;
    }
    if (paramf.field_showHead == 32)
    {
      paramf = getString(2131296465);
      AppMethodBeat.o(33471);
      return paramf;
    }
    String str = (String)this.Aac.get(paramf.field_showHead);
    if (str != null)
    {
      AppMethodBeat.o(33471);
      return str;
    }
    str = String.valueOf((char)paramf.field_showHead);
    this.Aac.put(paramf.field_showHead, str);
    AppMethodBeat.o(33471);
    return str;
  }
  
  protected void b(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(156718);
    paramb.nYV.updateTextColors();
    if (ad.arf(paramf.field_username)) {
      paramb.nYV.setMergeCallback(new a.2(this, paramf, paramb));
    }
    for (;;)
    {
      paramb.nYV.setDescription(com.tencent.mm.platformtools.ah.nullAsNil(paramf.field_remarkDesc));
      AppMethodBeat.o(156718);
      return;
      paramb.nYV.setMergeCallback(null);
      Object localObject2 = paramf.ywx;
      if (localObject2 == null) {}
      try
      {
        localObject2 = j.b(this.context, auw(getDisplayName(paramf.Of(), paramf.field_username)), com.tencent.mm.cb.a.ao(this.context, 2131427809));
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
      paramb.nYV.setName((CharSequence)localObject2);
      continue;
      paramb.nYV.setName((CharSequence)localObject2);
    }
  }
  
  public final com.tencent.mm.cg.a.d<String> dAZ()
  {
    AppMethodBeat.i(33474);
    com.tencent.mm.cg.a.d locald = (com.tencent.mm.cg.a.d)dLA();
    AppMethodBeat.o(33474);
    return locald;
  }
  
  protected Cursor dLA()
  {
    AppMethodBeat.i(33465);
    long l = System.currentTimeMillis();
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add("weixin");
    aw.aaz();
    localObject = c.YA().a(this.zZK, this.zZL, this.ejc, (List)localObject, dLz(), this.zZW);
    r((Cursor)localObject);
    ab.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(33465);
    return localObject;
  }
  
  protected final void dLB()
  {
    AppMethodBeat.i(33466);
    int k = getCount();
    if (k == 0)
    {
      AppMethodBeat.o(33466);
      return;
    }
    this.zZT = dAY();
    if (this.zsR != null)
    {
      this.zZP = t.a(this.zZK, this.zZL, this.ejc, this.zsR);
      this.zZQ = t.a(this.zZK, this.zZL, this.zsR, this.ejc);
    }
    for (;;)
    {
      this.zZS.clear();
      if (this.zZP == null) {
        break;
      }
      Object localObject1 = this.zZP;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        k = localObject1[i];
        this.zZS.add(Integer.valueOf(k - 1));
        i += 1;
      }
      long l;
      if (dzM())
      {
        l = System.currentTimeMillis();
        localObject1 = new HashSet();
        this.zZP = new int[30];
        this.zZQ = new String[30];
        j = this.zZT;
        i = 0;
        if (j < k)
        {
          Object localObject2 = (com.tencent.mm.storage.f)NM(j);
          if (localObject2 != null)
          {
            localObject2 = b((com.tencent.mm.storage.f)localObject2, j);
            if (!((HashSet)localObject1).add(localObject2)) {
              break label268;
            }
            this.zZP[i] = (j - this.zZT);
            this.zZQ[i] = localObject2;
            i += 1;
          }
          label268:
          for (;;)
          {
            j += 1;
            break;
            ab.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
          }
        }
        ab.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - l) + "favourCount : " + this.zZT);
      }
      else
      {
        l = System.currentTimeMillis();
        this.zZP = t.a(this.zZK, this.zZL, this.ejc, this.gvZ);
        this.zZQ = t.a(this.zZK, this.zZL, this.gvZ, this.ejc);
        ab.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - l));
      }
    }
    AppMethodBeat.o(33466);
  }
  
  public final void dLC()
  {
    AppMethodBeat.i(33467);
    this.jSe.bKl();
    AppMethodBeat.o(33467);
  }
  
  public final void dLD()
  {
    AppMethodBeat.i(33477);
    super.i(null, 1);
    AppMethodBeat.o(33477);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(33462);
    if (this.gxo != null)
    {
      this.gxo.detach();
      this.gxo = null;
    }
    AppMethodBeat.o(33462);
  }
  
  public final void eT(String paramString, int paramInt)
  {
    AppMethodBeat.i(33458);
    if (paramInt == 5) {
      this.Aae.add(paramString);
    }
    super.i(paramString, paramInt);
    AppMethodBeat.o(33458);
  }
  
  public final void ft(List<String> paramList)
  {
    AppMethodBeat.i(33463);
    if (this.type != 2) {
      paramList.add(r.Zn());
    }
    aw.aaz();
    Object localObject = c.YI().TL("@t.qq.com");
    if (localObject != null) {
      paramList.add(((bq)localObject).name);
    }
    if ((this.type == 3) || (this.type == 5) || (this.type == 4) || (this.type == 1) || (this.type == 0))
    {
      localObject = t.ZW().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add((String)((Iterator)localObject).next());
      }
    }
    paramList.add("blogapp");
    this.ejc = paramList;
    AppMethodBeat.o(33463);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(33472);
    int i = super.getCount();
    AppMethodBeat.o(33472);
    return i;
  }
  
  public final int getPositionForSection(int paramInt)
  {
    int i = paramInt;
    if (this.zZP != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.zZP.length) {
          i = this.zZP[paramInt];
        }
      }
    }
    return this.zZT + i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33468);
    paramViewGroup = (Context)this.gYJ.get();
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(33468);
      return paramView;
    }
    int i;
    if (!this.Aaa)
    {
      i = 0;
      while (i < 8)
      {
        this.zZZ.add(w.hM(paramViewGroup).inflate(2130968643, null));
        i += 1;
      }
      this.Aaa = true;
    }
    Object localObject2 = (com.tencent.mm.storage.f)NM(paramInt);
    label322:
    Object localObject3;
    if (paramView == null) {
      if (this.zZZ.size() > 0)
      {
        paramView = (View)this.zZZ.getFirst();
        this.zZZ.removeFirst();
        paramViewGroup = new a.b();
        paramViewGroup.nSs = ((TextView)paramView.findViewById(2131821089));
        paramViewGroup.nSt = ((TextView)paramView.findViewById(2131821095));
        paramViewGroup.nYV = ((AddressView)paramView.findViewById(2131821109));
        paramViewGroup.ehv = ((ImageView)paramView.findViewById(2131821108));
        paramViewGroup.Aai = ((TextView)paramView.findViewById(2131821106));
        paramViewGroup.Aaj = paramView.findViewById(2131821105);
        paramViewGroup.Aak = ((TextView)paramView.findViewById(2131821107));
        paramViewGroup.Aal = ((CategoryTipView)paramView.findViewById(2131821104));
        paramViewGroup.Aam = ((ViewGroup)paramView.findViewById(2131821103));
        localObject1 = paramViewGroup.Aaj.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cb.a.ap(this.context, 2131427549) * com.tencent.mm.cb.a.gs(this.context)));
        paramViewGroup.Aaj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (this.zZR != null) {
          this.zZR.efo.a(paramViewGroup.nYV);
        }
        paramView.setTag(paramViewGroup);
        if (localObject2 != null)
        {
          localObject3 = (com.tencent.mm.storage.f)NM(paramInt - 1);
          localObject1 = (com.tencent.mm.storage.f)NM(paramInt + 1);
          if (localObject3 != null) {
            break label792;
          }
          i = -1;
          label359:
          int j = a((com.tencent.mm.storage.f)localObject2, paramInt);
          if (localObject1 != null) {
            a((com.tencent.mm.storage.f)localObject1, paramInt + 1);
          }
          paramViewGroup.Aal.setTag(Integer.valueOf(j));
          if ((!this.zZU) || (paramInt < 0) || (j == i)) {
            break label806;
          }
          localObject3 = b((com.tencent.mm.storage.f)localObject2, paramInt);
          if (com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject3)) {
            break label806;
          }
          paramViewGroup.Aam.setVisibility(0);
          paramViewGroup.nSs.setVisibility(0);
          paramViewGroup.nSs.setText((CharSequence)localObject3);
          paramViewGroup.Aal.Qs(((com.tencent.mm.plugin.story.api.e)g.G(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().czn());
          label481:
          localObject3 = b((com.tencent.mm.storage.f)localObject2, paramInt);
          if (localObject1 != null) {
            break label836;
          }
          localObject1 = null;
          label498:
          paramInt = paramViewGroup.Aaj.getPaddingLeft();
          if ((localObject3 == null) || (((String)localObject3).equals(localObject1))) {
            break label850;
          }
          paramViewGroup.nYV.setBackground(null);
          paramViewGroup.Aaj.setBackgroundResource(2130839276);
          label539:
          paramViewGroup.Aaj.setPadding(paramInt, 0, 0, 0);
          com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.ehv, ((com.tencent.mm.storage.f)localObject2).field_username);
          if (((com.tencent.mm.storage.f)localObject2).field_verifyFlag == 0) {
            break label893;
          }
          if (ao.a.flK == null) {
            break label882;
          }
          localObject1 = ao.a.flK.ky(((com.tencent.mm.storage.f)localObject2).field_verifyFlag);
          if (localObject1 == null) {
            break label871;
          }
          localObject1 = m.sf((String)localObject1);
          paramViewGroup.nYV.setMaskBitmap((Bitmap)localObject1);
          label612:
          b((com.tencent.mm.storage.f)localObject2, paramViewGroup);
          a((com.tencent.mm.storage.f)localObject2, paramViewGroup);
          com.tencent.mm.plugin.sns.ui.e.a.b(0, (String)paramViewGroup.ehv.getTag(), (AvatarImageView)paramViewGroup.ehv);
          ((AvatarImageView)paramViewGroup.ehv).dw(((com.tencent.mm.storage.f)localObject2).field_username, 0);
          ((AvatarImageView)paramViewGroup.ehv).setTag(((com.tencent.mm.storage.f)localObject2).field_username);
          com.tencent.mm.plugin.sns.ui.e.a.a(0, ((com.tencent.mm.storage.f)localObject2).field_username, (AvatarImageView)paramViewGroup.ehv);
          ((AvatarImageView)paramViewGroup.ehv).setShowStoryHint(com.tencent.mm.plugin.sns.e.a.ZR(((com.tencent.mm.storage.f)localObject2).field_username));
        }
        paramViewGroup.nYV.updatePositionFlag();
        localObject2 = paramViewGroup.nYV;
        if (paramViewGroup.nYV.getNickName() != null) {
          break label904;
        }
      }
    }
    label904:
    for (Object localObject1 = "";; localObject1 = paramViewGroup.nYV.getNickName().toString())
    {
      ((AddressView)localObject2).setContentDescription((CharSequence)localObject1);
      paramViewGroup.ehv.setOnClickListener(new a.1(this));
      AppMethodBeat.o(33468);
      return paramView;
      paramView = View.inflate(paramViewGroup, 2130968643, null);
      break;
      paramViewGroup = (a.b)paramView.getTag();
      break label322;
      label792:
      i = a((com.tencent.mm.storage.f)localObject3, paramInt - 1);
      break label359;
      label806:
      paramViewGroup.Aam.setVisibility(8);
      paramViewGroup.nSs.setVisibility(8);
      paramViewGroup.Aal.setVisibility(8);
      break label481;
      label836:
      localObject1 = b((com.tencent.mm.storage.f)localObject1, paramInt + 1);
      break label498;
      label850:
      paramViewGroup.nYV.setBackgroundResource(2130839276);
      paramViewGroup.Aaj.setBackground(null);
      break label539;
      label871:
      paramViewGroup.nYV.setMaskBitmap(null);
      break label612;
      label882:
      paramViewGroup.nYV.setMaskBitmap(null);
      break label612;
      label893:
      paramViewGroup.nYV.setMaskBitmap(null);
      break label612;
    }
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(33460);
    this.zZY = r.Zn();
    if (this.zZP == null) {
      dLB();
    }
    if (getCount() == 0)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(33460);
      return;
    }
    this.zZT = dAY();
    ab.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[] { Integer.valueOf(this.zZT) });
    super.notifyDataSetChanged();
    AppMethodBeat.o(33460);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(33459);
    this.Aae.clear();
    super.pause();
    AppMethodBeat.o(33459);
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.zZR = ((AddressUI.AddressUIFragment)paramFragment);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a
 * JD-Core Version:    0.7.0.1
 */
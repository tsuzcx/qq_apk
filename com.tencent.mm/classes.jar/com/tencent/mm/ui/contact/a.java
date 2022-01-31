package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.cf.a.e;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.f.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class a
  extends com.tencent.mm.ui.f<String, com.tencent.mm.storage.f>
  implements m.b
{
  public static final ColorStateList lBE = com.tencent.mm.cb.a.h(ae.getContext(), R.e.mm_list_textcolor_one);
  public static final ColorStateList lBF = com.tencent.mm.cb.a.h(ae.getContext(), R.e.hint_text_color);
  protected List<String> dru = null;
  private String feq = "";
  private com.tencent.mm.ui.applet.b ffG = null;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  private boolean idd = false;
  View.OnClickListener kdc = new a.1(this);
  protected MMSlideDelView.f mDS;
  StringBuilder sb = new StringBuilder(32);
  private int type;
  private Set<Integer> vIA = new HashSet();
  private int vIB = 0;
  private boolean vIC = true;
  a.a vID;
  private boolean vIE = false;
  boolean vIF = false;
  private String vIG;
  LinkedList<View> vIH = new LinkedList();
  boolean vII;
  HashMap<View, ViewStub> vIJ = new HashMap();
  private SparseArray<String> vIK = new SparseArray();
  private SparseArray<Integer> vIL = new SparseArray();
  private HashSet<String> vIM = new HashSet();
  public HashMap<String, com.tencent.mm.storage.f> vIr = new HashMap();
  protected String vIs = null;
  protected String vIt = null;
  private List<Object> vIu;
  private List<String> vIv;
  private int vIw = 0;
  protected int[] vIx;
  String[] vIy;
  protected AddressUI.a vIz;
  private String[] ves = null;
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    this.context = paramContext;
    this.vIs = paramString1;
    this.vIt = paramString2;
    this.type = paramInt;
    this.vIE = true;
    this.vIu = new LinkedList();
    this.vIv = new LinkedList();
    this.vIG = q.Gj();
    this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
  }
  
  private boolean cHj()
  {
    return (this.vIs.equals("@micromsg.qq.com")) || (this.vIs.equals("@all.contact.without.chatroom")) || (this.vIs.equals("@all.contact.without.chatroom.without.openim"));
  }
  
  private String getString(int paramInt)
  {
    String str2 = (String)this.vIK.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = this.context.getString(paramInt);
      this.vIK.put(paramInt, str1);
    }
    return str1;
  }
  
  protected int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    if (paramInt < this.vIB) {
      return 32;
    }
    if (paramf == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AddressAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      return -1;
    }
    return paramf.field_showHead;
  }
  
  public void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    do
    {
      do
      {
        return;
        au.Hx();
      } while (paramm != c.Fw());
      if ((s.hj((String)paramObject)) || (this.vIM.contains((String)paramObject))) {
        break;
      }
      super.f((String)paramObject, 2);
    } while ((!this.vIF) || (this.vIz == null));
    this.vIz.vJl = true;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
    return;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
  }
  
  protected void a(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    try
    {
      paramb.vIQ.setText(null);
      paramb.vIQ.setVisibility(8);
      if (ad.aaU(paramf.field_username))
      {
        String str = paramf.field_descWordingId;
        paramf = ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).aK(paramf.field_openImAppid, str);
        if ((paramf != null) && (paramf.length() > 0))
        {
          paramb.vIQ.setVisibility(0);
          paramb.vIQ.setText(paramf);
        }
      }
      return;
    }
    catch (Throwable paramf) {}
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.mDS = paramf;
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.f>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    paramHashSet = new SparseArray[paramArrayOfSparseArray.length];
    paramArrayOfSparseArray = new LinkedList();
    paramArrayOfSparseArray.add("weixin");
    long l = System.currentTimeMillis();
    au.Hx();
    paramArrayOfSparseArray = c.Fw().b(this.vIs, this.vIt, this.dru, paramArrayOfSparseArray, cHj(), this.vIE);
    int i;
    if ((paramArrayOfSparseArray instanceof e))
    {
      com.tencent.mm.cf.a.d[] arrayOfd = ((e)paramArrayOfSparseArray).uEL;
      int k = arrayOfd.length;
      i = 0;
      while (i < k)
      {
        arrayOfd[i].FD(5000);
        paramHashSet[i] = new SparseArray();
        int j = 0;
        while (arrayOfd[i].moveToNext())
        {
          paramHashSet[i].put(j, arrayOfd[i].getString(0));
          j += 1;
        }
        i += 1;
      }
      this.vIB = arrayOfd[0].getCount();
    }
    for (;;)
    {
      paramArrayOfSparseArray.close();
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - l));
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
  
  public final ArrayList<com.tencent.mm.storage.f> ag(ArrayList<String> paramArrayList)
  {
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ((List)localObject).add((String)paramArrayList.get(i));
      i += 1;
    }
    paramArrayList = new ArrayList(((List)localObject).size());
    au.Hx();
    localObject = c.Fw().du((List)localObject);
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
      localf.d((Cursor)localObject);
      paramArrayList.add(localf);
    }
    ((Cursor)localObject).close();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - l));
    return paramArrayList;
  }
  
  protected String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    if (paramInt < this.vIB) {
      localObject = getString(R.l.address_favour_contact_catalog_name);
    }
    String str;
    do
    {
      return localObject;
      if (paramf.field_showHead == 31) {
        return "";
      }
      if (paramf.field_showHead == 123) {
        return "#";
      }
      if (paramf.field_showHead == 33) {
        return getString(R.l.address_application_account_catalog_name);
      }
      if (paramf.field_showHead == 43) {
        return getString(R.l.room_head_name);
      }
      if (paramf.field_showHead == 32) {
        return getString(R.l.address_favour_contact_catalog_name);
      }
      str = (String)this.vIK.get(paramf.field_showHead);
      localObject = str;
    } while (str != null);
    Object localObject = String.valueOf((char)paramf.field_showHead);
    this.vIK.put(paramf.field_showHead, localObject);
    return localObject;
  }
  
  protected Cursor cHk()
  {
    long l = System.currentTimeMillis();
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add("weixin");
    au.Hx();
    localObject = c.Fw().a(this.vIs, this.vIt, this.dru, (List)localObject, cHj(), this.vIE);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - l));
    return localObject;
  }
  
  protected final void cHl()
  {
    int k = getCount();
    if (k == 0) {
      return;
    }
    this.vIB = cyb();
    if (this.ves != null)
    {
      this.vIx = s.a(this.vIs, this.vIt, this.dru, this.ves);
      this.vIy = s.a(this.vIs, this.vIt, this.ves, this.dru);
    }
    for (;;)
    {
      this.vIA.clear();
      Object localObject1 = this.vIx;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        k = localObject1[i];
        this.vIA.add(Integer.valueOf(k - 1));
        i += 1;
      }
      break;
      long l;
      if (cxa())
      {
        l = System.currentTimeMillis();
        localObject1 = new HashSet();
        this.vIx = new int[30];
        this.vIy = new String[30];
        j = this.vIB;
        i = 0;
        if (j < k)
        {
          Object localObject2 = (com.tencent.mm.storage.f)FC(j);
          if (localObject2 != null)
          {
            localObject2 = b((com.tencent.mm.storage.f)localObject2, j);
            if (!((HashSet)localObject1).add(localObject2)) {
              break label248;
            }
            this.vIx[i] = (j - this.vIB);
            this.vIy[i] = localObject2;
            i += 1;
          }
          label248:
          for (;;)
          {
            j += 1;
            break;
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
          }
        }
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - l) + "favourCount : " + this.vIB);
      }
      else
      {
        l = System.currentTimeMillis();
        this.vIx = s.b(this.vIs, this.vIt, this.dru, this.feq);
        this.vIy = s.a(this.vIs, this.vIt, this.feq, this.dru);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - l));
      }
    }
  }
  
  public final void cHm()
  {
    this.hZg.bdc();
  }
  
  public final void cHn()
  {
    super.f(null, 1);
  }
  
  public final com.tencent.mm.cf.a.d<String> cyc()
  {
    return (com.tencent.mm.cf.a.d)cHk();
  }
  
  public final void dJ(String paramString, int paramInt)
  {
    if (paramInt == 5) {
      this.vIM.add(paramString);
    }
    super.f(paramString, paramInt);
  }
  
  public final void detach()
  {
    if (this.ffG != null)
    {
      this.ffG.detach();
      this.ffG = null;
    }
  }
  
  public final void ej(List<String> paramList)
  {
    if (this.type != 2) {
      paramList.add(q.Gj());
    }
    au.Hx();
    Object localObject = c.FE().Ic("@t.qq.com");
    if (localObject != null) {
      paramList.add(((bq)localObject).name);
    }
    if ((this.type == 3) || (this.type == 5) || (this.type == 4) || (this.type == 1) || (this.type == 0))
    {
      localObject = s.GU().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add((String)((Iterator)localObject).next());
      }
    }
    paramList.add("blogapp");
    this.dru = paramList;
  }
  
  public int getCount()
  {
    return super.getCount();
  }
  
  public final int getPositionForSection(int paramInt)
  {
    int i = paramInt;
    if (this.vIx != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.vIx.length) {
          i = this.vIx[paramInt];
        }
      }
    }
    return this.vIB + i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = -1;
    int i;
    if (!this.vII)
    {
      i = 0;
      while (i < 8)
      {
        this.vIH.add(com.tencent.mm.ui.y.gt(this.context).inflate(R.i.address_new_item_myview, null));
        i += 1;
      }
      this.vII = true;
    }
    com.tencent.mm.storage.f localf = (com.tencent.mm.storage.f)FC(paramInt);
    a.b localb;
    label267:
    Object localObject;
    label346:
    int k;
    if (paramView == null) {
      if (this.vIH.size() > 0)
      {
        paramView = (View)this.vIH.getFirst();
        this.vIH.removeFirst();
        localb = new a.b();
        localb.lvb = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
        localb.lvc = ((TextView)paramView.findViewById(R.h.contactitem_signature));
        localb.lBJ = ((AddressView)paramView.findViewById(R.h.myview));
        localb.vIO = ((TextView)paramView.findViewById(R.h.contactitem_account_delete));
        localb.vIP = paramView.findViewById(R.h.contactitem_selector);
        localb.vIQ = ((TextView)paramView.findViewById(R.h.openim_contact_desc));
        paramViewGroup = localb.vIP.getLayoutParams();
        paramViewGroup.height = ((int)(com.tencent.mm.cb.a.ab(this.context, R.f.ContactListHeight) * com.tencent.mm.cb.a.fg(this.context)));
        localb.vIP.setLayoutParams(paramViewGroup);
        if (this.vIz != null) {
          this.vIz.dnR.a(localb.lBJ);
        }
        paramView.setTag(localb);
        paramViewGroup = paramView;
        if (localf != null)
        {
          au.Hx();
          paramView = c.Fw().abl(localf.field_username);
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AddressAdapter", "user:%s, remark:%s", new Object[] { paramView.field_username, paramView.field_conRemark });
          paramView = (com.tencent.mm.storage.f)FC(paramInt - 1);
          localObject = (com.tencent.mm.storage.f)FC(paramInt + 1);
          if (paramView != null) {
            break label661;
          }
          i = -1;
          k = a(localf, paramInt);
          if (localObject != null) {
            break label674;
          }
          label360:
          if (!this.vIC) {
            break label735;
          }
          if (paramInt != 0) {
            break label688;
          }
          paramView = b(localf, paramInt);
          if (ah.bl(paramView)) {
            break label735;
          }
          localb.lvb.setVisibility(0);
          localb.lvb.setText(paramView);
          label404:
          if ((!this.vIC) || (k == j)) {
            localb.vIP.setBackgroundResource(R.g.list_item_normal);
          }
          com.tencent.mm.pluginsdk.ui.a.b.a(localb.lBJ, localf.field_username);
          if (localf.field_verifyFlag == 0) {
            break label772;
          }
          if (am.a.dVA == null) {
            break label760;
          }
          paramView = am.a.dVA.hM(localf.field_verifyFlag);
          if (paramView == null) {
            break label748;
          }
          paramView = com.tencent.mm.ai.m.lk(paramView);
          localb.lBJ.setMaskBitmap(paramView);
          label488:
          localb.lBJ.updateTextColors();
          paramView = localf.umR;
          if (paramView != null) {
            break label936;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (ad.aaU(localf.field_username))
        {
          paramView = ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).d(ae.getContext(), localf.Bq(), com.tencent.mm.cb.a.aa(this.context, R.f.NormalTextSize));
          localObject = paramView;
          if (paramView == null) {
            localObject = "";
          }
          localb.lBJ.setName((CharSequence)localObject);
          localb.lBJ.setDescription(ah.pm(localf.field_remarkDesc));
          a(localf, localb);
          localb.lBJ.updatePositionFlag();
          localObject = localb.lBJ;
          if (localb.lBJ.getNickName() != null) {
            break label948;
          }
          paramView = "";
          ((AddressView)localObject).setContentDescription(paramView);
          return paramViewGroup;
          paramView = View.inflate(this.context, R.i.address_new_item_myview, null);
          break;
          localb = (a.b)paramView.getTag();
          paramViewGroup = paramView;
          break label267;
          label661:
          i = a(paramView, paramInt - 1);
          break label346;
          label674:
          j = a((com.tencent.mm.storage.f)localObject, paramInt + 1);
          break label360;
          label688:
          if ((paramInt > 0) && (k != i))
          {
            paramView = b(localf, paramInt);
            if (!ah.bl(paramView))
            {
              localb.lvb.setVisibility(0);
              localb.lvb.setText(paramView);
              break label404;
            }
          }
          label735:
          localb.lvb.setVisibility(8);
          break label404;
          label748:
          localb.lBJ.setMaskBitmap(null);
          break label488;
          label760:
          localb.lBJ.setMaskBitmap(null);
          break label488;
          label772:
          localb.lBJ.setMaskBitmap(null);
          break label488;
        }
        Context localContext = this.context;
        paramView = localf.Bq();
        localObject = localf.field_username;
        if ((paramView != null) && (paramView.length() > 0))
        {
          localObject = paramView;
          if ("".length() > 0)
          {
            localObject = paramView;
            if (!"".equals(paramView))
            {
              this.sb.append(paramView);
              this.sb.append("(");
              this.sb.append("");
              this.sb.append(")");
              localObject = this.sb.toString();
              this.sb.delete(0, this.sb.length());
            }
          }
          paramView = com.tencent.mm.pluginsdk.ui.d.j.b(localContext, (CharSequence)localObject, com.tencent.mm.cb.a.aa(this.context, R.f.NormalTextSize));
          continue;
        }
        paramView = (View)localObject;
        continue;
      }
      catch (Exception paramView)
      {
        paramView = null;
        continue;
      }
      label936:
      localb.lBJ.setName(paramView);
      continue;
      label948:
      paramView = localb.lBJ.getNickName().toString();
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.vIG = q.Gj();
    if (this.vIx == null) {
      cHl();
    }
    if (getCount() == 0)
    {
      super.notifyDataSetChanged();
      return;
    }
    this.vIB = cyb();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[] { Integer.valueOf(this.vIB) });
    super.notifyDataSetChanged();
  }
  
  public final void pause()
  {
    this.vIM.clear();
    super.pause();
  }
  
  public final void s(Fragment paramFragment)
  {
    if ((paramFragment instanceof AddressUI.a)) {
      this.vIz = ((AddressUI.a)paramFragment);
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
 * Qualified Name:     com.tencent.mm.ui.contact.a
 * JD-Core Version:    0.7.0.1
 */
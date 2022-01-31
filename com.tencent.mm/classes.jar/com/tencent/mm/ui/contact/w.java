package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class w
  extends o
  implements m.b
{
  private final String bOL;
  private Cursor eYd;
  private HashMap<String, Integer> vJH = null;
  private SparseArray<String> vJI = null;
  private w.a vMX;
  
  public w(String paramString, MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean)
  {
    super(paramMMBaseSelectContactUI, paramList, false, paramBoolean, false);
    this.bOL = paramString;
    this.vMX = new w.a();
    ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().a(this);
    xO();
  }
  
  private static ArrayList<ad> adT(String paramString)
  {
    au.Hx();
    paramString = c.Fw().abi(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString.moveToFirst()) {
      do
      {
        ad localad = new ad();
        localad.d(paramString);
        localArrayList.add(localad);
      } while (paramString.moveToNext());
    }
    paramString.close();
    return localArrayList;
  }
  
  private void xO()
  {
    label28:
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    int[] arrayOfInt;
    int i;
    int j;
    if (this.vJH != null)
    {
      this.vJH.clear();
      if (this.vJI == null) {
        break label369;
      }
      this.vJI.clear();
      localArrayList = new ArrayList();
      localObject1 = ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getAppIdInfoStg().oW(this.bOL);
      au.Hx();
      localArrayList.add(c.Fw().a(this.dru, x.fB(ae.getContext()), (List)localObject1));
      adT("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
      au.Hx();
      localObject2 = c.Fw().b(this.dru, x.fB(ae.getContext()), (List)localObject1);
      arrayOfInt = new int[((Cursor)localObject2).getCount()];
      if (((Cursor)localObject2).moveToFirst())
      {
        i = 0;
        do
        {
          arrayOfInt[i] = ((Cursor)localObject2).getInt(0);
          i += 1;
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
      au.Hx();
      localObject1 = c.Fw().c(this.dru, x.fB(ae.getContext()), (List)localObject1);
      if (((Cursor)localObject1).moveToFirst())
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      localObject2 = new ad();
      ((ad)localObject2).d((Cursor)localObject1);
      localObject2 = ((b)com.tencent.mm.kernel.g.r(b.class)).aK(this.bOL, ((ao)localObject2).field_descWordingId);
      this.vJH.put(localObject2, Integer.valueOf(j));
      this.vJI.put(j, localObject2);
      j = arrayOfInt[i] + (j + 1);
      if (!((Cursor)localObject1).moveToNext())
      {
        ((Cursor)localObject1).close();
        y.d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", new Object[] { this.vJH.toString() });
        this.eYd = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        return;
        this.vJH = new HashMap();
        break;
        label369:
        this.vJI = new SparseArray();
        break label28;
      }
      i += 1;
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    xO();
    notifyDataSetChanged();
  }
  
  public final int adP(String paramString)
  {
    int j = -1;
    int i;
    if (paramString.equals("↑")) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.vJH == null);
      i = j;
    } while (!this.vJH.containsKey(paramString));
    return ((Integer)this.vJH.get(paramString)).intValue() + this.vLI.getContentLV().getHeaderViewsCount();
  }
  
  protected final boolean c(a parama)
  {
    int i = parama.position;
    return this.vJI.indexOfKey(i + 1) >= 0;
  }
  
  public final void finish()
  {
    super.finish();
    y.i("MicroMsg.OpenIMSelectContactAdapter", "finish!");
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
    ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().b(this);
  }
  
  public final int getCount()
  {
    return this.eYd.getCount() + this.vJH.size();
  }
  
  protected final a jQ(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (this.vJI.indexOfKey(paramInt) >= 0)
    {
      localObject1 = (String)this.vJI.get(paramInt);
      localObject2 = new com.tencent.mm.ui.contact.a.g(paramInt);
      ((com.tencent.mm.ui.contact.a.g)localObject2).kDu = ((String)localObject1);
      return localObject2;
    }
    int k = paramInt;
    int i = 0;
    int j;
    int m;
    do
    {
      j = i;
      if (i > this.vJI.size()) {
        break;
      }
      j = i;
      if (this.vJI.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.eYd.moveToPosition(i))
    {
      y.d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject1 = new ad();
      ((ad)localObject1).d(this.eYd);
      localObject2 = new com.tencent.mm.ui.contact.a.d(paramInt);
      ((a)localObject2).dnp = ((ad)localObject1);
      ((a)localObject2).vLJ = bBJ();
      ((a)localObject2).vLK = this.vLK;
      ((com.tencent.mm.ui.contact.a.d)localObject2).vOt = true;
      return localObject2;
    }
    y.i("MicroMsg.OpenIMSelectContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.w
 * JD-Core Version:    0.7.0.1
 */
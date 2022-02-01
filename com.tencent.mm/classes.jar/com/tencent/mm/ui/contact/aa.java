package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class aa
  extends q
  implements n.b
{
  private HashMap<String, Integer> Kkm;
  private SparseArray<String> Kkn;
  private a KoQ;
  private final String duW;
  private Cursor iVJ;
  
  public aa(String paramString, MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean)
  {
    super(paramMMBaseSelectContactUI, paramList, false, paramBoolean, false);
    AppMethodBeat.i(37935);
    this.Kkm = null;
    this.Kkn = null;
    this.duW = paramString;
    this.KoQ = new a();
    ((l)g.ab(l.class)).azp().a(this);
    Zh();
    AppMethodBeat.o(37935);
  }
  
  private static ArrayList<am> aWT(String paramString)
  {
    AppMethodBeat.i(37936);
    ba.aBQ();
    paramString = c.azp().aTi(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString.moveToFirst()) {
      do
      {
        am localam = new am();
        localam.convertFrom(paramString);
        localArrayList.add(localam);
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(37936);
    return localArrayList;
  }
  
  private void cR(int paramInt, String paramString)
  {
    AppMethodBeat.i(37938);
    this.Kkm.put(paramString, Integer.valueOf(paramInt));
    this.Kkn.put(paramInt, paramString);
    AppMethodBeat.o(37938);
  }
  
  public final void Zh()
  {
    AppMethodBeat.i(37937);
    label33:
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    int[] arrayOfInt;
    int i;
    int j;
    if (this.Kkm != null)
    {
      this.Kkm.clear();
      if (this.Kkn == null) {
        break label358;
      }
      this.Kkn.clear();
      localArrayList = new ArrayList();
      localObject1 = ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAppIdInfoStg().IH(this.duW);
      ba.aBQ();
      localArrayList.add(c.azp().a(this.fSL, ac.iM(aj.getContext()), (List)localObject1));
      aWT("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
      ba.aBQ();
      localObject2 = c.azp().b(this.fSL, ac.iM(aj.getContext()), (List)localObject1);
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
      ba.aBQ();
      localObject1 = c.azp().c(this.fSL, ac.iM(aj.getContext()), (List)localObject1);
      if (((Cursor)localObject1).moveToFirst())
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      localObject2 = new am();
      ((am)localObject2).convertFrom((Cursor)localObject1);
      cR(j, ((b)g.ab(b.class)).bC(this.duW, ((aw)localObject2).field_descWordingId));
      j = arrayOfInt[i] + (j + 1);
      if (!((Cursor)localObject1).moveToNext())
      {
        ((Cursor)localObject1).close();
        ad.d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", new Object[] { this.Kkm.toString() });
        this.iVJ = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.o(37937);
        return;
        this.Kkm = new HashMap();
        break;
        label358:
        this.Kkn = new SparseArray();
        break label33;
      }
      i += 1;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(37943);
    Zh();
    notifyDataSetChanged();
    AppMethodBeat.o(37943);
  }
  
  public final int aWM(String paramString)
  {
    AppMethodBeat.i(37939);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(37939);
      return 0;
    }
    if (this.Kkm != null)
    {
      if (this.Kkm.containsKey(paramString))
      {
        int i = ((Integer)this.Kkm.get(paramString)).intValue();
        int j = this.KmO.getContentLV().getHeaderViewsCount();
        AppMethodBeat.o(37939);
        return i + j;
      }
      AppMethodBeat.o(37939);
      return -1;
    }
    AppMethodBeat.o(37939);
    return -1;
  }
  
  protected final boolean c(a parama)
  {
    AppMethodBeat.i(37944);
    int i = parama.position;
    if (this.Kkn.indexOfKey(i + 1) >= 0)
    {
      AppMethodBeat.o(37944);
      return true;
    }
    AppMethodBeat.o(37944);
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(37942);
    super.finish();
    ad.i("MicroMsg.OpenIMSelectContactAdapter", "finish!");
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    ((l)g.ab(l.class)).azp().b(this);
    AppMethodBeat.o(37942);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37940);
    int i = this.iVJ.getCount();
    int j = this.Kkm.size();
    AppMethodBeat.o(37940);
    return i + j;
  }
  
  protected final a rh(int paramInt)
  {
    AppMethodBeat.i(37941);
    Object localObject1;
    Object localObject2;
    if (this.Kkn.indexOfKey(paramInt) >= 0)
    {
      localObject1 = (String)this.Kkn.get(paramInt);
      localObject2 = new h(paramInt);
      ((h)localObject2).header = ((String)localObject1);
      AppMethodBeat.o(37941);
      return localObject2;
    }
    int i = 0;
    int k = paramInt;
    int j;
    int m;
    do
    {
      j = i;
      if (i > this.Kkn.size()) {
        break;
      }
      j = i;
      if (this.Kkn.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      i = j;
      k = m;
    } while (m >= 0);
    i = paramInt - j;
    if (this.iVJ.moveToPosition(i))
    {
      ad.d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject1 = new am();
      ((am)localObject1).convertFrom(this.iVJ);
      localObject2 = new e(paramInt);
      ((a)localObject2).contact = ((am)localObject1);
      ((a)localObject2).KmP = dQK();
      ((a)localObject2).KmQ = this.KmQ;
      ((e)localObject2).KqU = true;
      AppMethodBeat.o(37941);
      return localObject2;
    }
    ad.i("MicroMsg.OpenIMSelectContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(37941);
    return null;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.aa
 * JD-Core Version:    0.7.0.1
 */
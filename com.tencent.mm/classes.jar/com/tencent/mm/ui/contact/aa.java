package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class aa
  extends q
  implements n.b
{
  private HashMap<String, Integer> KGG;
  private SparseArray<String> KGH;
  private a KLk;
  private final String dwb;
  private Cursor iYC;
  
  public aa(String paramString, MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean)
  {
    super(paramMMBaseSelectContactUI, paramList, false, paramBoolean, false);
    AppMethodBeat.i(37935);
    this.KGG = null;
    this.KGH = null;
    this.dwb = paramString;
    this.KLk = new a();
    ((l)g.ab(l.class)).azF().a(this);
    Zq();
    AppMethodBeat.o(37935);
  }
  
  private static ArrayList<an> aYu(String paramString)
  {
    AppMethodBeat.i(37936);
    bc.aCg();
    paramString = c.azF().aUJ(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString.moveToFirst()) {
      do
      {
        an localan = new an();
        localan.convertFrom(paramString);
        localArrayList.add(localan);
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(37936);
    return localArrayList;
  }
  
  private void cR(int paramInt, String paramString)
  {
    AppMethodBeat.i(37938);
    this.KGG.put(paramString, Integer.valueOf(paramInt));
    this.KGH.put(paramInt, paramString);
    AppMethodBeat.o(37938);
  }
  
  public final void Zq()
  {
    AppMethodBeat.i(37937);
    label33:
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    int[] arrayOfInt;
    int i;
    int j;
    if (this.KGG != null)
    {
      this.KGG.clear();
      if (this.KGH == null) {
        break label358;
      }
      this.KGH.clear();
      localArrayList = new ArrayList();
      localObject1 = ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAppIdInfoStg().Jg(this.dwb);
      bc.aCg();
      localArrayList.add(c.azF().a(this.fUR, ad.iR(ak.getContext()), (List)localObject1));
      aYu("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
      bc.aCg();
      localObject2 = c.azF().b(this.fUR, ad.iR(ak.getContext()), (List)localObject1);
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
      bc.aCg();
      localObject1 = c.azF().c(this.fUR, ad.iR(ak.getContext()), (List)localObject1);
      if (((Cursor)localObject1).moveToFirst())
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      localObject2 = new an();
      ((an)localObject2).convertFrom((Cursor)localObject1);
      cR(j, ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).bC(this.dwb, ((aw)localObject2).field_descWordingId));
      j = arrayOfInt[i] + (j + 1);
      if (!((Cursor)localObject1).moveToNext())
      {
        ((Cursor)localObject1).close();
        ae.d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", new Object[] { this.KGG.toString() });
        this.iYC = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.o(37937);
        return;
        this.KGG = new HashMap();
        break;
        label358:
        this.KGH = new SparseArray();
        break label33;
      }
      i += 1;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(37943);
    Zq();
    notifyDataSetChanged();
    AppMethodBeat.o(37943);
  }
  
  public final int aYn(String paramString)
  {
    AppMethodBeat.i(37939);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(37939);
      return 0;
    }
    if (this.KGG != null)
    {
      if (this.KGG.containsKey(paramString))
      {
        int i = ((Integer)this.KGG.get(paramString)).intValue();
        int j = this.KJi.getContentLV().getHeaderViewsCount();
        AppMethodBeat.o(37939);
        return i + j;
      }
      AppMethodBeat.o(37939);
      return -1;
    }
    AppMethodBeat.o(37939);
    return -1;
  }
  
  protected final boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(37944);
    int i = parama.position;
    if (this.KGH.indexOfKey(i + 1) >= 0)
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
    ae.i("MicroMsg.OpenIMSelectContactAdapter", "finish!");
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    ((l)g.ab(l.class)).azF().b(this);
    AppMethodBeat.o(37942);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37940);
    int i = this.iYC.getCount();
    int j = this.KGG.size();
    AppMethodBeat.o(37940);
    return i + j;
  }
  
  protected final com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    AppMethodBeat.i(37941);
    Object localObject1;
    Object localObject2;
    if (this.KGH.indexOfKey(paramInt) >= 0)
    {
      localObject1 = (String)this.KGH.get(paramInt);
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
      if (i > this.KGH.size()) {
        break;
      }
      j = i;
      if (this.KGH.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      i = j;
      k = m;
    } while (m >= 0);
    i = paramInt - j;
    if (this.iYC.moveToPosition(i))
    {
      ae.d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject1 = new an();
      ((an)localObject1).convertFrom(this.iYC);
      localObject2 = new e(paramInt);
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((an)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).KJj = dUh();
      ((com.tencent.mm.ui.contact.a.a)localObject2).KJk = this.KJk;
      ((e)localObject2).KNo = true;
      AppMethodBeat.o(37941);
      return localObject2;
    }
    ae.i("MicroMsg.OpenIMSelectContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(37941);
    return null;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.aa
 * JD-Core Version:    0.7.0.1
 */
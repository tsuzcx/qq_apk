package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ac
  extends r
  implements MStorageEx.IOnStorageChange
{
  private HashMap<String, Integer> Xqo;
  private SparseArray<String> Xqp;
  private a Xvd;
  private final String appid;
  private Cursor mNt;
  
  public ac(String paramString, MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean)
  {
    super(paramMMBaseSelectContactUI, paramList, false, paramBoolean, false);
    AppMethodBeat.i(37935);
    this.Xqo = null;
    this.Xqp = null;
    this.appid = paramString;
    this.Xvd = new a();
    ((n)h.ae(n.class)).bbL().add(this);
    ate();
    AppMethodBeat.o(37935);
  }
  
  private static ArrayList<as> bAb(String paramString)
  {
    AppMethodBeat.i(37936);
    bh.beI();
    paramString = c.bbL().bwf(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString.moveToFirst()) {
      do
      {
        as localas = new as();
        localas.convertFrom(paramString);
        localArrayList.add(localas);
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(37936);
    return localArrayList;
  }
  
  private void dl(int paramInt, String paramString)
  {
    AppMethodBeat.i(37938);
    this.Xqo.put(paramString, Integer.valueOf(paramInt));
    this.Xqp.put(paramInt, paramString);
    AppMethodBeat.o(37938);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(37937);
    label33:
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    int[] arrayOfInt;
    int i;
    int j;
    if (this.Xqo != null)
    {
      this.Xqo.clear();
      if (this.Xqp == null) {
        break label358;
      }
      this.Xqp.clear();
      localArrayList = new ArrayList();
      localObject1 = ((PluginOpenIM)h.ag(PluginOpenIM.class)).getAppIdInfoStg().ZF(this.appid);
      bh.beI();
      localArrayList.add(c.bbL().a(csq(), LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), (List)localObject1));
      bAb("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
      bh.beI();
      localObject2 = c.bbL().b(csq(), LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), (List)localObject1);
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
      bh.beI();
      localObject1 = c.bbL().c(csq(), LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), (List)localObject1);
      if (((Cursor)localObject1).moveToFirst())
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      localObject2 = new as();
      ((as)localObject2).convertFrom((Cursor)localObject1);
      dl(j, ((com.tencent.mm.openim.a.a)h.ae(com.tencent.mm.openim.a.a.class)).bR(this.appid, ((ax)localObject2).field_descWordingId));
      j = arrayOfInt[i] + (j + 1);
      if (!((Cursor)localObject1).moveToNext())
      {
        ((Cursor)localObject1).close();
        Log.d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", new Object[] { this.Xqo.toString() });
        this.mNt = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.o(37937);
        return;
        this.Xqo = new HashMap();
        break;
        label358:
        this.Xqp = new SparseArray();
        break label33;
      }
      i += 1;
    }
  }
  
  public final int bzR(String paramString)
  {
    AppMethodBeat.i(37939);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(37939);
      return 0;
    }
    if (this.Xqo != null)
    {
      if (this.Xqo.containsKey(paramString))
      {
        int i = ((Integer)this.Xqo.get(paramString)).intValue();
        int j = this.XsW.getContentLV().getHeaderViewsCount();
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
    if (this.Xqp.indexOfKey(i + 1) >= 0)
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
    Log.i("MicroMsg.OpenIMSelectContactAdapter", "finish!");
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    ((n)h.ae(n.class)).bbL().remove(this);
    AppMethodBeat.o(37942);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37940);
    int i = this.mNt.getCount();
    int j = this.Xqo.size();
    AppMethodBeat.o(37940);
    return i + j;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(37943);
    ate();
    notifyDataSetChanged();
    AppMethodBeat.o(37943);
  }
  
  protected final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(37941);
    Object localObject1;
    Object localObject2;
    if (this.Xqp.indexOfKey(paramInt) >= 0)
    {
      localObject1 = (String)this.Xqp.get(paramInt);
      localObject2 = new j(paramInt);
      ((j)localObject2).header = ((String)localObject1);
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
      if (i > this.Xqp.size()) {
        break;
      }
      j = i;
      if (this.Xqp.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      i = j;
      k = m;
    } while (m >= 0);
    i = paramInt - j;
    if (this.mNt.moveToPosition(i))
    {
      Log.d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject1 = new as();
      ((as)localObject1).convertFrom(this.mNt);
      localObject2 = new f(paramInt);
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((as)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).XsX = fJk();
      ((com.tencent.mm.ui.contact.a.a)localObject2).XsY = hUO();
      ((f)localObject2).XxL = true;
      AppMethodBeat.o(37941);
      return localObject2;
    }
    Log.i("MicroMsg.OpenIMSelectContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(37941);
    return null;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ac
 * JD-Core Version:    0.7.0.1
 */
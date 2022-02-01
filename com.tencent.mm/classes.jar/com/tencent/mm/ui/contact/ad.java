package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ad
  extends r
  implements MStorageEx.IOnStorageChange
{
  private HashMap<String, Integer> JUK;
  private SparseArray<String> JUL;
  private a afhb;
  private final String appid;
  private Cursor pKb;
  
  public ad(String paramString, MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean)
  {
    super(paramMMBaseSelectContactUI, paramList, false, paramBoolean, false);
    AppMethodBeat.i(37935);
    this.JUK = null;
    this.JUL = null;
    this.appid = paramString;
    this.afhb = new a();
    ((n)h.ax(n.class)).bzA().add(this);
    aNm();
    AppMethodBeat.o(37935);
  }
  
  private static ArrayList<au> bBW(String paramString)
  {
    AppMethodBeat.i(37936);
    bh.bCz();
    paramString = c.bzA().bxt(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString.moveToFirst()) {
      do
      {
        au localau = new au();
        localau.convertFrom(paramString);
        localArrayList.add(localau);
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(37936);
    return localArrayList;
  }
  
  private void ee(int paramInt, String paramString)
  {
    AppMethodBeat.i(37938);
    this.JUK.put(paramString, Integer.valueOf(paramInt));
    this.JUL.put(paramInt, paramString);
    AppMethodBeat.o(37938);
  }
  
  public final int aJM(String paramString)
  {
    AppMethodBeat.i(37939);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(37939);
      return 0;
    }
    if (this.JUK != null)
    {
      if (this.JUK.containsKey(paramString))
      {
        int i = ((Integer)this.JUK.get(paramString)).intValue();
        int j = this.afex.getContentLV().getHeaderViewsCount();
        AppMethodBeat.o(37939);
        return i + j;
      }
      AppMethodBeat.o(37939);
      return -1;
    }
    AppMethodBeat.o(37939);
    return -1;
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(37937);
    label33:
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    int[] arrayOfInt;
    int i;
    int j;
    if (this.JUK != null)
    {
      this.JUK.clear();
      if (this.JUL == null) {
        break label358;
      }
      this.JUL.clear();
      localArrayList = new ArrayList();
      localObject1 = ((PluginOpenIM)h.az(PluginOpenIM.class)).getAppIdInfoStg().RU(this.appid);
      bh.bCz();
      localArrayList.add(c.bzA().a(cVa(), LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), (List)localObject1));
      bBW("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
      bh.bCz();
      localObject2 = c.bzA().b(cVa(), LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), (List)localObject1);
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
      bh.bCz();
      localObject1 = c.bzA().c(cVa(), LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), (List)localObject1);
      if (((Cursor)localObject1).moveToFirst())
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      localObject2 = new au();
      ((au)localObject2).convertFrom((Cursor)localObject1);
      ee(j, ((e)h.ax(e.class)).cc(this.appid, ((az)localObject2).field_descWordingId));
      j = arrayOfInt[i] + (j + 1);
      if (!((Cursor)localObject1).moveToNext())
      {
        ((Cursor)localObject1).close();
        Log.d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", new Object[] { this.JUK.toString() });
        this.pKb = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.o(37937);
        return;
        this.JUK = new HashMap();
        break;
        label358:
        this.JUL = new SparseArray();
        break label33;
      }
      i += 1;
    }
  }
  
  protected final boolean d(a parama)
  {
    AppMethodBeat.i(37944);
    int i = parama.position;
    if (this.JUL.indexOfKey(i + 1) >= 0)
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
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    ((n)h.ax(n.class)).bzA().remove(this);
    AppMethodBeat.o(37942);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37940);
    int i = this.pKb.getCount();
    int j = this.JUK.size();
    AppMethodBeat.o(37940);
    return i + j;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(37943);
    aNm();
    notifyDataSetChanged();
    AppMethodBeat.o(37943);
  }
  
  protected final a yk(int paramInt)
  {
    AppMethodBeat.i(37941);
    Object localObject1;
    Object localObject2;
    if (this.JUL.indexOfKey(paramInt) >= 0)
    {
      localObject1 = (String)this.JUL.get(paramInt);
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
      if (i > this.JUL.size()) {
        break;
      }
      j = i;
      if (this.JUL.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      i = j;
      k = m;
    } while (m >= 0);
    i = paramInt - j;
    if (this.pKb.moveToPosition(i))
    {
      Log.d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject1 = new au();
      ((au)localObject1).convertFrom(this.pKb);
      localObject2 = new f(paramInt);
      ((a)localObject2).contact = ((au)localObject1);
      ((a)localObject2).afey = gZe();
      ((a)localObject2).afez = jyD();
      ((f)localObject2).JXq = true;
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
 * Qualified Name:     com.tencent.mm.ui.contact.ad
 * JD-Core Version:    0.7.0.1
 */
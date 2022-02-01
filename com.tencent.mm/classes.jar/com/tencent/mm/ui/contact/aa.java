package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class aa
  extends q
  implements MStorageEx.IOnStorageChange
{
  private HashMap<String, Integer> PTD;
  private SparseArray<String> PTE;
  private a PYl;
  private final String dNI;
  private Cursor jWh;
  
  public aa(String paramString, MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean)
  {
    super(paramMMBaseSelectContactUI, paramList, false, paramBoolean, false);
    AppMethodBeat.i(37935);
    this.PTD = null;
    this.PTE = null;
    this.dNI = paramString;
    this.PYl = new a();
    ((l)g.af(l.class)).aSN().add(this);
    and();
    AppMethodBeat.o(37935);
  }
  
  private static ArrayList<as> bny(String paramString)
  {
    AppMethodBeat.i(37936);
    bg.aVF();
    paramString = c.aSN().bjI(paramString);
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
  
  private void dm(int paramInt, String paramString)
  {
    AppMethodBeat.i(37938);
    this.PTD.put(paramString, Integer.valueOf(paramInt));
    this.PTE.put(paramInt, paramString);
    AppMethodBeat.o(37938);
  }
  
  public final void and()
  {
    AppMethodBeat.i(37937);
    label33:
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    int[] arrayOfInt;
    int i;
    int j;
    if (this.PTD != null)
    {
      this.PTD.clear();
      if (this.PTE == null) {
        break label358;
      }
      this.PTE.clear();
      localArrayList = new ArrayList();
      localObject1 = ((PluginOpenIM)g.ah(PluginOpenIM.class)).getAppIdInfoStg().Sd(this.dNI);
      bg.aVF();
      localArrayList.add(c.aSN().a(this.gzY, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), (List)localObject1));
      bny("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
      bg.aVF();
      localObject2 = c.aSN().b(this.gzY, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), (List)localObject1);
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
      bg.aVF();
      localObject1 = c.aSN().c(this.gzY, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), (List)localObject1);
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
      dm(j, ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).bN(this.dNI, ((ax)localObject2).field_descWordingId));
      j = arrayOfInt[i] + (j + 1);
      if (!((Cursor)localObject1).moveToNext())
      {
        ((Cursor)localObject1).close();
        Log.d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", new Object[] { this.PTD.toString() });
        this.jWh = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.o(37937);
        return;
        this.PTD = new HashMap();
        break;
        label358:
        this.PTE = new SparseArray();
        break label33;
      }
      i += 1;
    }
  }
  
  public final int bnr(String paramString)
  {
    AppMethodBeat.i(37939);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(37939);
      return 0;
    }
    if (this.PTD != null)
    {
      if (this.PTD.containsKey(paramString))
      {
        int i = ((Integer)this.PTD.get(paramString)).intValue();
        int j = this.PWg.getContentLV().getHeaderViewsCount();
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
    if (this.PTE.indexOfKey(i + 1) >= 0)
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
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    ((l)g.af(l.class)).aSN().remove(this);
    AppMethodBeat.o(37942);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37940);
    int i = this.jWh.getCount();
    int j = this.PTD.size();
    AppMethodBeat.o(37940);
    return i + j;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(37943);
    and();
    notifyDataSetChanged();
    AppMethodBeat.o(37943);
  }
  
  protected final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(37941);
    Object localObject1;
    Object localObject2;
    if (this.PTE.indexOfKey(paramInt) >= 0)
    {
      localObject1 = (String)this.PTE.get(paramInt);
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
      if (i > this.PTE.size()) {
        break;
      }
      j = i;
      if (this.PTE.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      i = j;
      k = m;
    } while (m >= 0);
    i = paramInt - j;
    if (this.jWh.moveToPosition(i))
    {
      Log.d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject1 = new as();
      ((as)localObject1).convertFrom(this.jWh);
      localObject2 = new e(paramInt);
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((as)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).PWh = eWh();
      ((com.tencent.mm.ui.contact.a.a)localObject2).PWi = this.PWi;
      ((e)localObject2).Qao = true;
      AppMethodBeat.o(37941);
      return localObject2;
    }
    Log.i("MicroMsg.OpenIMSelectContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(37941);
    return null;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.aa
 * JD-Core Version:    0.7.0.1
 */
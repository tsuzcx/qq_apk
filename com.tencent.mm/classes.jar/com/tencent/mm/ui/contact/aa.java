package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
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
  private HashMap<String, Integer> ItG;
  private SparseArray<String> ItH;
  private a Iyi;
  private final String djj;
  private Cursor iCz;
  
  public aa(String paramString, MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean)
  {
    super(paramMMBaseSelectContactUI, paramList, false, paramBoolean, false);
    AppMethodBeat.i(37935);
    this.ItG = null;
    this.ItH = null;
    this.djj = paramString;
    this.Iyi = new a();
    ((k)g.ab(k.class)).awB().a(this);
    WN();
    AppMethodBeat.o(37935);
  }
  
  private static ArrayList<com.tencent.mm.storage.ai> aQY(String paramString)
  {
    AppMethodBeat.i(37936);
    az.ayM();
    paramString = c.awB().aNq(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString.moveToFirst()) {
      do
      {
        com.tencent.mm.storage.ai localai = new com.tencent.mm.storage.ai();
        localai.convertFrom(paramString);
        localArrayList.add(localai);
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(37936);
    return localArrayList;
  }
  
  private void cK(int paramInt, String paramString)
  {
    AppMethodBeat.i(37938);
    this.ItG.put(paramString, Integer.valueOf(paramInt));
    this.ItH.put(paramInt, paramString);
    AppMethodBeat.o(37938);
  }
  
  public final void WN()
  {
    AppMethodBeat.i(37937);
    label33:
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    int[] arrayOfInt;
    int i;
    int j;
    if (this.ItG != null)
    {
      this.ItG.clear();
      if (this.ItH == null) {
        break label358;
      }
      this.ItH.clear();
      localArrayList = new ArrayList();
      localObject1 = ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAppIdInfoStg().Fr(this.djj);
      az.ayM();
      localArrayList.add(c.awB().a(this.fzw, ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext()), (List)localObject1));
      aQY("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
      az.ayM();
      localObject2 = c.awB().b(this.fzw, ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext()), (List)localObject1);
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
      az.ayM();
      localObject1 = c.awB().c(this.fzw, ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext()), (List)localObject1);
      if (((Cursor)localObject1).moveToFirst())
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.storage.ai();
      ((com.tencent.mm.storage.ai)localObject2).convertFrom((Cursor)localObject1);
      cK(j, ((b)g.ab(b.class)).bB(this.djj, ((av)localObject2).field_descWordingId));
      j = arrayOfInt[i] + (j + 1);
      if (!((Cursor)localObject1).moveToNext())
      {
        ((Cursor)localObject1).close();
        ac.d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", new Object[] { this.ItG.toString() });
        this.iCz = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.o(37937);
        return;
        this.ItG = new HashMap();
        break;
        label358:
        this.ItH = new SparseArray();
        break label33;
      }
      i += 1;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(37943);
    WN();
    notifyDataSetChanged();
    AppMethodBeat.o(37943);
  }
  
  public final int aQR(String paramString)
  {
    AppMethodBeat.i(37939);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(37939);
      return 0;
    }
    if (this.ItG != null)
    {
      if (this.ItG.containsKey(paramString))
      {
        int i = ((Integer)this.ItG.get(paramString)).intValue();
        int j = this.Iwg.getContentLV().getHeaderViewsCount();
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
    if (this.ItH.indexOfKey(i + 1) >= 0)
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
    ac.i("MicroMsg.OpenIMSelectContactAdapter", "finish!");
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    ((k)g.ab(k.class)).awB().b(this);
    AppMethodBeat.o(37942);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37940);
    int i = this.iCz.getCount();
    int j = this.ItG.size();
    AppMethodBeat.o(37940);
    return i + j;
  }
  
  protected final a qH(int paramInt)
  {
    AppMethodBeat.i(37941);
    Object localObject1;
    Object localObject2;
    if (this.ItH.indexOfKey(paramInt) >= 0)
    {
      localObject1 = (String)this.ItH.get(paramInt);
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
      if (i > this.ItH.size()) {
        break;
      }
      j = i;
      if (this.ItH.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      i = j;
      k = m;
    } while (m >= 0);
    i = paramInt - j;
    if (this.iCz.moveToPosition(i))
    {
      ac.d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject1 = new com.tencent.mm.storage.ai();
      ((com.tencent.mm.storage.ai)localObject1).convertFrom(this.iCz);
      localObject2 = new e(paramInt);
      ((a)localObject2).contact = ((com.tencent.mm.storage.ai)localObject1);
      ((a)localObject2).Iwh = dFi();
      ((a)localObject2).Iwi = this.Iwi;
      ((e)localObject2).IzO = true;
      AppMethodBeat.o(37941);
      return localObject2;
    }
    ac.i("MicroMsg.OpenIMSelectContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(37941);
    return null;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.aa
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class x
  extends p
  implements n.b
{
  private HashMap<String, Integer> Abd;
  private SparseArray<String> Abe;
  private a AeA;
  private final String cwc;
  private Cursor gqa;
  
  public x(String paramString, MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean)
  {
    super(paramMMBaseSelectContactUI, paramList, false, paramBoolean, false);
    AppMethodBeat.i(33814);
    this.Abd = null;
    this.Abe = null;
    this.cwc = paramString;
    this.AeA = new a();
    ((j)g.E(j.class)).YA().a(this);
    Kg();
    AppMethodBeat.o(33814);
  }
  
  private void Kg()
  {
    AppMethodBeat.i(33816);
    label33:
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    int[] arrayOfInt;
    int i;
    int j;
    if (this.Abd != null)
    {
      this.Abd.clear();
      if (this.Abe == null) {
        break label358;
      }
      this.Abe.clear();
      localArrayList = new ArrayList();
      localObject1 = ((PluginOpenIM)g.G(PluginOpenIM.class)).getAppIdInfoStg().wo(this.cwc);
      aw.aaz();
      localArrayList.add(c.YA().a(this.ejc, aa.gP(ah.getContext()), (List)localObject1));
      auB("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
      aw.aaz();
      localObject2 = c.YA().b(this.ejc, aa.gP(ah.getContext()), (List)localObject1);
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
      aw.aaz();
      localObject1 = c.YA().c(this.ejc, aa.gP(ah.getContext()), (List)localObject1);
      if (((Cursor)localObject1).moveToFirst())
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      localObject2 = new ad();
      ((ad)localObject2).convertFrom((Cursor)localObject1);
      bL(j, ((b)g.E(b.class)).bd(this.cwc, ((aq)localObject2).field_descWordingId));
      j = arrayOfInt[i] + (j + 1);
      if (!((Cursor)localObject1).moveToNext())
      {
        ((Cursor)localObject1).close();
        ab.d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", new Object[] { this.Abd.toString() });
        this.gqa = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.o(33816);
        return;
        this.Abd = new HashMap();
        break;
        label358:
        this.Abe = new SparseArray();
        break label33;
      }
      i += 1;
    }
  }
  
  private static ArrayList<ad> auB(String paramString)
  {
    AppMethodBeat.i(33815);
    aw.aaz();
    paramString = c.YA().art(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString.moveToFirst()) {
      do
      {
        ad localad = new ad();
        localad.convertFrom(paramString);
        localArrayList.add(localad);
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(33815);
    return localArrayList;
  }
  
  private void bL(int paramInt, String paramString)
  {
    AppMethodBeat.i(33817);
    this.Abd.put(paramString, Integer.valueOf(paramInt));
    this.Abe.put(paramInt, paramString);
    AppMethodBeat.o(33817);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(33822);
    Kg();
    notifyDataSetChanged();
    AppMethodBeat.o(33822);
  }
  
  public final int aux(String paramString)
  {
    AppMethodBeat.i(33818);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(33818);
      return 0;
    }
    if (this.Abd != null)
    {
      if (this.Abd.containsKey(paramString))
      {
        int i = ((Integer)this.Abd.get(paramString)).intValue();
        int j = this.Adk.getContentLV().getHeaderViewsCount();
        AppMethodBeat.o(33818);
        return i + j;
      }
      AppMethodBeat.o(33818);
      return -1;
    }
    AppMethodBeat.o(33818);
    return -1;
  }
  
  protected final boolean c(a parama)
  {
    AppMethodBeat.i(33823);
    int i = parama.position;
    if (this.Abe.indexOfKey(i + 1) >= 0)
    {
      AppMethodBeat.o(33823);
      return true;
    }
    AppMethodBeat.o(33823);
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(33821);
    super.finish();
    ab.i("MicroMsg.OpenIMSelectContactAdapter", "finish!");
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    ((j)g.E(j.class)).YA().b(this);
    AppMethodBeat.o(33821);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(33819);
    int i = this.gqa.getCount();
    int j = this.Abd.size();
    AppMethodBeat.o(33819);
    return i + j;
  }
  
  protected final a mM(int paramInt)
  {
    AppMethodBeat.i(33820);
    Object localObject1;
    Object localObject2;
    if (this.Abe.indexOfKey(paramInt) >= 0)
    {
      localObject1 = (String)this.Abe.get(paramInt);
      localObject2 = new h(paramInt);
      ((h)localObject2).mZq = ((String)localObject1);
      AppMethodBeat.o(33820);
      return localObject2;
    }
    int i = 0;
    int k = paramInt;
    int j;
    int m;
    do
    {
      j = i;
      if (i > this.Abe.size()) {
        break;
      }
      j = i;
      if (this.Abe.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      i = j;
      k = m;
    } while (m >= 0);
    i = paramInt - j;
    if (this.gqa.moveToPosition(i))
    {
      ab.d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject1 = new ad();
      ((ad)localObject1).convertFrom(this.gqa);
      localObject2 = new e(paramInt);
      ((a)localObject2).contact = ((ad)localObject1);
      ((a)localObject2).Adl = cni();
      ((a)localObject2).Adm = this.Adm;
      ((e)localObject2).Agd = true;
      AppMethodBeat.o(33820);
      return localObject2;
    }
    ab.i("MicroMsg.OpenIMSelectContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(33820);
    return null;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.x
 * JD-Core Version:    0.7.0.1
 */
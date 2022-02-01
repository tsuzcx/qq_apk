package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.contact.a.b;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ae
  extends r
  implements MStorageEx.IOnStorageChange, af
{
  private int OpX;
  private int OpZ;
  private Cursor afgg;
  private Cursor afgh;
  private List<String> afgi;
  private int afgj;
  private int afgk;
  private boolean afgl;
  private int afgm;
  private Map<String, Integer> afgo;
  private Map<String, Integer> afgp;
  private int afgq;
  private int afgt;
  private Cursor pKb;
  
  public ae(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList)
  {
    this(paramMMBaseSelectContactUI, paramList, true, false, false, 0);
  }
  
  public ae(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(102921);
    this.afgj = -1;
    this.OpX = -1;
    this.afgm = 0;
    this.OpZ = 0;
    this.afgo = new HashMap();
    this.afgp = new HashMap();
    this.afgq = 0;
    this.afgt = 0;
    Log.i("MicroMsg.RecentConversationAdapter", "create!");
    this.afgl = paramBoolean3;
    this.afgm = paramInt;
    aNm();
    AppMethodBeat.o(102921);
  }
  
  private void jzb()
  {
    AppMethodBeat.i(252739);
    if (this.afgg != null)
    {
      this.afgg.close();
      this.afgg = null;
    }
    if (this.afgh != null)
    {
      this.afgh.close();
      this.afgh = null;
    }
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    AppMethodBeat.o(252739);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(102922);
    Log.i("MicroMsg.RecentConversationAdapter", "resetData");
    jzb();
    ArrayList localArrayList = new ArrayList();
    this.afgt = 0;
    List localList;
    if (w.hasAttr(this.afgm, 4))
    {
      if (!h.jyv()) {
        break label589;
      }
      localList = h.jys();
      if (!Util.isNullOrNil(localList)) {
        this.afgh = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(localList, 3, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
      }
      Log.i("MicroMsg.RecentConversationAdapter", "resetData: recent forward control switch on");
    }
    for (;;)
    {
      this.afgg = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(3, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
      int i;
      label147:
      int j;
      if (this.afgl)
      {
        i = 2;
        if (this.afgi != null)
        {
          j = this.afgi.size();
          label164:
          this.afgk = j;
          this.OpZ = 0;
          if (!Util.isNullOrNil(localList))
          {
            this.afgt = this.afgh.getCount();
            if (this.afgt > 0)
            {
              localArrayList.add(this.afgh);
              this.afgj = (this.afgk + i);
              this.OpZ += 1;
            }
          }
          if (this.afgg.getCount() <= 0) {
            break label555;
          }
          this.OpZ += 1;
          if (this.afgj != -1) {
            break label537;
          }
          this.OpX = (i + this.afgk);
          label273:
          localArrayList.add(this.afgg);
          this.pKb = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
          clearCache();
          AppMethodBeat.o(102922);
          return;
          if (w.hasAttr(this.afgm, 16))
          {
            if (!h.jyv()) {
              break label584;
            }
            localList = h.jyr();
            if (!Util.isNullOrNil(localList)) {
              this.afgh = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(localList, 5, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
            }
            Log.i("MicroMsg.RecentConversationAdapter", "resetData: recent forward control switch on");
          }
        }
      }
      for (;;)
      {
        this.afgg = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(5, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
        break;
        if (h.jyv())
        {
          localList = h.jyt();
          if (!Util.isNullOrNil(localList)) {
            this.afgh = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(localList, 1, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
          }
          Log.i("MicroMsg.RecentConversationAdapter", "resetData: recent forward control switch on");
        }
        for (;;)
        {
          this.afgg = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(1, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
          break;
          j = 0;
          break label164;
          label537:
          this.OpX = (this.afgj + this.afgt + 1);
          break label273;
          label555:
          this.OpX = this.afex.getContentLV().getHeaderViewsCount();
          break label273;
          i = 0;
          break label147;
          localList = null;
        }
        label584:
        localList = null;
      }
      label589:
      localList = null;
    }
  }
  
  public final int bBQ(String paramString)
  {
    AppMethodBeat.i(252764);
    if (!bBT(paramString))
    {
      AppMethodBeat.o(252764);
      return 0;
    }
    int i = ((Integer)this.afgp.get(paramString)).intValue();
    AppMethodBeat.o(252764);
    return i;
  }
  
  public final int bBR(String paramString)
  {
    AppMethodBeat.i(252766);
    if (!bBS(paramString))
    {
      AppMethodBeat.o(252766);
      return 0;
    }
    int i = ((Integer)this.afgo.get(paramString)).intValue();
    AppMethodBeat.o(252766);
    return i;
  }
  
  public final boolean bBS(String paramString)
  {
    AppMethodBeat.i(252770);
    if ((Util.isNullOrNil(paramString)) || (this.afgo == null) || (this.afgo.isEmpty()))
    {
      AppMethodBeat.o(252770);
      return false;
    }
    boolean bool = this.afgo.containsKey(paramString);
    AppMethodBeat.o(252770);
    return bool;
  }
  
  public final boolean bBT(String paramString)
  {
    AppMethodBeat.i(252772);
    if ((Util.isNullOrNil(paramString)) || (this.afgp == null) || (this.afgp.isEmpty()))
    {
      AppMethodBeat.o(252772);
      return false;
    }
    boolean bool = this.afgp.containsKey(paramString);
    AppMethodBeat.o(252772);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102925);
    super.finish();
    Log.i("MicroMsg.RecentConversationAdapter", "finish!");
    jzb();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().remove(this);
    AppMethodBeat.o(102925);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102923);
    if (this.pKb == null)
    {
      Log.e("MicroMsg.RecentConversationAdapter", "getCount: dataCursor == null ");
      AppMethodBeat.o(102923);
      return 0;
    }
    int i = this.pKb.getCount();
    int j = this.OpZ;
    AppMethodBeat.o(102923);
    return i + j;
  }
  
  public final int jzc()
  {
    return this.afgq;
  }
  
  public final int jzd()
  {
    return this.afgt;
  }
  
  public final String jze()
  {
    return "";
  }
  
  public final int jzf()
  {
    return 0;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(102926);
    aNm();
    notifyDataSetChanged();
    AppMethodBeat.o(102926);
  }
  
  protected final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(102924);
    Object localObject2;
    Object localObject1;
    if (this.OpX > this.afgk)
    {
      if (paramInt == this.afgk) {
        new j(paramInt).header = this.afex.getActivity().getResources().getString(a.h.select_contact_official_accounts_title);
      }
    }
    else
    {
      if ((paramInt != this.OpX) && (paramInt != this.afgj)) {
        break label213;
      }
      localObject2 = new j(paramInt);
      if (paramInt != this.afgj) {
        break label173;
      }
      ((j)localObject2).header = this.afex.getActivity().getResources().getString(a.h.select_contact_recent_conversation_cur);
      localObject1 = localObject2;
    }
    for (;;)
    {
      AppMethodBeat.o(102924);
      return localObject1;
      if (paramInt != this.afgk + 1) {
        break;
      }
      localObject1 = new b(paramInt);
      localObject2 = this.afex.getActivity().getResources().getString(a.h.select_contact_official_accounts_title);
      ((b)localObject1).eg(a.g.default_servicebrand_contact, (String)localObject2);
      break;
      label173:
      localObject1 = localObject2;
      label645:
      if (paramInt == this.OpX)
      {
        ((j)localObject2).header = this.afex.getActivity().getResources().getString(a.h.select_contact_conversation_cur);
        localObject1 = localObject2;
        continue;
        label213:
        if (paramInt < this.afgk)
        {
          if ((this.afgi == null) || (paramInt < 0) || (paramInt >= this.afgi.size()))
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = new b(paramInt);
            ((b)localObject1).username = ((String)this.afgi.get(paramInt));
          }
        }
        else
        {
          int i;
          if (this.OpZ == 2) {
            if (paramInt > this.OpX) {
              i = paramInt - 2;
            }
          }
          for (;;)
          {
            if (this.pKb.moveToPosition(i))
            {
              localObject1 = new g(paramInt);
              localObject2 = new bb();
              ((bb)localObject2).convertFrom(this.pKb);
              com.tencent.mm.kernel.h.baF();
              ((com.tencent.mm.ui.contact.a.a)localObject1).contact = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxq(((bd)localObject2).field_username);
              if (((com.tencent.mm.ui.contact.a.a)localObject1).contact == null)
              {
                com.tencent.mm.kernel.h.baF();
                ((com.tencent.mm.ui.contact.a.a)localObject1).contact = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxv(((bd)localObject2).field_username);
              }
              ((com.tencent.mm.ui.contact.a.a)localObject1).afey = gZe();
              if (paramInt == this.OpX - 1) {
                ((com.tencent.mm.ui.contact.a.a)localObject1).afjC = true;
              }
              localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username;
              if (this.OpZ == 2)
              {
                if (paramInt > this.OpX)
                {
                  this.afgo.put(localObject2, Integer.valueOf(paramInt - this.OpX));
                  if (!((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxV((String)localObject2)) {
                    break label645;
                  }
                  this.afgq += 1;
                  break;
                  i = paramInt - 1;
                  continue;
                  if (this.OpZ == 1)
                  {
                    i = paramInt - 1;
                    continue;
                  }
                  Log.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", new Object[] { Integer.valueOf(paramInt) });
                  i = paramInt;
                  continue;
                }
                this.afgp.put(localObject2, Integer.valueOf(paramInt - this.afgj));
                break;
              }
              if (this.OpZ == 1)
              {
                this.afgo.put(localObject2, Integer.valueOf(paramInt - this.OpX));
                if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxV((String)localObject2)) {
                  this.afgq += 1;
                }
              }
              break;
            }
          }
          localObject1 = new i(paramInt);
          Log.e("MicroMsg.RecentConversationAdapter", "wrong case: %s, %s", new Object[] { Boolean.valueOf(this.pKb.isClosed()), Integer.valueOf(i) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ae
 * JD-Core Version:    0.7.0.1
 */
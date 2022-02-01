package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.contact.a.b;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ad
  extends r
  implements MStorageEx.IOnStorageChange
{
  private int Isp;
  private int Isr;
  private Cursor Xvk;
  private Cursor Xvl;
  private List<String> Xvm;
  private int Xvn;
  private int Xvo;
  private boolean Xvp;
  private int Xvq;
  private Map<String, Integer> Xvr;
  private Map<String, Integer> Xvs;
  public int Xvt;
  public int aadi;
  private Cursor mNt;
  
  public ad(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList)
  {
    this(paramMMBaseSelectContactUI, paramList, true, false, false, 0);
  }
  
  public ad(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(102921);
    this.Xvn = -1;
    this.Isp = -1;
    this.Xvq = 0;
    this.Isr = 0;
    this.Xvr = new HashMap();
    this.Xvs = new HashMap();
    this.Xvt = 0;
    this.aadi = 0;
    Log.i("MicroMsg.RecentConversationAdapter", "create!");
    this.Xvp = paramBoolean3;
    this.Xvq = paramInt;
    ate();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().add(this);
    AppMethodBeat.o(102921);
  }
  
  private void hVm()
  {
    AppMethodBeat.i(186890);
    if (this.Xvk != null)
    {
      this.Xvk.close();
      this.Xvk = null;
    }
    if (this.Xvl != null)
    {
      this.Xvl.close();
      this.Xvl = null;
    }
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    AppMethodBeat.o(186890);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(102922);
    Log.i("MicroMsg.RecentConversationAdapter", "resetData");
    hVm();
    ArrayList localArrayList = new ArrayList();
    this.aadi = 0;
    List localList;
    if (w.hasAttr(this.Xvq, 4))
    {
      if (h.iWB() != 1) {
        break label592;
      }
      localList = h.hUD();
      if (!Util.isNullOrNil(localList)) {
        this.Xvl = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(localList, 3, csq(), com.tencent.mm.o.a.jxD, hVe(), "");
      }
      Log.i("MicroMsg.RecentConversationAdapter", "resetData: recent forward control switch on");
    }
    for (;;)
    {
      this.Xvk = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(3, csq(), com.tencent.mm.o.a.jxD, hVe(), "");
      int i;
      label148:
      int j;
      if (this.Xvp)
      {
        i = 2;
        if (this.Xvm != null)
        {
          j = this.Xvm.size();
          label165:
          this.Xvo = j;
          this.Isr = 0;
          if (!Util.isNullOrNil(localList))
          {
            this.aadi = this.Xvl.getCount();
            if (this.aadi > 0)
            {
              localArrayList.add(this.Xvl);
              this.Xvn = (this.Xvo + i);
              this.Isr += 1;
            }
          }
          if (this.Xvk.getCount() <= 0) {
            break label558;
          }
          this.Isr += 1;
          if (this.Xvn != -1) {
            break label540;
          }
          this.Isp = (i + this.Xvo);
          label274:
          localArrayList.add(this.Xvk);
          this.mNt = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
          clearCache();
          AppMethodBeat.o(102922);
          return;
          if (w.hasAttr(this.Xvq, 16))
          {
            if (h.iWB() != 1) {
              break label587;
            }
            localList = h.hUC();
            if (!Util.isNullOrNil(localList)) {
              this.Xvl = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(localList, 5, csq(), com.tencent.mm.o.a.jxD, hVe(), "");
            }
            Log.i("MicroMsg.RecentConversationAdapter", "resetData: recent forward control switch on");
          }
        }
      }
      for (;;)
      {
        this.Xvk = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(5, csq(), com.tencent.mm.o.a.jxD, hVe(), "");
        break;
        if (h.iWB() == 1)
        {
          localList = h.hUE();
          if (!Util.isNullOrNil(localList)) {
            this.Xvl = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(localList, 1, csq(), com.tencent.mm.o.a.jxD, hVe(), "");
          }
          Log.i("MicroMsg.RecentConversationAdapter", "resetData: recent forward control switch on");
        }
        for (;;)
        {
          this.Xvk = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(1, csq(), com.tencent.mm.o.a.jxD, hVe(), "");
          break;
          j = 0;
          break label165;
          label540:
          this.Isp = (this.Xvn + this.aadi + 1);
          break label274;
          label558:
          this.Isp = this.XsW.getContentLV().getHeaderViewsCount();
          break label274;
          i = 0;
          break label148;
          localList = null;
        }
        label587:
        localList = null;
      }
      label592:
      localList = null;
    }
  }
  
  public final boolean bAc(String paramString)
  {
    AppMethodBeat.i(186896);
    if ((Util.isNullOrNil(paramString)) || (this.Xvr == null) || (this.Xvr.isEmpty()))
    {
      AppMethodBeat.o(186896);
      return false;
    }
    boolean bool = this.Xvr.containsKey(paramString);
    AppMethodBeat.o(186896);
    return bool;
  }
  
  public final boolean bAd(String paramString)
  {
    AppMethodBeat.i(186897);
    if ((Util.isNullOrNil(paramString)) || (this.Xvs == null) || (this.Xvs.isEmpty()))
    {
      AppMethodBeat.o(186897);
      return false;
    }
    boolean bool = this.Xvs.containsKey(paramString);
    AppMethodBeat.o(186897);
    return bool;
  }
  
  public final int bIS(String paramString)
  {
    AppMethodBeat.i(293070);
    if (!bAd(paramString))
    {
      AppMethodBeat.o(293070);
      return 0;
    }
    int i = ((Integer)this.Xvs.get(paramString)).intValue();
    AppMethodBeat.o(293070);
    return i;
  }
  
  public final int bIT(String paramString)
  {
    AppMethodBeat.i(293071);
    if (!bAc(paramString))
    {
      AppMethodBeat.o(293071);
      return 0;
    }
    int i = ((Integer)this.Xvr.get(paramString)).intValue();
    AppMethodBeat.o(293071);
    return i;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102925);
    super.finish();
    Log.i("MicroMsg.RecentConversationAdapter", "finish!");
    hVm();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().remove(this);
    AppMethodBeat.o(102925);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102923);
    if (this.mNt == null)
    {
      Log.e("MicroMsg.RecentConversationAdapter", "getCount: dataCursor == null ");
      AppMethodBeat.o(102923);
      return 0;
    }
    int i = this.mNt.getCount();
    int j = this.Isr;
    AppMethodBeat.o(102923);
    return i + j;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(102926);
    ate();
    notifyDataSetChanged();
    AppMethodBeat.o(102926);
  }
  
  protected final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(102924);
    Object localObject2;
    Object localObject1;
    if (this.Isp > this.Xvo)
    {
      if (paramInt == this.Xvo) {
        new j(paramInt).header = this.XsW.getActivity().getResources().getString(a.h.select_contact_official_accounts_title);
      }
    }
    else
    {
      if ((paramInt != this.Isp) && (paramInt != this.Xvn)) {
        break label217;
      }
      localObject2 = new j(paramInt);
      if (paramInt != this.Xvn) {
        break label177;
      }
      ((j)localObject2).header = this.XsW.getActivity().getResources().getString(a.h.select_contact_recent_conversation_cur);
      localObject1 = localObject2;
    }
    for (;;)
    {
      AppMethodBeat.o(102924);
      return localObject1;
      if (paramInt != this.Xvo + 1) {
        break;
      }
      localObject1 = new b(paramInt);
      localObject2 = this.XsW.getActivity().getResources().getString(a.h.select_contact_official_accounts_title);
      ((b)localObject1).resId = a.g.default_servicebrand_contact;
      ((b)localObject1).nickName = ((String)localObject2);
      break;
      label177:
      localObject1 = localObject2;
      if (paramInt == this.Isp)
      {
        ((j)localObject2).header = this.XsW.getActivity().getResources().getString(a.h.select_contact_conversation_cur);
        localObject1 = localObject2;
        continue;
        label217:
        if (paramInt < this.Xvo)
        {
          if ((this.Xvm == null) || (paramInt < 0) || (paramInt >= this.Xvm.size()))
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = new b(paramInt);
            ((b)localObject1).username = ((String)this.Xvm.get(paramInt));
          }
        }
        else
        {
          int i;
          if (this.Isr == 2) {
            if (paramInt > this.Isp) {
              i = paramInt - 2;
            }
          }
          for (;;)
          {
            if (this.mNt.moveToPosition(i))
            {
              localObject1 = new g(paramInt);
              localObject2 = new az();
              ((az)localObject2).convertFrom(this.mNt);
              com.tencent.mm.kernel.h.aHH();
              ((com.tencent.mm.ui.contact.a.a)localObject1).contact = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwc(((bb)localObject2).field_username);
              if (((com.tencent.mm.ui.contact.a.a)localObject1).contact == null)
              {
                com.tencent.mm.kernel.h.aHH();
                ((com.tencent.mm.ui.contact.a.a)localObject1).contact = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwh(((bb)localObject2).field_username);
              }
              ((com.tencent.mm.ui.contact.a.a)localObject1).XsX = fJk();
              localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username;
              if (this.Isr == 2)
              {
                if (paramInt > this.Isp)
                {
                  this.Xvr.put(localObject2, Integer.valueOf(paramInt - this.Isp));
                  if (!((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwF((String)localObject2)) {
                    break label634;
                  }
                  this.Xvt += 1;
                  break;
                  i = paramInt - 1;
                  continue;
                  if (this.Isr == 1)
                  {
                    i = paramInt - 1;
                    continue;
                  }
                  Log.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", new Object[] { Integer.valueOf(paramInt) });
                  i = paramInt;
                  continue;
                }
                this.Xvs.put(localObject2, Integer.valueOf(paramInt - this.Xvn));
                break;
              }
              if (this.Isr == 1)
              {
                this.Xvr.put(localObject2, Integer.valueOf(paramInt - this.Isp));
                if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwF((String)localObject2)) {
                  this.Xvt += 1;
                }
              }
              label634:
              break;
            }
          }
          localObject1 = new i(paramInt);
          Log.e("MicroMsg.RecentConversationAdapter", "wrong case: %s, %s", new Object[] { Boolean.valueOf(this.mNt.isClosed()), Integer.valueOf(i) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ad
 * JD-Core Version:    0.7.0.1
 */
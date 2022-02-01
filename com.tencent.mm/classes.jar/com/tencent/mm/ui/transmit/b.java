package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.o.a;
import com.tencent.mm.ui.contact.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class b
  extends o
{
  private MMCreateChatroomUI IVv;
  private l IVw;
  private ao handler;
  String query;
  private com.tencent.mm.plugin.fts.a.a.a syJ;
  k syy;
  
  public b(MMCreateChatroomUI paramMMCreateChatroomUI, int paramInt)
  {
    super(paramMMCreateChatroomUI, false, paramInt);
    AppMethodBeat.i(39232);
    this.handler = new ao(Looper.getMainLooper());
    this.IVw = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(39231);
        if (paramAnonymousk.bPH == 0) {
          b.a(b.this, paramAnonymousk);
        }
        for (;;)
        {
          if (paramAnonymousk.syK.size() == 0)
          {
            m localm = new m();
            localm.sxG = "no_result​";
            paramAnonymousk.syK = new ArrayList();
            paramAnonymousk.syK.add(localm);
          }
          b.this.clearCache();
          b.this.notifyDataSetChanged();
          b.a(b.this).y(paramAnonymousk.suU.query, paramAnonymousk.syK.size(), true);
          AppMethodBeat.o(39231);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.IVv = paramMMCreateChatroomUI;
    AppMethodBeat.o(39232);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39233);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.syI = this.IVw;
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.syH = com.tencent.mm.plugin.fts.a.c.b.szh;
    paramArrayOfInt.syD = new int[] { 131072 };
    paramArrayOfInt.syG.add("filehelper");
    paramArrayOfInt.syG.add(u.axw());
    paramArrayOfInt.syG.addAll(this.IVv.IVz.fue());
    this.syJ = ((n)g.ad(n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(39233);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(39234);
    if (this.syJ != null) {
      ((n)g.ad(n.class)).cancelSearchTask(this.syJ);
    }
    this.query = null;
    AppMethodBeat.o(39234);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(39236);
    if ((this.syy != null) && (this.syy.syK != null))
    {
      int i = this.syy.syK.size();
      AppMethodBeat.o(39236);
      return i;
    }
    AppMethodBeat.o(39236);
    return 0;
  }
  
  public final com.tencent.mm.ui.contact.a.a qH(int paramInt)
  {
    AppMethodBeat.i(39235);
    m localm = (m)this.syy.syK.get(paramInt);
    Object localObject;
    if (localm.sxG.equals("no_result​")) {
      localObject = new i(paramInt);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
      ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      ((com.tencent.mm.ui.contact.a.a)localObject).Iwh = false;
      AppMethodBeat.o(39235);
      return localObject;
      localObject = new e(paramInt);
      ((e)localObject).jPN = localm;
      ((com.tencent.mm.ui.contact.a.a)localObject).sxM = this.syy.sxM;
      ((com.tencent.mm.ui.contact.a.a)localObject).Iwh = dFi();
      ((e)localObject).gbD = true;
      ((e)localObject).szu = (paramInt + 1);
      ((e)localObject).fP(((e)localObject).jPN.type, ((e)localObject).jPN.sxF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b
 * JD-Core Version:    0.7.0.1
 */
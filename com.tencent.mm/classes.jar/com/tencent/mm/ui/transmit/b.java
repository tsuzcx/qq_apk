package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.p.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class b
  extends p
{
  com.tencent.mm.plugin.fts.a.a.k BIK;
  private com.tencent.mm.plugin.fts.a.a.a BIV;
  private MMCreateChatroomUI XWb;
  private l XWc;
  private MMHandler handler;
  String query;
  
  public b(MMCreateChatroomUI paramMMCreateChatroomUI, int paramInt)
  {
    super(paramMMCreateChatroomUI, false, paramInt);
    AppMethodBeat.i(39232);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.XWc = new l()
    {
      public final void b(com.tencent.mm.plugin.fts.a.a.k paramAnonymousk)
      {
        AppMethodBeat.i(39231);
        if (paramAnonymousk.resultCode == 0) {
          b.a(b.this, paramAnonymousk);
        }
        for (;;)
        {
          if (paramAnonymousk.BIW.size() == 0)
          {
            m localm = new m();
            localm.BHS = "no_result​";
            paramAnonymousk.BIW = new ArrayList();
            paramAnonymousk.BIW.add(localm);
          }
          b.this.clearCache();
          b.this.notifyDataSetChanged();
          b.a(b.this).g(paramAnonymousk.BFk.query, paramAnonymousk.BIW.size(), true);
          AppMethodBeat.o(39231);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.XWb = paramMMCreateChatroomUI;
    AppMethodBeat.o(39232);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39233);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.BIU = this.XWc;
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.BIT = com.tencent.mm.plugin.fts.a.c.b.BJu;
    paramArrayOfInt.BIP = new int[] { 131072 };
    paramArrayOfInt.BIS.add("filehelper");
    paramArrayOfInt.BIS.add(z.bcZ());
    paramArrayOfInt.BIS.addAll(this.XWb.XWf.hYO());
    this.BIV = ((n)h.ag(n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(39233);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(39234);
    if (this.BIV != null) {
      ((n)h.ag(n.class)).cancelSearchTask(this.BIV);
    }
    this.query = null;
    AppMethodBeat.o(39234);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(39236);
    if ((this.BIK != null) && (this.BIK.BIW != null))
    {
      int i = this.BIK.BIW.size();
      AppMethodBeat.o(39236);
      return i;
    }
    AppMethodBeat.o(39236);
    return 0;
  }
  
  public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(39235);
    m localm = (m)this.BIK.BIW.get(paramInt);
    Object localObject;
    if (localm.BHS.equals("no_result​")) {
      localObject = new com.tencent.mm.ui.contact.a.k(paramInt);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
      ((com.tencent.mm.ui.contact.a.a)localObject).scene = getScene();
      ((com.tencent.mm.ui.contact.a.a)localObject).XsX = false;
      AppMethodBeat.o(39235);
      return localObject;
      localObject = new f(paramInt);
      ((f)localObject).olG = localm;
      ((com.tencent.mm.ui.contact.a.a)localObject).BHY = this.BIK.BHY;
      ((com.tencent.mm.ui.contact.a.a)localObject).XsX = fJk();
      ((f)localObject).jWq = true;
      ((f)localObject).BJH = (paramInt + 1);
      ((f)localObject).hx(((f)localObject).olG.type, ((f)localObject).olG.BHR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b
 * JD-Core Version:    0.7.0.1
 */
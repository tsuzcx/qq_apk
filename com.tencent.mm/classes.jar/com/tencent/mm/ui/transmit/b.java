package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
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
  private c HtE;
  m Hts;
  private MMCreateChatroomUI afMs;
  private com.tencent.mm.plugin.fts.a.l afMt;
  private MMHandler handler;
  String query;
  
  public b(MMCreateChatroomUI paramMMCreateChatroomUI, int paramInt)
  {
    super(paramMMCreateChatroomUI, false, paramInt);
    AppMethodBeat.i(39232);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.afMt = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(m paramAnonymousm)
      {
        AppMethodBeat.i(39231);
        if (paramAnonymousm.resultCode == 0) {
          b.a(b.this, paramAnonymousm);
        }
        for (;;)
        {
          if (paramAnonymousm.HtF.size() == 0)
          {
            o localo = new o();
            localo.Hsz = "no_result​";
            paramAnonymousm.HtF = new ArrayList();
            paramAnonymousm.HtF.add(localo);
          }
          b.this.clearCache();
          b.this.notifyDataSetChanged();
          b.a(b.this).h(paramAnonymousm.HpM.query, paramAnonymousm.HtF.size(), true);
          AppMethodBeat.o(39231);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.afMs = paramMMCreateChatroomUI;
    AppMethodBeat.o(39232);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39233);
    this.query = paramString;
    paramArrayOfInt = new com.tencent.mm.plugin.fts.a.a.l();
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.HtC = this.afMt;
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.HtB = com.tencent.mm.plugin.fts.a.c.b.Hue;
    paramArrayOfInt.Htx = new int[] { 131072 };
    paramArrayOfInt.HtA.add("filehelper");
    paramArrayOfInt.HtA.add(z.bAM());
    paramArrayOfInt.HtA.addAll(this.afMs.afMw.jDy());
    this.HtE = ((n)h.az(n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(39233);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(39234);
    if (this.HtE != null) {
      ((n)h.az(n.class)).cancelSearchTask(this.HtE);
    }
    this.query = null;
    AppMethodBeat.o(39234);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(39236);
    if ((this.Hts != null) && (this.Hts.HtF != null))
    {
      int i = this.Hts.HtF.size();
      AppMethodBeat.o(39236);
      return i;
    }
    AppMethodBeat.o(39236);
    return 0;
  }
  
  public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(39235);
    o localo = (o)this.Hts.HtF.get(paramInt);
    Object localObject;
    if (localo.Hsz.equals("no_result​")) {
      localObject = new com.tencent.mm.ui.contact.a.l(paramInt);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
      ((com.tencent.mm.ui.contact.a.a)localObject).scene = getScene();
      ((com.tencent.mm.ui.contact.a.a)localObject).afey = false;
      AppMethodBeat.o(39235);
      return localObject;
      localObject = new f(paramInt);
      ((f)localObject).rpp = localo;
      ((com.tencent.mm.ui.contact.a.a)localObject).FWt = this.Hts.FWt;
      ((com.tencent.mm.ui.contact.a.a)localObject).afey = gZe();
      ((f)localObject).mwk = true;
      ((f)localObject).Huq = (paramInt + 1);
      ((f)localObject).iW(((f)localObject).rpp.type, ((f)localObject).rpp.subtype);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b
 * JD-Core Version:    0.7.0.1
 */
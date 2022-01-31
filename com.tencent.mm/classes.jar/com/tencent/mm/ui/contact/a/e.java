package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class e
  extends a
{
  private static final Pattern gpG;
  public String Agc;
  public boolean Agd;
  private e.b Age;
  private e.a Agf;
  public CharSequence gpH;
  public CharSequence gpI;
  public l hrL;
  public String username;
  
  static
  {
    AppMethodBeat.i(105284);
    gpG = Pattern.compile(",");
    AppMethodBeat.o(105284);
  }
  
  public e(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(105282);
    this.Age = new e.b(this);
    this.Agf = new e.a(this);
    AppMethodBeat.o(105282);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(105283);
    int j = 1;
    if (this.hrL != null)
    {
      i = j;
      if (this.contact == null)
      {
        com.tencent.mm.kernel.g.RM();
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arq(this.hrL.mRV);
        i = j;
        if (this.contact == null)
        {
          com.tencent.mm.kernel.g.RM();
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arv(this.hrL.mRV);
        }
      }
    }
    for (int i = j; this.contact == null; i = 0)
    {
      ab.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(105283);
      return;
    }
    this.username = this.contact.field_username;
    this.Agc = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).bd(this.contact.field_openImAppid, this.contact.field_descWordingId);
    l locall;
    Object localObject3;
    CharSequence localCharSequence;
    Iterator localIterator;
    int k;
    int m;
    boolean bool6;
    boolean bool5;
    boolean bool7;
    boolean bool3;
    boolean bool4;
    boolean bool8;
    Resources localResources;
    String str;
    boolean bool1;
    boolean bool2;
    Object localObject1;
    Object localObject2;
    if (i != 0)
    {
      locall = this.hrL;
      localObject3 = this.contact;
      localCharSequence = null;
      localIterator = null;
      k = 0;
      m = 0;
      bool6 = false;
      bool5 = false;
      bool7 = false;
      bool3 = false;
      bool4 = false;
      bool8 = false;
      localResources = paramContext.getResources();
      if (localObject3 == null) {
        break label1177;
      }
      str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).a((ad)localObject3, ((aq)localObject3).field_username);
      bool1 = bool8;
      bool2 = bool7;
      i = m;
      j = k;
      parama = localIterator;
      localObject1 = localCharSequence;
      localObject2 = str;
      switch (locall.mRU)
      {
      default: 
        localObject2 = str;
        localObject1 = localCharSequence;
        parama = localIterator;
        j = k;
        i = m;
        bool2 = bool7;
        bool1 = bool8;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        ab.d("MicroMsg.ContactDataItem", "highlight first line");
        this.gpH = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, (CharSequence)localObject2, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
        this.gpH = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.gpH, this.mRX, bool2, bool1)).mSp;
        label459:
        if (i == 0) {
          break label1063;
        }
        ab.d("MicroMsg.ContactDataItem", "highlight second line");
        this.gpI = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, parama, com.tencent.mm.cb.a.ao(paramContext, 2131427758));
        this.gpI = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.gpI, this.mRX, bool2, bool1)).mSp;
        label510:
        if ((!bo.isNullOrNil((String)localObject1)) && (this.gpI != null)) {
          this.gpI = TextUtils.concat(new CharSequence[] { localObject1, this.gpI });
        }
        AppMethodBeat.o(105283);
        return;
        bool1 = true;
      }
      label557:
      for (bool2 = true;; bool2 = bool6)
      {
        j = 1;
        i = m;
        parama = localIterator;
        localObject1 = localCharSequence;
        localObject2 = str;
        break;
        bool3 = true;
        bool5 = true;
        bool4 = bool3;
        parama = ((aq)localObject3).field_nickname;
        localObject1 = localResources.getString(2131302992);
        i = 1;
        bool1 = bool4;
        bool2 = bool5;
        j = k;
        localObject2 = str;
        break;
        parama = ((aq)localObject3).dqT;
        localObject1 = localResources.getString(2131302987);
        i = 1;
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        i = 1;
        localObject1 = ((ad)localObject3).Hq();
        parama = (a.a)localObject1;
        if (bo.isNullOrNil((String)localObject1)) {
          parama = ((aq)localObject3).field_username;
        }
        localObject1 = localResources.getString(2131302996);
        bool1 = bool8;
        bool2 = bool7;
        j = k;
        localObject2 = str;
        break;
        parama = locall.content;
        if (!bo.isNullOrNil(parama))
        {
          localObject2 = parama.split("​");
          j = localObject2.length;
          i = 0;
          label744:
          if (i < j)
          {
            localObject1 = localObject2[i];
            if (((String)localObject1).startsWith(this.query)) {
              parama = (a.a)localObject1;
            }
          }
        }
        for (;;)
        {
          localObject1 = localResources.getString(2131302991);
          i = 1;
          bool1 = bool8;
          bool2 = bool7;
          j = k;
          localObject2 = str;
          break;
          i += 1;
          break label744;
          parama = locall.content;
          localObject1 = localResources.getString(2131302989);
          i = 1;
          bool1 = bool8;
          bool2 = bool7;
          j = k;
          localObject2 = str;
          break;
          j = 1;
          parama = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSMainDB().OW(((aq)localObject3).field_contactLabelIds);
          localObject1 = new StringBuffer();
          localObject2 = this.mRX.mSy;
          m = localObject2.length;
          i = 0;
          while (i < m)
          {
            localCharSequence = localObject2[i];
            localIterator = parama.iterator();
            while (localIterator.hasNext())
            {
              localObject3 = (String)localIterator.next();
              if (com.tencent.mm.plugin.fts.a.d.Pa((String)localObject3).contains(localCharSequence))
              {
                ((StringBuffer)localObject1).append((String)localObject3);
                ((StringBuffer)localObject1).append(",");
              }
            }
            i += 1;
          }
          ((StringBuffer)localObject1).trimToSize();
          if (((StringBuffer)localObject1).length() == 0) {}
          for (parama = "";; parama = ((StringBuffer)localObject1).substring(0, ((StringBuffer)localObject1).length() - 1))
          {
            localObject1 = localResources.getString(2131302995);
            bool1 = bool8;
            bool2 = bool7;
            i = j;
            j = k;
            localObject2 = str;
            break;
          }
          this.gpH = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, (CharSequence)localObject2, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
          break label459;
          this.gpI = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, parama, com.tencent.mm.cb.a.ao(paramContext, 2131427758));
          break label510;
          if (bo.isNullOrNil(this.cpf)) {}
          for (parama = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).c(this.contact);; parama = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.contact.field_username, this.cpf))
          {
            this.gpH = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, parama, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
            AppMethodBeat.o(105283);
            return;
          }
        }
        bool1 = false;
        break label557;
        bool1 = false;
      }
      label1063:
      localObject2 = null;
      label1177:
      bool1 = bool8;
      bool2 = bool7;
      i = m;
      j = k;
      parama = localIterator;
      localObject1 = localCharSequence;
    }
  }
  
  public a.b aoY()
  {
    return this.Age;
  }
  
  public a.a cnj()
  {
    return this.Agf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.e
 * JD-Core Version:    0.7.0.1
 */
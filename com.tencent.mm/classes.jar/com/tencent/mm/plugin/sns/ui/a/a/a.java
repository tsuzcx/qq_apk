package com.tencent.mm.plugin.sns.ui.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.bd;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern sdH;
  public CharSequence gpH;
  public CharSequence gpI;
  public l hrL;
  public CharSequence sdI;
  private a.b sdJ;
  a.a sdK;
  public View.OnClickListener sdq;
  public String username;
  
  static
  {
    AppMethodBeat.i(145687);
    sdH = Pattern.compile(";");
    AppMethodBeat.o(145687);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(145685);
    this.sdq = null;
    this.sdJ = new a.b(this);
    this.sdK = new a.a(this);
    AppMethodBeat.o(145685);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    Object localObject = null;
    int j = 1;
    boolean bool1 = false;
    AppMethodBeat.i(145686);
    int i;
    if (this.hrL != null)
    {
      if (this.contact != null) {
        break label622;
      }
      g.RM();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arq(this.hrL.mRV);
      if (this.contact != null) {
        break label622;
      }
      g.RM();
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arv(this.hrL.mRV);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        this.gpH = "";
        AppMethodBeat.o(145686);
        return;
        i = 0;
      }
      else
      {
        this.username = this.contact.field_username;
        l locall;
        Resources localResources;
        String str1;
        if (i != 0)
        {
          locall = this.hrL;
          parama = this.contact;
          localResources = paramContext.getResources();
          str1 = ((b)g.E(b.class)).a(parama, parama.field_username);
          switch (locall.mRU)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject;
            if (i != 0)
            {
              this.gpH = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str1, com.tencent.mm.cb.a.ao(paramContext, 2131427758));
              this.gpH = f.a(d.a(this.gpH, this.mRX, bool2, bool1)).mSp;
              this.gpI = parama;
              AppMethodBeat.o(145686);
              return;
            }
            break;
          case 3: 
          case 7: 
            label263:
            label308:
            bool1 = true;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          localResources.getString(2131302992);
          i = j;
          parama = localObject;
          break label263;
          g.RM();
          parama = g.RL().eHS.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { parama.field_username }, 2);
          String str2;
          if (parama.moveToFirst())
          {
            str2 = parama.getString(0);
            parama.close();
            if (str2 == null) {
              parama = null;
            }
          }
          for (;;)
          {
            if ((parama != null) && (parama.length > 0)) {
              this.sdI = ("(" + parama.length + ")");
            }
            if ((parama == null) || (locall.mTg == null)) {
              break;
            }
            parama = m.a(paramContext, locall.mTg, parama, this.mRX, b.c.mVY);
            parama = TextUtils.concat(new CharSequence[] { localResources.getString(2131302990), parama });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label263;
            parama = sdH.split(str2);
            continue;
            parama.close();
            parama = null;
          }
          this.gpH = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str1, com.tencent.mm.cb.a.ao(paramContext, 2131427758));
          break label308;
          this.gpH = ((b)g.E(b.class)).a(this.contact, this.contact.field_username);
          if (this.hrL != null) {
            this.sdI = ("(" + this.hrL.mSZ + ")");
          }
          AppMethodBeat.o(145686);
          return;
          bool1 = false;
        }
        label622:
        i = 1;
      }
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b aoY()
  {
    return this.sdJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */
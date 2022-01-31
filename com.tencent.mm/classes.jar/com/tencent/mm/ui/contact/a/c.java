package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.regex.Pattern;

public final class c
  extends a
{
  private static final Pattern vOn = Pattern.compile(";");
  public CharSequence eXK;
  public CharSequence eXL;
  public l fYx;
  public String username;
  public CharSequence vOo;
  private c.b vOp = new c.b(this);
  c.a vOq = new c.a(this);
  
  public c(int paramInt)
  {
    super(3, paramInt);
  }
  
  protected final a.a VA()
  {
    return this.vOq;
  }
  
  public final a.b Vz()
  {
    return this.vOp;
  }
  
  public final boolean aVG()
  {
    return this.fYx.kxu;
  }
  
  public final void bW(Context paramContext)
  {
    Object localObject2 = null;
    int j = 1;
    boolean bool1 = false;
    int i;
    if (this.fYx != null)
    {
      if (this.dnp != null) {
        break label639;
      }
      g.DQ();
      this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abf(this.fYx.kwg);
      if (this.dnp != null) {
        break label639;
      }
      g.DQ();
      this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abk(this.fYx.kwg);
      i = 1;
    }
    for (;;)
    {
      if (this.dnp == null)
      {
        y.i("MicroMsg.ChatroomDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
        return;
        i = 0;
      }
      else
      {
        this.username = this.dnp.field_username;
        l locall;
        Object localObject1;
        Resources localResources;
        String str1;
        if (i != 0)
        {
          locall = this.fYx;
          localObject1 = this.dnp;
          localResources = paramContext.getResources();
          str1 = ((b)g.r(b.class)).a((ad)localObject1, ((ao)localObject1).field_username);
          switch (locall.kwf)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            localObject1 = localObject2;
            if (i != 0)
            {
              this.eXK = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str1, com.tencent.mm.cb.a.aa(paramContext, a.c.HintTextSize));
              this.eXK = f.a(d.a(this.eXK, this.kwi, bool2, bool1)).kwz;
              this.eXL = ((CharSequence)localObject1);
              return;
            }
            break;
          case 3: 
          case 7: 
            label268:
            label314:
            bool1 = true;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          localResources.getString(a.h.search_contact_tag_nickname);
          i = j;
          localObject1 = localObject2;
          break label268;
          g.DQ();
          localObject1 = g.DP().dKu.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { ((ao)localObject1).field_username }, 2);
          String str2;
          if (((Cursor)localObject1).moveToFirst())
          {
            str2 = ((Cursor)localObject1).getString(0);
            ((Cursor)localObject1).close();
            if (str2 == null) {
              localObject1 = null;
            }
          }
          for (;;)
          {
            if ((localObject1 != null) && (localObject1.length > 0)) {
              this.vOo = ("(" + localObject1.length + ")");
            }
            if ((localObject1 == null) || (locall.kxr == null)) {
              break;
            }
            localObject1 = m.a(paramContext, locall.kxr, (String[])localObject1, this.kwi, b.c.kAg);
            localObject1 = TextUtils.concat(new CharSequence[] { localResources.getString(a.h.search_contact_tag_member), localObject1 });
            bool1 = false;
            bool2 = false;
            i = 0;
            break label268;
            localObject1 = vOn.split(str2);
            continue;
            ((Cursor)localObject1).close();
            localObject1 = null;
          }
          this.eXK = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str1, com.tencent.mm.cb.a.aa(paramContext, a.c.HintTextSize));
          break label314;
          this.eXK = ((b)g.r(b.class)).a(this.dnp, this.dnp.field_username);
          if (this.fYx == null) {
            break;
          }
          this.vOo = ("(" + this.fYx.kxk + ")");
          return;
          bool1 = false;
        }
        label639:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.c
 * JD-Core Version:    0.7.0.1
 */
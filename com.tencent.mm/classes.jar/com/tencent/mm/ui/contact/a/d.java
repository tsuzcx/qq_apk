package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class d
  extends a
{
  private static final Pattern eXJ = Pattern.compile(",");
  public CharSequence eXK;
  public CharSequence eXL;
  public l fYx;
  public String username;
  public String vOs;
  public boolean vOt;
  private d.b vOu = new d.b(this);
  private d.a vOv = new d.a(this);
  
  public d(int paramInt)
  {
    super(2, paramInt);
  }
  
  public a.a VA()
  {
    return this.vOv;
  }
  
  public a.b Vz()
  {
    return this.vOu;
  }
  
  public final void bW(Context paramContext)
  {
    int i;
    if (this.fYx != null)
    {
      if (this.dnp != null) {
        break label1071;
      }
      com.tencent.mm.kernel.g.DQ();
      this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abf(this.fYx.kwg);
      if (this.dnp != null) {
        break label1071;
      }
      com.tencent.mm.kernel.g.DQ();
      this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abk(this.fYx.kwg);
      i = 1;
    }
    for (;;)
    {
      if (this.dnp == null)
      {
        y.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
        return;
        i = 0;
      }
      else
      {
        this.username = this.dnp.field_username;
        this.vOs = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).aK(this.dnp.field_openImAppid, this.dnp.field_descWordingId);
        Object localObject1;
        Object localObject3;
        Resources localResources;
        String str1;
        boolean bool2;
        boolean bool1;
        int j;
        Object localObject2;
        if (i != 0)
        {
          localObject1 = this.fYx;
          localObject3 = this.dnp;
          localResources = paramContext.getResources();
          if (localObject3 == null) {
            break label1049;
          }
          str1 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).a((ad)localObject3, ((ao)localObject3).field_username);
          switch (((l)localObject1).kwf)
          {
          case 8: 
          case 9: 
          case 10: 
          case 12: 
          case 13: 
          case 14: 
          default: 
            bool2 = false;
            bool1 = false;
            i = 0;
            j = 0;
            localObject1 = null;
            localObject2 = null;
          }
        }
        for (;;)
        {
          if (j != 0)
          {
            y.d("MicroMsg.ContactDataItem", "highlight first line");
            this.eXK = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str1, com.tencent.mm.cb.a.aa(paramContext, a.c.NormalTextSize));
            this.eXK = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.eXK, this.kwi, bool1, bool2)).kwz;
            label373:
            if (i == 0) {
              break label920;
            }
            y.d("MicroMsg.ContactDataItem", "highlight second line");
            this.eXL = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, (CharSequence)localObject1, com.tencent.mm.cb.a.aa(paramContext, a.c.HintTextSize));
            this.eXL = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.eXL, this.kwi, bool1, bool2)).kwz;
            label426:
            if ((bk.bl((String)localObject2)) || (this.eXL == null)) {
              break;
            }
            this.eXL = TextUtils.concat(new CharSequence[] { localObject2, this.eXL });
            return;
            bool2 = true;
            label468:
            bool1 = true;
            label471:
            i = 0;
            j = 1;
            localObject1 = null;
            localObject2 = null;
            continue;
            bool2 = true;
          }
          label487:
          for (bool1 = true;; bool1 = false)
          {
            localObject1 = ((ao)localObject3).field_nickname;
            localObject2 = localResources.getString(a.h.search_contact_tag_nickname);
            i = 1;
            j = 0;
            break;
            localObject1 = ((ao)localObject3).cCJ;
            localObject2 = localResources.getString(a.h.search_contact_tag_description);
            bool2 = false;
            bool1 = false;
            i = 1;
            j = 0;
            break;
            localObject2 = ((ad)localObject3).vk();
            localObject1 = localObject2;
            if (bk.bl((String)localObject2)) {
              localObject1 = ((ao)localObject3).field_username;
            }
            localObject2 = localResources.getString(a.h.search_contact_tag_wxid);
            bool2 = false;
            bool1 = false;
            i = 1;
            j = 0;
            break;
            localObject1 = ((l)localObject1).content;
            if (!bk.bl((String)localObject1))
            {
              localObject3 = ((String)localObject1).split("​");
              j = localObject3.length;
              i = 0;
              label623:
              if (i < j)
              {
                localObject2 = localObject3[i];
                if (((String)localObject2).startsWith(this.bVk)) {
                  localObject1 = localObject2;
                }
              }
            }
            for (;;)
            {
              localObject2 = localResources.getString(a.h.search_contact_tag_mobile);
              bool2 = false;
              bool1 = false;
              i = 1;
              j = 0;
              break;
              i += 1;
              break label623;
              localObject1 = ((l)localObject1).content;
              localObject2 = localResources.getString(a.h.search_contact_tag_location);
              bool2 = false;
              bool1 = false;
              i = 1;
              j = 0;
              break;
              localObject1 = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSMainDB().DN(((ao)localObject3).field_contactLabelIds);
              localObject2 = new StringBuffer();
              localObject3 = this.kwi.kwI;
              j = localObject3.length;
              i = 0;
              while (i < j)
              {
                CharSequence localCharSequence = localObject3[i];
                Iterator localIterator = ((List)localObject1).iterator();
                while (localIterator.hasNext())
                {
                  String str2 = (String)localIterator.next();
                  if (com.tencent.mm.plugin.fts.a.d.DR(str2).contains(localCharSequence))
                  {
                    ((StringBuffer)localObject2).append(str2);
                    ((StringBuffer)localObject2).append(",");
                  }
                }
                i += 1;
              }
              ((StringBuffer)localObject2).trimToSize();
              if (((StringBuffer)localObject2).length() == 0) {}
              for (localObject1 = "";; localObject1 = ((StringBuffer)localObject2).substring(0, ((StringBuffer)localObject2).length() - 1))
              {
                localObject2 = localResources.getString(a.h.search_contact_tag_tag);
                bool2 = false;
                bool1 = false;
                i = 1;
                j = 0;
                break;
              }
              this.eXK = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str1, com.tencent.mm.cb.a.aa(paramContext, a.c.NormalTextSize));
              break label373;
              this.eXL = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, (CharSequence)localObject1, com.tencent.mm.cb.a.aa(paramContext, a.c.HintTextSize));
              break label426;
              if (bk.bl(this.bHQ)) {}
              for (localObject1 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).c(this.dnp);; localObject1 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.dnp.field_username, this.bHQ))
              {
                this.eXK = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, (CharSequence)localObject1, com.tencent.mm.cb.a.aa(paramContext, a.c.NormalTextSize));
                return;
              }
            }
            bool2 = false;
            break label468;
            bool2 = false;
            bool1 = false;
            break label471;
            bool2 = false;
            break label487;
            bool2 = false;
          }
          label920:
          label1049:
          bool2 = false;
          bool1 = false;
          i = 0;
          j = 0;
          localObject1 = null;
          localObject2 = null;
          str1 = null;
        }
        label1071:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d
 * JD-Core Version:    0.7.0.1
 */
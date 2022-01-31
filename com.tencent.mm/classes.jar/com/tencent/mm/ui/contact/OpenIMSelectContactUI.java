package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.m.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class OpenIMSelectContactUI
  extends MMBaseSelectContactUI
{
  private String bOL;
  private List<String> dru;
  private HashSet<String> eXT;
  private String title;
  private int vIY;
  private HashSet<String> vMY;
  private HashSet<String> vMZ;
  private int vNa;
  private boolean vNb = true;
  private SelectContactUI.a vNc = new SelectContactUI.a();
  
  private void Wv(String paramString)
  {
    if (this.mbR == null) {
      return;
    }
    this.mbR.Wv(paramString);
  }
  
  private boolean l(List<String> paramList1, List<String> paramList2)
  {
    y.i("OpenIMSelectContactUI", "handleSelect %s, cancel %s", new Object[] { paramList1, paramList2 });
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Contact", bk.c(paramList1, ","));
    localIntent.putExtra("Cancel_Select_Contact", bk.c(paramList2, ","));
    setResult(-1, localIntent);
    finish();
    return true;
  }
  
  private void xU()
  {
    if ((s.fA(this.vNa, 64)) && (this.eXT.size() > 0))
    {
      updateOptionMenuText(1, getString(R.l.app_choose) + "(" + this.eXT.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((s.fA(this.vNa, 262144)) && (this.eXT.size() < i))
      {
        enableOptionMenu(1, false);
        return;
      }
      enableOptionMenu(1, true);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_choose));
    enableOptionMenu(1, false);
  }
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return false;
  }
  
  protected final String VE()
  {
    if (bk.bl(this.title)) {
      this.title = ((b)com.tencent.mm.kernel.g.r(b.class)).a(this.bOL, "openim_acct_type_title", b.a.ePI);
    }
    return this.title;
  }
  
  protected final o VF()
  {
    boolean bool = s.fA(this.vNa, 64);
    return new w(this.bOL, this, this.dru, bool);
  }
  
  protected final m VG()
  {
    return new q(this, this.dru, s.fA(this.vNa, 64), this.scene);
  }
  
  public final boolean a(a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.eXT.contains(parama.dnp.field_username);
    }
    if ((parama.vLK) && (parama.dnp != null)) {
      return this.eXT.contains(parama.dnp.field_username);
    }
    if ((parama instanceof j)) {
      return this.eXT.isEmpty();
    }
    return false;
  }
  
  public final boolean b(a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.vMY.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final boolean cHM()
  {
    return false;
  }
  
  public final void jP(int paramInt)
  {
    int i = 0;
    int j = paramInt - getContentLV().getHeaderViewsCount();
    if (j < 0) {
      y.i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
    }
    do
    {
      return;
      localObject = cHE().HK(j);
    } while ((localObject == null) || (((a)localObject).dnp == null) || (((a)localObject).dnp.field_deleteFlag == 1));
    Object localObject = ((a)localObject).dnp.field_username;
    y.i("OpenIMSelectContactUI", "ClickUser=%s", new Object[] { localObject });
    if (s.fA(this.vNa, 64))
    {
      if ((s.fA(this.vNa, 131072)) && (this.eXT.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.vMY.contains(localObject))
        {
          cHK();
          if (this.eXT.contains(localObject))
          {
            Wv((String)localObject);
            this.eXT.remove(localObject);
          }
        }
        else
        {
          xU();
          if ((this.vNb) && ((this.vIY == 1) || (this.vIY == 0))) {
            if (this.vMY == null) {
              break label432;
            }
          }
        }
      }
      label432:
      for (paramInt = this.vMY.size();; paramInt = 0)
      {
        if (this.eXT != null) {
          i = this.eXT.size();
        }
        j = bk.ZR(com.tencent.mm.m.g.AA().getValue("ChatRoomInviteStartCount"));
        this.vNc.d(this, paramInt + i, j);
        cHF().notifyDataSetChanged();
        return;
        String str = getIntent().getStringExtra("too_many_member_tip_string");
        localObject = str;
        if (bk.bl(str)) {
          localObject = getString(R.l.select_contact_num_limit_tips, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        h.a(this.mController.uMN, (String)localObject, getString(R.l.app_remind), new OpenIMSelectContactUI.2(this));
        break;
        if (this.vMY.contains(localObject)) {
          break;
        }
        cHK();
        Wv((String)localObject);
        if (this.eXT.contains(localObject))
        {
          this.eXT.remove(localObject);
          break;
        }
        this.eXT.add(localObject);
        break;
      }
    }
    l(bk.G(new String[] { localObject }), new ArrayList(0));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (s.fA(this.vNa, 64)) {
      a(1, getString(R.l.app_ok), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          paramAnonymousMenuItem = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, s.fA(OpenIMSelectContactUI.a(OpenIMSelectContactUI.this), 8192));
          paramAnonymousMenuItem.remove(com.tencent.mm.model.q.Gj());
          ArrayList localArrayList = new ArrayList(OpenIMSelectContactUI.b(OpenIMSelectContactUI.this));
          localArrayList.removeAll(paramAnonymousMenuItem);
          return OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, paramAnonymousMenuItem, localArrayList);
        }
      }, s.b.uNx);
    }
    xU();
    paramBundle = this.eXT.iterator();
    while (paramBundle.hasNext()) {
      Wv((String)paramBundle.next());
    }
  }
  
  public final void pw(String paramString)
  {
    this.eXT.remove(paramString);
    cHE().notifyDataSetChanged();
    xU();
  }
  
  protected final void xK()
  {
    super.xK();
    this.bOL = getIntent().getStringExtra("openim_appid");
    this.title = getIntent().getStringExtra("titile");
    this.vIY = getIntent().getIntExtra("list_type", -1);
    this.vNa = getIntent().getIntExtra("list_attr", s.vMq);
    this.dru = new ArrayList();
    this.eXT = new HashSet();
    this.vMZ = new HashSet();
    this.vMY = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bk.bl((String)localObject)) {
      this.vMY.addAll(bk.G(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bk.bl((String)localObject))
    {
      this.eXT.addAll(bk.G(((String)localObject).split(",")));
      this.vMZ.addAll(this.eXT);
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bk.bl(str)) {
      ((HashSet)localObject).addAll(bk.G(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(s.cHO());
    ((HashSet)localObject).addAll(s.cHP());
    this.dru.addAll((Collection)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMSelectContactUI
 * JD-Core Version:    0.7.0.1
 */
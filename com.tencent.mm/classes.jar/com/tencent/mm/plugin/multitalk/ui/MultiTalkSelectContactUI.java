package com.tencent.mm.plugin.multitalk.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.h.a.jw;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.s.b;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(3)
public class MultiTalkSelectContactUI
  extends MMBaseSelectContactUI
{
  private String chatroomName;
  private HashSet<String> eXS;
  private HashSet<String> eXT;
  private c mtY = new c() {};
  private boolean mvo;
  private d mvp;
  private boolean mvq = false;
  
  private void xU()
  {
    if (this.eXT.size() > 0)
    {
      enableOptionMenu(1, true);
      return;
    }
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
    return getIntent().getStringExtra("titile");
  }
  
  protected final o VF()
  {
    return new a(this, this.chatroomName);
  }
  
  protected final m VG()
  {
    return new b(this, this.chatroomName);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.eXT.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.eXS.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  protected final void bgx()
  {
    super.bgx();
    XM();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.e.multitalk_select_contact_ui;
  }
  
  protected void initView()
  {
    super.initView();
    ta(getResources().getColor(a.b.dark_actionbar_color));
    czo();
    this.mvp = new d(this);
    if (this.mvo) {
      this.mvp.setVisible(true);
    }
    for (;;)
    {
      int i = a.g.app_ok;
      if (this.mvo) {
        i = a.g.multitalk_start_talk;
      }
      a(1, getString(i), new MultiTalkSelectContactUI.1(this), s.b.uNx);
      xU();
      this.mbR.setBackgroundResource(a.b.dark_actionbar_color);
      this.mbR.getInputText().setTextColor(-1);
      return;
      this.mvp.setVisible(false);
    }
  }
  
  public final void jP(int paramInt)
  {
    int k = 1;
    n localn = cHE();
    Object localObject = localn.HK(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (((com.tencent.mm.ui.contact.a.a)localObject).dnp == null);
      y.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject).dnp.field_username });
      localObject = ((com.tencent.mm.ui.contact.a.a)localObject).dnp.field_username;
    } while (q.Gj().equals(localObject));
    cHK();
    d locald;
    int i;
    int j;
    if (this.eXT.contains(localObject)) {
      if (this.mvo)
      {
        locald = this.mvp;
        if (locald.size != 0)
        {
          i = -1;
          paramInt = 0;
          if (paramInt >= locald.mvO.getChildCount()) {
            break label446;
          }
          if (!locald.mvO.getChildAt(paramInt).getTag().equals(localObject)) {
            break label301;
          }
          j = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        i = 0;
        label163:
        if (i < locald.mvP.getChildCount()) {
          if (!locald.mvP.getChildAt(i).getTag().equals(localObject)) {}
        }
      }
      for (paramInt = k;; paramInt = k)
      {
        if (i >= 0)
        {
          if (paramInt != 0)
          {
            locald.mvP.removeViewAt(i);
            locald.size -= 1;
          }
          if (j != 0)
          {
            if (locald.size <= 5)
            {
              locald.mvO.removeViewAt(i);
              locald.size -= 1;
            }
          }
          else
          {
            label261:
            locald.ut(locald.size);
            locald.uu(locald.size);
          }
        }
        else
        {
          this.eXT.remove(localObject);
        }
        for (;;)
        {
          localn.notifyDataSetChanged();
          xU();
          return;
          label301:
          paramInt += 1;
          break;
          i += 1;
          break label163;
          locald.mvO.removeViewAt(i);
          View localView = locald.mvP.getChildAt(0);
          locald.mvP.removeViewAt(0);
          locald.mvO.addView(localView);
          locald.size -= 1;
          break label261;
          if (this.eXS.size() + this.eXT.size() == 9)
          {
            this.mvq = true;
            Toast.makeText(this, a.g.multitalk_select_at, 0).show();
            return;
          }
          if (this.mvo) {
            this.mvp.IM((String)localObject);
          }
          this.eXT.add(localObject);
        }
        k = 0;
        i = paramInt;
      }
      label446:
      j = 0;
      paramInt = i;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("always_select_contact");
    if (!bk.bl(paramBundle)) {
      this.eXS.addAll(bk.G(paramBundle.split(",")));
    }
    this.eXS.add(q.Gj());
    if (this.mvo) {
      this.mvp.IM(q.Gj());
    }
    com.tencent.mm.sdk.b.a.udP.c(this.mtY);
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.mtY);
    super.onDestroy();
  }
  
  protected final void xK()
  {
    super.xK();
    this.mvo = getIntent().getBooleanExtra("key_need_gallery", false);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!s.fn(this.chatroomName)) {
      finish();
    }
    this.eXT = new HashSet();
    this.eXS = new HashSet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI
 * JD-Core Version:    0.7.0.1
 */
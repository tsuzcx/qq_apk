package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.widget.b.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class SelectRemittanceContactUI
  extends MMBaseSelectContactUI
{
  private List<String> ejc;
  private int fromScene;
  private View oxB;
  private List<String> qoY;
  
  public final void Kc()
  {
    AppMethodBeat.i(45172);
    super.Kc();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject = getIntent().getStringExtra("recent_remittance_contact_list");
    ab.v("MicroMsg.SelectRemittanceContactUI", "recent list:".concat(String.valueOf(localObject)));
    this.qoY = new ArrayList();
    if (!bo.isNullOrNil((String)localObject)) {
      this.qoY = bo.P(((String)localObject).split(","));
    }
    localObject = new HashSet();
    ((HashSet)localObject).addAll(t.dMg());
    ((HashSet)localObject).addAll(t.dMh());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!bo.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bo.P(str.split(",")));
    }
    this.ejc = new ArrayList();
    this.ejc.addAll((Collection)localObject);
    AppMethodBeat.o(45172);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(45178);
    super.a(paramListView, paramInt);
    View localView;
    TextView localTextView;
    if (this.oxB == null)
    {
      localView = View.inflate(this, 2130970646, null);
      this.oxB = localView.findViewById(2131820946);
      localTextView = (TextView)localView.findViewById(2131821071);
      if (this.fromScene != 1) {
        break label81;
      }
      localTextView.setText(2131305635);
    }
    for (;;)
    {
      paramListView.addHeaderView(localView);
      this.oxB.setVisibility(paramInt);
      AppMethodBeat.o(45178);
      return;
      label81:
      localTextView.setText(2131302589);
    }
  }
  
  public final boolean apa()
  {
    return false;
  }
  
  public final boolean apb()
  {
    return false;
  }
  
  public final String apc()
  {
    AppMethodBeat.i(45177);
    if (this.fromScene == 1)
    {
      str = getString(2131305639);
      AppMethodBeat.o(45177);
      return str;
    }
    String str = getString(2131302629);
    AppMethodBeat.o(45177);
    return str;
  }
  
  public final p apd()
  {
    AppMethodBeat.i(45173);
    g localg = new g(this, this.qoY, this.ejc, this.fromScene);
    AppMethodBeat.o(45173);
    return localg;
  }
  
  public final n ape()
  {
    AppMethodBeat.i(45174);
    r localr = new r(this, this.ejc, false, this.scene);
    AppMethodBeat.o(45174);
    return localr;
  }
  
  public final int[] bOp()
  {
    if (this.fromScene == 1) {
      return new int[] { 131072, 131075 };
    }
    return new int[] { 131072 };
  }
  
  public final void bOq()
  {
    AppMethodBeat.i(45179);
    super.bOq();
    hideVKB();
    AppMethodBeat.o(45179);
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(45175);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ab.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      ab.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      localObject1 = new Intent();
      if (this.fromScene == 1)
      {
        ((Intent)localObject1).putExtra("list_attr", t.F(new int[] { t.AdS, 16384, 64, 4096, 262144 }));
        ((Intent)localObject1).putExtra("min_limit_num", 1);
        ((Intent)localObject1).putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        ((Intent)localObject1).putExtra("titile", getString(2131305641));
        ((Intent)localObject1).putExtra("without_openim", true);
      }
      for (;;)
      {
        d.b(this, ".ui.contact.SelectContactUI", (Intent)localObject1, 1);
        overridePendingTransition(2131034230, 2131034182);
        AppMethodBeat.o(45175);
        return;
        paramInt = t.F(new int[] { 16, 1, 2, 4, 16384 });
        ((Intent)localObject1).putExtra("list_type", 0);
        ((Intent)localObject1).putExtra("list_attr", paramInt);
        ((Intent)localObject1).putExtra("titile", getString(2131302625));
        ((Intent)localObject1).putExtra("sub_title", getString(2131305715));
      }
    }
    Object localObject1 = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (localObject1 == null)
    {
      AppMethodBeat.o(45175);
      return;
    }
    Object localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact;
    if (localObject2 == null)
    {
      AppMethodBeat.o(45175);
      return;
    }
    localObject1 = ((aq)localObject2).field_username;
    if ((ad.arg((String)localObject1)) || (ad.arf((String)localObject1)))
    {
      ab.i("MicroMsg.SelectRemittanceContactUI", "username[%s] is openime || oepnimechatroom", new Object[] { bo.bf((String)localObject1, "null") });
      localObject2 = ah.getContext();
      if (ad.arg((String)localObject1)) {}
      for (localObject1 = ((Context)localObject2).getString(2131305638);; localObject1 = ((Context)localObject2).getString(2131305637))
      {
        localObject1 = new e.a((Context)localObject2).avu((String)localObject1);
        ((e.a)localObject1).AHs = ((Context)localObject2).getString(2131305958);
        ((e.a)localObject1).AHv = true;
        ((e.a)localObject1).b(new SelectRemittanceContactUI.1(this)).show();
        AppMethodBeat.o(45175);
        return;
      }
    }
    localObject1 = ((aq)localObject2).field_username;
    ab.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { localObject1 });
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("Select_Conv_User", (String)localObject1);
    setResult(-1, (Intent)localObject2);
    finish();
    hideVKB();
    if ((dLW() instanceof g))
    {
      paramInt -= getContentLV().getHeaderViewsCount();
      localObject1 = (g)dLW();
      ab.d("MicroMsg.RecentConversationAdapter", "pos: %s", new Object[] { Integer.valueOf(paramInt) });
      if (((g)localObject1).qoW < 0) {
        break label584;
      }
      if (((g)localObject1).qoX >= 0) {
        break label563;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0) {
        h.qsU.e(13721, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
      }
      AppMethodBeat.o(45175);
      return;
      label563:
      if ((paramInt > ((g)localObject1).qoW) && (paramInt < ((g)localObject1).qoX)) {
        paramInt = 1;
      } else {
        label584:
        paramInt = 0;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45176);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ab.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        ab.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
        setResult(-1, paramIntent);
        finish();
      }
      AppMethodBeat.o(45176);
      return;
      ab.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
    }
    ab.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(45176);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45171);
    super.onCreate(paramBundle);
    AppMethodBeat.o(45171);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(45180);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      AppMethodBeat.o(45180);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(45180);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(45181);
    if (paramInt == 4) {
      bOq();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(45181);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI
 * JD-Core Version:    0.7.0.1
 */
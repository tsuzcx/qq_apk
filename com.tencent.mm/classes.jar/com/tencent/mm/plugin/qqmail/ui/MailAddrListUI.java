package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.q.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MailAddrListUI
  extends MMActivity
{
  private TextView gAc;
  private com.tencent.mm.plugin.qqmail.b.p pJC;
  private com.tencent.mm.ui.base.p pNh;
  private TextView pNi;
  private ListView pNj;
  private MailAddrListUI.a pNk;
  private List<o> pNl;
  private p.a pNm;
  
  public MailAddrListUI()
  {
    AppMethodBeat.i(68327);
    this.pNh = null;
    this.gAc = null;
    this.pNi = null;
    this.pJC = null;
    this.pNm = new p.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(68311);
        if (MailAddrListUI.a(MailAddrListUI.this) != null) {
          MailAddrListUI.a(MailAddrListUI.this).dismiss();
        }
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).Xs(null));
        if (MailAddrListUI.c(MailAddrListUI.this).size() == 0)
        {
          MailAddrListUI.d(MailAddrListUI.this).setText(2131303397);
          MailAddrListUI.d(MailAddrListUI.this).setVisibility(0);
        }
        Object localObject1 = MailAddrListUI.this.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
        if (localObject1 == null) {
          localObject1 = new String[] { "" };
        }
        for (;;)
        {
          int k = localObject1.length;
          int i = 0;
          Object localObject2;
          Object localObject3;
          if (i < k)
          {
            localObject2 = com.tencent.mm.plugin.qqmail.b.p.Xt(localObject1[i]);
            if (localObject2 != null)
            {
              localObject3 = MailAddrListUI.c(MailAddrListUI.this).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                o localo = (o)((Iterator)localObject3).next();
                if (localo.nZR.equalsIgnoreCase(((o)localObject2).nZR)) {
                  MailAddrListUI.e(MailAddrListUI.this).c(localo);
                }
              }
            }
          }
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              MailAddrListUI.e(MailAddrListUI.this).c((o)localObject2);
            }
            i += 1;
            break;
            localObject2 = MailAddrListUI.this;
            localObject3 = new StringBuilder().append(MailAddrListUI.this.getString(2131302109));
            if (MailAddrListUI.e(MailAddrListUI.this).ces() > 0) {}
            for (localObject1 = "(" + MailAddrListUI.e(MailAddrListUI.this).ces() + ")";; localObject1 = "")
            {
              ((MailAddrListUI)localObject2).setMMTitle((String)localObject1);
              MailAddrListUI.e(MailAddrListUI.this).notifyDataSetChanged();
              AppMethodBeat.o(68311);
              return;
            }
          }
        }
      }
    };
    AppMethodBeat.o(68327);
  }
  
  public int getLayoutId()
  {
    return 2130970481;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68329);
    this.pNj = ((ListView)findViewById(2131826881));
    this.gAc = ((TextView)findViewById(2131825157));
    this.pNi = ((TextView)findViewById(2131826882));
    this.pNk = new MailAddrListUI.a(this, this);
    Object localObject = new q((byte)0);
    ((q)localObject).Axg = new q.b()
    {
      public final void apN() {}
      
      public final void apO() {}
      
      public final void apP() {}
      
      public final void apQ() {}
      
      public final boolean wR(String paramAnonymousString)
      {
        return false;
      }
      
      public final void wS(String paramAnonymousString)
      {
        AppMethodBeat.i(68312);
        paramAnonymousString = bo.bf(paramAnonymousString, "");
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).Xs(paramAnonymousString.toLowerCase().trim()));
        if (paramAnonymousString.length() > 0)
        {
          MailAddrListUI.e(MailAddrListUI.this).pNp = true;
          MailAddrListUI.e(MailAddrListUI.this).pNo = false;
          if (MailAddrListUI.c(MailAddrListUI.this).size() != 0) {
            break label130;
          }
          MailAddrListUI.this.enableOptionMenu(false);
          MailAddrListUI.f(MailAddrListUI.this).setVisibility(0);
        }
        for (;;)
        {
          MailAddrListUI.e(MailAddrListUI.this).notifyDataSetChanged();
          AppMethodBeat.o(68312);
          return;
          MailAddrListUI.e(MailAddrListUI.this).pNp = false;
          break;
          label130:
          MailAddrListUI.this.enableOptionMenu(true);
          MailAddrListUI.f(MailAddrListUI.this).setVisibility(8);
        }
      }
    };
    addSearchMenu(true, (q)localObject);
    this.pNj.setAdapter(this.pNk);
    this.pNj.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(68313);
        paramAnonymousAdapterView = MailAddrListUI.e(MailAddrListUI.this);
        paramAnonymousView = paramAnonymousAdapterView.Ca(paramAnonymousInt - MailAddrListUI.g(MailAddrListUI.this).getHeaderViewsCount());
        Object localObject = paramAnonymousView.nZR;
        if (paramAnonymousAdapterView.pNq.containsKey(localObject))
        {
          paramAnonymousAdapterView.pNq.remove(localObject);
          paramAnonymousAdapterView.notifyDataSetChanged();
          paramAnonymousView = MailAddrListUI.this;
          localObject = new StringBuilder().append(MailAddrListUI.this.getString(2131302109));
          if (MailAddrListUI.e(MailAddrListUI.this).ces() <= 0) {
            break label171;
          }
        }
        label171:
        for (paramAnonymousAdapterView = "(" + MailAddrListUI.e(MailAddrListUI.this).ces() + ")";; paramAnonymousAdapterView = "")
        {
          paramAnonymousView.setMMTitle(paramAnonymousAdapterView);
          AppMethodBeat.o(68313);
          return;
          paramAnonymousAdapterView.pNq.put(localObject, paramAnonymousView);
          break;
        }
      }
    });
    this.pNj.setOnScrollListener(new MailAddrListUI.4(this));
    this.pNl = this.pJC.Xs(null);
    this.pNk.notifyDataSetChanged();
    setBackBtn(new MailAddrListUI.5(this));
    setToTop(new MailAddrListUI.6(this));
    addTextOptionMenu(0, getString(2131302108), new MailAddrListUI.7(this));
    if (!this.pNl.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(bool);
      localObject = getContext();
      getString(2131297087);
      this.pNh = h.b((Context)localObject, getString(2131302107), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      AppMethodBeat.o(68329);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68328);
    super.onCreate(paramBundle);
    setMMTitle(2131302109);
    this.pNl = new ArrayList();
    this.pJC = ac.cdQ().pJC;
    initView();
    this.pJC.a(this.pNm);
    this.pJC.cdE();
    AppMethodBeat.o(68328);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68332);
    super.onDestroy();
    this.pJC.b(this.pNm);
    AppMethodBeat.o(68332);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68330);
    super.onPause();
    AppMethodBeat.o(68330);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68331);
    super.onResume();
    this.pNk.notifyDataSetChanged();
    AppMethodBeat.o(68331);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI
 * JD-Core Version:    0.7.0.1
 */
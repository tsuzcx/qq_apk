package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.mc;
import com.tencent.mm.h.a.qo;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.l;
import com.tencent.mm.plugin.setting.model.l.1;
import com.tencent.mm.plugin.setting.model.l.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.b;>;

public class UnfamiliarContactDetailUI
  extends MMActivity
  implements f
{
  public static final String dse = new String(Character.toChars(123));
  private com.tencent.mm.ui.base.p dpF = null;
  private ArrayList<UnfamiliarContactDetailUI.b> gAi = new ArrayList();
  private boolean nQP;
  private boolean nQQ;
  private boolean nQR;
  private RecyclerView nWG;
  private TextView nWH;
  private View nWI;
  private View nWJ;
  private View nWK;
  private View nWL;
  private TextView nWM;
  private UnfamiliarContactDetailUI.a nWN;
  private RealAlphabetScrollBar nWO;
  HashMap<String, Integer> nWP = new HashMap();
  private HashMap<Integer, String> nWQ = new HashMap();
  private HashSet<Integer> nWR = new HashSet();
  private UnfamiliarContactDetailUI.d nWS;
  private int nWT = -1;
  private HashSet<String> nWU = new HashSet();
  private l nWV;
  private boolean nWW;
  
  private void cs(List<UnfamiliarContactDetailUI.b> paramList)
  {
    this.nWP.clear();
    this.nWQ.clear();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (paramList = null; localIterator.hasNext(); paramList = (List<UnfamiliarContactDetailUI.b>)localObject)
    {
      localObject = (UnfamiliarContactDetailUI.b)localIterator.next();
      if (dse.equalsIgnoreCase(((UnfamiliarContactDetailUI.b)localObject).nXd)) {
        ((UnfamiliarContactDetailUI.b)localObject).nXd = "#";
      }
      localObject = ((UnfamiliarContactDetailUI.b)localObject).nXd;
      if (!((String)localObject).equalsIgnoreCase(paramList))
      {
        this.nWP.put(((String)localObject).toUpperCase(), Integer.valueOf(i));
        this.nWQ.put(Integer.valueOf(i), ((String)localObject).toUpperCase());
      }
      i += 1;
    }
  }
  
  private void ew(boolean paramBoolean)
  {
    y.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.dpF = com.tencent.mm.ui.base.p.b(this, getString(a.i.unfamiliar_contact_member_handling), true, 0, null);
    }
    while ((this.dpF == null) || (!this.dpF.isShowing())) {
      return;
    }
    this.dpF.dismiss();
    this.dpF = null;
  }
  
  protected final int getLayoutId()
  {
    return a.g.settings_unfamiliar_contact_detail_ui;
  }
  
  protected final void initView()
  {
    int j = 0;
    super.initView();
    setMMTitle(a.i.settings_unfamiliar_contact);
    addTextOptionMenu(1, getString(a.i.unfamiliar_contact_member_multi_select), new UnfamiliarContactDetailUI.1(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        UnfamiliarContactDetailUI.this.finish();
        return true;
      }
    });
    View localView = findViewById(a.f.settings_half_year_not_chat_title);
    if (this.nQP)
    {
      i = 0;
      localView.setVisibility(i);
      localView = findViewById(a.f.settings_has_not_same_chatroom_title);
      if (!this.nQR) {
        break label339;
      }
      i = 0;
      label84:
      localView.setVisibility(i);
      localView = findViewById(a.f.settings_half_year_not_response_title);
      if (!this.nQQ) {
        break label345;
      }
    }
    label339:
    label345:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      this.nWG = ((RecyclerView)findViewById(a.f.unfamiliar_member_list));
      this.nWI = findViewById(a.f.bottom_bar);
      this.nWH = ((TextView)findViewById(a.f.member_list_title));
      this.nWS = new UnfamiliarContactDetailUI.d(this, this.nWR, new UnfamiliarContactDetailUI.6(this));
      this.nWJ = findViewById(a.f.unfamiliar_contact_member_delete);
      this.nWJ.setOnClickListener(new UnfamiliarContactDetailUI.7(this));
      this.nWK = findViewById(a.f.unfamiliar_contact_member_more);
      this.nWK.setOnClickListener(new UnfamiliarContactDetailUI.8(this));
      this.nWL = findViewById(a.f.unfamiliar_contact_member_select_all_area);
      this.nWL.setOnClickListener(new UnfamiliarContactDetailUI.9(this));
      this.nWM = ((TextView)findViewById(a.f.tip_tv));
      this.nWG.setLayoutManager(new LinearLayoutManager());
      this.nWN = new UnfamiliarContactDetailUI.a(this);
      this.nWG.setAdapter(this.nWN);
      this.nWO = ((RealAlphabetScrollBar)findViewById(a.f.unfamiliar_member_scrollbar));
      this.nWO.setOnScrollBarTouchListener(new UnfamiliarContactDetailUI.10(this));
      return;
      i = 8;
      break;
      i = 8;
      break label84;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.Dk().a(291, this);
    this.nQP = getIntent().getBooleanExtra("half_year_not_chat", false);
    this.nQQ = getIntent().getBooleanExtra("half_year_not_response", false);
    this.nQR = getIntent().getBooleanExtra("has_not_same_chatroom", false);
    initView();
    paramBundle = new UnfamiliarContactDetailUI.11(this);
    this.nWV = new l(this.nQP, this.nQQ, this.nQR, paramBundle);
    paramBundle = this.nWV;
    paramBundle.nQZ = System.currentTimeMillis();
    paramBundle.nQY.a(UnfamiliarContactDetailUI.e.nXt);
    paramBundle.dKQ.O(new l.1(paramBundle));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    int i;
    int j;
    if (this.nQP)
    {
      i = 1;
      if (!this.nQR) {
        break label339;
      }
      j = 2;
      label22:
      if (!this.nQQ) {
        break label344;
      }
    }
    label339:
    label344:
    for (int k = 4;; k = 0)
    {
      i = k | j | i;
      h.nFQ.f(14434, new Object[] { Integer.valueOf(i), Integer.valueOf(UnfamiliarContactDetailUI.f.nXw), Integer.valueOf(UnfamiliarContactDetailUI.f.nXv), Integer.valueOf(UnfamiliarContactDetailUI.f.nXA), Integer.valueOf(UnfamiliarContactDetailUI.f.nXx), Integer.valueOf(UnfamiliarContactDetailUI.f.nXz), Integer.valueOf(UnfamiliarContactDetailUI.f.nXy) });
      y.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(UnfamiliarContactDetailUI.f.nXw), Integer.valueOf(UnfamiliarContactDetailUI.f.nXv), Integer.valueOf(UnfamiliarContactDetailUI.f.nXA), Integer.valueOf(UnfamiliarContactDetailUI.f.nXx), Integer.valueOf(UnfamiliarContactDetailUI.f.nXz), Integer.valueOf(UnfamiliarContactDetailUI.f.nXy) });
      UnfamiliarContactDetailUI.f.nXv = 0;
      UnfamiliarContactDetailUI.f.nXw = 0;
      UnfamiliarContactDetailUI.f.nXx = 0;
      UnfamiliarContactDetailUI.f.nXy = 0;
      UnfamiliarContactDetailUI.f.nXz = 0;
      UnfamiliarContactDetailUI.f.nXA = 0;
      g.Dk().b(291, this);
      g.Dk().b(681, this.nWS);
      l locall = this.nWV;
      y.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[] { Boolean.valueOf(locall.nQQ), Boolean.valueOf(locall.nQP), Boolean.valueOf(locall.nQR) });
      if (locall.nQX != null)
      {
        l.a locala = locall.nQX;
        g.Dk().b(292, locala);
      }
      locall.dKQ.mnU.quit();
      e.Y(locall.mRunnable);
      return;
      i = 0;
      break;
      j = 0;
      break label22;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      onBackPressed();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    int i;
    if (-1 != this.nWT)
    {
      if (-1 != this.nWT) {
        break label64;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        UnfamiliarContactDetailUI.f.nXw += 1;
      }
      this.nWT = -1;
      this.nWU.clear();
      if (this.nWN != null) {
        this.nWN.agL.notifyChanged();
      }
      return;
      label64:
      UnfamiliarContactDetailUI.b localb = (UnfamiliarContactDetailUI.b)this.gAi.get(this.nWT);
      ad localad1 = localb.dnp;
      ad localad2 = ((j)g.r(j.class)).Fw().abl(localad1.field_username);
      if ((!com.tencent.mm.n.a.gR(localad2.field_type)) && (com.tencent.mm.n.a.gR(localad1.field_type)))
      {
        this.gAi.remove(this.nWT);
        i = 1;
      }
      else
      {
        localb.dnp = localad2;
        i = 0;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramm.getType());
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this, getString(a.i.unfamiliar_contact_setting_err), 1).show();
    }
    if (paramm.getType() == 291)
    {
      ew(false);
      this.nWU.clear();
      this.nWN.agL.notifyChanged();
    }
  }
  
  public static abstract interface h
  {
    public abstract void a(UnfamiliarContactDetailUI.e parame);
    
    public abstract void e(HashSet paramHashSet);
    
    public abstract void onError();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI
 * JD-Core Version:    0.7.0.1
 */
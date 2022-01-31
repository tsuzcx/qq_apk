package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class ShakeItemListUI
  extends MMActivity
{
  private a fGJ;
  private ListView gAb;
  private int id;
  private n.d jSn;
  private View kxi;
  public long qPI;
  private boolean qPJ;
  private ShakeItemListUI.a qPK;
  private int showType;
  
  public ShakeItemListUI()
  {
    AppMethodBeat.i(24738);
    this.qPI = 0L;
    this.qPJ = false;
    this.fGJ = null;
    this.jSn = new ShakeItemListUI.8(this);
    AppMethodBeat.o(24738);
  }
  
  public static int Dr(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 0: 
    default: 
      return 2131303577;
    case 100: 
      return 2131303581;
    case -5: 
    case 4: 
      return 2131303611;
    case -6: 
    case 5: 
      return 2131303651;
    }
    return 2131303584;
  }
  
  protected final void Dq(int paramInt)
  {
    AppMethodBeat.i(24744);
    this.qPK.Dq(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24744);
      return;
      if (this.kxi != null)
      {
        this.kxi.findViewById(2131827703).setVisibility(8);
        AppMethodBeat.o(24744);
        return;
        if (this.kxi != null) {
          this.kxi.findViewById(2131827703).setVisibility(0);
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130970710;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24740);
    this.fGJ = new a(this);
    aw.aaz();
    int i = bo.a((Integer)c.Ru().get(12290, null), 0);
    this.showType = getIntent().getIntExtra("_key_show_type_", 0);
    Object localObject = getIntent().getStringExtra("_key_title_");
    if (!bo.isNullOrNil((String)localObject)) {
      setMMTitle((String)localObject);
    }
    this.qPJ = getIntent().getBooleanExtra("_key_show_from_shake_", false);
    addTextOptionMenu(0, getString(2131296891), new ShakeItemListUI.1(this));
    this.gAb = ((ListView)findViewById(2131826488));
    this.kxi = getLayoutInflater().inflate(2130970712, null);
    this.kxi.findViewById(2131827703).setOnClickListener(new ShakeItemListUI.2(this));
    this.gAb.addFooterView(this.kxi);
    if (this.showType == -1)
    {
      this.kxi.findViewById(2131827703).setVisibility(0);
      this.qPK = new ShakeItemListUI.a(this, this);
      this.qPK.Dq(this.showType);
      if (this.qPK.getCount() > 0) {
        break label325;
      }
      this.gAb.setVisibility(8);
      localObject = (TextView)findViewById(2131826489);
      ((TextView)localObject).setText(Dr(this.showType));
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      setBackBtn(new ShakeItemListUI.5(this));
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24725);
          BackwardSupportUtil.c.a(ShakeItemListUI.c(ShakeItemListUI.this));
          AppMethodBeat.o(24725);
        }
      });
      this.gAb.setOnTouchListener(new ShakeItemListUI.7(this));
      AppMethodBeat.o(24740);
      return;
      this.kxi.findViewById(2131827703).setVisibility(8);
      break;
      label325:
      this.gAb.setAdapter(this.qPK);
      this.gAb.setOnItemClickListener(new ShakeItemListUI.3(this, i));
      localObject = new l(this);
      this.gAb.setOnItemLongClickListener(new ShakeItemListUI.4(this, (l)localObject));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24739);
    super.onCreate(paramBundle);
    initView();
    m.cln().add(this.qPK);
    this.qPK.Kv();
    ab.i("MicroMsg.ShakeItemListUI", "onResume");
    AppMethodBeat.o(24739);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(24741);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.id = ((d)this.qPK.getItem(paramView.position)).field_shakeItemID;
    paramContextMenu.add(paramView.position, 0, 0, 2131296901);
    AppMethodBeat.o(24741);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24743);
    this.qPK.bKb();
    ShakeItemListUI.a locala = this.qPK;
    if (locala.gxo != null)
    {
      locala.gxo.detach();
      locala.gxo = null;
    }
    m.cln().remove(this.qPK);
    ab.i("MicroMsg.ShakeItemListUI", "onPause");
    if (this.fGJ != null) {
      this.fGJ.detach();
    }
    super.onDestroy();
    AppMethodBeat.o(24743);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24742);
    super.onPause();
    AppMethodBeat.o(24742);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI
 * JD-Core Version:    0.7.0.1
 */
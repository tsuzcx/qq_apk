package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI
  extends MMActivity
{
  private List<String> AcR = null;
  private boolean AcS = false;
  private boolean AcT = true;
  private boolean AcU;
  private int AcV;
  private ListView AcW;
  private l AcX;
  private HashMap<String, Long> AcY;
  private TextView emptyTipTv;
  private List<ad> oBz;
  
  private void Km()
  {
    AppMethodBeat.i(33741);
    StringBuilder localStringBuilder;
    if (this.AcS)
    {
      localStringBuilder = new StringBuilder().append(getString(2131297018));
      if (this.AcR.size() <= 0) {
        break label85;
      }
    }
    label85:
    for (String str = String.format("(%s)", new Object[] { Integer.valueOf(this.AcR.size()) });; str = "")
    {
      updateOptionMenuText(1, str);
      AppMethodBeat.o(33741);
      return;
    }
  }
  
  private void a(int paramInt, ad paramad, long paramLong)
  {
    AppMethodBeat.i(33740);
    int i = 0;
    while ((i < paramInt) && (paramLong <= ((Long)this.AcY.get(((ad)this.oBz.get(i)).field_username)).longValue())) {
      i += 1;
    }
    this.oBz.add(i, paramad);
    AppMethodBeat.o(33740);
  }
  
  private void dLU()
  {
    AppMethodBeat.i(33739);
    aw.aaz();
    this.AcY = c.YF().dxe();
    this.oBz = new LinkedList();
    List localList = t.ZX();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(33739);
      return;
    }
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if (!this.AcY.containsKey(localad.field_username))
      {
        if (!a.je(localad.field_type)) {
          break label165;
        }
        this.oBz.add(localad);
      }
      else
      {
        a(i, localad, ((Long)this.AcY.get(localad.field_username)).longValue());
        i += 1;
      }
    }
    label165:
    for (;;)
    {
      break;
      localList.clear();
      AppMethodBeat.o(33739);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130969850;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33738);
    this.AcW = ((ListView)findViewById(2131824831));
    this.AcX = new l(getApplicationContext(), this.oBz, this.AcR, this.AcS);
    this.AcW.setAdapter(this.AcX);
    this.AcW.setOnItemClickListener(new GroupCardSelectUI.1(this));
    this.emptyTipTv = ((TextView)findViewById(2131824832));
    if (this.AcX.getCount() <= 0) {
      this.emptyTipTv.setVisibility(0);
    }
    for (;;)
    {
      setBackBtn(new GroupCardSelectUI.2(this));
      AppMethodBeat.o(33738);
      return;
      this.emptyTipTv.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33734);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131296493));
    this.AcT = getIntent().getBooleanExtra("group_select_type", true);
    this.AcU = getIntent().getBooleanExtra("group_select_need_result", false);
    this.AcS = getIntent().getBooleanExtra("group_multi_select", false);
    if (this.AcS)
    {
      paramBundle = getIntent().getStringExtra("already_select_contact");
      if (!bo.isNullOrNil(paramBundle)) {
        break label173;
      }
    }
    label173:
    for (this.AcR = new LinkedList();; this.AcR = ah.h(paramBundle.split(",")))
    {
      this.AcV = getIntent().getIntExtra("max_limit_num", 0);
      dLU();
      initView();
      if (this.AcS)
      {
        addTextOptionMenu(1, getString(2131297018), new GroupCardSelectUI.3(this), null, q.b.zby);
        enableOptionMenu(1, true);
        Km();
      }
      AppMethodBeat.o(33734);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33735);
    super.onDestroy();
    AppMethodBeat.o(33735);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33737);
    super.onPause();
    AppMethodBeat.o(33737);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33736);
    super.onResume();
    AppMethodBeat.o(33736);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    TextView Ada;
    ImageView gxs;
    TextView nZD;
    CheckBox pvL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI
 * JD-Core Version:    0.7.0.1
 */
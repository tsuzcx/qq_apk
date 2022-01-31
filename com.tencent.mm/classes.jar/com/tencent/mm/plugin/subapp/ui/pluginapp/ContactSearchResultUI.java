package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.o;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI
  extends MMActivity
{
  private static ah dPu = new ah(Looper.getMainLooper());
  private LinkedList<bnk> dTx = new LinkedList();
  private ListView pxH;
  private ContactSearchResultUI.a pxI;
  private LinkedList<bob> pxJ = new LinkedList();
  private Map<String, ContactSearchResultUI.b> pxK;
  
  protected final int getLayoutId()
  {
    return R.i.contact_search_result;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.contact_search_result);
    setBackBtn(new ContactSearchResultUI.1(this));
    this.pxK = new HashMap();
    this.pxH = ((ListView)findViewById(R.h.result_contactlist));
    Object localObject = (TextView)findViewById(R.h.empty);
    this.pxH.setEmptyView((View)localObject);
    localObject = getIntent().getByteArrayExtra("result");
    int i = getIntent().getIntExtra("add_more_friend_search_scene", 0);
    if (localObject != null) {}
    try
    {
      bnm localbnm = (bnm)new bnm().aH((byte[])localObject);
      if (localbnm != null)
      {
        this.dTx = localbnm.tcB;
        this.pxJ = localbnm.tGw;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException2, "SearchContactResponse", new Object[0]);
        try
        {
          localObject = (bob)new bob().aH((byte[])localObject);
          this.pxJ.add(localObject);
        }
        catch (Exception localException1)
        {
          y.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException1, "SearchOpenIMContactItem", new Object[0]);
        }
      }
      this.pxI = new ContactSearchResultUI.a(this, this);
      this.pxH.setAdapter(this.pxI);
      this.pxH.setOnItemClickListener(new ContactSearchResultUI.2(this, i));
      this.pxH.setOnScrollListener(new a());
    }
    if ((this.dTx.size() == 0) && (this.pxJ.isEmpty())) {
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onDestroy()
  {
    o.Kj().cancel();
    if (this.pxK != null) {
      this.pxK.clear();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI
 * JD-Core Version:    0.7.0.1
 */
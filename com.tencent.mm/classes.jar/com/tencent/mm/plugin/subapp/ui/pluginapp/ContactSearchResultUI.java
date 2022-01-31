package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI
  extends MMActivity
{
  private static ak feT;
  private LinkedList<bxf> fjy;
  private ListView sZv;
  private ContactSearchResultUI.a sZw;
  private LinkedList<bxw> sZx;
  private Map<String, ContactSearchResultUI.b> sZy;
  
  static
  {
    AppMethodBeat.i(25524);
    feT = new ak(Looper.getMainLooper());
    AppMethodBeat.o(25524);
  }
  
  public ContactSearchResultUI()
  {
    AppMethodBeat.i(25519);
    this.fjy = new LinkedList();
    this.sZx = new LinkedList();
    AppMethodBeat.o(25519);
  }
  
  public int getLayoutId()
  {
    return 2130969272;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25521);
    setMMTitle(2131298845);
    setBackBtn(new ContactSearchResultUI.1(this));
    this.sZy = new HashMap();
    this.sZv = ((ListView)findViewById(2131823244));
    Object localObject = (TextView)findViewById(2131821788);
    this.sZv.setEmptyView((View)localObject);
    localObject = getIntent().getByteArrayExtra("result");
    int i = getIntent().getIntExtra("add_more_friend_search_scene", 0);
    if (localObject != null) {}
    try
    {
      bxh localbxh = (bxh)new bxh().parseFrom((byte[])localObject);
      if (localbxh != null)
      {
        this.fjy = localbxh.xaT;
        this.sZx = localbxh.xKl;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException2, "SearchContactResponse", new Object[0]);
        try
        {
          localObject = (bxw)new bxw().parseFrom((byte[])localObject);
          this.sZx.add(localObject);
        }
        catch (Exception localException1)
        {
          ab.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException1, "SearchOpenIMContactItem", new Object[0]);
        }
      }
      this.sZw = new ContactSearchResultUI.a(this, this);
      this.sZv.setAdapter(this.sZw);
      this.sZv.setOnItemClickListener(new ContactSearchResultUI.2(this, i));
      this.sZv.setOnScrollListener(new a());
      AppMethodBeat.o(25521);
    }
    if ((this.fjy.size() == 0) && (this.sZx.isEmpty()))
    {
      AppMethodBeat.o(25521);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25520);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(25520);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25522);
    o.adi().cancel();
    if (this.sZy != null) {
      this.sZy.clear();
    }
    super.onDestroy();
    AppMethodBeat.o(25522);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI
 * JD-Core Version:    0.7.0.1
 */
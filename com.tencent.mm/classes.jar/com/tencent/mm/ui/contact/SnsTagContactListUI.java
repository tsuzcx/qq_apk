package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class SnsTagContactListUI
  extends MMActivity
{
  private SnsTagContactListUI.a AfI;
  private List<Long> AfJ;
  private ListView nYW;
  
  public SnsTagContactListUI()
  {
    AppMethodBeat.i(33962);
    this.AfJ = new ArrayList();
    AppMethodBeat.o(33962);
  }
  
  public int getLayoutId()
  {
    return 2130968639;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33964);
    setMMTitle(2131303999);
    findViewById(2131828467).setVisibility(8);
    this.nYW = ((ListView)findViewById(2131821074));
    long[] arrayOfLong = getIntent().getLongArrayExtra("sns_tag_list");
    if (arrayOfLong == null)
    {
      finish();
      AppMethodBeat.o(33964);
      return;
    }
    int i = 0;
    while (i < arrayOfLong.length)
    {
      this.AfJ.add(Long.valueOf(arrayOfLong[i]));
      i += 1;
    }
    ((TextView)findViewById(2131821076)).setVisibility(8);
    findViewById(2131821077).setVisibility(8);
    this.nYW.setBackgroundColor(getResources().getColor(2131690709));
    ((View)this.nYW.getParent()).setBackgroundColor(getResources().getColor(2131690709));
    this.AfI = new SnsTagContactListUI.a(this, this.AfJ);
    this.nYW.setAdapter(this.AfI);
    this.nYW.setVisibility(0);
    this.nYW.setOnItemClickListener(new SnsTagContactListUI.1(this));
    setBackBtn(new SnsTagContactListUI.2(this));
    showOptionMenu(false);
    AppMethodBeat.o(33964);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33963);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(33963);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33966);
    super.onDestroy();
    AppMethodBeat.o(33966);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33965);
    super.onResume();
    if (this.AfI != null) {
      this.AfI.notifyDataSetChanged();
    }
    AppMethodBeat.o(33965);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI
 * JD-Core Version:    0.7.0.1
 */
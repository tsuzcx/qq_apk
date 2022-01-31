package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class SnsTagContactListUI
  extends MMActivity
{
  private ListView lBK;
  private SnsTagContactListUI.a vOa;
  private List<Long> vOb = new ArrayList();
  
  protected final int getLayoutId()
  {
    return R.i.address;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.sns_tag_see);
    findViewById(R.h.loading_tips_area).setVisibility(8);
    this.lBK = ((ListView)findViewById(R.h.address_contactlist));
    long[] arrayOfLong = getIntent().getLongArrayExtra("sns_tag_list");
    if (arrayOfLong == null)
    {
      finish();
      return;
    }
    int i = 0;
    while (i < arrayOfLong.length)
    {
      this.vOb.add(Long.valueOf(arrayOfLong[i]));
      i += 1;
    }
    ((TextView)findViewById(R.h.empty_blacklist_tip_tv)).setVisibility(8);
    findViewById(R.h.address_scrollbar).setVisibility(8);
    this.lBK.setBackgroundColor(getResources().getColor(R.e.white));
    ((View)this.lBK.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
    this.vOa = new SnsTagContactListUI.a(this, this.vOb);
    this.lBK.setAdapter(this.vOa);
    this.lBK.setVisibility(0);
    this.lBK.setOnItemClickListener(new SnsTagContactListUI.1(this));
    setBackBtn(new SnsTagContactListUI.2(this));
    showOptionMenu(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.vOa != null) {
      this.vOa.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI
 * JD-Core Version:    0.7.0.1
 */
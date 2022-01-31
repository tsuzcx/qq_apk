package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoMessagePreference
  extends Preference
{
  MMActivity bER;
  private RecyclerView heQ;
  private boolean jAt = false;
  NewBizInfoMessagePreference.a mZQ;
  d mZz;
  int state = 1;
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  final void initView()
  {
    if (!this.jAt) {
      return;
    }
    if ((this.state != 1) && (this.state != 2) && (this.state == 3))
    {
      this.heQ.setVisibility(0);
      this.heQ.setAdapter(this.mZQ);
      return;
    }
    this.heQ.setVisibility(8);
  }
  
  public final void onBindView(View paramView)
  {
    this.heQ = ((RecyclerView)paramView.findViewById(R.h.new_bizinfo_message_list));
    this.heQ.setLayoutManager(new LinearLayoutManager());
    this.heQ.setNestedScrollingEnabled(false);
    this.jAt = true;
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference
 * JD-Core Version:    0.7.0.1
 */
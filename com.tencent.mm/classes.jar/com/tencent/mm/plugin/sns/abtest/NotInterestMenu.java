package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.ui.y;

public class NotInterestMenu
  extends LinearLayout
{
  private static int[] ojz = { i.j.sns_hate_op_un_like, i.j.sns_hate_op_block, i.j.sns_hate_op_expose };
  private Context mContext = null;
  private NotInterestMenu.c ojA = null;
  private NotInterestMenu.b ojB = null;
  private n oje = null;
  private ListView ojy;
  
  public NotInterestMenu(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public NotInterestMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    y.gt(this.mContext).inflate(i.g.not_interest_menu_content, this);
    this.ojy = ((ListView)findViewById(i.f.not_interest_list));
    this.ojy.setAdapter(new NotInterestMenu.a(this));
    this.ojy.setOnItemClickListener(new NotInterestMenu.1(this));
  }
  
  public void setOnClickMenuListener(NotInterestMenu.b paramb)
  {
    this.ojB = paramb;
  }
  
  public void setOnSelectMenuItemListener(NotInterestMenu.c paramc)
  {
    this.ojA = paramc;
  }
  
  public void setSnsInfo(n paramn)
  {
    this.oje = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.NotInterestMenu
 * JD-Core Version:    0.7.0.1
 */
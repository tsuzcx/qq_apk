package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.o;
import java.util.ArrayList;
import java.util.List;

public final class MailAddrsViewControl$b
  extends BaseAdapter
  implements Filterable
{
  private List<o> fkW;
  private ArrayList<o> fkX;
  private Context mContext;
  private final Object mLock = new Object();
  private boolean niu = true;
  private MailAddrsViewControl.b.a niv;
  
  public MailAddrsViewControl$b(Context paramContext, List<o> paramList)
  {
    this.mContext = paramContext;
    this.fkW = paramList;
  }
  
  public final int getCount()
  {
    return this.fkW.size();
  }
  
  public final Filter getFilter()
  {
    if (this.niv == null) {
      this.niv = new MailAddrsViewControl.b.a(this, (byte)0);
    }
    return this.niv;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, b.g.qqmail_dropdown_addrlist_item, null);
      paramViewGroup = new MailAddrsViewControl.b.b(this, (byte)0);
      paramViewGroup.fhD = ((TextView)paramView.findViewById(b.f.qqmail_addrlist_item_name_tv));
      paramViewGroup.nif = ((TextView)paramView.findViewById(b.f.qqmail_addrlist_item_addr_iv));
      paramViewGroup.nix = ((CheckBox)paramView.findViewById(b.f.qqmail_addrlist_item_select_cb));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = wo(paramInt);
      MailAddrsViewControl.b.b localb = (MailAddrsViewControl.b.b)paramView.getTag();
      localb.fhD.setText(paramViewGroup.name);
      localb.nif.setText(paramViewGroup.lCF);
      localb.nix.setVisibility(8);
      paramView.setBackgroundColor(-789517);
      return paramView;
      paramView = (ViewGroup)paramView;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.niu = true;
  }
  
  public final o wo(int paramInt)
  {
    return (o)this.fkW.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b
 * JD-Core Version:    0.7.0.1
 */
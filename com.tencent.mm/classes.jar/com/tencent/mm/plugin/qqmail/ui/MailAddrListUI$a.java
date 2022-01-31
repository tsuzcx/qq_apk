package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.qqmail.b.d;
import com.tencent.mm.plugin.qqmail.b.e;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.a;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class MailAddrListUI$a
  extends BaseAdapter
{
  private final Context context;
  boolean nib = false;
  boolean nic = false;
  Map<String, o> nid = new HashMap();
  
  public MailAddrListUI$a(MailAddrListUI paramMailAddrListUI, Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static String d(o paramo)
  {
    if (paramo == null) {
      return null;
    }
    paramo = a.Le(paramo.ndQ);
    if (paramo.length() > 1) {}
    for (char c = paramo.charAt(0);; c = '~') {
      switch (c)
      {
      case '|': 
      case '}': 
      default: 
        if (!bk.m(c)) {
          break label102;
        }
        return String.valueOf(c);
      }
    }
    c = paramo.charAt(1);
    if (bk.n(c)) {
      return String.valueOf(c);
    }
    return "~";
    return "~";
    label102:
    return "~";
  }
  
  private TextView getTitleTextView()
  {
    TextView localTextView = new TextView(this.context);
    localTextView.setBackgroundResource(b.e.list_thicklinecell_bg);
    localTextView.setTextColor(-16777216);
    localTextView.setTextSize(0, this.nia.getResources().getDimensionPixelSize(b.d.HintTextSize));
    int i = this.nia.getResources().getDimensionPixelSize(b.d.LargePadding);
    int j = this.nia.getResources().getDimensionPixelSize(b.d.SmallPadding);
    localTextView.setPadding(j, i, j, j);
    return localTextView;
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final int bug()
  {
    return this.nid.size();
  }
  
  public final void c(o paramo)
  {
    this.nid.put(paramo.lCF, paramo);
  }
  
  public final int getCount()
  {
    int j = MailAddrListUI.c(this.nia).size();
    int i;
    if (j == 0) {
      if (this.nib) {
        i = 1;
      }
    }
    do
    {
      return i;
      return 0;
      i = j;
    } while (this.nic);
    return j + 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt == 0)
    {
      if (this.nib)
      {
        paramView = getTitleTextView();
        paramView.setText(b.j.plugin_qqmail_composeui_addr_list_search_empty);
        paramInt = this.nia.getResources().getDimensionPixelSize(b.d.LargePadding);
        paramView.setPadding(paramInt, paramInt, paramInt, paramInt);
        paramView.setTextSize(0, this.nia.getResources().getDimensionPixelSize(b.d.BigTextSize));
        paramView.setGravity(17);
        return paramView;
      }
      if (!this.nic)
      {
        paramView = getTitleTextView();
        paramView.setText(b.j.plugin_qqmail_composeui_addr_list_recent_contacts);
        return paramView;
      }
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new MailAddrListUI.a.a(this);
      paramView = View.inflate(this.context, b.g.qqmail_addrlist_item, null);
      paramViewGroup.nie = ((TextView)paramView.findViewById(b.f.qqmail_addrlist_item_category));
      paramViewGroup.fhD = ((TextView)paramView.findViewById(b.f.qqmail_addrlist_item_name_tv));
      paramViewGroup.nif = ((TextView)paramView.findViewById(b.f.qqmail_addrlist_item_addr_iv));
      paramViewGroup.eXQ = ((CheckBox)paramView.findViewById(b.f.qqmail_addrlist_item_select_cb));
      paramView.setTag(paramViewGroup);
      o localo = wo(paramInt);
      if ((this.nic) || (paramInt <= 10)) {
        break label365;
      }
      Object localObject = wo(paramInt - 1);
      if (paramInt == 11) {
        localObject = null;
      }
      String str = d(localo);
      localObject = d((o)localObject);
      if (str == null) {
        break label353;
      }
      if (str.equals(localObject)) {
        break label341;
      }
      paramViewGroup.nie.setText(str.toUpperCase());
      paramViewGroup.nie.setVisibility(0);
      label273:
      paramViewGroup.fhD.setText(localo.name);
      paramViewGroup.nif.setText(localo.lCF);
      paramViewGroup = paramViewGroup.eXQ;
      if (this.nid.get(localo.lCF) == null) {
        break label377;
      }
    }
    label341:
    label353:
    label365:
    label377:
    for (boolean bool = true;; bool = false)
    {
      paramViewGroup.setChecked(bool);
      return paramView;
      paramViewGroup = (MailAddrListUI.a.a)paramView.getTag();
      break;
      paramViewGroup.nie.setVisibility(8);
      break label273;
      paramViewGroup.nie.setVisibility(8);
      break label273;
      paramViewGroup.nie.setVisibility(8);
      break label273;
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    if (paramInt == 0) {
      return this.nic;
    }
    return true;
  }
  
  public final o wo(int paramInt)
  {
    if (this.nic) {}
    for (;;)
    {
      return (o)MailAddrListUI.c(this.nia).get(paramInt);
      if (paramInt == 0) {
        paramInt = 0;
      } else {
        paramInt -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.ci.a.c;
import com.tencent.mm.ci.a.e;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends BaseAdapter
  implements a
{
  private final Context context;
  private final SharedPreferences dnD;
  private final LinkedList<String> vdm = new LinkedList();
  private final HashMap<String, Preference> vdn = new HashMap();
  private final HashSet<String> vdo = new HashSet();
  private final LinkedList<String> vdp = new LinkedList();
  private final HashMap<String, Integer> vdq = new HashMap();
  private final HashMap<String, String> vdr = new HashMap();
  private int[] vds = new int[0];
  boolean vdt = false;
  private boolean vdu = false;
  final c xfU;
  Preference.OnPreferenceChangeListener xfV;
  
  public b(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    this.xfU = new c(paramContext);
    this.context = paramContext;
    this.dnD = paramSharedPreferences;
  }
  
  private static boolean GB(int paramInt)
  {
    return (paramInt == a.g.mm_preference) || (paramInt == a.g.mm_preference_summary_below) || (paramInt == a.g.mm_preference_summary_checkbox);
  }
  
  private void a(Preference paramPreference, int paramInt)
  {
    if ((paramPreference.getKey() != null) && (paramPreference.getKey().length() > 0)) {}
    for (String str = paramPreference.getKey();; str = "_anonymous_pref@" + paramPreference.hashCode())
    {
      this.vdn.put(str, paramPreference);
      LinkedList localLinkedList = this.vdm;
      int i = paramInt;
      if (paramInt == -1) {
        i = this.vdm.size();
      }
      localLinkedList.add(i, str);
      if ((!this.vdq.containsKey(b(paramPreference))) && (!this.vdu)) {
        this.vdq.put(b(paramPreference), Integer.valueOf(this.vdq.size()));
      }
      if (paramPreference.getDependency() != null) {
        this.vdr.put(paramPreference.getDependency() + "|" + paramPreference.getKey(), paramPreference.getKey());
      }
      return;
    }
  }
  
  private static void a(Preference paramPreference, SharedPreferences paramSharedPreferences)
  {
    if ((paramPreference instanceof CheckBoxPreference))
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)paramPreference;
      if (localCheckBoxPreference.isPersistent()) {
        localCheckBoxPreference.rHo = paramSharedPreferences.getBoolean(paramPreference.getKey(), ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
  }
  
  private static String b(Preference paramPreference)
  {
    return paramPreference.getClass().getName() + "L" + paramPreference.getLayoutResource() + "W" + paramPreference.getWidgetLayoutResource();
  }
  
  private void cBy()
  {
    HashSet localHashSet = new HashSet();
    int i = 0;
    while (i < this.vdp.size())
    {
      this.vdn.get(this.vdp.get(i));
      if (i != 0) {
        this.vdn.get(this.vdp.get(i - 1));
      }
      i += 1;
    }
    this.vdp.removeAll(localHashSet);
  }
  
  public final void a(Preference paramPreference)
  {
    a(paramPreference, -1);
    if (!this.vdt) {
      notifyDataSetChanged();
    }
  }
  
  public final int getCount()
  {
    return this.vdp.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.vdn.get(this.vdp.get(paramInt));
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt > this.vdp.size()) {
      return -1;
    }
    Object localObject = (Preference)this.vdn.get(this.vdp.get(paramInt));
    localObject = (Integer)this.vdq.get(b((Preference)localObject));
    if (localObject == null) {
      return -1;
    }
    return ((Integer)localObject).intValue();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt > this.vdp.size()) {}
    Object localObject;
    int i6;
    View localView;
    do
    {
      return paramView;
      localObject = (Preference)this.vdn.get(this.vdp.get(paramInt));
      if ((localObject instanceof CheckBoxPreference)) {
        ((Preference)localObject).setOnPreferenceChangeListener(this.xfV);
      }
      if (!this.vdq.containsKey(b((Preference)localObject))) {
        paramView = null;
      }
      paramViewGroup = ((Preference)localObject).getView(paramView, paramViewGroup);
      i6 = this.vds[paramInt];
      localObject = paramViewGroup.findViewById(a.f.content);
      if (localObject == null)
      {
        ao.s("find content view error", new Object[0]);
        return paramViewGroup;
      }
      localView = paramViewGroup.findViewById(16908312);
      paramView = paramViewGroup;
    } while ((i6 & 0x4) != 0);
    int j = 0;
    int k = ((View)localObject).getPaddingLeft();
    int m = ((View)localObject).getPaddingRight();
    int n = ((View)localObject).getPaddingTop();
    int i1 = ((View)localObject).getPaddingBottom();
    int i = a.e.settings_line;
    int i2 = paramViewGroup.getPaddingLeft();
    int i3 = paramViewGroup.getPaddingRight();
    int i4 = paramViewGroup.getPaddingTop();
    int i5 = paramViewGroup.getPaddingBottom();
    if ((i6 & 0x8) != 0) {
      if ((paramInt == this.vdp.size() - 1) || ((paramInt == this.vdp.size() - 2) && ((getItem(this.vdp.size() - 1) instanceof PreferenceCategory))))
      {
        paramInt = a.e.mm_trans;
        j = a.c.white;
        i = paramInt;
        paramInt = j;
      }
    }
    for (;;)
    {
      ((View)localObject).setBackgroundResource(i);
      ((View)localObject).setPadding(k, n, m, i1);
      if (localView != null) {
        localView.setBackgroundResource(i);
      }
      paramViewGroup.setBackgroundResource(paramInt);
      paramViewGroup.setPadding(i2, i4, i3, i5);
      return paramViewGroup;
      if ((i6 & 0x2) != 0)
      {
        paramInt = a.e.mm_trans;
        break;
      }
      paramInt = a.e.list_item_normal;
      break;
      if (((i6 & 0x10) != 0) || ((i6 & 0x2) == 0))
      {
        j = a.e.list_item_normal;
        paramInt = i;
        i = j;
      }
      else
      {
        paramInt = i;
        i = j;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    if (!this.vdu) {
      this.vdu = true;
    }
    return Math.max(1, this.vdq.size());
  }
  
  public final void notifyDataSetChanged()
  {
    int i = 0;
    this.vdp.clear();
    Object localObject = this.vdm.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.vdo.contains(str)) {
        if (this.vdn.get(str) == null) {
          ao.v("not found pref by key " + str, new Object[0]);
        } else {
          this.vdp.add(str);
        }
      }
    }
    if ((!this.vdp.isEmpty()) && (GB(((Preference)this.vdn.get(this.vdp.get(0))).getLayoutResource()))) {
      a(new PreferenceSmallCategory(this.context), 0);
    }
    cBy();
    this.vds = new int[this.vdp.size()];
    if (this.vds.length <= 0) {
      return;
    }
    if (this.vds.length == 1)
    {
      i = ((Preference)this.vdn.get(this.vdp.get(0))).getLayoutResource();
      localObject = (Preference)this.vdn.get(this.vdp.get(0));
      if (GB(i)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.vds;
          localObject[0] |= 0x8;
        }
      }
      for (;;)
      {
        a((Preference)this.vdn.get(this.vdp.get(0)), this.dnD);
        super.notifyDataSetChanged();
        return;
        this.vds[0] = 3;
        continue;
        this.vds[0] = 4;
      }
    }
    if (i < this.vdp.size())
    {
      a((Preference)this.vdn.get(this.vdp.get(i)), this.dnD);
      localObject = (Preference)this.vdn.get(this.vdp.get(i));
      int j = ((Preference)localObject).getLayoutResource();
      if (GB(j)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.vds;
          localObject[i] |= 0x8;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 0)
        {
          localObject = this.vds;
          localObject[i] |= 0x1;
        }
        else
        {
          if (i == this.vdp.size() - 1)
          {
            localObject = this.vds;
            localObject[i] |= 0x2;
          }
          j = ((Preference)this.vdn.get(this.vdp.get(i - 1))).getLayoutResource();
          if ((j != a.g.mm_preference) || (j == a.g.mm_preference_summary_below) || (j == a.g.mm_preference_summary_checkbox))
          {
            localObject = this.vds;
            localObject[i] |= 0x1;
            continue;
            if (j == a.g.mm_preference_info)
            {
              if (i == 0)
              {
                localObject = this.vds;
                localObject[i] |= 0x4;
              }
              else
              {
                localObject = this.vds;
                localObject[i] |= 0x10;
                j = ((Preference)this.vdn.get(this.vdp.get(i - 1))).getLayoutResource();
                if ((j == a.g.mm_preference) || (j == a.g.mm_preference_summary_below) || (j == a.g.mm_preference_summary_checkbox))
                {
                  localObject = this.vds;
                  j = i - 1;
                  localObject[j] |= 0x2;
                }
              }
            }
            else
            {
              localObject = this.vds;
              localObject[i] |= 0x4;
              if (i != 0)
              {
                j = ((Preference)this.vdn.get(this.vdp.get(i - 1))).getLayoutResource();
                if ((GB(j)) || (j == a.g.mm_preference_info))
                {
                  localObject = this.vds;
                  j = i - 1;
                  localObject[j] |= 0x2;
                }
              }
            }
          }
        }
      }
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.weui.base.preference.b
 * JD-Core Version:    0.7.0.1
 */
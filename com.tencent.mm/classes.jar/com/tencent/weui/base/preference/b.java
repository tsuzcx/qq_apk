package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ui.bc;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends BaseAdapter
  implements a
{
  private boolean adZA;
  private final LinkedList<String> adZr;
  private final HashMap<String, Preference> adZs;
  private final HashSet<String> adZt;
  private final LinkedList<String> adZu;
  private final HashMap<String, Integer> adZv;
  private final HashMap<String, String> adZw;
  private int[] adZy;
  final c aicx;
  boolean aicy;
  Preference.OnPreferenceChangeListener aicz;
  private final Context context;
  private final SharedPreferences sp;
  
  public b(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(160001);
    this.adZr = new LinkedList();
    this.adZs = new HashMap();
    this.adZt = new HashSet();
    this.adZu = new LinkedList();
    this.adZv = new HashMap();
    this.adZw = new HashMap();
    this.adZy = new int[0];
    this.aicy = false;
    this.adZA = false;
    this.aicx = new c(paramContext);
    this.context = paramContext;
    this.sp = paramSharedPreferences;
    AppMethodBeat.o(160001);
  }
  
  private void a(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(160006);
    String str = c(paramPreference);
    this.adZs.put(str, paramPreference);
    LinkedList localLinkedList = this.adZr;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.adZr.size();
    }
    localLinkedList.add(i, str);
    if ((!this.adZv.containsKey(b(paramPreference))) && (!this.adZA)) {
      this.adZv.put(b(paramPreference), Integer.valueOf(this.adZv.size()));
    }
    if (paramPreference.getDependency() != null) {
      this.adZw.put(paramPreference.getDependency() + "|" + paramPreference.getKey(), paramPreference.getKey());
    }
    AppMethodBeat.o(160006);
  }
  
  private static void a(Preference paramPreference, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(160004);
    if ((paramPreference instanceof CheckBoxPreference))
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)paramPreference;
      if (localCheckBoxPreference.isPersistent()) {
        localCheckBoxPreference.duj = paramSharedPreferences.getBoolean(paramPreference.getKey(), ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
    AppMethodBeat.o(160004);
  }
  
  private static boolean aBn(int paramInt)
  {
    return (paramInt == a.g.mm_preference) || (paramInt == a.g.mm_preference_summary_below) || (paramInt == a.g.mm_preference_summary_checkbox);
  }
  
  private static String b(Preference paramPreference)
  {
    AppMethodBeat.i(160002);
    paramPreference = paramPreference.getClass().getName() + "L" + paramPreference.getLayoutResource() + "W" + paramPreference.getWidgetLayoutResource();
    AppMethodBeat.o(160002);
    return paramPreference;
  }
  
  private static String c(Preference paramPreference)
  {
    AppMethodBeat.i(160003);
    if ((paramPreference.getKey() != null) && (paramPreference.getKey().length() > 0))
    {
      paramPreference = paramPreference.getKey();
      AppMethodBeat.o(160003);
      return paramPreference;
    }
    paramPreference = "_anonymous_pref@" + paramPreference.hashCode();
    AppMethodBeat.o(160003);
    return paramPreference;
  }
  
  public final void a(Preference paramPreference)
  {
    AppMethodBeat.i(160005);
    a(paramPreference, -1);
    if (!this.aicy) {
      notifyDataSetChanged();
    }
    AppMethodBeat.o(160005);
  }
  
  public final Preference bGT(String paramString)
  {
    AppMethodBeat.i(210683);
    paramString = (Preference)this.adZs.get(paramString);
    AppMethodBeat.o(210683);
    return paramString;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(160008);
    int i = this.adZu.size();
    AppMethodBeat.o(160008);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(160009);
    Object localObject = this.adZs.get(this.adZu.get(paramInt));
    AppMethodBeat.o(160009);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(160011);
    if (paramInt > this.adZu.size())
    {
      AppMethodBeat.o(160011);
      return -1;
    }
    Object localObject = (Preference)this.adZs.get(this.adZu.get(paramInt));
    localObject = (Integer)this.adZv.get(b((Preference)localObject));
    if (localObject == null)
    {
      AppMethodBeat.o(160011);
      return -1;
    }
    paramInt = ((Integer)localObject).intValue();
    AppMethodBeat.o(160011);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(160012);
    if (paramInt > this.adZu.size())
    {
      AppMethodBeat.o(160012);
      return paramView;
    }
    Object localObject = (Preference)this.adZs.get(this.adZu.get(paramInt));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).setOnPreferenceChangeListener(this.aicz);
    }
    if (!this.adZv.containsKey(b((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).getView(paramView, paramViewGroup);
    int i6 = this.adZy[paramInt];
    paramViewGroup = paramView.findViewById(a.f.content);
    if (paramViewGroup == null)
    {
      bc.d("MicroMsg.WeUIPreferenceAdapter", "find content view error", new Object[0]);
      AppMethodBeat.o(160012);
      return paramView;
    }
    localObject = paramView.findViewById(16908312);
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i;
    int i2;
    int i3;
    int i4;
    int i5;
    if ((i6 & 0x4) == 0)
    {
      j = 0;
      k = paramViewGroup.getPaddingLeft();
      m = paramViewGroup.getPaddingRight();
      n = paramViewGroup.getPaddingTop();
      i1 = paramViewGroup.getPaddingBottom();
      i = a.e.settings_line;
      i2 = paramView.getPaddingLeft();
      i3 = paramView.getPaddingRight();
      i4 = paramView.getPaddingTop();
      i5 = paramView.getPaddingBottom();
      if ((i6 & 0x8) == 0) {
        break label340;
      }
      if ((paramInt != this.adZu.size() - 1) && ((paramInt != this.adZu.size() - 2) || (!(getItem(this.adZu.size() - 1) instanceof PreferenceCategory)))) {
        break label319;
      }
      paramInt = a.e.mm_trans;
      j = a.c.white;
      i = paramInt;
      paramInt = j;
    }
    for (;;)
    {
      paramViewGroup.setBackgroundResource(i);
      paramViewGroup.setPadding(k, n, m, i1);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(i);
      }
      paramView.setBackgroundResource(paramInt);
      paramView.setPadding(i2, i4, i3, i5);
      AppMethodBeat.o(160012);
      return paramView;
      label319:
      if ((i6 & 0x2) != 0)
      {
        paramInt = a.e.mm_trans;
        break;
      }
      paramInt = a.e.list_item_normal;
      break;
      label340:
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
    AppMethodBeat.i(160010);
    if (!this.adZA) {
      this.adZA = true;
    }
    int i = Math.max(1, this.adZv.size());
    AppMethodBeat.o(160010);
    return i;
  }
  
  public final void notifyDataSetChanged()
  {
    int j = 0;
    AppMethodBeat.i(160007);
    this.adZu.clear();
    Object localObject = this.adZr.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.adZt.contains(str)) {
        if (this.adZs.get(str) == null) {
          bc.e("MicroMsg.WeUIPreferenceAdapter", "not found pref by key ".concat(String.valueOf(str)), new Object[0]);
        } else {
          this.adZu.add(str);
        }
      }
    }
    if ((!this.adZu.isEmpty()) && (aBn(((Preference)this.adZs.get(this.adZu.get(0))).getLayoutResource()))) {
      a(new PreferenceSmallCategory(this.context), 0);
    }
    localObject = new HashSet();
    int i = 0;
    while (i < this.adZu.size())
    {
      this.adZs.get(this.adZu.get(i));
      if (i != 0) {
        this.adZs.get(this.adZu.get(i - 1));
      }
      i += 1;
    }
    this.adZu.removeAll((Collection)localObject);
    this.adZy = new int[this.adZu.size()];
    if (this.adZy.length <= 0)
    {
      AppMethodBeat.o(160007);
      return;
    }
    i = j;
    if (this.adZy.length == 1)
    {
      i = ((Preference)this.adZs.get(this.adZu.get(0))).getLayoutResource();
      localObject = (Preference)this.adZs.get(this.adZu.get(0));
      if (aBn(i)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.adZy;
          localObject[0] |= 0x8;
        }
      }
      for (;;)
      {
        a((Preference)this.adZs.get(this.adZu.get(0)), this.sp);
        super.notifyDataSetChanged();
        AppMethodBeat.o(160007);
        return;
        this.adZy[0] = 3;
        continue;
        this.adZy[0] = 4;
      }
    }
    if (i < this.adZu.size())
    {
      a((Preference)this.adZs.get(this.adZu.get(i)), this.sp);
      localObject = (Preference)this.adZs.get(this.adZu.get(i));
      j = ((Preference)localObject).getLayoutResource();
      if (aBn(j)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.adZy;
          localObject[i] |= 0x8;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 0)
        {
          localObject = this.adZy;
          localObject[i] |= 0x1;
        }
        else
        {
          if (i == this.adZu.size() - 1)
          {
            localObject = this.adZy;
            localObject[i] |= 0x2;
          }
          j = ((Preference)this.adZs.get(this.adZu.get(i - 1))).getLayoutResource();
          if ((j != a.g.mm_preference) || (j == a.g.mm_preference_summary_below) || (j == a.g.mm_preference_summary_checkbox))
          {
            localObject = this.adZy;
            localObject[i] |= 0x1;
            continue;
            if (j == a.g.mm_preference_info)
            {
              if (i == 0)
              {
                localObject = this.adZy;
                localObject[i] |= 0x4;
              }
              else
              {
                localObject = this.adZy;
                localObject[i] |= 0x10;
                j = ((Preference)this.adZs.get(this.adZu.get(i - 1))).getLayoutResource();
                if ((j == a.g.mm_preference) || (j == a.g.mm_preference_summary_below) || (j == a.g.mm_preference_summary_checkbox))
                {
                  localObject = this.adZy;
                  j = i - 1;
                  localObject[j] |= 0x2;
                }
              }
            }
            else
            {
              localObject = this.adZy;
              localObject[i] |= 0x4;
              if (i != 0)
              {
                j = ((Preference)this.adZs.get(this.adZu.get(i - 1))).getLayoutResource();
                if ((aBn(j)) || (j == a.g.mm_preference_info))
                {
                  localObject = this.adZy;
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
    AppMethodBeat.o(160007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.weui.base.preference.b
 * JD-Core Version:    0.7.0.1
 */
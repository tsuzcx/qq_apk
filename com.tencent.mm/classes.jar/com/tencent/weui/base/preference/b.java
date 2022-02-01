package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.an;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends BaseAdapter
  implements a
{
  private final HashMap<String, String> GfA;
  private int[] GfC;
  private boolean GfE;
  private final LinkedList<String> Gfv;
  private final HashMap<String, Preference> Gfw;
  private final HashSet<String> Gfx;
  private final LinkedList<String> Gfy;
  private final HashMap<String, Integer> Gfz;
  final c ILO;
  boolean ILP;
  Preference.OnPreferenceChangeListener ILQ;
  private final Context context;
  private final SharedPreferences sp;
  
  public b(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(160001);
    this.Gfv = new LinkedList();
    this.Gfw = new HashMap();
    this.Gfx = new HashSet();
    this.Gfy = new LinkedList();
    this.Gfz = new HashMap();
    this.GfA = new HashMap();
    this.GfC = new int[0];
    this.ILP = false;
    this.GfE = false;
    this.ILO = new c(paramContext);
    this.context = paramContext;
    this.sp = paramSharedPreferences;
    AppMethodBeat.o(160001);
  }
  
  private static boolean XZ(int paramInt)
  {
    return (paramInt == 2131494804) || (paramInt == 2131494886) || (paramInt == 2131494889);
  }
  
  private void a(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(160006);
    String str = c(paramPreference);
    this.Gfw.put(str, paramPreference);
    LinkedList localLinkedList = this.Gfv;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.Gfv.size();
    }
    localLinkedList.add(i, str);
    if ((!this.Gfz.containsKey(b(paramPreference))) && (!this.GfE)) {
      this.Gfz.put(b(paramPreference), Integer.valueOf(this.Gfz.size()));
    }
    if (paramPreference.getDependency() != null) {
      this.GfA.put(paramPreference.getDependency() + "|" + paramPreference.getKey(), paramPreference.getKey());
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
        localCheckBoxPreference.lG = paramSharedPreferences.getBoolean(paramPreference.getKey(), ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
    AppMethodBeat.o(160004);
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
    if (!this.ILP) {
      notifyDataSetChanged();
    }
    AppMethodBeat.o(160005);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(160008);
    int i = this.Gfy.size();
    AppMethodBeat.o(160008);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(160009);
    Object localObject = this.Gfw.get(this.Gfy.get(paramInt));
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
    if (paramInt > this.Gfy.size())
    {
      AppMethodBeat.o(160011);
      return -1;
    }
    Object localObject = (Preference)this.Gfw.get(this.Gfy.get(paramInt));
    localObject = (Integer)this.Gfz.get(b((Preference)localObject));
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
    if (paramInt > this.Gfy.size())
    {
      AppMethodBeat.o(160012);
      return paramView;
    }
    Object localObject = (Preference)this.Gfw.get(this.Gfy.get(paramInt));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).setOnPreferenceChangeListener(this.ILQ);
    }
    if (!this.Gfz.containsKey(b((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).getView(paramView, paramViewGroup);
    int j = this.GfC[paramInt];
    paramViewGroup = paramView.findViewById(2131298739);
    if (paramViewGroup == null)
    {
      an.d("MicroMsg.WeUIPreferenceAdapter", "find content view error", new Object[0]);
      AppMethodBeat.o(160012);
      return paramView;
    }
    localObject = paramView.findViewById(16908312);
    int i;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    if ((j & 0x4) == 0)
    {
      i = 0;
      k = paramViewGroup.getPaddingLeft();
      m = paramViewGroup.getPaddingRight();
      n = paramViewGroup.getPaddingTop();
      i1 = paramViewGroup.getPaddingBottom();
      i2 = paramView.getPaddingLeft();
      i3 = paramView.getPaddingRight();
      i4 = paramView.getPaddingTop();
      i5 = paramView.getPaddingBottom();
      if ((j & 0x8) == 0) {
        break label332;
      }
      if ((paramInt != this.Gfy.size() - 1) && ((paramInt != this.Gfy.size() - 2) || (!(getItem(this.Gfy.size() - 1) instanceof PreferenceCategory)))) {
        break label311;
      }
      paramInt = 2131233299;
      j = 2131101179;
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
      label311:
      if ((j & 0x2) != 0)
      {
        paramInt = 2131233299;
        break;
      }
      paramInt = 2131232867;
      break;
      label332:
      if (((j & 0x10) != 0) || ((j & 0x2) == 0))
      {
        i = 2131232867;
        paramInt = 2131233957;
      }
      else
      {
        paramInt = 2131233957;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(160010);
    if (!this.GfE) {
      this.GfE = true;
    }
    int i = Math.max(1, this.Gfz.size());
    AppMethodBeat.o(160010);
    return i;
  }
  
  public final void notifyDataSetChanged()
  {
    int j = 0;
    AppMethodBeat.i(160007);
    this.Gfy.clear();
    Object localObject = this.Gfv.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.Gfx.contains(str)) {
        if (this.Gfw.get(str) == null) {
          an.e("MicroMsg.WeUIPreferenceAdapter", "not found pref by key ".concat(String.valueOf(str)), new Object[0]);
        } else {
          this.Gfy.add(str);
        }
      }
    }
    if ((!this.Gfy.isEmpty()) && (XZ(((Preference)this.Gfw.get(this.Gfy.get(0))).getLayoutResource()))) {
      a(new PreferenceSmallCategory(this.context), 0);
    }
    localObject = new HashSet();
    int i = 0;
    while (i < this.Gfy.size())
    {
      this.Gfw.get(this.Gfy.get(i));
      if (i != 0) {
        this.Gfw.get(this.Gfy.get(i - 1));
      }
      i += 1;
    }
    this.Gfy.removeAll((Collection)localObject);
    this.GfC = new int[this.Gfy.size()];
    if (this.GfC.length <= 0)
    {
      AppMethodBeat.o(160007);
      return;
    }
    i = j;
    if (this.GfC.length == 1)
    {
      i = ((Preference)this.Gfw.get(this.Gfy.get(0))).getLayoutResource();
      localObject = (Preference)this.Gfw.get(this.Gfy.get(0));
      if (XZ(i)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.GfC;
          localObject[0] |= 0x8;
        }
      }
      for (;;)
      {
        a((Preference)this.Gfw.get(this.Gfy.get(0)), this.sp);
        super.notifyDataSetChanged();
        AppMethodBeat.o(160007);
        return;
        this.GfC[0] = 3;
        continue;
        this.GfC[0] = 4;
      }
    }
    if (i < this.Gfy.size())
    {
      a((Preference)this.Gfw.get(this.Gfy.get(i)), this.sp);
      localObject = (Preference)this.Gfw.get(this.Gfy.get(i));
      j = ((Preference)localObject).getLayoutResource();
      if (XZ(j)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.GfC;
          localObject[i] |= 0x8;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 0)
        {
          localObject = this.GfC;
          localObject[i] |= 0x1;
        }
        else
        {
          if (i == this.Gfy.size() - 1)
          {
            localObject = this.GfC;
            localObject[i] |= 0x2;
          }
          j = ((Preference)this.Gfw.get(this.Gfy.get(i - 1))).getLayoutResource();
          if ((j != 2131494804) || (j == 2131494886) || (j == 2131494889))
          {
            localObject = this.GfC;
            localObject[i] |= 0x1;
            continue;
            if (j == 2131494863)
            {
              if (i == 0)
              {
                localObject = this.GfC;
                localObject[i] |= 0x4;
              }
              else
              {
                localObject = this.GfC;
                localObject[i] |= 0x10;
                j = ((Preference)this.Gfw.get(this.Gfy.get(i - 1))).getLayoutResource();
                if ((j == 2131494804) || (j == 2131494886) || (j == 2131494889))
                {
                  localObject = this.GfC;
                  j = i - 1;
                  localObject[j] |= 0x2;
                }
              }
            }
            else
            {
              localObject = this.GfC;
              localObject[i] |= 0x4;
              if (i != 0)
              {
                j = ((Preference)this.Gfw.get(this.Gfy.get(i - 1))).getLayoutResource();
                if ((XZ(j)) || (j == 2131494863))
                {
                  localObject = this.GfC;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.weui.base.preference.b
 * JD-Core Version:    0.7.0.1
 */
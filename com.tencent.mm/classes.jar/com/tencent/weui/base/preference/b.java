package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends BaseAdapter
  implements a
{
  private final LinkedList<String> OYS;
  private final HashMap<String, Preference> OYT;
  private final HashSet<String> OYU;
  private final LinkedList<String> OYV;
  private final HashMap<String, Integer> OYW;
  private final HashMap<String, String> OYX;
  private int[] OYZ;
  private boolean OZb;
  final c SwY;
  boolean SwZ;
  Preference.OnPreferenceChangeListener Sxa;
  private final Context context;
  private final SharedPreferences sp;
  
  public b(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(160001);
    this.OYS = new LinkedList();
    this.OYT = new HashMap();
    this.OYU = new HashSet();
    this.OYV = new LinkedList();
    this.OYW = new HashMap();
    this.OYX = new HashMap();
    this.OYZ = new int[0];
    this.SwZ = false;
    this.OZb = false;
    this.SwY = new c(paramContext);
    this.context = paramContext;
    this.sp = paramSharedPreferences;
    AppMethodBeat.o(160001);
  }
  
  private void a(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(160006);
    String str = c(paramPreference);
    this.OYT.put(str, paramPreference);
    LinkedList localLinkedList = this.OYS;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.OYS.size();
    }
    localLinkedList.add(i, str);
    if ((!this.OYW.containsKey(b(paramPreference))) && (!this.OZb)) {
      this.OYW.put(b(paramPreference), Integer.valueOf(this.OYW.size()));
    }
    if (paramPreference.getDependency() != null) {
      this.OYX.put(paramPreference.getDependency() + "|" + paramPreference.getKey(), paramPreference.getKey());
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
        localCheckBoxPreference.oD = paramSharedPreferences.getBoolean(paramPreference.getKey(), ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
    AppMethodBeat.o(160004);
  }
  
  private static boolean alM(int paramInt)
  {
    return (paramInt == 2131495538) || (paramInt == 2131495624) || (paramInt == 2131495627);
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
    if (!this.SwZ) {
      notifyDataSetChanged();
    }
    AppMethodBeat.o(160005);
  }
  
  public final Preference brv(String paramString)
  {
    AppMethodBeat.i(198549);
    paramString = (Preference)this.OYT.get(paramString);
    AppMethodBeat.o(198549);
    return paramString;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(160008);
    int i = this.OYV.size();
    AppMethodBeat.o(160008);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(160009);
    Object localObject = this.OYT.get(this.OYV.get(paramInt));
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
    if (paramInt > this.OYV.size())
    {
      AppMethodBeat.o(160011);
      return -1;
    }
    Object localObject = (Preference)this.OYT.get(this.OYV.get(paramInt));
    localObject = (Integer)this.OYW.get(b((Preference)localObject));
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
    if (paramInt > this.OYV.size())
    {
      AppMethodBeat.o(160012);
      return paramView;
    }
    Object localObject = (Preference)this.OYT.get(this.OYV.get(paramInt));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).setOnPreferenceChangeListener(this.Sxa);
    }
    if (!this.OYW.containsKey(b((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).getView(paramView, paramViewGroup);
    int j = this.OYZ[paramInt];
    paramViewGroup = paramView.findViewById(2131299180);
    if (paramViewGroup == null)
    {
      as.d("MicroMsg.WeUIPreferenceAdapter", "find content view error", new Object[0]);
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
        break label333;
      }
      if ((paramInt != this.OYV.size() - 1) && ((paramInt != this.OYV.size() - 2) || (!(getItem(this.OYV.size() - 1) instanceof PreferenceCategory)))) {
        break label312;
      }
      paramInt = 2131233974;
      j = 2131101424;
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
      label312:
      if ((j & 0x2) != 0)
      {
        paramInt = 2131233974;
        break;
      }
      paramInt = 2131233327;
      break;
      label333:
      if (((j & 0x10) != 0) || ((j & 0x2) == 0))
      {
        i = 2131233327;
        paramInt = 2131234793;
      }
      else
      {
        paramInt = 2131234793;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(160010);
    if (!this.OZb) {
      this.OZb = true;
    }
    int i = Math.max(1, this.OYW.size());
    AppMethodBeat.o(160010);
    return i;
  }
  
  public final void notifyDataSetChanged()
  {
    int j = 0;
    AppMethodBeat.i(160007);
    this.OYV.clear();
    Object localObject = this.OYS.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.OYU.contains(str)) {
        if (this.OYT.get(str) == null) {
          as.e("MicroMsg.WeUIPreferenceAdapter", "not found pref by key ".concat(String.valueOf(str)), new Object[0]);
        } else {
          this.OYV.add(str);
        }
      }
    }
    if ((!this.OYV.isEmpty()) && (alM(((Preference)this.OYT.get(this.OYV.get(0))).getLayoutResource()))) {
      a(new PreferenceSmallCategory(this.context), 0);
    }
    localObject = new HashSet();
    int i = 0;
    while (i < this.OYV.size())
    {
      this.OYT.get(this.OYV.get(i));
      if (i != 0) {
        this.OYT.get(this.OYV.get(i - 1));
      }
      i += 1;
    }
    this.OYV.removeAll((Collection)localObject);
    this.OYZ = new int[this.OYV.size()];
    if (this.OYZ.length <= 0)
    {
      AppMethodBeat.o(160007);
      return;
    }
    i = j;
    if (this.OYZ.length == 1)
    {
      i = ((Preference)this.OYT.get(this.OYV.get(0))).getLayoutResource();
      localObject = (Preference)this.OYT.get(this.OYV.get(0));
      if (alM(i)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.OYZ;
          localObject[0] |= 0x8;
        }
      }
      for (;;)
      {
        a((Preference)this.OYT.get(this.OYV.get(0)), this.sp);
        super.notifyDataSetChanged();
        AppMethodBeat.o(160007);
        return;
        this.OYZ[0] = 3;
        continue;
        this.OYZ[0] = 4;
      }
    }
    if (i < this.OYV.size())
    {
      a((Preference)this.OYT.get(this.OYV.get(i)), this.sp);
      localObject = (Preference)this.OYT.get(this.OYV.get(i));
      j = ((Preference)localObject).getLayoutResource();
      if (alM(j)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.OYZ;
          localObject[i] |= 0x8;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 0)
        {
          localObject = this.OYZ;
          localObject[i] |= 0x1;
        }
        else
        {
          if (i == this.OYV.size() - 1)
          {
            localObject = this.OYZ;
            localObject[i] |= 0x2;
          }
          j = ((Preference)this.OYT.get(this.OYV.get(i - 1))).getLayoutResource();
          if ((j != 2131495538) || (j == 2131495624) || (j == 2131495627))
          {
            localObject = this.OYZ;
            localObject[i] |= 0x1;
            continue;
            if (j == 2131495599)
            {
              if (i == 0)
              {
                localObject = this.OYZ;
                localObject[i] |= 0x4;
              }
              else
              {
                localObject = this.OYZ;
                localObject[i] |= 0x10;
                j = ((Preference)this.OYT.get(this.OYV.get(i - 1))).getLayoutResource();
                if ((j == 2131495538) || (j == 2131495624) || (j == 2131495627))
                {
                  localObject = this.OYZ;
                  j = i - 1;
                  localObject[j] |= 0x2;
                }
              }
            }
            else
            {
              localObject = this.OYZ;
              localObject[i] |= 0x4;
              if (i != 0)
              {
                j = ((Preference)this.OYT.get(this.OYV.get(i - 1))).getLayoutResource();
                if ((alM(j)) || (j == 2131495599))
                {
                  localObject = this.OYZ;
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
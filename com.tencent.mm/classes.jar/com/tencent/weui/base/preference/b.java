package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends BaseAdapter
  implements a
{
  final c BCA;
  boolean BCB;
  Preference.OnPreferenceChangeListener BCC;
  private final Context context;
  private final SharedPreferences sp;
  private final LinkedList<String> zrJ;
  private final HashMap<String, Preference> zrK;
  private final HashSet<String> zrL;
  private final LinkedList<String> zrM;
  private final HashMap<String, Integer> zrN;
  private final HashMap<String, String> zrO;
  private int[] zrQ;
  private boolean zrS;
  
  public b(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(113264);
    this.zrJ = new LinkedList();
    this.zrK = new HashMap();
    this.zrL = new HashSet();
    this.zrM = new LinkedList();
    this.zrN = new HashMap();
    this.zrO = new HashMap();
    this.zrQ = new int[0];
    this.BCB = false;
    this.zrS = false;
    this.BCA = new c(paramContext);
    this.context = paramContext;
    this.sp = paramSharedPreferences;
    AppMethodBeat.o(113264);
  }
  
  private static boolean OU(int paramInt)
  {
    return (paramInt == 2130970179) || (paramInt == 2130970256) || (paramInt == 2130970259);
  }
  
  private void a(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(113269);
    String str = c(paramPreference);
    this.zrK.put(str, paramPreference);
    LinkedList localLinkedList = this.zrJ;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.zrJ.size();
    }
    localLinkedList.add(i, str);
    if ((!this.zrN.containsKey(b(paramPreference))) && (!this.zrS)) {
      this.zrN.put(b(paramPreference), Integer.valueOf(this.zrN.size()));
    }
    if (paramPreference.getDependency() != null) {
      this.zrO.put(paramPreference.getDependency() + "|" + paramPreference.getKey(), paramPreference.getKey());
    }
    AppMethodBeat.o(113269);
  }
  
  private static void a(Preference paramPreference, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(113267);
    if ((paramPreference instanceof CheckBoxPreference))
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)paramPreference;
      if (localCheckBoxPreference.isPersistent()) {
        localCheckBoxPreference.vxW = paramSharedPreferences.getBoolean(paramPreference.getKey(), ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
    AppMethodBeat.o(113267);
  }
  
  private static String b(Preference paramPreference)
  {
    AppMethodBeat.i(113265);
    paramPreference = paramPreference.getClass().getName() + "L" + paramPreference.getLayoutResource() + "W" + paramPreference.getWidgetLayoutResource();
    AppMethodBeat.o(113265);
    return paramPreference;
  }
  
  private static String c(Preference paramPreference)
  {
    AppMethodBeat.i(113266);
    if ((paramPreference.getKey() != null) && (paramPreference.getKey().length() > 0))
    {
      paramPreference = paramPreference.getKey();
      AppMethodBeat.o(113266);
      return paramPreference;
    }
    paramPreference = "_anonymous_pref@" + paramPreference.hashCode();
    AppMethodBeat.o(113266);
    return paramPreference;
  }
  
  public final void a(Preference paramPreference)
  {
    AppMethodBeat.i(113268);
    a(paramPreference, -1);
    if (!this.BCB) {
      notifyDataSetChanged();
    }
    AppMethodBeat.o(113268);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113271);
    int i = this.zrM.size();
    AppMethodBeat.o(113271);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(113272);
    Object localObject = this.zrK.get(this.zrM.get(paramInt));
    AppMethodBeat.o(113272);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(113274);
    if (paramInt > this.zrM.size())
    {
      AppMethodBeat.o(113274);
      return -1;
    }
    Object localObject = (Preference)this.zrK.get(this.zrM.get(paramInt));
    localObject = (Integer)this.zrN.get(b((Preference)localObject));
    if (localObject == null)
    {
      AppMethodBeat.o(113274);
      return -1;
    }
    paramInt = ((Integer)localObject).intValue();
    AppMethodBeat.o(113274);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113275);
    if (paramInt > this.zrM.size())
    {
      AppMethodBeat.o(113275);
      return paramView;
    }
    Object localObject = (Preference)this.zrK.get(this.zrM.get(paramInt));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).setOnPreferenceChangeListener(this.BCC);
    }
    if (!this.zrN.containsKey(b((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).getView(paramView, paramViewGroup);
    int j = this.zrQ[paramInt];
    paramViewGroup = paramView.findViewById(2131820946);
    if (paramViewGroup == null)
    {
      ak.d("MicroMsg.WeUIPreferenceAdapter", "find content view error", new Object[0]);
      AppMethodBeat.o(113275);
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
      if ((paramInt != this.zrM.size() - 1) && ((paramInt != this.zrM.size() - 2) || (!(getItem(this.zrM.size() - 1) instanceof PreferenceCategory)))) {
        break label311;
      }
      paramInt = 2130839676;
      j = 2131690709;
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
      AppMethodBeat.o(113275);
      return paramView;
      label311:
      if ((j & 0x2) != 0)
      {
        paramInt = 2130839676;
        break;
      }
      paramInt = 2130839276;
      break;
      label332:
      if (((j & 0x10) != 0) || ((j & 0x2) == 0))
      {
        i = 2130839276;
        paramInt = 2130840247;
      }
      else
      {
        paramInt = 2130840247;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(113273);
    if (!this.zrS) {
      this.zrS = true;
    }
    int i = Math.max(1, this.zrN.size());
    AppMethodBeat.o(113273);
    return i;
  }
  
  public final void notifyDataSetChanged()
  {
    int j = 0;
    AppMethodBeat.i(113270);
    this.zrM.clear();
    Object localObject = this.zrJ.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.zrL.contains(str)) {
        if (this.zrK.get(str) == null) {
          ak.e("MicroMsg.WeUIPreferenceAdapter", "not found pref by key ".concat(String.valueOf(str)), new Object[0]);
        } else {
          this.zrM.add(str);
        }
      }
    }
    if ((!this.zrM.isEmpty()) && (OU(((Preference)this.zrK.get(this.zrM.get(0))).getLayoutResource()))) {
      a(new PreferenceSmallCategory(this.context), 0);
    }
    localObject = new HashSet();
    int i = 0;
    while (i < this.zrM.size())
    {
      this.zrK.get(this.zrM.get(i));
      if (i != 0) {
        this.zrK.get(this.zrM.get(i - 1));
      }
      i += 1;
    }
    this.zrM.removeAll((Collection)localObject);
    this.zrQ = new int[this.zrM.size()];
    if (this.zrQ.length <= 0)
    {
      AppMethodBeat.o(113270);
      return;
    }
    i = j;
    if (this.zrQ.length == 1)
    {
      i = ((Preference)this.zrK.get(this.zrM.get(0))).getLayoutResource();
      localObject = (Preference)this.zrK.get(this.zrM.get(0));
      if (OU(i)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.zrQ;
          localObject[0] |= 0x8;
        }
      }
      for (;;)
      {
        a((Preference)this.zrK.get(this.zrM.get(0)), this.sp);
        super.notifyDataSetChanged();
        AppMethodBeat.o(113270);
        return;
        this.zrQ[0] = 3;
        continue;
        this.zrQ[0] = 4;
      }
    }
    if (i < this.zrM.size())
    {
      a((Preference)this.zrK.get(this.zrM.get(i)), this.sp);
      localObject = (Preference)this.zrK.get(this.zrM.get(i));
      j = ((Preference)localObject).getLayoutResource();
      if (OU(j)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.zrQ;
          localObject[i] |= 0x8;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 0)
        {
          localObject = this.zrQ;
          localObject[i] |= 0x1;
        }
        else
        {
          if (i == this.zrM.size() - 1)
          {
            localObject = this.zrQ;
            localObject[i] |= 0x2;
          }
          j = ((Preference)this.zrK.get(this.zrM.get(i - 1))).getLayoutResource();
          if ((j != 2130970179) || (j == 2130970256) || (j == 2130970259))
          {
            localObject = this.zrQ;
            localObject[i] |= 0x1;
            continue;
            if (j == 2130970236)
            {
              if (i == 0)
              {
                localObject = this.zrQ;
                localObject[i] |= 0x4;
              }
              else
              {
                localObject = this.zrQ;
                localObject[i] |= 0x10;
                j = ((Preference)this.zrK.get(this.zrM.get(i - 1))).getLayoutResource();
                if ((j == 2130970179) || (j == 2130970256) || (j == 2130970259))
                {
                  localObject = this.zrQ;
                  j = i - 1;
                  localObject[j] |= 0x2;
                }
              }
            }
            else
            {
              localObject = this.zrQ;
              localObject[i] |= 0x4;
              if (i != 0)
              {
                j = ((Preference)this.zrK.get(this.zrM.get(i - 1))).getLayoutResource();
                if ((OU(j)) || (j == 2130970236))
                {
                  localObject = this.zrQ;
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
    AppMethodBeat.o(113270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.weui.base.preference.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.aq;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class h
  extends BaseAdapter
  implements f
{
  private Preference.a JMy;
  private final i JNP;
  private final LinkedList<String> JNQ;
  private final HashMap<String, Preference> JNR;
  private final HashSet<String> JNS;
  private final LinkedList<String> JNT;
  private final HashMap<String, Integer> JNU;
  private final HashMap<String, String> JNV;
  public a JNW;
  private int[] JNX;
  private boolean JNY;
  private boolean JNZ;
  protected final Context context;
  private ListView jsM;
  private final SharedPreferences sp;
  
  public h(Context paramContext, ListView paramListView, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(142591);
    this.JNQ = new LinkedList();
    this.JNR = new HashMap();
    this.JNS = new HashSet();
    this.JNT = new LinkedList();
    this.JNU = new HashMap();
    this.JNV = new HashMap();
    this.JNX = new int[0];
    this.JNY = false;
    this.JNZ = false;
    this.JNP = new i(paramContext);
    this.context = paramContext;
    this.jsM = paramListView;
    this.sp = paramSharedPreferences;
    AppMethodBeat.o(142591);
  }
  
  private static void a(Preference paramPreference, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(142608);
    Object localObject;
    if ((paramPreference instanceof CheckBoxPreference))
    {
      localObject = (CheckBoxPreference)paramPreference;
      if (((Preference)localObject).JOq) {
        ((CheckBoxPreference)localObject).setChecked(paramSharedPreferences.getBoolean(paramPreference.mKey, ((CheckBoxPreference)paramPreference).isChecked()));
      }
    }
    if ((paramPreference instanceof DialogPreference))
    {
      localObject = (DialogPreference)paramPreference;
      if (((Preference)localObject).JOq) {
        ((DialogPreference)localObject).setValue(paramSharedPreferences.getString(paramPreference.mKey, null));
      }
    }
    if ((paramPreference instanceof EditPreference))
    {
      localObject = (EditPreference)paramPreference;
      if (((Preference)localObject).JOq)
      {
        ((EditPreference)localObject).value = paramSharedPreferences.getString(paramPreference.mKey, null);
        ((EditPreference)localObject).setSummary(((EditPreference)localObject).value);
      }
    }
    AppMethodBeat.o(142608);
  }
  
  private static boolean adb(int paramInt)
  {
    return (paramInt == 2131494804) || (paramInt == 2131494886) || (paramInt == 2131494889);
  }
  
  private void b(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(142599);
    String str = f(paramPreference);
    this.JNR.put(str, paramPreference);
    LinkedList localLinkedList = this.JNQ;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.JNQ.size();
    }
    localLinkedList.add(i, str);
    if ((!this.JNU.containsKey(e(paramPreference))) && (this.JNY)) {
      this.JNU.put(e(paramPreference), Integer.valueOf(this.JNU.size()));
    }
    if (paramPreference.JOr != null) {
      this.JNV.put(paramPreference.JOr + "|" + paramPreference.mKey, paramPreference.mKey);
    }
    AppMethodBeat.o(142599);
  }
  
  private static String e(Preference paramPreference)
  {
    AppMethodBeat.i(142592);
    paramPreference = paramPreference.getClass().getName() + "L" + paramPreference.getLayoutResource() + "W" + paramPreference.JOA;
    AppMethodBeat.o(142592);
    return paramPreference;
  }
  
  private static String f(Preference paramPreference)
  {
    AppMethodBeat.i(142593);
    if ((paramPreference.mKey != null) && (paramPreference.mKey.length() > 0))
    {
      paramPreference = paramPreference.mKey;
      AppMethodBeat.o(142593);
      return paramPreference;
    }
    paramPreference = "_anonymous_pref@" + paramPreference.hashCode();
    AppMethodBeat.o(142593);
    return paramPreference;
  }
  
  public final void a(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(142598);
    b(paramPreference, paramInt);
    if (!this.JNY) {
      notifyDataSetChanged();
    }
    AppMethodBeat.o(142598);
  }
  
  public final Preference aXe(String paramString)
  {
    AppMethodBeat.i(142600);
    paramString = (Preference)this.JNR.get(paramString);
    AppMethodBeat.o(142600);
    return paramString;
  }
  
  public final boolean aXf(String paramString)
  {
    AppMethodBeat.i(142603);
    boolean bool = d(aXe(paramString));
    AppMethodBeat.o(142603);
    return bool;
  }
  
  public final int aXg(String paramString)
  {
    AppMethodBeat.i(142595);
    if (this.JNT == null)
    {
      AppMethodBeat.o(142595);
      return -1;
    }
    int i = this.JNT.indexOf(paramString);
    AppMethodBeat.o(142595);
    return i;
  }
  
  public final void addPreferencesFromResource(int paramInt)
  {
    AppMethodBeat.i(142605);
    this.JNY = true;
    this.JNP.a(paramInt, this);
    this.JNY = false;
    if (this.jsM != null) {
      this.jsM.setAdapter(this);
    }
    notifyDataSetChanged();
    AppMethodBeat.o(142605);
  }
  
  public final void b(Preference.a parama)
  {
    AppMethodBeat.i(142606);
    this.JMy = parama;
    notifyDataSetChanged();
    AppMethodBeat.o(142606);
  }
  
  public final void b(Preference paramPreference)
  {
    AppMethodBeat.i(224384);
    a(paramPreference, -1);
    AppMethodBeat.o(224384);
  }
  
  public final void c(Preference paramPreference)
  {
    AppMethodBeat.i(142597);
    b(paramPreference, -1);
    AppMethodBeat.o(142597);
  }
  
  public final CheckBoxPreference cT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142601);
    if (paramBoolean) {
      if (!this.JNS.contains(paramString)) {
        this.JNS.add(paramString);
      }
    }
    while (this.JNS.remove(paramString))
    {
      notifyDataSetChanged();
      AppMethodBeat.o(142601);
      return null;
      AppMethodBeat.o(142601);
      return null;
    }
    AppMethodBeat.o(142601);
    return null;
  }
  
  public final boolean d(Preference paramPreference)
  {
    AppMethodBeat.i(142602);
    if (paramPreference == null)
    {
      AppMethodBeat.o(142602);
      return false;
    }
    String str = f(paramPreference);
    this.JNQ.remove(str);
    this.JNR.remove(str);
    this.JNS.remove(paramPreference.mKey);
    notifyDataSetChanged();
    AppMethodBeat.o(142602);
    return true;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(142609);
    if (this.JNW != null)
    {
      i = this.JNW.NI(this.JNT.size());
      AppMethodBeat.o(142609);
      return i;
    }
    int i = this.JNT.size();
    AppMethodBeat.o(142609);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(142610);
    int i = paramInt;
    if (this.JNW != null)
    {
      if (this.JNW.NJ(paramInt))
      {
        AppMethodBeat.o(142610);
        return null;
      }
      i = this.JNW.NK(paramInt);
    }
    Object localObject = this.JNR.get(this.JNT.get(i));
    AppMethodBeat.o(142610);
    return localObject;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(142612);
    if (paramInt > this.JNT.size() - 1)
    {
      AppMethodBeat.o(142612);
      return -1;
    }
    Object localObject = (Preference)this.JNR.get(this.JNT.get(paramInt));
    localObject = (Integer)this.JNU.get(e((Preference)localObject));
    if (localObject == null)
    {
      AppMethodBeat.o(142612);
      return -1;
    }
    paramInt = ((Integer)localObject).intValue();
    AppMethodBeat.o(142612);
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142613);
    int i = paramInt;
    if (this.JNW != null)
    {
      if (this.JNW.NJ(paramInt))
      {
        paramView = this.JNW.getView(paramInt, paramView, paramViewGroup);
        AppMethodBeat.o(142613);
        return paramView;
      }
      i = this.JNW.NK(paramInt);
    }
    if (i > this.JNT.size())
    {
      AppMethodBeat.o(142613);
      return paramView;
    }
    Object localObject = (Preference)this.JNR.get(this.JNT.get(i));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).a(this.JMy);
    }
    if (!this.JNU.containsKey(e((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).getView(paramView, paramViewGroup);
    paramInt = this.JNX[i];
    paramViewGroup = paramView.findViewById(2131298739);
    localObject = paramView.findViewById(2131306012);
    if (paramViewGroup == null) {
      ae.d("MicroMsg.MMPreferenceAdapter", "find content view error");
    }
    View localView;
    int n;
    if (paramViewGroup != null)
    {
      localView = paramViewGroup.findViewById(2131305937);
      paramViewGroup.getPaddingLeft();
      paramViewGroup.getPaddingRight();
      paramViewGroup.getPaddingTop();
      paramViewGroup.getPaddingBottom();
      i = paramView.getPaddingLeft();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingTop();
      int m = paramView.getPaddingBottom();
      if ((paramInt & 0x2) != 0)
      {
        n = paramViewGroup.getPaddingLeft();
        paramViewGroup.setBackground(aq.aM(this.context, 2130969245));
        paramViewGroup.setPadding(n, 0, 0, 0);
        if ((localView != null) && (localView.getBackground() != null)) {
          localView.setBackground(null);
        }
        paramView.setBackgroundResource(2131233957);
        paramView.setPadding(i, k, j, m);
      }
    }
    else if (localObject != null)
    {
      if ((paramInt & 0x1) == 0) {
        break label402;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(142613);
      return paramView;
      if (localView == null) {
        break;
      }
      n = localView.getPaddingTop();
      int i1 = localView.getPaddingBottom();
      localView.setBackground(aq.aM(this.context, 2130969245));
      localView.setPadding(0, n, 0, i1);
      if ((paramViewGroup == null) || (paramViewGroup.getBackground() == null)) {
        break;
      }
      paramViewGroup.setBackground(null);
      break;
      label402:
      ((View)localObject).setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    AppMethodBeat.i(142611);
    if (!this.JNZ) {
      this.JNZ = true;
    }
    int i = Math.max(1, this.JNU.size());
    AppMethodBeat.o(142611);
    return i;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(142594);
    int i = this.JNQ.indexOf(paramString);
    AppMethodBeat.o(142594);
    return i;
  }
  
  public void notifyDataSetChanged()
  {
    int j = 0;
    AppMethodBeat.i(142607);
    this.JNT.clear();
    Object localObject1 = this.JNQ.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!this.JNS.contains(localObject2)) {
        if (this.JNR.get(localObject2) == null) {
          ae.e("MicroMsg.MMPreferenceAdapter", "not found pref by key ".concat(String.valueOf(localObject2)));
        } else {
          this.JNT.add(localObject2);
        }
      }
    }
    if (!this.JNT.isEmpty()) {
      this.JNR.get(this.JNT.get(0));
    }
    localObject1 = new HashSet();
    int i = 0;
    if (i < this.JNT.size())
    {
      localObject2 = (Preference)this.JNR.get(this.JNT.get(i));
      if (((localObject2 instanceof PreferenceCategory)) && (bu.isNullOrNil(((Preference)localObject2).mKey)) && (i != 0))
      {
        Preference localPreference = (Preference)this.JNR.get(this.JNT.get(i - 1));
        if ((localPreference instanceof PreferenceCategory))
        {
          if ((!bu.isNullOrNil(localPreference.mKey)) || ((localPreference.getTitle() != null) && (localPreference.getTitle().toString().trim().length() > 0))) {
            break label277;
          }
          ((Set)localObject1).add(f(localPreference));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label277:
        if ((bu.isNullOrNil(((Preference)localObject2).mKey)) && ((((Preference)localObject2).getTitle() == null) || (((Preference)localObject2).getTitle().toString().trim().length() <= 0))) {
          ((Set)localObject1).add(f((Preference)localObject2));
        }
      }
    }
    this.JNT.removeAll((Collection)localObject1);
    this.JNX = new int[this.JNT.size()];
    if (this.JNX.length <= 0)
    {
      AppMethodBeat.o(142607);
      return;
    }
    i = j;
    if (this.JNX.length == 1)
    {
      i = ((Preference)this.JNR.get(this.JNT.get(0))).getLayoutResource();
      localObject1 = (Preference)this.JNR.get(this.JNT.get(0));
      if (adb(i)) {
        if ((localObject1 instanceof CheckBoxPreference))
        {
          localObject1 = this.JNX;
          localObject1[0] |= 0x8;
          localObject1 = this.JNX;
          localObject1[0] |= 0x1;
        }
      }
      for (;;)
      {
        a((Preference)this.JNR.get(this.JNT.get(0)), this.sp);
        super.notifyDataSetChanged();
        AppMethodBeat.o(142607);
        return;
        this.JNX[0] = 3;
        continue;
        this.JNX[0] = 4;
      }
    }
    if (i < this.JNT.size())
    {
      a((Preference)this.JNR.get(this.JNT.get(i)), this.sp);
      localObject1 = (Preference)this.JNR.get(this.JNT.get(i));
      j = ((Preference)localObject1).getLayoutResource();
      if (adb(j))
      {
        if ((localObject1 instanceof CheckBoxPreference))
        {
          localObject1 = this.JNX;
          localObject1[i] |= 0x8;
        }
        if (i == 0)
        {
          localObject1 = this.JNX;
          localObject1[i] |= 0x1;
          localObject1 = this.JNX;
          localObject1[i] |= 0x10;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == this.JNT.size() - 1)
        {
          localObject1 = this.JNX;
          localObject1[i] |= 0x2;
        }
        j = ((Preference)this.JNR.get(this.JNT.get(i - 1))).getLayoutResource();
        if ((j != 2131494804) || (j == 2131494886) || (j == 2131494889))
        {
          localObject1 = this.JNX;
          localObject1[i] |= 0x1;
          continue;
          if (j == 2131494863)
          {
            if (i == 0)
            {
              localObject1 = this.JNX;
              localObject1[i] |= 0x4;
              localObject1 = this.JNX;
              localObject1[i] |= 0x10;
            }
            else
            {
              j = ((Preference)this.JNR.get(this.JNT.get(i - 1))).getLayoutResource();
              if ((j == 2131494804) || (j == 2131494886) || (j == 2131494889))
              {
                localObject1 = this.JNX;
                j = i - 1;
                localObject1[j] |= 0x2;
              }
            }
          }
          else
          {
            localObject1 = this.JNX;
            localObject1[i] |= 0x4;
            if (i == 0)
            {
              localObject1 = this.JNX;
              localObject1[i] |= 0x10;
            }
            else
            {
              j = ((Preference)this.JNR.get(this.JNT.get(i - 1))).getLayoutResource();
              if ((adb(j)) || (j == 2131494863))
              {
                localObject1 = this.JNX;
                j = i - 1;
                localObject1[j] |= 0x2;
              }
            }
          }
        }
      }
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(142607);
  }
  
  public final void removeAll()
  {
    AppMethodBeat.i(142604);
    this.JNT.clear();
    this.JNR.clear();
    this.JNQ.clear();
    this.JNS.clear();
    notifyDataSetChanged();
    AppMethodBeat.o(142604);
  }
  
  public static abstract interface a
  {
    public abstract int NI(int paramInt);
    
    public abstract boolean NJ(int paramInt);
    
    public abstract int NK(int paramInt);
    
    public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.h
 * JD-Core Version:    0.7.0.1
 */
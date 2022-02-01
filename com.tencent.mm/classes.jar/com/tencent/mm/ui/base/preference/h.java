package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private Preference.a JrJ;
  private final i Jta;
  private final LinkedList<String> Jtb;
  private final HashMap<String, Preference> Jtc;
  private final HashSet<String> Jtd;
  private final LinkedList<String> Jte;
  private final HashMap<String, Integer> Jtf;
  private final HashMap<String, String> Jtg;
  public a Jth;
  private int[] Jti;
  private boolean Jtj;
  private boolean Jtk;
  protected final Context context;
  private ListView jpT;
  private final SharedPreferences sp;
  
  public h(Context paramContext, ListView paramListView, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(142591);
    this.Jtb = new LinkedList();
    this.Jtc = new HashMap();
    this.Jtd = new HashSet();
    this.Jte = new LinkedList();
    this.Jtf = new HashMap();
    this.Jtg = new HashMap();
    this.Jti = new int[0];
    this.Jtj = false;
    this.Jtk = false;
    this.Jta = new i(paramContext);
    this.context = paramContext;
    this.jpT = paramListView;
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
      if (((Preference)localObject).JtB) {
        ((CheckBoxPreference)localObject).oB = paramSharedPreferences.getBoolean(paramPreference.mKey, ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
    if ((paramPreference instanceof DialogPreference))
    {
      localObject = (DialogPreference)paramPreference;
      if (((Preference)localObject).JtB) {
        ((DialogPreference)localObject).setValue(paramSharedPreferences.getString(paramPreference.mKey, null));
      }
    }
    if ((paramPreference instanceof EditPreference))
    {
      localObject = (EditPreference)paramPreference;
      if (((Preference)localObject).JtB)
      {
        ((EditPreference)localObject).value = paramSharedPreferences.getString(paramPreference.mKey, null);
        ((EditPreference)localObject).setSummary(((EditPreference)localObject).value);
      }
    }
    AppMethodBeat.o(142608);
  }
  
  private static boolean acu(int paramInt)
  {
    return (paramInt == 2131494804) || (paramInt == 2131494886) || (paramInt == 2131494889);
  }
  
  private void b(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(142599);
    String str = f(paramPreference);
    this.Jtc.put(str, paramPreference);
    LinkedList localLinkedList = this.Jtb;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.Jtb.size();
    }
    localLinkedList.add(i, str);
    if ((!this.Jtf.containsKey(e(paramPreference))) && (this.Jtj)) {
      this.Jtf.put(e(paramPreference), Integer.valueOf(this.Jtf.size()));
    }
    if (paramPreference.JtC != null) {
      this.Jtg.put(paramPreference.JtC + "|" + paramPreference.mKey, paramPreference.mKey);
    }
    AppMethodBeat.o(142599);
  }
  
  private static String e(Preference paramPreference)
  {
    AppMethodBeat.i(142592);
    paramPreference = paramPreference.getClass().getName() + "L" + paramPreference.getLayoutResource() + "W" + paramPreference.JtL;
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
    if (!this.Jtj) {
      notifyDataSetChanged();
    }
    AppMethodBeat.o(142598);
  }
  
  public final Preference aVD(String paramString)
  {
    AppMethodBeat.i(142600);
    paramString = (Preference)this.Jtc.get(paramString);
    AppMethodBeat.o(142600);
    return paramString;
  }
  
  public final boolean aVE(String paramString)
  {
    AppMethodBeat.i(142603);
    boolean bool = d(aVD(paramString));
    AppMethodBeat.o(142603);
    return bool;
  }
  
  public final int aVF(String paramString)
  {
    AppMethodBeat.i(142595);
    if (this.Jte == null)
    {
      AppMethodBeat.o(142595);
      return -1;
    }
    int i = this.Jte.indexOf(paramString);
    AppMethodBeat.o(142595);
    return i;
  }
  
  public final void addPreferencesFromResource(int paramInt)
  {
    AppMethodBeat.i(142605);
    this.Jtj = true;
    this.Jta.a(paramInt, this);
    this.Jtj = false;
    if (this.jpT != null) {
      this.jpT.setAdapter(this);
    }
    notifyDataSetChanged();
    AppMethodBeat.o(142605);
  }
  
  public final void b(Preference.a parama)
  {
    AppMethodBeat.i(142606);
    this.JrJ = parama;
    notifyDataSetChanged();
    AppMethodBeat.o(142606);
  }
  
  public final void b(Preference paramPreference)
  {
    AppMethodBeat.i(221157);
    a(paramPreference, -1);
    AppMethodBeat.o(221157);
  }
  
  public final void c(Preference paramPreference)
  {
    AppMethodBeat.i(142597);
    b(paramPreference, -1);
    AppMethodBeat.o(142597);
  }
  
  public final CheckBoxPreference cP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142601);
    if (paramBoolean) {
      if (!this.Jtd.contains(paramString)) {
        this.Jtd.add(paramString);
      }
    }
    while (this.Jtd.remove(paramString))
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
    this.Jtb.remove(str);
    this.Jtc.remove(str);
    this.Jtd.remove(paramPreference.mKey);
    notifyDataSetChanged();
    AppMethodBeat.o(142602);
    return true;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(142609);
    if (this.Jth != null)
    {
      i = this.Jth.Nc(this.Jte.size());
      AppMethodBeat.o(142609);
      return i;
    }
    int i = this.Jte.size();
    AppMethodBeat.o(142609);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(142610);
    int i = paramInt;
    if (this.Jth != null)
    {
      if (this.Jth.Nd(paramInt))
      {
        AppMethodBeat.o(142610);
        return null;
      }
      i = this.Jth.Ne(paramInt);
    }
    Object localObject = this.Jtc.get(this.Jte.get(i));
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
    if (paramInt > this.Jte.size() - 1)
    {
      AppMethodBeat.o(142612);
      return -1;
    }
    Object localObject = (Preference)this.Jtc.get(this.Jte.get(paramInt));
    localObject = (Integer)this.Jtf.get(e((Preference)localObject));
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
    if (this.Jth != null)
    {
      if (this.Jth.Nd(paramInt))
      {
        paramView = this.Jth.getView(paramInt, paramView, paramViewGroup);
        AppMethodBeat.o(142613);
        return paramView;
      }
      i = this.Jth.Ne(paramInt);
    }
    if (i > this.Jte.size())
    {
      AppMethodBeat.o(142613);
      return paramView;
    }
    Object localObject = (Preference)this.Jtc.get(this.Jte.get(i));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).a(this.JrJ);
    }
    if (!this.Jtf.containsKey(e((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).getView(paramView, paramViewGroup);
    paramInt = this.Jti[i];
    paramViewGroup = paramView.findViewById(2131298739);
    localObject = paramView.findViewById(2131306012);
    if (paramViewGroup == null) {
      ad.d("MicroMsg.MMPreferenceAdapter", "find content view error");
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
    if (!this.Jtk) {
      this.Jtk = true;
    }
    int i = Math.max(1, this.Jtf.size());
    AppMethodBeat.o(142611);
    return i;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(142594);
    int i = this.Jtb.indexOf(paramString);
    AppMethodBeat.o(142594);
    return i;
  }
  
  public void notifyDataSetChanged()
  {
    int j = 0;
    AppMethodBeat.i(142607);
    this.Jte.clear();
    Object localObject1 = this.Jtb.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!this.Jtd.contains(localObject2)) {
        if (this.Jtc.get(localObject2) == null) {
          ad.e("MicroMsg.MMPreferenceAdapter", "not found pref by key ".concat(String.valueOf(localObject2)));
        } else {
          this.Jte.add(localObject2);
        }
      }
    }
    if (!this.Jte.isEmpty()) {
      this.Jtc.get(this.Jte.get(0));
    }
    localObject1 = new HashSet();
    int i = 0;
    if (i < this.Jte.size())
    {
      localObject2 = (Preference)this.Jtc.get(this.Jte.get(i));
      if (((localObject2 instanceof PreferenceCategory)) && (bt.isNullOrNil(((Preference)localObject2).mKey)) && (i != 0))
      {
        Preference localPreference = (Preference)this.Jtc.get(this.Jte.get(i - 1));
        if ((localPreference instanceof PreferenceCategory))
        {
          if ((!bt.isNullOrNil(localPreference.mKey)) || ((localPreference.getTitle() != null) && (localPreference.getTitle().toString().trim().length() > 0))) {
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
        if ((bt.isNullOrNil(((Preference)localObject2).mKey)) && ((((Preference)localObject2).getTitle() == null) || (((Preference)localObject2).getTitle().toString().trim().length() <= 0))) {
          ((Set)localObject1).add(f((Preference)localObject2));
        }
      }
    }
    this.Jte.removeAll((Collection)localObject1);
    this.Jti = new int[this.Jte.size()];
    if (this.Jti.length <= 0)
    {
      AppMethodBeat.o(142607);
      return;
    }
    i = j;
    if (this.Jti.length == 1)
    {
      i = ((Preference)this.Jtc.get(this.Jte.get(0))).getLayoutResource();
      localObject1 = (Preference)this.Jtc.get(this.Jte.get(0));
      if (acu(i)) {
        if ((localObject1 instanceof CheckBoxPreference))
        {
          localObject1 = this.Jti;
          localObject1[0] |= 0x8;
          localObject1 = this.Jti;
          localObject1[0] |= 0x1;
        }
      }
      for (;;)
      {
        a((Preference)this.Jtc.get(this.Jte.get(0)), this.sp);
        super.notifyDataSetChanged();
        AppMethodBeat.o(142607);
        return;
        this.Jti[0] = 3;
        continue;
        this.Jti[0] = 4;
      }
    }
    if (i < this.Jte.size())
    {
      a((Preference)this.Jtc.get(this.Jte.get(i)), this.sp);
      localObject1 = (Preference)this.Jtc.get(this.Jte.get(i));
      j = ((Preference)localObject1).getLayoutResource();
      if (acu(j))
      {
        if ((localObject1 instanceof CheckBoxPreference))
        {
          localObject1 = this.Jti;
          localObject1[i] |= 0x8;
        }
        if (i == 0)
        {
          localObject1 = this.Jti;
          localObject1[i] |= 0x1;
          localObject1 = this.Jti;
          localObject1[i] |= 0x10;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == this.Jte.size() - 1)
        {
          localObject1 = this.Jti;
          localObject1[i] |= 0x2;
        }
        j = ((Preference)this.Jtc.get(this.Jte.get(i - 1))).getLayoutResource();
        if ((j != 2131494804) || (j == 2131494886) || (j == 2131494889))
        {
          localObject1 = this.Jti;
          localObject1[i] |= 0x1;
          continue;
          if (j == 2131494863)
          {
            if (i == 0)
            {
              localObject1 = this.Jti;
              localObject1[i] |= 0x4;
              localObject1 = this.Jti;
              localObject1[i] |= 0x10;
            }
            else
            {
              j = ((Preference)this.Jtc.get(this.Jte.get(i - 1))).getLayoutResource();
              if ((j == 2131494804) || (j == 2131494886) || (j == 2131494889))
              {
                localObject1 = this.Jti;
                j = i - 1;
                localObject1[j] |= 0x2;
              }
            }
          }
          else
          {
            localObject1 = this.Jti;
            localObject1[i] |= 0x4;
            if (i == 0)
            {
              localObject1 = this.Jti;
              localObject1[i] |= 0x10;
            }
            else
            {
              j = ((Preference)this.Jtc.get(this.Jte.get(i - 1))).getLayoutResource();
              if ((acu(j)) || (j == 2131494863))
              {
                localObject1 = this.Jti;
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
    this.Jte.clear();
    this.Jtc.clear();
    this.Jtb.clear();
    this.Jtd.clear();
    notifyDataSetChanged();
    AppMethodBeat.o(142604);
  }
  
  public static abstract interface a
  {
    public abstract int Nc(int paramInt);
    
    public abstract boolean Nd(int paramInt);
    
    public abstract int Ne(int paramInt);
    
    public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.h
 * JD-Core Version:    0.7.0.1
 */
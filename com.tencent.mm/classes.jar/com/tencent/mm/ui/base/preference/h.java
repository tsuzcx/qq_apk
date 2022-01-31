package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  protected final Context context;
  private ListView gJa;
  private final SharedPreferences sp;
  private Preference.a zqD;
  private final i zrI;
  private final LinkedList<String> zrJ;
  private final HashMap<String, Preference> zrK;
  private final HashSet<String> zrL;
  private final LinkedList<String> zrM;
  private final HashMap<String, Integer> zrN;
  private final HashMap<String, String> zrO;
  public h.a zrP;
  private int[] zrQ;
  private boolean zrR;
  private boolean zrS;
  
  public h(Context paramContext, ListView paramListView, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(107214);
    this.zrJ = new LinkedList();
    this.zrK = new HashMap();
    this.zrL = new HashSet();
    this.zrM = new LinkedList();
    this.zrN = new HashMap();
    this.zrO = new HashMap();
    this.zrQ = new int[0];
    this.zrR = false;
    this.zrS = false;
    this.zrI = new i(paramContext);
    this.context = paramContext;
    this.gJa = paramListView;
    this.sp = paramSharedPreferences;
    AppMethodBeat.o(107214);
  }
  
  private static boolean OU(int paramInt)
  {
    return (paramInt == 2130970179) || (paramInt == 2130970256) || (paramInt == 2130970259);
  }
  
  private static void a(Preference paramPreference, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(107231);
    Object localObject;
    if ((paramPreference instanceof CheckBoxPreference))
    {
      localObject = (CheckBoxPreference)paramPreference;
      if (((Preference)localObject).zsk) {
        ((CheckBoxPreference)localObject).vxW = paramSharedPreferences.getBoolean(paramPreference.mKey, ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
    if ((paramPreference instanceof DialogPreference))
    {
      localObject = (DialogPreference)paramPreference;
      if (((Preference)localObject).zsk) {
        ((DialogPreference)localObject).setValue(paramSharedPreferences.getString(paramPreference.mKey, null));
      }
    }
    if ((paramPreference instanceof EditPreference))
    {
      localObject = (EditPreference)paramPreference;
      if (((Preference)localObject).zsk)
      {
        ((EditPreference)localObject).value = paramSharedPreferences.getString(paramPreference.mKey, null);
        ((EditPreference)localObject).setSummary(((EditPreference)localObject).value);
      }
    }
    AppMethodBeat.o(107231);
  }
  
  private void b(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(107222);
    String str = f(paramPreference);
    this.zrK.put(str, paramPreference);
    LinkedList localLinkedList = this.zrJ;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.zrJ.size();
    }
    localLinkedList.add(i, str);
    if ((!this.zrN.containsKey(e(paramPreference))) && (this.zrR)) {
      this.zrN.put(e(paramPreference), Integer.valueOf(this.zrN.size()));
    }
    if (paramPreference.zsl != null) {
      this.zrO.put(paramPreference.zsl + "|" + paramPreference.mKey, paramPreference.mKey);
    }
    AppMethodBeat.o(107222);
  }
  
  private static String e(Preference paramPreference)
  {
    AppMethodBeat.i(107215);
    paramPreference = paramPreference.getClass().getName() + "L" + paramPreference.getLayoutResource() + "W" + paramPreference.zsq;
    AppMethodBeat.o(107215);
    return paramPreference;
  }
  
  private static String f(Preference paramPreference)
  {
    AppMethodBeat.i(107216);
    if ((paramPreference.mKey != null) && (paramPreference.mKey.length() > 0))
    {
      paramPreference = paramPreference.mKey;
      AppMethodBeat.o(107216);
      return paramPreference;
    }
    paramPreference = "_anonymous_pref@" + paramPreference.hashCode();
    AppMethodBeat.o(107216);
    return paramPreference;
  }
  
  public final void a(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(107221);
    b(paramPreference, paramInt);
    if (!this.zrR) {
      notifyDataSetChanged();
    }
    AppMethodBeat.o(107221);
  }
  
  public final void addPreferencesFromResource(int paramInt)
  {
    AppMethodBeat.i(107228);
    this.zrR = true;
    this.zrI.a(paramInt, this);
    this.zrR = false;
    if (this.gJa != null) {
      this.gJa.setAdapter(this);
    }
    notifyDataSetChanged();
    AppMethodBeat.o(107228);
  }
  
  public final Preference atx(String paramString)
  {
    AppMethodBeat.i(107223);
    paramString = (Preference)this.zrK.get(paramString);
    AppMethodBeat.o(107223);
    return paramString;
  }
  
  public final boolean aty(String paramString)
  {
    AppMethodBeat.i(107226);
    boolean bool = d(atx(paramString));
    AppMethodBeat.o(107226);
    return bool;
  }
  
  public final int atz(String paramString)
  {
    AppMethodBeat.i(107218);
    if (this.zrM == null)
    {
      AppMethodBeat.o(107218);
      return -1;
    }
    int i = this.zrM.indexOf(paramString);
    AppMethodBeat.o(107218);
    return i;
  }
  
  public final void b(Preference.a parama)
  {
    AppMethodBeat.i(107229);
    this.zqD = parama;
    notifyDataSetChanged();
    AppMethodBeat.o(107229);
  }
  
  public final void b(Preference paramPreference)
  {
    AppMethodBeat.i(156786);
    a(paramPreference, -1);
    AppMethodBeat.o(156786);
  }
  
  public final void c(Preference paramPreference)
  {
    AppMethodBeat.i(107220);
    b(paramPreference, -1);
    AppMethodBeat.o(107220);
  }
  
  public final void cl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(107224);
    if (paramBoolean) {
      if (!this.zrL.contains(paramString)) {
        this.zrL.add(paramString);
      }
    }
    while (this.zrL.remove(paramString))
    {
      notifyDataSetChanged();
      AppMethodBeat.o(107224);
      return;
      AppMethodBeat.o(107224);
      return;
    }
    AppMethodBeat.o(107224);
  }
  
  public final boolean d(Preference paramPreference)
  {
    AppMethodBeat.i(107225);
    if (paramPreference == null)
    {
      AppMethodBeat.o(107225);
      return false;
    }
    String str = f(paramPreference);
    this.zrJ.remove(str);
    this.zrK.remove(str);
    this.zrL.remove(paramPreference.mKey);
    notifyDataSetChanged();
    AppMethodBeat.o(107225);
    return true;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(107232);
    if (this.zrP != null)
    {
      i = this.zrP.ub(this.zrM.size());
      AppMethodBeat.o(107232);
      return i;
    }
    int i = this.zrM.size();
    AppMethodBeat.o(107232);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(107233);
    int i = paramInt;
    if (this.zrP != null)
    {
      if (this.zrP.BN(paramInt))
      {
        AppMethodBeat.o(107233);
        return null;
      }
      i = this.zrP.BO(paramInt);
    }
    Object localObject = this.zrK.get(this.zrM.get(i));
    AppMethodBeat.o(107233);
    return localObject;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107235);
    if (paramInt > this.zrM.size() - 1)
    {
      AppMethodBeat.o(107235);
      return -1;
    }
    Object localObject = (Preference)this.zrK.get(this.zrM.get(paramInt));
    localObject = (Integer)this.zrN.get(e((Preference)localObject));
    if (localObject == null)
    {
      AppMethodBeat.o(107235);
      return -1;
    }
    paramInt = ((Integer)localObject).intValue();
    AppMethodBeat.o(107235);
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107236);
    int i = paramInt;
    if (this.zrP != null)
    {
      if (this.zrP.BN(paramInt))
      {
        paramView = this.zrP.getView(paramInt, paramView, paramViewGroup);
        AppMethodBeat.o(107236);
        return paramView;
      }
      i = this.zrP.BO(paramInt);
    }
    if (i > this.zrM.size())
    {
      AppMethodBeat.o(107236);
      return paramView;
    }
    Object localObject = (Preference)this.zrK.get(this.zrM.get(i));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).a(this.zqD);
    }
    if (!this.zrN.containsKey(e((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).getView(paramView, paramViewGroup);
    paramInt = this.zrQ[i];
    paramViewGroup = paramView.findViewById(2131820946);
    localObject = paramView.findViewById(2131826191);
    if (paramViewGroup == null) {
      ab.d("MicroMsg.MMPreferenceAdapter", "find content view error");
    }
    View localView;
    int j;
    int k;
    int m;
    int n;
    if (paramViewGroup != null)
    {
      localView = paramViewGroup.findViewById(2131820997);
      paramViewGroup.getPaddingLeft();
      paramViewGroup.getPaddingRight();
      paramViewGroup.getPaddingTop();
      paramViewGroup.getPaddingBottom();
      i = paramView.getPaddingLeft();
      j = paramView.getPaddingRight();
      k = paramView.getPaddingTop();
      m = paramView.getPaddingBottom();
      if ((paramInt & 0x2) == 0) {
        break label333;
      }
      n = paramViewGroup.getPaddingLeft();
      paramViewGroup.setBackgroundResource(2130839276);
      paramViewGroup.setPadding(n, 0, 0, 0);
      if ((localView != null) && (localView.getBackground() != null)) {
        localView.setBackground(null);
      }
    }
    for (;;)
    {
      paramView.setBackgroundResource(2130840247);
      paramView.setPadding(i, k, j, m);
      if (((paramInt & 0x1) != 0) && (localObject != null)) {
        ((View)localObject).setBackgroundResource(2130840970);
      }
      AppMethodBeat.o(107236);
      return paramView;
      label333:
      if (localView != null)
      {
        n = localView.getPaddingTop();
        int i1 = localView.getPaddingBottom();
        localView.setBackgroundResource(2130839276);
        localView.setPadding(0, n, 0, i1);
        if ((paramViewGroup != null) && (paramViewGroup.getBackground() != null)) {
          paramViewGroup.setBackground(null);
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    AppMethodBeat.i(107234);
    if (!this.zrS) {
      this.zrS = true;
    }
    int i = Math.max(1, this.zrN.size());
    AppMethodBeat.o(107234);
    return i;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(107217);
    int i = this.zrJ.indexOf(paramString);
    AppMethodBeat.o(107217);
    return i;
  }
  
  public void notifyDataSetChanged()
  {
    int j = 0;
    AppMethodBeat.i(107230);
    this.zrM.clear();
    Object localObject1 = this.zrJ.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!this.zrL.contains(localObject2)) {
        if (this.zrK.get(localObject2) == null) {
          ab.e("MicroMsg.MMPreferenceAdapter", "not found pref by key ".concat(String.valueOf(localObject2)));
        } else {
          this.zrM.add(localObject2);
        }
      }
    }
    if (!this.zrM.isEmpty()) {
      this.zrK.get(this.zrM.get(0));
    }
    localObject1 = new HashSet();
    int i = 0;
    if (i < this.zrM.size())
    {
      localObject2 = (Preference)this.zrK.get(this.zrM.get(i));
      if (((localObject2 instanceof PreferenceCategory)) && (bo.isNullOrNil(((Preference)localObject2).mKey)) && (i != 0))
      {
        Preference localPreference = (Preference)this.zrK.get(this.zrM.get(i - 1));
        if ((localPreference instanceof PreferenceCategory))
        {
          if ((!bo.isNullOrNil(localPreference.mKey)) || ((localPreference.getTitle() != null) && (localPreference.getTitle().toString().trim().length() > 0))) {
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
        if ((bo.isNullOrNil(((Preference)localObject2).mKey)) && ((((Preference)localObject2).getTitle() == null) || (((Preference)localObject2).getTitle().toString().trim().length() <= 0))) {
          ((Set)localObject1).add(f((Preference)localObject2));
        }
      }
    }
    this.zrM.removeAll((Collection)localObject1);
    this.zrQ = new int[this.zrM.size()];
    if (this.zrQ.length <= 0)
    {
      AppMethodBeat.o(107230);
      return;
    }
    i = j;
    if (this.zrQ.length == 1)
    {
      i = ((Preference)this.zrK.get(this.zrM.get(0))).getLayoutResource();
      localObject1 = (Preference)this.zrK.get(this.zrM.get(0));
      if (OU(i)) {
        if ((localObject1 instanceof CheckBoxPreference))
        {
          localObject1 = this.zrQ;
          localObject1[0] |= 0x8;
          localObject1 = this.zrQ;
          localObject1[0] |= 0x1;
        }
      }
      for (;;)
      {
        a((Preference)this.zrK.get(this.zrM.get(0)), this.sp);
        super.notifyDataSetChanged();
        AppMethodBeat.o(107230);
        return;
        this.zrQ[0] = 3;
        continue;
        this.zrQ[0] = 4;
      }
    }
    if (i < this.zrM.size())
    {
      a((Preference)this.zrK.get(this.zrM.get(i)), this.sp);
      localObject1 = (Preference)this.zrK.get(this.zrM.get(i));
      j = ((Preference)localObject1).getLayoutResource();
      if (OU(j))
      {
        if ((localObject1 instanceof CheckBoxPreference))
        {
          localObject1 = this.zrQ;
          localObject1[i] |= 0x8;
        }
        if (i == 0)
        {
          localObject1 = this.zrQ;
          localObject1[i] |= 0x1;
          localObject1 = this.zrQ;
          localObject1[i] |= 0x10;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == this.zrM.size() - 1)
        {
          localObject1 = this.zrQ;
          localObject1[i] |= 0x2;
        }
        j = ((Preference)this.zrK.get(this.zrM.get(i - 1))).getLayoutResource();
        if ((j != 2130970179) || (j == 2130970256) || (j == 2130970259))
        {
          localObject1 = this.zrQ;
          localObject1[i] |= 0x1;
          continue;
          if (j == 2130970236)
          {
            if (i == 0)
            {
              localObject1 = this.zrQ;
              localObject1[i] |= 0x4;
              localObject1 = this.zrQ;
              localObject1[i] |= 0x10;
            }
            else
            {
              j = ((Preference)this.zrK.get(this.zrM.get(i - 1))).getLayoutResource();
              if ((j == 2130970179) || (j == 2130970256) || (j == 2130970259))
              {
                localObject1 = this.zrQ;
                j = i - 1;
                localObject1[j] |= 0x2;
              }
            }
          }
          else
          {
            localObject1 = this.zrQ;
            localObject1[i] |= 0x4;
            if (i == 0)
            {
              localObject1 = this.zrQ;
              localObject1[i] |= 0x10;
            }
            else
            {
              j = ((Preference)this.zrK.get(this.zrM.get(i - 1))).getLayoutResource();
              if ((OU(j)) || (j == 2130970236))
              {
                localObject1 = this.zrQ;
                j = i - 1;
                localObject1[j] |= 0x2;
              }
            }
          }
        }
      }
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(107230);
  }
  
  public final void removeAll()
  {
    AppMethodBeat.i(107227);
    this.zrM.clear();
    this.zrK.clear();
    this.zrJ.clear();
    this.zrL.clear();
    notifyDataSetChanged();
    AppMethodBeat.o(107227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.h
 * JD-Core Version:    0.7.0.1
 */
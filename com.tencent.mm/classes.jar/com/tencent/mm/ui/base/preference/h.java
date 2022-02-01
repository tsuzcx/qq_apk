package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class h
  extends BaseAdapter
  implements f
{
  private Preference.a OXy;
  private final i OYR;
  private final LinkedList<String> OYS;
  private final HashMap<String, Preference> OYT;
  private final HashSet<String> OYU;
  private final LinkedList<String> OYV;
  private final HashMap<String, Integer> OYW;
  private final HashMap<String, String> OYX;
  public a OYY;
  private int[] OYZ;
  private boolean OZa;
  private boolean OZb;
  private long OZc;
  public long OZd;
  protected final Context context;
  private ListView krb;
  private MMHandler mHandler;
  private final SharedPreferences sp;
  
  public h(Context paramContext, ListView paramListView, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(142591);
    this.OYS = new LinkedList();
    this.OYT = new HashMap();
    this.OYU = new HashSet();
    this.OYV = new LinkedList();
    this.OYW = new HashMap();
    this.OYX = new HashMap();
    this.OYZ = new int[0];
    this.OZa = false;
    this.OZb = false;
    this.mHandler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(205294);
        h.a(h.this);
        h.a(h.this, System.currentTimeMillis());
        AppMethodBeat.o(205294);
      }
    };
    this.OZc = 0L;
    this.OZd = 0L;
    this.OYR = new i(paramContext);
    this.context = paramContext;
    this.krb = paramListView;
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
      if (((Preference)localObject).OZw) {
        ((CheckBoxPreference)localObject).setChecked(paramSharedPreferences.getBoolean(paramPreference.mKey, ((CheckBoxPreference)paramPreference).isChecked()));
      }
    }
    if ((paramPreference instanceof DialogPreference))
    {
      localObject = (DialogPreference)paramPreference;
      if (((Preference)localObject).OZw) {
        ((DialogPreference)localObject).setValue(paramSharedPreferences.getString(paramPreference.mKey, null));
      }
    }
    if ((paramPreference instanceof EditPreference))
    {
      localObject = (EditPreference)paramPreference;
      if (((Preference)localObject).OZw)
      {
        ((EditPreference)localObject).value = paramSharedPreferences.getString(paramPreference.mKey, null);
        ((EditPreference)localObject).setSummary(((EditPreference)localObject).value);
      }
    }
    AppMethodBeat.o(142608);
  }
  
  private static boolean alM(int paramInt)
  {
    return (paramInt == 2131495538) || (paramInt == 2131495624) || (paramInt == 2131495627);
  }
  
  private void b(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(142599);
    String str = g(paramPreference);
    this.OYT.put(str, paramPreference);
    LinkedList localLinkedList = this.OYS;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.OYS.size();
    }
    localLinkedList.add(i, str);
    if ((!this.OYW.containsKey(f(paramPreference))) && (this.OZa)) {
      this.OYW.put(f(paramPreference), Integer.valueOf(this.OYW.size()));
    }
    if (paramPreference.OZx != null) {
      this.OYX.put(paramPreference.OZx + "|" + paramPreference.mKey, paramPreference.mKey);
    }
    AppMethodBeat.o(142599);
  }
  
  private static String f(Preference paramPreference)
  {
    AppMethodBeat.i(142592);
    paramPreference = paramPreference.getClass().getName() + "L" + paramPreference.getLayoutResource() + "W" + paramPreference.OZG;
    AppMethodBeat.o(142592);
    return paramPreference;
  }
  
  private static String g(Preference paramPreference)
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
  
  private void gLL()
  {
    AppMethodBeat.i(205297);
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < this.OYV.size())
    {
      Preference localPreference1 = (Preference)this.OYT.get(this.OYV.get(i));
      if (((localPreference1 instanceof PreferenceCategory)) && (Util.isNullOrNil(localPreference1.mKey)) && (i != 0))
      {
        Preference localPreference2 = (Preference)this.OYT.get(this.OYV.get(i - 1));
        if ((localPreference2 instanceof PreferenceCategory))
        {
          if ((!Util.isNullOrNil(localPreference2.mKey)) || ((localPreference2.getTitle() != null) && (localPreference2.getTitle().toString().trim().length() > 0))) {
            break label154;
          }
          localHashSet.add(g(localPreference2));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label154:
        if ((Util.isNullOrNil(localPreference1.mKey)) && ((localPreference1.getTitle() == null) || (localPreference1.getTitle().toString().trim().length() <= 0))) {
          localHashSet.add(g(localPreference1));
        }
      }
    }
    this.OYV.removeAll(localHashSet);
    AppMethodBeat.o(205297);
  }
  
  private void gLM()
  {
    AppMethodBeat.i(205298);
    this.OYV.clear();
    Iterator localIterator = this.OYS.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!this.OYU.contains(str)) {
        if (this.OYT.get(str) == null) {
          Log.e("MicroMsg.MMPreferenceAdapter", "not found pref by key ".concat(String.valueOf(str)));
        } else {
          this.OYV.add(str);
        }
      }
    }
    if (!this.OYV.isEmpty()) {
      this.OYT.get(this.OYV.get(0));
    }
    AppMethodBeat.o(205298);
  }
  
  private void gLN()
  {
    int i = 0;
    AppMethodBeat.i(205299);
    gLM();
    gLL();
    this.OYZ = new int[this.OYV.size()];
    if (this.OYZ.length <= 0)
    {
      AppMethodBeat.o(205299);
      return;
    }
    Object localObject;
    if (this.OYZ.length == 1)
    {
      i = ((Preference)this.OYT.get(this.OYV.get(0))).getLayoutResource();
      localObject = (Preference)this.OYT.get(this.OYV.get(0));
      if (alM(i)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.OYZ;
          localObject[0] |= 0x8;
          localObject = this.OYZ;
          localObject[0] |= 0x1;
        }
      }
      for (;;)
      {
        a((Preference)this.OYT.get(this.OYV.get(0)), this.sp);
        super.notifyDataSetChanged();
        AppMethodBeat.o(205299);
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
      int j = ((Preference)localObject).getLayoutResource();
      if (alM(j))
      {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.OYZ;
          localObject[i] |= 0x8;
        }
        if (i == 0)
        {
          localObject = this.OYZ;
          localObject[i] |= 0x1;
          localObject = this.OYZ;
          localObject[i] |= 0x10;
        }
      }
      for (;;)
      {
        i += 1;
        break;
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
              localObject = this.OYZ;
              localObject[i] |= 0x10;
            }
            else
            {
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
            if (i == 0)
            {
              localObject = this.OYZ;
              localObject[i] |= 0x10;
            }
            else
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
    super.notifyDataSetChanged();
    AppMethodBeat.o(205299);
  }
  
  public final void a(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(142598);
    b(paramPreference, paramInt);
    if (!this.OZa) {
      notifyDataSetChanged();
    }
    AppMethodBeat.o(142598);
  }
  
  public final void addPreferencesFromResource(int paramInt)
  {
    AppMethodBeat.i(142605);
    this.OZa = true;
    this.OYR.a(paramInt, this);
    this.OZa = false;
    if (this.krb != null) {
      this.krb.setAdapter(this);
    }
    notifyDataSetChanged();
    AppMethodBeat.o(142605);
  }
  
  public final void b(Preference.a parama)
  {
    AppMethodBeat.i(142606);
    this.OXy = parama;
    notifyDataSetChanged();
    AppMethodBeat.o(142606);
  }
  
  public final Preference bmg(String paramString)
  {
    AppMethodBeat.i(142600);
    paramString = (Preference)this.OYT.get(paramString);
    AppMethodBeat.o(142600);
    return paramString;
  }
  
  public final boolean bmh(String paramString)
  {
    AppMethodBeat.i(205296);
    if (!this.OYU.contains(paramString))
    {
      AppMethodBeat.o(205296);
      return true;
    }
    AppMethodBeat.o(205296);
    return false;
  }
  
  public final boolean bmi(String paramString)
  {
    AppMethodBeat.i(142603);
    boolean bool = e(bmg(paramString));
    AppMethodBeat.o(142603);
    return bool;
  }
  
  public final int bmj(String paramString)
  {
    AppMethodBeat.i(142595);
    if (this.OYV == null)
    {
      AppMethodBeat.o(142595);
      return -1;
    }
    int i = this.OYV.indexOf(paramString);
    AppMethodBeat.o(142595);
    return i;
  }
  
  public final void c(Preference paramPreference)
  {
    AppMethodBeat.i(258465);
    a(paramPreference, -1);
    AppMethodBeat.o(258465);
  }
  
  public final void d(Preference paramPreference)
  {
    AppMethodBeat.i(142597);
    b(paramPreference, -1);
    AppMethodBeat.o(142597);
  }
  
  public final CheckBoxPreference jdMethod_do(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142601);
    if (paramBoolean) {
      if (!this.OYU.contains(paramString)) {
        this.OYU.add(paramString);
      }
    }
    while (this.OYU.remove(paramString))
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
  
  public final boolean e(Preference paramPreference)
  {
    AppMethodBeat.i(142602);
    if (paramPreference == null)
    {
      AppMethodBeat.o(142602);
      return false;
    }
    String str = g(paramPreference);
    this.OYS.remove(str);
    this.OYT.remove(str);
    this.OYU.remove(paramPreference.mKey);
    notifyDataSetChanged();
    AppMethodBeat.o(142602);
    return true;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(142609);
    if (this.OYY != null)
    {
      i = this.OYY.UX(this.OYV.size());
      AppMethodBeat.o(142609);
      return i;
    }
    int i = this.OYV.size();
    AppMethodBeat.o(142609);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(142610);
    int i = paramInt;
    if (this.OYY != null)
    {
      if (this.OYY.UY(paramInt))
      {
        AppMethodBeat.o(142610);
        return null;
      }
      i = this.OYY.UZ(paramInt);
    }
    Object localObject = this.OYT.get(this.OYV.get(i));
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
    if (paramInt > this.OYV.size() - 1)
    {
      AppMethodBeat.o(142612);
      return -1;
    }
    Object localObject = (Preference)this.OYT.get(this.OYV.get(paramInt));
    localObject = (Integer)this.OYW.get(f((Preference)localObject));
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
    if (this.OYY != null)
    {
      if (this.OYY.UY(paramInt))
      {
        paramView = this.OYY.getView(paramInt, paramView, paramViewGroup);
        AppMethodBeat.o(142613);
        return paramView;
      }
      i = this.OYY.UZ(paramInt);
    }
    if (i > this.OYV.size())
    {
      AppMethodBeat.o(142613);
      return paramView;
    }
    Object localObject = (Preference)this.OYT.get(this.OYV.get(i));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).a(this.OXy);
    }
    if (!this.OYW.containsKey(f((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).getView(paramView, paramViewGroup);
    paramInt = this.OYZ[i];
    paramViewGroup = paramView.findViewById(2131299180);
    localObject = paramView.findViewById(2131309322);
    if (paramViewGroup == null) {
      Log.d("MicroMsg.MMPreferenceAdapter", "find content view error");
    }
    View localView;
    int n;
    if (paramViewGroup != null)
    {
      localView = paramViewGroup.findViewById(2131309235);
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
        paramViewGroup.setBackground(at.aN(this.context, 2130969285));
        paramViewGroup.setPadding(n, 0, 0, 0);
        if ((localView != null) && (localView.getBackground() != null)) {
          localView.setBackground(null);
        }
        paramView.setBackgroundResource(2131234793);
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
      localView.setBackground(at.aN(this.context, 2130969285));
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
    if (!this.OZb) {
      this.OZb = true;
    }
    int i = Math.max(1, this.OYW.size());
    AppMethodBeat.o(142611);
    return i;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(142594);
    int i = this.OYS.indexOf(paramString);
    AppMethodBeat.o(142594);
    return i;
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(142607);
    if (ao.gJK())
    {
      int i = ((b)g.af(b.class)).a(b.a.sis, 1);
      Log.d("MicroMsg.MMPreferenceAdapter", "isHWMagicMMPreferenceNotifySwt() swt:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1) {
        i = 1;
      }
      while (i != 0)
      {
        Log.d("MicroMsg.MMPreferenceAdapter", "MMPreferenceAdapter notifyDataSetChanged %s %s %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.OZd) });
        long l = System.currentTimeMillis();
        if ((this.OZd != 0L) && (l - this.OZd > 5000L) && (l - this.OZc < 1000L))
        {
          boolean bool = this.mHandler.hasMessages(1);
          Log.i("MicroMsg.MMPreferenceAdapter", "ignore notifyDataSetChanged(%s %s), had:%s", new Object[] { Long.valueOf(this.OZc), Long.valueOf(l), Boolean.valueOf(bool) });
          if (!bool) {
            this.mHandler.sendEmptyMessageDelayed(1, 1000L);
          }
          AppMethodBeat.o(142607);
          return;
          i = 0;
        }
        else
        {
          gLN();
          this.OZc = l;
          AppMethodBeat.o(142607);
          return;
        }
      }
    }
    gLN();
    AppMethodBeat.o(142607);
  }
  
  public final void removeAll()
  {
    AppMethodBeat.i(142604);
    this.OYV.clear();
    this.OYT.clear();
    this.OYS.clear();
    this.OYU.clear();
    notifyDataSetChanged();
    AppMethodBeat.o(142604);
  }
  
  public static abstract interface a
  {
    public abstract int UX(int paramInt);
    
    public abstract boolean UY(int paramInt);
    
    public abstract int UZ(int paramInt);
    
    public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.h
 * JD-Core Version:    0.7.0.1
 */
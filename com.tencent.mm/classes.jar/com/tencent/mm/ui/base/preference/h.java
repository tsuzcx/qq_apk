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
import com.tencent.mm.ah.a.c;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class h
  extends BaseAdapter
  implements f
{
  private Preference.a adXX;
  private boolean adZA;
  private long adZB;
  public long adZC;
  private final i adZq;
  private final LinkedList<String> adZr;
  private final HashMap<String, Preference> adZs;
  private final HashSet<String> adZt;
  private final LinkedList<String> adZu;
  private final HashMap<String, Integer> adZv;
  private final HashMap<String, String> adZw;
  private a adZx;
  private int[] adZy;
  private boolean adZz;
  protected final Context context;
  private MMHandler mHandler;
  private ListView qgc;
  private final SharedPreferences sp;
  
  public h(Context paramContext, ListView paramListView, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(142591);
    this.adZr = new LinkedList();
    this.adZs = new HashMap();
    this.adZt = new HashSet();
    this.adZu = new LinkedList();
    this.adZv = new HashMap();
    this.adZw = new HashMap();
    this.adZy = new int[0];
    this.adZz = false;
    this.adZA = false;
    this.mHandler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(251494);
        h.a(h.this);
        h.a(h.this, System.currentTimeMillis());
        AppMethodBeat.o(251494);
      }
    };
    this.adZB = 0L;
    this.adZC = 0L;
    this.adZq = new i(paramContext);
    this.context = paramContext;
    this.qgc = paramListView;
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
      if (((Preference)localObject).adZV) {
        ((CheckBoxPreference)localObject).setChecked(paramSharedPreferences.getBoolean(paramPreference.mKey, ((CheckBoxPreference)paramPreference).isChecked()));
      }
    }
    if ((paramPreference instanceof DialogPreference))
    {
      localObject = (DialogPreference)paramPreference;
      if (((Preference)localObject).adZV) {
        ((DialogPreference)localObject).setValue(paramSharedPreferences.getString(paramPreference.mKey, null));
      }
    }
    if ((paramPreference instanceof EditPreference))
    {
      localObject = (EditPreference)paramPreference;
      if (((Preference)localObject).adZV)
      {
        ((EditPreference)localObject).value = paramSharedPreferences.getString(paramPreference.mKey, null);
        ((EditPreference)localObject).aS(((EditPreference)localObject).value);
      }
    }
    AppMethodBeat.o(142608);
  }
  
  private static boolean aBn(int paramInt)
  {
    return (paramInt == a.h.mm_preference) || (paramInt == a.h.mm_preference_summary_below) || (paramInt == a.h.mm_preference_summary_checkbox);
  }
  
  private void b(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(142599);
    String str = g(paramPreference);
    this.adZs.put(str, paramPreference);
    LinkedList localLinkedList = this.adZr;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.adZr.size();
    }
    localLinkedList.add(i, str);
    if ((!this.adZv.containsKey(f(paramPreference))) && (this.adZz)) {
      this.adZv.put(f(paramPreference), Integer.valueOf(this.adZv.size()));
    }
    if (paramPreference.adZW != null) {
      this.adZw.put(paramPreference.adZW + "|" + paramPreference.mKey, paramPreference.mKey);
    }
    AppMethodBeat.o(142599);
  }
  
  private static String f(Preference paramPreference)
  {
    AppMethodBeat.i(142592);
    paramPreference = paramPreference.getClass().getName() + "L" + paramPreference.getLayoutResource() + "W" + paramPreference.aeaf;
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
  
  private void jns()
  {
    AppMethodBeat.i(251515);
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < this.adZu.size())
    {
      Preference localPreference1 = (Preference)this.adZs.get(this.adZu.get(i));
      if (((localPreference1 instanceof PreferenceCategory)) && (Util.isNullOrNil(localPreference1.mKey)) && (i != 0))
      {
        Preference localPreference2 = (Preference)this.adZs.get(this.adZu.get(i - 1));
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
    this.adZu.removeAll(localHashSet);
    AppMethodBeat.o(251515);
  }
  
  private void jnt()
  {
    AppMethodBeat.i(251519);
    this.adZu.clear();
    Iterator localIterator = this.adZr.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!this.adZt.contains(str)) {
        if (this.adZs.get(str) == null) {
          Log.e("MicroMsg.MMPreferenceAdapter", "not found pref by key ".concat(String.valueOf(str)));
        } else {
          this.adZu.add(str);
        }
      }
    }
    if (!this.adZu.isEmpty()) {
      ((Preference)this.adZs.get(this.adZu.get(0))).getLayoutResource();
    }
    AppMethodBeat.o(251519);
  }
  
  private void jnu()
  {
    int i = 0;
    AppMethodBeat.i(251523);
    jnt();
    jns();
    this.adZy = new int[this.adZu.size()];
    if (this.adZy.length <= 0)
    {
      AppMethodBeat.o(251523);
      return;
    }
    Object localObject;
    if (this.adZy.length == 1)
    {
      i = ((Preference)this.adZs.get(this.adZu.get(0))).getLayoutResource();
      localObject = (Preference)this.adZs.get(this.adZu.get(0));
      if (aBn(i)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.adZy;
          localObject[0] |= 0x8;
          localObject = this.adZy;
          localObject[0] |= 0x1;
        }
      }
      for (;;)
      {
        a((Preference)this.adZs.get(this.adZu.get(0)), this.sp);
        super.notifyDataSetChanged();
        AppMethodBeat.o(251523);
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
      int j = ((Preference)localObject).getLayoutResource();
      if (aBn(j))
      {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.adZy;
          localObject[i] |= 0x8;
        }
        if (i == 0)
        {
          localObject = this.adZy;
          localObject[i] |= 0x1;
          localObject = this.adZy;
          localObject[i] |= 0x10;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == this.adZu.size() - 1)
        {
          localObject = this.adZy;
          localObject[i] |= 0x2;
        }
        j = ((Preference)this.adZs.get(this.adZu.get(i - 1))).getLayoutResource();
        if (((j != a.h.mm_preference) && (j != a.h.finder_mm_preference) && (j != a.h.contact_profile_header_normal)) || (j == a.h.mm_preference_summary_below) || (j == a.h.mm_preference_summary_checkbox))
        {
          localObject = this.adZy;
          localObject[i] |= 0x1;
          continue;
          if (j == a.h.mm_preference_info)
          {
            if (i == 0)
            {
              localObject = this.adZy;
              localObject[i] |= 0x4;
              localObject = this.adZy;
              localObject[i] |= 0x10;
            }
            else
            {
              j = ((Preference)this.adZs.get(this.adZu.get(i - 1))).getLayoutResource();
              if ((j == a.h.mm_preference) || (j == a.h.mm_preference_summary_below) || (j == a.h.mm_preference_summary_checkbox))
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
            if (i == 0)
            {
              localObject = this.adZy;
              localObject[i] |= 0x10;
            }
            else
            {
              j = ((Preference)this.adZs.get(this.adZu.get(i - 1))).getLayoutResource();
              if ((aBn(j)) || (j == a.h.mm_preference_info))
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
    super.notifyDataSetChanged();
    AppMethodBeat.o(251523);
  }
  
  public final void a(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(142598);
    b(paramPreference, paramInt);
    if (!this.adZz) {
      notifyDataSetChanged();
    }
    AppMethodBeat.o(142598);
  }
  
  public final void aBe(int paramInt)
  {
    AppMethodBeat.i(142605);
    this.adZz = true;
    this.adZq.a(paramInt, this);
    this.adZz = false;
    if (this.qgc != null) {
      this.qgc.setAdapter(this);
    }
    notifyDataSetChanged();
    AppMethodBeat.o(142605);
  }
  
  public final void b(Preference.a parama)
  {
    AppMethodBeat.i(142606);
    this.adXX = parama;
    notifyDataSetChanged();
    AppMethodBeat.o(142606);
  }
  
  public final Preference bAi(String paramString)
  {
    AppMethodBeat.i(142600);
    paramString = (Preference)this.adZs.get(paramString);
    AppMethodBeat.o(142600);
    return paramString;
  }
  
  public final boolean bAj(String paramString)
  {
    AppMethodBeat.i(251560);
    if (!this.adZt.contains(paramString))
    {
      AppMethodBeat.o(251560);
      return true;
    }
    AppMethodBeat.o(251560);
    return false;
  }
  
  public final boolean bAk(String paramString)
  {
    AppMethodBeat.i(142603);
    boolean bool = e(bAi(paramString));
    AppMethodBeat.o(142603);
    return bool;
  }
  
  public final int bAl(String paramString)
  {
    AppMethodBeat.i(142595);
    if (this.adZu == null)
    {
      AppMethodBeat.o(142595);
      return -1;
    }
    int i = this.adZu.indexOf(paramString);
    AppMethodBeat.o(142595);
    return i;
  }
  
  public final void c(Preference paramPreference)
  {
    AppMethodBeat.i(369639);
    a(paramPreference, -1);
    AppMethodBeat.o(369639);
  }
  
  public final int cs(String paramString)
  {
    AppMethodBeat.i(142594);
    int i = this.adZr.indexOf(paramString);
    AppMethodBeat.o(142594);
    return i;
  }
  
  public final void d(Preference paramPreference)
  {
    AppMethodBeat.i(142597);
    b(paramPreference, -1);
    AppMethodBeat.o(142597);
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
    this.adZr.remove(str);
    this.adZs.remove(str);
    this.adZt.remove(paramPreference.mKey);
    notifyDataSetChanged();
    AppMethodBeat.o(142602);
    return true;
  }
  
  public final CheckBoxPreference eh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142601);
    if (paramBoolean) {
      if (!this.adZt.contains(paramString)) {
        this.adZt.add(paramString);
      }
    }
    while (this.adZt.remove(paramString))
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
  
  public int getCount()
  {
    AppMethodBeat.i(142609);
    if (this.adZx != null)
    {
      a locala = this.adZx;
      this.adZu.size();
      i = locala.jhQ();
      AppMethodBeat.o(142609);
      return i;
    }
    int i = this.adZu.size();
    AppMethodBeat.o(142609);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(142610);
    if (this.adZx != null)
    {
      if (this.adZx.jnx())
      {
        localObject = this.adZx.jnw();
        AppMethodBeat.o(142610);
        return localObject;
      }
      paramInt = this.adZx.jny();
    }
    Object localObject = this.adZs.get(this.adZu.get(paramInt));
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
    if (paramInt > this.adZu.size() - 1)
    {
      AppMethodBeat.o(142612);
      return -1;
    }
    Object localObject = (Preference)this.adZs.get(this.adZu.get(paramInt));
    localObject = (Integer)this.adZv.get(f((Preference)localObject));
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
    if (this.adZx != null)
    {
      if (this.adZx.jnx())
      {
        paramView = this.adZx.jnv();
        AppMethodBeat.o(142613);
        return paramView;
      }
      paramInt = this.adZx.jny();
    }
    if (paramInt > this.adZu.size())
    {
      AppMethodBeat.o(142613);
      return paramView;
    }
    Object localObject = (Preference)this.adZs.get(this.adZu.get(paramInt));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).a(this.adXX);
    }
    if (!this.adZv.containsKey(f((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).b(paramView, paramViewGroup);
    paramView.setTag(a.g.wcpay_report_view_id, this.adZu.get(paramInt));
    paramInt = this.adZy[paramInt];
    paramViewGroup = paramView.findViewById(a.g.content);
    localObject = paramView.findViewById(a.g.top_line);
    if (paramViewGroup == null) {
      Log.d("MicroMsg.MMPreferenceAdapter", "find content view error");
    }
    View localView;
    int i1;
    if (paramViewGroup != null)
    {
      localView = paramViewGroup.findViewById(a.g.title_ll);
      paramViewGroup.getPaddingLeft();
      paramViewGroup.getPaddingRight();
      paramViewGroup.getPaddingTop();
      paramViewGroup.getPaddingBottom();
      int i = a.f.settings_line;
      int j = paramView.getPaddingLeft();
      int k = paramView.getPaddingRight();
      int m = paramView.getPaddingTop();
      int n = paramView.getPaddingBottom();
      if ((paramInt & 0x2) != 0)
      {
        i1 = paramViewGroup.getPaddingLeft();
        paramViewGroup.setBackground(bd.by(this.context, a.c.list_item_divider));
        paramViewGroup.setPadding(i1, 0, 0, 0);
        if ((localView != null) && (localView.getBackground() != null)) {
          localView.setBackground(null);
        }
        paramView.setBackgroundResource(i);
        paramView.setPadding(j, m, k, n);
      }
    }
    else if (localObject != null)
    {
      if ((paramInt & 0x1) == 0) {
        break label409;
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
      i1 = localView.getPaddingTop();
      int i2 = localView.getPaddingBottom();
      localView.setBackground(bd.by(this.context, a.c.list_item_divider));
      localView.setPadding(0, i1, 0, i2);
      if ((paramViewGroup == null) || (paramViewGroup.getBackground() == null)) {
        break;
      }
      paramViewGroup.setBackground(null);
      break;
      label409:
      ((View)localObject).setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    AppMethodBeat.i(142611);
    if (!this.adZA) {
      this.adZA = true;
    }
    int i = Math.max(1, this.adZv.size());
    AppMethodBeat.o(142611);
    return i;
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(142607);
    if (aw.jkS())
    {
      int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zkT, 1);
      Log.d("MicroMsg.MMPreferenceAdapter", "isHWMagicMMPreferenceNotifySwt() swt:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1) {
        i = 1;
      }
      while (i != 0)
      {
        Log.d("MicroMsg.MMPreferenceAdapter", "MMPreferenceAdapter notifyDataSetChanged %s %s %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.adZC) });
        long l = System.currentTimeMillis();
        if ((this.adZC != 0L) && (l - this.adZC > 5000L) && (l - this.adZB < 1000L))
        {
          boolean bool = this.mHandler.hasMessages(1);
          Log.i("MicroMsg.MMPreferenceAdapter", "ignore notifyDataSetChanged(%s %s), had:%s", new Object[] { Long.valueOf(this.adZB), Long.valueOf(l), Boolean.valueOf(bool) });
          if (!bool) {
            this.mHandler.sendEmptyMessageDelayed(1, 1000L);
          }
          AppMethodBeat.o(142607);
          return;
          i = 0;
        }
        else
        {
          jnu();
          this.adZB = l;
          AppMethodBeat.o(142607);
          return;
        }
      }
    }
    jnu();
    AppMethodBeat.o(142607);
  }
  
  public final void removeAll()
  {
    AppMethodBeat.i(142604);
    this.adZu.clear();
    this.adZs.clear();
    this.adZr.clear();
    this.adZt.clear();
    notifyDataSetChanged();
    AppMethodBeat.o(142604);
  }
  
  public static abstract interface a
  {
    public abstract int jhQ();
    
    public abstract View jnv();
    
    public abstract Object jnw();
    
    public abstract boolean jnx();
    
    public abstract int jny();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.h
 * JD-Core Version:    0.7.0.1
 */
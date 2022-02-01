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
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class h
  extends BaseAdapter
  implements f
{
  private Preference.a WqI;
  private final i Wsa;
  private final LinkedList<String> Wsb;
  private final HashMap<String, Preference> Wsc;
  private final HashSet<String> Wsd;
  private final LinkedList<String> Wse;
  private final HashMap<String, Integer> Wsf;
  private final HashMap<String, String> Wsg;
  public a Wsh;
  private int[] Wsi;
  private boolean Wsj;
  private boolean Wsk;
  private long Wsl;
  public long Wsm;
  protected final Context context;
  private MMHandler mHandler;
  private ListView niO;
  private final SharedPreferences sp;
  
  public h(Context paramContext, ListView paramListView, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(142591);
    this.Wsb = new LinkedList();
    this.Wsc = new HashMap();
    this.Wsd = new HashSet();
    this.Wse = new LinkedList();
    this.Wsf = new HashMap();
    this.Wsg = new HashMap();
    this.Wsi = new int[0];
    this.Wsj = false;
    this.Wsk = false;
    this.mHandler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(190289);
        h.a(h.this);
        h.a(h.this, System.currentTimeMillis());
        AppMethodBeat.o(190289);
      }
    };
    this.Wsl = 0L;
    this.Wsm = 0L;
    this.Wsa = new i(paramContext);
    this.context = paramContext;
    this.niO = paramListView;
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
      if (((Preference)localObject).WsF) {
        ((CheckBoxPreference)localObject).setChecked(paramSharedPreferences.getBoolean(paramPreference.mKey, ((CheckBoxPreference)paramPreference).isChecked()));
      }
    }
    if ((paramPreference instanceof DialogPreference))
    {
      localObject = (DialogPreference)paramPreference;
      if (((Preference)localObject).WsF) {
        ((DialogPreference)localObject).setValue(paramSharedPreferences.getString(paramPreference.mKey, null));
      }
    }
    if ((paramPreference instanceof EditPreference))
    {
      localObject = (EditPreference)paramPreference;
      if (((Preference)localObject).WsF)
      {
        ((EditPreference)localObject).value = paramSharedPreferences.getString(paramPreference.mKey, null);
        ((EditPreference)localObject).aF(((EditPreference)localObject).value);
      }
    }
    AppMethodBeat.o(142608);
  }
  
  private static boolean auL(int paramInt)
  {
    return (paramInt == a.h.mm_preference) || (paramInt == a.h.mm_preference_summary_below) || (paramInt == a.h.mm_preference_summary_checkbox);
  }
  
  private void b(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(142599);
    String str = f(paramPreference);
    this.Wsc.put(str, paramPreference);
    LinkedList localLinkedList = this.Wsb;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.Wsb.size();
    }
    localLinkedList.add(i, str);
    if ((!this.Wsf.containsKey(e(paramPreference))) && (this.Wsj)) {
      this.Wsf.put(e(paramPreference), Integer.valueOf(this.Wsf.size()));
    }
    if (paramPreference.WsG != null) {
      this.Wsg.put(paramPreference.WsG + "|" + paramPreference.mKey, paramPreference.mKey);
    }
    AppMethodBeat.o(142599);
  }
  
  private static String e(Preference paramPreference)
  {
    AppMethodBeat.i(142592);
    paramPreference = paramPreference.getClass().getName() + "L" + paramPreference.getLayoutResource() + "W" + paramPreference.WsP;
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
  
  private void hKP()
  {
    AppMethodBeat.i(208144);
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < this.Wse.size())
    {
      Preference localPreference1 = (Preference)this.Wsc.get(this.Wse.get(i));
      if (((localPreference1 instanceof PreferenceCategory)) && (Util.isNullOrNil(localPreference1.mKey)) && (i != 0))
      {
        Preference localPreference2 = (Preference)this.Wsc.get(this.Wse.get(i - 1));
        if ((localPreference2 instanceof PreferenceCategory))
        {
          if ((!Util.isNullOrNil(localPreference2.mKey)) || ((localPreference2.getTitle() != null) && (localPreference2.getTitle().toString().trim().length() > 0))) {
            break label154;
          }
          localHashSet.add(f(localPreference2));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label154:
        if ((Util.isNullOrNil(localPreference1.mKey)) && ((localPreference1.getTitle() == null) || (localPreference1.getTitle().toString().trim().length() <= 0))) {
          localHashSet.add(f(localPreference1));
        }
      }
    }
    this.Wse.removeAll(localHashSet);
    AppMethodBeat.o(208144);
  }
  
  private void hKQ()
  {
    AppMethodBeat.i(208145);
    this.Wse.clear();
    Iterator localIterator = this.Wsb.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!this.Wsd.contains(str)) {
        if (this.Wsc.get(str) == null) {
          Log.e("MicroMsg.MMPreferenceAdapter", "not found pref by key ".concat(String.valueOf(str)));
        } else {
          this.Wse.add(str);
        }
      }
    }
    if (!this.Wse.isEmpty()) {
      ((Preference)this.Wsc.get(this.Wse.get(0))).getLayoutResource();
    }
    AppMethodBeat.o(208145);
  }
  
  private void hKR()
  {
    int i = 0;
    AppMethodBeat.i(208149);
    hKQ();
    hKP();
    this.Wsi = new int[this.Wse.size()];
    if (this.Wsi.length <= 0)
    {
      AppMethodBeat.o(208149);
      return;
    }
    Object localObject;
    if (this.Wsi.length == 1)
    {
      i = ((Preference)this.Wsc.get(this.Wse.get(0))).getLayoutResource();
      localObject = (Preference)this.Wsc.get(this.Wse.get(0));
      if (auL(i)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.Wsi;
          localObject[0] |= 0x8;
          localObject = this.Wsi;
          localObject[0] |= 0x1;
        }
      }
      for (;;)
      {
        a((Preference)this.Wsc.get(this.Wse.get(0)), this.sp);
        super.notifyDataSetChanged();
        AppMethodBeat.o(208149);
        return;
        this.Wsi[0] = 3;
        continue;
        this.Wsi[0] = 4;
      }
    }
    if (i < this.Wse.size())
    {
      a((Preference)this.Wsc.get(this.Wse.get(i)), this.sp);
      localObject = (Preference)this.Wsc.get(this.Wse.get(i));
      int j = ((Preference)localObject).getLayoutResource();
      if (auL(j))
      {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.Wsi;
          localObject[i] |= 0x8;
        }
        if (i == 0)
        {
          localObject = this.Wsi;
          localObject[i] |= 0x1;
          localObject = this.Wsi;
          localObject[i] |= 0x10;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == this.Wse.size() - 1)
        {
          localObject = this.Wsi;
          localObject[i] |= 0x2;
        }
        j = ((Preference)this.Wsc.get(this.Wse.get(i - 1))).getLayoutResource();
        if (((j != a.h.mm_preference) && (j != a.h.finder_mm_preference)) || (j == a.h.mm_preference_summary_below) || (j == a.h.mm_preference_summary_checkbox))
        {
          localObject = this.Wsi;
          localObject[i] |= 0x1;
          continue;
          if (j == a.h.mm_preference_info)
          {
            if (i == 0)
            {
              localObject = this.Wsi;
              localObject[i] |= 0x4;
              localObject = this.Wsi;
              localObject[i] |= 0x10;
            }
            else
            {
              j = ((Preference)this.Wsc.get(this.Wse.get(i - 1))).getLayoutResource();
              if ((j == a.h.mm_preference) || (j == a.h.mm_preference_summary_below) || (j == a.h.mm_preference_summary_checkbox))
              {
                localObject = this.Wsi;
                j = i - 1;
                localObject[j] |= 0x2;
              }
            }
          }
          else
          {
            localObject = this.Wsi;
            localObject[i] |= 0x4;
            if (i == 0)
            {
              localObject = this.Wsi;
              localObject[i] |= 0x10;
            }
            else
            {
              j = ((Preference)this.Wsc.get(this.Wse.get(i - 1))).getLayoutResource();
              if ((auL(j)) || (j == a.h.mm_preference_info))
              {
                localObject = this.Wsi;
                j = i - 1;
                localObject[j] |= 0x2;
              }
            }
          }
        }
      }
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(208149);
  }
  
  public final void a(Preference paramPreference, int paramInt)
  {
    AppMethodBeat.i(142598);
    b(paramPreference, paramInt);
    if (!this.Wsj) {
      notifyDataSetChanged();
    }
    AppMethodBeat.o(142598);
  }
  
  public final void auC(int paramInt)
  {
    AppMethodBeat.i(142605);
    this.Wsj = true;
    this.Wsa.a(paramInt, this);
    this.Wsj = false;
    if (this.niO != null) {
      this.niO.setAdapter(this);
    }
    notifyDataSetChanged();
    AppMethodBeat.o(142605);
  }
  
  public final void b(Preference.a parama)
  {
    AppMethodBeat.i(142606);
    this.WqI = parama;
    notifyDataSetChanged();
    AppMethodBeat.o(142606);
  }
  
  public final void b(Preference paramPreference)
  {
    AppMethodBeat.i(293203);
    a(paramPreference, -1);
    AppMethodBeat.o(293203);
  }
  
  public final int bf(String paramString)
  {
    AppMethodBeat.i(142594);
    int i = this.Wsb.indexOf(paramString);
    AppMethodBeat.o(142594);
    return i;
  }
  
  public final Preference byG(String paramString)
  {
    AppMethodBeat.i(142600);
    paramString = (Preference)this.Wsc.get(paramString);
    AppMethodBeat.o(142600);
    return paramString;
  }
  
  public final boolean byH(String paramString)
  {
    AppMethodBeat.i(208139);
    if (!this.Wsd.contains(paramString))
    {
      AppMethodBeat.o(208139);
      return true;
    }
    AppMethodBeat.o(208139);
    return false;
  }
  
  public final boolean byI(String paramString)
  {
    AppMethodBeat.i(142603);
    boolean bool = d(byG(paramString));
    AppMethodBeat.o(142603);
    return bool;
  }
  
  public final int byJ(String paramString)
  {
    AppMethodBeat.i(142595);
    if (this.Wse == null)
    {
      AppMethodBeat.o(142595);
      return -1;
    }
    int i = this.Wse.indexOf(paramString);
    AppMethodBeat.o(142595);
    return i;
  }
  
  public final void c(Preference paramPreference)
  {
    AppMethodBeat.i(142597);
    b(paramPreference, -1);
    AppMethodBeat.o(142597);
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
    this.Wsb.remove(str);
    this.Wsc.remove(str);
    this.Wsd.remove(paramPreference.mKey);
    notifyDataSetChanged();
    AppMethodBeat.o(142602);
    return true;
  }
  
  public final CheckBoxPreference dz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142601);
    if (paramBoolean) {
      if (!this.Wsd.contains(paramString)) {
        this.Wsd.add(paramString);
      }
    }
    while (this.Wsd.remove(paramString))
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
    if (this.Wsh != null)
    {
      i = this.Wsh.abD(this.Wse.size());
      AppMethodBeat.o(142609);
      return i;
    }
    int i = this.Wse.size();
    AppMethodBeat.o(142609);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(142610);
    int i = paramInt;
    if (this.Wsh != null)
    {
      if (this.Wsh.abE(paramInt))
      {
        AppMethodBeat.o(142610);
        return null;
      }
      i = this.Wsh.abF(paramInt);
    }
    Object localObject = this.Wsc.get(this.Wse.get(i));
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
    if (paramInt > this.Wse.size() - 1)
    {
      AppMethodBeat.o(142612);
      return -1;
    }
    Object localObject = (Preference)this.Wsc.get(this.Wse.get(paramInt));
    localObject = (Integer)this.Wsf.get(e((Preference)localObject));
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
    if (this.Wsh != null)
    {
      if (this.Wsh.abE(paramInt))
      {
        paramView = this.Wsh.getView(paramInt, paramView, paramViewGroup);
        AppMethodBeat.o(142613);
        return paramView;
      }
      i = this.Wsh.abF(paramInt);
    }
    if (i > this.Wse.size())
    {
      AppMethodBeat.o(142613);
      return paramView;
    }
    Object localObject = (Preference)this.Wsc.get(this.Wse.get(i));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).a(this.WqI);
    }
    if (!this.Wsf.containsKey(e((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).c(paramView, paramViewGroup);
    paramInt = this.Wsi[i];
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
      i = a.f.settings_line;
      int j = paramView.getPaddingLeft();
      int k = paramView.getPaddingRight();
      int m = paramView.getPaddingTop();
      int n = paramView.getPaddingBottom();
      if ((paramInt & 0x2) != 0)
      {
        i1 = paramViewGroup.getPaddingLeft();
        paramViewGroup.setBackground(aw.bf(this.context, a.c.list_item_divider));
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
        break label406;
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
      localView.setBackground(aw.bf(this.context, a.c.list_item_divider));
      localView.setPadding(0, i1, 0, i2);
      if ((paramViewGroup == null) || (paramViewGroup.getBackground() == null)) {
        break;
      }
      paramViewGroup.setBackground(null);
      break;
      label406:
      ((View)localObject).setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    AppMethodBeat.i(142611);
    if (!this.Wsk) {
      this.Wsk = true;
    }
    int i = Math.max(1, this.Wsf.size());
    AppMethodBeat.o(142611);
    return i;
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(142607);
    if (ar.hIH())
    {
      int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vSp, 1);
      Log.d("MicroMsg.MMPreferenceAdapter", "isHWMagicMMPreferenceNotifySwt() swt:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1) {
        i = 1;
      }
      while (i != 0)
      {
        Log.d("MicroMsg.MMPreferenceAdapter", "MMPreferenceAdapter notifyDataSetChanged %s %s %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.Wsm) });
        long l = System.currentTimeMillis();
        if ((this.Wsm != 0L) && (l - this.Wsm > 5000L) && (l - this.Wsl < 1000L))
        {
          boolean bool = this.mHandler.hasMessages(1);
          Log.i("MicroMsg.MMPreferenceAdapter", "ignore notifyDataSetChanged(%s %s), had:%s", new Object[] { Long.valueOf(this.Wsl), Long.valueOf(l), Boolean.valueOf(bool) });
          if (!bool) {
            this.mHandler.sendEmptyMessageDelayed(1, 1000L);
          }
          AppMethodBeat.o(142607);
          return;
          i = 0;
        }
        else
        {
          hKR();
          this.Wsl = l;
          AppMethodBeat.o(142607);
          return;
        }
      }
    }
    hKR();
    AppMethodBeat.o(142607);
  }
  
  public final void removeAll()
  {
    AppMethodBeat.i(142604);
    this.Wse.clear();
    this.Wsc.clear();
    this.Wsb.clear();
    this.Wsd.clear();
    notifyDataSetChanged();
    AppMethodBeat.o(142604);
  }
  
  public static abstract interface a
  {
    public abstract int abD(int paramInt);
    
    public abstract boolean abE(int paramInt);
    
    public abstract int abF(int paramInt);
    
    public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.h
 * JD-Core Version:    0.7.0.1
 */
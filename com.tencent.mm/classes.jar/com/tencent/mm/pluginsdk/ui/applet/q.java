package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class q
{
  ContactListExpandPreference.a AHo;
  private String EVX;
  private HashMap<String, Preference> EVY;
  private boolean EVZ;
  private boolean EWa;
  private boolean EWb;
  public r EWc;
  s.b EWd;
  private View.OnClickListener EWe;
  private View.OnClickListener EWf;
  private View.OnClickListener EWg;
  private s.b EWh;
  private s.a EWi;
  private r.a EWj;
  private Context context;
  private View jfs;
  public View.OnClickListener km;
  private View oaY;
  f screen;
  String username;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(152183);
    this.EVY = new HashMap();
    this.EVZ = false;
    if (this.EVZ) {
      bool = true;
    }
    this.EWa = bool;
    this.EWd = null;
    this.km = null;
    this.AHo = null;
    this.EWg = new q.1(this);
    this.EWh = new s.b()
    {
      public final boolean le(int paramAnonymousInt)
      {
        AppMethodBeat.i(152180);
        if ((!q.this.EWc.EWu) || (!q.this.EWc.YW(paramAnonymousInt)))
        {
          AppMethodBeat.o(152180);
          return true;
        }
        if (!q.this.EWc.YU(paramAnonymousInt)) {
          ad.d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
        }
        AppMethodBeat.o(152180);
        return true;
      }
    };
    this.EWi = new s.a()
    {
      public final void n(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        int j = 1;
        AppMethodBeat.i(214479);
        if ((q.this.AHo != null) && (q.this.EWc != null))
        {
          r localr = q.this.EWc;
          if (localr.EWu) {
            if ((!localr.fRb) && (paramAnonymousInt == localr.EWs + 2))
            {
              i = 1;
              if (i != 0) {
                break label408;
              }
              localr = q.this.EWc;
              if ((localr.fRb) || (paramAnonymousInt != localr.EWs)) {
                break label168;
              }
            }
          }
          label168:
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label173;
            }
            if (!q.this.EWc.EWv) {
              break label408;
            }
            q.this.AHo.ld(paramAnonymousInt);
            AppMethodBeat.o(214479);
            return;
            i = 0;
            break;
            if ((!localr.fRb) && (paramAnonymousInt == localr.EWs + 1))
            {
              i = 1;
              break;
            }
            i = 0;
            break;
          }
          label173:
          localr = q.this.EWc;
          if ((!localr.fRb) && (paramAnonymousInt == localr.EWs + 1)) {
            i = j;
          }
          while (i != 0)
          {
            if (!q.this.EWc.EWu) {
              break label408;
            }
            if (w.vF(q.this.username))
            {
              q.this.AHo.lc(paramAnonymousInt);
              AppMethodBeat.o(214479);
              return;
              i = 0;
            }
            else
            {
              q.this.EWc.YU(0);
              AppMethodBeat.o(214479);
              return;
            }
          }
          if ((q.this.EWc.fRb) && (q.this.EWc.YW(paramAnonymousInt)))
          {
            q.this.AHo.lc(paramAnonymousInt);
            AppMethodBeat.o(214479);
            return;
          }
          if ((q.this.EWc.fRb) && (!q.this.EWc.YW(paramAnonymousInt)))
          {
            q.this.AHo.YJ();
            AppMethodBeat.o(214479);
            return;
          }
          if ((!q.this.EWc.fRb) && (q.this.EWc.YW(paramAnonymousInt))) {
            q.this.AHo.e(paramAnonymousViewGroup, paramAnonymousInt);
          }
        }
        label408:
        AppMethodBeat.o(214479);
      }
    };
    this.EWj = new r.a()
    {
      public final void cdp()
      {
        AppMethodBeat.i(152182);
        if (q.this.screen != null) {
          q.this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(152182);
      }
    };
    this.context = paramContext;
    this.EWc = new r(this.context);
    this.EWc.EWm = this.EWj;
    AppMethodBeat.o(152183);
  }
  
  private void YS(int paramInt)
  {
    AppMethodBeat.i(152188);
    int k = 0;
    if (this.jfs != null) {
      k = 1;
    }
    Object localObject1;
    if (this.oaY != null) {
      if (this.EVZ)
      {
        localObject1 = this.EWc;
        if (((r)localObject1).EWr <= ((r)localObject1).EWz) {
          break label450;
        }
        i = 1;
        if (i == 0) {
          break label759;
        }
      }
    }
    label162:
    label175:
    label201:
    label465:
    label474:
    label485:
    label756:
    label759:
    for (int i = 1;; i = 0)
    {
      int j = paramInt;
      if (k != 0)
      {
        localObject1 = new ContactListCustomPreference(this.context);
        ((ContactListCustomPreference)localObject1).setKey(YT(-1));
        ((ContactListCustomPreference)localObject1).setCustomView(this.jfs);
        ((ContactListCustomPreference)localObject1).background = 2131231818;
        ((ContactListCustomPreference)localObject1).km = this.EWe;
        this.screen.a((Preference)localObject1, paramInt);
        this.EVY.put(((Preference)localObject1).mKey, localObject1);
        j = paramInt + 1;
      }
      View.OnClickListener localOnClickListener;
      boolean bool1;
      boolean bool2;
      if (this.EWd != null)
      {
        localObject1 = this.EWd;
        if (this.km == null) {
          break label465;
        }
        localOnClickListener = this.km;
        if ((this.EWc.fLO == null) || (!this.EWc.fLO.YH())) {
          break label474;
        }
        bool1 = true;
        bool2 = this.EWc.fcF();
        if (!this.EWc.ruj) {
          break label756;
        }
        bool1 = this.EWc.EWo;
      }
      for (;;)
      {
        int i1 = this.EWc.EWs;
        if ((!bool2) || (bool1)) {}
        int m;
        Object localObject2;
        Object localObject3;
        for (paramInt = 2;; paramInt = 1)
        {
          m = 0;
          localObject2 = this.EWc;
          localObject3 = this.context;
          if (localObject3 != null) {
            break label485;
          }
          k = 0;
          n = 0;
          while ((n < this.EWc.getCount()) && (n < i1 + paramInt))
          {
            localObject2 = new ContactListExpandPreference(this.context, 1);
            ((ContactListExpandPreference)localObject2).setKey(YT(m));
            localObject3 = ((ContactListExpandPreference)localObject2).EWN;
            ((s)localObject3).EWc = this.EWc;
            ((s)localObject3).row = m;
            ((s)localObject3).index = n;
            ((ContactListExpandPreference)localObject2).EWN.EWO = k;
            ((ContactListExpandPreference)localObject2).EWN.fMM = bool1;
            ((ContactListExpandPreference)localObject2).EWN.km = localOnClickListener;
            ((ContactListExpandPreference)localObject2).EWN.EWi = this.EWi;
            ((ContactListExpandPreference)localObject2).EWN.EWP = ((s.b)localObject1);
            this.screen.a((Preference)localObject2, j + m);
            this.EVY.put(((Preference)localObject2).mKey, localObject2);
            n += k;
            m += 1;
          }
          i = 0;
          break;
          localObject1 = this.EWh;
          break label162;
          localOnClickListener = this.EWg;
          break label175;
          bool1 = false;
          break label201;
        }
        Display localDisplay = ((WindowManager)((Context)localObject3).getSystemService("window")).getDefaultDisplay();
        k = localDisplay.getWidth();
        int n = localDisplay.getHeight();
        float f2;
        if ((k / (((Context)localObject3).getResources().getDimension(2131165510) + ((Context)localObject3).getResources().getDimension(2131165500) * 2.0F) >= 5.0F) && (n > k))
        {
          ((r)localObject2).EWF = true;
          f2 = ((Context)localObject3).getResources().getDimension(2131165500);
          if (!((r)localObject2).EWF) {
            break label658;
          }
        }
        for (float f1 = ((Context)localObject3).getResources().getDimension(2131165510);; f1 = ((Context)localObject3).getResources().getDimension(2131165508))
        {
          n = k / (int)(f1 + 2.0F * f2);
          ad.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(n) });
          r.EWl = n;
          k = n;
          if (n != 4) {
            break;
          }
          r.MAX_COUNT = 43;
          k = n;
          break;
          ((r)localObject2).EWF = false;
          break label562;
        }
        if (i != 0)
        {
          localObject1 = new ContactListCustomPreference(this.context);
          ((ContactListCustomPreference)localObject1).setKey(YT(-2));
          ((ContactListCustomPreference)localObject1).setCustomView(this.oaY);
          ((ContactListCustomPreference)localObject1).km = this.EWf;
          this.screen.a((Preference)localObject1, j + m);
          this.EVY.put(((Preference)localObject1).mKey, localObject1);
        }
        AppMethodBeat.o(152188);
        return;
      }
    }
  }
  
  private static String YT(int paramInt)
  {
    AppMethodBeat.i(152190);
    if (paramInt >= 0)
    {
      str = "pref_contact_list_row_".concat(String.valueOf(paramInt));
      AppMethodBeat.o(152190);
      return str;
    }
    String str = "unkown";
    if (paramInt == -1) {
      str = "header";
    }
    for (;;)
    {
      str = "pref_contact_list_row_".concat(String.valueOf(str));
      AppMethodBeat.o(152190);
      return str;
      if (paramInt == -2) {
        str = "footer";
      }
    }
  }
  
  private void aoL(String paramString)
  {
    AppMethodBeat.i(152186);
    this.EWc.setUsername(paramString);
    this.EWc.EWy = this.EWa;
    this.EWc.Zd();
    bDh();
    AppMethodBeat.o(152186);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(152189);
    Iterator localIterator = this.EVY.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.screen.aVE(str);
    }
    this.EVY.clear();
    AppMethodBeat.o(152189);
  }
  
  public final void A(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152184);
    this.username = paramString;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList(0);
    }
    this.EWc.fS((List)localObject);
    aoL(paramString);
    AppMethodBeat.o(152184);
  }
  
  public final void a(f paramf, String paramString)
  {
    AppMethodBeat.i(152187);
    if ((paramf == null) || (paramString == null))
    {
      AppMethodBeat.o(152187);
      return;
    }
    this.screen = paramf;
    this.EVX = paramString;
    paramf.cP(paramString, true);
    AppMethodBeat.o(152187);
  }
  
  public final void aN(ArrayList<am> paramArrayList)
  {
    AppMethodBeat.i(152185);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList(0);
    }
    this.EWc.aO((ArrayList)localObject);
    aoL(null);
    AppMethodBeat.o(152185);
  }
  
  public final void bDh()
  {
    AppMethodBeat.i(152191);
    if ((this.screen == null) || (this.EVX == null))
    {
      AppMethodBeat.o(152191);
      return;
    }
    removeAll();
    YS(this.screen.indexOf(this.EVX));
    vN(this.EWb);
    AppMethodBeat.o(152191);
  }
  
  public final void fcD()
  {
    boolean bool = false;
    this.EVZ = false;
    if (this.EVZ) {
      bool = true;
    }
    this.EWa = bool;
  }
  
  public final void vN(boolean paramBoolean)
  {
    AppMethodBeat.i(214480);
    this.EWb = paramBoolean;
    Iterator localIterator = this.EVY.values().iterator();
    while (localIterator.hasNext())
    {
      Preference localPreference = (Preference)localIterator.next();
      if ((localPreference instanceof ContactListExpandPreference)) {
        ((ContactListExpandPreference)localPreference).vN(paramBoolean);
      }
    }
    AppMethodBeat.o(214480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.q
 * JD-Core Version:    0.7.0.1
 */
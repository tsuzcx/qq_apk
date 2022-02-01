package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
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
  ContactListExpandPreference.a AYR;
  private View.OnClickListener FoA;
  private View.OnClickListener FoB;
  private s.b FoC;
  private s.a FoD;
  private r.a FoE;
  private String Fos;
  private HashMap<String, Preference> Fot;
  private boolean Fou;
  private boolean Fov;
  private boolean Fow;
  public r Fox;
  s.b Foy;
  private View.OnClickListener Foz;
  private Context context;
  private View jil;
  public View.OnClickListener km;
  private View ogP;
  f screen;
  String username;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(152183);
    this.Fot = new HashMap();
    this.Fou = false;
    if (this.Fou) {
      bool = true;
    }
    this.Fov = bool;
    this.Foy = null;
    this.km = null;
    this.AYR = null;
    this.FoB = new q.1(this);
    this.FoC = new s.b()
    {
      public final boolean lg(int paramAnonymousInt)
      {
        AppMethodBeat.i(152180);
        if ((!q.this.Fox.FoP) || (!q.this.Fox.ZC(paramAnonymousInt)))
        {
          AppMethodBeat.o(152180);
          return true;
        }
        if (!q.this.Fox.ZA(paramAnonymousInt)) {
          ae.d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
        }
        AppMethodBeat.o(152180);
        return true;
      }
    };
    this.FoD = new s.a()
    {
      public final void n(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        int j = 1;
        AppMethodBeat.i(217890);
        if ((q.this.AYR != null) && (q.this.Fox != null))
        {
          r localr = q.this.Fox;
          if (localr.FoP) {
            if ((!localr.fTh) && (paramAnonymousInt == localr.FoN + 2))
            {
              i = 1;
              if (i != 0) {
                break label408;
              }
              localr = q.this.Fox;
              if ((localr.fTh) || (paramAnonymousInt != localr.FoN)) {
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
            if (!q.this.Fox.FoQ) {
              break label408;
            }
            q.this.AYR.lf(paramAnonymousInt);
            AppMethodBeat.o(217890);
            return;
            i = 0;
            break;
            if ((!localr.fTh) && (paramAnonymousInt == localr.FoN + 1))
            {
              i = 1;
              break;
            }
            i = 0;
            break;
          }
          label173:
          localr = q.this.Fox;
          if ((!localr.fTh) && (paramAnonymousInt == localr.FoN + 1)) {
            i = j;
          }
          while (i != 0)
          {
            if (!q.this.Fox.FoP) {
              break label408;
            }
            if (x.wb(q.this.username))
            {
              q.this.AYR.le(paramAnonymousInt);
              AppMethodBeat.o(217890);
              return;
              i = 0;
            }
            else
            {
              q.this.Fox.ZA(0);
              AppMethodBeat.o(217890);
              return;
            }
          }
          if ((q.this.Fox.fTh) && (q.this.Fox.ZC(paramAnonymousInt)))
          {
            q.this.AYR.le(paramAnonymousInt);
            AppMethodBeat.o(217890);
            return;
          }
          if ((q.this.Fox.fTh) && (!q.this.Fox.ZC(paramAnonymousInt)))
          {
            q.this.AYR.YS();
            AppMethodBeat.o(217890);
            return;
          }
          if ((!q.this.Fox.fTh) && (q.this.Fox.ZC(paramAnonymousInt))) {
            q.this.AYR.e(paramAnonymousViewGroup, paramAnonymousInt);
          }
        }
        label408:
        AppMethodBeat.o(217890);
      }
    };
    this.FoE = new r.a()
    {
      public final void ceE()
      {
        AppMethodBeat.i(152182);
        if (q.this.screen != null) {
          q.this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(152182);
      }
    };
    this.context = paramContext;
    this.Fox = new r(this.context);
    this.Fox.FoH = this.FoE;
    AppMethodBeat.o(152183);
  }
  
  private void Zy(int paramInt)
  {
    AppMethodBeat.i(152188);
    int k = 0;
    if (this.jil != null) {
      k = 1;
    }
    Object localObject1;
    if (this.ogP != null) {
      if (this.Fou)
      {
        localObject1 = this.Fox;
        if (((r)localObject1).FoM <= ((r)localObject1).FoU) {
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
        ((ContactListCustomPreference)localObject1).setKey(Zz(-1));
        ((ContactListCustomPreference)localObject1).setCustomView(this.jil);
        ((ContactListCustomPreference)localObject1).background = 2131231818;
        ((ContactListCustomPreference)localObject1).km = this.Foz;
        this.screen.a((Preference)localObject1, paramInt);
        this.Fot.put(((Preference)localObject1).mKey, localObject1);
        j = paramInt + 1;
      }
      View.OnClickListener localOnClickListener;
      boolean bool1;
      boolean bool2;
      if (this.Foy != null)
      {
        localObject1 = this.Foy;
        if (this.km == null) {
          break label465;
        }
        localOnClickListener = this.km;
        if ((this.Fox.fNS == null) || (!this.Fox.fNS.YQ())) {
          break label474;
        }
        bool1 = true;
        bool2 = this.Fox.fgt();
        if (!this.Fox.rCv) {
          break label756;
        }
        bool1 = this.Fox.FoJ;
      }
      for (;;)
      {
        int i1 = this.Fox.FoN;
        if ((!bool2) || (bool1)) {}
        int m;
        Object localObject2;
        Object localObject3;
        for (paramInt = 2;; paramInt = 1)
        {
          m = 0;
          localObject2 = this.Fox;
          localObject3 = this.context;
          if (localObject3 != null) {
            break label485;
          }
          k = 0;
          n = 0;
          while ((n < this.Fox.getCount()) && (n < i1 + paramInt))
          {
            localObject2 = new ContactListExpandPreference(this.context, 1);
            ((ContactListExpandPreference)localObject2).setKey(Zz(m));
            localObject3 = ((ContactListExpandPreference)localObject2).Fpi;
            ((s)localObject3).Fox = this.Fox;
            ((s)localObject3).row = m;
            ((s)localObject3).index = n;
            ((ContactListExpandPreference)localObject2).Fpi.Fpj = k;
            ((ContactListExpandPreference)localObject2).Fpi.fOU = bool1;
            ((ContactListExpandPreference)localObject2).Fpi.km = localOnClickListener;
            ((ContactListExpandPreference)localObject2).Fpi.FoD = this.FoD;
            ((ContactListExpandPreference)localObject2).Fpi.Fpk = ((s.b)localObject1);
            this.screen.a((Preference)localObject2, j + m);
            this.Fot.put(((Preference)localObject2).mKey, localObject2);
            n += k;
            m += 1;
          }
          i = 0;
          break;
          localObject1 = this.FoC;
          break label162;
          localOnClickListener = this.FoB;
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
          ((r)localObject2).Fpa = true;
          f2 = ((Context)localObject3).getResources().getDimension(2131165500);
          if (!((r)localObject2).Fpa) {
            break label658;
          }
        }
        for (float f1 = ((Context)localObject3).getResources().getDimension(2131165510);; f1 = ((Context)localObject3).getResources().getDimension(2131165508))
        {
          n = k / (int)(f1 + 2.0F * f2);
          ae.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(n) });
          r.FoG = n;
          k = n;
          if (n != 4) {
            break;
          }
          r.MAX_COUNT = 43;
          k = n;
          break;
          ((r)localObject2).Fpa = false;
          break label562;
        }
        if (i != 0)
        {
          localObject1 = new ContactListCustomPreference(this.context);
          ((ContactListCustomPreference)localObject1).setKey(Zz(-2));
          ((ContactListCustomPreference)localObject1).setCustomView(this.ogP);
          ((ContactListCustomPreference)localObject1).km = this.FoA;
          this.screen.a((Preference)localObject1, j + m);
          this.Fot.put(((Preference)localObject1).mKey, localObject1);
        }
        AppMethodBeat.o(152188);
        return;
      }
    }
  }
  
  private static String Zz(int paramInt)
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
  
  private void apQ(String paramString)
  {
    AppMethodBeat.i(152186);
    this.Fox.setUsername(paramString);
    this.Fox.FoT = this.Fov;
    this.Fox.Zm();
    bDZ();
    AppMethodBeat.o(152186);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(152189);
    Iterator localIterator = this.Fot.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.screen.aXf(str);
    }
    this.Fot.clear();
    AppMethodBeat.o(152189);
  }
  
  public final void B(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152184);
    this.username = paramString;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList(0);
    }
    this.Fox.gb((List)localObject);
    apQ(paramString);
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
    this.Fos = paramString;
    paramf.cT(paramString, true);
    AppMethodBeat.o(152187);
  }
  
  public final void aO(ArrayList<an> paramArrayList)
  {
    AppMethodBeat.i(152185);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList(0);
    }
    this.Fox.aP((ArrayList)localObject);
    apQ(null);
    AppMethodBeat.o(152185);
  }
  
  public final void bDZ()
  {
    AppMethodBeat.i(152191);
    if ((this.screen == null) || (this.Fos == null))
    {
      AppMethodBeat.o(152191);
      return;
    }
    removeAll();
    Zy(this.screen.indexOf(this.Fos));
    vV(this.Fow);
    AppMethodBeat.o(152191);
  }
  
  public final void fgr()
  {
    boolean bool = false;
    this.Fou = false;
    if (this.Fou) {
      bool = true;
    }
    this.Fov = bool;
  }
  
  public final void vV(boolean paramBoolean)
  {
    AppMethodBeat.i(217891);
    this.Fow = paramBoolean;
    Iterator localIterator = this.Fot.values().iterator();
    while (localIterator.hasNext())
    {
      Preference localPreference = (Preference)localIterator.next();
      if ((localPreference instanceof ContactListExpandPreference)) {
        ((ContactListExpandPreference)localPreference).vV(paramBoolean);
      }
    }
    AppMethodBeat.o(217891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.q
 * JD-Core Version:    0.7.0.1
 */
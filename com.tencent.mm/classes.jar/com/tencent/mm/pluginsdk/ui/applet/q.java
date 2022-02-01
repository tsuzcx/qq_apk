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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class q
{
  private String DqU;
  private HashMap<String, Preference> DqV;
  private boolean DqW;
  private boolean DqX;
  public r DqY;
  s.b DqZ;
  private View.OnClickListener Dra;
  private View.OnClickListener Drb;
  private View.OnClickListener Drc;
  private s.b Drd;
  private s.a Dre;
  private r.a Drf;
  private Context context;
  private View iMi;
  public View.OnClickListener iu;
  private View nzT;
  f screen;
  String username;
  ContactListExpandPreference.a zpu;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(152183);
    this.DqV = new HashMap();
    this.DqW = false;
    if (this.DqW) {
      bool = true;
    }
    this.DqX = bool;
    this.DqZ = null;
    this.iu = null;
    this.zpu = null;
    this.Drc = new q.1(this);
    this.Drd = new s.b()
    {
      public final boolean kF(int paramAnonymousInt)
      {
        AppMethodBeat.i(152180);
        if ((!q.this.DqY.Drq) || (!q.this.DqY.Xa(paramAnonymousInt)))
        {
          AppMethodBeat.o(152180);
          return true;
        }
        if (!q.this.DqY.WY(paramAnonymousInt)) {
          ac.d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
        }
        AppMethodBeat.o(152180);
        return true;
      }
    };
    this.Dre = new s.a()
    {
      public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        int j = 1;
        AppMethodBeat.i(192695);
        if ((q.this.zpu != null) && (q.this.DqY != null))
        {
          r localr = q.this.DqY;
          if (localr.Drq) {
            if ((!localr.fxO) && (paramAnonymousInt == localr.Dro + 2)) {
              i = 1;
            }
          }
          while (i != 0)
          {
            q.this.zpu.d(paramAnonymousViewGroup, paramAnonymousView);
            AppMethodBeat.o(192695);
            return;
            i = 0;
            continue;
            if ((!localr.fxO) && (paramAnonymousInt == localr.Dro + 1)) {
              i = 1;
            } else {
              i = 0;
            }
          }
          localr = q.this.DqY;
          if ((!localr.fxO) && (paramAnonymousInt == localr.Dro)) {}
          for (int i = 1; i != 0; i = 0)
          {
            if (!q.this.DqY.Drr) {
              break label448;
            }
            q.this.zpu.c(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousInt);
            AppMethodBeat.o(192695);
            return;
          }
          localr = q.this.DqY;
          if ((!localr.fxO) && (paramAnonymousInt == localr.Dro + 1)) {
            i = j;
          }
          while (i != 0)
          {
            if (!q.this.DqY.Drq) {
              break label448;
            }
            if (w.sQ(q.this.username))
            {
              q.this.zpu.a(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousInt);
              AppMethodBeat.o(192695);
              return;
              i = 0;
            }
            else
            {
              q.this.DqY.WY(0);
              AppMethodBeat.o(192695);
              return;
            }
          }
          if ((q.this.DqY.fxO) && (q.this.DqY.Xa(paramAnonymousInt)))
          {
            q.this.zpu.a(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousInt);
            AppMethodBeat.o(192695);
            return;
          }
          if ((q.this.DqY.fxO) && (!q.this.DqY.Xa(paramAnonymousInt)))
          {
            q.this.zpu.e(paramAnonymousViewGroup, paramAnonymousView);
            AppMethodBeat.o(192695);
            return;
          }
          if ((!q.this.DqY.fxO) && (q.this.DqY.Xa(paramAnonymousInt))) {
            q.this.zpu.b(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousInt);
          }
        }
        label448:
        AppMethodBeat.o(192695);
      }
    };
    this.Drf = new r.a()
    {
      public final void bYL()
      {
        AppMethodBeat.i(152182);
        if (q.this.screen != null) {
          q.this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(152182);
      }
    };
    this.context = paramContext;
    this.DqY = new r(this.context);
    this.DqY.Dri = this.Drf;
    AppMethodBeat.o(152183);
  }
  
  private void WW(int paramInt)
  {
    AppMethodBeat.i(152188);
    int k = 0;
    if (this.iMi != null) {
      k = 1;
    }
    Object localObject1;
    if (this.nzT != null) {
      if (this.DqW)
      {
        localObject1 = this.DqY;
        if (((r)localObject1).Drn <= ((r)localObject1).Drv) {
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
        ((ContactListCustomPreference)localObject1).setKey(WX(-1));
        ((ContactListCustomPreference)localObject1).setCustomView(this.iMi);
        ((ContactListCustomPreference)localObject1).background = 2131231818;
        ((ContactListCustomPreference)localObject1).iu = this.Dra;
        this.screen.a((Preference)localObject1, paramInt);
        this.DqV.put(((Preference)localObject1).mKey, localObject1);
        j = paramInt + 1;
      }
      View.OnClickListener localOnClickListener;
      boolean bool1;
      boolean bool2;
      if (this.DqZ != null)
      {
        localObject1 = this.DqZ;
        if (this.iu == null) {
          break label465;
        }
        localOnClickListener = this.iu;
        if ((this.DqY.ftP == null) || (!this.DqY.ftP.Wp())) {
          break label474;
        }
        bool1 = true;
        bool2 = this.DqY.eNG();
        if (!this.DqY.qKh) {
          break label756;
        }
        bool1 = this.DqY.Drk;
      }
      for (;;)
      {
        int i1 = this.DqY.Dro;
        if ((!bool2) || (bool1)) {}
        int m;
        Object localObject2;
        Object localObject3;
        for (paramInt = 2;; paramInt = 1)
        {
          m = 0;
          localObject2 = this.DqY;
          localObject3 = this.context;
          if (localObject3 != null) {
            break label485;
          }
          k = 0;
          n = 0;
          while ((n < this.DqY.getCount()) && (n < i1 + paramInt))
          {
            localObject2 = new ContactListExpandPreference(this.context, 1);
            ((ContactListExpandPreference)localObject2).setKey(WX(m));
            localObject3 = ((ContactListExpandPreference)localObject2).DrJ;
            ((s)localObject3).DqY = this.DqY;
            ((s)localObject3).row = m;
            ((s)localObject3).index = n;
            ((ContactListExpandPreference)localObject2).DrJ.DrK = k;
            ((ContactListExpandPreference)localObject2).DrJ.ftK = bool1;
            ((ContactListExpandPreference)localObject2).DrJ.iu = localOnClickListener;
            ((ContactListExpandPreference)localObject2).DrJ.Dre = this.Dre;
            ((ContactListExpandPreference)localObject2).DrJ.DrL = ((s.b)localObject1);
            this.screen.a((Preference)localObject2, j + m);
            this.DqV.put(((Preference)localObject2).mKey, localObject2);
            n += k;
            m += 1;
          }
          i = 0;
          break;
          localObject1 = this.Drd;
          break label162;
          localOnClickListener = this.Drc;
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
          ((r)localObject2).DrB = true;
          f2 = ((Context)localObject3).getResources().getDimension(2131165500);
          if (!((r)localObject2).DrB) {
            break label658;
          }
        }
        for (float f1 = ((Context)localObject3).getResources().getDimension(2131165510);; f1 = ((Context)localObject3).getResources().getDimension(2131165508))
        {
          n = k / (int)(f1 + 2.0F * f2);
          ac.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(n) });
          r.Drh = n;
          k = n;
          if (n != 4) {
            break;
          }
          r.MAX_COUNT = 43;
          k = n;
          break;
          ((r)localObject2).DrB = false;
          break label562;
        }
        if (i != 0)
        {
          localObject1 = new ContactListCustomPreference(this.context);
          ((ContactListCustomPreference)localObject1).setKey(WX(-2));
          ((ContactListCustomPreference)localObject1).setCustomView(this.nzT);
          ((ContactListCustomPreference)localObject1).iu = this.Drb;
          this.screen.a((Preference)localObject1, j + m);
          this.DqV.put(((Preference)localObject1).mKey, localObject1);
        }
        AppMethodBeat.o(152188);
        return;
      }
    }
  }
  
  private static String WX(int paramInt)
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
  
  private void ajY(String paramString)
  {
    AppMethodBeat.i(152186);
    this.DqY.setUsername(paramString);
    this.DqY.Dru = this.DqX;
    this.DqY.WJ();
    bzd();
    AppMethodBeat.o(152186);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(152189);
    Iterator localIterator = this.DqV.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.screen.aPO(str);
    }
    this.DqV.clear();
    AppMethodBeat.o(152189);
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
    this.DqU = paramString;
    paramf.cK(paramString, true);
    AppMethodBeat.o(152187);
  }
  
  public final void aQ(ArrayList<ai> paramArrayList)
  {
    AppMethodBeat.i(152185);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList(0);
    }
    this.DqY.aR((ArrayList)localObject);
    ajY(null);
    AppMethodBeat.o(152185);
  }
  
  public final void bzd()
  {
    AppMethodBeat.i(152191);
    if ((this.screen == null) || (this.DqU == null))
    {
      AppMethodBeat.o(152191);
      return;
    }
    removeAll();
    WW(this.screen.indexOf(this.DqU));
    AppMethodBeat.o(152191);
  }
  
  public final void eNE()
  {
    boolean bool = false;
    this.DqW = false;
    if (this.DqW) {
      bool = true;
    }
    this.DqX = bool;
  }
  
  public final void y(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152184);
    this.username = paramString;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList(0);
    }
    this.DqY.fH((List)localObject);
    ajY(paramString);
    AppMethodBeat.o(152184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.q
 * JD-Core Version:    0.7.0.1
 */
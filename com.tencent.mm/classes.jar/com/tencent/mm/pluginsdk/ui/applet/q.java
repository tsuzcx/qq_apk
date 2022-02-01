package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class q
{
  private String BYD;
  private HashMap<String, Preference> BYE;
  private boolean BYF;
  private boolean BYG;
  public r BYH;
  s.b BYI;
  private View.OnClickListener BYJ;
  private View.OnClickListener BYK;
  private View.OnClickListener BYL;
  private s.b BYM;
  private s.a BYN;
  private r.a BYO;
  private Context context;
  public View.OnClickListener hs;
  private View imc;
  private View mXu;
  f screen;
  String username;
  ContactListExpandPreference.a ycu;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(152183);
    this.BYE = new HashMap();
    this.BYF = false;
    if (this.BYF) {
      bool = true;
    }
    this.BYG = bool;
    this.BYI = null;
    this.hs = null;
    this.ycu = null;
    this.BYL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152179);
        ad.d("MicroMsg.ContactListArchor", "OnClickListener = onClick ");
        AppMethodBeat.o(152179);
      }
    };
    this.BYM = new s.b()
    {
      public final boolean kL(int paramAnonymousInt)
      {
        AppMethodBeat.i(152180);
        if ((!q.this.BYH.BYZ) || (!q.this.BYH.UR(paramAnonymousInt)))
        {
          AppMethodBeat.o(152180);
          return true;
        }
        if (!q.this.BYH.UP(paramAnonymousInt)) {
          ad.d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
        }
        AppMethodBeat.o(152180);
        return true;
      }
    };
    this.BYN = new s.a()
    {
      public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        int j = 1;
        AppMethodBeat.i(203576);
        if ((q.this.ycu != null) && (q.this.BYH != null))
        {
          r localr = q.this.BYH;
          if (localr.BYZ) {
            if ((!localr.fuh) && (paramAnonymousInt == localr.BYX + 2)) {
              i = 1;
            }
          }
          while (i != 0)
          {
            q.this.ycu.d(paramAnonymousViewGroup, paramAnonymousView);
            AppMethodBeat.o(203576);
            return;
            i = 0;
            continue;
            if ((!localr.fuh) && (paramAnonymousInt == localr.BYX + 1)) {
              i = 1;
            } else {
              i = 0;
            }
          }
          localr = q.this.BYH;
          if ((!localr.fuh) && (paramAnonymousInt == localr.BYX)) {}
          for (int i = 1; i != 0; i = 0)
          {
            if (!q.this.BYH.BZa) {
              break label448;
            }
            q.this.ycu.d(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousInt);
            AppMethodBeat.o(203576);
            return;
          }
          localr = q.this.BYH;
          if ((!localr.fuh) && (paramAnonymousInt == localr.BYX + 1)) {
            i = j;
          }
          while (i != 0)
          {
            if (!q.this.BYH.BYZ) {
              break label448;
            }
            if (com.tencent.mm.model.w.pF(q.this.username))
            {
              q.this.ycu.b(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousInt);
              AppMethodBeat.o(203576);
              return;
              i = 0;
            }
            else
            {
              q.this.BYH.UP(0);
              AppMethodBeat.o(203576);
              return;
            }
          }
          if ((q.this.BYH.fuh) && (q.this.BYH.UR(paramAnonymousInt)))
          {
            q.this.ycu.b(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousInt);
            AppMethodBeat.o(203576);
            return;
          }
          if ((q.this.BYH.fuh) && (!q.this.BYH.UR(paramAnonymousInt)))
          {
            q.this.ycu.e(paramAnonymousViewGroup, paramAnonymousView);
            AppMethodBeat.o(203576);
            return;
          }
          if ((!q.this.BYH.fuh) && (q.this.BYH.UR(paramAnonymousInt))) {
            q.this.ycu.c(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousInt);
          }
        }
        label448:
        AppMethodBeat.o(203576);
      }
    };
    this.BYO = new r.a()
    {
      public final void bRw()
      {
        AppMethodBeat.i(152182);
        if (q.this.screen != null) {
          q.this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(152182);
      }
    };
    this.context = paramContext;
    this.BYH = new r(this.context);
    this.BYH.BYR = this.BYO;
    AppMethodBeat.o(152183);
  }
  
  private void UM(int paramInt)
  {
    AppMethodBeat.i(152188);
    int k = 0;
    if (this.imc != null) {
      k = 1;
    }
    Object localObject1;
    if (this.mXu != null) {
      if (this.BYF)
      {
        localObject1 = this.BYH;
        if (((r)localObject1).BYW <= ((r)localObject1).BZe) {
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
        ((ContactListCustomPreference)localObject1).setKey(UN(-1));
        ((ContactListCustomPreference)localObject1).setCustomView(this.imc);
        ((ContactListCustomPreference)localObject1).background = 2131231818;
        ((ContactListCustomPreference)localObject1).hs = this.BYJ;
        this.screen.a((Preference)localObject1, paramInt);
        this.BYE.put(((Preference)localObject1).mKey, localObject1);
        j = paramInt + 1;
      }
      View.OnClickListener localOnClickListener;
      boolean bool1;
      boolean bool2;
      if (this.BYI != null)
      {
        localObject1 = this.BYI;
        if (this.hs == null) {
          break label465;
        }
        localOnClickListener = this.hs;
        if ((this.BYH.fql == null) || (!this.BYH.fql.Vq())) {
          break label474;
        }
        bool1 = true;
        bool2 = this.BYH.eym();
        if (!this.BYH.qbB) {
          break label756;
        }
        bool1 = this.BYH.BYT;
      }
      for (;;)
      {
        int i1 = this.BYH.BYX;
        if ((!bool2) || (bool1)) {}
        int m;
        Object localObject2;
        Object localObject3;
        for (paramInt = 2;; paramInt = 1)
        {
          m = 0;
          localObject2 = this.BYH;
          localObject3 = this.context;
          if (localObject3 != null) {
            break label485;
          }
          k = 0;
          n = 0;
          while ((n < this.BYH.getCount()) && (n < i1 + paramInt))
          {
            localObject2 = new ContactListExpandPreference(this.context, 1);
            ((ContactListExpandPreference)localObject2).setKey(UN(m));
            localObject3 = ((ContactListExpandPreference)localObject2).BZs;
            ((s)localObject3).BYH = this.BYH;
            ((s)localObject3).row = m;
            ((s)localObject3).index = n;
            ((ContactListExpandPreference)localObject2).BZs.BZt = k;
            ((ContactListExpandPreference)localObject2).BZs.fqg = bool1;
            ((ContactListExpandPreference)localObject2).BZs.hs = localOnClickListener;
            ((ContactListExpandPreference)localObject2).BZs.BYN = this.BYN;
            ((ContactListExpandPreference)localObject2).BZs.BZu = ((s.b)localObject1);
            this.screen.a((Preference)localObject2, j + m);
            this.BYE.put(((Preference)localObject2).mKey, localObject2);
            n += k;
            m += 1;
          }
          i = 0;
          break;
          localObject1 = this.BYM;
          break label162;
          localOnClickListener = this.BYL;
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
          ((r)localObject2).BZk = true;
          f2 = ((Context)localObject3).getResources().getDimension(2131165500);
          if (!((r)localObject2).BZk) {
            break label658;
          }
        }
        for (float f1 = ((Context)localObject3).getResources().getDimension(2131165510);; f1 = ((Context)localObject3).getResources().getDimension(2131165508))
        {
          n = k / (int)(f1 + 2.0F * f2);
          ad.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(n) });
          r.BYQ = n;
          k = n;
          if (n != 4) {
            break;
          }
          r.llh = 43;
          k = n;
          break;
          ((r)localObject2).BZk = false;
          break label562;
        }
        if (i != 0)
        {
          localObject1 = new ContactListCustomPreference(this.context);
          ((ContactListCustomPreference)localObject1).setKey(UN(-2));
          ((ContactListCustomPreference)localObject1).setCustomView(this.mXu);
          ((ContactListCustomPreference)localObject1).hs = this.BYK;
          this.screen.a((Preference)localObject1, j + m);
          this.BYE.put(((Preference)localObject1).mKey, localObject1);
        }
        AppMethodBeat.o(152188);
        return;
      }
    }
  }
  
  private static String UN(int paramInt)
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
  
  private void afe(String paramString)
  {
    AppMethodBeat.i(152186);
    this.BYH.setUsername(paramString);
    this.BYH.BZd = this.BYG;
    this.BYH.VL();
    bsd();
    AppMethodBeat.o(152186);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(152189);
    Iterator localIterator = this.BYE.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.screen.aKl(str);
    }
    this.BYE.clear();
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
    this.BYH.fz((List)localObject);
    afe(paramString);
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
    this.BYD = paramString;
    paramf.cE(paramString, true);
    AppMethodBeat.o(152187);
  }
  
  public final void aE(ArrayList<af> paramArrayList)
  {
    AppMethodBeat.i(152185);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList(0);
    }
    this.BYH.aF((ArrayList)localObject);
    afe(null);
    AppMethodBeat.o(152185);
  }
  
  public final void bsd()
  {
    AppMethodBeat.i(152191);
    if ((this.screen == null) || (this.BYD == null))
    {
      AppMethodBeat.o(152191);
      return;
    }
    removeAll();
    UM(this.screen.indexOf(this.BYD));
    AppMethodBeat.o(152191);
  }
  
  public final void eyk()
  {
    boolean bool = false;
    this.BYF = false;
    if (this.BYF) {
      bool = true;
    }
    this.BYG = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.q
 * JD-Core Version:    0.7.0.1
 */
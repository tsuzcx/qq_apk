package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
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
  ContactListExpandPreference.a FjO;
  private String Kfj;
  private HashMap<String, Preference> Kfk;
  private boolean Kfl;
  private boolean Kfm;
  private boolean Kfn;
  public r Kfo;
  s.b Kfp;
  private View.OnClickListener Kfq;
  private View.OnClickListener Kfr;
  private View.OnClickListener Kfs;
  private s.b Kft;
  private s.a Kfu;
  private r.a Kfv;
  private Context context;
  private View kgo;
  public View.OnClickListener ko;
  private View psf;
  f screen;
  String username;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(152183);
    this.Kfk = new HashMap();
    this.Kfl = false;
    if (this.Kfl) {
      bool = true;
    }
    this.Kfm = bool;
    this.Kfp = null;
    this.ko = null;
    this.FjO = null;
    this.Kfs = new q.1(this);
    this.Kft = new s.b()
    {
      public final boolean oi(int paramAnonymousInt)
      {
        AppMethodBeat.i(152180);
        if ((!q.this.Kfo.KfG) || (!q.this.Kfo.ain(paramAnonymousInt)))
        {
          AppMethodBeat.o(152180);
          return true;
        }
        if (!q.this.Kfo.ail(paramAnonymousInt)) {
          Log.d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
        }
        AppMethodBeat.o(152180);
        return true;
      }
    };
    this.Kfu = new s.a()
    {
      public final void m(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        int j = 1;
        AppMethodBeat.i(207172);
        if ((q.this.FjO != null) && (q.this.Kfo != null))
        {
          r localr = q.this.Kfo;
          if (localr.KfG) {
            if ((!localr.gyp) && (paramAnonymousInt == localr.KfE + 2))
            {
              i = 1;
              if (i != 0) {
                break label408;
              }
              localr = q.this.Kfo;
              if ((localr.gyp) || (paramAnonymousInt != localr.KfE)) {
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
            if (!q.this.Kfo.KfH) {
              break label408;
            }
            q.this.FjO.oh(paramAnonymousInt);
            AppMethodBeat.o(207172);
            return;
            i = 0;
            break;
            if ((!localr.gyp) && (paramAnonymousInt == localr.KfE + 1))
            {
              i = 1;
              break;
            }
            i = 0;
            break;
          }
          label173:
          localr = q.this.Kfo;
          if ((!localr.gyp) && (paramAnonymousInt == localr.KfE + 1)) {
            i = j;
          }
          while (i != 0)
          {
            if (!q.this.Kfo.KfG) {
              break label408;
            }
            if (ab.Eq(q.this.username))
            {
              q.this.FjO.og(paramAnonymousInt);
              AppMethodBeat.o(207172);
              return;
              i = 0;
            }
            else
            {
              q.this.Kfo.ail(0);
              AppMethodBeat.o(207172);
              return;
            }
          }
          if ((q.this.Kfo.gyp) && (q.this.Kfo.ain(paramAnonymousInt)))
          {
            q.this.FjO.og(paramAnonymousInt);
            AppMethodBeat.o(207172);
            return;
          }
          if ((q.this.Kfo.gyp) && (!q.this.Kfo.ain(paramAnonymousInt)))
          {
            q.this.FjO.amF();
            AppMethodBeat.o(207172);
            return;
          }
          if ((!q.this.Kfo.gyp) && (q.this.Kfo.ain(paramAnonymousInt))) {
            q.this.FjO.e(paramAnonymousViewGroup, paramAnonymousInt);
          }
        }
        label408:
        AppMethodBeat.o(207172);
      }
    };
    this.Kfv = new r.a()
    {
      public final void cCu()
      {
        AppMethodBeat.i(152182);
        if (q.this.screen != null) {
          q.this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(152182);
      }
    };
    this.context = paramContext;
    this.Kfo = new r(this.context);
    this.Kfo.Kfy = this.Kfv;
    AppMethodBeat.o(152183);
  }
  
  private void aDj(String paramString)
  {
    AppMethodBeat.i(152186);
    this.Kfo.setUsername(paramString);
    this.Kfo.KfK = this.Kfm;
    this.Kfo.amZ();
    cax();
    AppMethodBeat.o(152186);
  }
  
  private void aij(int paramInt)
  {
    AppMethodBeat.i(152188);
    int k = 0;
    if (this.kgo != null) {
      k = 1;
    }
    Object localObject1;
    if (this.psf != null) {
      if (this.Kfl)
      {
        localObject1 = this.Kfo;
        if (((r)localObject1).KfD <= ((r)localObject1).KfL) {
          break label450;
        }
        i = 1;
        if (i == 0) {
          break label764;
        }
      }
    }
    label162:
    label175:
    label201:
    label465:
    label474:
    label485:
    label761:
    label764:
    for (int i = 1;; i = 0)
    {
      int j = paramInt;
      if (k != 0)
      {
        localObject1 = new ContactListCustomPreference(this.context);
        ((ContactListCustomPreference)localObject1).setKey(aik(-1));
        ((ContactListCustomPreference)localObject1).setCustomView(this.kgo);
        ((ContactListCustomPreference)localObject1).background = 2131231898;
        ((ContactListCustomPreference)localObject1).ko = this.Kfq;
        this.screen.a((Preference)localObject1, paramInt);
        this.Kfk.put(((Preference)localObject1).mKey, localObject1);
        j = paramInt + 1;
      }
      View.OnClickListener localOnClickListener;
      boolean bool1;
      boolean bool2;
      if (this.Kfp != null)
      {
        localObject1 = this.Kfp;
        if (this.ko == null) {
          break label465;
        }
        localOnClickListener = this.ko;
        if ((this.Kfo.gtd == null) || (!this.Kfo.gtd.amD())) {
          break label474;
        }
        bool1 = true;
        bool2 = this.Kfo.gpC();
        if (!this.Kfo.tca) {
          break label761;
        }
        bool1 = this.Kfo.KfA;
      }
      for (;;)
      {
        int i1 = this.Kfo.KfE;
        if ((!bool2) || (bool1)) {}
        int m;
        Object localObject2;
        Object localObject3;
        for (paramInt = 2;; paramInt = 1)
        {
          m = 0;
          localObject2 = this.Kfo;
          localObject3 = this.context;
          if (localObject3 != null) {
            break label485;
          }
          k = 0;
          n = 0;
          while ((n < this.Kfo.getCount()) && (n < i1 + paramInt))
          {
            localObject2 = new ContactListExpandPreference(this.context, 1);
            ((ContactListExpandPreference)localObject2).setKey(aik(m));
            localObject3 = ((ContactListExpandPreference)localObject2).KfZ;
            ((s)localObject3).Kfo = this.Kfo;
            ((s)localObject3).row = m;
            ((s)localObject3).index = n;
            ((ContactListExpandPreference)localObject2).KfZ.Kga = k;
            ((ContactListExpandPreference)localObject2).KfZ.gue = bool1;
            ((ContactListExpandPreference)localObject2).KfZ.ko = localOnClickListener;
            ((ContactListExpandPreference)localObject2).KfZ.Kfu = this.Kfu;
            ((ContactListExpandPreference)localObject2).KfZ.Kgb = ((s.b)localObject1);
            this.screen.a((Preference)localObject2, j + m);
            this.Kfk.put(((Preference)localObject2).mKey, localObject2);
            n += k;
            m += 1;
          }
          i = 0;
          break;
          localObject1 = this.Kft;
          break label162;
          localOnClickListener = this.Kfs;
          break label175;
          bool1 = false;
          break label201;
        }
        Display localDisplay = ((WindowManager)((Context)localObject3).getSystemService("window")).getDefaultDisplay();
        k = localDisplay.getWidth();
        int n = localDisplay.getHeight();
        float f2;
        if ((k / (((Context)localObject3).getResources().getDimension(2131165528) + ((Context)localObject3).getResources().getDimension(2131165518) * 2.0F) >= 5.0F) && (n > k))
        {
          ((r)localObject2).KfR = true;
          f2 = ((Context)localObject3).getResources().getDimension(2131165518);
          if (!((r)localObject2).KfR) {
            break label663;
          }
        }
        for (float f1 = ((Context)localObject3).getResources().getDimension(2131165528);; f1 = ((Context)localObject3).getResources().getDimension(2131165526))
        {
          n = k / (int)(f1 + 2.0F * f2);
          Log.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(n) });
          r.Kfx = n;
          k = n;
          if (n != 4) {
            break;
          }
          r.MAX_COUNT = 43;
          k = n;
          break;
          ((r)localObject2).KfR = false;
          break label564;
        }
        if (i != 0)
        {
          localObject1 = new ContactListCustomPreference(this.context);
          ((ContactListCustomPreference)localObject1).setKey(aik(-2));
          ((ContactListCustomPreference)localObject1).setCustomView(this.psf);
          ((ContactListCustomPreference)localObject1).ko = this.Kfr;
          this.screen.a((Preference)localObject1, j + m);
          this.Kfk.put(((Preference)localObject1).mKey, localObject1);
        }
        AppMethodBeat.o(152188);
        return;
      }
    }
  }
  
  private static String aik(int paramInt)
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
  
  private void removeAll()
  {
    AppMethodBeat.i(152189);
    Iterator localIterator = this.Kfk.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.screen.bmi(str);
    }
    this.Kfk.clear();
    AppMethodBeat.o(152189);
  }
  
  public final void H(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152184);
    this.username = paramString;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList(0);
    }
    this.Kfo.gX((List)localObject);
    aDj(paramString);
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
    this.Kfj = paramString;
    paramf.jdMethod_do(paramString, true);
    AppMethodBeat.o(152187);
  }
  
  public final void bg(ArrayList<as> paramArrayList)
  {
    AppMethodBeat.i(152185);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList(0);
    }
    this.Kfo.bh((ArrayList)localObject);
    aDj(null);
    AppMethodBeat.o(152185);
  }
  
  public final void cax()
  {
    AppMethodBeat.i(152191);
    if ((this.screen == null) || (this.Kfj == null))
    {
      AppMethodBeat.o(152191);
      return;
    }
    removeAll();
    aij(this.screen.indexOf(this.Kfj));
    zT(this.Kfn);
    AppMethodBeat.o(152191);
  }
  
  public final void gpA()
  {
    boolean bool = false;
    this.Kfl = false;
    if (this.Kfl) {
      bool = true;
    }
    this.Kfm = bool;
  }
  
  public final void zT(boolean paramBoolean)
  {
    AppMethodBeat.i(207173);
    this.Kfn = paramBoolean;
    Iterator localIterator = this.Kfk.values().iterator();
    while (localIterator.hasNext())
    {
      Preference localPreference = (Preference)localIterator.next();
      if ((localPreference instanceof ContactListExpandPreference)) {
        ((ContactListExpandPreference)localPreference).zT(paramBoolean);
      }
    }
    AppMethodBeat.o(207173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.q
 * JD-Core Version:    0.7.0.1
 */
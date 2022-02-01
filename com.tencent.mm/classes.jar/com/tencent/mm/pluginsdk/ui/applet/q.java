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
import com.tencent.mm.pluginsdk.a.a.a;
import com.tencent.mm.pluginsdk.a.a.b;
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
  ContactListExpandPreference.a Lyz;
  private String RfX;
  private HashMap<String, Preference> RfY;
  private boolean RfZ;
  private boolean Rga;
  private boolean Rgb;
  public r Rgc;
  s.b Rgd;
  private View.OnClickListener Rge;
  private View.OnClickListener Rgf;
  private View.OnClickListener Rgg;
  private s.b Rgh;
  private s.a Rgi;
  private r.a Rgj;
  public View.OnClickListener bwV;
  private Context context;
  private View mXN;
  private View sBm;
  f screen;
  String username;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(152183);
    this.RfY = new HashMap();
    this.RfZ = false;
    if (this.RfZ) {
      bool = true;
    }
    this.Rga = bool;
    this.Rgd = null;
    this.bwV = null;
    this.Lyz = null;
    this.Rgg = new q.1(this);
    this.Rgh = new s.b()
    {
      public final boolean qx(int paramAnonymousInt)
      {
        AppMethodBeat.i(152180);
        if ((!q.this.Rgc.Rgu) || (!q.this.Rgc.aqp(paramAnonymousInt)))
        {
          AppMethodBeat.o(152180);
          return true;
        }
        if (!q.this.Rgc.aqn(paramAnonymousInt)) {
          Log.d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
        }
        AppMethodBeat.o(152180);
        return true;
      }
    };
    this.Rgi = new s.a()
    {
      public final void n(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        int j = 1;
        AppMethodBeat.i(191412);
        if ((q.this.Lyz != null) && (q.this.Rgc != null))
        {
          r localr = q.this.Rgc;
          if (localr.Rgu) {
            if ((!localr.jis) && (paramAnonymousInt == localr.Rgs + 2)) {
              i = 1;
            }
          }
          while (i != 0)
          {
            AppMethodBeat.o(191412);
            return;
            i = 0;
            continue;
            if ((!localr.jis) && (paramAnonymousInt == localr.Rgs + 1)) {
              i = 1;
            } else {
              i = 0;
            }
          }
          localr = q.this.Rgc;
          if ((!localr.jis) && (paramAnonymousInt == localr.Rgs)) {}
          for (int i = 1; i != 0; i = 0)
          {
            if (!q.this.Rgc.Rgv) {
              break label414;
            }
            q.this.Lyz.qw(paramAnonymousInt);
            AppMethodBeat.o(191412);
            return;
          }
          localr = q.this.Rgc;
          if ((!localr.jis) && (paramAnonymousInt == localr.Rgs + 1)) {
            i = j;
          }
          while (i != 0)
          {
            if (!q.this.Rgc.Rgu) {
              break label414;
            }
            if (ab.Lj(q.this.username))
            {
              q.this.Lyz.qv(paramAnonymousInt);
              AppMethodBeat.o(191412);
              return;
              i = 0;
            }
            else
            {
              q.this.Rgc.aqn(0);
              AppMethodBeat.o(191412);
              return;
            }
          }
          if ((q.this.Rgc.jis) && (q.this.Rgc.aqp(paramAnonymousInt)))
          {
            q.this.Lyz.qv(paramAnonymousInt);
            AppMethodBeat.o(191412);
            return;
          }
          if ((q.this.Rgc.jis) && (!q.this.Rgc.aqp(paramAnonymousInt)))
          {
            q.this.Lyz.asG();
            AppMethodBeat.o(191412);
            return;
          }
          if ((!q.this.Rgc.jis) && (q.this.Rgc.aqp(paramAnonymousInt))) {
            q.this.Lyz.e(paramAnonymousViewGroup, paramAnonymousInt);
          }
        }
        label414:
        AppMethodBeat.o(191412);
      }
    };
    this.Rgj = new r.a()
    {
      public final void cQZ()
      {
        AppMethodBeat.i(152182);
        if (q.this.screen != null) {
          q.this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(152182);
      }
    };
    this.context = paramContext;
    this.Rgc = new r(this.context);
    this.Rgc.Rgm = this.Rgj;
    AppMethodBeat.o(152183);
  }
  
  private void aNt(String paramString)
  {
    AppMethodBeat.i(152186);
    this.Rgc.setUsername(paramString);
    this.Rgc.Rgy = this.Rga;
    this.Rgc.ata();
    cnv();
    AppMethodBeat.o(152186);
  }
  
  private void aql(int paramInt)
  {
    AppMethodBeat.i(152188);
    int k = 0;
    if (this.mXN != null) {
      k = 1;
    }
    Object localObject1;
    if (this.sBm != null) {
      if (this.RfZ)
      {
        localObject1 = this.Rgc;
        if (((r)localObject1).Rgr <= ((r)localObject1).Rgz) {
          break label451;
        }
        i = 1;
        if (i == 0) {
          break label767;
        }
      }
    }
    label163:
    label176:
    label202:
    label466:
    label475:
    label486:
    label764:
    label767:
    for (int i = 1;; i = 0)
    {
      int j = paramInt;
      if (k != 0)
      {
        localObject1 = new ContactListCustomPreference(this.context);
        ((ContactListCustomPreference)localObject1).setKey(aqm(-1));
        ((ContactListCustomPreference)localObject1).setCustomView(this.mXN);
        ((ContactListCustomPreference)localObject1).background = a.b.comm_list_item_selector;
        ((ContactListCustomPreference)localObject1).bwV = this.Rge;
        this.screen.a((Preference)localObject1, paramInt);
        this.RfY.put(((Preference)localObject1).mKey, localObject1);
        j = paramInt + 1;
      }
      View.OnClickListener localOnClickListener;
      boolean bool1;
      boolean bool2;
      if (this.Rgd != null)
      {
        localObject1 = this.Rgd;
        if (this.bwV == null) {
          break label466;
        }
        localOnClickListener = this.bwV;
        if ((this.Rgc.iXp == null) || (!this.Rgc.iXp.asE())) {
          break label475;
        }
        bool1 = true;
        bool2 = this.Rgc.hkA();
        if (!this.Rgc.wIf) {
          break label764;
        }
        bool1 = this.Rgc.Rgo;
      }
      for (;;)
      {
        int i1 = this.Rgc.Rgs;
        if ((!bool2) || (bool1)) {}
        int m;
        Object localObject2;
        Object localObject3;
        for (paramInt = 2;; paramInt = 1)
        {
          m = 0;
          localObject2 = this.Rgc;
          localObject3 = this.context;
          if (localObject3 != null) {
            break label486;
          }
          k = 0;
          n = 0;
          while ((n < this.Rgc.getCount()) && (n < i1 + paramInt))
          {
            localObject2 = new ContactListExpandPreference(this.context, 1);
            ((ContactListExpandPreference)localObject2).setKey(aqm(m));
            localObject3 = ((ContactListExpandPreference)localObject2).RgN;
            ((s)localObject3).Rgc = this.Rgc;
            ((s)localObject3).row = m;
            ((s)localObject3).index = n;
            ((ContactListExpandPreference)localObject2).RgN.RgO = k;
            ((ContactListExpandPreference)localObject2).RgN.iYp = bool1;
            ((ContactListExpandPreference)localObject2).RgN.bwV = localOnClickListener;
            ((ContactListExpandPreference)localObject2).RgN.Rgi = this.Rgi;
            ((ContactListExpandPreference)localObject2).RgN.RgP = ((s.b)localObject1);
            this.screen.a((Preference)localObject2, j + m);
            this.RfY.put(((Preference)localObject2).mKey, localObject2);
            n += k;
            m += 1;
          }
          i = 0;
          break;
          localObject1 = this.Rgh;
          break label163;
          localOnClickListener = this.Rgg;
          break label176;
          bool1 = false;
          break label202;
        }
        Display localDisplay = ((WindowManager)((Context)localObject3).getSystemService("window")).getDefaultDisplay();
        k = localDisplay.getWidth();
        int n = localDisplay.getHeight();
        float f2;
        if ((k / (((Context)localObject3).getResources().getDimension(a.a.NormalAvatarWrapSize) + ((Context)localObject3).getResources().getDimension(a.a.MiddlePadding) * 2.0F) >= 5.0F) && (n > k))
        {
          ((r)localObject2).RgF = true;
          f2 = ((Context)localObject3).getResources().getDimension(a.a.MiddlePadding);
          if (!((r)localObject2).RgF) {
            break label666;
          }
        }
        for (float f1 = ((Context)localObject3).getResources().getDimension(a.a.NormalAvatarWrapSize);; f1 = ((Context)localObject3).getResources().getDimension(a.a.NormalAvatarSize))
        {
          n = k / (int)(f1 + 2.0F * f2);
          Log.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(n) });
          r.Rgl = n;
          k = n;
          if (n != 4) {
            break;
          }
          r.MAX_COUNT = 15;
          k = n;
          break;
          ((r)localObject2).RgF = false;
          break label566;
        }
        if (i != 0)
        {
          localObject1 = new ContactListCustomPreference(this.context);
          ((ContactListCustomPreference)localObject1).setKey(aqm(-2));
          ((ContactListCustomPreference)localObject1).setCustomView(this.sBm);
          ((ContactListCustomPreference)localObject1).bwV = this.Rgf;
          this.screen.a((Preference)localObject1, j + m);
          this.RfY.put(((Preference)localObject1).mKey, localObject1);
        }
        AppMethodBeat.o(152188);
        return;
      }
    }
  }
  
  private static String aqm(int paramInt)
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
    Iterator localIterator = this.RfY.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.screen.byI(str);
    }
    this.RfY.clear();
    AppMethodBeat.o(152189);
  }
  
  public final void DY(boolean paramBoolean)
  {
    AppMethodBeat.i(191536);
    this.Rgb = paramBoolean;
    Iterator localIterator = this.RfY.values().iterator();
    while (localIterator.hasNext())
    {
      Preference localPreference = (Preference)localIterator.next();
      if ((localPreference instanceof ContactListExpandPreference)) {
        ((ContactListExpandPreference)localPreference).DY(paramBoolean);
      }
    }
    AppMethodBeat.o(191536);
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
    this.RfX = paramString;
    paramf.dz(paramString, true);
    AppMethodBeat.o(152187);
  }
  
  public final void bv(ArrayList<as> paramArrayList)
  {
    AppMethodBeat.i(152185);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList(0);
    }
    this.Rgc.bw((ArrayList)localObject);
    aNt(null);
    AppMethodBeat.o(152185);
  }
  
  public final void cnv()
  {
    AppMethodBeat.i(152191);
    if ((this.screen == null) || (this.RfX == null))
    {
      AppMethodBeat.o(152191);
      return;
    }
    removeAll();
    aql(this.screen.bf(this.RfX));
    DY(this.Rgb);
    AppMethodBeat.o(152191);
  }
  
  public final void hky()
  {
    boolean bool = false;
    this.RfZ = false;
    if (this.RfZ) {
      bool = true;
    }
    this.Rga = bool;
  }
  
  public final void s(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152184);
    this.username = paramString;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList(0);
    }
    this.Rgc.hF((List)localObject);
    aNt(paramString);
    AppMethodBeat.o(152184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.q
 * JD-Core Version:    0.7.0.1
 */
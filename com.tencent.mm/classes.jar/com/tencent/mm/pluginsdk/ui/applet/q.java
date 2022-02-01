package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.a.a;
import com.tencent.mm.pluginsdk.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
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
  ContactListExpandPreference.a Sco;
  private String YbZ;
  public HashMap<String, Preference> Yca;
  private boolean Ycb;
  private boolean Ycc;
  private boolean Ycd;
  public r Yce;
  s.b Ycf;
  private View.OnClickListener Ycg;
  private View.OnClickListener Ych;
  public boolean Yci;
  private View.OnClickListener Ycj;
  private s.b Yck;
  private s.a Ycl;
  private r.a Ycm;
  private Context context;
  public View.OnClickListener dpY;
  private View pUv;
  f screen;
  private View uiE;
  String username;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(152183);
    this.Yca = new HashMap();
    this.Ycb = false;
    if (this.Ycb) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ycc = bool;
      this.Ycf = null;
      this.dpY = null;
      this.Sco = null;
      this.Yci = false;
      this.Ycj = new q.1(this);
      this.Yck = new s.b()
      {
        public final boolean qy(int paramAnonymousInt)
        {
          AppMethodBeat.i(152180);
          if ((!q.this.Yce.Ycx) || (!q.this.Yce.awt(paramAnonymousInt)))
          {
            AppMethodBeat.o(152180);
            return true;
          }
          if (!q.this.Yce.awr(paramAnonymousInt)) {
            Log.d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(152180);
          return true;
        }
      };
      this.Ycl = new s.a()
      {
        public final void n(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          int j = 1;
          AppMethodBeat.i(245231);
          if ((q.this.Sco != null) && (q.this.Yce != null))
          {
            r localr = q.this.Yce;
            if (localr.Ycx) {
              if ((!localr.lKI) && (paramAnonymousInt == localr.Ycv + 2)) {
                i = 1;
              }
            }
            while (i != 0)
            {
              AppMethodBeat.o(245231);
              return;
              i = 0;
              continue;
              if ((!localr.lKI) && (paramAnonymousInt == localr.Ycv + 1)) {
                i = 1;
              } else {
                i = 0;
              }
            }
            localr = q.this.Yce;
            if ((!localr.lKI) && (paramAnonymousInt == localr.Ycv)) {}
            for (int i = 1; i != 0; i = 0)
            {
              if (!q.this.Yce.Ycy) {
                break label414;
              }
              q.this.Sco.qx(paramAnonymousInt);
              AppMethodBeat.o(245231);
              return;
            }
            localr = q.this.Yce;
            if ((!localr.lKI) && (paramAnonymousInt == localr.Ycv + 1)) {
              i = j;
            }
            while (i != 0)
            {
              if (!q.this.Yce.Ycx) {
                break label414;
              }
              if (au.bwE(q.this.username))
              {
                q.this.Sco.qw(paramAnonymousInt);
                AppMethodBeat.o(245231);
                return;
                i = 0;
              }
              else
              {
                q.this.Yce.awr(0);
                AppMethodBeat.o(245231);
                return;
              }
            }
            if ((q.this.Yce.lKI) && (q.this.Yce.awt(paramAnonymousInt)))
            {
              q.this.Sco.qw(paramAnonymousInt);
              AppMethodBeat.o(245231);
              return;
            }
            if ((q.this.Yce.lKI) && (!q.this.Yce.awt(paramAnonymousInt)))
            {
              q.this.Sco.aMI();
              AppMethodBeat.o(245231);
              return;
            }
            if ((!q.this.Yce.lKI) && (q.this.Yce.awt(paramAnonymousInt))) {
              q.this.Sco.e(paramAnonymousViewGroup, paramAnonymousInt);
            }
          }
          label414:
          AppMethodBeat.o(245231);
        }
      };
      this.Ycm = new r.a()
      {
        public final void dvs()
        {
          AppMethodBeat.i(152182);
          if (q.this.screen != null) {
            q.this.screen.notifyDataSetChanged();
          }
          AppMethodBeat.o(152182);
        }
      };
      this.context = paramContext;
      this.Yce = new r(this.context);
      this.Yce.Ycp = this.Ycm;
      AppMethodBeat.o(152183);
      return;
    }
  }
  
  private void aKo(String paramString)
  {
    AppMethodBeat.i(152186);
    this.Yce.setUsername(paramString);
    this.Yce.YcB = this.Ycc;
    this.Yce.aNi();
    cPy();
    AppMethodBeat.o(152186);
  }
  
  private void awp(int paramInt)
  {
    AppMethodBeat.i(152188);
    int k = 0;
    if (this.pUv != null) {
      k = 1;
    }
    Object localObject1;
    if (this.uiE != null) {
      if (this.Ycb)
      {
        localObject1 = this.Yce;
        if (((r)localObject1).Ycu <= ((r)localObject1).YcC) {
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
        ((ContactListCustomPreference)localObject1).setKey(awq(-1));
        ((ContactListCustomPreference)localObject1).setCustomView(this.pUv);
        ((ContactListCustomPreference)localObject1).background = a.b.comm_list_item_selector;
        ((ContactListCustomPreference)localObject1).dpY = this.Ycg;
        this.screen.a((Preference)localObject1, paramInt);
        this.Yca.put(((Preference)localObject1).mKey, localObject1);
        j = paramInt + 1;
      }
      View.OnClickListener localOnClickListener;
      boolean bool1;
      boolean bool2;
      if (this.Ycf != null)
      {
        localObject1 = this.Ycf;
        if (this.dpY == null) {
          break label466;
        }
        localOnClickListener = this.dpY;
        if ((this.Yce.lzy == null) || (!this.Yce.lzy.aMF())) {
          break label475;
        }
        bool1 = true;
        bool2 = this.Yce.iLr();
        if (!this.Yce.Aet) {
          break label764;
        }
        bool1 = this.Yce.Ycr;
      }
      for (;;)
      {
        int i1 = this.Yce.Ycv;
        if ((!bool2) || (bool1)) {}
        int m;
        Object localObject2;
        Object localObject3;
        for (paramInt = 2;; paramInt = 1)
        {
          m = 0;
          localObject2 = this.Yce;
          localObject3 = this.context;
          if (localObject3 != null) {
            break label486;
          }
          k = 0;
          n = 0;
          while ((n < this.Yce.getCount()) && (n < i1 + paramInt))
          {
            localObject2 = new ContactListExpandPreference(this.context, 1);
            ((ContactListExpandPreference)localObject2).setKey(awq(m));
            localObject3 = ((ContactListExpandPreference)localObject2).YcQ;
            ((s)localObject3).Yce = this.Yce;
            ((s)localObject3).row = m;
            ((s)localObject3).index = n;
            ((ContactListExpandPreference)localObject2).YcQ.YcR = k;
            ((ContactListExpandPreference)localObject2).YcQ.lAh = bool1;
            ((ContactListExpandPreference)localObject2).YcQ.dpY = localOnClickListener;
            ((ContactListExpandPreference)localObject2).YcQ.Ycl = this.Ycl;
            ((ContactListExpandPreference)localObject2).YcQ.YcS = ((s.b)localObject1);
            this.screen.a((Preference)localObject2, j + m);
            this.Yca.put(((Preference)localObject2).mKey, localObject2);
            n += k;
            m += 1;
          }
          i = 0;
          break;
          localObject1 = this.Yck;
          break label163;
          localOnClickListener = this.Ycj;
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
          ((r)localObject2).YcI = true;
          f2 = ((Context)localObject3).getResources().getDimension(a.a.MiddlePadding);
          if (!((r)localObject2).YcI) {
            break label666;
          }
        }
        for (float f1 = ((Context)localObject3).getResources().getDimension(a.a.NormalAvatarWrapSize);; f1 = ((Context)localObject3).getResources().getDimension(a.a.NormalAvatarSize))
        {
          n = k / (int)(f1 + 2.0F * f2);
          Log.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(n) });
          r.Yco = n;
          k = n;
          if (n != 4) {
            break;
          }
          r.MAX_COUNT = 15;
          k = n;
          break;
          ((r)localObject2).YcI = false;
          break label566;
        }
        if (i != 0)
        {
          localObject1 = new ContactListCustomPreference(this.context);
          ((ContactListCustomPreference)localObject1).setKey(awq(-2));
          ((ContactListCustomPreference)localObject1).setCustomView(this.uiE);
          ((ContactListCustomPreference)localObject1).dpY = this.Ych;
          this.screen.a((Preference)localObject1, j + m);
          this.Yca.put(((Preference)localObject1).mKey, localObject1);
        }
        AppMethodBeat.o(152188);
        return;
      }
    }
  }
  
  private static String awq(int paramInt)
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
    Iterator localIterator = this.Yca.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.screen.bAk(str);
    }
    this.Yca.clear();
    AppMethodBeat.o(152189);
  }
  
  public final void JI(boolean paramBoolean)
  {
    AppMethodBeat.i(245270);
    this.Ycd = paramBoolean;
    Iterator localIterator = this.Yca.values().iterator();
    while (localIterator.hasNext())
    {
      Preference localPreference = (Preference)localIterator.next();
      if ((localPreference instanceof ContactListExpandPreference)) {
        ((ContactListExpandPreference)localPreference).JI(paramBoolean);
      }
    }
    AppMethodBeat.o(245270);
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
    this.YbZ = paramString;
    paramf.eh(paramString, true);
    AppMethodBeat.o(152187);
  }
  
  public final void bW(ArrayList<au> paramArrayList)
  {
    AppMethodBeat.i(152185);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList(0);
    }
    this.Yce.bX((ArrayList)localObject);
    aKo(null);
    AppMethodBeat.o(152185);
  }
  
  public final void cPy()
  {
    AppMethodBeat.i(152191);
    if ((this.screen == null) || (this.YbZ == null))
    {
      AppMethodBeat.o(152191);
      return;
    }
    removeAll();
    if (this.Yci)
    {
      AppMethodBeat.o(152191);
      return;
    }
    awp(this.screen.cs(this.YbZ));
    JI(this.Ycd);
    AppMethodBeat.o(152191);
  }
  
  public final void iLp()
  {
    boolean bool = false;
    this.Ycb = false;
    if (this.Ycb) {
      bool = true;
    }
    this.Ycc = bool;
  }
  
  public final void y(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152184);
    this.username = paramString;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList(0);
    }
    this.Yce.kG((List)localObject);
    aKo(paramString);
    AppMethodBeat.o(152184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.q
 * JD-Core Version:    0.7.0.1
 */
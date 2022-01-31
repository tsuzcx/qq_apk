package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class i
{
  private Context context;
  private View gyT;
  private View jWo;
  public View.OnClickListener qaq;
  f screen;
  ContactListExpandPreference.a sqf;
  String username;
  public j vTA;
  k.b vTB;
  private View.OnClickListener vTC;
  private View.OnClickListener vTD;
  private View.OnClickListener vTE;
  private k.b vTF;
  private k.a vTG;
  private j.a vTH;
  private String vTw;
  private HashMap<String, Preference> vTx;
  private boolean vTy;
  private boolean vTz;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(79735);
    this.vTx = new HashMap();
    this.vTy = false;
    if (this.vTy) {
      bool = true;
    }
    this.vTz = bool;
    this.vTB = null;
    this.qaq = null;
    this.sqf = null;
    this.vTE = new i.1(this);
    this.vTF = new i.2(this);
    this.vTG = new i.3(this);
    this.vTH = new j.a()
    {
      public final void djN()
      {
        AppMethodBeat.i(79734);
        if (i.this.screen != null) {
          i.this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(79734);
      }
    };
    this.context = paramContext;
    this.vTA = new j(this.context);
    this.vTA.vTK = this.vTH;
    AppMethodBeat.o(79735);
  }
  
  private void LV(int paramInt)
  {
    AppMethodBeat.i(79740);
    int k = 0;
    if (this.gyT != null) {
      k = 1;
    }
    Object localObject1;
    if (this.jWo != null) {
      if (this.vTy)
      {
        localObject1 = this.vTA;
        if (((j)localObject1).vTP <= ((j)localObject1).vTX) {
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
        ((ContactListCustomPreference)localObject1).setKey(LW(-1));
        ((ContactListCustomPreference)localObject1).setCustomView(this.gyT);
        ((ContactListCustomPreference)localObject1).background = 2130838445;
        ((ContactListCustomPreference)localObject1).qaq = this.vTC;
        this.screen.a((Preference)localObject1, paramInt);
        this.vTx.put(((Preference)localObject1).mKey, localObject1);
        j = paramInt + 1;
      }
      View.OnClickListener localOnClickListener;
      boolean bool1;
      boolean bool2;
      if (this.vTB != null)
      {
        localObject1 = this.vTB;
        if (this.qaq == null) {
          break label465;
        }
        localOnClickListener = this.qaq;
        if ((this.vTA.efi == null) || (!this.vTA.efi.JP())) {
          break label474;
        }
        bool1 = true;
        bool2 = this.vTA.dnD();
        if (!this.vTA.muT) {
          break label756;
        }
        bool1 = this.vTA.vTM;
      }
      for (;;)
      {
        int i1 = this.vTA.vTQ;
        if ((!bool2) || (bool1)) {}
        int m;
        Object localObject2;
        Object localObject3;
        for (paramInt = 2;; paramInt = 1)
        {
          m = 0;
          localObject2 = this.vTA;
          localObject3 = this.context;
          if (localObject3 != null) {
            break label485;
          }
          k = 0;
          n = 0;
          while ((n < this.vTA.getCount()) && (n < i1 + paramInt))
          {
            localObject2 = new ContactListExpandPreference(this.context, 1);
            ((ContactListExpandPreference)localObject2).setKey(LW(m));
            localObject3 = ((ContactListExpandPreference)localObject2).vUl;
            ((k)localObject3).vTA = this.vTA;
            ((k)localObject3).row = m;
            ((k)localObject3).index = n;
            ((ContactListExpandPreference)localObject2).vUl.vUm = k;
            ((ContactListExpandPreference)localObject2).vUl.efd = bool1;
            ((ContactListExpandPreference)localObject2).vUl.qaq = localOnClickListener;
            ((ContactListExpandPreference)localObject2).vUl.vTG = this.vTG;
            ((ContactListExpandPreference)localObject2).vUl.vUn = ((k.b)localObject1);
            this.screen.a((Preference)localObject2, j + m);
            this.vTx.put(((Preference)localObject2).mKey, localObject2);
            n += k;
            m += 1;
          }
          i = 0;
          break;
          localObject1 = this.vTF;
          break label162;
          localOnClickListener = this.vTE;
          break label175;
          bool1 = false;
          break label201;
        }
        Display localDisplay = ((WindowManager)((Context)localObject3).getSystemService("window")).getDefaultDisplay();
        k = localDisplay.getWidth();
        int n = localDisplay.getHeight();
        float f2;
        if ((k / (((Context)localObject3).getResources().getDimension(2131427802) + ((Context)localObject3).getResources().getDimension(2131427792) * 2.0F) >= 5.0F) && (n > k))
        {
          ((j)localObject2).vUd = true;
          f2 = ((Context)localObject3).getResources().getDimension(2131427792);
          if (!((j)localObject2).vUd) {
            break label658;
          }
        }
        for (float f1 = ((Context)localObject3).getResources().getDimension(2131427802);; f1 = ((Context)localObject3).getResources().getDimension(2131427800))
        {
          n = k / (int)(f1 + 2.0F * f2);
          ab.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(n) });
          j.vTJ = n;
          k = n;
          if (n != 4) {
            break;
          }
          j.MAX_COUNT = 43;
          k = n;
          break;
          ((j)localObject2).vUd = false;
          break label562;
        }
        if (i != 0)
        {
          localObject1 = new ContactListCustomPreference(this.context);
          ((ContactListCustomPreference)localObject1).setKey(LW(-2));
          ((ContactListCustomPreference)localObject1).setCustomView(this.jWo);
          ((ContactListCustomPreference)localObject1).qaq = this.vTD;
          this.screen.a((Preference)localObject1, j + m);
          this.vTx.put(((Preference)localObject1).mKey, localObject1);
        }
        AppMethodBeat.o(79740);
        return;
      }
    }
  }
  
  private static String LW(int paramInt)
  {
    AppMethodBeat.i(79742);
    if (paramInt >= 0)
    {
      str = "pref_contact_list_row_".concat(String.valueOf(paramInt));
      AppMethodBeat.o(79742);
      return str;
    }
    String str = "unkown";
    if (paramInt == -1) {
      str = "header";
    }
    for (;;)
    {
      str = "pref_contact_list_row_".concat(String.valueOf(str));
      AppMethodBeat.o(79742);
      return str;
      if (paramInt == -2) {
        str = "footer";
      }
    }
  }
  
  private void Sl(String paramString)
  {
    AppMethodBeat.i(79738);
    this.vTA.setUsername(paramString);
    this.vTA.vTW = this.vTz;
    this.vTA.Kc();
    aPD();
    AppMethodBeat.o(79738);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(79741);
    Iterator localIterator = this.vTx.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.screen.aty(str);
    }
    this.vTx.clear();
    AppMethodBeat.o(79741);
  }
  
  public final void a(f paramf, String paramString)
  {
    AppMethodBeat.i(79739);
    if ((paramf == null) || (paramString == null))
    {
      AppMethodBeat.o(79739);
      return;
    }
    this.screen = paramf;
    this.vTw = paramString;
    paramf.cl(paramString, true);
    AppMethodBeat.o(79739);
  }
  
  public final void aPD()
  {
    AppMethodBeat.i(79743);
    if ((this.screen == null) || (this.vTw == null))
    {
      AppMethodBeat.o(79743);
      return;
    }
    removeAll();
    LV(this.screen.indexOf(this.vTw));
    AppMethodBeat.o(79743);
  }
  
  public final void ah(ArrayList<ad> paramArrayList)
  {
    AppMethodBeat.i(79737);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList(0);
    }
    this.vTA.ai((ArrayList)localObject);
    Sl(null);
    AppMethodBeat.o(79737);
  }
  
  public final void dnB()
  {
    boolean bool = false;
    this.vTy = false;
    if (this.vTy) {
      bool = true;
    }
    this.vTz = bool;
  }
  
  public final void v(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(79736);
    this.username = paramString;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList(0);
    }
    this.vTA.dj((List)localObject);
    Sl(paramString);
    AppMethodBeat.o(79736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.i
 * JD-Core Version:    0.7.0.1
 */
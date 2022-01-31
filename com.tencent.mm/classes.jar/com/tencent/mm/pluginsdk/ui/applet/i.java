package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class i
{
  private Context context;
  f dnn;
  private View fhl;
  private View igy;
  public View.OnClickListener nuB;
  ContactListExpandPreference.a ptQ;
  private k.a scA;
  private j.a scB;
  String scq;
  private HashMap<String, Preference> scr = new HashMap();
  boolean scs = false;
  boolean sct;
  public j scu;
  k.b scv;
  private View.OnClickListener scw;
  private View.OnClickListener scx;
  private View.OnClickListener scy;
  private k.b scz;
  String username;
  
  public i(Context paramContext)
  {
    if (this.scs) {
      bool = true;
    }
    this.sct = bool;
    this.scv = null;
    this.nuB = null;
    this.ptQ = null;
    this.scy = new i.1(this);
    this.scz = new i.2(this);
    this.scA = new i.3(this);
    this.scB = new j.a()
    {
      public final void cjm()
      {
        if (i.this.dnn != null) {
          i.this.dnn.notifyDataSetChanged();
        }
      }
    };
    this.context = paramContext;
    this.scu = new j(this.context);
    this.scu.scF = this.scB;
  }
  
  private static String DZ(int paramInt)
  {
    if (paramInt >= 0) {
      return "pref_contact_list_row_" + paramInt;
    }
    String str = "unkown";
    if (paramInt == -1) {
      str = "header";
    }
    for (;;)
    {
      return "pref_contact_list_row_" + str;
      if (paramInt == -2) {
        str = "footer";
      }
    }
  }
  
  final void GI(String paramString)
  {
    j localj = this.scu;
    localj.username = paramString;
    localj.bRz = s.fn(paramString);
    if ((!localj.bRz) && (p.a.sdn != null)) {
      localj.kax = p.a.sdn.WC(paramString);
    }
    if (!localj.kax) {
      localj.dnL = ((c)g.r(c.class)).FF().in(paramString);
    }
    if ((localj.kax) && (p.a.sdn != null)) {
      localj.drd = p.a.sdn.WE(localj.username);
    }
    this.scu.scS = this.sct;
    this.scu.notifyChanged();
    buD();
  }
  
  public final void buD()
  {
    if ((this.dnn == null) || (this.scq == null)) {
      return;
    }
    Object localObject1 = this.scr.keySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      this.dnn.ade((String)localObject2);
    }
    this.scr.clear();
    int m = this.dnn.indexOf(this.scq);
    int k = 0;
    if (this.fhl != null) {
      k = 1;
    }
    if (this.igy != null) {
      if (this.scs)
      {
        localObject1 = this.scu;
        if (((j)localObject1).scL <= ((j)localObject1).scT) {
          break label536;
        }
        i = 1;
        if (i == 0) {
          break label847;
        }
      }
    }
    label259:
    label285:
    label550:
    label559:
    label571:
    label844:
    label847:
    for (int i = 1;; i = 0)
    {
      int j = m;
      if (k != 0)
      {
        localObject1 = new ContactListCustomPreference(this.context);
        ((ContactListCustomPreference)localObject1).setKey(DZ(-1));
        ((ContactListCustomPreference)localObject1).setCustomView(this.fhl);
        ((ContactListCustomPreference)localObject1).background = a.d.comm_list_item_selector;
        ((ContactListCustomPreference)localObject1).nuB = this.scw;
        this.dnn.a((Preference)localObject1, m);
        this.scr.put(((Preference)localObject1).mKey, localObject1);
        j = m + 1;
      }
      label246:
      boolean bool1;
      boolean bool2;
      if (this.scv != null)
      {
        localObject1 = this.scv;
        if (this.nuB == null) {
          break label550;
        }
        localObject2 = this.nuB;
        if ((this.scu.dnL == null) || (!this.scu.dnL.xw())) {
          break label559;
        }
        bool1 = true;
        bool2 = this.scu.cmL();
        if (!this.scu.kax) {
          break label844;
        }
        bool1 = this.scu.scH;
      }
      for (;;)
      {
        int i2 = this.scu.scM;
        if ((!bool2) || (bool1)) {}
        int n;
        Object localObject3;
        Object localObject4;
        for (k = 2;; k = 1)
        {
          n = 0;
          localObject3 = this.scu;
          localObject4 = this.context;
          if (localObject4 != null) {
            break label571;
          }
          m = 0;
          i1 = 0;
          while ((i1 < this.scu.getCount()) && (i1 < i2 + k))
          {
            localObject3 = new ContactListExpandPreference(this.context, 1);
            ((ContactListExpandPreference)localObject3).setKey(DZ(n));
            localObject4 = ((ContactListExpandPreference)localObject3).sdi;
            ((k)localObject4).scu = this.scu;
            ((k)localObject4).row = n;
            ((k)localObject4).index = i1;
            ((ContactListExpandPreference)localObject3).sdi.sdj = m;
            ((ContactListExpandPreference)localObject3).sdi.dnG = bool1;
            ((ContactListExpandPreference)localObject3).sdi.nuB = ((View.OnClickListener)localObject2);
            ((ContactListExpandPreference)localObject3).sdi.scA = this.scA;
            ((ContactListExpandPreference)localObject3).sdi.sdk = ((k.b)localObject1);
            this.dnn.a((Preference)localObject3, j + n);
            this.scr.put(((Preference)localObject3).mKey, localObject3);
            i1 += m;
            n += 1;
          }
          i = 0;
          break;
          localObject1 = this.scz;
          break label246;
          localObject2 = this.scy;
          break label259;
          bool1 = false;
          break label285;
        }
        Display localDisplay = ((WindowManager)((Context)localObject4).getSystemService("window")).getDefaultDisplay();
        m = localDisplay.getWidth();
        int i1 = localDisplay.getHeight();
        float f2;
        if ((m / (((Context)localObject4).getResources().getDimension(a.c.NormalAvatarWrapSize) + ((Context)localObject4).getResources().getDimension(a.c.MiddlePadding) * 2.0F) >= 5.0F) && (i1 > m))
        {
          ((j)localObject3).scZ = true;
          f2 = ((Context)localObject4).getResources().getDimension(a.c.MiddlePadding);
          if (!((j)localObject3).scZ) {
            break label752;
          }
        }
        label752:
        for (float f1 = ((Context)localObject4).getResources().getDimension(a.c.NormalAvatarWrapSize);; f1 = ((Context)localObject4).getResources().getDimension(a.c.NormalAvatarSize))
        {
          i1 = m / (int)(f1 + 2.0F * f2);
          y.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i1) });
          j.scE = i1;
          m = i1;
          if (i1 != 4) {
            break;
          }
          j.scD = 43;
          m = i1;
          break;
          ((j)localObject3).scZ = false;
          break label652;
        }
        if (i == 0) {
          break;
        }
        localObject1 = new ContactListCustomPreference(this.context);
        ((ContactListCustomPreference)localObject1).setKey(DZ(-2));
        ((ContactListCustomPreference)localObject1).setCustomView(this.igy);
        ((ContactListCustomPreference)localObject1).nuB = this.scx;
        this.dnn.a((Preference)localObject1, j + n);
        this.scr.put(((Preference)localObject1).mKey, localObject1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.i
 * JD-Core Version:    0.7.0.1
 */
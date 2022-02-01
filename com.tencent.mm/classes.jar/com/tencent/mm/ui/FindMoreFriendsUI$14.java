package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.protocal.protobuf.fob;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.tools.v;

final class FindMoreFriendsUI$14
  implements Runnable
{
  FindMoreFriendsUI$14(FindMoreFriendsUI paramFindMoreFriendsUI, IconPreference paramIconPreference) {}
  
  public final void run()
  {
    AppMethodBeat.i(33037);
    if (this.tYu == null)
    {
      AppMethodBeat.o(33037);
      return;
    }
    FindMoreFriendsUI.ef("find_friends_by_look", false);
    boolean bool = ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMy();
    int i;
    int k;
    label120:
    int m;
    label169:
    int i2;
    int i1;
    label218:
    Object localObject2;
    a locala;
    if ((((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hLS()) && (bool))
    {
      i = 1;
      bool = ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMA();
      if ((!((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMm()) || (!bool)) {
        break label471;
      }
      k = 1;
      bool = ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMz();
      if ((!((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMn()) || (!bool)) {
        break label476;
      }
      m = 1;
      i2 = ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMf();
      if ((i2 <= 0) || (!((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hLT())) {
        break label482;
      }
      i1 = 1;
      localObject2 = null;
      locala = null;
      if (((i1 == 0) && (k != 0)) || ((i1 == 0) && (k != 0) && (LauncherUI.getCurrentTabIndex() == 2))) {
        ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMC();
      }
      if ((i1 != 0) || (i == 0)) {
        break label1691;
      }
    }
    label1676:
    label1691:
    for (fob localfob = ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hLV();; localfob = null)
    {
      Object localObject1 = localObject2;
      if (i1 == 0)
      {
        localObject1 = localObject2;
        if (k != 0) {
          localObject1 = ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hLZ();
        }
      }
      localObject2 = locala;
      if (i1 == 0)
      {
        localObject2 = locala;
        if (m != 0)
        {
          if (LauncherUI.getCurrentTabIndex() == 2) {
            ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMC();
          }
          localObject2 = ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMc();
        }
      }
      locala = (a)this.tYu;
      if ((i1 != 0) || ((i != 0) && ((localfob == null) || ((localfob.type > 0) && (localfob.type <= 4)))) || (k != 0) || (m != 0)) {}
      for (bool = true;; bool = false)
      {
        if (!locala.ym(bool)) {
          break label494;
        }
        AppMethodBeat.o(33037);
        return;
        i = 0;
        break;
        label471:
        k = 0;
        break label120;
        label476:
        m = 0;
        break label169;
        label482:
        i1 = 0;
        break label218;
      }
      label494:
      int i3 = com.tencent.mm.plugin.topstory.ui.d.hMX();
      int j = k;
      int n = m;
      if (localfob != null)
      {
        j = k;
        n = m;
        if (g.aoJ(i3))
        {
          j = 0;
          n = 0;
        }
      }
      if ((localObject1 != null) && (g.aoK(i3))) {
        i = 0;
      }
      for (k = 0;; k = n)
      {
        if ((localObject2 != null) && (g.aoL(i3)))
        {
          i = 0;
          j = 0;
        }
        for (;;)
        {
          this.tYu.aeD(8);
          this.tYu.aBf(8);
          this.tYu.aBi(8);
          this.tYu.afx(8);
          if (i1 != 0)
          {
            this.tYu.afx(0);
            localObject1 = String.valueOf(i2);
            if (i2 > 99) {
              localObject1 = "99+";
            }
            this.tYu.gv((String)localObject1, v.bC(this.adyF.getContext(), i2));
            ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMC();
            locala.a(k.MsP, true);
            label680:
            if ((j == 0) && (i1 == 0) && (i == 0) && (k == 0)) {
              break label1676;
            }
          }
          for (bool = true;; bool = false)
          {
            FindMoreFriendsUI.ef("find_friends_by_look", bool);
            FindMoreFriendsUI.a(this.adyF).notifyDataSetChanged();
            AppMethodBeat.o(33037);
            return;
            if ((i != 0) && (localfob != null)) {}
            switch (localfob.type)
            {
            default: 
              Log.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[] { Integer.valueOf(localfob.type) });
            case 1: 
            case 2: 
              while ((j != 0) || (k != 0))
              {
                if (j != 0) {
                  localObject2 = localObject1;
                }
                if (localObject2 == null) {
                  break label1636;
                }
                switch (((fob)localObject2).type)
                {
                default: 
                  ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMC();
                  this.tYu.aeD(0);
                  locala.a(k.MsK, true);
                  break label680;
                  this.tYu.aeD(0);
                  locala.a(k.MsK, true);
                  continue;
                  this.tYu.aeD(8);
                  this.tYu.aBf(0);
                  this.tYu.bd(localfob.text, -1, Color.parseColor("#8c8c8c"));
                  this.tYu.LF(true);
                  this.tYu.aBi(8);
                  locala.a(k.MsM, true);
                }
              }
            case 3: 
              this.tYu.aeD(8);
              this.tYu.aBi(0);
              this.tYu.aBh(0);
              this.tYu.aBj(0);
              this.tYu.LF(false);
              r.bJZ();
              localBitmap = e.Eo(localfob.icon);
              if (localBitmap != null)
              {
                FindMoreFriendsUI.a(this.adyF, null);
                this.tYu.bd(localBitmap);
              }
              for (;;)
              {
                locala.a(k.MsN, true);
                break;
                r.bKd().a(localfob.icon, this.adyF.MrK);
                FindMoreFriendsUI.a(this.adyF, localfob.icon);
              }
            }
            this.tYu.aeD(8);
            this.tYu.aBi(0);
            this.tYu.aBh(0);
            this.tYu.aBj(0);
            this.tYu.aBf(0);
            this.tYu.LF(false);
            this.tYu.bd(localfob.text, -1, Color.parseColor("#8c8c8c"));
            r.bJZ();
            Bitmap localBitmap = e.Eo(localfob.icon);
            if (localBitmap != null)
            {
              FindMoreFriendsUI.a(this.adyF, null);
              this.tYu.bd(localBitmap);
            }
            for (;;)
            {
              locala.a(k.MsO, true);
              break;
              r.bKd().a(localfob.icon, this.adyF.MrK);
              FindMoreFriendsUI.a(this.adyF, localfob.icon);
            }
            this.tYu.aeD(0);
            locala.a(k.MsK, true);
            break;
            this.tYu.aeD(8);
            this.tYu.aBf(0);
            this.tYu.bd(((fob)localObject2).text, -1, Color.parseColor("#8c8c8c"));
            this.tYu.LF(true);
            this.tYu.aBi(8);
            locala.a(k.MsM, true);
            break;
            this.tYu.aeD(8);
            this.tYu.aBi(0);
            this.tYu.aBh(0);
            this.tYu.aBj(0);
            this.tYu.LF(false);
            r.bJZ();
            localObject1 = e.Eo(((fob)localObject2).icon);
            if (localObject1 != null)
            {
              FindMoreFriendsUI.a(this.adyF, null);
              this.tYu.bd((Bitmap)localObject1);
            }
            for (;;)
            {
              locala.a(k.MsN, true);
              break;
              r.bKd().a(((fob)localObject2).icon, this.adyF.MrK);
              FindMoreFriendsUI.a(this.adyF, ((fob)localObject2).icon);
            }
            this.tYu.aeD(8);
            this.tYu.aBi(0);
            this.tYu.aBh(0);
            this.tYu.aBj(0);
            this.tYu.aBf(0);
            this.tYu.LF(false);
            this.tYu.bd(((fob)localObject2).text, -1, Color.parseColor("#8c8c8c"));
            r.bJZ();
            localObject1 = e.Eo(((fob)localObject2).icon);
            if (localObject1 != null)
            {
              FindMoreFriendsUI.a(this.adyF, null);
              this.tYu.bd((Bitmap)localObject1);
            }
            for (;;)
            {
              locala.a(k.MsO, true);
              break;
              r.bKd().a(((fob)localObject2).icon, this.adyF.MrK);
              FindMoreFriendsUI.a(this.adyF, ((fob)localObject2).icon);
            }
            label1636:
            ((b)com.tencent.mm.kernel.h.az(b.class)).getRedDotMgr().hMC();
            this.tYu.aeD(0);
            locala.a(k.MsK, true);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.14
 * JD-Core Version:    0.7.0.1
 */
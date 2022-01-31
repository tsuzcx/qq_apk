package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.applet.b;
import java.util.LinkedList;
import java.util.List;

final class NearbyFriendsUI$b
  extends BaseAdapter
{
  private final Context context;
  b ffG = new b(new NearbyFriendsUI.b.1(this));
  private com.tencent.mm.ui.applet.b.b ffH = null;
  
  public NearbyFriendsUI$b(NearbyFriendsUI paramNearbyFriendsUI, Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final int getCount()
  {
    return NearbyFriendsUI.r(this.mDs).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.ffH == null) {
      this.ffH = new com.tencent.mm.ui.applet.b.b()
      {
        public final int WL()
        {
          return NearbyFriendsUI.b.this.getCount();
        }
        
        public final String jX(int paramAnonymousInt)
        {
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= NearbyFriendsUI.b.this.getCount())) {
            y.e("MicroMsg.NearbyFriend", "pos is invalid");
          }
          atm localatm;
          do
          {
            return null;
            localatm = NearbyFriendsUI.b.this.vd(paramAnonymousInt);
          } while (localatm == null);
          return localatm.hPY;
        }
      };
    }
    if (this.ffG != null) {
      this.ffG.a(paramInt, this.ffH);
    }
    Object localObject1;
    label361:
    Object localObject2;
    if (paramView == null)
    {
      paramViewGroup = new NearbyFriendsUI.d();
      paramView = View.inflate(this.context, b.e.nearby_friend_item, null);
      paramViewGroup.fdY = ((TextView)paramView.findViewById(b.d.nearby_friend_name));
      paramViewGroup.mDz = ((TextView)paramView.findViewById(b.d.nearby_friend_sign));
      paramViewGroup.mDy = ((TextView)paramView.findViewById(b.d.nearby_friend_distance));
      paramViewGroup.ffK = ((ImageView)paramView.findViewById(b.d.nearby_friend_avatar_iv));
      paramViewGroup.ffL = ((TextView)paramView.findViewById(b.d.nearby_friend_is_friend));
      paramViewGroup.mDA = ((ImageView)paramView.findViewById(b.d.nearby_friend_vuserinfo));
      paramViewGroup.mDC = ((ImageView)paramView.findViewById(b.d.nearby_friend_sns));
      paramViewGroup.mDE = ((ImageView)paramView.findViewById(b.d.nearby_friend_ad_icon_1));
      paramViewGroup.mDF = ((ImageView)paramView.findViewById(b.d.nearby_friend_ad_icon_2));
      paramViewGroup.mDG = ((ImageView)paramView.findViewById(b.d.nearby_friend_ad_icon_3));
      localObject1 = paramViewGroup.mDC.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.aa(this.context, com.tencent.mm.plugin.nearby.b.b.NormalPadding);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.aa(this.context, com.tencent.mm.plugin.nearby.b.b.NormalPadding);
      paramViewGroup.mDC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup.mDD = ((ImageView)paramView.findViewById(b.d.nearby_friend_sex));
      paramView.setTag(paramViewGroup);
      localObject1 = (atm)NearbyFriendsUI.r(this.mDs).get(paramInt);
      paramViewGroup.fdY.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, ((atm)localObject1).hRf, paramViewGroup.fdY.getTextSize()));
      if (NearbyFriendsUI.h(this.mDs) != 1) {
        break label764;
      }
      switch (((atm)localObject1).ffh)
      {
      default: 
        paramViewGroup.mDD.setVisibility(8);
        if (((atm)localObject1).tpg != 0)
        {
          paramViewGroup.mDA.setVisibility(0);
          localObject2 = BackwardSupportUtil.b.e(am.a.dVA.hL(((atm)localObject1).tpg), 2.0F);
          paramViewGroup.mDA.setImageBitmap((Bitmap)localObject2);
          paramViewGroup.mDD.setVisibility(8);
          label414:
          paramViewGroup.mDy.setText(((atm)localObject1).tpf);
          paramViewGroup.mDE.setVisibility(8);
          paramViewGroup.mDF.setVisibility(8);
          paramViewGroup.mDG.setVisibility(8);
          if ((localObject1 instanceof com.tencent.mm.plugin.nearby.a.a))
          {
            localObject2 = ((com.tencent.mm.plugin.nearby.a.a)localObject1).mCw;
            if ((localObject2 == null) || (((LinkedList)localObject2).size() != 1)) {
              break label788;
            }
            paramViewGroup.mDE.setVisibility(0);
            NearbyFriendsUI.k(paramViewGroup.mDE, (String)((LinkedList)localObject2).get(0));
          }
          label509:
          if ((((atm)localObject1).ffk != null) && (!((atm)localObject1).ffk.trim().equals(""))) {
            break label942;
          }
          paramViewGroup.mDz.setVisibility(8);
          label543:
          if ((((atm)localObject1).tpm == null) || ((((atm)localObject1).tpm.ffs & 0x1) <= 0)) {
            break label979;
          }
          paramViewGroup.mDC.setVisibility(0);
        }
        break;
      }
    }
    for (;;)
    {
      if (!NearbyFriendsUI.c.ve(((atm)localObject1).ffh)) {
        break label991;
      }
      paramViewGroup.ffK.setImageBitmap(null);
      localObject2 = new c.a();
      ((c.a)localObject2).eri = com.tencent.mm.plugin.n.c.FG();
      ((c.a)localObject2).erf = true;
      ((c.a)localObject2).erC = true;
      localObject2 = ((c.a)localObject2).OV();
      o.ON().a(((atm)localObject1).hPY, paramViewGroup.ffK, (com.tencent.mm.as.a.a.c)localObject2);
      if (bk.bl(((atm)localObject1).ffm)) {
        break label1177;
      }
      paramViewGroup.ffL.setText(((atm)localObject1).ffm);
      paramViewGroup.ffL.setVisibility(0);
      return paramView;
      paramViewGroup = (NearbyFriendsUI.d)paramView.getTag();
      break;
      paramViewGroup.mDD.setVisibility(0);
      paramViewGroup.mDD.setImageResource(b.g.ic_sex_male);
      paramViewGroup.mDD.setContentDescription(this.context.getString(b.h.male_Imgbtn));
      break label361;
      paramViewGroup.mDD.setVisibility(0);
      paramViewGroup.mDD.setImageResource(b.g.ic_sex_female);
      paramViewGroup.mDD.setContentDescription(this.context.getString(b.h.female_Imgbtn));
      break label361;
      label764:
      paramViewGroup.mDD.setVisibility(8);
      break label361;
      paramViewGroup.mDA.setVisibility(8);
      break label414;
      label788:
      if ((localObject2 != null) && (((LinkedList)localObject2).size() == 2))
      {
        paramViewGroup.mDE.setVisibility(0);
        paramViewGroup.mDF.setVisibility(0);
        NearbyFriendsUI.k(paramViewGroup.mDE, (String)((LinkedList)localObject2).get(0));
        NearbyFriendsUI.k(paramViewGroup.mDF, (String)((LinkedList)localObject2).get(1));
        break label509;
      }
      if ((localObject2 == null) || (((LinkedList)localObject2).size() < 3)) {
        break label509;
      }
      paramViewGroup.mDE.setVisibility(0);
      paramViewGroup.mDF.setVisibility(0);
      paramViewGroup.mDG.setVisibility(0);
      NearbyFriendsUI.k(paramViewGroup.mDE, (String)((LinkedList)localObject2).get(0));
      NearbyFriendsUI.k(paramViewGroup.mDF, (String)((LinkedList)localObject2).get(1));
      NearbyFriendsUI.k(paramViewGroup.mDG, (String)((LinkedList)localObject2).get(2));
      break label509;
      label942:
      paramViewGroup.mDz.setVisibility(0);
      paramViewGroup.mDz.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, ((atm)localObject1).ffk, paramViewGroup.mDz.getTextSize()));
      break label543;
      label979:
      paramViewGroup.mDC.setVisibility(8);
    }
    label991:
    a.b.a(paramViewGroup.ffK, ((atm)localObject1).hPY);
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abg(((atm)localObject1).hPY))
    {
      paramViewGroup.ffL.setVisibility(0);
      if (ad.Fn(((atm)localObject1).tpg))
      {
        paramViewGroup.ffL.setText(this.mDs.getString(b.h.nearby_friend_followed));
        return paramView;
      }
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abj(((atm)localObject1).hPY);
      Context localContext;
      if (localad != null)
      {
        localObject2 = paramViewGroup.fdY;
        localContext = this.context;
        if (!bk.bl(localad.Bq())) {
          break label1167;
        }
      }
      label1167:
      for (localObject1 = ((atm)localObject1).hRf;; localObject1 = localad.Bq())
      {
        ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.d.j.a(localContext, (CharSequence)localObject1, paramViewGroup.fdY.getTextSize()));
        paramViewGroup.ffL.setText(this.mDs.getString(b.h.nearby_friend_is_contact));
        return paramView;
      }
    }
    label1177:
    paramViewGroup.ffL.setVisibility(8);
    return paramView;
  }
  
  public final atm vd(int paramInt)
  {
    return (atm)NearbyFriendsUI.r(this.mDs).get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.b
 * JD-Core Version:    0.7.0.1
 */
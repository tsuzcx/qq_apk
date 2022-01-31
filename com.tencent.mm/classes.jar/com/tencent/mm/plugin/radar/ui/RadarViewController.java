package com.tencent.mm.plugin.radar.ui;

import a.b;
import a.d.a.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.c.c;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.b.e.c;
import com.tencent.mm.plugin.radar.b.e.d;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.protocal.c.bil;
import com.tencent.mm.protocal.c.bim;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class RadarViewController
  extends RelativeLayout
  implements c.c, e.d
{
  private static final String TAG = "MicroMsg.Radar.RadarViewController";
  public static final b nnL = new b((byte)0);
  private final b nnA = i.N(this, a.c.radar_quit_btn);
  private final b nnB = i.N(this, a.c.radar_bg_mask);
  e nnC;
  com.tencent.mm.plugin.radar.b.c nnD;
  RadarViewController.c nnE;
  private e.e nnF = e.e.nlv;
  private final boolean nnG;
  final View.OnClickListener nnH = (View.OnClickListener)new RadarViewController.f(this);
  private final int nnI = 33554432;
  private final int nnJ = this.nnI + 1;
  private final int nnK = this.nnI + 2;
  private final b nnu = a.c.f((a)new RadarViewController.h(this));
  private final b nnv = i.N(this, a.c.radar_member_detail_panel);
  private final b nnw = i.N(this, a.c.radar_search_result_grid);
  private final b nnx = i.N(this, a.c.radar_tips);
  private final b nny = i.N(this, a.c.radar_new_tip);
  private final b nnz = i.N(this, a.c.radar_new_tip_loading);
  
  public RadarViewController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = (e.d)this;
    Context localContext = paramContext.getApplicationContext();
    a.d.b.g.j(localContext, "mContext.getApplicationContext()");
    this.nnC = new e(paramAttributeSet, localContext);
    this.nnD = new com.tencent.mm.plugin.radar.b.c((c.c)this, paramContext);
  }
  
  private final void a(e.e parame)
  {
    this.nnF = parame;
    switch (h.noe[parame.ordinal()])
    {
    default: 
      return;
    case 1: 
      getRadarBgMask().setVisibility(8);
      getQuitBtn().setText(a.f.radar_quit);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      getWaveView().buU();
      getWaveView().setVisibility(0);
      parame = this.nnC;
      if (parame == null) {
        a.d.b.g.ahh("radarManager");
      }
      parame.buy();
      return;
    case 2: 
      getRadarBgMask().setVisibility(8);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      return;
    case 3: 
      if (getRadarBgMask().getVisibility() != 0)
      {
        getRadarBgMask().setAnimation(AnimationUtils.loadAnimation(getContext(), a.a.radar_button_fade_in));
        getRadarBgMask().setVisibility(0);
      }
      getQuitBtn().setText(a.f.app_cancel);
      parame = this.nnC;
      if (parame == null) {
        a.d.b.g.ahh("radarManager");
      }
      parame.buz();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(a.f.radar_searching_for_chat);
      getWaveView().buV();
      getWaveView().setVisibility(4);
      getGrid().setVisibility(4);
      parame = this.nnE;
      if (parame == null) {
        a.d.b.g.ahh("adapter");
      }
      parame.nnT.clear();
      parame.nnW.clear();
      Iterator localIterator = parame.nnW.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (View)parame.nnW.get(localObject);
        if (localObject != null)
        {
          RadarViewController.a locala = parame.nnU;
          a.d.b.g.j(localObject, "it");
          a.d.b.g.k(localObject, "view");
          int i = locala.cH((View)localObject);
          if (i > 0) {
            locala.nnO.removeMessages(i);
          }
          ((View)localObject).clearAnimation();
        }
      }
      parame.buD();
      return;
    case 4: 
      getRadarBgMask().setVisibility(0);
      parame = this.nnC;
      if (parame == null) {
        a.d.b.g.ahh("radarManager");
      }
      parame.buz();
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText(a.f.radar_create_chat_tip);
      getGrid().setVisibility(0);
      return;
    }
    getRadarBgMask().setVisibility(8);
    parame = this.nnC;
    if (parame == null) {
      a.d.b.g.ahh("radarManager");
    }
    parame.buz();
    getNewRadarTipLoading().setVisibility(0);
    getNewRadarTip().setText(a.f.radar_create_chating);
  }
  
  private final void ae(LinkedList<bio> paramLinkedList)
  {
    if (paramLinkedList == null) {
      a.d.b.g.cUk();
    }
    RadarViewController.c localc;
    if (paramLinkedList.size() == 0)
    {
      localc = this.nnE;
      if (localc == null) {
        a.d.b.g.ahh("adapter");
      }
      if (localc.getCount() == 0) {
        getRadarTips().setNoMember(true);
      }
    }
    for (;;)
    {
      y.d(TAG, "members got, size : " + paramLinkedList.size());
      boolean bool = af(paramLinkedList);
      y.d(TAG, "has friend:%s", new Object[] { String.valueOf(bool) });
      localc = this.nnE;
      if (localc == null) {
        a.d.b.g.ahh("adapter");
      }
      localc.ag(paramLinkedList);
      if ((this.nnG) && (bool)) {
        a(e.e.nlw);
      }
      return;
      getRadarTips().setNoMember(false);
    }
  }
  
  private final boolean af(LinkedList<bio> paramLinkedList)
  {
    boolean bool = false;
    if (paramLinkedList == null) {
      a.d.b.g.cUk();
    }
    Iterator localIterator = paramLinkedList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (bio)localIterator.next();
      paramLinkedList = this.nnC;
      if (paramLinkedList == null) {
        a.d.b.g.ahh("radarManager");
      }
      a.d.b.g.j(localObject, "member");
      paramLinkedList = e.a(paramLinkedList, (bio)localObject);
      if (paramLinkedList != null) {
        break label131;
      }
      paramLinkedList = g.nnt;
      localObject = g.b((bio)localObject);
      paramLinkedList = this.nnD.Lx((String)localObject);
      e locale = this.nnC;
      if (locale == null) {
        a.d.b.g.ahh("radarManager");
      }
      locale.b((String)localObject, paramLinkedList);
    }
    label131:
    for (;;)
    {
      if (paramLinkedList == c.e.nkG) {
        bool = true;
      }
      for (;;)
      {
        break;
        return bool;
      }
    }
  }
  
  private final void d(String paramString, c.e parame)
  {
    Object localObject = this.nnC;
    if (localObject == null) {
      a.d.b.g.ahh("radarManager");
    }
    if (paramString == null) {
      a.d.b.g.cUk();
    }
    localObject = ((e)localObject).Ly(paramString);
    if ((localObject != null) && (localObject != parame))
    {
      localObject = this.nnC;
      if (localObject == null) {
        a.d.b.g.ahh("radarManager");
      }
      ((e)localObject).b(paramString, parame);
      paramString = this.nnE;
      if (paramString == null) {
        a.d.b.g.ahh("adapter");
      }
      paramString.buD();
    }
  }
  
  private final TextView getNewRadarTip()
  {
    return (TextView)this.nny.getValue();
  }
  
  private final ProgressBar getNewRadarTipLoading()
  {
    return (ProgressBar)this.nnz.getValue();
  }
  
  private final View getRadarBgMask()
  {
    return (View)this.nnB.getValue();
  }
  
  private final void setRadarStatus(e.e parame)
  {
    this.nnF = parame;
  }
  
  public final void M(ad paramad)
  {
    a.d.b.g.k(paramad, "contact");
    if (getMemberDetailView().isShowing())
    {
      RadarMemberView localRadarMemberView = getMemberDetailView();
      String str = paramad.vp();
      a.d.b.g.j(str, "contact.encryptUsername");
      localRadarMemberView.c(str, c.e.nkG);
    }
    d(paramad.getUsername(), c.e.nkG);
    d(paramad.vp(), c.e.nkG);
  }
  
  public final void N(ad paramad)
  {
    a.d.b.g.k(paramad, "contact");
    Object localObject = this.nnC;
    if (localObject == null) {
      a.d.b.g.ahh("radarManager");
    }
    String str1 = paramad.getUsername();
    a.d.b.g.j(str1, "contact.username");
    if (((e)localObject).Ly(str1) == null)
    {
      localObject = this.nnC;
      if (localObject == null) {
        a.d.b.g.ahh("radarManager");
      }
      str1 = paramad.vp();
      a.d.b.g.j(str1, "contact.encryptUsername");
      if (((e)localObject).Ly(str1) == null)
      {
        localObject = new LinkedList();
        str1 = paramad.getUsername();
        a.d.b.g.j(str1, "contact.username");
        String str2 = paramad.vp();
        a.d.b.g.j(str2, "contact.encryptUsername");
        String str3 = paramad.vm();
        a.d.b.g.j(str3, "contact.nickname");
        bio localbio = new bio();
        localbio.tzC = 100;
        localbio.hPY = str1;
        localbio.hRf = str3;
        localbio.sRZ = "";
        localbio.sUr = str2;
        ((LinkedList)localObject).add(localbio);
        ae((LinkedList)localObject);
      }
    }
    if (getMemberDetailView().isShowing())
    {
      localObject = getMemberDetailView();
      str1 = paramad.vp();
      a.d.b.g.j(str1, "contact.encryptUsername");
      ((RadarMemberView)localObject).c(str1, c.e.nkH);
    }
    d(paramad.getUsername(), c.e.nkH);
    d(paramad.vp(), c.e.nkH);
  }
  
  public final void a(int paramInt1, int paramInt2, LinkedList<bio> paramLinkedList)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e(TAG, "radar member return error : %s, type : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (2 == paramInt1)
      {
        paramLinkedList = getRadarTips();
        str = getContext().getString(a.f.net_warn_no_network);
        a.d.b.g.j(str, "context.getString(R.string.net_warn_no_network)");
        paramLinkedList.Lz(str);
        return;
      }
      paramLinkedList = getRadarTips();
      String str = getContext().getString(a.f.radar_tips_network_err);
      a.d.b.g.j(str, "context.getString(R.string.radar_tips_network_err)");
      paramLinkedList.Lz(str);
      return;
    }
    ae(paramLinkedList);
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    if (paramBoolean) {
      d(paramString2, c.e.nkG);
    }
    for (;;)
    {
      paramString1 = this.nnC;
      if (paramString1 == null) {
        a.d.b.g.ahh("radarManager");
      }
      paramString1.nlh.remove(Long.valueOf(paramLong));
      return;
      RadarTipsView localRadarTipsView = getRadarTips();
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      localRadarTipsView.Lz(paramString2);
      paramString1 = this.nnC;
      if (paramString1 == null) {
        a.d.b.g.ahh("radarManager");
      }
      paramString1 = (e.c)paramString1.nlh.get(Long.valueOf(paramLong));
      if (paramString1 != null)
      {
        paramString2 = g.nnt;
        d(g.b(paramString1.nlt), paramString1.nlu);
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    if (paramBoolean1) {
      d(paramString2, c.e.nkG);
    }
    for (;;)
    {
      paramString1 = this.nnC;
      if (paramString1 == null) {
        a.d.b.g.ahh("radarManager");
      }
      paramString1.nlh.remove(Long.valueOf(paramLong));
      return;
      if (paramBoolean2)
      {
        d(paramString2, c.e.nkF);
      }
      else
      {
        RadarTipsView localRadarTipsView = getRadarTips();
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = "";
        }
        localRadarTipsView.Lz(paramString2);
        paramString1 = this.nnC;
        if (paramString1 == null) {
          a.d.b.g.ahh("radarManager");
        }
        paramString1 = (e.c)paramString1.nlh.get(Long.valueOf(paramLong));
        if (paramString1 != null)
        {
          paramString2 = g.nnt;
          d(g.b(paramString1.nlt), paramString1.nlu);
          paramString2 = g.nnt;
          d(g.c(paramString1.nlt), paramString1.nlu);
        }
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<bil> paramLinkedList)
  {
    int i = 0;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramLinkedList != null))
    {
      a(e.e.nly);
      RadarViewController.c localc = this.nnE;
      if (localc == null) {
        a.d.b.g.ahh("adapter");
      }
      c(localc.nnP).nli.clear();
      c(localc.nnP).nle.clear();
      localc.nnS.clear();
      localc.nnT.clear();
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramLinkedList != null)
      {
        localObject1 = localObject2;
        if (paramLinkedList.size() > 0)
        {
          localObject1 = new LinkedList();
          paramInt2 = paramLinkedList.size();
          paramInt1 = 0;
          Object localObject3;
          while (paramInt1 < paramInt2)
          {
            localObject2 = (bil)paramLinkedList.get(paramInt1);
            localObject3 = new bim();
            ((bim)localObject3).tCB = ((bil)localObject2).hPY;
            ((LinkedList)localObject1).add(localObject3);
            localObject3 = c(localc.nnP).nle;
            Object localObject4 = ((bil)localObject2).sUr;
            a.d.b.g.j(localObject4, "radarchatroomMember.EncodeUserName");
            String str = ((bil)localObject2).hPY;
            a.d.b.g.j(str, "radarchatroomMember.UserName");
            ((Map)localObject3).put(localObject4, str);
            localObject3 = localc.nnT;
            localObject4 = g.nnt;
            ((HashMap)localObject3).put(g.a((bil)localObject2), Integer.valueOf(0));
            paramInt1 += 1;
          }
          paramInt2 = ((Object[])localc.nnR).length;
          paramInt1 = i;
          while (paramInt1 < paramInt2)
          {
            paramLinkedList = localc.nnR[paramInt1];
            localObject2 = c(localc.nnP).nle;
            localObject3 = g.nnt;
            if (!bk.bl((String)((Map)localObject2).get(g.c(paramLinkedList))))
            {
              d(localc.nnP).d(paramLinkedList);
              c(localc.nnP).a(paramLinkedList);
            }
            paramInt1 += 1;
          }
        }
      }
      c(localc.nnP).nld = ((LinkedList)localObject1);
      paramLinkedList = this.nnE;
      if (paramLinkedList == null) {
        a.d.b.g.ahh("adapter");
      }
      paramLinkedList.buD();
      return;
    }
    a(e.e.nlv);
    paramLinkedList = getRadarTips();
    Object localObject1 = getContext().getString(a.f.radar_tips_network_err);
    a.d.b.g.j(localObject1, "context.getString(R.string.radar_tips_network_err)");
    paramLinkedList.Lz((String)localObject1);
  }
  
  final RadarSpecialGridView getGrid()
  {
    return (RadarSpecialGridView)this.nnw.getValue();
  }
  
  final RadarMemberView getMemberDetailView()
  {
    return (RadarMemberView)this.nnv.getValue();
  }
  
  final Button getQuitBtn()
  {
    return (Button)this.nnA.getValue();
  }
  
  public final e.e getRadarStatus()
  {
    return this.nnF;
  }
  
  final RadarTipsView getRadarTips()
  {
    return (RadarTipsView)this.nnx.getValue();
  }
  
  final RadarWaveView getWaveView()
  {
    return (RadarWaveView)this.nnu.getValue();
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    a.d.b.g.k(paramKeyEvent, "event");
    if ((paramInt == 4) && (getMemberDetailView().isShowing() == true))
    {
      getMemberDetailView().dismiss();
      return true;
    }
    return false;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.d.a.a.a.b.b.e;
import com.tencent.d.a.a.a.b.b.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.plugin.sport.e;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.util.b.a;
import java.util.Set;

public final class aw
  extends c
{
  private final int aeUm = 100;
  private final int aeUn = 10000;
  private final int aeUo = 86400000;
  private final int aeUp = 1;
  private final String aeUq = "werun_daily_push_list";
  private final int aeUr = 10000;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private ListView mListView;
  
  private static boolean ec(int paramInt, String paramString)
  {
    AppMethodBeat.i(255103);
    long l2 = 86400000L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      l1 = Long.parseLong(paramString);
      if (l1 * 1000L + paramInt * 1000L < cn.bDu())
      {
        AppMethodBeat.o(255103);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ChattingItemHardDeviceMsg", "isOverDue:%s,%s", new Object[] { localException, paramString });
        l1 = l2;
      }
      AppMethodBeat.o(255103);
    }
    return false;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37304);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggo);
      ((View)localObject).setTag(new a().lN((View)localObject));
    }
    AppMethodBeat.o(37304);
    return localObject;
  }
  
  public final void a(c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, final String paramString)
  {
    AppMethodBeat.i(37305);
    this.aeiK = parama1;
    this.mListView = parama1.getListView();
    a locala1 = (a)parama;
    Object localObject1 = as.iIJ().rI(paramcc.field_msgId);
    Object localObject2 = paramcc.field_content;
    final com.tencent.mm.message.k.b localb = null;
    bz localbz;
    boolean bool2;
    Object localObject5;
    Object localObject4;
    int k;
    int m;
    int j;
    int i;
    if ((localObject1 != null) && (localObject2 != null))
    {
      localb = com.tencent.mm.message.k.b.aP((String)localObject2, paramcc.field_reserved);
      localbz = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
      HardDeviceChattingItemView localHardDeviceChattingItemView = (HardDeviceChattingItemView)parama.clickArea;
      bool2 = false;
      if ((localb == null) || ((localb.hAN != 1) && (localb.nRZ != 1))) {
        break label1731;
      }
      localObject1 = (e)localb.aK(e.class);
      if (Util.isNullOrNil(localb.nRU))
      {
        localObject5 = localb.nRQ;
        Object localObject6 = localb.nRR;
        if (!Util.isNullOrNil((String)localObject5))
        {
          localObject2 = localObject5;
          localObject4 = localObject6;
          if (!Util.isNullOrNil((String)localObject6)) {}
        }
        else
        {
          Log.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[] { localObject5, localObject6 });
          localObject2 = "#ffffff";
          localObject4 = "#ffffff";
        }
        localObject5 = new StateListDrawable();
        localObject6 = new ColorDrawable(Color.parseColor((String)localObject4));
        ((StateListDrawable)localObject5).addState(new int[] { 16842919 }, (Drawable)localObject6);
        localObject4 = new ColorDrawable(Color.parseColor((String)localObject4));
        ((StateListDrawable)localObject5).addState(new int[] { 16842908 }, (Drawable)localObject4);
        localObject4 = new ColorDrawable(Color.parseColor((String)localObject2));
        ((StateListDrawable)localObject5).addState(new int[] { 16842766 }, (Drawable)localObject4);
        localObject2 = new ColorDrawable(Color.parseColor((String)localObject2));
        ((StateListDrawable)localObject5).addState(new int[0], (Drawable)localObject2);
        localHardDeviceChattingItemView.setBackgroundDrawable((Drawable)localObject5);
        localb.nRU = "#ffffff";
        localObject2 = localb.nRS;
        localObject4 = localb.nRT;
        k = R.e.white;
        m = R.e.white;
        j = m;
        i = k;
        if (!Util.isNullOrNil((String)localObject2))
        {
          j = m;
          i = k;
          if (!Util.isNullOrNil((String)localObject4)) {
            i = k;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        j = Color.parseColor((String)localObject2);
        i = j;
        k = Color.parseColor((String)localObject4);
        i = j;
        j = k;
        localObject2 = new StateListDrawable();
        localObject4 = new ColorDrawable(j);
        ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject4);
        localObject4 = new ColorDrawable(j);
        ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, (Drawable)localObject4);
        localObject4 = new ColorDrawable(i);
        ((StateListDrawable)localObject2).addState(new int[] { 16842766 }, (Drawable)localObject4);
        localObject4 = new ColorDrawable(i);
        ((StateListDrawable)localObject2).addState(new int[0], (Drawable)localObject4);
        locala1.aeUE.setBackgroundDrawable((Drawable)localObject2);
        localObject2 = localb.nRU;
        if (locala1 != null)
        {
          j = R.e.white;
          i = j;
          if (Util.isNullOrNil((String)localObject2)) {}
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        try
        {
          i = Color.parseColor((String)localObject2);
          locala1.aeUB.setTextColor(i);
          locala1.aeUC.setTextColor(i);
          locala1.aeUz.setTextColor(i);
          locala1.aeUA.setTextColor(i);
          locala1.aeUD.setTextColor(i);
          locala1.aeUB.setText(localb.nRM);
          locala1.aeUB.setTextSize(0, com.tencent.mm.cd.a.bs(parama1.aezO.getContext(), R.f.Edge_6A));
          locala1.aeUC.setText(localb.nRK);
          locala1.aeUz.setText(localb.nRO);
          locala1.aeUz.setTextSize(0, com.tencent.mm.cd.a.bs(parama1.aezO.getContext(), R.f.Edge_6A));
          locala1.aeUA.setText(localb.nRN);
          locala1.aeUD.setText(localb.nRP);
          if (!Util.isNullOrNil(localb.nRV))
          {
            locala1.aeUF.setVisibility(0);
            a.b.B(locala1.aeUF, localb.nRV);
            locala1.aeUJ.setVisibility(0);
            a.b.B(locala1.aeUJ, localb.nRV);
            locala1.aeUK.setVisibility(0);
            locala1.aeUK.setText(((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localb.nRV));
            locala1.aeUL.setVisibility(0);
            locala1.aeUL.setText(localb.nRP);
            bool1 = bool2;
            if (Util.isNullOrNil(((e)localObject1).Sba)) {}
          }
          try
          {
            i = Integer.parseInt(((e)localObject1).Sba);
            if (i != 1) {
              continue;
            }
            bool1 = true;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.ChattingItemHardDeviceMsg", "filling:%s,%s", new Object[] { localException, ((e)localObject1).Sba });
            bool1 = bool2;
            continue;
            i = ((Context)localObject5).getResources().getColor(R.e.Brand);
            try
            {
              j = Color.parseColor(localb.nRU);
              i = j;
              Log.i("MicroMsg.ChattingItemHardDeviceMsg", "fillWinterOlympic: content.fontcolor:%s", new Object[] { localb.nRU });
              i = j;
            }
            catch (IllegalArgumentException localIllegalArgumentException3)
            {
              for (;;)
              {
                Object localObject3;
                Log.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
              }
            }
            locala1.aeUI.setImageResource(R.k.rank_torch);
            localObject4 = ((e)localObject1).Sbe;
            localObject3 = localObject4;
            if (!Util.isNullOrNil((String)localObject4)) {
              break label1377;
            }
            localObject3 = ((Context)localObject5).getString(R.l.gHe);
            locala1.aeUH.setText((CharSequence)localObject3);
            locala1.aeUH.setTextColor(i);
            locala1.aeUG.setVisibility(0);
            continue;
            long l = paramcc.field_msgId;
            if (localb == null) {
              break label1696;
            }
          }
          if (bool1)
          {
            l = paramcc.field_msgId;
            if ((localb != null) && (localObject1 != null))
            {
              Integer.parseInt(localb.nRO);
              localObject5 = this.aeiK.aezO.getContext();
              if (localObject5 != null) {
                if (ec(localb.nSb, ((e)localObject1).Sbb))
                {
                  locala1.aeUG.setVisibility(8);
                  parama.clickArea.setOnLongClickListener(c(parama1));
                  parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
                  parama.clickArea.setTag(localbz);
                  parama.clickArea.setOnClickListener(d(parama1));
                  locala1.aeUM.setTag(localbz);
                  locala1.aeUM.setOnClickListener(d(parama1));
                  locala1.aeUG.setOnClickListener(new View.OnClickListener()
                  {
                    long duration = 2000L;
                    long lastClickTime = 0L;
                    
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(255548);
                      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemHardDeviceMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                      if (System.currentTimeMillis() - this.lastClickTime <= this.duration)
                      {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemHardDeviceMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(255548);
                        return;
                      }
                      this.lastClickTime = System.currentTimeMillis();
                      if (bool1)
                      {
                        d.g(44, 0, Integer.parseInt(localb.nRO), "2022_hj");
                        paramAnonymousView = new brs();
                        paramAnonymousView.ZZU = 1;
                        localObject = new dwa();
                        b.e.a locala = b.e.ahon;
                        ((dwa)localObject).abbK = b.e.a.jWa();
                        ((dwa)localObject).hLv = paramString;
                        ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).gotoLive(parama1.aezO.getContext(), this.aeUu.Sbc, paramAnonymousView, (dwa)localObject);
                      }
                      for (;;)
                      {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemHardDeviceMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(255548);
                        return;
                        Log.i("MicroMsg.ChattingItemHardDeviceMsg", "onClick: setTextStatusLl");
                        if (aw.ed(localb.nSb, this.aeUu.SaZ))
                        {
                          aa.y(parama1.aezO.getContext(), parama1.aezO.getContext().getString(R.l.gGR), R.k.icons_outlined_info);
                        }
                        else if (this.aeUu != null)
                        {
                          d.g(44, 0, Integer.parseInt(localb.nRO), this.aeUu.SaX);
                          aw.a(aw.this, this.aeUu.SaX, this.aeUu.SaY, Integer.parseInt(localb.nRO));
                        }
                      }
                    }
                  });
                  this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
                  {
                    public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
                    {
                      AppMethodBeat.i(255556);
                      if (paramAnonymousInt2 == 0)
                      {
                        AppMethodBeat.o(255556);
                        return;
                      }
                      aw.a(aw.this).getFirstVisiblePosition();
                      aw.a(aw.this).getLastVisiblePosition();
                      paramAnonymousAbsListView = k.aeZF;
                      Object localObject;
                      if (!((com.tencent.mm.ui.chatting.m.c)k.nq(parama1.aezO.getContext()).q(com.tencent.mm.ui.chatting.m.c.class)).jxe().contains(String.valueOf(paramcc.field_msgId)))
                      {
                        localObject = null;
                        if (!bool1) {
                          break label221;
                        }
                        if (aw.ed(localb.nSb, this.aeUu.Sbb))
                        {
                          AppMethodBeat.o(255556);
                          return;
                        }
                        paramAnonymousAbsListView = "2022_hj";
                      }
                      for (;;)
                      {
                        if (!Util.isNullOrNil(paramAnonymousAbsListView))
                        {
                          Log.i("MicroMsg.ChattingItemHardDeviceMsg", "onScroll: report iconId:%s, position:%s", new Object[] { paramAnonymousAbsListView, Integer.valueOf(paramInt) });
                          d.g(43, 0, Integer.parseInt(localb.nRO), paramAnonymousAbsListView);
                          paramAnonymousAbsListView = k.aeZF;
                          ((com.tencent.mm.ui.chatting.m.c)k.nq(parama1.aezO.getContext()).q(com.tencent.mm.ui.chatting.m.c.class)).jxe().add(String.valueOf(paramcc.field_msgId));
                        }
                        AppMethodBeat.o(255556);
                        return;
                        label221:
                        paramAnonymousAbsListView = localObject;
                        if (this.aeUu != null)
                        {
                          paramAnonymousAbsListView = localObject;
                          if (!Util.isNullOrNil(this.aeUu.SaX))
                          {
                            if (aw.ed(localb.nSb, this.aeUu.SaZ))
                            {
                              AppMethodBeat.o(255556);
                              return;
                            }
                            paramAnonymousAbsListView = this.aeUu.SaX;
                          }
                        }
                      }
                    }
                    
                    public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
                  });
                  AppMethodBeat.o(37305);
                  return;
                  if (localObject1 == null)
                  {
                    bool1 = true;
                    Log.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool1), Util.secPrint((String)localObject2), Long.valueOf(paramcc.field_msgId), paramString });
                    break;
                  }
                  bool1 = false;
                  continue;
                  localIllegalArgumentException1 = localIllegalArgumentException1;
                  Log.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
                  j = m;
                }
              }
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          Log.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
          i = j;
          continue;
          locala1.aeUF.setVisibility(8);
          locala1.aeUJ.setVisibility(8);
          locala1.aeUK.setVisibility(8);
          locala1.aeUL.setVisibility(8);
          continue;
          bool1 = false;
          continue;
        }
      }
      label1377:
      label1521:
      label1527:
      a.a locala;
      if (localObject1 != null)
      {
        j = Integer.parseInt(localb.nRO);
        if (((j <= 100) || (j >= 10000)) && (!TextUtils.isEmpty(((e)localObject1).SaX))) {
          if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zuC, b.a.agrn, 1) != 1) {
            break label1521;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1527;
          }
          locala1.aeUG.setVisibility(8);
          break;
        }
        localObject4 = this.aeiK.aezO.getContext();
        if (localObject4 != null)
        {
          i = ((Context)localObject4).getResources().getColor(R.e.FG_4);
          locala = a.a.ThA;
          if (j >= 100) {
            break label1699;
          }
          i = ((Context)localObject4).getResources().getColor(R.e.Brand);
          locala = a.a.Thu;
          label1587:
          if (!ec(localb.nSb, ((e)localObject1).SaZ)) {
            break label1728;
          }
          i = ((Context)localObject4).getResources().getColor(R.e.FG_4);
          locala = a.a.ThA;
        }
      }
      label1696:
      label1699:
      label1728:
      for (;;)
      {
        localObject4 = ((e)localObject1).SaX;
        locala1.aeUH.setText(this.aeiK.aezO.getContext().getString(R.l.gGQ));
        locala1.aeUH.setTextColor(i);
        ((f)h.az(f.class)).setIcon(locala1.aeUI, (String)localObject4, a.c.ThP, locala);
        locala1.aeUG.setVisibility(0);
        break;
        if (j <= 10000) {
          break label1587;
        }
        i = ((Context)localObject4).getResources().getColor(R.e.Orange);
        locala = a.a.Tht;
        break label1587;
      }
      label1731:
      final boolean bool1 = false;
      localObject1 = null;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37307);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37307);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255137);
    params.a(((bz)paramView.getTag()).position, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(255137);
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    int i = 0;
    AppMethodBeat.i(37308);
    String str = paramcc.field_content;
    paramView = com.tencent.mm.message.k.b.aP(str, paramcc.field_reserved);
    if (paramView == null)
    {
      Log.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
      AppMethodBeat.o(37308);
      return false;
    }
    Log.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!Util.isNullOrNil(paramView.url))
    {
      paramcc = new Intent();
      paramcc.putExtra("rawUrl", paramView.url);
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
      AppMethodBeat.o(37308);
      return true;
    }
    if (!Util.isNullOrNil(paramView.nRL))
    {
      int j = paramView.nSb;
      if (System.currentTimeMillis() - j * 1000L >= 2592000000L) {
        i = 1;
      }
      if (i == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_rank_info", str);
        localIntent.putExtra("key_rank_semi", paramcc.field_reserved);
        localIntent.putExtra("key_rank_title", paramView.nRW);
        localIntent.putExtra("key_champion_info", paramView.nRX);
        localIntent.putExtra("key_champion_coverimg", paramView.nRX);
        localIntent.putExtra("rank_id", paramView.nRL);
        localIntent.putExtra("app_username", paramView.appName);
        localIntent.putExtra("device_type", paramView.nSa);
        localIntent.putExtra("key_champioin_username", paramView.nRV);
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        d.rG(28);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37308);
      return true;
      com.tencent.mm.br.c.ai(parama.aezO.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
    }
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048185;
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView aeUA;
    protected TextView aeUB;
    protected TextView aeUC;
    protected TextView aeUD;
    protected TextView aeUE;
    protected ImageView aeUF;
    protected LinearLayout aeUG;
    protected TextView aeUH;
    protected ImageView aeUI;
    protected ImageView aeUJ;
    protected TextView aeUK;
    protected TextView aeUL;
    protected LinearLayout aeUM;
    protected TextView aeUz;
    
    a() {}
    
    public final a lN(View paramView)
    {
      AppMethodBeat.i(37303);
      super.create(paramView);
      this.aeUz = ((TextView)paramView.findViewById(R.h.fYi));
      this.aeUB = ((TextView)paramView.findViewById(R.h.fUa));
      this.aeUA = ((TextView)paramView.findViewById(R.h.fYj));
      this.aeUC = ((TextView)paramView.findViewById(R.h.fUb));
      this.aeUD = ((TextView)paramView.findViewById(R.h.gcb));
      this.aeUE = ((TextView)paramView.findViewById(R.h.fJD));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
      this.aeUF = ((ImageView)paramView.findViewById(R.h.gbT));
      this.aeUG = ((LinearLayout)paramView.findViewById(R.h.fMZ));
      this.aeUH = ((TextView)paramView.findViewById(R.h.gaM));
      this.aeUI = ((ImageView)paramView.findViewById(R.h.fLO));
      this.aeUJ = ((ImageView)paramView.findViewById(R.h.fLP));
      this.aeUK = ((TextView)paramView.findViewById(R.h.gaZ));
      this.aeUL = ((TextView)paramView.findViewById(R.h.gba));
      this.aeUM = ((LinearLayout)paramView.findViewById(R.h.fNd));
      AppMethodBeat.o(37303);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw
 * JD-Core Version:    0.7.0.1
 */
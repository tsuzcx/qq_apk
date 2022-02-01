package com.tencent.mm.ui.chatting.viewitems.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.r;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.viewitems.av.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1;", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl;", "()V", "INFRINGEMENT_URL_FORMAT", "", "MENU_ID_COMPLAINT", "", "MENU_ID_REJECT", "MENU_ID_UNREJECT", "TAG", "getTAG", "()Ljava/lang/String;", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$TmplHolderV1;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "moreMenu", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "filling", "", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemFinderLiveNotifyTmpl$FinderLiveNotifyHolder;", "values", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "getHolder", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "Companion", "InfoItem", "TmplHolderV1", "app_release"})
public final class a
  implements b
{
  private static final String Xob = "TipsTempl_MultiReason_Live";
  public static final a.a Xoc;
  private static final MultiProcessMMKV cQO;
  final String TAG;
  private e XiM;
  private final String Xix;
  private final int XnY;
  private final int XnZ;
  private final c Xoa;
  private final int xTa;
  
  static
  {
    AppMethodBeat.i(288576);
    Xoc = new a.a((byte)0);
    Xob = "TipsTempl_MultiReason_Live";
    cQO = MultiProcessMMKV.getMMKV("FINDER_LIVE_NOTIFY_REJECT_STATUS");
    AppMethodBeat.o(288576);
  }
  
  public a()
  {
    AppMethodBeat.i(288575);
    this.TAG = "FinderLiveNotifyTmplV1";
    this.xTa = 1;
    this.XnY = 2;
    this.XnZ = 3;
    this.Xix = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=62&liveid=%s&liveidentityid=%s&wechat_real_lang=%s";
    this.Xoa = new c();
    AppMethodBeat.o(288575);
  }
  
  public final void a(final av.a parama, final Map<String, String> paramMap, final ca paramca, final com.tencent.mm.ui.chatting.e.a parama1)
  {
    AppMethodBeat.i(288574);
    p.k(paramMap, "values");
    p.k(parama1, "ui");
    Object localObject3;
    Object localObject4;
    if (parama != null)
    {
      localObject2 = Xob;
      p.k(localObject2, "tmplId");
      localObject1 = (b.a)parama.XjR.get(localObject2);
      parama = parama.XjR.entrySet();
      p.j(parama, "holders.entries");
      localObject3 = (Iterable)parama;
      parama = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        if ((p.h((String)((Map.Entry)localObject4).getKey(), localObject2) ^ true)) {
          parama.add(localObject4);
        }
      }
      parama = ((Iterable)parama).iterator();
      while (parama.hasNext()) {
        ((b.a)((Map.Entry)parama.next()).getValue()).GG(false);
      }
      if (localObject1 != null) {
        ((b.a)localObject1).GG(true);
      }
      parama = (c)localObject1;
      localObject1 = t.ztT;
      localObject2 = t.dJh();
      localObject3 = new x(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".title.avatar")), u.Alz);
      if (parama == null) {
        break label798;
      }
      localObject1 = parama.mWb;
      label273:
      if (localObject1 == null) {
        p.iCn();
      }
      localObject4 = t.ztT;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, (ImageView)localObject1, t.a(t.a.zua));
      localObject1 = parama.znp;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".title.nickname")));
      }
      localObject1 = (String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".title.icon_url");
      if (localObject1 == null) {
        break label816;
      }
      if (((CharSequence)localObject1).length() <= 0) {
        break label804;
      }
      i = 1;
      label406:
      if (i == 0) {
        break label810;
      }
      label411:
      if (localObject1 == null) {
        break label816;
      }
      localObject2 = t.ztT;
      localObject2 = t.dJh();
      localObject1 = new x((String)localObject1, u.Alz);
      localObject3 = parama.Xod;
      if (localObject3 == null) {
        p.iCn();
      }
      localObject4 = t.ztT;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, t.a(t.a.zua));
      localObject1 = parama.Xod;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      label491:
      localObject4 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".tipsinfo.finder_username"));
      boolean bool = cQO.getBoolean((String)localObject4, false);
      localObject1 = parama.Xoj;
      if (localObject1 != null) {
        if (!bool) {
          break label837;
        }
      }
    }
    String str;
    label798:
    label804:
    label810:
    label816:
    label837:
    for (int i = 0;; i = 8)
    {
      ((View)localObject1).setVisibility(i);
      localObject1 = parama.jMg;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".header")));
      }
      localObject2 = ".msg.appmsg.extinfo.notifymsg" + ".display_list.item";
      localObject3 = new LinkedList();
      localObject1 = localObject2;
      i = 1;
      while (paramMap.containsKey(localObject1))
      {
        str = Util.nullAsNil((String)paramMap.get((String)localObject1 + ".topic"));
        localObject1 = Util.nullAsNil((String)paramMap.get((String)localObject1 + ".content"));
        if ((str != null) && (localObject1 != null)) {
          ((LinkedList)localObject3).add(new a.b(str, (String)localObject1));
        }
        localObject1 = (String)localObject2 + i;
        i += 1;
      }
      parama = null;
      break;
      localObject1 = null;
      break label273;
      i = 0;
      break label406;
      localObject1 = null;
      break label411;
      localObject1 = parama.Xod;
      if (localObject1 == null) {
        break label491;
      }
      ((ImageView)localObject1).setVisibility(8);
      break label491;
    }
    parama.kv((List)localObject3);
    Object localObject2 = paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".live_widget.thumb_url");
    Object localObject1 = paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".live_widget.status");
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject1 = (String)localObject1;
      localObject2 = (String)localObject2;
    }
    for (;;)
    {
      try
      {
        str = Util.nullAsNil((String)localObject2);
        p.j(str, "Util.nullAsNil(url)");
        int j = Integer.parseInt((String)localObject1);
        p.k(str, "url");
        localObject1 = parama.Xog;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = parama.Xog;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = (ImageView)((View)localObject1).findViewById(R.h.dGY);
        localObject2 = parama.Xog;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((View)localObject2).findViewById(R.h.finder_live_icon);
        localObject3 = parama.Xog;
        if (localObject3 == null) {
          continue;
        }
        localObject3 = ((View)localObject3).findViewById(R.h.finder_live_end_tag);
        if (((CharSequence)str).length() <= 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        if (j != 1) {
          continue;
        }
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(str, (ImageView)localObject1);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
        if (localObject3 != null) {
          ((View)localObject3).setVisibility(8);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1;
        final long l2;
        Log.i(this.TAG, localNumberFormatException.getMessage());
        continue;
        View localView = parama.Xog;
        if (localView == null) {
          continue;
        }
        localView.setVisibility(8);
        continue;
        i = 0;
        continue;
        localView = parama.Xoi;
        if (localView == null) {
          continue;
        }
        localView.setVisibility(8);
        continue;
        AppMethodBeat.o(288574);
      }
      localObject1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".tail"));
      p.j(localObject1, "tailStr");
      if (((CharSequence)localObject1).length() <= 0) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      localObject2 = parama.Xoi;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      localObject2 = parama.Xoh;
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      l1 = com.tencent.mm.ae.d.Nb(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".tipsinfo.object_id")));
      l2 = com.tencent.mm.ae.d.Nb(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".tipsinfo.live_id")));
      localObject2 = (String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".tipsinfo.object_nonce_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = Util.nullAsNil((String)localObject1);
      p.j(localObject3, "Util.nullAsNil(values[\"$….object_nonce_id\"] ?: \"\")");
      localObject2 = (String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".tipsinfo.tips_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      str = Util.nullAsNil((String)localObject1);
      p.j(str, "Util.nullAsNil(values[\"$…tipsinfo.tips_id\"] ?: \"\")");
      localObject2 = (String)paramMap.get(".msg.appmsg.extinfo.notifymsg" + ".tipsinfo.notice_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = Util.nullAsNil((String)localObject1);
      localObject2 = parama.amk;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new a.d(this, (String)localObject1, parama1, l1, l2, (String)localObject3, paramca, (String)localObject4, str));
      }
      localObject2 = parama.Xoe;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new e(this, parama1, (String)localObject4, paramca, paramMap, ".msg.appmsg.extinfo.notifymsg", parama, l2));
      }
      com.tencent.e.h.ZvG.be((Runnable)new a.f(paramca));
      parama = parama.amk;
      if (parama == null) {
        continue;
      }
      f.a(parama, (e.b)new a.g(paramca, (String)localObject1, (String)localObject4, l2, str));
      AppMethodBeat.o(288574);
      return;
      localObject1 = null;
      continue;
      localObject2 = null;
      continue;
      localObject3 = null;
      continue;
      i = 0;
      continue;
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().f((ImageView)localObject1, str);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(0);
      }
    }
  }
  
  public final b.a hTZ()
  {
    return (b.a)this.Xoa;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$TmplHolderV1;", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "()V", "auth", "Landroid/widget/ImageView;", "getAuth", "()Landroid/widget/ImageView;", "setAuth", "(Landroid/widget/ImageView;)V", "avatar", "getAvatar", "setAvatar", "infoList", "Landroid/widget/LinearLayout;", "getInfoList", "()Landroid/widget/LinearLayout;", "setInfoList", "(Landroid/widget/LinearLayout;)V", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "liveWidgetLayout", "getLiveWidgetLayout", "setLiveWidgetLayout", "more", "getMore", "setMore", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", "reject", "getReject", "setReject", "tail", "getTail", "setTail", "tailLayout", "getTailLayout", "setTailLayout", "title", "getTitle", "setTitle", "addInfo", "", "itemList", "", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$InfoItem;", "hideOrShow", "isShow", "", "initView", "view", "refreshLiveWidget", "url", "", "state", "", "setOnLongClickListener", "listener", "Landroid/view/View$OnLongClickListener;", "tag", "", "setOnTouchListener", "ls", "Landroid/view/View$OnTouchListener;", "app_release"})
  public static final class c
    implements b.a
  {
    ImageView Xod;
    View Xoe;
    private LinearLayout Xof;
    View Xog;
    TextView Xoh;
    View Xoi;
    View Xoj;
    View amk;
    TextView jMg;
    ImageView mWb;
    TextView znp;
    
    public final void GG(boolean paramBoolean)
    {
      AppMethodBeat.i(283077);
      View localView = this.amk;
      if (localView != null)
      {
        if (paramBoolean) {}
        for (int i = 0;; i = 8)
        {
          localView.setVisibility(i);
          AppMethodBeat.o(283077);
          return;
        }
      }
      AppMethodBeat.o(283077);
    }
    
    public final void a(View.OnLongClickListener paramOnLongClickListener, Object paramObject)
    {
      AppMethodBeat.i(283078);
      p.k(paramOnLongClickListener, "listener");
      p.k(paramObject, "tag");
      View localView = this.amk;
      if (localView != null) {
        localView.setOnLongClickListener(paramOnLongClickListener);
      }
      paramOnLongClickListener = this.amk;
      if (paramOnLongClickListener != null)
      {
        paramOnLongClickListener.setTag(paramObject);
        AppMethodBeat.o(283078);
        return;
      }
      AppMethodBeat.o(283078);
    }
    
    public final void ix(View paramView)
    {
      AppMethodBeat.i(283076);
      p.k(paramView, "view");
      this.amk = paramView.findViewById(R.h.dXA);
      View localView = this.amk;
      if (localView != null)
      {
        this.mWb = ((ImageView)localView.findViewById(R.h.dQq));
        this.znp = ((TextView)localView.findViewById(R.h.dQt));
        this.Xod = ((ImageView)localView.findViewById(R.h.dQp));
        this.Xoe = localView.findViewById(R.h.dQs);
        this.jMg = ((TextView)localView.findViewById(R.h.dLe));
        paramView = this.jMg;
        if (paramView != null) {}
        for (paramView = paramView.getPaint();; paramView = null)
        {
          ar.a((Paint)paramView, 0.8F);
          this.Xof = ((LinearLayout)localView.findViewById(R.h.dQr));
          this.Xog = localView.findViewById(R.h.dGX);
          this.Xoh = ((TextView)localView.findViewById(R.h.dQv));
          this.Xoi = localView.findViewById(R.h.dQu);
          this.Xoj = localView.findViewById(R.h.dQo);
          AppMethodBeat.o(283076);
          return;
        }
      }
      AppMethodBeat.o(283076);
    }
    
    public final void kv(List<a.b> paramList)
    {
      AppMethodBeat.i(283080);
      p.k(paramList, "itemList");
      View localView1 = this.amk;
      if (localView1 != null)
      {
        Object localObject1 = this.Xof;
        if (localObject1 != null) {
          ((LinearLayout)localObject1).removeAllViews();
        }
        paramList = ((Iterable)paramList).iterator();
        while (paramList.hasNext())
        {
          Object localObject2 = (a.b)paramList.next();
          localObject1 = ad.kS(localView1.getContext()).inflate(R.i.ehd, null);
          View localView2 = ((View)localObject1).findViewById(R.h.dJg);
          p.j(localView2, "infoItemView.findViewById<TextView>(R.id.info_key)");
          ((TextView)localView2).setText((CharSequence)((a.b)localObject2).key);
          localView2 = ((View)localObject1).findViewById(R.h.dJh);
          p.j(localView2, "infoItemView.findViewByI…extView>(R.id.info_value)");
          ((TextView)localView2).setText((CharSequence)((a.b)localObject2).value);
          localObject2 = this.Xof;
          if (localObject2 != null) {
            ((LinearLayout)localObject2).addView((View)localObject1);
          }
        }
        AppMethodBeat.o(283080);
        return;
      }
      AppMethodBeat.o(283080);
    }
    
    public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
    {
      AppMethodBeat.i(283079);
      p.k(paramOnTouchListener, "ls");
      View localView = this.amk;
      if (localView != null)
      {
        localView.setOnTouchListener(paramOnTouchListener);
        AppMethodBeat.o(283079);
        return;
      }
      AppMethodBeat.o(283079);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama, com.tencent.mm.ui.chatting.e.a parama1, String paramString1, ca paramca, Map paramMap, String paramString2, a.c paramc, long paramLong) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286175);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$filling$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.Xok, new e((Context)parama1.getContext(), 1, false));
      paramView = a.Xoc;
      final boolean bool = a.hUb().getBoolean(this.Xol, false);
      paramView = a.a(this.Xok);
      if (paramView == null) {
        p.iCn();
      }
      paramView.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(279973);
          paramAnonymouso.clear();
          Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject = this.Xop.lEd;
          long l;
          int i;
          if (localObject != null)
          {
            l = ((ca)localObject).apG();
            if (!com.tencent.mm.plugin.finder.utils.aj.T(l, 8))
            {
              if (!bool) {
                break label200;
              }
              i = a.b(this.Xop.Xok);
              localObject = MMApplicationContext.getContext();
              p.j(localObject, "MMApplicationContext.getContext()");
              paramAnonymouso.add(0, i, 0, (CharSequence)((Context)localObject).getResources().getString(R.l.etL, new Object[] { this.Xop.Vfs.get(this.Xop.Xon + ".title.nickname") }));
            }
          }
          for (;;)
          {
            i = a.d(this.Xop.Xok);
            localObject = MMApplicationContext.getContext();
            p.j(localObject, "MMApplicationContext.getContext()");
            paramAnonymouso.add(0, i, 0, (CharSequence)((Context)localObject).getResources().getString(R.l.eOe));
            AppMethodBeat.o(279973);
            return;
            l = -1L;
            break;
            label200:
            i = a.c(this.Xop.Xok);
            localObject = MMApplicationContext.getContext();
            p.j(localObject, "MMApplicationContext.getContext()");
            int j = ((Context)localObject).getResources().getColor(R.e.Red);
            localObject = MMApplicationContext.getContext();
            p.j(localObject, "MMApplicationContext.getContext()");
            paramAnonymouso.a(i, j, (CharSequence)((Context)localObject).getResources().getString(R.l.etK, new Object[] { this.Xop.Vfs.get(this.Xop.Xon + ".title.nickname") }));
          }
        }
      });
      paramView = a.a(this.Xok);
      if (paramView == null) {
        p.iCn();
      }
      paramView.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(275516);
          p.j(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          if (paramAnonymousInt == a.c(this.Xop.Xok))
          {
            paramAnonymousMenuItem = this.Xop.Xol;
            if (paramAnonymousMenuItem != null)
            {
              ((r)com.tencent.mm.kernel.h.ae(r.class)).c(paramAnonymousMenuItem, true, (com.tencent.mm.plugin.findersdk.a.aj)new a(paramAnonymousMenuItem, this));
              AppMethodBeat.o(275516);
              return;
            }
            AppMethodBeat.o(275516);
            return;
          }
          if (paramAnonymousInt == a.b(this.Xop.Xok))
          {
            paramAnonymousMenuItem = this.Xop.Xol;
            if (paramAnonymousMenuItem != null)
            {
              ((r)com.tencent.mm.kernel.h.ae(r.class)).c(paramAnonymousMenuItem, false, (com.tencent.mm.plugin.findersdk.a.aj)new b(paramAnonymousMenuItem, this));
              AppMethodBeat.o(275516);
              return;
            }
            AppMethodBeat.o(275516);
            return;
          }
          if (paramAnonymousInt == a.d(this.Xop.Xok))
          {
            paramAnonymousMenuItem = af.aaBG;
            paramAnonymousMenuItem = String.format(a.e(this.Xop.Xok), Arrays.copyOf(new Object[] { Long.valueOf(this.Xop.khN), this.Xop.Xol, LocaleUtil.getApplicationLanguage() }, 3));
            p.j(paramAnonymousMenuItem, "java.lang.String.format(format, *args)");
            Log.i(this.Xop.Xok.TAG, "go to complain page");
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousMenuItem);
            com.tencent.mm.ui.chatting.viewitems.c.q(localIntent, this.Xop.Xcd.getTalkerUserName());
            com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(275516);
        }
        
        @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$filling$6$2$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFollowNotifySetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "app_release"})
        public static final class a
          implements com.tencent.mm.plugin.findersdk.a.aj<beu>
        {
          a(String paramString, a.e.2 param2) {}
        }
        
        @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$filling$6$2$2$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFollowNotifySetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "app_release"})
        public static final class b
          implements com.tencent.mm.plugin.findersdk.a.aj<beu>
        {
          b(String paramString, a.e.2 param2) {}
        }
      });
      paramView = a.a(this.Xok);
      if (paramView != null) {
        paramView.eik();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$filling$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.a
 * JD-Core Version:    0.7.0.1
 */
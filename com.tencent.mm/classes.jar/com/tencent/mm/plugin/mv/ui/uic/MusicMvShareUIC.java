package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.a.e.a;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvShareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "currentShareMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "clickListMenu", "", "musicMv", "clickMoreMenu", "doFav", "doShareMvToTimeLine", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "Landroid/app/Activity;", "coverBm", "Landroid/graphics/Bitmap;", "CoverLocalPath", "", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "doShareToChat", "doShareToSns", "getMvCoverLocalPath", "mv", "onCreateMVBtnClicked", "Companion", "plugin-mv_release"})
public final class MusicMvShareUIC
  extends UIComponent
{
  public static final a Awa;
  private e AvZ;
  
  static
  {
    AppMethodBeat.i(257366);
    Awa = new a((byte)0);
    AppMethodBeat.o(257366);
  }
  
  public MusicMvShareUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257365);
    AppMethodBeat.o(257365);
  }
  
  private final String j(e parame)
  {
    AppMethodBeat.i(257364);
    Object localObject = parame.ApD;
    int i;
    if (localObject != null)
    {
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
      }
      for (;;)
      {
        if ((localObject == null) || (!s.YS((String)localObject))) {
          break label62;
        }
        AppMethodBeat.o(257364);
        return localObject;
        i = 0;
        break;
        label57:
        localObject = null;
      }
    }
    label62:
    parame = parame.coverUrl;
    if (parame != null)
    {
      if (((CharSequence)parame).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label122;
        }
      }
      for (;;)
      {
        if (parame == null) {
          break label127;
        }
        localObject = com.tencent.mm.plugin.mv.ui.a.ArA;
        parame = com.tencent.mm.plugin.mv.ui.a.aIo(parame);
        if (!s.YS(parame)) {
          break label127;
        }
        AppMethodBeat.o(257364);
        return parame;
        i = 0;
        break;
        label122:
        parame = null;
      }
    }
    label127:
    parame = com.tencent.mm.ui.component.a.PRN;
    parame = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
    p.g(parame, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    localObject = (MusicMvDataUIC)parame;
    parame = ((MusicMvDataUIC)localObject).Atr.thumbPath;
    if (parame != null)
    {
      if (((CharSequence)parame).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label209;
        }
      }
      for (;;)
      {
        if ((parame == null) || (!s.YS(parame))) {
          break label214;
        }
        AppMethodBeat.o(257364);
        return parame;
        i = 0;
        break;
        label209:
        parame = null;
      }
    }
    label214:
    parame = ((MusicMvDataUIC)localObject).Aqo.Djf;
    if (parame != null)
    {
      p.g(parame, "it");
      if (((CharSequence)parame).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label291;
        }
      }
      for (;;)
      {
        if (parame == null) {
          break label296;
        }
        localObject = com.tencent.mm.plugin.mv.ui.a.ArA;
        p.g(parame, "url");
        parame = com.tencent.mm.plugin.mv.ui.a.aIo(parame);
        if (!s.YS(parame)) {
          break label296;
        }
        AppMethodBeat.o(257364);
        return parame;
        i = 0;
        break;
        label291:
        parame = null;
      }
    }
    label296:
    AppMethodBeat.o(257364);
    return null;
  }
  
  public final void i(e parame)
  {
    AppMethodBeat.i(257363);
    p.h(parame, "musicMv");
    Intent localIntent = new Intent();
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = com.tencent.mm.ui.component.a.ko((Context)getContext()).get(MusicMvDataUIC.class);
    p.g(localObject1, "UICProvider.of(context).…sicMvDataUIC::class.java)");
    Object localObject3 = (MusicMvDataUIC)localObject1;
    csp localcsp = new csp();
    localObject1 = new FinderObject();
    Object localObject2 = parame.ApE;
    long l;
    axw localaxw;
    if (localObject2 != null)
    {
      l = ((Long)localObject2).longValue();
      ((FinderObject)localObject1).id = l;
      ((FinderObject)localObject1).objectNonceId = parame.ApF;
      localObject2 = new FinderObjectDesc();
      localaxw = new axw();
      localaxw.Aqo = ((MusicMvDataUIC)localObject3).Aqo;
      localObject3 = new axx();
      ((axx)localObject3).LIe = 0.0F;
      localaxw.ApI = ((axx)localObject3);
      if (parame.ApM != 1) {
        break label344;
      }
      localaxw.LId = parame.ApH;
      label176:
      ((FinderObjectDesc)localObject2).mvInfo = localaxw;
      ((FinderObject)localObject1).objectDesc = ((FinderObjectDesc)localObject2);
      localcsp.MxE = ((FinderObject)localObject1);
      if (parame.ApM != 1) {
        break label409;
      }
      localcsp.LDi = parame.ApL;
      label214:
      localObject1 = localcsp.MxE;
      if (localObject1 == null) {
        break label429;
      }
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 == null) {
        break label429;
      }
    }
    label409:
    label429:
    for (localObject1 = ((FinderObjectDesc)localObject1).mvInfo;; localObject1 = null)
    {
      localcsp.MxG = ((axw)localObject1);
      localcsp.MxF = j(parame);
      localIntent.putExtra("key_track_data", localcsp.toByteArray());
      parame = c.Akc;
      c.sm(true);
      parame = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.L((Context)getActivity(), localIntent);
      parame = SecDataUIC.CWq;
      parame = (cst)SecDataUIC.a.a((Context)getContext(), 7, cst.class);
      if (parame == null) {
        break label435;
      }
      parame.MxN = 1;
      AppMethodBeat.o(257363);
      return;
      l = 0L;
      break;
      label344:
      if (parame.ApM != 4) {
        break label176;
      }
      localObject3 = parame.ApP;
      if (localObject3 == null) {
        break label176;
      }
      localObject3 = ((FinderObject)localObject3).objectDesc;
      if (localObject3 == null) {
        break label176;
      }
      localObject3 = ((FinderObjectDesc)localObject3).mvInfo;
      if (localObject3 == null) {
        break label176;
      }
      localObject3 = ((axw)localObject3).LId;
      if (localObject3 == null) {
        break label176;
      }
      localaxw.LId = ((LinkedList)localObject3);
      break label176;
      if (parame.ApM != 4) {
        break label214;
      }
      localcsp.LDi = parame.ApQ;
      break label214;
    }
    label435:
    AppMethodBeat.o(257363);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvShareUIC$Companion;", "", "()V", "MENU_ID_SECOND_CREATE_MV", "", "MENU_ID_SECOND_DEL_MV", "MENU_ID_SECOND_EXPOSE_MV", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_SNS", "SHARE_TO_CHAT_REQUEST_CODE", "SHARE_TO_SNS_REQUEST_CODE", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class b
    implements o.f
  {
    public b(MusicMvShareUIC paramMusicMvShareUIC) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(257353);
      paramm.b(101, (CharSequence)this.Awb.getString(2131755985), 0);
      paramm.b(102, (CharSequence)this.Awb.getString(2131755984), 0);
      AppMethodBeat.o(257353);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class c
    implements o.g
  {
    public c(MusicMvShareUIC paramMusicMvShareUIC, e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(257354);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(257354);
        return;
        MusicMvShareUIC.a(this.Awb, this.Awc);
        AppMethodBeat.o(257354);
        return;
        MusicMvShareUIC.b(this.Awb, this.Awc);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class d
    implements o.f
  {
    public d(MusicMvShareUIC paramMusicMvShareUIC, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(257355);
      CharSequence localCharSequence = (CharSequence)this.Awb.getContext().getString(2131755985);
      int i = this.Awb.getContext().getResources().getColor(2131099710);
      if (!this.Awd)
      {
        bool = true;
        paramm.a(101, localCharSequence, 2131690244, i, bool);
        localCharSequence = (CharSequence)this.Awb.getContext().getString(2131755984);
        if (this.Awd) {
          break label149;
        }
        bool = true;
        label86:
        paramm.a(102, localCharSequence, 2131689830, 0, bool);
        localCharSequence = (CharSequence)this.Awb.getContext().getString(2131763348);
        if (this.Awd) {
          break label154;
        }
      }
      label149:
      label154:
      for (boolean bool = true;; bool = false)
      {
        paramm.a(103, localCharSequence, 2131689821, 0, bool);
        AppMethodBeat.o(257355);
        return;
        bool = false;
        break;
        bool = false;
        break label86;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class e
    implements o.f
  {
    public e(MusicMvShareUIC paramMusicMvShareUIC, boolean paramBoolean1, boolean paramBoolean2, e parame, boolean paramBoolean3) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(257356);
      Object localObject = (CharSequence)this.Awb.getContext().getString(2131763371);
      int i = this.Awb.getContext().getResources().getColor(2131100044);
      if (!this.Awe) {}
      for (boolean bool = true;; bool = false)
      {
        paramm.a(201, (CharSequence)localObject, 2131690850, i, bool);
        if (!this.Awf) {
          break;
        }
        localObject = e.ApR;
        if (!e.a.b(this.Awc)) {
          break label191;
        }
        paramm.a(203, (CharSequence)this.Awb.getContext().getString(2131763362), 2131690898, this.Awb.getContext().getResources().getColor(2131100044), false);
        AppMethodBeat.o(257356);
        return;
      }
      localObject = (CharSequence)this.Awb.getContext().getString(2131759677);
      i = this.Awb.getContext().getResources().getColor(2131100044);
      if (!this.Awd) {}
      for (bool = true;; bool = false)
      {
        paramm.a(202, (CharSequence)localObject, 2131690780, i, bool);
        label191:
        AppMethodBeat.o(257356);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class f
    implements o.g
  {
    public f(MusicMvShareUIC paramMusicMvShareUIC, e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      int i = 0;
      paramInt = 0;
      AppMethodBeat.i(257357);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(257357);
        return;
        paramMenuItem = this.Awc.ApJ;
        if (paramMenuItem != null) {
          paramInt = paramMenuItem.extFlag;
        }
        String str;
        if ((paramInt & 0x400) != 0)
        {
          paramMenuItem = y.vXH;
          paramMenuItem = (Context)this.Awb.getActivity();
          str = this.Awb.getActivity().getString(2131760436);
          p.g(str, "activity.getString(com.t…finder_private_ban_share)");
          y.aF(paramMenuItem, str);
          AppMethodBeat.o(257357);
          return;
        }
        MusicMvShareUIC.a(this.Awb, this.Awc);
        AppMethodBeat.o(257357);
        return;
        paramMenuItem = this.Awc.ApJ;
        paramInt = i;
        if (paramMenuItem != null) {
          paramInt = paramMenuItem.extFlag;
        }
        if ((paramInt & 0x400) != 0)
        {
          paramMenuItem = y.vXH;
          paramMenuItem = (Context)this.Awb.getActivity();
          str = this.Awb.getActivity().getString(2131760436);
          p.g(str, "activity.getString(com.t…finder_private_ban_share)");
          y.aF(paramMenuItem, str);
          AppMethodBeat.o(257357);
          return;
        }
        MusicMvShareUIC.b(this.Awb, this.Awc);
        AppMethodBeat.o(257357);
        return;
        MusicMvShareUIC.c(this.Awb, this.Awc);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class g
    implements o.g
  {
    public g(MusicMvShareUIC paramMusicMvShareUIC, e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(257359);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      do
      {
        AppMethodBeat.o(257359);
        return;
        paramMenuItem = new f.a((Context)this.Awb.getContext());
        paramMenuItem.bow(this.Awb.getContext().getString(2131763356)).apa(2131755778).apb(this.Awb.getContext().getResources().getColor(2131100996)).boB(this.Awb.getContext().getString(2131755761)).apc(this.Awb.getContext().getResources().getColor(2131100904));
        paramMenuItem.c((f.c)new f.c()
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(257358);
            Object localObject2;
            long l;
            if (paramAnonymousBoolean)
            {
              paramAnonymousString = com.tencent.mm.ui.component.a.PRN;
              paramAnonymousString = (MusicMvMainUIC)com.tencent.mm.ui.component.a.b(this.Awg.Awb.getActivity()).get(MusicMvMainUIC.class);
              localObject1 = this.Awg.Awc;
              p.h(localObject1, "musicMv");
              Log.i(paramAnonymousString.TAG, "deleteMv " + ((e)localObject1).ApE + ' ' + ((e)localObject1).ApF + ' ' + ((e)localObject1).ApM);
              if (((e)localObject1).ApM == 1)
              {
                localObject2 = ((e)localObject1).ApE;
                paramAnonymousString = ((e)localObject1).ApF;
                if ((localObject2 != null) && (paramAnonymousString != null))
                {
                  l = ((Number)localObject2).longValue();
                  localObject1 = g.azz();
                  localObject2 = z.aUg();
                  p.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
                  ((t)localObject1).b((q)new av((String)localObject2, l, paramAnonymousString, false));
                  AppMethodBeat.o(257358);
                }
              }
              else if (((e)localObject1).ApM == 4)
              {
                paramAnonymousString = ((e)localObject1).ApP;
                if (paramAnonymousString == null) {
                  break label294;
                }
                paramAnonymousString = Long.valueOf(paramAnonymousString.id);
                localObject1 = ((e)localObject1).ApP;
                if (localObject1 == null) {
                  break label299;
                }
              }
            }
            label294:
            label299:
            for (Object localObject1 = ((FinderObject)localObject1).objectNonceId;; localObject1 = null)
            {
              if ((paramAnonymousString != null) && (localObject1 != null))
              {
                l = ((Number)paramAnonymousString).longValue();
                paramAnonymousString = g.azz();
                localObject2 = z.aUg();
                p.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
                paramAnonymousString.b((q)new av((String)localObject2, l, (String)localObject1, false));
              }
              AppMethodBeat.o(257358);
              return;
              paramAnonymousString = null;
              break;
            }
          }
        }).show();
        AppMethodBeat.o(257359);
        return;
        this.Awb.i(this.Awc);
        AppMethodBeat.o(257359);
        return;
        paramMenuItem = this.Awc.ApE;
      } while (paramMenuItem == null);
      long l = ((Number)paramMenuItem).longValue();
      com.tencent.mm.plugin.music.model.m.bk((Context)this.Awb.getContext(), d.zs(l));
      AppMethodBeat.o(257359);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class i
    implements MMActivity.a
  {
    i(e parame) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(257361);
      if ((2 == paramInt1) && (paramInt2 == -1))
      {
        paramIntent = e.ApR;
        FinderObject localFinderObject = e.a.a(this.Awc);
        if (localFinderObject != null)
        {
          Object localObject = new LinkedList();
          String str2 = d.zs(localFinderObject.id);
          String str1 = localFinderObject.objectNonceId;
          paramIntent = str1;
          if (str1 == null) {
            paramIntent = "";
          }
          ((LinkedList)localObject).add(new Pair(str2, paramIntent));
          ((PluginFinder)g.ah(PluginFinder.class)).shareStatsReport((List)localObject, false);
          localObject = new StringBuilder("share mv to sns success ").append(d.zs(localFinderObject.id)).append(' ');
          str1 = localFinderObject.objectNonceId;
          paramIntent = str1;
          if (str1 == null) {
            paramIntent = "";
          }
          Log.i("MicroMsg.Mv.MusicMvShareUIC", paramIntent);
          AppMethodBeat.o(257361);
          return;
        }
      }
      AppMethodBeat.o(257361);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class j
    implements MMActivity.a
  {
    j(e parame) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(257362);
      if ((paramInt1 == 1) && (paramInt2 == -1))
      {
        paramIntent = e.ApR;
        FinderObject localFinderObject = e.a.a(this.Awc);
        if (localFinderObject != null)
        {
          Object localObject = new LinkedList();
          String str2 = d.zs(localFinderObject.id);
          String str1 = localFinderObject.objectNonceId;
          paramIntent = str1;
          if (str1 == null) {
            paramIntent = "";
          }
          ((LinkedList)localObject).add(new Pair(str2, paramIntent));
          ((PluginFinder)g.ah(PluginFinder.class)).shareStatsReport((List)localObject, false);
          localObject = new StringBuilder("share mv success ").append(d.zs(localFinderObject.id)).append(' ');
          str1 = localFinderObject.objectNonceId;
          paramIntent = str1;
          if (str1 == null) {
            paramIntent = "";
          }
          Log.i("MicroMsg.Mv.MusicMvShareUIC", paramIntent);
          AppMethodBeat.o(257362);
          return;
        }
      }
      AppMethodBeat.o(257362);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.of;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.ui.MusicMvRouterUI;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.util.b;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "MENU_ID_NOT_SAVE_DRAFT", "", "getMENU_ID_NOT_SAVE_DRAFT", "()I", "MENU_ID_SAVE_DRAFT", "getMENU_ID_SAVE_DRAFT", "REQUEST_CODE_CREATE_FINDER_DRAFT", "getREQUEST_CODE_CREATE_FINDER_DRAFT", "TAG", "", "getTAG", "()Ljava/lang/String;", "fromScene", "isFinderNew", "", "lastPageId", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getMvData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setMvData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "doBack", "", "isEdit", "pageId", "doDraft", "needCreateFinderContact", "needSave", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "plugin-mv_release"})
public final class MusicMvSaveDraftUIC
  extends UIComponent
{
  final int AvS;
  final int AvT;
  private final int AvU;
  private csp AvV;
  private int AvW;
  private final String TAG;
  private boolean UqV;
  private int fromScene;
  
  public MusicMvSaveDraftUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257351);
    this.TAG = "MicroMsg.Mv.MusicMvSaveDraftUIC";
    this.AvS = 1;
    this.AvT = 2;
    this.AvU = 10031;
    this.AvW = 2;
    this.fromScene = getIntent().getIntExtra("key_mv_from_scene", 0);
    AppMethodBeat.o(257351);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, csp paramcsp)
  {
    AppMethodBeat.i(257349);
    if (paramBoolean1)
    {
      localObject1 = (CharSequence)z.aUg();
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramcsp = y.vXH;
        if (!y.an((Activity)getActivity())) {
          break label425;
        }
        paramcsp = new Intent();
        paramcsp.setClassName((Context)getActivity(), "com.tencent.mm.plugin.finder.ui.FinderCreateContactUI");
        paramcsp.putExtra("scene", 89);
        paramcsp.putExtra("key_create_scene", 7);
        paramcsp.putExtra("key_router_to_profile", false);
        paramcsp.putExtra("key_mv_status", 1);
        getActivity().startActivityForResult(paramcsp, this.AvU);
        AppMethodBeat.o(257349);
        return;
      }
    }
    Object localObject1 = i.vfo;
    i.at(this.AvW, paramBoolean2);
    if (paramcsp != null)
    {
      if (!paramBoolean2) {
        break label431;
      }
      localObject1 = paramcsp;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.mv.ui.a.ArA;
        com.tencent.mm.plugin.mv.ui.a.c((csp)localObject1);
        h.vDp.a((csp)localObject1);
        u.u((Context)getActivity(), getString(2131755971), 2131690537);
      }
    }
    localObject1 = new Intent((Context)getActivity(), MusicMvRouterUI.class);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("KEY_MUSIC_ROUTER", 4);
    Object localObject2 = c.Akc;
    c.sm(true);
    localObject2 = getActivity();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doDraft", "(ZZLcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((AppCompatActivity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doDraft", "(ZZLcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    getActivity().finish();
    localObject1 = com.tencent.mm.plugin.mv.a.l.Uqz;
    paramBoolean1 = this.UqV;
    localObject1 = com.tencent.mm.plugin.mv.a.m.e(paramcsp);
    p.h(localObject1, "partList");
    paramcsp = com.tencent.mm.plugin.mv.a.l.gFd();
    if (paramBoolean2)
    {
      l = 1L;
      label372:
      paramcsp.PG(l);
      paramcsp.bvF((String)localObject1);
      if (!paramBoolean1) {
        break label443;
      }
    }
    label425:
    label431:
    label443:
    for (long l = 1L;; l = 0L)
    {
      paramcsp.PH(l);
      paramcsp.PF(9L);
      paramcsp.bfK();
      localObject1 = b.QYu;
      b.a((com.tencent.mm.plugin.report.a)paramcsp);
      AppMethodBeat.o(257349);
      return;
      localObject1 = null;
      break;
      l = 0L;
      break label372;
    }
  }
  
  public final void a(final csp paramcsp, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(257348);
    this.AvW = paramInt;
    if (paramBoolean)
    {
      this.AvV = paramcsp;
      localObject = new e((Context)getActivity(), 1, true);
      ((e)localObject).hbr();
      ((e)localObject).j((CharSequence)getResources().getString(2131763398), 17, getResources().getDimensionPixelSize(2131165594));
      ((e)localObject).setBackgroundColor(getContext().getResources().getColor(2131099745));
      ((e)localObject).a((o.f)new a(this));
      ((e)localObject).a((o.g)new b(this, paramcsp, (e)localObject));
      ((e)localObject).b((e.b)new c(this));
      ((e)localObject).dGm();
      AppMethodBeat.o(257348);
      return;
    }
    if (this.fromScene == 1)
    {
      paramcsp = k.euj();
      p.g(paramcsp, "MusicPlayerManager.Instance()");
      paramcsp.etW().stopPlay();
    }
    paramcsp = new Intent((Context)getActivity(), MusicMvRouterUI.class);
    paramcsp.addFlags(67108864);
    paramcsp.putExtra("KEY_MUSIC_ROUTER", 4);
    getActivity().overridePendingTransition(-1, 2130772170);
    Object localObject = c.Akc;
    c.sm(true);
    localObject = getActivity();
    paramcsp = new com.tencent.mm.hellhoundlib.b.a().bl(paramcsp);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramcsp.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doBack", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((AppCompatActivity)localObject).startActivity((Intent)paramcsp.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doBack", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    getActivity().finish();
    paramcsp = i.vfo;
    i.at(paramInt, false);
    AppMethodBeat.o(257348);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(257350);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.AvU)
    {
      Log.i(this.TAG, "callback create finder contact draft");
      paramIntent = this.AvV;
      if (paramIntent != null)
      {
        a(false, true, paramIntent);
        AppMethodBeat.o(257350);
        return;
      }
    }
    AppMethodBeat.o(257350);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements o.f
  {
    a(MusicMvSaveDraftUIC paramMusicMvSaveDraftUIC) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(257345);
      paramm.d(this.AvX.AvS, (CharSequence)this.AvX.getContext().getResources().getString(2131763397));
      paramm.a(this.AvX.AvT, this.AvX.getColor(2131099818), (CharSequence)this.AvX.getContext().getResources().getString(2131763396));
      AppMethodBeat.o(257345);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class b
    implements o.g
  {
    b(MusicMvSaveDraftUIC paramMusicMvSaveDraftUIC, csp paramcsp, e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(257346);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == this.AvX.AvS)
      {
        paramMenuItem = this.AvX;
        CharSequence localCharSequence = (CharSequence)z.aUg();
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          MusicMvSaveDraftUIC.a(paramMenuItem, bool);
          MusicMvSaveDraftUIC.a(this.AvX, true, true, paramcsp);
          AppMethodBeat.o(257346);
          return;
        }
      }
      if (paramInt == this.AvX.AvT)
      {
        MusicMvSaveDraftUIC.a(this.AvX, false);
        MusicMvSaveDraftUIC.a(this.AvX, false, false, paramcsp);
        AppMethodBeat.o(257346);
        return;
      }
      this.nkZ.bMo();
      AppMethodBeat.o(257346);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(MusicMvSaveDraftUIC paramMusicMvSaveDraftUIC) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(257347);
      if (MusicMvSaveDraftUIC.a(this.AvX) == 1)
      {
        k localk = k.euj();
        p.g(localk, "MusicPlayerManager.Instance()");
        localk.etW().stopPlay();
      }
      AppMethodBeat.o(257347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvSaveDraftUIC
 * JD-Core Version:    0.7.0.1
 */
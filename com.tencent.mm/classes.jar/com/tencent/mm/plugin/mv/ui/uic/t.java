package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ii;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.mv.b.a;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.m;
import com.tencent.mm.plugin.mv.model.n;
import com.tencent.mm.plugin.mv.ui.MusicMvRouterUI;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "MENU_ID_NOT_SAVE_DRAFT", "", "getMENU_ID_NOT_SAVE_DRAFT", "()I", "MENU_ID_SAVE_DRAFT", "getMENU_ID_SAVE_DRAFT", "REQUEST_CODE_CREATE_FINDER_DRAFT", "getREQUEST_CODE_CREATE_FINDER_DRAFT", "TAG", "", "getTAG", "()Ljava/lang/String;", "fromScene", "isFinderNew", "", "lastPageId", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getMvData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setMvData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "doBack", "", "isEdit", "pageId", "doDraft", "needCreateFinderContact", "needSave", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "plugin-mv_release"})
public final class t
  extends UIComponent
{
  private boolean GeY;
  private int GmA;
  final int Gmw;
  final int Gmx;
  private final int Gmy;
  private dbo Gmz;
  private final String TAG;
  private int fromScene;
  
  public t(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(225611);
    this.TAG = "MicroMsg.Mv.MusicMvSaveDraftUIC";
    this.Gmw = 1;
    this.Gmx = 2;
    this.Gmy = 10031;
    this.GmA = 2;
    this.fromScene = getIntent().getIntExtra("key_mv_from_scene", 0);
    AppMethodBeat.o(225611);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, dbo paramdbo)
  {
    AppMethodBeat.i(225605);
    if (paramBoolean1)
    {
      localObject1 = (CharSequence)z.bdh();
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramdbo = aj.AGc;
        if (!aj.at((Activity)getActivity())) {
          break label451;
        }
        paramdbo = new Intent();
        paramdbo.setClassName((Context)getActivity(), "com.tencent.mm.plugin.finder.ui.FinderCreateContactUI");
        paramdbo.putExtra("key_create_scene", 7);
        paramdbo.putExtra("key_router_to_profile", false);
        paramdbo.putExtra("key_mv_status", 1);
        getActivity().startActivityForResult(paramdbo, this.Gmy);
        AppMethodBeat.o(225605);
        return;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.finder.report.k.zWs;
    com.tencent.mm.plugin.finder.report.k.aw(this.GmA, paramBoolean2);
    if (paramdbo != null)
    {
      if (!paramBoolean2) {
        break label457;
      }
      localObject1 = paramdbo;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.mv.ui.a.Gfi;
        com.tencent.mm.plugin.mv.ui.a.d((dbo)localObject1);
        i.AkK.a((dbo)localObject1);
        w.w((Context)getActivity(), getString(b.h.app_saved), b.g.icons_filled_done);
      }
    }
    localObject1 = new Intent((Context)getActivity(), MusicMvRouterUI.class);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("KEY_MUSIC_ROUTER", 4);
    Object localObject2 = com.tencent.mm.plugin.music.model.c.FRf;
    com.tencent.mm.plugin.music.model.c.vs(true);
    localObject2 = getActivity();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doDraft", "(ZZLcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((AppCompatActivity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doDraft", "(ZZLcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    getActivity().finish();
    if (this.fromScene == 1)
    {
      localObject1 = com.tencent.mm.plugin.music.e.k.fet();
      p.j(localObject1, "MusicPlayerManager.Instance()");
      ((com.tencent.mm.plugin.music.e.k)localObject1).feg().stopPlay();
    }
    localObject1 = m.GcA;
    paramBoolean1 = this.GeY;
    localObject1 = n.c(paramdbo);
    p.k(localObject1, "partList");
    paramdbo = m.fgi();
    if (paramBoolean2)
    {
      l = 1L;
      label398:
      paramdbo.sQ(l);
      paramdbo.yr((String)localObject1);
      if (!paramBoolean1) {
        break label469;
      }
    }
    label451:
    label457:
    label469:
    for (long l = 1L;; l = 0L)
    {
      paramdbo.sR(l);
      paramdbo.sP(9L);
      paramdbo.bpa();
      localObject1 = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)paramdbo);
      AppMethodBeat.o(225605);
      return;
      localObject1 = null;
      break;
      l = 0L;
      break label398;
    }
  }
  
  public final void a(final dbo paramdbo, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(225594);
    this.GmA = paramInt;
    if (paramBoolean)
    {
      this.Gmz = paramdbo;
      if (paramdbo != null)
      {
        localObject = paramdbo.TIV;
        if (localObject != null)
        {
          localObject = ((FinderObject)localObject).objectDesc;
          if (localObject != null)
          {
            localObject = ((FinderObjectDesc)localObject).mvInfo;
            if ((localObject != null) && (((bdp)localObject).SOF == 1)) {
              break label264;
            }
          }
        }
      }
      int i = 1;
      if ((paramInt == 2) || (i != 0))
      {
        localObject = this.Gmz;
        if (localObject != null)
        {
          localObject = ((dbo)localObject).TIV;
          if (localObject != null)
          {
            localObject = ((FinderObject)localObject).objectDesc;
            if (localObject != null)
            {
              localObject = ((FinderObjectDesc)localObject).mvInfo;
              if (localObject != null) {
                ((bdp)localObject).SOG = 0;
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject = new e((Context)getActivity(), 1, true);
        ((e)localObject).icy();
        ((e)localObject).j((CharSequence)getResources().getString(b.h.music_post_save_draft_title), 17, getResources().getDimensionPixelSize(b.c.SmallestTextSize));
        ((e)localObject).setBackgroundColor(getContext().getResources().getColor(b.b.Dark_5));
        ((e)localObject).a((q.f)new a(this));
        ((e)localObject).a((q.g)new b(this, paramdbo, (e)localObject));
        ((e)localObject).b((e.b)c.GmC);
        ((e)localObject).eik();
        AppMethodBeat.o(225594);
        return;
        label264:
        i = 0;
        break;
        if ((paramInt == 4) || (paramInt == 7))
        {
          localObject = this.Gmz;
          if (localObject != null)
          {
            localObject = ((dbo)localObject).TIV;
            if (localObject != null)
            {
              localObject = ((FinderObject)localObject).objectDesc;
              if (localObject != null)
              {
                localObject = ((FinderObjectDesc)localObject).mvInfo;
                if (localObject != null) {
                  ((bdp)localObject).SOG = 2;
                }
              }
            }
          }
        }
      }
    }
    if ((paramInt == 7) && (this.fromScene != 1))
    {
      getActivity().finish();
      AppMethodBeat.o(225594);
      return;
    }
    paramdbo = new Intent((Context)getActivity(), MusicMvRouterUI.class);
    paramdbo.addFlags(67108864);
    paramdbo.putExtra("KEY_MUSIC_ROUTER", 4);
    getActivity().overridePendingTransition(-1, b.a.slide_right_out);
    Object localObject = com.tencent.mm.plugin.music.model.c.FRf;
    com.tencent.mm.plugin.music.model.c.vs(true);
    localObject = getActivity();
    paramdbo = new com.tencent.mm.hellhoundlib.b.a().bm(paramdbo);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramdbo.aFh(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doBack", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((AppCompatActivity)localObject).startActivity((Intent)paramdbo.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doBack", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    getActivity().finish();
    if (this.fromScene == 1)
    {
      paramdbo = com.tencent.mm.plugin.music.e.k.fet();
      p.j(paramdbo, "MusicPlayerManager.Instance()");
      paramdbo.feg().stopPlay();
    }
    paramdbo = com.tencent.mm.plugin.finder.report.k.zWs;
    com.tencent.mm.plugin.finder.report.k.aw(paramInt, false);
    AppMethodBeat.o(225594);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(225608);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.Gmy)
    {
      Log.i(this.TAG, "callback create finder contact draft");
      paramIntent = this.Gmz;
      if (paramIntent != null)
      {
        a(false, true, paramIntent);
        AppMethodBeat.o(225608);
        return;
      }
    }
    AppMethodBeat.o(225608);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements q.f
  {
    a(t paramt) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(231821);
      paramo.d(this.GmB.Gmw, (CharSequence)this.GmB.getContext().getResources().getString(b.h.music_post_menu_save));
      paramo.a(this.GmB.Gmx, this.GmB.getColor(b.b.Red), (CharSequence)this.GmB.getContext().getResources().getString(b.h.music_post_menu_not_save));
      AppMethodBeat.o(231821);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class b
    implements q.g
  {
    b(t paramt, dbo paramdbo, e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(225378);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == this.GmB.Gmw)
      {
        paramMenuItem = this.GmB;
        CharSequence localCharSequence = (CharSequence)z.bdh();
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          t.a(paramMenuItem, bool);
          t.a(this.GmB, true, true, paramdbo);
          AppMethodBeat.o(225378);
          return;
        }
      }
      if (paramInt == this.GmB.Gmx)
      {
        t.a(this.GmB, false);
        t.a(this.GmB, false, false, paramdbo);
        AppMethodBeat.o(225378);
        return;
      }
      this.qmB.bYF();
      AppMethodBeat.o(225378);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    public static final c GmC;
    
    static
    {
      AppMethodBeat.i(240550);
      GmC = new c();
      AppMethodBeat.o(240550);
    }
    
    public final void onDismiss() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.t
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.music.e.a.d;
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
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "MENU_ID_NOT_SAVE_DRAFT", "", "getMENU_ID_NOT_SAVE_DRAFT", "()I", "MENU_ID_SAVE_DRAFT", "getMENU_ID_SAVE_DRAFT", "REQUEST_CODE_CREATE_FINDER_DRAFT", "getREQUEST_CODE_CREATE_FINDER_DRAFT", "TAG", "", "getTAG", "()Ljava/lang/String;", "fromScene", "isFinderNew", "", "lastPageId", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getMvData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setMvData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "doBack", "", "isEdit", "pageId", "doDraft", "needCreateFinderContact", "needSave", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends UIComponent
{
  private boolean Mat;
  private final int MgL;
  private final int MgM;
  private final int MgN;
  private dtf MgO;
  private int MgP;
  private final String TAG;
  private int fromScene;
  
  public q(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287695);
    this.TAG = "MicroMsg.Mv.MusicMvSaveDraftUIC";
    this.MgL = 1;
    this.MgM = 2;
    this.MgN = 10031;
    this.MgP = 2;
    this.fromScene = getIntent().getIntExtra("key_mv_from_scene", 0);
    AppMethodBeat.o(287695);
  }
  
  private static final void a(q paramq, dtf paramdtf, f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(287739);
    kotlin.g.b.s.u(paramq, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == paramq.MgL)
    {
      paramf = (CharSequence)z.bAW();
      if ((paramf == null) || (paramf.length() == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        paramq.Mat = bool;
        paramq.a(true, true, paramdtf);
        AppMethodBeat.o(287739);
        return;
      }
    }
    if (paramInt == paramq.MgM)
    {
      paramq.Mat = false;
      paramq.a(false, false, paramdtf);
      AppMethodBeat.o(287739);
      return;
    }
    paramf.cyW();
    AppMethodBeat.o(287739);
  }
  
  private static final void a(q paramq, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(287727);
    kotlin.g.b.s.u(paramq, "this$0");
    params.c(paramq.MgL, (CharSequence)paramq.getContext().getResources().getString(b.h.music_post_menu_save));
    params.a(paramq.MgM, paramq.getColor(b.b.Red), (CharSequence)paramq.getContext().getResources().getString(b.h.music_post_menu_not_save));
    AppMethodBeat.o(287727);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, dtf paramdtf)
  {
    AppMethodBeat.i(287716);
    if (paramBoolean1)
    {
      localObject1 = (CharSequence)z.bAW();
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramdtf = av.GiL;
        if (!av.aO((Activity)getActivity())) {
          break label439;
        }
        paramdtf = new Intent();
        paramdtf.setClassName((Context)getActivity(), "com.tencent.mm.plugin.finder.ui.FinderCreateContactUI");
        paramdtf.putExtra("key_create_scene", 7);
        paramdtf.putExtra("key_router_to_profile", false);
        paramdtf.putExtra("key_mv_status", 1);
        getActivity().startActivityForResult(paramdtf, this.MgN);
        AppMethodBeat.o(287716);
        return;
      }
    }
    Object localObject1 = v.FrN;
    v.aQ(this.MgP, paramBoolean2);
    if (paramdtf != null)
    {
      if (!paramBoolean2) {
        break label445;
      }
      localObject1 = paramdtf;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.mv.ui.a.Maz;
        com.tencent.mm.plugin.mv.ui.a.d((dtf)localObject1);
        com.tencent.mm.plugin.finder.storage.j.FKc.a((dtf)localObject1);
        aa.y((Context)getActivity(), getString(b.h.app_saved), b.g.icons_filled_done);
      }
    }
    localObject1 = new Intent((Context)getActivity(), MusicMvRouterUI.class);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("KEY_MUSIC_ROUTER", 4);
    Object localObject2 = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.zK(true);
    localObject2 = getActivity();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doDraft", "(ZZLcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((AppCompatActivity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doDraft", "(ZZLcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    getActivity().finish();
    if (this.fromScene == 1) {
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().stopPlay();
    }
    localObject1 = m.LYc;
    paramBoolean1 = this.Mat;
    localObject1 = n.c(paramdtf);
    kotlin.g.b.s.u(localObject1, "partList");
    paramdtf = m.gpJ();
    if (paramBoolean2)
    {
      l = 1L;
      label389:
      paramdtf.iXi = l;
      paramdtf.tj((String)localObject1);
      if (!paramBoolean1) {
        break label457;
      }
    }
    label439:
    label445:
    label457:
    for (long l = 1L;; l = 0L)
    {
      paramdtf.iXj = l;
      paramdtf.ioV = 9L;
      paramdtf.bMH();
      localObject1 = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)paramdtf);
      AppMethodBeat.o(287716);
      return;
      localObject1 = null;
      break;
      l = 0L;
      break label389;
    }
  }
  
  private static final void grf() {}
  
  public final void a(dtf paramdtf, boolean paramBoolean, int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(287780);
    this.MgP = paramInt;
    label297:
    if (paramBoolean)
    {
      this.MgO = paramdtf;
      int i;
      if (paramdtf != null)
      {
        localObject1 = paramdtf.aaYK;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).objectDesc;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
            if ((localObject1 != null) && (((bol)localObject1).ZWM == 1))
            {
              i = 1;
              if (i != 0) {
                break label249;
              }
              i = 1;
              label85:
              if ((paramInt != 2) && (i == 0)) {
                break label297;
              }
              localObject1 = this.MgO;
              if (localObject1 != null) {
                break label255;
              }
              localObject1 = localObject2;
              label110:
              if (localObject1 != null) {
                ((bol)localObject1).ZWN = 0;
              }
            }
          }
        }
      }
      label249:
      label377:
      for (;;)
      {
        localObject1 = new f((Context)getActivity(), 1, true);
        ((f)localObject1).NE(true);
        ((f)localObject1).h((CharSequence)getResources().getString(b.h.music_post_save_draft_title), 17, getResources().getDimensionPixelSize(b.c.SmallestTextSize));
        ((f)localObject1).setBackgroundColor(getContext().getResources().getColor(b.b.Dark_5));
        ((f)localObject1).Vtg = new q..ExternalSyntheticLambda0(this);
        ((f)localObject1).GAC = new q..ExternalSyntheticLambda1(this, paramdtf, (f)localObject1);
        ((f)localObject1).aeLi = q..ExternalSyntheticLambda2.INSTANCE;
        ((f)localObject1).dDn();
        AppMethodBeat.o(287780);
        return;
        i = 0;
        break;
        i = 0;
        break label85;
        label255:
        localObject3 = ((dtf)localObject1).aaYK;
        localObject1 = localObject2;
        if (localObject3 == null) {
          break label110;
        }
        localObject3 = ((FinderObject)localObject3).objectDesc;
        localObject1 = localObject2;
        if (localObject3 == null) {
          break label110;
        }
        localObject1 = ((FinderObjectDesc)localObject3).mvInfo;
        break label110;
        if ((paramInt == 4) || (paramInt == 7))
        {
          localObject1 = this.MgO;
          if (localObject1 == null) {
            localObject1 = localObject3;
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label377;
            }
            ((bol)localObject1).ZWN = 2;
            break;
            localObject2 = ((dtf)localObject1).aaYK;
            localObject1 = localObject3;
            if (localObject2 != null)
            {
              localObject2 = ((FinderObject)localObject2).objectDesc;
              localObject1 = localObject3;
              if (localObject2 != null) {
                localObject1 = ((FinderObjectDesc)localObject2).mvInfo;
              }
            }
          }
        }
      }
    }
    if ((paramInt == 7) && (this.fromScene != 1))
    {
      getActivity().finish();
      AppMethodBeat.o(287780);
      return;
    }
    paramdtf = new Intent((Context)getActivity(), MusicMvRouterUI.class);
    paramdtf.addFlags(67108864);
    paramdtf.putExtra("KEY_MUSIC_ROUTER", 4);
    getActivity().overridePendingTransition(-1, b.a.slide_right_out);
    Object localObject1 = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.zK(true);
    localObject1 = getActivity();
    paramdtf = new com.tencent.mm.hellhoundlib.b.a().cG(paramdtf);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramdtf.aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doBack", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((AppCompatActivity)localObject1).startActivity((Intent)paramdtf.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doBack", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    getActivity().finish();
    if (this.fromScene == 1) {
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().stopPlay();
    }
    paramdtf = v.FrN;
    v.aQ(paramInt, false);
    AppMethodBeat.o(287780);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(287786);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.MgN)
    {
      Log.i(this.TAG, "callback create finder contact draft");
      paramIntent = this.MgO;
      if (paramIntent != null) {
        a(false, true, paramIntent);
      }
    }
    AppMethodBeat.o(287786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.q
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.textstatus.j;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.ah;
import com.tencent.mm.ui.widget.b;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/third/FinderTextStatusProfileService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "Companion", "plugin-textstatus_release"})
public final class a
  implements m
{
  public static final a MIO;
  
  static
  {
    AppMethodBeat.i(238511);
    MIO = new a((byte)0);
    AppMethodBeat.o(238511);
  }
  
  public final b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, com.tencent.mm.plugin.textstatus.proto.d paramd)
  {
    AppMethodBeat.i(238508);
    p.k(paramFrameLayout, "container");
    p.k(paramd, "pullDownParam");
    AppMethodBeat.o(238508);
    return null;
  }
  
  public final i dDF()
  {
    AppMethodBeat.i(238510);
    i locali = (i)new b();
    AppMethodBeat.o(238510);
    return locali;
  }
  
  public final void release() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/third/FinderTextStatusProfileService$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/third/FinderTextStatusProfileService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "finderProfileInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfoFinderProfile;", "getFinderProfileInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfoFinderProfile;", "setFinderProfileInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfoFinderProfile;)V", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "doJumpSource", "", "context", "Landroid/content/Context;", "isHasCustomPullDown", "loadAvatar", "", "avatarView", "Landroid/widget/ImageView;", "onAttach", "textStatusID", "", "", "onDetach", "setCustomSourceView", "container", "Landroid/widget/FrameLayout;", "plugin-textstatus_release"})
  public static final class b
    extends i
  {
    private ah MIP;
    private List<? extends TextStatusJumpInfo> yNX;
    
    public final boolean dDH()
    {
      return false;
    }
    
    public final boolean e(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(234208);
      p.k(paramFrameLayout, "container");
      ImageView localImageView = (ImageView)paramFrameLayout.findViewWithTag("FinderTextStatusProfileService");
      if (localImageView == null) {
        localImageView = new ImageView(paramFrameLayout.getContext());
      }
      for (;;)
      {
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFrameLayout.removeAllViews();
        paramFrameLayout.addView((View)localImageView);
        paramFrameLayout = this.MIP;
        if (paramFrameLayout != null) {}
        for (paramFrameLayout = paramFrameLayout.url;; paramFrameLayout = null)
        {
          Object localObject = t.ztT;
          localObject = t.dJh();
          paramFrameLayout = new e(paramFrameLayout);
          t localt = t.ztT;
          ((com.tencent.mm.loader.d)localObject).a(paramFrameLayout, localImageView, t.a(t.a.ztX));
          AppMethodBeat.o(234208);
          return true;
        }
      }
    }
    
    public final boolean fz(Context paramContext)
    {
      AppMethodBeat.i(234206);
      Object localObject1 = this.yNX;
      if (localObject1 != null)
      {
        Object localObject2 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (p.h(((TextStatusJumpInfo)((Iterator)localObject2).next()).jumpType, "8"))
          {
            localObject1 = this.MIP;
            label77:
            int i;
            if (localObject1 != null)
            {
              localObject1 = ((ah)localObject1).username;
              CharSequence localCharSequence = (CharSequence)localObject1;
              if ((localCharSequence != null) && (!n.ba(localCharSequence))) {
                break label167;
              }
              i = 1;
              label99:
              if (i != 0) {
                break label170;
              }
              localObject2 = new Intent();
              boolean bool = p.h(localObject1, z.bdh());
              ((Intent)localObject2).putExtra("finder_username", (String)localObject1);
              if (!bool) {
                break label172;
              }
              ((ak)h.ag(ak.class)).enterFinderSelfProfile(paramContext, (Intent)localObject2, 20, 2);
            }
            for (;;)
            {
              AppMethodBeat.o(234206);
              return true;
              localObject1 = null;
              break label77;
              label167:
              i = 0;
              break label99;
              label170:
              break;
              label172:
              ((ak)h.ag(ak.class)).fillContextIdToIntent(20, 2, 32, (Intent)localObject2);
              ((ak)h.ag(ak.class)).enterFinderProfileUI(paramContext, (Intent)localObject2);
            }
          }
        }
      }
      AppMethodBeat.o(234206);
      return false;
    }
    
    public final void onDetach() {}
    
    public final void s(String paramString, List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(234202);
      this.yNX = paramList;
      if (paramList != null)
      {
        paramString = ((Iterable)paramList).iterator();
        while (paramString.hasNext())
        {
          paramList = (TextStatusJumpInfo)paramString.next();
          if (p.h(paramList.jumpType, "8"))
          {
            paramString = Base64.decode(paramList.keyBusiBuf, 0);
            paramList = new ah();
            paramList.parseFrom(paramString);
            this.MIP = paramList;
            AppMethodBeat.o(234202);
            return;
          }
        }
        AppMethodBeat.o(234202);
        return;
      }
      AppMethodBeat.o(234202);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.textstatus.third;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.aw;
import com.tencent.mm.plugin.textstatus.proto.l;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/FinderTextStatusProfileService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpType", "", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements o
{
  public static final b.a TuD;
  
  static
  {
    AppMethodBeat.i(290107);
    TuD = new b.a((byte)0);
    AppMethodBeat.o(290107);
  }
  
  public final com.tencent.mm.ui.widget.b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, l paraml)
  {
    AppMethodBeat.i(290117);
    s.u(paramFrameLayout, "container");
    s.u(paraml, "pullDownParam");
    AppMethodBeat.o(290117);
    return null;
  }
  
  public final k axF(String paramString)
  {
    AppMethodBeat.i(290122);
    paramString = (k)new b(paramString);
    AppMethodBeat.o(290122);
    return paramString;
  }
  
  public final void release() {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/third/FinderTextStatusProfileService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "finderProfileInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfoFinderProfile;", "getFinderProfileInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfoFinderProfile;", "setFinderProfileInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfoFinderProfile;)V", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "doJumpSource", "", "context", "Landroid/content/Context;", "extParam", "Landroid/os/Bundle;", "isHasCustomPullDown", "loadAvatar", "", "avatarView", "Landroid/widget/ImageView;", "onAttach", "textStatusID", "", "", "onDetach", "setCustomSourceView", "container", "Landroid/widget/FrameLayout;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends k
  {
    private List<? extends TextStatusJumpInfo> DHi;
    private aw TuE;
    
    b(String paramString)
    {
      super();
    }
    
    public final boolean e(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(290091);
      s.u(paramFrameLayout, "container");
      ImageView localImageView = (ImageView)paramFrameLayout.findViewWithTag("FinderTextStatusProfileService");
      if (localImageView == null)
      {
        localImageView = new ImageView(paramFrameLayout.getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFrameLayout.removeAllViews();
        paramFrameLayout.addView((View)localImageView);
        paramFrameLayout = this.TuE;
        if (paramFrameLayout != null) {
          break label111;
        }
      }
      label111:
      for (paramFrameLayout = null;; paramFrameLayout = paramFrameLayout.url)
      {
        Object localObject = p.ExI;
        localObject = p.eCp();
        paramFrameLayout = new com.tencent.mm.plugin.finder.loader.b(paramFrameLayout);
        p localp = p.ExI;
        ((d)localObject).a(paramFrameLayout, localImageView, p.a(p.a.ExM));
        AppMethodBeat.o(290091);
        return true;
        break;
      }
    }
    
    public final boolean etQ()
    {
      return false;
    }
    
    public final boolean g(Context paramContext, Bundle paramBundle)
    {
      AppMethodBeat.i(290086);
      paramBundle = this.DHi;
      if (paramBundle != null)
      {
        Object localObject = ((Iterable)paramBundle).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (s.p(((TextStatusJumpInfo)((Iterator)localObject).next()).jumpType, "8"))
          {
            paramBundle = this.TuE;
            label67:
            int i;
            if (paramBundle == null)
            {
              paramBundle = null;
              CharSequence localCharSequence = (CharSequence)paramBundle;
              if ((localCharSequence != null) && (!n.bp(localCharSequence))) {
                break label158;
              }
              i = 1;
              label88:
              if (i != 0) {
                break label161;
              }
              localObject = new Intent();
              boolean bool = s.p(paramBundle, z.bAW());
              ((Intent)localObject).putExtra("finder_username", paramBundle);
              if (!bool) {
                break label163;
              }
              ((cn)h.az(cn.class)).enterFinderSelfProfile(paramContext, (Intent)localObject, 20, 2);
            }
            for (;;)
            {
              AppMethodBeat.o(290086);
              return true;
              paramBundle = paramBundle.username;
              break label67;
              label158:
              i = 0;
              break label88;
              label161:
              break;
              label163:
              ((cn)h.az(cn.class)).fillContextIdToIntent(20, 2, 32, (Intent)localObject);
              ((cn)h.az(cn.class)).enterFinderProfileUI(paramContext, (Intent)localObject);
            }
          }
        }
      }
      AppMethodBeat.o(290086);
      return false;
    }
    
    public final void onDetach() {}
    
    public final void y(String paramString, List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(290074);
      this.DHi = paramList;
      if (paramList != null)
      {
        paramString = ((Iterable)paramList).iterator();
        while (paramString.hasNext())
        {
          paramList = (TextStatusJumpInfo)paramString.next();
          if (s.p(paramList.jumpType, "8"))
          {
            paramString = Base64.decode(paramList.keyBusiBuf, 0);
            paramList = new aw();
            paramList.parseFrom(paramString);
            this.TuE = paramList;
            AppMethodBeat.o(290074);
            return;
          }
        }
      }
      AppMethodBeat.o(290074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.b
 * JD-Core Version:    0.7.0.1
 */
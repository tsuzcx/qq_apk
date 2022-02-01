package com.tencent.mm.plugin.textstatus.third;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/WeAppStatusService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpType", "", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "Companion", "WeAppJumpParam", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements o
{
  public static final a Tvg;
  
  static
  {
    AppMethodBeat.i(290124);
    Tvg = new a((byte)0);
    AppMethodBeat.o(290124);
  }
  
  public final com.tencent.mm.ui.widget.b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, com.tencent.mm.plugin.textstatus.proto.l paraml)
  {
    AppMethodBeat.i(290130);
    s.u(paramFrameLayout, "container");
    s.u(paraml, "pullDownParam");
    AppMethodBeat.o(290130);
    return null;
  }
  
  public final k axF(String paramString)
  {
    AppMethodBeat.i(290136);
    paramString = (k)new c(paramString);
    AppMethodBeat.o(290136);
    return paramString;
  }
  
  public final void release() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/WeAppStatusService$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/WeAppStatusService$WeAppJumpParam;", "", "username", "", "enterPath", "version", "", "versionType", "(Ljava/lang/String;Ljava/lang/String;II)V", "getEnterPath", "()Ljava/lang/String;", "getUsername", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final int euz;
    final String qAF;
    final String username;
    final int version;
    
    public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.username = paramString1;
      this.qAF = paramString2;
      this.version = paramInt1;
      this.euz = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(290071);
      if (this == paramObject)
      {
        AppMethodBeat.o(290071);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(290071);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.username, paramObject.username))
      {
        AppMethodBeat.o(290071);
        return false;
      }
      if (!s.p(this.qAF, paramObject.qAF))
      {
        AppMethodBeat.o(290071);
        return false;
      }
      if (this.version != paramObject.version)
      {
        AppMethodBeat.o(290071);
        return false;
      }
      if (this.euz != paramObject.euz)
      {
        AppMethodBeat.o(290071);
        return false;
      }
      AppMethodBeat.o(290071);
      return true;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(290068);
      int i;
      if (this.username == null)
      {
        i = 0;
        if (this.qAF != null) {
          break label68;
        }
      }
      for (;;)
      {
        int k = this.version;
        int m = this.euz;
        AppMethodBeat.o(290068);
        return ((i * 31 + j) * 31 + k) * 31 + m;
        i = this.username.hashCode();
        break;
        label68:
        j = this.qAF.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(290065);
      String str = "WeAppJumpParam(username=" + this.username + ", enterPath=" + this.qAF + ", version=" + this.version + ", versionType=" + this.euz + ')';
      AppMethodBeat.o(290065);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/third/WeAppStatusService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "jumpInfosJo", "Lorg/json/JSONObject;", "getJumpInfosJo", "()Lorg/json/JSONObject;", "setJumpInfosJo", "(Lorg/json/JSONObject;)V", "doJumpSource", "", "context", "Landroid/content/Context;", "extParams", "Landroid/os/Bundle;", "fillInfo", "", "resultSetTextStatus", "Lcom/tencent/mm/plugin/textstatus/proto/ResultSetTextStatus;", "getWeAppJumpParams", "Lcom/tencent/mm/plugin/textstatus/third/WeAppStatusService$WeAppJumpParam;", "isHasCustomPullDown", "onAttach", "textStatusID", "", "", "onDetach", "setCustomSourceView", "container", "Landroid/widget/FrameLayout;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends k
  {
    private List<? extends TextStatusJumpInfo> DHi;
    private JSONObject Tvh;
    
    c(String paramString)
    {
      super();
    }
    
    private final n.b hIg()
    {
      AppMethodBeat.i(290072);
      Object localObject1 = this.DHi;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            TextStatusJumpInfo localTextStatusJumpInfo = (TextStatusJumpInfo)((Iterator)localObject1).next();
            if (s.p(localTextStatusJumpInfo.jumpType, "7"))
            {
              localObject1 = localTextStatusJumpInfo.busiBuf;
              try
              {
                localObject1 = new JSONObject((String)localObject1);
                localObject1 = new n.b(((JSONObject)localObject1).optString("username"), ((JSONObject)localObject1).optString("path"), ((JSONObject)localObject1).optInt("version"), ((JSONObject)localObject1).optInt("versionType", 0));
                AppMethodBeat.o(290072);
                return localObject1;
              }
              finally
              {
                for (;;)
                {
                  JSONObject localJSONObject = new JSONObject();
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(290072);
      return null;
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(290098);
      super.a(paramm);
      n.b localb = hIg();
      if (localb != null)
      {
        if (paramm != null) {
          paramm.ToT = localb.username;
        }
        if (paramm != null) {
          paramm.ToU = localb.qAF;
        }
      }
      AppMethodBeat.o(290098);
    }
    
    public final boolean e(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(290126);
      s.u(paramFrameLayout, "container");
      ImageView localImageView = (ImageView)paramFrameLayout.findViewWithTag("MicroMsg.TextStatus.WeAppStatusService");
      if (localImageView == null)
      {
        localImageView = new ImageView(paramFrameLayout.getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFrameLayout.removeAllViews();
        paramFrameLayout.addView((View)localImageView);
        paramFrameLayout = com.tencent.mm.plugin.textstatus.util.l.TBz;
        com.tencent.mm.plugin.textstatus.util.l.km((View)localImageView);
        paramFrameLayout = this.Tvh;
        if (paramFrameLayout != null) {
          break label121;
        }
        paramFrameLayout = null;
        label78:
        CharSequence localCharSequence = (CharSequence)paramFrameLayout;
        if ((localCharSequence != null) && (!kotlin.n.n.bp(localCharSequence))) {
          break label131;
        }
      }
      label131:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          r.bKe().loadImage(paramFrameLayout, localImageView);
        }
        AppMethodBeat.o(290126);
        return true;
        break;
        label121:
        paramFrameLayout = paramFrameLayout.optString("headImageURL");
        break label78;
      }
    }
    
    public final boolean etQ()
    {
      return false;
    }
    
    public final boolean g(Context paramContext, Bundle paramBundle)
    {
      AppMethodBeat.i(290113);
      Object localObject = hIg();
      if (localObject != null)
      {
        paramBundle = (t)h.ax(t.class);
        if (paramBundle != null)
        {
          g localg = new g();
          localg.username = ((n.b)localObject).username;
          localg.qAF = ((n.b)localObject).qAF;
          localg.version = ((n.b)localObject).version;
          localg.euz = ((n.b)localObject).euz;
          localg.scene = 1196;
          localg.hzx = localg.username;
          localObject = ah.aiuX;
          paramBundle.a(paramContext, localg);
        }
        AppMethodBeat.o(290113);
        return true;
      }
      AppMethodBeat.o(290113);
      return false;
    }
    
    public final void onDetach() {}
    
    public final void y(String paramString, List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(290083);
      this.DHi = paramList;
      if (paramList != null)
      {
        paramString = ((Iterable)paramList).iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            paramList = (TextStatusJumpInfo)paramString.next();
            if (s.p(paramList.jumpType, "7"))
            {
              paramString = paramList.busiBuf;
              try
              {
                paramString = new JSONObject(paramString);
                this.Tvh = paramString;
                AppMethodBeat.o(290083);
                return;
              }
              finally
              {
                for (;;)
                {
                  com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.TextStatus.WeAppStatusService", paramString, "WeAppStatus parse err", new Object[0]);
                  paramString = null;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(290083);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.n
 * JD-Core Version:    0.7.0.1
 */
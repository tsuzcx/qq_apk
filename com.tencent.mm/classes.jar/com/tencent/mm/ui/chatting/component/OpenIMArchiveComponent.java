package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.b.a;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.autogen.b.fv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.dxb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.al;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.vending.e.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=al.class)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/OpenIMArchiveComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IOpenIMArchiveComponent;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "getDialog", "()Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "setDialog", "(Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;)V", "isPause", "", "()Z", "setPause", "(Z)V", "openIMArchiveSpanHandler", "Lcom/tencent/mm/ui/chatting/component/OpenIMArchiveComponent$OpenIMArchiveSpanHandler;", "checkArchiveDlg", "", "url", "", "fromNewXml", "handleDoubleBtnClick", "info", "Lcom/tencent/mm/protocal/protobuf/OpenIMArchivePopUpInfo;", "status", "", "onChattingEnterAnimStart", "onChattingExitAnimEnd", "onChattingPause", "onChattingResume", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "showArchiveDlg", "Companion", "NetSceneGetArchiveInfo", "NetSceneUpdateArchiveStatus", "OpenIMArchiveSpanHandler", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenIMArchiveComponent
  extends a
  implements MStorage.IOnStorageChange, al
{
  public static final OpenIMArchiveComponent.a aevs;
  private final OpenIMArchiveSpanHandler aevt;
  boolean hJi;
  private j lCH;
  
  static
  {
    AppMethodBeat.i(256053);
    aevs = new OpenIMArchiveComponent.a((byte)0);
    AppMethodBeat.o(256053);
  }
  
  public OpenIMArchiveComponent()
  {
    AppMethodBeat.i(256019);
    this.aevt = new OpenIMArchiveSpanHandler(this);
    AppMethodBeat.o(256019);
  }
  
  private static final ah a(w paramw, String paramString, OpenIMArchiveComponent paramOpenIMArchiveComponent, b.a parama)
  {
    AppMethodBeat.i(256046);
    s.u(paramString, "$reqTalkerName");
    s.u(paramOpenIMArchiveComponent, "this$0");
    if (paramw != null) {
      paramw.dismiss();
    }
    Log.i("MicroMsg.OpenIMArchiveComponent", "doubleBtnClick callback errType:%s, errCode:%s, reqTalkerName:%s rsp:%s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), paramString, parama.ott });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      paramw = paramOpenIMArchiveComponent.lCH;
      if (paramw != null) {
        paramw.cyW();
      }
      ((com.tencent.mm.openim.api.f)h.az(com.tencent.mm.openim.api.f.class)).delArchie(paramString);
      paramw = ah.aiuX;
      AppMethodBeat.o(256046);
      return paramw;
    }
    paramw = (CharSequence)parama.errMsg;
    int i;
    if ((paramw == null) || (paramw.length() == 0))
    {
      i = 1;
      label143:
      if (i != 0) {
        break label197;
      }
      paramw = paramOpenIMArchiveComponent.hlc;
      if (paramw != null) {
        break label199;
      }
    }
    label197:
    label199:
    for (paramw = null;; paramw = paramw.aezO.getContext())
    {
      k.a((Context)paramw, parama.errMsg, "", paramOpenIMArchiveComponent.hlc.aezO.getContext().getString(R.l.app_ok), null);
      break;
      i = 0;
      break label143;
      break;
    }
  }
  
  private static final ah a(OpenIMArchiveComponent paramOpenIMArchiveComponent, String paramString, ah.f paramf, boolean paramBoolean, b.a parama)
  {
    AppMethodBeat.i(256034);
    s.u(paramOpenIMArchiveComponent, "this$0");
    s.u(paramString, "$reqUserName");
    s.u(paramf, "$loading");
    StringBuilder localStringBuilder = new StringBuilder().append(paramOpenIMArchiveComponent.hashCode()).append(" checkArchiveDlg() called isPause = ").append(paramOpenIMArchiveComponent.hJi).append(" reqUserName = ").append(paramString).append(" curUserName:");
    Object localObject = paramOpenIMArchiveComponent.hlc;
    if (localObject == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append(" errType:").append(parama.errType).append(" errCode:").append(parama.errCode).append(" resp:");
      if (parama != null) {
        break label191;
      }
      localObject = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.OpenIMArchiveComponent", localObject);
      paramf = (w)paramf.aqH;
      if (paramf != null) {
        paramf.dismiss();
      }
      if (!paramOpenIMArchiveComponent.hJi) {
        break label222;
      }
      paramOpenIMArchiveComponent = ah.aiuX;
      AppMethodBeat.o(256034);
      return paramOpenIMArchiveComponent;
      localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).getTalkerUserName();
      break;
      label191:
      localObject = (coi)parama.ott;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((coi)localObject).toJSON();
      }
    }
    label222:
    paramf = paramOpenIMArchiveComponent.hlc;
    if (paramf == null) {}
    for (paramf = null; !s.p(paramf, paramString); paramf = paramf.getTalkerUserName())
    {
      paramOpenIMArchiveComponent = ah.aiuX;
      AppMethodBeat.o(256034);
      return paramOpenIMArchiveComponent;
    }
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      paramString = ((coi)parama.ott).aavz;
      s.s(paramString, "it.resp.info");
      paramOpenIMArchiveComponent.a(paramString);
    }
    while (paramBoolean)
    {
      paramOpenIMArchiveComponent = ah.aiuX;
      AppMethodBeat.o(256034);
      return paramOpenIMArchiveComponent;
    }
    paramString = paramOpenIMArchiveComponent.hlc;
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.aezO.getContext())
    {
      k.a((Context)paramString, parama.errMsg, "", paramOpenIMArchiveComponent.hlc.aezO.getContext().getString(R.l.app_ok), null);
      break;
    }
  }
  
  private final void a(dxb paramdxb)
  {
    AppMethodBeat.i(256026);
    Object localObject1 = this.lCH;
    if ((localObject1 != null) && (((j)localObject1).isShowing() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(256026);
      return;
    }
    j localj;
    Object localObject2;
    if (paramdxb.abcW)
    {
      i = 3;
      localj = new j((Context)this.hlc.aezO.getContext(), i, 2, false);
      localObject2 = LayoutInflater.from((Context)this.hlc.aezO.getContext()).inflate(R.i.gmN, null);
      localj.setCustomView((View)localObject2);
      localObject1 = LayoutInflater.from((Context)this.hlc.aezO.getContext()).inflate(R.i.gmO, null);
      if (localj.VtD != null)
      {
        if (localObject1 != null) {
          break label507;
        }
        localj.VtD.setVisibility(8);
        localj.agfO.setVisibility(8);
      }
      label163:
      TextView localTextView1 = (TextView)((View)localObject2).findViewById(R.h.gaQ);
      TextView localTextView2 = (TextView)((View)localObject2).findViewById(R.h.gaN);
      localObject2 = (TextView)((View)localObject1).findViewById(R.h.gaP);
      TextView localTextView3 = localj.VtF;
      if (localTextView3 != null)
      {
        localTextView3.setTypeface(Typeface.DEFAULT_BOLD);
        i = com.tencent.mm.cd.a.br((Context)this.hlc.aezO.getContext(), R.f.Edge_3_5_A);
        localObject1 = this.hlc.aezO.getContext().getDrawable(R.k.open_im_main_logo);
        if (localObject1 != null) {
          break label620;
        }
        localObject1 = null;
        label264:
        localTextView3.setCompoundDrawables((Drawable)localObject1, null, null, null);
        localTextView3.setText((CharSequence)s.X(" ", paramdxb.title));
        localTextView3.setGravity(16);
      }
      localTextView1.setText((CharSequence)paramdxb.abcR);
      localTextView2.setText((CharSequence)paramdxb.abcS);
      localTextView2.setMovementMethod(ScrollingMovementMethod.getInstance());
      localObject1 = (CharSequence)paramdxb.aavy;
      if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
        break label631;
      }
      i = 1;
      label351:
      if (i != 0) {
        break label641;
      }
      localObject1 = (CharSequence)paramdxb.abcV;
      if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
        break label636;
      }
      i = 1;
      label376:
      if (i != 0) {
        break label641;
      }
      ((TextView)localObject2).setVisibility(0);
      localObject1 = am.aixg;
      localObject1 = String.format("<a href='%s'>%s</a>", Arrays.copyOf(new Object[] { paramdxb.aavy, paramdxb.abcV }, 2));
      s.s(localObject1, "java.lang.String.format(format, *args)");
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    for (;;)
    {
      p.t((TextView)localObject2, 1);
      localj.d((CharSequence)paramdxb.abcU, (CharSequence)paramdxb.abcT);
      localj.a(new OpenIMArchiveComponent..ExternalSyntheticLambda1(this, paramdxb), new OpenIMArchiveComponent..ExternalSyntheticLambda0(this, paramdxb));
      localj.dDn();
      this.lCH = localj;
      AppMethodBeat.o(256026);
      return;
      i = 1;
      break;
      label507:
      if (localj.Vtw == 3)
      {
        localj.VtD.setVisibility(8);
        localj.agfO.setVisibility(0);
        localj.agfO.removeAllViews();
        localj.agfO.setGravity(17);
        localj.agfO.addView((View)localObject1, -1, -2);
        break label163;
      }
      localj.agfO.setVisibility(8);
      localj.VtD.setVisibility(0);
      localj.VtD.removeAllViews();
      localj.VtD.setGravity(17);
      localj.VtD.addView((View)localObject1, -1, -2);
      break label163;
      label620:
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      break label264;
      label631:
      i = 0;
      break label351;
      label636:
      i = 0;
      break label376;
      label641:
      ((TextView)localObject2).setVisibility(8);
    }
  }
  
  private final void a(dxb paramdxb, int paramInt)
  {
    AppMethodBeat.i(256029);
    Object localObject = this.hlc;
    if (localObject == null) {
      localObject = "";
    }
    w localw;
    Activity localActivity;
    for (;;)
    {
      Log.i("MicroMsg.OpenIMArchiveComponent", "doubleBtnClick username:%s url:%s status:%s", new Object[] { localObject, paramdxb.aavy, Integer.valueOf(paramInt) });
      localw = k.a((Context)this.hlc.aezO.getContext(), this.hlc.aezO.getContext().getString(R.l.loading_tips), false, null);
      paramdxb = paramdxb.aavy;
      s.s(paramdxb, "info.privacy_agreement_url");
      paramdxb = new OpenIMArchiveComponent.c((String)localObject, paramdxb, paramInt).bFJ();
      localActivity = this.hlc.aezO.getContext();
      if (localActivity != null) {
        break;
      }
      paramdxb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(256029);
      throw paramdxb;
      localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).getTalkerUserName();
      if (localObject == null) {
        localObject = "";
      }
    }
    paramdxb.a((b)localActivity).b(new OpenIMArchiveComponent..ExternalSyntheticLambda2(localw, (String)localObject, this));
    AppMethodBeat.o(256029);
  }
  
  private static final void a(OpenIMArchiveComponent paramOpenIMArchiveComponent, dxb paramdxb)
  {
    AppMethodBeat.i(256036);
    s.u(paramOpenIMArchiveComponent, "this$0");
    s.u(paramdxb, "$info");
    paramOpenIMArchiveComponent.a(paramdxb, 2);
    AppMethodBeat.o(256036);
  }
  
  private static final void b(OpenIMArchiveComponent paramOpenIMArchiveComponent, dxb paramdxb)
  {
    AppMethodBeat.i(256039);
    s.u(paramOpenIMArchiveComponent, "this$0");
    s.u(paramdxb, "$info");
    paramOpenIMArchiveComponent.a(paramdxb, 1);
    AppMethodBeat.o(256039);
  }
  
  private final void ek(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(256022);
    Object localObject1 = this.hlc;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject3 = new StringBuilder().append(hashCode()).append(" checkArchiveDlg() called with: url = ").append(paramString).append(", fromNewXml = ").append(paramBoolean).append(" reqUserName = ").append((String)localObject1).append(" isfinish:");
      localObject2 = this.hlc.aezO.getContext();
      if (localObject2 != null) {
        break label224;
      }
    }
    label224:
    for (Object localObject2 = null;; localObject2 = Boolean.valueOf(((Activity)localObject2).isFinishing()))
    {
      Log.i("MicroMsg.OpenIMArchiveComponent", localObject2);
      localObject2 = new ah.f();
      if (!paramBoolean) {
        ((ah.f)localObject2).aqH = k.a((Context)this.hlc.aezO.getContext(), this.hlc.aezO.getContext().getString(R.l.loading_tips), false, null);
      }
      paramString = new OpenIMArchiveComponent.b((String)localObject1, paramString).bFJ();
      localObject3 = this.hlc.aezO.getContext();
      if (localObject3 != null) {
        break label237;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(256022);
      throw paramString;
      localObject1 = ((com.tencent.mm.ui.chatting.d.a)localObject1).getTalkerUserName();
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      break;
    }
    label237:
    paramString.a((b)localObject3).b(new OpenIMArchiveComponent..ExternalSyntheticLambda3(this, (String)localObject1, (ah.f)localObject2, paramBoolean));
    AppMethodBeat.o(256022);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(256077);
    super.jjg();
    Log.i("MicroMsg.OpenIMArchiveComponent", s.X("onChattingEnterAnimStart() called ", Integer.valueOf(hashCode())));
    com.tencent.mm.app.plugin.f localf = com.tencent.mm.app.plugin.f.aDP();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)this.aevt;
    localf.hkD.add(localBaseUriSpanHandler);
    AppMethodBeat.o(256077);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(256069);
    this.hJi = false;
    Object localObject = this.hlc;
    if (localObject == null)
    {
      localObject = "";
      if (!n.bp((CharSequence)localObject)) {
        break label63;
      }
    }
    label63:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label68;
      }
      AppMethodBeat.o(256069);
      return;
      str = ((com.tencent.mm.ui.chatting.d.a)localObject).getTalkerUserName();
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
    }
    label68:
    if ((!au.bwO((String)localObject)) && (!au.bwP((String)localObject)) && (!ab.IG((String)localObject)))
    {
      AppMethodBeat.o(256069);
      return;
    }
    String str = ((com.tencent.mm.openim.api.f)h.az(com.tencent.mm.openim.api.f.class)).getArchieUrl((String)localObject);
    Log.i("MicroMsg.OpenIMArchiveComponent", hashCode() + " onChattingResume talker:%s url:%s", new Object[] { localObject, str });
    localObject = (CharSequence)str;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        s.s(str, "url");
        ek(str, true);
      }
      ((com.tencent.mm.openim.api.f)h.az(com.tencent.mm.openim.api.f.class)).getArchiveStg().add((MStorage.IOnStorageChange)this);
      AppMethodBeat.o(256069);
      return;
    }
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(256071);
    Log.d("MicroMsg.OpenIMArchiveComponent", hashCode() + " onChattingPause() called");
    this.hJi = true;
    ((com.tencent.mm.openim.api.f)h.az(com.tencent.mm.openim.api.f.class)).getArchiveStg().remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(256071);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(256081);
    Log.i("MicroMsg.OpenIMArchiveComponent", s.X("onChattingExitAnimEnd() called ", Integer.valueOf(hashCode())));
    super.jjl();
    Object localObject = com.tencent.mm.app.plugin.f.aDP();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)this.aevt;
    ((com.tencent.mm.app.plugin.f)localObject).hkD.remove(localBaseUriSpanHandler);
    localObject = this.lCH;
    if (localObject != null) {
      ((j)localObject).cyW();
    }
    this.lCH = null;
    AppMethodBeat.o(256081);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(256087);
    paramString = this.hlc;
    label30:
    label48:
    Object localObject;
    if (paramString == null)
    {
      paramString = "";
      if (!n.bp((CharSequence)paramString)) {
        break label170;
      }
      i = 1;
      if (i == 0)
      {
        if ((paramMStorageEventData == null) || (paramMStorageEventData.eventId != 4)) {
          break label175;
        }
        i = 1;
        if (i != 0)
        {
          if (paramMStorageEventData != null) {
            break label180;
          }
          localObject = null;
          label59:
          if (!(localObject instanceof fv)) {
            break label189;
          }
          localObject = (fv)localObject;
          label74:
          if (localObject != null) {
            break label195;
          }
          localObject = null;
          label82:
          if (s.p(paramString, localObject))
          {
            if (paramMStorageEventData != null) {
              break label205;
            }
            paramString = null;
            label97:
            if (!(paramString instanceof fv)) {
              break label213;
            }
            paramString = (fv)paramString;
            label109:
            if (paramString != null) {
              break label218;
            }
            paramString = null;
            label115:
            paramMStorageEventData = (CharSequence)paramString;
            if ((paramMStorageEventData != null) && (!n.bp(paramMStorageEventData))) {
              break label226;
            }
          }
        }
      }
    }
    label170:
    label175:
    label180:
    label189:
    label195:
    label205:
    label213:
    label218:
    label226:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ek(paramString, true);
      }
      AppMethodBeat.o(256087);
      return;
      localObject = paramString.getTalkerUserName();
      paramString = (String)localObject;
      if (localObject != null) {
        break;
      }
      paramString = "";
      break;
      i = 0;
      break label30;
      i = 0;
      break label48;
      localObject = paramMStorageEventData.obj;
      break label59;
      localObject = null;
      break label74;
      localObject = ((fv)localObject).field_username;
      break label82;
      paramString = paramMStorageEventData.obj;
      break label97;
      paramString = null;
      break label109;
      paramString = paramString.field_content;
      break label115;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/OpenIMArchiveComponent$OpenIMArchiveSpanHandler;", "Lcom/tencent/mm/app/plugin/URISpanHandlerSet$BaseUriSpanHandler;", "component", "Lcom/tencent/mm/ui/chatting/component/OpenIMArchiveComponent;", "(Lcom/tencent/mm/ui/chatting/component/OpenIMArchiveComponent;)V", "componentRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getComponentRef", "()Ljava/lang/ref/WeakReference;", "getHandleProtocalTypes", "", "getHandleProtocals", "", "", "()[Ljava/lang/String;", "getHrefFromUrl", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "url", "handleSpanClick", "", "widget", "Landroid/view/View;", "hrefInfo", "clickCallback", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;", "handleUriJump", "isAllowScanQrCode", "callback", "Lcom/tencent/mm/pluginsdk/UriJumpCallback;", "paramsBundle", "Landroid/os/Bundle;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class OpenIMArchiveSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    private final WeakReference<OpenIMArchiveComponent> hml;
    
    public OpenIMArchiveSpanHandler(OpenIMArchiveComponent paramOpenIMArchiveComponent)
    {
      AppMethodBeat.i(256412);
      this.hml = new WeakReference(paramOpenIMArchiveComponent);
      AppMethodBeat.o(256412);
    }
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(256418);
      s.checkNotNull(paramu);
      if (paramu.type == 65)
      {
        paramView = (OpenIMArchiveComponent)this.hml.get();
        if (paramView == null) {}
        for (paramView = null;; paramView = Boolean.valueOf(paramView.hJi))
        {
          Log.d("MicroMsg.OpenIMArchiveComponent", s.X("handleSpanClick ", paramView));
          paramView = (OpenIMArchiveComponent)this.hml.get();
          if (paramView != null) {
            break;
          }
          AppMethodBeat.o(256418);
          return false;
        }
        if (paramView.hJi)
        {
          AppMethodBeat.o(256418);
          return false;
        }
        paramu = Uri.parse(paramu.url).getQueryParameter("url");
        if (paramu != null) {
          OpenIMArchiveComponent.a(paramView, paramu);
        }
        AppMethodBeat.o(256418);
        return true;
      }
      AppMethodBeat.o(256418);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 65 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(256414);
      s.checkNotNull(paramString);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(256414);
        throw paramString;
      }
      if (n.U(n.bq((CharSequence)paramString).toString(), "wxwork://jump?target=archivepopup", false))
      {
        paramString = new u(paramString, 65, null);
        AppMethodBeat.o(256414);
        return paramString;
      }
      AppMethodBeat.o(256414);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.OpenIMArchiveComponent
 * JD-Core Version:    0.7.0.1
 */
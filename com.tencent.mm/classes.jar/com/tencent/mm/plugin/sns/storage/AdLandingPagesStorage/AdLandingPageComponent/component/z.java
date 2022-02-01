package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.openim.api.d;
import com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver;
import com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver.b;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.dxm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageJumpKefuBtnComp;", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent;", "Ljava/io/Serializable;", "context", "Landroid/content/Context;", "mBtnInfo", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/AdLandingPageJumpKefuBtnInfo;", "container", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/AdLandingPageJumpKefuBtnInfo;Landroid/view/ViewGroup;)V", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getMBtnInfo", "()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/AdLandingPageJumpKefuBtnInfo;", "setMBtnInfo", "(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/AdLandingPageJumpKefuBtnInfo;)V", "doBtnClick", "", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends r
  implements Serializable
{
  public static final z.a QQP;
  private ViewGroup CAj;
  private ao QQQ;
  private Context context;
  
  static
  {
    AppMethodBeat.i(307209);
    QQP = new z.a((byte)0);
    AppMethodBeat.o(307209);
  }
  
  public z(Context paramContext, ao paramao, ViewGroup paramViewGroup)
  {
    super(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramao, paramViewGroup);
    AppMethodBeat.i(307205);
    this.context = paramContext;
    this.QQQ = paramao;
    this.CAj = paramViewGroup;
    AppMethodBeat.o(307205);
  }
  
  protected final void hac()
  {
    AppMethodBeat.i(307216);
    Object localObject3 = this.QPl;
    Object localObject2 = this.QQQ.QLF;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a)localObject3).mx("jumpKefuUrl", (String)localObject1);
    Context localContext = this.context;
    if (localContext == null)
    {
      AppMethodBeat.o(307216);
      return;
    }
    localObject1 = hjn();
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AdLandingPageJumpKefuBtnComp", "uxinfo is null!");
        localObject2 = "";
      }
      localObject3 = new OpenIMKefuStartConversationRequest();
      ((OpenIMKefuStartConversationRequest)localObject3).context = localContext;
      ((OpenIMKefuStartConversationRequest)localObject3).prw = 10;
      localObject1 = new du();
      ((du)localObject1).url = this.QQQ.QLF;
      ((du)localObject1).YFV = this.QQQ.QLF;
      dxm localdxm = new dxm();
      localdxm.url = this.QQQ.QLF;
      localdxm.scene = ((OpenIMKefuStartConversationRequest)localObject3).prw;
      localdxm.abdw = ((String)localObject2);
      localObject2 = ah.aiuX;
      ((du)localObject1).YFX = localdxm;
      localObject2 = ah.aiuX;
      ((OpenIMKefuStartConversationRequest)localObject3).pry = ((du)localObject1);
      ((OpenIMKefuStartConversationRequest)localObject3).hBk = System.currentTimeMillis();
      ((OpenIMKefuStartConversationRequest)localObject3).prx = com.tencent.mm.openim.api.h.a.xD(((OpenIMKefuStartConversationRequest)localObject3).prw);
      ((OpenIMKefuStartConversationRequest)localObject3).prz = true;
      localObject1 = localContext.getResources();
      if (localObject1 != null) {
        break label316;
      }
      localObject1 = "";
    }
    for (;;)
    {
      ((OpenIMKefuStartConversationRequest)localObject3).prA = ((String)localObject1);
      ((OpenIMKefuStartConversationRequest)localObject3).prF = new Intent();
      localObject1 = ((OpenIMKefuStartConversationRequest)localObject3).prF;
      localObject2 = MMHandler.createFreeHandler(Looper.getMainLooper());
      s.s(localObject2, "createFreeHandler(Looper.getMainLooper())");
      ((Intent)localObject1).putExtra("key_result_receiver", (Parcelable)new OpenImKefuStartChattingResultReceiver((Handler)localObject2, (OpenImKefuStartChattingResultReceiver.b)new z.b()));
      localObject1 = (d)h.ax(d.class);
      if (localObject1 != null) {
        ((d)localObject1).a((OpenIMKefuStartConversationRequest)localObject3);
      }
      AppMethodBeat.o(307216);
      return;
      localObject1 = ((ai)localObject1).uxInfo;
      break;
      label316:
      localObject2 = ((Resources)localObject1).getString(b.j.open_im_kefu_start_conversation_error_tips);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z
 * JD-Core Version:    0.7.0.1
 */
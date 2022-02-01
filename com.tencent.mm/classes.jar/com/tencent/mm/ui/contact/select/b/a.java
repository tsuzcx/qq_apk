package com.tencent.mm.ui.contact.select.b;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.roomsdk.model.b.c;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/select/uic/SelectContactCreateChatroomUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isChatroomCreateStarted", "", "createChatroom", "", "memberList", "", "", "dealCreateChatRoomFail", "errType", "", "errCode", "result", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "sysErrMsg", "isWxRoom", "dealNeedVerify", "verifyUserList", "Ljava/util/LinkedList;", "memberBlackList", "doVerify", "lstVerifyUser", "isCreateOpenimRoomByAssociateChatRoom", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "usernameToDisplayName", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.mvvmbase.a
{
  private boolean afhY;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(253143);
    AppMethodBeat.o(253143);
  }
  
  private static final void MF(boolean paramBoolean) {}
  
  private static final void a(a parama, LinkedList paramLinkedList, DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 0;
    AppMethodBeat.i(253165);
    s.u(parama, "this$0");
    if (paramLinkedList.size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramDialogInterface = new LinkedList();
      int j = paramLinkedList.size() - 1;
      if (j >= 0)
      {
        int i;
        do
        {
          i = paramInt + 1;
          paramDialogInterface.add(Integer.valueOf(3));
          paramInt = i;
        } while (i <= j);
      }
      new ab((Context)parama.getActivity(), a..ExternalSyntheticLambda2.INSTANCE).a(paramLinkedList, paramDialogInterface, null);
      AppMethodBeat.o(253165);
      return;
    }
  }
  
  private static final void a(a parama, ah.f paramf, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(253154);
    s.u(parama, "this$0");
    s.u(paramf, "$createRoomFactory");
    parama.afhY = false;
    ((com.tencent.mm.roomsdk.model.factory.a)paramf.aqH).cancel();
    AppMethodBeat.o(253154);
  }
  
  private static List<String> bs(List<String> paramList)
  {
    AppMethodBeat.i(253149);
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(aa.getDisplayName((String)((Iterator)localObject).next()));
    }
    paramList = (List)paramList;
    AppMethodBeat.o(253149);
    return paramList;
  }
  
  public final void od(List<String> paramList)
  {
    AppMethodBeat.i(253215);
    s.u(paramList, "memberList");
    if (this.afhY)
    {
      AppMethodBeat.o(253215);
      return;
    }
    this.afhY = true;
    int i;
    Object localObject;
    if (((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("MMDirectCreateAssociateChatRoomSwitch", 0) == 1)
    {
      i = 1;
      if (i != 0) {
        break label301;
      }
      localObject = ((Iterable)paramList).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!au.bwO((String)((Iterator)localObject).next()));
    }
    label301:
    for (int j = 0;; j = 1)
    {
      localObject = new ah.f();
      if ((i != 0) || (j != 0))
      {
        paramList = com.tencent.mm.roomsdk.model.b.btW("@chatroom").b("", paramList);
        s.s(paramList, "service(ConstantsStorage…reateRoom(\"\", memberList)");
      }
      for (((ah.f)localObject).aqH = paramList;; ((ah.f)localObject).aqH = paramList)
      {
        ((com.tencent.mm.roomsdk.model.factory.a)((ah.f)localObject).aqH).d((com.tencent.mm.roomsdk.model.b.a)new a((ah.f)localObject, this));
        ((com.tencent.mm.roomsdk.model.factory.a)((ah.f)localObject).aqH).a((Context)getActivity(), getString(R.l.app_tip), getString(R.l.gME), true, true, new a..ExternalSyntheticLambda0(this, (ah.f)localObject));
        AppMethodBeat.o(253215);
        return;
        i = 0;
        break;
        if (!w.jyX())
        {
          k.d((Context)getActivity(), getActivity().getString(R.l.gVY), "", null);
          this.afhY = false;
          AppMethodBeat.o(253215);
          return;
        }
        paramList = com.tencent.mm.roomsdk.model.b.btW("@im.chatroom").b("", paramList);
        s.s(paramList, "service(ConstantsStorage…reateRoom(\"\", memberList)");
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253207);
    paramBundle = gst();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStateCenter();
      if (paramBundle != null) {
        paramBundle.observe((q)getActivity(), (kotlin.g.a.b)new a.b(this));
      }
    }
    AppMethodBeat.o(253207);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/contact/select/uic/SelectContactCreateChatroomUIC$createChatroom$2", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "onResult", "", "errType", "", "errCode", "errMsg", "", "detailResult", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c
  {
    a(ah.f<com.tencent.mm.roomsdk.model.factory.a> paramf, a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.select.b.a
 * JD-Core Version:    0.7.0.1
 */
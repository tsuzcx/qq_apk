package com.tencent.mm.plugin.textstatus.conversation.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.conversation.d.d;
import com.tencent.mm.plugin.textstatus.conversation.d.f;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/ui/TextStatusProfileBottomDialog;", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "context", "Landroid/content/Context;", "_contact", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContact;", "item", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "showBottomBtn", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContact;Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;Z)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends j
{
  w psR;
  
  private a(Context paramContext, com.tencent.mm.plugin.textstatus.h.f.h paramh, d paramd, boolean paramBoolean)
  {
    super(paramContext, 0, 1);
    AppMethodBeat.i(290984);
    com.tencent.mm.plugin.textstatus.h.f.h localh;
    label38:
    Object localObject2;
    label69:
    Object localObject1;
    label115:
    Object localObject3;
    label156:
    int i;
    label231:
    label369:
    boolean bool;
    if (paramh == null)
    {
      paramh = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
      if (paramd == null)
      {
        paramh = null;
        localh = com.tencent.mm.plugin.textstatus.conversation.g.a.bdK(paramh);
        aFf(a.f.Tfg);
        localObject2 = (ImageView)this.rootView.findViewById(a.e.avatarIv);
        if (localh != null) {
          break label494;
        }
        paramh = "";
        com.tencent.mm.ui.i.a.a.g((ImageView)localObject2, paramh);
        if (localh != null)
        {
          localObject2 = this.rootView;
          localObject1 = (TextView)((View)localObject2).findViewById(a.e.conversationName);
          paramh = localh.field_nickname;
          if (paramh != null) {
            break label515;
          }
          paramh = (CharSequence)"";
          ((TextView)localObject1).setText(paramh);
          localObject3 = new StringBuilder();
          switch (localh.field_sex)
          {
          default: 
            localObject1 = localh.field_country;
            paramh = (com.tencent.mm.plugin.textstatus.h.f.h)localObject1;
            if (localObject1 == null) {
              paramh = "";
            }
            RegionCodeDecoder.jcF();
            localObject1 = RegionCodeDecoder.pL(paramh, localh.field_province);
            RegionCodeDecoder.jcF();
            paramh = RegionCodeDecoder.bJ(paramh, localh.field_province, localh.field_city);
            CharSequence localCharSequence = (CharSequence)localObject1;
            if ((localCharSequence == null) || (n.bp(localCharSequence)))
            {
              i = 1;
              if (i == 0) {
                ((StringBuilder)localObject3).append((String)localObject1).append(" ");
              }
              localObject1 = (CharSequence)paramh;
              if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
                break label571;
              }
              i = 1;
              label271:
              if (i == 0) {
                ((StringBuilder)localObject3).append(paramh);
              }
              ((TextView)((View)localObject2).findViewById(a.e.descTv)).setText((CharSequence)localObject3);
              localObject3 = (TextView)((View)localObject2).findViewById(a.e.TeA);
              localObject1 = localh.field_signature;
              paramh = (com.tencent.mm.plugin.textstatus.h.f.h)localObject1;
              if (localObject1 == null) {
                paramh = "";
              }
              ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)paramh));
              paramh = (Button)((View)localObject2).findViewById(a.e.TbZ);
              if (!paramBoolean) {
                break label577;
              }
              i = 0;
              paramh.setVisibility(i);
              paramh = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
              localObject1 = localh.field_sessionId;
              paramh = (com.tencent.mm.plugin.textstatus.h.f.h)localObject1;
              if (localObject1 == null) {
                paramh = "";
              }
              bool = com.tencent.mm.plugin.textstatus.conversation.g.a.bdL(paramh);
              localObject1 = (Button)((View)localObject2).findViewById(a.e.TbZ);
              if (!bool) {
                break label583;
              }
            }
            break;
          }
        }
      }
    }
    label515:
    label571:
    label577:
    label583:
    for (paramh = (CharSequence)paramContext.getResources().getString(a.h.TgC);; paramh = (CharSequence)paramContext.getResources().getString(a.h.TgB))
    {
      ((Button)localObject1).setText(paramh);
      if (paramBoolean) {
        ((Button)((View)localObject2).findViewById(a.e.TbZ)).setOnClickListener(new a..ExternalSyntheticLambda1(bool, localh, paramContext, paramd, this));
      }
      AppMethodBeat.o(290984);
      return;
      paramh = paramd.field_session_id;
      break;
      localh = paramh;
      break label38;
      label494:
      localObject1 = localh.field_sessionId;
      paramh = (com.tencent.mm.plugin.textstatus.h.f.h)localObject1;
      if (localObject1 != null) {
        break label69;
      }
      paramh = "";
      break label69;
      paramh = (CharSequence)paramh;
      break label115;
      ((StringBuilder)localObject3).append(paramContext.getString(a.h.sex_male)).append(" ");
      break label156;
      ((StringBuilder)localObject3).append(paramContext.getString(a.h.sex_female)).append(" ");
      break label156;
      i = 0;
      break label231;
      i = 0;
      break label271;
      i = 4;
      break label369;
    }
  }
  
  private static final void a(boolean paramBoolean, final com.tencent.mm.plugin.textstatus.h.f.h paramh, final Context paramContext, d paramd, a parama, View paramView)
  {
    AppMethodBeat.i(291011);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.fv(paramBoolean);
    localb.cH(paramh);
    localb.cH(paramContext);
    localb.cH(paramd);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/conversation/ui/TextStatusProfileBottomDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "$it");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(parama, "this$0");
    if (paramBoolean) {
      com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq.a(paramh.field_sessionId, paramh.field_userName, paramContext);
    }
    label170:
    do
    {
      parama.cyW();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/conversation/ui/TextStatusProfileBottomDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291011);
      return;
      paramView = f.Tjd;
      if (paramd != null) {
        break;
      }
      paramView = "";
      f.a.hp(paramView, 105);
    } while (paramd == null);
    paramView = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
    if ((paramContext instanceof q)) {}
    for (paramView = (q)paramContext;; paramView = null)
    {
      paramh = com.tencent.mm.plugin.textstatus.conversation.g.a.a(paramd, paramView, (kotlin.g.a.b)new a(parama, paramh, paramContext));
      paramContext.getString(a.h.TgJ);
      parama.psR = k.a(paramContext, paramContext.getString(a.h.TgJ), true, new a..ExternalSyntheticLambda0(paramh));
      break;
      localObject = paramd.field_session_id;
      paramView = (View)localObject;
      if (localObject != null) {
        break label170;
      }
      paramView = "";
      break label170;
    }
  }
  
  private static final void b(com.tencent.mm.am.p paramp, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(290998);
    com.tencent.mm.kernel.h.aZW().a(paramp);
    AppMethodBeat.o(290998);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    a(a parama, com.tencent.mm.plugin.textstatus.h.f.h paramh, Context paramContext)
    {
      super();
    }
    
    private static final void i(Context paramContext, View paramView)
    {
      AppMethodBeat.i(290997);
      kotlin.g.b.s.u(paramContext, "$context");
      if (paramView == null) {}
      for (WeImageView localWeImageView = null;; localWeImageView = (WeImageView)paramView.findViewById(a.e.toast_img))
      {
        if (localWeImageView != null) {
          localWeImageView.setImageResource(a.g.icons_outlined_done);
        }
        if (paramView != null)
        {
          paramView = (TextView)paramView.findViewById(a.e.toast_text);
          if (paramView != null) {
            paramView.setTextSize(0, com.tencent.mm.cd.a.bs(paramContext, a.c.DescTextSize));
          }
        }
        AppMethodBeat.o(290997);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.ui.a
 * JD-Core Version:    0.7.0.1
 */
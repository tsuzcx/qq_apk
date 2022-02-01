package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class w
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  private com.tencent.mm.plugin.scanner.util.a KcC;
  private View.OnClickListener qkD;
  private com.tencent.mm.plugin.scanner.util.c ypc;
  
  w()
  {
    AppMethodBeat.i(37039);
    this.ypc = new com.tencent.mm.plugin.scanner.util.c();
    this.KcC = new com.tencent.mm.plugin.scanner.util.a();
    this.qkD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37037);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = (bk)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          ad.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan tag not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.dBd;
        if (paramAnonymousView == null)
        {
          ad.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan msg not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.field_content;
        if (bt.isNullOrNil(paramAnonymousView))
        {
          ad.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan content not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        localObject = OfflineScanContext.CREATOR;
        paramAnonymousView = OfflineScanContext.a.awE(paramAnonymousView);
        ad.i("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan onClick codeType: %d, selectFromAlbum: %b", new Object[] { Integer.valueOf(paramAnonymousView.dnt), Boolean.valueOf(paramAnonymousView.ymW) });
        localObject = n.ymX;
        localObject = paramAnonymousView.ymV;
        String str = paramAnonymousView.typeName;
        if (paramAnonymousView.ymW) {}
        for (int i = 2;; i = 1)
        {
          n.d((String)localObject, str, i, paramAnonymousView.networkType, 1);
          if (g.aiU().aEN() != 0) {
            break;
          }
          com.tencent.mm.ui.base.h.a(w.a(w.this).JOR.getContext(), w.a(w.this).JOR.getContext().getString(2131761792), "", w.a(w.this).JOR.getContext().getString(2131755793), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(37036);
              paramAnonymous2DialogInterface.dismiss();
              AppMethodBeat.o(37036);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        if (e.d.aLh(paramAnonymousView.typeName))
        {
          if (bt.isNullOrNil(paramAnonymousView.ymV))
          {
            ad.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan qBar result invalid");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
            return;
          }
          w.b(w.this).a(w.a(w.this).JOR.getContext(), paramAnonymousView.ymV, paramAnonymousView.dnh, paramAnonymousView.typeName, paramAnonymousView.dnt, paramAnonymousView.dnu, null, null, paramAnonymousView.dnx, 3, true, paramAnonymousView.networkType, false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
          localObject = paramAnonymousView.ymV;
          if (bt.isNullOrNil((String)localObject))
          {
            ad.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan zBar result invalid");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
            return;
          }
          w.c(w.this).a(w.a(w.this).JOR.getContext(), null, null, (String)localObject, paramAnonymousView.ymW, paramAnonymousView.dnu, paramAnonymousView.typeName, paramAnonymousView.dnx, 3, true, paramAnonymousView.networkType, false);
        }
      }
    };
    AppMethodBeat.o(37039);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37040);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493470);
      ((View)localObject).setTag(new a().gC((View)localObject));
    }
    AppMethodBeat.o(37040);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37041);
    this.JBI = parama1;
    parama = (a)parama;
    paramString = parambu.field_content;
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37041);
      return;
    }
    Object localObject = OfflineScanContext.CREATOR;
    localObject = OfflineScanContext.a.awE(paramString);
    ad.d("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo filling OfflineScan context %s", new Object[] { ((OfflineScanContext)localObject).toString() });
    paramString = parama.KcF;
    long l = ((OfflineScanContext)localObject).timestamp;
    localObject = new Time();
    ((Time)localObject).set(l);
    localObject = com.tencent.mm.pluginsdk.i.h.a("yyyy-MM-dd kk:mm", (Time)localObject).toString();
    paramString.setText(String.format(aj.getContext().getString(2131761794), new Object[] { localObject }));
    parambu = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
    parama.ofK.setTag(parambu);
    parama.ofK.setOnLongClickListener(c(parama1));
    parama.ofK.setOnClickListener(this.qkD);
    parama.KcG.setTag(parambu);
    parama.KcG.setOnClickListener(this.qkD);
    AppMethodBeat.o(37041);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194385);
    parambu = (bk)paramView.getTag();
    if (parambu == null)
    {
      AppMethodBeat.o(194385);
      return false;
    }
    paraml.a(parambu.position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(194385);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 721420337);
  }
  
  protected final boolean fHg()
  {
    return false;
  }
  
  public final boolean fHh()
  {
    return false;
  }
  
  final boolean fHi()
  {
    return false;
  }
  
  protected final boolean fHk()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    TextView KcF;
    RelativeLayout KcG;
    
    a() {}
    
    final a gC(View paramView)
    {
      AppMethodBeat.i(37038);
      super.gn(paramView);
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.ofK = paramView.findViewById(2131298069);
      this.KcF = ((TextView)paramView.findViewById(2131302994));
      this.KcG = ((RelativeLayout)paramView.findViewById(2131302993));
      AppMethodBeat.o(37038);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w
 * JD-Core Version:    0.7.0.1
 */
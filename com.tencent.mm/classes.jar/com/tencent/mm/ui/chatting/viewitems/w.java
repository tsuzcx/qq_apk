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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.plugin.scanner.model.o;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class w
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  private com.tencent.mm.plugin.scanner.util.a KyU;
  private View.OnClickListener qri;
  private com.tencent.mm.plugin.scanner.util.c yFb;
  
  w()
  {
    AppMethodBeat.i(37039);
    this.yFb = new com.tencent.mm.plugin.scanner.util.c();
    this.KyU = new com.tencent.mm.plugin.scanner.util.a();
    this.qri = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37037);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = (bk)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          ae.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan tag not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.dCi;
        if (paramAnonymousView == null)
        {
          ae.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan msg not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.field_content;
        if (bu.isNullOrNil(paramAnonymousView))
        {
          ae.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan content not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        localObject = OfflineScanContext.CREATOR;
        paramAnonymousView = OfflineScanContext.a.axT(paramAnonymousView);
        ae.i("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan onClick codeType: %d, selectFromAlbum: %b", new Object[] { Integer.valueOf(paramAnonymousView.dov), Boolean.valueOf(paramAnonymousView.yCV) });
        localObject = o.yCW;
        localObject = paramAnonymousView.yCU;
        String str = paramAnonymousView.typeName;
        if (paramAnonymousView.yCV) {}
        for (int i = 2;; i = 1)
        {
          o.d((String)localObject, str, i, paramAnonymousView.networkType, 1);
          if (g.ajj().aFd() != 0) {
            break;
          }
          com.tencent.mm.ui.base.h.a(w.a(w.this).Kkd.getContext(), w.a(w.this).Kkd.getContext().getString(2131761792), "", w.a(w.this).Kkd.getContext().getString(2131755793), new DialogInterface.OnClickListener()
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
        if (e.d.aMD(paramAnonymousView.typeName))
        {
          if (bu.isNullOrNil(paramAnonymousView.yCU))
          {
            ae.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan qBar result invalid");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
            return;
          }
          w.b(w.this).a(w.a(w.this).Kkd.getContext(), paramAnonymousView.yCU, paramAnonymousView.doj, paramAnonymousView.typeName, paramAnonymousView.dov, paramAnonymousView.dow, null, null, paramAnonymousView.doz, 3, true, paramAnonymousView.networkType, false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
          localObject = paramAnonymousView.yCU;
          if (bu.isNullOrNil((String)localObject))
          {
            ae.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan zBar result invalid");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
            return;
          }
          w.c(w.this).a(w.a(w.this).Kkd.getContext(), null, null, (String)localObject, paramAnonymousView.yCV, paramAnonymousView.dow, paramAnonymousView.typeName, paramAnonymousView.doz, 3, true, paramAnonymousView.networkType, false);
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
      ((View)localObject).setTag(new a().gH((View)localObject));
    }
    AppMethodBeat.o(37040);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37041);
    this.JWz = parama1;
    parama = (a)parama;
    paramString = parambv.field_content;
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37041);
      return;
    }
    Object localObject = OfflineScanContext.CREATOR;
    localObject = OfflineScanContext.a.axT(paramString);
    ae.d("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo filling OfflineScan context %s", new Object[] { ((OfflineScanContext)localObject).toString() });
    paramString = parama.KyX;
    long l = ((OfflineScanContext)localObject).timestamp;
    localObject = new Time();
    ((Time)localObject).set(l);
    localObject = com.tencent.mm.pluginsdk.i.h.a("yyyy-MM-dd kk:mm", (Time)localObject).toString();
    paramString.setText(String.format(ak.getContext().getString(2131761794), new Object[] { localObject }));
    parambv = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
    parama.olI.setTag(parambv);
    parama.olI.setOnLongClickListener(c(parama1));
    parama.olI.setOnClickListener(this.qri);
    parama.KyY.setTag(parambv);
    parama.KyY.setOnClickListener(this.qri);
    AppMethodBeat.o(37041);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187780);
    parambv = (bk)paramView.getTag();
    if (parambv == null)
    {
      AppMethodBeat.o(187780);
      return false;
    }
    paraml.a(parambv.position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(187780);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 721420337);
  }
  
  final boolean fLA()
  {
    return false;
  }
  
  protected final boolean fLC()
  {
    return false;
  }
  
  protected final boolean fLy()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    TextView KyX;
    RelativeLayout KyY;
    
    a() {}
    
    final a gH(View paramView)
    {
      AppMethodBeat.i(37038);
      super.gs(paramView);
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.olI = paramView.findViewById(2131298069);
      this.KyX = ((TextView)paramView.findViewById(2131302994));
      this.KyY = ((RelativeLayout)paramView.findViewById(2131302993));
      AppMethodBeat.o(37038);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w
 * JD-Core Version:    0.7.0.1
 */
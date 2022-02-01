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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.plugin.scanner.model.q;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class ac
  extends c
{
  private com.tencent.mm.plugin.scanner.util.c CIT;
  private com.tencent.mm.plugin.scanner.util.a PLt;
  private com.tencent.mm.ui.chatting.e.a PhN;
  private View.OnClickListener rID;
  
  ac()
  {
    AppMethodBeat.i(37039);
    this.CIT = new com.tencent.mm.plugin.scanner.util.c();
    this.PLt = new com.tencent.mm.plugin.scanner.util.a();
    this.rID = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37037);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = (bq)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan tag not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.dTX;
        if (paramAnonymousView == null)
        {
          Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan msg not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.field_content;
        if (Util.isNullOrNil(paramAnonymousView))
        {
          Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan content not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        localObject = OfflineScanContext.CREATOR;
        paramAnonymousView = OfflineScanContext.a.aMx(paramAnonymousView);
        Log.i("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan onClick codeType: %d, selectFromAlbum: %b", new Object[] { Integer.valueOf(paramAnonymousView.dFL), Boolean.valueOf(paramAnonymousView.CFK) });
        localObject = q.CFL;
        localObject = paramAnonymousView.CFJ;
        String str = paramAnonymousView.typeName;
        if (paramAnonymousView.CFK) {}
        for (int i = 2;; i = 1)
        {
          q.b((String)localObject, str, i, paramAnonymousView.networkType, 1);
          if (g.azz().aYS() != 0) {
            break;
          }
          h.a(ac.a(ac.this).Pwc.getContext(), ac.a(ac.this).Pwc.getContext().getString(2131763763), "", ac.a(ac.this).Pwc.getContext().getString(2131755874), new DialogInterface.OnClickListener()
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
        if (e.d.bcW(paramAnonymousView.typeName))
        {
          if (Util.isNullOrNil(paramAnonymousView.CFJ))
          {
            Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan qBar result invalid");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
            return;
          }
          ac.b(ac.this).a(ac.a(ac.this).Pwc.getContext(), paramAnonymousView.CFJ, paramAnonymousView.source, paramAnonymousView.typeName, paramAnonymousView.dFL, paramAnonymousView.dFM, null, null, paramAnonymousView.dFP, 3, true, paramAnonymousView.networkType, false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
          localObject = paramAnonymousView.CFJ;
          if (Util.isNullOrNil((String)localObject))
          {
            Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan zBar result invalid");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
            return;
          }
          ac.c(ac.this).a(ac.a(ac.this).Pwc.getContext(), null, null, (String)localObject, paramAnonymousView.CFK, paramAnonymousView.dFM, paramAnonymousView.typeName, paramAnonymousView.dFP, 3, true, paramAnonymousView.networkType, false, 0);
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
      localObject = new an(paramLayoutInflater, 2131493572);
      ((View)localObject).setTag(new a().gX((View)localObject));
    }
    AppMethodBeat.o(37040);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37041);
    this.PhN = parama1;
    parama = (a)parama;
    paramString = paramca.field_content;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37041);
      return;
    }
    Object localObject = OfflineScanContext.CREATOR;
    localObject = OfflineScanContext.a.aMx(paramString);
    Log.d("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo filling OfflineScan context %s", new Object[] { ((OfflineScanContext)localObject).toString() });
    paramString = parama.PLw;
    long l = ((OfflineScanContext)localObject).timestamp;
    localObject = new Time();
    ((Time)localObject).set(l);
    localObject = e.a("yyyy-MM-dd kk:mm", (Time)localObject).toString();
    paramString.setText(String.format(MMApplicationContext.getContext().getString(2131763765), new Object[] { localObject }));
    paramca = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
    parama.clickArea.setTag(paramca);
    parama.clickArea.setOnLongClickListener(c(parama1));
    parama.clickArea.setOnClickListener(this.rID);
    parama.PLx.setTag(paramca);
    parama.PLx.setOnClickListener(this.rID);
    AppMethodBeat.o(37041);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233777);
    paramca = (bq)paramView.getTag();
    if (paramca == null)
    {
      AppMethodBeat.o(233777);
      return false;
    }
    paramm.a(paramca.position, 100, paramView.getContext().getString(2131757433), 2131690529);
    AppMethodBeat.o(233777);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 721420337);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  protected final boolean gTU()
  {
    return false;
  }
  
  final boolean gTV()
  {
    return false;
  }
  
  protected final boolean gTX()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    TextView PLw;
    RelativeLayout PLx;
    
    a() {}
    
    final a gX(View paramView)
    {
      AppMethodBeat.i(37038);
      super.create(paramView);
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.clickArea = paramView.findViewById(2131298411);
      this.PLw = ((TextView)paramView.findViewById(2131305586));
      this.PLx = ((RelativeLayout)paramView.findViewById(2131305585));
      AppMethodBeat.o(37038);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac
 * JD-Core Version:    0.7.0.1
 */
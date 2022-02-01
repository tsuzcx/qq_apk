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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.j.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class af
  extends c
{
  private com.tencent.mm.plugin.scanner.util.c IOt;
  private com.tencent.mm.ui.chatting.e.a WBq;
  private com.tencent.mm.plugin.scanner.util.a Xhn;
  private View.OnClickListener vol;
  
  af()
  {
    AppMethodBeat.i(37039);
    this.IOt = new com.tencent.mm.plugin.scanner.util.c();
    this.Xhn = new com.tencent.mm.plugin.scanner.util.a();
    this.vol = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37037);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = (by)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan tag not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.fNz;
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
        paramAnonymousView = OfflineScanContext.a.aXe(paramAnonymousView);
        Log.i("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan onClick codeType: %d, selectFromAlbum: %b", new Object[] { Integer.valueOf(paramAnonymousView.fys), Boolean.valueOf(paramAnonymousView.IKW) });
        localObject = com.tencent.mm.plugin.scanner.model.o.IKX;
        localObject = paramAnonymousView.IAH;
        String str = paramAnonymousView.typeName;
        if (paramAnonymousView.IKW) {}
        for (int i = 2;; i = 1)
        {
          com.tencent.mm.plugin.scanner.model.o.b((String)localObject, str, i, paramAnonymousView.networkType, 1);
          if (com.tencent.mm.kernel.h.aGY().bih() != 0) {
            break;
          }
          com.tencent.mm.ui.base.h.a(af.a(af.this).WQv.getContext(), af.a(af.this).WQv.getContext().getString(R.l.eOH), "", af.a(af.this).WQv.getContext().getString(R.l.app_i_known), new DialogInterface.OnClickListener()
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
        if (e.d.boW(paramAnonymousView.typeName))
        {
          if (Util.isNullOrNil(paramAnonymousView.IAH))
          {
            Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan qBar result invalid");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
            return;
          }
          af.b(af.this).a(af.a(af.this).WQv.getContext(), paramAnonymousView.IAH, paramAnonymousView.source, paramAnonymousView.typeName, paramAnonymousView.fys, paramAnonymousView.fyt, paramAnonymousView.fyw, 3, true, paramAnonymousView.networkType, false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
          localObject = paramAnonymousView.IAH;
          if (Util.isNullOrNil((String)localObject))
          {
            Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan zBar result invalid");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
            return;
          }
          af.c(af.this).a(af.a(af.this).WQv.getContext(), null, null, (String)localObject, paramAnonymousView.IKW, paramAnonymousView.fyt, paramAnonymousView.typeName, paramAnonymousView.fyw, 3, true, paramAnonymousView.networkType, false, 0);
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
      localObject = new aq(paramLayoutInflater, R.i.edB);
      ((View)localObject).setTag(new a().ij((View)localObject));
    }
    AppMethodBeat.o(37040);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37041);
    this.WBq = parama1;
    parama = (a)parama;
    paramString = paramca.field_content;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37041);
      return;
    }
    Object localObject = OfflineScanContext.CREATOR;
    localObject = OfflineScanContext.a.aXe(paramString);
    Log.d("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo filling OfflineScan context %s", new Object[] { ((OfflineScanContext)localObject).toString() });
    paramString = parama.Xhq;
    long l = ((OfflineScanContext)localObject).timestamp;
    localObject = new Time();
    ((Time)localObject).set(l);
    localObject = e.a("yyyy-MM-dd kk:mm", (Time)localObject).toString();
    paramString.setText(String.format(MMApplicationContext.getContext().getString(R.l.dQC), new Object[] { localObject }));
    paramca = new by(paramca, parama1.hRi(), paramInt, null, '\000');
    parama.clickArea.setTag(paramca);
    parama.clickArea.setOnLongClickListener(c(parama1));
    parama.clickArea.setOnClickListener(this.vol);
    parama.Xhr.setTag(paramca);
    parama.Xhr.setOnClickListener(this.vol);
    AppMethodBeat.o(37041);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(289603);
    paramca = (by)paramView.getTag();
    if (paramca == null)
    {
      AppMethodBeat.o(289603);
      return false;
    }
    paramo.a(paramca.position, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
    AppMethodBeat.o(289603);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 721420337);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  protected final boolean hTE()
  {
    return false;
  }
  
  final boolean hTF()
  {
    return false;
  }
  
  protected final boolean hTH()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    TextView Xhq;
    RelativeLayout Xhr;
    
    a() {}
    
    final a ij(View paramView)
    {
      AppMethodBeat.i(37038);
      super.create(paramView);
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.clickArea = paramView.findViewById(R.h.chatting_click_area);
      this.Xhq = ((TextView)paramView.findViewById(R.h.dQC));
      this.Xhr = ((RelativeLayout)paramView.findViewById(R.h.dQB));
      AppMethodBeat.o(37038);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af
 * JD-Core Version:    0.7.0.1
 */
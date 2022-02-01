package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.format.Time;
import android.view.ContextMenu.ContextMenuInfo;
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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.pluginsdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class ad
  extends c
{
  private com.tencent.mm.plugin.scanner.util.c OVv;
  private com.tencent.mm.plugin.scanner.util.a aeRr;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private View.OnClickListener yAH;
  
  ad()
  {
    AppMethodBeat.i(37039);
    this.OVv = new com.tencent.mm.plugin.scanner.util.c();
    this.aeRr = new com.tencent.mm.plugin.scanner.util.a();
    this.yAH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37037);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        paramAnonymousView = (bz)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan tag not valid");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.hTm;
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
        paramAnonymousView = OfflineScanContext.a.aUF(paramAnonymousView);
        Log.i("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan onClick codeType: %d, selectFromAlbum: %b", new Object[] { Integer.valueOf(paramAnonymousView.hDb), Boolean.valueOf(paramAnonymousView.ORR) });
        localObject = w.ORS;
        localObject = paramAnonymousView.OGQ;
        String str = paramAnonymousView.typeName;
        if (paramAnonymousView.ORR) {}
        for (int i = 2;; i = 1)
        {
          w.b((String)localObject, str, i, paramAnonymousView.networkType, 1);
          if (h.aZW().bFQ() != 0) {
            break;
          }
          k.a(ad.a(ad.this).aezO.getContext(), ad.a(ad.this).aezO.getContext().getString(R.l.gQV), "", ad.a(ad.this).aezO.getContext().getString(R.l.app_i_known), new DialogInterface.OnClickListener()
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
        if (e.e.boQ(paramAnonymousView.typeName))
        {
          if (Util.isNullOrNil(paramAnonymousView.OGQ))
          {
            Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan qBar result invalid");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
            return;
          }
          ad.b(ad.this).a(ad.a(ad.this).aezO.getContext(), paramAnonymousView.OGQ, paramAnonymousView.source, paramAnonymousView.typeName, paramAnonymousView.hDb, paramAnonymousView.hDc, paramAnonymousView.hDf, 3, true, paramAnonymousView.networkType, false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37037);
          return;
          localObject = paramAnonymousView.OGQ;
          if (Util.isNullOrNil((String)localObject))
          {
            Log.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan zBar result invalid");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgOfflineScan$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37037);
            return;
          }
          ad.c(ad.this).a(ad.a(ad.this).aezO.getContext(), null, null, (String)localObject, paramAnonymousView.ORR, paramAnonymousView.hDc, paramAnonymousView.typeName, paramAnonymousView.hDf, 3, true, paramAnonymousView.networkType, false, false, 0, null);
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
      localObject = new ap(paramLayoutInflater, R.i.ggr);
      ((View)localObject).setTag(new a().lF((View)localObject));
    }
    AppMethodBeat.o(37040);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37041);
    this.aeiK = parama1;
    parama = (a)parama;
    paramString = paramcc.field_content;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37041);
      return;
    }
    Object localObject = OfflineScanContext.CREATOR;
    localObject = OfflineScanContext.a.aUF(paramString);
    Log.d("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo filling OfflineScan context %s", new Object[] { ((OfflineScanContext)localObject).toString() });
    paramString = parama.aeRu;
    long l = ((OfflineScanContext)localObject).timestamp;
    localObject = new Time();
    ((Time)localObject).set(l);
    localObject = e.a("yyyy-MM-dd kk:mm", (Time)localObject).toString();
    paramString.setText(String.format(MMApplicationContext.getContext().getString(R.l.fSH), new Object[] { localObject }));
    paramcc = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
    parama.clickArea.setTag(paramcc);
    parama.clickArea.setOnLongClickListener(c(parama1));
    parama.clickArea.setOnClickListener(this.yAH);
    parama.aeRv.setTag(paramcc);
    parama.aeRv.setOnClickListener(this.yAH);
    AppMethodBeat.o(37041);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255187);
    paramContextMenuInfo = (bz)paramView.getTag();
    if (paramContextMenuInfo == null)
    {
      AppMethodBeat.o(255187);
      return false;
    }
    params.a(paramContextMenuInfo.position, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(255187);
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 721420337);
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  protected final boolean jxh()
  {
    return false;
  }
  
  final boolean jxi()
  {
    return false;
  }
  
  protected final boolean jxk()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    TextView aeRu;
    RelativeLayout aeRv;
    
    a() {}
    
    final a lF(View paramView)
    {
      AppMethodBeat.i(37038);
      super.create(paramView);
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
      this.clickArea = paramView.findViewById(R.h.chatting_click_area);
      this.aeRu = ((TextView)paramView.findViewById(R.h.fSH));
      this.aeRv = ((RelativeLayout)paramView.findViewById(R.h.fSG));
      AppMethodBeat.o(37038);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad
 * JD-Core Version:    0.7.0.1
 */
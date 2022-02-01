package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.format.Time;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.plugin.scanner.model.l;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class v
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  private com.tencent.mm.plugin.scanner.util.a Imc;
  private View.OnClickListener pGY;
  private com.tencent.mm.plugin.scanner.util.c xbd;
  
  v()
  {
    AppMethodBeat.i(37039);
    this.xbd = new com.tencent.mm.plugin.scanner.util.c();
    this.Imc = new com.tencent.mm.plugin.scanner.util.a();
    this.pGY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37037);
        paramAnonymousView = (bj)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          ac.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan tag not valid");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.dpq;
        if (paramAnonymousView == null)
        {
          ac.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan msg not valid");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.field_content;
        if (bs.isNullOrNil(paramAnonymousView))
        {
          ac.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan content not valid");
          AppMethodBeat.o(37037);
          return;
        }
        Object localObject = OfflineScanContext.CREATOR;
        paramAnonymousView = OfflineScanContext.a.arE(paramAnonymousView);
        ac.i("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan onClick codeType: %d, selectFromAlbum: %b", new Object[] { Integer.valueOf(paramAnonymousView.dbX), Boolean.valueOf(paramAnonymousView.wZd) });
        localObject = l.wZe;
        localObject = paramAnonymousView.typeName;
        if (paramAnonymousView.wZd) {}
        for (int i = 2;; i = 1)
        {
          l.n((String)localObject, i, paramAnonymousView.networkType, 1);
          if (com.tencent.mm.kernel.g.agi().aBK() != 0) {
            break;
          }
          h.a(v.a(v.this).HZF.getContext(), v.a(v.this).HZF.getContext().getString(2131761792), "", v.a(v.this).HZF.getContext().getString(2131755793), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(37036);
              paramAnonymous2DialogInterface.dismiss();
              AppMethodBeat.o(37036);
            }
          });
          AppMethodBeat.o(37037);
          return;
        }
        if (d.d.aFH(paramAnonymousView.typeName))
        {
          if (bs.isNullOrNil(paramAnonymousView.wZc))
          {
            ac.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan qBar result invalid");
            AppMethodBeat.o(37037);
            return;
          }
          v.b(v.this).a(v.a(v.this).HZF.getContext(), paramAnonymousView.wZc, paramAnonymousView.dbL, paramAnonymousView.typeName, paramAnonymousView.dbX, paramAnonymousView.dbY, null, null, paramAnonymousView.dcb, 3, true, paramAnonymousView.networkType, false);
          AppMethodBeat.o(37037);
          return;
        }
        localObject = paramAnonymousView.wZc;
        if (bs.isNullOrNil((String)localObject))
        {
          ac.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan zBar result invalid");
          AppMethodBeat.o(37037);
          return;
        }
        v.c(v.this).a(v.a(v.this).HZF.getContext(), null, null, (String)localObject, paramAnonymousView.wZd, paramAnonymousView.dbY, paramAnonymousView.typeName, paramAnonymousView.dcb, 3, true, paramAnonymousView.networkType, false);
        AppMethodBeat.o(37037);
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
      localObject = new ag(paramLayoutInflater, 2131493470);
      ((View)localObject).setTag(new a().gl((View)localObject));
    }
    AppMethodBeat.o(37040);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37041);
    this.HNS = parama1;
    parama = (a)parama;
    paramString = parambo.field_content;
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37041);
      return;
    }
    Object localObject = OfflineScanContext.CREATOR;
    localObject = OfflineScanContext.a.arE(paramString);
    ac.d("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo filling OfflineScan context %s", new Object[] { ((OfflineScanContext)localObject).toString() });
    paramString = parama.Imf;
    long l = ((OfflineScanContext)localObject).timestamp;
    localObject = new Time();
    ((Time)localObject).set(l);
    localObject = com.tencent.mm.pluginsdk.g.g.a("yyyy-MM-dd kk:mm", (Time)localObject).toString();
    paramString.setText(String.format(ai.getContext().getString(2131761794), new Object[] { localObject }));
    parambo = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
    parama.nDl.setTag(parambo);
    parama.nDl.setOnLongClickListener(c(parama1));
    parama.nDl.setOnClickListener(this.pGY);
    parama.Img.setTag(parambo);
    parama.Img.setOnClickListener(this.pGY);
    AppMethodBeat.o(37041);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37042);
    parambo = (bj)paramView.getTag();
    if (parambo == null)
    {
      AppMethodBeat.o(37042);
      return false;
    }
    paramContextMenu.add(parambo.position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(37042);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 721420337);
  }
  
  protected final boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  final boolean fqv()
  {
    return false;
  }
  
  protected final boolean fqx()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    TextView Imf;
    RelativeLayout Img;
    
    a() {}
    
    final a gl(View paramView)
    {
      AppMethodBeat.i(37038);
      super.fX(paramView);
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.nDl = paramView.findViewById(2131298069);
      this.Imf = ((TextView)paramView.findViewById(2131302994));
      this.Img = ((RelativeLayout)paramView.findViewById(2131302993));
      AppMethodBeat.o(37038);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v
 * JD-Core Version:    0.7.0.1
 */
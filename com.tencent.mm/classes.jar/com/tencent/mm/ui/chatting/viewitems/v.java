package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.plugin.scanner.model.l;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class v
  extends c
{
  private com.tencent.mm.plugin.scanner.util.a GMf;
  private com.tencent.mm.ui.chatting.d.a Gob;
  private View.OnClickListener pdN;
  private com.tencent.mm.plugin.scanner.util.c vQw;
  
  v()
  {
    AppMethodBeat.i(37039);
    this.vQw = new com.tencent.mm.plugin.scanner.util.c();
    this.GMf = new com.tencent.mm.plugin.scanner.util.a();
    this.pdN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37037);
        paramAnonymousView = (bi)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          ad.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan tag not valid");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.drF;
        if (paramAnonymousView == null)
        {
          ad.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan msg not valid");
          AppMethodBeat.o(37037);
          return;
        }
        paramAnonymousView = paramAnonymousView.field_content;
        if (bt.isNullOrNil(paramAnonymousView))
        {
          ad.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan content not valid");
          AppMethodBeat.o(37037);
          return;
        }
        Object localObject = OfflineScanContext.CREATOR;
        paramAnonymousView = OfflineScanContext.a.amx(paramAnonymousView);
        ad.i("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan onClick codeType: %d, selectFromAlbum: %b", new Object[] { Integer.valueOf(paramAnonymousView.deB), Boolean.valueOf(paramAnonymousView.vOH) });
        localObject = l.vOI;
        localObject = paramAnonymousView.typeName;
        if (paramAnonymousView.vOH) {}
        for (int i = 2;; i = 1)
        {
          l.n((String)localObject, i, paramAnonymousView.networkType, 1);
          if (com.tencent.mm.kernel.g.aeS().auR() != 0) {
            break;
          }
          h.a(v.a(v.this).GzJ.getContext(), v.a(v.this).GzJ.getContext().getString(2131761792), "", v.a(v.this).GzJ.getContext().getString(2131755793), new v.1.1(this));
          AppMethodBeat.o(37037);
          return;
        }
        if (d.d.aAp(paramAnonymousView.typeName))
        {
          if (bt.isNullOrNil(paramAnonymousView.vOG))
          {
            ad.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan qBar result invalid");
            AppMethodBeat.o(37037);
            return;
          }
          v.b(v.this).a(v.a(v.this).GzJ.getContext(), paramAnonymousView.vOG, paramAnonymousView.dep, paramAnonymousView.typeName, paramAnonymousView.deB, paramAnonymousView.deC, null, null, paramAnonymousView.deG, 3, true, paramAnonymousView.networkType, false);
          AppMethodBeat.o(37037);
          return;
        }
        localObject = paramAnonymousView.vOG;
        if (bt.isNullOrNil((String)localObject))
        {
          ad.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan zBar result invalid");
          AppMethodBeat.o(37037);
          return;
        }
        v.c(v.this).a(v.a(v.this).GzJ.getContext(), null, null, (String)localObject, paramAnonymousView.vOH, paramAnonymousView.deC, paramAnonymousView.typeName, paramAnonymousView.deG, 3, true, paramAnonymousView.networkType, false);
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
      localObject = new af(paramLayoutInflater, 2131493470);
      ((View)localObject).setTag(new a().fY((View)localObject));
    }
    AppMethodBeat.o(37040);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37041);
    this.Gob = parama1;
    parama = (a)parama;
    paramString = parambl.field_content;
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37041);
      return;
    }
    Object localObject = OfflineScanContext.CREATOR;
    localObject = OfflineScanContext.a.amx(paramString);
    ad.d("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo filling OfflineScan context %s", new Object[] { ((OfflineScanContext)localObject).toString() });
    paramString = parama.GMi;
    long l = ((OfflineScanContext)localObject).timestamp;
    localObject = new Time();
    ((Time)localObject).set(l);
    localObject = com.tencent.mm.pluginsdk.g.g.a("yyyy-MM-dd kk:mm", (Time)localObject).toString();
    paramString.setText(String.format(aj.getContext().getString(2131761794), new Object[] { localObject }));
    parambl = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
    parama.naN.setTag(parambl);
    parama.naN.setOnLongClickListener(c(parama1));
    parama.naN.setOnClickListener(this.pdN);
    parama.GMj.setTag(parambl);
    parama.GMj.setOnClickListener(this.pdN);
    AppMethodBeat.o(37041);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37042);
    parambl = (bi)paramView.getTag();
    if (parambl == null)
    {
      AppMethodBeat.o(37042);
      return false;
    }
    paramContextMenu.add(parambl.position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(37042);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 721420337);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  protected final boolean faD()
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
  
  final boolean faF()
  {
    return false;
  }
  
  protected final boolean faH()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    TextView GMi;
    RelativeLayout GMj;
    
    a() {}
    
    final a fY(View paramView)
    {
      AppMethodBeat.i(37038);
      super.fK(paramView);
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.naN = paramView.findViewById(2131298069);
      this.GMi = ((TextView)paramView.findViewById(2131302994));
      this.GMj = ((RelativeLayout)paramView.findViewById(2131302993));
      AppMethodBeat.o(37038);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v
 * JD-Core Version:    0.7.0.1
 */
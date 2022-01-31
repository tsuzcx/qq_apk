package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.text.format.Time;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.plugin.scanner.util.f;
import com.tencent.mm.plugin.scanner.util.i;
import com.tencent.mm.pluginsdk.f.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;

public final class o
  extends c
{
  private View.OnClickListener lNc;
  private f zUh;
  private i zUi;
  private a zzP;
  
  o()
  {
    AppMethodBeat.i(153945);
    this.zUh = new f();
    this.zUi = new i();
    this.lNc = new o.1(this);
    AppMethodBeat.o(153945);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(153946);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969097);
      ((View)localObject).setTag(new o.a(this).ff((View)localObject));
    }
    AppMethodBeat.o(153946);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(153947);
    this.zzP = parama1;
    parama = (o.a)parama;
    paramString = parambi.field_content;
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(153947);
      return;
    }
    Object localObject = OfflineScanContext.CREATOR;
    localObject = OfflineScanContext.a.Yx(paramString);
    ab.d("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo filling OfflineScan context %s", new Object[] { ((OfflineScanContext)localObject).toString() });
    paramString = parama.zUl;
    long l = ((OfflineScanContext)localObject).timestamp;
    localObject = new Time();
    ((Time)localObject).set(l);
    localObject = g.a("yyyy-MM-dd kk:mm", (Time)localObject).toString();
    paramString.setText(String.format(ah.getContext().getString(2131302010), new Object[] { localObject }));
    parambi = new az(parambi, parama1.dJG(), paramInt, null, '\000');
    parama.jYu.setTag(parambi);
    parama.jYu.setOnLongClickListener(c(parama1));
    parama.jYu.setOnClickListener(this.lNc);
    parama.zUm.setTag(parambi);
    parama.zUm.setOnClickListener(this.lNc);
    AppMethodBeat.o(153947);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(153948);
    parambi = (az)paramView.getTag();
    if (parambi == null)
    {
      AppMethodBeat.o(153948);
      return false;
    }
    paramContextMenu.add(parambi.position, 100, 0, paramView.getContext().getString(2131298232));
    AppMethodBeat.o(153948);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 721420337);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  protected final boolean dLo()
  {
    return false;
  }
  
  final boolean dLp()
  {
    return false;
  }
  
  final boolean dLq()
  {
    return false;
  }
  
  protected final boolean dLs()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o
 * JD-Core Version:    0.7.0.1
 */
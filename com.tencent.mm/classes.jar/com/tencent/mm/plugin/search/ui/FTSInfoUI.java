package com.tencent.mm.plugin.search.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class FTSInfoUI
  extends MMActivity
  implements l
{
  private p mcf;
  private TextView sEo;
  private Button xnv;
  private Button xnw;
  private Button xnx;
  private Button xny;
  private View.OnClickListener xnz;
  
  public FTSInfoUI()
  {
    AppMethodBeat.i(28076);
    this.xnz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28075);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (i == 1)
        {
          paramAnonymousView = (com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class);
          FTSInfoUI.doF();
          paramAnonymousView = paramAnonymousView.bWY();
        }
        StringBuffer localStringBuffer;
        for (;;)
        {
          localStringBuffer = new StringBuffer();
          paramAnonymousView = paramAnonymousView.iterator();
          while (paramAnonymousView.hasNext())
          {
            Pair localPair = (Pair)paramAnonymousView.next();
            localStringBuffer.append("[");
            localStringBuffer.append(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk((String)localPair.first));
            localStringBuffer.append("]\n");
            localStringBuffer.append((String)localPair.second);
            localStringBuffer.append("\n");
          }
          if (i == 2)
          {
            paramAnonymousView = ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).rO(FTSInfoUI.doF());
          }
          else
          {
            if (i != 3) {
              break;
            }
            paramAnonymousView = ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).rN(FTSInfoUI.doF());
          }
        }
        AppMethodBeat.o(28075);
        return;
        FTSInfoUI.b(FTSInfoUI.this).setText(localStringBuffer.toString());
        AppMethodBeat.o(28075);
      }
    };
    AppMethodBeat.o(28076);
  }
  
  public static long doF()
  {
    AppMethodBeat.i(28078);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(28078);
    return l;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(28079);
    if (this.mcf != null) {
      this.mcf.dismiss();
    }
    paramk = new StringBuffer();
    paramk.append("[DBSize]=" + bs.An(e.swU.swX * 1048576L));
    paramk.append("\n");
    paramk.append("[WXContact]=" + e.swU.swY);
    paramk.append("\n");
    paramk.append("[WXChatroom]=" + e.swU.swZ);
    paramk.append("\n");
    paramk.append("[Favorite]=" + e.swU.sxb);
    paramk.append("\n");
    paramk.append("[Message]=" + e.swU.sxa);
    paramk.append("\n");
    paramk.append("[WebSearchH5Version]=" + z.Ul(0));
    paramk.append("\n");
    paramk.append("[TopStoryH5Version]=" + z.Ul(1));
    paramk.append("\n");
    paramk.append("[WxAppH5Version]=" + z.Ul(3));
    paramk.append("\n");
    paramk.append("[BoxH5Version]=" + z.Ul(2));
    paramk.append("\n");
    paramk.append("[TopStoryWebViewCore]=" + ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType());
    paramk.append("\n");
    paramk.append("[PardusH5Version]=" + z.Ul(5));
    paramk.append("\n");
    this.sEo.setText(paramk.toString());
    AppMethodBeat.o(28079);
  }
  
  public int getLayoutId()
  {
    return 2131494205;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28077);
    super.onCreate(paramBundle);
    setMMTitle(2131759707);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28072);
        FTSInfoUI.this.finish();
        AppMethodBeat.o(28072);
        return false;
      }
    });
    this.xnv = ((Button)findViewById(2131300999));
    this.sEo = ((TextView)findViewById(2131301013));
    this.xnv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28074);
        if (FTSInfoUI.a(FTSInfoUI.this) == null) {
          FTSInfoUI.a(FTSInfoUI.this, h.b(FTSInfoUI.this, FTSInfoUI.this.getString(2131760709), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(28073);
              FTSInfoUI.this.finish();
              AppMethodBeat.o(28073);
            }
          }));
        }
        FTSInfoUI.a(FTSInfoUI.this).show();
        paramAnonymousView = new j();
        paramAnonymousView.jwR = 65526;
        paramAnonymousView.syI = FTSInfoUI.this;
        ((n)g.ad(n.class)).search(10000, paramAnonymousView);
        AppMethodBeat.o(28074);
      }
    });
    this.xnw = ((Button)findViewById(2131303407));
    this.xnx = ((Button)findViewById(2131303409));
    this.xny = ((Button)findViewById(2131303408));
    this.xnw.setTag(Integer.valueOf(1));
    this.xnx.setTag(Integer.valueOf(2));
    this.xny.setTag(Integer.valueOf(3));
    this.xnw.setOnClickListener(this.xnz);
    this.xnx.setOnClickListener(this.xnz);
    this.xny.setOnClickListener(this.xnz);
    AppMethodBeat.o(28077);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.FTSInfoUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class RecordMsgImageUI
  extends MMActivity
  implements com.tencent.mm.plugin.record.a.d
{
  private long cpO;
  private List<aca> eiJ;
  private MMGestureGallery kuC;
  private n.d loG;
  private Runnable mvH;
  private com.tencent.mm.ui.widget.b.d mwq;
  private Map<String, RecordMsgImageUI.b> mwr;
  private com.tencent.mm.sdk.b.c mwt;
  private com.tencent.mm.plugin.record.b.l pZM;
  private RecordMsgImageUI.a pZT;
  private String pZU;
  private int selection;
  
  public RecordMsgImageUI()
  {
    AppMethodBeat.i(24312);
    this.eiJ = new LinkedList();
    this.selection = 0;
    this.cpO = -1L;
    this.pZU = null;
    this.mwr = new HashMap();
    this.loG = new RecordMsgImageUI.12(this);
    this.mvH = new RecordMsgImageUI.3(this);
    this.mwt = new RecordMsgImageUI.4(this);
    AppMethodBeat.o(24312);
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(24318);
    Iterator localIterator = this.eiJ.iterator();
    while (localIterator.hasNext()) {
      if (((aca)localIterator.next()).mBq.equals(parami.field_dataId))
      {
        al.d(this.mvH);
        AppMethodBeat.o(24318);
        return;
      }
    }
    AppMethodBeat.o(24318);
  }
  
  final String cge()
  {
    AppMethodBeat.i(24315);
    int i = this.kuC.getSelectedItemPosition();
    if (-1 == i)
    {
      ab.w("MicroMsg.ShowImageUI", "error position");
      AppMethodBeat.o(24315);
      return null;
    }
    String str = n.c(this.pZT.Cn(i), this.cpO);
    ab.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[] { Integer.valueOf(i), str });
    AppMethodBeat.o(24315);
    return str;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(24316);
    af.h(af.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(24316);
  }
  
  public int getLayoutId()
  {
    return 2130970736;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24317);
    if ((1001 == paramInt1) && (-1 == paramInt2))
    {
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label58;
        }
      }
      label58:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        if (!bo.isNullOrNil((String)localObject)) {
          break label69;
        }
        AppMethodBeat.o(24317);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label69:
      Object localObject = bo.P(((String)localObject).split(","));
      if (bo.es((List)localObject))
      {
        ab.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(24317);
        return;
      }
      RecordMsgImageUI.13 local13 = new RecordMsgImageUI.13(this, h.b(getContext(), getString(2131299734), false, null));
      aw.RO().ac(new RecordMsgImageUI.2(this, (List)localObject, paramIntent, local13));
      AppMethodBeat.o(24317);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(24317);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24313);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    this.pZM = new com.tencent.mm.plugin.record.b.l();
    this.cpO = getIntent().getLongExtra("message_id", -1L);
    paramBundle = getIntent().getStringExtra("record_data_id");
    Object localObject = n.XS(getIntent().getStringExtra("record_xml"));
    if (localObject == null)
    {
      ab.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(24313);
      return;
    }
    localObject = ((com.tencent.mm.protocal.b.a.c)localObject).fjy.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aca localaca = (aca)((Iterator)localObject).next();
      if (localaca.dataType == 2)
      {
        this.eiJ.add(localaca);
        if (localaca.mBq.equals(paramBundle)) {
          this.selection = (this.eiJ.size() - 1);
        }
      }
    }
    if (this.eiJ.isEmpty())
    {
      ab.w("MicroMsg.ShowImageUI", "get image data error, empty");
      finish();
      AppMethodBeat.o(24313);
      return;
    }
    this.kuC = ((MMGestureGallery)findViewById(2131822137));
    this.kuC.setVerticalFadingEdgeEnabled(false);
    this.kuC.setHorizontalFadingEdgeEnabled(false);
    this.pZT = new RecordMsgImageUI.a((byte)0);
    this.pZT.eiJ = this.eiJ;
    this.pZT.cpO = this.cpO;
    this.pZT.pZM = this.pZM;
    this.kuC.setAdapter(this.pZT);
    this.kuC.setSelection(this.selection);
    this.kuC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(24294);
        if (n.d(RecordMsgImageUI.a(RecordMsgImageUI.this).Cn(paramAnonymousInt), RecordMsgImageUI.b(RecordMsgImageUI.this)))
        {
          RecordMsgImageUI.this.setMMTitle(String.format("%d/%d", new Object[] { Integer.valueOf(paramAnonymousInt + 1), Integer.valueOf(RecordMsgImageUI.c(RecordMsgImageUI.this).size()) }));
          RecordMsgImageUI.this.enableOptionMenu(true);
          AppMethodBeat.o(24294);
          return;
        }
        RecordMsgImageUI.this.enableOptionMenu(false);
        AppMethodBeat.o(24294);
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    this.kuC.setSingleClickOverListener(new RecordMsgImageUI.6(this));
    this.kuC.setLongClickOverListener(new RecordMsgImageUI.7(this));
    fullScreenNoTitleBar(true);
    setBackBtn(new RecordMsgImageUI.8(this));
    ((com.tencent.mm.plugin.record.a.a)g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.mwt);
    AppMethodBeat.o(24313);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24314);
    ((com.tencent.mm.plugin.record.a.a)g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    this.pZM.destory();
    com.tencent.mm.sdk.b.a.ymk.d(this.mwt);
    super.onDestroy();
    AppMethodBeat.o(24314);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI
 * JD-Core Version:    0.7.0.1
 */
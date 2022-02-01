package com.tencent.mm.plugin.mmsight.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SightSettingsUI
  extends MMActivity
{
  private d fPa;
  private LinkedList<b> gFp;
  private ListView gFr;
  private CaptureMMProxy uJP;
  private a uUc;
  
  public SightSettingsUI()
  {
    AppMethodBeat.i(94737);
    this.fPa = new d(this);
    this.gFp = new LinkedList();
    AppMethodBeat.o(94737);
  }
  
  public int getLayoutId()
  {
    return 2131495461;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94738);
    super.onCreate(paramBundle);
    this.uJP = new CaptureMMProxy(this.fPa);
    this.fPa.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94730);
        ac.i("MicroMsg.SightSettingsUI", "has connect");
        SightSettingsUI.a(SightSettingsUI.this);
        AppMethodBeat.o(94730);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(94731);
        SightSettingsUI.this.finish();
        AppMethodBeat.o(94731);
        return false;
      }
    });
    AppMethodBeat.o(94738);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94739);
    super.onDestroy();
    this.fPa.release();
    AppMethodBeat.o(94739);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94741);
    super.onPause();
    AppMethodBeat.o(94741);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(94740);
    super.onResume();
    AppMethodBeat.o(94740);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(94733);
      int i = SightSettingsUI.d(SightSettingsUI.this).size();
      AppMethodBeat.o(94733);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(94734);
      Object localObject = SightSettingsUI.d(SightSettingsUI.this).get(paramInt);
      AppMethodBeat.o(94734);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(94735);
      paramView = new TextView(SightSettingsUI.this);
      paramViewGroup = (SightSettingsUI.b)getItem(paramInt);
      paramView.setText(paramViewGroup.gFw + "->:" + paramViewGroup.IZ(((Integer)SightSettingsUI.b(paramViewGroup.uUd).get(paramViewGroup.gFx, Integer.valueOf(0))).intValue()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(94732);
          paramAnonymousView = paramViewGroup;
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          int i = 0;
          while (i < paramAnonymousView.gFy.length)
          {
            localLinkedList1.add(paramAnonymousView.gFy[i]);
            localLinkedList2.add(Integer.valueOf(i));
            i += 1;
          }
          h.a(paramAnonymousView.uUd, "", localLinkedList1, localLinkedList2, "", new SightSettingsUI.b.1(paramAnonymousView));
          AppMethodBeat.o(94732);
        }
      });
      AppMethodBeat.o(94735);
      return paramView;
    }
  }
  
  final class b
  {
    public String gFw;
    ah.a gFx;
    String[] gFy;
    int[] uUg;
    
    public b(String paramString, ah.a parama, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      this.gFw = paramString;
      this.gFy = paramArrayOfString;
      this.gFx = parama;
      this.uUg = paramArrayOfInt;
    }
    
    final String IZ(int paramInt)
    {
      int i = 0;
      while (i < this.uUg.length)
      {
        if ((paramInt == this.uUg[i]) && (i < this.gFy.length)) {
          return this.gFy[i];
        }
        i += 1;
      }
      return this.gFy[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI
 * JD-Core Version:    0.7.0.1
 */
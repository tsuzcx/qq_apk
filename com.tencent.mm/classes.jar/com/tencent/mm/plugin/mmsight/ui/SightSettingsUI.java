package com.tencent.mm.plugin.mmsight.ui;

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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.w.a.f;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SightSettingsUI
  extends MMActivity
{
  private CaptureMMProxy KUn;
  private a Lem;
  private LinkedList<b> nlG;
  private ListView nlI;
  private d pfZ;
  
  public SightSettingsUI()
  {
    AppMethodBeat.i(94737);
    this.pfZ = new d(this);
    this.nlG = new LinkedList();
    AppMethodBeat.o(94737);
  }
  
  public int getLayoutId()
  {
    return a.f.sight_settings_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94738);
    super.onCreate(paramBundle);
    this.KUn = new CaptureMMProxy(this.pfZ);
    this.pfZ.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94730);
        Log.i("MicroMsg.SightSettingsUI", "has connect");
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
    this.pfZ.release();
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
      paramView.setText(paramViewGroup.nlK + "->:" + paramViewGroup.abm(((Integer)SightSettingsUI.b(paramViewGroup.Len).get(paramViewGroup.nlL, Integer.valueOf(0))).intValue()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(94732);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/ui/SightSettingsUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          paramAnonymousView = paramViewGroup;
          localObject = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          int i = 0;
          while (i < paramAnonymousView.nlM.length)
          {
            ((List)localObject).add(paramAnonymousView.nlM[i]);
            localLinkedList.add(Integer.valueOf(i));
            i += 1;
          }
          k.a(paramAnonymousView.Len, "", (List)localObject, localLinkedList, "", new SightSettingsUI.b.1(paramAnonymousView));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightSettingsUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(94732);
        }
      });
      AppMethodBeat.o(94735);
      return paramView;
    }
  }
  
  final class b
  {
    int[] Leq;
    public String nlK;
    at.a nlL;
    String[] nlM;
    
    public b(String paramString, at.a parama, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      this.nlK = paramString;
      this.nlM = paramArrayOfString;
      this.nlL = parama;
      this.Leq = paramArrayOfInt;
    }
    
    final String abm(int paramInt)
    {
      int i = 0;
      while (i < this.Leq.length)
      {
        if ((paramInt == this.Leq[i]) && (i < this.nlM.length)) {
          return this.nlM[i];
        }
        i += 1;
      }
      return this.nlM[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI
 * JD-Core Version:    0.7.0.1
 */
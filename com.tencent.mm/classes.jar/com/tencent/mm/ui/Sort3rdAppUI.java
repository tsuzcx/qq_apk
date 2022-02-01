package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI
  extends MMActivity
{
  private long DZL;
  private a FSo;
  private List<g> FSp;
  private DragSortListView oCA;
  
  protected int getLayoutId()
  {
    return 2131495627;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(33757);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(33749);
        Sort3rdAppUI.this.finish();
        AppMethodBeat.o(33749);
        return true;
      }
    });
    setMMTitle(getString(2131755131));
    this.oCA = ((DragSortListView)findViewById(2131301457));
    this.oCA.setDropListener(new DragSortListView.h()
    {
      public final void eg(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(33750);
        g localg = (g)Sort3rdAppUI.a(Sort3rdAppUI.this).getItem(paramAnonymousInt1);
        Sort3rdAppUI.a(Sort3rdAppUI.this).remove(localg);
        Sort3rdAppUI.a(Sort3rdAppUI.this).insert(localg, paramAnonymousInt2);
        AppMethodBeat.o(33750);
      }
    });
    AppMethodBeat.o(33757);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(33756);
    super.onCreate(paramBundle);
    this.DZL = getIntent().getLongExtra("KFlag", -1L);
    initView();
    this.FSp = com.tencent.mm.pluginsdk.model.app.h.b(this, this.DZL, true);
    paramBundle = ap.evS().vl(this.DZL);
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      Collections.sort(this.FSp, new Comparator() {});
    }
    this.FSo = new a(this, this.FSp, this.DZL);
    this.oCA.setAdapter(this.FSo);
    AppMethodBeat.o(33756);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33758);
    super.onDestroy();
    AppMethodBeat.o(33758);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33759);
    super.onPause();
    if (this.FSo != null)
    {
      List localList = this.FSo.otO;
      p localp = ap.evS();
      long l = this.DZL;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete from AppSort");
      ((StringBuilder)localObject).append(" where flag = ").append(l).append(" ");
      localObject = ((StringBuilder)localObject).toString();
      localp.db.execSQL("AppSort", (String)localObject);
      if ((localList != null) && (localList.size() > 0))
      {
        az.arV();
        l = com.tencent.mm.model.c.afg().rb(Thread.currentThread().getId());
        localp = ap.evS();
        int i = 0;
        while (i < localList.size())
        {
          localObject = new com.tencent.mm.pluginsdk.model.app.o();
          ((com.tencent.mm.pluginsdk.model.app.o)localObject).field_flag = this.DZL;
          ((com.tencent.mm.pluginsdk.model.app.o)localObject).field_appId = ((g)localList.get(i)).field_appId;
          ((com.tencent.mm.pluginsdk.model.app.o)localObject).field_sortId = i;
          localp.a((com.tencent.mm.pluginsdk.model.app.o)localObject);
          i += 1;
        }
        az.arV();
        com.tencent.mm.model.c.afg().mX(l);
      }
    }
    AppMethodBeat.o(33759);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends ArrayAdapter<g>
  {
    private long DZL;
    private Context mContext;
    List<g> otO;
    private com.tencent.mm.aw.a.a.c paS;
    
    public a(Context paramContext, List<g> paramList, long paramLong)
    {
      super(2131495628, paramList);
      AppMethodBeat.i(33754);
      this.DZL = paramLong;
      this.mContext = paramContext;
      this.otO = paramList;
      paramContext = new c.a();
      paramContext.hkf = 2131233401;
      this.paS = paramContext.azc();
      AppMethodBeat.o(33754);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      boolean bool = true;
      AppMethodBeat.i(33755);
      final g localg;
      Object localObject;
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, 2131495628, null);
        paramViewGroup = new a(paramView);
        paramView.setTag(paramViewGroup);
        localg = (g)getItem(paramInt);
        paramViewGroup.ica.setText(localg.field_appName);
        localObject = com.tencent.mm.pluginsdk.model.app.h.c(localg.field_appId, 1, com.tencent.mm.cd.a.getDensity(this.mContext));
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label164;
        }
        paramViewGroup.kXS.setImageBitmap((Bitmap)localObject);
        label99:
        localObject = paramViewGroup.sLH;
        if ((localg.field_appInfoFlag & 0x4000) != 0) {
          break label186;
        }
      }
      for (;;)
      {
        ((MMSwitchBtn)localObject).setCheck(bool);
        paramViewGroup.sLH.setSwitchListener(new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(33752);
            g localg;
            if (paramAnonymousBoolean) {
              localg = localg;
            }
            for (localg.field_appInfoFlag &= 0xFFFFBFFF;; localg.field_appInfoFlag |= 0x4000)
            {
              ap.cZQ().a(localg, new String[0]);
              AppMethodBeat.o(33752);
              return;
              localg = localg;
            }
          }
        });
        paramView.setVisibility(0);
        AppMethodBeat.o(33755);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label164:
        com.tencent.mm.aw.o.ayJ().a(localg.field_appIconUrl, paramViewGroup.kXS, this.paS);
        break label99;
        label186:
        bool = false;
      }
    }
    
    static final class a
    {
      TextView ica;
      ImageView kXS;
      View otP;
      ImageView otQ;
      MMSwitchBtn sLH;
      
      public a(View paramView)
      {
        AppMethodBeat.i(33753);
        this.otQ = ((ImageView)paramView.findViewById(2131300760));
        this.kXS = ((ImageView)paramView.findViewById(2131300880));
        this.ica = ((TextView)paramView.findViewById(2131305905));
        this.sLH = ((MMSwitchBtn)paramView.findViewById(2131305590));
        this.otP = paramView.findViewById(2131298736);
        AppMethodBeat.o(33753);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI
 * JD-Core Version:    0.7.0.1
 */
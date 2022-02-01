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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
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
  private long Btv;
  private a OLf;
  private List<g> OLg;
  private DragSortListView rhg;
  
  protected int getLayoutId()
  {
    return 2131496529;
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
    setMMTitle(getString(2131755149));
    this.rhg = ((DragSortListView)findViewById(2131303242));
    this.rhg.setDropListener(new DragSortListView.h()
    {
      public final void ey(int paramAnonymousInt1, int paramAnonymousInt2)
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
    this.Btv = getIntent().getLongExtra("KFlag", -1L);
    initView();
    this.OLg = com.tencent.mm.pluginsdk.model.app.h.b(this, this.Btv, true);
    paramBundle = ao.gng().Mq(this.Btv);
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      Collections.sort(this.OLg, new Comparator() {});
    }
    this.OLf = new a(this, this.OLg, this.Btv);
    this.rhg.setAdapter(this.OLf);
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
    if (this.OLf != null)
    {
      List localList = this.OLf.qXp;
      p localp = ao.gng();
      long l = this.Btv;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete from AppSort");
      ((StringBuilder)localObject).append(" where flag = ").append(l).append(" ");
      localObject = ((StringBuilder)localObject).toString();
      localp.db.execSQL("AppSort", (String)localObject);
      if ((localList != null) && (localList.size() > 0))
      {
        bg.aVF();
        l = com.tencent.mm.model.c.getDataDB().beginTransaction(Thread.currentThread().getId());
        localp = ao.gng();
        int i = 0;
        while (i < localList.size())
        {
          localObject = new o();
          ((o)localObject).field_flag = this.Btv;
          ((o)localObject).field_appId = ((g)localList.get(i)).field_appId;
          ((o)localObject).field_sortId = i;
          localp.a((o)localObject);
          i += 1;
        }
        bg.aVF();
        com.tencent.mm.model.c.getDataDB().endTransaction(l);
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
    private long Btv;
    private Context mContext;
    List<g> qXp;
    private com.tencent.mm.av.a.a.c rFu;
    
    public a(Context paramContext, List<g> paramList, long paramLong)
    {
      super(2131496530, paramList);
      AppMethodBeat.i(33754);
      this.Btv = paramLong;
      this.mContext = paramContext;
      this.qXp = paramList;
      paramContext = new c.a();
      paramContext.jbq = 2131234199;
      this.rFu = paramContext.bdv();
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
        paramView = View.inflate(this.mContext, 2131496530, null);
        paramViewGroup = new a(paramView);
        paramView.setTag(paramViewGroup);
        localg = (g)getItem(paramInt);
        paramViewGroup.jVO.setText(localg.field_appName);
        localObject = com.tencent.mm.pluginsdk.model.app.h.c(localg.field_appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label164;
        }
        paramViewGroup.nnL.setImageBitmap((Bitmap)localObject);
        label99:
        localObject = paramViewGroup.sLW;
        if ((localg.field_appInfoFlag & 0x4000) != 0) {
          break label186;
        }
      }
      for (;;)
      {
        ((MMSwitchBtn)localObject).setCheck(bool);
        paramViewGroup.sLW.setSwitchListener(new MMSwitchBtn.a()
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
              ao.eAS().a(localg, new String[0]);
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
        q.bcV().a(localg.field_appIconUrl, paramViewGroup.nnL, this.rFu);
        break label99;
        label186:
        bool = false;
      }
    }
    
    static final class a
    {
      TextView jVO;
      ImageView nnL;
      View qXq;
      ImageView qXr;
      MMSwitchBtn sLW;
      
      public a(View paramView)
      {
        AppMethodBeat.i(33753);
        this.qXr = ((ImageView)paramView.findViewById(2131302349));
        this.nnL = ((ImageView)paramView.findViewById(2131302475));
        this.jVO = ((TextView)paramView.findViewById(2131309198));
        this.sLW = ((MMSwitchBtn)paramView.findViewById(2131308812));
        this.qXq = paramView.findViewById(2131299174);
        AppMethodBeat.o(33753);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI
 * JD-Core Version:    0.7.0.1
 */
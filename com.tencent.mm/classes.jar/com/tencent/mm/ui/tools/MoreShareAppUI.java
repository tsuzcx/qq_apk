package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.List;

public class MoreShareAppUI
  extends MMActivity
{
  private List<g> WeF;
  private a XTq;
  private DragSortListView uKp;
  
  public int getLayoutId()
  {
    return R.i.ejj;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39083);
    setMMTitle(R.l.bottom_sheet_more_share);
    this.uKp = ((DragSortListView)findViewById(R.h.listview));
    this.uKp.setDropListener(new DragSortListView.h()
    {
      public final void eX(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39078);
        g localg = (g)MoreShareAppUI.a(MoreShareAppUI.this).getItem(paramAnonymousInt1);
        MoreShareAppUI.a.a(MoreShareAppUI.a(MoreShareAppUI.this)).remove(paramAnonymousInt1);
        MoreShareAppUI.a(MoreShareAppUI.this).notifyDataSetChanged();
        MoreShareAppUI.a(MoreShareAppUI.this).insert(localg, paramAnonymousInt2);
        AppMethodBeat.o(39078);
      }
    });
    AppMethodBeat.o(39083);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39082);
    super.onCreate(paramBundle);
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39079);
        MoreShareAppUI.this.finish();
        AppMethodBeat.o(39079);
        return true;
      }
    });
    addTextOptionMenu(0, getString(R.l.emoji_sequence), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
    });
    this.XTq = new a(this, this.WeF);
    this.uKp.setAdapter(this.XTq);
    AppMethodBeat.o(39082);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends ArrayAdapter<g>
  {
    private Context mContext;
    private List<g> uAd;
    
    public a(Context paramContext, List<g> paramList)
    {
      super(R.i.ejk, paramList);
      this.mContext = paramContext;
      this.uAd = paramList;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39081);
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, R.i.ejk, null);
        paramViewGroup = new a(paramView);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        g localg = (g)getItem(paramInt);
        paramViewGroup.mNb.setText(localg.field_appName);
        paramView.setVisibility(0);
        AppMethodBeat.o(39081);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    static final class a
    {
      TextView mNb;
      ImageView qps;
      View uAe;
      ImageView uAf;
      MMSwitchBtn wrR;
      
      public a(View paramView)
      {
        AppMethodBeat.i(39080);
        this.uAf = ((ImageView)paramView.findViewById(R.h.dIv));
        this.qps = ((ImageView)paramView.findViewById(R.h.dIy));
        this.mNb = ((TextView)paramView.findViewById(R.h.dXx));
        this.wrR = ((MMSwitchBtn)paramView.findViewById(R.h.dVX));
        this.uAe = paramView.findViewById(R.h.container);
        AppMethodBeat.o(39080);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MoreShareAppUI
 * JD-Core Version:    0.7.0.1
 */
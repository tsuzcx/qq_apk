package com.tencent.mm.ui.tools;

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
  private List<g> adKm;
  private a afJF;
  private DragSortListView xSK;
  
  public int getLayoutId()
  {
    return R.i.gmk;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39083);
    setMMTitle(R.l.bottom_sheet_more_share);
    this.xSK = ((DragSortListView)findViewById(R.h.listview));
    this.xSK.setDropListener(new DragSortListView.h()
    {
      public final void drop(int paramAnonymousInt1, int paramAnonymousInt2)
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
    this.afJF = new a(this, this.adKm);
    this.xSK.setAdapter(this.afJF);
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
    private List<g> xGG;
    
    public a(Context paramContext, List<g> paramList)
    {
      super(R.i.gml, paramList);
      this.mContext = paramContext;
      this.xGG = paramList;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39081);
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, R.i.gml, null);
        paramViewGroup = new a(paramView);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        g localg = (g)getItem(paramInt);
        paramViewGroup.pJJ.setText(localg.field_appName);
        paramView.setVisibility(0);
        AppMethodBeat.o(39081);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    static final class a
    {
      TextView pJJ;
      ImageView ttT;
      View xGH;
      ImageView xGI;
      MMSwitchBtn zNX;
      
      public a(View paramView)
      {
        AppMethodBeat.i(39080);
        this.xGI = ((ImageView)paramView.findViewById(R.h.fJN));
        this.ttT = ((ImageView)paramView.findViewById(R.h.iconIV));
        this.pJJ = ((TextView)paramView.findViewById(R.h.gac));
        this.zNX = ((MMSwitchBtn)paramView.findViewById(R.h.fYx));
        this.xGH = paramView.findViewById(R.h.container);
        AppMethodBeat.o(39080);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MoreShareAppUI
 * JD-Core Version:    0.7.0.1
 */
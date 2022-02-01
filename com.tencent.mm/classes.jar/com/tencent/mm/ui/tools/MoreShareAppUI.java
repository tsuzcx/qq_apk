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
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.List;

public class MoreShareAppUI
  extends MMActivity
{
  private List<g> FSp;
  private a Hsv;
  private DragSortListView oCA;
  
  public int getLayoutId()
  {
    return 2131494942;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39083);
    setMMTitle(2131756732);
    this.oCA = ((DragSortListView)findViewById(2131301457));
    this.oCA.setDropListener(new DragSortListView.h()
    {
      public final void eg(int paramAnonymousInt1, int paramAnonymousInt2)
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
    addTextOptionMenu(0, getString(2131758299), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
    });
    this.Hsv = new a(this, this.FSp);
    this.oCA.setAdapter(this.Hsv);
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
    private List<g> otO;
    
    public a(Context paramContext, List<g> paramList)
    {
      super(2131494943, paramList);
      this.mContext = paramContext;
      this.otO = paramList;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39081);
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, 2131494943, null);
        paramViewGroup = new a(paramView);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        g localg = (g)getItem(paramInt);
        paramViewGroup.ica.setText(localg.field_appName);
        paramView.setVisibility(0);
        AppMethodBeat.o(39081);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
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
        AppMethodBeat.i(39080);
        this.otQ = ((ImageView)paramView.findViewById(2131300760));
        this.kXS = ((ImageView)paramView.findViewById(2131300880));
        this.ica = ((TextView)paramView.findViewById(2131305905));
        this.sLH = ((MMSwitchBtn)paramView.findViewById(2131305590));
        this.otP = paramView.findViewById(2131298736);
        AppMethodBeat.o(39080);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MoreShareAppUI
 * JD-Core Version:    0.7.0.1
 */
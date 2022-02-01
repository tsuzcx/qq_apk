package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.ui.base.t;

public class GameMenuView
  extends LinearLayout
{
  private View XhP;
  private LinearLayout XhQ;
  private LinearLayout XhR;
  private f XhS;
  private b.c XhT;
  private b.a XhU;
  private Context mContext;
  private LayoutInflater mInflater;
  private boolean sRw;
  
  public GameMenuView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(80983);
    this.sRw = false;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    paramContext = this.mContext.getResources().getDisplayMetrics();
    if (paramContext.widthPixels > paramContext.heightPixels) {
      bool = true;
    }
    this.sRw = bool;
    initView();
    AppMethodBeat.o(80983);
  }
  
  public GameMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(80985);
    this.sRw = false;
    this.mContext = paramContext;
    initView();
    AppMethodBeat.o(80985);
  }
  
  private void initView()
  {
    AppMethodBeat.i(80986);
    if (this.sRw)
    {
      setOrientation(0);
      this.mInflater.inflate(c.g.game_menu_split_style_landscape, this, true);
    }
    for (View localView = this.mInflater.inflate(c.g.game_menu_layout_landscape, this, true);; localView = this.mInflater.inflate(c.g.game_menu_layout_portrait, this, true))
    {
      this.XhP = localView.findViewById(c.f.game_menu_layout);
      this.XhQ = ((LinearLayout)localView.findViewById(c.f.game_menu_first_line));
      this.XhR = ((LinearLayout)localView.findViewById(c.f.game_menu_second_line));
      AppMethodBeat.o(80986);
      return;
      setOrientation(1);
      this.mInflater.inflate(c.g.game_menu_split_style_portrait, this, true);
    }
  }
  
  public void setAdapter(f paramf)
  {
    AppMethodBeat.i(80984);
    this.XhS = paramf;
    paramf.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(80981);
        GameMenuView.a(GameMenuView.this);
        AppMethodBeat.o(80981);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(80980);
        GameMenuView.a(GameMenuView.this);
        AppMethodBeat.o(80980);
      }
    });
    paramf.notifyDataSetChanged();
    AppMethodBeat.o(80984);
  }
  
  public void setDismissListener(b.a parama)
  {
    this.XhU = parama;
  }
  
  public void setGameMenuItemSelectedListener(b.c paramc)
  {
    this.XhT = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView
 * JD-Core Version:    0.7.0.1
 */
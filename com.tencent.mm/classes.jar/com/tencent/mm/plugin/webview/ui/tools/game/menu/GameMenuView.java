package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class GameMenuView
  extends LinearLayout
{
  private LayoutInflater Lu;
  private Context mContext;
  private boolean rwZ = false;
  private View rxe;
  private LinearLayout rxf;
  private LinearLayout rxg;
  private f rxh;
  private b.c rxi;
  private b.a rxj;
  
  public GameMenuView(Context paramContext)
  {
    super(paramContext, null);
    this.mContext = paramContext;
    this.Lu = LayoutInflater.from(this.mContext);
    paramContext = this.mContext.getResources().getDisplayMetrics();
    if (paramContext.widthPixels > paramContext.heightPixels) {
      bool = true;
    }
    this.rwZ = bool;
    initView();
  }
  
  public GameMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    this.mContext = paramContext;
    initView();
  }
  
  private void initView()
  {
    if (this.rwZ)
    {
      setOrientation(0);
      this.Lu.inflate(R.i.game_menu_split_style_landscape, this, true);
    }
    for (View localView = this.Lu.inflate(R.i.game_menu_layout_landscape, this, true);; localView = this.Lu.inflate(R.i.game_menu_layout_portrait, this, true))
    {
      this.rxe = localView.findViewById(R.h.game_menu_layout);
      this.rxf = ((LinearLayout)localView.findViewById(R.h.game_menu_first_line));
      this.rxg = ((LinearLayout)localView.findViewById(R.h.game_menu_second_line));
      return;
      setOrientation(1);
      this.Lu.inflate(R.i.game_menu_split_style_portrait, this, true);
    }
  }
  
  public void setAdapter(f paramf)
  {
    this.rxh = paramf;
    paramf.registerDataSetObserver(new GameMenuView.1(this));
    paramf.notifyDataSetChanged();
  }
  
  public void setDismissListener(b.a parama)
  {
    this.rxj = parama;
  }
  
  public void setGameMenuItemSelectedListener(b.c paramc)
  {
    this.rxi = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView
 * JD-Core Version:    0.7.0.1
 */
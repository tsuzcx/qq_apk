package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameMenuView
  extends LinearLayout
{
  private Context mContext;
  private LayoutInflater mInflater;
  private boolean vnS;
  private View vnX;
  private LinearLayout vnY;
  private LinearLayout vnZ;
  private f voa;
  private b.c vob;
  private b.a voc;
  
  public GameMenuView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(8830);
    this.vnS = false;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    paramContext = this.mContext.getResources().getDisplayMetrics();
    if (paramContext.widthPixels > paramContext.heightPixels) {
      bool = true;
    }
    this.vnS = bool;
    initView();
    AppMethodBeat.o(8830);
  }
  
  public GameMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(8832);
    this.vnS = false;
    this.mContext = paramContext;
    initView();
    AppMethodBeat.o(8832);
  }
  
  private void initView()
  {
    AppMethodBeat.i(8833);
    if (this.vnS)
    {
      setOrientation(0);
      this.mInflater.inflate(2130969790, this, true);
    }
    for (View localView = this.mInflater.inflate(2130969787, this, true);; localView = this.mInflater.inflate(2130969788, this, true))
    {
      this.vnX = localView.findViewById(2131824693);
      this.vnY = ((LinearLayout)localView.findViewById(2131824694));
      this.vnZ = ((LinearLayout)localView.findViewById(2131824695));
      AppMethodBeat.o(8833);
      return;
      setOrientation(1);
      this.mInflater.inflate(2130969791, this, true);
    }
  }
  
  public void setAdapter(f paramf)
  {
    AppMethodBeat.i(8831);
    this.voa = paramf;
    paramf.registerDataSetObserver(new GameMenuView.1(this));
    paramf.notifyDataSetChanged();
    AppMethodBeat.o(8831);
  }
  
  public void setDismissListener(b.a parama)
  {
    this.voc = parama;
  }
  
  public void setGameMenuItemSelectedListener(b.c paramc)
  {
    this.vob = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView
 * JD-Core Version:    0.7.0.1
 */
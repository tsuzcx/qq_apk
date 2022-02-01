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
import com.tencent.mm.ui.base.n;

public class GameMenuView
  extends LinearLayout
{
  private View Jse;
  private LinearLayout Jsf;
  private LinearLayout Jsg;
  private f Jsh;
  private b.c Jsi;
  private b.a Jsj;
  private Context mContext;
  private LayoutInflater mInflater;
  private boolean mLL;
  
  public GameMenuView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(80983);
    this.mLL = false;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    paramContext = this.mContext.getResources().getDisplayMetrics();
    if (paramContext.widthPixels > paramContext.heightPixels) {
      bool = true;
    }
    this.mLL = bool;
    initView();
    AppMethodBeat.o(80983);
  }
  
  public GameMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(80985);
    this.mLL = false;
    this.mContext = paramContext;
    initView();
    AppMethodBeat.o(80985);
  }
  
  private void initView()
  {
    AppMethodBeat.i(80986);
    if (this.mLL)
    {
      setOrientation(0);
      this.mInflater.inflate(2131494914, this, true);
    }
    for (View localView = this.mInflater.inflate(2131494911, this, true);; localView = this.mInflater.inflate(2131494912, this, true))
    {
      this.Jse = localView.findViewById(2131302035);
      this.Jsf = ((LinearLayout)localView.findViewById(2131302034));
      this.Jsg = ((LinearLayout)localView.findViewById(2131302036));
      AppMethodBeat.o(80986);
      return;
      setOrientation(1);
      this.mInflater.inflate(2131494915, this, true);
    }
  }
  
  public void setAdapter(f paramf)
  {
    AppMethodBeat.i(80984);
    this.Jsh = paramf;
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
    this.Jsj = parama;
  }
  
  public void setGameMenuItemSelectedListener(b.c paramc)
  {
    this.Jsi = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView
 * JD-Core Version:    0.7.0.1
 */
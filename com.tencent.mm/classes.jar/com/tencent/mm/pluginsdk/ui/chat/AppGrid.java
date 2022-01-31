package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import java.util.List;
import java.util.Map;

public class AppGrid
  extends GridView
{
  private Context context;
  private AdapterView.OnItemClickListener jUz;
  private AdapterView.OnItemLongClickListener myN;
  private SharedPreferences sp;
  private AppGrid.b vUE;
  private int vUF;
  private int vUG;
  private int vUH;
  private int vUI;
  private int vUJ;
  private AppGrid.a vUK;
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27736);
    this.vUG = 0;
    this.vUH = 0;
    this.jUz = new AppGrid.1(this);
    this.myN = new AppGrid.2(this);
    this.context = paramContext;
    AppMethodBeat.o(27736);
  }
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27735);
    this.vUG = 0;
    this.vUH = 0;
    this.jUz = new AppGrid.1(this);
    this.myN = new AppGrid.2(this);
    this.context = paramContext;
    AppMethodBeat.o(27735);
  }
  
  public final void Me(int paramInt)
  {
    AppMethodBeat.i(27738);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(27738);
      return;
    }
    setPadding(BackwardSupportUtil.b.b(this.context, 16.0F), paramInt, BackwardSupportUtil.b.b(this.context, 16.0F), 0);
    setVerticalSpacing(paramInt / 2);
    AppMethodBeat.o(27738);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(27739);
    this.vUI = paramInt1;
    this.vUF = paramInt2;
    this.vUG = paramInt3;
    this.vUH = paramInt4;
    this.vUJ = paramInt6;
    setNumColumns(paramInt5);
    AppMethodBeat.o(27739);
  }
  
  public final void d(List<f> paramList, Map<String, f> paramMap)
  {
    AppMethodBeat.i(27737);
    this.vUK = new AppGrid.a(this, this.context, paramList, paramMap);
    setBackgroundResource(0);
    setAdapter(this.vUK);
    setOnItemClickListener(this.jUz);
    setOnItemLongClickListener(this.myN);
    int i = BackwardSupportUtil.b.b(this.context, 16.0F);
    int j = BackwardSupportUtil.b.b(this.context, 16.0F);
    setPadding(i, BackwardSupportUtil.b.b(this.context, 6.0F), j, 0);
    AppMethodBeat.o(27737);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(27740);
    int i = this.vUK.getCount();
    AppMethodBeat.o(27740);
    return i;
  }
  
  public void setOnAppSelectedListener(AppGrid.b paramb)
  {
    this.vUE = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid
 * JD-Core Version:    0.7.0.1
 */
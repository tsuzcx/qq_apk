package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.ui.w;

public class NotInterestMenu
  extends LinearLayout
{
  private static int[] qXK = { 2131303836, 2131303834, 2131303835 };
  private Context mContext;
  private ListView qXJ;
  private NotInterestMenu.c qXL;
  private NotInterestMenu.b qXM;
  private n qXp;
  
  public NotInterestMenu(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(35667);
    this.mContext = null;
    this.qXp = null;
    this.qXL = null;
    this.qXM = null;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(35667);
  }
  
  public NotInterestMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(35668);
    this.mContext = null;
    this.qXp = null;
    this.qXL = null;
    this.qXM = null;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(35668);
  }
  
  private void init()
  {
    AppMethodBeat.i(35669);
    w.hM(this.mContext).inflate(2130970366, this);
    this.qXJ = ((ListView)findViewById(2131826558));
    this.qXJ.setAdapter(new NotInterestMenu.a(this));
    this.qXJ.setOnItemClickListener(new NotInterestMenu.1(this));
    AppMethodBeat.o(35669);
  }
  
  public void setOnClickMenuListener(NotInterestMenu.b paramb)
  {
    this.qXM = paramb;
  }
  
  public void setOnSelectMenuItemListener(NotInterestMenu.c paramc)
  {
    this.qXL = paramc;
  }
  
  public void setSnsInfo(n paramn)
  {
    this.qXp = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.NotInterestMenu
 * JD-Core Version:    0.7.0.1
 */
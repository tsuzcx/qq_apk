package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.patmsg.a.c;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.sdk.platformtools.bt;

public class AvatarPatImageView
  extends AppCompatImageView
  implements c
{
  private c.a wFN;
  private View.OnClickListener wFO;
  public a wFP;
  
  public AvatarPatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AvatarPatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(215718);
    this.wFP = new a();
    this.wFP.wFU = this;
    AppMethodBeat.o(215718);
  }
  
  public c.a getDoubleClickListener()
  {
    return this.wFN;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return this.wFO;
  }
  
  public int getTagScene()
  {
    AppMethodBeat.i(215724);
    if (getTag(2131308174) == null)
    {
      AppMethodBeat.o(215724);
      return 0;
    }
    int i = ((Integer)getTag(2131308174)).intValue();
    AppMethodBeat.o(215724);
    return i;
  }
  
  public String getTagTalker()
  {
    AppMethodBeat.i(215722);
    if (getTag(2131308175) == null)
    {
      AppMethodBeat.o(215722);
      return "";
    }
    String str = (String)getTag(2131308175);
    AppMethodBeat.o(215722);
    return str;
  }
  
  public String getTagUsername()
  {
    AppMethodBeat.i(215720);
    String str = (String)getTag(2131308176);
    AppMethodBeat.o(215720);
    return str;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(215726);
    super.onDetachedFromWindow();
    this.wFP.dyp();
    AppMethodBeat.o(215726);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(215725);
    this.wFO = paramOnClickListener;
    super.setOnClickListener(this.wFP.wFW);
    AppMethodBeat.o(215725);
  }
  
  public void setOnDoubleClickListener(c.a parama)
  {
    this.wFN = parama;
  }
  
  public void setTagScene(int paramInt)
  {
    AppMethodBeat.i(215723);
    setTag(2131308174, Integer.valueOf(paramInt));
    AppMethodBeat.o(215723);
  }
  
  public void setTagTalker(String paramString)
  {
    AppMethodBeat.i(215721);
    setTag(2131308175, paramString);
    AppMethodBeat.o(215721);
  }
  
  public void setTagUsername(String paramString)
  {
    AppMethodBeat.i(215719);
    if (!bt.nullAsNil(getTagUsername()).equals(paramString)) {
      this.wFP.dyp();
    }
    setTag(2131308176, paramString);
    AppMethodBeat.o(215719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.patmsg.a.c;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.sdk.platformtools.bu;

public class AvatarPatImageView
  extends AppCompatImageView
  implements c
{
  private View.OnClickListener wVA;
  public a wVB;
  private c.a wVz;
  
  public AvatarPatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AvatarPatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220352);
    this.wVB = new a();
    this.wVB.wVG = this;
    AppMethodBeat.o(220352);
  }
  
  public c.a getDoubleClickListener()
  {
    return this.wVz;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return this.wVA;
  }
  
  public int getTagScene()
  {
    AppMethodBeat.i(220358);
    if (getTag(2131308174) == null)
    {
      AppMethodBeat.o(220358);
      return 0;
    }
    int i = ((Integer)getTag(2131308174)).intValue();
    AppMethodBeat.o(220358);
    return i;
  }
  
  public String getTagTalker()
  {
    AppMethodBeat.i(220356);
    if (getTag(2131308175) == null)
    {
      AppMethodBeat.o(220356);
      return "";
    }
    String str = (String)getTag(2131308175);
    AppMethodBeat.o(220356);
    return str;
  }
  
  public String getTagUsername()
  {
    AppMethodBeat.i(220354);
    String str = (String)getTag(2131308176);
    AppMethodBeat.o(220354);
    return str;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(220360);
    super.onDetachedFromWindow();
    this.wVB.dBF();
    AppMethodBeat.o(220360);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(220359);
    this.wVA = paramOnClickListener;
    super.setOnClickListener(this.wVB.wVI);
    AppMethodBeat.o(220359);
  }
  
  public void setOnDoubleClickListener(c.a parama)
  {
    this.wVz = parama;
  }
  
  public void setTagScene(int paramInt)
  {
    AppMethodBeat.i(220357);
    setTag(2131308174, Integer.valueOf(paramInt));
    AppMethodBeat.o(220357);
  }
  
  public void setTagTalker(String paramString)
  {
    AppMethodBeat.i(220355);
    setTag(2131308175, paramString);
    AppMethodBeat.o(220355);
  }
  
  public void setTagUsername(String paramString)
  {
    AppMethodBeat.i(220353);
    if (!bu.nullAsNil(getTagUsername()).equals(paramString)) {
      this.wVB.dBF();
    }
    setTag(2131308176, paramString);
    AppMethodBeat.o(220353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView
 * JD-Core Version:    0.7.0.1
 */
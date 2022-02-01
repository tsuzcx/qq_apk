package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.patmsg.a.c;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.sdk.platformtools.Util;

public class AvatarPatImageView
  extends AppCompatImageView
  implements c
{
  private c.a ARs;
  private View.OnClickListener ARt;
  public a ARu;
  
  public AvatarPatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AvatarPatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206974);
    this.ARu = new a();
    this.ARu.ARz = this;
    AppMethodBeat.o(206974);
  }
  
  public c.a getDoubleClickListener()
  {
    return this.ARs;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return this.ARt;
  }
  
  public int getTagScene()
  {
    AppMethodBeat.i(206980);
    if (getTag(2131305796) == null)
    {
      AppMethodBeat.o(206980);
      return 0;
    }
    int i = ((Integer)getTag(2131305796)).intValue();
    AppMethodBeat.o(206980);
    return i;
  }
  
  public String getTagTalker()
  {
    AppMethodBeat.i(206978);
    if (getTag(2131305797) == null)
    {
      AppMethodBeat.o(206978);
      return "";
    }
    String str = (String)getTag(2131305797);
    AppMethodBeat.o(206978);
    return str;
  }
  
  public String getTagUsername()
  {
    AppMethodBeat.i(206976);
    String str = (String)getTag(2131305798);
    AppMethodBeat.o(206976);
    return str;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(206982);
    super.onDetachedFromWindow();
    this.ARu.eBq();
    AppMethodBeat.o(206982);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(206981);
    this.ARt = paramOnClickListener;
    super.setOnClickListener(this.ARu.ARB);
    AppMethodBeat.o(206981);
  }
  
  public void setOnDoubleClickListener(c.a parama)
  {
    this.ARs = parama;
  }
  
  public void setTagScene(int paramInt)
  {
    AppMethodBeat.i(206979);
    setTag(2131305796, Integer.valueOf(paramInt));
    AppMethodBeat.o(206979);
  }
  
  public void setTagTalker(String paramString)
  {
    AppMethodBeat.i(206977);
    setTag(2131305797, paramString);
    AppMethodBeat.o(206977);
  }
  
  public void setTagUsername(String paramString)
  {
    AppMethodBeat.i(206975);
    if (!Util.nullAsNil(getTagUsername()).equals(paramString)) {
      this.ARu.eBq();
    }
    setTag(2131305798, paramString);
    AppMethodBeat.o(206975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView
 * JD-Core Version:    0.7.0.1
 */
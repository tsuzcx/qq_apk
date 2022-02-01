package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.patmsg.a.c;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.plugin.patmsg.d.d;
import com.tencent.mm.sdk.platformtools.Util;

public class AvatarPatImageView
  extends AppCompatImageView
  implements c
{
  private c.a MHx;
  private View.OnClickListener MHy;
  public a MHz;
  
  public AvatarPatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AvatarPatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(266435);
    this.MHz = new a();
    this.MHz.MHE = this;
    AppMethodBeat.o(266435);
  }
  
  public c.a getDoubleClickListener()
  {
    return this.MHx;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return this.MHy;
  }
  
  public int getTagScene()
  {
    AppMethodBeat.i(266463);
    if (getTag(d.d.pat_tag_scene) == null)
    {
      AppMethodBeat.o(266463);
      return 0;
    }
    int i = ((Integer)getTag(d.d.pat_tag_scene)).intValue();
    AppMethodBeat.o(266463);
    return i;
  }
  
  public String getTagTalker()
  {
    AppMethodBeat.i(266458);
    if (getTag(d.d.pat_tag_talker) == null)
    {
      AppMethodBeat.o(266458);
      return "";
    }
    String str = (String)getTag(d.d.pat_tag_talker);
    AppMethodBeat.o(266458);
    return str;
  }
  
  public String getTagUsername()
  {
    AppMethodBeat.i(266444);
    String str = (String)getTag(d.d.pat_tag_username);
    AppMethodBeat.o(266444);
    return str;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(266469);
    super.onDetachedFromWindow();
    this.MHz.gxL();
    AppMethodBeat.o(266469);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(266467);
    this.MHy = paramOnClickListener;
    super.setOnClickListener(this.MHz.MHG);
    AppMethodBeat.o(266467);
  }
  
  public void setOnDoubleClickListener(c.a parama)
  {
    this.MHx = parama;
  }
  
  public void setTagScene(int paramInt)
  {
    AppMethodBeat.i(266461);
    setTag(d.d.pat_tag_scene, Integer.valueOf(paramInt));
    AppMethodBeat.o(266461);
  }
  
  public void setTagTalker(String paramString)
  {
    AppMethodBeat.i(266455);
    setTag(d.d.pat_tag_talker, paramString);
    AppMethodBeat.o(266455);
  }
  
  public void setTagUsername(String paramString)
  {
    AppMethodBeat.i(266439);
    if (!Util.nullAsNil(getTagUsername()).equals(paramString)) {
      this.MHz.gxL();
    }
    setTag(d.d.pat_tag_username, paramString);
    AppMethodBeat.o(266439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView
 * JD-Core Version:    0.7.0.1
 */
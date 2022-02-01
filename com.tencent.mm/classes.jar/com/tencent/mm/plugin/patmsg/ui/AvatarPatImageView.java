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
  private c.a GKD;
  private View.OnClickListener GKE;
  public a GKF;
  
  public AvatarPatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AvatarPatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186365);
    this.GKF = new a();
    this.GKF.GKK = this;
    AppMethodBeat.o(186365);
  }
  
  public c.a getDoubleClickListener()
  {
    return this.GKD;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return this.GKE;
  }
  
  public int getTagScene()
  {
    AppMethodBeat.i(186380);
    if (getTag(d.d.pat_tag_scene) == null)
    {
      AppMethodBeat.o(186380);
      return 0;
    }
    int i = ((Integer)getTag(d.d.pat_tag_scene)).intValue();
    AppMethodBeat.o(186380);
    return i;
  }
  
  public String getTagTalker()
  {
    AppMethodBeat.i(186376);
    if (getTag(d.d.pat_tag_talker) == null)
    {
      AppMethodBeat.o(186376);
      return "";
    }
    String str = (String)getTag(d.d.pat_tag_talker);
    AppMethodBeat.o(186376);
    return str;
  }
  
  public String getTagUsername()
  {
    AppMethodBeat.i(186368);
    String str = (String)getTag(d.d.pat_tag_username);
    AppMethodBeat.o(186368);
    return str;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(186386);
    super.onDetachedFromWindow();
    this.GKF.fmX();
    AppMethodBeat.o(186386);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(186382);
    this.GKE = paramOnClickListener;
    super.setOnClickListener(this.GKF.GKM);
    AppMethodBeat.o(186382);
  }
  
  public void setOnDoubleClickListener(c.a parama)
  {
    this.GKD = parama;
  }
  
  public void setTagScene(int paramInt)
  {
    AppMethodBeat.i(186379);
    setTag(d.d.pat_tag_scene, Integer.valueOf(paramInt));
    AppMethodBeat.o(186379);
  }
  
  public void setTagTalker(String paramString)
  {
    AppMethodBeat.i(186375);
    setTag(d.d.pat_tag_talker, paramString);
    AppMethodBeat.o(186375);
  }
  
  public void setTagUsername(String paramString)
  {
    AppMethodBeat.i(186367);
    if (!Util.nullAsNil(getTagUsername()).equals(paramString)) {
      this.GKF.fmX();
    }
    setTag(d.d.pat_tag_username, paramString);
    AppMethodBeat.o(186367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView
 * JD-Core Version:    0.7.0.1
 */
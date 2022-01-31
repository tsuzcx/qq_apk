package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class ChattingUILayout
  extends BasePanelKeybordLayout
{
  private ChatFooterBottom sgq;
  
  public ChattingUILayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private ChatFooterBottom o(ViewGroup paramViewGroup)
  {
    if (this.sgq != null) {
      return this.sgq;
    }
    if ((paramViewGroup == null) || (paramViewGroup.getChildCount() <= 0)) {
      return this.sgq;
    }
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ChatFooterBottom))
      {
        this.sgq = ((ChatFooterBottom)localView);
        return this.sgq;
      }
      if (((localView instanceof ViewGroup)) && (o((ViewGroup)localView) != null)) {
        return this.sgq;
      }
      i += 1;
    }
    return this.sgq;
  }
  
  protected List<View> getPanelView()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(o(this));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChattingUILayout
 * JD-Core Version:    0.7.0.1
 */
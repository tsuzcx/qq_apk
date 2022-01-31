package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class ChattingUILayout
  extends BasePanelKeybordLayout
{
  public ChattingUILayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(27947);
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(27947);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChattingUILayout
 * JD-Core Version:    0.7.0.1
 */
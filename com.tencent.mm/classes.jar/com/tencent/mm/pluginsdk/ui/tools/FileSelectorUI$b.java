package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$Companion;", "", "()V", "DROPDOWN_ITEM_TYPE_ALBUM", "", "DROPDOWN_ITEM_TYPE_CHATTING", "DROPDOWN_ITEM_TYPE_FAV", "DROPDOWN_ITEM_TYPE_FOLDER", "INTENT_SCENE", "", "INTENT_SELECTED_FILE_LIST", "INTENT_TO_USER", "INTENT_WITH_TEXT_CONTENT", "MIN_FIRST_PAGE_ITEM_COUNT", "PREVIEW_REQUEST_CODE", "SCENE_FROM_C2C", "SCENE_FROM_CAST_SCREEN", "SCREEN_DOWNLOAD_CODE", "TAG", "checkOrientation", "context", "Landroid/content/Context;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FileSelectorUI$b
{
  public static int iY(Context paramContext)
  {
    AppMethodBeat.i(245700);
    s.u(paramContext, "context");
    paramContext = paramContext.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(245700);
      throw paramContext;
    }
    switch (((WindowManager)paramContext).getDefaultDisplay().getRotation())
    {
    default: 
      AppMethodBeat.o(245700);
      return 0;
    case 0: 
      AppMethodBeat.o(245700);
      return 0;
    case 1: 
      AppMethodBeat.o(245700);
      return 90;
    case 2: 
      AppMethodBeat.o(245700);
      return 180;
    }
    AppMethodBeat.o(245700);
    return 270;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.b
 * JD-Core Version:    0.7.0.1
 */
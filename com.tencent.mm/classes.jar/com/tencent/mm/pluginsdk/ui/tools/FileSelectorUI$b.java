package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$Companion;", "", "()V", "DROPDOWN_ITEM_TYPE_ALBUM", "", "DROPDOWN_ITEM_TYPE_CHATTING", "DROPDOWN_ITEM_TYPE_FAV", "DROPDOWN_ITEM_TYPE_FOLDER", "INTENT_SCENE", "", "INTENT_SELECTED_FILE_LIST", "INTENT_TO_USER", "INTENT_WITH_TEXT_CONTENT", "MIN_FIRST_PAGE_ITEM_COUNT", "PREVIEW_REQUEST_CODE", "SCENE_FROM_C2C", "SCENE_FROM_CAST_SCREEN", "SCREEN_DOWNLOAD_CODE", "TAG", "checkOrientation", "context", "Landroid/content/Context;", "app_release"})
public final class FileSelectorUI$b
{
  public static int hB(Context paramContext)
  {
    AppMethodBeat.i(292007);
    p.k(paramContext, "context");
    paramContext = paramContext.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(292007);
      throw paramContext;
    }
    paramContext = ((WindowManager)paramContext).getDefaultDisplay();
    p.j(paramContext, "(context.getSystemServic…owManager).defaultDisplay");
    switch (paramContext.getRotation())
    {
    default: 
      AppMethodBeat.o(292007);
      return 0;
    case 0: 
      AppMethodBeat.o(292007);
      return 0;
    case 1: 
      AppMethodBeat.o(292007);
      return 90;
    case 2: 
      AppMethodBeat.o(292007);
      return 180;
    }
    AppMethodBeat.o(292007);
    return 270;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.b
 * JD-Core Version:    0.7.0.1
 */
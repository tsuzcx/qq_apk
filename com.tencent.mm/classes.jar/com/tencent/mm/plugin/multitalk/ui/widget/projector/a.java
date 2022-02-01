package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "", "checkCallerState", "", "checkCurrentInAvatarLayout", "", "checkCurrentInDoodleLayout", "checkCurrentOrientation", "getCurrentFileMd5", "", "getCurrentStatus", "statusChange", "", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "Landroid/os/Bundle;", "Companion", "ProjectStatus", "plugin-multitalk_release"})
public abstract interface a
{
  public static final a.a FAT = a.a.FAU;
  
  public abstract void a(c paramc, Bundle paramBundle);
  
  public abstract int eYV();
  
  public abstract boolean eYW();
  
  public abstract boolean eYX();
  
  public abstract int eYY();
  
  public abstract boolean getCurrentStatus();
  
  @l(iBK={1, 1, 16})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "", "(Ljava/lang/String;I)V", "START_PROJECTOR", "STOP_PROJECTOR", "SHOW_DOODLE_LAYOUT", "HIDE_DOODLE_LAYOUT", "SET_MIC_MUTE_STATUS", "CLEAR_SCREEN", "STOP_PROJECTOR_SEND", "AVATAR_READY", "AVATAR_HIDE", "THUMB_VIEW_PAGE_FLIP", "SCREEN_ON_CLICK", "SLIDE_CONTENT_LEFT", "SLIDE_CONTENT_RIGHT", "REQUEST_THUMB_REFRESH", "ON_EDITOR_LAYOUT_CHANGE", "SCREEN_READY_UI_FINISH", "SAVE_TO_PICTURE", "SAVE_TO_FAV", "SEND_TO_FRIEND", "SCALE_SCREEN", "plugin-multitalk_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(206539);
      c localc1 = new c("START_PROJECTOR", 0);
      FAV = localc1;
      c localc2 = new c("STOP_PROJECTOR", 1);
      FAW = localc2;
      c localc3 = new c("SHOW_DOODLE_LAYOUT", 2);
      FAX = localc3;
      c localc4 = new c("HIDE_DOODLE_LAYOUT", 3);
      FAY = localc4;
      c localc5 = new c("SET_MIC_MUTE_STATUS", 4);
      FAZ = localc5;
      c localc6 = new c("CLEAR_SCREEN", 5);
      FBa = localc6;
      c localc7 = new c("STOP_PROJECTOR_SEND", 6);
      FBb = localc7;
      c localc8 = new c("AVATAR_READY", 7);
      FBc = localc8;
      c localc9 = new c("AVATAR_HIDE", 8);
      FBd = localc9;
      c localc10 = new c("THUMB_VIEW_PAGE_FLIP", 9);
      FBe = localc10;
      c localc11 = new c("SCREEN_ON_CLICK", 10);
      FBf = localc11;
      c localc12 = new c("SLIDE_CONTENT_LEFT", 11);
      FBg = localc12;
      c localc13 = new c("SLIDE_CONTENT_RIGHT", 12);
      FBh = localc13;
      c localc14 = new c("REQUEST_THUMB_REFRESH", 13);
      FBi = localc14;
      c localc15 = new c("ON_EDITOR_LAYOUT_CHANGE", 14);
      FBj = localc15;
      c localc16 = new c("SCREEN_READY_UI_FINISH", 15);
      FBk = localc16;
      c localc17 = new c("SAVE_TO_PICTURE", 16);
      FBl = localc17;
      c localc18 = new c("SAVE_TO_FAV", 17);
      FBm = localc18;
      c localc19 = new c("SEND_TO_FRIEND", 18);
      FBn = localc19;
      c localc20 = new c("SCALE_SCREEN", 19);
      FBo = localc20;
      FBp = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8, localc9, localc10, localc11, localc12, localc13, localc14, localc15, localc16, localc17, localc18, localc19, localc20 };
      AppMethodBeat.o(206539);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.a
 * JD-Core Version:    0.7.0.1
 */
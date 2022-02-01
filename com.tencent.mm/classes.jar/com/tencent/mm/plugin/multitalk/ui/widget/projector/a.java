package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "", "checkCallerState", "", "checkCurrentInAvatarLayout", "", "checkCurrentInDoodleLayout", "checkCurrentOrientation", "getCurrentFileMd5", "", "getCurrentStatus", "statusChange", "", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "Landroid/os/Bundle;", "Companion", "ProjectStatus", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public static final a.a LwV = a.a.LwW;
  
  public abstract void a(c paramc, Bundle paramBundle);
  
  public abstract boolean getCurrentStatus();
  
  public abstract int ghU();
  
  public abstract boolean ghV();
  
  public abstract boolean ghW();
  
  public abstract int ghX();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "", "(Ljava/lang/String;I)V", "START_PROJECTOR", "STOP_PROJECTOR", "SHOW_DOODLE_LAYOUT", "HIDE_DOODLE_LAYOUT", "SET_MIC_MUTE_STATUS", "CLEAR_SCREEN", "STOP_PROJECTOR_SEND", "AVATAR_READY", "AVATAR_HIDE", "THUMB_VIEW_PAGE_FLIP", "SCREEN_ON_CLICK", "SLIDE_CONTENT_LEFT", "SLIDE_CONTENT_RIGHT", "REQUEST_THUMB_REFRESH", "ON_EDITOR_LAYOUT_CHANGE", "SCREEN_READY_UI_FINISH", "SAVE_TO_PICTURE", "SAVE_TO_FAV", "SEND_TO_FRIEND", "SCALE_SCREEN", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(285637);
      LwX = new c("START_PROJECTOR", 0);
      LwY = new c("STOP_PROJECTOR", 1);
      LwZ = new c("SHOW_DOODLE_LAYOUT", 2);
      Lxa = new c("HIDE_DOODLE_LAYOUT", 3);
      Lxb = new c("SET_MIC_MUTE_STATUS", 4);
      Lxc = new c("CLEAR_SCREEN", 5);
      Lxd = new c("STOP_PROJECTOR_SEND", 6);
      Lxe = new c("AVATAR_READY", 7);
      Lxf = new c("AVATAR_HIDE", 8);
      Lxg = new c("THUMB_VIEW_PAGE_FLIP", 9);
      Lxh = new c("SCREEN_ON_CLICK", 10);
      Lxi = new c("SLIDE_CONTENT_LEFT", 11);
      Lxj = new c("SLIDE_CONTENT_RIGHT", 12);
      Lxk = new c("REQUEST_THUMB_REFRESH", 13);
      Lxl = new c("ON_EDITOR_LAYOUT_CHANGE", 14);
      Lxm = new c("SCREEN_READY_UI_FINISH", 15);
      Lxn = new c("SAVE_TO_PICTURE", 16);
      Lxo = new c("SAVE_TO_FAV", 17);
      Lxp = new c("SEND_TO_FRIEND", 18);
      Lxq = new c("SCALE_SCREEN", 19);
      Lxr = new c[] { LwX, LwY, LwZ, Lxa, Lxb, Lxc, Lxd, Lxe, Lxf, Lxg, Lxh, Lxi, Lxj, Lxk, Lxl, Lxm, Lxn, Lxo, Lxp, Lxq };
      AppMethodBeat.o(285637);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.a
 * JD-Core Version:    0.7.0.1
 */
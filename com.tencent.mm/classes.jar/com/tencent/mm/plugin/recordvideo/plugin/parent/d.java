package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "", "statusChange", "", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "RecordStatus", "plugin-recordvideo_release"})
public abstract interface d
{
  public static final d.a vnr = d.a.vns;
  
  public abstract void a(c paramc, Bundle paramBundle);
  
  @l(fvt={1, 1, 16})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "", "(Ljava/lang/String;I)V", "PREPARE_CAMERA_ZOOM", "TRIGGER_CAMERA_ZOOM", "SWITCH_CAMERA", "FOCUS_ON_TOUCH", "RECORD_START", "RECORD_FINISH", "SUB_RECORD_FINISH", "SUB_RECORD_PREPARE_DELETE", "SUB_RECORD_CANCEL_DELETE", "SUB_RECORD_DELETE", "SUB_RECORD_SELECT", "SUB_RECORD_CAMERA", "RECORD_PICTURE", "RECORD_ROUTE", "RECORD_BEAUTIFY", "RECORD_FILTER", "RECORD_CLICK_MUSIC", "RECORD_UN_CLICK_MUSIC", "RECORD_STICKER_PANEL", "RECORD_CHANGE_STICKER", "TO_SET_RESULT", "RECORD_TYPE_CHANGE", "BACK_RECORD", "START_PLAY_VIDEO", "EDIT_VIDEO", "EDIT_VIDEO_WITH_EMOJI", "EDIT_VIDEO_WITH_TEXT", "EDIT_VIDEO_WITH_TIP", "EDIT_VIDEO_SEEK", "EDIT_ADD_EMOJI", "EDIT_ADD_TEXT", "EDIT_ADD_TIP", "EDIT_ADD_POI", "EDIT_CHANGE_TEXT", "EDIT_CHANGE_TIP", "EDIT_CHANGE_POI", "EDIT_ADD_MUSIC", "EDIT_DELETE_ITEM", "EDIT_IN_PREVIEW", "EDIT_SET_ORIGIN_MUTE", "EDIT_SELECT_MUSIC", "EDIT_SELECT_LYRICS", "EDIT_CROP_VIDEO", "EDIT_FORCE_CROP_VIDEO", "EDIT_CROP_VIDEO_LENGTH", "EDIT_CROP_VIDEO_PERCENT", "EDIT_CROP_VIDEO_PAUSE", "EDIT_CROP_VIDEO_RESUME", "EDIT_CROP_CANCEL", "EDIT_CROP_FINISH", "EDIT_START_MUX", "EDIT_VIDEO_PREPARE", "EDIT_DELETE_ITEM_DONE", "EDIT_PHOTO_CROP", "EDIT_PHOTO_SHOW_EMOJI_PANEL", "EDIT_PHOTO_SHOW_TEXT_PANEL", "EDIT_PHOTO_DOODLE", "EDIT_PHOTO_DOODLE_CLICK", "EDIT_PHOTO_DOODLE_MOVE_START", "EDIT_PHOTO_DOODLE_MOVE_STOP", "EDIT_PHOTO_DOODLE_CANCEL", "EDIT_PHOTO_DOODLE_MSC", "EDIT_PHOTO_DOODLE_BRUSH", "EDIT_PHOTO_DOODLE_PENCIL", "EDIT_PHOTO_DOODLE_UNDO", "EDIT_PHOTO_CROP_CANCEL", "EDIT_PHOTO_CROP_FINISH", "EDIT_PHOTO_CROP_ROTATE", "EDIT_PHOTO_CROP_UNDO", "EDIT_PHOTO_SHOW_FUNC_LAYOUT", "EDIT_PHOTO_FILTER_CANCEL", "EDIT_PHOTO_FILTER_ENTER", "EDIT_VLOG_SIZE_CHANGE", "EDIT_VLOG_PREPARE", "EDIT_VLOG_ENTER_VIDEO_CROP", "EDIT_VLOG_CHANGE_VIDEO_LENGTH", "EDIT_VLOG_FINISH", "EDIT_VLOG_CANCEL", "EDIT_VLOG_SEARCH_MUSIC_FINISH", "EDIT_VLOG_SEARCH_MUSIC_SCRIPT_FINISH", "EDIT_VLOG_SELECT_IMAGE_VLOG", "EDIT_VLOG_MULTI_IMAGE_SELECT", "EDIT_VLOG_SELECT_TRACK", "EDIT_VLOG_TRACK_CROP", "EDIT_FILTER_SHOW", "UI_FINISH", "plugin-recordvideo_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(75782);
      c localc1 = new c("PREPARE_CAMERA_ZOOM", 0);
      vnu = localc1;
      c localc2 = new c("TRIGGER_CAMERA_ZOOM", 1);
      vnv = localc2;
      c localc3 = new c("SWITCH_CAMERA", 2);
      vnw = localc3;
      c localc4 = new c("FOCUS_ON_TOUCH", 3);
      vnx = localc4;
      c localc5 = new c("RECORD_START", 4);
      vny = localc5;
      c localc6 = new c("RECORD_FINISH", 5);
      vnz = localc6;
      c localc7 = new c("SUB_RECORD_FINISH", 6);
      Loo = localc7;
      c localc8 = new c("SUB_RECORD_PREPARE_DELETE", 7);
      Lop = localc8;
      c localc9 = new c("SUB_RECORD_CANCEL_DELETE", 8);
      Loq = localc9;
      c localc10 = new c("SUB_RECORD_DELETE", 9);
      Lor = localc10;
      c localc11 = new c("SUB_RECORD_SELECT", 10);
      Los = localc11;
      c localc12 = new c("SUB_RECORD_CAMERA", 11);
      Lot = localc12;
      c localc13 = new c("RECORD_PICTURE", 12);
      vnA = localc13;
      c localc14 = new c("RECORD_ROUTE", 13);
      vnB = localc14;
      c localc15 = new c("RECORD_BEAUTIFY", 14);
      vnC = localc15;
      c localc16 = new c("RECORD_FILTER", 15);
      vnD = localc16;
      c localc17 = new c("RECORD_CLICK_MUSIC", 16);
      Lou = localc17;
      c localc18 = new c("RECORD_UN_CLICK_MUSIC", 17);
      Lov = localc18;
      c localc19 = new c("RECORD_STICKER_PANEL", 18);
      Low = localc19;
      c localc20 = new c("RECORD_CHANGE_STICKER", 19);
      Lox = localc20;
      c localc21 = new c("TO_SET_RESULT", 20);
      vnE = localc21;
      c localc22 = new c("RECORD_TYPE_CHANGE", 21);
      Loy = localc22;
      c localc23 = new c("BACK_RECORD", 22);
      vnF = localc23;
      c localc24 = new c("START_PLAY_VIDEO", 23);
      vnG = localc24;
      c localc25 = new c("EDIT_VIDEO", 24);
      vnH = localc25;
      c localc26 = new c("EDIT_VIDEO_WITH_EMOJI", 25);
      vnI = localc26;
      c localc27 = new c("EDIT_VIDEO_WITH_TEXT", 26);
      vnJ = localc27;
      c localc28 = new c("EDIT_VIDEO_WITH_TIP", 27);
      vnK = localc28;
      c localc29 = new c("EDIT_VIDEO_SEEK", 28);
      Loz = localc29;
      c localc30 = new c("EDIT_ADD_EMOJI", 29);
      vnL = localc30;
      c localc31 = new c("EDIT_ADD_TEXT", 30);
      vnM = localc31;
      c localc32 = new c("EDIT_ADD_TIP", 31);
      vnN = localc32;
      c localc33 = new c("EDIT_ADD_POI", 32);
      vnO = localc33;
      c localc34 = new c("EDIT_CHANGE_TEXT", 33);
      vnP = localc34;
      c localc35 = new c("EDIT_CHANGE_TIP", 34);
      vnQ = localc35;
      c localc36 = new c("EDIT_CHANGE_POI", 35);
      vnR = localc36;
      c localc37 = new c("EDIT_ADD_MUSIC", 36);
      vnS = localc37;
      c localc38 = new c("EDIT_DELETE_ITEM", 37);
      vnT = localc38;
      c localc39 = new c("EDIT_IN_PREVIEW", 38);
      vnU = localc39;
      c localc40 = new c("EDIT_SET_ORIGIN_MUTE", 39);
      vnV = localc40;
      c localc41 = new c("EDIT_SELECT_MUSIC", 40);
      vnW = localc41;
      c localc42 = new c("EDIT_SELECT_LYRICS", 41);
      vnX = localc42;
      c localc43 = new c("EDIT_CROP_VIDEO", 42);
      vnY = localc43;
      c localc44 = new c("EDIT_FORCE_CROP_VIDEO", 43);
      vnZ = localc44;
      c localc45 = new c("EDIT_CROP_VIDEO_LENGTH", 44);
      voa = localc45;
      c localc46 = new c("EDIT_CROP_VIDEO_PERCENT", 45);
      vob = localc46;
      c localc47 = new c("EDIT_CROP_VIDEO_PAUSE", 46);
      voc = localc47;
      c localc48 = new c("EDIT_CROP_VIDEO_RESUME", 47);
      vod = localc48;
      c localc49 = new c("EDIT_CROP_CANCEL", 48);
      voe = localc49;
      c localc50 = new c("EDIT_CROP_FINISH", 49);
      vof = localc50;
      c localc51 = new c("EDIT_START_MUX", 50);
      vog = localc51;
      c localc52 = new c("EDIT_VIDEO_PREPARE", 51);
      voh = localc52;
      c localc53 = new c("EDIT_DELETE_ITEM_DONE", 52);
      voi = localc53;
      c localc54 = new c("EDIT_PHOTO_CROP", 53);
      voj = localc54;
      c localc55 = new c("EDIT_PHOTO_SHOW_EMOJI_PANEL", 54);
      vok = localc55;
      c localc56 = new c("EDIT_PHOTO_SHOW_TEXT_PANEL", 55);
      vol = localc56;
      c localc57 = new c("EDIT_PHOTO_DOODLE", 56);
      vom = localc57;
      c localc58 = new c("EDIT_PHOTO_DOODLE_CLICK", 57);
      von = localc58;
      c localc59 = new c("EDIT_PHOTO_DOODLE_MOVE_START", 58);
      voo = localc59;
      c localc60 = new c("EDIT_PHOTO_DOODLE_MOVE_STOP", 59);
      vop = localc60;
      c localc61 = new c("EDIT_PHOTO_DOODLE_CANCEL", 60);
      voq = localc61;
      c localc62 = new c("EDIT_PHOTO_DOODLE_MSC", 61);
      vor = localc62;
      c localc63 = new c("EDIT_PHOTO_DOODLE_BRUSH", 62);
      vos = localc63;
      c localc64 = new c("EDIT_PHOTO_DOODLE_PENCIL", 63);
      vot = localc64;
      c localc65 = new c("EDIT_PHOTO_DOODLE_UNDO", 64);
      vou = localc65;
      c localc66 = new c("EDIT_PHOTO_CROP_CANCEL", 65);
      vov = localc66;
      c localc67 = new c("EDIT_PHOTO_CROP_FINISH", 66);
      vow = localc67;
      c localc68 = new c("EDIT_PHOTO_CROP_ROTATE", 67);
      vox = localc68;
      c localc69 = new c("EDIT_PHOTO_CROP_UNDO", 68);
      voy = localc69;
      c localc70 = new c("EDIT_PHOTO_SHOW_FUNC_LAYOUT", 69);
      voz = localc70;
      c localc71 = new c("EDIT_PHOTO_FILTER_CANCEL", 70);
      voA = localc71;
      c localc72 = new c("EDIT_PHOTO_FILTER_ENTER", 71);
      voB = localc72;
      c localc73 = new c("EDIT_VLOG_SIZE_CHANGE", 72);
      voC = localc73;
      c localc74 = new c("EDIT_VLOG_PREPARE", 73);
      voD = localc74;
      c localc75 = new c("EDIT_VLOG_ENTER_VIDEO_CROP", 74);
      voE = localc75;
      c localc76 = new c("EDIT_VLOG_CHANGE_VIDEO_LENGTH", 75);
      voF = localc76;
      c localc77 = new c("EDIT_VLOG_FINISH", 76);
      voG = localc77;
      c localc78 = new c("EDIT_VLOG_CANCEL", 77);
      voH = localc78;
      c localc79 = new c("EDIT_VLOG_SEARCH_MUSIC_FINISH", 78);
      voI = localc79;
      c localc80 = new c("EDIT_VLOG_SEARCH_MUSIC_SCRIPT_FINISH", 79);
      voJ = localc80;
      c localc81 = new c("EDIT_VLOG_SELECT_IMAGE_VLOG", 80);
      LoA = localc81;
      c localc82 = new c("EDIT_VLOG_MULTI_IMAGE_SELECT", 81);
      LoB = localc82;
      c localc83 = new c("EDIT_VLOG_SELECT_TRACK", 82);
      LoC = localc83;
      c localc84 = new c("EDIT_VLOG_TRACK_CROP", 83);
      LoD = localc84;
      c localc85 = new c("EDIT_FILTER_SHOW", 84);
      LoE = localc85;
      c localc86 = new c("UI_FINISH", 85);
      LoF = localc86;
      voK = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8, localc9, localc10, localc11, localc12, localc13, localc14, localc15, localc16, localc17, localc18, localc19, localc20, localc21, localc22, localc23, localc24, localc25, localc26, localc27, localc28, localc29, localc30, localc31, localc32, localc33, localc34, localc35, localc36, localc37, localc38, localc39, localc40, localc41, localc42, localc43, localc44, localc45, localc46, localc47, localc48, localc49, localc50, localc51, localc52, localc53, localc54, localc55, localc56, localc57, localc58, localc59, localc60, localc61, localc62, localc63, localc64, localc65, localc66, localc67, localc68, localc69, localc70, localc71, localc72, localc73, localc74, localc75, localc76, localc77, localc78, localc79, localc80, localc81, localc82, localc83, localc84, localc85, localc86 };
      AppMethodBeat.o(75782);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.d
 * JD-Core Version:    0.7.0.1
 */
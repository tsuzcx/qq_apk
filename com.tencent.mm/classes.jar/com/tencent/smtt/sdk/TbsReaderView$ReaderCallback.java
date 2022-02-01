package com.tencent.smtt.sdk;

public abstract interface TbsReaderView$ReaderCallback
{
  public static final int COPY_SELECT_TEXT = 5003;
  public static final int GET_BAR_ANIMATING = 5000;
  public static final int GET_BAR_ISSHOWING = 5024;
  public static final int HIDDEN_BAR = 5001;
  public static final int INSTALL_QB = 5011;
  public static final int NOTIFY_CANDISPLAY = 12;
  public static final int NOTIFY_ERRORCODE = 19;
  public static final int READER_OPEN_QQ_FILE_LIST = 5031;
  public static final int READER_PDF_LIST = 5008;
  public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
  public static final int READER_PLUGIN_CANLOAD = 5013;
  public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
  public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
  public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
  public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
  public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
  public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
  public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
  public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
  public static final int READER_PLUGIN_DOWNLOADING = 5014;
  public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
  public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
  public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
  public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
  public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
  public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
  public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
  public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
  public static final int READER_PLUGIN_SO_ERR = 5025;
  public static final int READER_PLUGIN_SO_INTO_START = 5027;
  public static final int READER_PLUGIN_SO_PROGRESS = 5028;
  public static final int READER_PLUGIN_SO_VERSION = 5030;
  public static final int READER_PLUGIN_STATUS = 5012;
  public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
  public static final int READER_PPT_PLAY_MODEL = 5009;
  public static final int READER_SEARCH_IN_DOCUMENT = 5026;
  public static final int READER_TOAST = 5005;
  public static final int READER_TXT_READING_MODEL = 5010;
  public static final int SEARCH_SELECT_TEXT = 5004;
  public static final int SHOW_BAR = 5002;
  public static final int SHOW_DIALOG = 5006;
  
  public abstract void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
 * JD-Core Version:    0.7.0.1
 */
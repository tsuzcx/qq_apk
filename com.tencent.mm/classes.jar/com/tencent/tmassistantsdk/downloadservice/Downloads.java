package com.tencent.tmassistantsdk.downloadservice;

public class Downloads
{
  public static final String CONTENT_TYPE_APK = "application/vnd.android.package-archive";
  public static final String CONTENT_TYPE_APKDIFF = "application/tm.android.apkdiff";
  public static final String CONTENT_TYPE_OTHERS = "resource/tm.android.unknown";
  public static final int DOWNLOAD_ERR_CONNECT_TIMEOUT = 601;
  public static final int DOWNLOAD_ERR_HTTP_LOCATION_HEADER_IS_NULL = 702;
  public static final int DOWNLOAD_ERR_INTERRUPTED = 600;
  public static final int DOWNLOAD_ERR_IO_EXCEPTION = 606;
  public static final int DOWNLOAD_ERR_NONE = 0;
  public static final int DOWNLOAD_ERR_PARSER_CONTENT_FAILED = 704;
  public static final int DOWNLOAD_ERR_RANGE_NOT_MATCH = 706;
  public static final int DOWNLOAD_ERR_REDIRECT_TOO_MANY_TIMES = 709;
  public static final int DOWNLOAD_ERR_RESPONSE_IS_NULL = 701;
  public static final int DOWNLOAD_ERR_SET_RANGE_FAILED = 707;
  public static final int DOWNLOAD_ERR_SOCKET_EXCEPTION = 605;
  public static final int DOWNLOAD_ERR_SOCKET_TIMEOUT = 602;
  public static final int DOWNLOAD_ERR_SSL_HANDSHAKE_EXCEPTION = 607;
  public static final int DOWNLOAD_ERR_TOTAL_SIZE_NOT_SAME = 705;
  public static final int DOWNLOAD_ERR_UNKNOWN_EXCEPTION = 604;
  public static final int DOWNLOAD_ERR_UNKNOWN_HOST = 603;
  public static final int DOWNLOAD_ERR_URL_HOOK = 708;
  public static final int DOWNLOAD_ERR_URL_INVALID = 700;
  public static final int DOWNLOAD_ERR_WRITE_FILE_FAILED = 703;
  public static final int DOWNLOAD_ERR_WRITE_FILE_NO_ENOUGH_SPACE = 710;
  public static final int DOWNLOAD_ERR_WRITE_FILE_SDCARD_EXCEPTION = 711;
  public static final int DOWNLOAD_START_FAILED_BUSY = 5;
  public static final int DOWNLOAD_START_FAILED_EXISTED = 4;
  public static final int DOWNLOAD_START_FAILED_NETWORK_NOT_CONNECTED = 1;
  public static final int DOWNLOAD_START_FAILED_ONLY_FOR_WIFI = 2;
  public static final int DOWNLOAD_START_FAILED_PARAMETERS_INVALID = 3;
  public static final int DOWNLOAD_START_SUCCEED = 0;
  public static final int DOWNLOAD_STATUS_CANCELED = 6;
  public static final int DOWNLOAD_STATUS_DOWNLOADING = 2;
  public static final int DOWNLOAD_STATUS_FAILED = 5;
  public static final int DOWNLOAD_STATUS_INIT = 0;
  public static final int DOWNLOAD_STATUS_PAUSED = 3;
  public static final int DOWNLOAD_STATUS_SUCCEED = 4;
  public static final int DOWNLOAD_STATUS_WAITING = 1;
  public static final byte LOG_TYPE_DOWNLOAD = 0;
  public static final byte LOG_TYPE_TIPSINFO = 1;
  public static final byte LOG_TYPE_UPDATEINFO = 2;
  public static final int MAX_REDIRESTS = 5;
  public static final int MAX_RETIES = 5;
  public static final int MAX_RETYR_AFTER = 86400000;
  public static final int MIN_RETYR_AFTER = 5000;
  public static final int MIN_WAIT_FOR_NETWORK = 10000;
  public static final int RECV_BUFFER_SIZE = 4096;
  public static final byte RESOURCE_TYPE_APK = 0;
  public static final byte RESOURCE_TYPE_OPENSDK = 1;
  public static final int SPLIT_RANGE_SIZE_NET = 921600;
  public static final int SPLIT_RANGE_SIZE_WAP = 409600;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.Downloads
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.thumbplayer.core.downloadproxy.api;

public class TPDownloadProxyEnum
{
  public static final int DLMODE_ALL = 2147483647;
  public static final int DLMODE_DOWNLOAD = 4;
  public static final int DLMODE_PLAY = 1;
  public static final int DLMODE_PREPARE = 2;
  public static final String DLPARAM_ADAPTIVE_TYPE = "dl_param_adaptive_type";
  public static final String DLPARAM_CACHE_NEED_ENCRYPT = "dl_param_cache_need_encrypt";
  public static final String DLPARAM_CURRENT_FORMAT = "dl_param_current_format";
  public static final String DLPARAM_CURRENT_FORMATID = "dl_param_current_formatid";
  public static final String DLPARAM_DATA_TRANSFER_MODE = "dl_param_data_transfer_mode";
  public static final String DLPARAM_ENABLE_EXPAND_DOWNLOAD_URL = "dl_param_enable_expand_donwload_url";
  public static final String DLPARAM_ENABLE_TEG_PCDN = "dl_param_enable_teg_pcdn";
  public static final String DLPARAM_EXPECT_DELAY_TIME = "dl_param_expect_delay_time";
  public static final String DLPARAM_FILE_DURATION = "dl_param_file_duration";
  public static final String DLPARAM_FILE_MD5 = "dl_param_file_md5";
  public static final String DLPARAM_FILE_SIZE = "dl_param_file_size";
  public static final String DLPARAM_FORMAT_INFO = "dl_param_format_info";
  public static final String DLPARAM_FORMAT_NODES = "dl_param_format_nodes";
  public static final String DLPARAM_IS_OFFLINE = "dl_param_is_offline";
  public static final String DLPARAM_OFFLINE_PLAY_EXTRA_INFO = "dl_param_play_extra_info";
  public static final String DLPARAM_PACKAGE = "package";
  public static final String DLPARAM_PCDN_URLS = "dl_param_pcdn_urls";
  public static final String DLPARAM_PCDN_VTS = "dl_param_pcdn_vts";
  public static final String DLPARAM_PLAY_CLIP_COUNT = "dl_param_play_clip_count";
  public static final String DLPARAM_PLAY_CLIP_NO = "dl_param_play_clip_no";
  public static final String DLPARAM_PLAY_DEFINITION = "dl_param_play_definition";
  public static final String DLPARAM_PLAY_END_TIME = "dl_param_play_end_time";
  public static final String DLPARAM_PLAY_FLOWID = "dl_param_play_flowid";
  public static final String DLPARAM_PLAY_KEYID = "dl_param_play_keyid";
  public static final String DLPARAM_PLAY_START_TIME = "dl_param_play_start_time";
  public static final String DLPARAM_PRELOAD_DURATION = "dl_param_preload_duration";
  public static final String DLPARAM_PRELOAD_SIZE = "dl_param_preload_size";
  public static final String DLPARAM_SAVE_PATH = "dl_param_save_path";
  public static final String DLPARAM_SOURCE_IS_CHARGE = "dl_param_source_is_charge";
  public static final String DLPARAM_URL_COOKIE = "dl_param_url_cookie";
  public static final String DLPARAM_URL_EXPIRE_TIME = "dl_param_url_expire_time";
  public static final String DLPARAM_URL_HEADER = "dl_param_url_header";
  public static final String DLPARAM_URL_HOST = "dl_param_url_host";
  public static final String DLPARAM_VID = "dl_param_vid";
  public static final String DLPARAM_VINFO_BASE = "dl_param_vinfo_base";
  public static final String DLPARAM_VINFO_FP2P = "dl_param_vinfo_fp2p";
  public static final String DLPARAM_VINFO_LINK_VID = "dl_param_vinfo_link_vid";
  public static final String DLPARAM_VINFO_M3U8 = "dl_param_vinfo_m3u8";
  public static final String DLPARAM_VINFO_TESTID = "dl_param_vinfo_testid";
  public static final String DLPARAM_VINFO_TM = "dl_param_vinfo_tm";
  public static final String DLPARAM_XP2P_ID = "xp2p_id";
  public static final String DLPARAM_XP2P_KEY = "xp2p_key";
  public static final String DLPARAM_XP2P_SECRET_KEY = "xp2p_secretKey";
  public static final int DLTYPE_ADAPTIVE_PLAY_BASE = 400;
  public static final int DLTYPE_AUTO = 0;
  public static final int DLTYPE_CAPTION_SRT = 14;
  public static final int DLTYPE_CAPTION_WEBVTT = 15;
  public static final int DLTYPE_CLIP_MP4_VOD = 2;
  public static final int DLTYPE_FILE_DOWNLOAD = 10;
  public static final int DLTYPE_FILE_VOD_PROXYLOAD = 11;
  public static final int DLTYPE_FLV_LIVE = 12;
  public static final int DLTYPE_HLS_ADV = 7;
  public static final int DLTYPE_HLS_ADV_LOOP = 8;
  public static final int DLTYPE_HLS_AUDIO_VOD = 13;
  public static final int DLTYPE_HLS_LIVE = 5;
  public static final int DLTYPE_HLS_VOD = 3;
  public static final int DLTYPE_HLS_VOD_LOOP = 4;
  public static final int DLTYPE_LAN = 9;
  public static final int DLTYPE_MP4_ADV = 6;
  public static final int DLTYPE_MP4_VOD = 1;
  public static final int DLTYPE_OFFLINE_BASE = 100;
  public static final int DLTYPE_OFFLINE_PLAY_BASE = 300;
  public static final int DLTYPE_PREPARE_BASE = 200;
  public static final int DL_DATA_TRANSFER_MODE_AV = 1;
  public static final int DL_DATA_TRANSFER_MODE_DEFAULT = 0;
  public static final int DL_DATA_TRANSFER_MODE_FMP4_TO_TS = 2;
  public static final int DL_URL_TYPE_LOCAL_ABSOLUTE_URL_PRIORITY = 0;
  public static final int DL_URL_TYPE_LOCAL_PROXY_URL_CREATE_TASK = 2;
  public static final int DL_URL_TYPE_LOCAL_PROXY_URL_ONLY = 1;
  public static final int EVENT_APPTOBACK = 13;
  public static final int EVENT_APPTOFRONT = 14;
  public static final int EVENT_BUFFER_MORE_DATA = 21;
  public static final int EVENT_DOWNLOAD_PAUSE = 11;
  public static final int EVENT_DOWNLOAD_RESUME = 12;
  public static final int EVENT_NETWORK_ISWIFIOFF = 10;
  public static final int EVENT_NETWORK_ISWIFION = 9;
  public static final int EVENT_NETWORK_OFF = 1;
  public static final int EVENT_NETWORK_ON = 2;
  public static final int EVENT_NOT_PLAYING = 16;
  public static final int EVENT_OFFLINE_ALLOWED = 4;
  public static final int EVENT_OFFLINE_FORBIDDEN = 3;
  public static final int EVENT_ON_PLAYING = 15;
  public static final int EVENT_P2PUPLOAD_OFF = 18;
  public static final int EVENT_P2PUPLOAD_ON = 17;
  public static final int EVENT_PLAY_ALLOWED = 6;
  public static final int EVENT_PLAY_FORBIDDEN = 5;
  public static final int EVENT_SCREEN_OFF = 20;
  public static final int EVENT_SCREEN_ON = 19;
  public static final int EVENT_TRY_ACCELERATE_OFF = 24;
  public static final int EVENT_TRY_ACCELERATE_ON = 23;
  public static final int NETWORK_TYPE_2G = 2;
  public static final int NETWORK_TYPE_3G = 3;
  public static final int NETWORK_TYPE_4G = 4;
  public static final int NETWORK_TYPE_5G = 5;
  public static final int NETWORK_TYPE_NONE = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  public static final int NETWORK_TYPE_WIRED = 100;
  public static final int PLAYING_STATE_IN_SEEKING = 1;
  public static final int PLAYING_STATE_ON_BLOCKING = 2;
  public static final int PLAYING_STATE_ON_PAUSE = 5;
  public static final int PLAYING_STATE_ON_PLAYERROR = 3;
  public static final int PLAYING_STATE_ON_PLAYING = 0;
  public static final int PLAYING_STATE_ON_PREPLAY = 100;
  public static final int PLAYING_STATE_ON_REALPLAY = 101;
  public static final int PLAYING_STATE_ON_SECONDBLOCKING = 4;
  public static final String USER_APP_VERSION = "app_version_name";
  public static final String USER_APP_VERSION_CODE = "app_version_code";
  public static final String USER_BSSID = "bssid";
  public static final String USER_DEVICE_ID = "device_id";
  public static final String USER_DEVICE_MODEL = "device_model";
  public static final String USER_EXTERNAL_NETWORK_IP = "external_network_ip";
  public static final String USER_GUID = "guid";
  public static final String USER_IS_VIP = "qq_is_vip";
  public static final String USER_LOSS_PACKAGE_INFO = "lose_package_check_info";
  public static final String USER_MAC = "mac";
  public static final String USER_MAX_USE_MEMORY_MB = "max_use_memory";
  public static final String USER_MCC = "user_mcc";
  public static final String USER_MNC = "user_mnc";
  public static final String USER_NETWORK_TYPE = "network_type";
  public static final String USER_OS_VERSION = "os_version";
  public static final String USER_PLATFORM = "platform";
  public static final String USER_SSID = "ssid";
  public static final String USER_SYSTEM_RESERVE_MEMORY_MB = "system_reserve_memory";
  public static final String USER_TRIM_MEMORY_LEVEL = "trim_memory_level";
  public static final String USER_UIN = "user_uin";
  public static final String USER_UPC = "carrier_pesudo_code";
  public static final String USER_UPC_STATE = "carrier_pesudo_state";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum
 * JD-Core Version:    0.7.0.1
 */
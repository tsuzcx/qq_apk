package com.tencent.voip.mars.comm;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PlatformComm
{
  static final int EMobile = 2;
  static final int ENoNet = -1;
  static final int EOtherNet = 3;
  static final int EWifi = 1;
  private static final boolean IS_PROXY_ON = false;
  static final int NETTYPE_2G = 3;
  static final int NETTYPE_3G = 4;
  static final int NETTYPE_4G = 5;
  static final int NETTYPE_NON = -1;
  static final int NETTYPE_NOT_WIFI = 0;
  static final int NETTYPE_UNKNOWN = 6;
  static final int NETTYPE_WAP = 2;
  static final int NETTYPE_WIFI = 1;
  private static final String TAG = "PlatformComm";
  public static Context context = null;
  public static Handler handler = null;
  
  public static void init(Context paramContext, Handler paramHandler)
  {
    AppMethodBeat.i(55581);
    context = paramContext;
    handler = paramHandler;
    NetworkSignalUtil.InitNetworkSignalUtil(paramContext);
    AppMethodBeat.o(55581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.voip.mars.comm.PlatformComm
 * JD-Core Version:    0.7.0.1
 */
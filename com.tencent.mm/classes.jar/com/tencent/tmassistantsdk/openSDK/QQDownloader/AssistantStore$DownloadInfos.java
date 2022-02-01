package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AssistantStore$DownloadInfos
  implements BaseColumns
{
  public static final Uri CONTENT_URI;
  
  static
  {
    AppMethodBeat.i(102096);
    CONTENT_URI = Uri.parse("content://com.tencent.android.qqdownloader.provider/downloadsinfo?notify=true");
    AppMethodBeat.o(102096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos
 * JD-Core Version:    0.7.0.1
 */
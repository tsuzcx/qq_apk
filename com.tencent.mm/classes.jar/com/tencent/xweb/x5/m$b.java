package com.tencent.xweb.x5;

import android.net.Uri;
import android.webkit.PermissionRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback;
import java.util.ArrayList;

public final class m$b
  extends PermissionRequest
{
  private MediaAccessPermissionsCallback aagR;
  private long aagS;
  private String mOrigin;
  
  public m$b(String paramString, long paramLong, MediaAccessPermissionsCallback paramMediaAccessPermissionsCallback)
  {
    this.mOrigin = paramString;
    this.aagR = paramMediaAccessPermissionsCallback;
    this.aagS = paramLong;
  }
  
  public final void deny()
  {
    AppMethodBeat.i(210040);
    this.aagR.invoke(this.mOrigin, 0L, false);
    AppMethodBeat.o(210040);
  }
  
  public final Uri getOrigin()
  {
    AppMethodBeat.i(210034);
    Uri localUri = Uri.parse(this.mOrigin);
    AppMethodBeat.o(210034);
    return localUri;
  }
  
  public final String[] getResources()
  {
    AppMethodBeat.i(210037);
    long l = this.aagS;
    Object localObject = new ArrayList();
    if ((0x2 & l) != 0L) {
      ((ArrayList)localObject).add("android.webkit.resource.VIDEO_CAPTURE");
    }
    if ((0x4 & l) != 0L) {
      ((ArrayList)localObject).add("android.webkit.resource.AUDIO_CAPTURE");
    }
    if ((0x8 & l) != 0L) {
      ((ArrayList)localObject).add("android.webkit.resource.PROTECTED_MEDIA_ID");
    }
    if ((l & 0x10) != 0L) {
      ((ArrayList)localObject).add("android.webkit.resource.MIDI_SYSEX");
    }
    localObject = (String[])((String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()])).clone();
    AppMethodBeat.o(210037);
    return localObject;
  }
  
  public final void grant(String[] paramArrayOfString)
  {
    AppMethodBeat.i(210039);
    MediaAccessPermissionsCallback localMediaAccessPermissionsCallback = this.aagR;
    String str1 = this.mOrigin;
    long l2 = 0L;
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str2 = paramArrayOfString[i];
      long l1;
      if (str2.equals("android.webkit.resource.VIDEO_CAPTURE")) {
        l1 = l2 | 0x2;
      }
      for (;;)
      {
        i += 1;
        l2 = l1;
        break;
        if (str2.equals("android.webkit.resource.AUDIO_CAPTURE"))
        {
          l1 = l2 | 0x4;
        }
        else if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID"))
        {
          l1 = l2 | 0x8;
        }
        else
        {
          l1 = l2;
          if (str2.equals("android.webkit.resource.MIDI_SYSEX")) {
            l1 = l2 | 0x10;
          }
        }
      }
    }
    localMediaAccessPermissionsCallback.invoke(str1, l2, false);
    AppMethodBeat.o(210039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.m.b
 * JD-Core Version:    0.7.0.1
 */
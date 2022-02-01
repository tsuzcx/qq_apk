package com.tencent.thumbplayer.c;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

public final class g
  implements ITPMediaDRMAsset
{
  private Map<String, String> RYY;
  private int mDrmType;
  private String mPlayUrl;
  
  public g(int paramInt, String paramString)
  {
    AppMethodBeat.i(189139);
    this.mPlayUrl = paramString;
    this.mDrmType = paramInt;
    this.RYY = new HashMap();
    AppMethodBeat.o(189139);
  }
  
  public final Map<String, String> getDrmAllProperties()
  {
    return this.RYY;
  }
  
  public final String getDrmPlayUrl()
  {
    return this.mPlayUrl;
  }
  
  public final String getDrmProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189141);
    if ((this.RYY == null) || (this.RYY.isEmpty()))
    {
      AppMethodBeat.o(189141);
      return paramString2;
    }
    paramString1 = (String)this.RYY.get(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(189141);
      return paramString2;
    }
    AppMethodBeat.o(189141);
    return paramString1;
  }
  
  public final int getDrmType()
  {
    return this.mDrmType;
  }
  
  public final int getMediaType()
  {
    return 0;
  }
  
  public final String getUrl()
  {
    int i = 0;
    AppMethodBeat.i(189142);
    try
    {
      Object localObject = Xml.newSerializer();
      StringWriter localStringWriter = new StringWriter();
      ((XmlSerializer)localObject).setOutput(localStringWriter);
      ((XmlSerializer)localObject).startDocument("UTF-8", Boolean.TRUE);
      ((XmlSerializer)localObject).startTag("", "assets");
      ((XmlSerializer)localObject).startTag("", "av_tracks");
      ((XmlSerializer)localObject).startTag("", "av_track");
      ((XmlSerializer)localObject).startTag("", "track_clip");
      ((XmlSerializer)localObject).startTag("", "clip_id");
      ((XmlSerializer)localObject).text(Integer.toString(0));
      ((XmlSerializer)localObject).endTag("", "clip_id");
      ((XmlSerializer)localObject).startTag("", "clip_placeHolder");
      ((XmlSerializer)localObject).text("0");
      ((XmlSerializer)localObject).endTag("", "clip_placeHolder");
      ((XmlSerializer)localObject).startTag("", "clip_path");
      ((XmlSerializer)localObject).text(getDrmPlayUrl());
      ((XmlSerializer)localObject).endTag("", "clip_path");
      ((XmlSerializer)localObject).startTag("", "clip_drmType");
      int j = getDrmType();
      if (j == 0) {}
      for (;;)
      {
        ((XmlSerializer)localObject).text(String.valueOf(i));
        ((XmlSerializer)localObject).endTag("", "clip_drmType");
        ((XmlSerializer)localObject).startTag("", "clip_drmProvisionUrl");
        ((XmlSerializer)localObject).text(getDrmProperty("drm_property_provision_url", ""));
        ((XmlSerializer)localObject).endTag("", "clip_drmProvisionUrl");
        ((XmlSerializer)localObject).startTag("", "clip_drmLicenseUrl");
        ((XmlSerializer)localObject).text(getDrmProperty("drm_property_license_url", ""));
        ((XmlSerializer)localObject).endTag("", "clip_drmLicenseUrl");
        ((XmlSerializer)localObject).startTag("", "clip_drmUseL1");
        ((XmlSerializer)localObject).text(getDrmProperty("drm_property_use_l1", "1"));
        ((XmlSerializer)localObject).endTag("", "clip_drmUseL1");
        ((XmlSerializer)localObject).startTag("", "clip_drmSavePath");
        ((XmlSerializer)localObject).text(getDrmProperty("drm_property_save_path", ""));
        ((XmlSerializer)localObject).endTag("", "clip_drmSavePath");
        ((XmlSerializer)localObject).startTag("", "clip_drmGuid");
        ((XmlSerializer)localObject).text(getDrmProperty("drm_property_guid", ""));
        ((XmlSerializer)localObject).endTag("", "clip_drmGuid");
        ((XmlSerializer)localObject).startTag("", "clip_drmPlatform");
        ((XmlSerializer)localObject).text(getDrmProperty("drm_property_platform", ""));
        ((XmlSerializer)localObject).endTag("", "clip_drmPlatform");
        ((XmlSerializer)localObject).startTag("", "clip_drmAppVersion");
        ((XmlSerializer)localObject).text(getDrmProperty("drm_property_app_ver", ""));
        ((XmlSerializer)localObject).endTag("", "clip_drmAppVersion");
        ((XmlSerializer)localObject).startTag("", "clip_drmCookie");
        ((XmlSerializer)localObject).text(getDrmProperty("drm_property_cookie", ""));
        ((XmlSerializer)localObject).endTag("", "clip_drmCookie");
        ((XmlSerializer)localObject).endTag("", "track_clip");
        ((XmlSerializer)localObject).endTag("", "av_track");
        ((XmlSerializer)localObject).endTag("", "av_tracks");
        ((XmlSerializer)localObject).endTag("", "assets");
        ((XmlSerializer)localObject).endDocument();
        localObject = localStringWriter.toString();
        AppMethodBeat.o(189142);
        return localObject;
        if (1 == j) {
          i = 1;
        } else if (2 == j) {
          i = 2;
        } else if (3 == j) {
          i = 3;
        } else {
          i = j;
        }
      }
      return "";
    }
    catch (IOException localIOException)
    {
      com.tencent.thumbplayer.utils.g.e("TPMediaDRMAsset", localIOException);
      AppMethodBeat.o(189142);
    }
  }
  
  public final void setDrmPlayUrl(String paramString)
  {
    this.mPlayUrl = paramString;
  }
  
  public final void setDrmProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189140);
    this.RYY.put(paramString1, paramString2);
    AppMethodBeat.o(189140);
  }
  
  public final void setDrmType(int paramInt)
  {
    this.mDrmType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.g
 * JD-Core Version:    0.7.0.1
 */
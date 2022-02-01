package com.tencent.thumbplayer.core.downloadproxy.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class TPDownloadParam
{
  private static final String FILE_NAME = "TPDownloadParam";
  private int dlType;
  private Map<String, Object> extInfoMap;
  private ArrayList<String> urlList;
  
  public TPDownloadParam(ArrayList<String> paramArrayList, int paramInt, Map<String, Object> paramMap)
  {
    this.urlList = paramArrayList;
    this.dlType = paramInt;
    this.extInfoMap = paramMap;
  }
  
  private String getExtraFormatNodesJsonInfo()
  {
    AppMethodBeat.i(190023);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190023);
      return "[]";
    }
    for (;;)
    {
      StringBuffer localStringBuffer;
      int i;
      try
      {
        ArrayList localArrayList = (ArrayList)this.extInfoMap.get("dl_param_format_nodes");
        localStringBuffer = new StringBuffer("[");
        i = 0;
        if (i < localArrayList.size())
        {
          Map localMap = (Map)localArrayList.get(i);
          if (i == localArrayList.size() - 1) {
            localStringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}", new Object[] { localMap.get("dl_param_name"), localMap.get("dl_param_bitrate") }));
          } else {
            localStringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}, ", new Object[] { localMap.get("dl_param_name"), localMap.get("dl_param_bitrate") }));
          }
        }
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", "getExtraJsonInfo failed, error:" + localThrowable.toString());
        AppMethodBeat.o(190023);
        return "[]";
      }
      localStringBuffer.append("]");
      String str = localStringBuffer.toString();
      AppMethodBeat.o(190023);
      return str;
      i += 1;
    }
  }
  
  public String getCdnUrls()
  {
    int i = 0;
    AppMethodBeat.i(190009);
    if (this.urlList == null)
    {
      AppMethodBeat.o(190009);
      return "";
    }
    Object localObject = new StringBuffer();
    boolean bool;
    if ((this.extInfoMap != null) && (this.extInfoMap.containsKey("dl_param_enable_expand_donwload_url"))) {
      bool = ((Boolean)this.extInfoMap.get("dl_param_enable_expand_donwload_url")).booleanValue();
    }
    for (;;)
    {
      if (i < this.urlList.size())
      {
        ((StringBuffer)localObject).append((String)this.urlList.get(i));
        if (bool)
        {
          if (((String)this.urlList.get(i)).indexOf("?") <= 0) {
            break label140;
          }
          ((StringBuffer)localObject).append("&cost=low");
        }
        for (;;)
        {
          ((StringBuffer)localObject).append(";");
          i += 1;
          break;
          label140:
          ((StringBuffer)localObject).append("?cost=low");
        }
      }
      if (((StringBuffer)localObject).length() > 0) {
        ((StringBuffer)localObject).deleteCharAt(((StringBuffer)localObject).length() - 1);
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(190009);
      return localObject;
      bool = false;
    }
  }
  
  public int getClipCount()
  {
    int i = 1;
    AppMethodBeat.i(190017);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190017);
      return 1;
    }
    if (this.extInfoMap.containsKey("dl_param_play_clip_count")) {
      i = ((Integer)this.extInfoMap.get("dl_param_play_clip_count")).intValue();
    }
    AppMethodBeat.o(190017);
    return i;
  }
  
  public int getClipNo()
  {
    int i = 1;
    AppMethodBeat.i(190018);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190018);
      return 1;
    }
    if (this.extInfoMap.containsKey("dl_param_play_clip_no")) {
      i = ((Integer)this.extInfoMap.get("dl_param_play_clip_no")).intValue();
    }
    AppMethodBeat.o(190018);
    return i;
  }
  
  public int getDlType()
  {
    return this.dlType;
  }
  
  public Object getExtInfo(String paramString)
  {
    AppMethodBeat.i(190021);
    if (this.extInfoMap == null)
    {
      AppMethodBeat.o(190021);
      return null;
    }
    paramString = this.extInfoMap.get(paramString);
    AppMethodBeat.o(190021);
    return paramString;
  }
  
  public Map<String, Object> getExtInfoMap()
  {
    return this.extInfoMap;
  }
  
  public String getExtraJsonInfo()
  {
    AppMethodBeat.i(190022);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190022);
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = this.extInfoMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_is_offline")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_play_extra_info")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_play_definition")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_enable_expand_donwload_url")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_format_nodes"))) {
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
      }
      if (!this.extInfoMap.containsKey("dl_param_format_nodes")) {
        break label280;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", "getExtraJsonInfo failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190022);
      return "";
    }
    String str = localThrowable.toString();
    str = String.format("%s,\"%s\":%s}", new Object[] { str.substring(0, str.length() - 1), "dl_param_format_nodes", getExtraFormatNodesJsonInfo() });
    AppMethodBeat.o(190022);
    return str;
    label280:
    str = str.toString();
    AppMethodBeat.o(190022);
    return str;
  }
  
  public String getFormat()
  {
    AppMethodBeat.i(190015);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190015);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_current_format")) {
      str = (String)this.extInfoMap.get("dl_param_current_format");
    }
    AppMethodBeat.o(190015);
    return str;
  }
  
  public String getKeyid()
  {
    AppMethodBeat.i(190016);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190016);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_play_keyid")) {
      str = (String)this.extInfoMap.get("dl_param_play_keyid");
    }
    AppMethodBeat.o(190016);
    return str;
  }
  
  public Map<String, String> getOfflinePlayExtraInfo()
  {
    AppMethodBeat.i(190013);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190013);
      return null;
    }
    if (this.extInfoMap.containsKey("dl_param_play_extra_info"))
    {
      Map localMap = (Map)this.extInfoMap.get("dl_param_play_extra_info");
      AppMethodBeat.o(190013);
      return localMap;
    }
    AppMethodBeat.o(190013);
    return null;
  }
  
  public String getPlayDefinition()
  {
    AppMethodBeat.i(190014);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190014);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_play_definition")) {
      str = (String)this.extInfoMap.get("dl_param_play_definition");
    }
    AppMethodBeat.o(190014);
    return str;
  }
  
  public String getSavaPath()
  {
    AppMethodBeat.i(190020);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190020);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_save_path")) {
      str = (String)this.extInfoMap.get("dl_param_save_path");
    }
    AppMethodBeat.o(190020);
    return str;
  }
  
  public long getTotalDurationMS()
  {
    long l = 0L;
    AppMethodBeat.i(190019);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190019);
      return 0L;
    }
    if (this.extInfoMap.containsKey("dl_param_file_duration")) {
      l = ((Long)this.extInfoMap.get("dl_param_file_duration")).longValue();
    }
    AppMethodBeat.o(190019);
    return l;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public String getVid()
  {
    AppMethodBeat.i(190010);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190010);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_vid")) {
      str = (String)this.extInfoMap.get("dl_param_vid");
    }
    AppMethodBeat.o(190010);
    return str;
  }
  
  public boolean isAdaptive()
  {
    AppMethodBeat.i(190012);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190012);
      return false;
    }
    if ((this.extInfoMap.containsKey("dl_param_adaptive_type")) && (((Integer)this.extInfoMap.get("dl_param_adaptive_type")).intValue() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(190012);
      return bool;
    }
  }
  
  public boolean isOffline()
  {
    boolean bool = false;
    AppMethodBeat.i(190011);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(190011);
      return false;
    }
    if (this.extInfoMap.containsKey("dl_param_is_offline")) {
      bool = ((Boolean)this.extInfoMap.get("dl_param_is_offline")).booleanValue();
    }
    AppMethodBeat.o(190011);
    return bool;
  }
  
  public void setDlType(int paramInt)
  {
    this.dlType = paramInt;
  }
  
  public void setExtInfoMap(Map<String, Object> paramMap)
  {
    this.extInfoMap = paramMap;
  }
  
  public void setUrlList(ArrayList<String> paramArrayList)
  {
    this.urlList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.thumbplayer.core.downloadproxy.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.HashMap;
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
  
  private String getExtraFormatNodesJsonInfo(ArrayList<Map<String, Object>> paramArrayList)
  {
    AppMethodBeat.i(209897);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(209897);
      return "[]";
    }
    for (;;)
    {
      StringBuffer localStringBuffer;
      int i;
      try
      {
        localStringBuffer = new StringBuffer("[");
        i = 0;
        if (i < paramArrayList.size())
        {
          Map localMap = (Map)paramArrayList.get(i);
          if (i == paramArrayList.size() - 1) {
            localStringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}", new Object[] { localMap.get("dl_param_name"), localMap.get("dl_param_bitrate") }));
          } else {
            localStringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}, ", new Object[] { localMap.get("dl_param_name"), localMap.get("dl_param_bitrate") }));
          }
        }
      }
      catch (Throwable paramArrayList)
      {
        TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", "getExtraJsonInfo failed, error:" + paramArrayList.toString());
        AppMethodBeat.o(209897);
        return "[]";
      }
      localStringBuffer.append("]");
      paramArrayList = localStringBuffer.toString();
      AppMethodBeat.o(209897);
      return paramArrayList;
      i += 1;
    }
  }
  
  private String getUrlHostNodesJsonInfo(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(209898);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(209898);
      return "[]";
    }
    for (;;)
    {
      StringBuffer localStringBuffer;
      int i;
      try
      {
        localStringBuffer = new StringBuffer("[");
        i = 0;
        if (i < paramArrayList.size())
        {
          String str = (String)paramArrayList.get(i);
          if (i == paramArrayList.size() - 1) {
            localStringBuffer.append(String.format("\"%s\"", new Object[] { str }));
          } else {
            localStringBuffer.append(String.format("\"%s\", ", new Object[] { str }));
          }
        }
      }
      catch (Throwable paramArrayList)
      {
        TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", "getArrayListStr failed, error:" + paramArrayList.toString());
        AppMethodBeat.o(209898);
        return "[]";
      }
      localStringBuffer.append("]");
      paramArrayList = localStringBuffer.toString();
      AppMethodBeat.o(209898);
      return paramArrayList;
      i += 1;
    }
  }
  
  public String getCdnUrls()
  {
    int i = 0;
    AppMethodBeat.i(209883);
    if (this.urlList == null)
    {
      AppMethodBeat.o(209883);
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
      AppMethodBeat.o(209883);
      return localObject;
      bool = false;
    }
  }
  
  public int getClipCount()
  {
    int i = 1;
    AppMethodBeat.i(209891);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209891);
      return 1;
    }
    if (this.extInfoMap.containsKey("dl_param_play_clip_count")) {
      i = ((Integer)this.extInfoMap.get("dl_param_play_clip_count")).intValue();
    }
    AppMethodBeat.o(209891);
    return i;
  }
  
  public int getClipNo()
  {
    int i = 1;
    AppMethodBeat.i(209892);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209892);
      return 1;
    }
    if (this.extInfoMap.containsKey("dl_param_play_clip_no")) {
      i = ((Integer)this.extInfoMap.get("dl_param_play_clip_no")).intValue();
    }
    AppMethodBeat.o(209892);
    return i;
  }
  
  public int getDlType()
  {
    return this.dlType;
  }
  
  public Object getExtInfo(String paramString)
  {
    AppMethodBeat.i(209895);
    if (this.extInfoMap == null)
    {
      AppMethodBeat.o(209895);
      return null;
    }
    paramString = this.extInfoMap.get(paramString);
    AppMethodBeat.o(209895);
    return paramString;
  }
  
  public Map<String, Object> getExtInfoMap()
  {
    return this.extInfoMap;
  }
  
  public String getExtraJsonInfo()
  {
    AppMethodBeat.i(209896);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209896);
      return "";
    }
    try
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.extInfoMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_is_offline")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_play_extra_info")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_play_definition")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_enable_expand_donwload_url"))) {
          localHashMap.put(localEntry.getKey(), localEntry.getValue());
        }
      }
      str = new JSONObject(localThrowable).toString();
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", "getExtraJsonInfo failed, error:" + localThrowable.toString());
      AppMethodBeat.o(209896);
      return "";
    }
    String str;
    AppMethodBeat.o(209896);
    return str;
  }
  
  public String getFormat()
  {
    AppMethodBeat.i(209889);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209889);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_current_format")) {
      str = (String)this.extInfoMap.get("dl_param_current_format");
    }
    AppMethodBeat.o(209889);
    return str;
  }
  
  public String getKeyid()
  {
    AppMethodBeat.i(209890);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209890);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_play_keyid")) {
      str = (String)this.extInfoMap.get("dl_param_play_keyid");
    }
    AppMethodBeat.o(209890);
    return str;
  }
  
  public Map<String, String> getOfflinePlayExtraInfo()
  {
    AppMethodBeat.i(209887);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209887);
      return null;
    }
    if (this.extInfoMap.containsKey("dl_param_play_extra_info"))
    {
      Map localMap = (Map)this.extInfoMap.get("dl_param_play_extra_info");
      AppMethodBeat.o(209887);
      return localMap;
    }
    AppMethodBeat.o(209887);
    return null;
  }
  
  public String getPlayDefinition()
  {
    AppMethodBeat.i(209888);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209888);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_play_definition")) {
      str = (String)this.extInfoMap.get("dl_param_play_definition");
    }
    AppMethodBeat.o(209888);
    return str;
  }
  
  public String getSavaPath()
  {
    AppMethodBeat.i(209894);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209894);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_save_path")) {
      str = (String)this.extInfoMap.get("dl_param_save_path");
    }
    AppMethodBeat.o(209894);
    return str;
  }
  
  public long getTotalDurationMS()
  {
    long l = 0L;
    AppMethodBeat.i(209893);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209893);
      return 0L;
    }
    if (this.extInfoMap.containsKey("dl_param_file_duration")) {
      l = ((Long)this.extInfoMap.get("dl_param_file_duration")).longValue();
    }
    AppMethodBeat.o(209893);
    return l;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public String getVid()
  {
    AppMethodBeat.i(209884);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209884);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_vid")) {
      str = (String)this.extInfoMap.get("dl_param_vid");
    }
    AppMethodBeat.o(209884);
    return str;
  }
  
  public boolean isAdaptive()
  {
    AppMethodBeat.i(209886);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209886);
      return false;
    }
    if ((this.extInfoMap.containsKey("dl_param_adaptive_type")) && (((Integer)this.extInfoMap.get("dl_param_adaptive_type")).intValue() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(209886);
      return bool;
    }
  }
  
  public boolean isOffline()
  {
    boolean bool = false;
    AppMethodBeat.i(209885);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(209885);
      return false;
    }
    if (this.extInfoMap.containsKey("dl_param_is_offline")) {
      bool = ((Boolean)this.extInfoMap.get("dl_param_is_offline")).booleanValue();
    }
    AppMethodBeat.o(209885);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam
 * JD-Core Version:    0.7.0.1
 */
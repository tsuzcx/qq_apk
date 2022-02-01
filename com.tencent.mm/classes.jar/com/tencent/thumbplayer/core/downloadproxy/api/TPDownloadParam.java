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
    AppMethodBeat.i(255559);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(255559);
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
        AppMethodBeat.o(255559);
        return "[]";
      }
      localStringBuffer.append("]");
      paramArrayList = localStringBuffer.toString();
      AppMethodBeat.o(255559);
      return paramArrayList;
      i += 1;
    }
  }
  
  private String getUrlHostNodesJsonInfo(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(255562);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(255562);
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
        AppMethodBeat.o(255562);
        return "[]";
      }
      localStringBuffer.append("]");
      paramArrayList = localStringBuffer.toString();
      AppMethodBeat.o(255562);
      return paramArrayList;
      i += 1;
    }
  }
  
  public String getCdnUrls()
  {
    int i = 0;
    AppMethodBeat.i(255525);
    if (this.urlList == null)
    {
      AppMethodBeat.o(255525);
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
      AppMethodBeat.o(255525);
      return localObject;
      bool = false;
    }
  }
  
  public int getClipCount()
  {
    int i = 1;
    AppMethodBeat.i(255546);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255546);
      return 1;
    }
    if (this.extInfoMap.containsKey("dl_param_play_clip_count")) {
      i = ((Integer)this.extInfoMap.get("dl_param_play_clip_count")).intValue();
    }
    AppMethodBeat.o(255546);
    return i;
  }
  
  public int getClipNo()
  {
    int i = 1;
    AppMethodBeat.i(255548);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255548);
      return 1;
    }
    if (this.extInfoMap.containsKey("dl_param_play_clip_no")) {
      i = ((Integer)this.extInfoMap.get("dl_param_play_clip_no")).intValue();
    }
    AppMethodBeat.o(255548);
    return i;
  }
  
  public int getDlType()
  {
    return this.dlType;
  }
  
  public Object getExtInfo(String paramString)
  {
    AppMethodBeat.i(255554);
    if (this.extInfoMap == null)
    {
      AppMethodBeat.o(255554);
      return null;
    }
    paramString = this.extInfoMap.get(paramString);
    AppMethodBeat.o(255554);
    return paramString;
  }
  
  public Map<String, Object> getExtInfoMap()
  {
    return this.extInfoMap;
  }
  
  public String getExtraJsonInfo()
  {
    AppMethodBeat.i(255557);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255557);
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
      AppMethodBeat.o(255557);
      return "";
    }
    String str;
    AppMethodBeat.o(255557);
    return str;
  }
  
  public String getFormat()
  {
    AppMethodBeat.i(255540);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255540);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_current_format")) {
      str = (String)this.extInfoMap.get("dl_param_current_format");
    }
    AppMethodBeat.o(255540);
    return str;
  }
  
  public String getKeyid()
  {
    AppMethodBeat.i(255544);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255544);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_play_keyid")) {
      str = (String)this.extInfoMap.get("dl_param_play_keyid");
    }
    AppMethodBeat.o(255544);
    return str;
  }
  
  public Map<String, String> getOfflinePlayExtraInfo()
  {
    AppMethodBeat.i(255533);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255533);
      return null;
    }
    if (this.extInfoMap.containsKey("dl_param_play_extra_info"))
    {
      Map localMap = (Map)this.extInfoMap.get("dl_param_play_extra_info");
      AppMethodBeat.o(255533);
      return localMap;
    }
    AppMethodBeat.o(255533);
    return null;
  }
  
  public String getPlayDefinition()
  {
    AppMethodBeat.i(255536);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255536);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_play_definition")) {
      str = (String)this.extInfoMap.get("dl_param_play_definition");
    }
    AppMethodBeat.o(255536);
    return str;
  }
  
  public String getSavaPath()
  {
    AppMethodBeat.i(255552);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255552);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_save_path")) {
      str = (String)this.extInfoMap.get("dl_param_save_path");
    }
    AppMethodBeat.o(255552);
    return str;
  }
  
  public long getTotalDurationMS()
  {
    long l = 0L;
    AppMethodBeat.i(255550);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255550);
      return 0L;
    }
    if (this.extInfoMap.containsKey("dl_param_file_duration")) {
      l = ((Long)this.extInfoMap.get("dl_param_file_duration")).longValue();
    }
    AppMethodBeat.o(255550);
    return l;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public String getVid()
  {
    AppMethodBeat.i(255528);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255528);
      return "";
    }
    String str = "";
    if (this.extInfoMap.containsKey("dl_param_vid")) {
      str = (String)this.extInfoMap.get("dl_param_vid");
    }
    AppMethodBeat.o(255528);
    return str;
  }
  
  public boolean isAdaptive()
  {
    AppMethodBeat.i(255531);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255531);
      return false;
    }
    if ((this.extInfoMap.containsKey("dl_param_adaptive_type")) && (((Integer)this.extInfoMap.get("dl_param_adaptive_type")).intValue() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(255531);
      return bool;
    }
  }
  
  public boolean isOffline()
  {
    boolean bool = false;
    AppMethodBeat.i(255529);
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty()))
    {
      AppMethodBeat.o(255529);
      return false;
    }
    if (this.extInfoMap.containsKey("dl_param_is_offline")) {
      bool = ((Boolean)this.extInfoMap.get("dl_param_is_offline")).booleanValue();
    }
    AppMethodBeat.o(255529);
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
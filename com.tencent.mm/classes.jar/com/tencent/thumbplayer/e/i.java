package com.tencent.thumbplayer.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.utils.b;
import com.tencent.thumbplayer.utils.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class i
{
  static TPDownloadParam b(String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(189241);
    Object localObject1;
    if (paramTPDownloadParamData != null)
    {
      localObject1 = new ArrayList();
      Object localObject2;
      if ((paramTPDownloadParamData.getUrlCdnidList() == null) || (paramTPDownloadParamData.getUrlCdnidList().isEmpty()))
      {
        if (!TextUtils.isEmpty(paramString)) {
          ((ArrayList)localObject1).add(paramString);
        }
        for (;;)
        {
          localObject2 = paramTPDownloadParamData.getBakUrl();
          paramString = (String)localObject1;
          if (localObject2 == null) {
            break;
          }
          paramString = (String)localObject1;
          if (localObject2.length <= 0) {
            break;
          }
          int i = 0;
          for (;;)
          {
            paramString = (String)localObject1;
            if (i >= localObject2.length) {
              break;
            }
            if (!TextUtils.isEmpty(localObject2[i])) {
              ((ArrayList)localObject1).add(localObject2[i]);
            }
            i += 1;
          }
          ((ArrayList)localObject1).add(paramTPDownloadParamData.url);
        }
      }
      paramString = paramTPDownloadParamData.getUrlCdnidList();
      localObject1 = new HashMap();
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getFlowId()))
      {
        g.i("TPProxyUtils", paramTPDownloadParamData.getFlowId());
        ((Map)localObject1).put("dl_param_play_flowid", paramTPDownloadParamData.getFlowId());
      }
      if (!b.isEmpty(paramTPDownloadParamData.getUrlHostList())) {
        ((Map)localObject1).put("dl_param_url_host", paramTPDownloadParamData.getUrlHostList());
      }
      if (!b.isEmpty(paramTPDownloadParamData.getUrlCookieList())) {
        ((Map)localObject1).put("dl_param_url_cookie", paramTPDownloadParamData.getUrlCookieList());
      }
      if (paramTPDownloadParamData.getUrlExpireTime() > 0) {
        ((Map)localObject1).put("dl_param_url_expire_time", Integer.valueOf(paramTPDownloadParamData.getUrlExpireTime()));
      }
      if (paramTPDownloadParamData.getFileSize() > 0L) {
        ((Map)localObject1).put("dl_param_file_size", Long.valueOf(paramTPDownloadParamData.getFileSize()));
      }
      if (paramTPDownloadParamData.getFileDuration() > 0L) {
        ((Map)localObject1).put("dl_param_file_duration", Long.valueOf(paramTPDownloadParamData.getFileDuration()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getDownloadFileID())) {
        ((Map)localObject1).put("dl_param_play_keyid", paramTPDownloadParamData.getDownloadFileID());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getVid())) {
        ((Map)localObject1).put("dl_param_vid", paramTPDownloadParamData.getVid());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getPlayDefinition()))
      {
        ((Map)localObject1).put("dl_param_play_definition", paramTPDownloadParamData.getPlayDefinition());
        ((Map)localObject1).put("dl_param_current_format", paramTPDownloadParamData.getPlayDefinition());
      }
      if (paramTPDownloadParamData.getCurrentFormatID() > 0) {
        ((Map)localObject1).put("dl_param_current_formatid", Integer.valueOf(paramTPDownloadParamData.getCurrentFormatID()));
      }
      if (!b.isEmpty(paramTPDownloadParamData.getFormatInfo())) {
        ((Map)localObject1).put("dl_param_format_info", paramTPDownloadParamData.getFormatInfo());
      }
      ((Map)localObject1).put("dl_param_source_is_charge", Boolean.valueOf(paramTPDownloadParamData.isCharge()));
      ((Map)localObject1).put("dl_param_cache_need_encrypt", Boolean.valueOf(paramTPDownloadParamData.isNeedEncryptCache()));
      ((Map)localObject1).put("dl_param_is_offline", Boolean.valueOf(paramTPDownloadParamData.isOffline()));
      ((Map)localObject1).put("dl_param_enable_expand_donwload_url", Boolean.valueOf(paramTPDownloadParamData.isExtraParam()));
      if (paramTPDownloadParamData.getPreloadSize() > 0L) {
        ((Map)localObject1).put("dl_param_preload_size", Long.valueOf(paramTPDownloadParamData.getPreloadSize()));
      }
      if (paramTPDownloadParamData.getPreloadDuration() > 0L) {
        ((Map)localObject1).put("dl_param_preload_duration", Long.valueOf(paramTPDownloadParamData.getPreloadDuration()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getSavePath())) {
        ((Map)localObject1).put("dl_param_save_path", paramTPDownloadParamData.getSavePath());
      }
      if (paramTPDownloadParamData.getStarTimeMS() > 0) {
        ((Map)localObject1).put("dl_param_play_start_time", Integer.valueOf(paramTPDownloadParamData.getStarTimeMS()));
      }
      if (paramTPDownloadParamData.getEndTimeMS() > 0) {
        ((Map)localObject1).put("dl_param_play_end_time", Integer.valueOf(paramTPDownloadParamData.getEndTimeMS()));
      }
      if (paramTPDownloadParamData.getClipCount() > 0) {
        ((Map)localObject1).put("dl_param_play_clip_count", Integer.valueOf(paramTPDownloadParamData.getClipCount()));
      }
      if (paramTPDownloadParamData.getClipNo() > 0) {
        ((Map)localObject1).put("dl_param_play_clip_no", Integer.valueOf(paramTPDownloadParamData.getClipNo()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getBase())) {
        ((Map)localObject1).put("dl_param_vinfo_base", paramTPDownloadParamData.getBase());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getLinkVid())) {
        ((Map)localObject1).put("dl_param_vinfo_link_vid", paramTPDownloadParamData.getLinkVid());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getFileMD5())) {
        ((Map)localObject1).put("dl_param_file_md5", paramTPDownloadParamData.getFileMD5());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getM3u8())) {
        ((Map)localObject1).put("dl_param_vinfo_m3u8", paramTPDownloadParamData.getM3u8());
      }
      if (paramTPDownloadParamData.getTm() > 0L) {
        ((Map)localObject1).put("dl_param_vinfo_tm", Long.valueOf(paramTPDownloadParamData.getTm()));
      }
      if (paramTPDownloadParamData.getFp2p() > 0) {
        ((Map)localObject1).put("dl_param_vinfo_fp2p", Integer.valueOf(paramTPDownloadParamData.getFp2p()));
      }
      if (paramTPDownloadParamData.getTestid() > 0) {
        ((Map)localObject1).put("dl_param_vinfo_testid", Integer.valueOf(paramTPDownloadParamData.getTestid()));
      }
      if (paramTPDownloadParamData.getExceptDelay() > 0) {
        ((Map)localObject1).put("dl_param_expect_delay_time", Integer.valueOf(paramTPDownloadParamData.getExceptDelay()));
      }
      if (!b.isEmpty(paramTPDownloadParamData.getExtInfoMap())) {
        ((Map)localObject1).putAll(paramTPDownloadParamData.getExtInfoMap());
      }
      if (paramTPDownloadParamData.getSelfAdaption()) {
        ((Map)localObject1).put("dl_param_adaptive_type", Integer.valueOf(3));
      }
      Iterator localIterator;
      for (;;)
      {
        ((Map)localObject1).put("dl_param_format_nodes", paramTPDownloadParamData.getDefInfoList());
        if ((paramTPDownloadParamData.getPcdnUrlList() == null) || (paramTPDownloadParamData.getPcdnUrlList().isEmpty())) {
          break label1032;
        }
        localObject2 = new StringBuilder("");
        localIterator = paramTPDownloadParamData.getPcdnUrlList().iterator();
        while (localIterator.hasNext())
        {
          ((StringBuilder)localObject2).append((String)localIterator.next());
          ((StringBuilder)localObject2).append(";");
        }
        ((Map)localObject1).put("dl_param_adaptive_type", Integer.valueOf(0));
      }
      if (((StringBuilder)localObject2).length() > 0) {
        ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
      }
      g.i("TPProxyUtils", "pcdn url list: " + ((StringBuilder)localObject2).toString());
      ((Map)localObject1).put("dl_param_pcdn_urls", ((StringBuilder)localObject2).toString());
      label1032:
      if ((paramTPDownloadParamData.getPcdnVtList() != null) && (!paramTPDownloadParamData.getPcdnVtList().isEmpty()))
      {
        localObject2 = new StringBuilder("");
        localIterator = paramTPDownloadParamData.getPcdnVtList().iterator();
        while (localIterator.hasNext())
        {
          ((StringBuilder)localObject2).append(((Integer)localIterator.next()).intValue());
          ((StringBuilder)localObject2).append(";");
        }
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
        }
        ((Map)localObject1).put("dl_param_pcdn_vts", ((StringBuilder)localObject2).toString());
      }
    }
    for (paramString = new TPDownloadParam(paramString, f.art(paramTPDownloadParamData.getDlType()), (Map)localObject1);; paramString = new TPDownloadParam(paramTPDownloadParamData, 0, null))
    {
      AppMethodBeat.o(189241);
      return paramString;
      paramTPDownloadParamData = new ArrayList(1);
      paramTPDownloadParamData.add(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.e.i
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.thumbplayer.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.b.b;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.utils.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  static TPDownloadParam b(String paramString, b paramb)
  {
    AppMethodBeat.i(191965);
    Object localObject;
    if (paramb != null)
    {
      localObject = new ArrayList();
      if ((paramb.LZu == null) || (paramb.LZu.isEmpty()))
      {
        if (!TextUtils.isEmpty(paramString)) {
          ((ArrayList)localObject).add(paramString);
        }
        for (;;)
        {
          paramString = paramb.LZq;
          if ((paramString == null) || (paramString.length <= 0)) {
            break;
          }
          int i = 0;
          while (i < paramString.length)
          {
            if (!TextUtils.isEmpty(paramString[i])) {
              ((ArrayList)localObject).add(paramString[i]);
            }
            i += 1;
          }
          ((ArrayList)localObject).add(paramb.url);
        }
        paramString = (String)localObject;
        localObject = new HashMap();
        if (!a.isEmpty(paramb.LZs)) {
          ((Map)localObject).put("dl_param_url_host", paramb.LZs);
        }
        if (!a.isEmpty(paramb.LZt)) {
          ((Map)localObject).put("dl_param_url_cookie", paramb.LZt);
        }
        if (paramb.LZv > 0) {
          ((Map)localObject).put("dl_param_url_expire_time", Integer.valueOf(paramb.LZv));
        }
        if (paramb.fileSize > 0L) {
          ((Map)localObject).put("dl_param_file_size", Long.valueOf(paramb.fileSize));
        }
        if (paramb.LZw > 0L) {
          ((Map)localObject).put("dl_param_file_duration", Long.valueOf(paramb.LZw));
        }
        if (!TextUtils.isEmpty(paramb.LZr)) {
          ((Map)localObject).put("dl_param_play_keyid", paramb.LZr);
        }
        if (!TextUtils.isEmpty(paramb.hzm)) {
          ((Map)localObject).put("dl_param_vid", paramb.hzm);
        }
        if (!TextUtils.isEmpty(paramb.LZx))
        {
          ((Map)localObject).put("dl_param_play_definition", paramb.LZx);
          ((Map)localObject).put("dl_param_current_format", paramb.LZx);
        }
        if (paramb.LZy > 0) {
          ((Map)localObject).put("dl_param_current_formatid", Integer.valueOf(paramb.LZy));
        }
        if (!a.isEmpty(paramb.LZz)) {
          ((Map)localObject).put("dl_param_format_info", paramb.LZz);
        }
        ((Map)localObject).put("dl_param_source_is_charge", Boolean.valueOf(paramb.LZA));
        ((Map)localObject).put("dl_param_cache_need_encrypt", Boolean.valueOf(paramb.LZB));
        ((Map)localObject).put("dl_param_is_offline", Boolean.valueOf(paramb.LZP));
        ((Map)localObject).put("dl_param_enable_expand_donwload_url", Boolean.valueOf(paramb.LZL));
        if (paramb.LZN > 0L) {
          ((Map)localObject).put("dl_param_preload_size", Long.valueOf(paramb.LZN));
        }
        if (paramb.LZO > 0L) {
          ((Map)localObject).put("dl_param_preload_duration", Long.valueOf(paramb.LZO));
        }
        if (!TextUtils.isEmpty(paramb.savePath)) {
          ((Map)localObject).put("dl_param_save_path", paramb.savePath);
        }
        if (paramb.LZC > 0) {
          ((Map)localObject).put("dl_param_play_start_time", Integer.valueOf(paramb.LZC));
        }
        if (paramb.LZD > 0) {
          ((Map)localObject).put("dl_param_play_end_time", Integer.valueOf(paramb.LZD));
        }
        if (paramb.LZE > 0) {
          ((Map)localObject).put("dl_param_play_clip_count", Integer.valueOf(paramb.LZE));
        }
        if (paramb.LZF > 0) {
          ((Map)localObject).put("dl_param_play_clip_no", Integer.valueOf(paramb.LZF));
        }
        if (!TextUtils.isEmpty(paramb.LZG)) {
          ((Map)localObject).put("dl_param_vinfo_base", paramb.LZG);
        }
        if (!TextUtils.isEmpty(paramb.LZH)) {
          ((Map)localObject).put("dl_param_vinfo_link_vid", paramb.LZH);
        }
        if (!TextUtils.isEmpty(paramb.rJV)) {
          ((Map)localObject).put("dl_param_file_md5", paramb.rJV);
        }
        if (!TextUtils.isEmpty(paramb.LZI)) {
          ((Map)localObject).put("dl_param_vinfo_m3u8", paramb.LZI);
        }
        if (paramb.LZJ > 0L) {
          ((Map)localObject).put("dl_param_vinfo_tm", Long.valueOf(paramb.LZJ));
        }
        if (paramb.LZK > 0) {
          ((Map)localObject).put("dl_param_vinfo_fp2p", Integer.valueOf(paramb.LZK));
        }
        if (paramb.LZM > 0) {
          ((Map)localObject).put("dl_param_vinfo_testid", Integer.valueOf(paramb.LZM));
        }
        if (!a.isEmpty(paramb.extInfoMap)) {
          ((Map)localObject).putAll(paramb.extInfoMap);
        }
        if (!paramb.LZQ) {
          break label839;
        }
        ((Map)localObject).put("dl_param_adaptive_type", Integer.valueOf(3));
        label794:
        ((Map)localObject).put("dl_param_format_nodes", paramb.LZR);
      }
    }
    for (paramString = new TPDownloadParam(paramString, e.ahq(paramb.dlType), (Map)localObject);; paramString = new TPDownloadParam(paramb, 0, null))
    {
      AppMethodBeat.o(191965);
      return paramString;
      paramString = paramb.LZu;
      break;
      label839:
      ((Map)localObject).put("dl_param_adaptive_type", Integer.valueOf(0));
      break label794;
      paramb = new ArrayList(1);
      paramb.add(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.h
 * JD-Core Version:    0.7.0.1
 */
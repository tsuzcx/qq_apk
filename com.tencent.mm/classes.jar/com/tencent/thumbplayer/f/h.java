package com.tencent.thumbplayer.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  static TPDownloadParam b(String paramString, com.tencent.thumbplayer.b.b.b paramb)
  {
    AppMethodBeat.i(187944);
    Object localObject;
    if (paramb != null)
    {
      localObject = new ArrayList();
      if ((paramb.KfA == null) || (paramb.KfA.isEmpty()))
      {
        if (!TextUtils.isEmpty(paramString)) {
          ((ArrayList)localObject).add(paramString);
        }
        for (;;)
        {
          paramString = paramb.Kfw;
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
        if (!com.tencent.thumbplayer.utils.b.isEmpty(paramb.Kfy)) {
          ((Map)localObject).put("dl_param_url_host", paramb.Kfy);
        }
        if (!com.tencent.thumbplayer.utils.b.isEmpty(paramb.Kfz)) {
          ((Map)localObject).put("dl_param_url_cookie", paramb.Kfz);
        }
        if (paramb.KfB > 0) {
          ((Map)localObject).put("dl_param_url_expire_time", Integer.valueOf(paramb.KfB));
        }
        if (paramb.fileSize > 0L) {
          ((Map)localObject).put("dl_param_file_size", Long.valueOf(paramb.fileSize));
        }
        if (paramb.KfC > 0L) {
          ((Map)localObject).put("dl_param_file_duration", Long.valueOf(paramb.KfC));
        }
        if (!TextUtils.isEmpty(paramb.Kfx)) {
          ((Map)localObject).put("dl_param_play_keyid", paramb.Kfx);
        }
        if (!TextUtils.isEmpty(paramb.hhd)) {
          ((Map)localObject).put("dl_param_vid", paramb.hhd);
        }
        if (!TextUtils.isEmpty(paramb.KfD))
        {
          ((Map)localObject).put("dl_param_play_definition", paramb.KfD);
          ((Map)localObject).put("dl_param_current_format", paramb.KfD);
        }
        if (paramb.KfE > 0) {
          ((Map)localObject).put("dl_param_current_formatid", Integer.valueOf(paramb.KfE));
        }
        if (!com.tencent.thumbplayer.utils.b.isEmpty(paramb.KfF)) {
          ((Map)localObject).put("dl_param_format_info", paramb.KfF);
        }
        ((Map)localObject).put("dl_param_source_is_charge", Boolean.valueOf(paramb.KfG));
        ((Map)localObject).put("dl_param_cache_need_encrypt", Boolean.valueOf(paramb.KfH));
        ((Map)localObject).put("dl_param_is_offline", Boolean.valueOf(paramb.KfV));
        ((Map)localObject).put("dl_param_enable_expand_donwload_url", Boolean.valueOf(paramb.KfR));
        if (paramb.KfT > 0L) {
          ((Map)localObject).put("dl_param_preload_size", Long.valueOf(paramb.KfT));
        }
        if (paramb.KfU > 0L) {
          ((Map)localObject).put("dl_param_preload_duration", Long.valueOf(paramb.KfU));
        }
        if (!TextUtils.isEmpty(paramb.savePath)) {
          ((Map)localObject).put("dl_param_save_path", paramb.savePath);
        }
        if (paramb.KfI > 0) {
          ((Map)localObject).put("dl_param_play_start_time", Integer.valueOf(paramb.KfI));
        }
        if (paramb.KfJ > 0) {
          ((Map)localObject).put("dl_param_play_end_time", Integer.valueOf(paramb.KfJ));
        }
        if (paramb.KfK > 0) {
          ((Map)localObject).put("dl_param_play_clip_count", Integer.valueOf(paramb.KfK));
        }
        if (paramb.KfL > 0) {
          ((Map)localObject).put("dl_param_play_clip_no", Integer.valueOf(paramb.KfL));
        }
        if (!TextUtils.isEmpty(paramb.KfM)) {
          ((Map)localObject).put("dl_param_vinfo_base", paramb.KfM);
        }
        if (!TextUtils.isEmpty(paramb.KfN)) {
          ((Map)localObject).put("dl_param_vinfo_link_vid", paramb.KfN);
        }
        if (!TextUtils.isEmpty(paramb.qYF)) {
          ((Map)localObject).put("dl_param_file_md5", paramb.qYF);
        }
        if (!TextUtils.isEmpty(paramb.KfO)) {
          ((Map)localObject).put("dl_param_vinfo_m3u8", paramb.KfO);
        }
        if (paramb.KfP > 0L) {
          ((Map)localObject).put("dl_param_vinfo_tm", Long.valueOf(paramb.KfP));
        }
        if (paramb.KfQ > 0) {
          ((Map)localObject).put("dl_param_vinfo_fp2p", Integer.valueOf(paramb.KfQ));
        }
        if (paramb.KfS > 0) {
          ((Map)localObject).put("dl_param_vinfo_testid", Integer.valueOf(paramb.KfS));
        }
        if (!com.tencent.thumbplayer.utils.b.isEmpty(paramb.extInfoMap)) {
          ((Map)localObject).putAll(paramb.extInfoMap);
        }
        if (!paramb.KfW) {
          break label839;
        }
        ((Map)localObject).put("dl_param_adaptive_type", Integer.valueOf(3));
        label794:
        ((Map)localObject).put("dl_param_format_nodes", paramb.KfX);
      }
    }
    for (paramString = new TPDownloadParam(paramString, e.aeQ(paramb.dlType), (Map)localObject);; paramString = new TPDownloadParam(paramb, 0, null))
    {
      AppMethodBeat.o(187944);
      return paramString;
      paramString = paramb.KfA;
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
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
    AppMethodBeat.i(194643);
    Object localObject;
    if (paramb != null)
    {
      localObject = new ArrayList();
      if ((paramb.Mwp == null) || (paramb.Mwp.isEmpty()))
      {
        if (!TextUtils.isEmpty(paramString)) {
          ((ArrayList)localObject).add(paramString);
        }
        for (;;)
        {
          paramString = paramb.Mwl;
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
        if (!a.isEmpty(paramb.Mwn)) {
          ((Map)localObject).put("dl_param_url_host", paramb.Mwn);
        }
        if (!a.isEmpty(paramb.Mwo)) {
          ((Map)localObject).put("dl_param_url_cookie", paramb.Mwo);
        }
        if (paramb.Mwq > 0) {
          ((Map)localObject).put("dl_param_url_expire_time", Integer.valueOf(paramb.Mwq));
        }
        if (paramb.fileSize > 0L) {
          ((Map)localObject).put("dl_param_file_size", Long.valueOf(paramb.fileSize));
        }
        if (paramb.Mwr > 0L) {
          ((Map)localObject).put("dl_param_file_duration", Long.valueOf(paramb.Mwr));
        }
        if (!TextUtils.isEmpty(paramb.Mwm)) {
          ((Map)localObject).put("dl_param_play_keyid", paramb.Mwm);
        }
        if (!TextUtils.isEmpty(paramb.hCa)) {
          ((Map)localObject).put("dl_param_vid", paramb.hCa);
        }
        if (!TextUtils.isEmpty(paramb.Mws))
        {
          ((Map)localObject).put("dl_param_play_definition", paramb.Mws);
          ((Map)localObject).put("dl_param_current_format", paramb.Mws);
        }
        if (paramb.Mwt > 0) {
          ((Map)localObject).put("dl_param_current_formatid", Integer.valueOf(paramb.Mwt));
        }
        if (!a.isEmpty(paramb.Mwu)) {
          ((Map)localObject).put("dl_param_format_info", paramb.Mwu);
        }
        ((Map)localObject).put("dl_param_source_is_charge", Boolean.valueOf(paramb.Mwv));
        ((Map)localObject).put("dl_param_cache_need_encrypt", Boolean.valueOf(paramb.Mww));
        ((Map)localObject).put("dl_param_is_offline", Boolean.valueOf(paramb.MwK));
        ((Map)localObject).put("dl_param_enable_expand_donwload_url", Boolean.valueOf(paramb.MwG));
        if (paramb.MwI > 0L) {
          ((Map)localObject).put("dl_param_preload_size", Long.valueOf(paramb.MwI));
        }
        if (paramb.MwJ > 0L) {
          ((Map)localObject).put("dl_param_preload_duration", Long.valueOf(paramb.MwJ));
        }
        if (!TextUtils.isEmpty(paramb.savePath)) {
          ((Map)localObject).put("dl_param_save_path", paramb.savePath);
        }
        if (paramb.Mwx > 0) {
          ((Map)localObject).put("dl_param_play_start_time", Integer.valueOf(paramb.Mwx));
        }
        if (paramb.Mwy > 0) {
          ((Map)localObject).put("dl_param_play_end_time", Integer.valueOf(paramb.Mwy));
        }
        if (paramb.Mwz > 0) {
          ((Map)localObject).put("dl_param_play_clip_count", Integer.valueOf(paramb.Mwz));
        }
        if (paramb.MwA > 0) {
          ((Map)localObject).put("dl_param_play_clip_no", Integer.valueOf(paramb.MwA));
        }
        if (!TextUtils.isEmpty(paramb.MwB)) {
          ((Map)localObject).put("dl_param_vinfo_base", paramb.MwB);
        }
        if (!TextUtils.isEmpty(paramb.MwC)) {
          ((Map)localObject).put("dl_param_vinfo_link_vid", paramb.MwC);
        }
        if (!TextUtils.isEmpty(paramb.rSj)) {
          ((Map)localObject).put("dl_param_file_md5", paramb.rSj);
        }
        if (!TextUtils.isEmpty(paramb.MwD)) {
          ((Map)localObject).put("dl_param_vinfo_m3u8", paramb.MwD);
        }
        if (paramb.MwE > 0L) {
          ((Map)localObject).put("dl_param_vinfo_tm", Long.valueOf(paramb.MwE));
        }
        if (paramb.MwF > 0) {
          ((Map)localObject).put("dl_param_vinfo_fp2p", Integer.valueOf(paramb.MwF));
        }
        if (paramb.MwH > 0) {
          ((Map)localObject).put("dl_param_vinfo_testid", Integer.valueOf(paramb.MwH));
        }
        if (!a.isEmpty(paramb.extInfoMap)) {
          ((Map)localObject).putAll(paramb.extInfoMap);
        }
        if (!paramb.MwL) {
          break label839;
        }
        ((Map)localObject).put("dl_param_adaptive_type", Integer.valueOf(3));
        label794:
        ((Map)localObject).put("dl_param_format_nodes", paramb.MwM);
      }
    }
    for (paramString = new TPDownloadParam(paramString, e.ahZ(paramb.dlType), (Map)localObject);; paramString = new TPDownloadParam(paramb, 0, null))
    {
      AppMethodBeat.o(194643);
      return paramString;
      paramString = paramb.Mwp;
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
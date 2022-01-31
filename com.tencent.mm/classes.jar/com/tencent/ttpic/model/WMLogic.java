package com.tencent.ttpic.model;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.util.g;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WMLogic
{
  private static final String TAG = WMLogic.class.getSimpleName();
  private static final String TYPE_CASE = "case";
  public static final String TYPE_COUNTDOWN = "countdown";
  private static final String TYPE_RANGE = "range";
  public static final String TYPE_SINCE = "since";
  public String compare;
  public String data;
  public List<WMLogicPair> range;
  public String type;
  public List<WMLogicPair> wmcase;
  
  public String getValue(String paramString)
  {
    Object localObject1 = "";
    Object localObject2;
    if (this.type.equals("case"))
    {
      paramString = LogicDataManager.getInstance().getValue(this.data);
      Iterator localIterator = this.wmcase.iterator();
      do
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WMLogicPair)localIterator.next();
      } while (!((WMLogicPair)localObject2).key.equals(paramString));
      localObject2 = ((WMLogicPair)localObject2).value;
    }
    int i;
    for (;;)
    {
      return localObject2;
      if (this.type.equals("range")) {
        try
        {
          paramString = LogicDataManager.getInstance().getValue(this.data);
          i = this.range.size() - 1;
          for (;;)
          {
            localObject2 = localObject1;
            if (i < 0) {
              break;
            }
            if ((Integer.parseInt(paramString) >= Integer.parseInt(((WMLogicPair)this.range.get(i)).key)) || (i == 0))
            {
              paramString = ((WMLogicPair)this.range.get(i)).value;
              return paramString;
            }
            i -= 1;
          }
          if (!this.type.equals("since")) {
            break label348;
          }
        }
        catch (NumberFormatException paramString)
        {
          g.i(TAG, paramString.getMessage());
          return "";
        }
      }
    }
    localObject1 = new SimpleDateFormat("yyyy-MM-dd");
    label230:
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      j = VideoUtil.daysBetween(paramString, ((SimpleDateFormat)localObject1).format(new Date()));
      i = 0;
      label249:
      if (i >= this.range.size()) {
        break label503;
      }
      if ((j > Integer.parseInt(((WMLogicPair)this.range.get(i)).key)) && (i != this.range.size() - 1)) {
        break label341;
      }
    }
    label341:
    label348:
    label503:
    for (paramString = ((WMLogicPair)this.range.get(i)).value;; paramString = "")
    {
      return String.format(paramString, new Object[] { Integer.valueOf(j) });
      paramString = this.compare;
      break label230;
      i += 1;
      break label249;
      localObject2 = localObject1;
      if (!this.type.equals("countdown")) {
        break;
      }
      localObject2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      if (!TextUtils.isEmpty(paramString))
      {
        j = VideoUtil.daysBetween((String)localObject2, paramString);
        i = 0;
      }
      for (;;)
      {
        paramString = (String)localObject1;
        if (i < this.range.size())
        {
          if ((j <= Integer.parseInt(((WMLogicPair)this.range.get(i)).key)) || (i == this.range.size() - 1)) {
            paramString = ((WMLogicPair)this.range.get(i)).value;
          }
        }
        else
        {
          return String.format(paramString, new Object[] { Integer.valueOf(j) });
          paramString = this.compare;
          break;
        }
        i += 1;
      }
    }
  }
  
  public void setCompare(String paramString1, String paramString2)
  {
    if (this.type.equals("since"))
    {
      paramString2 = VideoPrefsUtil.getDefaultPrefs().getString("prefs_key_watermark_since_" + paramString2, "");
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString2;
      }
      this.compare = paramString1;
      return;
    }
    if (this.type.equals("countdown"))
    {
      paramString2 = VideoPrefsUtil.getDefaultPrefs().getString("prefs_key_watermark_countdown_" + paramString2, "");
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString2;
      }
      this.compare = paramString1;
      return;
    }
    this.compare = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.model.WMLogic
 * JD-Core Version:    0.7.0.1
 */
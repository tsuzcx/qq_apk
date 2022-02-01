package com.tencent.mm.plugin.sport.model;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.sdk.platformtools.bt;

public class SportDataProvider
  extends ContentProvider
{
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(149326);
    if (!bt.isNullOrNil(paramString1)) {}
    for (;;)
    {
      try
      {
        int j = paramString1.hashCode();
        switch (j)
        {
        default: 
          i = -1;
          switch (i)
          {
          }
          break;
        }
      }
      catch (Exception paramUri)
      {
        long l1;
        long l2;
        continue;
      }
      AppMethodBeat.o(149326);
      return null;
      if (paramString1.equals("getTodayStepCount"))
      {
        continue;
        if (paramString1.equals("clearConfig"))
        {
          i = 1;
          continue;
          if (paramString1.equals("updateConfig"))
          {
            i = 2;
            continue;
            if (paramString1.equals("updateStep"))
            {
              i = 3;
              continue;
              if (paramString1.equals("Key_mmSensorChange"))
              {
                i = 4;
                continue;
                paramUri = new Bundle();
                paramUri.putLong("TodayStep", g.dFv());
                paramUri.putLong("TodaySaveTime", g.dFw());
                paramUri = new i(new String[] { "Step" }, paramUri);
                AppMethodBeat.o(149326);
                return paramUri;
                if (com.tencent.mm.kernel.g.ad(PluginSport.class) != null)
                {
                  ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getSportFileStorage().reset();
                  continue;
                  if (com.tencent.mm.kernel.g.ad(PluginSport.class) != null)
                  {
                    h.aqZ(paramArrayOfString2[0]);
                    ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getPushSportStepDetector().dFs();
                    continue;
                    if (com.tencent.mm.kernel.g.ad(PluginSport.class) != null)
                    {
                      ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getPushSportStepDetector().dFs();
                      continue;
                      if (com.tencent.mm.kernel.g.ad(PluginSport.class) != null)
                      {
                        l1 = Long.valueOf(paramArrayOfString2[0]).longValue();
                        l2 = Long.valueOf(paramArrayOfString2[1]).longValue();
                        ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getPushSportStepDetector().b(l1, l2, "MM");
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.SportDataProvider
 * JD-Core Version:    0.7.0.1
 */
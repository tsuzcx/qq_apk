package com.tencent.mm.q;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.StatFs;
import android.preference.PreferenceManager;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class a
{
  public static int dBi = -1;
  public static final long[] dBj = { 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L };
  public static final long[] dBk = { 104857600L, 314572800L, 524288000L, 1073741824L, 1073741824L };
  
  public static int Bu()
  {
    double d = 0.0D;
    try
    {
      localStatFs = new StatFs(h.getDataDirectory().getPath());
      l1 = localStatFs.getAvailableBlocks();
      i = localStatFs.getBlockSize();
      l1 *= i;
    }
    catch (Exception localException1)
    {
      long l1;
      long l3;
      for (;;)
      {
        StatFs localStatFs;
        label95:
        l1 = 0L;
        y.e("MicroMsg.DbChecker", "get db spare space error");
        long l2 = 0L;
        l3 = 0L;
      }
      if (dBi < 0)
      {
        dBi = dBj.length - 1;
        i = 0;
      }
      for (;;)
      {
        if (i < dBj.length)
        {
          if (l3 < dBj[i]) {
            dBi = i;
          }
        }
        else
        {
          if (l1 >= dBk[dBi]) {
            break label244;
          }
          i = 1;
          break;
        }
        i += 1;
      }
    }
    try
    {
      l3 = localStatFs.getBlockCount() * localStatFs.getBlockSize();
      l2 = localStatFs.getFreeBlocks();
      i = localStatFs.getBlockSize();
      l2 *= i;
      d = l1 / l3;
      if (l3 <= 0L) {
        break label244;
      }
      if (l1 >= 52428800L) {
        break label175;
      }
      i = 2;
    }
    catch (Exception localException2)
    {
      break label159;
      i = 0;
      break label95;
    }
    y.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Double.valueOf(d), Integer.valueOf(dBi) });
    return i;
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("db_check_tip_time", paramLong).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.q.a
 * JD-Core Version:    0.7.0.1
 */
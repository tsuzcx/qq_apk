package com.tencent.mm.q;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.StatFs;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

public final class a
{
  public static int euJ = -1;
  public static final long[] euK = { 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L };
  public static final long[] euL = { 104857600L, 314572800L, 524288000L, 1073741824L, 1073741824L };
  
  public static int Oj()
  {
    AppMethodBeat.i(77693);
    long l2 = 0L;
    long l4 = 0L;
    double d = 0.0D;
    l1 = l2;
    try
    {
      StatFs localStatFs = new StatFs(h.getDataDirectory().getPath());
      l1 = l2;
      l3 = localStatFs.getAvailableBlocks();
      l1 = l2;
      l2 = localStatFs.getBlockSize() * l3;
      l1 = l2;
      l3 = localStatFs.getBlockCount() * localStatFs.getBlockSize();
      l1 = l2;
      long l5 = localStatFs.getFreeBlocks();
      l1 = l2;
      i = localStatFs.getBlockSize();
      l4 = l5 * i;
      d = l2 / l3;
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l3 = 0L;
        ab.e("MicroMsg.DbChecker", "get db spare space error");
        continue;
        if (euJ < 0)
        {
          euJ = euK.length - 1;
          i = 0;
        }
        for (;;)
        {
          if (i < euK.length)
          {
            if (l3 < euK[i]) {
              euJ = i;
            }
          }
          else
          {
            if (l1 >= euL[euJ]) {
              break label273;
            }
            i = 1;
            break;
          }
          i += 1;
        }
        int i = 0;
      }
    }
    if (l3 > 0L) {
      if (l1 < 52428800L)
      {
        i = 2;
        ab.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Double.valueOf(d), Integer.valueOf(euJ) });
        AppMethodBeat.o(77693);
        return i;
      }
    }
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(77694);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("db_check_tip_time", paramLong).commit();
    AppMethodBeat.o(77694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.q.a
 * JD-Core Version:    0.7.0.1
 */
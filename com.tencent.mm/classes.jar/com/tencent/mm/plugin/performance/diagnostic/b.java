package com.tencent.mm.plugin.performance.diagnostic;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.backtrace.d;
import com.tencent.matrix.backtrace.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class b
  implements d
{
  private static final ArrayList<IDKey> MIr;
  private static boolean MIs;
  
  static
  {
    AppMethodBeat.i(300891);
    MIr = new ArrayList();
    MIs = false;
    AppMethodBeat.o(300891);
  }
  
  static void setup()
  {
    AppMethodBeat.i(300878);
    com.tencent.mm.kernel.h.baF().a(new g()
    {
      public final void aDv()
      {
        AppMethodBeat.i(300851);
        com.tencent.mm.kernel.h.baF().b(this);
        synchronized (b.gyd())
        {
          b.bDd();
          com.tencent.mm.plugin.report.service.h.OAn.b(b.gyd(), false);
          b.gyd().clear();
          AppMethodBeat.o(300851);
          return;
        }
      }
      
      public final void dZ(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(300878);
  }
  
  public final void a(d.a arg1, Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(300904);
    switch (2.MIt[???.ordinal()])
    {
    }
    label389:
    label541:
    for (;;)
    {
      i = -1;
      label54:
      if (i >= 0)
      {
        paramVarArgs = new ArrayList();
        if ((i >= 10) && (i < 20))
        {
          paramVarArgs.add(new IDKey(1593, 10, 1));
          label96:
          paramVarArgs.add(new IDKey(1593, i, 1));
        }
        synchronized (MIr)
        {
          if (MIs)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(paramVarArgs, false);
            AppMethodBeat.o(300904);
            return;
            i = 1;
            break label54;
            i = 2;
            break label54;
            if ((paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof Long))) {}
            for (long l1 = ((Long)paramVarArgs[0]).longValue();; l1 = -1L)
            {
              if ((l1 < 0L) || (l1 >= 10000L)) {
                break label207;
              }
              i = 11;
              break;
            }
            label207:
            if ((l1 >= 10000L) && (l1 < 30000L))
            {
              i = 12;
              break label54;
            }
            if ((l1 >= 30000L) && (l1 < 60000L))
            {
              i = 13;
              break label54;
            }
            if ((l1 >= 60000L) && (l1 < 120000L))
            {
              i = 14;
              break label54;
            }
            if ((l1 >= 120000L) && (l1 < 300000L))
            {
              i = 15;
              break label54;
            }
            if ((l1 >= 300000L) && (l1 < 600000L))
            {
              i = 16;
              break label54;
            }
            i = 17;
            break label54;
            if ((paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof Long))) {}
            for (l1 = ((Long)paramVarArgs[0]).longValue();; l1 = -1L)
            {
              if ((l1 < 0L) || (l1 >= 10000L)) {
                break label389;
              }
              i = 21;
              break;
            }
            if ((l1 >= 10000L) && (l1 < 30000L))
            {
              i = 22;
              break label54;
            }
            if ((l1 >= 30000L) && (l1 < 60000L))
            {
              i = 23;
              break label54;
            }
            if ((l1 >= 60000L) && (l1 < 120000L))
            {
              i = 24;
              break label54;
            }
            if ((l1 >= 120000L) && (l1 < 300000L))
            {
              i = 25;
              break label54;
            }
            if ((l1 >= 300000L) && (l1 < 600000L))
            {
              i = 26;
              break label54;
            }
            i = 27;
            break label54;
            if ((paramVarArgs.length == 2) && ((paramVarArgs[0] instanceof Long)))
            {
              l1 = ((Long)paramVarArgs[0]).longValue();
              if ((paramVarArgs.length != 2) || (!(paramVarArgs[1] instanceof Long))) {
                break label618;
              }
            }
            label618:
            for (long l2 = ((Long)paramVarArgs[1]).longValue();; l2 = -1L)
            {
              Log.i("MicroMsg.BacktraceReporter", "WeChat backtrace disk usage: file count(%s), file size(%s)");
              if ((l1 < 0L) || (l2 < 0L)) {
                break;
              }
              if ((l2 < 0L) || (l2 >= 524288L)) {
                break label626;
              }
              i = 61;
              break label54;
              l1 = -1L;
              break label541;
            }
            label626:
            if ((l2 >= 524288L) && (l2 < 2097152L))
            {
              i = 62;
              break label54;
            }
            if ((l2 >= 2097152L) && (l2 < 10485760L))
            {
              i = 63;
              break label54;
            }
            if ((l2 >= 10485760L) && (l2 < 52428800L))
            {
              i = 64;
              break label54;
            }
            if ((l2 >= 52428800L) && (l2 < 209715200L))
            {
              i = 65;
              break label54;
            }
            i = 66;
            break label54;
            if ((i >= 20) && (i < 30))
            {
              paramVarArgs.add(new IDKey(1593, 20, 1));
              break label96;
            }
            if ((i < 60) || (i >= 70)) {
              break label96;
            }
            paramVarArgs.add(new IDKey(1593, 60, 1));
            break label96;
          }
          MIr.addAll(paramVarArgs);
        }
      }
    }
    AppMethodBeat.o(300904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.b
 * JD-Core Version:    0.7.0.1
 */
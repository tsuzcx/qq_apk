package com.tencent.mm.plugin.profile.ui.tab.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public class BizProfileExtraOperateObserver
  extends BaseBizProfileOperateObserver
{
  private static String HdC = "crashFlag";
  private static boolean HdD = false;
  
  public final boolean a(f paramf, as paramas)
  {
    boolean bool2 = false;
    AppMethodBeat.i(291241);
    if (paramas != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      bool1 = bool2;
      if (paramf != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      AppMethodBeat.o(291241);
      return true;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileExtraOperateObserver
 * JD-Core Version:    0.7.0.1
 */
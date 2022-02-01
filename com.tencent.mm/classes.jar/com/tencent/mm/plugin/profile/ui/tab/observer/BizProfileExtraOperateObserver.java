package com.tencent.mm.plugin.profile.ui.tab.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public class BizProfileExtraOperateObserver
  extends BaseBizProfileOperateObserver
{
  private static boolean NdK = false;
  private static String NdL = "crashFlag";
  
  public final boolean a(f paramf, au paramau)
  {
    boolean bool2 = false;
    AppMethodBeat.i(306198);
    if (paramau != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (Util.nullAsNil(paramau.field_username).length() <= 0) {
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
      AppMethodBeat.o(306198);
      return true;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileExtraOperateObserver
 * JD-Core Version:    0.7.0.1
 */
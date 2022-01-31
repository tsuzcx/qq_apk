package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class a
  implements b
{
  public final String chj()
  {
    return ac.Ru("discoverRecommendEntry").optString("labIcon");
  }
  
  public final String chk()
  {
    String str2 = ac.Ru("discoverRecommendEntry").optString("wording");
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = ae.getContext().getString(R.l.find_friends_look);
    }
    return str1;
  }
  
  public final void f(Activity paramActivity, String paramString)
  {
    if (!aa.Br(0))
    {
      y.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
      return;
    }
    paramString = ac.Ru("discoverRecommendEntry").optString("wording");
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
      return;
    }
    ((m)g.r(m.class)).a(ae.getContext(), new a.1(this, paramString, paramActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b.a
 * JD-Core Version:    0.7.0.1
 */
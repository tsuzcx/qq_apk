package com.tinkerboots.sdk.a.a;

import android.content.Context;
import com.tinkerboots.sdk.b.c;
import java.util.Map;

public class a
  implements b
{
  public void C(Map<String, String> paramMap) {}
  
  public boolean bbk()
  {
    Context localContext = com.tinkerboots.sdk.b.b.getContext();
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.hN(localContext);
    if (!com.tinkerboots.sdk.b.a.isConnected(localContext))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, not connect to internet", new Object[0]);
      return false;
    }
    if (com.tencent.tinker.lib.f.b.hP(localContext))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, tinker service is running", new Object[0]);
      return false;
    }
    if (!locala.prD)
    {
      com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, only request on the main process", new Object[0]);
      return false;
    }
    if (c.cUb())
    {
      com.tencent.tinker.lib.f.a.e("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, is in ignore channel, current channel:%s", new Object[] { c.cUa() });
      return false;
    }
    return true;
  }
  
  public void bbl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tinkerboots.sdk.a.a.a
 * JD-Core Version:    0.7.0.1
 */
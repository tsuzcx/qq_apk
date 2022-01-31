package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONArray;
import org.json.JSONObject;

final class n$1$1
  implements Runnable
{
  n$1$1(n.1 param1, j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(1756);
    try
    {
      JSONArray localJSONArray = new JSONObject(this.tjB.cID().wAa).optJSONArray("data");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        al.d(new n.1.1.1(this, n.b(this.tjC.tjA.thM.cJn(), localJSONArray)));
        AppMethodBeat.o(1756);
        return;
      }
      ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=json data error");
      AppMethodBeat.o(1756);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=" + localException.getMessage());
      AppMethodBeat.o(1756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.1.1
 * JD-Core Version:    0.7.0.1
 */
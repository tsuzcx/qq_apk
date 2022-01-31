package com.tencent.mm.plugin.topstory.ui.video;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.in;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import org.json.JSONException;
import org.json.JSONObject;

final class TopStoryBaseVideoUI$7
  implements com.tencent.mm.ai.f
{
  TopStoryBaseVideoUI$7(TopStoryBaseVideoUI paramTopStoryBaseVideoUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final m paramm)
  {
    AppMethodBeat.i(1726);
    paramm = (i)paramm;
    Object localObject = (cks)paramm.rr.fsV.fta;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      t.makeText(this.tiT.getContext(), this.tiT.getString(2131304339), 0).show();
      if (paramm.tfm != null)
      {
        paramString = paramm.tfm;
        if (paramm.tfm.xVp) {
          break label175;
        }
      }
      label175:
      for (bool = true;; bool = false)
      {
        paramString.xVp = bool;
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + paramm.tfm.xVp);
        this.tiT.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(1725);
            h localh = TopStoryBaseVideoUI.7.this.tiT.cJm().b(paramm.tfm);
            if (localh != null)
            {
              if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.list.h))
              {
                localh.cJL();
                AppMethodBeat.o(1725);
                return;
              }
              if ((localh instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
                ((com.tencent.mm.plugin.topstory.ui.video.fs.f)localh.cJM().getControlBar()).i(paramm.tfm);
              }
            }
            AppMethodBeat.o(1725);
          }
        });
        AppMethodBeat.o(1726);
        return;
      }
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("docId", ((cks)localObject).xHJ);
      localJSONObject.put("opType", "LIKE");
      if (((cks)localObject).nrS != 4) {
        break label476;
      }
      bool = true;
      label225:
      localJSONObject.put("isLike", bool);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        continue;
        paramString = null;
      }
    }
    if (paramm.tfm != null)
    {
      paramString = paramm.tfm;
      if (((cks)localObject).nrS != 4) {
        break label482;
      }
    }
    label476:
    label482:
    for (boolean bool = true;; bool = false)
    {
      paramString.xVp = bool;
      ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb:" + paramm.tfm.xVp);
      if (((cks)localObject).nrS != 4) {
        break label488;
      }
      localObject = this.tiT.cJm().b(paramm.tfm);
      if ((TopStoryBaseVideoUI.c(this.tiT).tjR == null) || (TopStoryBaseVideoUI.c(this.tiT).tjR.xVa == null) || (!TopStoryBaseVideoUI.c(this.tiT).tjR.xVa.equals(paramm.tfm.xVa)) || ((!(localObject instanceof com.tencent.mm.plugin.topstory.ui.video.list.h)) && (!(localObject instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)))) {
        break label559;
      }
      paramString = ((h)localObject).getWowView();
      if (paramString != null)
      {
        this.tiT.a(paramm.tfm, paramString, true);
        if ((localObject instanceof com.tencent.mm.plugin.topstory.ui.video.fs.g)) {
          ((h)localObject).cJM().getControlBar().show();
        }
      }
      paramString = new in();
      paramString.cxU.cxV = localJSONObject.toString();
      paramString.cxU.cxW = "";
      a.ymk.l(paramString);
      break;
      bool = false;
      break label225;
    }
    label488:
    if (paramm.cIG().xUG) {
      com.tencent.mm.ui.base.h.b(this.tiT, this.tiT.getString(2131304365), "", true);
    }
    for (;;)
    {
      this.tiT.a(paramm.tfm, null, false);
      break;
      t.makeText(this.tiT.getContext(), 2131304366, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.7
 * JD-Core Version:    0.7.0.1
 */
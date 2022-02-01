package com.tencent.mm.plugin.webview.ui.tools.media;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.jl;
import com.tencent.mm.message.m;
import com.tencent.mm.message.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "", "()V", "_realPlayTime", "", "get_realPlayTime", "()J", "set_realPlayTime", "(J)V", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "isFans", "", "()Z", "setFans", "(Z)V", "lastOpType", "playErrType", "", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "playStatus", "getPlayStatus", "setPlayStatus", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "scene", "getScene", "setScene", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "subScene", "getSubScene", "setSubScene", "doPlayReport", "", "doStopReport", "getPlayType", "report17149", "videoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "opType", "enterId", "itemShowType", "Companion", "KV17149OpType", "PlayStatus", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g
{
  private static final String TAG;
  public static final g.a Xms;
  protected int AcJ;
  private long Fta;
  protected int Xmt;
  protected int Xmu;
  public String Xmv;
  protected boolean Xmw;
  private int Xmx;
  public int oYt;
  private long ork;
  protected int scene;
  
  static
  {
    AppMethodBeat.i(82685);
    Xms = new g.a((byte)0);
    TAG = "MicroMsg.MpVideoShareReport";
    AppMethodBeat.o(82685);
  }
  
  public g()
  {
    AppMethodBeat.i(82684);
    this.ork = System.currentTimeMillis();
    this.Xmv = "";
    AppMethodBeat.o(82684);
  }
  
  public final void a(y paramy, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82683);
    if (paramy == null)
    {
      AppMethodBeat.o(82683);
      return;
    }
    if (this.Xmx == paramInt1)
    {
      AppMethodBeat.o(82683);
      return;
    }
    this.Xmx = paramInt1;
    if (paramy.nVr == -1L) {}
    try
    {
      Object localObject = Uri.parse(paramy.YMm);
      paramy.nVr = Util.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
      paramy.idx = Util.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
      switch (paramInt1)
      {
      case 5: 
      case 6: 
      default: 
        switch (paramInt1)
        {
        default: 
          int j = m.aPK();
          int i = j;
          if (j == 100) {
            i = -1;
          }
          localObject = new jl();
          ((jl)localObject).iSX = ((jl)localObject).F("BizUserName", paramy.hEE, true);
          ((jl)localObject).iTb = paramInt1;
          ((jl)localObject).iTa = ((jl)localObject).F("VideoId", paramy.YMn, true);
          ((jl)localObject).irp = i;
          ((jl)localObject).imP = paramy.nVr;
          ((jl)localObject).iSY = paramy.idx;
          ((jl)localObject).iSZ = paramInt2;
          ((jl)localObject).iCW = paramy.videoDuration;
          ((jl)localObject).iqr = this.scene;
          ((jl)localObject).iTe = this.AcJ;
          ((jl)localObject).iRw = paramy.width;
          ((jl)localObject).iTi = paramy.height;
          ((jl)localObject).iTB = 101L;
          if ((this.Fta == 0L) && (this.ork != 0L)) {
            this.Fta = (System.currentTimeMillis() - this.ork);
          }
          ((jl)localObject).iMm = this.Fta;
          ((jl)localObject).iTd = this.Xmu;
          ((jl)localObject).iGQ = (System.currentTimeMillis() / 1000L);
          ((jl)localObject).iTc = this.Xmt;
          ((jl)localObject).iTf = ((jl)localObject).F("PlayErrType", this.Xmv, true);
          ((jl)localObject).iTm = 2L;
          if (this.Xmw)
          {
            l = 1L;
            ((jl)localObject).iTg = l;
            ((jl)localObject).iTq = 1L;
            ((jl)localObject).bMH();
            Log.d(TAG, s.X("eventType: ", Integer.valueOf(paramInt1)));
            switch (paramInt1)
            {
            default: 
              AppMethodBeat.o(82683);
              return;
            }
          }
          break;
        }
        break;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramy.nVr = 0L;
        continue;
        this.ork = System.currentTimeMillis();
        continue;
        long l = System.currentTimeMillis();
        this.Fta += l - this.ork;
        this.ork = l;
        continue;
        String str1 = paramy.YMn;
        s.s(str1, "videoInfo.videoVid");
        String str2 = paramy.YMm;
        s.s(str2, "videoInfo.mpUrl");
        g.a.b(0, str1, str2, this.AcJ, paramInt2);
        continue;
        str1 = paramy.YMn;
        s.s(str1, "videoInfo.videoVid");
        str2 = paramy.YMm;
        s.s(str2, "videoInfo.mpUrl");
        g.a.b(1, str1, str2, this.AcJ, paramInt2);
        continue;
        str1 = paramy.YMn;
        s.s(str1, "videoInfo.videoVid");
        str2 = paramy.YMm;
        s.s(str2, "videoInfo.mpUrl");
        g.a.b(2, str1, str2, this.AcJ, paramInt2);
        continue;
        l = 0L;
        continue;
        this.Fta = 0L;
        this.ork = System.currentTimeMillis();
        this.Xmu = 0;
      }
    }
  }
  
  public final int getPlayType()
  {
    switch (this.oYt)
    {
    case 0: 
    default: 
      return 3;
    case 1: 
      return 4;
    case 2: 
      return 8;
    case 3: 
      return 9;
    }
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.g
 * JD-Core Version:    0.7.0.1
 */
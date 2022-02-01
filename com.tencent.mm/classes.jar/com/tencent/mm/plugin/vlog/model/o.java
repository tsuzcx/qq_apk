package com.tencent.mm.plugin.vlog.model;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/HDRUtil;", "", "()V", "TAG", "", "getHdrDisplay", "", "getGetHdrDisplay", "()Z", "setGetHdrDisplay", "(Z)V", "hdrDisplayInfo", "getHdrDisplayInfo", "()Ljava/lang/String;", "setHdrDisplayInfo", "(Ljava/lang/String;)V", "checkHdrDisplayInfo", "", "activity", "Landroid/app/Activity;", "toHDRDesc", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final String TAG;
  public static final o TZr;
  private static boolean TZs;
  private static String TZt;
  
  static
  {
    AppMethodBeat.i(283455);
    TZr = new o();
    TAG = "MicroMsg.HDRUtil";
    TZt = "";
    AppMethodBeat.o(283455);
  }
  
  public static void bfa(String paramString)
  {
    AppMethodBeat.i(283437);
    s.u(paramString, "<set-?>");
    TZt = paramString;
    AppMethodBeat.o(283437);
  }
  
  public static void bz(Activity paramActivity)
  {
    AppMethodBeat.i(283443);
    s.u(paramActivity, "activity");
    if (TZs)
    {
      AppMethodBeat.o(283443);
      return;
    }
    TZs = true;
    if (Build.VERSION.SDK_INT >= 24) {
      d.B((a)new a(paramActivity));
    }
    AppMethodBeat.o(283443);
  }
  
  public static String hQC()
  {
    return TZt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(Activity paramActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.o
 * JD-Core Version:    0.7.0.1
 */
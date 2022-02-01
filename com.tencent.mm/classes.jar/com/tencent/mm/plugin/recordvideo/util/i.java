package com.tencent.mm.plugin.recordvideo.util;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "()V", "timeStartMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "calculate", "tag", "extra", "mark", "release", "", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements v
{
  public static final i.a ObE;
  private final HashMap<String, Long> ObF;
  
  static
  {
    AppMethodBeat.i(279517);
    ObE = new i.a((byte)0);
    AppMethodBeat.o(279517);
  }
  
  public i()
  {
    AppMethodBeat.i(279512);
    this.ObF = new HashMap();
    AppMethodBeat.o(279512);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(279546);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(279546);
  }
  
  public final long aTI(String paramString)
  {
    AppMethodBeat.i(279524);
    s.u(paramString, "tag");
    long l = System.currentTimeMillis();
    ((Map)this.ObF).put(paramString, Long.valueOf(l));
    AppMethodBeat.o(279524);
    return l;
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(279566);
    s.u(this, "this");
    AppMethodBeat.o(279566);
  }
  
  public final long ls(String paramString1, String paramString2)
  {
    AppMethodBeat.i(279530);
    s.u(paramString1, "tag");
    if (this.ObF.get(paramString1) == null)
    {
      Log.e("MicroMsg.RecordTimeCalculatePlugin", s.X(paramString1, " miss start mark!!!"));
      AppMethodBeat.o(279530);
      return -1L;
    }
    paramString1 = (Long)this.ObF.get(paramString1);
    if (paramString1 != null)
    {
      long l = System.currentTimeMillis() - paramString1.longValue();
      Log.i("MicroMsg.RecordTimeCalculatePlugin", paramString2 + " cost time:" + l);
      AppMethodBeat.o(279530);
      return l;
    }
    AppMethodBeat.o(279530);
    return -1L;
  }
  
  public final String name()
  {
    AppMethodBeat.i(279553);
    String str = v.a.b(this);
    AppMethodBeat.o(279553);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(279557);
    s.u(this, "this");
    AppMethodBeat.o(279557);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(279573);
    s.u(this, "this");
    AppMethodBeat.o(279573);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(279580);
    s.u(this, "this");
    AppMethodBeat.o(279580);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(279586);
    s.u(this, "this");
    AppMethodBeat.o(279586);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(279592);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(279592);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(279597);
    s.u(this, "this");
    AppMethodBeat.o(279597);
  }
  
  public final void release()
  {
    AppMethodBeat.i(279537);
    s.u((v)this, "this");
    this.ObF.clear();
    AppMethodBeat.o(279537);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(279599);
    s.u(this, "this");
    AppMethodBeat.o(279599);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(279605);
    s.u(this, "this");
    AppMethodBeat.o(279605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.i
 * JD-Core Version:    0.7.0.1
 */
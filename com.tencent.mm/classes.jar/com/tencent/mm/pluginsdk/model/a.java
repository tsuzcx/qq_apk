package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fnd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizCommUtil;", "", "()V", "TAG", "", "kTimelineSettingInfo", "settingList", "", "", "getSettingList", "()[Ljava/lang/Integer;", "settingList$delegate", "Lkotlin/Lazy;", "getTimelineSettingInfo", "Lcom/tencent/mm/protocal/protobuf/TimelineSettingInfo;", "isSettingOpen", "", "bit", "setTimelineSettingInfo", "", "info", "SettingType", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a XPo;
  public static final j XPp;
  
  static
  {
    AppMethodBeat.i(244724);
    XPo = new a();
    XPp = k.cm((kotlin.g.a.a)a.XPq);
    AppMethodBeat.o(244724);
  }
  
  public static void a(fnd paramfnd)
  {
    AppMethodBeat.i(244722);
    if (paramfnd == null)
    {
      AppMethodBeat.o(244722);
      return;
    }
    try
    {
      Log.i("MicroMsg.BizCommUtil", s.X("setTimelineSettingInfo bitSet = ", Integer.valueOf(paramfnd.abNk)));
      MultiProcessMMKV.getSingleMMKV("brandService").encode("k_TimelineSettingInfo", paramfnd.toByteArray());
      AppMethodBeat.o(244722);
      return;
    }
    catch (IOException paramfnd)
    {
      Log.w("MicroMsg.BizCommUtil", "encode TimelineSettingInfo ex %s", new Object[] { paramfnd.getMessage() });
      AppMethodBeat.o(244722);
    }
  }
  
  public static fnd iGT()
  {
    int j = 1;
    AppMethodBeat.i(244714);
    Object localObject1 = MultiProcessMMKV.getSingleMMKV("brandService");
    s.s(localObject1, "getSingleMMKV(BizConstants.brandService)");
    int i;
    if (((MultiProcessMMKV)localObject1).containsKey("k_TimelineSettingInfo"))
    {
      localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("k_TimelineSettingInfo");
      if (localObject1 != null) {
        if (localObject1.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label93;
          }
          i = j;
          label52:
          if (i == 0) {
            break label114;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = fnd.class.newInstance();
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject3;
        localObject1 = (fnd)localObject1;
        AppMethodBeat.o(244714);
        return localObject1;
      }
      catch (Exception localException)
      {
        label93:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label52;
      label114:
      Object localObject2 = null;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Integer[]>
  {
    public static final a XPq;
    
    static
    {
      AppMethodBeat.i(244707);
      XPq = new a();
      AppMethodBeat.o(244707);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a
 * JD-Core Version:    0.7.0.1
 */
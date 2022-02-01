package com.tencent.mm.plugin.teenmode.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.protocal.protobuf.abs;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/NetSceneCheckPwdExist;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/CheckTeenagerModePwdExistResponse;", "()V", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b<abs>
{
  public static final a SYO;
  
  static
  {
    AppMethodBeat.i(278865);
    SYO = new a((byte)0);
    AppMethodBeat.o(278865);
  }
  
  public f()
  {
    AppMethodBeat.i(278858);
    c.a locala = new c.a();
    locala.otE = ((a)new abr());
    locala.otF = ((a)new abs());
    locala.uri = "/cgi-bin/micromsg-bin/checkteenagermodepwdexist";
    locala.funcId = 4231;
    c(locala.bEF());
    AppMethodBeat.o(278858);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/NetSceneCheckPwdExist$Companion;", "", "()V", "TAG", "", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.f
 * JD-Core Version:    0.7.0.1
 */
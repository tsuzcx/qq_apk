package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class tu
  extends com.tencent.mm.bw.a
{
  public String appId;
  public int eix;
  public String md5;
  public String path;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(224537);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.e(1, this.appId);
      }
      if (this.path != null) {
        paramVarArgs.e(2, this.path);
      }
      paramVarArgs.aM(3, this.version);
      paramVarArgs.aM(4, this.eix);
      if (this.md5 != null) {
        paramVarArgs.e(5, this.md5);
      }
      AppMethodBeat.o(224537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.f(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.path);
      }
      i = i + g.a.a.b.b.a.bu(3, this.version) + g.a.a.b.b.a.bu(4, this.eix);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.md5);
      }
      AppMethodBeat.o(224537);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(224537);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        tu localtu = (tu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(224537);
          return -1;
        case 1: 
          localtu.appId = locala.UbS.readString();
          AppMethodBeat.o(224537);
          return 0;
        case 2: 
          localtu.path = locala.UbS.readString();
          AppMethodBeat.o(224537);
          return 0;
        case 3: 
          localtu.version = locala.UbS.zi();
          AppMethodBeat.o(224537);
          return 0;
        case 4: 
          localtu.eix = locala.UbS.zi();
          AppMethodBeat.o(224537);
          return 0;
        }
        localtu.md5 = locala.UbS.readString();
        AppMethodBeat.o(224537);
        return 0;
      }
      AppMethodBeat.o(224537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tu
 * JD-Core Version:    0.7.0.1
 */
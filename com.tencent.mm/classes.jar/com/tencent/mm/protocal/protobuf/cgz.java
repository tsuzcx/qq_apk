package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cgz
  extends com.tencent.mm.bw.a
{
  public String Fvc;
  public int Fvd;
  public String appId;
  public int dcj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153295);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.d(1, this.appId);
      }
      if (this.Fvc != null) {
        paramVarArgs.d(2, this.Fvc);
      }
      paramVarArgs.aR(3, this.dcj);
      paramVarArgs.aR(4, this.Fvd);
      AppMethodBeat.o(153295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fvc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fvc);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.dcj);
      int j = f.a.a.b.b.a.bx(4, this.Fvd);
      AppMethodBeat.o(153295);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153295);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cgz localcgz = (cgz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153295);
          return -1;
        case 1: 
          localcgz.appId = locala.LVo.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 2: 
          localcgz.Fvc = locala.LVo.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 3: 
          localcgz.dcj = locala.LVo.xF();
          AppMethodBeat.o(153295);
          return 0;
        }
        localcgz.Fvd = locala.LVo.xF();
        AppMethodBeat.o(153295);
        return 0;
      }
      AppMethodBeat.o(153295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgz
 * JD-Core Version:    0.7.0.1
 */
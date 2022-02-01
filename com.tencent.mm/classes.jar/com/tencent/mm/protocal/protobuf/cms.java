package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cms
  extends com.tencent.mm.bw.a
{
  public String HyH;
  public int HyI;
  public String appId;
  public int doK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153295);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.d(1, this.appId);
      }
      if (this.HyH != null) {
        paramVarArgs.d(2, this.HyH);
      }
      paramVarArgs.aS(3, this.doK);
      paramVarArgs.aS(4, this.HyI);
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
      if (this.HyH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HyH);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.doK);
      int j = f.a.a.b.b.a.bz(4, this.HyI);
      AppMethodBeat.o(153295);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153295);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cms localcms = (cms)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153295);
          return -1;
        case 1: 
          localcms.appId = locala.OmT.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 2: 
          localcms.HyH = locala.OmT.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 3: 
          localcms.doK = locala.OmT.zc();
          AppMethodBeat.o(153295);
          return 0;
        }
        localcms.HyI = locala.OmT.zc();
        AppMethodBeat.o(153295);
        return 0;
      }
      AppMethodBeat.o(153295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cms
 * JD-Core Version:    0.7.0.1
 */
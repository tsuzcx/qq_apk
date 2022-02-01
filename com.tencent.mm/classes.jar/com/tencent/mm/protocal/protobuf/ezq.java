package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezq
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String KHq;
  public int MuU;
  public int NvO;
  public int oTz;
  public int oUv;
  public String xNG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32560);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xNG != null) {
        paramVarArgs.e(1, this.xNG);
      }
      paramVarArgs.aM(2, this.oUv);
      paramVarArgs.aM(3, this.oTz);
      paramVarArgs.aM(4, this.CreateTime);
      paramVarArgs.aM(5, this.MuU);
      if (this.KHq != null) {
        paramVarArgs.e(6, this.KHq);
      }
      paramVarArgs.aM(7, this.NvO);
      AppMethodBeat.o(32560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNG == null) {
        break label507;
      }
    }
    label507:
    for (paramInt = g.a.a.b.b.a.f(1, this.xNG) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.oTz) + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(5, this.MuU);
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KHq);
      }
      i = g.a.a.b.b.a.bu(7, this.NvO);
      AppMethodBeat.o(32560);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32560);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezq localezq = (ezq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32560);
          return -1;
        case 1: 
          localezq.xNG = locala.UbS.readString();
          AppMethodBeat.o(32560);
          return 0;
        case 2: 
          localezq.oUv = locala.UbS.zi();
          AppMethodBeat.o(32560);
          return 0;
        case 3: 
          localezq.oTz = locala.UbS.zi();
          AppMethodBeat.o(32560);
          return 0;
        case 4: 
          localezq.CreateTime = locala.UbS.zi();
          AppMethodBeat.o(32560);
          return 0;
        case 5: 
          localezq.MuU = locala.UbS.zi();
          AppMethodBeat.o(32560);
          return 0;
        case 6: 
          localezq.KHq = locala.UbS.readString();
          AppMethodBeat.o(32560);
          return 0;
        }
        localezq.NvO = locala.UbS.zi();
        AppMethodBeat.o(32560);
        return 0;
      }
      AppMethodBeat.o(32560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezq
 * JD-Core Version:    0.7.0.1
 */
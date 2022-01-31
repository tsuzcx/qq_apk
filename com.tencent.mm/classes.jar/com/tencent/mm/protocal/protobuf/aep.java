package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class aep
  extends com.tencent.mm.bv.a
{
  public String npZ;
  public String wXs;
  public String wXz;
  public String woO;
  public int wzE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(112425);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(112425);
        throw paramVarArgs;
      }
      if (this.wXz == null)
      {
        paramVarArgs = new b("Not all required fields were included: RecommendKey");
        AppMethodBeat.o(112425);
        throw paramVarArgs;
      }
      if (this.npZ != null) {
        paramVarArgs.e(1, this.npZ);
      }
      if (this.wXz != null) {
        paramVarArgs.e(2, this.wXz);
      }
      if (this.woO != null) {
        paramVarArgs.e(3, this.woO);
      }
      paramVarArgs.aO(4, this.wzE);
      if (this.wXs != null) {
        paramVarArgs.e(5, this.wXs);
      }
      AppMethodBeat.o(112425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npZ == null) {
        break label534;
      }
    }
    label534:
    for (int i = e.a.a.b.b.a.f(1, this.npZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wXz != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wXz);
      }
      i = paramInt;
      if (this.woO != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.woO);
      }
      i += e.a.a.b.b.a.bl(4, this.wzE);
      paramInt = i;
      if (this.wXs != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wXs);
      }
      AppMethodBeat.o(112425);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.npZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(112425);
          throw paramVarArgs;
        }
        if (this.wXz == null)
        {
          paramVarArgs = new b("Not all required fields were included: RecommendKey");
          AppMethodBeat.o(112425);
          throw paramVarArgs;
        }
        AppMethodBeat.o(112425);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aep localaep = (aep)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(112425);
          return -1;
        case 1: 
          localaep.npZ = locala.CLY.readString();
          AppMethodBeat.o(112425);
          return 0;
        case 2: 
          localaep.wXz = locala.CLY.readString();
          AppMethodBeat.o(112425);
          return 0;
        case 3: 
          localaep.woO = locala.CLY.readString();
          AppMethodBeat.o(112425);
          return 0;
        case 4: 
          localaep.wzE = locala.CLY.sl();
          AppMethodBeat.o(112425);
          return 0;
        }
        localaep.wXs = locala.CLY.readString();
        AppMethodBeat.o(112425);
        return 0;
      }
      AppMethodBeat.o(112425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aep
 * JD-Core Version:    0.7.0.1
 */
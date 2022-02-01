package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class edo
  extends com.tencent.mm.bw.a
{
  public String NdR;
  public String NdS;
  public String NdT;
  public String NdU;
  public String NdV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101531);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NdR == null)
      {
        paramVarArgs = new b("Not all required fields were included: videoFileMD5");
        AppMethodBeat.o(101531);
        throw paramVarArgs;
      }
      if (this.NdR != null) {
        paramVarArgs.e(1, this.NdR);
      }
      if (this.NdS != null) {
        paramVarArgs.e(2, this.NdS);
      }
      if (this.NdT != null) {
        paramVarArgs.e(3, this.NdT);
      }
      if (this.NdU != null) {
        paramVarArgs.e(4, this.NdU);
      }
      if (this.NdV != null) {
        paramVarArgs.e(5, this.NdV);
      }
      AppMethodBeat.o(101531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NdR == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.f(1, this.NdR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NdS != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NdS);
      }
      i = paramInt;
      if (this.NdT != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NdT);
      }
      paramInt = i;
      if (this.NdU != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NdU);
      }
      i = paramInt;
      if (this.NdV != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.NdV);
      }
      AppMethodBeat.o(101531);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NdR == null)
        {
          paramVarArgs = new b("Not all required fields were included: videoFileMD5");
          AppMethodBeat.o(101531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101531);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        edo localedo = (edo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101531);
          return -1;
        case 1: 
          localedo.NdR = locala.UbS.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 2: 
          localedo.NdS = locala.UbS.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 3: 
          localedo.NdT = locala.UbS.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 4: 
          localedo.NdU = locala.UbS.readString();
          AppMethodBeat.o(101531);
          return 0;
        }
        localedo.NdV = locala.UbS.readString();
        AppMethodBeat.o(101531);
        return 0;
      }
      AppMethodBeat.o(101531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edo
 * JD-Core Version:    0.7.0.1
 */
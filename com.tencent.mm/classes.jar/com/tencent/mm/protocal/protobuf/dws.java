package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dws
  extends com.tencent.mm.bw.a
{
  public boolean BYY;
  public String DUB;
  public long duration;
  public String hoZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212482);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUB == null)
      {
        paramVarArgs = new b("Not all required fields were included: templatePath");
        AppMethodBeat.o(212482);
        throw paramVarArgs;
      }
      if (this.hoZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: musicPath");
        AppMethodBeat.o(212482);
        throw paramVarArgs;
      }
      if (this.DUB != null) {
        paramVarArgs.d(1, this.DUB);
      }
      if (this.hoZ != null) {
        paramVarArgs.d(2, this.hoZ);
      }
      paramVarArgs.aZ(3, this.duration);
      paramVarArgs.bC(4, this.BYY);
      AppMethodBeat.o(212482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUB == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.DUB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hoZ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hoZ);
      }
      paramInt = f.a.a.b.b.a.p(3, this.duration);
      int j = f.a.a.b.b.a.amF(4);
      AppMethodBeat.o(212482);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.DUB == null)
        {
          paramVarArgs = new b("Not all required fields were included: templatePath");
          AppMethodBeat.o(212482);
          throw paramVarArgs;
        }
        if (this.hoZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: musicPath");
          AppMethodBeat.o(212482);
          throw paramVarArgs;
        }
        AppMethodBeat.o(212482);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dws localdws = (dws)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212482);
          return -1;
        case 1: 
          localdws.DUB = locala.OmT.readString();
          AppMethodBeat.o(212482);
          return 0;
        case 2: 
          localdws.hoZ = locala.OmT.readString();
          AppMethodBeat.o(212482);
          return 0;
        case 3: 
          localdws.duration = locala.OmT.zd();
          AppMethodBeat.o(212482);
          return 0;
        }
        localdws.BYY = locala.OmT.gvY();
        AppMethodBeat.o(212482);
        return 0;
      }
      AppMethodBeat.o(212482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dws
 * JD-Core Version:    0.7.0.1
 */
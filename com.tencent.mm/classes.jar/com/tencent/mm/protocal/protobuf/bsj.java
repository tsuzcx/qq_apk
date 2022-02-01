package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bsj
  extends com.tencent.mm.cd.a
{
  public int RIK;
  public eaf TcD;
  public int TcE;
  public int TcF;
  public int TcG = 1;
  public int TcH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101809);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TcD == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatroomId");
        AppMethodBeat.o(101809);
        throw paramVarArgs;
      }
      if (this.TcD != null)
      {
        paramVarArgs.oE(1, this.TcD.computeSize());
        this.TcD.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RIK);
      paramVarArgs.aY(3, this.TcE);
      paramVarArgs.aY(4, this.TcF);
      paramVarArgs.aY(5, this.TcG);
      paramVarArgs.aY(6, this.TcH);
      AppMethodBeat.o(101809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TcD == null) {
        break label568;
      }
    }
    label568:
    for (paramInt = g.a.a.a.oD(1, this.TcD.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.RIK);
      int j = g.a.a.b.b.a.bM(3, this.TcE);
      int k = g.a.a.b.b.a.bM(4, this.TcF);
      int m = g.a.a.b.b.a.bM(5, this.TcG);
      int n = g.a.a.b.b.a.bM(6, this.TcH);
      AppMethodBeat.o(101809);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TcD == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatroomId");
          AppMethodBeat.o(101809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bsj localbsj = (bsj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101809);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eaf localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localbsj.TcD = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(101809);
          return 0;
        case 2: 
          localbsj.RIK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101809);
          return 0;
        case 3: 
          localbsj.TcE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101809);
          return 0;
        case 4: 
          localbsj.TcF = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101809);
          return 0;
        case 5: 
          localbsj.TcG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101809);
          return 0;
        }
        localbsj.TcH = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(101809);
        return 0;
      }
      AppMethodBeat.o(101809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsj
 * JD-Core Version:    0.7.0.1
 */
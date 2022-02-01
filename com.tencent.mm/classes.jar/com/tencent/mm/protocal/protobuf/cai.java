package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cai
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public eae RJA;
  public int TdG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104810);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104810);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.TdG);
      if (this.RJA != null)
      {
        paramVarArgs.oE(2, this.RJA.computeSize());
        this.RJA.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.CPw);
      AppMethodBeat.o(104810);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TdG) + 0;
      paramInt = i;
      if (this.RJA != null) {
        paramInt = i + g.a.a.a.oD(2, this.RJA.computeSize());
      }
      i = g.a.a.b.b.a.bM(3, this.CPw);
      AppMethodBeat.o(104810);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.RJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104810);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104810);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      cai localcai = (cai)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104810);
        return -1;
      case 1: 
        localcai.TdG = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(104810);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eae localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localcai.RJA = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(104810);
        return 0;
      }
      localcai.CPw = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(104810);
      return 0;
    }
    AppMethodBeat.o(104810);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cai
 * JD-Core Version:    0.7.0.1
 */
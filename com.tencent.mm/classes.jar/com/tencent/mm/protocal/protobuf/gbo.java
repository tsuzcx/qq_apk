package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gbo
  extends esc
{
  public long abZN;
  public int abZR;
  public int abZS;
  public LinkedList<fgy> abZT;
  
  public gbo()
  {
    AppMethodBeat.i(115918);
    this.abZT = new LinkedList();
    AppMethodBeat.o(115918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115919);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115919);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abZR);
      paramVarArgs.bv(3, this.abZN);
      paramVarArgs.bS(4, this.abZS);
      paramVarArgs.e(5, 8, this.abZT);
      AppMethodBeat.o(115919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abZR);
      int j = i.a.a.b.b.a.q(3, this.abZN);
      int k = i.a.a.b.b.a.cJ(4, this.abZS);
      int m = i.a.a.a.c(5, 8, this.abZT);
      AppMethodBeat.o(115919);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abZT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115919);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gbo localgbo = (gbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115919);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localgbo.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115919);
          return 0;
        case 2: 
          localgbo.abZR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115919);
          return 0;
        case 3: 
          localgbo.abZN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115919);
          return 0;
        case 4: 
          localgbo.abZS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115919);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fgy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fgy)localObject2).parseFrom((byte[])localObject1);
          }
          localgbo.abZT.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115919);
        return 0;
      }
      AppMethodBeat.o(115919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbo
 * JD-Core Version:    0.7.0.1
 */
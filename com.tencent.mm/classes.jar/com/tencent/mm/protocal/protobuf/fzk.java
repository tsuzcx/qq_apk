package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fzk
  extends esc
{
  public int abWL;
  public LinkedList<fzh> abWM;
  public int abWN;
  public int abpC;
  
  public fzk()
  {
    AppMethodBeat.i(148670);
    this.abWM = new LinkedList();
    AppMethodBeat.o(148670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148671);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148671);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abWL);
      paramVarArgs.e(3, 8, this.abWM);
      paramVarArgs.bS(4, this.abpC);
      paramVarArgs.bS(5, this.abWN);
      AppMethodBeat.o(148671);
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
      int i = i.a.a.b.b.a.cJ(2, this.abWL);
      int j = i.a.a.a.c(3, 8, this.abWM);
      int k = i.a.a.b.b.a.cJ(4, this.abpC);
      int m = i.a.a.b.b.a.cJ(5, this.abWN);
      AppMethodBeat.o(148671);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abWM.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(148671);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fzk localfzk = (fzk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148671);
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
            localfzk.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148671);
          return 0;
        case 2: 
          localfzk.abWL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148671);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzh)localObject2).parseFrom((byte[])localObject1);
            }
            localfzk.abWM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148671);
          return 0;
        case 4: 
          localfzk.abpC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148671);
          return 0;
        }
        localfzk.abWN = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148671);
        return 0;
      }
      AppMethodBeat.o(148671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzk
 * JD-Core Version:    0.7.0.1
 */
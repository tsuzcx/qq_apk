package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cfa
  extends esc
{
  public LinkedList<jr> aaoK;
  public LinkedList<jr> aaoL;
  public int hAV;
  public String wYI;
  
  public cfa()
  {
    AppMethodBeat.i(72481);
    this.aaoK = new LinkedList();
    this.aaoL = new LinkedList();
    AppMethodBeat.o(72481);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72482);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72482);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      paramVarArgs.e(4, 8, this.aaoK);
      paramVarArgs.e(5, 8, this.aaoL);
      AppMethodBeat.o(72482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label676;
      }
    }
    label676:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = i.a.a.a.c(4, 8, this.aaoK);
      int j = i.a.a.a.c(5, 8, this.aaoL);
      AppMethodBeat.o(72482);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaoK.clear();
        this.aaoL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72482);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72482);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cfa localcfa = (cfa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72482);
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
            localcfa.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72482);
          return 0;
        case 2: 
          localcfa.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72482);
          return 0;
        case 3: 
          localcfa.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72482);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jr)localObject2).parseFrom((byte[])localObject1);
            }
            localcfa.aaoK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72482);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new jr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((jr)localObject2).parseFrom((byte[])localObject1);
          }
          localcfa.aaoL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72482);
        return 0;
      }
      AppMethodBeat.o(72482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfa
 * JD-Core Version:    0.7.0.1
 */
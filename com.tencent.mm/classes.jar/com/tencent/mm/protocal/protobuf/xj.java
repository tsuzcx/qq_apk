package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class xj
  extends esc
{
  public String ZfX;
  public LinkedList<apy> ZfY;
  public int ZfZ;
  public int hAV;
  public String wYI;
  public String wYJ;
  
  public xj()
  {
    AppMethodBeat.i(91401);
    this.ZfY = new LinkedList();
    AppMethodBeat.o(91401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91402);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91402);
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
      if (this.ZfX != null) {
        paramVarArgs.g(4, this.ZfX);
      }
      if (this.wYJ != null) {
        paramVarArgs.g(5, this.wYJ);
      }
      paramVarArgs.e(6, 8, this.ZfY);
      paramVarArgs.bS(7, this.ZfZ);
      AppMethodBeat.o(91402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.ZfX != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZfX);
      }
      paramInt = i;
      if (this.wYJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.wYJ);
      }
      i = i.a.a.a.c(6, 8, this.ZfY);
      int j = i.a.a.b.b.a.cJ(7, this.ZfZ);
      AppMethodBeat.o(91402);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZfY.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        xj localxj = (xj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91402);
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
            localxj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        case 2: 
          localxj.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91402);
          return 0;
        case 3: 
          localxj.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 4: 
          localxj.ZfX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 5: 
          localxj.wYJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new apy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((apy)localObject2).parseFrom((byte[])localObject1);
            }
            localxj.ZfY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        }
        localxj.ZfZ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91402);
        return 0;
      }
      AppMethodBeat.o(91402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xj
 * JD-Core Version:    0.7.0.1
 */
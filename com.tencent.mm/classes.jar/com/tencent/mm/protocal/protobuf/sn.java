package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sn
  extends erp
{
  public String YXD;
  public int YXV;
  public int YXW;
  public long YXX;
  public eh YXl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91376);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YXl != null)
      {
        paramVarArgs.qD(2, this.YXl.computeSize());
        this.YXl.writeFields(paramVarArgs);
      }
      if (this.YXD != null) {
        paramVarArgs.g(3, this.YXD);
      }
      paramVarArgs.bS(4, this.YXV);
      paramVarArgs.bS(5, this.YXW);
      paramVarArgs.bv(6, this.YXX);
      AppMethodBeat.o(91376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YXl != null) {
        paramInt = i + i.a.a.a.qC(2, this.YXl.computeSize());
      }
      i = paramInt;
      if (this.YXD != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YXD);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.YXV);
      int j = i.a.a.b.b.a.cJ(5, this.YXW);
      int k = i.a.a.b.b.a.q(6, this.YXX);
      AppMethodBeat.o(91376);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        sn localsn = (sn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91376);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localsn.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91376);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eh)localObject2).parseFrom((byte[])localObject1);
            }
            localsn.YXl = ((eh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91376);
          return 0;
        case 3: 
          localsn.YXD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91376);
          return 0;
        case 4: 
          localsn.YXV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91376);
          return 0;
        case 5: 
          localsn.YXW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91376);
          return 0;
        }
        localsn.YXX = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(91376);
        return 0;
      }
      AppMethodBeat.o(91376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sn
 * JD-Core Version:    0.7.0.1
 */
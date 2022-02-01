package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class bhr
  extends esc
{
  public int BeA;
  public int YFb;
  public b ZEQ;
  public LinkedList<bgx> oPy;
  
  public bhr()
  {
    AppMethodBeat.i(257734);
    this.oPy = new LinkedList();
    AppMethodBeat.o(257734);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257736);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(2, this.ZEQ);
      }
      paramVarArgs.bS(3, this.BeA);
      paramVarArgs.bS(4, this.YFb);
      paramVarArgs.e(5, 8, this.oPy);
      AppMethodBeat.o(257736);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ZEQ);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.BeA);
      int j = i.a.a.b.b.a.cJ(4, this.YFb);
      int k = i.a.a.a.c(5, 8, this.oPy);
      AppMethodBeat.o(257736);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.oPy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257736);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bhr localbhr = (bhr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257736);
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
            localbhr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257736);
          return 0;
        case 2: 
          localbhr.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257736);
          return 0;
        case 3: 
          localbhr.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257736);
          return 0;
        case 4: 
          localbhr.YFb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257736);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bgx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bgx)localObject2).parseFrom((byte[])localObject1);
          }
          localbhr.oPy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257736);
        return 0;
      }
      AppMethodBeat.o(257736);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhr
 * JD-Core Version:    0.7.0.1
 */
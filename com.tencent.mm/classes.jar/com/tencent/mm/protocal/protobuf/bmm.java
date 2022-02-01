package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bmm
  extends esc
{
  public int BeA;
  public b ZEQ;
  public LinkedList<bkh> ZPz;
  
  public bmm()
  {
    AppMethodBeat.i(258939);
    this.ZPz = new LinkedList();
    AppMethodBeat.o(258939);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258945);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZPz);
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.bS(4, this.BeA);
      AppMethodBeat.o(258945);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZPz);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = i.a.a.b.b.a.cJ(4, this.BeA);
      AppMethodBeat.o(258945);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZPz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258945);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bmm localbmm = (bmm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258945);
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
            localbmm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258945);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkh)localObject2).parseFrom((byte[])localObject1);
            }
            localbmm.ZPz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258945);
          return 0;
        case 3: 
          localbmm.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258945);
          return 0;
        }
        localbmm.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258945);
        return 0;
      }
      AppMethodBeat.o(258945);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmm
 * JD-Core Version:    0.7.0.1
 */
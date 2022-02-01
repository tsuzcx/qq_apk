package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bhz
  extends esc
{
  public bok ZRg;
  public int continueFlag;
  public b lastBuffer;
  public long liveId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257653);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZRg != null)
      {
        paramVarArgs.qD(2, this.ZRg.computeSize());
        this.ZRg.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      paramVarArgs.bS(4, this.continueFlag);
      paramVarArgs.bv(5, this.liveId);
      AppMethodBeat.o(257653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZRg != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZRg.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.continueFlag);
      int j = i.a.a.b.b.a.q(5, this.liveId);
      AppMethodBeat.o(257653);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bhz localbhz = (bhz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257653);
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
            localbhz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257653);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bok();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bok)localObject2).parseFrom((byte[])localObject1);
            }
            localbhz.ZRg = ((bok)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257653);
          return 0;
        case 3: 
          localbhz.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257653);
          return 0;
        case 4: 
          localbhz.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257653);
          return 0;
        }
        localbhz.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257653);
        return 0;
      }
      AppMethodBeat.o(257653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhz
 * JD-Core Version:    0.7.0.1
 */
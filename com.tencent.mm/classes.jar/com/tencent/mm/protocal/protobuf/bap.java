package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bap
  extends esc
{
  public LinkedList<bqs> ZLv;
  public int ZLw;
  public int continueFlag;
  public b lastBuffer;
  
  public bap()
  {
    AppMethodBeat.i(259933);
    this.ZLv = new LinkedList();
    AppMethodBeat.o(259933);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259938);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZLv);
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      paramVarArgs.bS(4, this.continueFlag);
      paramVarArgs.bS(5, this.ZLw);
      AppMethodBeat.o(259938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZLv);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      i = i.a.a.b.b.a.cJ(4, this.continueFlag);
      int j = i.a.a.b.b.a.cJ(5, this.ZLw);
      AppMethodBeat.o(259938);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZLv.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259938);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bap localbap = (bap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259938);
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
            localbap.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259938);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqs)localObject2).parseFrom((byte[])localObject1);
            }
            localbap.ZLv.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259938);
          return 0;
        case 3: 
          localbap.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259938);
          return 0;
        case 4: 
          localbap.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259938);
          return 0;
        }
        localbap.ZLw = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259938);
        return 0;
      }
      AppMethodBeat.o(259938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bap
 * JD-Core Version:    0.7.0.1
 */
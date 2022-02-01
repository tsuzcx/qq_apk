package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnu
  extends cvp
{
  public boolean HBL;
  public String HbT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117937);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HbT != null) {
        paramVarArgs.d(2, this.HbT);
      }
      paramVarArgs.bt(3, this.HBL);
      AppMethodBeat.o(117937);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HbT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HbT);
      }
      paramInt = f.a.a.b.b.a.alV(3);
      AppMethodBeat.o(117937);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117937);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnu localdnu = (dnu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117937);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117937);
          return 0;
        case 2: 
          localdnu.HbT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117937);
          return 0;
        }
        localdnu.HBL = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(117937);
        return 0;
      }
      AppMethodBeat.o(117937);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnu
 * JD-Core Version:    0.7.0.1
 */
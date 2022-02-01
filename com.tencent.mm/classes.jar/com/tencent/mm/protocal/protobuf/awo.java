package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awo
  extends cvp
{
  public int Gvc;
  public String Gvd;
  public String Gve;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.aS(4, this.Gvc);
      if (this.Gvd != null) {
        paramVarArgs.d(5, this.Gvd);
      }
      if (this.Gve != null) {
        paramVarArgs.d(6, this.Gve);
      }
      AppMethodBeat.o(91476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Gvc);
      paramInt = i;
      if (this.Gvd != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gvd);
      }
      i = paramInt;
      if (this.Gve != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Gve);
      }
      AppMethodBeat.o(91476);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awo localawo = (awo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91476);
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
            localawo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91476);
          return 0;
        case 2: 
          localawo.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91476);
          return 0;
        case 3: 
          localawo.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91476);
          return 0;
        case 4: 
          localawo.Gvc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91476);
          return 0;
        case 5: 
          localawo.Gvd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91476);
          return 0;
        }
        localawo.Gve = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91476);
        return 0;
      }
      AppMethodBeat.o(91476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awo
 * JD-Core Version:    0.7.0.1
 */
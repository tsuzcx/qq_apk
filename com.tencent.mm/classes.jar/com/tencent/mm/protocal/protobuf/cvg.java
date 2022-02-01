package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cvg
  extends cvp
{
  public String GZe;
  public int GZg;
  public String GZr;
  public int Hnn;
  public int Hno;
  public String thm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91672);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91672);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.thm != null) {
        paramVarArgs.d(2, this.thm);
      }
      if (this.GZe != null) {
        paramVarArgs.d(3, this.GZe);
      }
      paramVarArgs.aS(4, this.Hnn);
      paramVarArgs.aS(5, this.Hno);
      paramVarArgs.aS(6, this.GZg);
      if (this.GZr != null) {
        paramVarArgs.d(7, this.GZr);
      }
      AppMethodBeat.o(91672);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label670;
      }
    }
    label670:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thm);
      }
      i = paramInt;
      if (this.GZe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GZe);
      }
      i = i + f.a.a.b.b.a.bz(4, this.Hnn) + f.a.a.b.b.a.bz(5, this.Hno) + f.a.a.b.b.a.bz(6, this.GZg);
      paramInt = i;
      if (this.GZr != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GZr);
      }
      AppMethodBeat.o(91672);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91672);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91672);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvg localcvg = (cvg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91672);
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
            localcvg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91672);
          return 0;
        case 2: 
          localcvg.thm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 3: 
          localcvg.GZe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 4: 
          localcvg.Hnn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91672);
          return 0;
        case 5: 
          localcvg.Hno = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91672);
          return 0;
        case 6: 
          localcvg.GZg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91672);
          return 0;
        }
        localcvg.GZr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91672);
        return 0;
      }
      AppMethodBeat.o(91672);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvg
 * JD-Core Version:    0.7.0.1
 */
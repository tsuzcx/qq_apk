package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dvg
  extends cvp
{
  public int FWG;
  public int Hli;
  public dwk Hln;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32495);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32495);
        throw paramVarArgs;
      }
      if (this.Hln == null)
      {
        paramVarArgs = new b("Not all required fields were included: NextPiece");
        AppMethodBeat.o(32495);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Hln != null)
      {
        paramVarArgs.lC(2, this.Hln.computeSize());
        this.Hln.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FWG);
      paramVarArgs.aS(4, this.Hli);
      AppMethodBeat.o(32495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label664;
      }
    }
    label664:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hln != null) {
        i = paramInt + f.a.a.a.lB(2, this.Hln.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.FWG);
      int j = f.a.a.b.b.a.bz(4, this.Hli);
      AppMethodBeat.o(32495);
      return i + paramInt + j;
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
          AppMethodBeat.o(32495);
          throw paramVarArgs;
        }
        if (this.Hln == null)
        {
          paramVarArgs = new b("Not all required fields were included: NextPiece");
          AppMethodBeat.o(32495);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvg localdvg = (dvg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32495);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32495);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvg.Hln = ((dwk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32495);
          return 0;
        case 3: 
          localdvg.FWG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32495);
          return 0;
        }
        localdvg.Hli = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32495);
        return 0;
      }
      AppMethodBeat.o(32495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcv
  extends cvp
{
  public int FCq;
  public String FCr;
  public LinkedList<ahk> Gzo;
  public int Gzp;
  
  public bcv()
  {
    AppMethodBeat.i(91487);
    this.Gzo = new LinkedList();
    AppMethodBeat.o(91487);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91488);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91488);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Gzo);
      paramVarArgs.aS(3, this.Gzp);
      paramVarArgs.aS(4, this.FCq);
      if (this.FCr != null) {
        paramVarArgs.d(5, this.FCr);
      }
      AppMethodBeat.o(91488);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Gzo) + f.a.a.b.b.a.bz(3, this.Gzp) + f.a.a.b.b.a.bz(4, this.FCq);
      paramInt = i;
      if (this.FCr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FCr);
      }
      AppMethodBeat.o(91488);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gzo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91488);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91488);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcv localbcv = (bcv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91488);
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
            localbcv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91488);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcv.Gzo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91488);
          return 0;
        case 3: 
          localbcv.Gzp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91488);
          return 0;
        case 4: 
          localbcv.FCq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91488);
          return 0;
        }
        localbcv.FCr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91488);
        return 0;
      }
      AppMethodBeat.o(91488);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcv
 * JD-Core Version:    0.7.0.1
 */
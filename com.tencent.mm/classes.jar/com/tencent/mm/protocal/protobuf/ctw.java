package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ctw
  extends cvp
{
  public int Gyc;
  public LinkedList<Integer> Gyd;
  public LinkedList<ahl> Gye;
  public int HlS;
  
  public ctw()
  {
    AppMethodBeat.i(210616);
    this.Gye = new LinkedList();
    this.Gyd = new LinkedList();
    AppMethodBeat.o(210616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(210617);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gyc);
      paramVarArgs.aS(3, this.HlS);
      paramVarArgs.e(4, 8, this.Gye);
      paramVarArgs.e(5, 2, this.Gyd);
      AppMethodBeat.o(210617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label653;
      }
    }
    label653:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gyc);
      int j = f.a.a.b.b.a.bz(3, this.HlS);
      int k = f.a.a.a.c(4, 8, this.Gye);
      int m = f.a.a.a.c(5, 2, this.Gyd);
      AppMethodBeat.o(210617);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gye.clear();
        this.Gyd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(210617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(210617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctw localctw = (ctw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210617);
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
            localctw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210617);
          return 0;
        case 2: 
          localctw.Gyc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210617);
          return 0;
        case 3: 
          localctw.HlS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210617);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctw.Gye.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210617);
          return 0;
        }
        localctw.Gyd.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
        AppMethodBeat.o(210617);
        return 0;
      }
      AppMethodBeat.o(210617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctw
 * JD-Core Version:    0.7.0.1
 */
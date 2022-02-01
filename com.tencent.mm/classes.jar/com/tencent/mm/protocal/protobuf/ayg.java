package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayg
  extends cvp
{
  public boolean GvO;
  public int GvP;
  public int GvQ;
  public tg GvR;
  public boolean GvS;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114007);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114007);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.bt(4, this.GvO);
      paramVarArgs.aS(5, this.GvP);
      paramVarArgs.aS(6, this.GvQ);
      if (this.GvR != null)
      {
        paramVarArgs.lC(7, this.GvR.computeSize());
        this.GvR.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(8, this.GvS);
      AppMethodBeat.o(114007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.alV(4) + f.a.a.b.b.a.bz(5, this.GvP) + f.a.a.b.b.a.bz(6, this.GvQ);
      paramInt = i;
      if (this.GvR != null) {
        paramInt = i + f.a.a.a.lB(7, this.GvR.computeSize());
      }
      i = f.a.a.b.b.a.alV(8);
      AppMethodBeat.o(114007);
      return paramInt + i;
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
          AppMethodBeat.o(114007);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayg localayg = (ayg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114007);
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
            localayg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        case 2: 
          localayg.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114007);
          return 0;
        case 3: 
          localayg.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114007);
          return 0;
        case 4: 
          localayg.GvO = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(114007);
          return 0;
        case 5: 
          localayg.GvP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114007);
          return 0;
        case 6: 
          localayg.GvQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114007);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayg.GvR = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        }
        localayg.GvS = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(114007);
        return 0;
      }
      AppMethodBeat.o(114007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayg
 * JD-Core Version:    0.7.0.1
 */
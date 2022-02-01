package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bee
  extends cvp
{
  public sx GAp;
  public tc GAs;
  public sz GAt;
  public String GAu;
  public int GwY;
  public int ozR;
  public String ozS;
  public int pjW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(215421);
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
      if (this.GAs != null)
      {
        paramVarArgs.lC(4, this.GAs.computeSize());
        this.GAs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.pjW);
      paramVarArgs.aS(6, this.GwY);
      if (this.GAt != null)
      {
        paramVarArgs.lC(7, this.GAt.computeSize());
        this.GAt.writeFields(paramVarArgs);
      }
      if (this.GAp != null)
      {
        paramVarArgs.lC(8, this.GAp.computeSize());
        this.GAp.writeFields(paramVarArgs);
      }
      if (this.GAu != null) {
        paramVarArgs.d(9, this.GAu);
      }
      AppMethodBeat.o(215421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.GAs != null) {
        i = paramInt + f.a.a.a.lB(4, this.GAs.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(5, this.pjW) + f.a.a.b.b.a.bz(6, this.GwY);
      paramInt = i;
      if (this.GAt != null) {
        paramInt = i + f.a.a.a.lB(7, this.GAt.computeSize());
      }
      i = paramInt;
      if (this.GAp != null) {
        i = paramInt + f.a.a.a.lB(8, this.GAp.computeSize());
      }
      paramInt = i;
      if (this.GAu != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GAu);
      }
      AppMethodBeat.o(215421);
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
          AppMethodBeat.o(215421);
          throw paramVarArgs;
        }
        AppMethodBeat.o(215421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bee localbee = (bee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215421);
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
            localbee.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215421);
          return 0;
        case 2: 
          localbee.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215421);
          return 0;
        case 3: 
          localbee.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215421);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbee.GAs = ((tc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215421);
          return 0;
        case 5: 
          localbee.pjW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215421);
          return 0;
        case 6: 
          localbee.GwY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215421);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbee.GAt = ((sz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215421);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbee.GAp = ((sx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215421);
          return 0;
        }
        localbee.GAu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215421);
        return 0;
      }
      AppMethodBeat.o(215421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bee
 * JD-Core Version:    0.7.0.1
 */
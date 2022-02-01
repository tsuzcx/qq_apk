package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auo
  extends ckq
{
  public int Dun;
  public int Duo;
  public String Dup;
  public int Duq;
  public String mAQ;
  public int uKQ;
  public int uKR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152570);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      paramVarArgs.aR(3, this.Dun);
      paramVarArgs.aR(4, this.Duo);
      if (this.Dup != null) {
        paramVarArgs.d(5, this.Dup);
      }
      paramVarArgs.aR(6, this.uKQ);
      paramVarArgs.aR(7, this.uKR);
      paramVarArgs.aR(8, this.Duq);
      AppMethodBeat.o(152570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = i + f.a.a.b.b.a.bA(3, this.Dun) + f.a.a.b.b.a.bA(4, this.Duo);
      paramInt = i;
      if (this.Dup != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Dup);
      }
      i = f.a.a.b.b.a.bA(6, this.uKQ);
      int j = f.a.a.b.b.a.bA(7, this.uKR);
      int k = f.a.a.b.b.a.bA(8, this.Duq);
      AppMethodBeat.o(152570);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auo localauo = (auo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152570);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauo.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152570);
          return 0;
        case 2: 
          localauo.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 3: 
          localauo.Dun = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152570);
          return 0;
        case 4: 
          localauo.Duo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152570);
          return 0;
        case 5: 
          localauo.Dup = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 6: 
          localauo.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152570);
          return 0;
        case 7: 
          localauo.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152570);
          return 0;
        }
        localauo.Duq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152570);
        return 0;
      }
      AppMethodBeat.o(152570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auo
 * JD-Core Version:    0.7.0.1
 */
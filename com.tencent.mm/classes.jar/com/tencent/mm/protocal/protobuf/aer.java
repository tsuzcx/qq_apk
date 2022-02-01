package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aer
  extends cvw
{
  public int FMa;
  public String GuT;
  public int GuU;
  public int GuV;
  public int doj;
  public String dwb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147761);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      if (this.GuT != null) {
        paramVarArgs.d(3, this.GuT);
      }
      paramVarArgs.aS(4, this.GuU);
      paramVarArgs.aS(5, this.doj);
      paramVarArgs.aS(6, this.GuV);
      paramVarArgs.aS(7, this.FMa);
      AppMethodBeat.o(147761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwb);
      }
      i = paramInt;
      if (this.GuT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GuT);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GuU);
      int j = f.a.a.b.b.a.bz(5, this.doj);
      int k = f.a.a.b.b.a.bz(6, this.GuV);
      int m = f.a.a.b.b.a.bz(7, this.FMa);
      AppMethodBeat.o(147761);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147761);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aer localaer = (aer)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147761);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaer.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147761);
          return 0;
        case 2: 
          localaer.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147761);
          return 0;
        case 3: 
          localaer.GuT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147761);
          return 0;
        case 4: 
          localaer.GuU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(147761);
          return 0;
        case 5: 
          localaer.doj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(147761);
          return 0;
        case 6: 
          localaer.GuV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(147761);
          return 0;
        }
        localaer.FMa = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(147761);
        return 0;
      }
      AppMethodBeat.o(147761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aer
 * JD-Core Version:    0.7.0.1
 */
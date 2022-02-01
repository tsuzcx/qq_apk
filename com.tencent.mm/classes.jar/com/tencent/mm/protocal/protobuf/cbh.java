package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbh
  extends cvw
{
  public String HoC;
  public int HoD;
  public int HoE;
  public int HoF;
  public int dJd;
  public String dwb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74664);
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
      if (this.HoC != null) {
        paramVarArgs.d(3, this.HoC);
      }
      paramVarArgs.aS(4, this.HoD);
      paramVarArgs.aS(5, this.HoE);
      paramVarArgs.aS(6, this.HoF);
      paramVarArgs.aS(7, this.dJd);
      AppMethodBeat.o(74664);
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
      if (this.HoC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HoC);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HoD);
      int j = f.a.a.b.b.a.bz(5, this.HoE);
      int k = f.a.a.b.b.a.bz(6, this.HoF);
      int m = f.a.a.b.b.a.bz(7, this.dJd);
      AppMethodBeat.o(74664);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(74664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbh localcbh = (cbh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74664);
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
            localcbh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74664);
          return 0;
        case 2: 
          localcbh.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(74664);
          return 0;
        case 3: 
          localcbh.HoC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(74664);
          return 0;
        case 4: 
          localcbh.HoD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(74664);
          return 0;
        case 5: 
          localcbh.HoE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(74664);
          return 0;
        case 6: 
          localcbh.HoF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(74664);
          return 0;
        }
        localcbh.dJd = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(74664);
        return 0;
      }
      AppMethodBeat.o(74664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbh
 * JD-Core Version:    0.7.0.1
 */
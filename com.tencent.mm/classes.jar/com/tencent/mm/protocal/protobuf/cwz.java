package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwz
  extends cvc
{
  public int FtC;
  public String GEp;
  public int dnh;
  public String duW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147776);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      if (this.GEp != null) {
        paramVarArgs.d(3, this.GEp);
      }
      paramVarArgs.aS(4, this.dnh);
      paramVarArgs.aS(5, this.FtC);
      AppMethodBeat.o(147776);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.duW);
      }
      i = paramInt;
      if (this.GEp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GEp);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.dnh);
      int j = f.a.a.b.b.a.bz(5, this.FtC);
      AppMethodBeat.o(147776);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147776);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwz localcwz = (cwz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147776);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147776);
          return 0;
        case 2: 
          localcwz.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147776);
          return 0;
        case 3: 
          localcwz.GEp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147776);
          return 0;
        case 4: 
          localcwz.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(147776);
          return 0;
        }
        localcwz.FtC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(147776);
        return 0;
      }
      AppMethodBeat.o(147776);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwz
 * JD-Core Version:    0.7.0.1
 */
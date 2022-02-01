package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cps
  extends cvw
{
  public String GeJ;
  public boolean HBL;
  public int HBM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72566);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GeJ != null) {
        paramVarArgs.d(2, this.GeJ);
      }
      paramVarArgs.bC(3, this.HBL);
      paramVarArgs.aS(4, this.HBM);
      AppMethodBeat.o(72566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GeJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GeJ);
      }
      paramInt = f.a.a.b.b.a.amF(3);
      int j = f.a.a.b.b.a.bz(4, this.HBM);
      AppMethodBeat.o(72566);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72566);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cps localcps = (cps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72566);
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
            localcps.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72566);
          return 0;
        case 2: 
          localcps.GeJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72566);
          return 0;
        case 3: 
          localcps.HBL = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(72566);
          return 0;
        }
        localcps.HBM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72566);
        return 0;
      }
      AppMethodBeat.o(72566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cps
 * JD-Core Version:    0.7.0.1
 */
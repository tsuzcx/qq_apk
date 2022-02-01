package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aff
  extends cvc
{
  public int Gdp;
  public int Gdq;
  public int xbr;
  public long xbt;
  public int xcK;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127170);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xbr);
      paramVarArgs.aS(3, this.xcK);
      paramVarArgs.aS(4, this.xcL);
      paramVarArgs.aS(5, this.Gdp);
      paramVarArgs.aS(6, this.Gdq);
      paramVarArgs.aY(7, this.xbt);
      AppMethodBeat.o(127170);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.xbr);
      int j = f.a.a.b.b.a.bz(3, this.xcK);
      int k = f.a.a.b.b.a.bz(4, this.xcL);
      int m = f.a.a.b.b.a.bz(5, this.Gdp);
      int n = f.a.a.b.b.a.bz(6, this.Gdq);
      int i1 = f.a.a.b.b.a.p(7, this.xbt);
      AppMethodBeat.o(127170);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127170);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aff localaff = (aff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127170);
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
            localaff.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127170);
          return 0;
        case 2: 
          localaff.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127170);
          return 0;
        case 3: 
          localaff.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127170);
          return 0;
        case 4: 
          localaff.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127170);
          return 0;
        case 5: 
          localaff.Gdp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127170);
          return 0;
        case 6: 
          localaff.Gdq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127170);
          return 0;
        }
        localaff.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(127170);
        return 0;
      }
      AppMethodBeat.o(127170);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aff
 * JD-Core Version:    0.7.0.1
 */
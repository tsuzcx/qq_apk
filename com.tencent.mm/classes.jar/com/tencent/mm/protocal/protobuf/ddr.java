package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ddr
  extends cvc
{
  public LinkedList<Integer> FCj;
  public String Hse;
  public int Scene;
  public int nDi;
  
  public ddr()
  {
    AppMethodBeat.i(127502);
    this.FCj = new LinkedList();
    AppMethodBeat.o(127502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127503);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hse != null) {
        paramVarArgs.d(2, this.Hse);
      }
      paramVarArgs.aS(3, this.Scene);
      paramVarArgs.aS(4, this.nDi);
      paramVarArgs.f(5, 2, this.FCj);
      AppMethodBeat.o(127503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label537;
      }
    }
    label537:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hse != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hse);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Scene);
      int j = f.a.a.b.b.a.bz(4, this.nDi);
      int k = f.a.a.a.d(5, 2, this.FCj);
      AppMethodBeat.o(127503);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FCj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddr localddr = (ddr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127503);
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
            localddr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127503);
          return 0;
        case 2: 
          localddr.Hse = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127503);
          return 0;
        case 3: 
          localddr.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127503);
          return 0;
        case 4: 
          localddr.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127503);
          return 0;
        }
        localddr.FCj = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
        AppMethodBeat.o(127503);
        return 0;
      }
      AppMethodBeat.o(127503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddr
 * JD-Core Version:    0.7.0.1
 */
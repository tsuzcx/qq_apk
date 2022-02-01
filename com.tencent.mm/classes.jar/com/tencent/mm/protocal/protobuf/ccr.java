package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ccr
  extends com.tencent.mm.bx.a
{
  public int FRq;
  public SKBuiltinBuffer_t FRr;
  public String FzJ;
  public zv GWT;
  public int GWU;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133186);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GWT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.FRr == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.GWT != null)
      {
        paramVarArgs.lC(1, this.GWT.computeSize());
        this.GWT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FRq);
      if (this.FRr != null)
      {
        paramVarArgs.lC(3, this.FRr.computeSize());
        this.FRr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.Scene);
      if (this.FzJ != null) {
        paramVarArgs.d(5, this.FzJ);
      }
      paramVarArgs.aS(6, this.GWU);
      AppMethodBeat.o(133186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GWT == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lB(1, this.GWT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FRq);
      paramInt = i;
      if (this.FRr != null) {
        paramInt = i + f.a.a.a.lB(3, this.FRr.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.FzJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FzJ);
      }
      i = f.a.a.b.b.a.bz(6, this.GWU);
      AppMethodBeat.o(133186);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GWT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        if (this.FRr == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133186);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccr localccr = (ccr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133186);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccr.GWT = ((zv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 2: 
          localccr.FRq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133186);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccr.FRr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 4: 
          localccr.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133186);
          return 0;
        case 5: 
          localccr.FzJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133186);
          return 0;
        }
        localccr.GWU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133186);
        return 0;
      }
      AppMethodBeat.o(133186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccr
 * JD-Core Version:    0.7.0.1
 */
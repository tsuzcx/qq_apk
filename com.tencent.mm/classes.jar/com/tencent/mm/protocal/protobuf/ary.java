package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ary
  extends com.tencent.mm.bx.a
{
  public int CxE;
  public cmf Dsg;
  public int Dsh;
  public int Dsi;
  public int Dsj = 1;
  public int Dsk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dsg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatroomId");
        AppMethodBeat.o(101809);
        throw paramVarArgs;
      }
      if (this.Dsg != null)
      {
        paramVarArgs.kX(1, this.Dsg.computeSize());
        this.Dsg.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CxE);
      paramVarArgs.aR(3, this.Dsh);
      paramVarArgs.aR(4, this.Dsi);
      paramVarArgs.aR(5, this.Dsj);
      paramVarArgs.aR(6, this.Dsk);
      AppMethodBeat.o(101809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dsg == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.kW(1, this.Dsg.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.CxE);
      int j = f.a.a.b.b.a.bA(3, this.Dsh);
      int k = f.a.a.b.b.a.bA(4, this.Dsi);
      int m = f.a.a.b.b.a.bA(5, this.Dsj);
      int n = f.a.a.b.b.a.bA(6, this.Dsk);
      AppMethodBeat.o(101809);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dsg == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatroomId");
          AppMethodBeat.o(101809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ary localary = (ary)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101809);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localary.Dsg = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101809);
          return 0;
        case 2: 
          localary.CxE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101809);
          return 0;
        case 3: 
          localary.Dsh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101809);
          return 0;
        case 4: 
          localary.Dsi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101809);
          return 0;
        case 5: 
          localary.Dsj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101809);
          return 0;
        }
        localary.Dsk = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(101809);
        return 0;
      }
      AppMethodBeat.o(101809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ary
 * JD-Core Version:    0.7.0.1
 */
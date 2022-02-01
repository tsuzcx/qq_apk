package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnf
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b GHe;
  public int GHf;
  public LinkedList<bnh> GHg;
  public LinkedList<Integer> GHh;
  
  public bnf()
  {
    AppMethodBeat.i(115842);
    this.GHg = new LinkedList();
    this.GHh = new LinkedList();
    AppMethodBeat.o(115842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GHe == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: RawBuf");
        AppMethodBeat.o(115843);
        throw paramVarArgs;
      }
      if (this.GHe != null) {
        paramVarArgs.c(1, this.GHe);
      }
      paramVarArgs.aS(2, this.GHf);
      paramVarArgs.e(3, 8, this.GHg);
      paramVarArgs.e(4, 2, this.GHh);
      AppMethodBeat.o(115843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GHe == null) {
        break label513;
      }
    }
    label513:
    for (paramInt = f.a.a.b.b.a.b(1, this.GHe) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GHf);
      int j = f.a.a.a.c(3, 8, this.GHg);
      int k = f.a.a.a.c(4, 2, this.GHh);
      AppMethodBeat.o(115843);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GHg.clear();
        this.GHh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GHe == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: RawBuf");
          AppMethodBeat.o(115843);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnf localbnf = (bnf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115843);
          return -1;
        case 1: 
          localbnf.GHe = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(115843);
          return 0;
        case 2: 
          localbnf.GHf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115843);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bnh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbnf.GHg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115843);
          return 0;
        }
        localbnf.GHh.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
        AppMethodBeat.o(115843);
        return 0;
      }
      AppMethodBeat.o(115843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnf
 * JD-Core Version:    0.7.0.1
 */
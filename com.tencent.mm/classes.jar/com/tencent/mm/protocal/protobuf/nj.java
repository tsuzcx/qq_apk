package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nj
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b wCu;
  public com.tencent.mm.bv.b wCv;
  public LinkedList<bzv> wCw;
  
  public nj()
  {
    AppMethodBeat.i(124301);
    this.wCw = new LinkedList();
    AppMethodBeat.o(124301);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124302);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wCu == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(124302);
        throw paramVarArgs;
      }
      if (this.wCv == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: ServiceUrl");
        AppMethodBeat.o(124302);
        throw paramVarArgs;
      }
      if (this.wCu != null) {
        paramVarArgs.c(1, this.wCu);
      }
      if (this.wCv != null) {
        paramVarArgs.c(2, this.wCv);
      }
      paramVarArgs.e(3, 8, this.wCw);
      AppMethodBeat.o(124302);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wCu == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = e.a.a.b.b.a.b(1, this.wCu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wCv != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.wCv);
      }
      paramInt = e.a.a.a.c(3, 8, this.wCw);
      AppMethodBeat.o(124302);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wCw.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wCu == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: Title");
          AppMethodBeat.o(124302);
          throw paramVarArgs;
        }
        if (this.wCv == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: ServiceUrl");
          AppMethodBeat.o(124302);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124302);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        nj localnj = (nj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124302);
          return -1;
        case 1: 
          localnj.wCu = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(124302);
          return 0;
        case 2: 
          localnj.wCv = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(124302);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzv();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bzv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localnj.wCw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124302);
        return 0;
      }
      AppMethodBeat.o(124302);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nj
 * JD-Core Version:    0.7.0.1
 */
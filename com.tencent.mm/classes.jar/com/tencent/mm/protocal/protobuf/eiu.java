package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eiu
  extends com.tencent.mm.bw.a
{
  public String Nil;
  public String Nim;
  public LinkedList<any> Nin;
  
  public eiu()
  {
    AppMethodBeat.i(153008);
    this.Nin = new LinkedList();
    AppMethodBeat.o(153008);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153009);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nil != null) {
        paramVarArgs.e(1, this.Nil);
      }
      if (this.Nim != null) {
        paramVarArgs.e(2, this.Nim);
      }
      paramVarArgs.e(3, 8, this.Nin);
      AppMethodBeat.o(153009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nil == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = g.a.a.b.b.a.f(1, this.Nil) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nim != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Nim);
      }
      paramInt = g.a.a.a.c(3, 8, this.Nin);
      AppMethodBeat.o(153009);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nin.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eiu localeiu = (eiu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153009);
          return -1;
        case 1: 
          localeiu.Nil = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153009);
          return 0;
        case 2: 
          localeiu.Nim = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153009);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new any();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((any)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeiu.Nin.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      AppMethodBeat.o(153009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiu
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cng
  extends com.tencent.mm.bw.a
{
  public LinkedList<bta> Hzp;
  public String id;
  
  public cng()
  {
    AppMethodBeat.i(196279);
    this.Hzp = new LinkedList();
    AppMethodBeat.o(196279);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196280);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new b("Not all required fields were included: id");
        AppMethodBeat.o(196280);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      paramVarArgs.e(2, 8, this.Hzp);
      AppMethodBeat.o(196280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Hzp);
      AppMethodBeat.o(196280);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hzp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new b("Not all required fields were included: id");
          AppMethodBeat.o(196280);
          throw paramVarArgs;
        }
        AppMethodBeat.o(196280);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cng localcng = (cng)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196280);
          return -1;
        case 1: 
          localcng.id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196280);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bta();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcng.Hzp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(196280);
        return 0;
      }
      AppMethodBeat.o(196280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cng
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rb
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b Gfv;
  public com.tencent.mm.bw.b Gfw;
  public LinkedList<dbr> Gfx;
  
  public rb()
  {
    AppMethodBeat.i(117851);
    this.Gfx = new LinkedList();
    AppMethodBeat.o(117851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117852);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gfv == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(117852);
        throw paramVarArgs;
      }
      if (this.Gfw == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ServiceUrl");
        AppMethodBeat.o(117852);
        throw paramVarArgs;
      }
      if (this.Gfv != null) {
        paramVarArgs.c(1, this.Gfv);
      }
      if (this.Gfw != null) {
        paramVarArgs.c(2, this.Gfw);
      }
      paramVarArgs.e(3, 8, this.Gfx);
      AppMethodBeat.o(117852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gfv == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.b.b.a.b(1, this.Gfv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gfw != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.Gfw);
      }
      paramInt = f.a.a.a.c(3, 8, this.Gfx);
      AppMethodBeat.o(117852);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gfx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gfv == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
          AppMethodBeat.o(117852);
          throw paramVarArgs;
        }
        if (this.Gfw == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: ServiceUrl");
          AppMethodBeat.o(117852);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117852);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rb localrb = (rb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117852);
          return -1;
        case 1: 
          localrb.Gfv = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(117852);
          return 0;
        case 2: 
          localrb.Gfw = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(117852);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dbr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrb.Gfx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117852);
        return 0;
      }
      AppMethodBeat.o(117852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rb
 * JD-Core Version:    0.7.0.1
 */
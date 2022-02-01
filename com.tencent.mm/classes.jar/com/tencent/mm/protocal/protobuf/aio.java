package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aio
  extends com.tencent.mm.bw.a
{
  public String EDk;
  public long EDl;
  public String EDm;
  public LinkedList<aim> EDn;
  public int ndD;
  
  public aio()
  {
    AppMethodBeat.i(110849);
    this.EDn = new LinkedList();
    AppMethodBeat.o(110849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110850);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EDk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.EDm == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.EDk != null) {
        paramVarArgs.d(1, this.EDk);
      }
      paramVarArgs.aO(2, this.EDl);
      paramVarArgs.aR(3, this.ndD);
      if (this.EDm != null) {
        paramVarArgs.d(4, this.EDm);
      }
      paramVarArgs.e(5, 8, this.EDn);
      AppMethodBeat.o(110850);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EDk == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.EDk) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.EDl) + f.a.a.b.b.a.bx(3, this.ndD);
      paramInt = i;
      if (this.EDm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EDm);
      }
      i = f.a.a.a.c(5, 8, this.EDn);
      AppMethodBeat.o(110850);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EDn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EDk == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        if (this.EDm == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110850);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aio localaio = (aio)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110850);
          return -1;
        case 1: 
          localaio.EDk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110850);
          return 0;
        case 2: 
          localaio.EDl = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(110850);
          return 0;
        case 3: 
          localaio.ndD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(110850);
          return 0;
        case 4: 
          localaio.EDm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110850);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aim();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aim)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaio.EDn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110850);
        return 0;
      }
      AppMethodBeat.o(110850);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aio
 * JD-Core Version:    0.7.0.1
 */
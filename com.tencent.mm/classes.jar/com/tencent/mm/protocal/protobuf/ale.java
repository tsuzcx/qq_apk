package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ale
  extends com.tencent.mm.bx.a
{
  public String GkU;
  public long GkV;
  public String GkW;
  public LinkedList<alc> GkX;
  public int nEa;
  
  public ale()
  {
    AppMethodBeat.i(110849);
    this.GkX = new LinkedList();
    AppMethodBeat.o(110849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110850);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GkU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.GkW == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.GkU != null) {
        paramVarArgs.d(1, this.GkU);
      }
      paramVarArgs.aY(2, this.GkV);
      paramVarArgs.aS(3, this.nEa);
      if (this.GkW != null) {
        paramVarArgs.d(4, this.GkW);
      }
      paramVarArgs.e(5, 8, this.GkX);
      AppMethodBeat.o(110850);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GkU == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.GkU) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GkV) + f.a.a.b.b.a.bz(3, this.nEa);
      paramInt = i;
      if (this.GkW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GkW);
      }
      i = f.a.a.a.c(5, 8, this.GkX);
      AppMethodBeat.o(110850);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GkX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GkU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        if (this.GkW == null)
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
        ale localale = (ale)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110850);
          return -1;
        case 1: 
          localale.GkU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110850);
          return 0;
        case 2: 
          localale.GkV = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(110850);
          return 0;
        case 3: 
          localale.nEa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(110850);
          return 0;
        case 4: 
          localale.GkW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110850);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((alc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localale.GkX.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ale
 * JD-Core Version:    0.7.0.1
 */
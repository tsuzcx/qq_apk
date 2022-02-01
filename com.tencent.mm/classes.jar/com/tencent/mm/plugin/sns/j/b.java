package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpi;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public bpi dyS;
  public int hgr;
  public String wNP;
  public int wNQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96151);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyS != null)
      {
        paramVarArgs.kX(1, this.dyS.computeSize());
        this.dyS.writeFields(paramVarArgs);
      }
      if (this.wNP != null) {
        paramVarArgs.d(2, this.wNP);
      }
      paramVarArgs.aR(3, this.hgr);
      paramVarArgs.aR(4, this.wNQ);
      AppMethodBeat.o(96151);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyS == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.a.kW(1, this.dyS.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wNP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.wNP);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.hgr);
      int j = f.a.a.b.b.a.bA(4, this.wNQ);
      AppMethodBeat.o(96151);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(96151);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96151);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bpi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.dyS = ((bpi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96151);
          return 0;
        case 2: 
          localb.wNP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(96151);
          return 0;
        case 3: 
          localb.hgr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(96151);
          return 0;
        }
        localb.wNQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(96151);
        return 0;
      }
      AppMethodBeat.o(96151);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.b
 * JD-Core Version:    0.7.0.1
 */
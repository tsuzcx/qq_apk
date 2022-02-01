package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqm
  extends com.tencent.mm.bx.a
{
  public String DDP;
  public String Ejq;
  public LinkedList<cql> Ejy;
  public String pZX;
  
  public cqm()
  {
    AppMethodBeat.i(122532);
    this.Ejy = new LinkedList();
    AppMethodBeat.o(122532);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pZX != null) {
        paramVarArgs.d(1, this.pZX);
      }
      if (this.Ejq != null) {
        paramVarArgs.d(2, this.Ejq);
      }
      if (this.DDP != null) {
        paramVarArgs.d(3, this.DDP);
      }
      paramVarArgs.e(4, 8, this.Ejy);
      AppMethodBeat.o(122533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pZX == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.b.b.a.e(1, this.pZX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ejq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ejq);
      }
      i = paramInt;
      if (this.DDP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DDP);
      }
      paramInt = f.a.a.a.c(4, 8, this.Ejy);
      AppMethodBeat.o(122533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ejy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqm localcqm = (cqm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122533);
          return -1;
        case 1: 
          localcqm.pZX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 2: 
          localcqm.Ejq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 3: 
          localcqm.DDP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122533);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cql();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqm.Ejy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      AppMethodBeat.o(122533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbz
  extends com.tencent.mm.bw.a
{
  public LinkedList<dby> HKA;
  public String HKs;
  public String duQ;
  public String rfp;
  
  public dbz()
  {
    AppMethodBeat.i(122532);
    this.HKA = new LinkedList();
    AppMethodBeat.o(122532);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rfp != null) {
        paramVarArgs.d(1, this.rfp);
      }
      if (this.HKs != null) {
        paramVarArgs.d(2, this.HKs);
      }
      if (this.duQ != null) {
        paramVarArgs.d(3, this.duQ);
      }
      paramVarArgs.e(4, 8, this.HKA);
      AppMethodBeat.o(122533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rfp == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.b.b.a.e(1, this.rfp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HKs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HKs);
      }
      i = paramInt;
      if (this.duQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.duQ);
      }
      paramInt = f.a.a.a.c(4, 8, this.HKA);
      AppMethodBeat.o(122533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HKA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbz localdbz = (dbz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122533);
          return -1;
        case 1: 
          localdbz.rfp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 2: 
          localdbz.HKs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 3: 
          localdbz.duQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122533);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dby();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dby)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbz.HKA.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbz
 * JD-Core Version:    0.7.0.1
 */
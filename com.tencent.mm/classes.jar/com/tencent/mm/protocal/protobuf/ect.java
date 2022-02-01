package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ect
  extends com.tencent.mm.bw.a
{
  public String IhS;
  public String IhT;
  public edf IhU;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197209);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IhS != null) {
        paramVarArgs.d(1, this.IhS);
      }
      if (this.IhT != null) {
        paramVarArgs.d(2, this.IhT);
      }
      if (this.IhU != null)
      {
        paramVarArgs.lJ(3, this.IhU.computeSize());
        this.IhU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.type);
      AppMethodBeat.o(197209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IhS == null) {
        break label474;
      }
    }
    label474:
    for (int i = f.a.a.b.b.a.e(1, this.IhS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IhT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IhT);
      }
      i = paramInt;
      if (this.IhU != null) {
        i = paramInt + f.a.a.a.lI(3, this.IhU.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.type);
      AppMethodBeat.o(197209);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197209);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ect localect = (ect)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197209);
          return -1;
        case 1: 
          localect.IhS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197209);
          return 0;
        case 2: 
          localect.IhT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197209);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((edf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localect.IhU = ((edf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197209);
          return 0;
        }
        localect.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(197209);
        return 0;
      }
      AppMethodBeat.o(197209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ect
 * JD-Core Version:    0.7.0.1
 */
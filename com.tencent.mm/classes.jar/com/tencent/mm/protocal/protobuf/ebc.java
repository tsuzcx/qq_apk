package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebc
  extends com.tencent.mm.bx.a
{
  public String HNL;
  public String HNM;
  public ebo HNN;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209420);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HNL != null) {
        paramVarArgs.d(1, this.HNL);
      }
      if (this.HNM != null) {
        paramVarArgs.d(2, this.HNM);
      }
      if (this.HNN != null)
      {
        paramVarArgs.lC(3, this.HNN.computeSize());
        this.HNN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.type);
      AppMethodBeat.o(209420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HNL == null) {
        break label474;
      }
    }
    label474:
    for (int i = f.a.a.b.b.a.e(1, this.HNL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HNM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HNM);
      }
      i = paramInt;
      if (this.HNN != null) {
        i = paramInt + f.a.a.a.lB(3, this.HNN.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.type);
      AppMethodBeat.o(209420);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebc localebc = (ebc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209420);
          return -1;
        case 1: 
          localebc.HNL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209420);
          return 0;
        case 2: 
          localebc.HNM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209420);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ebo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebc.HNN = ((ebo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209420);
          return 0;
        }
        localebc.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209420);
        return 0;
      }
      AppMethodBeat.o(209420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebc
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gp
  extends com.tencent.mm.bx.a
{
  public ces FyG;
  public LinkedList<ces> FyH;
  public String dpf;
  public String dvs;
  
  public gp()
  {
    AppMethodBeat.i(152496);
    this.FyH = new LinkedList();
    AppMethodBeat.o(152496);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152497);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvs != null) {
        paramVarArgs.d(1, this.dvs);
      }
      if (this.FyG != null)
      {
        paramVarArgs.lC(2, this.FyG.computeSize());
        this.FyG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.FyH);
      if (this.dpf != null) {
        paramVarArgs.d(4, this.dpf);
      }
      AppMethodBeat.o(152497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvs == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.b.b.a.e(1, this.dvs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FyG != null) {
        i = paramInt + f.a.a.a.lB(2, this.FyG.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.FyH);
      paramInt = i;
      if (this.dpf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dpf);
      }
      AppMethodBeat.o(152497);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FyH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152497);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gp localgp = (gp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152497);
          return -1;
        case 1: 
          localgp.dvs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152497);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ces();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ces)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgp.FyG = ((ces)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ces();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ces)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgp.FyH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        }
        localgp.dpf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152497);
        return 0;
      }
      AppMethodBeat.o(152497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gp
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brb
  extends com.tencent.mm.bw.a
{
  public String FUn;
  public dnl Heg;
  public LinkedList<dmr> Heh;
  public dnl Hei;
  
  public brb()
  {
    AppMethodBeat.i(91526);
    this.Heh = new LinkedList();
    AppMethodBeat.o(91526);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Heg != null)
      {
        paramVarArgs.lJ(1, this.Heg.computeSize());
        this.Heg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Heh);
      if (this.Hei != null)
      {
        paramVarArgs.lJ(3, this.Hei.computeSize());
        this.Hei.writeFields(paramVarArgs);
      }
      if (this.FUn != null) {
        paramVarArgs.d(4, this.FUn);
      }
      AppMethodBeat.o(91527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Heg == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = f.a.a.a.lI(1, this.Heg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Heh);
      paramInt = i;
      if (this.Hei != null) {
        paramInt = i + f.a.a.a.lI(3, this.Hei.computeSize());
      }
      i = paramInt;
      if (this.FUn != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FUn);
      }
      AppMethodBeat.o(91527);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Heh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91527);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brb localbrb = (brb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91527);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrb.Heg = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrb.Heh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrb.Hei = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        }
        localbrb.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91527);
        return 0;
      }
      AppMethodBeat.o(91527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brb
 * JD-Core Version:    0.7.0.1
 */
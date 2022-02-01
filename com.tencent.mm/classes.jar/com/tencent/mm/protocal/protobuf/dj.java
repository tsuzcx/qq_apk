package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dj
  extends com.tencent.mm.bw.a
{
  public dfw FOb;
  public cxn FOc;
  public int FOd;
  public cty FOe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125705);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FOb == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsADObject");
        AppMethodBeat.o(125705);
        throw paramVarArgs;
      }
      if (this.FOb != null)
      {
        paramVarArgs.lJ(1, this.FOb.computeSize());
        this.FOb.writeFields(paramVarArgs);
      }
      if (this.FOc != null)
      {
        paramVarArgs.lJ(2, this.FOc.computeSize());
        this.FOc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FOd);
      if (this.FOe != null)
      {
        paramVarArgs.lJ(4, this.FOe.computeSize());
        this.FOe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FOb == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = f.a.a.a.lI(1, this.FOb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FOc != null) {
        i = paramInt + f.a.a.a.lI(2, this.FOc.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.FOd);
      paramInt = i;
      if (this.FOe != null) {
        paramInt = i + f.a.a.a.lI(4, this.FOe.computeSize());
      }
      AppMethodBeat.o(125705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FOb == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsADObject");
          AppMethodBeat.o(125705);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dj localdj = (dj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125705);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdj.FOb = ((dfw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdj.FOc = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 3: 
          localdj.FOd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125705);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cty();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdj.FOe = ((cty)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      AppMethodBeat.o(125705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dj
 * JD-Core Version:    0.7.0.1
 */
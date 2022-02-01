package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aae
  extends com.tencent.mm.bw.a
{
  public cfl IoL;
  public cfl IoM;
  public LinkedList<cfz> Llq;
  public String subtitle;
  public String title;
  
  public aae()
  {
    AppMethodBeat.i(72460);
    this.Llq = new LinkedList();
    AppMethodBeat.o(72460);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72461);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.subtitle != null) {
        paramVarArgs.e(2, this.subtitle);
      }
      paramVarArgs.e(3, 8, this.Llq);
      if (this.IoL != null)
      {
        paramVarArgs.ni(4, this.IoL.computeSize());
        this.IoL.writeFields(paramVarArgs);
      }
      if (this.IoM != null)
      {
        paramVarArgs.ni(5, this.IoM.computeSize());
        this.IoM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = g.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.subtitle != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.subtitle);
      }
      i += g.a.a.a.c(3, 8, this.Llq);
      paramInt = i;
      if (this.IoL != null) {
        paramInt = i + g.a.a.a.nh(4, this.IoL.computeSize());
      }
      i = paramInt;
      if (this.IoM != null) {
        i = paramInt + g.a.a.a.nh(5, this.IoM.computeSize());
      }
      AppMethodBeat.o(72461);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Llq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aae localaae = (aae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72461);
          return -1;
        case 1: 
          localaae.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 2: 
          localaae.subtitle = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaae.Llq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaae.IoL = ((cfl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaae.IoM = ((cfl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      AppMethodBeat.o(72461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aae
 * JD-Core Version:    0.7.0.1
 */
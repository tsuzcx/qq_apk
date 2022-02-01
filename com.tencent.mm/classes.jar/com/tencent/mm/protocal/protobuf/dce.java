package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dce
  extends com.tencent.mm.bw.a
{
  public String MGW;
  public LinkedList<dcf> MGX;
  public LinkedList<dcl> MGY;
  public LinkedList<dcl> MGZ;
  
  public dce()
  {
    AppMethodBeat.i(209778);
    this.MGX = new LinkedList();
    this.MGY = new LinkedList();
    this.MGZ = new LinkedList();
    AppMethodBeat.o(209778);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209779);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MGW != null) {
        paramVarArgs.e(1, this.MGW);
      }
      paramVarArgs.e(2, 8, this.MGX);
      paramVarArgs.e(3, 8, this.MGY);
      paramVarArgs.e(4, 8, this.MGZ);
      AppMethodBeat.o(209779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MGW == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = g.a.a.b.b.a.f(1, this.MGW) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.MGX);
      int j = g.a.a.a.c(3, 8, this.MGY);
      int k = g.a.a.a.c(4, 8, this.MGZ);
      AppMethodBeat.o(209779);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MGX.clear();
        this.MGY.clear();
        this.MGZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209779);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dce localdce = (dce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209779);
          return -1;
        case 1: 
          localdce.MGW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209779);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdce.MGX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209779);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdce.MGY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209779);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdce.MGZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209779);
        return 0;
      }
      AppMethodBeat.o(209779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dce
 * JD-Core Version:    0.7.0.1
 */
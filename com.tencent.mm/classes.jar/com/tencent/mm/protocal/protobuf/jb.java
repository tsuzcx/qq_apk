package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jb
  extends com.tencent.mm.bw.a
{
  public cui KNA;
  public int KNB;
  public int KNC;
  public int KND;
  public cui KNx;
  public cui KNy;
  public cui KNz;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118406);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.KNx != null)
      {
        paramVarArgs.ni(2, this.KNx.computeSize());
        this.KNx.writeFields(paramVarArgs);
      }
      if (this.KNy != null)
      {
        paramVarArgs.ni(3, this.KNy.computeSize());
        this.KNy.writeFields(paramVarArgs);
      }
      if (this.KNz != null)
      {
        paramVarArgs.ni(4, this.KNz.computeSize());
        this.KNz.writeFields(paramVarArgs);
      }
      if (this.KNA != null)
      {
        paramVarArgs.ni(11, this.KNA.computeSize());
        this.KNA.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(100, this.KNB);
      paramVarArgs.aM(101, this.KNC);
      paramVarArgs.aM(102, this.KND);
      AppMethodBeat.o(118406);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.KNx != null) {
        paramInt = i + g.a.a.a.nh(2, this.KNx.computeSize());
      }
      i = paramInt;
      if (this.KNy != null) {
        i = paramInt + g.a.a.a.nh(3, this.KNy.computeSize());
      }
      paramInt = i;
      if (this.KNz != null) {
        paramInt = i + g.a.a.a.nh(4, this.KNz.computeSize());
      }
      i = paramInt;
      if (this.KNA != null) {
        i = paramInt + g.a.a.a.nh(11, this.KNA.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(100, this.KNB);
      int j = g.a.a.b.b.a.bu(101, this.KNC);
      int k = g.a.a.b.b.a.bu(102, this.KND);
      AppMethodBeat.o(118406);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(118406);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      jb localjb = (jb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118406);
        return -1;
      case 1: 
        localjb.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118406);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cui();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cui)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localjb.KNx = ((cui)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cui();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cui)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localjb.KNy = ((cui)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cui();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cui)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localjb.KNz = ((cui)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cui();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cui)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localjb.KNA = ((cui)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 100: 
        localjb.KNB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118406);
        return 0;
      case 101: 
        localjb.KNC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118406);
        return 0;
      }
      localjb.KND = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(118406);
      return 0;
    }
    AppMethodBeat.o(118406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jb
 * JD-Core Version:    0.7.0.1
 */
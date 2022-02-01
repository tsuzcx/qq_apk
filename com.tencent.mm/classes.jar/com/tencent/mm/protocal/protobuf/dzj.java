package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dzj
  extends com.tencent.mm.bw.a
{
  public long Id;
  public long MZa;
  public dzi MZb;
  public dzi MZc;
  public String izX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125772);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MZb == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.Id);
      paramVarArgs.bb(2, this.MZa);
      if (this.MZb != null)
      {
        paramVarArgs.ni(3, this.MZb.computeSize());
        this.MZb.writeFields(paramVarArgs);
      }
      if (this.MZc != null)
      {
        paramVarArgs.ni(4, this.MZc.computeSize());
        this.MZc.writeFields(paramVarArgs);
      }
      if (this.izX != null) {
        paramVarArgs.e(5, this.izX);
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Id) + 0 + g.a.a.b.b.a.r(2, this.MZa);
      paramInt = i;
      if (this.MZb != null) {
        paramInt = i + g.a.a.a.nh(3, this.MZb.computeSize());
      }
      i = paramInt;
      if (this.MZc != null) {
        i = paramInt + g.a.a.a.nh(4, this.MZc.computeSize());
      }
      paramInt = i;
      if (this.izX != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.izX);
      }
      AppMethodBeat.o(125772);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.MZb == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dzj localdzj = (dzj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125772);
        return -1;
      case 1: 
        localdzj.Id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125772);
        return 0;
      case 2: 
        localdzj.MZa = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125772);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdzj.MZb = ((dzi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdzj.MZc = ((dzi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      }
      localdzj.izX = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(125772);
      return 0;
    }
    AppMethodBeat.o(125772);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzj
 * JD-Core Version:    0.7.0.1
 */
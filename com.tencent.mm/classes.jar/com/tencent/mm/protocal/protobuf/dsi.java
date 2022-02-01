package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dsi
  extends com.tencent.mm.bw.a
{
  public long KZg;
  public String LUZ;
  public int MUr;
  public LinkedList<eou> MUs;
  public chl MlQ;
  
  public dsi()
  {
    AppMethodBeat.i(117914);
    this.MUs = new LinkedList();
    AppMethodBeat.o(117914);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117915);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LUZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117915);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.KZg);
      if (this.LUZ != null) {
        paramVarArgs.e(2, this.LUZ);
      }
      if (this.MlQ != null)
      {
        paramVarArgs.ni(3, this.MlQ.computeSize());
        this.MlQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.MUr);
      paramVarArgs.e(5, 8, this.MUs);
      AppMethodBeat.o(117915);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.KZg) + 0;
      paramInt = i;
      if (this.LUZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LUZ);
      }
      i = paramInt;
      if (this.MlQ != null) {
        i = paramInt + g.a.a.a.nh(3, this.MlQ.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(4, this.MUr);
      int j = g.a.a.a.c(5, 8, this.MUs);
      AppMethodBeat.o(117915);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MUs.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.LUZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117915);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117915);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dsi localdsi = (dsi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117915);
        return -1;
      case 1: 
        localdsi.KZg = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(117915);
        return 0;
      case 2: 
        localdsi.LUZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117915);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdsi.MlQ = ((chl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117915);
        return 0;
      case 4: 
        localdsi.MUr = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117915);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new eou();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((eou)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdsi.MUs.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117915);
      return 0;
    }
    AppMethodBeat.o(117915);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsi
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class edp
  extends com.tencent.mm.bw.a
{
  public long Id;
  public String Lrr;
  public eea NdL;
  public LinkedList<Integer> NdW;
  public int Ndu;
  
  public edp()
  {
    AppMethodBeat.i(118447);
    this.NdW = new LinkedList();
    AppMethodBeat.o(118447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118448);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Id);
      if (this.Lrr != null) {
        paramVarArgs.e(2, this.Lrr);
      }
      if (this.NdL != null)
      {
        paramVarArgs.ni(3, this.NdL.computeSize());
        this.NdL.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.Ndu);
      paramVarArgs.f(5, 2, this.NdW);
      AppMethodBeat.o(118448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Id) + 0;
      paramInt = i;
      if (this.Lrr != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Lrr);
      }
      i = paramInt;
      if (this.NdL != null) {
        i = paramInt + g.a.a.a.nh(3, this.NdL.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Ndu);
      int j = g.a.a.a.d(5, 2, this.NdW);
      AppMethodBeat.o(118448);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NdW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(118448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      edp localedp = (edp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118448);
        return -1;
      case 1: 
        localedp.Id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(118448);
        return 0;
      case 2: 
        localedp.Lrr = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(118448);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eea();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eea)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localedp.NdL = ((eea)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118448);
        return 0;
      case 4: 
        localedp.Ndu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118448);
        return 0;
      }
      localedp.NdW = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
      AppMethodBeat.o(118448);
      return 0;
    }
    AppMethodBeat.o(118448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edp
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ddu
  extends com.tencent.mm.bw.a
{
  public String EvH;
  public int FMU;
  public def FNl;
  public LinkedList<Integer> FNy;
  public long Id;
  
  public ddu()
  {
    AppMethodBeat.i(118447);
    this.FNy = new LinkedList();
    AppMethodBeat.o(118447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Id);
      if (this.EvH != null) {
        paramVarArgs.d(2, this.EvH);
      }
      if (this.FNl != null)
      {
        paramVarArgs.ln(3, this.FNl.computeSize());
        this.FNl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.FMU);
      paramVarArgs.f(5, 2, this.FNy);
      AppMethodBeat.o(118448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.EvH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EvH);
      }
      i = paramInt;
      if (this.FNl != null) {
        i = paramInt + f.a.a.a.lm(3, this.FNl.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(4, this.FMU);
      int j = f.a.a.a.d(5, 2, this.FNy);
      AppMethodBeat.o(118448);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FNy.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(118448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ddu localddu = (ddu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118448);
        return -1;
      case 1: 
        localddu.Id = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(118448);
        return 0;
      case 2: 
        localddu.EvH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(118448);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new def();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((def)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localddu.FNl = ((def)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118448);
        return 0;
      case 4: 
        localddu.FMU = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118448);
        return 0;
      }
      localddu.FNy = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
      AppMethodBeat.o(118448);
      return 0;
    }
    AppMethodBeat.o(118448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddu
 * JD-Core Version:    0.7.0.1
 */
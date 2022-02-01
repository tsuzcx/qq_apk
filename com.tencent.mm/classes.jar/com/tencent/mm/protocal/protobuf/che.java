package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class che
  extends com.tencent.mm.bw.a
{
  public String DWw;
  public boolean Fvs;
  public czd Fvt;
  public czd Fvu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.Fvs);
      if (this.Fvt != null)
      {
        paramVarArgs.ln(2, this.Fvt.computeSize());
        this.Fvt.writeFields(paramVarArgs);
      }
      if (this.Fvu != null)
      {
        paramVarArgs.ln(3, this.Fvu.computeSize());
        this.Fvu.writeFields(paramVarArgs);
      }
      if (this.DWw != null) {
        paramVarArgs.d(4, this.DWw);
      }
      AppMethodBeat.o(91632);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.fK(1) + 1 + 0;
      paramInt = i;
      if (this.Fvt != null) {
        paramInt = i + f.a.a.a.lm(2, this.Fvt.computeSize());
      }
      i = paramInt;
      if (this.Fvu != null) {
        i = paramInt + f.a.a.a.lm(3, this.Fvu.computeSize());
      }
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DWw);
      }
      AppMethodBeat.o(91632);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91632);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      che localche = (che)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91632);
        return -1;
      case 1: 
        localche.Fvs = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(91632);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localche.Fvt = ((czd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localche.Fvu = ((czd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      }
      localche.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(91632);
      return 0;
    }
    AppMethodBeat.o(91632);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.che
 * JD-Core Version:    0.7.0.1
 */
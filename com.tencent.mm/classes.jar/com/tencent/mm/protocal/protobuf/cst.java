package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cst
  extends com.tencent.mm.bw.a
{
  public String EOf;
  public long EfR;
  public String EfU;
  public int EfV;
  public int FEV;
  public LinkedList<doh> FEW;
  public bpa FhT;
  public int Scene;
  
  public cst()
  {
    AppMethodBeat.i(117908);
    this.FEW = new LinkedList();
    AppMethodBeat.o(117908);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117909);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.EfR);
      if (this.EOf != null) {
        paramVarArgs.d(2, this.EOf);
      }
      paramVarArgs.aR(3, this.EfV);
      if (this.FhT != null)
      {
        paramVarArgs.ln(4, this.FhT.computeSize());
        this.FhT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.FEV);
      paramVarArgs.e(6, 8, this.FEW);
      paramVarArgs.aR(7, this.Scene);
      if (this.EfU != null) {
        paramVarArgs.d(8, this.EfU);
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.EfR) + 0;
      paramInt = i;
      if (this.EOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EOf);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.EfV);
      paramInt = i;
      if (this.FhT != null) {
        paramInt = i + f.a.a.a.lm(4, this.FhT.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FEV) + f.a.a.a.c(6, 8, this.FEW) + f.a.a.b.b.a.bx(7, this.Scene);
      paramInt = i;
      if (this.EfU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EfU);
      }
      AppMethodBeat.o(117909);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FEW.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.EOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cst localcst = (cst)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117909);
        return -1;
      case 1: 
        localcst.EfR = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(117909);
        return 0;
      case 2: 
        localcst.EOf = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117909);
        return 0;
      case 3: 
        localcst.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117909);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcst.FhT = ((bpa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 5: 
        localcst.FEV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117909);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcst.FEW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 7: 
        localcst.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117909);
        return 0;
      }
      localcst.EfU = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(117909);
      return 0;
    }
    AppMethodBeat.o(117909);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cst
 * JD-Core Version:    0.7.0.1
 */
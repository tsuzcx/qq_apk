package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crj
  extends com.tencent.mm.bw.a
{
  public LinkedList<acs> Eut;
  public dhm FEf;
  public acr FEg;
  public int FEh;
  public boolean FEi;
  public aae FEj;
  public bf FEk;
  public int type;
  public String url;
  
  public crj()
  {
    AppMethodBeat.i(91676);
    this.Eut = new LinkedList();
    AppMethodBeat.o(91676);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91677);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.FEf != null)
      {
        paramVarArgs.ln(3, this.FEf.computeSize());
        this.FEf.writeFields(paramVarArgs);
      }
      if (this.FEg != null)
      {
        paramVarArgs.ln(4, this.FEg.computeSize());
        this.FEg.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.FEh);
      paramVarArgs.bl(6, this.FEi);
      paramVarArgs.e(7, 8, this.Eut);
      if (this.FEj != null)
      {
        paramVarArgs.ln(8, this.FEj.computeSize());
        this.FEj.writeFields(paramVarArgs);
      }
      if (this.FEk != null)
      {
        paramVarArgs.ln(9, this.FEk.computeSize());
        this.FEk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.FEf != null) {
        i = paramInt + f.a.a.a.lm(3, this.FEf.computeSize());
      }
      paramInt = i;
      if (this.FEg != null) {
        paramInt = i + f.a.a.a.lm(4, this.FEg.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FEh) + (f.a.a.b.b.a.fK(6) + 1) + f.a.a.a.c(7, 8, this.Eut);
      paramInt = i;
      if (this.FEj != null) {
        paramInt = i + f.a.a.a.lm(8, this.FEj.computeSize());
      }
      i = paramInt;
      if (this.FEk != null) {
        i = paramInt + f.a.a.a.lm(9, this.FEk.computeSize());
      }
      AppMethodBeat.o(91677);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Eut.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      crj localcrj = (crj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91677);
        return -1;
      case 1: 
        localcrj.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91677);
        return 0;
      case 2: 
        localcrj.url = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91677);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrj.FEf = ((dhm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrj.FEg = ((acr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 5: 
        localcrj.FEh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91677);
        return 0;
      case 6: 
        localcrj.FEi = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(91677);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrj.Eut.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aae();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aae)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrj.FEj = ((aae)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcrj.FEk = ((bf)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    AppMethodBeat.o(91677);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crj
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eaf
  extends com.tencent.mm.bw.a
{
  public LinkedList<dze> EWg;
  public int Eae;
  public LinkedList<sc> Euk;
  public int Ggh;
  public String Ggi;
  public String Ggj;
  public int Ggk;
  public fq Ggl;
  
  public eaf()
  {
    AppMethodBeat.i(123694);
    this.Euk = new LinkedList();
    this.EWg = new LinkedList();
    AppMethodBeat.o(123694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Eae);
      paramVarArgs.aR(2, this.Ggh);
      if (this.Ggi != null) {
        paramVarArgs.d(3, this.Ggi);
      }
      if (this.Ggj != null) {
        paramVarArgs.d(4, this.Ggj);
      }
      paramVarArgs.aR(5, this.Ggk);
      paramVarArgs.e(6, 8, this.Euk);
      if (this.Ggl != null)
      {
        paramVarArgs.ln(7, this.Ggl.computeSize());
        this.Ggl.writeFields(paramVarArgs);
      }
      paramVarArgs.e(36, 8, this.EWg);
      AppMethodBeat.o(123695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Eae) + 0 + f.a.a.b.b.a.bx(2, this.Ggh);
      paramInt = i;
      if (this.Ggi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ggi);
      }
      i = paramInt;
      if (this.Ggj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Ggj);
      }
      i = i + f.a.a.b.b.a.bx(5, this.Ggk) + f.a.a.a.c(6, 8, this.Euk);
      paramInt = i;
      if (this.Ggl != null) {
        paramInt = i + f.a.a.a.lm(7, this.Ggl.computeSize());
      }
      i = f.a.a.a.c(36, 8, this.EWg);
      AppMethodBeat.o(123695);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Euk.clear();
      this.EWg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      eaf localeaf = (eaf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123695);
        return -1;
      case 1: 
        localeaf.Eae = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123695);
        return 0;
      case 2: 
        localeaf.Ggh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123695);
        return 0;
      case 3: 
        localeaf.Ggi = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 4: 
        localeaf.Ggj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 5: 
        localeaf.Ggk = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123695);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeaf.Euk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeaf.Ggl = ((fq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dze();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dze)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localeaf.EWg.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    AppMethodBeat.o(123695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaf
 * JD-Core Version:    0.7.0.1
 */
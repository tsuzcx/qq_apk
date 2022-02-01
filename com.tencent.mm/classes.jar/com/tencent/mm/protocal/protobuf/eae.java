package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eae
  extends com.tencent.mm.bw.a
{
  public String FHE;
  public boolean GfQ;
  public boolean GfS;
  public String Gge;
  public cyh Ggf;
  public dhw Ggg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153317);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gge != null) {
        paramVarArgs.d(1, this.Gge);
      }
      if (this.FHE != null) {
        paramVarArgs.d(2, this.FHE);
      }
      if (this.Ggf != null)
      {
        paramVarArgs.ln(3, this.Ggf.computeSize());
        this.Ggf.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(4, this.GfQ);
      paramVarArgs.bl(5, this.GfS);
      if (this.Ggg != null)
      {
        paramVarArgs.ln(6, this.Ggg.computeSize());
        this.Ggg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gge == null) {
        break label670;
      }
    }
    label670:
    for (int i = f.a.a.b.b.a.e(1, this.Gge) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FHE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FHE);
      }
      i = paramInt;
      if (this.Ggf != null) {
        i = paramInt + f.a.a.a.lm(3, this.Ggf.computeSize());
      }
      i = i + (f.a.a.b.b.a.fK(4) + 1) + (f.a.a.b.b.a.fK(5) + 1);
      paramInt = i;
      if (this.Ggg != null) {
        paramInt = i + f.a.a.a.lm(6, this.Ggg.computeSize());
      }
      AppMethodBeat.o(153317);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153317);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eae localeae = (eae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153317);
          return -1;
        case 1: 
          localeae.Gge = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 2: 
          localeae.FHE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeae.Ggf = ((cyh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        case 4: 
          localeae.GfQ = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153317);
          return 0;
        case 5: 
          localeae.GfS = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153317);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeae.Ggg = ((dhw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153317);
        return 0;
      }
      AppMethodBeat.o(153317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eae
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cri
  extends com.tencent.mm.bw.a
{
  public String DWw;
  public dhb Ete;
  public ccn FEc;
  public float FEd;
  public long FEe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91675);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DWw != null) {
        paramVarArgs.d(1, this.DWw);
      }
      if (this.Ete != null)
      {
        paramVarArgs.ln(2, this.Ete.computeSize());
        this.Ete.writeFields(paramVarArgs);
      }
      if (this.FEc != null)
      {
        paramVarArgs.ln(3, this.FEc.computeSize());
        this.FEc.writeFields(paramVarArgs);
      }
      paramVarArgs.x(4, this.FEd);
      paramVarArgs.aO(5, this.FEe);
      AppMethodBeat.o(91675);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWw == null) {
        break label617;
      }
    }
    label617:
    for (int i = f.a.a.b.b.a.e(1, this.DWw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ete != null) {
        paramInt = i + f.a.a.a.lm(2, this.Ete.computeSize());
      }
      i = paramInt;
      if (this.FEc != null) {
        i = paramInt + f.a.a.a.lm(3, this.FEc.computeSize());
      }
      paramInt = f.a.a.b.b.a.fK(4);
      int j = f.a.a.b.b.a.p(5, this.FEe);
      AppMethodBeat.o(91675);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91675);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cri localcri = (cri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91675);
          return -1;
        case 1: 
          localcri.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91675);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcri.Ete = ((dhb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcri.FEc = ((ccn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 4: 
          localcri.FEd = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(91675);
          return 0;
        }
        localcri.FEe = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91675);
        return 0;
      }
      AppMethodBeat.o(91675);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cri
 * JD-Core Version:    0.7.0.1
 */
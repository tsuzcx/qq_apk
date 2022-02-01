package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqx
  extends com.tencent.mm.bw.a
{
  public crj DNL;
  public String DWw;
  public dhb Ete;
  public int FDR;
  public int FDS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91674);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FDR);
      paramVarArgs.aR(2, this.FDS);
      if (this.DNL != null)
      {
        paramVarArgs.ln(3, this.DNL.computeSize());
        this.DNL.writeFields(paramVarArgs);
      }
      if (this.Ete != null)
      {
        paramVarArgs.ln(4, this.Ete.computeSize());
        this.Ete.writeFields(paramVarArgs);
      }
      if (this.DWw != null) {
        paramVarArgs.d(5, this.DWw);
      }
      AppMethodBeat.o(91674);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FDR) + 0 + f.a.a.b.b.a.bx(2, this.FDS);
      paramInt = i;
      if (this.DNL != null) {
        paramInt = i + f.a.a.a.lm(3, this.DNL.computeSize());
      }
      i = paramInt;
      if (this.Ete != null) {
        i = paramInt + f.a.a.a.lm(4, this.Ete.computeSize());
      }
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DWw);
      }
      AppMethodBeat.o(91674);
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
      AppMethodBeat.o(91674);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cqx localcqx = (cqx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91674);
        return -1;
      case 1: 
        localcqx.FDR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91674);
        return 0;
      case 2: 
        localcqx.FDS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91674);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqx.DNL = ((crj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqx.Ete = ((dhb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      }
      localcqx.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(91674);
      return 0;
    }
    AppMethodBeat.o(91674);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqx
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbi
  extends cpx
{
  public String Bpa;
  public String Fpt;
  public String dkS;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129970);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fpt != null) {
        paramVarArgs.d(2, this.Fpt);
      }
      if (this.signature != null) {
        paramVarArgs.d(3, this.signature);
      }
      if (this.Bpa != null) {
        paramVarArgs.d(4, this.Bpa);
      }
      if (this.dkS != null) {
        paramVarArgs.d(5, this.dkS);
      }
      AppMethodBeat.o(129970);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fpt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fpt);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.signature);
      }
      paramInt = i;
      if (this.Bpa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Bpa);
      }
      i = paramInt;
      if (this.dkS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dkS);
      }
      AppMethodBeat.o(129970);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(129970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbi localcbi = (cbi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(129970);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbi.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(129970);
          return 0;
        case 2: 
          localcbi.Fpt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(129970);
          return 0;
        case 3: 
          localcbi.signature = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(129970);
          return 0;
        case 4: 
          localcbi.Bpa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(129970);
          return 0;
        }
        localcbi.dkS = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(129970);
        return 0;
      }
      AppMethodBeat.o(129970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbi
 * JD-Core Version:    0.7.0.1
 */
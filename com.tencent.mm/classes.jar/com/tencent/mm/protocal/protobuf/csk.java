package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csk
  extends cpx
{
  public String FEI;
  public String FEJ;
  public String FEK;
  public String FEL;
  public String djj;
  public String scope;
  public String state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      if (this.scope != null) {
        paramVarArgs.d(3, this.scope);
      }
      if (this.state != null) {
        paramVarArgs.d(4, this.state);
      }
      if (this.FEI != null) {
        paramVarArgs.d(5, this.FEI);
      }
      if (this.FEK != null) {
        paramVarArgs.d(6, this.FEK);
      }
      if (this.FEL != null) {
        paramVarArgs.d(7, this.FEL);
      }
      if (this.FEJ != null) {
        paramVarArgs.d(13, this.FEJ);
      }
      AppMethodBeat.o(82473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label758;
      }
    }
    label758:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djj);
      }
      i = paramInt;
      if (this.scope != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.scope);
      }
      paramInt = i;
      if (this.state != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.state);
      }
      i = paramInt;
      if (this.FEI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FEI);
      }
      paramInt = i;
      if (this.FEK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FEK);
      }
      i = paramInt;
      if (this.FEL != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FEL);
      }
      paramInt = i;
      if (this.FEJ != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FEJ);
      }
      AppMethodBeat.o(82473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csk localcsk = (csk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(82473);
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
            localcsk.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82473);
          return 0;
        case 2: 
          localcsk.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 3: 
          localcsk.scope = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 4: 
          localcsk.state = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 5: 
          localcsk.FEI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 6: 
          localcsk.FEK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 7: 
          localcsk.FEL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82473);
          return 0;
        }
        localcsk.FEJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82473);
        return 0;
      }
      AppMethodBeat.o(82473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csk
 * JD-Core Version:    0.7.0.1
 */
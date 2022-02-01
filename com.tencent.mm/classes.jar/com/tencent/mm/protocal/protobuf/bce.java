package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bce
  extends cpx
{
  public String ESn;
  public String ESo;
  public int Version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91504);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ESn != null) {
        paramVarArgs.d(2, this.ESn);
      }
      paramVarArgs.aR(3, this.Version);
      if (this.ESo != null) {
        paramVarArgs.d(4, this.ESo);
      }
      AppMethodBeat.o(91504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ESn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ESn);
      }
      i += f.a.a.b.b.a.bx(3, this.Version);
      paramInt = i;
      if (this.ESo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ESo);
      }
      AppMethodBeat.o(91504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bce localbce = (bce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91504);
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
            localbce.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91504);
          return 0;
        case 2: 
          localbce.ESn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91504);
          return 0;
        case 3: 
          localbce.Version = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91504);
          return 0;
        }
        localbce.ESo = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91504);
        return 0;
      }
      AppMethodBeat.o(91504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bce
 * JD-Core Version:    0.7.0.1
 */
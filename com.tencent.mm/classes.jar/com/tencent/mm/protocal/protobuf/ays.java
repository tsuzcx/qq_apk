package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ays
  extends cpx
{
  public String EIj;
  public String EIk;
  public String EIl;
  public String EPZ;
  public String Ewu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EIj != null) {
        paramVarArgs.d(2, this.EIj);
      }
      if (this.EPZ != null) {
        paramVarArgs.d(3, this.EPZ);
      }
      if (this.EIk != null) {
        paramVarArgs.d(4, this.EIk);
      }
      if (this.EIl != null) {
        paramVarArgs.d(5, this.EIl);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(6, this.Ewu);
      }
      AppMethodBeat.o(91489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EIj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EIj);
      }
      i = paramInt;
      if (this.EPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EPZ);
      }
      paramInt = i;
      if (this.EIk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EIk);
      }
      i = paramInt;
      if (this.EIl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EIl);
      }
      paramInt = i;
      if (this.Ewu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ewu);
      }
      AppMethodBeat.o(91489);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ays localays = (ays)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91489);
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
            localays.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91489);
          return 0;
        case 2: 
          localays.EIj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91489);
          return 0;
        case 3: 
          localays.EPZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91489);
          return 0;
        case 4: 
          localays.EIk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91489);
          return 0;
        case 5: 
          localays.EIl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91489);
          return 0;
        }
        localays.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91489);
        return 0;
      }
      AppMethodBeat.o(91489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ays
 * JD-Core Version:    0.7.0.1
 */
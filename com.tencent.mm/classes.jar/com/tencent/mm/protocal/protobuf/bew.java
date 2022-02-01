package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bew
  extends cpx
{
  public String EUn;
  public String EUo;
  public int EUp;
  public int EUq = 4;
  public int Eif;
  public String djj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123580);
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
      if (this.EUn != null) {
        paramVarArgs.d(3, this.EUn);
      }
      if (this.EUo != null) {
        paramVarArgs.d(4, this.EUo);
      }
      paramVarArgs.aR(5, this.Eif);
      paramVarArgs.aR(6, this.EUp);
      paramVarArgs.aR(7, this.EUq);
      AppMethodBeat.o(123580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djj);
      }
      i = paramInt;
      if (this.EUn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EUn);
      }
      paramInt = i;
      if (this.EUo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EUo);
      }
      i = f.a.a.b.b.a.bx(5, this.Eif);
      int j = f.a.a.b.b.a.bx(6, this.EUp);
      int k = f.a.a.b.b.a.bx(7, this.EUq);
      AppMethodBeat.o(123580);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123580);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bew localbew = (bew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123580);
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
            localbew.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123580);
          return 0;
        case 2: 
          localbew.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 3: 
          localbew.EUn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 4: 
          localbew.EUo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 5: 
          localbew.Eif = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123580);
          return 0;
        case 6: 
          localbew.EUp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123580);
          return 0;
        }
        localbew.EUq = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123580);
        return 0;
      }
      AppMethodBeat.o(123580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bew
 * JD-Core Version:    0.7.0.1
 */
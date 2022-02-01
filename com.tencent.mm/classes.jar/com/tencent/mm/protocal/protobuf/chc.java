package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chc
  extends cpx
{
  public String Fvl;
  public String Fvm;
  public int Fvn;
  public String ProductID;
  public String tlX;
  public int vyb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91630);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(2, this.ProductID);
      }
      if (this.Fvl != null) {
        paramVarArgs.d(3, this.Fvl);
      }
      if (this.Fvm != null) {
        paramVarArgs.d(4, this.Fvm);
      }
      paramVarArgs.aR(5, this.vyb);
      if (this.tlX != null) {
        paramVarArgs.d(7, this.tlX);
      }
      paramVarArgs.aR(8, this.Fvn);
      AppMethodBeat.o(91630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ProductID);
      }
      i = paramInt;
      if (this.Fvl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fvl);
      }
      paramInt = i;
      if (this.Fvm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fvm);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.vyb);
      paramInt = i;
      if (this.tlX != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.tlX);
      }
      i = f.a.a.b.b.a.bx(8, this.Fvn);
      AppMethodBeat.o(91630);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91630);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chc localchc = (chc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(91630);
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
            localchc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91630);
          return 0;
        case 2: 
          localchc.ProductID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 3: 
          localchc.Fvl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 4: 
          localchc.Fvm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 5: 
          localchc.vyb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91630);
          return 0;
        case 7: 
          localchc.tlX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91630);
          return 0;
        }
        localchc.Fvn = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91630);
        return 0;
      }
      AppMethodBeat.o(91630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chc
 * JD-Core Version:    0.7.0.1
 */
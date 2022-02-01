package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apg
  extends cpx
{
  public String DYn;
  public String EIj;
  public String EIk;
  public String EIl;
  public String Ewu;
  public String vyA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91466);
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
      if (this.DYn != null) {
        paramVarArgs.d(3, this.DYn);
      }
      if (this.vyA != null) {
        paramVarArgs.d(4, this.vyA);
      }
      if (this.EIk != null) {
        paramVarArgs.d(5, this.EIk);
      }
      if (this.EIl != null) {
        paramVarArgs.d(6, this.EIl);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(7, this.Ewu);
      }
      AppMethodBeat.o(91466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EIj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EIj);
      }
      i = paramInt;
      if (this.DYn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DYn);
      }
      paramInt = i;
      if (this.vyA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vyA);
      }
      i = paramInt;
      if (this.EIk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EIk);
      }
      paramInt = i;
      if (this.EIl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EIl);
      }
      i = paramInt;
      if (this.Ewu != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Ewu);
      }
      AppMethodBeat.o(91466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apg localapg = (apg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91466);
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
            localapg.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91466);
          return 0;
        case 2: 
          localapg.EIj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 3: 
          localapg.DYn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 4: 
          localapg.vyA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 5: 
          localapg.EIk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 6: 
          localapg.EIl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91466);
          return 0;
        }
        localapg.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91466);
        return 0;
      }
      AppMethodBeat.o(91466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apg
 * JD-Core Version:    0.7.0.1
 */
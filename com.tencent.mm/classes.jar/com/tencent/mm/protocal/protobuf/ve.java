package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ve
  extends cpx
{
  public String Epm;
  public String Epn;
  public String Epo;
  public String Epp;
  public String Epq;
  public long Epr;
  public String Eps;
  public String Ept;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32161);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Epm != null) {
        paramVarArgs.d(2, this.Epm);
      }
      if (this.Epn != null) {
        paramVarArgs.d(3, this.Epn);
      }
      if (this.Epo != null) {
        paramVarArgs.d(4, this.Epo);
      }
      if (this.Epp != null) {
        paramVarArgs.d(5, this.Epp);
      }
      if (this.Epq != null) {
        paramVarArgs.d(6, this.Epq);
      }
      paramVarArgs.aO(7, this.Epr);
      if (this.Eps != null) {
        paramVarArgs.d(8, this.Eps);
      }
      if (this.Ept != null) {
        paramVarArgs.d(9, this.Ept);
      }
      AppMethodBeat.o(32161);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label797;
      }
    }
    label797:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Epm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Epm);
      }
      i = paramInt;
      if (this.Epn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Epn);
      }
      paramInt = i;
      if (this.Epo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Epo);
      }
      i = paramInt;
      if (this.Epp != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Epp);
      }
      paramInt = i;
      if (this.Epq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Epq);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.Epr);
      paramInt = i;
      if (this.Eps != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Eps);
      }
      i = paramInt;
      if (this.Ept != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ept);
      }
      AppMethodBeat.o(32161);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32161);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ve localve = (ve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32161);
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
            localve.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32161);
          return 0;
        case 2: 
          localve.Epm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 3: 
          localve.Epn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 4: 
          localve.Epo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 5: 
          localve.Epp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 6: 
          localve.Epq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 7: 
          localve.Epr = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32161);
          return 0;
        case 8: 
          localve.Eps = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32161);
          return 0;
        }
        localve.Ept = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32161);
        return 0;
      }
      AppMethodBeat.o(32161);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ve
 * JD-Core Version:    0.7.0.1
 */
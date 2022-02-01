package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbu
  extends cpx
{
  public String FJm;
  public long FJn;
  public int FKE;
  public long FKy;
  public int FKz;
  public int FLd;
  public String Username;
  public int sVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125835);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FJm != null) {
        paramVarArgs.d(2, this.FJm);
      }
      if (this.Username != null) {
        paramVarArgs.d(3, this.Username);
      }
      paramVarArgs.aO(4, this.FJn);
      paramVarArgs.aR(5, this.sVo);
      paramVarArgs.aO(6, this.FKy);
      paramVarArgs.aR(7, this.FKz);
      paramVarArgs.aR(8, this.FLd);
      paramVarArgs.aR(9, this.FKE);
      AppMethodBeat.o(125835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FJm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FJm);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Username);
      }
      paramInt = f.a.a.b.b.a.p(4, this.FJn);
      int j = f.a.a.b.b.a.bx(5, this.sVo);
      int k = f.a.a.b.b.a.p(6, this.FKy);
      int m = f.a.a.b.b.a.bx(7, this.FKz);
      int n = f.a.a.b.b.a.bx(8, this.FLd);
      int i1 = f.a.a.b.b.a.bx(9, this.FKE);
      AppMethodBeat.o(125835);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbu localdbu = (dbu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125835);
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
            localdbu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125835);
          return 0;
        case 2: 
          localdbu.FJm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125835);
          return 0;
        case 3: 
          localdbu.Username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125835);
          return 0;
        case 4: 
          localdbu.FJn = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125835);
          return 0;
        case 5: 
          localdbu.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125835);
          return 0;
        case 6: 
          localdbu.FKy = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125835);
          return 0;
        case 7: 
          localdbu.FKz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125835);
          return 0;
        case 8: 
          localdbu.FLd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125835);
          return 0;
        }
        localdbu.FKE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125835);
        return 0;
      }
      AppMethodBeat.o(125835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbu
 * JD-Core Version:    0.7.0.1
 */
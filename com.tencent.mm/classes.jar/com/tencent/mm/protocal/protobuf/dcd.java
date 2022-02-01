package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcd
  extends cpx
{
  public int FLo;
  public int FLp;
  public String FLr;
  public String FLs;
  public String FLt;
  public String dkS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(130919);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FLs != null) {
        paramVarArgs.d(2, this.FLs);
      }
      if (this.FLr != null) {
        paramVarArgs.d(3, this.FLr);
      }
      if (this.FLt != null) {
        paramVarArgs.d(4, this.FLt);
      }
      if (this.dkS != null) {
        paramVarArgs.d(5, this.dkS);
      }
      paramVarArgs.aR(6, this.FLo);
      paramVarArgs.aR(7, this.FLp);
      AppMethodBeat.o(130919);
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
      if (this.FLs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FLs);
      }
      i = paramInt;
      if (this.FLr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FLr);
      }
      paramInt = i;
      if (this.FLt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FLt);
      }
      i = paramInt;
      if (this.dkS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dkS);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.FLo);
      int j = f.a.a.b.b.a.bx(7, this.FLp);
      AppMethodBeat.o(130919);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(130919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcd localdcd = (dcd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(130919);
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
            localdcd.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(130919);
          return 0;
        case 2: 
          localdcd.FLs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 3: 
          localdcd.FLr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 4: 
          localdcd.FLt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 5: 
          localdcd.dkS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 6: 
          localdcd.FLo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(130919);
          return 0;
        }
        localdcd.FLp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(130919);
        return 0;
      }
      AppMethodBeat.o(130919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcd
 * JD-Core Version:    0.7.0.1
 */
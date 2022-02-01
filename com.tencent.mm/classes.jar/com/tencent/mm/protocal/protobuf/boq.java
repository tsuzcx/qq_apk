package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boq
  extends cpx
{
  public String FdR;
  public String FdS;
  public String FdT;
  public int dbL;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153288);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FdR != null) {
        paramVarArgs.d(2, this.FdR);
      }
      if (this.query != null) {
        paramVarArgs.d(3, this.query);
      }
      if (this.FdS != null) {
        paramVarArgs.d(4, this.FdS);
      }
      if (this.FdT != null) {
        paramVarArgs.d(5, this.FdT);
      }
      paramVarArgs.aR(6, this.dbL);
      AppMethodBeat.o(153288);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FdR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FdR);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.query);
      }
      paramInt = i;
      if (this.FdS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FdS);
      }
      i = paramInt;
      if (this.FdT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FdT);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.dbL);
      AppMethodBeat.o(153288);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153288);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        boq localboq = (boq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153288);
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
            localboq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153288);
          return 0;
        case 2: 
          localboq.FdR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 3: 
          localboq.query = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 4: 
          localboq.FdS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 5: 
          localboq.FdT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153288);
          return 0;
        }
        localboq.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153288);
        return 0;
      }
      AppMethodBeat.o(153288);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boq
 * JD-Core Version:    0.7.0.1
 */
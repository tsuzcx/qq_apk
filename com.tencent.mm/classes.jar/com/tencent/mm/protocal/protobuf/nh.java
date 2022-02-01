package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class nh
  extends cpx
{
  public int DWd;
  public b DZw;
  public String DZz;
  public int Edm;
  public int dbL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118407);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DZw != null) {
        paramVarArgs.c(2, this.DZw);
      }
      paramVarArgs.aR(3, this.dbL);
      paramVarArgs.aR(4, this.Edm);
      if (this.DZz != null) {
        paramVarArgs.d(5, this.DZz);
      }
      paramVarArgs.aR(6, this.DWd);
      AppMethodBeat.o(118407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DZw != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.DZw);
      }
      i = i + f.a.a.b.b.a.bx(3, this.dbL) + f.a.a.b.b.a.bx(4, this.Edm);
      paramInt = i;
      if (this.DZz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DZz);
      }
      i = f.a.a.b.b.a.bx(6, this.DWd);
      AppMethodBeat.o(118407);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(118407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nh localnh = (nh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118407);
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
            localnh.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118407);
          return 0;
        case 2: 
          localnh.DZw = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(118407);
          return 0;
        case 3: 
          localnh.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118407);
          return 0;
        case 4: 
          localnh.Edm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118407);
          return 0;
        case 5: 
          localnh.DZz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118407);
          return 0;
        }
        localnh.DWd = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118407);
        return 0;
      }
      AppMethodBeat.o(118407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nh
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnh
  extends cpx
{
  public String AYl;
  public String ErF;
  public int ErG;
  public int FuS;
  public String FuW;
  public String FuX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91665);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FuS);
      if (this.FuX != null) {
        paramVarArgs.d(3, this.FuX);
      }
      if (this.ErF != null) {
        paramVarArgs.d(4, this.ErF);
      }
      paramVarArgs.aR(5, this.ErG);
      if (this.FuW != null) {
        paramVarArgs.d(6, this.FuW);
      }
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(91665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FuS);
      paramInt = i;
      if (this.FuX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FuX);
      }
      i = paramInt;
      if (this.ErF != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ErF);
      }
      i += f.a.a.b.b.a.bx(5, this.ErG);
      paramInt = i;
      if (this.FuW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FuW);
      }
      i = paramInt;
      if (this.AYl != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(91665);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnh localcnh = (cnh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91665);
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
            localcnh.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91665);
          return 0;
        case 2: 
          localcnh.FuS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91665);
          return 0;
        case 3: 
          localcnh.FuX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 4: 
          localcnh.ErF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 5: 
          localcnh.ErG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91665);
          return 0;
        case 6: 
          localcnh.FuW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91665);
          return 0;
        }
        localcnh.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91665);
        return 0;
      }
      AppMethodBeat.o(91665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnh
 * JD-Core Version:    0.7.0.1
 */
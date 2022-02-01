package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwn
  extends cpx
{
  public String AYl;
  public String ErF;
  public dhg FlO;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72523);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.time_stamp);
      if (this.ErF != null) {
        paramVarArgs.d(3, this.ErF);
      }
      if (this.FlO != null)
      {
        paramVarArgs.ln(4, this.FlO.computeSize());
        this.FlO.writeFields(paramVarArgs);
      }
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(72523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.time_stamp);
      paramInt = i;
      if (this.ErF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ErF);
      }
      i = paramInt;
      if (this.FlO != null) {
        i = paramInt + f.a.a.a.lm(4, this.FlO.computeSize());
      }
      paramInt = i;
      if (this.AYl != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(72523);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72523);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwn localbwn = (bwn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72523);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwn.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72523);
          return 0;
        case 2: 
          localbwn.time_stamp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72523);
          return 0;
        case 3: 
          localbwn.ErF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72523);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwn.FlO = ((dhg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72523);
          return 0;
        }
        localbwn.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72523);
        return 0;
      }
      AppMethodBeat.o(72523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwn
 * JD-Core Version:    0.7.0.1
 */
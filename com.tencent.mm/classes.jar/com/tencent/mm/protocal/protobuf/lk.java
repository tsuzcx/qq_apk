package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lk
  extends cpx
{
  public String DZc;
  public String DZd;
  public long DZe;
  public String mac;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DZc != null) {
        paramVarArgs.d(2, this.DZc);
      }
      if (this.DZd != null) {
        paramVarArgs.d(3, this.DZd);
      }
      if (this.mac != null) {
        paramVarArgs.d(4, this.mac);
      }
      paramVarArgs.aO(5, this.DZe);
      AppMethodBeat.o(82394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DZc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DZc);
      }
      i = paramInt;
      if (this.DZd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DZd);
      }
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mac);
      }
      i = f.a.a.b.b.a.p(5, this.DZe);
      AppMethodBeat.o(82394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lk locallk = (lk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82394);
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
            locallk.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82394);
          return 0;
        case 2: 
          locallk.DZc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 3: 
          locallk.DZd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 4: 
          locallk.mac = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82394);
          return 0;
        }
        locallk.DZe = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(82394);
        return 0;
      }
      AppMethodBeat.o(82394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lk
 * JD-Core Version:    0.7.0.1
 */
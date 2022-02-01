package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ckk
  extends cvw
{
  public int FJf;
  public int Ghu;
  public bb Ghz;
  public String HwU;
  public String HwV;
  public b HwW;
  public int HwX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91598);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HwU != null) {
        paramVarArgs.d(2, this.HwU);
      }
      if (this.HwV != null) {
        paramVarArgs.d(3, this.HwV);
      }
      if (this.HwW != null) {
        paramVarArgs.c(4, this.HwW);
      }
      paramVarArgs.aS(5, this.Ghu);
      paramVarArgs.aS(6, this.FJf);
      paramVarArgs.aS(7, this.HwX);
      if (this.Ghz != null)
      {
        paramVarArgs.lJ(8, this.Ghz.computeSize());
        this.Ghz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HwU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HwU);
      }
      i = paramInt;
      if (this.HwV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HwV);
      }
      paramInt = i;
      if (this.HwW != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HwW);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Ghu) + f.a.a.b.b.a.bz(6, this.FJf) + f.a.a.b.b.a.bz(7, this.HwX);
      paramInt = i;
      if (this.Ghz != null) {
        paramInt = i + f.a.a.a.lI(8, this.Ghz.computeSize());
      }
      AppMethodBeat.o(91598);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ckk localckk = (ckk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91598);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localckk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91598);
          return 0;
        case 2: 
          localckk.HwU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 3: 
          localckk.HwV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 4: 
          localckk.HwW = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(91598);
          return 0;
        case 5: 
          localckk.Ghu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91598);
          return 0;
        case 6: 
          localckk.FJf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91598);
          return 0;
        case 7: 
          localckk.HwX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91598);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localckk.Ghz = ((bb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      AppMethodBeat.o(91598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckk
 * JD-Core Version:    0.7.0.1
 */
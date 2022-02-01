package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class drp
  extends cwj
{
  public int HYr;
  public gx HYs;
  public aw HYt;
  public ccx HYu;
  public ht HYv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133205);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HYr);
      if (this.HYs != null)
      {
        paramVarArgs.lJ(3, this.HYs.computeSize());
        this.HYs.writeFields(paramVarArgs);
      }
      if (this.HYt != null)
      {
        paramVarArgs.lJ(4, this.HYt.computeSize());
        this.HYt.writeFields(paramVarArgs);
      }
      if (this.HYu != null)
      {
        paramVarArgs.lJ(5, this.HYu.computeSize());
        this.HYu.writeFields(paramVarArgs);
      }
      if (this.HYv != null)
      {
        paramVarArgs.lJ(6, this.HYv.computeSize());
        this.HYv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HYr);
      paramInt = i;
      if (this.HYs != null) {
        paramInt = i + f.a.a.a.lI(3, this.HYs.computeSize());
      }
      i = paramInt;
      if (this.HYt != null) {
        i = paramInt + f.a.a.a.lI(4, this.HYt.computeSize());
      }
      paramInt = i;
      if (this.HYu != null) {
        paramInt = i + f.a.a.a.lI(5, this.HYu.computeSize());
      }
      i = paramInt;
      if (this.HYv != null) {
        i = paramInt + f.a.a.a.lI(6, this.HYv.computeSize());
      }
      AppMethodBeat.o(133205);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133205);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133205);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drp localdrp = (drp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133205);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 2: 
          localdrp.HYr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133205);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrp.HYs = ((gx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrp.HYt = ((aw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrp.HYu = ((ccx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ht();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdrp.HYv = ((ht)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133205);
        return 0;
      }
      AppMethodBeat.o(133205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drp
 * JD-Core Version:    0.7.0.1
 */
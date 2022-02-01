package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adc
  extends cvw
{
  public String FNj;
  public LinkedList<adm> FNl;
  public int Scene;
  public int fNf;
  
  public adc()
  {
    AppMethodBeat.i(101801);
    this.FNl = new LinkedList();
    AppMethodBeat.o(101801);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101802);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.fNf);
      paramVarArgs.e(3, 8, this.FNl);
      if (this.FNj != null) {
        paramVarArgs.d(4, this.FNj);
      }
      paramVarArgs.aS(5, this.Scene);
      AppMethodBeat.o(101802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.fNf) + f.a.a.a.c(3, 8, this.FNl);
      paramInt = i;
      if (this.FNj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FNj);
      }
      i = f.a.a.b.b.a.bz(5, this.Scene);
      AppMethodBeat.o(101802);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(101802);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adc localadc = (adc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101802);
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
            localadc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101802);
          return 0;
        case 2: 
          localadc.fNf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101802);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadc.FNl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101802);
          return 0;
        case 4: 
          localadc.FNj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101802);
          return 0;
        }
        localadc.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(101802);
        return 0;
      }
      AppMethodBeat.o(101802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adc
 * JD-Core Version:    0.7.0.1
 */
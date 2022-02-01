package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eaf
  extends cvw
{
  public int Gxq;
  public long Gxr;
  public String HzT;
  public long Idp;
  public eal Iek;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115911);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Iek == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115911);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HzT != null) {
        paramVarArgs.d(2, this.HzT);
      }
      paramVarArgs.aS(3, this.Gxq);
      paramVarArgs.aZ(4, this.Gxr);
      if (this.Iek != null)
      {
        paramVarArgs.lJ(5, this.Iek.computeSize());
        this.Iek.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.Idp);
      AppMethodBeat.o(115911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HzT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HzT);
      }
      i = i + f.a.a.b.b.a.bz(3, this.Gxq) + f.a.a.b.b.a.p(4, this.Gxr);
      paramInt = i;
      if (this.Iek != null) {
        paramInt = i + f.a.a.a.lI(5, this.Iek.computeSize());
      }
      i = f.a.a.b.b.a.p(6, this.Idp);
      AppMethodBeat.o(115911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Iek == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115911);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eaf localeaf = (eaf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115911);
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
            localeaf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        case 2: 
          localeaf.HzT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115911);
          return 0;
        case 3: 
          localeaf.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115911);
          return 0;
        case 4: 
          localeaf.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115911);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eal();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeaf.Iek = ((eal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        }
        localeaf.Idp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(115911);
        return 0;
      }
      AppMethodBeat.o(115911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaf
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzd
  extends cvw
{
  public int Gxq;
  public long Gxr;
  public String HzT;
  public int Hzx;
  public long Idp;
  public eal Iek;
  public int Iel;
  public int Iem;
  public String uvF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115868);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Iek == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115868);
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
      if (this.uvF != null) {
        paramVarArgs.d(6, this.uvF);
      }
      if (this.Iek != null)
      {
        paramVarArgs.lJ(8, this.Iek.computeSize());
        this.Iek.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.Iel);
      paramVarArgs.aZ(10, this.Idp);
      paramVarArgs.aS(11, this.Hzx);
      paramVarArgs.aS(12, this.Iem);
      AppMethodBeat.o(115868);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HzT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HzT);
      }
      i = i + f.a.a.b.b.a.bz(3, this.Gxq) + f.a.a.b.b.a.p(4, this.Gxr);
      paramInt = i;
      if (this.uvF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uvF);
      }
      i = paramInt;
      if (this.Iek != null) {
        i = paramInt + f.a.a.a.lI(8, this.Iek.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(9, this.Iel);
      int j = f.a.a.b.b.a.p(10, this.Idp);
      int k = f.a.a.b.b.a.bz(11, this.Hzx);
      int m = f.a.a.b.b.a.bz(12, this.Iem);
      AppMethodBeat.o(115868);
      return i + paramInt + j + k + m;
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
          AppMethodBeat.o(115868);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115868);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzd localdzd = (dzd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(115868);
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
            localdzd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 2: 
          localdzd.HzT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 3: 
          localdzd.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115868);
          return 0;
        case 4: 
          localdzd.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115868);
          return 0;
        case 6: 
          localdzd.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eal();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzd.Iek = ((eal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 9: 
          localdzd.Iel = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115868);
          return 0;
        case 10: 
          localdzd.Idp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115868);
          return 0;
        case 11: 
          localdzd.Hzx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115868);
          return 0;
        }
        localdzd.Iem = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115868);
        return 0;
      }
      AppMethodBeat.o(115868);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzd
 * JD-Core Version:    0.7.0.1
 */
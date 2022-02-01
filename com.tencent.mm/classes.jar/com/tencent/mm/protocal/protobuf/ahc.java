package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ahc
  extends cwj
{
  public LinkedList<dnb> FNl;
  public int FST;
  public LinkedList<dna> FSU;
  public int Gxq;
  public long Gxr;
  public int Gxs;
  public int Gxt;
  public int Gxu;
  
  public ahc()
  {
    AppMethodBeat.i(32191);
    this.FNl = new LinkedList();
    this.FSU = new LinkedList();
    AppMethodBeat.o(32191);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32192);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32192);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.aS(4, this.Gxs);
      paramVarArgs.aS(5, this.Gxt);
      paramVarArgs.e(6, 8, this.FNl);
      paramVarArgs.aS(7, this.Gxu);
      paramVarArgs.aS(8, this.FST);
      paramVarArgs.e(9, 8, this.FSU);
      AppMethodBeat.o(32192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gxq);
      int j = f.a.a.b.b.a.p(3, this.Gxr);
      int k = f.a.a.b.b.a.bz(4, this.Gxs);
      int m = f.a.a.b.b.a.bz(5, this.Gxt);
      int n = f.a.a.a.c(6, 8, this.FNl);
      int i1 = f.a.a.b.b.a.bz(7, this.Gxu);
      int i2 = f.a.a.b.b.a.bz(8, this.FST);
      int i3 = f.a.a.a.c(9, 8, this.FSU);
      AppMethodBeat.o(32192);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNl.clear();
        this.FSU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32192);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ahc localahc = (ahc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32192);
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
            localahc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 2: 
          localahc.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32192);
          return 0;
        case 3: 
          localahc.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32192);
          return 0;
        case 4: 
          localahc.Gxs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32192);
          return 0;
        case 5: 
          localahc.Gxt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32192);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahc.FNl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 7: 
          localahc.Gxu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32192);
          return 0;
        case 8: 
          localahc.FST = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32192);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dna();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dna)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahc.FSU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      AppMethodBeat.o(32192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahc
 * JD-Core Version:    0.7.0.1
 */
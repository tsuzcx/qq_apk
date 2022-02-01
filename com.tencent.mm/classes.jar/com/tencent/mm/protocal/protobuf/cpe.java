package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpe
  extends cwj
{
  public String FIx;
  public dok GQG;
  public long Gub;
  public cwv HcC;
  public long HcG;
  public String dEM;
  public int mwj;
  public String oFF;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72558);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72558);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      if (this.FIx != null) {
        paramVarArgs.d(4, this.FIx);
      }
      paramVarArgs.aZ(5, this.HcG);
      paramVarArgs.aZ(6, this.Gub);
      if (this.HcC != null)
      {
        paramVarArgs.lJ(7, this.HcC.computeSize());
        this.HcC.writeFields(paramVarArgs);
      }
      if (this.GQG != null)
      {
        paramVarArgs.lJ(8, this.GQG.computeSize());
        this.GQG.writeFields(paramVarArgs);
      }
      if (this.oFF != null) {
        paramVarArgs.d(9, this.oFF);
      }
      paramVarArgs.aS(10, this.mwj);
      if (this.dEM != null) {
        paramVarArgs.d(11, this.dEM);
      }
      AppMethodBeat.o(72558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.FIx != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FIx);
      }
      i = i + f.a.a.b.b.a.p(5, this.HcG) + f.a.a.b.b.a.p(6, this.Gub);
      paramInt = i;
      if (this.HcC != null) {
        paramInt = i + f.a.a.a.lI(7, this.HcC.computeSize());
      }
      i = paramInt;
      if (this.GQG != null) {
        i = paramInt + f.a.a.a.lI(8, this.GQG.computeSize());
      }
      paramInt = i;
      if (this.oFF != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.oFF);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.mwj);
      paramInt = i;
      if (this.dEM != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dEM);
      }
      AppMethodBeat.o(72558);
      return paramInt;
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
          AppMethodBeat.o(72558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpe localcpe = (cpe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72558);
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
            localcpe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 2: 
          localcpe.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72558);
          return 0;
        case 3: 
          localcpe.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 4: 
          localcpe.FIx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 5: 
          localcpe.HcG = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72558);
          return 0;
        case 6: 
          localcpe.Gub = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72558);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpe.HcC = ((cwv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dok();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpe.GQG = ((dok)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 9: 
          localcpe.oFF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 10: 
          localcpe.mwj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72558);
          return 0;
        }
        localcpe.dEM = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72558);
        return 0;
      }
      AppMethodBeat.o(72558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpe
 * JD-Core Version:    0.7.0.1
 */
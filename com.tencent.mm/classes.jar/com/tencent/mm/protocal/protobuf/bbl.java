package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbl
  extends cwj
{
  public String Dps;
  public int FMm;
  public String GRl;
  public String GRm;
  public String GRn;
  public String GRo;
  public bsr GRp;
  public com.tencent.mm.bw.b GRq;
  public String GRr;
  public int GRs;
  public String GRt;
  public int GRu;
  public String dwb;
  public String msg;
  public int pFK;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108144);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(108144);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ret);
      if (this.msg != null) {
        paramVarArgs.d(3, this.msg);
      }
      paramVarArgs.aS(4, this.FMm);
      if (this.dwb != null) {
        paramVarArgs.d(5, this.dwb);
      }
      if (this.GRm != null) {
        paramVarArgs.d(6, this.GRm);
      }
      if (this.Dps != null) {
        paramVarArgs.d(7, this.Dps);
      }
      if (this.GRn != null) {
        paramVarArgs.d(8, this.GRn);
      }
      if (this.GRo != null) {
        paramVarArgs.d(9, this.GRo);
      }
      if (this.GRp != null)
      {
        paramVarArgs.lJ(10, this.GRp.computeSize());
        this.GRp.writeFields(paramVarArgs);
      }
      if (this.GRq != null) {
        paramVarArgs.c(11, this.GRq);
      }
      paramVarArgs.aS(12, this.pFK);
      if (this.GRl != null) {
        paramVarArgs.d(13, this.GRl);
      }
      if (this.GRr != null) {
        paramVarArgs.d(14, this.GRr);
      }
      paramVarArgs.aS(15, this.GRs);
      if (this.GRt != null) {
        paramVarArgs.d(17, this.GRt);
      }
      paramVarArgs.aS(18, this.GRu);
      AppMethodBeat.o(108144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1362;
      }
    }
    label1362:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ret);
      paramInt = i;
      if (this.msg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.msg);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.FMm);
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dwb);
      }
      i = paramInt;
      if (this.GRm != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GRm);
      }
      paramInt = i;
      if (this.Dps != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Dps);
      }
      i = paramInt;
      if (this.GRn != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GRn);
      }
      paramInt = i;
      if (this.GRo != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GRo);
      }
      i = paramInt;
      if (this.GRp != null) {
        i = paramInt + f.a.a.a.lI(10, this.GRp.computeSize());
      }
      paramInt = i;
      if (this.GRq != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.GRq);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.pFK);
      paramInt = i;
      if (this.GRl != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GRl);
      }
      i = paramInt;
      if (this.GRr != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GRr);
      }
      i += f.a.a.b.b.a.bz(15, this.GRs);
      paramInt = i;
      if (this.GRt != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GRt);
      }
      i = f.a.a.b.b.a.bz(18, this.GRu);
      AppMethodBeat.o(108144);
      return paramInt + i;
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(108144);
          throw paramVarArgs;
        }
        AppMethodBeat.o(108144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbl localbbl = (bbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 16: 
        default: 
          AppMethodBeat.o(108144);
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
            localbbl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108144);
          return 0;
        case 2: 
          localbbl.ret = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(108144);
          return 0;
        case 3: 
          localbbl.msg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 4: 
          localbbl.FMm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(108144);
          return 0;
        case 5: 
          localbbl.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 6: 
          localbbl.GRm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 7: 
          localbbl.Dps = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 8: 
          localbbl.GRn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 9: 
          localbbl.GRo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbl.GRp = ((bsr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108144);
          return 0;
        case 11: 
          localbbl.GRq = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(108144);
          return 0;
        case 12: 
          localbbl.pFK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(108144);
          return 0;
        case 13: 
          localbbl.GRl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 14: 
          localbbl.GRr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 15: 
          localbbl.GRs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(108144);
          return 0;
        case 17: 
          localbbl.GRt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108144);
          return 0;
        }
        localbbl.GRu = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(108144);
        return 0;
      }
      AppMethodBeat.o(108144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbl
 * JD-Core Version:    0.7.0.1
 */
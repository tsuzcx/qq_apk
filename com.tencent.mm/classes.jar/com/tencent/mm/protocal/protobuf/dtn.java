package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtn
  extends cvp
{
  public int CreateTime;
  public int FIg;
  public int FKC;
  public int FMu;
  public int FOM;
  public String Fwt;
  public int Gds;
  public int ihf;
  public String uki;
  public String ukj;
  public int xbr;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148662);
        throw paramVarArgs;
      }
      if (this.ukj != null) {
        paramVarArgs.d(1, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(2, this.uki);
      }
      paramVarArgs.aS(3, this.FMu);
      paramVarArgs.aS(4, this.FIg);
      paramVarArgs.aS(5, this.CreateTime);
      if (this.Fwt != null) {
        paramVarArgs.d(6, this.Fwt);
      }
      paramVarArgs.aS(7, this.xbr);
      paramVarArgs.aS(8, this.FKC);
      paramVarArgs.aS(9, this.ihf);
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(10, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.Gds);
      paramVarArgs.aY(12, this.xbt);
      paramVarArgs.aS(13, this.FOM);
      AppMethodBeat.o(148662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ukj == null) {
        break label946;
      }
    }
    label946:
    for (paramInt = f.a.a.b.b.a.e(1, this.ukj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uki);
      }
      i = i + f.a.a.b.b.a.bz(3, this.FMu) + f.a.a.b.b.a.bz(4, this.FIg) + f.a.a.b.b.a.bz(5, this.CreateTime);
      paramInt = i;
      if (this.Fwt != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fwt);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.xbr) + f.a.a.b.b.a.bz(8, this.FKC) + f.a.a.b.b.a.bz(9, this.ihf);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.lB(10, this.BaseResponse.computeSize());
      }
      i = f.a.a.b.b.a.bz(11, this.Gds);
      int j = f.a.a.b.b.a.p(12, this.xbt);
      int k = f.a.a.b.b.a.bz(13, this.FOM);
      AppMethodBeat.o(148662);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(148662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtn localdtn = (dtn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148662);
          return -1;
        case 1: 
          localdtn.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 2: 
          localdtn.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 3: 
          localdtn.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 4: 
          localdtn.FIg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 5: 
          localdtn.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 6: 
          localdtn.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 7: 
          localdtn.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 8: 
          localdtn.FKC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 9: 
          localdtn.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148662);
          return 0;
        case 11: 
          localdtn.Gds = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 12: 
          localdtn.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(148662);
          return 0;
        }
        localdtn.FOM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148662);
        return 0;
      }
      AppMethodBeat.o(148662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtn
 * JD-Core Version:    0.7.0.1
 */
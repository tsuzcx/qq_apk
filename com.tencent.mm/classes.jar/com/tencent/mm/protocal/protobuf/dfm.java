package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfm
  extends dpc
{
  public LinkedList<dfe> KMD;
  public int LsZ;
  public long Lta;
  public long MKi;
  public int MKr;
  public int MKs;
  public LinkedList<dfe> MKt;
  public String MKu;
  public com.tencent.mm.bw.b MKv;
  public int MKw;
  public int ypM;
  public String ypN;
  public int ypR;
  public int ypX;
  public int ypY;
  public int ypZ;
  public com.tencent.mm.bw.b yqa;
  public int yqc;
  public int yqf;
  
  public dfm()
  {
    AppMethodBeat.i(32379);
    this.KMD = new LinkedList();
    this.MKt = new LinkedList();
    AppMethodBeat.o(32379);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32380);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32380);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.aM(4, this.MKr);
      paramVarArgs.e(5, 8, this.KMD);
      paramVarArgs.aM(6, this.MKs);
      paramVarArgs.aM(7, this.ypX);
      paramVarArgs.aM(8, this.ypY);
      paramVarArgs.bb(9, this.MKi);
      paramVarArgs.aM(10, this.ypZ);
      if (this.yqa != null) {
        paramVarArgs.c(11, this.yqa);
      }
      paramVarArgs.aM(12, this.ypR);
      paramVarArgs.aM(13, this.ypM);
      if (this.ypN != null) {
        paramVarArgs.e(14, this.ypN);
      }
      paramVarArgs.aM(15, this.yqc);
      paramVarArgs.e(16, 8, this.MKt);
      paramVarArgs.aM(17, this.yqf);
      if (this.MKu != null) {
        paramVarArgs.e(18, this.MKu);
      }
      if (this.MKv != null) {
        paramVarArgs.c(19, this.MKv);
      }
      paramVarArgs.aM(20, this.MKw);
      AppMethodBeat.o(32380);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1488;
      }
    }
    label1488:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.MKr) + g.a.a.a.c(5, 8, this.KMD) + g.a.a.b.b.a.bu(6, this.MKs) + g.a.a.b.b.a.bu(7, this.ypX) + g.a.a.b.b.a.bu(8, this.ypY) + g.a.a.b.b.a.r(9, this.MKi) + g.a.a.b.b.a.bu(10, this.ypZ);
      paramInt = i;
      if (this.yqa != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.yqa);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.ypR) + g.a.a.b.b.a.bu(13, this.ypM);
      paramInt = i;
      if (this.ypN != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.ypN);
      }
      i = paramInt + g.a.a.b.b.a.bu(15, this.yqc) + g.a.a.a.c(16, 8, this.MKt) + g.a.a.b.b.a.bu(17, this.yqf);
      paramInt = i;
      if (this.MKu != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.MKu);
      }
      i = paramInt;
      if (this.MKv != null) {
        i = paramInt + g.a.a.b.b.a.b(19, this.MKv);
      }
      paramInt = g.a.a.b.b.a.bu(20, this.MKw);
      AppMethodBeat.o(32380);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KMD.clear();
        this.MKt.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32380);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32380);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dfm localdfm = (dfm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32380);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdfm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 2: 
          localdfm.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32380);
          return 0;
        case 3: 
          localdfm.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32380);
          return 0;
        case 4: 
          localdfm.MKr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32380);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdfm.KMD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 6: 
          localdfm.MKs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32380);
          return 0;
        case 7: 
          localdfm.ypX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32380);
          return 0;
        case 8: 
          localdfm.ypY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32380);
          return 0;
        case 9: 
          localdfm.MKi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32380);
          return 0;
        case 10: 
          localdfm.ypZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32380);
          return 0;
        case 11: 
          localdfm.yqa = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(32380);
          return 0;
        case 12: 
          localdfm.ypR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32380);
          return 0;
        case 13: 
          localdfm.ypM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32380);
          return 0;
        case 14: 
          localdfm.ypN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 15: 
          localdfm.yqc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32380);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdfm.MKt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 17: 
          localdfm.yqf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32380);
          return 0;
        case 18: 
          localdfm.MKu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 19: 
          localdfm.MKv = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(32380);
          return 0;
        }
        localdfm.MKw = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32380);
        return 0;
      }
      AppMethodBeat.o(32380);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfm
 * JD-Core Version:    0.7.0.1
 */
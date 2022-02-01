package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vv
  extends dpc
{
  public int CpF;
  public String CpG;
  public String CpH;
  public String HTZ;
  public int LgF;
  public LinkedList<cor> LgM;
  public cor LgN;
  public String LgO;
  public boolean LgP;
  public String LgQ;
  public int LgR;
  public coz LgS;
  public dju LgT;
  public String LgU;
  public String LgV;
  public String LgW;
  public dgo LgX;
  public dgo LgY;
  public dgo LgZ;
  public com.tencent.mm.bw.b Lha;
  public int dDN;
  public String jTx;
  public String jTy;
  public String url;
  
  public vv()
  {
    AppMethodBeat.i(91406);
    this.LgM = new LinkedList();
    AppMethodBeat.o(91406);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91407);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91407);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      paramVarArgs.e(3, 8, this.LgM);
      if (this.LgN != null)
      {
        paramVarArgs.ni(4, this.LgN.computeSize());
        this.LgN.writeFields(paramVarArgs);
      }
      if (this.HTZ != null) {
        paramVarArgs.e(5, this.HTZ);
      }
      if (this.LgO != null) {
        paramVarArgs.e(6, this.LgO);
      }
      paramVarArgs.cc(7, this.LgP);
      paramVarArgs.aM(8, this.CpF);
      if (this.LgQ != null) {
        paramVarArgs.e(9, this.LgQ);
      }
      if (this.CpG != null) {
        paramVarArgs.e(10, this.CpG);
      }
      if (this.CpH != null) {
        paramVarArgs.e(11, this.CpH);
      }
      paramVarArgs.aM(12, this.LgR);
      if (this.LgS != null)
      {
        paramVarArgs.ni(13, this.LgS.computeSize());
        this.LgS.writeFields(paramVarArgs);
      }
      if (this.LgT != null)
      {
        paramVarArgs.ni(14, this.LgT.computeSize());
        this.LgT.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(15, this.dDN);
      paramVarArgs.aM(16, this.LgF);
      if (this.jTx != null) {
        paramVarArgs.e(17, this.jTx);
      }
      if (this.jTy != null) {
        paramVarArgs.e(18, this.jTy);
      }
      if (this.LgU != null) {
        paramVarArgs.e(19, this.LgU);
      }
      if (this.LgV != null) {
        paramVarArgs.e(20, this.LgV);
      }
      if (this.LgW != null) {
        paramVarArgs.e(21, this.LgW);
      }
      if (this.LgX != null)
      {
        paramVarArgs.ni(22, this.LgX.computeSize());
        this.LgX.writeFields(paramVarArgs);
      }
      if (this.LgY != null)
      {
        paramVarArgs.ni(23, this.LgY.computeSize());
        this.LgY.writeFields(paramVarArgs);
      }
      if (this.LgZ != null)
      {
        paramVarArgs.ni(24, this.LgZ.computeSize());
        this.LgZ.writeFields(paramVarArgs);
      }
      if (this.Lha != null) {
        paramVarArgs.c(25, this.Lha);
      }
      AppMethodBeat.o(91407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2398;
      }
    }
    label2398:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.url);
      }
      i += g.a.a.a.c(3, 8, this.LgM);
      paramInt = i;
      if (this.LgN != null) {
        paramInt = i + g.a.a.a.nh(4, this.LgN.computeSize());
      }
      i = paramInt;
      if (this.HTZ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.HTZ);
      }
      paramInt = i;
      if (this.LgO != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LgO);
      }
      i = paramInt + (g.a.a.b.b.a.fS(7) + 1) + g.a.a.b.b.a.bu(8, this.CpF);
      paramInt = i;
      if (this.LgQ != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LgQ);
      }
      i = paramInt;
      if (this.CpG != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.CpG);
      }
      paramInt = i;
      if (this.CpH != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.CpH);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.LgR);
      paramInt = i;
      if (this.LgS != null) {
        paramInt = i + g.a.a.a.nh(13, this.LgS.computeSize());
      }
      i = paramInt;
      if (this.LgT != null) {
        i = paramInt + g.a.a.a.nh(14, this.LgT.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(15, this.dDN) + g.a.a.b.b.a.bu(16, this.LgF);
      paramInt = i;
      if (this.jTx != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.jTx);
      }
      i = paramInt;
      if (this.jTy != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.jTy);
      }
      paramInt = i;
      if (this.LgU != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.LgU);
      }
      i = paramInt;
      if (this.LgV != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.LgV);
      }
      paramInt = i;
      if (this.LgW != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.LgW);
      }
      i = paramInt;
      if (this.LgX != null) {
        i = paramInt + g.a.a.a.nh(22, this.LgX.computeSize());
      }
      paramInt = i;
      if (this.LgY != null) {
        paramInt = i + g.a.a.a.nh(23, this.LgY.computeSize());
      }
      i = paramInt;
      if (this.LgZ != null) {
        i = paramInt + g.a.a.a.nh(24, this.LgZ.computeSize());
      }
      paramInt = i;
      if (this.Lha != null) {
        paramInt = i + g.a.a.b.b.a.b(25, this.Lha);
      }
      AppMethodBeat.o(91407);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LgM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91407);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        vv localvv = (vv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91407);
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
            localvv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 2: 
          localvv.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cor();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cor)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localvv.LgM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cor();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cor)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localvv.LgN = ((cor)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 5: 
          localvv.HTZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 6: 
          localvv.LgO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 7: 
          localvv.LgP = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91407);
          return 0;
        case 8: 
          localvv.CpF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91407);
          return 0;
        case 9: 
          localvv.LgQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 10: 
          localvv.CpG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 11: 
          localvv.CpH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 12: 
          localvv.LgR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91407);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localvv.LgS = ((coz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dju();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dju)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localvv.LgT = ((dju)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 15: 
          localvv.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91407);
          return 0;
        case 16: 
          localvv.LgF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91407);
          return 0;
        case 17: 
          localvv.jTx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 18: 
          localvv.jTy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 19: 
          localvv.LgU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 20: 
          localvv.LgV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 21: 
          localvv.LgW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localvv.LgX = ((dgo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localvv.LgY = ((dgo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localvv.LgZ = ((dgo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        }
        localvv.Lha = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(91407);
        return 0;
      }
      AppMethodBeat.o(91407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vv
 * JD-Core Version:    0.7.0.1
 */
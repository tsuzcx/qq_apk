package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ceq
  extends cwj
{
  public String CPZ;
  public boolean HgN;
  public bws Hrl;
  public String Hrm;
  public ajt Hrn;
  public int Hro;
  public int Hrp;
  public int Hrq;
  public LinkedList<afj> Hrr;
  public LinkedList<ctg> Hrs;
  public LinkedList<is> Hrt;
  public clt Hru;
  public int Hrv;
  public int oGt;
  public String oGu;
  
  public ceq()
  {
    AppMethodBeat.i(91561);
    this.Hrr = new LinkedList();
    this.Hrs = new LinkedList();
    this.Hrt = new LinkedList();
    AppMethodBeat.o(91561);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91562);
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
      paramVarArgs.aS(4, this.Hro);
      paramVarArgs.aS(5, this.Hrp);
      paramVarArgs.aS(6, this.Hrq);
      paramVarArgs.e(8, 8, this.Hrr);
      if (this.Hrl != null)
      {
        paramVarArgs.lJ(9, this.Hrl.computeSize());
        this.Hrl.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.Hrs);
      paramVarArgs.e(11, 8, this.Hrt);
      paramVarArgs.bC(12, this.HgN);
      if (this.Hru != null)
      {
        paramVarArgs.lJ(13, this.Hru.computeSize());
        this.Hru.writeFields(paramVarArgs);
      }
      if (this.Hrm != null) {
        paramVarArgs.d(14, this.Hrm);
      }
      if (this.Hrn != null)
      {
        paramVarArgs.lJ(15, this.Hrn.computeSize());
        this.Hrn.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.Hrv);
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
      }
      AppMethodBeat.o(91562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1750;
      }
    }
    label1750:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Hro) + f.a.a.b.b.a.bz(5, this.Hrp) + f.a.a.b.b.a.bz(6, this.Hrq) + f.a.a.a.c(8, 8, this.Hrr);
      paramInt = i;
      if (this.Hrl != null) {
        paramInt = i + f.a.a.a.lI(9, this.Hrl.computeSize());
      }
      i = paramInt + f.a.a.a.c(10, 8, this.Hrs) + f.a.a.a.c(11, 8, this.Hrt) + f.a.a.b.b.a.amF(12);
      paramInt = i;
      if (this.Hru != null) {
        paramInt = i + f.a.a.a.lI(13, this.Hru.computeSize());
      }
      i = paramInt;
      if (this.Hrm != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Hrm);
      }
      paramInt = i;
      if (this.Hrn != null) {
        paramInt = i + f.a.a.a.lI(15, this.Hrn.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.Hrv);
      paramInt = i;
      if (this.CPZ != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(91562);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hrr.clear();
        this.Hrs.clear();
        this.Hrt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ceq localceq = (ceq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91562);
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
            localceq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 2: 
          localceq.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91562);
          return 0;
        case 3: 
          localceq.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 4: 
          localceq.Hro = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91562);
          return 0;
        case 5: 
          localceq.Hrp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91562);
          return 0;
        case 6: 
          localceq.Hrq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91562);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceq.Hrr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bws();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceq.Hrl = ((bws)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceq.Hrs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new is();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((is)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceq.Hrt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 12: 
          localceq.HgN = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91562);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceq.Hru = ((clt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 14: 
          localceq.Hrm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceq.Hrn = ((ajt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 16: 
          localceq.Hrv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91562);
          return 0;
        }
        localceq.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91562);
        return 0;
      }
      AppMethodBeat.o(91562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceq
 * JD-Core Version:    0.7.0.1
 */
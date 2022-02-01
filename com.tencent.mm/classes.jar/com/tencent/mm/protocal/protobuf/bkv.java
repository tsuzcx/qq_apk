package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bkv
  extends cwj
{
  public LinkedList<ats> FNC;
  public LinkedList<String> GYa;
  public String GYb;
  public String GYc;
  public boolean GYe;
  public LinkedList<eko> GYh;
  public LinkedList<ekp> GYi;
  public String GYj;
  public String GYk;
  public String GYl;
  public String GYm;
  public boolean GYn;
  public int GYo;
  public String GYp;
  public String hDm;
  public boolean qlQ;
  
  public bkv()
  {
    AppMethodBeat.i(32282);
    this.GYh = new LinkedList();
    this.GYi = new LinkedList();
    this.GYa = new LinkedList();
    this.FNC = new LinkedList();
    AppMethodBeat.o(32282);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32283);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.GYj == null)
      {
        paramVarArgs = new b("Not all required fields were included: championcoverurl");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.GYk == null)
      {
        paramVarArgs = new b("Not all required fields were included: championmotto");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.hDm == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GYh);
      paramVarArgs.e(3, 8, this.GYi);
      paramVarArgs.e(4, 1, this.GYa);
      if (this.GYj != null) {
        paramVarArgs.d(5, this.GYj);
      }
      if (this.GYk != null) {
        paramVarArgs.d(6, this.GYk);
      }
      if (this.hDm != null) {
        paramVarArgs.d(7, this.hDm);
      }
      if (this.GYl != null) {
        paramVarArgs.d(8, this.GYl);
      }
      if (this.GYb != null) {
        paramVarArgs.d(9, this.GYb);
      }
      paramVarArgs.bC(10, this.qlQ);
      if (this.GYc != null) {
        paramVarArgs.d(11, this.GYc);
      }
      paramVarArgs.e(12, 8, this.FNC);
      paramVarArgs.bC(13, this.GYe);
      if (this.GYm != null) {
        paramVarArgs.d(14, this.GYm);
      }
      paramVarArgs.bC(15, this.GYn);
      paramVarArgs.aS(16, this.GYo);
      if (this.GYp != null) {
        paramVarArgs.d(17, this.GYp);
      }
      AppMethodBeat.o(32283);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1669;
      }
    }
    label1669:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GYh) + f.a.a.a.c(3, 8, this.GYi) + f.a.a.a.c(4, 1, this.GYa);
      paramInt = i;
      if (this.GYj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GYj);
      }
      i = paramInt;
      if (this.GYk != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GYk);
      }
      paramInt = i;
      if (this.hDm != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hDm);
      }
      i = paramInt;
      if (this.GYl != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GYl);
      }
      paramInt = i;
      if (this.GYb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GYb);
      }
      i = paramInt + f.a.a.b.b.a.amF(10);
      paramInt = i;
      if (this.GYc != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GYc);
      }
      i = paramInt + f.a.a.a.c(12, 8, this.FNC) + f.a.a.b.b.a.amF(13);
      paramInt = i;
      if (this.GYm != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GYm);
      }
      i = paramInt + f.a.a.b.b.a.amF(15) + f.a.a.b.b.a.bz(16, this.GYo);
      paramInt = i;
      if (this.GYp != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GYp);
      }
      AppMethodBeat.o(32283);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GYh.clear();
        this.GYi.clear();
        this.GYa.clear();
        this.FNC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.GYj == null)
        {
          paramVarArgs = new b("Not all required fields were included: championcoverurl");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.GYk == null)
        {
          paramVarArgs = new b("Not all required fields were included: championmotto");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.hDm == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32283);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkv localbkv = (bkv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32283);
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
            localbkv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eko();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eko)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkv.GYh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkv.GYi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 4: 
          localbkv.GYa.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(32283);
          return 0;
        case 5: 
          localbkv.GYj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 6: 
          localbkv.GYk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 7: 
          localbkv.hDm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 8: 
          localbkv.GYl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 9: 
          localbkv.GYb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 10: 
          localbkv.qlQ = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(32283);
          return 0;
        case 11: 
          localbkv.GYc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ats();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ats)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkv.FNC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 13: 
          localbkv.GYe = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(32283);
          return 0;
        case 14: 
          localbkv.GYm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 15: 
          localbkv.GYn = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(32283);
          return 0;
        case 16: 
          localbkv.GYo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32283);
          return 0;
        }
        localbkv.GYp = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32283);
        return 0;
      }
      AppMethodBeat.o(32283);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkv
 * JD-Core Version:    0.7.0.1
 */
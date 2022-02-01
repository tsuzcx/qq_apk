package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class lb
  extends cld
{
  public ctj CBm;
  public String CBn;
  public int CBr;
  public int CFX;
  public String CFY;
  public bst CGc;
  public String CGd;
  public int CGe;
  public String CGf;
  public bgp CGg;
  public oj CGh;
  public bsu CGi;
  public String CGj;
  public int CGk;
  public cmi CGl;
  public String CGm;
  public String CGn;
  public String CGo;
  public String CGp;
  public int CGq;
  public int CuL;
  public String Username;
  public String dgo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134244);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.dgo != null) {
        paramVarArgs.d(2, this.dgo);
      }
      if (this.CGd != null) {
        paramVarArgs.d(3, this.CGd);
      }
      paramVarArgs.aR(4, this.CGe);
      if (this.CGf != null) {
        paramVarArgs.d(5, this.CGf);
      }
      if (this.Username != null) {
        paramVarArgs.d(6, this.Username);
      }
      if (this.CGg != null)
      {
        paramVarArgs.kX(7, this.CGg.computeSize());
        this.CGg.writeFields(paramVarArgs);
      }
      if (this.CGh != null)
      {
        paramVarArgs.kX(8, this.CGh.computeSize());
        this.CGh.writeFields(paramVarArgs);
      }
      if (this.CGi != null)
      {
        paramVarArgs.kX(9, this.CGi.computeSize());
        this.CGi.writeFields(paramVarArgs);
      }
      if (this.CBn != null) {
        paramVarArgs.d(10, this.CBn);
      }
      paramVarArgs.aR(11, this.CuL);
      if (this.CGj != null) {
        paramVarArgs.d(12, this.CGj);
      }
      paramVarArgs.aR(13, this.CGk);
      if (this.CGl != null)
      {
        paramVarArgs.kX(14, this.CGl.computeSize());
        this.CGl.writeFields(paramVarArgs);
      }
      if (this.CGm != null) {
        paramVarArgs.d(15, this.CGm);
      }
      if (this.CGn != null) {
        paramVarArgs.d(16, this.CGn);
      }
      if (this.CBm != null)
      {
        paramVarArgs.kX(17, this.CBm.computeSize());
        this.CBm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(18, this.CBr);
      if (this.CGo != null) {
        paramVarArgs.d(19, this.CGo);
      }
      if (this.CGp != null) {
        paramVarArgs.d(20, this.CGp);
      }
      paramVarArgs.aR(21, this.CFX);
      if (this.CFY != null) {
        paramVarArgs.d(22, this.CFY);
      }
      paramVarArgs.aR(23, this.CGq);
      if (this.CGc != null)
      {
        paramVarArgs.kX(24, this.CGc.computeSize());
        this.CGc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2246;
      }
    }
    label2246:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dgo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dgo);
      }
      i = paramInt;
      if (this.CGd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CGd);
      }
      i += f.a.a.b.b.a.bA(4, this.CGe);
      paramInt = i;
      if (this.CGf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CGf);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Username);
      }
      paramInt = i;
      if (this.CGg != null) {
        paramInt = i + f.a.a.a.kW(7, this.CGg.computeSize());
      }
      i = paramInt;
      if (this.CGh != null) {
        i = paramInt + f.a.a.a.kW(8, this.CGh.computeSize());
      }
      paramInt = i;
      if (this.CGi != null) {
        paramInt = i + f.a.a.a.kW(9, this.CGi.computeSize());
      }
      i = paramInt;
      if (this.CBn != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CBn);
      }
      i += f.a.a.b.b.a.bA(11, this.CuL);
      paramInt = i;
      if (this.CGj != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CGj);
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.CGk);
      paramInt = i;
      if (this.CGl != null) {
        paramInt = i + f.a.a.a.kW(14, this.CGl.computeSize());
      }
      i = paramInt;
      if (this.CGm != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.CGm);
      }
      paramInt = i;
      if (this.CGn != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.CGn);
      }
      i = paramInt;
      if (this.CBm != null) {
        i = paramInt + f.a.a.a.kW(17, this.CBm.computeSize());
      }
      i += f.a.a.b.b.a.bA(18, this.CBr);
      paramInt = i;
      if (this.CGo != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.CGo);
      }
      i = paramInt;
      if (this.CGp != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.CGp);
      }
      i += f.a.a.b.b.a.bA(21, this.CFX);
      paramInt = i;
      if (this.CFY != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.CFY);
      }
      i = paramInt + f.a.a.b.b.a.bA(23, this.CGq);
      paramInt = i;
      if (this.CGc != null) {
        paramInt = i + f.a.a.a.kW(24, this.CGc.computeSize());
      }
      AppMethodBeat.o(134244);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(134244);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lb locallb = (lb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134244);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 2: 
          locallb.dgo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 3: 
          locallb.CGd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 4: 
          locallb.CGe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134244);
          return 0;
        case 5: 
          locallb.CGf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 6: 
          locallb.Username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallb.CGg = ((bgp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallb.CGh = ((oj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallb.CGi = ((bsu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 10: 
          locallb.CBn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 11: 
          locallb.CuL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134244);
          return 0;
        case 12: 
          locallb.CGj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 13: 
          locallb.CGk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134244);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallb.CGl = ((cmi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 15: 
          locallb.CGm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 16: 
          locallb.CGn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallb.CBm = ((ctj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 18: 
          locallb.CBr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134244);
          return 0;
        case 19: 
          locallb.CGo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 20: 
          locallb.CGp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 21: 
          locallb.CFX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134244);
          return 0;
        case 22: 
          locallb.CFY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 23: 
          locallb.CGq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134244);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bst();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bst)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallb.CGc = ((bst)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      AppMethodBeat.o(134244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lb
 * JD-Core Version:    0.7.0.1
 */
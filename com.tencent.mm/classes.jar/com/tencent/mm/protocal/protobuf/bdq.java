package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bdq
  extends cwj
{
  public SKBuiltinBuffer_t GTa;
  public int GTf;
  public LinkedList<cxn> GTg;
  public int GTh;
  public LinkedList<buf> GTi;
  public String GTj;
  public int GTk;
  public int GTl;
  public bug GTm;
  public String GTn;
  public int GeQ;
  public String GeS;
  public String jfX;
  
  public bdq()
  {
    AppMethodBeat.i(32251);
    this.GTg = new LinkedList();
    this.GTi = new LinkedList();
    AppMethodBeat.o(32251);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32252);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.GTa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GTa != null)
      {
        paramVarArgs.lJ(2, this.GTa.computeSize());
        this.GTa.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GTf);
      paramVarArgs.e(4, 8, this.GTg);
      paramVarArgs.aS(5, this.GTh);
      paramVarArgs.e(6, 8, this.GTi);
      paramVarArgs.aS(7, this.GeQ);
      if (this.GTj != null) {
        paramVarArgs.d(8, this.GTj);
      }
      if (this.GeS != null) {
        paramVarArgs.d(9, this.GeS);
      }
      paramVarArgs.aS(10, this.GTk);
      if (this.jfX != null) {
        paramVarArgs.d(11, this.jfX);
      }
      paramVarArgs.aS(12, this.GTl);
      if (this.GTm != null)
      {
        paramVarArgs.lJ(13, this.GTm.computeSize());
        this.GTm.writeFields(paramVarArgs);
      }
      if (this.GTn != null) {
        paramVarArgs.d(14, this.GTn);
      }
      AppMethodBeat.o(32252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1490;
      }
    }
    label1490:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GTa != null) {
        i = paramInt + f.a.a.a.lI(2, this.GTa.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.GTf) + f.a.a.a.c(4, 8, this.GTg) + f.a.a.b.b.a.bz(5, this.GTh) + f.a.a.a.c(6, 8, this.GTi) + f.a.a.b.b.a.bz(7, this.GeQ);
      paramInt = i;
      if (this.GTj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GTj);
      }
      i = paramInt;
      if (this.GeS != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GeS);
      }
      i += f.a.a.b.b.a.bz(10, this.GTk);
      paramInt = i;
      if (this.jfX != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.jfX);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.GTl);
      paramInt = i;
      if (this.GTm != null) {
        paramInt = i + f.a.a.a.lI(13, this.GTm.computeSize());
      }
      i = paramInt;
      if (this.GTn != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GTn);
      }
      AppMethodBeat.o(32252);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GTg.clear();
        this.GTi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        if (this.GTa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32252);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdq localbdq = (bdq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32252);
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
            localbdq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdq.GTa = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 3: 
          localbdq.GTf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32252);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdq.GTg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 5: 
          localbdq.GTh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32252);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdq.GTi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 7: 
          localbdq.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32252);
          return 0;
        case 8: 
          localbdq.GTj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 9: 
          localbdq.GeS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 10: 
          localbdq.GTk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32252);
          return 0;
        case 11: 
          localbdq.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 12: 
          localbdq.GTl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32252);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bug();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bug)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdq.GTm = ((bug)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        }
        localbdq.GTn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32252);
        return 0;
      }
      AppMethodBeat.o(32252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ad
  extends cwj
{
  public String FJj;
  public int FJk;
  public int FJl;
  public String FJm;
  public dfd FJn;
  public ctm FJo;
  public dfd FJp;
  public cpp FJq;
  public aui FJr;
  public hu FJs;
  public String FJt;
  public String FJu;
  public int FJv;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32097);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32097);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FJj != null) {
        paramVarArgs.d(2, this.FJj);
      }
      paramVarArgs.aS(3, this.FJk);
      paramVarArgs.aS(4, this.FJl);
      if (this.FJm != null) {
        paramVarArgs.d(5, this.FJm);
      }
      if (this.FJn != null)
      {
        paramVarArgs.lJ(6, this.FJn.computeSize());
        this.FJn.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.OpCode);
      if (this.FJo != null)
      {
        paramVarArgs.lJ(8, this.FJo.computeSize());
        this.FJo.writeFields(paramVarArgs);
      }
      if (this.FJp != null)
      {
        paramVarArgs.lJ(9, this.FJp.computeSize());
        this.FJp.writeFields(paramVarArgs);
      }
      if (this.FJq != null)
      {
        paramVarArgs.lJ(10, this.FJq.computeSize());
        this.FJq.writeFields(paramVarArgs);
      }
      if (this.FJr != null)
      {
        paramVarArgs.lJ(11, this.FJr.computeSize());
        this.FJr.writeFields(paramVarArgs);
      }
      if (this.FJs != null)
      {
        paramVarArgs.lJ(12, this.FJs.computeSize());
        this.FJs.writeFields(paramVarArgs);
      }
      if (this.FJt != null) {
        paramVarArgs.d(13, this.FJt);
      }
      if (this.FJu != null) {
        paramVarArgs.d(14, this.FJu);
      }
      paramVarArgs.aS(15, this.FJv);
      AppMethodBeat.o(32097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1739;
      }
    }
    label1739:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FJj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FJj);
      }
      i = i + f.a.a.b.b.a.bz(3, this.FJk) + f.a.a.b.b.a.bz(4, this.FJl);
      paramInt = i;
      if (this.FJm != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FJm);
      }
      i = paramInt;
      if (this.FJn != null) {
        i = paramInt + f.a.a.a.lI(6, this.FJn.computeSize());
      }
      i += f.a.a.b.b.a.bz(7, this.OpCode);
      paramInt = i;
      if (this.FJo != null) {
        paramInt = i + f.a.a.a.lI(8, this.FJo.computeSize());
      }
      i = paramInt;
      if (this.FJp != null) {
        i = paramInt + f.a.a.a.lI(9, this.FJp.computeSize());
      }
      paramInt = i;
      if (this.FJq != null) {
        paramInt = i + f.a.a.a.lI(10, this.FJq.computeSize());
      }
      i = paramInt;
      if (this.FJr != null) {
        i = paramInt + f.a.a.a.lI(11, this.FJr.computeSize());
      }
      paramInt = i;
      if (this.FJs != null) {
        paramInt = i + f.a.a.a.lI(12, this.FJs.computeSize());
      }
      i = paramInt;
      if (this.FJt != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FJt);
      }
      paramInt = i;
      if (this.FJu != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FJu);
      }
      i = f.a.a.b.b.a.bz(15, this.FJv);
      AppMethodBeat.o(32097);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32097);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32097);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32097);
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
            localad.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 2: 
          localad.FJj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 3: 
          localad.FJk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32097);
          return 0;
        case 4: 
          localad.FJl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32097);
          return 0;
        case 5: 
          localad.FJm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FJn = ((dfd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 7: 
          localad.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32097);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FJo = ((ctm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FJp = ((dfd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FJq = ((cpp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aui();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aui)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FJr = ((aui)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FJs = ((hu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 13: 
          localad.FJt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 14: 
          localad.FJu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32097);
          return 0;
        }
        localad.FJv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32097);
        return 0;
      }
      AppMethodBeat.o(32097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ad
 * JD-Core Version:    0.7.0.1
 */
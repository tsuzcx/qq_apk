package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgb
  extends cwj
{
  public String FJt;
  public String FZl;
  public SKBuiltinBuffer_t GTa;
  public String GTj;
  public int GTk;
  public int GUJ;
  public LinkedList<chm> GUK;
  public int GbX;
  public String GeS;
  public int OpCode;
  public String Url;
  
  public bgb()
  {
    AppMethodBeat.i(56250);
    this.GUK = new LinkedList();
    AppMethodBeat.o(56250);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.GTa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GUJ);
      paramVarArgs.e(3, 8, this.GUK);
      paramVarArgs.aS(4, this.OpCode);
      paramVarArgs.aS(5, this.GbX);
      if (this.GTa != null)
      {
        paramVarArgs.lJ(6, this.GTa.computeSize());
        this.GTa.writeFields(paramVarArgs);
      }
      if (this.Url != null) {
        paramVarArgs.d(7, this.Url);
      }
      if (this.GTj != null) {
        paramVarArgs.d(8, this.GTj);
      }
      if (this.FZl != null) {
        paramVarArgs.d(9, this.FZl);
      }
      if (this.FJt != null) {
        paramVarArgs.d(10, this.FJt);
      }
      paramVarArgs.aS(11, this.GTk);
      if (this.GeS != null) {
        paramVarArgs.d(12, this.GeS);
      }
      AppMethodBeat.o(56251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GUJ) + f.a.a.a.c(3, 8, this.GUK) + f.a.a.b.b.a.bz(4, this.OpCode) + f.a.a.b.b.a.bz(5, this.GbX);
      paramInt = i;
      if (this.GTa != null) {
        paramInt = i + f.a.a.a.lI(6, this.GTa.computeSize());
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Url);
      }
      paramInt = i;
      if (this.GTj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GTj);
      }
      i = paramInt;
      if (this.FZl != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FZl);
      }
      paramInt = i;
      if (this.FJt != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FJt);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GTk);
      paramInt = i;
      if (this.GeS != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GeS);
      }
      AppMethodBeat.o(56251);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GUK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        if (this.GTa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgb localbgb = (bgb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56251);
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
            localbgb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 2: 
          localbgb.GUJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56251);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgb.GUK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 4: 
          localbgb.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56251);
          return 0;
        case 5: 
          localbgb.GbX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56251);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgb.GTa = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 7: 
          localbgb.Url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 8: 
          localbgb.GTj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 9: 
          localbgb.FZl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 10: 
          localbgb.FJt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 11: 
          localbgb.GTk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56251);
          return 0;
        }
        localbgb.GeS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(56251);
        return 0;
      }
      AppMethodBeat.o(56251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgb
 * JD-Core Version:    0.7.0.1
 */
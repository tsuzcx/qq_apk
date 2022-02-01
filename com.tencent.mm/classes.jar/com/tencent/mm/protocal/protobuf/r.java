package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class r
  extends dpc
{
  public String Cpg;
  public a KBE;
  public String KBM;
  public String KBu;
  public int dDN = 268513600;
  public String dXf;
  public String qwn = "请求不成功，请稍候再试";
  public String wFL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91327);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91327);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.wFL != null) {
        paramVarArgs.e(4, this.wFL);
      }
      if (this.dXf != null) {
        paramVarArgs.e(5, this.dXf);
      }
      if (this.Cpg != null) {
        paramVarArgs.e(7, this.Cpg);
      }
      if (this.KBu != null) {
        paramVarArgs.e(8, this.KBu);
      }
      if (this.KBE != null)
      {
        paramVarArgs.ni(9, this.KBE.computeSize());
        this.KBE.writeFields(paramVarArgs);
      }
      if (this.KBM != null) {
        paramVarArgs.e(10, this.KBM);
      }
      AppMethodBeat.o(91327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.wFL != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.wFL);
      }
      paramInt = i;
      if (this.dXf != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dXf);
      }
      i = paramInt;
      if (this.Cpg != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Cpg);
      }
      paramInt = i;
      if (this.KBu != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KBu);
      }
      i = paramInt;
      if (this.KBE != null) {
        i = paramInt + g.a.a.a.nh(9, this.KBE.computeSize());
      }
      paramInt = i;
      if (this.KBM != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KBM);
      }
      AppMethodBeat.o(91327);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91327);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91327);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(91327);
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
            localr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91327);
          return 0;
        case 2: 
          localr.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91327);
          return 0;
        case 3: 
          localr.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 4: 
          localr.wFL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 5: 
          localr.dXf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 7: 
          localr.Cpg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 8: 
          localr.KBu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localr.KBE = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91327);
          return 0;
        }
        localr.KBM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91327);
        return 0;
      }
      AppMethodBeat.o(91327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.r
 * JD-Core Version:    0.7.0.1
 */
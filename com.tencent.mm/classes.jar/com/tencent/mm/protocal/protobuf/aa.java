package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aa
  extends dpc
{
  public String KCg;
  public int KCh;
  public int KCi;
  public String KCj;
  public String KCk;
  public int dDN;
  public LinkedList<m> dkr;
  public String qwn;
  
  public aa()
  {
    AppMethodBeat.i(91337);
    this.dDN = 268513600;
    this.qwn = "请求不成功，请稍候再试";
    this.dkr = new LinkedList();
    AppMethodBeat.o(91337);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91338);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91338);
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
      paramVarArgs.e(4, 8, this.dkr);
      if (this.KCk != null) {
        paramVarArgs.e(5, this.KCk);
      }
      if (this.KCg != null) {
        paramVarArgs.e(6, this.KCg);
      }
      paramVarArgs.aM(7, this.KCh);
      paramVarArgs.aM(8, this.KCi);
      if (this.KCj != null) {
        paramVarArgs.e(9, this.KCj);
      }
      AppMethodBeat.o(91338);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.dkr);
      paramInt = i;
      if (this.KCk != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KCk);
      }
      i = paramInt;
      if (this.KCg != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KCg);
      }
      i = i + g.a.a.b.b.a.bu(7, this.KCh) + g.a.a.b.b.a.bu(8, this.KCi);
      paramInt = i;
      if (this.KCj != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KCj);
      }
      AppMethodBeat.o(91338);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.dkr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91338);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91338);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91338);
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
            localaa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 2: 
          localaa.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91338);
          return 0;
        case 3: 
          localaa.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaa.dkr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 5: 
          localaa.KCk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 6: 
          localaa.KCg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 7: 
          localaa.KCh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91338);
          return 0;
        case 8: 
          localaa.KCi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91338);
          return 0;
        }
        localaa.KCj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91338);
        return 0;
      }
      AppMethodBeat.o(91338);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aa
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class p
  extends dpc
{
  public int KBJ;
  public int dDN = 268513600;
  public int jTs;
  public int jTt;
  public int jTu;
  public long jTv;
  public long jTw;
  public String jTx;
  public String jTy;
  public String qwn = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91325);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91325);
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
      paramVarArgs.aM(4, this.jTs);
      paramVarArgs.aM(5, this.jTt);
      paramVarArgs.aM(6, this.jTu);
      paramVarArgs.bb(7, this.jTv);
      paramVarArgs.bb(8, this.jTw);
      if (this.jTx != null) {
        paramVarArgs.e(9, this.jTx);
      }
      if (this.jTy != null) {
        paramVarArgs.e(10, this.jTy);
      }
      paramVarArgs.aM(11, this.KBJ);
      AppMethodBeat.o(91325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.jTs) + g.a.a.b.b.a.bu(5, this.jTt) + g.a.a.b.b.a.bu(6, this.jTu) + g.a.a.b.b.a.r(7, this.jTv) + g.a.a.b.b.a.r(8, this.jTw);
      paramInt = i;
      if (this.jTx != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.jTx);
      }
      i = paramInt;
      if (this.jTy != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.jTy);
      }
      paramInt = g.a.a.b.b.a.bu(11, this.KBJ);
      AppMethodBeat.o(91325);
      return i + paramInt;
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
          AppMethodBeat.o(91325);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91325);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91325);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91325);
          return 0;
        case 2: 
          localp.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91325);
          return 0;
        case 3: 
          localp.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91325);
          return 0;
        case 4: 
          localp.jTs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91325);
          return 0;
        case 5: 
          localp.jTt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91325);
          return 0;
        case 6: 
          localp.jTu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91325);
          return 0;
        case 7: 
          localp.jTv = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91325);
          return 0;
        case 8: 
          localp.jTw = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91325);
          return 0;
        case 9: 
          localp.jTx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91325);
          return 0;
        case 10: 
          localp.jTy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91325);
          return 0;
        }
        localp.KBJ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91325);
        return 0;
      }
      AppMethodBeat.o(91325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.p
 * JD-Core Version:    0.7.0.1
 */
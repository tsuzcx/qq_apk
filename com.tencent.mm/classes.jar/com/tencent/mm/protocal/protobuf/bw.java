package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bw
  extends buy
{
  public String cwc;
  public String fileid;
  public String nickname;
  public b woq;
  public int wor;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10151);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.woq != null) {
        paramVarArgs.c(3, this.woq);
      }
      if (this.fileid != null) {
        paramVarArgs.e(4, this.fileid);
      }
      paramVarArgs.aO(5, this.wor);
      if (this.cwc != null) {
        paramVarArgs.e(6, this.cwc);
      }
      AppMethodBeat.o(10151);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label610;
      }
    }
    label610:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.woq != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.woq);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.fileid);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wor);
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.cwc);
      }
      AppMethodBeat.o(10151);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10151);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bw localbw = (bw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10151);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbw.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10151);
          return 0;
        case 2: 
          localbw.nickname = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10151);
          return 0;
        case 3: 
          localbw.woq = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(10151);
          return 0;
        case 4: 
          localbw.fileid = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10151);
          return 0;
        case 5: 
          localbw.wor = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10151);
          return 0;
        }
        localbw.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10151);
        return 0;
      }
      AppMethodBeat.o(10151);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bw
 * JD-Core Version:    0.7.0.1
 */
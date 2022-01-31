package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class sh
  extends buy
{
  public String cqq;
  public String fileid;
  public String wKF;
  public int wKG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135754);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fileid == null)
      {
        paramVarArgs = new b("Not all required fields were included: fileid");
        AppMethodBeat.o(135754);
        throw paramVarArgs;
      }
      if (this.cqq == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(135754);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.e(2, this.fileid);
      }
      if (this.cqq != null) {
        paramVarArgs.e(3, this.cqq);
      }
      if (this.wKF != null) {
        paramVarArgs.e(4, this.wKF);
      }
      paramVarArgs.aO(5, this.wKG);
      AppMethodBeat.o(135754);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fileid);
      }
      i = paramInt;
      if (this.cqq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cqq);
      }
      paramInt = i;
      if (this.wKF != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wKF);
      }
      i = e.a.a.b.b.a.bl(5, this.wKG);
      AppMethodBeat.o(135754);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.fileid == null)
        {
          paramVarArgs = new b("Not all required fields were included: fileid");
          AppMethodBeat.o(135754);
          throw paramVarArgs;
        }
        if (this.cqq == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(135754);
          throw paramVarArgs;
        }
        AppMethodBeat.o(135754);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        sh localsh = (sh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(135754);
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
            localsh.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(135754);
          return 0;
        case 2: 
          localsh.fileid = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135754);
          return 0;
        case 3: 
          localsh.cqq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135754);
          return 0;
        case 4: 
          localsh.wKF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135754);
          return 0;
        }
        localsh.wKG = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(135754);
        return 0;
      }
      AppMethodBeat.o(135754);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sh
 * JD-Core Version:    0.7.0.1
 */
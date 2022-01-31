package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jw
  extends buy
{
  public String mac;
  public String wwt;
  public String wwu;
  public long wwv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10160);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wwt != null) {
        paramVarArgs.e(2, this.wwt);
      }
      if (this.wwu != null) {
        paramVarArgs.e(3, this.wwu);
      }
      if (this.mac != null) {
        paramVarArgs.e(4, this.mac);
      }
      paramVarArgs.am(5, this.wwv);
      AppMethodBeat.o(10160);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label545;
      }
    }
    label545:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wwt != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wwt);
      }
      i = paramInt;
      if (this.wwu != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wwu);
      }
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.mac);
      }
      i = e.a.a.b.b.a.p(5, this.wwv);
      AppMethodBeat.o(10160);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10160);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        jw localjw = (jw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10160);
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
            localjw.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10160);
          return 0;
        case 2: 
          localjw.wwt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10160);
          return 0;
        case 3: 
          localjw.wwu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10160);
          return 0;
        case 4: 
          localjw.mac = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10160);
          return 0;
        }
        localjw.wwv = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(10160);
        return 0;
      }
      AppMethodBeat.o(10160);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jw
 * JD-Core Version:    0.7.0.1
 */
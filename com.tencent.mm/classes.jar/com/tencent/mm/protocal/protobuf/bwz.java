package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwz
  extends buy
{
  public String cwc;
  public String scope;
  public String state;
  public String xKa;
  public String xKb;
  public String xKc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10237);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      if (this.scope != null) {
        paramVarArgs.e(3, this.scope);
      }
      if (this.state != null) {
        paramVarArgs.e(4, this.state);
      }
      if (this.xKa != null) {
        paramVarArgs.e(5, this.xKa);
      }
      if (this.xKb != null) {
        paramVarArgs.e(6, this.xKb);
      }
      if (this.xKc != null) {
        paramVarArgs.e(7, this.xKc);
      }
      AppMethodBeat.o(10237);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label687;
      }
    }
    label687:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cwc);
      }
      i = paramInt;
      if (this.scope != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.scope);
      }
      paramInt = i;
      if (this.state != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.state);
      }
      i = paramInt;
      if (this.xKa != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xKa);
      }
      paramInt = i;
      if (this.xKb != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xKb);
      }
      i = paramInt;
      if (this.xKc != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xKc);
      }
      AppMethodBeat.o(10237);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10237);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bwz localbwz = (bwz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10237);
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
            localbwz.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10237);
          return 0;
        case 2: 
          localbwz.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10237);
          return 0;
        case 3: 
          localbwz.scope = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10237);
          return 0;
        case 4: 
          localbwz.state = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10237);
          return 0;
        case 5: 
          localbwz.xKa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10237);
          return 0;
        case 6: 
          localbwz.xKb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10237);
          return 0;
        }
        localbwz.xKc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10237);
        return 0;
      }
      AppMethodBeat.o(10237);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czo
  extends buy
{
  public String cwc;
  public LinkedList<String> ygn;
  public boolean ygo;
  public String ygp;
  
  public czo()
  {
    AppMethodBeat.i(114997);
    this.ygn = new LinkedList();
    AppMethodBeat.o(114997);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114998);
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
      paramVarArgs.e(3, 1, this.ygn);
      paramVarArgs.aS(4, this.ygo);
      if (this.ygp != null) {
        paramVarArgs.e(5, this.ygp);
      }
      AppMethodBeat.o(114998);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label530;
      }
    }
    label530:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cwc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cwc);
      }
      i = i + e.a.a.a.c(3, 1, this.ygn) + (e.a.a.b.b.a.eW(4) + 1);
      paramInt = i;
      if (this.ygp != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.ygp);
      }
      AppMethodBeat.o(114998);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ygn.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114998);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        czo localczo = (czo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114998);
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
            localczo.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114998);
          return 0;
        case 2: 
          localczo.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(114998);
          return 0;
        case 3: 
          localczo.ygn.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(114998);
          return 0;
        case 4: 
          localczo.ygo = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(114998);
          return 0;
        }
        localczo.ygp = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(114998);
        return 0;
      }
      AppMethodBeat.o(114998);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czo
 * JD-Core Version:    0.7.0.1
 */
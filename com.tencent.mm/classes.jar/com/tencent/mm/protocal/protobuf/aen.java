package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aen
  extends buy
{
  public String nsa;
  public String wXt;
  public LinkedList<String> wXu;
  
  public aen()
  {
    AppMethodBeat.i(112421);
    this.wXu = new LinkedList();
    AppMethodBeat.o(112421);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(112422);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wXt != null) {
        paramVarArgs.e(2, this.wXt);
      }
      paramVarArgs.e(3, 1, this.wXu);
      if (this.nsa != null) {
        paramVarArgs.e(4, this.nsa);
      }
      AppMethodBeat.o(112422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wXt != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wXt);
      }
      i += e.a.a.a.c(3, 1, this.wXu);
      paramInt = i;
      if (this.nsa != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nsa);
      }
      AppMethodBeat.o(112422);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wXu.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(112422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aen localaen = (aen)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(112422);
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
            localaen.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(112422);
          return 0;
        case 2: 
          localaen.wXt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112422);
          return 0;
        case 3: 
          localaen.wXu.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(112422);
          return 0;
        }
        localaen.nsa = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(112422);
        return 0;
      }
      AppMethodBeat.o(112422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aen
 * JD-Core Version:    0.7.0.1
 */
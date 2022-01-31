package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pa
  extends buy
{
  public float cAH;
  public String cHn;
  public float cyV;
  public String kml;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89040);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.kml != null) {
        paramVarArgs.e(2, this.kml);
      }
      paramVarArgs.q(3, this.cAH);
      paramVarArgs.q(4, this.cyV);
      if (this.cHn != null) {
        paramVarArgs.e(5, this.cHn);
      }
      AppMethodBeat.o(89040);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kml != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.kml);
      }
      i = i + (e.a.a.b.b.a.eW(3) + 4) + (e.a.a.b.b.a.eW(4) + 4);
      paramInt = i;
      if (this.cHn != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.cHn);
      }
      AppMethodBeat.o(89040);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89040);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        pa localpa = (pa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89040);
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
            localpa.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89040);
          return 0;
        case 2: 
          localpa.kml = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89040);
          return 0;
        case 3: 
          localpa.cAH = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(89040);
          return 0;
        case 4: 
          localpa.cyV = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(89040);
          return 0;
        }
        localpa.cHn = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89040);
        return 0;
      }
      AppMethodBeat.o(89040);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pa
 * JD-Core Version:    0.7.0.1
 */
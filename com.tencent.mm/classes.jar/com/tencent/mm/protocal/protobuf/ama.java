package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ama
  extends buy
{
  public int Height;
  public int Width;
  public String lGH;
  public float wDh;
  public float wDi;
  public int xcS;
  public int xcT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113780);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.q(2, this.wDh);
      paramVarArgs.q(3, this.wDi);
      paramVarArgs.aO(4, this.Width);
      paramVarArgs.aO(5, this.Height);
      if (this.lGH != null) {
        paramVarArgs.e(6, this.lGH);
      }
      paramVarArgs.aO(7, this.xcS);
      paramVarArgs.aO(8, this.xcT);
      AppMethodBeat.o(113780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 4) + (e.a.a.b.b.a.eW(3) + 4) + e.a.a.b.b.a.bl(4, this.Width) + e.a.a.b.b.a.bl(5, this.Height);
      paramInt = i;
      if (this.lGH != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.lGH);
      }
      i = e.a.a.b.b.a.bl(7, this.xcS);
      int j = e.a.a.b.b.a.bl(8, this.xcT);
      AppMethodBeat.o(113780);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(113780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ama localama = (ama)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113780);
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
            localama.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113780);
          return 0;
        case 2: 
          localama.wDh = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(113780);
          return 0;
        case 3: 
          localama.wDi = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(113780);
          return 0;
        case 4: 
          localama.Width = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113780);
          return 0;
        case 5: 
          localama.Height = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113780);
          return 0;
        case 6: 
          localama.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(113780);
          return 0;
        case 7: 
          localama.xcS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113780);
          return 0;
        }
        localama.xcT = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(113780);
        return 0;
      }
      AppMethodBeat.o(113780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ama
 * JD-Core Version:    0.7.0.1
 */
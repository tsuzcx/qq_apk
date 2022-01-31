package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byr
  extends buy
{
  public String jJA;
  public String ntu;
  public String xLa;
  public int xez;
  public int xvr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80182);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      if (this.ntu != null) {
        paramVarArgs.e(3, this.ntu);
      }
      paramVarArgs.aO(4, this.xvr);
      paramVarArgs.aO(5, this.xez);
      if (this.xLa != null) {
        paramVarArgs.e(6, this.xLa);
      }
      AppMethodBeat.o(80182);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = paramInt;
      if (this.ntu != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ntu);
      }
      i = i + e.a.a.b.b.a.bl(4, this.xvr) + e.a.a.b.b.a.bl(5, this.xez);
      paramInt = i;
      if (this.xLa != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xLa);
      }
      AppMethodBeat.o(80182);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80182);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        byr localbyr = (byr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80182);
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
            localbyr.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80182);
          return 0;
        case 2: 
          localbyr.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80182);
          return 0;
        case 3: 
          localbyr.ntu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80182);
          return 0;
        case 4: 
          localbyr.xvr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80182);
          return 0;
        case 5: 
          localbyr.xez = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80182);
          return 0;
        }
        localbyr.xLa = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80182);
        return 0;
      }
      AppMethodBeat.o(80182);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byr
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpi
  extends com.tencent.mm.bv.a
{
  public String cHn;
  public int xDq;
  public boolean xDr;
  public String xDs;
  public int xDt;
  public int xDu;
  public LinkedList<bph> xDv;
  
  public bpi()
  {
    AppMethodBeat.i(89124);
    this.xDv = new LinkedList();
    AppMethodBeat.o(89124);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89125);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cHn != null) {
        paramVarArgs.e(1, this.cHn);
      }
      paramVarArgs.aO(2, this.xDq);
      paramVarArgs.aS(3, this.xDr);
      if (this.xDs != null) {
        paramVarArgs.e(4, this.xDs);
      }
      paramVarArgs.aO(5, this.xDt);
      paramVarArgs.aO(6, this.xDu);
      paramVarArgs.e(7, 8, this.xDv);
      AppMethodBeat.o(89125);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cHn == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = e.a.a.b.b.a.f(1, this.cHn) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xDq) + (e.a.a.b.b.a.eW(3) + 1);
      paramInt = i;
      if (this.xDs != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xDs);
      }
      i = e.a.a.b.b.a.bl(5, this.xDt);
      int j = e.a.a.b.b.a.bl(6, this.xDu);
      int k = e.a.a.a.c(7, 8, this.xDv);
      AppMethodBeat.o(89125);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xDv.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89125);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bpi localbpi = (bpi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89125);
          return -1;
        case 1: 
          localbpi.cHn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89125);
          return 0;
        case 2: 
          localbpi.xDq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89125);
          return 0;
        case 3: 
          localbpi.xDr = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(89125);
          return 0;
        case 4: 
          localbpi.xDs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89125);
          return 0;
        case 5: 
          localbpi.xDt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89125);
          return 0;
        case 6: 
          localbpi.xDu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89125);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bph();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bph)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbpi.xDv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89125);
        return 0;
      }
      AppMethodBeat.o(89125);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpi
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ky
  extends com.tencent.mm.bv.a
{
  public int wyA;
  public int wyB;
  public int wyC;
  public int wyD;
  public long wyE;
  public long wyF;
  public int wyG;
  public boolean wyH;
  public int wyI;
  public boolean wyJ;
  public hk wyK;
  public boolean wyL;
  public String wyh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11710);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyh == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(11710);
        throw paramVarArgs;
      }
      if (this.wyh != null) {
        paramVarArgs.e(1, this.wyh);
      }
      paramVarArgs.aO(2, this.wyA);
      paramVarArgs.aO(3, this.wyB);
      paramVarArgs.aO(4, this.wyC);
      paramVarArgs.aO(5, this.wyD);
      paramVarArgs.am(6, this.wyE);
      paramVarArgs.am(7, this.wyF);
      paramVarArgs.aO(8, this.wyG);
      paramVarArgs.aS(9, this.wyH);
      paramVarArgs.aO(10, this.wyI);
      paramVarArgs.aS(11, this.wyJ);
      if (this.wyK != null)
      {
        paramVarArgs.iQ(12, this.wyK.computeSize());
        this.wyK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.wyL);
      AppMethodBeat.o(11710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wyh == null) {
        break label917;
      }
    }
    label917:
    for (paramInt = e.a.a.b.b.a.f(1, this.wyh) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wyA) + e.a.a.b.b.a.bl(3, this.wyB) + e.a.a.b.b.a.bl(4, this.wyC) + e.a.a.b.b.a.bl(5, this.wyD) + e.a.a.b.b.a.p(6, this.wyE) + e.a.a.b.b.a.p(7, this.wyF) + e.a.a.b.b.a.bl(8, this.wyG) + (e.a.a.b.b.a.eW(9) + 1) + e.a.a.b.b.a.bl(10, this.wyI) + (e.a.a.b.b.a.eW(11) + 1);
      paramInt = i;
      if (this.wyK != null) {
        paramInt = i + e.a.a.a.iP(12, this.wyK.computeSize());
      }
      i = e.a.a.b.b.a.eW(13);
      AppMethodBeat.o(11710);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wyh == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(11710);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11710);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ky localky = (ky)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11710);
          return -1;
        case 1: 
          localky.wyh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11710);
          return 0;
        case 2: 
          localky.wyA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11710);
          return 0;
        case 3: 
          localky.wyB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11710);
          return 0;
        case 4: 
          localky.wyC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11710);
          return 0;
        case 5: 
          localky.wyD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11710);
          return 0;
        case 6: 
          localky.wyE = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(11710);
          return 0;
        case 7: 
          localky.wyF = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(11710);
          return 0;
        case 8: 
          localky.wyG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11710);
          return 0;
        case 9: 
          localky.wyH = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(11710);
          return 0;
        case 10: 
          localky.wyI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11710);
          return 0;
        case 11: 
          localky.wyJ = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(11710);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hk();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localky.wyK = ((hk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11710);
          return 0;
        }
        localky.wyL = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(11710);
        return 0;
      }
      AppMethodBeat.o(11710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ky
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aes
  extends com.tencent.mm.bv.a
{
  public String Title;
  public int type;
  public LinkedList<aem> wXD;
  public LinkedList<aeu> wXE;
  public String wXF;
  public String wXG;
  public LinkedList<aet> wXH;
  public int wXI;
  public boolean wXJ;
  
  public aes()
  {
    AppMethodBeat.i(112430);
    this.wXD = new LinkedList();
    this.wXE = new LinkedList();
    this.wXH = new LinkedList();
    AppMethodBeat.o(112430);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(112431);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.aO(2, this.type);
      paramVarArgs.e(3, 8, this.wXD);
      paramVarArgs.e(4, 8, this.wXE);
      if (this.wXF != null) {
        paramVarArgs.e(5, this.wXF);
      }
      if (this.wXG != null) {
        paramVarArgs.e(6, this.wXG);
      }
      paramVarArgs.e(7, 8, this.wXH);
      paramVarArgs.aO(8, this.wXI);
      paramVarArgs.aS(9, this.wXJ);
      AppMethodBeat.o(112431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.type) + e.a.a.a.c(3, 8, this.wXD) + e.a.a.a.c(4, 8, this.wXE);
      paramInt = i;
      if (this.wXF != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wXF);
      }
      i = paramInt;
      if (this.wXG != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wXG);
      }
      paramInt = e.a.a.a.c(7, 8, this.wXH);
      int j = e.a.a.b.b.a.bl(8, this.wXI);
      int k = e.a.a.b.b.a.eW(9);
      AppMethodBeat.o(112431);
      return i + paramInt + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wXD.clear();
        this.wXE.clear();
        this.wXH.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(112431);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aes localaes = (aes)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(112431);
          return -1;
        case 1: 
          localaes.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112431);
          return 0;
        case 2: 
          localaes.type = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(112431);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aem();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aem)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaes.wXD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(112431);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaes.wXE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(112431);
          return 0;
        case 5: 
          localaes.wXF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112431);
          return 0;
        case 6: 
          localaes.wXG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112431);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aet();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aet)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaes.wXH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(112431);
          return 0;
        case 8: 
          localaes.wXI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(112431);
          return 0;
        }
        localaes.wXJ = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(112431);
        return 0;
      }
      AppMethodBeat.o(112431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aes
 * JD-Core Version:    0.7.0.1
 */
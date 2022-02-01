package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfl
  extends com.tencent.mm.bx.a
{
  public LinkedList<dfj> CtY;
  public int EbB;
  public String EwI;
  public String EwJ;
  public blu EwK;
  public int EwL;
  public dfk EwM;
  public dfk EwN;
  public String desc;
  public String title;
  
  public dfl()
  {
    AppMethodBeat.i(72617);
    this.CtY = new LinkedList();
    AppMethodBeat.o(72617);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.EwI != null) {
        paramVarArgs.d(3, this.EwI);
      }
      if (this.EwJ != null) {
        paramVarArgs.d(4, this.EwJ);
      }
      if (this.EwK != null)
      {
        paramVarArgs.kX(5, this.EwK.computeSize());
        this.EwK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.CtY);
      paramVarArgs.aR(7, this.EbB);
      paramVarArgs.aR(8, this.EwL);
      if (this.EwM != null)
      {
        paramVarArgs.kX(9, this.EwM.computeSize());
        this.EwM.writeFields(paramVarArgs);
      }
      if (this.EwN != null)
      {
        paramVarArgs.kX(10, this.EwN.computeSize());
        this.EwN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.EwI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EwI);
      }
      paramInt = i;
      if (this.EwJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EwJ);
      }
      i = paramInt;
      if (this.EwK != null) {
        i = paramInt + f.a.a.a.kW(5, this.EwK.computeSize());
      }
      i = i + f.a.a.a.c(6, 8, this.CtY) + f.a.a.b.b.a.bA(7, this.EbB) + f.a.a.b.b.a.bA(8, this.EwL);
      paramInt = i;
      if (this.EwM != null) {
        paramInt = i + f.a.a.a.kW(9, this.EwM.computeSize());
      }
      i = paramInt;
      if (this.EwN != null) {
        i = paramInt + f.a.a.a.kW(10, this.EwN.computeSize());
      }
      AppMethodBeat.o(72618);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CtY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfl localdfl = (dfl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72618);
          return -1;
        case 1: 
          localdfl.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 2: 
          localdfl.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 3: 
          localdfl.EwI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 4: 
          localdfl.EwJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfl.EwK = ((blu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfl.CtY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 7: 
          localdfl.EbB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72618);
          return 0;
        case 8: 
          localdfl.EwL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72618);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfl.EwM = ((dfk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfl.EwN = ((dfk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      AppMethodBeat.o(72618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfl
 * JD-Core Version:    0.7.0.1
 */
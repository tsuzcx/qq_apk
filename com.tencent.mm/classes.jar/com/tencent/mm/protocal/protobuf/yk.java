package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yk
  extends com.tencent.mm.bx.a
{
  public int DaB;
  public LinkedList<bpi> DaC;
  public int DaD;
  public String DaE;
  public bnt DaF;
  public ald DaG;
  public ale DaH;
  public String Desc;
  public String Title;
  public String Url;
  
  public yk()
  {
    AppMethodBeat.i(125718);
    this.DaC = new LinkedList();
    AppMethodBeat.o(125718);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Desc != null) {
        paramVarArgs.d(1, this.Desc);
      }
      paramVarArgs.aR(2, this.DaB);
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      paramVarArgs.e(5, 8, this.DaC);
      paramVarArgs.aR(6, this.DaD);
      if (this.DaE != null) {
        paramVarArgs.d(7, this.DaE);
      }
      if (this.DaF != null)
      {
        paramVarArgs.kX(8, this.DaF.computeSize());
        this.DaF.writeFields(paramVarArgs);
      }
      if (this.DaG != null)
      {
        paramVarArgs.kX(9, this.DaG.computeSize());
        this.DaG.writeFields(paramVarArgs);
      }
      if (this.DaH != null)
      {
        paramVarArgs.kX(10, this.DaH.computeSize());
        this.DaH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = f.a.a.b.b.a.e(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DaB);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Title);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Url);
      }
      i = i + f.a.a.a.c(5, 8, this.DaC) + f.a.a.b.b.a.bA(6, this.DaD);
      paramInt = i;
      if (this.DaE != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DaE);
      }
      i = paramInt;
      if (this.DaF != null) {
        i = paramInt + f.a.a.a.kW(8, this.DaF.computeSize());
      }
      paramInt = i;
      if (this.DaG != null) {
        paramInt = i + f.a.a.a.kW(9, this.DaG.computeSize());
      }
      i = paramInt;
      if (this.DaH != null) {
        i = paramInt + f.a.a.a.kW(10, this.DaH.computeSize());
      }
      AppMethodBeat.o(125719);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DaC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yk localyk = (yk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125719);
          return -1;
        case 1: 
          localyk.Desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 2: 
          localyk.DaB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125719);
          return 0;
        case 3: 
          localyk.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 4: 
          localyk.Url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyk.DaC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 6: 
          localyk.DaD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125719);
          return 0;
        case 7: 
          localyk.DaE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyk.DaF = ((bnt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ald();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ald)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyk.DaG = ((ald)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ale();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ale)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyk.DaH = ((ale)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      AppMethodBeat.o(125719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yk
 * JD-Core Version:    0.7.0.1
 */
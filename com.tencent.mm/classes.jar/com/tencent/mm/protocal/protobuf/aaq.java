package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aaq
  extends com.tencent.mm.bw.a
{
  public aar BWx;
  public aap BWy;
  public boolean BXK;
  public boolean BXL;
  public LinkedList<dpj> GrU;
  public long GrV;
  public long GrW;
  public boolean GrX;
  public LinkedList<byh> GrY;
  public dws GrZ;
  public String hoZ;
  
  public aaq()
  {
    AppMethodBeat.i(212470);
    this.GrU = new LinkedList();
    this.GrY = new LinkedList();
    AppMethodBeat.o(212470);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GrU);
      paramVarArgs.aZ(2, this.GrV);
      paramVarArgs.aZ(3, this.GrW);
      paramVarArgs.bC(4, this.BXK);
      if (this.hoZ != null) {
        paramVarArgs.d(5, this.hoZ);
      }
      if (this.BWx != null)
      {
        paramVarArgs.lJ(6, this.BWx.computeSize());
        this.BWx.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(7, this.GrX);
      if (this.BWy != null)
      {
        paramVarArgs.lJ(8, this.BWy.computeSize());
        this.BWy.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.GrY);
      if (this.GrZ != null)
      {
        paramVarArgs.lJ(10, this.GrZ.computeSize());
        this.GrZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(11, this.BXL);
      AppMethodBeat.o(212471);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.GrU) + 0 + f.a.a.b.b.a.p(2, this.GrV) + f.a.a.b.b.a.p(3, this.GrW) + f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.hoZ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hoZ);
      }
      i = paramInt;
      if (this.BWx != null) {
        i = paramInt + f.a.a.a.lI(6, this.BWx.computeSize());
      }
      i += f.a.a.b.b.a.amF(7);
      paramInt = i;
      if (this.BWy != null) {
        paramInt = i + f.a.a.a.lI(8, this.BWy.computeSize());
      }
      i = paramInt + f.a.a.a.c(9, 8, this.GrY);
      paramInt = i;
      if (this.GrZ != null) {
        paramInt = i + f.a.a.a.lI(10, this.GrZ.computeSize());
      }
      i = f.a.a.b.b.a.amF(11);
      AppMethodBeat.o(212471);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GrU.clear();
      this.GrY.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(212471);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aaq localaaq = (aaq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(212471);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaaq.GrU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212471);
        return 0;
      case 2: 
        localaaq.GrV = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(212471);
        return 0;
      case 3: 
        localaaq.GrW = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(212471);
        return 0;
      case 4: 
        localaaq.BXK = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(212471);
        return 0;
      case 5: 
        localaaq.hoZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(212471);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aar();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aar)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaaq.BWx = ((aar)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212471);
        return 0;
      case 7: 
        localaaq.GrX = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(212471);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aap();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aap)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaaq.BWy = ((aap)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212471);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaaq.GrY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212471);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dws();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaaq.GrZ = ((dws)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212471);
        return 0;
      }
      localaaq.BXL = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(212471);
      return 0;
    }
    AppMethodBeat.o(212471);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaq
 * JD-Core Version:    0.7.0.1
 */
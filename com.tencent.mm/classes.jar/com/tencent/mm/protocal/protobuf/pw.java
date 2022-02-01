package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class pw
  extends com.tencent.mm.bx.a
{
  public int COA;
  public int COB;
  public int COo;
  public int COp;
  public int COq;
  public int COr;
  public LinkedList<cmf> COs;
  public String COt;
  public SKBuiltinBuffer_t COu;
  public int COv;
  public int COw;
  public LinkedList<cmf> COx;
  public LinkedList<px> COy;
  public LinkedList<px> COz;
  public int oXh;
  
  public pw()
  {
    AppMethodBeat.i(133162);
    this.COs = new LinkedList();
    this.COx = new LinkedList();
    this.COy = new LinkedList();
    this.COz = new LinkedList();
    AppMethodBeat.o(133162);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133163);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.COu == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.COo);
      paramVarArgs.aR(2, this.oXh);
      paramVarArgs.aR(3, this.COp);
      paramVarArgs.aR(4, this.COq);
      paramVarArgs.aR(5, this.COr);
      paramVarArgs.e(6, 8, this.COs);
      if (this.COt != null) {
        paramVarArgs.d(7, this.COt);
      }
      if (this.COu != null)
      {
        paramVarArgs.kX(8, this.COu.computeSize());
        this.COu.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.COv);
      paramVarArgs.aR(10, this.COw);
      paramVarArgs.e(11, 8, this.COx);
      paramVarArgs.e(12, 8, this.COy);
      paramVarArgs.e(13, 8, this.COz);
      paramVarArgs.aR(14, this.COA);
      paramVarArgs.aR(15, this.COB);
      AppMethodBeat.o(133163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.COo) + 0 + f.a.a.b.b.a.bA(2, this.oXh) + f.a.a.b.b.a.bA(3, this.COp) + f.a.a.b.b.a.bA(4, this.COq) + f.a.a.b.b.a.bA(5, this.COr) + f.a.a.a.c(6, 8, this.COs);
      paramInt = i;
      if (this.COt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.COt);
      }
      i = paramInt;
      if (this.COu != null) {
        i = paramInt + f.a.a.a.kW(8, this.COu.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(9, this.COv);
      int j = f.a.a.b.b.a.bA(10, this.COw);
      int k = f.a.a.a.c(11, 8, this.COx);
      int m = f.a.a.a.c(12, 8, this.COy);
      int n = f.a.a.a.c(13, 8, this.COz);
      int i1 = f.a.a.b.b.a.bA(14, this.COA);
      int i2 = f.a.a.b.b.a.bA(15, this.COB);
      AppMethodBeat.o(133163);
      return i + paramInt + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.COs.clear();
      this.COx.clear();
      this.COy.clear();
      this.COz.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.COu == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133163);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pw localpw = (pw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133163);
        return -1;
      case 1: 
        localpw.COo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133163);
        return 0;
      case 2: 
        localpw.oXh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133163);
        return 0;
      case 3: 
        localpw.COp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133163);
        return 0;
      case 4: 
        localpw.COq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133163);
        return 0;
      case 5: 
        localpw.COr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133163);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpw.COs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 7: 
        localpw.COt = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(133163);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpw.COu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 9: 
        localpw.COv = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133163);
        return 0;
      case 10: 
        localpw.COw = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133163);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpw.COx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new px();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((px)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpw.COy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new px();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((px)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpw.COz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 14: 
        localpw.COA = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133163);
        return 0;
      }
      localpw.COB = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(133163);
      return 0;
    }
    AppMethodBeat.o(133163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pw
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ib
  extends com.tencent.mm.bx.a
{
  public btz CDA;
  public btz CDB;
  public int CDC;
  public int CDD;
  public int CDE;
  public btz CDy;
  public btz CDz;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118406);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.CDy != null)
      {
        paramVarArgs.kX(2, this.CDy.computeSize());
        this.CDy.writeFields(paramVarArgs);
      }
      if (this.CDz != null)
      {
        paramVarArgs.kX(3, this.CDz.computeSize());
        this.CDz.writeFields(paramVarArgs);
      }
      if (this.CDA != null)
      {
        paramVarArgs.kX(4, this.CDA.computeSize());
        this.CDA.writeFields(paramVarArgs);
      }
      if (this.CDB != null)
      {
        paramVarArgs.kX(11, this.CDB.computeSize());
        this.CDB.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(100, this.CDC);
      paramVarArgs.aR(101, this.CDD);
      paramVarArgs.aR(102, this.CDE);
      AppMethodBeat.o(118406);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.CDy != null) {
        paramInt = i + f.a.a.a.kW(2, this.CDy.computeSize());
      }
      i = paramInt;
      if (this.CDz != null) {
        i = paramInt + f.a.a.a.kW(3, this.CDz.computeSize());
      }
      paramInt = i;
      if (this.CDA != null) {
        paramInt = i + f.a.a.a.kW(4, this.CDA.computeSize());
      }
      i = paramInt;
      if (this.CDB != null) {
        i = paramInt + f.a.a.a.kW(11, this.CDB.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(100, this.CDC);
      int j = f.a.a.b.b.a.bA(101, this.CDD);
      int k = f.a.a.b.b.a.bA(102, this.CDE);
      AppMethodBeat.o(118406);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(118406);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ib localib = (ib)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118406);
        return -1;
      case 1: 
        localib.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118406);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localib.CDy = ((btz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localib.CDz = ((btz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localib.CDA = ((btz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localib.CDB = ((btz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 100: 
        localib.CDC = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118406);
        return 0;
      case 101: 
        localib.CDD = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118406);
        return 0;
      }
      localib.CDE = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(118406);
      return 0;
    }
    AppMethodBeat.o(118406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ib
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsv
  extends com.tencent.mm.bx.a
{
  public long CNp;
  public int DLD;
  public ble DLE;
  public LinkedList<String> EHv;
  public LinkedList<xp> EHw;
  public int Scene;
  public String nlG;
  public String oXs;
  
  public dsv()
  {
    AppMethodBeat.i(117951);
    this.EHv = new LinkedList();
    this.EHw = new LinkedList();
    AppMethodBeat.o(117951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117952);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.EHv);
      paramVarArgs.aR(2, this.DLD);
      if (this.oXs != null) {
        paramVarArgs.d(3, this.oXs);
      }
      paramVarArgs.aR(4, this.Scene);
      paramVarArgs.aG(5, this.CNp);
      if (this.nlG != null) {
        paramVarArgs.d(6, this.nlG);
      }
      if (this.DLE != null)
      {
        paramVarArgs.kX(7, this.DLE.computeSize());
        this.DLE.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.EHw);
      AppMethodBeat.o(117952);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 1, this.EHv) + 0 + f.a.a.b.b.a.bA(2, this.DLD);
      paramInt = i;
      if (this.oXs != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oXs);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Scene) + f.a.a.b.b.a.q(5, this.CNp);
      paramInt = i;
      if (this.nlG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.nlG);
      }
      i = paramInt;
      if (this.DLE != null) {
        i = paramInt + f.a.a.a.kW(7, this.DLE.computeSize());
      }
      paramInt = f.a.a.a.c(8, 8, this.EHw);
      AppMethodBeat.o(117952);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EHv.clear();
      this.EHw.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dsv localdsv = (dsv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117952);
        return -1;
      case 1: 
        localdsv.EHv.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(117952);
        return 0;
      case 2: 
        localdsv.DLD = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117952);
        return 0;
      case 3: 
        localdsv.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 4: 
        localdsv.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117952);
        return 0;
      case 5: 
        localdsv.CNp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(117952);
        return 0;
      case 6: 
        localdsv.nlG = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ble();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ble)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsv.DLE = ((ble)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117952);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new xp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((xp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdsv.EHw.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    AppMethodBeat.o(117952);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsv
 * JD-Core Version:    0.7.0.1
 */
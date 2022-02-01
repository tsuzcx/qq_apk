package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fyd
  extends com.tencent.mm.bx.a
{
  public LinkedList<dms> UaK;
  public long YNt;
  public LinkedList<amq> aaOY;
  public dtg abVZ;
  public LinkedList<fmn> abWa;
  
  public fyd()
  {
    AppMethodBeat.i(110917);
    this.abWa = new LinkedList();
    this.aaOY = new LinkedList();
    this.UaK = new LinkedList();
    AppMethodBeat.o(110917);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110918);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YNt);
      if (this.abVZ != null)
      {
        paramVarArgs.qD(2, this.abVZ.computeSize());
        this.abVZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.abWa);
      paramVarArgs.e(4, 8, this.aaOY);
      paramVarArgs.e(5, 8, this.UaK);
      AppMethodBeat.o(110918);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.YNt) + 0;
      paramInt = i;
      if (this.abVZ != null) {
        paramInt = i + i.a.a.a.qC(2, this.abVZ.computeSize());
      }
      i = i.a.a.a.c(3, 8, this.abWa);
      int j = i.a.a.a.c(4, 8, this.aaOY);
      int k = i.a.a.a.c(5, 8, this.UaK);
      AppMethodBeat.o(110918);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abWa.clear();
      this.aaOY.clear();
      this.UaK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fyd localfyd = (fyd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110918);
        return -1;
      case 1: 
        localfyd.YNt = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(110918);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dtg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dtg)localObject2).parseFrom((byte[])localObject1);
          }
          localfyd.abVZ = ((dtg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmn)localObject2).parseFrom((byte[])localObject1);
          }
          localfyd.abWa.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new amq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((amq)localObject2).parseFrom((byte[])localObject1);
          }
          localfyd.aaOY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dms();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dms)localObject2).parseFrom((byte[])localObject1);
        }
        localfyd.UaK.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    AppMethodBeat.o(110918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fyd
 * JD-Core Version:    0.7.0.1
 */
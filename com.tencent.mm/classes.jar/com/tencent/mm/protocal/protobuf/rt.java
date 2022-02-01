package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class rt
  extends com.tencent.mm.cd.a
{
  public LinkedList<po> SaI;
  public LinkedList<fiv> SaJ;
  public LinkedList<aia> SaK;
  public LinkedList<fmi> SaL;
  public dxf SaM;
  public b SaN;
  public LinkedList<din> SaO;
  public int rWu;
  
  public rt()
  {
    AppMethodBeat.i(117848);
    this.SaI = new LinkedList();
    this.SaJ = new LinkedList();
    this.SaK = new LinkedList();
    this.SaL = new LinkedList();
    this.SaO = new LinkedList();
    AppMethodBeat.o(117848);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117849);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      paramVarArgs.e(2, 8, this.SaI);
      paramVarArgs.e(3, 8, this.SaJ);
      paramVarArgs.e(4, 8, this.SaK);
      paramVarArgs.e(5, 8, this.SaL);
      if (this.SaM != null)
      {
        paramVarArgs.oE(6, this.SaM.computeSize());
        this.SaM.writeFields(paramVarArgs);
      }
      if (this.SaN != null) {
        paramVarArgs.c(7, this.SaN);
      }
      paramVarArgs.e(8, 8, this.SaO);
      AppMethodBeat.o(117849);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.rWu) + 0 + g.a.a.a.c(2, 8, this.SaI) + g.a.a.a.c(3, 8, this.SaJ) + g.a.a.a.c(4, 8, this.SaK) + g.a.a.a.c(5, 8, this.SaL);
      paramInt = i;
      if (this.SaM != null) {
        paramInt = i + g.a.a.a.oD(6, this.SaM.computeSize());
      }
      i = paramInt;
      if (this.SaN != null) {
        i = paramInt + g.a.a.b.b.a.b(7, this.SaN);
      }
      paramInt = g.a.a.a.c(8, 8, this.SaO);
      AppMethodBeat.o(117849);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SaI.clear();
      this.SaJ.clear();
      this.SaK.clear();
      this.SaL.clear();
      this.SaO.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      rt localrt = (rt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117849);
        return -1;
      case 1: 
        localrt.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117849);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new po();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((po)localObject2).parseFrom((byte[])localObject1);
          }
          localrt.SaI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fiv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fiv)localObject2).parseFrom((byte[])localObject1);
          }
          localrt.SaJ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aia();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aia)localObject2).parseFrom((byte[])localObject1);
          }
          localrt.SaK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmi)localObject2).parseFrom((byte[])localObject1);
          }
          localrt.SaL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dxf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dxf)localObject2).parseFrom((byte[])localObject1);
          }
          localrt.SaM = ((dxf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 7: 
        localrt.SaN = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(117849);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new din();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((din)localObject2).parseFrom((byte[])localObject1);
        }
        localrt.SaO.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    AppMethodBeat.o(117849);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rt
 * JD-Core Version:    0.7.0.1
 */
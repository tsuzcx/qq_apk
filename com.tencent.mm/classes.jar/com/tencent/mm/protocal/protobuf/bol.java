package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bol
  extends com.tencent.mm.bx.a
{
  public boo LWI;
  public bon LXo;
  public LinkedList<boq> ZWI;
  public bqp ZWJ;
  public bom ZWK;
  public LinkedList<boq> ZWL;
  public int ZWM;
  public int ZWN;
  
  public bol()
  {
    AppMethodBeat.i(258391);
    this.ZWI = new LinkedList();
    this.ZWL = new LinkedList();
    AppMethodBeat.o(258391);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258394);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZWI);
      if (this.LWI != null)
      {
        paramVarArgs.qD(2, this.LWI.computeSize());
        this.LWI.writeFields(paramVarArgs);
      }
      if (this.LXo != null)
      {
        paramVarArgs.qD(3, this.LXo.computeSize());
        this.LXo.writeFields(paramVarArgs);
      }
      if (this.ZWJ != null)
      {
        paramVarArgs.qD(4, this.ZWJ.computeSize());
        this.ZWJ.writeFields(paramVarArgs);
      }
      if (this.ZWK != null)
      {
        paramVarArgs.qD(5, this.ZWK.computeSize());
        this.ZWK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.ZWL);
      paramVarArgs.bS(7, this.ZWM);
      paramVarArgs.bS(8, this.ZWN);
      AppMethodBeat.o(258394);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZWI) + 0;
      paramInt = i;
      if (this.LWI != null) {
        paramInt = i + i.a.a.a.qC(2, this.LWI.computeSize());
      }
      i = paramInt;
      if (this.LXo != null) {
        i = paramInt + i.a.a.a.qC(3, this.LXo.computeSize());
      }
      paramInt = i;
      if (this.ZWJ != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZWJ.computeSize());
      }
      i = paramInt;
      if (this.ZWK != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZWK.computeSize());
      }
      paramInt = i.a.a.a.c(6, 8, this.ZWL);
      int j = i.a.a.b.b.a.cJ(7, this.ZWM);
      int k = i.a.a.b.b.a.cJ(8, this.ZWN);
      AppMethodBeat.o(258394);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZWI.clear();
      this.ZWL.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258394);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bol localbol = (bol)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258394);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new boq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((boq)localObject2).parseFrom((byte[])localObject1);
          }
          localbol.ZWI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258394);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new boo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((boo)localObject2).parseFrom((byte[])localObject1);
          }
          localbol.LWI = ((boo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258394);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bon();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bon)localObject2).parseFrom((byte[])localObject1);
          }
          localbol.LXo = ((bon)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258394);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bqp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bqp)localObject2).parseFrom((byte[])localObject1);
          }
          localbol.ZWJ = ((bqp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258394);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bom();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bom)localObject2).parseFrom((byte[])localObject1);
          }
          localbol.ZWK = ((bom)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258394);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new boq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((boq)localObject2).parseFrom((byte[])localObject1);
          }
          localbol.ZWL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258394);
        return 0;
      case 7: 
        localbol.ZWM = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258394);
        return 0;
      }
      localbol.ZWN = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(258394);
      return 0;
    }
    AppMethodBeat.o(258394);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bol
 * JD-Core Version:    0.7.0.1
 */
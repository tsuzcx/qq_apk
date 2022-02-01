package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyu
  extends com.tencent.mm.bx.a
{
  public boolean Akx;
  public LinkedList<eyy> abAa;
  public LinkedList<eyt> abzY;
  public eyv abzZ;
  public boolean lKI;
  public LinkedList<eyw> obH;
  
  public eyu()
  {
    AppMethodBeat.i(122527);
    this.lKI = true;
    this.Akx = false;
    this.obH = new LinkedList();
    this.abzY = new LinkedList();
    this.abAa = new LinkedList();
    AppMethodBeat.o(122527);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122528);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.lKI);
      paramVarArgs.di(2, this.Akx);
      paramVarArgs.e(3, 8, this.obH);
      paramVarArgs.e(4, 8, this.abzY);
      if (this.abzZ != null)
      {
        paramVarArgs.qD(5, this.abzZ.computeSize());
        this.abzZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.abAa);
      AppMethodBeat.o(122528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.ko(1) + 1 + 0 + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.a.c(3, 8, this.obH) + i.a.a.a.c(4, 8, this.abzY);
      paramInt = i;
      if (this.abzZ != null) {
        paramInt = i + i.a.a.a.qC(5, this.abzZ.computeSize());
      }
      i = i.a.a.a.c(6, 8, this.abAa);
      AppMethodBeat.o(122528);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.obH.clear();
      this.abzY.clear();
      this.abAa.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      eyu localeyu = (eyu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122528);
        return -1;
      case 1: 
        localeyu.lKI = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(122528);
        return 0;
      case 2: 
        localeyu.Akx = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(122528);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eyw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eyw)localObject2).parseFrom((byte[])localObject1);
          }
          localeyu.obH.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eyt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eyt)localObject2).parseFrom((byte[])localObject1);
          }
          localeyu.abzY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eyv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eyv)localObject2).parseFrom((byte[])localObject1);
          }
          localeyu.abzZ = ((eyv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new eyy();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((eyy)localObject2).parseFrom((byte[])localObject1);
        }
        localeyu.abAa.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    AppMethodBeat.o(122528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyu
 * JD-Core Version:    0.7.0.1
 */
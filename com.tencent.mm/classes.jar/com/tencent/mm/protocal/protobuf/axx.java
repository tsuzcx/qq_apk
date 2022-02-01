package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axx
  extends com.tencent.mm.bx.a
{
  public atz YIY;
  public String ZIW;
  public LinkedList<duu> lPK;
  public int num;
  public int scene;
  
  public axx()
  {
    AppMethodBeat.i(259518);
    this.lPK = new LinkedList();
    AppMethodBeat.o(259518);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259523);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIY != null)
      {
        paramVarArgs.qD(1, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.scene);
      if (this.ZIW != null) {
        paramVarArgs.g(3, this.ZIW);
      }
      paramVarArgs.bS(4, this.num);
      paramVarArgs.e(5, 8, this.lPK);
      AppMethodBeat.o(259523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YIY == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = i.a.a.a.qC(1, this.YIY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.scene);
      paramInt = i;
      if (this.ZIW != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZIW);
      }
      i = i.a.a.b.b.a.cJ(4, this.num);
      int j = i.a.a.a.c(5, 8, this.lPK);
      AppMethodBeat.o(259523);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.lPK.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259523);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        axx localaxx = (axx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259523);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localaxx.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259523);
          return 0;
        case 2: 
          localaxx.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259523);
          return 0;
        case 3: 
          localaxx.ZIW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259523);
          return 0;
        case 4: 
          localaxx.num = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259523);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new duu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((duu)localObject2).parseFrom((byte[])localObject1);
          }
          localaxx.lPK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259523);
        return 0;
      }
      AppMethodBeat.o(259523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axx
 * JD-Core Version:    0.7.0.1
 */
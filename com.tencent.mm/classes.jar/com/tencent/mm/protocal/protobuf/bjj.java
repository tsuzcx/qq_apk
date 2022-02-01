package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bjj
  extends com.tencent.mm.bx.a
{
  public LinkedList<bfx> ZSW;
  public diz ZSX;
  public int ZSY;
  public String ZSZ;
  
  public bjj()
  {
    AppMethodBeat.i(259926);
    this.ZSW = new LinkedList();
    AppMethodBeat.o(259926);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259930);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZSW);
      if (this.ZSX != null)
      {
        paramVarArgs.qD(2, this.ZSX.computeSize());
        this.ZSX.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.ZSY);
      if (this.ZSZ != null) {
        paramVarArgs.g(4, this.ZSZ);
      }
      AppMethodBeat.o(259930);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZSW) + 0;
      paramInt = i;
      if (this.ZSX != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZSX.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.ZSY);
      paramInt = i;
      if (this.ZSZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZSZ);
      }
      AppMethodBeat.o(259930);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZSW.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259930);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bjj localbjj = (bjj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259930);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfx)localObject2).parseFrom((byte[])localObject1);
          }
          localbjj.ZSW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259930);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new diz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((diz)localObject2).parseFrom((byte[])localObject1);
          }
          localbjj.ZSX = ((diz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259930);
        return 0;
      case 3: 
        localbjj.ZSY = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259930);
        return 0;
      }
      localbjj.ZSZ = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(259930);
      return 0;
    }
    AppMethodBeat.o(259930);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjj
 * JD-Core Version:    0.7.0.1
 */
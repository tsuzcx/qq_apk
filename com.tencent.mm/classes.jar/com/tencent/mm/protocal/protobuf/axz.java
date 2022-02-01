package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class axz
  extends com.tencent.mm.bx.a
{
  public b ZEP;
  public FinderObject ZIY;
  public int scene;
  public int tab_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259548);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.tab_type);
      paramVarArgs.bS(2, this.scene);
      if (this.ZEP != null) {
        paramVarArgs.d(3, this.ZEP);
      }
      if (this.ZIY != null)
      {
        paramVarArgs.qD(4, this.ZIY.computeSize());
        this.ZIY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259548);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.tab_type) + 0 + i.a.a.b.b.a.cJ(2, this.scene);
      paramInt = i;
      if (this.ZEP != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZEP);
      }
      i = paramInt;
      if (this.ZIY != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZIY.computeSize());
      }
      AppMethodBeat.o(259548);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259548);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      axz localaxz = (axz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259548);
        return -1;
      case 1: 
        localaxz.tab_type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259548);
        return 0;
      case 2: 
        localaxz.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259548);
        return 0;
      case 3: 
        localaxz.ZEP = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(259548);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        FinderObject localFinderObject = new FinderObject();
        if ((localObject != null) && (localObject.length > 0)) {
          localFinderObject.parseFrom((byte[])localObject);
        }
        localaxz.ZIY = localFinderObject;
        paramInt += 1;
      }
      AppMethodBeat.o(259548);
      return 0;
    }
    AppMethodBeat.o(259548);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsy
  extends com.tencent.mm.bx.a
{
  public dtb aaYv;
  public dsz aaYw;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259507);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.aaYv != null)
      {
        paramVarArgs.qD(2, this.aaYv.computeSize());
        this.aaYv.writeFields(paramVarArgs);
      }
      if (this.aaYw != null)
      {
        paramVarArgs.qD(101, this.aaYw.computeSize());
        this.aaYw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259507);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.aaYv != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaYv.computeSize());
      }
      i = paramInt;
      if (this.aaYw != null) {
        i = paramInt + i.a.a.a.qC(101, this.aaYw.computeSize());
      }
      AppMethodBeat.o(259507);
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
      AppMethodBeat.o(259507);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dsy localdsy = (dsy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259507);
        return -1;
      case 1: 
        localdsy.type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259507);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dtb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dtb)localObject2).parseFrom((byte[])localObject1);
          }
          localdsy.aaYv = ((dtb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259507);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dsz();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dsz)localObject2).parseFrom((byte[])localObject1);
        }
        localdsy.aaYw = ((dsz)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259507);
      return 0;
    }
    AppMethodBeat.o(259507);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsy
 * JD-Core Version:    0.7.0.1
 */
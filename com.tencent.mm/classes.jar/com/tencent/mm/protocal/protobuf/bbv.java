package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbv
  extends com.tencent.mm.bx.a
{
  public String ZMo;
  public bbr ZMp;
  public int end_time;
  public int start_time;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259563);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.start_time);
      paramVarArgs.bS(2, this.end_time);
      if (this.ZMo != null) {
        paramVarArgs.g(3, this.ZMo);
      }
      if (this.ZMp != null)
      {
        paramVarArgs.qD(4, this.ZMp.computeSize());
        this.ZMp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259563);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.start_time) + 0 + i.a.a.b.b.a.cJ(2, this.end_time);
      paramInt = i;
      if (this.ZMo != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZMo);
      }
      i = paramInt;
      if (this.ZMp != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZMp.computeSize());
      }
      AppMethodBeat.o(259563);
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
      AppMethodBeat.o(259563);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bbv localbbv = (bbv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259563);
        return -1;
      case 1: 
        localbbv.start_time = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259563);
        return 0;
      case 2: 
        localbbv.end_time = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259563);
        return 0;
      case 3: 
        localbbv.ZMo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259563);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        bbr localbbr = new bbr();
        if ((localObject != null) && (localObject.length > 0)) {
          localbbr.parseFrom((byte[])localObject);
        }
        localbbv.ZMp = localbbr;
        paramInt += 1;
      }
      AppMethodBeat.o(259563);
      return 0;
    }
    AppMethodBeat.o(259563);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbv
 * JD-Core Version:    0.7.0.1
 */
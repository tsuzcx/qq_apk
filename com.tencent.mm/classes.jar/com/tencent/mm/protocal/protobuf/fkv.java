package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fkv
  extends com.tencent.mm.bx.a
{
  public String YMe;
  public int abLv;
  public aki abLw;
  public aki abLx;
  public int abpG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91706);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abpG);
      paramVarArgs.bS(2, this.abLv);
      if (this.YMe != null) {
        paramVarArgs.g(3, this.YMe);
      }
      if (this.abLw != null)
      {
        paramVarArgs.qD(4, this.abLw.computeSize());
        this.abLw.writeFields(paramVarArgs);
      }
      if (this.abLx != null)
      {
        paramVarArgs.qD(5, this.abLx.computeSize());
        this.abLx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abpG) + 0 + i.a.a.b.b.a.cJ(2, this.abLv);
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YMe);
      }
      i = paramInt;
      if (this.abLw != null) {
        i = paramInt + i.a.a.a.qC(4, this.abLw.computeSize());
      }
      paramInt = i;
      if (this.abLx != null) {
        paramInt = i + i.a.a.a.qC(5, this.abLx.computeSize());
      }
      AppMethodBeat.o(91706);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fkv localfkv = (fkv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      aki localaki;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91706);
        return -1;
      case 1: 
        localfkv.abpG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91706);
        return 0;
      case 2: 
        localfkv.abLv = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91706);
        return 0;
      case 3: 
        localfkv.YMe = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91706);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localaki = new aki();
          if ((localObject != null) && (localObject.length > 0)) {
            localaki.parseFrom((byte[])localObject);
          }
          localfkv.abLw = localaki;
          paramInt += 1;
        }
        AppMethodBeat.o(91706);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localaki = new aki();
        if ((localObject != null) && (localObject.length > 0)) {
          localaki.parseFrom((byte[])localObject);
        }
        localfkv.abLx = localaki;
        paramInt += 1;
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    AppMethodBeat.o(91706);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkv
 * JD-Core Version:    0.7.0.1
 */
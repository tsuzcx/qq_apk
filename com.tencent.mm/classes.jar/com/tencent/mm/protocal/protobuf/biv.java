package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class biv
  extends com.tencent.mm.bx.a
{
  public bod ZSp;
  public boolean ZSq;
  public int jump_type;
  public String jump_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257373);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.jump_type);
      if (this.jump_url != null) {
        paramVarArgs.g(2, this.jump_url);
      }
      if (this.ZSp != null)
      {
        paramVarArgs.qD(3, this.ZSp.computeSize());
        this.ZSp.writeFields(paramVarArgs);
      }
      paramVarArgs.di(4, this.ZSq);
      AppMethodBeat.o(257373);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.jump_type) + 0;
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.jump_url);
      }
      i = paramInt;
      if (this.ZSp != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZSp.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(257373);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257373);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      biv localbiv = (biv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257373);
        return -1;
      case 1: 
        localbiv.jump_type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257373);
        return 0;
      case 2: 
        localbiv.jump_url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257373);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bod localbod = new bod();
          if ((localObject != null) && (localObject.length > 0)) {
            localbod.parseFrom((byte[])localObject);
          }
          localbiv.ZSp = localbod;
          paramInt += 1;
        }
        AppMethodBeat.o(257373);
        return 0;
      }
      localbiv.ZSq = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(257373);
      return 0;
    }
    AppMethodBeat.o(257373);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biv
 * JD-Core Version:    0.7.0.1
 */
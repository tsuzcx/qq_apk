package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bev
  extends com.tencent.mm.bx.a
{
  public int ZPe;
  public int ZPf;
  public dcf ZPg;
  public int mIY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258628);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.mIY);
      paramVarArgs.bS(2, this.ZPe);
      paramVarArgs.bS(3, this.ZPf);
      if (this.ZPg != null)
      {
        paramVarArgs.qD(4, this.ZPg.computeSize());
        this.ZPg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258628);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.mIY) + 0 + i.a.a.b.b.a.cJ(2, this.ZPe) + i.a.a.b.b.a.cJ(3, this.ZPf);
      paramInt = i;
      if (this.ZPg != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZPg.computeSize());
      }
      AppMethodBeat.o(258628);
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
      AppMethodBeat.o(258628);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bev localbev = (bev)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258628);
        return -1;
      case 1: 
        localbev.mIY = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258628);
        return 0;
      case 2: 
        localbev.ZPe = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258628);
        return 0;
      case 3: 
        localbev.ZPf = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258628);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dcf localdcf = new dcf();
        if ((localObject != null) && (localObject.length > 0)) {
          localdcf.parseFrom((byte[])localObject);
        }
        localbev.ZPg = localdcf;
        paramInt += 1;
      }
      AppMethodBeat.o(258628);
      return 0;
    }
    AppMethodBeat.o(258628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bev
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gam
  extends com.tencent.mm.bx.a
{
  public int YWY;
  public LinkedList<gal> abXS;
  public int vgN;
  
  public gam()
  {
    AppMethodBeat.i(115874);
    this.abXS = new LinkedList();
    AppMethodBeat.o(115874);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115875);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vgN);
      paramVarArgs.e(2, 8, this.abXS);
      paramVarArgs.bS(3, this.YWY);
      AppMethodBeat.o(115875);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.vgN);
      i = i.a.a.a.c(2, 8, this.abXS);
      int j = i.a.a.b.b.a.cJ(3, this.YWY);
      AppMethodBeat.o(115875);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abXS.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115875);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gam localgam = (gam)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115875);
        return -1;
      case 1: 
        localgam.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115875);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gal localgal = new gal();
          if ((localObject != null) && (localObject.length > 0)) {
            localgal.parseFrom((byte[])localObject);
          }
          localgam.abXS.add(localgal);
          paramInt += 1;
        }
        AppMethodBeat.o(115875);
        return 0;
      }
      localgam.YWY = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(115875);
      return 0;
    }
    AppMethodBeat.o(115875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gam
 * JD-Core Version:    0.7.0.1
 */
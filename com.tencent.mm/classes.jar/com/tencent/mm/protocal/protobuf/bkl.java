package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bkl
  extends com.tencent.mm.bx.a
{
  public int BeA;
  public LinkedList<bkk> ZTJ;
  public int ZTK;
  public int ZTL;
  public int ZTM;
  
  public bkl()
  {
    AppMethodBeat.i(259503);
    this.ZTJ = new LinkedList();
    AppMethodBeat.o(259503);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259511);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZTJ);
      paramVarArgs.bS(2, this.BeA);
      paramVarArgs.bS(3, this.ZTK);
      paramVarArgs.bS(4, this.ZTL);
      paramVarArgs.bS(5, this.ZTM);
      AppMethodBeat.o(259511);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.ZTJ);
      i = i.a.a.b.b.a.cJ(2, this.BeA);
      int j = i.a.a.b.b.a.cJ(3, this.ZTK);
      int k = i.a.a.b.b.a.cJ(4, this.ZTL);
      int m = i.a.a.b.b.a.cJ(5, this.ZTM);
      AppMethodBeat.o(259511);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZTJ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259511);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bkl localbkl = (bkl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259511);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bkk localbkk = new bkk();
          if ((localObject != null) && (localObject.length > 0)) {
            localbkk.parseFrom((byte[])localObject);
          }
          localbkl.ZTJ.add(localbkk);
          paramInt += 1;
        }
        AppMethodBeat.o(259511);
        return 0;
      case 2: 
        localbkl.BeA = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259511);
        return 0;
      case 3: 
        localbkl.ZTK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259511);
        return 0;
      case 4: 
        localbkl.ZTL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259511);
        return 0;
      }
      localbkl.ZTM = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(259511);
      return 0;
    }
    AppMethodBeat.o(259511);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkl
 * JD-Core Version:    0.7.0.1
 */
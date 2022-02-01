package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fez
  extends com.tencent.mm.bx.a
{
  public int abEF;
  public LinkedList<fef> abEG;
  public int abEH;
  public int abEI;
  public int xKa;
  
  public fez()
  {
    AppMethodBeat.i(125810);
    this.abEG = new LinkedList();
    AppMethodBeat.o(125810);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125811);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abEF);
      paramVarArgs.e(2, 8, this.abEG);
      paramVarArgs.bS(3, this.abEH);
      paramVarArgs.bS(4, this.xKa);
      paramVarArgs.bS(5, this.abEI);
      AppMethodBeat.o(125811);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abEF);
      i = i.a.a.a.c(2, 8, this.abEG);
      int j = i.a.a.b.b.a.cJ(3, this.abEH);
      int k = i.a.a.b.b.a.cJ(4, this.xKa);
      int m = i.a.a.b.b.a.cJ(5, this.abEI);
      AppMethodBeat.o(125811);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abEG.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125811);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fez localfez = (fez)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125811);
        return -1;
      case 1: 
        localfez.abEF = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125811);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fef localfef = new fef();
          if ((localObject != null) && (localObject.length > 0)) {
            localfef.parseFrom((byte[])localObject);
          }
          localfez.abEG.add(localfef);
          paramInt += 1;
        }
        AppMethodBeat.o(125811);
        return 0;
      case 3: 
        localfez.abEH = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125811);
        return 0;
      case 4: 
        localfez.xKa = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125811);
        return 0;
      }
      localfez.abEI = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(125811);
      return 0;
    }
    AppMethodBeat.o(125811);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fez
 * JD-Core Version:    0.7.0.1
 */
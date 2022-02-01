package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ekr
  extends com.tencent.mm.cd.a
{
  public int Uet;
  public int UmA;
  public int UmB;
  public int Umy;
  public LinkedList<ejx> Umz;
  
  public ekr()
  {
    AppMethodBeat.i(125810);
    this.Umz = new LinkedList();
    AppMethodBeat.o(125810);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125811);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Umy);
      paramVarArgs.e(2, 8, this.Umz);
      paramVarArgs.aY(3, this.UmA);
      paramVarArgs.aY(4, this.Uet);
      paramVarArgs.aY(5, this.UmB);
      AppMethodBeat.o(125811);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Umy);
      i = g.a.a.a.c(2, 8, this.Umz);
      int j = g.a.a.b.b.a.bM(3, this.UmA);
      int k = g.a.a.b.b.a.bM(4, this.Uet);
      int m = g.a.a.b.b.a.bM(5, this.UmB);
      AppMethodBeat.o(125811);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Umz.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125811);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ekr localekr = (ekr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125811);
        return -1;
      case 1: 
        localekr.Umy = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125811);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ejx localejx = new ejx();
          if ((localObject != null) && (localObject.length > 0)) {
            localejx.parseFrom((byte[])localObject);
          }
          localekr.Umz.add(localejx);
          paramInt += 1;
        }
        AppMethodBeat.o(125811);
        return 0;
      case 3: 
        localekr.UmA = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125811);
        return 0;
      case 4: 
        localekr.Uet = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125811);
        return 0;
      }
      localekr.UmB = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(125811);
      return 0;
    }
    AppMethodBeat.o(125811);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekr
 * JD-Core Version:    0.7.0.1
 */
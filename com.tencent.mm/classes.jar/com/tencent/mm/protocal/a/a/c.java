package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class c
  extends com.tencent.mm.cd.a
{
  public int RCr;
  public int RCs;
  public o RCt;
  public o RCu;
  public int RCv;
  public int RCw;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143942);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.ret);
      paramVarArgs.aY(2, this.RCr);
      paramVarArgs.aY(3, this.RCs);
      if (this.RCt != null)
      {
        paramVarArgs.oE(4, this.RCt.computeSize());
        this.RCt.writeFields(paramVarArgs);
      }
      if (this.RCu != null)
      {
        paramVarArgs.oE(5, this.RCu.computeSize());
        this.RCu.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.RCv);
      paramVarArgs.aY(7, this.RCw);
      AppMethodBeat.o(143942);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.ret) + 0 + g.a.a.b.b.a.bM(2, this.RCr) + g.a.a.b.b.a.bM(3, this.RCs);
      paramInt = i;
      if (this.RCt != null) {
        paramInt = i + g.a.a.a.oD(4, this.RCt.computeSize());
      }
      i = paramInt;
      if (this.RCu != null) {
        i = paramInt + g.a.a.a.oD(5, this.RCu.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(6, this.RCv);
      int j = g.a.a.b.b.a.bM(7, this.RCw);
      AppMethodBeat.o(143942);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143942);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      o localo;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143942);
        return -1;
      case 1: 
        localc.ret = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143942);
        return 0;
      case 2: 
        localc.RCr = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143942);
        return 0;
      case 3: 
        localc.RCs = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143942);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localo = new o();
          if ((localObject != null) && (localObject.length > 0)) {
            localo.parseFrom((byte[])localObject);
          }
          localc.RCt = localo;
          paramInt += 1;
        }
        AppMethodBeat.o(143942);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localo = new o();
          if ((localObject != null) && (localObject.length > 0)) {
            localo.parseFrom((byte[])localObject);
          }
          localc.RCu = localo;
          paramInt += 1;
        }
        AppMethodBeat.o(143942);
        return 0;
      case 6: 
        localc.RCv = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143942);
        return 0;
      }
      localc.RCw = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(143942);
      return 0;
    }
    AppMethodBeat.o(143942);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.c
 * JD-Core Version:    0.7.0.1
 */
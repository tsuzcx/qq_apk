package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class f
  extends com.tencent.mm.cd.a
{
  public int RCF;
  public o RCG;
  public int RCr;
  public int RCs;
  public o RCt;
  public o RCu;
  public int RCv;
  public int RCw;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143946);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.ret);
      paramVarArgs.aY(2, this.RCr);
      paramVarArgs.aY(3, this.RCs);
      paramVarArgs.aY(4, this.RCF);
      if (this.RCt != null)
      {
        paramVarArgs.oE(5, this.RCt.computeSize());
        this.RCt.writeFields(paramVarArgs);
      }
      if (this.RCu != null)
      {
        paramVarArgs.oE(6, this.RCu.computeSize());
        this.RCu.writeFields(paramVarArgs);
      }
      if (this.RCG != null)
      {
        paramVarArgs.oE(7, this.RCG.computeSize());
        this.RCG.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.RCv);
      paramVarArgs.aY(9, this.RCw);
      AppMethodBeat.o(143946);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.ret) + 0 + g.a.a.b.b.a.bM(2, this.RCr) + g.a.a.b.b.a.bM(3, this.RCs) + g.a.a.b.b.a.bM(4, this.RCF);
      paramInt = i;
      if (this.RCt != null) {
        paramInt = i + g.a.a.a.oD(5, this.RCt.computeSize());
      }
      i = paramInt;
      if (this.RCu != null) {
        i = paramInt + g.a.a.a.oD(6, this.RCu.computeSize());
      }
      paramInt = i;
      if (this.RCG != null) {
        paramInt = i + g.a.a.a.oD(7, this.RCG.computeSize());
      }
      i = g.a.a.b.b.a.bM(8, this.RCv);
      int j = g.a.a.b.b.a.bM(9, this.RCw);
      AppMethodBeat.o(143946);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143946);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      o localo;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143946);
        return -1;
      case 1: 
        localf.ret = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143946);
        return 0;
      case 2: 
        localf.RCr = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143946);
        return 0;
      case 3: 
        localf.RCs = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143946);
        return 0;
      case 4: 
        localf.RCF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143946);
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
          localf.RCt = localo;
          paramInt += 1;
        }
        AppMethodBeat.o(143946);
        return 0;
      case 6: 
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
          localf.RCu = localo;
          paramInt += 1;
        }
        AppMethodBeat.o(143946);
        return 0;
      case 7: 
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
          localf.RCG = localo;
          paramInt += 1;
        }
        AppMethodBeat.o(143946);
        return 0;
      case 8: 
        localf.RCv = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143946);
        return 0;
      }
      localf.RCw = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(143946);
      return 0;
    }
    AppMethodBeat.o(143946);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ai
  extends com.tencent.mm.cd.a
{
  public int REq;
  public int REr;
  public int REs;
  public LinkedList<ag> REt;
  public int REu;
  public LinkedList<ag> REv;
  
  public ai()
  {
    AppMethodBeat.i(143963);
    this.REt = new LinkedList();
    this.REv = new LinkedList();
    AppMethodBeat.o(143963);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143964);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.REq);
      paramVarArgs.aY(2, this.REs);
      paramVarArgs.e(3, 8, this.REt);
      paramVarArgs.aY(4, this.REr);
      paramVarArgs.aY(5, this.REu);
      paramVarArgs.e(6, 8, this.REv);
      AppMethodBeat.o(143964);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.REq);
      i = g.a.a.b.b.a.bM(2, this.REs);
      int j = g.a.a.a.c(3, 8, this.REt);
      int k = g.a.a.b.b.a.bM(4, this.REr);
      int m = g.a.a.b.b.a.bM(5, this.REu);
      int n = g.a.a.a.c(6, 8, this.REv);
      AppMethodBeat.o(143964);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.REt.clear();
      this.REv.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143964);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ai localai = (ai)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      ag localag;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143964);
        return -1;
      case 1: 
        localai.REq = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143964);
        return 0;
      case 2: 
        localai.REs = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143964);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localag = new ag();
          if ((localObject != null) && (localObject.length > 0)) {
            localag.parseFrom((byte[])localObject);
          }
          localai.REt.add(localag);
          paramInt += 1;
        }
        AppMethodBeat.o(143964);
        return 0;
      case 4: 
        localai.REr = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143964);
        return 0;
      case 5: 
        localai.REu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143964);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localag = new ag();
        if ((localObject != null) && (localObject.length > 0)) {
          localag.parseFrom((byte[])localObject);
        }
        localai.REv.add(localag);
        paramInt += 1;
      }
      AppMethodBeat.o(143964);
      return 0;
    }
    AppMethodBeat.o(143964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ai
 * JD-Core Version:    0.7.0.1
 */
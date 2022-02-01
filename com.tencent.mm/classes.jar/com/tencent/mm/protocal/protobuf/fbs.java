package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbs
  extends com.tencent.mm.cd.a
{
  public LinkedList<cvm> Nni;
  public long RQc;
  public LinkedList<ajk> TzO;
  public dbp UBQ;
  public LinkedList<erg> UBR;
  
  public fbs()
  {
    AppMethodBeat.i(110917);
    this.UBR = new LinkedList();
    this.TzO = new LinkedList();
    this.Nni = new LinkedList();
    AppMethodBeat.o(110917);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110918);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RQc);
      if (this.UBQ != null)
      {
        paramVarArgs.oE(2, this.UBQ.computeSize());
        this.UBQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.UBR);
      paramVarArgs.e(4, 8, this.TzO);
      paramVarArgs.e(5, 8, this.Nni);
      AppMethodBeat.o(110918);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.RQc) + 0;
      paramInt = i;
      if (this.UBQ != null) {
        paramInt = i + g.a.a.a.oD(2, this.UBQ.computeSize());
      }
      i = g.a.a.a.c(3, 8, this.UBR);
      int j = g.a.a.a.c(4, 8, this.TzO);
      int k = g.a.a.a.c(5, 8, this.Nni);
      AppMethodBeat.o(110918);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UBR.clear();
      this.TzO.clear();
      this.Nni.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fbs localfbs = (fbs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110918);
        return -1;
      case 1: 
        localfbs.RQc = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(110918);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbp)localObject2).parseFrom((byte[])localObject1);
          }
          localfbs.UBQ = ((dbp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new erg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((erg)localObject2).parseFrom((byte[])localObject1);
          }
          localfbs.UBR.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ajk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ajk)localObject2).parseFrom((byte[])localObject1);
          }
          localfbs.TzO.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cvm();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cvm)localObject2).parseFrom((byte[])localObject1);
        }
        localfbs.Nni.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    AppMethodBeat.o(110918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbs
 * JD-Core Version:    0.7.0.1
 */
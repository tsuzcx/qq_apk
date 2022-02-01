package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bhh
  extends com.tencent.mm.cd.a
{
  public bhg SRT;
  public LinkedList<bhi> SRU;
  public LinkedList<cwk> SRV;
  public long zKM;
  
  public bhh()
  {
    AppMethodBeat.i(184206);
    this.SRU = new LinkedList();
    this.SRV = new LinkedList();
    AppMethodBeat.o(184206);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184207);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.zKM);
      if (this.SRT != null)
      {
        paramVarArgs.oE(2, this.SRT.computeSize());
        this.SRT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.SRU);
      paramVarArgs.e(4, 8, this.SRV);
      AppMethodBeat.o(184207);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.zKM) + 0;
      paramInt = i;
      if (this.SRT != null) {
        paramInt = i + g.a.a.a.oD(2, this.SRT.computeSize());
      }
      i = g.a.a.a.c(3, 8, this.SRU);
      int j = g.a.a.a.c(4, 8, this.SRV);
      AppMethodBeat.o(184207);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SRU.clear();
      this.SRV.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(184207);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bhh localbhh = (bhh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184207);
        return -1;
      case 1: 
        localbhh.zKM = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(184207);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bhg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bhg)localObject2).parseFrom((byte[])localObject1);
          }
          localbhh.SRT = ((bhg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184207);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bhi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bhi)localObject2).parseFrom((byte[])localObject1);
          }
          localbhh.SRU.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184207);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cwk();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cwk)localObject2).parseFrom((byte[])localObject1);
        }
        localbhh.SRV.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(184207);
      return 0;
    }
    AppMethodBeat.o(184207);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhh
 * JD-Core Version:    0.7.0.1
 */
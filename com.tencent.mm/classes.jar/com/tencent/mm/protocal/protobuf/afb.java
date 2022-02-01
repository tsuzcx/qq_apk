package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afb
  extends com.tencent.mm.cd.a
{
  public boolean Gbs;
  public fqo Srw;
  public LinkedList<emg> Srx;
  public int Sry;
  public int dXr;
  public LinkedList<fqn> likeList;
  
  public afb()
  {
    AppMethodBeat.i(271709);
    this.Srx = new LinkedList();
    this.likeList = new LinkedList();
    AppMethodBeat.o(271709);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(271710);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.dXr);
      if (this.Srw != null)
      {
        paramVarArgs.oE(2, this.Srw.computeSize());
        this.Srw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Srx);
      paramVarArgs.aY(4, this.Sry);
      paramVarArgs.e(5, 8, this.likeList);
      paramVarArgs.co(6, this.Gbs);
      AppMethodBeat.o(271710);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.dXr) + 0;
      paramInt = i;
      if (this.Srw != null) {
        paramInt = i + g.a.a.a.oD(2, this.Srw.computeSize());
      }
      i = g.a.a.a.c(3, 8, this.Srx);
      int j = g.a.a.b.b.a.bM(4, this.Sry);
      int k = g.a.a.a.c(5, 8, this.likeList);
      int m = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(271710);
      return paramInt + i + j + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Srx.clear();
      this.likeList.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(271710);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      afb localafb = (afb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(271710);
        return -1;
      case 1: 
        localafb.dXr = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(271710);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fqo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fqo)localObject2).parseFrom((byte[])localObject1);
          }
          localafb.Srw = ((fqo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(271710);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new emg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((emg)localObject2).parseFrom((byte[])localObject1);
          }
          localafb.Srx.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(271710);
        return 0;
      case 4: 
        localafb.Sry = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(271710);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fqn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fqn)localObject2).parseFrom((byte[])localObject1);
          }
          localafb.likeList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(271710);
        return 0;
      }
      localafb.Gbs = ((g.a.a.a.a)localObject1).abFh.AB();
      AppMethodBeat.o(271710);
      return 0;
    }
    AppMethodBeat.o(271710);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afb
 * JD-Core Version:    0.7.0.1
 */
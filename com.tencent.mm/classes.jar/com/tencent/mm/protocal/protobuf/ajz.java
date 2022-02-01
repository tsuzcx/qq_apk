package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajz
  extends com.tencent.mm.cd.a
{
  public String Md5;
  public int rVx;
  public LinkedList<cpt> rVy;
  
  public ajz()
  {
    AppMethodBeat.i(104773);
    this.rVy = new LinkedList();
    AppMethodBeat.o(104773);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104774);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.f(1, this.Md5);
      }
      paramVarArgs.aY(2, this.rVx);
      paramVarArgs.e(3, 8, this.rVy);
      AppMethodBeat.o(104774);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = g.a.a.b.b.a.g(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rVx);
      int j = g.a.a.a.c(3, 8, this.rVy);
      AppMethodBeat.o(104774);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rVy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104774);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ajz localajz = (ajz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104774);
          return -1;
        case 1: 
          localajz.Md5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104774);
          return 0;
        case 2: 
          localajz.rVx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104774);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cpt localcpt = new cpt();
          if ((localObject != null) && (localObject.length > 0)) {
            localcpt.parseFrom((byte[])localObject);
          }
          localajz.rVy.add(localcpt);
          paramInt += 1;
        }
        AppMethodBeat.o(104774);
        return 0;
      }
      AppMethodBeat.o(104774);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mz
  extends com.tencent.mm.cd.a
{
  public mx RTK;
  public LinkedList<my> RTM;
  public String RTN;
  
  public mz()
  {
    AppMethodBeat.i(124400);
    this.RTM = new LinkedList();
    AppMethodBeat.o(124400);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124401);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RTK != null)
      {
        paramVarArgs.oE(1, this.RTK.computeSize());
        this.RTK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.RTM);
      if (this.RTN != null) {
        paramVarArgs.f(6, this.RTN);
      }
      AppMethodBeat.o(124401);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RTK == null) {
        break label482;
      }
    }
    label482:
    for (paramInt = g.a.a.a.oD(1, this.RTK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.RTM);
      paramInt = i;
      if (this.RTN != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RTN);
      }
      AppMethodBeat.o(124401);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RTM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124401);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mz localmz = (mz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        default: 
          AppMethodBeat.o(124401);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new mx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((mx)localObject2).parseFrom((byte[])localObject1);
            }
            localmz.RTK = ((mx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124401);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new my();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((my)localObject2).parseFrom((byte[])localObject1);
            }
            localmz.RTM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124401);
          return 0;
        }
        localmz.RTN = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(124401);
        return 0;
      }
      AppMethodBeat.o(124401);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public final class ba
  extends dyy
{
  public LinkedList<al> HnJ;
  public LinkedList<al> HnK;
  public LinkedList<al> HnL;
  public long HnM;
  public boolean HnN;
  
  public ba()
  {
    AppMethodBeat.i(250056);
    this.HnJ = new LinkedList();
    this.HnK = new LinkedList();
    this.HnL = new LinkedList();
    AppMethodBeat.o(250056);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250057);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.HnJ);
      paramVarArgs.e(3, 8, this.HnK);
      paramVarArgs.e(4, 8, this.HnL);
      paramVarArgs.bm(5, this.HnM);
      paramVarArgs.co(6, this.HnN);
      AppMethodBeat.o(250057);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.HnJ);
      int j = g.a.a.a.c(3, 8, this.HnK);
      int k = g.a.a.a.c(4, 8, this.HnL);
      int m = g.a.a.b.b.a.p(5, this.HnM);
      int n = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(250057);
      return paramInt + i + j + k + m + (n + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HnJ.clear();
        this.HnK.clear();
        this.HnL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250057);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ba localba = (ba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250057);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localba.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250057);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new al();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((al)localObject2).parseFrom((byte[])localObject1);
            }
            localba.HnJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250057);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new al();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((al)localObject2).parseFrom((byte[])localObject1);
            }
            localba.HnK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250057);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new al();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((al)localObject2).parseFrom((byte[])localObject1);
            }
            localba.HnL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250057);
          return 0;
        case 5: 
          localba.HnM = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(250057);
          return 0;
        }
        localba.HnN = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(250057);
        return 0;
      }
      AppMethodBeat.o(250057);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ba
 * JD-Core Version:    0.7.0.1
 */
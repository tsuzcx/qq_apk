package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apb
  extends buy
{
  public long bqN;
  public int bxy;
  public int xfb;
  public pm xfc;
  public ts xfd;
  public int xfe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134430);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xfb);
      paramVarArgs.aO(3, this.bxy);
      if (this.xfc != null)
      {
        paramVarArgs.iQ(4, this.xfc.computeSize());
        this.xfc.writeFields(paramVarArgs);
      }
      paramVarArgs.am(5, this.bqN);
      if (this.xfd != null)
      {
        paramVarArgs.iQ(6, this.xfd.computeSize());
        this.xfd.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.xfe);
      AppMethodBeat.o(134430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xfb) + e.a.a.b.b.a.bl(3, this.bxy);
      paramInt = i;
      if (this.xfc != null) {
        paramInt = i + e.a.a.a.iP(4, this.xfc.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.p(5, this.bqN);
      paramInt = i;
      if (this.xfd != null) {
        paramInt = i + e.a.a.a.iP(6, this.xfd.computeSize());
      }
      i = e.a.a.b.b.a.bl(7, this.xfe);
      AppMethodBeat.o(134430);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(134430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        apb localapb = (apb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134430);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localapb.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134430);
          return 0;
        case 2: 
          localapb.xfb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(134430);
          return 0;
        case 3: 
          localapb.bxy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(134430);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localapb.xfc = ((pm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134430);
          return 0;
        case 5: 
          localapb.bqN = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(134430);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ts();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ts)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localapb.xfd = ((ts)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134430);
          return 0;
        }
        localapb.xfe = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(134430);
        return 0;
      }
      AppMethodBeat.o(134430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apb
 * JD-Core Version:    0.7.0.1
 */
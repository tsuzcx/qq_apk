package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cn
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public int nqW;
  public long pIG;
  public int woW;
  public bwc woX;
  public int woY;
  public bwc woZ;
  public int wpa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58885);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.woX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomId");
        AppMethodBeat.o(58885);
        throw paramVarArgs;
      }
      if (this.woZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: DigestContent");
        AppMethodBeat.o(58885);
        throw paramVarArgs;
      }
      if (this.woX != null)
      {
        paramVarArgs.iQ(1, this.woX.computeSize());
        this.woX.writeFields(paramVarArgs);
      }
      paramVarArgs.am(2, this.pIG);
      paramVarArgs.aO(3, this.woW);
      paramVarArgs.aO(4, this.CreateTime);
      paramVarArgs.aO(5, this.woY);
      if (this.woZ != null)
      {
        paramVarArgs.iQ(6, this.woZ.computeSize());
        this.woZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.wpa);
      paramVarArgs.aO(8, this.nqW);
      AppMethodBeat.o(58885);
      return 0;
    }
    if (paramInt == 1) {
      if (this.woX == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = e.a.a.a.iP(1, this.woX.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.pIG) + e.a.a.b.b.a.bl(3, this.woW) + e.a.a.b.b.a.bl(4, this.CreateTime) + e.a.a.b.b.a.bl(5, this.woY);
      paramInt = i;
      if (this.woZ != null) {
        paramInt = i + e.a.a.a.iP(6, this.woZ.computeSize());
      }
      i = e.a.a.b.b.a.bl(7, this.wpa);
      int j = e.a.a.b.b.a.bl(8, this.nqW);
      AppMethodBeat.o(58885);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.woX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomId");
          AppMethodBeat.o(58885);
          throw paramVarArgs;
        }
        if (this.woZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: DigestContent");
          AppMethodBeat.o(58885);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58885);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cn localcn = (cn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58885);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcn.woX = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58885);
          return 0;
        case 2: 
          localcn.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(58885);
          return 0;
        case 3: 
          localcn.woW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58885);
          return 0;
        case 4: 
          localcn.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58885);
          return 0;
        case 5: 
          localcn.woY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58885);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcn.woZ = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58885);
          return 0;
        case 7: 
          localcn.wpa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58885);
          return 0;
        }
        localcn.nqW = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58885);
        return 0;
      }
      AppMethodBeat.o(58885);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cn
 * JD-Core Version:    0.7.0.1
 */
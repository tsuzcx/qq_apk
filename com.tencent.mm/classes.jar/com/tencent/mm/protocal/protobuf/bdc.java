package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bdc
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public int jKs;
  public String ntu;
  public bwc woQ;
  public String woU;
  public int xtf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60044);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.woQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(60044);
        throw paramVarArgs;
      }
      if (this.woQ != null)
      {
        paramVarArgs.iQ(1, this.woQ.computeSize());
        this.woQ.writeFields(paramVarArgs);
      }
      if (this.ntu != null) {
        paramVarArgs.e(2, this.ntu);
      }
      paramVarArgs.aO(3, this.jKs);
      paramVarArgs.aO(4, this.CreateTime);
      paramVarArgs.aO(5, this.xtf);
      if (this.woU != null) {
        paramVarArgs.e(6, this.woU);
      }
      AppMethodBeat.o(60044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.woQ == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = e.a.a.a.iP(1, this.woQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ntu != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.ntu);
      }
      i = i + e.a.a.b.b.a.bl(3, this.jKs) + e.a.a.b.b.a.bl(4, this.CreateTime) + e.a.a.b.b.a.bl(5, this.xtf);
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.woU);
      }
      AppMethodBeat.o(60044);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.woQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(60044);
          throw paramVarArgs;
        }
        AppMethodBeat.o(60044);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bdc localbdc = (bdc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(60044);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdc.woQ = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60044);
          return 0;
        case 2: 
          localbdc.ntu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60044);
          return 0;
        case 3: 
          localbdc.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60044);
          return 0;
        case 4: 
          localbdc.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60044);
          return 0;
        case 5: 
          localbdc.xtf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60044);
          return 0;
        }
        localbdc.woU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60044);
        return 0;
      }
      AppMethodBeat.o(60044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdc
 * JD-Core Version:    0.7.0.1
 */
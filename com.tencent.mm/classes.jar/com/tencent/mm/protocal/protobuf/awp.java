package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class awp
  extends buy
{
  public int eeF;
  public LinkedList<bcw> wov;
  public bwc wow;
  public int xmg;
  public String xmh;
  
  public awp()
  {
    AppMethodBeat.i(5590);
    this.wov = new LinkedList();
    AppMethodBeat.o(5590);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5591);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wow == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(5591);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.eeF);
      paramVarArgs.e(3, 8, this.wov);
      if (this.wow != null)
      {
        paramVarArgs.iQ(4, this.wow.computeSize());
        this.wow.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xmg);
      if (this.xmh != null) {
        paramVarArgs.e(6, this.xmh);
      }
      AppMethodBeat.o(5591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.eeF) + e.a.a.a.c(3, 8, this.wov);
      paramInt = i;
      if (this.wow != null) {
        paramInt = i + e.a.a.a.iP(4, this.wow.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xmg);
      paramInt = i;
      if (this.xmh != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xmh);
      }
      AppMethodBeat.o(5591);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wov.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wow == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(5591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        awp localawp = (awp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5591);
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
            localawp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5591);
          return 0;
        case 2: 
          localawp.eeF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5591);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localawp.wov.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5591);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localawp.wow = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5591);
          return 0;
        case 5: 
          localawp.xmg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5591);
          return 0;
        }
        localawp.xmh = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(5591);
        return 0;
      }
      AppMethodBeat.o(5591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awp
 * JD-Core Version:    0.7.0.1
 */
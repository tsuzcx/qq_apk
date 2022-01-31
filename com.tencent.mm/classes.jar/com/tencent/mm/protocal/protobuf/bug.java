package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bug
  extends buy
{
  public LinkedList<String> EmotionList;
  public int jKs;
  public String wxW;
  public bus xHA;
  public bub xHz;
  
  public bug()
  {
    AppMethodBeat.i(65417);
    this.EmotionList = new LinkedList();
    AppMethodBeat.o(65417);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(65418);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jKs);
      if (this.xHz != null)
      {
        paramVarArgs.iQ(3, this.xHz.computeSize());
        this.xHz.writeFields(paramVarArgs);
      }
      if (this.xHA != null)
      {
        paramVarArgs.iQ(4, this.xHA.computeSize());
        this.xHA.writeFields(paramVarArgs);
      }
      if (this.wxW != null) {
        paramVarArgs.e(5, this.wxW);
      }
      paramVarArgs.e(6, 1, this.EmotionList);
      AppMethodBeat.o(65418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKs);
      paramInt = i;
      if (this.xHz != null) {
        paramInt = i + e.a.a.a.iP(3, this.xHz.computeSize());
      }
      i = paramInt;
      if (this.xHA != null) {
        i = paramInt + e.a.a.a.iP(4, this.xHA.computeSize());
      }
      paramInt = i;
      if (this.wxW != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wxW);
      }
      i = e.a.a.a.c(6, 1, this.EmotionList);
      AppMethodBeat.o(65418);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(65418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bug localbug = (bug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(65418);
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
            localbug.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(65418);
          return 0;
        case 2: 
          localbug.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(65418);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bub();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bub)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbug.xHz = ((bub)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(65418);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bus();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bus)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbug.xHA = ((bus)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(65418);
          return 0;
        case 5: 
          localbug.wxW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(65418);
          return 0;
        }
        localbug.EmotionList.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(65418);
        return 0;
      }
      AppMethodBeat.o(65418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bug
 * JD-Core Version:    0.7.0.1
 */
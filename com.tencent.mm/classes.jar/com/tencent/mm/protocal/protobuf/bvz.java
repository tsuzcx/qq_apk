package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvz
  extends com.tencent.mm.bv.a
{
  public int type;
  public String url;
  public LinkedList<yl> wOK;
  public boolean xJA;
  public wb xJB;
  public ba xJC;
  public ckg xJx;
  public yk xJy;
  public int xJz;
  
  public bvz()
  {
    AppMethodBeat.i(48961);
    this.wOK = new LinkedList();
    AppMethodBeat.o(48961);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48962);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.xJx != null)
      {
        paramVarArgs.iQ(3, this.xJx.computeSize());
        this.xJx.writeFields(paramVarArgs);
      }
      if (this.xJy != null)
      {
        paramVarArgs.iQ(4, this.xJy.computeSize());
        this.xJy.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xJz);
      paramVarArgs.aS(6, this.xJA);
      paramVarArgs.e(7, 8, this.wOK);
      if (this.xJB != null)
      {
        paramVarArgs.iQ(8, this.xJB.computeSize());
        this.xJB.writeFields(paramVarArgs);
      }
      if (this.xJC != null)
      {
        paramVarArgs.iQ(9, this.xJC.computeSize());
        this.xJC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48962);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.xJx != null) {
        i = paramInt + e.a.a.a.iP(3, this.xJx.computeSize());
      }
      paramInt = i;
      if (this.xJy != null) {
        paramInt = i + e.a.a.a.iP(4, this.xJy.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xJz) + (e.a.a.b.b.a.eW(6) + 1) + e.a.a.a.c(7, 8, this.wOK);
      paramInt = i;
      if (this.xJB != null) {
        paramInt = i + e.a.a.a.iP(8, this.xJB.computeSize());
      }
      i = paramInt;
      if (this.xJC != null) {
        i = paramInt + e.a.a.a.iP(9, this.xJC.computeSize());
      }
      AppMethodBeat.o(48962);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wOK.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(48962);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bvz localbvz = (bvz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48962);
        return -1;
      case 1: 
        localbvz.type = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48962);
        return 0;
      case 2: 
        localbvz.url = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48962);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ckg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbvz.xJx = ((ckg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48962);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbvz.xJy = ((yk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48962);
        return 0;
      case 5: 
        localbvz.xJz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48962);
        return 0;
      case 6: 
        localbvz.xJA = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(48962);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yl();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbvz.wOK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48962);
        return 0;
      case 8: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new wb();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((wb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbvz.xJB = ((wb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48962);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ba();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ba)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbvz.xJC = ((ba)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(48962);
      return 0;
    }
    AppMethodBeat.o(48962);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvz
 * JD-Core Version:    0.7.0.1
 */
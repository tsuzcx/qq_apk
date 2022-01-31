package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ox
  extends com.tencent.mm.bv.a
{
  public String poq;
  public String por;
  public int state;
  public awf wFA;
  public LinkedList<cjw> wFB;
  public int wFC;
  public int wFD;
  public cjw wmY;
  public bvz wna;
  public String wug;
  
  public ox()
  {
    AppMethodBeat.i(48789);
    this.wFB = new LinkedList();
    AppMethodBeat.o(48789);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48790);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wFA != null)
      {
        paramVarArgs.iQ(1, this.wFA.computeSize());
        this.wFA.writeFields(paramVarArgs);
      }
      if (this.wmY != null)
      {
        paramVarArgs.iQ(2, this.wmY.computeSize());
        this.wmY.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.wFB);
      if (this.por != null) {
        paramVarArgs.e(4, this.por);
      }
      if (this.poq != null) {
        paramVarArgs.e(5, this.poq);
      }
      if (this.wna != null)
      {
        paramVarArgs.iQ(6, this.wna.computeSize());
        this.wna.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.state);
      paramVarArgs.aO(8, this.wFC);
      paramVarArgs.aO(9, this.wFD);
      if (this.wug != null) {
        paramVarArgs.e(10, this.wug);
      }
      AppMethodBeat.o(48790);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wFA == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = e.a.a.a.iP(1, this.wFA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wmY != null) {
        i = paramInt + e.a.a.a.iP(2, this.wmY.computeSize());
      }
      i += e.a.a.a.c(3, 8, this.wFB);
      paramInt = i;
      if (this.por != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.por);
      }
      i = paramInt;
      if (this.poq != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.poq);
      }
      paramInt = i;
      if (this.wna != null) {
        paramInt = i + e.a.a.a.iP(6, this.wna.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.state) + e.a.a.b.b.a.bl(8, this.wFC) + e.a.a.b.b.a.bl(9, this.wFD);
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wug);
      }
      AppMethodBeat.o(48790);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wFB.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48790);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ox localox = (ox)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48790);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localox.wFA = ((awf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48790);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localox.wmY = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48790);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localox.wFB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48790);
          return 0;
        case 4: 
          localox.por = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48790);
          return 0;
        case 5: 
          localox.poq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48790);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localox.wna = ((bvz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48790);
          return 0;
        case 7: 
          localox.state = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48790);
          return 0;
        case 8: 
          localox.wFC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48790);
          return 0;
        case 9: 
          localox.wFD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48790);
          return 0;
        }
        localox.wug = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48790);
        return 0;
      }
      AppMethodBeat.o(48790);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ox
 * JD-Core Version:    0.7.0.1
 */
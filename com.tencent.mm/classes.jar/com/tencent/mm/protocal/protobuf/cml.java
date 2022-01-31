package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cml
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String title;
  public LinkedList<cmj> wlK;
  public int xED;
  public String xWf;
  public String xWg;
  public bae xWh;
  public int xWi;
  public cmk xWj;
  public cmk xWk;
  
  public cml()
  {
    AppMethodBeat.i(48979);
    this.wlK = new LinkedList();
    AppMethodBeat.o(48979);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48980);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.xWf != null) {
        paramVarArgs.e(3, this.xWf);
      }
      if (this.xWg != null) {
        paramVarArgs.e(4, this.xWg);
      }
      if (this.xWh != null)
      {
        paramVarArgs.iQ(5, this.xWh.computeSize());
        this.xWh.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.wlK);
      paramVarArgs.aO(7, this.xED);
      paramVarArgs.aO(8, this.xWi);
      if (this.xWj != null)
      {
        paramVarArgs.iQ(9, this.xWj.computeSize());
        this.xWj.writeFields(paramVarArgs);
      }
      if (this.xWk != null)
      {
        paramVarArgs.iQ(10, this.xWk.computeSize());
        this.xWk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48980);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.xWf != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xWf);
      }
      paramInt = i;
      if (this.xWg != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xWg);
      }
      i = paramInt;
      if (this.xWh != null) {
        i = paramInt + e.a.a.a.iP(5, this.xWh.computeSize());
      }
      i = i + e.a.a.a.c(6, 8, this.wlK) + e.a.a.b.b.a.bl(7, this.xED) + e.a.a.b.b.a.bl(8, this.xWi);
      paramInt = i;
      if (this.xWj != null) {
        paramInt = i + e.a.a.a.iP(9, this.xWj.computeSize());
      }
      i = paramInt;
      if (this.xWk != null) {
        i = paramInt + e.a.a.a.iP(10, this.xWk.computeSize());
      }
      AppMethodBeat.o(48980);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wlK.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48980);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cml localcml = (cml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48980);
          return -1;
        case 1: 
          localcml.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48980);
          return 0;
        case 2: 
          localcml.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48980);
          return 0;
        case 3: 
          localcml.xWf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48980);
          return 0;
        case 4: 
          localcml.xWg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48980);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bae();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bae)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcml.xWh = ((bae)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48980);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcml.wlK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48980);
          return 0;
        case 7: 
          localcml.xED = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48980);
          return 0;
        case 8: 
          localcml.xWi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48980);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmk();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcml.xWj = ((cmk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48980);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcml.xWk = ((cmk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48980);
        return 0;
      }
      AppMethodBeat.o(48980);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cml
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bln
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String kmm;
  public String name;
  public int pdt;
  public String title;
  public String uaJ;
  public String uaL;
  public String ugl;
  public bst xAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48918);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      if (this.kmm != null) {
        paramVarArgs.e(4, this.kmm);
      }
      paramVarArgs.aO(5, this.pdt);
      if (this.uaJ != null) {
        paramVarArgs.e(6, this.uaJ);
      }
      if (this.ugl != null) {
        paramVarArgs.e(7, this.ugl);
      }
      if (this.uaL != null) {
        paramVarArgs.e(8, this.uaL);
      }
      if (this.xAk != null)
      {
        paramVarArgs.iQ(9, this.xAk.computeSize());
        this.xAk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48918);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label782;
      }
    }
    label782:
    for (int i = e.a.a.b.b.a.f(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.desc);
      }
      paramInt = i;
      if (this.kmm != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kmm);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.pdt);
      paramInt = i;
      if (this.uaJ != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.uaJ);
      }
      i = paramInt;
      if (this.ugl != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.ugl);
      }
      paramInt = i;
      if (this.uaL != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.uaL);
      }
      i = paramInt;
      if (this.xAk != null) {
        i = paramInt + e.a.a.a.iP(9, this.xAk.computeSize());
      }
      AppMethodBeat.o(48918);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48918);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bln localbln = (bln)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48918);
          return -1;
        case 1: 
          localbln.name = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48918);
          return 0;
        case 2: 
          localbln.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48918);
          return 0;
        case 3: 
          localbln.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48918);
          return 0;
        case 4: 
          localbln.kmm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48918);
          return 0;
        case 5: 
          localbln.pdt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48918);
          return 0;
        case 6: 
          localbln.uaJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48918);
          return 0;
        case 7: 
          localbln.ugl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48918);
          return 0;
        case 8: 
          localbln.uaL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48918);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bst();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bst)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbln.xAk = ((bst)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48918);
        return 0;
      }
      AppMethodBeat.o(48918);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bln
 * JD-Core Version:    0.7.0.1
 */
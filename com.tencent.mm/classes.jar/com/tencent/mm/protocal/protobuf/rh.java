package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class rh
  extends com.tencent.mm.bx.a
{
  public int FIy;
  public String FNt;
  public b FNu;
  public ri FNv;
  public rg FNw;
  public rj FNx;
  public String Fsc;
  public String FuI;
  public String ovl;
  public String ovm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194970);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FIy);
      if (this.ovl != null) {
        paramVarArgs.d(2, this.ovl);
      }
      if (this.ovm != null) {
        paramVarArgs.d(3, this.ovm);
      }
      if (this.Fsc != null) {
        paramVarArgs.d(4, this.Fsc);
      }
      if (this.FNt != null) {
        paramVarArgs.d(5, this.FNt);
      }
      if (this.FNu != null) {
        paramVarArgs.c(6, this.FNu);
      }
      if (this.FuI != null) {
        paramVarArgs.d(7, this.FuI);
      }
      if (this.FNv != null)
      {
        paramVarArgs.lC(101, this.FNv.computeSize());
        this.FNv.writeFields(paramVarArgs);
      }
      if (this.FNw != null)
      {
        paramVarArgs.lC(102, this.FNw.computeSize());
        this.FNw.writeFields(paramVarArgs);
      }
      if (this.FNx != null)
      {
        paramVarArgs.lC(103, this.FNx.computeSize());
        this.FNx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194970);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FIy) + 0;
      paramInt = i;
      if (this.ovl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ovl);
      }
      i = paramInt;
      if (this.ovm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ovm);
      }
      paramInt = i;
      if (this.Fsc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fsc);
      }
      i = paramInt;
      if (this.FNt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FNt);
      }
      paramInt = i;
      if (this.FNu != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.FNu);
      }
      i = paramInt;
      if (this.FuI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FuI);
      }
      paramInt = i;
      if (this.FNv != null) {
        paramInt = i + f.a.a.a.lB(101, this.FNv.computeSize());
      }
      i = paramInt;
      if (this.FNw != null) {
        i = paramInt + f.a.a.a.lB(102, this.FNw.computeSize());
      }
      paramInt = i;
      if (this.FNx != null) {
        paramInt = i + f.a.a.a.lB(103, this.FNx.computeSize());
      }
      AppMethodBeat.o(194970);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(194970);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      rh localrh = (rh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194970);
        return -1;
      case 1: 
        localrh.FIy = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(194970);
        return 0;
      case 2: 
        localrh.ovl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(194970);
        return 0;
      case 3: 
        localrh.ovm = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(194970);
        return 0;
      case 4: 
        localrh.Fsc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(194970);
        return 0;
      case 5: 
        localrh.FNt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(194970);
        return 0;
      case 6: 
        localrh.FNu = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(194970);
        return 0;
      case 7: 
        localrh.FuI = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(194970);
        return 0;
      case 101: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ri();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ri)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrh.FNv = ((ri)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194970);
        return 0;
      case 102: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrh.FNw = ((rg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194970);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new rj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((rj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localrh.FNx = ((rj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(194970);
      return 0;
    }
    AppMethodBeat.o(194970);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rh
 * JD-Core Version:    0.7.0.1
 */
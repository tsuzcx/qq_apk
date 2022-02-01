package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brk
  extends com.tencent.mm.bx.a
{
  public String ZZA;
  public String ZZB;
  public String ZZC;
  public String ZZD;
  public String ZZE;
  public String ZZr;
  public String ZZs;
  public String ZZt;
  public String ZZu;
  public String ZZv;
  public String ZZw;
  public String ZZx;
  public String ZZy;
  public String ZZz;
  public LinkedList<brf> nUC;
  public int objectType;
  
  public brk()
  {
    AppMethodBeat.i(257340);
    this.nUC = new LinkedList();
    AppMethodBeat.o(257340);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257343);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.objectType);
      if (this.ZZr != null) {
        paramVarArgs.g(2, this.ZZr);
      }
      if (this.ZZs != null) {
        paramVarArgs.g(3, this.ZZs);
      }
      if (this.ZZt != null) {
        paramVarArgs.g(4, this.ZZt);
      }
      if (this.ZZu != null) {
        paramVarArgs.g(5, this.ZZu);
      }
      if (this.ZZv != null) {
        paramVarArgs.g(6, this.ZZv);
      }
      if (this.ZZw != null) {
        paramVarArgs.g(7, this.ZZw);
      }
      if (this.ZZx != null) {
        paramVarArgs.g(8, this.ZZx);
      }
      if (this.ZZy != null) {
        paramVarArgs.g(9, this.ZZy);
      }
      if (this.ZZz != null) {
        paramVarArgs.g(10, this.ZZz);
      }
      if (this.ZZA != null) {
        paramVarArgs.g(11, this.ZZA);
      }
      if (this.ZZB != null) {
        paramVarArgs.g(12, this.ZZB);
      }
      if (this.ZZC != null) {
        paramVarArgs.g(13, this.ZZC);
      }
      if (this.ZZD != null) {
        paramVarArgs.g(14, this.ZZD);
      }
      if (this.ZZE != null) {
        paramVarArgs.g(15, this.ZZE);
      }
      paramVarArgs.e(16, 8, this.nUC);
      AppMethodBeat.o(257343);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.objectType) + 0;
      paramInt = i;
      if (this.ZZr != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZZr);
      }
      i = paramInt;
      if (this.ZZs != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZZs);
      }
      paramInt = i;
      if (this.ZZt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZZt);
      }
      i = paramInt;
      if (this.ZZu != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZZu);
      }
      paramInt = i;
      if (this.ZZv != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZZv);
      }
      i = paramInt;
      if (this.ZZw != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZZw);
      }
      paramInt = i;
      if (this.ZZx != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZZx);
      }
      i = paramInt;
      if (this.ZZy != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZZy);
      }
      paramInt = i;
      if (this.ZZz != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ZZz);
      }
      i = paramInt;
      if (this.ZZA != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZZA);
      }
      paramInt = i;
      if (this.ZZB != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ZZB);
      }
      i = paramInt;
      if (this.ZZC != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.ZZC);
      }
      paramInt = i;
      if (this.ZZD != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.ZZD);
      }
      i = paramInt;
      if (this.ZZE != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.ZZE);
      }
      paramInt = i.a.a.a.c(16, 8, this.nUC);
      AppMethodBeat.o(257343);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nUC.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257343);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      brk localbrk = (brk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257343);
        return -1;
      case 1: 
        localbrk.objectType = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257343);
        return 0;
      case 2: 
        localbrk.ZZr = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 3: 
        localbrk.ZZs = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 4: 
        localbrk.ZZt = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 5: 
        localbrk.ZZu = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 6: 
        localbrk.ZZv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 7: 
        localbrk.ZZw = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 8: 
        localbrk.ZZx = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 9: 
        localbrk.ZZy = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 10: 
        localbrk.ZZz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 11: 
        localbrk.ZZA = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 12: 
        localbrk.ZZB = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 13: 
        localbrk.ZZC = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 14: 
        localbrk.ZZD = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      case 15: 
        localbrk.ZZE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257343);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        brf localbrf = new brf();
        if ((localObject != null) && (localObject.length > 0)) {
          localbrf.parseFrom((byte[])localObject);
        }
        localbrk.nUC.add(localbrf);
        paramInt += 1;
      }
      AppMethodBeat.o(257343);
      return 0;
    }
    AppMethodBeat.o(257343);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brk
 * JD-Core Version:    0.7.0.1
 */
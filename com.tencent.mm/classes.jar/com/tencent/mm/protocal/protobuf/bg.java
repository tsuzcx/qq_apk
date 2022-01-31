package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bg
  extends com.tencent.mm.bv.a
{
  public String npZ;
  public String nqL;
  public String ntp;
  public String wnA;
  public String wnB;
  public String wnC;
  public dbw wnD;
  public String wnE;
  public String wnx;
  public String wny;
  public String wnz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80006);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npZ != null) {
        paramVarArgs.e(1, this.npZ);
      }
      if (this.wnx != null) {
        paramVarArgs.e(2, this.wnx);
      }
      if (this.wny != null) {
        paramVarArgs.e(3, this.wny);
      }
      if (this.nqL != null) {
        paramVarArgs.e(4, this.nqL);
      }
      if (this.ntp != null) {
        paramVarArgs.e(5, this.ntp);
      }
      if (this.wnz != null) {
        paramVarArgs.e(6, this.wnz);
      }
      if (this.wnA != null) {
        paramVarArgs.e(7, this.wnA);
      }
      if (this.wnB != null) {
        paramVarArgs.e(8, this.wnB);
      }
      if (this.wnC != null) {
        paramVarArgs.e(9, this.wnC);
      }
      if (this.wnD != null)
      {
        paramVarArgs.iQ(10, this.wnD.computeSize());
        this.wnD.writeFields(paramVarArgs);
      }
      if (this.wnE != null) {
        paramVarArgs.e(11, this.wnE);
      }
      AppMethodBeat.o(80006);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npZ == null) {
        break label922;
      }
    }
    label922:
    for (int i = e.a.a.b.b.a.f(1, this.npZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wnx != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wnx);
      }
      i = paramInt;
      if (this.wny != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wny);
      }
      paramInt = i;
      if (this.nqL != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nqL);
      }
      i = paramInt;
      if (this.ntp != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ntp);
      }
      paramInt = i;
      if (this.wnz != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wnz);
      }
      i = paramInt;
      if (this.wnA != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wnA);
      }
      paramInt = i;
      if (this.wnB != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wnB);
      }
      i = paramInt;
      if (this.wnC != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wnC);
      }
      paramInt = i;
      if (this.wnD != null) {
        paramInt = i + e.a.a.a.iP(10, this.wnD.computeSize());
      }
      i = paramInt;
      if (this.wnE != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wnE);
      }
      AppMethodBeat.o(80006);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80006);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bg localbg = (bg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80006);
          return -1;
        case 1: 
          localbg.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80006);
          return 0;
        case 2: 
          localbg.wnx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80006);
          return 0;
        case 3: 
          localbg.wny = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80006);
          return 0;
        case 4: 
          localbg.nqL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80006);
          return 0;
        case 5: 
          localbg.ntp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80006);
          return 0;
        case 6: 
          localbg.wnz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80006);
          return 0;
        case 7: 
          localbg.wnA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80006);
          return 0;
        case 8: 
          localbg.wnB = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80006);
          return 0;
        case 9: 
          localbg.wnC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80006);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dbw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbg.wnD = ((dbw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80006);
          return 0;
        }
        localbg.wnE = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80006);
        return 0;
      }
      AppMethodBeat.o(80006);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bg
 * JD-Core Version:    0.7.0.1
 */
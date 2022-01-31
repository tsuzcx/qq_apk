package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aci
  extends com.tencent.mm.bv.a
{
  public String cqX;
  public int duration;
  public int fgh = -1;
  public int fgi;
  public int fgj = 0;
  public int fgk;
  public String fgl;
  public String fjB;
  public String fjJ;
  public int videoHeight;
  public int videoWidth;
  public acj wUS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(141620);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.fgh);
      paramVarArgs.aO(2, this.fgj);
      paramVarArgs.aO(3, this.videoWidth);
      paramVarArgs.aO(4, this.videoHeight);
      paramVarArgs.aO(5, this.fgi);
      paramVarArgs.aO(6, this.duration);
      if (this.fgl != null) {
        paramVarArgs.e(7, this.fgl);
      }
      if (this.cqX != null) {
        paramVarArgs.e(8, this.cqX);
      }
      if (this.fjB != null) {
        paramVarArgs.e(9, this.fjB);
      }
      paramVarArgs.aO(10, this.fgk);
      if (this.wUS != null)
      {
        paramVarArgs.iQ(11, this.wUS.computeSize());
        this.wUS.writeFields(paramVarArgs);
      }
      if (this.fjJ != null) {
        paramVarArgs.e(12, this.fjJ);
      }
      AppMethodBeat.o(141620);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.fgh) + 0 + e.a.a.b.b.a.bl(2, this.fgj) + e.a.a.b.b.a.bl(3, this.videoWidth) + e.a.a.b.b.a.bl(4, this.videoHeight) + e.a.a.b.b.a.bl(5, this.fgi) + e.a.a.b.b.a.bl(6, this.duration);
      paramInt = i;
      if (this.fgl != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.fgl);
      }
      i = paramInt;
      if (this.cqX != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.cqX);
      }
      paramInt = i;
      if (this.fjB != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.fjB);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.fgk);
      paramInt = i;
      if (this.wUS != null) {
        paramInt = i + e.a.a.a.iP(11, this.wUS.computeSize());
      }
      i = paramInt;
      if (this.fjJ != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.fjJ);
      }
      AppMethodBeat.o(141620);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(141620);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      aci localaci = (aci)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(141620);
        return -1;
      case 1: 
        localaci.fgh = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141620);
        return 0;
      case 2: 
        localaci.fgj = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141620);
        return 0;
      case 3: 
        localaci.videoWidth = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141620);
        return 0;
      case 4: 
        localaci.videoHeight = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141620);
        return 0;
      case 5: 
        localaci.fgi = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141620);
        return 0;
      case 6: 
        localaci.duration = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141620);
        return 0;
      case 7: 
        localaci.fgl = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141620);
        return 0;
      case 8: 
        localaci.cqX = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141620);
        return 0;
      case 9: 
        localaci.fjB = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141620);
        return 0;
      case 10: 
        localaci.fgk = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141620);
        return 0;
      case 11: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((acj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaci.wUS = ((acj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(141620);
        return 0;
      }
      localaci.fjJ = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(141620);
      return 0;
    }
    AppMethodBeat.o(141620);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aci
 * JD-Core Version:    0.7.0.1
 */
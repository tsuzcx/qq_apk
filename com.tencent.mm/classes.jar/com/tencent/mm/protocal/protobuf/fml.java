package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fml
  extends com.tencent.mm.bx.a
{
  public etg YCV;
  public String YMe;
  public int abMH;
  public alg abMI;
  public int abMJ;
  public long ayn;
  public String mAD;
  public float size;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91713);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ayn);
      if (this.mAD != null) {
        paramVarArgs.g(2, this.mAD);
      }
      if (this.text != null) {
        paramVarArgs.g(3, this.text);
      }
      paramVarArgs.l(4, this.size);
      if (this.YCV != null)
      {
        paramVarArgs.qD(5, this.YCV.computeSize());
        this.YCV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.abMH);
      if (this.YMe != null) {
        paramVarArgs.g(7, this.YMe);
      }
      if (this.abMI != null)
      {
        paramVarArgs.qD(8, this.abMI.computeSize());
        this.abMI.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.abMJ);
      AppMethodBeat.o(91713);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.ayn) + 0;
      paramInt = i;
      if (this.mAD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mAD);
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.text);
      }
      i += i.a.a.b.b.a.ko(4) + 4;
      paramInt = i;
      if (this.YCV != null) {
        paramInt = i + i.a.a.a.qC(5, this.YCV.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abMH);
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YMe);
      }
      i = paramInt;
      if (this.abMI != null) {
        i = paramInt + i.a.a.a.qC(8, this.abMI.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(11, this.abMJ);
      AppMethodBeat.o(91713);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fml localfml = (fml)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 9: 
      case 10: 
      default: 
        AppMethodBeat.o(91713);
        return -1;
      case 1: 
        localfml.ayn = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(91713);
        return 0;
      case 2: 
        localfml.mAD = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 3: 
        localfml.text = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 4: 
        localfml.size = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
        AppMethodBeat.o(91713);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etg)localObject2).parseFrom((byte[])localObject1);
          }
          localfml.YCV = ((etg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91713);
        return 0;
      case 6: 
        localfml.abMH = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91713);
        return 0;
      case 7: 
        localfml.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new alg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((alg)localObject2).parseFrom((byte[])localObject1);
          }
          localfml.abMI = ((alg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91713);
        return 0;
      }
      localfml.abMJ = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(91713);
      return 0;
    }
    AppMethodBeat.o(91713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fml
 * JD-Core Version:    0.7.0.1
 */
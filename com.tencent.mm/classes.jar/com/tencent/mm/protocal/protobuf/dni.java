package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dni
  extends com.tencent.mm.bw.a
{
  public cxk FLp;
  public String FUn;
  public long HUs;
  public int HUt;
  public afu HUu;
  public float size;
  public String text;
  public String ydG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91713);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.HUs);
      if (this.ydG != null) {
        paramVarArgs.d(2, this.ydG);
      }
      if (this.text != null) {
        paramVarArgs.d(3, this.text);
      }
      paramVarArgs.y(4, this.size);
      if (this.FLp != null)
      {
        paramVarArgs.lJ(5, this.FLp.computeSize());
        this.FLp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HUt);
      if (this.FUn != null) {
        paramVarArgs.d(7, this.FUn);
      }
      if (this.HUu != null)
      {
        paramVarArgs.lJ(8, this.HUu.computeSize());
        this.HUu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.HUs) + 0;
      paramInt = i;
      if (this.ydG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ydG);
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.text);
      }
      i += f.a.a.b.b.a.amE(4);
      paramInt = i;
      if (this.FLp != null) {
        paramInt = i + f.a.a.a.lI(5, this.FLp.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HUt);
      paramInt = i;
      if (this.FUn != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FUn);
      }
      i = paramInt;
      if (this.HUu != null) {
        i = paramInt + f.a.a.a.lI(8, this.HUu.computeSize());
      }
      AppMethodBeat.o(91713);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dni localdni = (dni)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91713);
        return -1;
      case 1: 
        localdni.HUs = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91713);
        return 0;
      case 2: 
        localdni.ydG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 3: 
        localdni.text = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 4: 
        localdni.size = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
        AppMethodBeat.o(91713);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdni.FLp = ((cxk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91713);
        return 0;
      case 6: 
        localdni.HUt = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91713);
        return 0;
      case 7: 
        localdni.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91713);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new afu();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((afu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdni.HUu = ((afu)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    AppMethodBeat.o(91713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dni
 * JD-Core Version:    0.7.0.1
 */
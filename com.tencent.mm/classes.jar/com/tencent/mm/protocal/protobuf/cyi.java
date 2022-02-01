package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cyi
  extends com.tencent.mm.bw.a
{
  public b HIA;
  public b HIB;
  public b HIC;
  public cyj HID;
  public b HIz;
  public int kCY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200334);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.kCY);
      if (this.HIz != null) {
        paramVarArgs.c(2, this.HIz);
      }
      if (this.HIA != null) {
        paramVarArgs.c(3, this.HIA);
      }
      if (this.HIB != null) {
        paramVarArgs.c(4, this.HIB);
      }
      if (this.HIC != null) {
        paramVarArgs.c(5, this.HIC);
      }
      if (this.HID != null)
      {
        paramVarArgs.lJ(6, this.HID.computeSize());
        this.HID.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200334);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.kCY) + 0;
      paramInt = i;
      if (this.HIz != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HIz);
      }
      i = paramInt;
      if (this.HIA != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HIA);
      }
      paramInt = i;
      if (this.HIB != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HIB);
      }
      i = paramInt;
      if (this.HIC != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.HIC);
      }
      paramInt = i;
      if (this.HID != null) {
        paramInt = i + f.a.a.a.lI(6, this.HID.computeSize());
      }
      AppMethodBeat.o(200334);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(200334);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cyi localcyi = (cyi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(200334);
        return -1;
      case 1: 
        localcyi.kCY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(200334);
        return 0;
      case 2: 
        localcyi.HIz = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(200334);
        return 0;
      case 3: 
        localcyi.HIA = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(200334);
        return 0;
      case 4: 
        localcyi.HIB = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(200334);
        return 0;
      case 5: 
        localcyi.HIC = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(200334);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cyj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cyj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcyi.HID = ((cyj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(200334);
      return 0;
    }
    AppMethodBeat.o(200334);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyi
 * JD-Core Version:    0.7.0.1
 */
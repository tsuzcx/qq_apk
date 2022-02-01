package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mw
  extends com.tencent.mm.bx.a
{
  public String CGS;
  public int CID;
  public LinkedList<mv> CKt;
  public nc CKu;
  
  public mw()
  {
    AppMethodBeat.i(124435);
    this.CKt = new LinkedList();
    AppMethodBeat.o(124435);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124436);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CKt);
      paramVarArgs.aR(3, this.CID);
      if (this.CGS != null) {
        paramVarArgs.d(4, this.CGS);
      }
      if (this.CKu != null)
      {
        paramVarArgs.kX(5, this.CKu.computeSize());
        this.CKu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.CKt) + 0 + f.a.a.b.b.a.bA(3, this.CID);
      paramInt = i;
      if (this.CGS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CGS);
      }
      i = paramInt;
      if (this.CKu != null) {
        i = paramInt + f.a.a.a.kW(5, this.CKu.computeSize());
      }
      AppMethodBeat.o(124436);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CKt.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      mw localmw = (mw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(124436);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localmw.CKt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124436);
        return 0;
      case 3: 
        localmw.CID = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124436);
        return 0;
      case 4: 
        localmw.CGS = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(124436);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new nc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((nc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localmw.CKu = ((nc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    AppMethodBeat.o(124436);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mw
 * JD-Core Version:    0.7.0.1
 */
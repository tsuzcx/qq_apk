package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzs
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public cxn FNH;
  public String FNL;
  public String Ghk;
  public int HnF;
  public String hFS;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43104);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43104);
        throw paramVarArgs;
      }
      if (this.FNH != null)
      {
        paramVarArgs.lJ(1, this.FNH.computeSize());
        this.FNH.writeFields(paramVarArgs);
      }
      if (this.hFS != null) {
        paramVarArgs.d(2, this.hFS);
      }
      paramVarArgs.aS(3, this.nJA);
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(5, this.HnF);
      if (this.FNL != null) {
        paramVarArgs.d(6, this.FNL);
      }
      if (this.Ghk != null) {
        paramVarArgs.d(9, this.Ghk);
      }
      AppMethodBeat.o(43104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNH == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = f.a.a.a.lI(1, this.FNH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hFS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hFS);
      }
      i = i + f.a.a.b.b.a.bz(3, this.nJA) + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(5, this.HnF);
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNL);
      }
      i = paramInt;
      if (this.Ghk != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ghk);
      }
      AppMethodBeat.o(43104);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FNH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(43104);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzs localbzs = (bzs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(43104);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzs.FNH = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43104);
          return 0;
        case 2: 
          localbzs.hFS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43104);
          return 0;
        case 3: 
          localbzs.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43104);
          return 0;
        case 4: 
          localbzs.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43104);
          return 0;
        case 5: 
          localbzs.HnF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43104);
          return 0;
        case 6: 
          localbzs.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43104);
          return 0;
        }
        localbzs.Ghk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43104);
        return 0;
      }
      AppMethodBeat.o(43104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzs
 * JD-Core Version:    0.7.0.1
 */
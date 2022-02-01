package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bps
  extends com.tencent.mm.bx.a
{
  public String COT;
  public int CreateTime;
  public String CxC;
  public cmf Cxy;
  public int DOf;
  public String gKr;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43104);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43104);
        throw paramVarArgs;
      }
      if (this.Cxy != null)
      {
        paramVarArgs.kX(1, this.Cxy.computeSize());
        this.Cxy.writeFields(paramVarArgs);
      }
      if (this.gKr != null) {
        paramVarArgs.d(2, this.gKr);
      }
      paramVarArgs.aR(3, this.mBH);
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(5, this.DOf);
      if (this.CxC != null) {
        paramVarArgs.d(6, this.CxC);
      }
      if (this.COT != null) {
        paramVarArgs.d(9, this.COT);
      }
      AppMethodBeat.o(43104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cxy == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = f.a.a.a.kW(1, this.Cxy.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gKr);
      }
      i = i + f.a.a.b.b.a.bA(3, this.mBH) + f.a.a.b.b.a.bA(4, this.CreateTime) + f.a.a.b.b.a.bA(5, this.DOf);
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CxC);
      }
      i = paramInt;
      if (this.COT != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.COT);
      }
      AppMethodBeat.o(43104);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Cxy == null)
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
        bps localbps = (bps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(43104);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbps.Cxy = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43104);
          return 0;
        case 2: 
          localbps.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43104);
          return 0;
        case 3: 
          localbps.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43104);
          return 0;
        case 4: 
          localbps.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43104);
          return 0;
        case 5: 
          localbps.DOf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43104);
          return 0;
        case 6: 
          localbps.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43104);
          return 0;
        }
        localbps.COT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43104);
        return 0;
      }
      AppMethodBeat.o(43104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bps
 * JD-Core Version:    0.7.0.1
 */
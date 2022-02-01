package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fll
  extends com.tencent.mm.bx.a
{
  public etg YCV;
  public String YMe;
  public eod aaZw;
  public dbk abLR;
  public LinkedList<fmp> abLS;
  public LinkedList<fmp> abLT;
  public dbk abLU;
  public etf abLV;
  public eab abwz;
  
  public fll()
  {
    AppMethodBeat.i(91707);
    this.abLS = new LinkedList();
    this.abLT = new LinkedList();
    AppMethodBeat.o(91707);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91708);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abLR != null)
      {
        paramVarArgs.qD(1, this.abLR.computeSize());
        this.abLR.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.abLS);
      paramVarArgs.e(3, 8, this.abLT);
      if (this.abLU != null)
      {
        paramVarArgs.qD(4, this.abLU.computeSize());
        this.abLU.writeFields(paramVarArgs);
      }
      if (this.aaZw != null)
      {
        paramVarArgs.qD(5, this.aaZw.computeSize());
        this.aaZw.writeFields(paramVarArgs);
      }
      if (this.YMe != null) {
        paramVarArgs.g(6, this.YMe);
      }
      if (this.abwz != null)
      {
        paramVarArgs.qD(7, this.abwz.computeSize());
        this.abwz.writeFields(paramVarArgs);
      }
      if (this.YCV != null)
      {
        paramVarArgs.qD(8, this.YCV.computeSize());
        this.YCV.writeFields(paramVarArgs);
      }
      if (this.abLV != null)
      {
        paramVarArgs.qD(9, this.abLV.computeSize());
        this.abLV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abLR == null) {
        break label1246;
      }
    }
    label1246:
    for (paramInt = i.a.a.a.qC(1, this.abLR.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.abLS) + i.a.a.a.c(3, 8, this.abLT);
      paramInt = i;
      if (this.abLU != null) {
        paramInt = i + i.a.a.a.qC(4, this.abLU.computeSize());
      }
      i = paramInt;
      if (this.aaZw != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaZw.computeSize());
      }
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YMe);
      }
      i = paramInt;
      if (this.abwz != null) {
        i = paramInt + i.a.a.a.qC(7, this.abwz.computeSize());
      }
      paramInt = i;
      if (this.YCV != null) {
        paramInt = i + i.a.a.a.qC(8, this.YCV.computeSize());
      }
      i = paramInt;
      if (this.abLV != null) {
        i = paramInt + i.a.a.a.qC(9, this.abLV.computeSize());
      }
      AppMethodBeat.o(91708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abLS.clear();
        this.abLT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fll localfll = (fll)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91708);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbk)localObject2).parseFrom((byte[])localObject1);
            }
            localfll.abLR = ((dbk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localfll.abLS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localfll.abLT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbk)localObject2).parseFrom((byte[])localObject1);
            }
            localfll.abLU = ((dbk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eod();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eod)localObject2).parseFrom((byte[])localObject1);
            }
            localfll.aaZw = ((eod)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 6: 
          localfll.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91708);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eab();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eab)localObject2).parseFrom((byte[])localObject1);
            }
            localfll.abwz = ((eab)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 8: 
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
            localfll.YCV = ((etg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etf)localObject2).parseFrom((byte[])localObject1);
          }
          localfll.abLV = ((etf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      AppMethodBeat.o(91708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fll
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmr
  extends com.tencent.mm.bw.a
{
  public cxk FLp;
  public String FUn;
  public chy HHT;
  public bqg HTW;
  public LinkedList<dnl> HTX;
  public LinkedList<dnl> HTY;
  public bqg HTZ;
  public csz HUa;
  public cxj HUb;
  
  public dmr()
  {
    AppMethodBeat.i(91707);
    this.HTX = new LinkedList();
    this.HTY = new LinkedList();
    AppMethodBeat.o(91707);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HTW != null)
      {
        paramVarArgs.lJ(1, this.HTW.computeSize());
        this.HTW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.HTX);
      paramVarArgs.e(3, 8, this.HTY);
      if (this.HTZ != null)
      {
        paramVarArgs.lJ(4, this.HTZ.computeSize());
        this.HTZ.writeFields(paramVarArgs);
      }
      if (this.HUa != null)
      {
        paramVarArgs.lJ(5, this.HUa.computeSize());
        this.HUa.writeFields(paramVarArgs);
      }
      if (this.FUn != null) {
        paramVarArgs.d(6, this.FUn);
      }
      if (this.HHT != null)
      {
        paramVarArgs.lJ(7, this.HHT.computeSize());
        this.HHT.writeFields(paramVarArgs);
      }
      if (this.FLp != null)
      {
        paramVarArgs.lJ(8, this.FLp.computeSize());
        this.FLp.writeFields(paramVarArgs);
      }
      if (this.HUb != null)
      {
        paramVarArgs.lJ(9, this.HUb.computeSize());
        this.HUb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HTW == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = f.a.a.a.lI(1, this.HTW.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.HTX) + f.a.a.a.c(3, 8, this.HTY);
      paramInt = i;
      if (this.HTZ != null) {
        paramInt = i + f.a.a.a.lI(4, this.HTZ.computeSize());
      }
      i = paramInt;
      if (this.HUa != null) {
        i = paramInt + f.a.a.a.lI(5, this.HUa.computeSize());
      }
      paramInt = i;
      if (this.FUn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FUn);
      }
      i = paramInt;
      if (this.HHT != null) {
        i = paramInt + f.a.a.a.lI(7, this.HHT.computeSize());
      }
      paramInt = i;
      if (this.FLp != null) {
        paramInt = i + f.a.a.a.lI(8, this.FLp.computeSize());
      }
      i = paramInt;
      if (this.HUb != null) {
        i = paramInt + f.a.a.a.lI(9, this.HUb.computeSize());
      }
      AppMethodBeat.o(91708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HTX.clear();
        this.HTY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmr localdmr = (dmr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91708);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmr.HTW = ((bqg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmr.HTX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmr.HTY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmr.HTZ = ((bqg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmr.HUa = ((csz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 6: 
          localdmr.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91708);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmr.HHT = ((chy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmr.FLp = ((cxk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdmr.HUb = ((cxj)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmr
 * JD-Core Version:    0.7.0.1
 */
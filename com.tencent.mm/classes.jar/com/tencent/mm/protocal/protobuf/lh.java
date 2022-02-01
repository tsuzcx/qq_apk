package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lh
  extends com.tencent.mm.bx.a
{
  public pw CGH;
  public pw CGI;
  public pw CGJ;
  public SKBuiltinBuffer_t CGK;
  public SKBuiltinBuffer_t CGL;
  public pw CGM;
  public int CGN;
  public pv CGO;
  public pv CGP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104359);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CGH != null)
      {
        paramVarArgs.kX(1, this.CGH.computeSize());
        this.CGH.writeFields(paramVarArgs);
      }
      if (this.CGI != null)
      {
        paramVarArgs.kX(2, this.CGI.computeSize());
        this.CGI.writeFields(paramVarArgs);
      }
      if (this.CGJ != null)
      {
        paramVarArgs.kX(4, this.CGJ.computeSize());
        this.CGJ.writeFields(paramVarArgs);
      }
      if (this.CGK != null)
      {
        paramVarArgs.kX(5, this.CGK.computeSize());
        this.CGK.writeFields(paramVarArgs);
      }
      if (this.CGL != null)
      {
        paramVarArgs.kX(6, this.CGL.computeSize());
        this.CGL.writeFields(paramVarArgs);
      }
      if (this.CGM != null)
      {
        paramVarArgs.kX(7, this.CGM.computeSize());
        this.CGM.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.CGN);
      if (this.CGO != null)
      {
        paramVarArgs.kX(9, this.CGO.computeSize());
        this.CGO.writeFields(paramVarArgs);
      }
      if (this.CGP != null)
      {
        paramVarArgs.kX(10, this.CGP.computeSize());
        this.CGP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104359);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CGH == null) {
        break label1446;
      }
    }
    label1446:
    for (int i = f.a.a.a.kW(1, this.CGH.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CGI != null) {
        paramInt = i + f.a.a.a.kW(2, this.CGI.computeSize());
      }
      i = paramInt;
      if (this.CGJ != null) {
        i = paramInt + f.a.a.a.kW(4, this.CGJ.computeSize());
      }
      paramInt = i;
      if (this.CGK != null) {
        paramInt = i + f.a.a.a.kW(5, this.CGK.computeSize());
      }
      i = paramInt;
      if (this.CGL != null) {
        i = paramInt + f.a.a.a.kW(6, this.CGL.computeSize());
      }
      paramInt = i;
      if (this.CGM != null) {
        paramInt = i + f.a.a.a.kW(7, this.CGM.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.CGN);
      paramInt = i;
      if (this.CGO != null) {
        paramInt = i + f.a.a.a.kW(9, this.CGO.computeSize());
      }
      i = paramInt;
      if (this.CGP != null) {
        i = paramInt + f.a.a.a.kW(10, this.CGP.computeSize());
      }
      AppMethodBeat.o(104359);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104359);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lh locallh = (lh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(104359);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.CGH = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.CGI = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.CGJ = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.CGK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.CGL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.CGM = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 8: 
          locallh.CGN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104359);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallh.CGO = ((pv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallh.CGP = ((pv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104359);
        return 0;
      }
      AppMethodBeat.o(104359);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lh
 * JD-Core Version:    0.7.0.1
 */
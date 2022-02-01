package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auy
  extends cvw
{
  public LinkedList<String> GLQ;
  public LinkedList<String> GLW;
  public int GLX;
  public String jge;
  public String usS;
  
  public auy()
  {
    AppMethodBeat.i(42638);
    this.GLW = new LinkedList();
    this.GLQ = new LinkedList();
    AppMethodBeat.o(42638);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.GLW);
      paramVarArgs.e(3, 1, this.GLQ);
      if (this.usS != null) {
        paramVarArgs.d(4, this.usS);
      }
      if (this.jge != null) {
        paramVarArgs.d(5, this.jge);
      }
      paramVarArgs.aS(6, this.GLX);
      AppMethodBeat.o(42639);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.GLW) + f.a.a.a.c(3, 1, this.GLQ);
      paramInt = i;
      if (this.usS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.usS);
      }
      i = paramInt;
      if (this.jge != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jge);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.GLX);
      AppMethodBeat.o(42639);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLW.clear();
        this.GLQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(42639);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auy localauy = (auy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42639);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42639);
          return 0;
        case 2: 
          localauy.GLW.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 3: 
          localauy.GLQ.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 4: 
          localauy.usS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42639);
          return 0;
        case 5: 
          localauy.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42639);
          return 0;
        }
        localauy.GLX = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(42639);
        return 0;
      }
      AppMethodBeat.o(42639);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auy
 * JD-Core Version:    0.7.0.1
 */
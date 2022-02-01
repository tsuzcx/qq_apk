package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmm
  extends com.tencent.mm.bx.a
{
  public dwb FPc;
  public String text;
  public int textColor;
  public int xNG;
  public String xNN;
  public int xPn;
  public afx xPq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140931);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.text == null)
      {
        paramVarArgs = new b("Not all required fields were included: text");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.FPc == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.text != null) {
        paramVarArgs.d(1, this.text);
      }
      paramVarArgs.aS(2, this.textColor);
      paramVarArgs.aS(3, this.xPn);
      if (this.FPc != null)
      {
        paramVarArgs.lC(4, this.FPc.computeSize());
        this.FPc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.xNG);
      if (this.xPq != null)
      {
        paramVarArgs.lC(6, this.xPq.computeSize());
        this.xPq.writeFields(paramVarArgs);
      }
      if (this.xNN != null) {
        paramVarArgs.d(7, this.xNN);
      }
      AppMethodBeat.o(140931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = f.a.a.b.b.a.e(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.textColor) + f.a.a.b.b.a.bz(3, this.xPn);
      paramInt = i;
      if (this.FPc != null) {
        paramInt = i + f.a.a.a.lB(4, this.FPc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.xNG);
      paramInt = i;
      if (this.xPq != null) {
        paramInt = i + f.a.a.a.lB(6, this.xPq.computeSize());
      }
      i = paramInt;
      if (this.xNN != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.xNN);
      }
      AppMethodBeat.o(140931);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.text == null)
        {
          paramVarArgs = new b("Not all required fields were included: text");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        if (this.FPc == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140931);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmm localdmm = (dmm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140931);
          return -1;
        case 1: 
          localdmm.text = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(140931);
          return 0;
        case 2: 
          localdmm.textColor = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(140931);
          return 0;
        case 3: 
          localdmm.xPn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(140931);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmm.FPc = ((dwb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        case 5: 
          localdmm.xNG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(140931);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmm.xPq = ((afx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        }
        localdmm.xNN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(140931);
        return 0;
      }
      AppMethodBeat.o(140931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmm
 * JD-Core Version:    0.7.0.1
 */
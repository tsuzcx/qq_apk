package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzl
  extends com.tencent.mm.bw.a
{
  public String Hnl;
  public String Hnm;
  public String Hnn;
  public int Hno;
  public String Hnp;
  public ti Hnq;
  public String Hnr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hnl != null) {
        paramVarArgs.d(1, this.Hnl);
      }
      if (this.Hnm != null) {
        paramVarArgs.d(2, this.Hnm);
      }
      if (this.Hnn != null) {
        paramVarArgs.d(3, this.Hnn);
      }
      paramVarArgs.aS(4, this.Hno);
      if (this.Hnp != null) {
        paramVarArgs.d(5, this.Hnp);
      }
      if (this.Hnq != null)
      {
        paramVarArgs.lJ(6, this.Hnq.computeSize());
        this.Hnq.writeFields(paramVarArgs);
      }
      if (this.Hnr != null) {
        paramVarArgs.d(7, this.Hnr);
      }
      AppMethodBeat.o(218618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hnl == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.Hnl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hnm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hnm);
      }
      i = paramInt;
      if (this.Hnn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hnn);
      }
      i += f.a.a.b.b.a.bz(4, this.Hno);
      paramInt = i;
      if (this.Hnp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hnp);
      }
      i = paramInt;
      if (this.Hnq != null) {
        i = paramInt + f.a.a.a.lI(6, this.Hnq.computeSize());
      }
      paramInt = i;
      if (this.Hnr != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hnr);
      }
      AppMethodBeat.o(218618);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzl localbzl = (bzl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218618);
          return -1;
        case 1: 
          localbzl.Hnl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218618);
          return 0;
        case 2: 
          localbzl.Hnm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218618);
          return 0;
        case 3: 
          localbzl.Hnn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218618);
          return 0;
        case 4: 
          localbzl.Hno = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218618);
          return 0;
        case 5: 
          localbzl.Hnp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218618);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzl.Hnq = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218618);
          return 0;
        }
        localbzl.Hnr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(218618);
        return 0;
      }
      AppMethodBeat.o(218618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzl
 * JD-Core Version:    0.7.0.1
 */
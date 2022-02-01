package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cdl
  extends com.tencent.mm.bw.a
{
  public String FSh;
  public int GjP;
  public SKBuiltinBuffer_t GjQ;
  public zy Hqt;
  public int Hqu;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133186);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hqt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.GjQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.Hqt != null)
      {
        paramVarArgs.lJ(1, this.Hqt.computeSize());
        this.Hqt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GjP);
      if (this.GjQ != null)
      {
        paramVarArgs.lJ(3, this.GjQ.computeSize());
        this.GjQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.Scene);
      if (this.FSh != null) {
        paramVarArgs.d(5, this.FSh);
      }
      paramVarArgs.aS(6, this.Hqu);
      AppMethodBeat.o(133186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hqt == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lI(1, this.Hqt.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GjP);
      paramInt = i;
      if (this.GjQ != null) {
        paramInt = i + f.a.a.a.lI(3, this.GjQ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.FSh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FSh);
      }
      i = f.a.a.b.b.a.bz(6, this.Hqu);
      AppMethodBeat.o(133186);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Hqt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        if (this.GjQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133186);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdl localcdl = (cdl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133186);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdl.Hqt = ((zy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 2: 
          localcdl.GjP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133186);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdl.GjQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 4: 
          localcdl.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133186);
          return 0;
        case 5: 
          localcdl.FSh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133186);
          return 0;
        }
        localcdl.Hqu = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133186);
        return 0;
      }
      AppMethodBeat.o(133186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdl
 * JD-Core Version:    0.7.0.1
 */
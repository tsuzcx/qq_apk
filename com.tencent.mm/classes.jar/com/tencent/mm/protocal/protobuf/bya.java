package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bya
  extends com.tencent.mm.bw.a
{
  public String DUp;
  public int Ekh;
  public SKBuiltinBuffer_t Eki;
  public xw Fnk;
  public int Fnl;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133186);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fnk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.Eki == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.Fnk != null)
      {
        paramVarArgs.ln(1, this.Fnk.computeSize());
        this.Fnk.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Ekh);
      if (this.Eki != null)
      {
        paramVarArgs.ln(3, this.Eki.computeSize());
        this.Eki.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Scene);
      if (this.DUp != null) {
        paramVarArgs.d(5, this.DUp);
      }
      paramVarArgs.aR(6, this.Fnl);
      AppMethodBeat.o(133186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fnk == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lm(1, this.Fnk.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Ekh);
      paramInt = i;
      if (this.Eki != null) {
        paramInt = i + f.a.a.a.lm(3, this.Eki.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Scene);
      paramInt = i;
      if (this.DUp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DUp);
      }
      i = f.a.a.b.b.a.bx(6, this.Fnl);
      AppMethodBeat.o(133186);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Fnk == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        if (this.Eki == null)
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
        bya localbya = (bya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133186);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbya.Fnk = ((xw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 2: 
          localbya.Ekh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133186);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbya.Eki = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 4: 
          localbya.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133186);
          return 0;
        case 5: 
          localbya.DUp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133186);
          return 0;
        }
        localbya.Fnl = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133186);
        return 0;
      }
      AppMethodBeat.o(133186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bya
 * JD-Core Version:    0.7.0.1
 */
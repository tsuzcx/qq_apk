package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class duz
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t DPX;
  public String DYT;
  public SKBuiltinBuffer_t DYX;
  public String GcE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133207);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DYX == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.GcE != null) {
        paramVarArgs.d(1, this.GcE);
      }
      if (this.DYX != null)
      {
        paramVarArgs.ln(2, this.DYX.computeSize());
        this.DYX.writeFields(paramVarArgs);
      }
      if (this.DYT != null) {
        paramVarArgs.d(3, this.DYT);
      }
      if (this.DPX != null)
      {
        paramVarArgs.ln(4, this.DPX.computeSize());
        this.DPX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GcE == null) {
        break label682;
      }
    }
    label682:
    for (int i = f.a.a.b.b.a.e(1, this.GcE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DYX != null) {
        paramInt = i + f.a.a.a.lm(2, this.DYX.computeSize());
      }
      i = paramInt;
      if (this.DYT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DYT);
      }
      paramInt = i;
      if (this.DPX != null) {
        paramInt = i + f.a.a.a.lm(4, this.DPX.computeSize());
      }
      AppMethodBeat.o(133207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DYX == null)
        {
          paramVarArgs = new b("Not all required fields were included: KSid");
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        if (this.DPX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        duz localduz = (duz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133207);
          return -1;
        case 1: 
          localduz.GcE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133207);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduz.DYX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133207);
          return 0;
        case 3: 
          localduz.DYT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133207);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localduz.DPX = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133207);
        return 0;
      }
      AppMethodBeat.o(133207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duz
 * JD-Core Version:    0.7.0.1
 */
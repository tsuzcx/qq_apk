package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bga
  extends cvw
{
  public String GLP;
  public SKBuiltinBuffer_t GTa;
  public int GTc;
  public double GUH;
  public double GUI;
  public double Gax;
  public double Gay;
  public int OpCode;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56249);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GTa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56249);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Scene);
      paramVarArgs.aS(3, this.OpCode);
      if (this.GLP != null) {
        paramVarArgs.d(4, this.GLP);
      }
      if (this.GTa != null)
      {
        paramVarArgs.lJ(5, this.GTa.computeSize());
        this.GTa.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, this.Gax);
      paramVarArgs.e(7, this.Gay);
      paramVarArgs.e(8, this.GUH);
      paramVarArgs.e(9, this.GUI);
      paramVarArgs.aS(10, this.GTc);
      AppMethodBeat.o(56249);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Scene) + f.a.a.b.b.a.bz(3, this.OpCode);
      paramInt = i;
      if (this.GLP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GLP);
      }
      i = paramInt;
      if (this.GTa != null) {
        i = paramInt + f.a.a.a.lI(5, this.GTa.computeSize());
      }
      paramInt = f.a.a.b.b.a.amD(6);
      int j = f.a.a.b.b.a.amD(7);
      int k = f.a.a.b.b.a.amD(8);
      int m = f.a.a.b.b.a.amD(9);
      int n = f.a.a.b.b.a.bz(10, this.GTc);
      AppMethodBeat.o(56249);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GTa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56249);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56249);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bga localbga = (bga)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56249);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbga.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 2: 
          localbga.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56249);
          return 0;
        case 3: 
          localbga.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56249);
          return 0;
        case 4: 
          localbga.GLP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(56249);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbga.GTa = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 6: 
          localbga.Gax = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(56249);
          return 0;
        case 7: 
          localbga.Gay = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(56249);
          return 0;
        case 8: 
          localbga.GUH = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(56249);
          return 0;
        case 9: 
          localbga.GUI = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(56249);
          return 0;
        }
        localbga.GTc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(56249);
        return 0;
      }
      AppMethodBeat.o(56249);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bga
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dpi
  extends com.tencent.mm.bx.a
{
  public String CGt;
  public SKBuiltinBuffer_t CGx;
  public SKBuiltinBuffer_t CxB;
  public String EFs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133207);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CGx == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.EFs != null) {
        paramVarArgs.d(1, this.EFs);
      }
      if (this.CGx != null)
      {
        paramVarArgs.kX(2, this.CGx.computeSize());
        this.CGx.writeFields(paramVarArgs);
      }
      if (this.CGt != null) {
        paramVarArgs.d(3, this.CGt);
      }
      if (this.CxB != null)
      {
        paramVarArgs.kX(4, this.CxB.computeSize());
        this.CxB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFs == null) {
        break label682;
      }
    }
    label682:
    for (int i = f.a.a.b.b.a.e(1, this.EFs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CGx != null) {
        paramInt = i + f.a.a.a.kW(2, this.CGx.computeSize());
      }
      i = paramInt;
      if (this.CGt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CGt);
      }
      paramInt = i;
      if (this.CxB != null) {
        paramInt = i + f.a.a.a.kW(4, this.CxB.computeSize());
      }
      AppMethodBeat.o(133207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CGx == null)
        {
          paramVarArgs = new b("Not all required fields were included: KSid");
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        if (this.CxB == null)
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
        dpi localdpi = (dpi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133207);
          return -1;
        case 1: 
          localdpi.EFs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133207);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpi.CGx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133207);
          return 0;
        case 3: 
          localdpi.CGt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133207);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpi.CxB = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpi
 * JD-Core Version:    0.7.0.1
 */
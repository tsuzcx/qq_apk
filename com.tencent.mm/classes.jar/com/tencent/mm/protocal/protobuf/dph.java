package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dph
  extends com.tencent.mm.bx.a
{
  public String CGt;
  public String CGu;
  public SKBuiltinBuffer_t CGx;
  public String EFs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CGx == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133206);
        throw paramVarArgs;
      }
      if (this.CGt != null) {
        paramVarArgs.d(1, this.CGt);
      }
      if (this.CGu != null) {
        paramVarArgs.d(2, this.CGu);
      }
      if (this.EFs != null) {
        paramVarArgs.d(3, this.EFs);
      }
      if (this.CGx != null)
      {
        paramVarArgs.kX(4, this.CGx.computeSize());
        this.CGx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CGt == null) {
        break label538;
      }
    }
    label538:
    for (int i = f.a.a.b.b.a.e(1, this.CGt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CGu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CGu);
      }
      i = paramInt;
      if (this.EFs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EFs);
      }
      paramInt = i;
      if (this.CGx != null) {
        paramInt = i + f.a.a.a.kW(4, this.CGx.computeSize());
      }
      AppMethodBeat.o(133206);
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
          AppMethodBeat.o(133206);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133206);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dph localdph = (dph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133206);
          return -1;
        case 1: 
          localdph.CGt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 2: 
          localdph.CGu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 3: 
          localdph.EFs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133206);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdph.CGx = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133206);
        return 0;
      }
      AppMethodBeat.o(133206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dph
 * JD-Core Version:    0.7.0.1
 */
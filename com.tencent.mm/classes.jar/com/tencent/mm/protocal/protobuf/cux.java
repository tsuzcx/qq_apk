package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cux
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public SKBuiltinBuffer_t Emd;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125786);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Emd == null)
      {
        paramVarArgs = new b("Not all required fields were included: HBBuffer");
        AppMethodBeat.o(125786);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      paramVarArgs.aR(2, this.CreateTime);
      if (this.Emd != null)
      {
        paramVarArgs.kX(3, this.Emd.computeSize());
        this.Emd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125786);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CreateTime);
      paramInt = i;
      if (this.Emd != null) {
        paramInt = i + f.a.a.a.kW(3, this.Emd.computeSize());
      }
      AppMethodBeat.o(125786);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Emd == null)
        {
          paramVarArgs = new b("Not all required fields were included: HBBuffer");
          AppMethodBeat.o(125786);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125786);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cux localcux = (cux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125786);
          return -1;
        case 1: 
          localcux.Username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125786);
          return 0;
        case 2: 
          localcux.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125786);
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
          localcux.Emd = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125786);
        return 0;
      }
      AppMethodBeat.o(125786);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cux
 * JD-Core Version:    0.7.0.1
 */
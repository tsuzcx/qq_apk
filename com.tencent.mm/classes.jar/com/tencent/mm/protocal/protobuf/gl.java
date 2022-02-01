package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gl
  extends com.tencent.mm.bx.a
{
  public String CAX;
  public dio CAY;
  public String CAZ;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147757);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.CAX != null) {
        paramVarArgs.d(2, this.CAX);
      }
      paramVarArgs.aR(3, this.state);
      if (this.CAY != null)
      {
        paramVarArgs.kX(4, this.CAY.computeSize());
        this.CAY.writeFields(paramVarArgs);
      }
      if (this.CAZ != null) {
        paramVarArgs.d(5, this.CAZ);
      }
      AppMethodBeat.o(147757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CAX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CAX);
      }
      i += f.a.a.b.b.a.bA(3, this.state);
      paramInt = i;
      if (this.CAY != null) {
        paramInt = i + f.a.a.a.kW(4, this.CAY.computeSize());
      }
      i = paramInt;
      if (this.CAZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CAZ);
      }
      AppMethodBeat.o(147757);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gl localgl = (gl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147757);
          return -1;
        case 1: 
          localgl.scope = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 2: 
          localgl.CAX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 3: 
          localgl.state = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(147757);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgl.CAY = ((dio)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147757);
          return 0;
        }
        localgl.CAZ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(147757);
        return 0;
      }
      AppMethodBeat.o(147757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gl
 * JD-Core Version:    0.7.0.1
 */
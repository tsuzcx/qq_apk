package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class box
  extends ckq
{
  public int DMf;
  public int DMg;
  public String dyc;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114044);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dyc != null) {
        paramVarArgs.d(2, this.dyc);
      }
      paramVarArgs.aR(3, this.DMf);
      paramVarArgs.aR(4, this.DMg);
      paramVarArgs.aR(5, this.scene);
      AppMethodBeat.o(114044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dyc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dyc);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DMf);
      int j = f.a.a.b.b.a.bA(4, this.DMg);
      int k = f.a.a.b.b.a.bA(5, this.scene);
      AppMethodBeat.o(114044);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114044);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        box localbox = (box)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114044);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbox.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114044);
          return 0;
        case 2: 
          localbox.dyc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114044);
          return 0;
        case 3: 
          localbox.DMf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114044);
          return 0;
        case 4: 
          localbox.DMg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114044);
          return 0;
        }
        localbox.scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(114044);
        return 0;
      }
      AppMethodBeat.o(114044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.box
 * JD-Core Version:    0.7.0.1
 */
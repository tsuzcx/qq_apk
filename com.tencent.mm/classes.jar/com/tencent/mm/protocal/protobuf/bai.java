package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bai
  extends ckq
{
  public String code;
  public String dyc;
  public String nrr;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114034);
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
      paramVarArgs.aR(3, this.scene);
      if (this.nrr != null) {
        paramVarArgs.d(4, this.nrr);
      }
      if (this.code != null) {
        paramVarArgs.d(5, this.code);
      }
      AppMethodBeat.o(114034);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dyc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dyc);
      }
      i += f.a.a.b.b.a.bA(3, this.scene);
      paramInt = i;
      if (this.nrr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nrr);
      }
      i = paramInt;
      if (this.code != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.code);
      }
      AppMethodBeat.o(114034);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114034);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bai localbai = (bai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114034);
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
            localbai.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114034);
          return 0;
        case 2: 
          localbai.dyc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114034);
          return 0;
        case 3: 
          localbai.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114034);
          return 0;
        case 4: 
          localbai.nrr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114034);
          return 0;
        }
        localbai.code = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(114034);
        return 0;
      }
      AppMethodBeat.o(114034);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bai
 * JD-Core Version:    0.7.0.1
 */
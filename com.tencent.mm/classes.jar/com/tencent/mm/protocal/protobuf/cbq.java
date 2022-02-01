package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbq
  extends ckq
{
  public int DAL;
  public boolean DXU;
  public int Dtj;
  public String dlB;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123636);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      paramVarArgs.aR(4, this.DAL);
      if (this.path != null) {
        paramVarArgs.d(5, this.path);
      }
      paramVarArgs.aR(6, this.Dtj);
      paramVarArgs.bg(7, this.DXU);
      AppMethodBeat.o(123636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlB);
      }
      i += f.a.a.b.b.a.bA(4, this.DAL);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.path);
      }
      i = f.a.a.b.b.a.bA(6, this.Dtj);
      int j = f.a.a.b.b.a.fY(7);
      AppMethodBeat.o(123636);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbq localcbq = (cbq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123636);
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
            localcbq.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123636);
          return 0;
        case 2: 
          localcbq.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 3: 
          localcbq.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 4: 
          localcbq.DAL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123636);
          return 0;
        case 5: 
          localcbq.path = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 6: 
          localcbq.Dtj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123636);
          return 0;
        }
        localcbq.DXU = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(123636);
        return 0;
      }
      AppMethodBeat.o(123636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpz
  extends ckq
{
  public bld Dbk;
  public int Ejk;
  public int Scene;
  public String gKr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152692);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dbk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(152692);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Dbk != null)
      {
        paramVarArgs.kX(2, this.Dbk.computeSize());
        this.Dbk.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Ejk);
      paramVarArgs.aR(4, this.Scene);
      if (this.gKr != null) {
        paramVarArgs.d(5, this.gKr);
      }
      AppMethodBeat.o(152692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dbk != null) {
        i = paramInt + f.a.a.a.kW(2, this.Dbk.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(3, this.Ejk) + f.a.a.b.b.a.bA(4, this.Scene);
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gKr);
      }
      AppMethodBeat.o(152692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dbk == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(152692);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152692);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpz localcpz = (cpz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152692);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152692);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpz.Dbk = ((bld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152692);
          return 0;
        case 3: 
          localcpz.Ejk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152692);
          return 0;
        case 4: 
          localcpz.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152692);
          return 0;
        }
        localcpz.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152692);
        return 0;
      }
      AppMethodBeat.o(152692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amd
  extends ckq
{
  public String CFN;
  public String Ddo;
  public String Dnj;
  public String Dnk;
  public String Dnl;
  public String upE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Dnj != null) {
        paramVarArgs.d(2, this.Dnj);
      }
      if (this.CFN != null) {
        paramVarArgs.d(3, this.CFN);
      }
      if (this.upE != null) {
        paramVarArgs.d(4, this.upE);
      }
      if (this.Dnk != null) {
        paramVarArgs.d(5, this.Dnk);
      }
      if (this.Dnl != null) {
        paramVarArgs.d(6, this.Dnl);
      }
      if (this.Ddo != null) {
        paramVarArgs.d(7, this.Ddo);
      }
      AppMethodBeat.o(91466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dnj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dnj);
      }
      i = paramInt;
      if (this.CFN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CFN);
      }
      paramInt = i;
      if (this.upE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.upE);
      }
      i = paramInt;
      if (this.Dnk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dnk);
      }
      paramInt = i;
      if (this.Dnl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dnl);
      }
      i = paramInt;
      if (this.Ddo != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Ddo);
      }
      AppMethodBeat.o(91466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amd localamd = (amd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91466);
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
            localamd.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91466);
          return 0;
        case 2: 
          localamd.Dnj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 3: 
          localamd.CFN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 4: 
          localamd.upE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 5: 
          localamd.Dnk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 6: 
          localamd.Dnl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91466);
          return 0;
        }
        localamd.Ddo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91466);
        return 0;
      }
      AppMethodBeat.o(91466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amd
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdu
  extends ckq
{
  public String DRh;
  public int DRi;
  public LinkedList<String> DRj;
  public int Dbx;
  
  public cdu()
  {
    AppMethodBeat.i(82464);
    this.DRj = new LinkedList();
    AppMethodBeat.o(82464);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82465);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DRh != null) {
        paramVarArgs.d(2, this.DRh);
      }
      paramVarArgs.aR(3, this.DRi);
      paramVarArgs.e(4, 1, this.DRj);
      paramVarArgs.aR(5, this.Dbx);
      AppMethodBeat.o(82465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DRh != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DRh);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DRi);
      int j = f.a.a.a.c(4, 1, this.DRj);
      int k = f.a.a.b.b.a.bA(5, this.Dbx);
      AppMethodBeat.o(82465);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DRj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82465);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdu localcdu = (cdu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82465);
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
            localcdu.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82465);
          return 0;
        case 2: 
          localcdu.DRh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82465);
          return 0;
        case 3: 
          localcdu.DRi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82465);
          return 0;
        case 4: 
          localcdu.DRj.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(82465);
          return 0;
        }
        localcdu.Dbx = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(82465);
        return 0;
      }
      AppMethodBeat.o(82465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdu
 * JD-Core Version:    0.7.0.1
 */
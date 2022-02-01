package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class atl
  extends cld
{
  public int Dtu;
  public String Dtv;
  public int Dtw;
  public int mAK;
  public LinkedList<ade> mAL;
  
  public atl()
  {
    AppMethodBeat.i(104792);
    this.mAL = new LinkedList();
    AppMethodBeat.o(104792);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104793);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104793);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mAK);
      paramVarArgs.e(3, 8, this.mAL);
      paramVarArgs.aR(4, this.Dtu);
      if (this.Dtv != null) {
        paramVarArgs.d(5, this.Dtv);
      }
      paramVarArgs.aR(6, this.Dtw);
      AppMethodBeat.o(104793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mAK) + f.a.a.a.c(3, 8, this.mAL) + f.a.a.b.b.a.bA(4, this.Dtu);
      paramInt = i;
      if (this.Dtv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Dtv);
      }
      i = f.a.a.b.b.a.bA(6, this.Dtw);
      AppMethodBeat.o(104793);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mAL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104793);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104793);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atl localatl = (atl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104793);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 2: 
          localatl.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104793);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ade();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ade)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatl.mAL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 4: 
          localatl.Dtu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104793);
          return 0;
        case 5: 
          localatl.Dtv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104793);
          return 0;
        }
        localatl.Dtw = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104793);
        return 0;
      }
      AppMethodBeat.o(104793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atl
 * JD-Core Version:    0.7.0.1
 */
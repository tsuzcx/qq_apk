package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cwf
  extends cld
{
  public int DNL;
  public LinkedList<cul> DNM;
  public cul Eoa;
  public long Id;
  public String gKn;
  public int mBH;
  public int uKQ;
  public int uKR;
  
  public cwf()
  {
    AppMethodBeat.i(125831);
    this.DNM = new LinkedList();
    AppMethodBeat.o(125831);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125832);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.Eoa == null)
      {
        paramVarArgs = new b("Not all required fields were included: BufferUrl");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.uKR);
      paramVarArgs.aR(3, this.uKQ);
      if (this.gKn != null) {
        paramVarArgs.d(4, this.gKn);
      }
      if (this.Eoa != null)
      {
        paramVarArgs.kX(5, this.Eoa.computeSize());
        this.Eoa.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.DNL);
      paramVarArgs.e(7, 8, this.DNM);
      paramVarArgs.aG(8, this.Id);
      paramVarArgs.aR(9, this.mBH);
      AppMethodBeat.o(125832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.uKR) + f.a.a.b.b.a.bA(3, this.uKQ);
      paramInt = i;
      if (this.gKn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gKn);
      }
      i = paramInt;
      if (this.Eoa != null) {
        i = paramInt + f.a.a.a.kW(5, this.Eoa.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(6, this.DNL);
      int j = f.a.a.a.c(7, 8, this.DNM);
      int k = f.a.a.b.b.a.q(8, this.Id);
      int m = f.a.a.b.b.a.bA(9, this.mBH);
      AppMethodBeat.o(125832);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DNM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        if (this.Eoa == null)
        {
          paramVarArgs = new b("Not all required fields were included: BufferUrl");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwf localcwf = (cwf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125832);
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
            localcwf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 2: 
          localcwf.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125832);
          return 0;
        case 3: 
          localcwf.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125832);
          return 0;
        case 4: 
          localcwf.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125832);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cul();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cul)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwf.Eoa = ((cul)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 6: 
          localcwf.DNL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125832);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cul();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cul)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwf.DNM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 8: 
          localcwf.Id = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125832);
          return 0;
        }
        localcwf.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125832);
        return 0;
      }
      AppMethodBeat.o(125832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwf
 * JD-Core Version:    0.7.0.1
 */
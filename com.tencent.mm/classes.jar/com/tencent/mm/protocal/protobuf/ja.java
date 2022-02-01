package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ja
  extends ckq
{
  public int CEA;
  public LinkedList<String> CEw;
  public LinkedList<cko> CEx;
  public long CEy;
  public int CEz;
  public String nlG;
  
  public ja()
  {
    AppMethodBeat.i(6394);
    this.CEw = new LinkedList();
    this.CEx = new LinkedList();
    AppMethodBeat.o(6394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.CEw);
      paramVarArgs.e(3, 8, this.CEx);
      if (this.nlG != null) {
        paramVarArgs.d(4, this.nlG);
      }
      paramVarArgs.aG(5, this.CEy);
      paramVarArgs.aR(6, this.CEz);
      paramVarArgs.aR(7, this.CEA);
      AppMethodBeat.o(6395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label719;
      }
    }
    label719:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.CEw) + f.a.a.a.c(3, 8, this.CEx);
      paramInt = i;
      if (this.nlG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nlG);
      }
      i = f.a.a.b.b.a.q(5, this.CEy);
      int j = f.a.a.b.b.a.bA(6, this.CEz);
      int k = f.a.a.b.b.a.bA(7, this.CEA);
      AppMethodBeat.o(6395);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CEw.clear();
        this.CEx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(6395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ja localja = (ja)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6395);
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
            localja.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 2: 
          localja.CEw.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(6395);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cko();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cko)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localja.CEx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 4: 
          localja.nlG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6395);
          return 0;
        case 5: 
          localja.CEy = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(6395);
          return 0;
        case 6: 
          localja.CEz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6395);
          return 0;
        }
        localja.CEA = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(6395);
        return 0;
      }
      AppMethodBeat.o(6395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ja
 * JD-Core Version:    0.7.0.1
 */
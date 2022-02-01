package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bjf
  extends cwj
{
  public LinkedList<bom> GWK;
  public String GWL;
  public int GWM;
  public LinkedList<String> GWN;
  public int GWO;
  public long GWP;
  public int dmy;
  public String phe;
  public String vzQ;
  
  public bjf()
  {
    AppMethodBeat.i(91512);
    this.dmy = 0;
    this.phe = "ok";
    this.GWK = new LinkedList();
    this.GWN = new LinkedList();
    AppMethodBeat.o(91512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91513);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      paramVarArgs.e(4, 8, this.GWK);
      if (this.GWL != null) {
        paramVarArgs.d(5, this.GWL);
      }
      paramVarArgs.aS(6, this.GWM);
      if (this.vzQ != null) {
        paramVarArgs.d(7, this.vzQ);
      }
      paramVarArgs.e(8, 1, this.GWN);
      paramVarArgs.aS(9, this.GWO);
      paramVarArgs.aZ(10, this.GWP);
      AppMethodBeat.o(91513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.GWK);
      paramInt = i;
      if (this.GWL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GWL);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GWM);
      paramInt = i;
      if (this.vzQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vzQ);
      }
      i = f.a.a.a.c(8, 1, this.GWN);
      int j = f.a.a.b.b.a.bz(9, this.GWO);
      int k = f.a.a.b.b.a.p(10, this.GWP);
      AppMethodBeat.o(91513);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GWK.clear();
        this.GWN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91513);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjf localbjf = (bjf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91513);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 2: 
          localbjf.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91513);
          return 0;
        case 3: 
          localbjf.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bom();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bom)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjf.GWK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 5: 
          localbjf.GWL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 6: 
          localbjf.GWM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91513);
          return 0;
        case 7: 
          localbjf.vzQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 8: 
          localbjf.GWN.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(91513);
          return 0;
        case 9: 
          localbjf.GWO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91513);
          return 0;
        }
        localbjf.GWP = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91513);
        return 0;
      }
      AppMethodBeat.o(91513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjf
 * JD-Core Version:    0.7.0.1
 */
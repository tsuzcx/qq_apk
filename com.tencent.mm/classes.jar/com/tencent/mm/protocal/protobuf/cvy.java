package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cvy
  extends cwj
{
  public String GeJ;
  public dn HGK;
  public int dmy;
  public String phe;
  public String tsf;
  public String uVs;
  public String yit;
  public String yiu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72582);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72582);
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
      if (this.tsf != null) {
        paramVarArgs.d(4, this.tsf);
      }
      if (this.GeJ != null) {
        paramVarArgs.d(5, this.GeJ);
      }
      if (this.yit != null) {
        paramVarArgs.d(6, this.yit);
      }
      if (this.yiu != null) {
        paramVarArgs.d(7, this.yiu);
      }
      if (this.uVs != null) {
        paramVarArgs.d(8, this.uVs);
      }
      if (this.HGK != null)
      {
        paramVarArgs.lJ(9, this.HGK.computeSize());
        this.HGK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72582);
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
      i = paramInt;
      if (this.tsf != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tsf);
      }
      paramInt = i;
      if (this.GeJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GeJ);
      }
      i = paramInt;
      if (this.yit != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.yit);
      }
      paramInt = i;
      if (this.yiu != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.yiu);
      }
      i = paramInt;
      if (this.uVs != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.uVs);
      }
      paramInt = i;
      if (this.HGK != null) {
        paramInt = i + f.a.a.a.lI(9, this.HGK.computeSize());
      }
      AppMethodBeat.o(72582);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72582);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvy localcvy = (cvy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72582);
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
            localcvy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72582);
          return 0;
        case 2: 
          localcvy.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72582);
          return 0;
        case 3: 
          localcvy.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 4: 
          localcvy.tsf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 5: 
          localcvy.GeJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 6: 
          localcvy.yit = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 7: 
          localcvy.yiu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 8: 
          localcvy.uVs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72582);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvy.HGK = ((dn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      AppMethodBeat.o(72582);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvy
 * JD-Core Version:    0.7.0.1
 */
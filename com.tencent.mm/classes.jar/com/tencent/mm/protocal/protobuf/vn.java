package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vn
  extends cwj
{
  public String GmH;
  public int GmI;
  public LinkedList<Integer> GmJ;
  public int GmM;
  public String desc;
  public int dmy;
  public String phe;
  public String ynq;
  
  public vn()
  {
    AppMethodBeat.i(72446);
    this.GmJ = new LinkedList();
    AppMethodBeat.o(72446);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72447);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72447);
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
      if (this.ynq != null) {
        paramVarArgs.d(4, this.ynq);
      }
      if (this.GmH != null) {
        paramVarArgs.d(5, this.GmH);
      }
      paramVarArgs.aS(6, this.GmI);
      paramVarArgs.e(7, 2, this.GmJ);
      if (this.desc != null) {
        paramVarArgs.d(8, this.desc);
      }
      paramVarArgs.aS(9, this.GmM);
      AppMethodBeat.o(72447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label797;
      }
    }
    label797:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.ynq != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ynq);
      }
      paramInt = i;
      if (this.GmH != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GmH);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GmI) + f.a.a.a.c(7, 2, this.GmJ);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.desc);
      }
      i = f.a.a.b.b.a.bz(9, this.GmM);
      AppMethodBeat.o(72447);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GmJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72447);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72447);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vn localvn = (vn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72447);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72447);
          return 0;
        case 2: 
          localvn.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72447);
          return 0;
        case 3: 
          localvn.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 4: 
          localvn.ynq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 5: 
          localvn.GmH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 6: 
          localvn.GmI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72447);
          return 0;
        case 7: 
          localvn.GmJ.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(72447);
          return 0;
        case 8: 
          localvn.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72447);
          return 0;
        }
        localvn.GmM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72447);
        return 0;
      }
      AppMethodBeat.o(72447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vn
 * JD-Core Version:    0.7.0.1
 */
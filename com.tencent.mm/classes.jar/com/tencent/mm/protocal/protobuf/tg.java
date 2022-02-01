package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class tg
  extends cld
{
  public String CUp;
  public int CUq;
  public LinkedList<Integer> CUr;
  public int CUu;
  public int dcG;
  public String desc;
  public String nTK;
  public String vzM;
  
  public tg()
  {
    AppMethodBeat.i(72446);
    this.CUr = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      if (this.vzM != null) {
        paramVarArgs.d(4, this.vzM);
      }
      if (this.CUp != null) {
        paramVarArgs.d(5, this.CUp);
      }
      paramVarArgs.aR(6, this.CUq);
      paramVarArgs.e(7, 2, this.CUr);
      if (this.desc != null) {
        paramVarArgs.d(8, this.desc);
      }
      paramVarArgs.aR(9, this.CUu);
      AppMethodBeat.o(72447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label797;
      }
    }
    label797:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.vzM != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vzM);
      }
      paramInt = i;
      if (this.CUp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CUp);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.CUq) + f.a.a.a.c(7, 2, this.CUr);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.desc);
      }
      i = f.a.a.b.b.a.bA(9, this.CUu);
      AppMethodBeat.o(72447);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CUr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        tg localtg = (tg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72447);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72447);
          return 0;
        case 2: 
          localtg.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72447);
          return 0;
        case 3: 
          localtg.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 4: 
          localtg.vzM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 5: 
          localtg.CUp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 6: 
          localtg.CUq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72447);
          return 0;
        case 7: 
          localtg.CUr.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(72447);
          return 0;
        case 8: 
          localtg.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72447);
          return 0;
        }
        localtg.CUu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(72447);
        return 0;
      }
      AppMethodBeat.o(72447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tg
 * JD-Core Version:    0.7.0.1
 */
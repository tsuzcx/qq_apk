package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sd
  extends cld
{
  public String CTJ;
  public String CTK;
  public String CTL;
  public String CTM;
  public int dcG;
  public String dre;
  public String nTK;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195465);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(195465);
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
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.dre != null) {
        paramVarArgs.d(5, this.dre);
      }
      if (this.CTJ != null) {
        paramVarArgs.d(6, this.CTJ);
      }
      if (this.CTK != null) {
        paramVarArgs.d(7, this.CTK);
      }
      if (this.CTL != null) {
        paramVarArgs.d(8, this.CTL);
      }
      if (this.CTM != null) {
        paramVarArgs.d(9, this.CTM);
      }
      AppMethodBeat.o(195465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.title);
      }
      paramInt = i;
      if (this.dre != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dre);
      }
      i = paramInt;
      if (this.CTJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CTJ);
      }
      paramInt = i;
      if (this.CTK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CTK);
      }
      i = paramInt;
      if (this.CTL != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CTL);
      }
      paramInt = i;
      if (this.CTM != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CTM);
      }
      AppMethodBeat.o(195465);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(195465);
          throw paramVarArgs;
        }
        AppMethodBeat.o(195465);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sd localsd = (sd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195465);
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
            localsd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195465);
          return 0;
        case 2: 
          localsd.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(195465);
          return 0;
        case 3: 
          localsd.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195465);
          return 0;
        case 4: 
          localsd.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195465);
          return 0;
        case 5: 
          localsd.dre = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195465);
          return 0;
        case 6: 
          localsd.CTJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195465);
          return 0;
        case 7: 
          localsd.CTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195465);
          return 0;
        case 8: 
          localsd.CTL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195465);
          return 0;
        }
        localsd.CTM = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(195465);
        return 0;
      }
      AppMethodBeat.o(195465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sd
 * JD-Core Version:    0.7.0.1
 */
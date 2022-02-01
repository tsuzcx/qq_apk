package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sb
  extends cld
{
  public String CTG;
  public LinkedList<aes> CTH;
  public int CTI;
  public int dcG;
  public String nTK;
  public String nTL;
  
  public sb()
  {
    AppMethodBeat.i(91401);
    this.CTH = new LinkedList();
    AppMethodBeat.o(91401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91402);
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
      if (this.CTG != null) {
        paramVarArgs.d(4, this.CTG);
      }
      if (this.nTL != null) {
        paramVarArgs.d(5, this.nTL);
      }
      paramVarArgs.e(6, 8, this.CTH);
      paramVarArgs.aR(7, this.CTI);
      AppMethodBeat.o(91402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label774;
      }
    }
    label774:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.CTG != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CTG);
      }
      paramInt = i;
      if (this.nTL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.nTL);
      }
      i = f.a.a.a.c(6, 8, this.CTH);
      int j = f.a.a.b.b.a.bA(7, this.CTI);
      AppMethodBeat.o(91402);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CTH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sb localsb = (sb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91402);
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
            localsb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        case 2: 
          localsb.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91402);
          return 0;
        case 3: 
          localsb.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 4: 
          localsb.CTG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 5: 
          localsb.nTL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aes();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aes)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsb.CTH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        }
        localsb.CTI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91402);
        return 0;
      }
      AppMethodBeat.o(91402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sb
 * JD-Core Version:    0.7.0.1
 */
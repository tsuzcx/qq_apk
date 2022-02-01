package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afb
  extends cld
{
  public int Dfe;
  public int dcG;
  public String nTK;
  public String oYa;
  public String sZn;
  public String taJ;
  public String taK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91455);
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
      if (this.sZn != null) {
        paramVarArgs.d(4, this.sZn);
      }
      if (this.oYa != null) {
        paramVarArgs.d(5, this.oYa);
      }
      paramVarArgs.aR(6, this.Dfe);
      if (this.taK != null) {
        paramVarArgs.d(7, this.taK);
      }
      if (this.taJ != null) {
        paramVarArgs.d(8, this.taJ);
      }
      AppMethodBeat.o(91455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.sZn != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sZn);
      }
      paramInt = i;
      if (this.oYa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.oYa);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.Dfe);
      paramInt = i;
      if (this.taK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.taK);
      }
      i = paramInt;
      if (this.taJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.taJ);
      }
      AppMethodBeat.o(91455);
      return i;
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
          AppMethodBeat.o(91455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afb localafb = (afb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91455);
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
            localafb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91455);
          return 0;
        case 2: 
          localafb.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91455);
          return 0;
        case 3: 
          localafb.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 4: 
          localafb.sZn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 5: 
          localafb.oYa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 6: 
          localafb.Dfe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91455);
          return 0;
        case 7: 
          localafb.taK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91455);
          return 0;
        }
        localafb.taJ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91455);
        return 0;
      }
      AppMethodBeat.o(91455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afb
 * JD-Core Version:    0.7.0.1
 */
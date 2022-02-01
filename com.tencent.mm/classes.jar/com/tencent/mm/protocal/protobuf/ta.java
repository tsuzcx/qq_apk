package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ta
  extends cld
{
  public String CUC;
  public String CUD;
  public String CUF;
  public String CUR;
  public String CxX;
  public int dcG;
  public String dlJ;
  public String nTK;
  public int tav;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72438);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72438);
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
      if (this.dlJ != null) {
        paramVarArgs.d(4, this.dlJ);
      }
      if (this.CUF != null) {
        paramVarArgs.d(5, this.CUF);
      }
      if (this.CxX != null) {
        paramVarArgs.d(6, this.CxX);
      }
      paramVarArgs.aR(7, this.tav);
      if (this.CUR != null) {
        paramVarArgs.d(8, this.CUR);
      }
      if (this.CUD != null) {
        paramVarArgs.d(9, this.CUD);
      }
      if (this.CUC != null) {
        paramVarArgs.d(10, this.CUC);
      }
      AppMethodBeat.o(72438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.dlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dlJ);
      }
      paramInt = i;
      if (this.CUF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CUF);
      }
      i = paramInt;
      if (this.CxX != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CxX);
      }
      i += f.a.a.b.b.a.bA(7, this.tav);
      paramInt = i;
      if (this.CUR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CUR);
      }
      i = paramInt;
      if (this.CUD != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CUD);
      }
      paramInt = i;
      if (this.CUC != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CUC);
      }
      AppMethodBeat.o(72438);
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
          AppMethodBeat.o(72438);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ta localta = (ta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72438);
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
            localta.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72438);
          return 0;
        case 2: 
          localta.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72438);
          return 0;
        case 3: 
          localta.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 4: 
          localta.dlJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 5: 
          localta.CUF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 6: 
          localta.CxX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 7: 
          localta.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72438);
          return 0;
        case 8: 
          localta.CUR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 9: 
          localta.CUD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72438);
          return 0;
        }
        localta.CUC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72438);
        return 0;
      }
      AppMethodBeat.o(72438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ta
 * JD-Core Version:    0.7.0.1
 */
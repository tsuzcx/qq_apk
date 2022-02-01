package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cie
  extends cld
{
  public int DXY;
  public boolean EdA;
  public boolean EdB;
  public String EdC;
  public String EdD;
  public String EdE;
  public int ntx;
  public String nty;
  public int status;
  public String szi;
  public String uoo;
  public String zFY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91666);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.bg(4, this.EdA);
      paramVarArgs.bg(5, this.EdB);
      paramVarArgs.aR(6, this.status);
      if (this.EdC != null) {
        paramVarArgs.d(7, this.EdC);
      }
      if (this.EdD != null) {
        paramVarArgs.d(8, this.EdD);
      }
      paramVarArgs.aR(9, this.DXY);
      if (this.szi != null) {
        paramVarArgs.d(10, this.szi);
      }
      if (this.uoo != null) {
        paramVarArgs.d(11, this.uoo);
      }
      if (this.EdE != null) {
        paramVarArgs.d(12, this.EdE);
      }
      if (this.zFY != null) {
        paramVarArgs.d(100, this.zFY);
      }
      AppMethodBeat.o(91666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1054;
      }
    }
    label1054:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + (f.a.a.b.b.a.fY(4) + 1) + (f.a.a.b.b.a.fY(5) + 1) + f.a.a.b.b.a.bA(6, this.status);
      paramInt = i;
      if (this.EdC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EdC);
      }
      i = paramInt;
      if (this.EdD != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EdD);
      }
      i += f.a.a.b.b.a.bA(9, this.DXY);
      paramInt = i;
      if (this.szi != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.szi);
      }
      i = paramInt;
      if (this.uoo != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.uoo);
      }
      paramInt = i;
      if (this.EdE != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EdE);
      }
      i = paramInt;
      if (this.zFY != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.zFY);
      }
      AppMethodBeat.o(91666);
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
          AppMethodBeat.o(91666);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cie localcie = (cie)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91666);
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
            localcie.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91666);
          return 0;
        case 2: 
          localcie.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91666);
          return 0;
        case 3: 
          localcie.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 4: 
          localcie.EdA = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91666);
          return 0;
        case 5: 
          localcie.EdB = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91666);
          return 0;
        case 6: 
          localcie.status = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91666);
          return 0;
        case 7: 
          localcie.EdC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 8: 
          localcie.EdD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 9: 
          localcie.DXY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91666);
          return 0;
        case 10: 
          localcie.szi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 11: 
          localcie.uoo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 12: 
          localcie.EdE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91666);
          return 0;
        }
        localcie.zFY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91666);
        return 0;
      }
      AppMethodBeat.o(91666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cie
 * JD-Core Version:    0.7.0.1
 */
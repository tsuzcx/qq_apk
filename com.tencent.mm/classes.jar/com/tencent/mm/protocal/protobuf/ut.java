package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ut
  extends cld
{
  public long CWA;
  public String CWB;
  public String CWC;
  public long CWz;
  public int ntx;
  public String nty;
  public String odo;
  public String sYt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72458);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72458);
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
      paramVarArgs.aG(4, this.CWz);
      paramVarArgs.aG(5, this.CWA);
      if (this.CWB != null) {
        paramVarArgs.d(6, this.CWB);
      }
      if (this.CWC != null) {
        paramVarArgs.d(7, this.CWC);
      }
      if (this.sYt != null) {
        paramVarArgs.d(8, this.sYt);
      }
      if (this.odo != null) {
        paramVarArgs.d(9, this.odo);
      }
      AppMethodBeat.o(72458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.q(4, this.CWz) + f.a.a.b.b.a.q(5, this.CWA);
      paramInt = i;
      if (this.CWB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CWB);
      }
      i = paramInt;
      if (this.CWC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CWC);
      }
      paramInt = i;
      if (this.sYt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.sYt);
      }
      i = paramInt;
      if (this.odo != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.odo);
      }
      AppMethodBeat.o(72458);
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
          AppMethodBeat.o(72458);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ut localut = (ut)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72458);
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
            localut.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72458);
          return 0;
        case 2: 
          localut.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72458);
          return 0;
        case 3: 
          localut.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 4: 
          localut.CWz = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(72458);
          return 0;
        case 5: 
          localut.CWA = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(72458);
          return 0;
        case 6: 
          localut.CWB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 7: 
          localut.CWC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 8: 
          localut.sYt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72458);
          return 0;
        }
        localut.odo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72458);
        return 0;
      }
      AppMethodBeat.o(72458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ut
 * JD-Core Version:    0.7.0.1
 */
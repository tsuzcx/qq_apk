package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dti
  extends cvp
{
  public String FOH;
  public int FOM;
  public String Fvn;
  public String Fwt;
  public int GSg;
  public int HFW;
  public int xbr;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127181);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127181);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Fwt != null) {
        paramVarArgs.d(2, this.Fwt);
      }
      paramVarArgs.aS(3, this.xbr);
      paramVarArgs.aS(4, this.GSg);
      paramVarArgs.aS(5, this.HFW);
      paramVarArgs.aY(6, this.xbt);
      if (this.FOH != null) {
        paramVarArgs.d(7, this.FOH);
      }
      if (this.Fvn != null) {
        paramVarArgs.d(8, this.Fvn);
      }
      paramVarArgs.aS(9, this.FOM);
      AppMethodBeat.o(127181);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fwt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fwt);
      }
      i = i + f.a.a.b.b.a.bz(3, this.xbr) + f.a.a.b.b.a.bz(4, this.GSg) + f.a.a.b.b.a.bz(5, this.HFW) + f.a.a.b.b.a.p(6, this.xbt);
      paramInt = i;
      if (this.FOH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FOH);
      }
      i = paramInt;
      if (this.Fvn != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Fvn);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.FOM);
      AppMethodBeat.o(127181);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(127181);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127181);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dti localdti = (dti)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127181);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdti.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127181);
          return 0;
        case 2: 
          localdti.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 3: 
          localdti.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127181);
          return 0;
        case 4: 
          localdti.GSg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127181);
          return 0;
        case 5: 
          localdti.HFW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127181);
          return 0;
        case 6: 
          localdti.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(127181);
          return 0;
        case 7: 
          localdti.FOH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 8: 
          localdti.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127181);
          return 0;
        }
        localdti.FOM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127181);
        return 0;
      }
      AppMethodBeat.o(127181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dti
 * JD-Core Version:    0.7.0.1
 */
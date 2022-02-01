package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class chd
  extends cwj
{
  public int HsW;
  public int HsX;
  public String HsY;
  public String HsZ;
  public int Hta;
  public int Htb;
  public int dmy;
  public String iWA;
  public String iWB;
  public String phe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72539);
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
      paramVarArgs.aS(4, this.HsW);
      paramVarArgs.aS(5, this.HsX);
      if (this.iWA != null) {
        paramVarArgs.d(6, this.iWA);
      }
      if (this.iWB != null) {
        paramVarArgs.d(7, this.iWB);
      }
      if (this.HsY != null) {
        paramVarArgs.d(8, this.HsY);
      }
      if (this.HsZ != null) {
        paramVarArgs.d(9, this.HsZ);
      }
      paramVarArgs.aS(10, this.Hta);
      paramVarArgs.aS(11, this.Htb);
      AppMethodBeat.o(72539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HsW) + f.a.a.b.b.a.bz(5, this.HsX);
      paramInt = i;
      if (this.iWA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iWA);
      }
      i = paramInt;
      if (this.iWB != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iWB);
      }
      paramInt = i;
      if (this.HsY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HsY);
      }
      i = paramInt;
      if (this.HsZ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HsZ);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.Hta);
      int j = f.a.a.b.b.a.bz(11, this.Htb);
      AppMethodBeat.o(72539);
      return i + paramInt + j;
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
          AppMethodBeat.o(72539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chd localchd = (chd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72539);
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
            localchd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72539);
          return 0;
        case 2: 
          localchd.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72539);
          return 0;
        case 3: 
          localchd.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 4: 
          localchd.HsW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72539);
          return 0;
        case 5: 
          localchd.HsX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72539);
          return 0;
        case 6: 
          localchd.iWA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 7: 
          localchd.iWB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 8: 
          localchd.HsY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 9: 
          localchd.HsZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 10: 
          localchd.Hta = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72539);
          return 0;
        }
        localchd.Htb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72539);
        return 0;
      }
      AppMethodBeat.o(72539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chd
 * JD-Core Version:    0.7.0.1
 */
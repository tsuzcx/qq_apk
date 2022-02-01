package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajm
  extends cvw
{
  public String FXO;
  public long GyV;
  public String GyW;
  public String GyX;
  public int GyY;
  public float GyZ;
  public int Gza;
  public int doj;
  public String dwb;
  public int roq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104363);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      paramVarArgs.aZ(3, this.GyV);
      if (this.FXO != null) {
        paramVarArgs.d(4, this.FXO);
      }
      if (this.GyW != null) {
        paramVarArgs.d(5, this.GyW);
      }
      if (this.GyX != null) {
        paramVarArgs.d(6, this.GyX);
      }
      paramVarArgs.aS(7, this.doj);
      paramVarArgs.aS(8, this.GyY);
      paramVarArgs.aS(9, this.roq);
      paramVarArgs.y(10, this.GyZ);
      paramVarArgs.aS(11, this.Gza);
      AppMethodBeat.o(104363);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label833;
      }
    }
    label833:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dwb);
      }
      i += f.a.a.b.b.a.p(3, this.GyV);
      paramInt = i;
      if (this.FXO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FXO);
      }
      i = paramInt;
      if (this.GyW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GyW);
      }
      paramInt = i;
      if (this.GyX != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GyX);
      }
      i = f.a.a.b.b.a.bz(7, this.doj);
      int j = f.a.a.b.b.a.bz(8, this.GyY);
      int k = f.a.a.b.b.a.bz(9, this.roq);
      int m = f.a.a.b.b.a.amE(10);
      int n = f.a.a.b.b.a.bz(11, this.Gza);
      AppMethodBeat.o(104363);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104363);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajm localajm = (ajm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104363);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104363);
          return 0;
        case 2: 
          localajm.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 3: 
          localajm.GyV = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(104363);
          return 0;
        case 4: 
          localajm.FXO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 5: 
          localajm.GyW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 6: 
          localajm.GyX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 7: 
          localajm.doj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104363);
          return 0;
        case 8: 
          localajm.GyY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104363);
          return 0;
        case 9: 
          localajm.roq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104363);
          return 0;
        case 10: 
          localajm.GyZ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(104363);
          return 0;
        }
        localajm.Gza = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104363);
        return 0;
      }
      AppMethodBeat.o(104363);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cen
  extends cvc
{
  public String CPf;
  public String FDo;
  public String FDp;
  public boolean GYt;
  public String GYu;
  public String GYv;
  public int GYw;
  public String GYx;
  public int dBY;
  public int dHZ;
  public String dkR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FDo != null) {
        paramVarArgs.d(2, this.FDo);
      }
      if (this.FDp != null) {
        paramVarArgs.d(3, this.FDp);
      }
      if (this.GYu != null) {
        paramVarArgs.d(4, this.GYu);
      }
      if (this.GYv != null) {
        paramVarArgs.d(5, this.GYv);
      }
      if (this.CPf != null) {
        paramVarArgs.d(6, this.CPf);
      }
      if (this.dkR != null) {
        paramVarArgs.d(7, this.dkR);
      }
      paramVarArgs.aS(8, this.dBY);
      paramVarArgs.aS(9, this.GYw);
      paramVarArgs.bt(10, this.GYt);
      paramVarArgs.aS(11, this.dHZ);
      if (this.GYx != null) {
        paramVarArgs.d(12, this.GYx);
      }
      AppMethodBeat.o(72530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label910;
      }
    }
    label910:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FDo);
      }
      i = paramInt;
      if (this.FDp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FDp);
      }
      paramInt = i;
      if (this.GYu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GYu);
      }
      i = paramInt;
      if (this.GYv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GYv);
      }
      paramInt = i;
      if (this.CPf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CPf);
      }
      i = paramInt;
      if (this.dkR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dkR);
      }
      i = i + f.a.a.b.b.a.bz(8, this.dBY) + f.a.a.b.b.a.bz(9, this.GYw) + f.a.a.b.b.a.alV(10) + f.a.a.b.b.a.bz(11, this.dHZ);
      paramInt = i;
      if (this.GYx != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GYx);
      }
      AppMethodBeat.o(72530);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72530);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cen localcen = (cen)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72530);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcen.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72530);
          return 0;
        case 2: 
          localcen.FDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 3: 
          localcen.FDp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 4: 
          localcen.GYu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 5: 
          localcen.GYv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 6: 
          localcen.CPf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 7: 
          localcen.dkR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 8: 
          localcen.dBY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72530);
          return 0;
        case 9: 
          localcen.GYw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72530);
          return 0;
        case 10: 
          localcen.GYt = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(72530);
          return 0;
        case 11: 
          localcen.dHZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72530);
          return 0;
        }
        localcen.GYx = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72530);
        return 0;
      }
      AppMethodBeat.o(72530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cen
 * JD-Core Version:    0.7.0.1
 */
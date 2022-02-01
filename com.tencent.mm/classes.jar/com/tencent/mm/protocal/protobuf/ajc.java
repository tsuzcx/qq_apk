package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajc
  extends cvc
{
  public String FFt;
  public long Ggm;
  public String Ggn;
  public String Ggo;
  public int Ggp;
  public float Ggq;
  public int Ggr;
  public int dnh;
  public String duW;
  public int rgn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104363);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      paramVarArgs.aY(3, this.Ggm);
      if (this.FFt != null) {
        paramVarArgs.d(4, this.FFt);
      }
      if (this.Ggn != null) {
        paramVarArgs.d(5, this.Ggn);
      }
      if (this.Ggo != null) {
        paramVarArgs.d(6, this.Ggo);
      }
      paramVarArgs.aS(7, this.dnh);
      paramVarArgs.aS(8, this.Ggp);
      paramVarArgs.aS(9, this.rgn);
      paramVarArgs.z(10, this.Ggq);
      paramVarArgs.aS(11, this.Ggr);
      AppMethodBeat.o(104363);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label833;
      }
    }
    label833:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.duW);
      }
      i += f.a.a.b.b.a.p(3, this.Ggm);
      paramInt = i;
      if (this.FFt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FFt);
      }
      i = paramInt;
      if (this.Ggn != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ggn);
      }
      paramInt = i;
      if (this.Ggo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ggo);
      }
      i = f.a.a.b.b.a.bz(7, this.dnh);
      int j = f.a.a.b.b.a.bz(8, this.Ggp);
      int k = f.a.a.b.b.a.bz(9, this.rgn);
      int m = f.a.a.b.b.a.alU(10);
      int n = f.a.a.b.b.a.bz(11, this.Ggr);
      AppMethodBeat.o(104363);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104363);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajc localajc = (ajc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104363);
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
            localajc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104363);
          return 0;
        case 2: 
          localajc.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 3: 
          localajc.Ggm = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(104363);
          return 0;
        case 4: 
          localajc.FFt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 5: 
          localajc.Ggn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 6: 
          localajc.Ggo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 7: 
          localajc.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104363);
          return 0;
        case 8: 
          localajc.Ggp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104363);
          return 0;
        case 9: 
          localajc.rgn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104363);
          return 0;
        case 10: 
          localajc.Ggq = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(104363);
          return 0;
        }
        localajc.Ggr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104363);
        return 0;
      }
      AppMethodBeat.o(104363);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajc
 * JD-Core Version:    0.7.0.1
 */
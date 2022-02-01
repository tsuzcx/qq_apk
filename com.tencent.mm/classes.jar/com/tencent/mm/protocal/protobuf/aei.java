package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aei
  extends cvc
{
  public int FtC;
  public String Gcm;
  public int Gcn;
  public int Gco;
  public int dnh;
  public String duW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147761);
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
      if (this.Gcm != null) {
        paramVarArgs.d(3, this.Gcm);
      }
      paramVarArgs.aS(4, this.Gcn);
      paramVarArgs.aS(5, this.dnh);
      paramVarArgs.aS(6, this.Gco);
      paramVarArgs.aS(7, this.FtC);
      AppMethodBeat.o(147761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.duW);
      }
      i = paramInt;
      if (this.Gcm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gcm);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Gcn);
      int j = f.a.a.b.b.a.bz(5, this.dnh);
      int k = f.a.a.b.b.a.bz(6, this.Gco);
      int m = f.a.a.b.b.a.bz(7, this.FtC);
      AppMethodBeat.o(147761);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147761);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aei localaei = (aei)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147761);
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
            localaei.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147761);
          return 0;
        case 2: 
          localaei.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147761);
          return 0;
        case 3: 
          localaei.Gcm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147761);
          return 0;
        case 4: 
          localaei.Gcn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(147761);
          return 0;
        case 5: 
          localaei.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(147761);
          return 0;
        case 6: 
          localaei.Gco = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(147761);
          return 0;
        }
        localaei.FtC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(147761);
        return 0;
      }
      AppMethodBeat.o(147761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aei
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cno
  extends cvc
{
  public long FHC;
  public String HcP;
  public int HgJ;
  public long HgK;
  public int HgL;
  public long HgM;
  public long appid;
  public int dkM;
  public int platform;
  public int scene;
  public long xdB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HgJ);
      paramVarArgs.aY(3, this.HgK);
      paramVarArgs.aY(4, this.appid);
      paramVarArgs.aY(5, this.FHC);
      paramVarArgs.aS(6, this.HgL);
      paramVarArgs.aS(7, this.scene);
      paramVarArgs.aS(8, this.dkM);
      paramVarArgs.aY(9, this.xdB);
      paramVarArgs.aY(10, this.HgM);
      paramVarArgs.aS(11, this.platform);
      if (this.HcP != null) {
        paramVarArgs.d(12, this.HcP);
      }
      AppMethodBeat.o(124539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HgJ) + f.a.a.b.b.a.p(3, this.HgK) + f.a.a.b.b.a.p(4, this.appid) + f.a.a.b.b.a.p(5, this.FHC) + f.a.a.b.b.a.bz(6, this.HgL) + f.a.a.b.b.a.bz(7, this.scene) + f.a.a.b.b.a.bz(8, this.dkM) + f.a.a.b.b.a.p(9, this.xdB) + f.a.a.b.b.a.p(10, this.HgM) + f.a.a.b.b.a.bz(11, this.platform);
      paramInt = i;
      if (this.HcP != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HcP);
      }
      AppMethodBeat.o(124539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cno localcno = (cno)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124539);
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
            localcno.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124539);
          return 0;
        case 2: 
          localcno.HgJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124539);
          return 0;
        case 3: 
          localcno.HgK = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124539);
          return 0;
        case 4: 
          localcno.appid = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124539);
          return 0;
        case 5: 
          localcno.FHC = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124539);
          return 0;
        case 6: 
          localcno.HgL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124539);
          return 0;
        case 7: 
          localcno.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124539);
          return 0;
        case 8: 
          localcno.dkM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124539);
          return 0;
        case 9: 
          localcno.xdB = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124539);
          return 0;
        case 10: 
          localcno.HgM = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124539);
          return 0;
        case 11: 
          localcno.platform = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124539);
          return 0;
        }
        localcno.HcP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124539);
        return 0;
      }
      AppMethodBeat.o(124539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cno
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdl
  extends ckq
{
  public long CJo;
  public String DVU;
  public int DZI;
  public long DZJ;
  public int DZK;
  public long DZL;
  public long DZM;
  public long appid;
  public int dbV;
  public int platform;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DZI);
      paramVarArgs.aG(3, this.DZJ);
      paramVarArgs.aG(4, this.appid);
      paramVarArgs.aG(5, this.CJo);
      paramVarArgs.aR(6, this.DZK);
      paramVarArgs.aR(7, this.scene);
      paramVarArgs.aR(8, this.dbV);
      paramVarArgs.aG(9, this.DZL);
      paramVarArgs.aG(10, this.DZM);
      paramVarArgs.aR(11, this.platform);
      if (this.DVU != null) {
        paramVarArgs.d(12, this.DVU);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DZI) + f.a.a.b.b.a.q(3, this.DZJ) + f.a.a.b.b.a.q(4, this.appid) + f.a.a.b.b.a.q(5, this.CJo) + f.a.a.b.b.a.bA(6, this.DZK) + f.a.a.b.b.a.bA(7, this.scene) + f.a.a.b.b.a.bA(8, this.dbV) + f.a.a.b.b.a.q(9, this.DZL) + f.a.a.b.b.a.q(10, this.DZM) + f.a.a.b.b.a.bA(11, this.platform);
      paramInt = i;
      if (this.DVU != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DVU);
      }
      AppMethodBeat.o(124539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdl localcdl = (cdl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124539);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124539);
          return 0;
        case 2: 
          localcdl.DZI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124539);
          return 0;
        case 3: 
          localcdl.DZJ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124539);
          return 0;
        case 4: 
          localcdl.appid = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124539);
          return 0;
        case 5: 
          localcdl.CJo = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124539);
          return 0;
        case 6: 
          localcdl.DZK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124539);
          return 0;
        case 7: 
          localcdl.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124539);
          return 0;
        case 8: 
          localcdl.dbV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124539);
          return 0;
        case 9: 
          localcdl.DZL = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124539);
          return 0;
        case 10: 
          localcdl.DZM = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124539);
          return 0;
        case 11: 
          localcdl.platform = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124539);
          return 0;
        }
        localcdl.DVU = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(124539);
        return 0;
      }
      AppMethodBeat.o(124539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdl
 * JD-Core Version:    0.7.0.1
 */
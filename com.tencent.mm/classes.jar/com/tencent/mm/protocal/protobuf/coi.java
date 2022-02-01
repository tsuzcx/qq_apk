package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coi
  extends cvw
{
  public long FZY;
  public int HAj;
  public long HAk;
  public int HAl;
  public long HAm;
  public String Hwp;
  public long appid;
  public int dlO;
  public int platform;
  public int scene;
  public long xts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HAj);
      paramVarArgs.aZ(3, this.HAk);
      paramVarArgs.aZ(4, this.appid);
      paramVarArgs.aZ(5, this.FZY);
      paramVarArgs.aS(6, this.HAl);
      paramVarArgs.aS(7, this.scene);
      paramVarArgs.aS(8, this.dlO);
      paramVarArgs.aZ(9, this.xts);
      paramVarArgs.aZ(10, this.HAm);
      paramVarArgs.aS(11, this.platform);
      if (this.Hwp != null) {
        paramVarArgs.d(12, this.Hwp);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HAj) + f.a.a.b.b.a.p(3, this.HAk) + f.a.a.b.b.a.p(4, this.appid) + f.a.a.b.b.a.p(5, this.FZY) + f.a.a.b.b.a.bz(6, this.HAl) + f.a.a.b.b.a.bz(7, this.scene) + f.a.a.b.b.a.bz(8, this.dlO) + f.a.a.b.b.a.p(9, this.xts) + f.a.a.b.b.a.p(10, this.HAm) + f.a.a.b.b.a.bz(11, this.platform);
      paramInt = i;
      if (this.Hwp != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Hwp);
      }
      AppMethodBeat.o(124539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coi localcoi = (coi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124539);
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
            localcoi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124539);
          return 0;
        case 2: 
          localcoi.HAj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124539);
          return 0;
        case 3: 
          localcoi.HAk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124539);
          return 0;
        case 4: 
          localcoi.appid = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124539);
          return 0;
        case 5: 
          localcoi.FZY = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124539);
          return 0;
        case 6: 
          localcoi.HAl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124539);
          return 0;
        case 7: 
          localcoi.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124539);
          return 0;
        case 8: 
          localcoi.dlO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124539);
          return 0;
        case 9: 
          localcoi.xts = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124539);
          return 0;
        case 10: 
          localcoi.HAm = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124539);
          return 0;
        case 11: 
          localcoi.platform = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124539);
          return 0;
        }
        localcoi.Hwp = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124539);
        return 0;
      }
      AppMethodBeat.o(124539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coi
 * JD-Core Version:    0.7.0.1
 */
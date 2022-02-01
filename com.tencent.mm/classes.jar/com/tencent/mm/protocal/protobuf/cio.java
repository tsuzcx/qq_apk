package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cio
  extends cpx
{
  public long EbQ;
  public String FsI;
  public int FwD;
  public long FwE;
  public int FwF;
  public long FwG;
  public long FwH;
  public long appid;
  public int cZu;
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
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FwD);
      paramVarArgs.aO(3, this.FwE);
      paramVarArgs.aO(4, this.appid);
      paramVarArgs.aO(5, this.EbQ);
      paramVarArgs.aR(6, this.FwF);
      paramVarArgs.aR(7, this.scene);
      paramVarArgs.aR(8, this.cZu);
      paramVarArgs.aO(9, this.FwG);
      paramVarArgs.aO(10, this.FwH);
      paramVarArgs.aR(11, this.platform);
      if (this.FsI != null) {
        paramVarArgs.d(12, this.FsI);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FwD) + f.a.a.b.b.a.p(3, this.FwE) + f.a.a.b.b.a.p(4, this.appid) + f.a.a.b.b.a.p(5, this.EbQ) + f.a.a.b.b.a.bx(6, this.FwF) + f.a.a.b.b.a.bx(7, this.scene) + f.a.a.b.b.a.bx(8, this.cZu) + f.a.a.b.b.a.p(9, this.FwG) + f.a.a.b.b.a.p(10, this.FwH) + f.a.a.b.b.a.bx(11, this.platform);
      paramInt = i;
      if (this.FsI != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FsI);
      }
      AppMethodBeat.o(124539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cio localcio = (cio)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124539);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcio.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124539);
          return 0;
        case 2: 
          localcio.FwD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124539);
          return 0;
        case 3: 
          localcio.FwE = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124539);
          return 0;
        case 4: 
          localcio.appid = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124539);
          return 0;
        case 5: 
          localcio.EbQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124539);
          return 0;
        case 6: 
          localcio.FwF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124539);
          return 0;
        case 7: 
          localcio.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124539);
          return 0;
        case 8: 
          localcio.cZu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124539);
          return 0;
        case 9: 
          localcio.FwG = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124539);
          return 0;
        case 10: 
          localcio.FwH = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124539);
          return 0;
        case 11: 
          localcio.platform = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124539);
          return 0;
        }
        localcio.FsI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124539);
        return 0;
      }
      AppMethodBeat.o(124539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cio
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sk
  extends cpx
{
  public String Emq;
  public String nYC;
  public String nickname;
  public int uiK;
  public String wKR;
  public String wLc;
  public String wLd;
  public String wLu;
  public String wLx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91400);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.uiK);
      if (this.nYC != null) {
        paramVarArgs.d(3, this.nYC);
      }
      if (this.wLu != null) {
        paramVarArgs.d(4, this.wLu);
      }
      if (this.Emq != null) {
        paramVarArgs.d(5, this.Emq);
      }
      if (this.wLc != null) {
        paramVarArgs.d(6, this.wLc);
      }
      if (this.wLd != null) {
        paramVarArgs.d(7, this.wLd);
      }
      if (this.wLx != null) {
        paramVarArgs.d(8, this.wLx);
      }
      if (this.nickname != null) {
        paramVarArgs.d(9, this.nickname);
      }
      if (this.wKR != null) {
        paramVarArgs.d(10, this.wKR);
      }
      AppMethodBeat.o(91400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.uiK);
      paramInt = i;
      if (this.nYC != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nYC);
      }
      i = paramInt;
      if (this.wLu != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.wLu);
      }
      paramInt = i;
      if (this.Emq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Emq);
      }
      i = paramInt;
      if (this.wLc != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.wLc);
      }
      paramInt = i;
      if (this.wLd != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wLd);
      }
      i = paramInt;
      if (this.wLx != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.wLx);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nickname);
      }
      i = paramInt;
      if (this.wKR != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.wKR);
      }
      AppMethodBeat.o(91400);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91400);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sk localsk = (sk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91400);
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
            localsk.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91400);
          return 0;
        case 2: 
          localsk.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91400);
          return 0;
        case 3: 
          localsk.nYC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 4: 
          localsk.wLu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 5: 
          localsk.Emq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 6: 
          localsk.wLc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 7: 
          localsk.wLd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 8: 
          localsk.wLx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 9: 
          localsk.nickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91400);
          return 0;
        }
        localsk.wKR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91400);
        return 0;
      }
      AppMethodBeat.o(91400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sk
 * JD-Core Version:    0.7.0.1
 */
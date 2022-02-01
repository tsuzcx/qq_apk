package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ctz
  extends cpx
{
  public int DTc;
  public int EhC;
  public int EhD;
  public String EhE;
  public int EwP;
  public em FFG;
  public String FFH;
  public String FFI;
  public int FFJ;
  public int FFK;
  public String Md5;
  public String iJW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FFG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Msg");
        AppMethodBeat.o(32426);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FFG != null)
      {
        paramVarArgs.ln(2, this.FFG.computeSize());
        this.FFG.writeFields(paramVarArgs);
      }
      if (this.FFH != null) {
        paramVarArgs.d(3, this.FFH);
      }
      paramVarArgs.aR(4, this.EwP);
      if (this.Md5 != null) {
        paramVarArgs.d(5, this.Md5);
      }
      paramVarArgs.aR(6, this.DTc);
      if (this.iJW != null) {
        paramVarArgs.d(7, this.iJW);
      }
      if (this.FFI != null) {
        paramVarArgs.d(8, this.FFI);
      }
      paramVarArgs.aR(9, this.FFJ);
      paramVarArgs.aR(10, this.EhC);
      paramVarArgs.aR(11, this.EhD);
      paramVarArgs.aR(12, this.FFK);
      if (this.EhE != null) {
        paramVarArgs.d(13, this.EhE);
      }
      AppMethodBeat.o(32426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1109;
      }
    }
    label1109:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FFG != null) {
        paramInt = i + f.a.a.a.lm(2, this.FFG.computeSize());
      }
      i = paramInt;
      if (this.FFH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FFH);
      }
      i += f.a.a.b.b.a.bx(4, this.EwP);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Md5);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.DTc);
      paramInt = i;
      if (this.iJW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.iJW);
      }
      i = paramInt;
      if (this.FFI != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FFI);
      }
      i = i + f.a.a.b.b.a.bx(9, this.FFJ) + f.a.a.b.b.a.bx(10, this.EhC) + f.a.a.b.b.a.bx(11, this.EhD) + f.a.a.b.b.a.bx(12, this.FFK);
      paramInt = i;
      if (this.EhE != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.EhE);
      }
      AppMethodBeat.o(32426);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FFG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Msg");
          AppMethodBeat.o(32426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctz localctz = (ctz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32426);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctz.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new em();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((em)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctz.FFG = ((em)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 3: 
          localctz.FFH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 4: 
          localctz.EwP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32426);
          return 0;
        case 5: 
          localctz.Md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 6: 
          localctz.DTc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32426);
          return 0;
        case 7: 
          localctz.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 8: 
          localctz.FFI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 9: 
          localctz.FFJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32426);
          return 0;
        case 10: 
          localctz.EhC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32426);
          return 0;
        case 11: 
          localctz.EhD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32426);
          return 0;
        case 12: 
          localctz.FFK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32426);
          return 0;
        }
        localctz.EhE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32426);
        return 0;
      }
      AppMethodBeat.o(32426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctz
 * JD-Core Version:    0.7.0.1
 */
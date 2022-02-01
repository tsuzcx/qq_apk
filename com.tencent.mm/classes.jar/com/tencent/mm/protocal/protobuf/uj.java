package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uj
  extends cpx
{
  public int DTc;
  public long DUE;
  public String DUF;
  public String EhA;
  public String Eot;
  public String Eou;
  public String tlJ;
  public String tlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32157);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.tlK != null) {
        paramVarArgs.d(2, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(3, this.tlJ);
      }
      paramVarArgs.aO(4, this.DUE);
      if (this.EhA != null) {
        paramVarArgs.d(5, this.EhA);
      }
      if (this.Eot != null) {
        paramVarArgs.d(6, this.Eot);
      }
      paramVarArgs.aR(7, this.DTc);
      if (this.DUF != null) {
        paramVarArgs.d(8, this.DUF);
      }
      if (this.Eou != null) {
        paramVarArgs.d(9, this.Eou);
      }
      AppMethodBeat.o(32157);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label781;
      }
    }
    label781:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tlK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tlK);
      }
      i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlJ);
      }
      i += f.a.a.b.b.a.p(4, this.DUE);
      paramInt = i;
      if (this.EhA != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EhA);
      }
      i = paramInt;
      if (this.Eot != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Eot);
      }
      i += f.a.a.b.b.a.bx(7, this.DTc);
      paramInt = i;
      if (this.DUF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DUF);
      }
      i = paramInt;
      if (this.Eou != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Eou);
      }
      AppMethodBeat.o(32157);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32157);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uj localuj = (uj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32157);
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
            localuj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32157);
          return 0;
        case 2: 
          localuj.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32157);
          return 0;
        case 3: 
          localuj.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32157);
          return 0;
        case 4: 
          localuj.DUE = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32157);
          return 0;
        case 5: 
          localuj.EhA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32157);
          return 0;
        case 6: 
          localuj.Eot = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32157);
          return 0;
        case 7: 
          localuj.DTc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32157);
          return 0;
        case 8: 
          localuj.DUF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32157);
          return 0;
        }
        localuj.Eou = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32157);
        return 0;
      }
      AppMethodBeat.o(32157);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uj
 * JD-Core Version:    0.7.0.1
 */
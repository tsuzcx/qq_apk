package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vo
  extends dop
{
  public String CpJ;
  public String CpM;
  public String Cpg;
  public String Cpr;
  public String Cps;
  public String LgC;
  public String nickname;
  public String pWm;
  public int yRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91400);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.yRL);
      if (this.pWm != null) {
        paramVarArgs.e(3, this.pWm);
      }
      if (this.CpJ != null) {
        paramVarArgs.e(4, this.CpJ);
      }
      if (this.LgC != null) {
        paramVarArgs.e(5, this.LgC);
      }
      if (this.Cpr != null) {
        paramVarArgs.e(6, this.Cpr);
      }
      if (this.Cps != null) {
        paramVarArgs.e(7, this.Cps);
      }
      if (this.CpM != null) {
        paramVarArgs.e(8, this.CpM);
      }
      if (this.nickname != null) {
        paramVarArgs.e(9, this.nickname);
      }
      if (this.Cpg != null) {
        paramVarArgs.e(10, this.Cpg);
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
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.yRL);
      paramInt = i;
      if (this.pWm != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pWm);
      }
      i = paramInt;
      if (this.CpJ != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.CpJ);
      }
      paramInt = i;
      if (this.LgC != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LgC);
      }
      i = paramInt;
      if (this.Cpr != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Cpr);
      }
      paramInt = i;
      if (this.Cps != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Cps);
      }
      i = paramInt;
      if (this.CpM != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.CpM);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.nickname);
      }
      i = paramInt;
      if (this.Cpg != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Cpg);
      }
      AppMethodBeat.o(91400);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91400);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        vo localvo = (vo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91400);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localvo.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91400);
          return 0;
        case 2: 
          localvo.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91400);
          return 0;
        case 3: 
          localvo.pWm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 4: 
          localvo.CpJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 5: 
          localvo.LgC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 6: 
          localvo.Cpr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 7: 
          localvo.Cps = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 8: 
          localvo.CpM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 9: 
          localvo.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91400);
          return 0;
        }
        localvo.Cpg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91400);
        return 0;
      }
      AppMethodBeat.o(91400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vo
 * JD-Core Version:    0.7.0.1
 */